package org.osate.xtext.aadl2.parser.antlr.internal; 

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
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalAadl2Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SEMI", "RULE_COMMA", "RULE_COLON", "RULE_LTRANS", "RULE_RTRANS", "RULE_NONE", "RULE_DOT", "RULE_LPARENS", "RULE_RPARENS", "RULE_ANNEXTEXT", "RULE_EM", "RULE_SL_COMMENT", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_LCURLY", "RULE_RCURLY", "RULE_ASSIGN", "RULE_APPEND", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'end'", "'::'", "'public'", "'with'", "'private'", "'flow'", "'->'", "'initial'", "'mode'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'prototypes'", "'features'", "'flows'", "'modes'", "'implementation'", "'subcomponents'", "'connections'", "'feature'", "'port'", "'event'", "'in'", "'out'", "'all'", "'<->'", "'access'", "'parameter'", "'annex'", "'source'", "'path'", "'sink'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_ANY_OTHER=27;
    public static final int RULE_LBRACKET=17;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int RULE_ASSIGN=21;
    public static final int RULE_ANNEXTEXT=14;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int RULE_DOT=11;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_LPARENS=12;
    public static final int RULE_INT=23;
    public static final int T__50=50;
    public static final int RULE_RBRACKET=18;
    public static final int RULE_SEMI=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_RPARENS=13;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_APPEND=22;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_LTRANS=8;
    public static final int RULE_COMMA=6;
    public static final int RULE_SL_COMMENT=16;
    public static final int RULE_NONE=10;
    public static final int RULE_ML_COMMENT=25;
    public static final int T__30=30;
    public static final int RULE_COLON=7;
    public static final int T__31=31;
    public static final int RULE_STRING=24;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_EM=15;
    public static final int RULE_RTRANS=9;
    public static final int RULE_WS=26;
    public static final int RULE_RCURLY=20;
    public static final int RULE_LCURLY=19;

    // delegates
    // delegators


        public InternalAadl2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAadl2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAadl2Parser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g"; }



     	private Aadl2GrammarAccess grammarAccess;
     	
        public InternalAadl2Parser(TokenStream input, Aadl2GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AadlPackage";	
       	}
       	
       	@Override
       	protected Aadl2GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAadlPackage"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:68:1: entryRuleAadlPackage returns [EObject current=null] : iv_ruleAadlPackage= ruleAadlPackage EOF ;
    public final EObject entryRuleAadlPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAadlPackage = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:69:2: (iv_ruleAadlPackage= ruleAadlPackage EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:70:2: iv_ruleAadlPackage= ruleAadlPackage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAadlPackageRule()); 
            }
            pushFollow(FOLLOW_ruleAadlPackage_in_entryRuleAadlPackage75);
            iv_ruleAadlPackage=ruleAadlPackage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAadlPackage; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlPackage85); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAadlPackage"


    // $ANTLR start "ruleAadlPackage"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:77:1: ruleAadlPackage returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) otherlv_5= 'end' this_ID_6= RULE_ID (otherlv_7= '::' this_ID_8= RULE_ID )* this_SEMI_9= RULE_SEMI ) ;
    public final EObject ruleAadlPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token otherlv_7=null;
        Token this_ID_8=null;
        Token this_SEMI_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedPublicSection_2_0 = null;

        EObject lv_ownedPrivateSection_3_0 = null;

        EObject lv_ownedPrivateSection_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:80:28: ( (otherlv_0= 'package' ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) otherlv_5= 'end' this_ID_6= RULE_ID (otherlv_7= '::' this_ID_8= RULE_ID )* this_SEMI_9= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:81:1: (otherlv_0= 'package' ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) otherlv_5= 'end' this_ID_6= RULE_ID (otherlv_7= '::' this_ID_8= RULE_ID )* this_SEMI_9= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:81:1: (otherlv_0= 'package' ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) otherlv_5= 'end' this_ID_6= RULE_ID (otherlv_7= '::' this_ID_8= RULE_ID )* this_SEMI_9= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:81:3: otherlv_0= 'package' ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) otherlv_5= 'end' this_ID_6= RULE_ID (otherlv_7= '::' this_ID_8= RULE_ID )* this_SEMI_9= RULE_SEMI
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleAadlPackage122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAadlPackageAccess().getPackageKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:85:1: ( (lv_name_1_0= rulePNAME ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:86:1: (lv_name_1_0= rulePNAME )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:86:1: (lv_name_1_0= rulePNAME )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:87:3: lv_name_1_0= rulePNAME
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAadlPackageAccess().getNamePNAMEParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePNAME_in_ruleAadlPackage143);
            lv_name_1_0=rulePNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAadlPackageRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"PNAME");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:103:2: ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==31) ) {
                alt2=1;
            }
            else if ( (LA2_0==33) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:103:3: ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:103:3: ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:103:4: ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )?
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:103:4: ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:104:1: (lv_ownedPublicSection_2_0= rulePublicPackageSection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:104:1: (lv_ownedPublicSection_2_0= rulePublicPackageSection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:105:3: lv_ownedPublicSection_2_0= rulePublicPackageSection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPublicSectionPublicPackageSectionParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePublicPackageSection_in_ruleAadlPackage166);
                    lv_ownedPublicSection_2_0=rulePublicPackageSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAadlPackageRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedPublicSection",
                              		lv_ownedPublicSection_2_0, 
                              		"PublicPackageSection");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:121:2: ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==33) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:122:1: (lv_ownedPrivateSection_3_0= rulePrivatePackageSection )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:122:1: (lv_ownedPrivateSection_3_0= rulePrivatePackageSection )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:123:3: lv_ownedPrivateSection_3_0= rulePrivatePackageSection
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPrivateSectionPrivatePackageSectionParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage187);
                            lv_ownedPrivateSection_3_0=rulePrivatePackageSection();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAadlPackageRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedPrivateSection",
                                      		lv_ownedPrivateSection_3_0, 
                                      		"PrivatePackageSection");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:140:6: ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:140:6: ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:141:1: (lv_ownedPrivateSection_4_0= rulePrivatePackageSection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:141:1: (lv_ownedPrivateSection_4_0= rulePrivatePackageSection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:142:3: lv_ownedPrivateSection_4_0= rulePrivatePackageSection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPrivateSectionPrivatePackageSectionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage216);
                    lv_ownedPrivateSection_4_0=rulePrivatePackageSection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAadlPackageRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedPrivateSection",
                              		lv_ownedPrivateSection_4_0, 
                              		"PrivatePackageSection");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,29,FOLLOW_29_in_ruleAadlPackage229); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAadlPackageAccess().getEndKeyword_3());
                  
            }
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlPackage240); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_6, grammarAccess.getAadlPackageAccess().getIDTerminalRuleCall_4()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:166:1: (otherlv_7= '::' this_ID_8= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==30) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:166:3: otherlv_7= '::' this_ID_8= RULE_ID
            	    {
            	    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleAadlPackage252); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getAadlPackageAccess().getColonColonKeyword_5_0());
            	          
            	    }
            	    this_ID_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlPackage263); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_8, grammarAccess.getAadlPackageAccess().getIDTerminalRuleCall_5_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            this_SEMI_9=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleAadlPackage275); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_9, grammarAccess.getAadlPackageAccess().getSEMITerminalRuleCall_6()); 
                  
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
    // $ANTLR end "ruleAadlPackage"


    // $ANTLR start "entryRulePublicPackageSection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:188:1: entryRulePublicPackageSection returns [EObject current=null] : iv_rulePublicPackageSection= rulePublicPackageSection EOF ;
    public final EObject entryRulePublicPackageSection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublicPackageSection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:189:2: (iv_rulePublicPackageSection= rulePublicPackageSection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:190:2: iv_rulePublicPackageSection= rulePublicPackageSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPublicPackageSectionRule()); 
            }
            pushFollow(FOLLOW_rulePublicPackageSection_in_entryRulePublicPackageSection312);
            iv_rulePublicPackageSection=rulePublicPackageSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePublicPackageSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePublicPackageSection322); if (state.failed) return current;

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
    // $ANTLR end "entryRulePublicPackageSection"


    // $ANTLR start "rulePublicPackageSection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:197:1: rulePublicPackageSection returns [EObject current=null] : ( () otherlv_1= 'public' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) ;
    public final EObject rulePublicPackageSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_COMMA_4=null;
        Token this_SEMI_6=null;
        EObject lv_ownedSystemType_7_0 = null;

        EObject lv_ownedSystemImplementation_8_0 = null;

        EObject lv_ownedProcessorType_9_0 = null;

        EObject lv_ownedDataType_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:200:28: ( ( () otherlv_1= 'public' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:201:1: ( () otherlv_1= 'public' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:201:1: ( () otherlv_1= 'public' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:201:2: () otherlv_1= 'public' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:201:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:202:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPublicPackageSectionAccess().getPublicPackageSectionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_rulePublicPackageSection368); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPublicPackageSectionAccess().getPublicKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:211:1: ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==32) && (synpred1_InternalAadl2())) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:211:2: ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:211:2: ( ( 'with' )=>otherlv_2= 'with' )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:211:3: ( 'with' )=>otherlv_2= 'with'
            	    {
            	    otherlv_2=(Token)match(input,32,FOLLOW_32_in_rulePublicPackageSection389); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getPublicPackageSectionAccess().getWithKeyword_2_0());
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:216:2: ( ( rulePNAME ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:217:1: ( rulePNAME )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:217:1: ( rulePNAME )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:218:3: rulePNAME
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPublicPackageSectionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePNAME_in_rulePublicPackageSection413);
            	    rulePNAME();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:231:2: (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_COMMA) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:231:3: this_COMMA_4= RULE_COMMA ( ( rulePNAME ) )
            	    	    {
            	    	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rulePublicPackageSection425); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_COMMA_4, grammarAccess.getPublicPackageSectionAccess().getCOMMATerminalRuleCall_2_2_0()); 
            	    	          
            	    	    }
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:235:1: ( ( rulePNAME ) )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:236:1: ( rulePNAME )
            	    	    {
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:236:1: ( rulePNAME )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:237:3: rulePNAME
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getPublicPackageSectionRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_2_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_rulePNAME_in_rulePublicPackageSection447);
            	    	    rulePNAME();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);

            	    this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePublicPackageSection460); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SEMI_6, grammarAccess.getPublicPackageSectionAccess().getSEMITerminalRuleCall_2_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:254:3: ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            loop6:
            do {
                int alt6=5;
                switch ( input.LA(1) ) {
                case 47:
                    {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==RULE_ID) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==54) ) {
                        alt6=2;
                    }


                    }
                    break;
                case 44:
                    {
                    alt6=3;
                    }
                    break;
                case 40:
                    {
                    alt6=4;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:254:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:254:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:255:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:255:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:256:3: lv_ownedSystemType_7_0= ruleSystemType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedSystemTypeSystemTypeParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemType_in_rulePublicPackageSection483);
            	    lv_ownedSystemType_7_0=ruleSystemType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPublicPackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSystemType",
            	              		lv_ownedSystemType_7_0, 
            	              		"SystemType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:273:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:273:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:274:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:274:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:275:3: lv_ownedSystemImplementation_8_0= ruleSystemImplementation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedSystemImplementationSystemImplementationParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemImplementation_in_rulePublicPackageSection510);
            	    lv_ownedSystemImplementation_8_0=ruleSystemImplementation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPublicPackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSystemImplementation",
            	              		lv_ownedSystemImplementation_8_0, 
            	              		"SystemImplementation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:292:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:292:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:293:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:293:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:294:3: lv_ownedProcessorType_9_0= ruleProcessorType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedProcessorTypeProcessorTypeParserRuleCall_3_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProcessorType_in_rulePublicPackageSection537);
            	    lv_ownedProcessorType_9_0=ruleProcessorType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPublicPackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedProcessorType",
            	              		lv_ownedProcessorType_9_0, 
            	              		"ProcessorType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:311:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:311:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:312:1: (lv_ownedDataType_10_0= ruleDataType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:312:1: (lv_ownedDataType_10_0= ruleDataType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:313:3: lv_ownedDataType_10_0= ruleDataType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedDataTypeDataTypeParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDataType_in_rulePublicPackageSection564);
            	    lv_ownedDataType_10_0=ruleDataType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPublicPackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedDataType",
            	              		lv_ownedDataType_10_0, 
            	              		"DataType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "rulePublicPackageSection"


    // $ANTLR start "entryRulePrivatePackageSection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:337:1: entryRulePrivatePackageSection returns [EObject current=null] : iv_rulePrivatePackageSection= rulePrivatePackageSection EOF ;
    public final EObject entryRulePrivatePackageSection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivatePackageSection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:338:2: (iv_rulePrivatePackageSection= rulePrivatePackageSection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:339:2: iv_rulePrivatePackageSection= rulePrivatePackageSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivatePackageSectionRule()); 
            }
            pushFollow(FOLLOW_rulePrivatePackageSection_in_entryRulePrivatePackageSection602);
            iv_rulePrivatePackageSection=rulePrivatePackageSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivatePackageSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrivatePackageSection612); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrivatePackageSection"


    // $ANTLR start "rulePrivatePackageSection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:346:1: rulePrivatePackageSection returns [EObject current=null] : ( () otherlv_1= 'private' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) ;
    public final EObject rulePrivatePackageSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_COMMA_4=null;
        Token this_SEMI_6=null;
        EObject lv_ownedSystemType_7_0 = null;

        EObject lv_ownedSystemImplementation_8_0 = null;

        EObject lv_ownedProcessorType_9_0 = null;

        EObject lv_ownedDataType_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:349:28: ( ( () otherlv_1= 'private' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:350:1: ( () otherlv_1= 'private' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:350:1: ( () otherlv_1= 'private' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:350:2: () otherlv_1= 'private' ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:350:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:351:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrivatePackageSectionAccess().getPrivatePackageSectionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,33,FOLLOW_33_in_rulePrivatePackageSection658); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPrivatePackageSectionAccess().getPrivateKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:360:1: ( ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==32) && (synpred2_InternalAadl2())) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:360:2: ( ( 'with' )=>otherlv_2= 'with' ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:360:2: ( ( 'with' )=>otherlv_2= 'with' )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:360:3: ( 'with' )=>otherlv_2= 'with'
            	    {
            	    otherlv_2=(Token)match(input,32,FOLLOW_32_in_rulePrivatePackageSection679); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getPrivatePackageSectionAccess().getWithKeyword_2_0());
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:365:2: ( ( rulePNAME ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:366:1: ( rulePNAME )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:366:1: ( rulePNAME )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:367:3: rulePNAME
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPrivatePackageSectionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePNAME_in_rulePrivatePackageSection703);
            	    rulePNAME();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:380:2: (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==RULE_COMMA) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:380:3: this_COMMA_4= RULE_COMMA ( ( rulePNAME ) )
            	    	    {
            	    	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rulePrivatePackageSection715); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_COMMA_4, grammarAccess.getPrivatePackageSectionAccess().getCOMMATerminalRuleCall_2_2_0()); 
            	    	          
            	    	    }
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:384:1: ( ( rulePNAME ) )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:385:1: ( rulePNAME )
            	    	    {
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:385:1: ( rulePNAME )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:386:3: rulePNAME
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getPrivatePackageSectionRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_2_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_rulePNAME_in_rulePrivatePackageSection737);
            	    	    rulePNAME();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        afterParserOrEnumRuleCall();
            	    	      	    
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);

            	    this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePrivatePackageSection750); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SEMI_6, grammarAccess.getPrivatePackageSectionAccess().getSEMITerminalRuleCall_2_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:403:3: ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            loop9:
            do {
                int alt9=5;
                switch ( input.LA(1) ) {
                case 47:
                    {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==RULE_ID) ) {
                        alt9=1;
                    }
                    else if ( (LA9_2==54) ) {
                        alt9=2;
                    }


                    }
                    break;
                case 44:
                    {
                    alt9=3;
                    }
                    break;
                case 40:
                    {
                    alt9=4;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:403:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:403:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:404:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:404:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:405:3: lv_ownedSystemType_7_0= ruleSystemType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedSystemTypeSystemTypeParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemType_in_rulePrivatePackageSection773);
            	    lv_ownedSystemType_7_0=ruleSystemType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrivatePackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSystemType",
            	              		lv_ownedSystemType_7_0, 
            	              		"SystemType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:422:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:422:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:423:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:423:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:424:3: lv_ownedSystemImplementation_8_0= ruleSystemImplementation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedSystemImplementationSystemImplementationParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemImplementation_in_rulePrivatePackageSection800);
            	    lv_ownedSystemImplementation_8_0=ruleSystemImplementation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrivatePackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSystemImplementation",
            	              		lv_ownedSystemImplementation_8_0, 
            	              		"SystemImplementation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:441:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:441:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:442:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:442:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:443:3: lv_ownedProcessorType_9_0= ruleProcessorType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedProcessorTypeProcessorTypeParserRuleCall_3_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProcessorType_in_rulePrivatePackageSection827);
            	    lv_ownedProcessorType_9_0=ruleProcessorType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrivatePackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedProcessorType",
            	              		lv_ownedProcessorType_9_0, 
            	              		"ProcessorType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:460:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:460:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:461:1: (lv_ownedDataType_10_0= ruleDataType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:461:1: (lv_ownedDataType_10_0= ruleDataType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:462:3: lv_ownedDataType_10_0= ruleDataType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedDataTypeDataTypeParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDataType_in_rulePrivatePackageSection854);
            	    lv_ownedDataType_10_0=ruleDataType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrivatePackageSectionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedDataType",
            	              		lv_ownedDataType_10_0, 
            	              		"DataType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "rulePrivatePackageSection"


    // $ANTLR start "entryRuleFlowSpecification"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:490:1: entryRuleFlowSpecification returns [EObject current=null] : iv_ruleFlowSpecification= ruleFlowSpecification EOF ;
    public final EObject entryRuleFlowSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecification = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:491:2: (iv_ruleFlowSpecification= ruleFlowSpecification EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:492:2: iv_ruleFlowSpecification= ruleFlowSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSpecification_in_entryRuleFlowSpecification896);
            iv_ruleFlowSpecification=ruleFlowSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecification906); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFlowSpecification"


    // $ANTLR start "ruleFlowSpecification"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:499:1: ruleFlowSpecification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowKind ) ) ( (otherlv_4= RULE_ID ) ) ( ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) ) )? this_SEMI_7= RULE_SEMI ) ;
    public final EObject ruleFlowSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_SEMI_7=null;
        Enumerator lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:502:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowKind ) ) ( (otherlv_4= RULE_ID ) ) ( ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) ) )? this_SEMI_7= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:503:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowKind ) ) ( (otherlv_4= RULE_ID ) ) ( ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) ) )? this_SEMI_7= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:503:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowKind ) ) ( (otherlv_4= RULE_ID ) ) ( ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) ) )? this_SEMI_7= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:503:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowKind ) ) ( (otherlv_4= RULE_ID ) ) ( ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) ) )? this_SEMI_7= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:503:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:504:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:504:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:505:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecification948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFlowSpecificationAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSpecificationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSpecification964); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSpecificationAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleFlowSpecification975); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:529:1: ( (lv_kind_3_0= ruleFlowKind ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:530:1: (lv_kind_3_0= ruleFlowKind )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:530:1: (lv_kind_3_0= ruleFlowKind )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:531:3: lv_kind_3_0= ruleFlowKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSpecificationAccess().getKindFlowKindEnumRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowKind_in_ruleFlowSpecification996);
            lv_kind_3_0=ruleFlowKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_3_0, 
                      		"FlowKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:547:2: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:548:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:548:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:549:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSpecificationRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecification1016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationAccess().getInFeatureFeatureCrossReference_4_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:560:2: ( ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==35) && (synpred3_InternalAadl2())) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:560:3: ( ( '->' )=>otherlv_5= '->' ) ( (otherlv_6= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:560:3: ( ( '->' )=>otherlv_5= '->' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:560:4: ( '->' )=>otherlv_5= '->'
                    {
                    otherlv_5=(Token)match(input,35,FOLLOW_35_in_ruleFlowSpecification1037); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getFlowSpecificationAccess().getHyphenMinusGreaterThanSignKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:565:2: ( (otherlv_6= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:566:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:566:1: (otherlv_6= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:567:3: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowSpecificationRule());
                      	        }
                              
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecification1058); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationAccess().getOutFeatureFeatureCrossReference_5_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            this_SEMI_7=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFlowSpecification1071); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_7, grammarAccess.getFlowSpecificationAccess().getSEMITerminalRuleCall_6()); 
                  
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
    // $ANTLR end "ruleFlowSpecification"


    // $ANTLR start "entryRuleMode"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:590:1: entryRuleMode returns [EObject current=null] : iv_ruleMode= ruleMode EOF ;
    public final EObject entryRuleMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMode = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:591:2: (iv_ruleMode= ruleMode EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:592:2: iv_ruleMode= ruleMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeRule()); 
            }
            pushFollow(FOLLOW_ruleMode_in_entryRuleMode1106);
            iv_ruleMode=ruleMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMode; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMode1116); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMode"


    // $ANTLR start "ruleMode"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:599:1: ruleMode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleMode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token lv_initial_2_0=null;
        Token otherlv_3=null;
        Token this_SEMI_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:602:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:603:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:603:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:603:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:603:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:604:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:604:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:605:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMode1158); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getModeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getModeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleMode1174); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getModeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:625:1: ( (lv_initial_2_0= 'initial' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==36) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:626:1: (lv_initial_2_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:626:1: (lv_initial_2_0= 'initial' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:627:3: lv_initial_2_0= 'initial'
                    {
                    lv_initial_2_0=(Token)match(input,36,FOLLOW_36_in_ruleMode1191); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_initial_2_0, grammarAccess.getModeAccess().getInitialInitialKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getModeRule());
                      	        }
                             		setWithLastConsumed(current, "initial", true, "initial");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleMode1217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModeAccess().getModeKeyword_3());
                  
            }
            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleMode1228); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getModeAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleMode"


    // $ANTLR start "entryRuleModeTransition"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:656:1: entryRuleModeTransition returns [EObject current=null] : iv_ruleModeTransition= ruleModeTransition EOF ;
    public final EObject entryRuleModeTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransition = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:657:2: (iv_ruleModeTransition= ruleModeTransition EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:658:2: iv_ruleModeTransition= ruleModeTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeTransitionRule()); 
            }
            pushFollow(FOLLOW_ruleModeTransition_in_entryRuleModeTransition1263);
            iv_ruleModeTransition=ruleModeTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeTransition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransition1273); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModeTransition"


    // $ANTLR start "ruleModeTransition"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:665:1: ruleModeTransition returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI ) ;
    public final EObject ruleModeTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_LTRANS_3=null;
        Token this_COMMA_5=null;
        Token this_RTRANS_7=null;
        Token otherlv_8=null;
        Token this_SEMI_9=null;
        EObject lv_ownedTrigger_4_0 = null;

        EObject lv_ownedTrigger_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:668:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:2: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:2: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_COLON) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:3: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:670:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:670:1: (lv_name_0_0= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:671:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition1316); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getModeTransitionAccess().getNameIDTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getModeTransitionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleModeTransition1332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COLON_1, grammarAccess.getModeTransitionAccess().getCOLONTerminalRuleCall_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:691:3: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:692:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:692:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:693:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeTransitionRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition1353); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getModeTransitionAccess().getSourceModeCrossReference_1_0()); 
              	
            }

            }


            }

            this_LTRANS_3=(Token)match(input,RULE_LTRANS,FOLLOW_RULE_LTRANS_in_ruleModeTransition1364); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LTRANS_3, grammarAccess.getModeTransitionAccess().getLTRANSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:708:1: ( (lv_ownedTrigger_4_0= ruleTriggerPort ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:709:1: (lv_ownedTrigger_4_0= ruleTriggerPort )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:709:1: (lv_ownedTrigger_4_0= ruleTriggerPort )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:710:3: lv_ownedTrigger_4_0= ruleTriggerPort
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedTriggerTriggerPortParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerPort_in_ruleModeTransition1384);
            lv_ownedTrigger_4_0=ruleTriggerPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModeTransitionRule());
              	        }
                     		add(
                     			current, 
                     			"ownedTrigger",
                      		lv_ownedTrigger_4_0, 
                      		"TriggerPort");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:726:2: (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_COMMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:726:3: this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) )
            	    {
            	    this_COMMA_5=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleModeTransition1396); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_5, grammarAccess.getModeTransitionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:730:1: ( (lv_ownedTrigger_6_0= ruleTriggerPort ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:731:1: (lv_ownedTrigger_6_0= ruleTriggerPort )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:731:1: (lv_ownedTrigger_6_0= ruleTriggerPort )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:732:3: lv_ownedTrigger_6_0= ruleTriggerPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedTriggerTriggerPortParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTriggerPort_in_ruleModeTransition1416);
            	    lv_ownedTrigger_6_0=ruleTriggerPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModeTransitionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedTrigger",
            	              		lv_ownedTrigger_6_0, 
            	              		"TriggerPort");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            this_RTRANS_7=(Token)match(input,RULE_RTRANS,FOLLOW_RULE_RTRANS_in_ruleModeTransition1429); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RTRANS_7, grammarAccess.getModeTransitionAccess().getRTRANSTerminalRuleCall_5()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:752:1: ( (otherlv_8= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:753:1: (otherlv_8= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:753:1: (otherlv_8= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:754:3: otherlv_8= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeTransitionRule());
              	        }
                      
            }
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition1448); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_8, grammarAccess.getModeTransitionAccess().getDestinationModeCrossReference_6_0()); 
              	
            }

            }


            }

            this_SEMI_9=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleModeTransition1459); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_9, grammarAccess.getModeTransitionAccess().getSEMITerminalRuleCall_7()); 
                  
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
    // $ANTLR end "ruleModeTransition"


    // $ANTLR start "entryRuleTriggerPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:777:1: entryRuleTriggerPort returns [EObject current=null] : iv_ruleTriggerPort= ruleTriggerPort EOF ;
    public final EObject entryRuleTriggerPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:778:2: (iv_ruleTriggerPort= ruleTriggerPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:779:2: iv_ruleTriggerPort= ruleTriggerPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggerPortRule()); 
            }
            pushFollow(FOLLOW_ruleTriggerPort_in_entryRuleTriggerPort1494);
            iv_ruleTriggerPort=ruleTriggerPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggerPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerPort1504); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTriggerPort"


    // $ANTLR start "ruleTriggerPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:786:1: ruleTriggerPort returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleTriggerPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:789:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:790:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:790:1: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:791:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:791:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:792:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTriggerPortRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggerPort1548); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getTriggerPortAccess().getPortPortCrossReference_0()); 
              	
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
    // $ANTLR end "ruleTriggerPort"


    // $ANTLR start "entryRuleComponentCategoryKW"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:811:1: entryRuleComponentCategoryKW returns [String current=null] : iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF ;
    public final String entryRuleComponentCategoryKW() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategoryKW = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:812:2: (iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:813:2: iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentCategoryKWRule()); 
            }
            pushFollow(FOLLOW_ruleComponentCategoryKW_in_entryRuleComponentCategoryKW1584);
            iv_ruleComponentCategoryKW=ruleComponentCategoryKW();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentCategoryKW.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategoryKW1595); if (state.failed) return current;

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
    // $ANTLR end "entryRuleComponentCategoryKW"


    // $ANTLR start "ruleComponentCategoryKW"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:820:1: ruleComponentCategoryKW returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategoryKW() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:823:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:824:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:824:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt14=13;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:825:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleComponentCategoryKW1633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getAbstractKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:832:2: kw= 'bus'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleComponentCategoryKW1652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getBusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:839:2: kw= 'data'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleComponentCategoryKW1671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getDataKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:846:2: kw= 'device'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleComponentCategoryKW1690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:853:2: kw= 'memory'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleComponentCategoryKW1709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getMemoryKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:860:2: kw= 'process'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleComponentCategoryKW1728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:867:2: kw= 'processor'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategoryKW1747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessorKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:873:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:873:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:874:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleComponentCategoryKW1767); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getSubprogramKeyword_7_0()); 
                          
                    }
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategoryKW1780); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getGroupKeyword_7_1()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:887:2: kw= 'system'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategoryKW1800); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getSystemKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:893:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:893:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:894:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleComponentCategoryKW1820); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getThreadKeyword_9_0()); 
                          
                    }
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategoryKW1833); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getGroupKeyword_9_1()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:907:2: kw= 'thread'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleComponentCategoryKW1853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getThreadKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:913:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:913:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:914:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategoryKW1873); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getVirtualKeyword_11_0()); 
                          
                    }
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleComponentCategoryKW1886); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getBusKeyword_11_1()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:926:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:926:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:927:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategoryKW1907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getVirtualKeyword_12_0()); 
                          
                    }
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategoryKW1920); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessorKeyword_12_1()); 
                          
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
    // $ANTLR end "ruleComponentCategoryKW"


    // $ANTLR start "entryRuleSystemType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:946:1: entryRuleSystemType returns [EObject current=null] : iv_ruleSystemType= ruleSystemType EOF ;
    public final EObject entryRuleSystemType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:947:2: (iv_ruleSystemType= ruleSystemType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:948:2: iv_ruleSystemType= ruleSystemType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSystemType_in_entryRuleSystemType1961);
            iv_ruleSystemType=ruleSystemType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemType1971); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSystemType"


    // $ANTLR start "ruleSystemType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:955:1: ruleSystemType returns [EObject current=null] : (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI ) ;
    public final EObject ruleSystemType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_noPrototypes_3_0=null;
        Token otherlv_5=null;
        Token lv_noFeatures_6_0=null;
        Token otherlv_10=null;
        Token lv_noFlows_12_0=null;
        Token otherlv_13=null;
        Token lv_noModes_16_0=null;
        Token otherlv_18=null;
        Token this_ID_19=null;
        Token this_SEMI_20=null;
        EObject lv_ownedPrototype_4_0 = null;

        EObject lv_ownedDataPort_7_0 = null;

        EObject lv_ownedEventPort_8_0 = null;

        EObject lv_ownedEventDataPort_9_0 = null;

        EObject lv_ownedFlowSpecification_11_0 = null;

        EObject lv_ownedMode_14_0 = null;

        EObject lv_ownedModeTransition_15_0 = null;

        EObject lv_ownedAnnexSubclause_17_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:958:28: ( (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:959:1: (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:959:1: (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:959:3: otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleSystemType2008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemTypeAccess().getSystemKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:963:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:964:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:964:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:965:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemType2025); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getSystemTypeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSystemTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:2: ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) && (synpred4_InternalAadl2())) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:3: ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:3: ( ( 'prototypes' )=>otherlv_2= 'prototypes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:4: ( 'prototypes' )=>otherlv_2= 'prototypes'
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleSystemType2051); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSystemTypeAccess().getPrototypesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:986:2: ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_NONE) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==RULE_ID) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:986:3: ( (lv_noPrototypes_3_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:986:3: ( (lv_noPrototypes_3_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:987:1: (lv_noPrototypes_3_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:987:1: (lv_noPrototypes_3_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:988:3: lv_noPrototypes_3_0= RULE_NONE
                            {
                            lv_noPrototypes_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType2070); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noPrototypes_3_0, grammarAccess.getSystemTypeAccess().getNoPrototypesNONETerminalRuleCall_2_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noPrototypes",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1005:6: ( (lv_ownedPrototype_4_0= rulePrototype ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1005:6: ( (lv_ownedPrototype_4_0= rulePrototype ) )+
                            int cnt15=0;
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==RULE_ID) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1006:1: (lv_ownedPrototype_4_0= rulePrototype )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1006:1: (lv_ownedPrototype_4_0= rulePrototype )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1007:3: lv_ownedPrototype_4_0= rulePrototype
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedPrototypePrototypeParserRuleCall_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_rulePrototype_in_ruleSystemType2102);
                            	    lv_ownedPrototype_4_0=rulePrototype();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPrototype",
                            	              		lv_ownedPrototype_4_0, 
                            	              		"Prototype");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt15 >= 1 ) break loop15;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(15, input);
                                        throw eee;
                                }
                                cnt15++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1023:6: ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==51) && (synpred5_InternalAadl2())) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1023:7: ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1023:7: ( ( 'features' )=>otherlv_5= 'features' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1023:8: ( 'features' )=>otherlv_5= 'features'
                    {
                    otherlv_5=(Token)match(input,51,FOLLOW_51_in_ruleSystemType2127); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSystemTypeAccess().getFeaturesKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1028:2: ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_NONE) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==RULE_ID) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1028:3: ( (lv_noFeatures_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1028:3: ( (lv_noFeatures_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1029:1: (lv_noFeatures_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1029:1: (lv_noFeatures_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1030:3: lv_noFeatures_6_0= RULE_NONE
                            {
                            lv_noFeatures_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType2146); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noFeatures_6_0, grammarAccess.getSystemTypeAccess().getNoFeaturesNONETerminalRuleCall_3_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noFeatures",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1047:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1047:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+
                            int cnt18=0;
                            loop18:
                            do {
                                int alt18=4;
                                alt18 = dfa18.predict(input);
                                switch (alt18) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1047:7: ( (lv_ownedDataPort_7_0= ruleDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1047:7: ( (lv_ownedDataPort_7_0= ruleDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1048:1: (lv_ownedDataPort_7_0= ruleDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1048:1: (lv_ownedDataPort_7_0= ruleDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1049:3: lv_ownedDataPort_7_0= ruleDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedDataPortDataPortParserRuleCall_3_1_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataPort_in_ruleSystemType2179);
                            	    lv_ownedDataPort_7_0=ruleDataPort();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedDataPort",
                            	              		lv_ownedDataPort_7_0, 
                            	              		"DataPort");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1066:6: ( (lv_ownedEventPort_8_0= ruleEventPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1066:6: ( (lv_ownedEventPort_8_0= ruleEventPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1067:1: (lv_ownedEventPort_8_0= ruleEventPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1067:1: (lv_ownedEventPort_8_0= ruleEventPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1068:3: lv_ownedEventPort_8_0= ruleEventPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedEventPortEventPortParserRuleCall_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventPort_in_ruleSystemType2206);
                            	    lv_ownedEventPort_8_0=ruleEventPort();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedEventPort",
                            	              		lv_ownedEventPort_8_0, 
                            	              		"EventPort");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 3 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1085:6: ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1085:6: ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1086:1: (lv_ownedEventDataPort_9_0= ruleEventDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1086:1: (lv_ownedEventDataPort_9_0= ruleEventDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1087:3: lv_ownedEventDataPort_9_0= ruleEventDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedEventDataPortEventDataPortParserRuleCall_3_1_1_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventDataPort_in_ruleSystemType2233);
                            	    lv_ownedEventDataPort_9_0=ruleEventDataPort();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedEventDataPort",
                            	              		lv_ownedEventDataPort_9_0, 
                            	              		"EventDataPort");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt18 >= 1 ) break loop18;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(18, input);
                                        throw eee;
                                }
                                cnt18++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1103:7: ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==52) && (synpred6_InternalAadl2())) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1103:8: ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1103:8: ( ( 'flows' )=>otherlv_10= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1103:9: ( 'flows' )=>otherlv_10= 'flows'
                    {
                    otherlv_10=(Token)match(input,52,FOLLOW_52_in_ruleSystemType2259); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSystemTypeAccess().getFlowsKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1108:2: ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==RULE_ID) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==RULE_NONE) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1108:3: ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1108:3: ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+
                            int cnt21=0;
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==RULE_ID) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1109:1: (lv_ownedFlowSpecification_11_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1109:1: (lv_ownedFlowSpecification_11_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1110:3: lv_ownedFlowSpecification_11_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_4_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleSystemType2282);
                            	    lv_ownedFlowSpecification_11_0=ruleFlowSpecification();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedFlowSpecification",
                            	              		lv_ownedFlowSpecification_11_0, 
                            	              		"FlowSpecification");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt21 >= 1 ) break loop21;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(21, input);
                                        throw eee;
                                }
                                cnt21++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1127:6: ( (lv_noFlows_12_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1127:6: ( (lv_noFlows_12_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1128:1: (lv_noFlows_12_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1128:1: (lv_noFlows_12_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1129:3: lv_noFlows_12_0= RULE_NONE
                            {
                            lv_noFlows_12_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType2306); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noFlows_12_0, grammarAccess.getSystemTypeAccess().getNoFlowsNONETerminalRuleCall_4_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noFlows",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:5: ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )?
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==53) && (synpred7_InternalAadl2())) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_NONE) ) {
                alt25=2;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:6: ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:6: ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:7: ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:7: ( ( 'modes' )=>otherlv_13= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:8: ( 'modes' )=>otherlv_13= 'modes'
                    {
                    otherlv_13=(Token)match(input,53,FOLLOW_53_in_ruleSystemType2336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSystemTypeAccess().getModesKeyword_5_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1150:2: ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=3;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            int LA24_2 = input.LA(2);

                            if ( (LA24_2==RULE_COLON) ) {
                                int LA24_3 = input.LA(3);

                                if ( (LA24_3==RULE_ID) ) {
                                    alt24=2;
                                }
                                else if ( ((LA24_3>=36 && LA24_3<=37)) ) {
                                    alt24=1;
                                }


                            }
                            else if ( (LA24_2==RULE_LTRANS) ) {
                                alt24=2;
                            }


                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1150:3: ( (lv_ownedMode_14_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1150:3: ( (lv_ownedMode_14_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1151:1: (lv_ownedMode_14_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1151:1: (lv_ownedMode_14_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1152:3: lv_ownedMode_14_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedModeModeParserRuleCall_5_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleSystemType2359);
                    	    lv_ownedMode_14_0=ruleMode();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedMode",
                    	              		lv_ownedMode_14_0, 
                    	              		"Mode");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1169:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1169:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1170:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1170:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1171:3: lv_ownedModeTransition_15_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_5_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleSystemType2386);
                    	    lv_ownedModeTransition_15_0=ruleModeTransition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedModeTransition",
                    	              		lv_ownedModeTransition_15_0, 
                    	              		"ModeTransition");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1188:6: ( (lv_noModes_16_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1188:6: ( (lv_noModes_16_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1189:1: (lv_noModes_16_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1189:1: (lv_noModes_16_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1190:3: lv_noModes_16_0= RULE_NONE
                    {
                    lv_noModes_16_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType2412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_noModes_16_0, grammarAccess.getSystemTypeAccess().getNoModesNONETerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSystemTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"noModes",
                              		true, 
                              		"NONE");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1206:4: ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==66) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1207:1: (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1207:1: (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1208:3: lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleSystemType2440);
            	    lv_ownedAnnexSubclause_17_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedAnnexSubclause",
            	              		lv_ownedAnnexSubclause_17_0, 
            	              		"AnnexSubclause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_18=(Token)match(input,29,FOLLOW_29_in_ruleSystemType2453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_18, grammarAccess.getSystemTypeAccess().getEndKeyword_7());
                  
            }
            this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemType2464); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_19, grammarAccess.getSystemTypeAccess().getIDTerminalRuleCall_8()); 
                  
            }
            this_SEMI_20=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemType2474); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_20, grammarAccess.getSystemTypeAccess().getSEMITerminalRuleCall_9()); 
                  
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
    // $ANTLR end "ruleSystemType"


    // $ANTLR start "entryRuleProcessorType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1248:1: entryRuleProcessorType returns [EObject current=null] : iv_ruleProcessorType= ruleProcessorType EOF ;
    public final EObject entryRuleProcessorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessorType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1249:2: (iv_ruleProcessorType= ruleProcessorType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1250:2: iv_ruleProcessorType= ruleProcessorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessorTypeRule()); 
            }
            pushFollow(FOLLOW_ruleProcessorType_in_entryRuleProcessorType2513);
            iv_ruleProcessorType=ruleProcessorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessorType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcessorType2523); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProcessorType"


    // $ANTLR start "ruleProcessorType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1257:1: ruleProcessorType returns [EObject current=null] : (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI ) ;
    public final EObject ruleProcessorType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_noFeatures_3_0=null;
        Token otherlv_7=null;
        Token lv_noFlows_9_0=null;
        Token otherlv_10=null;
        Token lv_noModes_13_0=null;
        Token otherlv_15=null;
        Token this_ID_16=null;
        Token this_SEMI_17=null;
        EObject lv_ownedDataPort_4_0 = null;

        EObject lv_ownedEventPort_5_0 = null;

        EObject lv_ownedEventDataPort_6_0 = null;

        EObject lv_ownedFlowSpecification_8_0 = null;

        EObject lv_ownedMode_11_0 = null;

        EObject lv_ownedModeTransition_12_0 = null;

        EObject lv_ownedAnnexSubclause_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1260:28: ( (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1261:1: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1261:1: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1261:3: otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleProcessorType2560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProcessorTypeAccess().getProcessorKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1265:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1266:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1266:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1267:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorType2577); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getProcessorTypeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getProcessorTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1283:2: ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==51) && (synpred8_InternalAadl2())) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1283:3: ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1283:3: ( ( 'features' )=>otherlv_2= 'features' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1283:4: ( 'features' )=>otherlv_2= 'features'
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleProcessorType2603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getProcessorTypeAccess().getFeaturesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1288:2: ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_NONE) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==RULE_ID) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1288:3: ( (lv_noFeatures_3_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1288:3: ( (lv_noFeatures_3_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1289:1: (lv_noFeatures_3_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1289:1: (lv_noFeatures_3_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1290:3: lv_noFeatures_3_0= RULE_NONE
                            {
                            lv_noFeatures_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2622); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noFeatures_3_0, grammarAccess.getProcessorTypeAccess().getNoFeaturesNONETerminalRuleCall_2_1_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getProcessorTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noFeatures",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1307:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1307:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+
                            int cnt27=0;
                            loop27:
                            do {
                                int alt27=4;
                                alt27 = dfa27.predict(input);
                                switch (alt27) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1307:7: ( (lv_ownedDataPort_4_0= ruleDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1307:7: ( (lv_ownedDataPort_4_0= ruleDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1308:1: (lv_ownedDataPort_4_0= ruleDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1308:1: (lv_ownedDataPort_4_0= ruleDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1309:3: lv_ownedDataPort_4_0= ruleDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedDataPortDataPortParserRuleCall_2_1_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataPort_in_ruleProcessorType2655);
                            	    lv_ownedDataPort_4_0=ruleDataPort();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedDataPort",
                            	              		lv_ownedDataPort_4_0, 
                            	              		"DataPort");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1326:6: ( (lv_ownedEventPort_5_0= ruleEventPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1326:6: ( (lv_ownedEventPort_5_0= ruleEventPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1327:1: (lv_ownedEventPort_5_0= ruleEventPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1327:1: (lv_ownedEventPort_5_0= ruleEventPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1328:3: lv_ownedEventPort_5_0= ruleEventPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedEventPortEventPortParserRuleCall_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventPort_in_ruleProcessorType2682);
                            	    lv_ownedEventPort_5_0=ruleEventPort();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedEventPort",
                            	              		lv_ownedEventPort_5_0, 
                            	              		"EventPort");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 3 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1345:6: ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1345:6: ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1346:1: (lv_ownedEventDataPort_6_0= ruleEventDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1346:1: (lv_ownedEventDataPort_6_0= ruleEventDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1347:3: lv_ownedEventDataPort_6_0= ruleEventDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedEventDataPortEventDataPortParserRuleCall_2_1_1_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventDataPort_in_ruleProcessorType2709);
                            	    lv_ownedEventDataPort_6_0=ruleEventDataPort();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedEventDataPort",
                            	              		lv_ownedEventDataPort_6_0, 
                            	              		"EventDataPort");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt27 >= 1 ) break loop27;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(27, input);
                                        throw eee;
                                }
                                cnt27++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:7: ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==52) && (synpred9_InternalAadl2())) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:8: ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:8: ( ( 'flows' )=>otherlv_7= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:9: ( 'flows' )=>otherlv_7= 'flows'
                    {
                    otherlv_7=(Token)match(input,52,FOLLOW_52_in_ruleProcessorType2735); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getProcessorTypeAccess().getFlowsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1368:2: ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_ID) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RULE_NONE) ) {
                        alt31=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1368:3: ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1368:3: ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+
                            int cnt30=0;
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==RULE_ID) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1369:1: (lv_ownedFlowSpecification_8_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1369:1: (lv_ownedFlowSpecification_8_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1370:3: lv_ownedFlowSpecification_8_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleProcessorType2758);
                            	    lv_ownedFlowSpecification_8_0=ruleFlowSpecification();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedFlowSpecification",
                            	              		lv_ownedFlowSpecification_8_0, 
                            	              		"FlowSpecification");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt30 >= 1 ) break loop30;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(30, input);
                                        throw eee;
                                }
                                cnt30++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1387:6: ( (lv_noFlows_9_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1387:6: ( (lv_noFlows_9_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1388:1: (lv_noFlows_9_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1388:1: (lv_noFlows_9_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1389:3: lv_noFlows_9_0= RULE_NONE
                            {
                            lv_noFlows_9_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2782); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noFlows_9_0, grammarAccess.getProcessorTypeAccess().getNoFlowsNONETerminalRuleCall_3_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getProcessorTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noFlows",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:5: ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==53) && (synpred10_InternalAadl2())) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_NONE) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:6: ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:6: ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:7: ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:7: ( ( 'modes' )=>otherlv_10= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:8: ( 'modes' )=>otherlv_10= 'modes'
                    {
                    otherlv_10=(Token)match(input,53,FOLLOW_53_in_ruleProcessorType2812); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getProcessorTypeAccess().getModesKeyword_4_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1410:2: ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=3;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            int LA33_2 = input.LA(2);

                            if ( (LA33_2==RULE_COLON) ) {
                                int LA33_3 = input.LA(3);

                                if ( ((LA33_3>=36 && LA33_3<=37)) ) {
                                    alt33=1;
                                }
                                else if ( (LA33_3==RULE_ID) ) {
                                    alt33=2;
                                }


                            }
                            else if ( (LA33_2==RULE_LTRANS) ) {
                                alt33=2;
                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1410:3: ( (lv_ownedMode_11_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1410:3: ( (lv_ownedMode_11_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1411:1: (lv_ownedMode_11_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1411:1: (lv_ownedMode_11_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1412:3: lv_ownedMode_11_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedModeModeParserRuleCall_4_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleProcessorType2835);
                    	    lv_ownedMode_11_0=ruleMode();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedMode",
                    	              		lv_ownedMode_11_0, 
                    	              		"Mode");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1429:6: ( (lv_ownedModeTransition_12_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1429:6: ( (lv_ownedModeTransition_12_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1430:1: (lv_ownedModeTransition_12_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1430:1: (lv_ownedModeTransition_12_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1431:3: lv_ownedModeTransition_12_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_4_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleProcessorType2862);
                    	    lv_ownedModeTransition_12_0=ruleModeTransition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedModeTransition",
                    	              		lv_ownedModeTransition_12_0, 
                    	              		"ModeTransition");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1448:6: ( (lv_noModes_13_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1448:6: ( (lv_noModes_13_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1449:1: (lv_noModes_13_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1449:1: (lv_noModes_13_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1450:3: lv_noModes_13_0= RULE_NONE
                    {
                    lv_noModes_13_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2888); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_noModes_13_0, grammarAccess.getProcessorTypeAccess().getNoModesNONETerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getProcessorTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"noModes",
                              		true, 
                              		"NONE");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1466:4: ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==66) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1467:1: (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1467:1: (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1468:3: lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleProcessorType2916);
            	    lv_ownedAnnexSubclause_14_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedAnnexSubclause",
            	              		lv_ownedAnnexSubclause_14_0, 
            	              		"AnnexSubclause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            otherlv_15=(Token)match(input,29,FOLLOW_29_in_ruleProcessorType2929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getProcessorTypeAccess().getEndKeyword_6());
                  
            }
            this_ID_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorType2940); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_16, grammarAccess.getProcessorTypeAccess().getIDTerminalRuleCall_7()); 
                  
            }
            this_SEMI_17=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleProcessorType2950); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_17, grammarAccess.getProcessorTypeAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // $ANTLR end "ruleProcessorType"


    // $ANTLR start "entryRuleDataType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1504:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1505:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1506:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType2985);
            iv_ruleDataType=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType2995); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1513:1: ruleDataType returns [EObject current=null] : (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_noFeatures_3_0=null;
        Token otherlv_4=null;
        Token lv_noFlows_6_0=null;
        Token otherlv_7=null;
        Token lv_noModes_10_0=null;
        Token otherlv_12=null;
        Token this_ID_13=null;
        Token this_SEMI_14=null;
        EObject lv_ownedFlowSpecification_5_0 = null;

        EObject lv_ownedMode_8_0 = null;

        EObject lv_ownedModeTransition_9_0 = null;

        EObject lv_ownedAnnexSubclause_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1516:28: ( (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1517:1: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1517:1: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1517:3: otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleDataType3032); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDataTypeAccess().getDataKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1521:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1522:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1522:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1523:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType3049); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDataTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1539:2: ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==51) && (synpred11_InternalAadl2())) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1539:3: ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1539:3: ( ( 'features' )=>otherlv_2= 'features' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1539:4: ( 'features' )=>otherlv_2= 'features'
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleDataType3075); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDataTypeAccess().getFeaturesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1544:2: ( (lv_noFeatures_3_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1545:1: (lv_noFeatures_3_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1545:1: (lv_noFeatures_3_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1546:3: lv_noFeatures_3_0= RULE_NONE
                    {
                    lv_noFeatures_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType3093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_noFeatures_3_0, grammarAccess.getDataTypeAccess().getNoFeaturesNONETerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"noFeatures",
                              		true, 
                              		"NONE");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1562:4: ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==52) && (synpred12_InternalAadl2())) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1562:5: ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1562:5: ( ( 'flows' )=>otherlv_4= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1562:6: ( 'flows' )=>otherlv_4= 'flows'
                    {
                    otherlv_4=(Token)match(input,52,FOLLOW_52_in_ruleDataType3121); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDataTypeAccess().getFlowsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1567:2: ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==RULE_NONE) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1567:3: ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1567:3: ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+
                            int cnt37=0;
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==RULE_ID) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1568:1: (lv_ownedFlowSpecification_5_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1568:1: (lv_ownedFlowSpecification_5_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1569:3: lv_ownedFlowSpecification_5_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleDataType3144);
                            	    lv_ownedFlowSpecification_5_0=ruleFlowSpecification();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedFlowSpecification",
                            	              		lv_ownedFlowSpecification_5_0, 
                            	              		"FlowSpecification");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt37 >= 1 ) break loop37;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(37, input);
                                        throw eee;
                                }
                                cnt37++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1586:6: ( (lv_noFlows_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1586:6: ( (lv_noFlows_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1587:1: (lv_noFlows_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1587:1: (lv_noFlows_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1588:3: lv_noFlows_6_0= RULE_NONE
                            {
                            lv_noFlows_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType3168); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noFlows_6_0, grammarAccess.getDataTypeAccess().getNoFlowsNONETerminalRuleCall_3_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDataTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noFlows",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:5: ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )?
            int alt41=3;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==53) && (synpred13_InternalAadl2())) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_NONE) ) {
                alt41=2;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:6: ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:6: ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:7: ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:7: ( ( 'modes' )=>otherlv_7= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:8: ( 'modes' )=>otherlv_7= 'modes'
                    {
                    otherlv_7=(Token)match(input,53,FOLLOW_53_in_ruleDataType3198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDataTypeAccess().getModesKeyword_4_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1609:2: ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=3;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            int LA40_2 = input.LA(2);

                            if ( (LA40_2==RULE_COLON) ) {
                                int LA40_3 = input.LA(3);

                                if ( (LA40_3==RULE_ID) ) {
                                    alt40=2;
                                }
                                else if ( ((LA40_3>=36 && LA40_3<=37)) ) {
                                    alt40=1;
                                }


                            }
                            else if ( (LA40_2==RULE_LTRANS) ) {
                                alt40=2;
                            }


                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1609:3: ( (lv_ownedMode_8_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1609:3: ( (lv_ownedMode_8_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1610:1: (lv_ownedMode_8_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1610:1: (lv_ownedMode_8_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1611:3: lv_ownedMode_8_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedModeModeParserRuleCall_4_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleDataType3221);
                    	    lv_ownedMode_8_0=ruleMode();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedMode",
                    	              		lv_ownedMode_8_0, 
                    	              		"Mode");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1628:6: ( (lv_ownedModeTransition_9_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1628:6: ( (lv_ownedModeTransition_9_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1629:1: (lv_ownedModeTransition_9_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1629:1: (lv_ownedModeTransition_9_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1630:3: lv_ownedModeTransition_9_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_4_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleDataType3248);
                    	    lv_ownedModeTransition_9_0=ruleModeTransition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedModeTransition",
                    	              		lv_ownedModeTransition_9_0, 
                    	              		"ModeTransition");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1647:6: ( (lv_noModes_10_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1647:6: ( (lv_noModes_10_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1648:1: (lv_noModes_10_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1648:1: (lv_noModes_10_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1649:3: lv_noModes_10_0= RULE_NONE
                    {
                    lv_noModes_10_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType3274); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_noModes_10_0, grammarAccess.getDataTypeAccess().getNoModesNONETerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"noModes",
                              		true, 
                              		"NONE");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1665:4: ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==66) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1666:1: (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1666:1: (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1667:3: lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleDataType3302);
            	    lv_ownedAnnexSubclause_11_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedAnnexSubclause",
            	              		lv_ownedAnnexSubclause_11_0, 
            	              		"AnnexSubclause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleDataType3315); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getDataTypeAccess().getEndKeyword_6());
                  
            }
            this_ID_13=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType3326); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_13, grammarAccess.getDataTypeAccess().getIDTerminalRuleCall_7()); 
                  
            }
            this_SEMI_14=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataType3336); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_14, grammarAccess.getDataTypeAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleSystemImplementation"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1703:1: entryRuleSystemImplementation returns [EObject current=null] : iv_ruleSystemImplementation= ruleSystemImplementation EOF ;
    public final EObject entryRuleSystemImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemImplementation = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1704:2: (iv_ruleSystemImplementation= ruleSystemImplementation EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1705:2: iv_ruleSystemImplementation= ruleSystemImplementation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemImplementationRule()); 
            }
            pushFollow(FOLLOW_ruleSystemImplementation_in_entryRuleSystemImplementation3371);
            iv_ruleSystemImplementation=ruleSystemImplementation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemImplementation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemImplementation3381); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSystemImplementation"


    // $ANTLR start "ruleSystemImplementation"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1712:1: ruleSystemImplementation returns [EObject current=null] : (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI ) ;
    public final EObject ruleSystemImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_noSubcomponents_6_0=null;
        Token otherlv_7=null;
        Token lv_noConnections_9_0=null;
        Token otherlv_10=null;
        Token lv_noFlows_11_0=null;
        Token otherlv_12=null;
        Token lv_noModes_15_0=null;
        Token otherlv_17=null;
        Token this_ID_18=null;
        Token this_DOT_19=null;
        Token this_SEMI_21=null;
        EObject lv_ownedSystemSubcomponent_3_0 = null;

        EObject lv_ownedProcessorSubcomponent_4_0 = null;

        EObject lv_ownedDataSubcomponent_5_0 = null;

        EObject lv_ownedPortConnection_8_0 = null;

        EObject lv_ownedMode_13_0 = null;

        EObject lv_ownedModeTransition_14_0 = null;

        EObject lv_ownedAnnexSubclause_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1715:28: ( (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1716:1: (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1716:1: (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1716:3: otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleSystemImplementation3418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemImplementationAccess().getSystemKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleSystemImplementation3430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSystemImplementationAccess().getImplementationKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1724:1: ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==55) && (synpred14_InternalAadl2())) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1724:2: ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1724:2: ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1724:3: ( 'subcomponents' )=>otherlv_2= 'subcomponents'
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleSystemImplementation3451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSystemImplementationAccess().getSubcomponentsKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1729:2: ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_ID) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==RULE_NONE) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1729:3: ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1729:3: ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+
                            int cnt43=0;
                            loop43:
                            do {
                                int alt43=4;
                                int LA43_0 = input.LA(1);

                                if ( (LA43_0==RULE_ID) ) {
                                    int LA43_2 = input.LA(2);

                                    if ( (LA43_2==RULE_COLON) ) {
                                        switch ( input.LA(3) ) {
                                        case 40:
                                            {
                                            alt43=3;
                                            }
                                            break;
                                        case 47:
                                            {
                                            alt43=1;
                                            }
                                            break;
                                        case 44:
                                            {
                                            alt43=2;
                                            }
                                            break;

                                        }

                                    }


                                }


                                switch (alt43) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1729:4: ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1729:4: ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1730:1: (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1730:1: (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1731:3: lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedSystemSubcomponentSystemSubcomponentParserRuleCall_2_1_0_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleSystemSubcomponent_in_ruleSystemImplementation3475);
                            	    lv_ownedSystemSubcomponent_3_0=ruleSystemSubcomponent();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedSystemSubcomponent",
                            	              		lv_ownedSystemSubcomponent_3_0, 
                            	              		"SystemSubcomponent");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1748:6: ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1748:6: ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1749:1: (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1749:1: (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1750:3: lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedProcessorSubcomponentProcessorSubcomponentParserRuleCall_2_1_0_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleProcessorSubcomponent_in_ruleSystemImplementation3502);
                            	    lv_ownedProcessorSubcomponent_4_0=ruleProcessorSubcomponent();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedProcessorSubcomponent",
                            	              		lv_ownedProcessorSubcomponent_4_0, 
                            	              		"ProcessorSubcomponent");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 3 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1767:6: ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1767:6: ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1768:1: (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1768:1: (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1769:3: lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedDataSubcomponentDataSubcomponentParserRuleCall_2_1_0_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataSubcomponent_in_ruleSystemImplementation3529);
                            	    lv_ownedDataSubcomponent_5_0=ruleDataSubcomponent();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedDataSubcomponent",
                            	              		lv_ownedDataSubcomponent_5_0, 
                            	              		"DataSubcomponent");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt43 >= 1 ) break loop43;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(43, input);
                                        throw eee;
                                }
                                cnt43++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1786:6: ( (lv_noSubcomponents_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1786:6: ( (lv_noSubcomponents_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1787:1: (lv_noSubcomponents_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1787:1: (lv_noSubcomponents_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1788:3: lv_noSubcomponents_6_0= RULE_NONE
                            {
                            lv_noSubcomponents_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3554); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noSubcomponents_6_0, grammarAccess.getSystemImplementationAccess().getNoSubcomponentsNONETerminalRuleCall_2_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemImplementationRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noSubcomponents",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1804:5: ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==56) && (synpred15_InternalAadl2())) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1804:6: ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1804:6: ( ( 'connections' )=>otherlv_7= 'connections' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1804:7: ( 'connections' )=>otherlv_7= 'connections'
                    {
                    otherlv_7=(Token)match(input,56,FOLLOW_56_in_ruleSystemImplementation3583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSystemImplementationAccess().getConnectionsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1809:2: ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==RULE_ID) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==RULE_NONE) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1809:3: ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1809:3: ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+
                            int cnt46=0;
                            loop46:
                            do {
                                int alt46=2;
                                int LA46_0 = input.LA(1);

                                if ( (LA46_0==RULE_ID) ) {
                                    alt46=1;
                                }


                                switch (alt46) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1810:1: (lv_ownedPortConnection_8_0= rulePortConnection )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1810:1: (lv_ownedPortConnection_8_0= rulePortConnection )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1811:3: lv_ownedPortConnection_8_0= rulePortConnection
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedPortConnectionPortConnectionParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_rulePortConnection_in_ruleSystemImplementation3606);
                            	    lv_ownedPortConnection_8_0=rulePortConnection();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPortConnection",
                            	              		lv_ownedPortConnection_8_0, 
                            	              		"PortConnection");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt46 >= 1 ) break loop46;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(46, input);
                                        throw eee;
                                }
                                cnt46++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1828:6: ( (lv_noConnections_9_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1828:6: ( (lv_noConnections_9_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1829:1: (lv_noConnections_9_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1829:1: (lv_noConnections_9_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1830:3: lv_noConnections_9_0= RULE_NONE
                            {
                            lv_noConnections_9_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3630); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noConnections_9_0, grammarAccess.getSystemImplementationAccess().getNoConnectionsNONETerminalRuleCall_3_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemImplementationRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noConnections",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1846:5: ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==52) && (synpred16_InternalAadl2())) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1846:6: ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1846:6: ( ( 'flows' )=>otherlv_10= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1846:7: ( 'flows' )=>otherlv_10= 'flows'
                    {
                    otherlv_10=(Token)match(input,52,FOLLOW_52_in_ruleSystemImplementation3659); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSystemImplementationAccess().getFlowsKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1851:2: ( (lv_noFlows_11_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1852:1: (lv_noFlows_11_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1852:1: (lv_noFlows_11_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1853:3: lv_noFlows_11_0= RULE_NONE
                    {
                    lv_noFlows_11_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3677); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_noFlows_11_0, grammarAccess.getSystemImplementationAccess().getNoFlowsNONETerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSystemImplementationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"noFlows",
                              		true, 
                              		"NONE");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1869:4: ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==53) && (synpred17_InternalAadl2())) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1869:5: ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1869:5: ( ( 'modes' )=>otherlv_12= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1869:6: ( 'modes' )=>otherlv_12= 'modes'
                    {
                    otherlv_12=(Token)match(input,53,FOLLOW_53_in_ruleSystemImplementation3705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getSystemImplementationAccess().getModesKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1874:2: ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_ID) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==RULE_NONE) ) {
                        alt51=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1874:3: ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1874:3: ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+
                            int cnt50=0;
                            loop50:
                            do {
                                int alt50=3;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==RULE_ID) ) {
                                    int LA50_2 = input.LA(2);

                                    if ( (LA50_2==RULE_LTRANS) ) {
                                        alt50=2;
                                    }
                                    else if ( (LA50_2==RULE_COLON) ) {
                                        int LA50_4 = input.LA(3);

                                        if ( ((LA50_4>=36 && LA50_4<=37)) ) {
                                            alt50=1;
                                        }
                                        else if ( (LA50_4==RULE_ID) ) {
                                            alt50=2;
                                        }


                                    }


                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1874:4: ( (lv_ownedMode_13_0= ruleMode ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1874:4: ( (lv_ownedMode_13_0= ruleMode ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1875:1: (lv_ownedMode_13_0= ruleMode )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1875:1: (lv_ownedMode_13_0= ruleMode )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1876:3: lv_ownedMode_13_0= ruleMode
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedModeModeParserRuleCall_5_1_0_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleMode_in_ruleSystemImplementation3729);
                            	    lv_ownedMode_13_0=ruleMode();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedMode",
                            	              		lv_ownedMode_13_0, 
                            	              		"Mode");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1893:6: ( (lv_ownedModeTransition_14_0= ruleModeTransition ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1893:6: ( (lv_ownedModeTransition_14_0= ruleModeTransition ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1894:1: (lv_ownedModeTransition_14_0= ruleModeTransition )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1894:1: (lv_ownedModeTransition_14_0= ruleModeTransition )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1895:3: lv_ownedModeTransition_14_0= ruleModeTransition
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedModeTransitionModeTransitionParserRuleCall_5_1_0_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeTransition_in_ruleSystemImplementation3756);
                            	    lv_ownedModeTransition_14_0=ruleModeTransition();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedModeTransition",
                            	              		lv_ownedModeTransition_14_0, 
                            	              		"ModeTransition");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt50 >= 1 ) break loop50;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(50, input);
                                        throw eee;
                                }
                                cnt50++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1912:6: ( (lv_noModes_15_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1912:6: ( (lv_noModes_15_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1913:1: (lv_noModes_15_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1913:1: (lv_noModes_15_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1914:3: lv_noModes_15_0= RULE_NONE
                            {
                            lv_noModes_15_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3781); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noModes_15_0, grammarAccess.getSystemImplementationAccess().getNoModesNONETerminalRuleCall_5_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemImplementationRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noModes",
                                      		true, 
                                      		"NONE");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1930:5: ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==66) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1931:1: (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1931:1: (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1932:3: lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleSystemImplementation3810);
            	    lv_ownedAnnexSubclause_16_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedAnnexSubclause",
            	              		lv_ownedAnnexSubclause_16_0, 
            	              		"AnnexSubclause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            otherlv_17=(Token)match(input,29,FOLLOW_29_in_ruleSystemImplementation3823); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_17, grammarAccess.getSystemImplementationAccess().getEndKeyword_7());
                  
            }
            this_ID_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemImplementation3834); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_18, grammarAccess.getSystemImplementationAccess().getIDTerminalRuleCall_8()); 
                  
            }
            this_DOT_19=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSystemImplementation3844); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_19, grammarAccess.getSystemImplementationAccess().getDOTTerminalRuleCall_9()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSystemImplementationAccess().getINAMEParserRuleCall_10()); 
                  
            }
            pushFollow(FOLLOW_ruleINAME_in_ruleSystemImplementation3859);
            ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            this_SEMI_21=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemImplementation3869); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_21, grammarAccess.getSystemImplementationAccess().getSEMITerminalRuleCall_11()); 
                  
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
    // $ANTLR end "ruleSystemImplementation"


    // $ANTLR start "entryRulePrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1984:1: entryRulePrototype returns [EObject current=null] : iv_rulePrototype= rulePrototype EOF ;
    public final EObject entryRulePrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1985:2: (iv_rulePrototype= rulePrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1986:2: iv_rulePrototype= rulePrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrototypeRule()); 
            }
            pushFollow(FOLLOW_rulePrototype_in_entryRulePrototype3908);
            iv_rulePrototype=rulePrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrototype3918); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrototype"


    // $ANTLR start "rulePrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1993:1: rulePrototype returns [EObject current=null] : (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ;
    public final EObject rulePrototype() throws RecognitionException {
        EObject current = null;

        EObject this_ComponentPrototype_0 = null;

        EObject this_FeatureGroupPrototype_1 = null;

        EObject this_FeaturePrototype_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1996:28: ( (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1997:1: (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1997:1: (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype )
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==RULE_COLON) ) {
                    int LA54_2 = input.LA(3);

                    if ( (LA54_2==57) ) {
                        int LA54_3 = input.LA(4);

                        if ( ((LA54_3>=RULE_ID && LA54_3<=RULE_SEMI)||(LA54_3>=60 && LA54_3<=61)) ) {
                            alt54=3;
                        }
                        else if ( (LA54_3==46) ) {
                            alt54=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 54, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( ((LA54_2>=38 && LA54_2<=45)||(LA54_2>=47 && LA54_2<=49)) ) {
                        alt54=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1998:5: this_ComponentPrototype_0= ruleComponentPrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getComponentPrototypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentPrototype_in_rulePrototype3965);
                    this_ComponentPrototype_0=ruleComponentPrototype();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ComponentPrototype_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2008:5: this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getFeatureGroupPrototypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureGroupPrototype_in_rulePrototype3992);
                    this_FeatureGroupPrototype_1=ruleFeatureGroupPrototype();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FeatureGroupPrototype_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2018:5: this_FeaturePrototype_2= ruleFeaturePrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getFeaturePrototypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeaturePrototype_in_rulePrototype4019);
                    this_FeaturePrototype_2=ruleFeaturePrototype();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FeaturePrototype_2; 
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
    // $ANTLR end "rulePrototype"


    // $ANTLR start "entryRuleComponentPrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2034:1: entryRuleComponentPrototype returns [EObject current=null] : iv_ruleComponentPrototype= ruleComponentPrototype EOF ;
    public final EObject entryRuleComponentPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentPrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2035:2: (iv_ruleComponentPrototype= ruleComponentPrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2036:2: iv_ruleComponentPrototype= ruleComponentPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleComponentPrototype_in_entryRuleComponentPrototype4054);
            iv_ruleComponentPrototype=ruleComponentPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentPrototype4064); if (state.failed) return current;

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
    // $ANTLR end "entryRuleComponentPrototype"


    // $ANTLR start "ruleComponentPrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2043:1: ruleComponentPrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleComponentPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token this_SEMI_4=null;
        AntlrDatatypeRuleToken lv_category_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2046:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2047:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2047:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2047:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2047:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2048:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2048:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2049:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentPrototype4106); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getComponentPrototypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getComponentPrototypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleComponentPrototype4122); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getComponentPrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2069:1: ( (lv_category_2_0= ruleComponentCategoryKW ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2070:1: (lv_category_2_0= ruleComponentCategoryKW )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2070:1: (lv_category_2_0= ruleComponentCategoryKW )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2071:3: lv_category_2_0= ruleComponentCategoryKW
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentPrototypeAccess().getCategoryComponentCategoryKWParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleComponentCategoryKW_in_ruleComponentPrototype4142);
            lv_category_2_0=ruleComponentCategoryKW();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentPrototypeRule());
              	        }
                     		set(
                     			current, 
                     			"category",
                      		lv_category_2_0, 
                      		"ComponentCategoryKW");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2087:2: ( ( ruleQCREF ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2088:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2088:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2089:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getComponentPrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentPrototypeAccess().getConstrainingClassifierComponentClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleComponentPrototype4165);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleComponentPrototype4177); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getComponentPrototypeAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleComponentPrototype"


    // $ANTLR start "entryRuleFeatureGroupPrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2114:1: entryRuleFeatureGroupPrototype returns [EObject current=null] : iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF ;
    public final EObject entryRuleFeatureGroupPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureGroupPrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2115:2: (iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2116:2: iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureGroupPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureGroupPrototype_in_entryRuleFeatureGroupPrototype4212);
            iv_ruleFeatureGroupPrototype=ruleFeatureGroupPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureGroupPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureGroupPrototype4222); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeatureGroupPrototype"


    // $ANTLR start "ruleFeatureGroupPrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2123:1: ruleFeatureGroupPrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleFeatureGroupPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2126:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2127:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2127:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2127:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2127:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2128:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2128:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2129:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureGroupPrototype4264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFeatureGroupPrototypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureGroupPrototypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFeatureGroupPrototype4280); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFeatureGroupPrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,57,FOLLOW_57_in_ruleFeatureGroupPrototype4291); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeatureGroupPrototypeAccess().getFeatureKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleFeatureGroupPrototype4303); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureGroupPrototypeAccess().getGroupKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2157:1: ( ( ruleQCREF ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2158:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2158:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2159:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeatureGroupPrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureGroupPrototypeAccess().getConstrainingFeatureGroupTypeFeatureGroupTypeCrossReference_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleFeatureGroupPrototype4326);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeatureGroupPrototype4338); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getFeatureGroupPrototypeAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleFeatureGroupPrototype"


    // $ANTLR start "entryRuleFeaturePrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2184:1: entryRuleFeaturePrototype returns [EObject current=null] : iv_ruleFeaturePrototype= ruleFeaturePrototype EOF ;
    public final EObject entryRuleFeaturePrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeaturePrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:2: (iv_ruleFeaturePrototype= ruleFeaturePrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2186:2: iv_ruleFeaturePrototype= ruleFeaturePrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeaturePrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFeaturePrototype_in_entryRuleFeaturePrototype4373);
            iv_ruleFeaturePrototype=ruleFeaturePrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeaturePrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeaturePrototype4383); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeaturePrototype"


    // $ANTLR start "ruleFeaturePrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2193:1: ruleFeaturePrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleFeaturePrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_SEMI_5=null;
        AntlrDatatypeRuleToken lv_direction_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2196:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2197:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2197:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2197:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2197:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2198:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2198:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2199:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeaturePrototype4425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFeaturePrototypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFeaturePrototypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFeaturePrototype4441); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFeaturePrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,57,FOLLOW_57_in_ruleFeaturePrototype4452); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeaturePrototypeAccess().getFeatureKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2223:1: ( (lv_direction_3_0= rulePortDirection ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=60 && LA57_0<=61)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2224:1: (lv_direction_3_0= rulePortDirection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2224:1: (lv_direction_3_0= rulePortDirection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2225:3: lv_direction_3_0= rulePortDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeaturePrototypeAccess().getDirectionPortDirectionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePortDirection_in_ruleFeaturePrototype4473);
                    lv_direction_3_0=rulePortDirection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeaturePrototypeRule());
                      	        }
                             		set(
                             			current, 
                             			"direction",
                              		lv_direction_3_0, 
                              		"PortDirection");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2241:3: ( ( ruleQCREF ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2242:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2242:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2243:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeaturePrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeaturePrototypeAccess().getConstrainingClassifierComponentClassifierCrossReference_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleFeaturePrototype4497);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeaturePrototype4509); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getFeaturePrototypeAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleFeaturePrototype"


    // $ANTLR start "entryRuleDataPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2268:1: entryRuleDataPort returns [EObject current=null] : iv_ruleDataPort= ruleDataPort EOF ;
    public final EObject entryRuleDataPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2269:2: (iv_ruleDataPort= ruleDataPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2270:2: iv_ruleDataPort= ruleDataPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataPortRule()); 
            }
            pushFollow(FOLLOW_ruleDataPort_in_entryRuleDataPort4544);
            iv_ruleDataPort=ruleDataPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataPort4554); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataPort"


    // $ANTLR start "ruleDataPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2277:1: ruleDataPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI ) ;
    public final EObject ruleDataPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_SEMI_6=null;
        AntlrDatatypeRuleToken lv_direction_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2280:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2281:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2281:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2281:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2281:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2282:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2282:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2283:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataPort4596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getDataPortAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDataPortRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleDataPort4612); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getDataPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2303:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2304:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2304:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2305:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDataPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleDataPort4632);
            lv_direction_2_0=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDataPortRule());
              	        }
                     		set(
                     			current, 
                     			"direction",
                      		lv_direction_2_0, 
                      		"PortDirection");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleDataPort4644); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDataPortAccess().getDataKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,58,FOLLOW_58_in_ruleDataPort4656); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getDataPortAccess().getPortKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2329:1: ( ( ruleQCREF ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2330:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2330:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2331:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataPortRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDataPortAccess().getDataClassifierDataTypeCrossReference_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleDataPort4679);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataPort4691); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_6, grammarAccess.getDataPortAccess().getSEMITerminalRuleCall_6()); 
                  
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
    // $ANTLR end "ruleDataPort"


    // $ANTLR start "entryRuleEventDataPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2356:1: entryRuleEventDataPort returns [EObject current=null] : iv_ruleEventDataPort= ruleEventDataPort EOF ;
    public final EObject entryRuleEventDataPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDataPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2357:2: (iv_ruleEventDataPort= ruleEventDataPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2358:2: iv_ruleEventDataPort= ruleEventDataPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDataPortRule()); 
            }
            pushFollow(FOLLOW_ruleEventDataPort_in_entryRuleEventDataPort4726);
            iv_ruleEventDataPort=ruleEventDataPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDataPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDataPort4736); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEventDataPort"


    // $ANTLR start "ruleEventDataPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2365:1: ruleEventDataPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI ) ;
    public final EObject ruleEventDataPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_SEMI_7=null;
        AntlrDatatypeRuleToken lv_direction_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2368:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2369:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2369:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2369:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2369:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2370:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2370:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2371:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDataPort4778); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEventDataPortAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEventDataPortRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleEventDataPort4794); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getEventDataPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2391:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2392:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2392:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2393:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventDataPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleEventDataPort4814);
            lv_direction_2_0=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventDataPortRule());
              	        }
                     		set(
                     			current, 
                     			"direction",
                      		lv_direction_2_0, 
                      		"PortDirection");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleEventDataPort4826); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEventDataPortAccess().getEventKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,40,FOLLOW_40_in_ruleEventDataPort4838); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventDataPortAccess().getDataKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,58,FOLLOW_58_in_ruleEventDataPort4850); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEventDataPortAccess().getPortKeyword_5());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2421:1: ( ( ruleQCREF ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ID) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2422:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2422:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2423:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEventDataPortRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDataPortAccess().getDataClassifierDataTypeCrossReference_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleEventDataPort4873);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_SEMI_7=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEventDataPort4885); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_7, grammarAccess.getEventDataPortAccess().getSEMITerminalRuleCall_7()); 
                  
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
    // $ANTLR end "ruleEventDataPort"


    // $ANTLR start "entryRuleEventPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2448:1: entryRuleEventPort returns [EObject current=null] : iv_ruleEventPort= ruleEventPort EOF ;
    public final EObject entryRuleEventPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2449:2: (iv_ruleEventPort= ruleEventPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2450:2: iv_ruleEventPort= ruleEventPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventPortRule()); 
            }
            pushFollow(FOLLOW_ruleEventPort_in_entryRuleEventPort4920);
            iv_ruleEventPort=ruleEventPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventPort4930); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEventPort"


    // $ANTLR start "ruleEventPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2457:1: ruleEventPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleEventPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_SEMI_5=null;
        AntlrDatatypeRuleToken lv_direction_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2460:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2461:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2461:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2461:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2461:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2462:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2462:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2463:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventPort4972); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEventPortAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEventPortRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleEventPort4988); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getEventPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2483:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2484:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2484:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2485:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleEventPort5008);
            lv_direction_2_0=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventPortRule());
              	        }
                     		set(
                     			current, 
                     			"direction",
                      		lv_direction_2_0, 
                      		"PortDirection");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleEventPort5020); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEventPortAccess().getEventKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,58,FOLLOW_58_in_ruleEventPort5032); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventPortAccess().getPortKeyword_4());
                  
            }
            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEventPort5043); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getEventPortAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleEventPort"


    // $ANTLR start "entryRuleFeatureGroup"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2521:1: entryRuleFeatureGroup returns [EObject current=null] : iv_ruleFeatureGroup= ruleFeatureGroup EOF ;
    public final EObject entryRuleFeatureGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureGroup = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2522:2: (iv_ruleFeatureGroup= ruleFeatureGroup EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2523:2: iv_ruleFeatureGroup= ruleFeatureGroup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureGroupRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureGroup_in_entryRuleFeatureGroup5078);
            iv_ruleFeatureGroup=ruleFeatureGroup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureGroup; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureGroup5088); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeatureGroup"


    // $ANTLR start "ruleFeatureGroup"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2530:1: ruleFeatureGroup returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleFeatureGroup() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_SEMI_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2533:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2534:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2534:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2534:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2534:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2535:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2535:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2536:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureGroup5130); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFeatureGroupAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureGroupRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleFeatureGroup5147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureGroupAccess().getFeatureKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleFeatureGroup5159); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeatureGroupAccess().getGroupKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2560:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2561:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2561:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2562:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureGroupRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureGroupAccess().getFeatureGroupTypeFeatureGroupTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQCREF_in_ruleFeatureGroup5182);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeatureGroup5193); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getFeatureGroupAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleFeatureGroup"


    // $ANTLR start "entryRuleFeature"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2587:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2588:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2589:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature5228);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature5238); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2596:1: ruleFeature returns [EObject current=null] : (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_FeatureGroup_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2599:28: ( (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2600:1: (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2600:1: (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==RULE_COLON) ) {
                    alt61=1;
                }
                else if ( (LA61_1==57) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2601:5: this_Port_0= rulePort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getPortParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePort_in_ruleFeature5285);
                    this_Port_0=rulePort();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Port_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2611:5: this_FeatureGroup_1= ruleFeatureGroup
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getFeatureGroupParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureGroup_in_ruleFeature5312);
                    this_FeatureGroup_1=ruleFeatureGroup();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FeatureGroup_1; 
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRulePort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2627:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2628:2: (iv_rulePort= rulePort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2629:2: iv_rulePort= rulePort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortRule()); 
            }
            pushFollow(FOLLOW_rulePort_in_entryRulePort5347);
            iv_rulePort=rulePort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePort5357); if (state.failed) return current;

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
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2636:1: rulePort returns [EObject current=null] : (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        EObject this_DataPort_0 = null;

        EObject this_EventPort_1 = null;

        EObject this_EventDataPort_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2639:28: ( (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2640:1: (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2640:1: (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort )
            int alt62=3;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2641:5: this_DataPort_0= ruleDataPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getDataPortParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataPort_in_rulePort5404);
                    this_DataPort_0=ruleDataPort();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DataPort_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2651:5: this_EventPort_1= ruleEventPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getEventPortParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventPort_in_rulePort5431);
                    this_EventPort_1=ruleEventPort();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EventPort_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2661:5: this_EventDataPort_2= ruleEventDataPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getEventDataPortParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventDataPort_in_rulePort5458);
                    this_EventDataPort_2=ruleEventDataPort();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EventDataPort_2; 
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
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRulePortDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2677:1: entryRulePortDirection returns [String current=null] : iv_rulePortDirection= rulePortDirection EOF ;
    public final String entryRulePortDirection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePortDirection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2678:2: (iv_rulePortDirection= rulePortDirection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2679:2: iv_rulePortDirection= rulePortDirection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortDirectionRule()); 
            }
            pushFollow(FOLLOW_rulePortDirection_in_entryRulePortDirection5494);
            iv_rulePortDirection=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortDirection.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortDirection5505); if (state.failed) return current;

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
    // $ANTLR end "entryRulePortDirection"


    // $ANTLR start "rulePortDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2686:1: rulePortDirection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken rulePortDirection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2689:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2690:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2690:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt63=3;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==60) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==EOF||(LA63_1>=RULE_ID && LA63_1<=RULE_SEMI)||LA63_1==40||LA63_1==59) ) {
                    alt63=1;
                }
                else if ( (LA63_1==61) ) {
                    alt63=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA63_0==61) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2691:2: kw= 'in'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_rulePortDirection5543); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getInKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2698:2: kw= 'out'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_rulePortDirection5562); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getOutKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2704:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2704:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2705:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_rulePortDirection5582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getInKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,61,FOLLOW_61_in_rulePortDirection5595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getOutKeyword_2_1()); 
                          
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
    // $ANTLR end "rulePortDirection"


    // $ANTLR start "entryRuleModeRef"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2724:1: entryRuleModeRef returns [EObject current=null] : iv_ruleModeRef= ruleModeRef EOF ;
    public final EObject entryRuleModeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeRef = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2725:2: (iv_ruleModeRef= ruleModeRef EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2726:2: iv_ruleModeRef= ruleModeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeRefRule()); 
            }
            pushFollow(FOLLOW_ruleModeRef_in_entryRuleModeRef5636);
            iv_ruleModeRef=ruleModeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeRef5646); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModeRef"


    // $ANTLR start "ruleModeRef"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2733:1: ruleModeRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleModeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2736:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2737:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2737:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2737:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2737:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2738:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2738:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2739:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeRefRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeRef5691); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getModeRefAccess().getParentModeModeCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2750:2: (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==35) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2750:4: otherlv_1= '->' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleModeRef5704); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getModeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2754:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2755:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2755:1: (otherlv_2= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2756:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModeRefRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeRef5724); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getModeRefAccess().getDerivedModeModeCrossReference_1_1_0()); 
                      	
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
    // $ANTLR end "ruleModeRef"


    // $ANTLR start "entryRuleSystemSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2775:1: entryRuleSystemSubcomponent returns [EObject current=null] : iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF ;
    public final EObject entryRuleSystemSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2776:2: (iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2777:2: iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleSystemSubcomponent_in_entryRuleSystemSubcomponent5762);
            iv_ruleSystemSubcomponent=ruleSystemSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemSubcomponent5772); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSystemSubcomponent"


    // $ANTLR start "ruleSystemSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2784:1: ruleSystemSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleSystemSubcomponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_LPARENS_6=null;
        Token lv_allModes_8_0=null;
        Token this_RPARENS_9=null;
        Token this_SEMI_10=null;
        EObject lv_modeBinding_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2787:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2788:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2788:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2788:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2788:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2789:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2789:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2790:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemSubcomponent5814); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getSystemSubcomponentAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSystemSubcomponentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleSystemSubcomponent5830); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getSystemSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleSystemSubcomponent5841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSystemSubcomponentAccess().getSystemKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2814:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2815:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2815:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2816:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSystemSubcomponentRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getSystemClassifierSystemClassifierCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQCREF_in_ruleSystemSubcomponent5864);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2829:2: (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==60) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2829:4: otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS
                    {
                    otherlv_4=(Token)match(input,60,FOLLOW_60_in_ruleSystemSubcomponent5877); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSystemSubcomponentAccess().getInKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,53,FOLLOW_53_in_ruleSystemSubcomponent5889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSystemSubcomponentAccess().getModesKeyword_4_1());
                          
                    }
                    this_LPARENS_6=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleSystemSubcomponent5900); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_6, grammarAccess.getSystemSubcomponentAccess().getLPARENSTerminalRuleCall_4_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2841:1: ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==RULE_ID) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==62) ) {
                        alt66=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 66, 0, input);

                        throw nvae;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2841:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2841:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            int cnt65=0;
                            loop65:
                            do {
                                int alt65=2;
                                int LA65_0 = input.LA(1);

                                if ( (LA65_0==RULE_ID) ) {
                                    alt65=1;
                                }


                                switch (alt65) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2842:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2842:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2843:3: lv_modeBinding_7_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getModeBindingModeRefParserRuleCall_4_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleSystemSubcomponent5921);
                            	    lv_modeBinding_7_0=ruleModeRef();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemSubcomponentRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"modeBinding",
                            	              		lv_modeBinding_7_0, 
                            	              		"ModeRef");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt65 >= 1 ) break loop65;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(65, input);
                                        throw eee;
                                }
                                cnt65++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2860:6: ( (lv_allModes_8_0= 'all' ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2860:6: ( (lv_allModes_8_0= 'all' ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2861:1: (lv_allModes_8_0= 'all' )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2861:1: (lv_allModes_8_0= 'all' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2862:3: lv_allModes_8_0= 'all'
                            {
                            lv_allModes_8_0=(Token)match(input,62,FOLLOW_62_in_ruleSystemSubcomponent5946); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_allModes_8_0, grammarAccess.getSystemSubcomponentAccess().getAllModesAllKeyword_4_3_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemSubcomponentRule());
                              	        }
                                     		setWithLastConsumed(current, "allModes", true, "all");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleSystemSubcomponent5971); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getSystemSubcomponentAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemSubcomponent5983); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getSystemSubcomponentAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleSystemSubcomponent"


    // $ANTLR start "entryRuleProcessorSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2891:1: entryRuleProcessorSubcomponent returns [EObject current=null] : iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF ;
    public final EObject entryRuleProcessorSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessorSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2892:2: (iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2893:2: iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessorSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleProcessorSubcomponent_in_entryRuleProcessorSubcomponent6018);
            iv_ruleProcessorSubcomponent=ruleProcessorSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessorSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcessorSubcomponent6028); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProcessorSubcomponent"


    // $ANTLR start "ruleProcessorSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2900:1: ruleProcessorSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleProcessorSubcomponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_LPARENS_6=null;
        Token lv_allModes_8_0=null;
        Token this_RPARENS_9=null;
        Token this_SEMI_10=null;
        EObject lv_modeBinding_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2903:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2904:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2904:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2904:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2904:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2905:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2905:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2906:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorSubcomponent6070); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getProcessorSubcomponentAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getProcessorSubcomponentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleProcessorSubcomponent6086); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getProcessorSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleProcessorSubcomponent6097); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProcessorSubcomponentAccess().getProcessorKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2930:1: ( ( ruleQCREF ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2931:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2931:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2932:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getProcessorSubcomponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getProcessorClassifierProcessorClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleProcessorSubcomponent6120);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2945:3: (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==60) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2945:5: otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS
                    {
                    otherlv_4=(Token)match(input,60,FOLLOW_60_in_ruleProcessorSubcomponent6134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getProcessorSubcomponentAccess().getInKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,53,FOLLOW_53_in_ruleProcessorSubcomponent6146); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getProcessorSubcomponentAccess().getModesKeyword_4_1());
                          
                    }
                    this_LPARENS_6=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleProcessorSubcomponent6157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_6, grammarAccess.getProcessorSubcomponentAccess().getLPARENSTerminalRuleCall_4_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2957:1: ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) )
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==RULE_ID) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==62) ) {
                        alt70=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }
                    switch (alt70) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2957:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2957:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            int cnt69=0;
                            loop69:
                            do {
                                int alt69=2;
                                int LA69_0 = input.LA(1);

                                if ( (LA69_0==RULE_ID) ) {
                                    alt69=1;
                                }


                                switch (alt69) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2958:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2958:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2959:3: lv_modeBinding_7_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getModeBindingModeRefParserRuleCall_4_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleProcessorSubcomponent6178);
                            	    lv_modeBinding_7_0=ruleModeRef();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorSubcomponentRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"modeBinding",
                            	              		lv_modeBinding_7_0, 
                            	              		"ModeRef");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt69 >= 1 ) break loop69;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(69, input);
                                        throw eee;
                                }
                                cnt69++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2976:6: ( (lv_allModes_8_0= 'all' ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2976:6: ( (lv_allModes_8_0= 'all' ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2977:1: (lv_allModes_8_0= 'all' )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2977:1: (lv_allModes_8_0= 'all' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2978:3: lv_allModes_8_0= 'all'
                            {
                            lv_allModes_8_0=(Token)match(input,62,FOLLOW_62_in_ruleProcessorSubcomponent6203); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_allModes_8_0, grammarAccess.getProcessorSubcomponentAccess().getAllModesAllKeyword_4_3_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getProcessorSubcomponentRule());
                              	        }
                                     		setWithLastConsumed(current, "allModes", true, "all");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleProcessorSubcomponent6228); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getProcessorSubcomponentAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleProcessorSubcomponent6240); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getProcessorSubcomponentAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleProcessorSubcomponent"


    // $ANTLR start "entryRuleDataSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3007:1: entryRuleDataSubcomponent returns [EObject current=null] : iv_ruleDataSubcomponent= ruleDataSubcomponent EOF ;
    public final EObject entryRuleDataSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3008:2: (iv_ruleDataSubcomponent= ruleDataSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3009:2: iv_ruleDataSubcomponent= ruleDataSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleDataSubcomponent_in_entryRuleDataSubcomponent6275);
            iv_ruleDataSubcomponent=ruleDataSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataSubcomponent6285); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataSubcomponent"


    // $ANTLR start "ruleDataSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3016:1: ruleDataSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleDataSubcomponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_LPARENS_6=null;
        Token lv_allModes_8_0=null;
        Token this_RPARENS_9=null;
        Token this_SEMI_10=null;
        EObject lv_modeBinding_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3019:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3020:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3020:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3020:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3020:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3021:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3021:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3022:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataSubcomponent6327); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getDataSubcomponentAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDataSubcomponentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleDataSubcomponent6343); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getDataSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleDataSubcomponent6354); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDataSubcomponentAccess().getDataKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3046:1: ( ( ruleQCREF ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3047:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3047:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3048:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataSubcomponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getDataClassifierDataClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleDataSubcomponent6377);
                    ruleQCREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3061:3: (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==60) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3061:5: otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS
                    {
                    otherlv_4=(Token)match(input,60,FOLLOW_60_in_ruleDataSubcomponent6391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDataSubcomponentAccess().getInKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,53,FOLLOW_53_in_ruleDataSubcomponent6403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDataSubcomponentAccess().getModesKeyword_4_1());
                          
                    }
                    this_LPARENS_6=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleDataSubcomponent6414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_6, grammarAccess.getDataSubcomponentAccess().getLPARENSTerminalRuleCall_4_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3073:1: ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==RULE_ID) ) {
                        alt74=1;
                    }
                    else if ( (LA74_0==62) ) {
                        alt74=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3073:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3073:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            int cnt73=0;
                            loop73:
                            do {
                                int alt73=2;
                                int LA73_0 = input.LA(1);

                                if ( (LA73_0==RULE_ID) ) {
                                    alt73=1;
                                }


                                switch (alt73) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3074:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3074:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3075:3: lv_modeBinding_7_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getModeBindingModeRefParserRuleCall_4_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleDataSubcomponent6435);
                            	    lv_modeBinding_7_0=ruleModeRef();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDataSubcomponentRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"modeBinding",
                            	              		lv_modeBinding_7_0, 
                            	              		"ModeRef");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt73 >= 1 ) break loop73;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(73, input);
                                        throw eee;
                                }
                                cnt73++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3092:6: ( (lv_allModes_8_0= 'all' ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3092:6: ( (lv_allModes_8_0= 'all' ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3093:1: (lv_allModes_8_0= 'all' )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3093:1: (lv_allModes_8_0= 'all' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3094:3: lv_allModes_8_0= 'all'
                            {
                            lv_allModes_8_0=(Token)match(input,62,FOLLOW_62_in_ruleDataSubcomponent6460); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_allModes_8_0, grammarAccess.getDataSubcomponentAccess().getAllModesAllKeyword_4_3_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDataSubcomponentRule());
                              	        }
                                     		setWithLastConsumed(current, "allModes", true, "all");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleDataSubcomponent6485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getDataSubcomponentAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataSubcomponent6497); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getDataSubcomponentAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleDataSubcomponent"


    // $ANTLR start "entryRuleSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3123:1: entryRuleSubcomponent returns [EObject current=null] : iv_ruleSubcomponent= ruleSubcomponent EOF ;
    public final EObject entryRuleSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3124:2: (iv_ruleSubcomponent= ruleSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3125:2: iv_ruleSubcomponent= ruleSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleSubcomponent_in_entryRuleSubcomponent6532);
            iv_ruleSubcomponent=ruleSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubcomponent6542); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSubcomponent"


    // $ANTLR start "ruleSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3132:1: ruleSubcomponent returns [EObject current=null] : (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent ) ;
    public final EObject ruleSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject this_SystemSubcomponent_0 = null;

        EObject this_ProcessorSubcomponent_1 = null;

        EObject this_DataSubcomponent_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3135:28: ( (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3136:1: (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3136:1: (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent )
            int alt76=3;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                int LA76_1 = input.LA(2);

                if ( (LA76_1==RULE_COLON) ) {
                    switch ( input.LA(3) ) {
                    case 44:
                        {
                        alt76=2;
                        }
                        break;
                    case 40:
                        {
                        alt76=3;
                        }
                        break;
                    case 47:
                        {
                        alt76=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3137:5: this_SystemSubcomponent_0= ruleSystemSubcomponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubcomponentAccess().getSystemSubcomponentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSystemSubcomponent_in_ruleSubcomponent6589);
                    this_SystemSubcomponent_0=ruleSystemSubcomponent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SystemSubcomponent_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3147:5: this_ProcessorSubcomponent_1= ruleProcessorSubcomponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubcomponentAccess().getProcessorSubcomponentParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleProcessorSubcomponent_in_ruleSubcomponent6616);
                    this_ProcessorSubcomponent_1=ruleProcessorSubcomponent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProcessorSubcomponent_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3157:5: this_DataSubcomponent_2= ruleDataSubcomponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubcomponentAccess().getDataSubcomponentParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataSubcomponent_in_ruleSubcomponent6643);
                    this_DataSubcomponent_2=ruleDataSubcomponent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DataSubcomponent_2; 
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
    // $ANTLR end "ruleSubcomponent"


    // $ANTLR start "entryRulePortConnection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3173:1: entryRulePortConnection returns [EObject current=null] : iv_rulePortConnection= rulePortConnection EOF ;
    public final EObject entryRulePortConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortConnection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3174:2: (iv_rulePortConnection= rulePortConnection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3175:2: iv_rulePortConnection= rulePortConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortConnectionRule()); 
            }
            pushFollow(FOLLOW_rulePortConnection_in_entryRulePortConnection6678);
            iv_rulePortConnection=rulePortConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortConnection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortConnection6688); if (state.failed) return current;

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
    // $ANTLR end "entryRulePortConnection"


    // $ANTLR start "rulePortConnection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3182:1: rulePortConnection returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI ) ;
    public final EObject rulePortConnection() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token this_DOT_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_bidirectional_7_0=null;
        Token otherlv_8=null;
        Token this_DOT_9=null;
        Token otherlv_10=null;
        Token this_SEMI_11=null;
        AntlrDatatypeRuleToken lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3185:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3186:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3186:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3186:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3186:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3187:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3187:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3188:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPortConnectionAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rulePortConnection6746); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getPortConnectionAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3208:1: ( (lv_kind_2_0= ruleConnectionType ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3209:1: (lv_kind_2_0= ruleConnectionType )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3209:1: (lv_kind_2_0= ruleConnectionType )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3210:3: lv_kind_2_0= ruleConnectionType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPortConnectionAccess().getKindConnectionTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConnectionType_in_rulePortConnection6766);
            lv_kind_2_0=ruleConnectionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPortConnectionRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_2_0, 
                      		"ConnectionType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3226:2: ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                int LA77_1 = input.LA(2);

                if ( (LA77_1==RULE_DOT) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3226:3: ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3226:3: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3227:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3227:1: (otherlv_3= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3228:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getPortConnectionAccess().getSourceContextContextCrossReference_3_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_4=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rulePortConnection6798); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_4, grammarAccess.getPortConnectionAccess().getDOTTerminalRuleCall_3_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3243:3: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3244:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3244:1: (otherlv_5= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3245:3: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                      
            }
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6819); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_5, grammarAccess.getPortConnectionAccess().getSourceConnectionEndCrossReference_4_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3256:2: (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==35) ) {
                alt78=1;
            }
            else if ( (LA78_0==63) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3256:4: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,35,FOLLOW_35_in_rulePortConnection6832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPortConnectionAccess().getHyphenMinusGreaterThanSignKeyword_5_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3261:6: ( (lv_bidirectional_7_0= '<->' ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3261:6: ( (lv_bidirectional_7_0= '<->' ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3262:1: (lv_bidirectional_7_0= '<->' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3262:1: (lv_bidirectional_7_0= '<->' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3263:3: lv_bidirectional_7_0= '<->'
                    {
                    lv_bidirectional_7_0=(Token)match(input,63,FOLLOW_63_in_rulePortConnection6856); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_bidirectional_7_0, grammarAccess.getPortConnectionAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                             		setWithLastConsumed(current, "bidirectional", true, "<->");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3276:3: ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID) ) {
                int LA79_1 = input.LA(2);

                if ( (LA79_1==RULE_DOT) ) {
                    alt79=1;
                }
            }
            switch (alt79) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3276:4: ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3276:4: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3277:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3277:1: (otherlv_8= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3278:3: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                              
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_8, grammarAccess.getPortConnectionAccess().getDestinationContextContextCrossReference_6_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_9=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rulePortConnection6902); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_9, grammarAccess.getPortConnectionAccess().getDOTTerminalRuleCall_6_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3293:3: ( (otherlv_10= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3294:1: (otherlv_10= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3294:1: (otherlv_10= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3295:3: otherlv_10= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                      
            }
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_10, grammarAccess.getPortConnectionAccess().getDestinationConnectionEndCrossReference_7_0()); 
              	
            }

            }


            }

            this_SEMI_11=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePortConnection6934); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_11, grammarAccess.getPortConnectionAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // $ANTLR end "rulePortConnection"


    // $ANTLR start "entryRuleConnectionType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3318:1: entryRuleConnectionType returns [String current=null] : iv_ruleConnectionType= ruleConnectionType EOF ;
    public final String entryRuleConnectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3319:2: (iv_ruleConnectionType= ruleConnectionType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3320:2: iv_ruleConnectionType= ruleConnectionType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConnectionTypeRule()); 
            }
            pushFollow(FOLLOW_ruleConnectionType_in_entryRuleConnectionType6970);
            iv_ruleConnectionType=ruleConnectionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConnectionType.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionType6981); if (state.failed) return current;

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
    // $ANTLR end "entryRuleConnectionType"


    // $ANTLR start "ruleConnectionType"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3327:1: ruleConnectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3330:28: ( (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3331:1: (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3331:1: (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' )
            int alt80=5;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt80=1;
                }
                break;
            case 57:
                {
                int LA80_2 = input.LA(2);

                if ( (LA80_2==46) ) {
                    alt80=3;
                }
                else if ( (LA80_2==EOF||LA80_2==RULE_ID) ) {
                    alt80=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 2, input);

                    throw nvae;
                }
                }
                break;
            case 65:
                {
                alt80=4;
                }
                break;
            case 58:
                {
                alt80=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3332:2: kw= 'access'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleConnectionType7019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getAccessKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3339:2: kw= 'feature'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleConnectionType7038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getFeatureKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3345:6: (kw= 'feature' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3345:6: (kw= 'feature' kw= 'group' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3346:2: kw= 'feature' kw= 'group'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleConnectionType7058); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getFeatureKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleConnectionType7071); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getGroupKeyword_2_1()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3359:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleConnectionType7091); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getParameterKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3366:2: kw= 'port'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleConnectionType7110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getPortKeyword_4()); 
                          
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
    // $ANTLR end "ruleConnectionType"


    // $ANTLR start "entryRuleDefaultAnnexLibrary"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3389:1: entryRuleDefaultAnnexLibrary returns [EObject current=null] : iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF ;
    public final EObject entryRuleDefaultAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultAnnexLibrary = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3390:2: (iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3391:2: iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultAnnexLibraryRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultAnnexLibrary_in_entryRuleDefaultAnnexLibrary7160);
            iv_ruleDefaultAnnexLibrary=ruleDefaultAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultAnnexLibrary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultAnnexLibrary7170); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDefaultAnnexLibrary"


    // $ANTLR start "ruleDefaultAnnexLibrary"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3398:1: ruleDefaultAnnexLibrary returns [EObject current=null] : (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleDefaultAnnexLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sourceText_2_0=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3401:28: ( (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3402:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3402:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3402:3: otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleDefaultAnnexLibrary7207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefaultAnnexLibraryAccess().getAnnexKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3406:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3407:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3407:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3408:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefaultAnnexLibrary7224); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getDefaultAnnexLibraryAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefaultAnnexLibraryRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3424:2: ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3425:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3425:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3426:3: lv_sourceText_2_0= RULE_ANNEXTEXT
            {
            lv_sourceText_2_0=(Token)match(input,RULE_ANNEXTEXT,FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexLibrary7246); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_sourceText_2_0, grammarAccess.getDefaultAnnexLibraryAccess().getSourceTextANNEXTEXTTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefaultAnnexLibraryRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"sourceText",
                      		lv_sourceText_2_0, 
                      		"ANNEXTEXT");
              	    
            }

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDefaultAnnexLibrary7262); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_3, grammarAccess.getDefaultAnnexLibraryAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleDefaultAnnexLibrary"


    // $ANTLR start "entryRuleAnnexSubclause"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3454:1: entryRuleAnnexSubclause returns [EObject current=null] : iv_ruleAnnexSubclause= ruleAnnexSubclause EOF ;
    public final EObject entryRuleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3455:2: (iv_ruleAnnexSubclause= ruleAnnexSubclause EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3456:2: iv_ruleAnnexSubclause= ruleAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause7297);
            iv_ruleAnnexSubclause=ruleAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnexSubclause7307); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAnnexSubclause"


    // $ANTLR start "ruleAnnexSubclause"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3463:1: ruleAnnexSubclause returns [EObject current=null] : this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause ;
    public final EObject ruleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_DefaultAnnexSubclause_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3466:28: (this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3468:5: this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAnnexSubclauseAccess().getDefaultAnnexSubclauseParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleDefaultAnnexSubclause_in_ruleAnnexSubclause7353);
            this_DefaultAnnexSubclause_0=ruleDefaultAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_DefaultAnnexSubclause_0; 
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
    // $ANTLR end "ruleAnnexSubclause"


    // $ANTLR start "entryRuleDefaultAnnexSubclause"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3484:1: entryRuleDefaultAnnexSubclause returns [EObject current=null] : iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF ;
    public final EObject entryRuleDefaultAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultAnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3485:2: (iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3486:2: iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultAnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultAnnexSubclause_in_entryRuleDefaultAnnexSubclause7387);
            iv_ruleDefaultAnnexSubclause=ruleDefaultAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultAnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultAnnexSubclause7397); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDefaultAnnexSubclause"


    // $ANTLR start "ruleDefaultAnnexSubclause"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3493:1: ruleDefaultAnnexSubclause returns [EObject current=null] : (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleDefaultAnnexSubclause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sourceText_2_0=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3496:28: ( (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3497:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3497:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3497:3: otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleDefaultAnnexSubclause7434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefaultAnnexSubclauseAccess().getAnnexKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3501:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3502:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3502:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3503:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefaultAnnexSubclause7451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getDefaultAnnexSubclauseAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefaultAnnexSubclauseRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3519:2: ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3520:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3520:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3521:3: lv_sourceText_2_0= RULE_ANNEXTEXT
            {
            lv_sourceText_2_0=(Token)match(input,RULE_ANNEXTEXT,FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexSubclause7473); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_sourceText_2_0, grammarAccess.getDefaultAnnexSubclauseAccess().getSourceTextANNEXTEXTTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefaultAnnexSubclauseRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"sourceText",
                      		lv_sourceText_2_0, 
                      		"ANNEXTEXT");
              	    
            }

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDefaultAnnexSubclause7489); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_3, grammarAccess.getDefaultAnnexSubclauseAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleDefaultAnnexSubclause"


    // $ANTLR start "entryRulePNAME"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3553:1: entryRulePNAME returns [String current=null] : iv_rulePNAME= rulePNAME EOF ;
    public final String entryRulePNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePNAME = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3554:2: (iv_rulePNAME= rulePNAME EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3555:2: iv_rulePNAME= rulePNAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPNAMERule()); 
            }
            pushFollow(FOLLOW_rulePNAME_in_entryRulePNAME7529);
            iv_rulePNAME=rulePNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePNAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePNAME7540); if (state.failed) return current;

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
    // $ANTLR end "entryRulePNAME"


    // $ANTLR start "rulePNAME"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3562:1: rulePNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken rulePNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3565:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3566:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3566:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3566:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePNAME7580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getPNAMEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3573:1: (kw= '::' this_ID_2= RULE_ID )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==30) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3574:2: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,30,FOLLOW_30_in_rulePNAME7599); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getPNAMEAccess().getColonColonKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePNAME7614); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getPNAMEAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop81;
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
    // $ANTLR end "rulePNAME"


    // $ANTLR start "entryRuleINAME"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3596:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3597:2: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3598:2: iv_ruleINAME= ruleINAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINAMERule()); 
            }
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME7664);
            iv_ruleINAME=ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME7675); if (state.failed) return current;

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
    // $ANTLR end "entryRuleINAME"


    // $ANTLR start "ruleINAME"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3605:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3608:28: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3609:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME7714); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getINAMEAccess().getIDTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleINAME"


    // $ANTLR start "entryRuleQCREF"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3624:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3625:2: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3626:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF7759);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF7770); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3633:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_DOT_3=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3636:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3637:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3637:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3637:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3637:2: (this_ID_0= RULE_ID kw= '::' )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==RULE_ID) ) {
                    int LA82_1 = input.LA(2);

                    if ( (LA82_1==30) ) {
                        alt82=1;
                    }


                }


                switch (alt82) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3637:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF7811); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,30,FOLLOW_30_in_ruleQCREF7829); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF7846); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3657:1: (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_DOT) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3657:6: this_DOT_3= RULE_DOT this_ID_4= RULE_ID
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleQCREF7867); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_3, grammarAccess.getQCREFAccess().getDOTTerminalRuleCall_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF7887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
                          
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
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "ruleFlowKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3679:1: ruleFlowKind returns [Enumerator current=null] : ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'path' ) | (enumLiteral_2= 'sink' ) ) ;
    public final Enumerator ruleFlowKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3681:28: ( ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'path' ) | (enumLiteral_2= 'sink' ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3682:1: ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'path' ) | (enumLiteral_2= 'sink' ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3682:1: ( (enumLiteral_0= 'source' ) | (enumLiteral_1= 'path' ) | (enumLiteral_2= 'sink' ) )
            int alt84=3;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt84=1;
                }
                break;
            case 68:
                {
                alt84=2;
                }
                break;
            case 69:
                {
                alt84=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3682:2: (enumLiteral_0= 'source' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3682:2: (enumLiteral_0= 'source' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3682:4: enumLiteral_0= 'source'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_67_in_ruleFlowKind7948); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getFlowKindAccess().getSourceEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getFlowKindAccess().getSourceEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3688:6: (enumLiteral_1= 'path' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3688:6: (enumLiteral_1= 'path' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3688:8: enumLiteral_1= 'path'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_68_in_ruleFlowKind7965); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getFlowKindAccess().getPathEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getFlowKindAccess().getPathEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3694:6: (enumLiteral_2= 'sink' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3694:6: (enumLiteral_2= 'sink' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3694:8: enumLiteral_2= 'sink'
                    {
                    enumLiteral_2=(Token)match(input,69,FOLLOW_69_in_ruleFlowKind7982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getFlowKindAccess().getSinkEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getFlowKindAccess().getSinkEnumLiteralDeclaration_2()); 
                          
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
    // $ANTLR end "ruleFlowKind"

    // $ANTLR start synpred1_InternalAadl2
    public final void synpred1_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:211:3: ( 'with' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:211:5: 'with'
        {
        match(input,32,FOLLOW_32_in_synpred1_InternalAadl2381); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalAadl2

    // $ANTLR start synpred2_InternalAadl2
    public final void synpred2_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:360:3: ( 'with' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:360:5: 'with'
        {
        match(input,32,FOLLOW_32_in_synpred2_InternalAadl2671); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalAadl2

    // $ANTLR start synpred3_InternalAadl2
    public final void synpred3_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:560:4: ( '->' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:560:6: '->'
        {
        match(input,35,FOLLOW_35_in_synpred3_InternalAadl21029); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalAadl2

    // $ANTLR start synpred4_InternalAadl2
    public final void synpred4_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:4: ( 'prototypes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:6: 'prototypes'
        {
        match(input,50,FOLLOW_50_in_synpred4_InternalAadl22043); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalAadl2

    // $ANTLR start synpred5_InternalAadl2
    public final void synpred5_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1023:8: ( 'features' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1023:10: 'features'
        {
        match(input,51,FOLLOW_51_in_synpred5_InternalAadl22119); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalAadl2

    // $ANTLR start synpred6_InternalAadl2
    public final void synpred6_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1103:9: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1103:11: 'flows'
        {
        match(input,52,FOLLOW_52_in_synpred6_InternalAadl22251); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalAadl2

    // $ANTLR start synpred7_InternalAadl2
    public final void synpred7_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:8: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1145:10: 'modes'
        {
        match(input,53,FOLLOW_53_in_synpred7_InternalAadl22328); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalAadl2

    // $ANTLR start synpred8_InternalAadl2
    public final void synpred8_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1283:4: ( 'features' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1283:6: 'features'
        {
        match(input,51,FOLLOW_51_in_synpred8_InternalAadl22595); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalAadl2

    // $ANTLR start synpred9_InternalAadl2
    public final void synpred9_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:9: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:11: 'flows'
        {
        match(input,52,FOLLOW_52_in_synpred9_InternalAadl22727); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalAadl2

    // $ANTLR start synpred10_InternalAadl2
    public final void synpred10_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:8: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1405:10: 'modes'
        {
        match(input,53,FOLLOW_53_in_synpred10_InternalAadl22804); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalAadl2

    // $ANTLR start synpred11_InternalAadl2
    public final void synpred11_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1539:4: ( 'features' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1539:6: 'features'
        {
        match(input,51,FOLLOW_51_in_synpred11_InternalAadl23067); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalAadl2

    // $ANTLR start synpred12_InternalAadl2
    public final void synpred12_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1562:6: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1562:8: 'flows'
        {
        match(input,52,FOLLOW_52_in_synpred12_InternalAadl23113); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalAadl2

    // $ANTLR start synpred13_InternalAadl2
    public final void synpred13_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:8: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:10: 'modes'
        {
        match(input,53,FOLLOW_53_in_synpred13_InternalAadl23190); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalAadl2

    // $ANTLR start synpred14_InternalAadl2
    public final void synpred14_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1724:3: ( 'subcomponents' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1724:5: 'subcomponents'
        {
        match(input,55,FOLLOW_55_in_synpred14_InternalAadl23443); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalAadl2

    // $ANTLR start synpred15_InternalAadl2
    public final void synpred15_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1804:7: ( 'connections' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1804:9: 'connections'
        {
        match(input,56,FOLLOW_56_in_synpred15_InternalAadl23575); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalAadl2

    // $ANTLR start synpred16_InternalAadl2
    public final void synpred16_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1846:7: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1846:9: 'flows'
        {
        match(input,52,FOLLOW_52_in_synpred16_InternalAadl23651); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalAadl2

    // $ANTLR start synpred17_InternalAadl2
    public final void synpred17_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1869:6: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1869:8: 'modes'
        {
        match(input,53,FOLLOW_53_in_synpred17_InternalAadl23697); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalAadl2

    // Delegated rules

    public final boolean synpred10_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalAadl2() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalAadl2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA62 dfa62 = new DFA62(this);
    static final String DFA14_eotS =
        "\20\uffff";
    static final String DFA14_eofS =
        "\12\uffff\1\14\5\uffff";
    static final String DFA14_minS =
        "\1\46\11\uffff\1\4\1\47\4\uffff";
    static final String DFA14_maxS =
        "\1\61\11\uffff\1\56\1\54\4\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff\1\13\1\12"+
        "\1\15\1\14";
    static final String DFA14_specialS =
        "\20\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\2\14\50\uffff\1\15",
            "\1\17\4\uffff\1\16",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "824:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA18_eotS =
        "\13\uffff";
    static final String DFA18_eofS =
        "\13\uffff";
    static final String DFA18_minS =
        "\1\4\1\uffff\1\7\1\74\3\50\1\uffff\1\50\2\uffff";
    static final String DFA18_maxS =
        "\1\102\1\uffff\1\7\2\75\1\73\1\72\1\uffff\1\73\2\uffff";
    static final String DFA18_acceptS =
        "\1\uffff\1\4\5\uffff\1\1\1\uffff\1\3\1\2";
    static final String DFA18_specialS =
        "\13\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\5\uffff\1\1\22\uffff\1\1\26\uffff\2\1\14\uffff\1\1",
            "",
            "\1\3",
            "\1\4\1\5",
            "\1\7\22\uffff\1\6\1\uffff\1\10",
            "\1\7\22\uffff\1\6",
            "\1\11\21\uffff\1\12",
            "",
            "\1\7\22\uffff\1\6",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1047:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+";
        }
    }
    static final String DFA27_eotS =
        "\13\uffff";
    static final String DFA27_eofS =
        "\13\uffff";
    static final String DFA27_minS =
        "\1\4\1\uffff\1\7\1\74\4\50\3\uffff";
    static final String DFA27_maxS =
        "\1\102\1\uffff\1\7\2\75\1\73\1\72\1\73\3\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\4\6\uffff\1\1\1\3\1\2";
    static final String DFA27_specialS =
        "\13\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\2\5\uffff\1\1\22\uffff\1\1\26\uffff\2\1\14\uffff\1\1",
            "",
            "\1\3",
            "\1\4\1\5",
            "\1\10\22\uffff\1\6\1\uffff\1\7",
            "\1\10\22\uffff\1\6",
            "\1\11\21\uffff\1\12",
            "\1\10\22\uffff\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1307:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+";
        }
    }
    static final String DFA62_eotS =
        "\12\uffff";
    static final String DFA62_eofS =
        "\12\uffff";
    static final String DFA62_minS =
        "\1\4\1\7\1\74\4\50\3\uffff";
    static final String DFA62_maxS =
        "\1\4\1\7\2\75\1\73\1\72\1\73\3\uffff";
    static final String DFA62_acceptS =
        "\7\uffff\1\1\1\2\1\3";
    static final String DFA62_specialS =
        "\12\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\1\4",
            "\1\7\22\uffff\1\5\1\uffff\1\6",
            "\1\7\22\uffff\1\5",
            "\1\11\21\uffff\1\10",
            "\1\7\22\uffff\1\5",
            "",
            "",
            ""
    };

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "2640:1: (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort )";
        }
    }
 

    public static final BitSet FOLLOW_ruleAadlPackage_in_entryRuleAadlPackage75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlPackage85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAadlPackage122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_ruleAadlPackage143 = new BitSet(new long[]{0x0000000280000000L});
    public static final BitSet FOLLOW_rulePublicPackageSection_in_ruleAadlPackage166 = new BitSet(new long[]{0x00000002A0000000L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage187 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage216 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAadlPackage229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlPackage240 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleAadlPackage252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlPackage263 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleAadlPackage275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePublicPackageSection_in_entryRulePublicPackageSection312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePublicPackageSection322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rulePublicPackageSection368 = new BitSet(new long[]{0x0000910100000002L});
    public static final BitSet FOLLOW_32_in_rulePublicPackageSection389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePublicPackageSection413 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePublicPackageSection425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePublicPackageSection447 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePublicPackageSection460 = new BitSet(new long[]{0x0000910100000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_rulePublicPackageSection483 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_rulePublicPackageSection510 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_rulePublicPackageSection537 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rulePublicPackageSection564 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_entryRulePrivatePackageSection602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrivatePackageSection612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulePrivatePackageSection658 = new BitSet(new long[]{0x0000910100000002L});
    public static final BitSet FOLLOW_32_in_rulePrivatePackageSection679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePrivatePackageSection703 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePrivatePackageSection715 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePrivatePackageSection737 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePrivatePackageSection750 = new BitSet(new long[]{0x0000910100000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_rulePrivatePackageSection773 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_rulePrivatePackageSection800 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_rulePrivatePackageSection827 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rulePrivatePackageSection854 = new BitSet(new long[]{0x0000910000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_entryRuleFlowSpecification896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecification906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecification948 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSpecification964 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleFlowSpecification975 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000038L});
    public static final BitSet FOLLOW_ruleFlowKind_in_ruleFlowSpecification996 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecification1016 = new BitSet(new long[]{0x0000000800000020L});
    public static final BitSet FOLLOW_35_in_ruleFlowSpecification1037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecification1058 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFlowSpecification1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMode_in_entryRuleMode1106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMode1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMode1158 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleMode1174 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_36_in_ruleMode1191 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleMode1217 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleMode1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransition_in_entryRuleModeTransition1263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransition1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition1316 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleModeTransition1332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition1353 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_LTRANS_in_ruleModeTransition1364 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_ruleModeTransition1384 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleModeTransition1396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_ruleModeTransition1416 = new BitSet(new long[]{0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RTRANS_in_ruleModeTransition1429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition1448 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleModeTransition1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_entryRuleTriggerPort1494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerPort1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggerPort1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategoryKW_in_entryRuleComponentCategoryKW1584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategoryKW1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleComponentCategoryKW1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleComponentCategoryKW1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleComponentCategoryKW1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleComponentCategoryKW1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleComponentCategoryKW1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleComponentCategoryKW1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategoryKW1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleComponentCategoryKW1767 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategoryKW1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategoryKW1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleComponentCategoryKW1820 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategoryKW1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleComponentCategoryKW1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategoryKW1873 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleComponentCategoryKW1886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategoryKW1907 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategoryKW1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_entryRuleSystemType1961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemType1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSystemType2008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemType2025 = new BitSet(new long[]{0x003C000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_50_in_ruleSystemType2051 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType2070 = new BitSet(new long[]{0x0038000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_rulePrototype_in_ruleSystemType2102 = new BitSet(new long[]{0x0038000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_51_in_ruleSystemType2127 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType2146 = new BitSet(new long[]{0x0030000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleDataPort_in_ruleSystemType2179 = new BitSet(new long[]{0x0030000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleEventPort_in_ruleSystemType2206 = new BitSet(new long[]{0x0030000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_ruleSystemType2233 = new BitSet(new long[]{0x0030000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_52_in_ruleSystemType2259 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleSystemType2282 = new BitSet(new long[]{0x0020000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType2306 = new BitSet(new long[]{0x0020000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_53_in_ruleSystemType2336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleSystemType2359 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleSystemType2386 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType2412 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleSystemType2440 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29_in_ruleSystemType2453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemType2464 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemType2474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_entryRuleProcessorType2513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcessorType2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleProcessorType2560 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorType2577 = new BitSet(new long[]{0x0038000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_51_in_ruleProcessorType2603 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2622 = new BitSet(new long[]{0x0030000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleDataPort_in_ruleProcessorType2655 = new BitSet(new long[]{0x0030000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleEventPort_in_ruleProcessorType2682 = new BitSet(new long[]{0x0030000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_ruleProcessorType2709 = new BitSet(new long[]{0x0030000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_52_in_ruleProcessorType2735 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleProcessorType2758 = new BitSet(new long[]{0x0020000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2782 = new BitSet(new long[]{0x0020000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_53_in_ruleProcessorType2812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleProcessorType2835 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleProcessorType2862 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2888 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleProcessorType2916 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29_in_ruleProcessorType2929 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorType2940 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleProcessorType2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType2985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleDataType3032 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType3049 = new BitSet(new long[]{0x0038000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_51_in_ruleDataType3075 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType3093 = new BitSet(new long[]{0x0030000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_52_in_ruleDataType3121 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleDataType3144 = new BitSet(new long[]{0x0020000020000410L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType3168 = new BitSet(new long[]{0x0020000020000400L,0x0000000000000004L});
    public static final BitSet FOLLOW_53_in_ruleDataType3198 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleDataType3221 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleDataType3248 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType3274 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleDataType3302 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29_in_ruleDataType3315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType3326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataType3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_entryRuleSystemImplementation3371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemImplementation3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSystemImplementation3418 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleSystemImplementation3430 = new BitSet(new long[]{0x01B0000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_55_in_ruleSystemImplementation3451 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_ruleSystemImplementation3475 = new BitSet(new long[]{0x0130000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_ruleSystemImplementation3502 = new BitSet(new long[]{0x0130000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_ruleSystemImplementation3529 = new BitSet(new long[]{0x0130000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3554 = new BitSet(new long[]{0x0130000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_56_in_ruleSystemImplementation3583 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_rulePortConnection_in_ruleSystemImplementation3606 = new BitSet(new long[]{0x0030000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3630 = new BitSet(new long[]{0x0030000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_52_in_ruleSystemImplementation3659 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3677 = new BitSet(new long[]{0x0020000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_53_in_ruleSystemImplementation3705 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_ruleMode_in_ruleSystemImplementation3729 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleSystemImplementation3756 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3781 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleSystemImplementation3810 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29_in_ruleSystemImplementation3823 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemImplementation3834 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSystemImplementation3844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINAME_in_ruleSystemImplementation3859 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemImplementation3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrototype_in_entryRulePrototype3908 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrototype3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentPrototype_in_rulePrototype3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroupPrototype_in_rulePrototype3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeaturePrototype_in_rulePrototype4019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentPrototype_in_entryRuleComponentPrototype4054 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentPrototype4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentPrototype4106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleComponentPrototype4122 = new BitSet(new long[]{0x0003BFC000000000L});
    public static final BitSet FOLLOW_ruleComponentCategoryKW_in_ruleComponentPrototype4142 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentPrototype4165 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleComponentPrototype4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroupPrototype_in_entryRuleFeatureGroupPrototype4212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureGroupPrototype4222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureGroupPrototype4264 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFeatureGroupPrototype4280 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleFeatureGroupPrototype4291 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleFeatureGroupPrototype4303 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeatureGroupPrototype4326 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeatureGroupPrototype4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeaturePrototype_in_entryRuleFeaturePrototype4373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeaturePrototype4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeaturePrototype4425 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFeaturePrototype4441 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleFeaturePrototype4452 = new BitSet(new long[]{0x3000000000000030L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleFeaturePrototype4473 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeaturePrototype4497 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeaturePrototype4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataPort_in_entryRuleDataPort4544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataPort4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataPort4596 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleDataPort4612 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleDataPort4632 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDataPort4644 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleDataPort4656 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleDataPort4679 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataPort4691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_entryRuleEventDataPort4726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDataPort4736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDataPort4778 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleEventDataPort4794 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleEventDataPort4814 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleEventDataPort4826 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleEventDataPort4838 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleEventDataPort4850 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleEventDataPort4873 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEventDataPort4885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventPort_in_entryRuleEventPort4920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventPort4930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventPort4972 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleEventPort4988 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleEventPort5008 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleEventPort5020 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleEventPort5032 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEventPort5043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroup_in_entryRuleFeatureGroup5078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureGroup5088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureGroup5130 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleFeatureGroup5147 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleFeatureGroup5159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeatureGroup5182 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeatureGroup5193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature5228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature5238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_ruleFeature5285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroup_in_ruleFeature5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort5347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort5357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataPort_in_rulePort5404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventPort_in_rulePort5431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_rulePort5458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortDirection_in_entryRulePortDirection5494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortDirection5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rulePortDirection5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_rulePortDirection5562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rulePortDirection5582 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_rulePortDirection5595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeRef_in_entryRuleModeRef5636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeRef5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeRef5691 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleModeRef5704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeRef5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_entryRuleSystemSubcomponent5762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemSubcomponent5772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemSubcomponent5814 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleSystemSubcomponent5830 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleSystemSubcomponent5841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleSystemSubcomponent5864 = new BitSet(new long[]{0x1000000000000020L});
    public static final BitSet FOLLOW_60_in_ruleSystemSubcomponent5877 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleSystemSubcomponent5889 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleSystemSubcomponent5900 = new BitSet(new long[]{0x4000000000000010L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleSystemSubcomponent5921 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_62_in_ruleSystemSubcomponent5946 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleSystemSubcomponent5971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemSubcomponent5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_entryRuleProcessorSubcomponent6018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcessorSubcomponent6028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorSubcomponent6070 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleProcessorSubcomponent6086 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleProcessorSubcomponent6097 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleProcessorSubcomponent6120 = new BitSet(new long[]{0x1000000000000020L});
    public static final BitSet FOLLOW_60_in_ruleProcessorSubcomponent6134 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleProcessorSubcomponent6146 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleProcessorSubcomponent6157 = new BitSet(new long[]{0x4000000000000010L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleProcessorSubcomponent6178 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_62_in_ruleProcessorSubcomponent6203 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleProcessorSubcomponent6228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleProcessorSubcomponent6240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_entryRuleDataSubcomponent6275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataSubcomponent6285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataSubcomponent6327 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleDataSubcomponent6343 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDataSubcomponent6354 = new BitSet(new long[]{0x1000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleDataSubcomponent6377 = new BitSet(new long[]{0x1000000000000020L});
    public static final BitSet FOLLOW_60_in_ruleDataSubcomponent6391 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleDataSubcomponent6403 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleDataSubcomponent6414 = new BitSet(new long[]{0x4000000000000010L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleDataSubcomponent6435 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_62_in_ruleDataSubcomponent6460 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleDataSubcomponent6485 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataSubcomponent6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubcomponent_in_entryRuleSubcomponent6532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubcomponent6542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_ruleSubcomponent6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_ruleSubcomponent6616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_ruleSubcomponent6643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortConnection_in_entryRulePortConnection6678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortConnection6688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6730 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_rulePortConnection6746 = new BitSet(new long[]{0x0600000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleConnectionType_in_rulePortConnection6766 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6787 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RULE_DOT_in_rulePortConnection6798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6819 = new BitSet(new long[]{0x8000000800000000L});
    public static final BitSet FOLLOW_35_in_rulePortConnection6832 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_63_in_rulePortConnection6856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6891 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RULE_DOT_in_rulePortConnection6902 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6923 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePortConnection6934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionType_in_entryRuleConnectionType6970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionType6981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleConnectionType7019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleConnectionType7038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleConnectionType7058 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleConnectionType7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConnectionType7091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleConnectionType7110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexLibrary_in_entryRuleDefaultAnnexLibrary7160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultAnnexLibrary7170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleDefaultAnnexLibrary7207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefaultAnnexLibrary7224 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexLibrary7246 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDefaultAnnexLibrary7262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause7297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnexSubclause7307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexSubclause_in_ruleAnnexSubclause7353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexSubclause_in_entryRuleDefaultAnnexSubclause7387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultAnnexSubclause7397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleDefaultAnnexSubclause7434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefaultAnnexSubclause7451 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexSubclause7473 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDefaultAnnexSubclause7489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePNAME_in_entryRulePNAME7529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePNAME7540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePNAME7580 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rulePNAME7599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePNAME7614 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME7664 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME7675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME7714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF7759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF7770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF7811 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleQCREF7829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF7846 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleQCREF7867 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleFlowKind7948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleFlowKind7965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleFlowKind7982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred1_InternalAadl2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred2_InternalAadl2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_synpred3_InternalAadl21029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred4_InternalAadl22043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred5_InternalAadl22119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred6_InternalAadl22251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred7_InternalAadl22328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred8_InternalAadl22595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred9_InternalAadl22727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred10_InternalAadl22804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred11_InternalAadl23067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred12_InternalAadl23113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred13_InternalAadl23190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred14_InternalAadl23443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred15_InternalAadl23575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred16_InternalAadl23651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred17_InternalAadl23697 = new BitSet(new long[]{0x0000000000000002L});

}