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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SEMI", "RULE_COMMA", "RULE_LPARENS", "RULE_RPARENS", "RULE_COLON", "RULE_LTRANS", "RULE_RTRANS", "RULE_NONE", "RULE_DOT", "RULE_ANNEXTEXT", "RULE_EM", "RULE_SL_COMMENT", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_LCURLY", "RULE_RCURLY", "RULE_ASSIGN", "RULE_APPEND", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'end'", "'::'", "'public'", "'with'", "'private'", "'source'", "'sink'", "'path'", "'in'", "'modes'", "'flow'", "'->'", "'initial'", "'mode'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'prototypes'", "'features'", "'flows'", "'implementation'", "'subcomponents'", "'connections'", "'feature'", "'port'", "'event'", "'out'", "'all'", "'<->'", "'access'", "'parameter'", "'annex'"
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
    public static final int RULE_DOT=13;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_LPARENS=7;
    public static final int RULE_INT=23;
    public static final int T__50=50;
    public static final int RULE_RBRACKET=18;
    public static final int RULE_SEMI=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_RPARENS=8;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_APPEND=22;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_LTRANS=10;
    public static final int RULE_COMMA=6;
    public static final int RULE_SL_COMMENT=16;
    public static final int RULE_NONE=12;
    public static final int RULE_ML_COMMENT=25;
    public static final int T__30=30;
    public static final int RULE_COLON=9;
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
    public static final int RULE_RTRANS=11;
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
                case 52:
                    {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==58) ) {
                        alt6=2;
                    }
                    else if ( (LA6_2==RULE_ID) ) {
                        alt6=1;
                    }


                    }
                    break;
                case 49:
                    {
                    alt6=3;
                    }
                    break;
                case 45:
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
                case 52:
                    {
                    int LA9_2 = input.LA(2);

                    if ( (LA9_2==RULE_ID) ) {
                        alt9=1;
                    }
                    else if ( (LA9_2==58) ) {
                        alt9=2;
                    }


                    }
                    break;
                case 49:
                    {
                    alt9=3;
                    }
                    break;
                case 45:
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


    // $ANTLR start "entryRuleFlowSource"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:490:1: entryRuleFlowSource returns [String current=null] : iv_ruleFlowSource= ruleFlowSource EOF ;
    public final String entryRuleFlowSource() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlowSource = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:491:2: (iv_ruleFlowSource= ruleFlowSource EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:492:2: iv_ruleFlowSource= ruleFlowSource EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSourceRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSource_in_entryRuleFlowSource897);
            iv_ruleFlowSource=ruleFlowSource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSource.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSource908); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSource"


    // $ANTLR start "ruleFlowSource"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:499:1: ruleFlowSource returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'source' ;
    public final AntlrDatatypeRuleToken ruleFlowSource() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:502:28: (kw= 'source' )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:504:2: kw= 'source'
            {
            kw=(Token)match(input,34,FOLLOW_34_in_ruleFlowSource945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFlowSourceAccess().getSourceKeyword()); 
                  
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
    // $ANTLR end "ruleFlowSource"


    // $ANTLR start "entryRuleFlowSink"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:517:1: entryRuleFlowSink returns [String current=null] : iv_ruleFlowSink= ruleFlowSink EOF ;
    public final String entryRuleFlowSink() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlowSink = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:518:2: (iv_ruleFlowSink= ruleFlowSink EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:519:2: iv_ruleFlowSink= ruleFlowSink EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSinkRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSink_in_entryRuleFlowSink985);
            iv_ruleFlowSink=ruleFlowSink();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSink.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSink996); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSink"


    // $ANTLR start "ruleFlowSink"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:526:1: ruleFlowSink returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'sink' ;
    public final AntlrDatatypeRuleToken ruleFlowSink() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:529:28: (kw= 'sink' )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:531:2: kw= 'sink'
            {
            kw=(Token)match(input,35,FOLLOW_35_in_ruleFlowSink1033); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFlowSinkAccess().getSinkKeyword()); 
                  
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
    // $ANTLR end "ruleFlowSink"


    // $ANTLR start "entryRuleFlowPath"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:544:1: entryRuleFlowPath returns [String current=null] : iv_ruleFlowPath= ruleFlowPath EOF ;
    public final String entryRuleFlowPath() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlowPath = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:545:2: (iv_ruleFlowPath= ruleFlowPath EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:546:2: iv_ruleFlowPath= ruleFlowPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowPathRule()); 
            }
            pushFollow(FOLLOW_ruleFlowPath_in_entryRuleFlowPath1073);
            iv_ruleFlowPath=ruleFlowPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowPath.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowPath1084); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowPath"


    // $ANTLR start "ruleFlowPath"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:553:1: ruleFlowPath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'path' ;
    public final AntlrDatatypeRuleToken ruleFlowPath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:556:28: (kw= 'path' )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:558:2: kw= 'path'
            {
            kw=(Token)match(input,36,FOLLOW_36_in_ruleFlowPath1121); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFlowPathAccess().getPathKeyword()); 
                  
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
    // $ANTLR end "ruleFlowPath"


    // $ANTLR start "entryRuleFlowSpecification"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:571:1: entryRuleFlowSpecification returns [EObject current=null] : iv_ruleFlowSpecification= ruleFlowSpecification EOF ;
    public final EObject entryRuleFlowSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecification = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:572:2: (iv_ruleFlowSpecification= ruleFlowSpecification EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:573:2: iv_ruleFlowSpecification= ruleFlowSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSpecification_in_entryRuleFlowSpecification1160);
            iv_ruleFlowSpecification=ruleFlowSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecification1170); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:580:1: ruleFlowSpecification returns [EObject current=null] : (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | (this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI ) ) ;
    public final EObject ruleFlowSpecification() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_LPARENS_5=null;
        Token otherlv_6=null;
        Token this_RPARENS_7=null;
        Token this_SEMI_8=null;
        EObject this_FlowSourceSpec_0 = null;

        EObject this_FlowSinkSpec_1 = null;

        EObject this_FlowPathSpec_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:583:28: ( (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | (this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:584:1: (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | (this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:584:1: (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | (this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==RULE_COLON) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==39) ) {
                        switch ( input.LA(4) ) {
                        case 35:
                            {
                            alt12=2;
                            }
                            break;
                        case 34:
                            {
                            alt12=1;
                            }
                            break;
                        case 36:
                            {
                            alt12=3;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:585:5: this_FlowSourceSpec_0= ruleFlowSourceSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowSourceSpecParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowSourceSpec_in_ruleFlowSpecification1217);
                    this_FlowSourceSpec_0=ruleFlowSourceSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FlowSourceSpec_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:595:5: this_FlowSinkSpec_1= ruleFlowSinkSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowSinkSpecParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowSinkSpec_in_ruleFlowSpecification1244);
                    this_FlowSinkSpec_1=ruleFlowSinkSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FlowSinkSpec_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:604:6: (this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:604:6: (this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:605:5: this_FlowPathSpec_2= ruleFlowPathSpec ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )? this_SEMI_8= RULE_SEMI
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowPathSpecParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowPathSpec_in_ruleFlowSpecification1272);
                    this_FlowPathSpec_2=ruleFlowPathSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FlowPathSpec_2; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:613:1: ( ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==37) && (synpred3_InternalAadl2())) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:613:2: ( ( 'in' )=>otherlv_3= 'in' ) otherlv_4= 'modes' this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) )+ this_RPARENS_7= RULE_RPARENS
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:613:2: ( ( 'in' )=>otherlv_3= 'in' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:613:3: ( 'in' )=>otherlv_3= 'in'
                            {
                            otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleFlowSpecification1292); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getFlowSpecificationAccess().getInKeyword_2_1_0());
                                  
                            }

                            }

                            otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleFlowSpecification1305); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationAccess().getModesKeyword_2_1_1());
                                  
                            }
                            this_LPARENS_5=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleFlowSpecification1316); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_LPARENS_5, grammarAccess.getFlowSpecificationAccess().getLPARENSTerminalRuleCall_2_1_2()); 
                                  
                            }
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:626:1: ( (otherlv_6= RULE_ID ) )+
                            int cnt10=0;
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==RULE_ID) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:627:1: (otherlv_6= RULE_ID )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:627:1: (otherlv_6= RULE_ID )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:628:3: otherlv_6= RULE_ID
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      			if (current==null) {
                            	      	            current = createModelElement(grammarAccess.getFlowSpecificationRule());
                            	      	        }
                            	              
                            	    }
                            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecification1335); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      		newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationAccess().getInModeModeCrossReference_2_1_3_0()); 
                            	      	
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt10 >= 1 ) break loop10;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(10, input);
                                        throw eee;
                                }
                                cnt10++;
                            } while (true);

                            this_RPARENS_7=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleFlowSpecification1347); if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                  newLeafNode(this_RPARENS_7, grammarAccess.getFlowSpecificationAccess().getRPARENSTerminalRuleCall_2_1_4()); 
                                  
                            }

                            }
                            break;

                    }

                    this_SEMI_8=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFlowSpecification1359); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SEMI_8, grammarAccess.getFlowSpecificationAccess().getSEMITerminalRuleCall_2_2()); 
                          
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
    // $ANTLR end "ruleFlowSpecification"


    // $ANTLR start "entryRuleFlowSourceSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:655:1: entryRuleFlowSourceSpec returns [EObject current=null] : iv_ruleFlowSourceSpec= ruleFlowSourceSpec EOF ;
    public final EObject entryRuleFlowSourceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSourceSpec = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:656:2: (iv_ruleFlowSourceSpec= ruleFlowSourceSpec EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:657:2: iv_ruleFlowSourceSpec= ruleFlowSourceSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSourceSpecRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSourceSpec_in_entryRuleFlowSourceSpec1395);
            iv_ruleFlowSourceSpec=ruleFlowSourceSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSourceSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSourceSpec1405); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSourceSpec"


    // $ANTLR start "ruleFlowSourceSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:664:1: ruleFlowSourceSpec returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSource ) ) ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleFlowSourceSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:667:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSource ) ) ( (otherlv_4= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:668:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSource ) ) ( (otherlv_4= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:668:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSource ) ) ( (otherlv_4= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:668:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSource ) ) ( (otherlv_4= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:668:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:669:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:670:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceSpec1447); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFlowSourceSpecAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSourceSpecRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSourceSpec1463); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSourceSpecAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleFlowSourceSpec1474); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSourceSpecAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:694:1: ( (lv_kind_3_0= ruleFlowSource ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:695:1: (lv_kind_3_0= ruleFlowSource )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:695:1: (lv_kind_3_0= ruleFlowSource )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:696:3: lv_kind_3_0= ruleFlowSource
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSourceSpecAccess().getKindFlowSourceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSource_in_ruleFlowSourceSpec1495);
            lv_kind_3_0=ruleFlowSource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSourceSpecRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_3_0, 
                      		"FlowSource");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:712:2: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:713:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:713:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:714:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSourceSpecRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceSpec1515); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getFlowSourceSpecAccess().getOutFeatureFeatureCrossReference_4_0()); 
              	
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
    // $ANTLR end "ruleFlowSourceSpec"


    // $ANTLR start "entryRuleFlowSinkSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:733:1: entryRuleFlowSinkSpec returns [EObject current=null] : iv_ruleFlowSinkSpec= ruleFlowSinkSpec EOF ;
    public final EObject entryRuleFlowSinkSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSinkSpec = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:734:2: (iv_ruleFlowSinkSpec= ruleFlowSinkSpec EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:735:2: iv_ruleFlowSinkSpec= ruleFlowSinkSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSinkSpecRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSinkSpec_in_entryRuleFlowSinkSpec1551);
            iv_ruleFlowSinkSpec=ruleFlowSinkSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSinkSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSinkSpec1561); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSinkSpec"


    // $ANTLR start "ruleFlowSinkSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:742:1: ruleFlowSinkSpec returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSink ) ) ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleFlowSinkSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:745:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSink ) ) ( (otherlv_4= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:746:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSink ) ) ( (otherlv_4= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:746:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSink ) ) ( (otherlv_4= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:746:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowSink ) ) ( (otherlv_4= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:746:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:747:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:747:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:748:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkSpec1603); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFlowSinkSpecAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSinkSpecRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSinkSpec1619); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSinkSpecAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleFlowSinkSpec1630); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSinkSpecAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:772:1: ( (lv_kind_3_0= ruleFlowSink ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:773:1: (lv_kind_3_0= ruleFlowSink )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:773:1: (lv_kind_3_0= ruleFlowSink )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:774:3: lv_kind_3_0= ruleFlowSink
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSinkSpecAccess().getKindFlowSinkParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSink_in_ruleFlowSinkSpec1651);
            lv_kind_3_0=ruleFlowSink();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSinkSpecRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_3_0, 
                      		"FlowSink");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:790:2: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:791:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:791:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:792:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSinkSpecRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkSpec1671); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getFlowSinkSpecAccess().getInFeatureFeatureCrossReference_4_0()); 
              	
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
    // $ANTLR end "ruleFlowSinkSpec"


    // $ANTLR start "entryRuleFlowPathSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:811:1: entryRuleFlowPathSpec returns [EObject current=null] : iv_ruleFlowPathSpec= ruleFlowPathSpec EOF ;
    public final EObject entryRuleFlowPathSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowPathSpec = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:812:2: (iv_ruleFlowPathSpec= ruleFlowPathSpec EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:813:2: iv_ruleFlowPathSpec= ruleFlowPathSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowPathSpecRule()); 
            }
            pushFollow(FOLLOW_ruleFlowPathSpec_in_entryRuleFlowPathSpec1707);
            iv_ruleFlowPathSpec=ruleFlowPathSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowPathSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowPathSpec1717); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowPathSpec"


    // $ANTLR start "ruleFlowPathSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:820:1: ruleFlowPathSpec returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowPath ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleFlowPathSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:823:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowPath ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:824:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowPath ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:824:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowPath ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:824:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'flow' ( (lv_kind_3_0= ruleFlowPath ) ) ( (otherlv_4= RULE_ID ) ) otherlv_5= '->' ( (otherlv_6= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:824:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:825:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:825:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:826:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec1759); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getFlowPathSpecAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowPathSpec1775); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowPathSpecAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleFlowPathSpec1786); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowPathSpecAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:850:1: ( (lv_kind_3_0= ruleFlowPath ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:851:1: (lv_kind_3_0= ruleFlowPath )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:851:1: (lv_kind_3_0= ruleFlowPath )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:852:3: lv_kind_3_0= ruleFlowPath
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowPathSpecAccess().getKindFlowPathParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowPath_in_ruleFlowPathSpec1807);
            lv_kind_3_0=ruleFlowPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowPathSpecRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_3_0, 
                      		"FlowPath");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:868:2: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:869:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:869:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:870:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec1827); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getFlowPathSpecAccess().getInFeatureFeatureCrossReference_4_0()); 
              	
            }

            }


            }

            otherlv_5=(Token)match(input,40,FOLLOW_40_in_ruleFlowPathSpec1839); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getFlowPathSpecAccess().getHyphenMinusGreaterThanSignKeyword_5());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:885:1: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:886:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:886:1: (otherlv_6= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:887:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec1859); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getFlowPathSpecAccess().getOutFeatureFeatureCrossReference_6_0()); 
              	
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
    // $ANTLR end "ruleFlowPathSpec"


    // $ANTLR start "entryRuleMode"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:906:1: entryRuleMode returns [EObject current=null] : iv_ruleMode= ruleMode EOF ;
    public final EObject entryRuleMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMode = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:907:2: (iv_ruleMode= ruleMode EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:908:2: iv_ruleMode= ruleMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeRule()); 
            }
            pushFollow(FOLLOW_ruleMode_in_entryRuleMode1895);
            iv_ruleMode=ruleMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMode; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMode1905); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:915:1: ruleMode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleMode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token lv_initial_2_0=null;
        Token otherlv_3=null;
        Token this_SEMI_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:918:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:919:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:919:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:919:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= 'initial' ) )? otherlv_3= 'mode' this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:919:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:920:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:920:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:921:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMode1947); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleMode1963); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getModeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:941:1: ( (lv_initial_2_0= 'initial' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==41) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:942:1: (lv_initial_2_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:942:1: (lv_initial_2_0= 'initial' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:943:3: lv_initial_2_0= 'initial'
                    {
                    lv_initial_2_0=(Token)match(input,41,FOLLOW_41_in_ruleMode1980); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleMode2006); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModeAccess().getModeKeyword_3());
                  
            }
            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleMode2017); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:972:1: entryRuleModeTransition returns [EObject current=null] : iv_ruleModeTransition= ruleModeTransition EOF ;
    public final EObject entryRuleModeTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransition = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:973:2: (iv_ruleModeTransition= ruleModeTransition EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:974:2: iv_ruleModeTransition= ruleModeTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeTransitionRule()); 
            }
            pushFollow(FOLLOW_ruleModeTransition_in_entryRuleModeTransition2052);
            iv_ruleModeTransition=ruleModeTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeTransition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransition2062); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:981:1: ruleModeTransition returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:984:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:985:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:985:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:985:2: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) this_SEMI_9= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:985:2: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==RULE_COLON) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:985:3: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:985:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:986:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:986:1: (lv_name_0_0= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:987:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition2105); if (state.failed) return current;
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

                    this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleModeTransition2121); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COLON_1, grammarAccess.getModeTransitionAccess().getCOLONTerminalRuleCall_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1007:3: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1008:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1008:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1009:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeTransitionRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition2142); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getModeTransitionAccess().getSourceModeCrossReference_1_0()); 
              	
            }

            }


            }

            this_LTRANS_3=(Token)match(input,RULE_LTRANS,FOLLOW_RULE_LTRANS_in_ruleModeTransition2153); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LTRANS_3, grammarAccess.getModeTransitionAccess().getLTRANSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1024:1: ( (lv_ownedTrigger_4_0= ruleTriggerPort ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1025:1: (lv_ownedTrigger_4_0= ruleTriggerPort )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1025:1: (lv_ownedTrigger_4_0= ruleTriggerPort )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1026:3: lv_ownedTrigger_4_0= ruleTriggerPort
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedTriggerTriggerPortParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerPort_in_ruleModeTransition2173);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1042:2: (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1042:3: this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) )
            	    {
            	    this_COMMA_5=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleModeTransition2185); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_5, grammarAccess.getModeTransitionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1046:1: ( (lv_ownedTrigger_6_0= ruleTriggerPort ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1047:1: (lv_ownedTrigger_6_0= ruleTriggerPort )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1047:1: (lv_ownedTrigger_6_0= ruleTriggerPort )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1048:3: lv_ownedTrigger_6_0= ruleTriggerPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedTriggerTriggerPortParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTriggerPort_in_ruleModeTransition2205);
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
            	    break loop15;
                }
            } while (true);

            this_RTRANS_7=(Token)match(input,RULE_RTRANS,FOLLOW_RULE_RTRANS_in_ruleModeTransition2218); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RTRANS_7, grammarAccess.getModeTransitionAccess().getRTRANSTerminalRuleCall_5()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1068:1: ( (otherlv_8= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1069:1: (otherlv_8= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1069:1: (otherlv_8= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1070:3: otherlv_8= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeTransitionRule());
              	        }
                      
            }
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition2237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_8, grammarAccess.getModeTransitionAccess().getDestinationModeCrossReference_6_0()); 
              	
            }

            }


            }

            this_SEMI_9=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleModeTransition2248); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1093:1: entryRuleTriggerPort returns [EObject current=null] : iv_ruleTriggerPort= ruleTriggerPort EOF ;
    public final EObject entryRuleTriggerPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1094:2: (iv_ruleTriggerPort= ruleTriggerPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1095:2: iv_ruleTriggerPort= ruleTriggerPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggerPortRule()); 
            }
            pushFollow(FOLLOW_ruleTriggerPort_in_entryRuleTriggerPort2283);
            iv_ruleTriggerPort=ruleTriggerPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggerPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerPort2293); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1102:1: ruleTriggerPort returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleTriggerPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1105:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1106:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1106:1: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1107:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1107:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1108:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTriggerPortRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggerPort2337); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1127:1: entryRuleComponentCategoryKW returns [String current=null] : iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF ;
    public final String entryRuleComponentCategoryKW() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategoryKW = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1128:2: (iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1129:2: iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentCategoryKWRule()); 
            }
            pushFollow(FOLLOW_ruleComponentCategoryKW_in_entryRuleComponentCategoryKW2373);
            iv_ruleComponentCategoryKW=ruleComponentCategoryKW();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentCategoryKW.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategoryKW2384); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1136:1: ruleComponentCategoryKW returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategoryKW() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1139:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1140:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1140:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt16=13;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1141:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleComponentCategoryKW2422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getAbstractKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1148:2: kw= 'bus'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategoryKW2441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getBusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1155:2: kw= 'data'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleComponentCategoryKW2460); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getDataKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1162:2: kw= 'device'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategoryKW2479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1169:2: kw= 'memory'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategoryKW2498); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getMemoryKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1176:2: kw= 'process'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleComponentCategoryKW2517); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1183:2: kw= 'processor'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategoryKW2536); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessorKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1189:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1189:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1190:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleComponentCategoryKW2556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getSubprogramKeyword_7_0()); 
                          
                    }
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleComponentCategoryKW2569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getGroupKeyword_7_1()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1203:2: kw= 'system'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategoryKW2589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getSystemKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1209:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1209:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1210:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategoryKW2609); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getThreadKeyword_9_0()); 
                          
                    }
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleComponentCategoryKW2622); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getGroupKeyword_9_1()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1223:2: kw= 'thread'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategoryKW2642); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getThreadKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1229:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1229:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1230:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleComponentCategoryKW2662); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getVirtualKeyword_11_0()); 
                          
                    }
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategoryKW2675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getBusKeyword_11_1()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1242:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1242:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1243:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleComponentCategoryKW2696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getVirtualKeyword_12_0()); 
                          
                    }
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategoryKW2709); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1262:1: entryRuleSystemType returns [EObject current=null] : iv_ruleSystemType= ruleSystemType EOF ;
    public final EObject entryRuleSystemType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1263:2: (iv_ruleSystemType= ruleSystemType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1264:2: iv_ruleSystemType= ruleSystemType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSystemType_in_entryRuleSystemType2750);
            iv_ruleSystemType=ruleSystemType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemType2760); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1271:1: ruleSystemType returns [EObject current=null] : (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1274:28: ( (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1275:1: (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1275:1: (otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1275:3: otherlv_0= 'system' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= 'end' this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSystemType2797); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemTypeAccess().getSystemKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1279:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1280:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1280:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1281:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemType2814); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1297:2: ( ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==55) && (synpred4_InternalAadl2())) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1297:3: ( ( 'prototypes' )=>otherlv_2= 'prototypes' ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1297:3: ( ( 'prototypes' )=>otherlv_2= 'prototypes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1297:4: ( 'prototypes' )=>otherlv_2= 'prototypes'
                    {
                    otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleSystemType2840); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSystemTypeAccess().getPrototypesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1302:2: ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_NONE) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==RULE_ID) ) {
                        alt18=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1302:3: ( (lv_noPrototypes_3_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1302:3: ( (lv_noPrototypes_3_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1303:1: (lv_noPrototypes_3_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1303:1: (lv_noPrototypes_3_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1304:3: lv_noPrototypes_3_0= RULE_NONE
                            {
                            lv_noPrototypes_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType2859); if (state.failed) return current;
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1321:6: ( (lv_ownedPrototype_4_0= rulePrototype ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1321:6: ( (lv_ownedPrototype_4_0= rulePrototype ) )+
                            int cnt17=0;
                            loop17:
                            do {
                                int alt17=2;
                                int LA17_0 = input.LA(1);

                                if ( (LA17_0==RULE_ID) ) {
                                    alt17=1;
                                }


                                switch (alt17) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1322:1: (lv_ownedPrototype_4_0= rulePrototype )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1322:1: (lv_ownedPrototype_4_0= rulePrototype )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1323:3: lv_ownedPrototype_4_0= rulePrototype
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedPrototypePrototypeParserRuleCall_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_rulePrototype_in_ruleSystemType2891);
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
                            	    if ( cnt17 >= 1 ) break loop17;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(17, input);
                                        throw eee;
                                }
                                cnt17++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1339:6: ( ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) && (synpred5_InternalAadl2())) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1339:7: ( ( 'features' )=>otherlv_5= 'features' ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1339:7: ( ( 'features' )=>otherlv_5= 'features' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1339:8: ( 'features' )=>otherlv_5= 'features'
                    {
                    otherlv_5=(Token)match(input,56,FOLLOW_56_in_ruleSystemType2916); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSystemTypeAccess().getFeaturesKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1344:2: ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_NONE) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==RULE_ID) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1344:3: ( (lv_noFeatures_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1344:3: ( (lv_noFeatures_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1345:1: (lv_noFeatures_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1345:1: (lv_noFeatures_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1346:3: lv_noFeatures_6_0= RULE_NONE
                            {
                            lv_noFeatures_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType2935); if (state.failed) return current;
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+
                            int cnt20=0;
                            loop20:
                            do {
                                int alt20=4;
                                alt20 = dfa20.predict(input);
                                switch (alt20) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:7: ( (lv_ownedDataPort_7_0= ruleDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1363:7: ( (lv_ownedDataPort_7_0= ruleDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1364:1: (lv_ownedDataPort_7_0= ruleDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1364:1: (lv_ownedDataPort_7_0= ruleDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1365:3: lv_ownedDataPort_7_0= ruleDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedDataPortDataPortParserRuleCall_3_1_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataPort_in_ruleSystemType2968);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1382:6: ( (lv_ownedEventPort_8_0= ruleEventPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1382:6: ( (lv_ownedEventPort_8_0= ruleEventPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1383:1: (lv_ownedEventPort_8_0= ruleEventPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1383:1: (lv_ownedEventPort_8_0= ruleEventPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1384:3: lv_ownedEventPort_8_0= ruleEventPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedEventPortEventPortParserRuleCall_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventPort_in_ruleSystemType2995);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1401:6: ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1401:6: ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1402:1: (lv_ownedEventDataPort_9_0= ruleEventDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1402:1: (lv_ownedEventDataPort_9_0= ruleEventDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1403:3: lv_ownedEventDataPort_9_0= ruleEventDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedEventDataPortEventDataPortParserRuleCall_3_1_1_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventDataPort_in_ruleSystemType3022);
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
                            	    if ( cnt20 >= 1 ) break loop20;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(20, input);
                                        throw eee;
                                }
                                cnt20++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1419:7: ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==57) && (synpred6_InternalAadl2())) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1419:8: ( ( 'flows' )=>otherlv_10= 'flows' ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1419:8: ( ( 'flows' )=>otherlv_10= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1419:9: ( 'flows' )=>otherlv_10= 'flows'
                    {
                    otherlv_10=(Token)match(input,57,FOLLOW_57_in_ruleSystemType3048); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSystemTypeAccess().getFlowsKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1424:2: ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==RULE_ID) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==RULE_NONE) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1424:3: ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1424:3: ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+
                            int cnt23=0;
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==RULE_ID) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1425:1: (lv_ownedFlowSpecification_11_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1425:1: (lv_ownedFlowSpecification_11_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1426:3: lv_ownedFlowSpecification_11_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_4_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleSystemType3071);
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
                            	    if ( cnt23 >= 1 ) break loop23;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(23, input);
                                        throw eee;
                                }
                                cnt23++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1443:6: ( (lv_noFlows_12_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1443:6: ( (lv_noFlows_12_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1444:1: (lv_noFlows_12_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1444:1: (lv_noFlows_12_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1445:3: lv_noFlows_12_0= RULE_NONE
                            {
                            lv_noFlows_12_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType3095); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:5: ( ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==38) && (synpred7_InternalAadl2())) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_NONE) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:6: ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:6: ( ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:7: ( ( 'modes' )=>otherlv_13= 'modes' ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:7: ( ( 'modes' )=>otherlv_13= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:8: ( 'modes' )=>otherlv_13= 'modes'
                    {
                    otherlv_13=(Token)match(input,38,FOLLOW_38_in_ruleSystemType3125); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSystemTypeAccess().getModesKeyword_5_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1466:2: ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=3;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            int LA26_2 = input.LA(2);

                            if ( (LA26_2==RULE_LTRANS) ) {
                                alt26=2;
                            }
                            else if ( (LA26_2==RULE_COLON) ) {
                                int LA26_4 = input.LA(3);

                                if ( ((LA26_4>=41 && LA26_4<=42)) ) {
                                    alt26=1;
                                }
                                else if ( (LA26_4==RULE_ID) ) {
                                    alt26=2;
                                }


                            }


                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1466:3: ( (lv_ownedMode_14_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1466:3: ( (lv_ownedMode_14_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1467:1: (lv_ownedMode_14_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1467:1: (lv_ownedMode_14_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1468:3: lv_ownedMode_14_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedModeModeParserRuleCall_5_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleSystemType3148);
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1485:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1485:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1486:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1486:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1487:3: lv_ownedModeTransition_15_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_5_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleSystemType3175);
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
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1504:6: ( (lv_noModes_16_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1504:6: ( (lv_noModes_16_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1505:1: (lv_noModes_16_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1505:1: (lv_noModes_16_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1506:3: lv_noModes_16_0= RULE_NONE
                    {
                    lv_noModes_16_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType3201); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1522:4: ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==69) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1523:1: (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1523:1: (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1524:3: lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleSystemType3229);
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
            	    break loop28;
                }
            } while (true);

            otherlv_18=(Token)match(input,29,FOLLOW_29_in_ruleSystemType3242); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_18, grammarAccess.getSystemTypeAccess().getEndKeyword_7());
                  
            }
            this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemType3253); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_19, grammarAccess.getSystemTypeAccess().getIDTerminalRuleCall_8()); 
                  
            }
            this_SEMI_20=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemType3263); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1564:1: entryRuleProcessorType returns [EObject current=null] : iv_ruleProcessorType= ruleProcessorType EOF ;
    public final EObject entryRuleProcessorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessorType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1565:2: (iv_ruleProcessorType= ruleProcessorType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1566:2: iv_ruleProcessorType= ruleProcessorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessorTypeRule()); 
            }
            pushFollow(FOLLOW_ruleProcessorType_in_entryRuleProcessorType3302);
            iv_ruleProcessorType=ruleProcessorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessorType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcessorType3312); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1573:1: ruleProcessorType returns [EObject current=null] : (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1576:28: ( (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1577:1: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1577:1: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1577:3: otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= 'end' this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleProcessorType3349); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProcessorTypeAccess().getProcessorKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1581:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1582:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1582:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1583:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorType3366); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1599:2: ( ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==56) && (synpred8_InternalAadl2())) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1599:3: ( ( 'features' )=>otherlv_2= 'features' ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1599:3: ( ( 'features' )=>otherlv_2= 'features' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1599:4: ( 'features' )=>otherlv_2= 'features'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleProcessorType3392); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getProcessorTypeAccess().getFeaturesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:2: ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==RULE_NONE) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==RULE_ID) ) {
                        alt30=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:3: ( (lv_noFeatures_3_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1604:3: ( (lv_noFeatures_3_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1605:1: (lv_noFeatures_3_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1605:1: (lv_noFeatures_3_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1606:3: lv_noFeatures_3_0= RULE_NONE
                            {
                            lv_noFeatures_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType3411); if (state.failed) return current;
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1623:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1623:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+
                            int cnt29=0;
                            loop29:
                            do {
                                int alt29=4;
                                alt29 = dfa29.predict(input);
                                switch (alt29) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1623:7: ( (lv_ownedDataPort_4_0= ruleDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1623:7: ( (lv_ownedDataPort_4_0= ruleDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1624:1: (lv_ownedDataPort_4_0= ruleDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1624:1: (lv_ownedDataPort_4_0= ruleDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1625:3: lv_ownedDataPort_4_0= ruleDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedDataPortDataPortParserRuleCall_2_1_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataPort_in_ruleProcessorType3444);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1642:6: ( (lv_ownedEventPort_5_0= ruleEventPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1642:6: ( (lv_ownedEventPort_5_0= ruleEventPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1643:1: (lv_ownedEventPort_5_0= ruleEventPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1643:1: (lv_ownedEventPort_5_0= ruleEventPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1644:3: lv_ownedEventPort_5_0= ruleEventPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedEventPortEventPortParserRuleCall_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventPort_in_ruleProcessorType3471);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1661:6: ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1661:6: ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1662:1: (lv_ownedEventDataPort_6_0= ruleEventDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1662:1: (lv_ownedEventDataPort_6_0= ruleEventDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1663:3: lv_ownedEventDataPort_6_0= ruleEventDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedEventDataPortEventDataPortParserRuleCall_2_1_1_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventDataPort_in_ruleProcessorType3498);
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
                            	    if ( cnt29 >= 1 ) break loop29;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(29, input);
                                        throw eee;
                                }
                                cnt29++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1679:7: ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==57) && (synpred9_InternalAadl2())) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1679:8: ( ( 'flows' )=>otherlv_7= 'flows' ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1679:8: ( ( 'flows' )=>otherlv_7= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1679:9: ( 'flows' )=>otherlv_7= 'flows'
                    {
                    otherlv_7=(Token)match(input,57,FOLLOW_57_in_ruleProcessorType3524); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getProcessorTypeAccess().getFlowsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1684:2: ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_ID) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==RULE_NONE) ) {
                        alt33=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1684:3: ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1684:3: ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+
                            int cnt32=0;
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==RULE_ID) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1685:1: (lv_ownedFlowSpecification_8_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1685:1: (lv_ownedFlowSpecification_8_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1686:3: lv_ownedFlowSpecification_8_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleProcessorType3547);
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
                            	    if ( cnt32 >= 1 ) break loop32;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(32, input);
                                        throw eee;
                                }
                                cnt32++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1703:6: ( (lv_noFlows_9_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1703:6: ( (lv_noFlows_9_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1704:1: (lv_noFlows_9_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1704:1: (lv_noFlows_9_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1705:3: lv_noFlows_9_0= RULE_NONE
                            {
                            lv_noFlows_9_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType3571); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:5: ( ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==38) && (synpred10_InternalAadl2())) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_NONE) ) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:6: ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:6: ( ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:7: ( ( 'modes' )=>otherlv_10= 'modes' ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:7: ( ( 'modes' )=>otherlv_10= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:8: ( 'modes' )=>otherlv_10= 'modes'
                    {
                    otherlv_10=(Token)match(input,38,FOLLOW_38_in_ruleProcessorType3601); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getProcessorTypeAccess().getModesKeyword_4_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1726:2: ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=3;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_ID) ) {
                            int LA35_2 = input.LA(2);

                            if ( (LA35_2==RULE_COLON) ) {
                                int LA35_3 = input.LA(3);

                                if ( (LA35_3==RULE_ID) ) {
                                    alt35=2;
                                }
                                else if ( ((LA35_3>=41 && LA35_3<=42)) ) {
                                    alt35=1;
                                }


                            }
                            else if ( (LA35_2==RULE_LTRANS) ) {
                                alt35=2;
                            }


                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1726:3: ( (lv_ownedMode_11_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1726:3: ( (lv_ownedMode_11_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1727:1: (lv_ownedMode_11_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1727:1: (lv_ownedMode_11_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1728:3: lv_ownedMode_11_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedModeModeParserRuleCall_4_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleProcessorType3624);
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1745:6: ( (lv_ownedModeTransition_12_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1745:6: ( (lv_ownedModeTransition_12_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1746:1: (lv_ownedModeTransition_12_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1746:1: (lv_ownedModeTransition_12_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1747:3: lv_ownedModeTransition_12_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_4_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleProcessorType3651);
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
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1764:6: ( (lv_noModes_13_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1764:6: ( (lv_noModes_13_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1765:1: (lv_noModes_13_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1765:1: (lv_noModes_13_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1766:3: lv_noModes_13_0= RULE_NONE
                    {
                    lv_noModes_13_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType3677); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1782:4: ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==69) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1783:1: (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1783:1: (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1784:3: lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleProcessorType3705);
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
            	    break loop37;
                }
            } while (true);

            otherlv_15=(Token)match(input,29,FOLLOW_29_in_ruleProcessorType3718); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getProcessorTypeAccess().getEndKeyword_6());
                  
            }
            this_ID_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorType3729); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_16, grammarAccess.getProcessorTypeAccess().getIDTerminalRuleCall_7()); 
                  
            }
            this_SEMI_17=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleProcessorType3739); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1820:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1821:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1822:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType3774);
            iv_ruleDataType=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType3784); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1829:1: ruleDataType returns [EObject current=null] : (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1832:28: ( (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1833:1: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1833:1: (otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1833:3: otherlv_0= 'data' ( (lv_name_1_0= RULE_ID ) ) ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )* otherlv_12= 'end' this_ID_13= RULE_ID this_SEMI_14= RULE_SEMI
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleDataType3821); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDataTypeAccess().getDataKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1837:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1838:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1838:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1839:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType3838); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1855:2: ( ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==56) && (synpred11_InternalAadl2())) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1855:3: ( ( 'features' )=>otherlv_2= 'features' ) ( (lv_noFeatures_3_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1855:3: ( ( 'features' )=>otherlv_2= 'features' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1855:4: ( 'features' )=>otherlv_2= 'features'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleDataType3864); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDataTypeAccess().getFeaturesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1860:2: ( (lv_noFeatures_3_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1861:1: (lv_noFeatures_3_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1861:1: (lv_noFeatures_3_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1862:3: lv_noFeatures_3_0= RULE_NONE
                    {
                    lv_noFeatures_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType3882); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1878:4: ( ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==57) && (synpred12_InternalAadl2())) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1878:5: ( ( 'flows' )=>otherlv_4= 'flows' ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1878:5: ( ( 'flows' )=>otherlv_4= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1878:6: ( 'flows' )=>otherlv_4= 'flows'
                    {
                    otherlv_4=(Token)match(input,57,FOLLOW_57_in_ruleDataType3910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDataTypeAccess().getFlowsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1883:2: ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==RULE_ID) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==RULE_NONE) ) {
                        alt40=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1883:3: ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1883:3: ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+
                            int cnt39=0;
                            loop39:
                            do {
                                int alt39=2;
                                int LA39_0 = input.LA(1);

                                if ( (LA39_0==RULE_ID) ) {
                                    alt39=1;
                                }


                                switch (alt39) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1884:1: (lv_ownedFlowSpecification_5_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1884:1: (lv_ownedFlowSpecification_5_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1885:3: lv_ownedFlowSpecification_5_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleDataType3933);
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
                            	    if ( cnt39 >= 1 ) break loop39;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(39, input);
                                        throw eee;
                                }
                                cnt39++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1902:6: ( (lv_noFlows_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1902:6: ( (lv_noFlows_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1903:1: (lv_noFlows_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1903:1: (lv_noFlows_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1904:3: lv_noFlows_6_0= RULE_NONE
                            {
                            lv_noFlows_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType3957); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:5: ( ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )?
            int alt43=3;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==38) && (synpred13_InternalAadl2())) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_NONE) ) {
                alt43=2;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:6: ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:6: ( ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:7: ( ( 'modes' )=>otherlv_7= 'modes' ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:7: ( ( 'modes' )=>otherlv_7= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:8: ( 'modes' )=>otherlv_7= 'modes'
                    {
                    otherlv_7=(Token)match(input,38,FOLLOW_38_in_ruleDataType3987); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDataTypeAccess().getModesKeyword_4_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1925:2: ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=3;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            int LA42_2 = input.LA(2);

                            if ( (LA42_2==RULE_COLON) ) {
                                int LA42_3 = input.LA(3);

                                if ( (LA42_3==RULE_ID) ) {
                                    alt42=2;
                                }
                                else if ( ((LA42_3>=41 && LA42_3<=42)) ) {
                                    alt42=1;
                                }


                            }
                            else if ( (LA42_2==RULE_LTRANS) ) {
                                alt42=2;
                            }


                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1925:3: ( (lv_ownedMode_8_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1925:3: ( (lv_ownedMode_8_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1926:1: (lv_ownedMode_8_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1926:1: (lv_ownedMode_8_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1927:3: lv_ownedMode_8_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedModeModeParserRuleCall_4_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleDataType4010);
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1944:6: ( (lv_ownedModeTransition_9_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1944:6: ( (lv_ownedModeTransition_9_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1945:1: (lv_ownedModeTransition_9_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1945:1: (lv_ownedModeTransition_9_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1946:3: lv_ownedModeTransition_9_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_4_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleDataType4037);
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
                    	    if ( cnt42 >= 1 ) break loop42;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1963:6: ( (lv_noModes_10_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1963:6: ( (lv_noModes_10_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1964:1: (lv_noModes_10_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1964:1: (lv_noModes_10_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1965:3: lv_noModes_10_0= RULE_NONE
                    {
                    lv_noModes_10_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType4063); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1981:4: ( (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==69) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1982:1: (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1982:1: (lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1983:3: lv_ownedAnnexSubclause_11_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleDataType4091);
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
            	    break loop44;
                }
            } while (true);

            otherlv_12=(Token)match(input,29,FOLLOW_29_in_ruleDataType4104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getDataTypeAccess().getEndKeyword_6());
                  
            }
            this_ID_13=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType4115); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_13, grammarAccess.getDataTypeAccess().getIDTerminalRuleCall_7()); 
                  
            }
            this_SEMI_14=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataType4125); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2019:1: entryRuleSystemImplementation returns [EObject current=null] : iv_ruleSystemImplementation= ruleSystemImplementation EOF ;
    public final EObject entryRuleSystemImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemImplementation = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2020:2: (iv_ruleSystemImplementation= ruleSystemImplementation EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2021:2: iv_ruleSystemImplementation= ruleSystemImplementation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemImplementationRule()); 
            }
            pushFollow(FOLLOW_ruleSystemImplementation_in_entryRuleSystemImplementation4160);
            iv_ruleSystemImplementation=ruleSystemImplementation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemImplementation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemImplementation4170); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2028:1: ruleSystemImplementation returns [EObject current=null] : (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2031:28: ( (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2032:1: (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2032:1: (otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2032:3: otherlv_0= 'system' otherlv_1= 'implementation' ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )? ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )? ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )? ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )* otherlv_17= 'end' this_ID_18= RULE_ID this_DOT_19= RULE_DOT ruleINAME this_SEMI_21= RULE_SEMI
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSystemImplementation4207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemImplementationAccess().getSystemKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleSystemImplementation4219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSystemImplementationAccess().getImplementationKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2040:1: ( ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==59) && (synpred14_InternalAadl2())) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2040:2: ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' ) ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2040:2: ( ( 'subcomponents' )=>otherlv_2= 'subcomponents' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2040:3: ( 'subcomponents' )=>otherlv_2= 'subcomponents'
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleSystemImplementation4240); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSystemImplementationAccess().getSubcomponentsKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2045:2: ( ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_6_0= RULE_NONE ) ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==RULE_ID) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==RULE_NONE) ) {
                        alt46=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2045:3: ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2045:3: ( ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) ) )+
                            int cnt45=0;
                            loop45:
                            do {
                                int alt45=4;
                                int LA45_0 = input.LA(1);

                                if ( (LA45_0==RULE_ID) ) {
                                    int LA45_2 = input.LA(2);

                                    if ( (LA45_2==RULE_COLON) ) {
                                        switch ( input.LA(3) ) {
                                        case 52:
                                            {
                                            alt45=1;
                                            }
                                            break;
                                        case 45:
                                            {
                                            alt45=3;
                                            }
                                            break;
                                        case 49:
                                            {
                                            alt45=2;
                                            }
                                            break;

                                        }

                                    }


                                }


                                switch (alt45) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2045:4: ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2045:4: ( (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2046:1: (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2046:1: (lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2047:3: lv_ownedSystemSubcomponent_3_0= ruleSystemSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedSystemSubcomponentSystemSubcomponentParserRuleCall_2_1_0_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleSystemSubcomponent_in_ruleSystemImplementation4264);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2064:6: ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2064:6: ( (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2065:1: (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2065:1: (lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2066:3: lv_ownedProcessorSubcomponent_4_0= ruleProcessorSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedProcessorSubcomponentProcessorSubcomponentParserRuleCall_2_1_0_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleProcessorSubcomponent_in_ruleSystemImplementation4291);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2083:6: ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2083:6: ( (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2084:1: (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2084:1: (lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2085:3: lv_ownedDataSubcomponent_5_0= ruleDataSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedDataSubcomponentDataSubcomponentParserRuleCall_2_1_0_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataSubcomponent_in_ruleSystemImplementation4318);
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
                            	    if ( cnt45 >= 1 ) break loop45;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(45, input);
                                        throw eee;
                                }
                                cnt45++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2102:6: ( (lv_noSubcomponents_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2102:6: ( (lv_noSubcomponents_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2103:1: (lv_noSubcomponents_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2103:1: (lv_noSubcomponents_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2104:3: lv_noSubcomponents_6_0= RULE_NONE
                            {
                            lv_noSubcomponents_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation4343); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2120:5: ( ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==60) && (synpred15_InternalAadl2())) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2120:6: ( ( 'connections' )=>otherlv_7= 'connections' ) ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2120:6: ( ( 'connections' )=>otherlv_7= 'connections' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2120:7: ( 'connections' )=>otherlv_7= 'connections'
                    {
                    otherlv_7=(Token)match(input,60,FOLLOW_60_in_ruleSystemImplementation4372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSystemImplementationAccess().getConnectionsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2125:2: ( ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+ | ( (lv_noConnections_9_0= RULE_NONE ) ) )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==RULE_ID) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==RULE_NONE) ) {
                        alt49=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2125:3: ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2125:3: ( (lv_ownedPortConnection_8_0= rulePortConnection ) )+
                            int cnt48=0;
                            loop48:
                            do {
                                int alt48=2;
                                int LA48_0 = input.LA(1);

                                if ( (LA48_0==RULE_ID) ) {
                                    alt48=1;
                                }


                                switch (alt48) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2126:1: (lv_ownedPortConnection_8_0= rulePortConnection )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2126:1: (lv_ownedPortConnection_8_0= rulePortConnection )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2127:3: lv_ownedPortConnection_8_0= rulePortConnection
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedPortConnectionPortConnectionParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_rulePortConnection_in_ruleSystemImplementation4395);
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
                            	    if ( cnt48 >= 1 ) break loop48;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(48, input);
                                        throw eee;
                                }
                                cnt48++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2144:6: ( (lv_noConnections_9_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2144:6: ( (lv_noConnections_9_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2145:1: (lv_noConnections_9_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2145:1: (lv_noConnections_9_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2146:3: lv_noConnections_9_0= RULE_NONE
                            {
                            lv_noConnections_9_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation4419); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2162:5: ( ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==57) && (synpred16_InternalAadl2())) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2162:6: ( ( 'flows' )=>otherlv_10= 'flows' ) ( (lv_noFlows_11_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2162:6: ( ( 'flows' )=>otherlv_10= 'flows' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2162:7: ( 'flows' )=>otherlv_10= 'flows'
                    {
                    otherlv_10=(Token)match(input,57,FOLLOW_57_in_ruleSystemImplementation4448); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSystemImplementationAccess().getFlowsKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2167:2: ( (lv_noFlows_11_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2168:1: (lv_noFlows_11_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2168:1: (lv_noFlows_11_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2169:3: lv_noFlows_11_0= RULE_NONE
                    {
                    lv_noFlows_11_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation4466); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:4: ( ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==38) && (synpred17_InternalAadl2())) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:5: ( ( 'modes' )=>otherlv_12= 'modes' ) ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:5: ( ( 'modes' )=>otherlv_12= 'modes' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:6: ( 'modes' )=>otherlv_12= 'modes'
                    {
                    otherlv_12=(Token)match(input,38,FOLLOW_38_in_ruleSystemImplementation4494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getSystemImplementationAccess().getModesKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2190:2: ( ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+ | ( (lv_noModes_15_0= RULE_NONE ) ) )
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==RULE_ID) ) {
                        alt53=1;
                    }
                    else if ( (LA53_0==RULE_NONE) ) {
                        alt53=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 0, input);

                        throw nvae;
                    }
                    switch (alt53) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2190:3: ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2190:3: ( ( (lv_ownedMode_13_0= ruleMode ) ) | ( (lv_ownedModeTransition_14_0= ruleModeTransition ) ) )+
                            int cnt52=0;
                            loop52:
                            do {
                                int alt52=3;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==RULE_ID) ) {
                                    int LA52_2 = input.LA(2);

                                    if ( (LA52_2==RULE_LTRANS) ) {
                                        alt52=2;
                                    }
                                    else if ( (LA52_2==RULE_COLON) ) {
                                        int LA52_4 = input.LA(3);

                                        if ( ((LA52_4>=41 && LA52_4<=42)) ) {
                                            alt52=1;
                                        }
                                        else if ( (LA52_4==RULE_ID) ) {
                                            alt52=2;
                                        }


                                    }


                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2190:4: ( (lv_ownedMode_13_0= ruleMode ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2190:4: ( (lv_ownedMode_13_0= ruleMode ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2191:1: (lv_ownedMode_13_0= ruleMode )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2191:1: (lv_ownedMode_13_0= ruleMode )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2192:3: lv_ownedMode_13_0= ruleMode
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedModeModeParserRuleCall_5_1_0_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleMode_in_ruleSystemImplementation4518);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2209:6: ( (lv_ownedModeTransition_14_0= ruleModeTransition ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2209:6: ( (lv_ownedModeTransition_14_0= ruleModeTransition ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2210:1: (lv_ownedModeTransition_14_0= ruleModeTransition )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2210:1: (lv_ownedModeTransition_14_0= ruleModeTransition )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2211:3: lv_ownedModeTransition_14_0= ruleModeTransition
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedModeTransitionModeTransitionParserRuleCall_5_1_0_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeTransition_in_ruleSystemImplementation4545);
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
                            	    if ( cnt52 >= 1 ) break loop52;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(52, input);
                                        throw eee;
                                }
                                cnt52++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2228:6: ( (lv_noModes_15_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2228:6: ( (lv_noModes_15_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2229:1: (lv_noModes_15_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2229:1: (lv_noModes_15_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2230:3: lv_noModes_15_0= RULE_NONE
                            {
                            lv_noModes_15_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation4570); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2246:5: ( (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==69) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2247:1: (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2247:1: (lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2248:3: lv_ownedAnnexSubclause_16_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleSystemImplementation4599);
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
            	    break loop55;
                }
            } while (true);

            otherlv_17=(Token)match(input,29,FOLLOW_29_in_ruleSystemImplementation4612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_17, grammarAccess.getSystemImplementationAccess().getEndKeyword_7());
                  
            }
            this_ID_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemImplementation4623); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_18, grammarAccess.getSystemImplementationAccess().getIDTerminalRuleCall_8()); 
                  
            }
            this_DOT_19=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSystemImplementation4633); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_19, grammarAccess.getSystemImplementationAccess().getDOTTerminalRuleCall_9()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSystemImplementationAccess().getINAMEParserRuleCall_10()); 
                  
            }
            pushFollow(FOLLOW_ruleINAME_in_ruleSystemImplementation4648);
            ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            this_SEMI_21=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemImplementation4658); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2300:1: entryRulePrototype returns [EObject current=null] : iv_rulePrototype= rulePrototype EOF ;
    public final EObject entryRulePrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2301:2: (iv_rulePrototype= rulePrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2302:2: iv_rulePrototype= rulePrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrototypeRule()); 
            }
            pushFollow(FOLLOW_rulePrototype_in_entryRulePrototype4697);
            iv_rulePrototype=rulePrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrototype4707); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2309:1: rulePrototype returns [EObject current=null] : (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ;
    public final EObject rulePrototype() throws RecognitionException {
        EObject current = null;

        EObject this_ComponentPrototype_0 = null;

        EObject this_FeatureGroupPrototype_1 = null;

        EObject this_FeaturePrototype_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2312:28: ( (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2313:1: (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2313:1: (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype )
            int alt56=3;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==RULE_COLON) ) {
                    int LA56_2 = input.LA(3);

                    if ( ((LA56_2>=43 && LA56_2<=50)||(LA56_2>=52 && LA56_2<=54)) ) {
                        alt56=1;
                    }
                    else if ( (LA56_2==61) ) {
                        int LA56_4 = input.LA(4);

                        if ( (LA56_4==51) ) {
                            alt56=2;
                        }
                        else if ( ((LA56_4>=RULE_ID && LA56_4<=RULE_SEMI)||LA56_4==37||LA56_4==64) ) {
                            alt56=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 56, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2314:5: this_ComponentPrototype_0= ruleComponentPrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getComponentPrototypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentPrototype_in_rulePrototype4754);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2324:5: this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getFeatureGroupPrototypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureGroupPrototype_in_rulePrototype4781);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2334:5: this_FeaturePrototype_2= ruleFeaturePrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getFeaturePrototypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeaturePrototype_in_rulePrototype4808);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2350:1: entryRuleComponentPrototype returns [EObject current=null] : iv_ruleComponentPrototype= ruleComponentPrototype EOF ;
    public final EObject entryRuleComponentPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentPrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2351:2: (iv_ruleComponentPrototype= ruleComponentPrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2352:2: iv_ruleComponentPrototype= ruleComponentPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleComponentPrototype_in_entryRuleComponentPrototype4843);
            iv_ruleComponentPrototype=ruleComponentPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentPrototype4853); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2359:1: ruleComponentPrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleComponentPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token this_SEMI_4=null;
        AntlrDatatypeRuleToken lv_category_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2362:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2363:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2363:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2363:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_category_2_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2363:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2364:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2364:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2365:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentPrototype4895); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleComponentPrototype4911); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getComponentPrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2385:1: ( (lv_category_2_0= ruleComponentCategoryKW ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2386:1: (lv_category_2_0= ruleComponentCategoryKW )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2386:1: (lv_category_2_0= ruleComponentCategoryKW )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2387:3: lv_category_2_0= ruleComponentCategoryKW
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentPrototypeAccess().getCategoryComponentCategoryKWParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleComponentCategoryKW_in_ruleComponentPrototype4931);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2403:2: ( ( ruleQCREF ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2404:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2404:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2405:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getComponentPrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentPrototypeAccess().getConstrainingClassifierComponentClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleComponentPrototype4954);
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

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleComponentPrototype4966); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2430:1: entryRuleFeatureGroupPrototype returns [EObject current=null] : iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF ;
    public final EObject entryRuleFeatureGroupPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureGroupPrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2431:2: (iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2432:2: iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureGroupPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureGroupPrototype_in_entryRuleFeatureGroupPrototype5001);
            iv_ruleFeatureGroupPrototype=ruleFeatureGroupPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureGroupPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureGroupPrototype5011); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2439:1: ruleFeatureGroupPrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleFeatureGroupPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2442:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2443:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2443:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2443:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' otherlv_3= 'group' ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2443:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2444:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2444:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2445:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureGroupPrototype5053); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFeatureGroupPrototype5069); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFeatureGroupPrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleFeatureGroupPrototype5080); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeatureGroupPrototypeAccess().getFeatureKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleFeatureGroupPrototype5092); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureGroupPrototypeAccess().getGroupKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2473:1: ( ( ruleQCREF ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2474:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2474:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2475:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeatureGroupPrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureGroupPrototypeAccess().getConstrainingFeatureGroupTypeFeatureGroupTypeCrossReference_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleFeatureGroupPrototype5115);
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

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeatureGroupPrototype5127); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2500:1: entryRuleFeaturePrototype returns [EObject current=null] : iv_ruleFeaturePrototype= ruleFeaturePrototype EOF ;
    public final EObject entryRuleFeaturePrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeaturePrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2501:2: (iv_ruleFeaturePrototype= ruleFeaturePrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2502:2: iv_ruleFeaturePrototype= ruleFeaturePrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeaturePrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFeaturePrototype_in_entryRuleFeaturePrototype5162);
            iv_ruleFeaturePrototype=ruleFeaturePrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeaturePrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeaturePrototype5172); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2509:1: ruleFeaturePrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleFeaturePrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_SEMI_5=null;
        AntlrDatatypeRuleToken lv_direction_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2512:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2513:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2513:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2513:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'feature' ( (lv_direction_3_0= rulePortDirection ) )? ( ( ruleQCREF ) )? this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2513:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2514:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2514:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2515:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeaturePrototype5214); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFeaturePrototype5230); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFeaturePrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,61,FOLLOW_61_in_ruleFeaturePrototype5241); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeaturePrototypeAccess().getFeatureKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2539:1: ( (lv_direction_3_0= rulePortDirection ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==37||LA59_0==64) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2540:1: (lv_direction_3_0= rulePortDirection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2540:1: (lv_direction_3_0= rulePortDirection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2541:3: lv_direction_3_0= rulePortDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeaturePrototypeAccess().getDirectionPortDirectionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePortDirection_in_ruleFeaturePrototype5262);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2557:3: ( ( ruleQCREF ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ID) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2558:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2558:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2559:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeaturePrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeaturePrototypeAccess().getConstrainingClassifierComponentClassifierCrossReference_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleFeaturePrototype5286);
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

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeaturePrototype5298); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2584:1: entryRuleDataPort returns [EObject current=null] : iv_ruleDataPort= ruleDataPort EOF ;
    public final EObject entryRuleDataPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2585:2: (iv_ruleDataPort= ruleDataPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2586:2: iv_ruleDataPort= ruleDataPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataPortRule()); 
            }
            pushFollow(FOLLOW_ruleDataPort_in_entryRuleDataPort5333);
            iv_ruleDataPort=ruleDataPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataPort5343); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2593:1: ruleDataPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2596:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2597:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2597:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2597:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'data' otherlv_4= 'port' ( ( ruleQCREF ) )? this_SEMI_6= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2597:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2598:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2598:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2599:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataPort5385); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleDataPort5401); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getDataPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2619:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2620:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2620:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2621:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDataPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleDataPort5421);
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

            otherlv_3=(Token)match(input,45,FOLLOW_45_in_ruleDataPort5433); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDataPortAccess().getDataKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,62,FOLLOW_62_in_ruleDataPort5445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getDataPortAccess().getPortKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2645:1: ( ( ruleQCREF ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2646:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2646:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2647:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataPortRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDataPortAccess().getDataClassifierDataTypeCrossReference_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleDataPort5468);
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

            this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataPort5480); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2672:1: entryRuleEventDataPort returns [EObject current=null] : iv_ruleEventDataPort= ruleEventDataPort EOF ;
    public final EObject entryRuleEventDataPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDataPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2673:2: (iv_ruleEventDataPort= ruleEventDataPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2674:2: iv_ruleEventDataPort= ruleEventDataPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDataPortRule()); 
            }
            pushFollow(FOLLOW_ruleEventDataPort_in_entryRuleEventDataPort5515);
            iv_ruleEventDataPort=ruleEventDataPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDataPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDataPort5525); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2681:1: ruleEventDataPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2684:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2685:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2685:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2685:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'data' otherlv_5= 'port' ( ( ruleQCREF ) )? this_SEMI_7= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2685:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2686:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2686:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2687:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDataPort5567); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleEventDataPort5583); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getEventDataPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2707:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2708:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2708:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2709:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventDataPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleEventDataPort5603);
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

            otherlv_3=(Token)match(input,63,FOLLOW_63_in_ruleEventDataPort5615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEventDataPortAccess().getEventKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleEventDataPort5627); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventDataPortAccess().getDataKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,62,FOLLOW_62_in_ruleEventDataPort5639); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEventDataPortAccess().getPortKeyword_5());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2737:1: ( ( ruleQCREF ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2738:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2738:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2739:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEventDataPortRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDataPortAccess().getDataClassifierDataTypeCrossReference_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleEventDataPort5662);
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

            this_SEMI_7=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEventDataPort5674); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2764:1: entryRuleEventPort returns [EObject current=null] : iv_ruleEventPort= ruleEventPort EOF ;
    public final EObject entryRuleEventPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2765:2: (iv_ruleEventPort= ruleEventPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2766:2: iv_ruleEventPort= ruleEventPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventPortRule()); 
            }
            pushFollow(FOLLOW_ruleEventPort_in_entryRuleEventPort5709);
            iv_ruleEventPort=ruleEventPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventPort5719); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2773:1: ruleEventPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2776:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2777:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2777:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2777:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= 'event' otherlv_4= 'port' this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2777:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2778:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2778:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2779:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventPort5761); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleEventPort5777); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getEventPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2799:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2800:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2800:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2801:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleEventPort5797);
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

            otherlv_3=(Token)match(input,63,FOLLOW_63_in_ruleEventPort5809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEventPortAccess().getEventKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,62,FOLLOW_62_in_ruleEventPort5821); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventPortAccess().getPortKeyword_4());
                  
            }
            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEventPort5832); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2837:1: entryRuleFeatureGroup returns [EObject current=null] : iv_ruleFeatureGroup= ruleFeatureGroup EOF ;
    public final EObject entryRuleFeatureGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureGroup = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2838:2: (iv_ruleFeatureGroup= ruleFeatureGroup EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2839:2: iv_ruleFeatureGroup= ruleFeatureGroup EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureGroupRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureGroup_in_entryRuleFeatureGroup5867);
            iv_ruleFeatureGroup=ruleFeatureGroup();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureGroup; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureGroup5877); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2846:1: ruleFeatureGroup returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleFeatureGroup() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_SEMI_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2849:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2850:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2850:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2850:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'feature' otherlv_2= 'group' ( ( ruleQCREF ) ) this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2850:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2851:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2851:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2852:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureGroup5919); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleFeatureGroup5936); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureGroupAccess().getFeatureKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleFeatureGroup5948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFeatureGroupAccess().getGroupKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2876:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2877:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2877:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2878:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureGroupRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureGroupAccess().getFeatureGroupTypeFeatureGroupTypeCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQCREF_in_ruleFeatureGroup5971);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeatureGroup5982); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2903:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2904:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2905:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature6017);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature6027); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2912:1: ruleFeature returns [EObject current=null] : (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Port_0 = null;

        EObject this_FeatureGroup_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2915:28: ( (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2916:1: (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2916:1: (this_Port_0= rulePort | this_FeatureGroup_1= ruleFeatureGroup )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==61) ) {
                    alt63=2;
                }
                else if ( (LA63_1==RULE_COLON) ) {
                    alt63=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2917:5: this_Port_0= rulePort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getPortParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePort_in_ruleFeature6074);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2927:5: this_FeatureGroup_1= ruleFeatureGroup
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFeatureAccess().getFeatureGroupParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureGroup_in_ruleFeature6101);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2943:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2944:2: (iv_rulePort= rulePort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2945:2: iv_rulePort= rulePort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortRule()); 
            }
            pushFollow(FOLLOW_rulePort_in_entryRulePort6136);
            iv_rulePort=rulePort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePort6146); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2952:1: rulePort returns [EObject current=null] : (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        EObject this_DataPort_0 = null;

        EObject this_EventPort_1 = null;

        EObject this_EventDataPort_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2955:28: ( (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2956:1: (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2956:1: (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort )
            int alt64=3;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2957:5: this_DataPort_0= ruleDataPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getDataPortParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataPort_in_rulePort6193);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2967:5: this_EventPort_1= ruleEventPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getEventPortParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventPort_in_rulePort6220);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2977:5: this_EventDataPort_2= ruleEventDataPort
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPortAccess().getEventDataPortParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEventDataPort_in_rulePort6247);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2993:1: entryRulePortDirection returns [String current=null] : iv_rulePortDirection= rulePortDirection EOF ;
    public final String entryRulePortDirection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePortDirection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2994:2: (iv_rulePortDirection= rulePortDirection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2995:2: iv_rulePortDirection= rulePortDirection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortDirectionRule()); 
            }
            pushFollow(FOLLOW_rulePortDirection_in_entryRulePortDirection6283);
            iv_rulePortDirection=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortDirection.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortDirection6294); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3002:1: rulePortDirection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken rulePortDirection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3005:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3006:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3006:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt65=3;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==37) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==EOF||(LA65_1>=RULE_ID && LA65_1<=RULE_SEMI)||LA65_1==45||LA65_1==63) ) {
                    alt65=1;
                }
                else if ( (LA65_1==64) ) {
                    alt65=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA65_0==64) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3007:2: kw= 'in'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_rulePortDirection6332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getInKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3014:2: kw= 'out'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_rulePortDirection6351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getOutKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3020:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3020:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3021:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_rulePortDirection6371); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getInKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,64,FOLLOW_64_in_rulePortDirection6384); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3040:1: entryRuleModeRef returns [EObject current=null] : iv_ruleModeRef= ruleModeRef EOF ;
    public final EObject entryRuleModeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeRef = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3041:2: (iv_ruleModeRef= ruleModeRef EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3042:2: iv_ruleModeRef= ruleModeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeRefRule()); 
            }
            pushFollow(FOLLOW_ruleModeRef_in_entryRuleModeRef6425);
            iv_ruleModeRef=ruleModeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeRef6435); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3049:1: ruleModeRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleModeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3052:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3053:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3053:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3053:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3053:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3054:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3054:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3055:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeRefRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeRef6480); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getModeRefAccess().getParentModeModeCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3066:2: (otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==40) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3066:4: otherlv_1= '->' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleModeRef6493); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getModeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3070:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3071:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3071:1: (otherlv_2= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3072:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModeRefRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeRef6513); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3091:1: entryRuleSystemSubcomponent returns [EObject current=null] : iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF ;
    public final EObject entryRuleSystemSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3092:2: (iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3093:2: iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleSystemSubcomponent_in_entryRuleSystemSubcomponent6551);
            iv_ruleSystemSubcomponent=ruleSystemSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemSubcomponent6561); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3100:1: ruleSystemSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3103:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3104:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3104:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3104:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'system' ( ( ruleQCREF ) ) (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3104:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3105:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3105:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3106:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemSubcomponent6603); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleSystemSubcomponent6619); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getSystemSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleSystemSubcomponent6630); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSystemSubcomponentAccess().getSystemKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3130:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3131:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3131:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3132:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSystemSubcomponentRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getSystemClassifierSystemClassifierCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQCREF_in_ruleSystemSubcomponent6653);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3145:2: (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==37) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3145:4: otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS
                    {
                    otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleSystemSubcomponent6666); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSystemSubcomponentAccess().getInKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleSystemSubcomponent6678); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSystemSubcomponentAccess().getModesKeyword_4_1());
                          
                    }
                    this_LPARENS_6=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleSystemSubcomponent6689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_6, grammarAccess.getSystemSubcomponentAccess().getLPARENSTerminalRuleCall_4_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3157:1: ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) )
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==RULE_ID) ) {
                        alt68=1;
                    }
                    else if ( (LA68_0==65) ) {
                        alt68=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 0, input);

                        throw nvae;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3157:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3157:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            int cnt67=0;
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==RULE_ID) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3158:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3158:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3159:3: lv_modeBinding_7_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getModeBindingModeRefParserRuleCall_4_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleSystemSubcomponent6710);
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
                            	    if ( cnt67 >= 1 ) break loop67;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(67, input);
                                        throw eee;
                                }
                                cnt67++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3176:6: ( (lv_allModes_8_0= 'all' ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3176:6: ( (lv_allModes_8_0= 'all' ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3177:1: (lv_allModes_8_0= 'all' )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3177:1: (lv_allModes_8_0= 'all' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3178:3: lv_allModes_8_0= 'all'
                            {
                            lv_allModes_8_0=(Token)match(input,65,FOLLOW_65_in_ruleSystemSubcomponent6735); if (state.failed) return current;
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

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleSystemSubcomponent6760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getSystemSubcomponentAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemSubcomponent6772); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3207:1: entryRuleProcessorSubcomponent returns [EObject current=null] : iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF ;
    public final EObject entryRuleProcessorSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessorSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3208:2: (iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3209:2: iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessorSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleProcessorSubcomponent_in_entryRuleProcessorSubcomponent6807);
            iv_ruleProcessorSubcomponent=ruleProcessorSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessorSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcessorSubcomponent6817); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3216:1: ruleProcessorSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3219:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3220:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3220:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3220:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'processor' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3220:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3221:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3221:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3222:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorSubcomponent6859); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleProcessorSubcomponent6875); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getProcessorSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleProcessorSubcomponent6886); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProcessorSubcomponentAccess().getProcessorKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3246:1: ( ( ruleQCREF ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3247:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3247:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3248:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getProcessorSubcomponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getProcessorClassifierProcessorClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleProcessorSubcomponent6909);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3261:3: (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==37) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3261:5: otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS
                    {
                    otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleProcessorSubcomponent6923); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getProcessorSubcomponentAccess().getInKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleProcessorSubcomponent6935); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getProcessorSubcomponentAccess().getModesKeyword_4_1());
                          
                    }
                    this_LPARENS_6=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleProcessorSubcomponent6946); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_6, grammarAccess.getProcessorSubcomponentAccess().getLPARENSTerminalRuleCall_4_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3273:1: ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) )
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==RULE_ID) ) {
                        alt72=1;
                    }
                    else if ( (LA72_0==65) ) {
                        alt72=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;
                    }
                    switch (alt72) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3273:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3273:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            int cnt71=0;
                            loop71:
                            do {
                                int alt71=2;
                                int LA71_0 = input.LA(1);

                                if ( (LA71_0==RULE_ID) ) {
                                    alt71=1;
                                }


                                switch (alt71) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3274:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3274:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3275:3: lv_modeBinding_7_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getModeBindingModeRefParserRuleCall_4_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleProcessorSubcomponent6967);
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
                            	    if ( cnt71 >= 1 ) break loop71;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(71, input);
                                        throw eee;
                                }
                                cnt71++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3292:6: ( (lv_allModes_8_0= 'all' ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3292:6: ( (lv_allModes_8_0= 'all' ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3293:1: (lv_allModes_8_0= 'all' )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3293:1: (lv_allModes_8_0= 'all' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3294:3: lv_allModes_8_0= 'all'
                            {
                            lv_allModes_8_0=(Token)match(input,65,FOLLOW_65_in_ruleProcessorSubcomponent6992); if (state.failed) return current;
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

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleProcessorSubcomponent7017); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getProcessorSubcomponentAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleProcessorSubcomponent7029); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3323:1: entryRuleDataSubcomponent returns [EObject current=null] : iv_ruleDataSubcomponent= ruleDataSubcomponent EOF ;
    public final EObject entryRuleDataSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3324:2: (iv_ruleDataSubcomponent= ruleDataSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3325:2: iv_ruleDataSubcomponent= ruleDataSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleDataSubcomponent_in_entryRuleDataSubcomponent7064);
            iv_ruleDataSubcomponent=ruleDataSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataSubcomponent7074); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3332:1: ruleDataSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3335:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3336:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3336:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3336:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'data' ( ( ruleQCREF ) )? (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3336:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3337:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3337:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3338:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataSubcomponent7116); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleDataSubcomponent7132); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getDataSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleDataSubcomponent7143); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDataSubcomponentAccess().getDataKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3362:1: ( ( ruleQCREF ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3363:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3363:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3364:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataSubcomponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getDataClassifierDataClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleDataSubcomponent7166);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3377:3: (otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==37) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3377:5: otherlv_4= 'in' otherlv_5= 'modes' this_LPARENS_6= RULE_LPARENS ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) ) this_RPARENS_9= RULE_RPARENS
                    {
                    otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleDataSubcomponent7180); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDataSubcomponentAccess().getInKeyword_4_0());
                          
                    }
                    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleDataSubcomponent7192); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDataSubcomponentAccess().getModesKeyword_4_1());
                          
                    }
                    this_LPARENS_6=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleDataSubcomponent7203); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_6, grammarAccess.getDataSubcomponentAccess().getLPARENSTerminalRuleCall_4_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3389:1: ( ( (lv_modeBinding_7_0= ruleModeRef ) )+ | ( (lv_allModes_8_0= 'all' ) ) )
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==RULE_ID) ) {
                        alt76=1;
                    }
                    else if ( (LA76_0==65) ) {
                        alt76=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 76, 0, input);

                        throw nvae;
                    }
                    switch (alt76) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3389:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3389:2: ( (lv_modeBinding_7_0= ruleModeRef ) )+
                            int cnt75=0;
                            loop75:
                            do {
                                int alt75=2;
                                int LA75_0 = input.LA(1);

                                if ( (LA75_0==RULE_ID) ) {
                                    alt75=1;
                                }


                                switch (alt75) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3390:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3390:1: (lv_modeBinding_7_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3391:3: lv_modeBinding_7_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getModeBindingModeRefParserRuleCall_4_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleDataSubcomponent7224);
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
                            	    if ( cnt75 >= 1 ) break loop75;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(75, input);
                                        throw eee;
                                }
                                cnt75++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3408:6: ( (lv_allModes_8_0= 'all' ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3408:6: ( (lv_allModes_8_0= 'all' ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3409:1: (lv_allModes_8_0= 'all' )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3409:1: (lv_allModes_8_0= 'all' )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3410:3: lv_allModes_8_0= 'all'
                            {
                            lv_allModes_8_0=(Token)match(input,65,FOLLOW_65_in_ruleDataSubcomponent7249); if (state.failed) return current;
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

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleDataSubcomponent7274); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getDataSubcomponentAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataSubcomponent7286); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3439:1: entryRuleSubcomponent returns [EObject current=null] : iv_ruleSubcomponent= ruleSubcomponent EOF ;
    public final EObject entryRuleSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3440:2: (iv_ruleSubcomponent= ruleSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3441:2: iv_ruleSubcomponent= ruleSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleSubcomponent_in_entryRuleSubcomponent7321);
            iv_ruleSubcomponent=ruleSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubcomponent7331); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3448:1: ruleSubcomponent returns [EObject current=null] : (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent ) ;
    public final EObject ruleSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject this_SystemSubcomponent_0 = null;

        EObject this_ProcessorSubcomponent_1 = null;

        EObject this_DataSubcomponent_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3451:28: ( (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3452:1: (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3452:1: (this_SystemSubcomponent_0= ruleSystemSubcomponent | this_ProcessorSubcomponent_1= ruleProcessorSubcomponent | this_DataSubcomponent_2= ruleDataSubcomponent )
            int alt78=3;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==RULE_COLON) ) {
                    switch ( input.LA(3) ) {
                    case 49:
                        {
                        alt78=2;
                        }
                        break;
                    case 45:
                        {
                        alt78=3;
                        }
                        break;
                    case 52:
                        {
                        alt78=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 78, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3453:5: this_SystemSubcomponent_0= ruleSystemSubcomponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubcomponentAccess().getSystemSubcomponentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSystemSubcomponent_in_ruleSubcomponent7378);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3463:5: this_ProcessorSubcomponent_1= ruleProcessorSubcomponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubcomponentAccess().getProcessorSubcomponentParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleProcessorSubcomponent_in_ruleSubcomponent7405);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3473:5: this_DataSubcomponent_2= ruleDataSubcomponent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSubcomponentAccess().getDataSubcomponentParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDataSubcomponent_in_ruleSubcomponent7432);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3489:1: entryRulePortConnection returns [EObject current=null] : iv_rulePortConnection= rulePortConnection EOF ;
    public final EObject entryRulePortConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortConnection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3490:2: (iv_rulePortConnection= rulePortConnection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3491:2: iv_rulePortConnection= rulePortConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortConnectionRule()); 
            }
            pushFollow(FOLLOW_rulePortConnection_in_entryRulePortConnection7467);
            iv_rulePortConnection=rulePortConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortConnection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortConnection7477); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3498:1: rulePortConnection returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3501:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3502:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3502:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3502:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= ruleConnectionType ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3502:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3503:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3503:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3504:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection7519); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rulePortConnection7535); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getPortConnectionAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3524:1: ( (lv_kind_2_0= ruleConnectionType ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3525:1: (lv_kind_2_0= ruleConnectionType )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3525:1: (lv_kind_2_0= ruleConnectionType )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3526:3: lv_kind_2_0= ruleConnectionType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPortConnectionAccess().getKindConnectionTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConnectionType_in_rulePortConnection7555);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3542:2: ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )?
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3542:3: ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3542:3: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3543:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3543:1: (otherlv_3= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3544:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection7576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getPortConnectionAccess().getSourceContextContextCrossReference_3_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_4=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rulePortConnection7587); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_4, grammarAccess.getPortConnectionAccess().getDOTTerminalRuleCall_3_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3559:3: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3560:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3560:1: (otherlv_5= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3561:3: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                      
            }
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection7608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_5, grammarAccess.getPortConnectionAccess().getSourceConnectionEndCrossReference_4_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3572:2: (otherlv_6= '->' | ( (lv_bidirectional_7_0= '<->' ) ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==40) ) {
                alt80=1;
            }
            else if ( (LA80_0==66) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3572:4: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,40,FOLLOW_40_in_rulePortConnection7621); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getPortConnectionAccess().getHyphenMinusGreaterThanSignKeyword_5_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3577:6: ( (lv_bidirectional_7_0= '<->' ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3577:6: ( (lv_bidirectional_7_0= '<->' ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3578:1: (lv_bidirectional_7_0= '<->' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3578:1: (lv_bidirectional_7_0= '<->' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3579:3: lv_bidirectional_7_0= '<->'
                    {
                    lv_bidirectional_7_0=(Token)match(input,66,FOLLOW_66_in_rulePortConnection7645); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3592:3: ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID) ) {
                int LA81_1 = input.LA(2);

                if ( (LA81_1==RULE_DOT) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3592:4: ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3592:4: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3593:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3593:1: (otherlv_8= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3594:3: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                              
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection7680); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_8, grammarAccess.getPortConnectionAccess().getDestinationContextContextCrossReference_6_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_9=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rulePortConnection7691); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_9, grammarAccess.getPortConnectionAccess().getDOTTerminalRuleCall_6_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3609:3: ( (otherlv_10= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3610:1: (otherlv_10= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3610:1: (otherlv_10= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3611:3: otherlv_10= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                      
            }
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection7712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_10, grammarAccess.getPortConnectionAccess().getDestinationConnectionEndCrossReference_7_0()); 
              	
            }

            }


            }

            this_SEMI_11=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePortConnection7723); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3634:1: entryRuleConnectionType returns [String current=null] : iv_ruleConnectionType= ruleConnectionType EOF ;
    public final String entryRuleConnectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3635:2: (iv_ruleConnectionType= ruleConnectionType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3636:2: iv_ruleConnectionType= ruleConnectionType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConnectionTypeRule()); 
            }
            pushFollow(FOLLOW_ruleConnectionType_in_entryRuleConnectionType7759);
            iv_ruleConnectionType=ruleConnectionType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConnectionType.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionType7770); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3643:1: ruleConnectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3646:28: ( (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3647:1: (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3647:1: (kw= 'access' | kw= 'feature' | (kw= 'feature' kw= 'group' ) | kw= 'parameter' | kw= 'port' )
            int alt82=5;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt82=1;
                }
                break;
            case 61:
                {
                int LA82_2 = input.LA(2);

                if ( (LA82_2==EOF||LA82_2==RULE_ID) ) {
                    alt82=2;
                }
                else if ( (LA82_2==51) ) {
                    alt82=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 2, input);

                    throw nvae;
                }
                }
                break;
            case 68:
                {
                alt82=4;
                }
                break;
            case 62:
                {
                alt82=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3648:2: kw= 'access'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleConnectionType7808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getAccessKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3655:2: kw= 'feature'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleConnectionType7827); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getFeatureKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3661:6: (kw= 'feature' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3661:6: (kw= 'feature' kw= 'group' )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3662:2: kw= 'feature' kw= 'group'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleConnectionType7847); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getFeatureKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleConnectionType7860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getGroupKeyword_2_1()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3675:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleConnectionType7880); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getConnectionTypeAccess().getParameterKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3682:2: kw= 'port'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleConnectionType7899); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3705:1: entryRuleDefaultAnnexLibrary returns [EObject current=null] : iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF ;
    public final EObject entryRuleDefaultAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultAnnexLibrary = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3706:2: (iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3707:2: iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultAnnexLibraryRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultAnnexLibrary_in_entryRuleDefaultAnnexLibrary7949);
            iv_ruleDefaultAnnexLibrary=ruleDefaultAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultAnnexLibrary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultAnnexLibrary7959); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3714:1: ruleDefaultAnnexLibrary returns [EObject current=null] : (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleDefaultAnnexLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sourceText_2_0=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3717:28: ( (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3718:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3718:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3718:3: otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleDefaultAnnexLibrary7996); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefaultAnnexLibraryAccess().getAnnexKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3722:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3723:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3723:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3724:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefaultAnnexLibrary8013); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3740:2: ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3741:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3741:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3742:3: lv_sourceText_2_0= RULE_ANNEXTEXT
            {
            lv_sourceText_2_0=(Token)match(input,RULE_ANNEXTEXT,FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexLibrary8035); if (state.failed) return current;
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

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDefaultAnnexLibrary8051); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3770:1: entryRuleAnnexSubclause returns [EObject current=null] : iv_ruleAnnexSubclause= ruleAnnexSubclause EOF ;
    public final EObject entryRuleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3771:2: (iv_ruleAnnexSubclause= ruleAnnexSubclause EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3772:2: iv_ruleAnnexSubclause= ruleAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause8086);
            iv_ruleAnnexSubclause=ruleAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnexSubclause8096); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3779:1: ruleAnnexSubclause returns [EObject current=null] : this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause ;
    public final EObject ruleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_DefaultAnnexSubclause_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3782:28: (this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3784:5: this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAnnexSubclauseAccess().getDefaultAnnexSubclauseParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleDefaultAnnexSubclause_in_ruleAnnexSubclause8142);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3800:1: entryRuleDefaultAnnexSubclause returns [EObject current=null] : iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF ;
    public final EObject entryRuleDefaultAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultAnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3801:2: (iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3802:2: iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultAnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultAnnexSubclause_in_entryRuleDefaultAnnexSubclause8176);
            iv_ruleDefaultAnnexSubclause=ruleDefaultAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultAnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultAnnexSubclause8186); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3809:1: ruleDefaultAnnexSubclause returns [EObject current=null] : (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleDefaultAnnexSubclause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sourceText_2_0=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3812:28: ( (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3813:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3813:1: (otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3813:3: otherlv_0= 'annex' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleDefaultAnnexSubclause8223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefaultAnnexSubclauseAccess().getAnnexKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3817:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3818:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3818:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3819:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefaultAnnexSubclause8240); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3835:2: ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3836:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3836:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3837:3: lv_sourceText_2_0= RULE_ANNEXTEXT
            {
            lv_sourceText_2_0=(Token)match(input,RULE_ANNEXTEXT,FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexSubclause8262); if (state.failed) return current;
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

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDefaultAnnexSubclause8278); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3869:1: entryRulePNAME returns [String current=null] : iv_rulePNAME= rulePNAME EOF ;
    public final String entryRulePNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePNAME = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3870:2: (iv_rulePNAME= rulePNAME EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3871:2: iv_rulePNAME= rulePNAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPNAMERule()); 
            }
            pushFollow(FOLLOW_rulePNAME_in_entryRulePNAME8318);
            iv_rulePNAME=rulePNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePNAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePNAME8329); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3878:1: rulePNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken rulePNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3881:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3882:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3882:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3882:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePNAME8369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getPNAMEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3889:1: (kw= '::' this_ID_2= RULE_ID )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==30) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3890:2: kw= '::' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,30,FOLLOW_30_in_rulePNAME8388); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getPNAMEAccess().getColonColonKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePNAME8403); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getPNAMEAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop83;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3912:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3913:2: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3914:2: iv_ruleINAME= ruleINAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINAMERule()); 
            }
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME8453);
            iv_ruleINAME=ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME8464); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3921:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3924:28: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3925:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME8503); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3940:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3941:2: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3942:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF8548);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF8559); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3949:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_DOT_3=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3952:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3953:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3953:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3953:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3953:2: (this_ID_0= RULE_ID kw= '::' )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==RULE_ID) ) {
                    int LA84_1 = input.LA(2);

                    if ( (LA84_1==30) ) {
                        alt84=1;
                    }


                }


                switch (alt84) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3953:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF8600); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,30,FOLLOW_30_in_ruleQCREF8618); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF8635); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3973:1: (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_DOT) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:3973:6: this_DOT_3= RULE_DOT this_ID_4= RULE_ID
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleQCREF8656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_3, grammarAccess.getQCREFAccess().getDOTTerminalRuleCall_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF8676); if (state.failed) return current;
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
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:613:3: ( 'in' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:613:5: 'in'
        {
        match(input,37,FOLLOW_37_in_synpred3_InternalAadl21284); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalAadl2

    // $ANTLR start synpred4_InternalAadl2
    public final void synpred4_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1297:4: ( 'prototypes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1297:6: 'prototypes'
        {
        match(input,55,FOLLOW_55_in_synpred4_InternalAadl22832); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalAadl2

    // $ANTLR start synpred5_InternalAadl2
    public final void synpred5_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1339:8: ( 'features' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1339:10: 'features'
        {
        match(input,56,FOLLOW_56_in_synpred5_InternalAadl22908); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalAadl2

    // $ANTLR start synpred6_InternalAadl2
    public final void synpred6_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1419:9: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1419:11: 'flows'
        {
        match(input,57,FOLLOW_57_in_synpred6_InternalAadl23040); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalAadl2

    // $ANTLR start synpred7_InternalAadl2
    public final void synpred7_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:8: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1461:10: 'modes'
        {
        match(input,38,FOLLOW_38_in_synpred7_InternalAadl23117); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalAadl2

    // $ANTLR start synpred8_InternalAadl2
    public final void synpred8_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1599:4: ( 'features' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1599:6: 'features'
        {
        match(input,56,FOLLOW_56_in_synpred8_InternalAadl23384); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalAadl2

    // $ANTLR start synpred9_InternalAadl2
    public final void synpred9_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1679:9: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1679:11: 'flows'
        {
        match(input,57,FOLLOW_57_in_synpred9_InternalAadl23516); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalAadl2

    // $ANTLR start synpred10_InternalAadl2
    public final void synpred10_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:8: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1721:10: 'modes'
        {
        match(input,38,FOLLOW_38_in_synpred10_InternalAadl23593); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalAadl2

    // $ANTLR start synpred11_InternalAadl2
    public final void synpred11_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1855:4: ( 'features' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1855:6: 'features'
        {
        match(input,56,FOLLOW_56_in_synpred11_InternalAadl23856); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalAadl2

    // $ANTLR start synpred12_InternalAadl2
    public final void synpred12_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1878:6: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1878:8: 'flows'
        {
        match(input,57,FOLLOW_57_in_synpred12_InternalAadl23902); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalAadl2

    // $ANTLR start synpred13_InternalAadl2
    public final void synpred13_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:8: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:1920:10: 'modes'
        {
        match(input,38,FOLLOW_38_in_synpred13_InternalAadl23979); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalAadl2

    // $ANTLR start synpred14_InternalAadl2
    public final void synpred14_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2040:3: ( 'subcomponents' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2040:5: 'subcomponents'
        {
        match(input,59,FOLLOW_59_in_synpred14_InternalAadl24232); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalAadl2

    // $ANTLR start synpred15_InternalAadl2
    public final void synpred15_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2120:7: ( 'connections' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2120:9: 'connections'
        {
        match(input,60,FOLLOW_60_in_synpred15_InternalAadl24364); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalAadl2

    // $ANTLR start synpred16_InternalAadl2
    public final void synpred16_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2162:7: ( 'flows' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2162:9: 'flows'
        {
        match(input,57,FOLLOW_57_in_synpred16_InternalAadl24440); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalAadl2

    // $ANTLR start synpred17_InternalAadl2
    public final void synpred17_InternalAadl2_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:6: ( 'modes' )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2.g:2185:8: 'modes'
        {
        match(input,38,FOLLOW_38_in_synpred17_InternalAadl24486); if (state.failed) return ;

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


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA64 dfa64 = new DFA64(this);
    static final String DFA16_eotS =
        "\20\uffff";
    static final String DFA16_eofS =
        "\12\uffff\1\15\5\uffff";
    static final String DFA16_minS =
        "\1\53\11\uffff\1\4\1\54\4\uffff";
    static final String DFA16_maxS =
        "\1\66\11\uffff\1\63\1\61\4\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff\1\12\1\13"+
        "\1\15\1\14";
    static final String DFA16_specialS =
        "\20\uffff}>";
    static final String[] DFA16_transitionS = {
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
            "\2\15\55\uffff\1\14",
            "\1\17\4\uffff\1\16",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1140:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA20_eotS =
        "\13\uffff";
    static final String DFA20_eofS =
        "\13\uffff";
    static final String DFA20_minS =
        "\1\4\1\uffff\1\11\1\45\4\55\3\uffff";
    static final String DFA20_maxS =
        "\1\105\1\uffff\1\11\2\100\1\77\1\76\1\77\3\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\4\6\uffff\1\1\1\3\1\2";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\2\7\uffff\1\1\20\uffff\1\1\10\uffff\1\1\22\uffff\1\1\13"+
            "\uffff\1\1",
            "",
            "\1\3",
            "\1\4\32\uffff\1\5",
            "\1\10\21\uffff\1\6\1\7",
            "\1\10\21\uffff\1\6",
            "\1\11\20\uffff\1\12",
            "\1\10\21\uffff\1\6",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1363:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+";
        }
    }
    static final String DFA29_eotS =
        "\13\uffff";
    static final String DFA29_eofS =
        "\13\uffff";
    static final String DFA29_minS =
        "\1\4\1\uffff\1\11\1\45\4\55\3\uffff";
    static final String DFA29_maxS =
        "\1\105\1\uffff\1\11\2\100\2\77\1\76\3\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\4\6\uffff\1\1\1\2\1\3";
    static final String DFA29_specialS =
        "\13\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\2\7\uffff\1\1\20\uffff\1\1\10\uffff\1\1\22\uffff\1\1\13"+
            "\uffff\1\1",
            "",
            "\1\3",
            "\1\4\32\uffff\1\5",
            "\1\10\21\uffff\1\7\1\6",
            "\1\10\21\uffff\1\7",
            "\1\10\21\uffff\1\7",
            "\1\12\20\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1623:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+";
        }
    }
    static final String DFA64_eotS =
        "\12\uffff";
    static final String DFA64_eofS =
        "\12\uffff";
    static final String DFA64_minS =
        "\1\4\1\11\1\45\4\55\3\uffff";
    static final String DFA64_maxS =
        "\1\4\1\11\2\100\2\77\1\76\3\uffff";
    static final String DFA64_acceptS =
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA64_specialS =
        "\12\uffff}>";
    static final String[] DFA64_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3\32\uffff\1\4",
            "\1\7\21\uffff\1\6\1\5",
            "\1\7\21\uffff\1\6",
            "\1\7\21\uffff\1\6",
            "\1\10\20\uffff\1\11",
            "",
            "",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "2956:1: (this_DataPort_0= ruleDataPort | this_EventPort_1= ruleEventPort | this_EventDataPort_2= ruleEventDataPort )";
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
    public static final BitSet FOLLOW_31_in_rulePublicPackageSection368 = new BitSet(new long[]{0x0012200100000002L});
    public static final BitSet FOLLOW_32_in_rulePublicPackageSection389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePublicPackageSection413 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePublicPackageSection425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePublicPackageSection447 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePublicPackageSection460 = new BitSet(new long[]{0x0012200100000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_rulePublicPackageSection483 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_rulePublicPackageSection510 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_rulePublicPackageSection537 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rulePublicPackageSection564 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_entryRulePrivatePackageSection602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrivatePackageSection612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rulePrivatePackageSection658 = new BitSet(new long[]{0x0012200100000002L});
    public static final BitSet FOLLOW_32_in_rulePrivatePackageSection679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePrivatePackageSection703 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePrivatePackageSection715 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePrivatePackageSection737 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePrivatePackageSection750 = new BitSet(new long[]{0x0012200100000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_rulePrivatePackageSection773 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_rulePrivatePackageSection800 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_rulePrivatePackageSection827 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_rulePrivatePackageSection854 = new BitSet(new long[]{0x0012200000000002L});
    public static final BitSet FOLLOW_ruleFlowSource_in_entryRuleFlowSource897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSource908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFlowSource945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSink_in_entryRuleFlowSink985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSink996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleFlowSink1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPath_in_entryRuleFlowPath1073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowPath1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleFlowPath1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_entryRuleFlowSpecification1160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecification1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSourceSpec_in_ruleFlowSpecification1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSinkSpec_in_ruleFlowSpecification1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPathSpec_in_ruleFlowSpecification1272 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_37_in_ruleFlowSpecification1292 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleFlowSpecification1305 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleFlowSpecification1316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecification1335 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleFlowSpecification1347 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFlowSpecification1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSourceSpec_in_entryRuleFlowSourceSpec1395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSourceSpec1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceSpec1447 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSourceSpec1463 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleFlowSourceSpec1474 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleFlowSource_in_ruleFlowSourceSpec1495 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceSpec1515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSinkSpec_in_entryRuleFlowSinkSpec1551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSinkSpec1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkSpec1603 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSinkSpec1619 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleFlowSinkSpec1630 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ruleFlowSink_in_ruleFlowSinkSpec1651 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkSpec1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPathSpec_in_entryRuleFlowPathSpec1707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowPathSpec1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec1759 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowPathSpec1775 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleFlowPathSpec1786 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleFlowPath_in_ruleFlowPathSpec1807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec1827 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleFlowPathSpec1839 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMode_in_entryRuleMode1895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMode1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMode1947 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleMode1963 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_41_in_ruleMode1980 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleMode2006 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleMode2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransition_in_entryRuleModeTransition2052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransition2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition2105 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleModeTransition2121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition2142 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_LTRANS_in_ruleModeTransition2153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_ruleModeTransition2173 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleModeTransition2185 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_ruleModeTransition2205 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_RULE_RTRANS_in_ruleModeTransition2218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition2237 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleModeTransition2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_entryRuleTriggerPort2283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerPort2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggerPort2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategoryKW_in_entryRuleComponentCategoryKW2373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategoryKW2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleComponentCategoryKW2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategoryKW2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleComponentCategoryKW2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategoryKW2479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategoryKW2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleComponentCategoryKW2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategoryKW2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleComponentCategoryKW2556 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleComponentCategoryKW2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategoryKW2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategoryKW2609 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleComponentCategoryKW2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategoryKW2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleComponentCategoryKW2662 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategoryKW2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleComponentCategoryKW2696 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategoryKW2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_entryRuleSystemType2750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemType2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSystemType2797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemType2814 = new BitSet(new long[]{0x0380004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_55_in_ruleSystemType2840 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType2859 = new BitSet(new long[]{0x0300004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_rulePrototype_in_ruleSystemType2891 = new BitSet(new long[]{0x0300004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_ruleSystemType2916 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType2935 = new BitSet(new long[]{0x0200004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDataPort_in_ruleSystemType2968 = new BitSet(new long[]{0x0200004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleEventPort_in_ruleSystemType2995 = new BitSet(new long[]{0x0200004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_ruleSystemType3022 = new BitSet(new long[]{0x0200004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_57_in_ruleSystemType3048 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleSystemType3071 = new BitSet(new long[]{0x0000004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType3095 = new BitSet(new long[]{0x0000004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38_in_ruleSystemType3125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleSystemType3148 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleSystemType3175 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType3201 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleSystemType3229 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_29_in_ruleSystemType3242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemType3253 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemType3263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_entryRuleProcessorType3302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcessorType3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleProcessorType3349 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorType3366 = new BitSet(new long[]{0x0300004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_ruleProcessorType3392 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType3411 = new BitSet(new long[]{0x0200004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDataPort_in_ruleProcessorType3444 = new BitSet(new long[]{0x0200004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleEventPort_in_ruleProcessorType3471 = new BitSet(new long[]{0x0200004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_ruleProcessorType3498 = new BitSet(new long[]{0x0200004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_57_in_ruleProcessorType3524 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleProcessorType3547 = new BitSet(new long[]{0x0000004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType3571 = new BitSet(new long[]{0x0000004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38_in_ruleProcessorType3601 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleProcessorType3624 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleProcessorType3651 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType3677 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleProcessorType3705 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_29_in_ruleProcessorType3718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorType3729 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleProcessorType3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType3774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleDataType3821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType3838 = new BitSet(new long[]{0x0300004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_56_in_ruleDataType3864 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType3882 = new BitSet(new long[]{0x0200004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_57_in_ruleDataType3910 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleDataType3933 = new BitSet(new long[]{0x0000004020001010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType3957 = new BitSet(new long[]{0x0000004020001000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38_in_ruleDataType3987 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleDataType4010 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleDataType4037 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType4063 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleDataType4091 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_29_in_ruleDataType4104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType4115 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataType4125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_entryRuleSystemImplementation4160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemImplementation4170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSystemImplementation4207 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleSystemImplementation4219 = new BitSet(new long[]{0x1A00004020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_59_in_ruleSystemImplementation4240 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_ruleSystemImplementation4264 = new BitSet(new long[]{0x1200004020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_ruleSystemImplementation4291 = new BitSet(new long[]{0x1200004020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_ruleSystemImplementation4318 = new BitSet(new long[]{0x1200004020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation4343 = new BitSet(new long[]{0x1200004020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_60_in_ruleSystemImplementation4372 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rulePortConnection_in_ruleSystemImplementation4395 = new BitSet(new long[]{0x0200004020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation4419 = new BitSet(new long[]{0x0200004020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_57_in_ruleSystemImplementation4448 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation4466 = new BitSet(new long[]{0x0000004020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38_in_ruleSystemImplementation4494 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleMode_in_ruleSystemImplementation4518 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleSystemImplementation4545 = new BitSet(new long[]{0x0000000020000010L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation4570 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleSystemImplementation4599 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_29_in_ruleSystemImplementation4612 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemImplementation4623 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSystemImplementation4633 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINAME_in_ruleSystemImplementation4648 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemImplementation4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrototype_in_entryRulePrototype4697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrototype4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentPrototype_in_rulePrototype4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroupPrototype_in_rulePrototype4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeaturePrototype_in_rulePrototype4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentPrototype_in_entryRuleComponentPrototype4843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentPrototype4853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentPrototype4895 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleComponentPrototype4911 = new BitSet(new long[]{0x0077F80000000000L});
    public static final BitSet FOLLOW_ruleComponentCategoryKW_in_ruleComponentPrototype4931 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentPrototype4954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleComponentPrototype4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroupPrototype_in_entryRuleFeatureGroupPrototype5001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureGroupPrototype5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureGroupPrototype5053 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFeatureGroupPrototype5069 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleFeatureGroupPrototype5080 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleFeatureGroupPrototype5092 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeatureGroupPrototype5115 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeatureGroupPrototype5127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeaturePrototype_in_entryRuleFeaturePrototype5162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeaturePrototype5172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeaturePrototype5214 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFeaturePrototype5230 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleFeaturePrototype5241 = new BitSet(new long[]{0x0000002000000030L,0x0000000000000001L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleFeaturePrototype5262 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeaturePrototype5286 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeaturePrototype5298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataPort_in_entryRuleDataPort5333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataPort5343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataPort5385 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleDataPort5401 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleDataPort5421 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleDataPort5433 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleDataPort5445 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleDataPort5468 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataPort5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_entryRuleEventDataPort5515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDataPort5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDataPort5567 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleEventDataPort5583 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleEventDataPort5603 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleEventDataPort5615 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleEventDataPort5627 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleEventDataPort5639 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleEventDataPort5662 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEventDataPort5674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventPort_in_entryRuleEventPort5709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventPort5719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventPort5761 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleEventPort5777 = new BitSet(new long[]{0x0000002000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleEventPort5797 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleEventPort5809 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleEventPort5821 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEventPort5832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroup_in_entryRuleFeatureGroup5867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureGroup5877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureGroup5919 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleFeatureGroup5936 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleFeatureGroup5948 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeatureGroup5971 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeatureGroup5982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature6017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature6027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_ruleFeature6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroup_in_ruleFeature6101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePort_in_entryRulePort6136 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePort6146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataPort_in_rulePort6193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventPort_in_rulePort6220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_rulePort6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortDirection_in_entryRulePortDirection6283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortDirection6294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rulePortDirection6332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_rulePortDirection6351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rulePortDirection6371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_rulePortDirection6384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeRef_in_entryRuleModeRef6425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeRef6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeRef6480 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleModeRef6493 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeRef6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_entryRuleSystemSubcomponent6551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemSubcomponent6561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemSubcomponent6603 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleSystemSubcomponent6619 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleSystemSubcomponent6630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleSystemSubcomponent6653 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_37_in_ruleSystemSubcomponent6666 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSystemSubcomponent6678 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleSystemSubcomponent6689 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleSystemSubcomponent6710 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_65_in_ruleSystemSubcomponent6735 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleSystemSubcomponent6760 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemSubcomponent6772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_entryRuleProcessorSubcomponent6807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcessorSubcomponent6817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorSubcomponent6859 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleProcessorSubcomponent6875 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleProcessorSubcomponent6886 = new BitSet(new long[]{0x0000002000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleProcessorSubcomponent6909 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_37_in_ruleProcessorSubcomponent6923 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleProcessorSubcomponent6935 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleProcessorSubcomponent6946 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleProcessorSubcomponent6967 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_65_in_ruleProcessorSubcomponent6992 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleProcessorSubcomponent7017 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleProcessorSubcomponent7029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_entryRuleDataSubcomponent7064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataSubcomponent7074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataSubcomponent7116 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleDataSubcomponent7132 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleDataSubcomponent7143 = new BitSet(new long[]{0x0000002000000030L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleDataSubcomponent7166 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_37_in_ruleDataSubcomponent7180 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleDataSubcomponent7192 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleDataSubcomponent7203 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleDataSubcomponent7224 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_65_in_ruleDataSubcomponent7249 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleDataSubcomponent7274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataSubcomponent7286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubcomponent_in_entryRuleSubcomponent7321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubcomponent7331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_ruleSubcomponent7378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_ruleSubcomponent7405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_ruleSubcomponent7432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortConnection_in_entryRulePortConnection7467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortConnection7477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection7519 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_COLON_in_rulePortConnection7535 = new BitSet(new long[]{0x6000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_ruleConnectionType_in_rulePortConnection7555 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection7576 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_DOT_in_rulePortConnection7587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection7608 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_40_in_rulePortConnection7621 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_66_in_rulePortConnection7645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection7680 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_DOT_in_rulePortConnection7691 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection7712 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePortConnection7723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionType_in_entryRuleConnectionType7759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionType7770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConnectionType7808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleConnectionType7827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleConnectionType7847 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleConnectionType7860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleConnectionType7880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleConnectionType7899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexLibrary_in_entryRuleDefaultAnnexLibrary7949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultAnnexLibrary7959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleDefaultAnnexLibrary7996 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefaultAnnexLibrary8013 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexLibrary8035 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDefaultAnnexLibrary8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause8086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnexSubclause8096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexSubclause_in_ruleAnnexSubclause8142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexSubclause_in_entryRuleDefaultAnnexSubclause8176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultAnnexSubclause8186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleDefaultAnnexSubclause8223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefaultAnnexSubclause8240 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexSubclause8262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDefaultAnnexSubclause8278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePNAME_in_entryRulePNAME8318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePNAME8329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePNAME8369 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_rulePNAME8388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePNAME8403 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME8453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME8464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME8503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF8548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF8559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF8600 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleQCREF8618 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF8635 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleQCREF8656 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred1_InternalAadl2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred2_InternalAadl2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred3_InternalAadl21284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred4_InternalAadl22832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred5_InternalAadl22908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred6_InternalAadl23040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred7_InternalAadl23117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred8_InternalAadl23384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred9_InternalAadl23516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred10_InternalAadl23593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred11_InternalAadl23856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred12_InternalAadl23902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred13_InternalAadl23979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_synpred14_InternalAadl24232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred15_InternalAadl24364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred16_InternalAadl24440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred17_InternalAadl24486 = new BitSet(new long[]{0x0000000000000002L});

}