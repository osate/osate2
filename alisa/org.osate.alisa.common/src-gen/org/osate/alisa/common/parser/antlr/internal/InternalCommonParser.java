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
public class InternalCommonParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'description'", "'this'", "'target'", "'exception'", "'diagnosticId'", "'['", "']'", "'boolean'", "'integer'", "'unit'", "'real'", "'string'", "'model'", "'element'", "'#'", "'.'", "'%'", "'in'", "'img'", "'/'", "'or'", "'||'", "'and'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'><'", "'+'", "'-'", "'*'", "'div'", "'mod'", "'not'", "'('", "','", "')'", "'..'", "'delta'", "'if'", "'then'", "'else'", "'endif'", "'true'", "'false'", "'::'", "'tbd'", "'error'", "'warning'", "'info'", "'success'", "'fail'"
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
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
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
    public String getGrammarFileName() { return "../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g"; }



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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:80:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:81:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:82:2: iv_ruleDescription= ruleDescription EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionRule()); 
            }
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription75);
            iv_ruleDescription=ruleDescription();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescription; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription85); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:89:1: ruleDescription returns [EObject current=null] : (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:92:28: ( (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:93:1: (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:93:1: (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:93:3: otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleDescription122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getDescriptionKeyword_0());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:97:1: ( (lv_description_1_0= ruleDescriptionElement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==18||LA1_0==35) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:98:1: (lv_description_1_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:98:1: (lv_description_1_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:99:3: lv_description_1_0= ruleDescriptionElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription143);
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
            	              		"DescriptionElement");
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:123:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:124:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:125:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            }
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement180);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement190); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:132:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_2_0=null;
        EObject lv_showValue_1_0 = null;

        EObject lv_image_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:135:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:136:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:136:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_showValue_1_0= ruleShowValue ) ) | ( (lv_thisTarget_2_0= 'this' ) ) | ( (lv_image_3_0= ruleImageReference ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            case 35:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:136:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:136:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:137:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:137:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:138:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement232); if (state.failed) return current;
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
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:155:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:155:6: ( (lv_showValue_1_0= ruleShowValue ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:156:1: (lv_showValue_1_0= ruleShowValue )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:156:1: (lv_showValue_1_0= ruleShowValue )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:157:3: lv_showValue_1_0= ruleShowValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement264);
                    lv_showValue_1_0=ruleShowValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      	        }
                             		set(
                             			current, 
                             			"showValue",
                              		lv_showValue_1_0, 
                              		"ShowValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:174:6: ( (lv_thisTarget_2_0= 'this' ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:174:6: ( (lv_thisTarget_2_0= 'this' ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:175:1: (lv_thisTarget_2_0= 'this' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:175:1: (lv_thisTarget_2_0= 'this' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:176:3: lv_thisTarget_2_0= 'this'
                    {
                    lv_thisTarget_2_0=(Token)match(input,18,FOLLOW_18_in_ruleDescriptionElement288); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_thisTarget_2_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_2_0());
                          
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
                case 4 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:190:6: ( (lv_image_3_0= ruleImageReference ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:190:6: ( (lv_image_3_0= ruleImageReference ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:191:1: (lv_image_3_0= ruleImageReference )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:191:1: (lv_image_3_0= ruleImageReference )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:192:3: lv_image_3_0= ruleImageReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImageReference_in_ruleDescriptionElement328);
                    lv_image_3_0=ruleImageReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      	        }
                             		set(
                             			current, 
                             			"image",
                              		lv_image_3_0, 
                              		"ImageReference");
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


    // $ANTLR start "entryRuleResultIssue"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:220:1: entryRuleResultIssue returns [EObject current=null] : iv_ruleResultIssue= ruleResultIssue EOF ;
    public final EObject entryRuleResultIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultIssue = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:221:2: (iv_ruleResultIssue= ruleResultIssue EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:222:2: iv_ruleResultIssue= ruleResultIssue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResultIssueRule()); 
            }
            pushFollow(FOLLOW_ruleResultIssue_in_entryRuleResultIssue368);
            iv_ruleResultIssue=ruleResultIssue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResultIssue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultIssue378); if (state.failed) return current;

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
    // $ANTLR end "entryRuleResultIssue"


    // $ANTLR start "ruleResultIssue"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:229:1: ruleResultIssue returns [EObject current=null] : ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) ;
    public final EObject ruleResultIssue() throws RecognitionException {
        EObject current = null;

        Token lv_message_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_exceptionType_5_0=null;
        Token otherlv_6=null;
        Token lv_diagnosticId_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_issueType_0_0 = null;

        EObject lv_issues_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:232:28: ( ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:233:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:233:1: ( ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:233:2: ( (lv_issueType_0_0= ruleResultIssueType ) ) ( (lv_message_1_0= RULE_STRING ) ) (otherlv_2= 'target' ( ( ruleURIID ) ) )? (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )? (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )? (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:233:2: ( (lv_issueType_0_0= ruleResultIssueType ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:234:1: (lv_issueType_0_0= ruleResultIssueType )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:234:1: (lv_issueType_0_0= ruleResultIssueType )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:235:3: lv_issueType_0_0= ruleResultIssueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssueTypeResultIssueTypeEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleResultIssueType_in_ruleResultIssue424);
            lv_issueType_0_0=ruleResultIssueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
              	        }
                     		set(
                     			current, 
                     			"issueType",
                      		lv_issueType_0_0, 
                      		"ResultIssueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:251:2: ( (lv_message_1_0= RULE_STRING ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:252:1: (lv_message_1_0= RULE_STRING )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:252:1: (lv_message_1_0= RULE_STRING )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:253:3: lv_message_1_0= RULE_STRING
            {
            lv_message_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_message_1_0, grammarAccess.getResultIssueAccess().getMessageSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResultIssueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"message",
                      		lv_message_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:269:2: (otherlv_2= 'target' ( ( ruleURIID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:269:4: otherlv_2= 'target' ( ( ruleURIID ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleResultIssue459); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getResultIssueAccess().getTargetKeyword_2_0());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:273:1: ( ( ruleURIID ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:274:1: ( ruleURIID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:274:1: ( ruleURIID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:275:3: ruleURIID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getResultIssueAccess().getTargetEObjectCrossReference_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleURIID_in_ruleResultIssue482);
                    ruleURIID();

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

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:288:4: (otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:288:6: otherlv_4= 'exception' ( (lv_exceptionType_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleResultIssue497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getResultIssueAccess().getExceptionKeyword_3_0());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:292:1: ( (lv_exceptionType_5_0= RULE_STRING ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:293:1: (lv_exceptionType_5_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:293:1: (lv_exceptionType_5_0= RULE_STRING )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:294:3: lv_exceptionType_5_0= RULE_STRING
                    {
                    lv_exceptionType_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue514); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_exceptionType_5_0, grammarAccess.getResultIssueAccess().getExceptionTypeSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"exceptionType",
                              		lv_exceptionType_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:310:4: (otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:310:6: otherlv_6= 'diagnosticId' ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleResultIssue534); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getResultIssueAccess().getDiagnosticIdKeyword_4_0());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:314:1: ( (lv_diagnosticId_7_0= RULE_STRING ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:315:1: (lv_diagnosticId_7_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:315:1: (lv_diagnosticId_7_0= RULE_STRING )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:316:3: lv_diagnosticId_7_0= RULE_STRING
                    {
                    lv_diagnosticId_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultIssue551); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_diagnosticId_7_0, grammarAccess.getResultIssueAccess().getDiagnosticIdSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getResultIssueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"diagnosticId",
                              		lv_diagnosticId_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:332:4: (otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:332:6: otherlv_8= '[' ( (lv_issues_9_0= ruleResultIssue ) )* otherlv_10= ']'
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleResultIssue571); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getResultIssueAccess().getLeftSquareBracketKeyword_5_0());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:336:1: ( (lv_issues_9_0= ruleResultIssue ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=66 && LA6_0<=71)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:337:1: (lv_issues_9_0= ruleResultIssue )
                    	    {
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:337:1: (lv_issues_9_0= ruleResultIssue )
                    	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:338:3: lv_issues_9_0= ruleResultIssue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getResultIssueAccess().getIssuesResultIssueParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleResultIssue_in_ruleResultIssue592);
                    	    lv_issues_9_0=ruleResultIssue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getResultIssueRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"issues",
                    	              		lv_issues_9_0, 
                    	              		"ResultIssue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleResultIssue605); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getResultIssueAccess().getRightSquareBracketKeyword_5_2());
                          
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
    // $ANTLR end "ruleResultIssue"


    // $ANTLR start "entryRuleTypeRef"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:366:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:367:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:368:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef643);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef653); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:375:1: ruleTypeRef returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) ;
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:378:28: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:379:1: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:379:1: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt10=1;
                }
                break;
            case 25:
                {
                alt10=2;
                }
                break;
            case 27:
                {
                alt10=3;
                }
                break;
            case 28:
                {
                alt10=4;
                }
                break;
            case 29:
                {
                alt10=5;
                }
                break;
            case RULE_ID:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:379:2: ( () otherlv_1= 'boolean' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:379:2: ( () otherlv_1= 'boolean' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:379:3: () otherlv_1= 'boolean'
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:379:3: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:380:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTypeRef700); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:390:6: ( () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:390:6: ( () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:390:7: () otherlv_3= 'integer' (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:390:7: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:391:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleTypeRef729); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:400:1: (otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==26) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:400:3: otherlv_4= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleTypeRef742); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getUnitKeyword_1_2_0());
                                  
                            }
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:404:1: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:405:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:405:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:406:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTypeRefRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef765);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:420:6: ( () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:420:6: ( () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:420:7: () otherlv_7= 'real' (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:420:7: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:421:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlRealAction_2_0(),
                                  current);
                          
                    }

                    }

                    otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleTypeRef796); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:430:1: (otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==26) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:430:3: otherlv_8= 'unit' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleTypeRef809); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getTypeRefAccess().getUnitKeyword_2_2_0());
                                  
                            }
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:434:1: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:435:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:435:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:436:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getTypeRefRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef832);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:450:6: ( () otherlv_11= 'string' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:450:6: ( () otherlv_11= 'string' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:450:7: () otherlv_11= 'string'
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:450:7: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:451:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getAadlStringAction_3_0(),
                                  current);
                          
                    }

                    }

                    otherlv_11=(Token)match(input,28,FOLLOW_28_in_ruleTypeRef863); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getTypeRefAccess().getStringKeyword_3_1());
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:461:6: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:461:6: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:461:7: () otherlv_13= 'model' otherlv_14= 'element'
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:461:7: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:462:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getModelRefAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_13=(Token)match(input,29,FOLLOW_29_in_ruleTypeRef892); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getTypeRefAccess().getModelKeyword_4_1());
                          
                    }
                    otherlv_14=(Token)match(input,30,FOLLOW_30_in_ruleTypeRef904); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getTypeRefAccess().getElementKeyword_4_2());
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:476:6: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:476:6: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:476:7: () ( ( ruleAADLPROPERTYREFERENCE ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:476:7: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:477:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTypeRefAccess().getTypeRefAction_5_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:482:2: ( ( ruleAADLPROPERTYREFERENCE ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:483:1: ( ruleAADLPROPERTYREFERENCE )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:483:1: ( ruleAADLPROPERTYREFERENCE )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:484:3: ruleAADLPROPERTYREFERENCE
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeRefRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef944);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:505:1: entryRulePropertyRef returns [EObject current=null] : iv_rulePropertyRef= rulePropertyRef EOF ;
    public final EObject entryRulePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRef = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:506:2: (iv_rulePropertyRef= rulePropertyRef EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:507:2: iv_rulePropertyRef= rulePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRefRule()); 
            }
            pushFollow(FOLLOW_rulePropertyRef_in_entryRulePropertyRef981);
            iv_rulePropertyRef=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyRef991); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:514:1: rulePropertyRef returns [EObject current=null] : ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject rulePropertyRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:517:28: ( ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:518:1: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:518:1: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:518:2: () ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:518:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:519:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPropertyRefAccess().getPropertyRefAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:524:2: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:525:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:525:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:526:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_rulePropertyRef1048);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:551:1: entryRuleAModelOrPropertyReference returns [EObject current=null] : iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF ;
    public final EObject entryRuleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelOrPropertyReference = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:552:2: (iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:553:2: iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAModelOrPropertyReference_in_entryRuleAModelOrPropertyReference1088);
            iv_ruleAModelOrPropertyReference=ruleAModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelOrPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModelOrPropertyReference1098); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:560:1: ruleAModelOrPropertyReference returns [EObject current=null] : ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) ;
    public final EObject ruleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AModelReference_0 = null;

        EObject this_APropertyReference_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:563:28: ( ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:564:1: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:564:1: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            else if ( (LA12_0==31) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:564:2: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:564:2: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:565:5: this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAModelReference_in_ruleAModelOrPropertyReference1146);
                    this_AModelReference_0=ruleAModelReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AModelReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:1: ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==31) && (synpred1_InternalCommon())) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:2: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:2: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:3: ( ( () '#' ) )=> ( () otherlv_2= '#' )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:575:5: ( () otherlv_2= '#' )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:575:6: () otherlv_2= '#'
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:575:6: ()
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:576:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleAModelOrPropertyReference1181); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
                                  
                            }

                            }


                            }

                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:585:3: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:586:1: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:586:1: ( ruleAADLPROPERTYREFERENCE )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:587:3: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getAModelOrPropertyReferenceRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAModelOrPropertyReference1206);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:602:5: this_APropertyReference_4= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAPropertyReference_in_ruleAModelOrPropertyReference1237);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:618:1: entryRuleAModelReference returns [EObject current=null] : iv_ruleAModelReference= ruleAModelReference EOF ;
    public final EObject entryRuleAModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelReference = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:619:2: (iv_ruleAModelReference= ruleAModelReference EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:620:2: iv_ruleAModelReference= ruleAModelReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAModelReference_in_entryRuleAModelReference1272);
            iv_ruleAModelReference=ruleAModelReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModelReference1282); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:627:1: ruleAModelReference returns [EObject current=null] : ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleAModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:630:28: ( ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:631:1: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:631:1: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:631:2: ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:631:2: ( ( ruleThisKeyword ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:632:1: ( ruleThisKeyword )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:632:1: ( ruleThisKeyword )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:633:3: ruleThisKeyword
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAModelReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleThisKeyword_in_ruleAModelReference1330);
            ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:646:2: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==32) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:646:3: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:646:3: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:647:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleAModelReference1352); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1());
            	          
            	    }
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:656:1: ( (otherlv_3= RULE_ID ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:657:1: (otherlv_3= RULE_ID )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:657:1: (otherlv_3= RULE_ID )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:658:3: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAModelReferenceRule());
            	      	        }
            	              
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAModelReference1372); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_3, grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:677:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:678:2: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:679:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference1410);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPropertyReference1420); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:686:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:689:28: ( ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:690:1: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:690:1: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:690:2: () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:690:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:691:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleAPropertyReference1466); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:700:1: ( ( ruleAADLPROPERTYREFERENCE ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:701:1: ( ruleAADLPROPERTYREFERENCE )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:701:1: ( ruleAADLPROPERTYREFERENCE )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:702:3: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference1489);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:723:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:724:2: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:725:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference1525);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableReference1535); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:732:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:735:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:736:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:736:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:736:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:736:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:737:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:742:2: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:743:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:743:1: (otherlv_1= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:744:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAVariableReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAVariableReference1589); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:763:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:764:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:765:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue1625);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue1635); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:772:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:775:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:776:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:776:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:776:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )?
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:776:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:777:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:777:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:778:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShowValueRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue1680); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefAVariableDeclarationCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:789:2: (otherlv_1= '%' | (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) ) )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==33) ) {
                alt14=1;
            }
            else if ( (LA14_0==34) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:789:4: otherlv_1= '%'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleShowValue1693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:794:6: (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:794:6: (otherlv_2= 'in' ( (otherlv_3= RULE_ID ) ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:794:8: otherlv_2= 'in' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleShowValue1712); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getShowValueAccess().getInKeyword_1_1_0());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:798:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:799:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:799:1: (otherlv_3= RULE_ID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:800:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getShowValueRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue1732); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_1_0()); 
                      	
                    }

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:819:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:820:2: (iv_ruleImageReference= ruleImageReference EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:821:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleImageReference_in_entryRuleImageReference1771);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImageReference1781); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:828:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:831:28: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:832:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:832:1: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:832:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleImageReference1818); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:836:1: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:837:1: (lv_imgfile_1_0= ruleIMGREF )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:837:1: (lv_imgfile_1_0= ruleIMGREF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:838:3: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleIMGREF_in_ruleImageReference1839);
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
                      		"IMGREF");
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:862:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:863:2: (iv_ruleIMGREF= ruleIMGREF EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:864:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_ruleIMGREF_in_entryRuleIMGREF1876);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMGREF1887); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:871:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:874:28: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:875:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:875:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:875:2: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:875:2: (this_ID_0= RULE_ID kw= '/' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==36) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:875:7: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF1928); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,36,FOLLOW_36_in_ruleIMGREF1946); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF1963); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            kw=(Token)match(input,32,FOLLOW_32_in_ruleIMGREF1981); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMGREF1996); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:916:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:917:2: (iv_ruleAExpression= ruleAExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:918:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAExpression_in_entryRuleAExpression2041);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExpression2051); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:925:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:928:28: (this_AOrExpression_0= ruleAOrExpression )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:930:5: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_ruleAExpression2097);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:946:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:947:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:948:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression2131);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression2141); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:955:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:958:28: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:959:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:959:1: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:960:5: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression2188);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:1: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==37) && (synpred2_InternalCommon())) {
                    alt16=1;
                }
                else if ( (LA16_0==38) && (synpred2_InternalCommon())) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:2: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:3: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:973:6: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:973:7: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:973:7: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:974:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:979:2: ( (lv_operator_2_0= ruleOpOr ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:980:1: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:980:1: (lv_operator_2_0= ruleOpOr )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:981:3: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpOr_in_ruleAOrExpression2237);
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
            	              		"OpOr");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:997:4: ( (lv_right_3_0= ruleAAndExpression ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:998:1: (lv_right_3_0= ruleAAndExpression )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:998:1: (lv_right_3_0= ruleAAndExpression )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:999:3: lv_right_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression2260);
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
            	              		"AAndExpression");
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
    // $ANTLR end "ruleAOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1023:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1024:2: (iv_ruleOpOr= ruleOpOr EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1025:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_ruleOpOr_in_entryRuleOpOr2299);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpOr2310); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1032:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'or' | kw= '||' ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1035:28: ( (kw= 'or' | kw= '||' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1036:1: (kw= 'or' | kw= '||' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1036:1: (kw= 'or' | kw= '||' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            else if ( (LA17_0==38) ) {
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1037:2: kw= 'or'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleOpOr2348); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1044:2: kw= '||'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleOpOr2367); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1057:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1058:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1059:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression2407);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression2417); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1066:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1069:28: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1070:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1070:1: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1071:5: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2464);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AEqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:1: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==39) && (synpred3_InternalCommon())) {
                    alt18=1;
                }
                else if ( (LA18_0==40) && (synpred3_InternalCommon())) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:2: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:3: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1084:6: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1084:7: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1084:7: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1085:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1090:2: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1091:1: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1091:1: (lv_operator_2_0= ruleOpAnd )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1092:3: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAnd_in_ruleAAndExpression2513);
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
            	              		"OpAnd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1108:4: ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1109:1: (lv_right_3_0= ruleAEqualityExpression )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1109:1: (lv_right_3_0= ruleAEqualityExpression )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1110:3: lv_right_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2536);
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
            	              		"AEqualityExpression");
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
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1134:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1135:2: (iv_ruleOpAnd= ruleOpAnd EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1136:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_ruleOpAnd_in_entryRuleOpAnd2575);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAnd2586); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1143:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= '&&' ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1146:28: ( (kw= 'and' | kw= '&&' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1147:1: (kw= 'and' | kw= '&&' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1147:1: (kw= 'and' | kw= '&&' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            else if ( (LA19_0==40) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1148:2: kw= 'and'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleOpAnd2624); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1155:2: kw= '&&'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleOpAnd2643); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1168:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1169:2: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1170:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression2683);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAEqualityExpression2693); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1177:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1180:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1181:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1181:1: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1182:5: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression2740);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ARelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:1: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==41) && (synpred4_InternalCommon())) {
                    alt20=1;
                }
                else if ( (LA20_0==42) && (synpred4_InternalCommon())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:2: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:3: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1195:6: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1195:7: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1195:7: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1196:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1201:2: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1202:1: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1202:1: (lv_operator_2_0= ruleOpEquality )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1203:3: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpEquality_in_ruleAEqualityExpression2789);
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
            	              		"OpEquality");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1219:4: ( (lv_right_3_0= ruleARelationalExpression ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1220:1: (lv_right_3_0= ruleARelationalExpression )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1220:1: (lv_right_3_0= ruleARelationalExpression )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1221:3: lv_right_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression2812);
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
            	              		"ARelationalExpression");
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
    // $ANTLR end "ruleAEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1245:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1246:2: (iv_ruleOpEquality= ruleOpEquality EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1247:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleOpEquality_in_entryRuleOpEquality2851);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpEquality2862); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1254:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1257:28: ( (kw= '==' | kw= '!=' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1258:1: (kw= '==' | kw= '!=' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1258:1: (kw= '==' | kw= '!=' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            else if ( (LA21_0==42) ) {
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1259:2: kw= '=='
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleOpEquality2900); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1266:2: kw= '!='
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleOpEquality2919); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1279:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1280:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1281:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression2959);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression2969); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1288:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1291:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1292:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1292:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1293:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3016);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AAdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:1: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==43) && (synpred5_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==44) && (synpred5_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==45) && (synpred5_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==46) && (synpred5_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==47) && (synpred5_InternalCommon())) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:2: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:3: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1306:6: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1306:7: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1306:7: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1307:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1312:2: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1313:1: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1313:1: (lv_operator_2_0= ruleOpCompare )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1314:3: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpCompare_in_ruleARelationalExpression3065);
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
            	              		"OpCompare");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1330:4: ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1331:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1331:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1332:3: lv_right_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3088);
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
            	              		"AAdditiveExpression");
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
    // $ANTLR end "ruleARelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1356:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1357:2: (iv_ruleOpCompare= ruleOpCompare EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1358:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_ruleOpCompare_in_entryRuleOpCompare3127);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpCompare3138); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1365:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1368:28: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1369:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1369:1: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt23=1;
                }
                break;
            case 44:
                {
                alt23=2;
                }
                break;
            case 45:
                {
                alt23=3;
                }
                break;
            case 46:
                {
                alt23=4;
                }
                break;
            case 47:
                {
                alt23=5;
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1370:2: kw= '>='
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleOpCompare3176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1377:2: kw= '<='
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleOpCompare3195); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1384:2: kw= '>'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleOpCompare3214); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1391:2: kw= '<'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleOpCompare3233); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1398:2: kw= '><'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleOpCompare3252); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1411:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1412:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1413:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression3292);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression3302); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1420:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1423:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1424:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1424:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1425:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3349);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AMultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:1: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==48) && (synpred6_InternalCommon())) {
                    alt24=1;
                }
                else if ( (LA24_0==49) && (synpred6_InternalCommon())) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:2: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:3: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1438:6: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1438:7: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1438:7: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1439:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1444:2: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1445:1: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1445:1: (lv_operator_2_0= ruleOpAdd )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1446:3: lv_operator_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression3398);
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
            	              		"OpAdd");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1462:4: ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1463:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1463:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1464:3: lv_right_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3421);
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
            	              		"AMultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1488:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1489:2: (iv_ruleOpAdd= ruleOpAdd EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1490:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_ruleOpAdd_in_entryRuleOpAdd3460);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpAdd3471); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1497:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1500:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1501:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1501:1: (kw= '+' | kw= '-' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==48) ) {
                alt25=1;
            }
            else if ( (LA25_0==49) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1502:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpAdd3509); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1509:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpAdd3528); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1522:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1523:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1524:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression3568);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression3578); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1531:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1534:28: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1535:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1535:1: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1536:5: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression3625);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AUnaryOperation_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:1: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==50) && (synpred7_InternalCommon())) {
                    alt26=1;
                }
                else if ( (LA26_0==36) && (synpred7_InternalCommon())) {
                    alt26=1;
                }
                else if ( (LA26_0==51) && (synpred7_InternalCommon())) {
                    alt26=1;
                }
                else if ( (LA26_0==52) && (synpred7_InternalCommon())) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:2: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:3: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1549:6: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1549:7: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1549:7: ()
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1550:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1555:2: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1556:1: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1556:1: (lv_operator_2_0= ruleOpMulti )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1557:3: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression3674);
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
            	              		"OpMulti");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1573:4: ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1574:1: (lv_right_3_0= ruleAUnaryOperation )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1574:1: (lv_right_3_0= ruleAUnaryOperation )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1575:3: lv_right_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression3697);
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
            	              		"AUnaryOperation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1599:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1600:2: (iv_ruleOpMulti= ruleOpMulti EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1601:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_ruleOpMulti_in_entryRuleOpMulti3736);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpMulti3747); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1608:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1611:28: ( (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1612:1: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1612:1: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            int alt27=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt27=1;
                }
                break;
            case 36:
                {
                alt27=2;
                }
                break;
            case 51:
                {
                alt27=3;
                }
                break;
            case 52:
                {
                alt27=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1613:2: kw= '*'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleOpMulti3785); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1620:2: kw= '/'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleOpMulti3804); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1627:2: kw= 'div'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleOpMulti3823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1634:2: kw= 'mod'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleOpMulti3842); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1647:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1648:2: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1649:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation3882);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOperation3892); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1656:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_AUnitExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1659:28: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1660:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1660:1: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=48 && LA28_0<=49)||LA28_0==53) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_REAL_LIT)||LA28_0==18||LA28_0==22||LA28_0==31||LA28_0==54||LA28_0==59||(LA28_0>=63 && LA28_0<=64)) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1660:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1660:2: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1660:3: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1660:3: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1661:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1666:2: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1666:3: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1671:1: (lv_operator_1_0= ruleOpUnary )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1672:3: lv_operator_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleOpUnary_in_ruleAUnaryOperation3958);
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
                              		"OpUnary");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1688:2: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1689:1: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1689:1: (lv_operand_2_0= ruleAUnaryOperation )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1690:3: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation3979);
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
                              		"AUnaryOperation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1708:5: this_AUnitExpression_3= ruleAUnitExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAUnitExpression_in_ruleAUnaryOperation4008);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1724:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1725:2: (iv_ruleOpUnary= ruleOpUnary EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1726:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleOpUnary_in_entryRuleOpUnary4044);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpUnary4055); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1733:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1736:28: ( (kw= 'not' | kw= '-' | kw= '+' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1737:1: (kw= 'not' | kw= '-' | kw= '+' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1737:1: (kw= 'not' | kw= '-' | kw= '+' )
            int alt29=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt29=1;
                }
                break;
            case 49:
                {
                alt29=2;
                }
                break;
            case 48:
                {
                alt29=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1738:2: kw= 'not'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleOpUnary4093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1745:2: kw= '-'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleOpUnary4112); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1752:2: kw= '+'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleOpUnary4131); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1765:1: entryRuleAUnitExpression returns [EObject current=null] : iv_ruleAUnitExpression= ruleAUnitExpression EOF ;
    public final EObject entryRuleAUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnitExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1766:2: (iv_ruleAUnitExpression= ruleAUnitExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1767:2: iv_ruleAUnitExpression= ruleAUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnitExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAUnitExpression_in_entryRuleAUnitExpression4171);
            iv_ruleAUnitExpression=ruleAUnitExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnitExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnitExpression4181); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1774:1: ruleAUnitExpression returns [EObject current=null] : (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleAUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_APrimaryExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1777:28: ( (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1778:1: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1778:1: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1779:5: this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_ruleAUnitExpression4228);
            this_APrimaryExpression_0=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_APrimaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1787:1: ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID||(LA31_0>=33 && LA31_0<=34)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1787:2: () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1787:2: ()
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1788:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1793:2: ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )?
                    int alt30=3;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==33) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==34) ) {
                        alt30=2;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1793:3: ( (lv_convert_2_0= '%' ) )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1793:3: ( (lv_convert_2_0= '%' ) )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1794:1: (lv_convert_2_0= '%' )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1794:1: (lv_convert_2_0= '%' )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1795:3: lv_convert_2_0= '%'
                            {
                            lv_convert_2_0=(Token)match(input,33,FOLLOW_33_in_ruleAUnitExpression4256); if (state.failed) return current;
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
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1809:6: ( (lv_drop_3_0= 'in' ) )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1809:6: ( (lv_drop_3_0= 'in' ) )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1810:1: (lv_drop_3_0= 'in' )
                            {
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1810:1: (lv_drop_3_0= 'in' )
                            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1811:3: lv_drop_3_0= 'in'
                            {
                            lv_drop_3_0=(Token)match(input,34,FOLLOW_34_in_ruleAUnitExpression4293); if (state.failed) return current;
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

                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1824:4: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1825:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1825:1: (otherlv_4= RULE_ID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1826:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getAUnitExpressionRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAUnitExpression4328); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1845:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1846:2: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1847:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression4366);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPrimaryExpression4376); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1854:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) ;
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1857:28: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1858:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1858:1: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            int alt32=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL_LIT:
            case 63:
            case 64:
                {
                alt32=1;
                }
                break;
            case RULE_ID:
                {
                int LA32_2 = input.LA(2);

                if ( (LA32_2==54) ) {
                    alt32=4;
                }
                else if ( (LA32_2==EOF||LA32_2==RULE_ID||LA32_2==23||(LA32_2>=33 && LA32_2<=34)||(LA32_2>=36 && LA32_2<=52)||(LA32_2>=55 && LA32_2<=58)||(LA32_2>=60 && LA32_2<=62)) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 2, input);

                    throw nvae;
                }
                }
                break;
            case 18:
            case 31:
                {
                alt32=3;
                }
                break;
            case 22:
                {
                alt32=5;
                }
                break;
            case 59:
                {
                alt32=6;
                }
                break;
            case 54:
                {
                alt32=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1859:5: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleALiteral_in_ruleAPrimaryExpression4423);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1869:5: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression4450);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1879:5: this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAModelOrPropertyReference_in_ruleAPrimaryExpression4477);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1889:5: this_AFunctionCall_3= ruleAFunctionCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAFunctionCall_in_ruleAPrimaryExpression4504);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1899:5: this_ARangeExpression_4= ruleARangeExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARangeExpression_in_ruleAPrimaryExpression4531);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1909:5: this_AIfExpression_5= ruleAIfExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIfExpression_in_ruleAPrimaryExpression4558);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1919:5: this_AParenthesizedExpression_6= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression4585);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1935:1: entryRuleAFunctionCall returns [EObject current=null] : iv_ruleAFunctionCall= ruleAFunctionCall EOF ;
    public final EObject entryRuleAFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionCall = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1936:2: (iv_ruleAFunctionCall= ruleAFunctionCall EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1937:2: iv_ruleAFunctionCall= ruleAFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAFunctionCallRule()); 
            }
            pushFollow(FOLLOW_ruleAFunctionCall_in_entryRuleAFunctionCall4620);
            iv_ruleAFunctionCall=ruleAFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAFunctionCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunctionCall4630); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1944:1: ruleAFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' ) ;
    public final EObject ruleAFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_function_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1947:28: ( ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1948:1: ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1948:1: ( () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* otherlv_6= ')' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1948:2: () ( (lv_function_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* otherlv_6= ')'
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1948:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1949:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1954:2: ( (lv_function_1_0= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1955:1: (lv_function_1_0= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1955:1: (lv_function_1_0= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1956:3: lv_function_1_0= RULE_ID
            {
            lv_function_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAFunctionCall4681); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_function_1_0, grammarAccess.getAFunctionCallAccess().getFunctionIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAFunctionCallRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"function",
                      		lv_function_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleAFunctionCall4698); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1976:1: ( (lv_arguments_3_0= ruleAExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1977:1: (lv_arguments_3_0= ruleAExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1977:1: (lv_arguments_3_0= ruleAExpression )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1978:3: lv_arguments_3_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAFunctionCall4719);
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
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1994:2: (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==55) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1994:4: otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) )
            	    {
            	    otherlv_4=(Token)match(input,55,FOLLOW_55_in_ruleAFunctionCall4732); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1998:1: ( (lv_arguments_5_0= ruleAExpression ) )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1999:1: (lv_arguments_5_0= ruleAExpression )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1999:1: (lv_arguments_5_0= ruleAExpression )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2000:3: lv_arguments_5_0= ruleAExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAExpression_in_ruleAFunctionCall4753);
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
            	              		"AExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_6=(Token)match(input,56,FOLLOW_56_in_ruleAFunctionCall4767); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_5());
                  
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2028:1: entryRuleARangeExpression returns [EObject current=null] : iv_ruleARangeExpression= ruleARangeExpression EOF ;
    public final EObject entryRuleARangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARangeExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2029:2: (iv_ruleARangeExpression= ruleARangeExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2030:2: iv_ruleARangeExpression= ruleARangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARangeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleARangeExpression_in_entryRuleARangeExpression4803);
            iv_ruleARangeExpression=ruleARangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARangeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARangeExpression4813); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2037:1: ruleARangeExpression returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) ;
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2040:28: ( ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2041:1: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2041:1: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2041:2: () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']'
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2041:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2042:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getARangeExpressionAccess().getARangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleARangeExpression4859); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2051:1: ( (lv_minimum_2_0= ruleAExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2052:1: (lv_minimum_2_0= ruleAExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2052:1: (lv_minimum_2_0= ruleAExpression )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2053:3: lv_minimum_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleARangeExpression4880);
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
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleARangeExpression4892); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2073:1: ( (lv_maximum_4_0= ruleAExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2074:1: (lv_maximum_4_0= ruleAExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2074:1: (lv_maximum_4_0= ruleAExpression )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2075:3: lv_maximum_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleARangeExpression4913);
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
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2091:2: ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==58) && (synpred9_InternalCommon())) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2091:3: ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2091:3: ( ( 'delta' )=>otherlv_5= 'delta' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2091:4: ( 'delta' )=>otherlv_5= 'delta'
                    {
                    otherlv_5=(Token)match(input,58,FOLLOW_58_in_ruleARangeExpression4934); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2096:2: ( (lv_delta_6_0= ruleAExpression ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2097:1: (lv_delta_6_0= ruleAExpression )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2097:1: (lv_delta_6_0= ruleAExpression )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2098:3: lv_delta_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleARangeExpression4956);
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
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleARangeExpression4970); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2126:1: entryRuleAIfExpression returns [EObject current=null] : iv_ruleAIfExpression= ruleAIfExpression EOF ;
    public final EObject entryRuleAIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIfExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2127:2: (iv_ruleAIfExpression= ruleAIfExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2128:2: iv_ruleAIfExpression= ruleAIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIfExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression5006);
            iv_ruleAIfExpression=ruleAIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIfExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIfExpression5016); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2135:1: ruleAIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) ;
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
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2138:28: ( ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2139:1: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2139:1: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2139:2: () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif'
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2139:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2140:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAIfExpressionAccess().getAConditionalAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_59_in_ruleAIfExpression5062); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAIfExpressionAccess().getIfKeyword_1());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2149:1: ( (lv_if_2_0= ruleAExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2150:1: (lv_if_2_0= ruleAExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2150:1: (lv_if_2_0= ruleAExpression )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2151:3: lv_if_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAIfExpression5083);
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
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,60,FOLLOW_60_in_ruleAIfExpression5095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAIfExpressionAccess().getThenKeyword_3());
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2171:1: ( (lv_then_4_0= ruleAExpression ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2172:1: (lv_then_4_0= ruleAExpression )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2172:1: (lv_then_4_0= ruleAExpression )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2173:3: lv_then_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAIfExpression5116);
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
                      		"AExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2189:2: (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==61) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2189:4: otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) )
                    {
                    otherlv_5=(Token)match(input,61,FOLLOW_61_in_ruleAIfExpression5129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0());
                          
                    }
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2193:1: ( (lv_else_6_0= ruleAExpression ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2194:1: (lv_else_6_0= ruleAExpression )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2194:1: (lv_else_6_0= ruleAExpression )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2195:3: lv_else_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAExpression_in_ruleAIfExpression5150);
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
                              		"AExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,62,FOLLOW_62_in_ruleAIfExpression5164); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2223:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2224:2: (iv_ruleALiteral= ruleALiteral EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2225:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_ruleALiteral_in_entryRuleALiteral5200);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleALiteral5210); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2232:1: ruleALiteral returns [EObject current=null] : (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) ;
    public final EObject ruleALiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ABooleanLiteral_0 = null;

        EObject this_ARealTerm_1 = null;

        EObject this_AIntegerTerm_2 = null;

        EObject this_StringTerm_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2235:28: ( (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2236:1: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2236:1: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 63:
            case 64:
                {
                alt36=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt36=2;
                }
                break;
            case RULE_INT:
                {
                alt36=3;
                }
                break;
            case RULE_STRING:
                {
                alt36=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2237:5: this_ABooleanLiteral_0= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleABooleanLiteral_in_ruleALiteral5257);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2247:5: this_ARealTerm_1= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleARealTerm_in_ruleALiteral5284);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2257:5: this_AIntegerTerm_2= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAIntegerTerm_in_ruleALiteral5311);
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2267:5: this_StringTerm_3= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleALiteral5338);
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2283:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2284:2: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2285:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5373);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerTerm5383); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2292:1: ruleAIntegerTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAInt ) ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2295:28: ( ( (lv_value_0_0= ruleAInt ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2296:1: ( (lv_value_0_0= ruleAInt ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2296:1: ( (lv_value_0_0= ruleAInt ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2297:1: (lv_value_0_0= ruleAInt )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2297:1: (lv_value_0_0= ruleAInt )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2298:3: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAInt_in_ruleAIntegerTerm5428);
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
                      		"AInt");
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2322:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2323:2: (iv_ruleAInt= ruleAInt EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2324:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_ruleAInt_in_entryRuleAInt5464);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInt5475); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2331:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2334:28: (this_INT_0= RULE_INT )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2335:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAInt5514); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2350:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2351:2: (iv_ruleARealTerm= ruleARealTerm EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2352:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_ruleARealTerm_in_entryRuleARealTerm5558);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealTerm5568); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2359:1: ruleARealTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAReal ) ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2362:28: ( ( (lv_value_0_0= ruleAReal ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2363:1: ( (lv_value_0_0= ruleAReal ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2363:1: ( (lv_value_0_0= ruleAReal ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2364:1: (lv_value_0_0= ruleAReal )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2364:1: (lv_value_0_0= ruleAReal )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2365:3: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAReal_in_ruleARealTerm5613);
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
                      		"AReal");
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2389:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2390:2: (iv_ruleAReal= ruleAReal EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2391:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_ruleAReal_in_entryRuleAReal5649);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReal5660); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2398:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2401:28: (this_REAL_LIT_0= RULE_REAL_LIT )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2402:5: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleAReal5699); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2417:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2418:2: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2419:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral5743);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanLiteral5753); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2426:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2429:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2430:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2430:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2430:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2430:2: ()
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2431:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2436:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==63) ) {
                alt37=1;
            }
            else if ( (LA37_0==64) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2436:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2436:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2437:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2437:1: (lv_value_1_0= 'true' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2438:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,63,FOLLOW_63_in_ruleABooleanLiteral5806); if (state.failed) return current;
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2452:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,64,FOLLOW_64_in_ruleABooleanLiteral5837); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2464:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2465:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2466:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm5874);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm5884); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2473:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2476:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2477:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2477:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2478:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2478:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2479:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm5929);
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
                      		"NoQuoteString");
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2503:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2504:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2505:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString5965);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString5976); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2512:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2515:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2516:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString6015); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2531:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2532:2: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2533:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6059);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParenthesizedExpression6069); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2540:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2543:28: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2544:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2544:1: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2544:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleAParenthesizedExpression6106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6128);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AExpression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleAParenthesizedExpression6139); if (state.failed) return current;
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2573:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2574:2: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2575:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE6180);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE6191); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2582:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2585:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2586:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2586:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2586:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE6231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2593:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==65) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2594:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleAADLPROPERTYREFERENCE6250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE6265); if (state.failed) return current;
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


    // $ANTLR start "entryRuleURIID"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2614:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2615:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2616:2: iv_ruleURIID= ruleURIID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIIDRule()); 
            }
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID6313);
            iv_ruleURIID=ruleURIID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID6324); if (state.failed) return current;

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
    // $ANTLR end "entryRuleURIID"


    // $ANTLR start "ruleURIID"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2623:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2626:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2627:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID6363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleURIID"


    // $ANTLR start "entryRuleThisKeyword"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2644:1: entryRuleThisKeyword returns [String current=null] : iv_ruleThisKeyword= ruleThisKeyword EOF ;
    public final String entryRuleThisKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleThisKeyword = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2645:2: (iv_ruleThisKeyword= ruleThisKeyword EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2646:2: iv_ruleThisKeyword= ruleThisKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisKeywordRule()); 
            }
            pushFollow(FOLLOW_ruleThisKeyword_in_entryRuleThisKeyword6410);
            iv_ruleThisKeyword=ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThisKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleThisKeyword6421); if (state.failed) return current;

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2653:1: ruleThisKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'this' ;
    public final AntlrDatatypeRuleToken ruleThisKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2656:28: (kw= 'this' )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2658:2: kw= 'this'
            {
            kw=(Token)match(input,18,FOLLOW_18_in_ruleThisKeyword6458); if (state.failed) return current;
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


    // $ANTLR start "ruleResultIssueType"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2671:1: ruleResultIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) ;
    public final Enumerator ruleResultIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2673:28: ( ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2674:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2674:1: ( (enumLiteral_0= 'tbd' ) | (enumLiteral_1= 'error' ) | (enumLiteral_2= 'warning' ) | (enumLiteral_3= 'info' ) | (enumLiteral_4= 'success' ) | (enumLiteral_5= 'fail' ) )
            int alt39=6;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt39=1;
                }
                break;
            case 67:
                {
                alt39=2;
                }
                break;
            case 68:
                {
                alt39=3;
                }
                break;
            case 69:
                {
                alt39=4;
                }
                break;
            case 70:
                {
                alt39=5;
                }
                break;
            case 71:
                {
                alt39=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2674:2: (enumLiteral_0= 'tbd' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2674:2: (enumLiteral_0= 'tbd' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2674:4: enumLiteral_0= 'tbd'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_66_in_ruleResultIssueType6511); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getResultIssueTypeAccess().getTBDEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2680:6: (enumLiteral_1= 'error' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2680:6: (enumLiteral_1= 'error' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2680:8: enumLiteral_1= 'error'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_67_in_ruleResultIssueType6528); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getResultIssueTypeAccess().getERROREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2686:6: (enumLiteral_2= 'warning' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2686:6: (enumLiteral_2= 'warning' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2686:8: enumLiteral_2= 'warning'
                    {
                    enumLiteral_2=(Token)match(input,68,FOLLOW_68_in_ruleResultIssueType6545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getResultIssueTypeAccess().getWARNINGEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2692:6: (enumLiteral_3= 'info' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2692:6: (enumLiteral_3= 'info' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2692:8: enumLiteral_3= 'info'
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_69_in_ruleResultIssueType6562); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getResultIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2698:6: (enumLiteral_4= 'success' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2698:6: (enumLiteral_4= 'success' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2698:8: enumLiteral_4= 'success'
                    {
                    enumLiteral_4=(Token)match(input,70,FOLLOW_70_in_ruleResultIssueType6579); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getResultIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2704:6: (enumLiteral_5= 'fail' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2704:6: (enumLiteral_5= 'fail' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2704:8: enumLiteral_5= 'fail'
                    {
                    enumLiteral_5=(Token)match(input,71,FOLLOW_71_in_ruleResultIssueType6596); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getResultIssueTypeAccess().getFAILEnumLiteralDeclaration_5()); 
                          
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
    // $ANTLR end "ruleResultIssueType"

    // $ANTLR start synpred1_InternalCommon
    public final void synpred1_InternalCommon_fragment() throws RecognitionException {   
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:3: ( ( () '#' ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:4: ( () '#' )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:4: ( () '#' )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:5: () '#'
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:573:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:574:1: 
        {
        }

        match(input,31,FOLLOW_31_in_synpred1_InternalCommon1162); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalCommon

    // $ANTLR start synpred2_InternalCommon
    public final void synpred2_InternalCommon_fragment() throws RecognitionException {   
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:3: ( ( () ( ( ruleOpOr ) ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:4: ( () ( ( ruleOpOr ) ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:4: ( () ( ( ruleOpOr ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:5: () ( ( ruleOpOr ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:968:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:969:1: 
        {
        }

        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:969:2: ( ( ruleOpOr ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:970:1: ( ruleOpOr )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:970:1: ( ruleOpOr )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:971:1: ruleOpOr
        {
        pushFollow(FOLLOW_ruleOpOr_in_synpred2_InternalCommon2207);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalCommon

    // $ANTLR start synpred3_InternalCommon
    public final void synpred3_InternalCommon_fragment() throws RecognitionException {   
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:3: ( ( () ( ( ruleOpAnd ) ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:4: ( () ( ( ruleOpAnd ) ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:4: ( () ( ( ruleOpAnd ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:5: () ( ( ruleOpAnd ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1079:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1080:1: 
        {
        }

        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1080:2: ( ( ruleOpAnd ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1081:1: ( ruleOpAnd )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1081:1: ( ruleOpAnd )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1082:1: ruleOpAnd
        {
        pushFollow(FOLLOW_ruleOpAnd_in_synpred3_InternalCommon2483);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalCommon

    // $ANTLR start synpred4_InternalCommon
    public final void synpred4_InternalCommon_fragment() throws RecognitionException {   
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:3: ( ( () ( ( ruleOpEquality ) ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:4: ( () ( ( ruleOpEquality ) ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:4: ( () ( ( ruleOpEquality ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:5: () ( ( ruleOpEquality ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1190:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1191:1: 
        {
        }

        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1191:2: ( ( ruleOpEquality ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1192:1: ( ruleOpEquality )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1192:1: ( ruleOpEquality )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1193:1: ruleOpEquality
        {
        pushFollow(FOLLOW_ruleOpEquality_in_synpred4_InternalCommon2759);
        ruleOpEquality();

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
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:3: ( ( () ( ( ruleOpCompare ) ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:4: ( () ( ( ruleOpCompare ) ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:4: ( () ( ( ruleOpCompare ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:5: () ( ( ruleOpCompare ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1301:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1302:1: 
        {
        }

        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1302:2: ( ( ruleOpCompare ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1303:1: ( ruleOpCompare )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1303:1: ( ruleOpCompare )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1304:1: ruleOpCompare
        {
        pushFollow(FOLLOW_ruleOpCompare_in_synpred5_InternalCommon3035);
        ruleOpCompare();

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
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:3: ( ( () ( ( ruleOpAdd ) ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:4: ( () ( ( ruleOpAdd ) ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:4: ( () ( ( ruleOpAdd ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:5: () ( ( ruleOpAdd ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1433:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1434:1: 
        {
        }

        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1434:2: ( ( ruleOpAdd ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1435:1: ( ruleOpAdd )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1435:1: ( ruleOpAdd )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1436:1: ruleOpAdd
        {
        pushFollow(FOLLOW_ruleOpAdd_in_synpred6_InternalCommon3368);
        ruleOpAdd();

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
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:3: ( ( () ( ( ruleOpMulti ) ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:4: ( () ( ( ruleOpMulti ) ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:4: ( () ( ( ruleOpMulti ) ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:5: () ( ( ruleOpMulti ) )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1544:5: ()
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1545:1: 
        {
        }

        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1545:2: ( ( ruleOpMulti ) )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1546:1: ( ruleOpMulti )
        {
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1546:1: ( ruleOpMulti )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:1547:1: ruleOpMulti
        {
        pushFollow(FOLLOW_ruleOpMulti_in_synpred7_InternalCommon3644);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalCommon

    // $ANTLR start synpred9_InternalCommon
    public final void synpred9_InternalCommon_fragment() throws RecognitionException {   
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2091:4: ( 'delta' )
        // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:2091:6: 'delta'
        {
        match(input,58,FOLLOW_58_in_synpred9_InternalCommon4926); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalCommon

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


 

    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleDescription122 = new BitSet(new long[]{0x0000000800040030L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription143 = new BitSet(new long[]{0x0000000800040032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleDescriptionElement288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_ruleDescriptionElement328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssue_in_entryRuleResultIssue368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultIssue378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultIssueType_in_ruleResultIssue424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue441 = new BitSet(new long[]{0x0000000000780002L});
    public static final BitSet FOLLOW_19_in_ruleResultIssue459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultIssue482 = new BitSet(new long[]{0x0000000000700002L});
    public static final BitSet FOLLOW_20_in_ruleResultIssue497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue514 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_21_in_ruleResultIssue534 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultIssue551 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleResultIssue571 = new BitSet(new long[]{0x0000000000800000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_ruleResultIssue_in_ruleResultIssue592 = new BitSet(new long[]{0x0000000000800000L,0x00000000000000FCL});
    public static final BitSet FOLLOW_23_in_ruleResultIssue605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTypeRef700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTypeRef729 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleTypeRef742 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTypeRef796 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleTypeRef809 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTypeRef892 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTypeRef904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleTypeRef944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyRef_in_entryRulePropertyRef981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyRef991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_rulePropertyRef1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelOrPropertyReference_in_entryRuleAModelOrPropertyReference1088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModelOrPropertyReference1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelReference_in_ruleAModelOrPropertyReference1146 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleAModelOrPropertyReference1181 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAModelOrPropertyReference1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_ruleAModelOrPropertyReference1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelReference_in_entryRuleAModelReference1272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModelReference1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisKeyword_in_ruleAModelReference1330 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleAModelReference1352 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAModelReference1372 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleAPropertyReference_in_entryRuleAPropertyReference1410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPropertyReference1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAPropertyReference1466 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_ruleAPropertyReference1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_entryRuleAVariableReference1525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableReference1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAVariableReference1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue1625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue1680 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_ruleShowValue1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleShowValue1712 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImageReference_in_entryRuleImageReference1771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImageReference1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleImageReference1818 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleIMGREF_in_ruleImageReference1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMGREF_in_entryRuleIMGREF1876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMGREF1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF1928 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleIMGREF1946 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF1963 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleIMGREF1981 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMGREF1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExpression_in_entryRuleAExpression2041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExpression2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAExpression2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression2131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression2188 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_ruleAOrExpression2237 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression2260 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_entryRuleOpOr2299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpOr2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleOpOr2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleOpOr2367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression2407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2464 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_ruleAAndExpression2513 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_ruleAAndExpression2536 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_entryRuleOpAnd2575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAnd2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOpAnd2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleOpAnd2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEqualityExpression_in_entryRuleAEqualityExpression2683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAEqualityExpression2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression2740 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_ruleAEqualityExpression2789 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAEqualityExpression2812 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_entryRuleOpEquality2851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpEquality2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOpEquality2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleOpEquality2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression2959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3016 = new BitSet(new long[]{0x0000F80000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_ruleARelationalExpression3065 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3088 = new BitSet(new long[]{0x0000F80000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_entryRuleOpCompare3127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpCompare3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOpCompare3176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleOpCompare3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleOpCompare3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleOpCompare3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleOpCompare3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression3292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3349 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_ruleAAdditiveExpression3398 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3421 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_entryRuleOpAdd3460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpAdd3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpAdd3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpAdd3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression3568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression3625 = new BitSet(new long[]{0x001C001000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_ruleAMultiplicativeExpression3674 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAMultiplicativeExpression3697 = new BitSet(new long[]{0x001C001000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_entryRuleOpMulti3736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpMulti3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleOpMulti3785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleOpMulti3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOpMulti3823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleOpMulti3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_entryRuleAUnaryOperation3882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOperation3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_ruleAUnaryOperation3958 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOperation_in_ruleAUnaryOperation3979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnitExpression_in_ruleAUnaryOperation4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpUnary_in_entryRuleOpUnary4044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpUnary4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOpUnary4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOpUnary4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleOpUnary4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnitExpression_in_entryRuleAUnitExpression4171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnitExpression4181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_ruleAUnitExpression4228 = new BitSet(new long[]{0x0000000600000022L});
    public static final BitSet FOLLOW_33_in_ruleAUnitExpression4256 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_34_in_ruleAUnitExpression4293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAUnitExpression4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPrimaryExpression_in_entryRuleAPrimaryExpression4366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPrimaryExpression4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_ruleAPrimaryExpression4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableReference_in_ruleAPrimaryExpression4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModelOrPropertyReference_in_ruleAPrimaryExpression4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionCall_in_ruleAPrimaryExpression4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARangeExpression_in_ruleAPrimaryExpression4531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_ruleAPrimaryExpression4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_ruleAPrimaryExpression4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionCall_in_entryRuleAFunctionCall4620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunctionCall4630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAFunctionCall4681 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleAFunctionCall4698 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAFunctionCall4719 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_55_in_ruleAFunctionCall4732 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAFunctionCall4753 = new BitSet(new long[]{0x0180000000000000L});
    public static final BitSet FOLLOW_56_in_ruleAFunctionCall4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARangeExpression_in_entryRuleARangeExpression4803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARangeExpression4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleARangeExpression4859 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleARangeExpression4880 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleARangeExpression4892 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleARangeExpression4913 = new BitSet(new long[]{0x0400000000800000L});
    public static final BitSet FOLLOW_58_in_ruleARangeExpression4934 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleARangeExpression4956 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleARangeExpression4970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression5006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIfExpression5016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAIfExpression5062 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAIfExpression5083 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleAIfExpression5095 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAIfExpression5116 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleAIfExpression5129 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAIfExpression5150 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleAIfExpression5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALiteral_in_entryRuleALiteral5200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALiteral5210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_ruleALiteral5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_ruleALiteral5284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_ruleALiteral5311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleALiteral5338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerTerm_in_entryRuleAIntegerTerm5373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerTerm5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_ruleAIntegerTerm5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInt_in_entryRuleAInt5464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInt5475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAInt5514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealTerm_in_entryRuleARealTerm5558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealTerm5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_ruleARealTerm5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReal_in_entryRuleAReal5649 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReal5660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleAReal5699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanLiteral_in_entryRuleABooleanLiteral5743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanLiteral5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleABooleanLiteral5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleABooleanLiteral5837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm5874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm5884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString5965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString6015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParenthesizedExpression_in_entryRuleAParenthesizedExpression6059 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParenthesizedExpression6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAParenthesizedExpression6106 = new BitSet(new long[]{0x88630000804400F0L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAExpression_in_ruleAParenthesizedExpression6128 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleAParenthesizedExpression6139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAADLPROPERTYREFERENCE_in_entryRuleAADLPROPERTYREFERENCE6180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAADLPROPERTYREFERENCE6191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE6231 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAADLPROPERTYREFERENCE6250 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAADLPROPERTYREFERENCE6265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID6313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID6324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID6363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisKeyword_in_entryRuleThisKeyword6410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThisKeyword6421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleThisKeyword6458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleResultIssueType6511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleResultIssueType6528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleResultIssueType6545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleResultIssueType6562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleResultIssueType6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleResultIssueType6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_synpred1_InternalCommon1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpOr_in_synpred2_InternalCommon2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAnd_in_synpred3_InternalCommon2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpEquality_in_synpred4_InternalCommon2759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpCompare_in_synpred5_InternalCommon3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpAdd_in_synpred6_InternalCommon3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpMulti_in_synpred7_InternalCommon3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred9_InternalCommon4926 = new BitSet(new long[]{0x0000000000000002L});

}
