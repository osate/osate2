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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_50", "KEYWORD_49", "KEYWORD_48", "KEYWORD_45", "KEYWORD_46", "KEYWORD_47", "KEYWORD_43", "KEYWORD_44", "KEYWORD_39", "KEYWORD_40", "KEYWORD_41", "KEYWORD_42", "KEYWORD_29", "KEYWORD_30", "KEYWORD_31", "KEYWORD_32", "KEYWORD_33", "KEYWORD_34", "KEYWORD_35", "KEYWORD_36", "KEYWORD_37", "KEYWORD_38", "KEYWORD_22", "KEYWORD_23", "KEYWORD_24", "KEYWORD_25", "KEYWORD_26", "KEYWORD_27", "KEYWORD_28", "KEYWORD_17", "KEYWORD_18", "KEYWORD_19", "KEYWORD_20", "KEYWORD_21", "KEYWORD_10", "KEYWORD_11", "KEYWORD_12", "KEYWORD_13", "KEYWORD_14", "KEYWORD_15", "KEYWORD_16", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "KEYWORD_8", "KEYWORD_9", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "RULE_EM", "RULE_ANNEXTEXT", "RULE_SEMI", "RULE_NONE", "RULE_LTRANS", "RULE_RTRANS", "RULE_ARROW", "RULE_SL_COMMENT", "RULE_COLON", "RULE_COMMA", "RULE_DOT", "RULE_LPARENS", "RULE_RPARENS", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_LCURLY", "RULE_RCURLY", "RULE_ASSIGN", "RULE_APPEND", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=73;
    public static final int RULE_ANY_OTHER=78;
    public static final int KEYWORD_19=35;
    public static final int KEYWORD_17=33;
    public static final int KEYWORD_18=34;
    public static final int KEYWORD_15=43;
    public static final int KEYWORD_16=44;
    public static final int RULE_LBRACKET=67;
    public static final int KEYWORD_13=41;
    public static final int KEYWORD_50=4;
    public static final int KEYWORD_14=42;
    public static final int KEYWORD_11=39;
    public static final int KEYWORD_12=40;
    public static final int EOF=-1;
    public static final int KEYWORD_10=38;
    public static final int RULE_ASSIGN=71;
    public static final int RULE_ANNEXTEXT=55;
    public static final int RULE_DOT=64;
    public static final int KEYWORD_6=46;
    public static final int RULE_LPARENS=65;
    public static final int KEYWORD_7=47;
    public static final int KEYWORD_8=48;
    public static final int KEYWORD_9=49;
    public static final int KEYWORD_28=32;
    public static final int KEYWORD_29=16;
    public static final int RULE_INT=74;
    public static final int KEYWORD_24=28;
    public static final int KEYWORD_25=29;
    public static final int KEYWORD_26=30;
    public static final int KEYWORD_27=31;
    public static final int KEYWORD_20=36;
    public static final int KEYWORD_21=37;
    public static final int KEYWORD_22=26;
    public static final int RULE_RBRACKET=68;
    public static final int KEYWORD_23=27;
    public static final int RULE_SEMI=56;
    public static final int RULE_RPARENS=66;
    public static final int RULE_APPEND=72;
    public static final int KEYWORD_1=50;
    public static final int KEYWORD_30=17;
    public static final int RULE_LTRANS=58;
    public static final int RULE_COMMA=63;
    public static final int KEYWORD_34=21;
    public static final int KEYWORD_5=45;
    public static final int KEYWORD_33=20;
    public static final int KEYWORD_4=53;
    public static final int KEYWORD_32=19;
    public static final int KEYWORD_3=52;
    public static final int KEYWORD_31=18;
    public static final int KEYWORD_2=51;
    public static final int KEYWORD_38=25;
    public static final int KEYWORD_37=24;
    public static final int RULE_SL_COMMENT=61;
    public static final int KEYWORD_36=23;
    public static final int KEYWORD_35=22;
    public static final int RULE_NONE=57;
    public static final int RULE_ML_COMMENT=76;
    public static final int KEYWORD_39=12;
    public static final int RULE_COLON=62;
    public static final int RULE_STRING=75;
    public static final int RULE_EM=54;
    public static final int RULE_ARROW=60;
    public static final int KEYWORD_41=14;
    public static final int KEYWORD_40=13;
    public static final int KEYWORD_43=10;
    public static final int RULE_RTRANS=59;
    public static final int KEYWORD_42=15;
    public static final int KEYWORD_45=7;
    public static final int KEYWORD_44=11;
    public static final int KEYWORD_47=9;
    public static final int RULE_WS=77;
    public static final int KEYWORD_46=8;
    public static final int KEYWORD_49=5;
    public static final int KEYWORD_48=6;
    public static final int RULE_RCURLY=70;
    public static final int RULE_LCURLY=69;

    // delegates
    // delegators


        public InternalAadl2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAadl2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAadl2Parser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g"; }




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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:62:1: entryRuleAadlPackage returns [EObject current=null] : iv_ruleAadlPackage= ruleAadlPackage EOF ;
    public final EObject entryRuleAadlPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAadlPackage = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:63:2: (iv_ruleAadlPackage= ruleAadlPackage EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:64:2: iv_ruleAadlPackage= ruleAadlPackage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAadlPackageRule()); 
            }
            pushFollow(FOLLOW_ruleAadlPackage_in_entryRuleAadlPackage67);
            iv_ruleAadlPackage=ruleAadlPackage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAadlPackage; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlPackage77); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:71:1: ruleAadlPackage returns [EObject current=null] : (otherlv_0= KEYWORD_34 ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) ( ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+ )? otherlv_7= KEYWORD_8 this_ID_8= RULE_ID (otherlv_9= KEYWORD_1 this_ID_10= RULE_ID )* this_SEMI_11= RULE_SEMI ) ;
    public final EObject ruleAadlPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token this_ID_8=null;
        Token otherlv_9=null;
        Token this_ID_10=null;
        Token this_SEMI_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedPublicSection_2_0 = null;

        EObject lv_ownedPrivateSection_3_0 = null;

        EObject lv_ownedPrivateSection_4_0 = null;

        EObject lv_ownedPropertyAssociation_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:74:28: ( (otherlv_0= KEYWORD_34 ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) ( ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+ )? otherlv_7= KEYWORD_8 this_ID_8= RULE_ID (otherlv_9= KEYWORD_1 this_ID_10= RULE_ID )* this_SEMI_11= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:75:1: (otherlv_0= KEYWORD_34 ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) ( ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+ )? otherlv_7= KEYWORD_8 this_ID_8= RULE_ID (otherlv_9= KEYWORD_1 this_ID_10= RULE_ID )* this_SEMI_11= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:75:1: (otherlv_0= KEYWORD_34 ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) ( ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+ )? otherlv_7= KEYWORD_8 this_ID_8= RULE_ID (otherlv_9= KEYWORD_1 this_ID_10= RULE_ID )* this_SEMI_11= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:76:2: otherlv_0= KEYWORD_34 ( (lv_name_1_0= rulePNAME ) ) ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) ) ( ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+ )? otherlv_7= KEYWORD_8 this_ID_8= RULE_ID (otherlv_9= KEYWORD_1 this_ID_10= RULE_ID )* this_SEMI_11= RULE_SEMI
            {
            otherlv_0=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_ruleAadlPackage115); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAadlPackageAccess().getPackageKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:80:1: ( (lv_name_1_0= rulePNAME ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:81:1: (lv_name_1_0= rulePNAME )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:81:1: (lv_name_1_0= rulePNAME )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:82:3: lv_name_1_0= rulePNAME
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAadlPackageAccess().getNamePNAMEParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePNAME_in_ruleAadlPackage135);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:98:2: ( ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? ) | ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_25) ) {
                alt2=1;
            }
            else if ( (LA2_0==KEYWORD_35) ) {
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:98:3: ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:98:3: ( ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )? )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:98:4: ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) ) ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )?
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:98:4: ( (lv_ownedPublicSection_2_0= rulePublicPackageSection ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:99:1: (lv_ownedPublicSection_2_0= rulePublicPackageSection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:99:1: (lv_ownedPublicSection_2_0= rulePublicPackageSection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:100:3: lv_ownedPublicSection_2_0= rulePublicPackageSection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPublicSectionPublicPackageSectionParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePublicPackageSection_in_ruleAadlPackage158);
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

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:116:2: ( (lv_ownedPrivateSection_3_0= rulePrivatePackageSection ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==KEYWORD_35) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:117:1: (lv_ownedPrivateSection_3_0= rulePrivatePackageSection )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:117:1: (lv_ownedPrivateSection_3_0= rulePrivatePackageSection )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:118:3: lv_ownedPrivateSection_3_0= rulePrivatePackageSection
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPrivateSectionPrivatePackageSectionParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage179);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:135:6: ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:135:6: ( (lv_ownedPrivateSection_4_0= rulePrivatePackageSection ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:136:1: (lv_ownedPrivateSection_4_0= rulePrivatePackageSection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:136:1: (lv_ownedPrivateSection_4_0= rulePrivatePackageSection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:137:3: lv_ownedPrivateSection_4_0= rulePrivatePackageSection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPrivateSectionPrivatePackageSectionParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage208);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:153:3: ( ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_45) && (synpred1_InternalAadl2Parser())) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:153:4: ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 ) ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:153:4: ( ( KEYWORD_45 )=>otherlv_5= KEYWORD_45 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:153:5: ( KEYWORD_45 )=>otherlv_5= KEYWORD_45
                    {
                    otherlv_5=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleAadlPackage230); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAadlPackageAccess().getPropertiesKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:160:2: ( (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation ) )+
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:161:1: (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:161:1: (lv_ownedPropertyAssociation_6_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:162:3: lv_ownedPropertyAssociation_6_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getAadlPackageAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleAadlPackage251);
                    	    lv_ownedPropertyAssociation_6_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getAadlPackageRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_6_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleAadlPackage267); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAadlPackageAccess().getEndKeyword_4());
                  
            }
            this_ID_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlPackage277); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_8, grammarAccess.getAadlPackageAccess().getIDTerminalRuleCall_5()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:187:1: (otherlv_9= KEYWORD_1 this_ID_10= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==KEYWORD_1) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:188:2: otherlv_9= KEYWORD_1 this_ID_10= RULE_ID
            	    {
            	    otherlv_9=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleAadlPackage290); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getAadlPackageAccess().getColonColonKeyword_6_0());
            	          
            	    }
            	    this_ID_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlPackage300); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_10, grammarAccess.getAadlPackageAccess().getIDTerminalRuleCall_6_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            this_SEMI_11=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleAadlPackage312); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_11, grammarAccess.getAadlPackageAccess().getSEMITerminalRuleCall_7()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:208:1: entryRulePublicPackageSection returns [EObject current=null] : iv_rulePublicPackageSection= rulePublicPackageSection EOF ;
    public final EObject entryRulePublicPackageSection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublicPackageSection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:209:2: (iv_rulePublicPackageSection= rulePublicPackageSection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:210:2: iv_rulePublicPackageSection= rulePublicPackageSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPublicPackageSectionRule()); 
            }
            pushFollow(FOLLOW_rulePublicPackageSection_in_entryRulePublicPackageSection346);
            iv_rulePublicPackageSection=rulePublicPackageSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePublicPackageSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePublicPackageSection356); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:217:1: rulePublicPackageSection returns [EObject current=null] : ( () otherlv_1= KEYWORD_25 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:220:28: ( ( () otherlv_1= KEYWORD_25 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:221:1: ( () otherlv_1= KEYWORD_25 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:221:1: ( () otherlv_1= KEYWORD_25 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:221:2: () otherlv_1= KEYWORD_25 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:221:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:222:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPublicPackageSectionAccess().getPublicPackageSectionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_rulePublicPackageSection403); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPublicPackageSectionAccess().getPublicKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:232:1: ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==KEYWORD_16) && (synpred2_InternalAadl2Parser())) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:232:2: ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:232:2: ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:232:3: ( KEYWORD_16 )=>otherlv_2= KEYWORD_16
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_rulePublicPackageSection423); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getPublicPackageSectionAccess().getWithKeyword_2_0());
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:239:2: ( ( rulePNAME ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:240:1: ( rulePNAME )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:240:1: ( rulePNAME )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:241:3: rulePNAME
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPublicPackageSectionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePNAME_in_rulePublicPackageSection446);
            	    rulePNAME();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:254:2: (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==RULE_COMMA) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:254:3: this_COMMA_4= RULE_COMMA ( ( rulePNAME ) )
            	    	    {
            	    	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rulePublicPackageSection458); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_COMMA_4, grammarAccess.getPublicPackageSectionAccess().getCOMMATerminalRuleCall_2_2_0()); 
            	    	          
            	    	    }
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:258:1: ( ( rulePNAME ) )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:259:1: ( rulePNAME )
            	    	    {
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:259:1: ( rulePNAME )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:260:3: rulePNAME
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getPublicPackageSectionRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_2_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_rulePNAME_in_rulePublicPackageSection480);
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
            	    	    break loop6;
            	        }
            	    } while (true);

            	    this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePublicPackageSection493); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SEMI_6, grammarAccess.getPublicPackageSectionAccess().getSEMITerminalRuleCall_2_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:277:3: ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            loop8:
            do {
                int alt8=5;
                switch ( input.LA(1) ) {
                case KEYWORD_27:
                    {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==RULE_ID) ) {
                        alt8=1;
                    }
                    else if ( (LA8_2==KEYWORD_50) ) {
                        alt8=2;
                    }


                    }
                    break;
                case KEYWORD_44:
                    {
                    alt8=3;
                    }
                    break;
                case KEYWORD_10:
                    {
                    alt8=4;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:277:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:277:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:278:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:278:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:279:3: lv_ownedSystemType_7_0= ruleSystemType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedSystemTypeSystemTypeParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemType_in_rulePublicPackageSection516);
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
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:296:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:296:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:297:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:297:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:298:3: lv_ownedSystemImplementation_8_0= ruleSystemImplementation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedSystemImplementationSystemImplementationParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemImplementation_in_rulePublicPackageSection543);
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
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:315:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:315:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:316:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:316:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:317:3: lv_ownedProcessorType_9_0= ruleProcessorType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedProcessorTypeProcessorTypeParserRuleCall_3_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProcessorType_in_rulePublicPackageSection570);
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
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:334:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:334:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:335:1: (lv_ownedDataType_10_0= ruleDataType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:335:1: (lv_ownedDataType_10_0= ruleDataType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:336:3: lv_ownedDataType_10_0= ruleDataType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPublicPackageSectionAccess().getOwnedDataTypeDataTypeParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDataType_in_rulePublicPackageSection597);
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
    // $ANTLR end "rulePublicPackageSection"


    // $ANTLR start "entryRulePrivatePackageSection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:360:1: entryRulePrivatePackageSection returns [EObject current=null] : iv_rulePrivatePackageSection= rulePrivatePackageSection EOF ;
    public final EObject entryRulePrivatePackageSection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivatePackageSection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:361:2: (iv_rulePrivatePackageSection= rulePrivatePackageSection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:362:2: iv_rulePrivatePackageSection= rulePrivatePackageSection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivatePackageSectionRule()); 
            }
            pushFollow(FOLLOW_rulePrivatePackageSection_in_entryRulePrivatePackageSection634);
            iv_rulePrivatePackageSection=rulePrivatePackageSection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivatePackageSection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrivatePackageSection644); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:369:1: rulePrivatePackageSection returns [EObject current=null] : ( () otherlv_1= KEYWORD_35 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) ;
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
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:372:28: ( ( () otherlv_1= KEYWORD_35 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:373:1: ( () otherlv_1= KEYWORD_35 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:373:1: ( () otherlv_1= KEYWORD_35 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:373:2: () otherlv_1= KEYWORD_35 ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )* ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:373:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:374:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrivatePackageSectionAccess().getPrivatePackageSectionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_rulePrivatePackageSection691); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPrivatePackageSectionAccess().getPrivateKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:384:1: ( ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==KEYWORD_16) && (synpred3_InternalAadl2Parser())) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:384:2: ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 ) ( ( rulePNAME ) ) (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )* this_SEMI_6= RULE_SEMI
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:384:2: ( ( KEYWORD_16 )=>otherlv_2= KEYWORD_16 )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:384:3: ( KEYWORD_16 )=>otherlv_2= KEYWORD_16
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_rulePrivatePackageSection711); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getPrivatePackageSectionAccess().getWithKeyword_2_0());
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:391:2: ( ( rulePNAME ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:392:1: ( rulePNAME )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:392:1: ( rulePNAME )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:393:3: rulePNAME
            	    {
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPrivatePackageSectionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePNAME_in_rulePrivatePackageSection734);
            	    rulePNAME();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:406:2: (this_COMMA_4= RULE_COMMA ( ( rulePNAME ) ) )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==RULE_COMMA) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:406:3: this_COMMA_4= RULE_COMMA ( ( rulePNAME ) )
            	    	    {
            	    	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rulePrivatePackageSection746); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_COMMA_4, grammarAccess.getPrivatePackageSectionAccess().getCOMMATerminalRuleCall_2_2_0()); 
            	    	          
            	    	    }
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:410:1: ( ( rulePNAME ) )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:411:1: ( rulePNAME )
            	    	    {
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:411:1: ( rulePNAME )
            	    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:412:3: rulePNAME
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getPrivatePackageSectionRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getImportedPackageAadlPackageCrossReference_2_2_1_0()); 
            	    	      	    
            	    	    }
            	    	    pushFollow(FOLLOW_rulePNAME_in_rulePrivatePackageSection768);
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
            	    	    break loop9;
            	        }
            	    } while (true);

            	    this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePrivatePackageSection781); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_SEMI_6, grammarAccess.getPrivatePackageSectionAccess().getSEMITerminalRuleCall_2_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:429:3: ( ( (lv_ownedSystemType_7_0= ruleSystemType ) ) | ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) ) | ( (lv_ownedProcessorType_9_0= ruleProcessorType ) ) | ( (lv_ownedDataType_10_0= ruleDataType ) ) )*
            loop11:
            do {
                int alt11=5;
                switch ( input.LA(1) ) {
                case KEYWORD_27:
                    {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2==KEYWORD_50) ) {
                        alt11=2;
                    }
                    else if ( (LA11_2==RULE_ID) ) {
                        alt11=1;
                    }


                    }
                    break;
                case KEYWORD_44:
                    {
                    alt11=3;
                    }
                    break;
                case KEYWORD_10:
                    {
                    alt11=4;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:429:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:429:4: ( (lv_ownedSystemType_7_0= ruleSystemType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:430:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:430:1: (lv_ownedSystemType_7_0= ruleSystemType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:431:3: lv_ownedSystemType_7_0= ruleSystemType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedSystemTypeSystemTypeParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemType_in_rulePrivatePackageSection804);
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
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:448:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:448:6: ( (lv_ownedSystemImplementation_8_0= ruleSystemImplementation ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:449:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:449:1: (lv_ownedSystemImplementation_8_0= ruleSystemImplementation )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:450:3: lv_ownedSystemImplementation_8_0= ruleSystemImplementation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedSystemImplementationSystemImplementationParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSystemImplementation_in_rulePrivatePackageSection831);
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
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:467:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:467:6: ( (lv_ownedProcessorType_9_0= ruleProcessorType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:468:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:468:1: (lv_ownedProcessorType_9_0= ruleProcessorType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:469:3: lv_ownedProcessorType_9_0= ruleProcessorType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedProcessorTypeProcessorTypeParserRuleCall_3_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleProcessorType_in_rulePrivatePackageSection858);
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
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:486:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:486:6: ( (lv_ownedDataType_10_0= ruleDataType ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:487:1: (lv_ownedDataType_10_0= ruleDataType )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:487:1: (lv_ownedDataType_10_0= ruleDataType )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:488:3: lv_ownedDataType_10_0= ruleDataType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrivatePackageSectionAccess().getOwnedDataTypeDataTypeParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleDataType_in_rulePrivatePackageSection885);
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
            	    break loop11;
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


    // $ANTLR start "entryRuleComponentCategoryKW"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:516:1: entryRuleComponentCategoryKW returns [String current=null] : iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF ;
    public final String entryRuleComponentCategoryKW() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategoryKW = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:517:1: (iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:518:2: iv_ruleComponentCategoryKW= ruleComponentCategoryKW EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentCategoryKWRule()); 
            }
            pushFollow(FOLLOW_ruleComponentCategoryKW_in_entryRuleComponentCategoryKW927);
            iv_ruleComponentCategoryKW=ruleComponentCategoryKW();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentCategoryKW.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategoryKW938); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:525:1: ruleComponentCategoryKW returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_39 | kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_23 | kw= KEYWORD_24 | kw= KEYWORD_36 | kw= KEYWORD_44 | (kw= KEYWORD_47 kw= KEYWORD_20 ) | kw= KEYWORD_27 | (kw= KEYWORD_28 kw= KEYWORD_20 ) | kw= KEYWORD_28 | (kw= KEYWORD_38 kw= KEYWORD_7 ) | (kw= KEYWORD_38 kw= KEYWORD_44 ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategoryKW() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:529:6: ( (kw= KEYWORD_39 | kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_23 | kw= KEYWORD_24 | kw= KEYWORD_36 | kw= KEYWORD_44 | (kw= KEYWORD_47 kw= KEYWORD_20 ) | kw= KEYWORD_27 | (kw= KEYWORD_28 kw= KEYWORD_20 ) | kw= KEYWORD_28 | (kw= KEYWORD_38 kw= KEYWORD_7 ) | (kw= KEYWORD_38 kw= KEYWORD_44 ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:530:1: (kw= KEYWORD_39 | kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_23 | kw= KEYWORD_24 | kw= KEYWORD_36 | kw= KEYWORD_44 | (kw= KEYWORD_47 kw= KEYWORD_20 ) | kw= KEYWORD_27 | (kw= KEYWORD_28 kw= KEYWORD_20 ) | kw= KEYWORD_28 | (kw= KEYWORD_38 kw= KEYWORD_7 ) | (kw= KEYWORD_38 kw= KEYWORD_44 ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:530:1: (kw= KEYWORD_39 | kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_23 | kw= KEYWORD_24 | kw= KEYWORD_36 | kw= KEYWORD_44 | (kw= KEYWORD_47 kw= KEYWORD_20 ) | kw= KEYWORD_27 | (kw= KEYWORD_28 kw= KEYWORD_20 ) | kw= KEYWORD_28 | (kw= KEYWORD_38 kw= KEYWORD_7 ) | (kw= KEYWORD_38 kw= KEYWORD_44 ) )
            int alt12=13;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:531:2: kw= KEYWORD_39
                    {
                    kw=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_ruleComponentCategoryKW976); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getAbstractKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:538:2: kw= KEYWORD_7
                    {
                    kw=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleComponentCategoryKW995); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getBusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:545:2: kw= KEYWORD_10
                    {
                    kw=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleComponentCategoryKW1014); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getDataKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:552:2: kw= KEYWORD_23
                    {
                    kw=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleComponentCategoryKW1033); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:559:2: kw= KEYWORD_24
                    {
                    kw=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_ruleComponentCategoryKW1052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getMemoryKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:566:2: kw= KEYWORD_36
                    {
                    kw=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleComponentCategoryKW1071); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:573:2: kw= KEYWORD_44
                    {
                    kw=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleComponentCategoryKW1090); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getProcessorKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:579:6: (kw= KEYWORD_47 kw= KEYWORD_20 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:579:6: (kw= KEYWORD_47 kw= KEYWORD_20 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:580:2: kw= KEYWORD_47 kw= KEYWORD_20
                    {
                    kw=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleComponentCategoryKW1110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getSubprogramKeyword_7_0()); 
                          
                    }
                    kw=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleComponentCategoryKW1123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getGroupKeyword_7_1()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:593:2: kw= KEYWORD_27
                    {
                    kw=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleComponentCategoryKW1143); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getSystemKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:599:6: (kw= KEYWORD_28 kw= KEYWORD_20 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:599:6: (kw= KEYWORD_28 kw= KEYWORD_20 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:600:2: kw= KEYWORD_28 kw= KEYWORD_20
                    {
                    kw=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleComponentCategoryKW1163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getThreadKeyword_9_0()); 
                          
                    }
                    kw=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleComponentCategoryKW1176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getGroupKeyword_9_1()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:613:2: kw= KEYWORD_28
                    {
                    kw=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleComponentCategoryKW1196); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getThreadKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:619:6: (kw= KEYWORD_38 kw= KEYWORD_7 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:619:6: (kw= KEYWORD_38 kw= KEYWORD_7 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:620:2: kw= KEYWORD_38 kw= KEYWORD_7
                    {
                    kw=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleComponentCategoryKW1216); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getVirtualKeyword_11_0()); 
                          
                    }
                    kw=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleComponentCategoryKW1229); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getBusKeyword_11_1()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:632:6: (kw= KEYWORD_38 kw= KEYWORD_44 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:632:6: (kw= KEYWORD_38 kw= KEYWORD_44 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:633:2: kw= KEYWORD_38 kw= KEYWORD_44
                    {
                    kw=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleComponentCategoryKW1250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getComponentCategoryKWAccess().getVirtualKeyword_12_0()); 
                          
                    }
                    kw=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleComponentCategoryKW1263); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:652:1: entryRuleSystemType returns [EObject current=null] : iv_ruleSystemType= ruleSystemType EOF ;
    public final EObject entryRuleSystemType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:653:2: (iv_ruleSystemType= ruleSystemType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:654:2: iv_ruleSystemType= ruleSystemType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemTypeRule()); 
            }
            pushFollow(FOLLOW_ruleSystemType_in_entryRuleSystemType1303);
            iv_ruleSystemType=ruleSystemType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemType1313); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:661:1: ruleSystemType returns [EObject current=null] : (otherlv_0= KEYWORD_27 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_SEMI_23= RULE_SEMI ) ;
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
        Token otherlv_17=null;
        Token lv_noProperties_19_0=null;
        Token otherlv_21=null;
        Token this_ID_22=null;
        Token this_SEMI_23=null;
        EObject lv_ownedPrototype_4_0 = null;

        EObject lv_ownedDataPort_7_0 = null;

        EObject lv_ownedEventPort_8_0 = null;

        EObject lv_ownedEventDataPort_9_0 = null;

        EObject lv_ownedFlowSpecification_11_0 = null;

        EObject lv_ownedMode_14_0 = null;

        EObject lv_ownedModeTransition_15_0 = null;

        EObject lv_ownedPropertyAssociation_18_0 = null;

        EObject lv_ownedAnnexSubclause_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:664:28: ( (otherlv_0= KEYWORD_27 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_SEMI_23= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:665:1: (otherlv_0= KEYWORD_27 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_SEMI_23= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:665:1: (otherlv_0= KEYWORD_27 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_SEMI_23= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:666:2: otherlv_0= KEYWORD_27 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )? ( ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_SEMI_23= RULE_SEMI
            {
            otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleSystemType1351); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSystemTypeAccess().getSystemKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:670:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:671:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:671:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:672:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemType1367); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:688:2: ( ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==KEYWORD_46) && (synpred4_InternalAadl2Parser())) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:688:3: ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 ) ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:688:3: ( ( KEYWORD_46 )=>otherlv_2= KEYWORD_46 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:688:4: ( KEYWORD_46 )=>otherlv_2= KEYWORD_46
                    {
                    otherlv_2=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_ruleSystemType1393); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getSystemTypeAccess().getPrototypesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:695:2: ( ( (lv_noPrototypes_3_0= RULE_NONE ) ) | ( (lv_ownedPrototype_4_0= rulePrototype ) )+ )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_NONE) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==RULE_ID) ) {
                        alt14=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:695:3: ( (lv_noPrototypes_3_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:695:3: ( (lv_noPrototypes_3_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:696:1: (lv_noPrototypes_3_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:696:1: (lv_noPrototypes_3_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:697:3: lv_noPrototypes_3_0= RULE_NONE
                            {
                            lv_noPrototypes_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType1411); if (state.failed) return current;
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:714:6: ( (lv_ownedPrototype_4_0= rulePrototype ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:714:6: ( (lv_ownedPrototype_4_0= rulePrototype ) )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_ID) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:715:1: (lv_ownedPrototype_4_0= rulePrototype )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:715:1: (lv_ownedPrototype_4_0= rulePrototype )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:716:3: lv_ownedPrototype_4_0= rulePrototype
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedPrototypePrototypeParserRuleCall_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_rulePrototype_in_ruleSystemType1443);
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
                            	    if ( cnt13 >= 1 ) break loop13;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:732:6: ( ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==KEYWORD_40) && (synpred5_InternalAadl2Parser())) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:732:7: ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 ) ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:732:7: ( ( KEYWORD_40 )=>otherlv_5= KEYWORD_40 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:732:8: ( KEYWORD_40 )=>otherlv_5= KEYWORD_40
                    {
                    otherlv_5=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleSystemType1468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSystemTypeAccess().getFeaturesKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:739:2: ( ( (lv_noFeatures_6_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+ )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_NONE) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RULE_ID) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:739:3: ( (lv_noFeatures_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:739:3: ( (lv_noFeatures_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:740:1: (lv_noFeatures_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:740:1: (lv_noFeatures_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:741:3: lv_noFeatures_6_0= RULE_NONE
                            {
                            lv_noFeatures_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType1486); if (state.failed) return current;
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:758:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:758:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+
                            int cnt16=0;
                            loop16:
                            do {
                                int alt16=4;
                                alt16 = dfa16.predict(input);
                                switch (alt16) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:758:7: ( (lv_ownedDataPort_7_0= ruleDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:758:7: ( (lv_ownedDataPort_7_0= ruleDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:759:1: (lv_ownedDataPort_7_0= ruleDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:759:1: (lv_ownedDataPort_7_0= ruleDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:760:3: lv_ownedDataPort_7_0= ruleDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedDataPortDataPortParserRuleCall_3_1_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataPort_in_ruleSystemType1519);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:777:6: ( (lv_ownedEventPort_8_0= ruleEventPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:777:6: ( (lv_ownedEventPort_8_0= ruleEventPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:778:1: (lv_ownedEventPort_8_0= ruleEventPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:778:1: (lv_ownedEventPort_8_0= ruleEventPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:779:3: lv_ownedEventPort_8_0= ruleEventPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedEventPortEventPortParserRuleCall_3_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventPort_in_ruleSystemType1546);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:796:6: ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:796:6: ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:797:1: (lv_ownedEventDataPort_9_0= ruleEventDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:797:1: (lv_ownedEventDataPort_9_0= ruleEventDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:798:3: lv_ownedEventDataPort_9_0= ruleEventDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedEventDataPortEventDataPortParserRuleCall_3_1_1_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventDataPort_in_ruleSystemType1573);
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
                            	    if ( cnt16 >= 1 ) break loop16;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(16, input);
                                        throw eee;
                                }
                                cnt16++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:814:7: ( ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==KEYWORD_19) && (synpred6_InternalAadl2Parser())) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:814:8: ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:814:8: ( ( KEYWORD_19 )=>otherlv_10= KEYWORD_19 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:814:9: ( KEYWORD_19 )=>otherlv_10= KEYWORD_19
                    {
                    otherlv_10=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleSystemType1599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSystemTypeAccess().getFlowsKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:821:2: ( ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_12_0= RULE_NONE ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_ID) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==RULE_NONE) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:821:3: ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:821:3: ( (lv_ownedFlowSpecification_11_0= ruleFlowSpecification ) )+
                            int cnt19=0;
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==RULE_ID) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:822:1: (lv_ownedFlowSpecification_11_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:822:1: (lv_ownedFlowSpecification_11_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:823:3: lv_ownedFlowSpecification_11_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_4_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleSystemType1621);
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
                            	    if ( cnt19 >= 1 ) break loop19;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(19, input);
                                        throw eee;
                                }
                                cnt19++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:840:6: ( (lv_noFlows_12_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:840:6: ( (lv_noFlows_12_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:841:1: (lv_noFlows_12_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:841:1: (lv_noFlows_12_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:842:3: lv_noFlows_12_0= RULE_NONE
                            {
                            lv_noFlows_12_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType1645); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:5: ( ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_16_0= RULE_NONE ) ) )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==KEYWORD_21) && (synpred7_InternalAadl2Parser())) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_NONE) ) {
                alt23=2;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:6: ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:6: ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:7: ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:7: ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:8: ( KEYWORD_21 )=>otherlv_13= KEYWORD_21
                    {
                    otherlv_13=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleSystemType1675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSystemTypeAccess().getModesKeyword_5_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:865:2: ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=3;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID) ) {
                            int LA22_2 = input.LA(2);

                            if ( (LA22_2==RULE_LTRANS) ) {
                                alt22=2;
                            }
                            else if ( (LA22_2==RULE_COLON) ) {
                                int LA22_4 = input.LA(3);

                                if ( (LA22_4==KEYWORD_32||LA22_4==KEYWORD_12) ) {
                                    alt22=1;
                                }
                                else if ( (LA22_4==RULE_ID) ) {
                                    alt22=2;
                                }


                            }


                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:865:3: ( (lv_ownedMode_14_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:865:3: ( (lv_ownedMode_14_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:866:1: (lv_ownedMode_14_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:866:1: (lv_ownedMode_14_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:867:3: lv_ownedMode_14_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedModeModeParserRuleCall_5_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleSystemType1697);
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:884:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:884:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:885:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:885:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:886:3: lv_ownedModeTransition_15_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_5_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleSystemType1724);
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
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:903:6: ( (lv_noModes_16_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:903:6: ( (lv_noModes_16_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:904:1: (lv_noModes_16_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:904:1: (lv_noModes_16_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:905:3: lv_noModes_16_0= RULE_NONE
                    {
                    lv_noModes_16_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType1750); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:921:4: ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==KEYWORD_45) && (synpred8_InternalAadl2Parser())) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:921:5: ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:921:5: ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:921:6: ( KEYWORD_45 )=>otherlv_17= KEYWORD_45
                    {
                    otherlv_17=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleSystemType1778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getSystemTypeAccess().getPropertiesKeyword_6_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:928:2: ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==RULE_ID) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==RULE_NONE) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:928:3: ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:928:3: ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+
                            int cnt24=0;
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==RULE_ID) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:929:1: (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:929:1: (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:930:3: lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_6_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleSystemType1800);
                            	    lv_ownedPropertyAssociation_18_0=ruleContainedPropertyAssociation();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPropertyAssociation",
                            	              		lv_ownedPropertyAssociation_18_0, 
                            	              		"ContainedPropertyAssociation");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
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
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:947:6: ( (lv_noProperties_19_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:947:6: ( (lv_noProperties_19_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:948:1: (lv_noProperties_19_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:948:1: (lv_noProperties_19_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:949:3: lv_noProperties_19_0= RULE_NONE
                            {
                            lv_noProperties_19_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemType1824); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noProperties_19_0, grammarAccess.getSystemTypeAccess().getNoPropertiesNONETerminalRuleCall_6_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noProperties",
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:965:5: ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==KEYWORD_17) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:966:1: (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:966:1: (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:967:3: lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleSystemType1853);
            	    lv_ownedAnnexSubclause_20_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSystemTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedAnnexSubclause",
            	              		lv_ownedAnnexSubclause_20_0, 
            	              		"AnnexSubclause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_21=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleSystemType1867); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_21, grammarAccess.getSystemTypeAccess().getEndKeyword_8());
                  
            }
            this_ID_22=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemType1877); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_22, grammarAccess.getSystemTypeAccess().getIDTerminalRuleCall_9()); 
                  
            }
            this_SEMI_23=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemType1887); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_23, grammarAccess.getSystemTypeAccess().getSEMITerminalRuleCall_10()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1008:1: entryRuleProcessorType returns [EObject current=null] : iv_ruleProcessorType= ruleProcessorType EOF ;
    public final EObject entryRuleProcessorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessorType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1009:2: (iv_ruleProcessorType= ruleProcessorType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1010:2: iv_ruleProcessorType= ruleProcessorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessorTypeRule()); 
            }
            pushFollow(FOLLOW_ruleProcessorType_in_entryRuleProcessorType1925);
            iv_ruleProcessorType=ruleProcessorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessorType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcessorType1935); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1017:1: ruleProcessorType returns [EObject current=null] : (otherlv_0= KEYWORD_44 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= KEYWORD_8 this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI ) ;
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
        Token otherlv_14=null;
        Token lv_noProperties_16_0=null;
        Token otherlv_18=null;
        Token this_ID_19=null;
        Token this_SEMI_20=null;
        EObject lv_ownedDataPort_4_0 = null;

        EObject lv_ownedEventPort_5_0 = null;

        EObject lv_ownedEventDataPort_6_0 = null;

        EObject lv_ownedFlowSpecification_8_0 = null;

        EObject lv_ownedMode_11_0 = null;

        EObject lv_ownedModeTransition_12_0 = null;

        EObject lv_ownedPropertyAssociation_15_0 = null;

        EObject lv_ownedAnnexSubclause_17_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1020:28: ( (otherlv_0= KEYWORD_44 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= KEYWORD_8 this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1021:1: (otherlv_0= KEYWORD_44 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= KEYWORD_8 this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1021:1: (otherlv_0= KEYWORD_44 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= KEYWORD_8 this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1022:2: otherlv_0= KEYWORD_44 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )? ( ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )* otherlv_18= KEYWORD_8 this_ID_19= RULE_ID this_SEMI_20= RULE_SEMI
            {
            otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleProcessorType1973); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProcessorTypeAccess().getProcessorKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1026:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1027:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1027:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1028:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorType1989); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1044:2: ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==KEYWORD_40) && (synpred9_InternalAadl2Parser())) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1044:3: ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1044:3: ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1044:4: ( KEYWORD_40 )=>otherlv_2= KEYWORD_40
                    {
                    otherlv_2=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleProcessorType2015); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getProcessorTypeAccess().getFeaturesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1051:2: ( ( (lv_noFeatures_3_0= RULE_NONE ) ) | ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+ )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_NONE) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_ID) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1051:3: ( (lv_noFeatures_3_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1051:3: ( (lv_noFeatures_3_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1052:1: (lv_noFeatures_3_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1052:1: (lv_noFeatures_3_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1053:3: lv_noFeatures_3_0= RULE_NONE
                            {
                            lv_noFeatures_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2033); if (state.failed) return current;
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1070:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1070:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+
                            int cnt28=0;
                            loop28:
                            do {
                                int alt28=4;
                                alt28 = dfa28.predict(input);
                                switch (alt28) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1070:7: ( (lv_ownedDataPort_4_0= ruleDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1070:7: ( (lv_ownedDataPort_4_0= ruleDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1071:1: (lv_ownedDataPort_4_0= ruleDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1071:1: (lv_ownedDataPort_4_0= ruleDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1072:3: lv_ownedDataPort_4_0= ruleDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedDataPortDataPortParserRuleCall_2_1_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataPort_in_ruleProcessorType2066);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1089:6: ( (lv_ownedEventPort_5_0= ruleEventPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1089:6: ( (lv_ownedEventPort_5_0= ruleEventPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1090:1: (lv_ownedEventPort_5_0= ruleEventPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1090:1: (lv_ownedEventPort_5_0= ruleEventPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1091:3: lv_ownedEventPort_5_0= ruleEventPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedEventPortEventPortParserRuleCall_2_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventPort_in_ruleProcessorType2093);
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1108:6: ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1108:6: ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1109:1: (lv_ownedEventDataPort_6_0= ruleEventDataPort )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1109:1: (lv_ownedEventDataPort_6_0= ruleEventDataPort )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1110:3: lv_ownedEventDataPort_6_0= ruleEventDataPort
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedEventDataPortEventDataPortParserRuleCall_2_1_1_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleEventDataPort_in_ruleProcessorType2120);
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
                            	    if ( cnt28 >= 1 ) break loop28;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(28, input);
                                        throw eee;
                                }
                                cnt28++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1126:7: ( ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==KEYWORD_19) && (synpred10_InternalAadl2Parser())) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1126:8: ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1126:8: ( ( KEYWORD_19 )=>otherlv_7= KEYWORD_19 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1126:9: ( KEYWORD_19 )=>otherlv_7= KEYWORD_19
                    {
                    otherlv_7=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleProcessorType2146); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getProcessorTypeAccess().getFlowsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1133:2: ( ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_9_0= RULE_NONE ) ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==RULE_ID) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==RULE_NONE) ) {
                        alt32=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1133:3: ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1133:3: ( (lv_ownedFlowSpecification_8_0= ruleFlowSpecification ) )+
                            int cnt31=0;
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==RULE_ID) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1134:1: (lv_ownedFlowSpecification_8_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1134:1: (lv_ownedFlowSpecification_8_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1135:3: lv_ownedFlowSpecification_8_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleProcessorType2168);
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
                            	    if ( cnt31 >= 1 ) break loop31;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(31, input);
                                        throw eee;
                                }
                                cnt31++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1152:6: ( (lv_noFlows_9_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1152:6: ( (lv_noFlows_9_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1153:1: (lv_noFlows_9_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1153:1: (lv_noFlows_9_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1154:3: lv_noFlows_9_0= RULE_NONE
                            {
                            lv_noFlows_9_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2192); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:5: ( ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_13_0= RULE_NONE ) ) )?
            int alt35=3;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==KEYWORD_21) && (synpred11_InternalAadl2Parser())) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_NONE) ) {
                alt35=2;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:6: ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:6: ( ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:7: ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 ) ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:7: ( ( KEYWORD_21 )=>otherlv_10= KEYWORD_21 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:8: ( KEYWORD_21 )=>otherlv_10= KEYWORD_21
                    {
                    otherlv_10=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleProcessorType2222); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getProcessorTypeAccess().getModesKeyword_4_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1177:2: ( ( (lv_ownedMode_11_0= ruleMode ) ) | ( (lv_ownedModeTransition_12_0= ruleModeTransition ) ) )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=3;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_ID) ) {
                            int LA34_2 = input.LA(2);

                            if ( (LA34_2==RULE_COLON) ) {
                                int LA34_3 = input.LA(3);

                                if ( (LA34_3==KEYWORD_32||LA34_3==KEYWORD_12) ) {
                                    alt34=1;
                                }
                                else if ( (LA34_3==RULE_ID) ) {
                                    alt34=2;
                                }


                            }
                            else if ( (LA34_2==RULE_LTRANS) ) {
                                alt34=2;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1177:3: ( (lv_ownedMode_11_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1177:3: ( (lv_ownedMode_11_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1178:1: (lv_ownedMode_11_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1178:1: (lv_ownedMode_11_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1179:3: lv_ownedMode_11_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedModeModeParserRuleCall_4_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleProcessorType2244);
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1196:6: ( (lv_ownedModeTransition_12_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1196:6: ( (lv_ownedModeTransition_12_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1197:1: (lv_ownedModeTransition_12_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1197:1: (lv_ownedModeTransition_12_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1198:3: lv_ownedModeTransition_12_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_4_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleProcessorType2271);
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
                    	    if ( cnt34 >= 1 ) break loop34;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1215:6: ( (lv_noModes_13_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1215:6: ( (lv_noModes_13_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1216:1: (lv_noModes_13_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1216:1: (lv_noModes_13_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1217:3: lv_noModes_13_0= RULE_NONE
                    {
                    lv_noModes_13_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2297); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1233:4: ( ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==KEYWORD_45) && (synpred12_InternalAadl2Parser())) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1233:5: ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1233:5: ( ( KEYWORD_45 )=>otherlv_14= KEYWORD_45 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1233:6: ( KEYWORD_45 )=>otherlv_14= KEYWORD_45
                    {
                    otherlv_14=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleProcessorType2325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getProcessorTypeAccess().getPropertiesKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1240:2: ( ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_16_0= RULE_NONE ) ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==RULE_ID) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==RULE_NONE) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1240:3: ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1240:3: ( (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation ) )+
                            int cnt36=0;
                            loop36:
                            do {
                                int alt36=2;
                                int LA36_0 = input.LA(1);

                                if ( (LA36_0==RULE_ID) ) {
                                    alt36=1;
                                }


                                switch (alt36) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1241:1: (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1241:1: (lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1242:3: lv_ownedPropertyAssociation_15_0= ruleContainedPropertyAssociation
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_5_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleProcessorType2347);
                            	    lv_ownedPropertyAssociation_15_0=ruleContainedPropertyAssociation();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPropertyAssociation",
                            	              		lv_ownedPropertyAssociation_15_0, 
                            	              		"ContainedPropertyAssociation");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt36 >= 1 ) break loop36;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(36, input);
                                        throw eee;
                                }
                                cnt36++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1259:6: ( (lv_noProperties_16_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1259:6: ( (lv_noProperties_16_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1260:1: (lv_noProperties_16_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1260:1: (lv_noProperties_16_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1261:3: lv_noProperties_16_0= RULE_NONE
                            {
                            lv_noProperties_16_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleProcessorType2371); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noProperties_16_0, grammarAccess.getProcessorTypeAccess().getNoPropertiesNONETerminalRuleCall_5_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getProcessorTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noProperties",
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1277:5: ( (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==KEYWORD_17) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1278:1: (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1278:1: (lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1279:3: lv_ownedAnnexSubclause_17_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProcessorTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleProcessorType2400);
            	    lv_ownedAnnexSubclause_17_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProcessorTypeRule());
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
            	    break loop39;
                }
            } while (true);

            otherlv_18=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleProcessorType2414); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_18, grammarAccess.getProcessorTypeAccess().getEndKeyword_7());
                  
            }
            this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorType2424); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_19, grammarAccess.getProcessorTypeAccess().getIDTerminalRuleCall_8()); 
                  
            }
            this_SEMI_20=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleProcessorType2434); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_20, grammarAccess.getProcessorTypeAccess().getSEMITerminalRuleCall_9()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1316:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1317:2: (iv_ruleDataType= ruleDataType EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1318:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FOLLOW_ruleDataType_in_entryRuleDataType2468);
            iv_ruleDataType=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataType2478); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1325:1: ruleDataType returns [EObject current=null] : (otherlv_0= KEYWORD_10 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= KEYWORD_8 this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI ) ;
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
        Token otherlv_11=null;
        Token lv_noProperties_13_0=null;
        Token otherlv_15=null;
        Token this_ID_16=null;
        Token this_SEMI_17=null;
        EObject lv_ownedFlowSpecification_5_0 = null;

        EObject lv_ownedMode_8_0 = null;

        EObject lv_ownedModeTransition_9_0 = null;

        EObject lv_ownedPropertyAssociation_12_0 = null;

        EObject lv_ownedAnnexSubclause_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1328:28: ( (otherlv_0= KEYWORD_10 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= KEYWORD_8 this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1329:1: (otherlv_0= KEYWORD_10 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= KEYWORD_8 this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1329:1: (otherlv_0= KEYWORD_10 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= KEYWORD_8 this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1330:2: otherlv_0= KEYWORD_10 ( (lv_name_1_0= RULE_ID ) ) ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )? ( ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )? ( ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )? ( ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )* otherlv_15= KEYWORD_8 this_ID_16= RULE_ID this_SEMI_17= RULE_SEMI
            {
            otherlv_0=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleDataType2516); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDataTypeAccess().getDataKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1334:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1335:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1335:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1336:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType2532); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1352:2: ( ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==KEYWORD_40) && (synpred13_InternalAadl2Parser())) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1352:3: ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 ) ( (lv_noFeatures_3_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1352:3: ( ( KEYWORD_40 )=>otherlv_2= KEYWORD_40 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1352:4: ( KEYWORD_40 )=>otherlv_2= KEYWORD_40
                    {
                    otherlv_2=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleDataType2558); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDataTypeAccess().getFeaturesKeyword_2_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1359:2: ( (lv_noFeatures_3_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1360:1: (lv_noFeatures_3_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1360:1: (lv_noFeatures_3_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1361:3: lv_noFeatures_3_0= RULE_NONE
                    {
                    lv_noFeatures_3_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType2575); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1377:4: ( ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==KEYWORD_19) && (synpred14_InternalAadl2Parser())) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1377:5: ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 ) ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1377:5: ( ( KEYWORD_19 )=>otherlv_4= KEYWORD_19 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1377:6: ( KEYWORD_19 )=>otherlv_4= KEYWORD_19
                    {
                    otherlv_4=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleDataType2603); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDataTypeAccess().getFlowsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1384:2: ( ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+ | ( (lv_noFlows_6_0= RULE_NONE ) ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==RULE_ID) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==RULE_NONE) ) {
                        alt42=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1384:3: ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1384:3: ( (lv_ownedFlowSpecification_5_0= ruleFlowSpecification ) )+
                            int cnt41=0;
                            loop41:
                            do {
                                int alt41=2;
                                int LA41_0 = input.LA(1);

                                if ( (LA41_0==RULE_ID) ) {
                                    alt41=1;
                                }


                                switch (alt41) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1385:1: (lv_ownedFlowSpecification_5_0= ruleFlowSpecification )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1385:1: (lv_ownedFlowSpecification_5_0= ruleFlowSpecification )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1386:3: lv_ownedFlowSpecification_5_0= ruleFlowSpecification
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedFlowSpecificationFlowSpecificationParserRuleCall_3_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleFlowSpecification_in_ruleDataType2625);
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
                            	    if ( cnt41 >= 1 ) break loop41;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(41, input);
                                        throw eee;
                                }
                                cnt41++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1403:6: ( (lv_noFlows_6_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1403:6: ( (lv_noFlows_6_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1404:1: (lv_noFlows_6_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1404:1: (lv_noFlows_6_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1405:3: lv_noFlows_6_0= RULE_NONE
                            {
                            lv_noFlows_6_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType2649); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:5: ( ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ ) | ( (lv_noModes_10_0= RULE_NONE ) ) )?
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==KEYWORD_21) && (synpred15_InternalAadl2Parser())) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_NONE) ) {
                alt45=2;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:6: ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:6: ( ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+ )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:7: ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 ) ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:7: ( ( KEYWORD_21 )=>otherlv_7= KEYWORD_21 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:8: ( KEYWORD_21 )=>otherlv_7= KEYWORD_21
                    {
                    otherlv_7=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleDataType2679); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDataTypeAccess().getModesKeyword_4_0_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1428:2: ( ( (lv_ownedMode_8_0= ruleMode ) ) | ( (lv_ownedModeTransition_9_0= ruleModeTransition ) ) )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=3;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==RULE_ID) ) {
                            int LA44_2 = input.LA(2);

                            if ( (LA44_2==RULE_LTRANS) ) {
                                alt44=2;
                            }
                            else if ( (LA44_2==RULE_COLON) ) {
                                int LA44_4 = input.LA(3);

                                if ( (LA44_4==KEYWORD_32||LA44_4==KEYWORD_12) ) {
                                    alt44=1;
                                }
                                else if ( (LA44_4==RULE_ID) ) {
                                    alt44=2;
                                }


                            }


                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1428:3: ( (lv_ownedMode_8_0= ruleMode ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1428:3: ( (lv_ownedMode_8_0= ruleMode ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1429:1: (lv_ownedMode_8_0= ruleMode )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1429:1: (lv_ownedMode_8_0= ruleMode )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1430:3: lv_ownedMode_8_0= ruleMode
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedModeModeParserRuleCall_4_0_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMode_in_ruleDataType2701);
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1447:6: ( (lv_ownedModeTransition_9_0= ruleModeTransition ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1447:6: ( (lv_ownedModeTransition_9_0= ruleModeTransition ) )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1448:1: (lv_ownedModeTransition_9_0= ruleModeTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1448:1: (lv_ownedModeTransition_9_0= ruleModeTransition )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1449:3: lv_ownedModeTransition_9_0= ruleModeTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedModeTransitionModeTransitionParserRuleCall_4_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModeTransition_in_ruleDataType2728);
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
                    	    if ( cnt44 >= 1 ) break loop44;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1466:6: ( (lv_noModes_10_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1466:6: ( (lv_noModes_10_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1467:1: (lv_noModes_10_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1467:1: (lv_noModes_10_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1468:3: lv_noModes_10_0= RULE_NONE
                    {
                    lv_noModes_10_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType2754); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1484:4: ( ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==KEYWORD_45) && (synpred16_InternalAadl2Parser())) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1484:5: ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1484:5: ( ( KEYWORD_45 )=>otherlv_11= KEYWORD_45 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1484:6: ( KEYWORD_45 )=>otherlv_11= KEYWORD_45
                    {
                    otherlv_11=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleDataType2782); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDataTypeAccess().getPropertiesKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1491:2: ( ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_13_0= RULE_NONE ) ) )
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1491:3: ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1491:3: ( (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation ) )+
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1492:1: (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1492:1: (lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1493:3: lv_ownedPropertyAssociation_12_0= ruleContainedPropertyAssociation
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_5_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleDataType2804);
                            	    lv_ownedPropertyAssociation_12_0=ruleContainedPropertyAssociation();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPropertyAssociation",
                            	              		lv_ownedPropertyAssociation_12_0, 
                            	              		"ContainedPropertyAssociation");
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1510:6: ( (lv_noProperties_13_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1510:6: ( (lv_noProperties_13_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1511:1: (lv_noProperties_13_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1511:1: (lv_noProperties_13_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1512:3: lv_noProperties_13_0= RULE_NONE
                            {
                            lv_noProperties_13_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleDataType2828); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noProperties_13_0, grammarAccess.getDataTypeAccess().getNoPropertiesNONETerminalRuleCall_5_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDataTypeRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noProperties",
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1528:5: ( (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==KEYWORD_17) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1529:1: (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1529:1: (lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1530:3: lv_ownedAnnexSubclause_14_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDataTypeAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleDataType2857);
            	    lv_ownedAnnexSubclause_14_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDataTypeRule());
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
            	    break loop49;
                }
            } while (true);

            otherlv_15=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleDataType2871); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getDataTypeAccess().getEndKeyword_7());
                  
            }
            this_ID_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataType2881); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_16, grammarAccess.getDataTypeAccess().getIDTerminalRuleCall_8()); 
                  
            }
            this_SEMI_17=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataType2891); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_17, grammarAccess.getDataTypeAccess().getSEMITerminalRuleCall_9()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1567:1: entryRuleSystemImplementation returns [EObject current=null] : iv_ruleSystemImplementation= ruleSystemImplementation EOF ;
    public final EObject entryRuleSystemImplementation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemImplementation = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1568:2: (iv_ruleSystemImplementation= ruleSystemImplementation EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1569:2: iv_ruleSystemImplementation= ruleSystemImplementation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemImplementationRule()); 
            }
            pushFollow(FOLLOW_ruleSystemImplementation_in_entryRuleSystemImplementation2925);
            iv_ruleSystemImplementation=ruleSystemImplementation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemImplementation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemImplementation2935); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1576:1: ruleSystemImplementation returns [EObject current=null] : ( () otherlv_1= KEYWORD_27 otherlv_2= KEYWORD_50 ( ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) ) )? ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_DOT_23= RULE_DOT ruleINAME this_SEMI_25= RULE_SEMI ) ;
    public final EObject ruleSystemImplementation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_noSubcomponents_7_0=null;
        Token otherlv_8=null;
        Token lv_noConnections_10_0=null;
        Token otherlv_11=null;
        Token lv_noFlows_12_0=null;
        Token otherlv_13=null;
        Token lv_noModes_16_0=null;
        Token otherlv_17=null;
        Token lv_noProperties_19_0=null;
        Token otherlv_21=null;
        Token this_ID_22=null;
        Token this_DOT_23=null;
        Token this_SEMI_25=null;
        EObject lv_ownedSystemSubcomponent_4_0 = null;

        EObject lv_ownedProcessorSubcomponent_5_0 = null;

        EObject lv_ownedDataSubcomponent_6_0 = null;

        EObject lv_ownedPortConnection_9_0 = null;

        EObject lv_ownedMode_14_0 = null;

        EObject lv_ownedModeTransition_15_0 = null;

        EObject lv_ownedPropertyAssociation_18_0 = null;

        EObject lv_ownedAnnexSubclause_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1579:28: ( ( () otherlv_1= KEYWORD_27 otherlv_2= KEYWORD_50 ( ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) ) )? ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_DOT_23= RULE_DOT ruleINAME this_SEMI_25= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1580:1: ( () otherlv_1= KEYWORD_27 otherlv_2= KEYWORD_50 ( ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) ) )? ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_DOT_23= RULE_DOT ruleINAME this_SEMI_25= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1580:1: ( () otherlv_1= KEYWORD_27 otherlv_2= KEYWORD_50 ( ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) ) )? ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_DOT_23= RULE_DOT ruleINAME this_SEMI_25= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1580:2: () otherlv_1= KEYWORD_27 otherlv_2= KEYWORD_50 ( ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) ) )? ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) ) )? ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )? ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )* otherlv_21= KEYWORD_8 this_ID_22= RULE_ID this_DOT_23= RULE_DOT ruleINAME this_SEMI_25= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1580:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1581:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSystemImplementationAccess().getSystemImplementationAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleSystemImplementation2982); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSystemImplementationAccess().getSystemKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleSystemImplementation2994); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSystemImplementationAccess().getImplementationKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1596:1: ( ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==KEYWORD_49) && (synpred17_InternalAadl2Parser())) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1596:2: ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 ) ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1596:2: ( ( KEYWORD_49 )=>otherlv_3= KEYWORD_49 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1596:3: ( KEYWORD_49 )=>otherlv_3= KEYWORD_49
                    {
                    otherlv_3=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleSystemImplementation3014); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSystemImplementationAccess().getSubcomponentsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1603:2: ( ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+ | ( (lv_noSubcomponents_7_0= RULE_NONE ) ) )
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1603:3: ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1603:3: ( ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) ) | ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) ) | ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) ) )+
                            int cnt50=0;
                            loop50:
                            do {
                                int alt50=4;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==RULE_ID) ) {
                                    int LA50_2 = input.LA(2);

                                    if ( (LA50_2==RULE_COLON) ) {
                                        switch ( input.LA(3) ) {
                                        case KEYWORD_10:
                                            {
                                            alt50=3;
                                            }
                                            break;
                                        case KEYWORD_44:
                                            {
                                            alt50=2;
                                            }
                                            break;
                                        case KEYWORD_27:
                                            {
                                            alt50=1;
                                            }
                                            break;

                                        }

                                    }


                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1603:4: ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1603:4: ( (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1604:1: (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1604:1: (lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1605:3: lv_ownedSystemSubcomponent_4_0= ruleSystemSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedSystemSubcomponentSystemSubcomponentParserRuleCall_3_1_0_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleSystemSubcomponent_in_ruleSystemImplementation3037);
                            	    lv_ownedSystemSubcomponent_4_0=ruleSystemSubcomponent();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedSystemSubcomponent",
                            	              		lv_ownedSystemSubcomponent_4_0, 
                            	              		"SystemSubcomponent");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1622:6: ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1622:6: ( (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1623:1: (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1623:1: (lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1624:3: lv_ownedProcessorSubcomponent_5_0= ruleProcessorSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedProcessorSubcomponentProcessorSubcomponentParserRuleCall_3_1_0_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleProcessorSubcomponent_in_ruleSystemImplementation3064);
                            	    lv_ownedProcessorSubcomponent_5_0=ruleProcessorSubcomponent();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedProcessorSubcomponent",
                            	              		lv_ownedProcessorSubcomponent_5_0, 
                            	              		"ProcessorSubcomponent");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;
                            	case 3 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1641:6: ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1641:6: ( (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1642:1: (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1642:1: (lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1643:3: lv_ownedDataSubcomponent_6_0= ruleDataSubcomponent
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedDataSubcomponentDataSubcomponentParserRuleCall_3_1_0_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleDataSubcomponent_in_ruleSystemImplementation3091);
                            	    lv_ownedDataSubcomponent_6_0=ruleDataSubcomponent();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedDataSubcomponent",
                            	              		lv_ownedDataSubcomponent_6_0, 
                            	              		"DataSubcomponent");
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1660:6: ( (lv_noSubcomponents_7_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1660:6: ( (lv_noSubcomponents_7_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1661:1: (lv_noSubcomponents_7_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1661:1: (lv_noSubcomponents_7_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1662:3: lv_noSubcomponents_7_0= RULE_NONE
                            {
                            lv_noSubcomponents_7_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3116); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noSubcomponents_7_0, grammarAccess.getSystemImplementationAccess().getNoSubcomponentsNONETerminalRuleCall_3_1_1_0()); 
                              		
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1678:5: ( ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==KEYWORD_48) && (synpred18_InternalAadl2Parser())) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1678:6: ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 ) ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1678:6: ( ( KEYWORD_48 )=>otherlv_8= KEYWORD_48 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1678:7: ( KEYWORD_48 )=>otherlv_8= KEYWORD_48
                    {
                    otherlv_8=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_ruleSystemImplementation3145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSystemImplementationAccess().getConnectionsKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1685:2: ( ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+ | ( (lv_noConnections_10_0= RULE_NONE ) ) )
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==RULE_ID) ) {
                        alt54=1;
                    }
                    else if ( (LA54_0==RULE_NONE) ) {
                        alt54=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 0, input);

                        throw nvae;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1685:3: ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1685:3: ( (lv_ownedPortConnection_9_0= rulePortConnection ) )+
                            int cnt53=0;
                            loop53:
                            do {
                                int alt53=2;
                                int LA53_0 = input.LA(1);

                                if ( (LA53_0==RULE_ID) ) {
                                    alt53=1;
                                }


                                switch (alt53) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1686:1: (lv_ownedPortConnection_9_0= rulePortConnection )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1686:1: (lv_ownedPortConnection_9_0= rulePortConnection )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1687:3: lv_ownedPortConnection_9_0= rulePortConnection
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedPortConnectionPortConnectionParserRuleCall_4_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_rulePortConnection_in_ruleSystemImplementation3167);
                            	    lv_ownedPortConnection_9_0=rulePortConnection();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPortConnection",
                            	              		lv_ownedPortConnection_9_0, 
                            	              		"PortConnection");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt53 >= 1 ) break loop53;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(53, input);
                                        throw eee;
                                }
                                cnt53++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1704:6: ( (lv_noConnections_10_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1704:6: ( (lv_noConnections_10_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1705:1: (lv_noConnections_10_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1705:1: (lv_noConnections_10_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1706:3: lv_noConnections_10_0= RULE_NONE
                            {
                            lv_noConnections_10_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3191); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noConnections_10_0, grammarAccess.getSystemImplementationAccess().getNoConnectionsNONETerminalRuleCall_4_1_1_0()); 
                              		
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1722:5: ( ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==KEYWORD_19) && (synpred19_InternalAadl2Parser())) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1722:6: ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 ) ( (lv_noFlows_12_0= RULE_NONE ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1722:6: ( ( KEYWORD_19 )=>otherlv_11= KEYWORD_19 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1722:7: ( KEYWORD_19 )=>otherlv_11= KEYWORD_19
                    {
                    otherlv_11=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleSystemImplementation3220); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getSystemImplementationAccess().getFlowsKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1729:2: ( (lv_noFlows_12_0= RULE_NONE ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1730:1: (lv_noFlows_12_0= RULE_NONE )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1730:1: (lv_noFlows_12_0= RULE_NONE )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1731:3: lv_noFlows_12_0= RULE_NONE
                    {
                    lv_noFlows_12_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3237); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_noFlows_12_0, grammarAccess.getSystemImplementationAccess().getNoFlowsNONETerminalRuleCall_5_1_0()); 
                      		
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1747:4: ( ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==KEYWORD_21) && (synpred20_InternalAadl2Parser())) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1747:5: ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 ) ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1747:5: ( ( KEYWORD_21 )=>otherlv_13= KEYWORD_21 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1747:6: ( KEYWORD_21 )=>otherlv_13= KEYWORD_21
                    {
                    otherlv_13=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleSystemImplementation3265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSystemImplementationAccess().getModesKeyword_6_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1754:2: ( ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+ | ( (lv_noModes_16_0= RULE_NONE ) ) )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==RULE_ID) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==RULE_NONE) ) {
                        alt58=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1754:3: ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1754:3: ( ( (lv_ownedMode_14_0= ruleMode ) ) | ( (lv_ownedModeTransition_15_0= ruleModeTransition ) ) )+
                            int cnt57=0;
                            loop57:
                            do {
                                int alt57=3;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==RULE_ID) ) {
                                    int LA57_2 = input.LA(2);

                                    if ( (LA57_2==RULE_COLON) ) {
                                        int LA57_3 = input.LA(3);

                                        if ( (LA57_3==KEYWORD_32||LA57_3==KEYWORD_12) ) {
                                            alt57=1;
                                        }
                                        else if ( (LA57_3==RULE_ID) ) {
                                            alt57=2;
                                        }


                                    }
                                    else if ( (LA57_2==RULE_LTRANS) ) {
                                        alt57=2;
                                    }


                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1754:4: ( (lv_ownedMode_14_0= ruleMode ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1754:4: ( (lv_ownedMode_14_0= ruleMode ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1755:1: (lv_ownedMode_14_0= ruleMode )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1755:1: (lv_ownedMode_14_0= ruleMode )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1756:3: lv_ownedMode_14_0= ruleMode
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedModeModeParserRuleCall_6_1_0_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleMode_in_ruleSystemImplementation3288);
                            	    lv_ownedMode_14_0=ruleMode();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
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
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1773:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1773:6: ( (lv_ownedModeTransition_15_0= ruleModeTransition ) )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1774:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1774:1: (lv_ownedModeTransition_15_0= ruleModeTransition )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1775:3: lv_ownedModeTransition_15_0= ruleModeTransition
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedModeTransitionModeTransitionParserRuleCall_6_1_0_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeTransition_in_ruleSystemImplementation3315);
                            	    lv_ownedModeTransition_15_0=ruleModeTransition();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
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
                            	    if ( cnt57 >= 1 ) break loop57;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(57, input);
                                        throw eee;
                                }
                                cnt57++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1792:6: ( (lv_noModes_16_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1792:6: ( (lv_noModes_16_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1793:1: (lv_noModes_16_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1793:1: (lv_noModes_16_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1794:3: lv_noModes_16_0= RULE_NONE
                            {
                            lv_noModes_16_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3340); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noModes_16_0, grammarAccess.getSystemImplementationAccess().getNoModesNONETerminalRuleCall_6_1_1_0()); 
                              		
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1810:5: ( ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==KEYWORD_45) && (synpred21_InternalAadl2Parser())) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1810:6: ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 ) ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1810:6: ( ( KEYWORD_45 )=>otherlv_17= KEYWORD_45 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1810:7: ( KEYWORD_45 )=>otherlv_17= KEYWORD_45
                    {
                    otherlv_17=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleSystemImplementation3369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getSystemImplementationAccess().getPropertiesKeyword_7_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1817:2: ( ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+ | ( (lv_noProperties_19_0= RULE_NONE ) ) )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==RULE_ID) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==RULE_NONE) ) {
                        alt61=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1817:3: ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1817:3: ( (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation ) )+
                            int cnt60=0;
                            loop60:
                            do {
                                int alt60=2;
                                int LA60_0 = input.LA(1);

                                if ( (LA60_0==RULE_ID) ) {
                                    alt60=1;
                                }


                                switch (alt60) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1818:1: (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1818:1: (lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1819:3: lv_ownedPropertyAssociation_18_0= ruleContainedPropertyAssociation
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_7_1_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleSystemImplementation3391);
                            	    lv_ownedPropertyAssociation_18_0=ruleContainedPropertyAssociation();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedPropertyAssociation",
                            	              		lv_ownedPropertyAssociation_18_0, 
                            	              		"ContainedPropertyAssociation");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt60 >= 1 ) break loop60;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(60, input);
                                        throw eee;
                                }
                                cnt60++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1836:6: ( (lv_noProperties_19_0= RULE_NONE ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1836:6: ( (lv_noProperties_19_0= RULE_NONE ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1837:1: (lv_noProperties_19_0= RULE_NONE )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1837:1: (lv_noProperties_19_0= RULE_NONE )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1838:3: lv_noProperties_19_0= RULE_NONE
                            {
                            lv_noProperties_19_0=(Token)match(input,RULE_NONE,FOLLOW_RULE_NONE_in_ruleSystemImplementation3415); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_noProperties_19_0, grammarAccess.getSystemImplementationAccess().getNoPropertiesNONETerminalRuleCall_7_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSystemImplementationRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"noProperties",
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1854:5: ( (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==KEYWORD_17) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1855:1: (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1855:1: (lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1856:3: lv_ownedAnnexSubclause_20_0= ruleAnnexSubclause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSystemImplementationAccess().getOwnedAnnexSubclauseAnnexSubclauseParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAnnexSubclause_in_ruleSystemImplementation3444);
            	    lv_ownedAnnexSubclause_20_0=ruleAnnexSubclause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSystemImplementationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedAnnexSubclause",
            	              		lv_ownedAnnexSubclause_20_0, 
            	              		"AnnexSubclause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            otherlv_21=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleSystemImplementation3458); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_21, grammarAccess.getSystemImplementationAccess().getEndKeyword_9());
                  
            }
            this_ID_22=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemImplementation3468); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_22, grammarAccess.getSystemImplementationAccess().getIDTerminalRuleCall_10()); 
                  
            }
            this_DOT_23=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSystemImplementation3478); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_23, grammarAccess.getSystemImplementationAccess().getDOTTerminalRuleCall_11()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSystemImplementationAccess().getINAMEParserRuleCall_12()); 
                  
            }
            pushFollow(FOLLOW_ruleINAME_in_ruleSystemImplementation3493);
            ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      afterParserOrEnumRuleCall();
                  
            }
            this_SEMI_25=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemImplementation3503); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_25, grammarAccess.getSystemImplementationAccess().getSEMITerminalRuleCall_13()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1909:1: entryRulePrototype returns [EObject current=null] : iv_rulePrototype= rulePrototype EOF ;
    public final EObject entryRulePrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1910:2: (iv_rulePrototype= rulePrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1911:2: iv_rulePrototype= rulePrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrototypeRule()); 
            }
            pushFollow(FOLLOW_rulePrototype_in_entryRulePrototype3541);
            iv_rulePrototype=rulePrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrototype3551); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1918:1: rulePrototype returns [EObject current=null] : ( (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ( ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI ) ;
    public final EObject rulePrototype() throws RecognitionException {
        EObject current = null;

        Token this_LCURLY_3=null;
        Token this_RCURLY_5=null;
        Token this_SEMI_6=null;
        EObject this_ComponentPrototype_0 = null;

        EObject this_FeatureGroupPrototype_1 = null;

        EObject this_FeaturePrototype_2 = null;

        EObject lv_ownedPropertyAssociation_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1921:28: ( ( (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ( ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1922:1: ( (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ( ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1922:1: ( (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ( ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1922:2: (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype ) ( ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1922:2: (this_ComponentPrototype_0= ruleComponentPrototype | this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype | this_FeaturePrototype_2= ruleFeaturePrototype )
            int alt64=3;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_COLON) ) {
                    switch ( input.LA(3) ) {
                    case KEYWORD_37:
                        {
                        int LA64_3 = input.LA(4);

                        if ( (LA64_3==KEYWORD_4) ) {
                            int LA64_6 = input.LA(5);

                            if ( (LA64_6==KEYWORD_47||(LA64_6>=KEYWORD_44 && LA64_6<=KEYWORD_39)||LA64_6==KEYWORD_36||LA64_6==KEYWORD_38||(LA64_6>=KEYWORD_23 && LA64_6<=KEYWORD_24)||(LA64_6>=KEYWORD_27 && LA64_6<=KEYWORD_28)||LA64_6==KEYWORD_10||LA64_6==KEYWORD_7) ) {
                                alt64=1;
                            }
                            else if ( (LA64_6==KEYWORD_31) ) {
                                int LA64_4 = input.LA(6);

                                if ( (LA64_4==KEYWORD_9||LA64_4==KEYWORD_2||LA64_4==RULE_SEMI||LA64_4==RULE_LCURLY||LA64_4==RULE_ID) ) {
                                    alt64=3;
                                }
                                else if ( (LA64_4==KEYWORD_20) ) {
                                    alt64=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return current;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 64, 4, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 64, 6, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 64, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case KEYWORD_31:
                        {
                        int LA64_4 = input.LA(4);

                        if ( (LA64_4==KEYWORD_9||LA64_4==KEYWORD_2||LA64_4==RULE_SEMI||LA64_4==RULE_LCURLY||LA64_4==RULE_ID) ) {
                            alt64=3;
                        }
                        else if ( (LA64_4==KEYWORD_20) ) {
                            alt64=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 64, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case KEYWORD_47:
                    case KEYWORD_44:
                    case KEYWORD_39:
                    case KEYWORD_36:
                    case KEYWORD_38:
                    case KEYWORD_23:
                    case KEYWORD_24:
                    case KEYWORD_27:
                    case KEYWORD_28:
                    case KEYWORD_10:
                    case KEYWORD_7:
                        {
                        alt64=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1923:5: this_ComponentPrototype_0= ruleComponentPrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getComponentPrototypeParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentPrototype_in_rulePrototype3599);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1933:5: this_FeatureGroupPrototype_1= ruleFeatureGroupPrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getFeatureGroupPrototypeParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureGroupPrototype_in_rulePrototype3626);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1943:5: this_FeaturePrototype_2= ruleFeaturePrototype
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrototypeAccess().getFeaturePrototypeParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeaturePrototype_in_rulePrototype3653);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1951:2: ( ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_LCURLY) && (synpred22_InternalAadl2Parser())) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1951:3: ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1951:3: ( ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1951:4: ( RULE_LCURLY )=>this_LCURLY_3= RULE_LCURLY
                    {
                    this_LCURLY_3=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_rulePrototype3670); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_3, grammarAccess.getPrototypeAccess().getLCURLYTerminalRuleCall_1_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1955:2: ( (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation ) )+
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1956:1: (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1956:1: (lv_ownedPropertyAssociation_4_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1957:3: lv_ownedPropertyAssociation_4_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPrototypeAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_rulePrototype3691);
                    	    lv_ownedPropertyAssociation_4_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPrototypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_4_0, 
                    	              		"PropertyAssociation");
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

                    this_RCURLY_5=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_rulePrototype3703); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_5, grammarAccess.getPrototypeAccess().getRCURLYTerminalRuleCall_1_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePrototype3715); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_6, grammarAccess.getPrototypeAccess().getSEMITerminalRuleCall_2()); 
                  
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
    // $ANTLR end "rulePrototype"


    // $ANTLR start "entryRuleComponentPrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1989:1: entryRuleComponentPrototype returns [EObject current=null] : iv_ruleComponentPrototype= ruleComponentPrototype EOF ;
    public final EObject entryRuleComponentPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentPrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1990:2: (iv_ruleComponentPrototype= ruleComponentPrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1991:2: iv_ruleComponentPrototype= ruleComponentPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleComponentPrototype_in_entryRuleComponentPrototype3749);
            iv_ruleComponentPrototype=ruleComponentPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentPrototype3759); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1998:1: ruleComponentPrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? ( (lv_category_4_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? ( ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET )? ) ;
    public final EObject ruleComponentPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_array_6_0=null;
        Token this_RBRACKET_7=null;
        AntlrDatatypeRuleToken lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2001:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? ( (lv_category_4_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? ( ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2002:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? ( (lv_category_4_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? ( ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2002:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? ( (lv_category_4_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? ( ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2002:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? ( (lv_category_4_0= ruleComponentCategoryKW ) ) ( ( ruleQCREF ) )? ( ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2002:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2003:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2003:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2004:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentPrototype3801); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleComponentPrototype3817); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getComponentPrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2024:1: (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==KEYWORD_37) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2025:2: otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4
                    {
                    otherlv_2=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleComponentPrototype3830); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getComponentPrototypeAccess().getRefinedKeyword_2_0());
                          
                    }
                    otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleComponentPrototype3842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getComponentPrototypeAccess().getToKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2034:3: ( (lv_category_4_0= ruleComponentCategoryKW ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2035:1: (lv_category_4_0= ruleComponentCategoryKW )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2035:1: (lv_category_4_0= ruleComponentCategoryKW )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2036:3: lv_category_4_0= ruleComponentCategoryKW
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentPrototypeAccess().getCategoryComponentCategoryKWParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleComponentCategoryKW_in_ruleComponentPrototype3864);
            lv_category_4_0=ruleComponentCategoryKW();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentPrototypeRule());
              	        }
                     		set(
                     			current, 
                     			"category",
                      		lv_category_4_0, 
                      		"ComponentCategoryKW");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2052:2: ( ( ruleQCREF ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2053:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2053:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2054:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getComponentPrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentPrototypeAccess().getConstrainingClassifierComponentClassifierCrossReference_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleComponentPrototype3887);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2067:3: ( ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_LBRACKET) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2067:4: ( (lv_array_6_0= RULE_LBRACKET ) ) this_RBRACKET_7= RULE_RBRACKET
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2067:4: ( (lv_array_6_0= RULE_LBRACKET ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2068:1: (lv_array_6_0= RULE_LBRACKET )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2068:1: (lv_array_6_0= RULE_LBRACKET )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2069:3: lv_array_6_0= RULE_LBRACKET
                    {
                    lv_array_6_0=(Token)match(input,RULE_LBRACKET,FOLLOW_RULE_LBRACKET_in_ruleComponentPrototype3906); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_array_6_0, grammarAccess.getComponentPrototypeAccess().getArrayLBRACKETTerminalRuleCall_5_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getComponentPrototypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"array",
                              		true, 
                              		"LBRACKET");
                      	    
                    }

                    }


                    }

                    this_RBRACKET_7=(Token)match(input,RULE_RBRACKET,FOLLOW_RULE_RBRACKET_in_ruleComponentPrototype3922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RBRACKET_7, grammarAccess.getComponentPrototypeAccess().getRBRACKETTerminalRuleCall_5_1()); 
                          
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
    // $ANTLR end "ruleComponentPrototype"


    // $ANTLR start "entryRuleFeatureGroupPrototype"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2097:1: entryRuleFeatureGroupPrototype returns [EObject current=null] : iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF ;
    public final EObject entryRuleFeatureGroupPrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureGroupPrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2098:2: (iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2099:2: iv_ruleFeatureGroupPrototype= ruleFeatureGroupPrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureGroupPrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureGroupPrototype_in_entryRuleFeatureGroupPrototype3958);
            iv_ruleFeatureGroupPrototype=ruleFeatureGroupPrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureGroupPrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureGroupPrototype3968); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2106:1: ruleFeatureGroupPrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 otherlv_5= KEYWORD_20 ( ( ruleQCREF ) )? ) ;
    public final EObject ruleFeatureGroupPrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2109:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 otherlv_5= KEYWORD_20 ( ( ruleQCREF ) )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2110:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 otherlv_5= KEYWORD_20 ( ( ruleQCREF ) )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2110:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 otherlv_5= KEYWORD_20 ( ( ruleQCREF ) )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2110:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 otherlv_5= KEYWORD_20 ( ( ruleQCREF ) )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2110:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2111:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2111:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2112:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureGroupPrototype4010); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFeatureGroupPrototype4026); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFeatureGroupPrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2132:1: (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==KEYWORD_37) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2133:2: otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4
                    {
                    otherlv_2=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleFeatureGroupPrototype4039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getFeatureGroupPrototypeAccess().getRefinedKeyword_2_0());
                          
                    }
                    otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleFeatureGroupPrototype4051); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFeatureGroupPrototypeAccess().getToKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleFeatureGroupPrototype4065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFeatureGroupPrototypeAccess().getFeatureKeyword_3());
                  
            }
            otherlv_5=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleFeatureGroupPrototype4077); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getFeatureGroupPrototypeAccess().getGroupKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2152:1: ( ( ruleQCREF ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2153:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2153:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2154:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeatureGroupPrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureGroupPrototypeAccess().getConstrainingFeatureGroupTypeFeatureGroupTypeCrossReference_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleFeatureGroupPrototype4099);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2175:1: entryRuleFeaturePrototype returns [EObject current=null] : iv_ruleFeaturePrototype= ruleFeaturePrototype EOF ;
    public final EObject entryRuleFeaturePrototype() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeaturePrototype = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2176:2: (iv_ruleFeaturePrototype= ruleFeaturePrototype EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2177:2: iv_ruleFeaturePrototype= ruleFeaturePrototype EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeaturePrototypeRule()); 
            }
            pushFollow(FOLLOW_ruleFeaturePrototype_in_entryRuleFeaturePrototype4135);
            iv_ruleFeaturePrototype=ruleFeaturePrototype();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeaturePrototype; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeaturePrototype4145); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2184:1: ruleFeaturePrototype returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 ( (lv_direction_5_0= ruleInOutDirection ) )? ( ( ruleQCREF ) )? ) ;
    public final EObject ruleFeaturePrototype() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_direction_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2187:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 ( (lv_direction_5_0= ruleInOutDirection ) )? ( ( ruleQCREF ) )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2188:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 ( (lv_direction_5_0= ruleInOutDirection ) )? ( ( ruleQCREF ) )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2188:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 ( (lv_direction_5_0= ruleInOutDirection ) )? ( ( ruleQCREF ) )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2188:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )? otherlv_4= KEYWORD_31 ( (lv_direction_5_0= ruleInOutDirection ) )? ( ( ruleQCREF ) )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2188:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2189:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2189:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2190:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeaturePrototype4187); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFeaturePrototype4203); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFeaturePrototypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2210:1: (otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==KEYWORD_37) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2211:2: otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4
                    {
                    otherlv_2=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleFeaturePrototype4216); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getFeaturePrototypeAccess().getRefinedKeyword_2_0());
                          
                    }
                    otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleFeaturePrototype4228); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFeaturePrototypeAccess().getToKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleFeaturePrototype4242); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFeaturePrototypeAccess().getFeatureKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2225:1: ( (lv_direction_5_0= ruleInOutDirection ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==KEYWORD_9||LA73_0==KEYWORD_2) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2226:1: (lv_direction_5_0= ruleInOutDirection )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2226:1: (lv_direction_5_0= ruleInOutDirection )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2227:3: lv_direction_5_0= ruleInOutDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeaturePrototypeAccess().getDirectionInOutDirectionParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleInOutDirection_in_ruleFeaturePrototype4262);
                    lv_direction_5_0=ruleInOutDirection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeaturePrototypeRule());
                      	        }
                             		set(
                             			current, 
                             			"direction",
                              		lv_direction_5_0, 
                              		"InOutDirection");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2243:3: ( ( ruleQCREF ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2244:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2244:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2245:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeaturePrototypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeaturePrototypeAccess().getConstrainingClassifierComponentClassifierCrossReference_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleFeaturePrototype4286);
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


    // $ANTLR start "entryRuleSystemSubcomponent"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2266:1: entryRuleSystemSubcomponent returns [EObject current=null] : iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF ;
    public final EObject entryRuleSystemSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2267:2: (iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2268:2: iv_ruleSystemSubcomponent= ruleSystemSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSystemSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleSystemSubcomponent_in_entryRuleSystemSubcomponent4322);
            iv_ruleSystemSubcomponent=ruleSystemSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSystemSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemSubcomponent4332); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2275:1: ruleSystemSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_27 ( ( ruleQCREF ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI ) ;
    public final EObject ruleSystemSubcomponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_LCURLY_4=null;
        Token this_RCURLY_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token this_LPARENS_9=null;
        Token lv_allModes_11_0=null;
        Token this_RPARENS_12=null;
        Token this_SEMI_13=null;
        EObject lv_ownedPropertyAssociation_5_0 = null;

        EObject lv_modeBinding_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2278:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_27 ( ( ruleQCREF ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2279:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_27 ( ( ruleQCREF ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2279:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_27 ( ( ruleQCREF ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2279:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_27 ( ( ruleQCREF ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2279:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2280:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2280:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2281:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemSubcomponent4374); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleSystemSubcomponent4390); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getSystemSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleSystemSubcomponent4402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSystemSubcomponentAccess().getSystemKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2306:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2307:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2307:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2308:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSystemSubcomponentRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getSystemClassifierSystemClassifierCrossReference_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQCREF_in_ruleSystemSubcomponent4424);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2321:2: ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_LCURLY) && (synpred23_InternalAadl2Parser())) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2321:3: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2321:3: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2321:4: ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY
                    {
                    this_LCURLY_4=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleSystemSubcomponent4441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_4, grammarAccess.getSystemSubcomponentAccess().getLCURLYTerminalRuleCall_4_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2325:2: ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+
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
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2326:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2326:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2327:3: lv_ownedPropertyAssociation_5_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleSystemSubcomponent4462);
                    	    lv_ownedPropertyAssociation_5_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSystemSubcomponentRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_5_0, 
                    	              		"PropertyAssociation");
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

                    this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleSystemSubcomponent4474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_6, grammarAccess.getSystemSubcomponentAccess().getRCURLYTerminalRuleCall_4_2()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2347:3: ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==KEYWORD_2) && (synpred24_InternalAadl2Parser())) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2347:4: ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2347:4: ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2347:5: ( KEYWORD_2 )=>otherlv_7= KEYWORD_2
                    {
                    otherlv_7=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleSystemSubcomponent4496); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSystemSubcomponentAccess().getInKeyword_5_0());
                          
                    }

                    }

                    otherlv_8=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleSystemSubcomponent4509); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSystemSubcomponentAccess().getModesKeyword_5_1());
                          
                    }
                    this_LPARENS_9=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleSystemSubcomponent4519); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_9, grammarAccess.getSystemSubcomponentAccess().getLPARENSTerminalRuleCall_5_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2363:1: ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) )
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==RULE_ID) ) {
                        alt78=1;
                    }
                    else if ( (LA78_0==KEYWORD_6) ) {
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
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2363:2: ( (lv_modeBinding_10_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2363:2: ( (lv_modeBinding_10_0= ruleModeRef ) )+
                            int cnt77=0;
                            loop77:
                            do {
                                int alt77=2;
                                int LA77_0 = input.LA(1);

                                if ( (LA77_0==RULE_ID) ) {
                                    alt77=1;
                                }


                                switch (alt77) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2364:1: (lv_modeBinding_10_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2364:1: (lv_modeBinding_10_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2365:3: lv_modeBinding_10_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getSystemSubcomponentAccess().getModeBindingModeRefParserRuleCall_5_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleSystemSubcomponent4540);
                            	    lv_modeBinding_10_0=ruleModeRef();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getSystemSubcomponentRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"modeBinding",
                            	              		lv_modeBinding_10_0, 
                            	              		"ModeRef");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt77 >= 1 ) break loop77;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(77, input);
                                        throw eee;
                                }
                                cnt77++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2382:6: ( (lv_allModes_11_0= KEYWORD_6 ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2382:6: ( (lv_allModes_11_0= KEYWORD_6 ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2383:1: (lv_allModes_11_0= KEYWORD_6 )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2383:1: (lv_allModes_11_0= KEYWORD_6 )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2384:3: lv_allModes_11_0= KEYWORD_6
                            {
                            lv_allModes_11_0=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleSystemSubcomponent4566); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_allModes_11_0, grammarAccess.getSystemSubcomponentAccess().getAllModesAllKeyword_5_3_1_0());
                                  
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

                    this_RPARENS_12=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleSystemSubcomponent4589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_12, grammarAccess.getSystemSubcomponentAccess().getRPARENSTerminalRuleCall_5_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_13=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleSystemSubcomponent4601); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_13, grammarAccess.getSystemSubcomponentAccess().getSEMITerminalRuleCall_6()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2414:1: entryRuleProcessorSubcomponent returns [EObject current=null] : iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF ;
    public final EObject entryRuleProcessorSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessorSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2415:2: (iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2416:2: iv_ruleProcessorSubcomponent= ruleProcessorSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessorSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleProcessorSubcomponent_in_entryRuleProcessorSubcomponent4635);
            iv_ruleProcessorSubcomponent=ruleProcessorSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessorSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProcessorSubcomponent4645); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2423:1: ruleProcessorSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_44 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI ) ;
    public final EObject ruleProcessorSubcomponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_LCURLY_4=null;
        Token this_RCURLY_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token this_LPARENS_9=null;
        Token lv_allModes_11_0=null;
        Token this_RPARENS_12=null;
        Token this_SEMI_13=null;
        EObject lv_ownedPropertyAssociation_5_0 = null;

        EObject lv_modeBinding_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2426:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_44 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2427:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_44 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2427:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_44 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2427:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_44 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2427:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2428:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2428:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2429:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProcessorSubcomponent4687); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleProcessorSubcomponent4703); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getProcessorSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleProcessorSubcomponent4715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProcessorSubcomponentAccess().getProcessorKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2454:1: ( ( ruleQCREF ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2455:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2455:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2456:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getProcessorSubcomponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getProcessorClassifierProcessorClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleProcessorSubcomponent4737);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2469:3: ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_LCURLY) && (synpred25_InternalAadl2Parser())) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2469:4: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2469:4: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2469:5: ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY
                    {
                    this_LCURLY_4=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleProcessorSubcomponent4755); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_4, grammarAccess.getProcessorSubcomponentAccess().getLCURLYTerminalRuleCall_4_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2473:2: ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+
                    int cnt81=0;
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==RULE_ID) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2474:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2474:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2475:3: lv_ownedPropertyAssociation_5_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleProcessorSubcomponent4776);
                    	    lv_ownedPropertyAssociation_5_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getProcessorSubcomponentRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_5_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt81 >= 1 ) break loop81;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(81, input);
                                throw eee;
                        }
                        cnt81++;
                    } while (true);

                    this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleProcessorSubcomponent4788); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_6, grammarAccess.getProcessorSubcomponentAccess().getRCURLYTerminalRuleCall_4_2()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2495:3: ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==KEYWORD_2) && (synpred26_InternalAadl2Parser())) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2495:4: ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2495:4: ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2495:5: ( KEYWORD_2 )=>otherlv_7= KEYWORD_2
                    {
                    otherlv_7=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleProcessorSubcomponent4810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getProcessorSubcomponentAccess().getInKeyword_5_0());
                          
                    }

                    }

                    otherlv_8=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleProcessorSubcomponent4823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getProcessorSubcomponentAccess().getModesKeyword_5_1());
                          
                    }
                    this_LPARENS_9=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleProcessorSubcomponent4833); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_9, grammarAccess.getProcessorSubcomponentAccess().getLPARENSTerminalRuleCall_5_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2511:1: ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) )
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==RULE_ID) ) {
                        alt84=1;
                    }
                    else if ( (LA84_0==KEYWORD_6) ) {
                        alt84=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 84, 0, input);

                        throw nvae;
                    }
                    switch (alt84) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2511:2: ( (lv_modeBinding_10_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2511:2: ( (lv_modeBinding_10_0= ruleModeRef ) )+
                            int cnt83=0;
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==RULE_ID) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2512:1: (lv_modeBinding_10_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2512:1: (lv_modeBinding_10_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2513:3: lv_modeBinding_10_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getProcessorSubcomponentAccess().getModeBindingModeRefParserRuleCall_5_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleProcessorSubcomponent4854);
                            	    lv_modeBinding_10_0=ruleModeRef();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getProcessorSubcomponentRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"modeBinding",
                            	              		lv_modeBinding_10_0, 
                            	              		"ModeRef");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt83 >= 1 ) break loop83;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(83, input);
                                        throw eee;
                                }
                                cnt83++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2530:6: ( (lv_allModes_11_0= KEYWORD_6 ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2530:6: ( (lv_allModes_11_0= KEYWORD_6 ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2531:1: (lv_allModes_11_0= KEYWORD_6 )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2531:1: (lv_allModes_11_0= KEYWORD_6 )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2532:3: lv_allModes_11_0= KEYWORD_6
                            {
                            lv_allModes_11_0=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleProcessorSubcomponent4880); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_allModes_11_0, grammarAccess.getProcessorSubcomponentAccess().getAllModesAllKeyword_5_3_1_0());
                                  
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

                    this_RPARENS_12=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleProcessorSubcomponent4903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_12, grammarAccess.getProcessorSubcomponentAccess().getRPARENSTerminalRuleCall_5_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_13=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleProcessorSubcomponent4915); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_13, grammarAccess.getProcessorSubcomponentAccess().getSEMITerminalRuleCall_6()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2562:1: entryRuleDataSubcomponent returns [EObject current=null] : iv_ruleDataSubcomponent= ruleDataSubcomponent EOF ;
    public final EObject entryRuleDataSubcomponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataSubcomponent = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2563:2: (iv_ruleDataSubcomponent= ruleDataSubcomponent EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2564:2: iv_ruleDataSubcomponent= ruleDataSubcomponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataSubcomponentRule()); 
            }
            pushFollow(FOLLOW_ruleDataSubcomponent_in_entryRuleDataSubcomponent4949);
            iv_ruleDataSubcomponent=ruleDataSubcomponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataSubcomponent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataSubcomponent4959); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2571:1: ruleDataSubcomponent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_10 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI ) ;
    public final EObject ruleDataSubcomponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_LCURLY_4=null;
        Token this_RCURLY_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token this_LPARENS_9=null;
        Token lv_allModes_11_0=null;
        Token this_RPARENS_12=null;
        Token this_SEMI_13=null;
        EObject lv_ownedPropertyAssociation_5_0 = null;

        EObject lv_modeBinding_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2574:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_10 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2575:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_10 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2575:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_10 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2575:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_10 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )? this_SEMI_13= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2575:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2576:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2576:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2577:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataSubcomponent5001); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleDataSubcomponent5017); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getDataSubcomponentAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleDataSubcomponent5029); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDataSubcomponentAccess().getDataKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2602:1: ( ( ruleQCREF ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_ID) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2603:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2603:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2604:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataSubcomponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getDataClassifierDataClassifierCrossReference_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleDataSubcomponent5051);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2617:3: ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_LCURLY) && (synpred27_InternalAadl2Parser())) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2617:4: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2617:4: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2617:5: ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY
                    {
                    this_LCURLY_4=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleDataSubcomponent5069); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_4, grammarAccess.getDataSubcomponentAccess().getLCURLYTerminalRuleCall_4_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2621:2: ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+
                    int cnt87=0;
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==RULE_ID) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2622:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2622:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2623:3: lv_ownedPropertyAssociation_5_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleDataSubcomponent5090);
                    	    lv_ownedPropertyAssociation_5_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDataSubcomponentRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_5_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt87 >= 1 ) break loop87;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(87, input);
                                throw eee;
                        }
                        cnt87++;
                    } while (true);

                    this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleDataSubcomponent5102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_6, grammarAccess.getDataSubcomponentAccess().getRCURLYTerminalRuleCall_4_2()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2643:3: ( ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==KEYWORD_2) && (synpred28_InternalAadl2Parser())) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2643:4: ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 ) otherlv_8= KEYWORD_21 this_LPARENS_9= RULE_LPARENS ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) ) this_RPARENS_12= RULE_RPARENS
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2643:4: ( ( KEYWORD_2 )=>otherlv_7= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2643:5: ( KEYWORD_2 )=>otherlv_7= KEYWORD_2
                    {
                    otherlv_7=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleDataSubcomponent5124); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDataSubcomponentAccess().getInKeyword_5_0());
                          
                    }

                    }

                    otherlv_8=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleDataSubcomponent5137); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDataSubcomponentAccess().getModesKeyword_5_1());
                          
                    }
                    this_LPARENS_9=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleDataSubcomponent5147); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_9, grammarAccess.getDataSubcomponentAccess().getLPARENSTerminalRuleCall_5_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2659:1: ( ( (lv_modeBinding_10_0= ruleModeRef ) )+ | ( (lv_allModes_11_0= KEYWORD_6 ) ) )
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==RULE_ID) ) {
                        alt90=1;
                    }
                    else if ( (LA90_0==KEYWORD_6) ) {
                        alt90=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 90, 0, input);

                        throw nvae;
                    }
                    switch (alt90) {
                        case 1 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2659:2: ( (lv_modeBinding_10_0= ruleModeRef ) )+
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2659:2: ( (lv_modeBinding_10_0= ruleModeRef ) )+
                            int cnt89=0;
                            loop89:
                            do {
                                int alt89=2;
                                int LA89_0 = input.LA(1);

                                if ( (LA89_0==RULE_ID) ) {
                                    alt89=1;
                                }


                                switch (alt89) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2660:1: (lv_modeBinding_10_0= ruleModeRef )
                            	    {
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2660:1: (lv_modeBinding_10_0= ruleModeRef )
                            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2661:3: lv_modeBinding_10_0= ruleModeRef
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getDataSubcomponentAccess().getModeBindingModeRefParserRuleCall_5_3_0_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleModeRef_in_ruleDataSubcomponent5168);
                            	    lv_modeBinding_10_0=ruleModeRef();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getDataSubcomponentRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"modeBinding",
                            	              		lv_modeBinding_10_0, 
                            	              		"ModeRef");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt89 >= 1 ) break loop89;
                            	    if (state.backtracking>0) {state.failed=true; return current;}
                                        EarlyExitException eee =
                                            new EarlyExitException(89, input);
                                        throw eee;
                                }
                                cnt89++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2678:6: ( (lv_allModes_11_0= KEYWORD_6 ) )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2678:6: ( (lv_allModes_11_0= KEYWORD_6 ) )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2679:1: (lv_allModes_11_0= KEYWORD_6 )
                            {
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2679:1: (lv_allModes_11_0= KEYWORD_6 )
                            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2680:3: lv_allModes_11_0= KEYWORD_6
                            {
                            lv_allModes_11_0=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleDataSubcomponent5194); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_allModes_11_0, grammarAccess.getDataSubcomponentAccess().getAllModesAllKeyword_5_3_1_0());
                                  
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

                    this_RPARENS_12=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleDataSubcomponent5217); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_12, grammarAccess.getDataSubcomponentAccess().getRPARENSTerminalRuleCall_5_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_13=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataSubcomponent5229); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_13, grammarAccess.getDataSubcomponentAccess().getSEMITerminalRuleCall_6()); 
                  
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


    // $ANTLR start "entryRuleDataPort"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2710:1: entryRuleDataPort returns [EObject current=null] : iv_ruleDataPort= ruleDataPort EOF ;
    public final EObject entryRuleDataPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2711:2: (iv_ruleDataPort= ruleDataPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2712:2: iv_ruleDataPort= ruleDataPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataPortRule()); 
            }
            pushFollow(FOLLOW_ruleDataPort_in_entryRuleDataPort5263);
            iv_ruleDataPort=ruleDataPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataPort5273); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2719:1: ruleDataPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_10 otherlv_4= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? this_SEMI_9= RULE_SEMI ) ;
    public final EObject ruleDataPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_LCURLY_6=null;
        Token this_RCURLY_8=null;
        Token this_SEMI_9=null;
        AntlrDatatypeRuleToken lv_direction_2_0 = null;

        EObject lv_ownedPropertyAssociation_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2722:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_10 otherlv_4= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? this_SEMI_9= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2723:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_10 otherlv_4= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? this_SEMI_9= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2723:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_10 otherlv_4= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? this_SEMI_9= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2723:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_10 otherlv_4= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? this_SEMI_9= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2723:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2724:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2724:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2725:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDataPort5315); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleDataPort5331); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getDataPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2745:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2746:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2746:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2747:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDataPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleDataPort5351);
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

            otherlv_3=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleDataPort5364); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDataPortAccess().getDataKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleDataPort5376); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getDataPortAccess().getPortKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2773:1: ( ( ruleQCREF ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_ID) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2774:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2774:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2775:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDataPortRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDataPortAccess().getDataClassifierDataTypeCrossReference_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleDataPort5398);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2788:3: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_LCURLY) && (synpred29_InternalAadl2Parser())) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2788:4: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2788:4: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2788:5: ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY
                    {
                    this_LCURLY_6=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleDataPort5416); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_6, grammarAccess.getDataPortAccess().getLCURLYTerminalRuleCall_6_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2792:2: ( (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation ) )+
                    int cnt93=0;
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==RULE_ID) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2793:1: (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2793:1: (lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2794:3: lv_ownedPropertyAssociation_7_0= ruleContainedPropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDataPortAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleDataPort5437);
                    	    lv_ownedPropertyAssociation_7_0=ruleContainedPropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDataPortRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_7_0, 
                    	              		"ContainedPropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt93 >= 1 ) break loop93;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(93, input);
                                throw eee;
                        }
                        cnt93++;
                    } while (true);

                    this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleDataPort5449); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_8, grammarAccess.getDataPortAccess().getRCURLYTerminalRuleCall_6_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_9=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDataPort5461); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_9, grammarAccess.getDataPortAccess().getSEMITerminalRuleCall_7()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2826:1: entryRuleEventDataPort returns [EObject current=null] : iv_ruleEventDataPort= ruleEventDataPort EOF ;
    public final EObject entryRuleEventDataPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDataPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2827:2: (iv_ruleEventDataPort= ruleEventDataPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2828:2: iv_ruleEventDataPort= ruleEventDataPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDataPortRule()); 
            }
            pushFollow(FOLLOW_ruleEventDataPort_in_entryRuleEventDataPort5495);
            iv_ruleEventDataPort=ruleEventDataPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDataPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventDataPort5505); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2835:1: ruleEventDataPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_10 otherlv_5= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY )? this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleEventDataPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_LCURLY_7=null;
        Token this_RCURLY_9=null;
        Token this_SEMI_10=null;
        AntlrDatatypeRuleToken lv_direction_2_0 = null;

        EObject lv_ownedPropertyAssociation_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2838:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_10 otherlv_5= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2839:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_10 otherlv_5= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2839:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_10 otherlv_5= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2839:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_10 otherlv_5= KEYWORD_14 ( ( ruleQCREF ) )? ( ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2839:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2840:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2840:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2841:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventDataPort5547); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleEventDataPort5563); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getEventDataPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2861:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2862:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2862:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2863:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventDataPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleEventDataPort5583);
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

            otherlv_3=(Token)match(input,KEYWORD_18,FOLLOW_KEYWORD_18_in_ruleEventDataPort5596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEventDataPortAccess().getEventKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleEventDataPort5608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventDataPortAccess().getDataKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleEventDataPort5620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEventDataPortAccess().getPortKeyword_5());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2894:1: ( ( ruleQCREF ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_ID) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2895:1: ( ruleQCREF )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2895:1: ( ruleQCREF )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2896:3: ruleQCREF
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getEventDataPortRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEventDataPortAccess().getDataClassifierDataTypeCrossReference_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCREF_in_ruleEventDataPort5642);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2909:3: ( ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_LCURLY) && (synpred30_InternalAadl2Parser())) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2909:4: ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_9= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2909:4: ( ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2909:5: ( RULE_LCURLY )=>this_LCURLY_7= RULE_LCURLY
                    {
                    this_LCURLY_7=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleEventDataPort5660); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_7, grammarAccess.getEventDataPortAccess().getLCURLYTerminalRuleCall_7_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2913:2: ( (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation ) )+
                    int cnt96=0;
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==RULE_ID) ) {
                            alt96=1;
                        }


                        switch (alt96) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2914:1: (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2914:1: (lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2915:3: lv_ownedPropertyAssociation_8_0= ruleContainedPropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEventDataPortAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_7_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleEventDataPort5681);
                    	    lv_ownedPropertyAssociation_8_0=ruleContainedPropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEventDataPortRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_8_0, 
                    	              		"ContainedPropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt96 >= 1 ) break loop96;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(96, input);
                                throw eee;
                        }
                        cnt96++;
                    } while (true);

                    this_RCURLY_9=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleEventDataPort5693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_9, grammarAccess.getEventDataPortAccess().getRCURLYTerminalRuleCall_7_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEventDataPort5705); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getEventDataPortAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2947:1: entryRuleEventPort returns [EObject current=null] : iv_ruleEventPort= ruleEventPort EOF ;
    public final EObject entryRuleEventPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2948:2: (iv_ruleEventPort= ruleEventPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2949:2: iv_ruleEventPort= ruleEventPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventPortRule()); 
            }
            pushFollow(FOLLOW_ruleEventPort_in_entryRuleEventPort5739);
            iv_ruleEventPort=ruleEventPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventPort5749); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2956:1: ruleEventPort returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_14 ( ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY )? this_SEMI_8= RULE_SEMI ) ;
    public final EObject ruleEventPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_LCURLY_5=null;
        Token this_RCURLY_7=null;
        Token this_SEMI_8=null;
        AntlrDatatypeRuleToken lv_direction_2_0 = null;

        EObject lv_ownedPropertyAssociation_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2959:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_14 ( ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY )? this_SEMI_8= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2960:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_14 ( ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY )? this_SEMI_8= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2960:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_14 ( ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY )? this_SEMI_8= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2960:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_direction_2_0= rulePortDirection ) ) otherlv_3= KEYWORD_18 otherlv_4= KEYWORD_14 ( ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY )? this_SEMI_8= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2960:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2961:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2961:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2962:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEventPort5791); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleEventPort5807); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getEventPortAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2982:1: ( (lv_direction_2_0= rulePortDirection ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2983:1: (lv_direction_2_0= rulePortDirection )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2983:1: (lv_direction_2_0= rulePortDirection )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2984:3: lv_direction_2_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventPortAccess().getDirectionPortDirectionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortDirection_in_ruleEventPort5827);
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

            otherlv_3=(Token)match(input,KEYWORD_18,FOLLOW_KEYWORD_18_in_ruleEventPort5840); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEventPortAccess().getEventKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleEventPort5852); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEventPortAccess().getPortKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3010:1: ( ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_LCURLY) && (synpred31_InternalAadl2Parser())) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3010:2: ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+ this_RCURLY_7= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3010:2: ( ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3010:3: ( RULE_LCURLY )=>this_LCURLY_5= RULE_LCURLY
                    {
                    this_LCURLY_5=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleEventPort5868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_5, grammarAccess.getEventPortAccess().getLCURLYTerminalRuleCall_5_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3014:2: ( (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation ) )+
                    int cnt98=0;
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==RULE_ID) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3015:1: (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3015:1: (lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3016:3: lv_ownedPropertyAssociation_6_0= ruleContainedPropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEventPortAccess().getOwnedPropertyAssociationContainedPropertyAssociationParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_ruleEventPort5889);
                    	    lv_ownedPropertyAssociation_6_0=ruleContainedPropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEventPortRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_6_0, 
                    	              		"ContainedPropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt98 >= 1 ) break loop98;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(98, input);
                                throw eee;
                        }
                        cnt98++;
                    } while (true);

                    this_RCURLY_7=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleEventPort5901); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_7, grammarAccess.getEventPortAccess().getRCURLYTerminalRuleCall_5_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_8=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEventPort5913); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_8, grammarAccess.getEventPortAccess().getSEMITerminalRuleCall_6()); 
                  
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


    // $ANTLR start "entryRulePortDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3062:1: entryRulePortDirection returns [String current=null] : iv_rulePortDirection= rulePortDirection EOF ;
    public final String entryRulePortDirection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePortDirection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3063:1: (iv_rulePortDirection= rulePortDirection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3064:2: iv_rulePortDirection= rulePortDirection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortDirectionRule()); 
            }
            pushFollow(FOLLOW_rulePortDirection_in_entryRulePortDirection5962);
            iv_rulePortDirection=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortDirection.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortDirection5973); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3071:1: rulePortDirection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_2 | kw= KEYWORD_9 | (kw= KEYWORD_2 kw= KEYWORD_9 ) ) ;
    public final AntlrDatatypeRuleToken rulePortDirection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3075:6: ( (kw= KEYWORD_2 | kw= KEYWORD_9 | (kw= KEYWORD_2 kw= KEYWORD_9 ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3076:1: (kw= KEYWORD_2 | kw= KEYWORD_9 | (kw= KEYWORD_2 kw= KEYWORD_9 ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3076:1: (kw= KEYWORD_2 | kw= KEYWORD_9 | (kw= KEYWORD_2 kw= KEYWORD_9 ) )
            int alt100=3;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==KEYWORD_2) ) {
                int LA100_1 = input.LA(2);

                if ( (LA100_1==EOF||LA100_1==KEYWORD_18||LA100_1==KEYWORD_10) ) {
                    alt100=1;
                }
                else if ( (LA100_1==KEYWORD_9) ) {
                    alt100=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA100_0==KEYWORD_9) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3077:2: kw= KEYWORD_2
                    {
                    kw=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rulePortDirection6011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getInKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3084:2: kw= KEYWORD_9
                    {
                    kw=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_rulePortDirection6030); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getOutKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3090:6: (kw= KEYWORD_2 kw= KEYWORD_9 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3090:6: (kw= KEYWORD_2 kw= KEYWORD_9 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3091:2: kw= KEYWORD_2 kw= KEYWORD_9
                    {
                    kw=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_rulePortDirection6050); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPortDirectionAccess().getInKeyword_2_0()); 
                          
                    }
                    kw=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_rulePortDirection6063); if (state.failed) return current;
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


    // $ANTLR start "entryRuleInOutDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3110:1: entryRuleInOutDirection returns [String current=null] : iv_ruleInOutDirection= ruleInOutDirection EOF ;
    public final String entryRuleInOutDirection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInOutDirection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3111:1: (iv_ruleInOutDirection= ruleInOutDirection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3112:2: iv_ruleInOutDirection= ruleInOutDirection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInOutDirectionRule()); 
            }
            pushFollow(FOLLOW_ruleInOutDirection_in_entryRuleInOutDirection6104);
            iv_ruleInOutDirection=ruleInOutDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInOutDirection.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInOutDirection6115); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInOutDirection"


    // $ANTLR start "ruleInOutDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3119:1: ruleInOutDirection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_2 | kw= KEYWORD_9 ) ;
    public final AntlrDatatypeRuleToken ruleInOutDirection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3123:6: ( (kw= KEYWORD_2 | kw= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3124:1: (kw= KEYWORD_2 | kw= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3124:1: (kw= KEYWORD_2 | kw= KEYWORD_9 )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==KEYWORD_2) ) {
                alt101=1;
            }
            else if ( (LA101_0==KEYWORD_9) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3125:2: kw= KEYWORD_2
                    {
                    kw=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleInOutDirection6153); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getInOutDirectionAccess().getInKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3132:2: kw= KEYWORD_9
                    {
                    kw=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleInOutDirection6172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getInOutDirectionAccess().getOutKeyword_1()); 
                          
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
    // $ANTLR end "ruleInOutDirection"


    // $ANTLR start "entryRuleAccessDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3145:1: entryRuleAccessDirection returns [String current=null] : iv_ruleAccessDirection= ruleAccessDirection EOF ;
    public final String entryRuleAccessDirection() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAccessDirection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3146:1: (iv_ruleAccessDirection= ruleAccessDirection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3147:2: iv_ruleAccessDirection= ruleAccessDirection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessDirectionRule()); 
            }
            pushFollow(FOLLOW_ruleAccessDirection_in_entryRuleAccessDirection6212);
            iv_ruleAccessDirection=ruleAccessDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessDirection.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessDirection6223); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessDirection"


    // $ANTLR start "ruleAccessDirection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3154:1: ruleAccessDirection returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_42 | kw= KEYWORD_41 ) ;
    public final AntlrDatatypeRuleToken ruleAccessDirection() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3158:6: ( (kw= KEYWORD_42 | kw= KEYWORD_41 ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3159:1: (kw= KEYWORD_42 | kw= KEYWORD_41 )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3159:1: (kw= KEYWORD_42 | kw= KEYWORD_41 )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==KEYWORD_42) ) {
                alt102=1;
            }
            else if ( (LA102_0==KEYWORD_41) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3160:2: kw= KEYWORD_42
                    {
                    kw=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_ruleAccessDirection6261); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessDirectionAccess().getRequiresKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3167:2: kw= KEYWORD_41
                    {
                    kw=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_ruleAccessDirection6280); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessDirectionAccess().getProvidesKeyword_1()); 
                          
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
    // $ANTLR end "ruleAccessDirection"


    // $ANTLR start "entryRulePortConnection"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3182:1: entryRulePortConnection returns [EObject current=null] : iv_rulePortConnection= rulePortConnection EOF ;
    public final EObject entryRulePortConnection() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortConnection = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3183:2: (iv_rulePortConnection= rulePortConnection EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3184:2: iv_rulePortConnection= rulePortConnection EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortConnectionRule()); 
            }
            pushFollow(FOLLOW_rulePortConnection_in_entryRulePortConnection6321);
            iv_rulePortConnection=rulePortConnection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortConnection; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortConnection6331); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3191:1: rulePortConnection returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= rulePortConnectionKind ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (this_ARROW_6= RULE_ARROW | ( (lv_bidirectional_7_0= KEYWORD_5 ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI ) ;
    public final EObject rulePortConnection() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_3=null;
        Token this_DOT_4=null;
        Token otherlv_5=null;
        Token this_ARROW_6=null;
        Token lv_bidirectional_7_0=null;
        Token otherlv_8=null;
        Token this_DOT_9=null;
        Token otherlv_10=null;
        Token this_SEMI_11=null;
        AntlrDatatypeRuleToken lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3194:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= rulePortConnectionKind ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (this_ARROW_6= RULE_ARROW | ( (lv_bidirectional_7_0= KEYWORD_5 ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3195:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= rulePortConnectionKind ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (this_ARROW_6= RULE_ARROW | ( (lv_bidirectional_7_0= KEYWORD_5 ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3195:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= rulePortConnectionKind ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (this_ARROW_6= RULE_ARROW | ( (lv_bidirectional_7_0= KEYWORD_5 ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3195:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_kind_2_0= rulePortConnectionKind ) ) ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )? ( (otherlv_5= RULE_ID ) ) (this_ARROW_6= RULE_ARROW | ( (lv_bidirectional_7_0= KEYWORD_5 ) ) ) ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) this_SEMI_11= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3195:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3196:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3196:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3197:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6373); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rulePortConnection6389); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getPortConnectionAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3217:1: ( (lv_kind_2_0= rulePortConnectionKind ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3218:1: (lv_kind_2_0= rulePortConnectionKind )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3218:1: (lv_kind_2_0= rulePortConnectionKind )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3219:3: lv_kind_2_0= rulePortConnectionKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPortConnectionAccess().getKindPortConnectionKindParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePortConnectionKind_in_rulePortConnection6409);
            lv_kind_2_0=rulePortConnectionKind();

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
                      		"PortConnectionKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3235:2: ( ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_ID) ) {
                int LA103_1 = input.LA(2);

                if ( (LA103_1==RULE_DOT) ) {
                    alt103=1;
                }
            }
            switch (alt103) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3235:3: ( (otherlv_3= RULE_ID ) ) this_DOT_4= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3235:3: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3236:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3236:1: (otherlv_3= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3237:3: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                              
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6430); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_3, grammarAccess.getPortConnectionAccess().getSourceContextContextCrossReference_3_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_4=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rulePortConnection6441); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_4, grammarAccess.getPortConnectionAccess().getDOTTerminalRuleCall_3_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3252:3: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3253:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3253:1: (otherlv_5= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3254:3: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                      
            }
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6462); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_5, grammarAccess.getPortConnectionAccess().getSourceConnectionEndCrossReference_4_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3265:2: (this_ARROW_6= RULE_ARROW | ( (lv_bidirectional_7_0= KEYWORD_5 ) ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==RULE_ARROW) ) {
                alt104=1;
            }
            else if ( (LA104_0==KEYWORD_5) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3265:3: this_ARROW_6= RULE_ARROW
                    {
                    this_ARROW_6=(Token)match(input,RULE_ARROW,FOLLOW_RULE_ARROW_in_rulePortConnection6474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ARROW_6, grammarAccess.getPortConnectionAccess().getARROWTerminalRuleCall_5_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3270:6: ( (lv_bidirectional_7_0= KEYWORD_5 ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3270:6: ( (lv_bidirectional_7_0= KEYWORD_5 ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3271:1: (lv_bidirectional_7_0= KEYWORD_5 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3271:1: (lv_bidirectional_7_0= KEYWORD_5 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3272:3: lv_bidirectional_7_0= KEYWORD_5
                    {
                    lv_bidirectional_7_0=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_rulePortConnection6498); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3286:3: ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_ID) ) {
                int LA105_1 = input.LA(2);

                if ( (LA105_1==RULE_DOT) ) {
                    alt105=1;
                }
            }
            switch (alt105) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3286:4: ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3286:4: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3287:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3287:1: (otherlv_8= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3288:3: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPortConnectionRule());
                      	        }
                              
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_8, grammarAccess.getPortConnectionAccess().getDestinationContextContextCrossReference_6_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_9=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_rulePortConnection6542); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_9, grammarAccess.getPortConnectionAccess().getDOTTerminalRuleCall_6_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3303:3: ( (otherlv_10= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3304:1: (otherlv_10= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3304:1: (otherlv_10= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3305:3: otherlv_10= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPortConnectionRule());
              	        }
                      
            }
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortConnection6563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_10, grammarAccess.getPortConnectionAccess().getDestinationConnectionEndCrossReference_7_0()); 
              	
            }

            }


            }

            this_SEMI_11=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePortConnection6574); if (state.failed) return current;
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


    // $ANTLR start "entryRulePortConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3338:1: entryRulePortConnectionKind returns [String current=null] : iv_rulePortConnectionKind= rulePortConnectionKind EOF ;
    public final String entryRulePortConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePortConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3339:1: (iv_rulePortConnectionKind= rulePortConnectionKind EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3340:2: iv_rulePortConnectionKind= rulePortConnectionKind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortConnectionKindRule()); 
            }
            pushFollow(FOLLOW_rulePortConnectionKind_in_entryRulePortConnectionKind6619);
            iv_rulePortConnectionKind=rulePortConnectionKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortConnectionKind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePortConnectionKind6630); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortConnectionKind"


    // $ANTLR start "rulePortConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3347:1: rulePortConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_14 ;
    public final AntlrDatatypeRuleToken rulePortConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3351:6: (kw= KEYWORD_14 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3353:2: kw= KEYWORD_14
            {
            kw=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_rulePortConnectionKind6667); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getPortConnectionKindAccess().getPortKeyword()); 
                  
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
    // $ANTLR end "rulePortConnectionKind"


    // $ANTLR start "entryRuleAccessConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3366:1: entryRuleAccessConnectionKind returns [String current=null] : iv_ruleAccessConnectionKind= ruleAccessConnectionKind EOF ;
    public final String entryRuleAccessConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAccessConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3367:1: (iv_ruleAccessConnectionKind= ruleAccessConnectionKind EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3368:2: iv_ruleAccessConnectionKind= ruleAccessConnectionKind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessConnectionKindRule()); 
            }
            pushFollow(FOLLOW_ruleAccessConnectionKind_in_entryRuleAccessConnectionKind6706);
            iv_ruleAccessConnectionKind=ruleAccessConnectionKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessConnectionKind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessConnectionKind6717); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessConnectionKind"


    // $ANTLR start "ruleAccessConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3375:1: ruleAccessConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_22 ;
    public final AntlrDatatypeRuleToken ruleAccessConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3379:6: (kw= KEYWORD_22 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3381:2: kw= KEYWORD_22
            {
            kw=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleAccessConnectionKind6754); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAccessConnectionKindAccess().getAccessKeyword()); 
                  
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
    // $ANTLR end "ruleAccessConnectionKind"


    // $ANTLR start "entryRuleFeatureGroupConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3394:1: entryRuleFeatureGroupConnectionKind returns [String current=null] : iv_ruleFeatureGroupConnectionKind= ruleFeatureGroupConnectionKind EOF ;
    public final String entryRuleFeatureGroupConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureGroupConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3395:1: (iv_ruleFeatureGroupConnectionKind= ruleFeatureGroupConnectionKind EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3396:2: iv_ruleFeatureGroupConnectionKind= ruleFeatureGroupConnectionKind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureGroupConnectionKindRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureGroupConnectionKind_in_entryRuleFeatureGroupConnectionKind6793);
            iv_ruleFeatureGroupConnectionKind=ruleFeatureGroupConnectionKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureGroupConnectionKind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureGroupConnectionKind6804); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureGroupConnectionKind"


    // $ANTLR start "ruleFeatureGroupConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3403:1: ruleFeatureGroupConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_31 kw= KEYWORD_20 ) ;
    public final AntlrDatatypeRuleToken ruleFeatureGroupConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3407:6: ( (kw= KEYWORD_31 kw= KEYWORD_20 ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3408:1: (kw= KEYWORD_31 kw= KEYWORD_20 )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3408:1: (kw= KEYWORD_31 kw= KEYWORD_20 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3409:2: kw= KEYWORD_31 kw= KEYWORD_20
            {
            kw=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleFeatureGroupConnectionKind6842); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFeatureGroupConnectionKindAccess().getFeatureKeyword_0()); 
                  
            }
            kw=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleFeatureGroupConnectionKind6855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFeatureGroupConnectionKindAccess().getGroupKeyword_1()); 
                  
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
    // $ANTLR end "ruleFeatureGroupConnectionKind"


    // $ANTLR start "entryRuleFeatureConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3428:1: entryRuleFeatureConnectionKind returns [String current=null] : iv_ruleFeatureConnectionKind= ruleFeatureConnectionKind EOF ;
    public final String entryRuleFeatureConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3429:1: (iv_ruleFeatureConnectionKind= ruleFeatureConnectionKind EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3430:2: iv_ruleFeatureConnectionKind= ruleFeatureConnectionKind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureConnectionKindRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureConnectionKind_in_entryRuleFeatureConnectionKind6895);
            iv_ruleFeatureConnectionKind=ruleFeatureConnectionKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureConnectionKind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureConnectionKind6906); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureConnectionKind"


    // $ANTLR start "ruleFeatureConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3437:1: ruleFeatureConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_31 ;
    public final AntlrDatatypeRuleToken ruleFeatureConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3441:6: (kw= KEYWORD_31 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3443:2: kw= KEYWORD_31
            {
            kw=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleFeatureConnectionKind6943); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getFeatureConnectionKindAccess().getFeatureKeyword()); 
                  
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
    // $ANTLR end "ruleFeatureConnectionKind"


    // $ANTLR start "entryRuleParameterConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3456:1: entryRuleParameterConnectionKind returns [String current=null] : iv_ruleParameterConnectionKind= ruleParameterConnectionKind EOF ;
    public final String entryRuleParameterConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParameterConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3457:1: (iv_ruleParameterConnectionKind= ruleParameterConnectionKind EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3458:2: iv_ruleParameterConnectionKind= ruleParameterConnectionKind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterConnectionKindRule()); 
            }
            pushFollow(FOLLOW_ruleParameterConnectionKind_in_entryRuleParameterConnectionKind6982);
            iv_ruleParameterConnectionKind=ruleParameterConnectionKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterConnectionKind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterConnectionKind6993); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterConnectionKind"


    // $ANTLR start "ruleParameterConnectionKind"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3465:1: ruleParameterConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_43 ;
    public final AntlrDatatypeRuleToken ruleParameterConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3469:6: (kw= KEYWORD_43 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3471:2: kw= KEYWORD_43
            {
            kw=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleParameterConnectionKind7030); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getParameterConnectionKindAccess().getParameterKeyword()); 
                  
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
    // $ANTLR end "ruleParameterConnectionKind"


    // $ANTLR start "entryRuleAccessCategory"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3484:1: entryRuleAccessCategory returns [String current=null] : iv_ruleAccessCategory= ruleAccessCategory EOF ;
    public final String entryRuleAccessCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAccessCategory = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3485:1: (iv_ruleAccessCategory= ruleAccessCategory EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3486:2: iv_ruleAccessCategory= ruleAccessCategory EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccessCategoryRule()); 
            }
            pushFollow(FOLLOW_ruleAccessCategory_in_entryRuleAccessCategory7069);
            iv_ruleAccessCategory=ruleAccessCategory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccessCategory.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessCategory7080); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessCategory"


    // $ANTLR start "ruleAccessCategory"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3493:1: ruleAccessCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_47 | (kw= KEYWORD_47 kw= KEYWORD_20 ) ) ;
    public final AntlrDatatypeRuleToken ruleAccessCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3497:6: ( (kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_47 | (kw= KEYWORD_47 kw= KEYWORD_20 ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3498:1: (kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_47 | (kw= KEYWORD_47 kw= KEYWORD_20 ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3498:1: (kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_47 | (kw= KEYWORD_47 kw= KEYWORD_20 ) )
            int alt106=4;
            switch ( input.LA(1) ) {
            case KEYWORD_7:
                {
                alt106=1;
                }
                break;
            case KEYWORD_10:
                {
                alt106=2;
                }
                break;
            case KEYWORD_47:
                {
                int LA106_3 = input.LA(2);

                if ( (LA106_3==EOF) ) {
                    alt106=3;
                }
                else if ( (LA106_3==KEYWORD_20) ) {
                    alt106=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3499:2: kw= KEYWORD_7
                    {
                    kw=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleAccessCategory7118); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessCategoryAccess().getBusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3506:2: kw= KEYWORD_10
                    {
                    kw=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleAccessCategory7137); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessCategoryAccess().getDataKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3513:2: kw= KEYWORD_47
                    {
                    kw=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleAccessCategory7156); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessCategoryAccess().getSubprogramKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3519:6: (kw= KEYWORD_47 kw= KEYWORD_20 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3519:6: (kw= KEYWORD_47 kw= KEYWORD_20 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3520:2: kw= KEYWORD_47 kw= KEYWORD_20
                    {
                    kw=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleAccessCategory7176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessCategoryAccess().getSubprogramKeyword_3_0()); 
                          
                    }
                    kw=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleAccessCategory7189); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAccessCategoryAccess().getGroupKeyword_3_1()); 
                          
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
    // $ANTLR end "ruleAccessCategory"


    // $ANTLR start "entryRuleFlowSource"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3541:1: entryRuleFlowSource returns [String current=null] : iv_ruleFlowSource= ruleFlowSource EOF ;
    public final String entryRuleFlowSource() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlowSource = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3542:1: (iv_ruleFlowSource= ruleFlowSource EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3543:2: iv_ruleFlowSource= ruleFlowSource EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSourceRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSource_in_entryRuleFlowSource7232);
            iv_ruleFlowSource=ruleFlowSource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSource.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSource7243); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3550:1: ruleFlowSource returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_26 ;
    public final AntlrDatatypeRuleToken ruleFlowSource() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3554:6: (kw= KEYWORD_26 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3556:2: kw= KEYWORD_26
            {
            kw=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_ruleFlowSource7280); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3569:1: entryRuleFlowSink returns [String current=null] : iv_ruleFlowSink= ruleFlowSink EOF ;
    public final String entryRuleFlowSink() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlowSink = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3570:1: (iv_ruleFlowSink= ruleFlowSink EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3571:2: iv_ruleFlowSink= ruleFlowSink EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSinkRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSink_in_entryRuleFlowSink7319);
            iv_ruleFlowSink=ruleFlowSink();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSink.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSink7330); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3578:1: ruleFlowSink returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_15 ;
    public final AntlrDatatypeRuleToken ruleFlowSink() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3582:6: (kw= KEYWORD_15 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3584:2: kw= KEYWORD_15
            {
            kw=(Token)match(input,KEYWORD_15,FOLLOW_KEYWORD_15_in_ruleFlowSink7367); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3597:1: entryRuleFlowPath returns [String current=null] : iv_ruleFlowPath= ruleFlowPath EOF ;
    public final String entryRuleFlowPath() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlowPath = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3598:1: (iv_ruleFlowPath= ruleFlowPath EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3599:2: iv_ruleFlowPath= ruleFlowPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowPathRule()); 
            }
            pushFollow(FOLLOW_ruleFlowPath_in_entryRuleFlowPath7406);
            iv_ruleFlowPath=ruleFlowPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowPath.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowPath7417); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3606:1: ruleFlowPath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_13 ;
    public final AntlrDatatypeRuleToken ruleFlowPath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3610:6: (kw= KEYWORD_13 )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3612:2: kw= KEYWORD_13
            {
            kw=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleFlowPath7454); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3625:1: entryRuleFlowSpecification returns [EObject current=null] : iv_ruleFlowSpecification= ruleFlowSpecification EOF ;
    public final EObject entryRuleFlowSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecification = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3626:2: (iv_ruleFlowSpecification= ruleFlowSpecification EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3627:2: iv_ruleFlowSpecification= ruleFlowSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSpecification_in_entryRuleFlowSpecification7492);
            iv_ruleFlowSpecification=ruleFlowSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecification7502); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3634:1: ruleFlowSpecification returns [EObject current=null] : ( (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS )? this_SEMI_14= RULE_SEMI ) ;
    public final EObject ruleFlowSpecification() throws RecognitionException {
        EObject current = null;

        Token this_LCURLY_6=null;
        Token this_RCURLY_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token this_LPARENS_11=null;
        Token otherlv_12=null;
        Token this_RPARENS_13=null;
        Token this_SEMI_14=null;
        EObject this_FlowSourceSpec_0 = null;

        EObject this_FlowSinkSpec_1 = null;

        EObject this_FlowPathSpec_2 = null;

        EObject this_FlowSourceSpecRefinement_3 = null;

        EObject this_FlowSinkSpecRefinement_4 = null;

        EObject this_FlowPathSpecRefinement_5 = null;

        EObject lv_ownedPropertyAssociation_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3637:28: ( ( (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS )? this_SEMI_14= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3638:1: ( (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS )? this_SEMI_14= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3638:1: ( (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS )? this_SEMI_14= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3638:2: (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ( ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS )? this_SEMI_14= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3638:2: (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement )
            int alt107=6;
            alt107 = dfa107.predict(input);
            switch (alt107) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3639:5: this_FlowSourceSpec_0= ruleFlowSourceSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowSourceSpecParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowSourceSpec_in_ruleFlowSpecification7550);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3649:5: this_FlowSinkSpec_1= ruleFlowSinkSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowSinkSpecParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowSinkSpec_in_ruleFlowSpecification7577);
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
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3659:5: this_FlowPathSpec_2= ruleFlowPathSpec
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowPathSpecParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowPathSpec_in_ruleFlowSpecification7604);
                    this_FlowPathSpec_2=ruleFlowPathSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FlowPathSpec_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3669:5: this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowSourceSpecRefinementParserRuleCall_0_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowSourceSpecRefinement_in_ruleFlowSpecification7631);
                    this_FlowSourceSpecRefinement_3=ruleFlowSourceSpecRefinement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FlowSourceSpecRefinement_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3679:5: this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowSinkSpecRefinementParserRuleCall_0_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowSinkSpecRefinement_in_ruleFlowSpecification7658);
                    this_FlowSinkSpecRefinement_4=ruleFlowSinkSpecRefinement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FlowSinkSpecRefinement_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3689:5: this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFlowSpecificationAccess().getFlowPathSpecRefinementParserRuleCall_0_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFlowPathSpecRefinement_in_ruleFlowSpecification7685);
                    this_FlowPathSpecRefinement_5=ruleFlowPathSpecRefinement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_FlowPathSpecRefinement_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3697:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_LCURLY) && (synpred32_InternalAadl2Parser())) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3697:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3697:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3697:4: ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY
                    {
                    this_LCURLY_6=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleFlowSpecification7702); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_6, grammarAccess.getFlowSpecificationAccess().getLCURLYTerminalRuleCall_1_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3701:2: ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+
                    int cnt108=0;
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==RULE_ID) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3702:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3702:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3703:3: lv_ownedPropertyAssociation_7_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFlowSpecificationAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleFlowSpecification7723);
                    	    lv_ownedPropertyAssociation_7_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFlowSpecificationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_7_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt108 >= 1 ) break loop108;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(108, input);
                                throw eee;
                        }
                        cnt108++;
                    } while (true);

                    this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleFlowSpecification7735); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_8, grammarAccess.getFlowSpecificationAccess().getRCURLYTerminalRuleCall_1_2()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3723:3: ( ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==KEYWORD_2) && (synpred33_InternalAadl2Parser())) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3723:4: ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 ) otherlv_10= KEYWORD_21 this_LPARENS_11= RULE_LPARENS ( (otherlv_12= RULE_ID ) )+ this_RPARENS_13= RULE_RPARENS
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3723:4: ( ( KEYWORD_2 )=>otherlv_9= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3723:5: ( KEYWORD_2 )=>otherlv_9= KEYWORD_2
                    {
                    otherlv_9=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleFlowSpecification7757); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationAccess().getInKeyword_2_0());
                          
                    }

                    }

                    otherlv_10=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleFlowSpecification7770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationAccess().getModesKeyword_2_1());
                          
                    }
                    this_LPARENS_11=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleFlowSpecification7780); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_11, grammarAccess.getFlowSpecificationAccess().getLPARENSTerminalRuleCall_2_2()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3739:1: ( (otherlv_12= RULE_ID ) )+
                    int cnt110=0;
                    loop110:
                    do {
                        int alt110=2;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==RULE_ID) ) {
                            alt110=1;
                        }


                        switch (alt110) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3740:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3740:1: (otherlv_12= RULE_ID )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3741:3: otherlv_12= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFlowSpecificationRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecification7799); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_12, grammarAccess.getFlowSpecificationAccess().getInModeModeCrossReference_2_3_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt110 >= 1 ) break loop110;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(110, input);
                                throw eee;
                        }
                        cnt110++;
                    } while (true);

                    this_RPARENS_13=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleFlowSpecification7811); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_13, grammarAccess.getFlowSpecificationAccess().getRPARENSTerminalRuleCall_2_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_14=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFlowSpecification7823); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_14, grammarAccess.getFlowSpecificationAccess().getSEMITerminalRuleCall_3()); 
                  
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


    // $ANTLR start "entryRuleFlowSourceSpec"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3768:1: entryRuleFlowSourceSpec returns [EObject current=null] : iv_ruleFlowSourceSpec= ruleFlowSourceSpec EOF ;
    public final EObject entryRuleFlowSourceSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSourceSpec = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3769:2: (iv_ruleFlowSourceSpec= ruleFlowSourceSpec EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3770:2: iv_ruleFlowSourceSpec= ruleFlowSourceSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSourceSpecRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSourceSpec_in_entryRuleFlowSourceSpec7857);
            iv_ruleFlowSourceSpec=ruleFlowSourceSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSourceSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSourceSpec7867); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3777:1: ruleFlowSourceSpec returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleFlowSourceSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_DOT_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3780:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3781:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3781:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3781:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3781:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3782:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3782:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3783:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceSpec7909); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSourceSpec7925); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSourceSpecAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowSourceSpec7937); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSourceSpecAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3808:1: ( (lv_kind_3_0= ruleFlowSource ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3809:1: (lv_kind_3_0= ruleFlowSource )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3809:1: (lv_kind_3_0= ruleFlowSource )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3810:3: lv_kind_3_0= ruleFlowSource
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSourceSpecAccess().getKindFlowSourceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSource_in_ruleFlowSourceSpec7957);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3826:2: ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_ID) ) {
                int LA112_1 = input.LA(2);

                if ( (LA112_1==RULE_DOT) ) {
                    alt112=1;
                }
            }
            switch (alt112) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3826:3: ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3826:3: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3827:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3827:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3828:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowSourceSpecRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceSpec7978); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getFlowSourceSpecAccess().getOutContextContextCrossReference_4_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_5=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleFlowSourceSpec7989); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_5, grammarAccess.getFlowSourceSpecAccess().getDOTTerminalRuleCall_4_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3843:3: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3844:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3844:1: (otherlv_6= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3845:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSourceSpecRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceSpec8010); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getFlowSourceSpecAccess().getOutFeatureFeatureCrossReference_5_0()); 
              	
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3864:1: entryRuleFlowSinkSpec returns [EObject current=null] : iv_ruleFlowSinkSpec= ruleFlowSinkSpec EOF ;
    public final EObject entryRuleFlowSinkSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSinkSpec = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3865:2: (iv_ruleFlowSinkSpec= ruleFlowSinkSpec EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3866:2: iv_ruleFlowSinkSpec= ruleFlowSinkSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSinkSpecRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSinkSpec_in_entryRuleFlowSinkSpec8045);
            iv_ruleFlowSinkSpec=ruleFlowSinkSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSinkSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSinkSpec8055); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3873:1: ruleFlowSinkSpec returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleFlowSinkSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_DOT_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3876:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3877:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3877:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3877:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3877:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3878:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3878:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3879:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkSpec8097); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSinkSpec8113); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSinkSpecAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowSinkSpec8125); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSinkSpecAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3904:1: ( (lv_kind_3_0= ruleFlowSink ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3905:1: (lv_kind_3_0= ruleFlowSink )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3905:1: (lv_kind_3_0= ruleFlowSink )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3906:3: lv_kind_3_0= ruleFlowSink
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSinkSpecAccess().getKindFlowSinkParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSink_in_ruleFlowSinkSpec8145);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3922:2: ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==RULE_ID) ) {
                int LA113_1 = input.LA(2);

                if ( (LA113_1==RULE_DOT) ) {
                    alt113=1;
                }
            }
            switch (alt113) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3922:3: ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3922:3: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3923:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3923:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3924:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowSinkSpecRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkSpec8166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getFlowSinkSpecAccess().getInContextContextCrossReference_4_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_5=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleFlowSinkSpec8177); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_5, grammarAccess.getFlowSinkSpecAccess().getDOTTerminalRuleCall_4_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3939:3: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3940:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3940:1: (otherlv_6= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3941:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSinkSpecRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkSpec8198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getFlowSinkSpecAccess().getInFeatureFeatureCrossReference_5_0()); 
              	
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3960:1: entryRuleFlowPathSpec returns [EObject current=null] : iv_ruleFlowPathSpec= ruleFlowPathSpec EOF ;
    public final EObject entryRuleFlowPathSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowPathSpec = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3961:2: (iv_ruleFlowPathSpec= ruleFlowPathSpec EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3962:2: iv_ruleFlowPathSpec= ruleFlowPathSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowPathSpecRule()); 
            }
            pushFollow(FOLLOW_ruleFlowPathSpec_in_entryRuleFlowPathSpec8233);
            iv_ruleFlowPathSpec=ruleFlowPathSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowPathSpec; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowPathSpec8243); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3969:1: ruleFlowPathSpec returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) this_ARROW_7= RULE_ARROW ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) ) ;
    public final EObject ruleFlowPathSpec() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_DOT_5=null;
        Token otherlv_6=null;
        Token this_ARROW_7=null;
        Token otherlv_8=null;
        Token this_DOT_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3972:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) this_ARROW_7= RULE_ARROW ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3973:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) this_ARROW_7= RULE_ARROW ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3973:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) this_ARROW_7= RULE_ARROW ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3973:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )? ( (otherlv_6= RULE_ID ) ) this_ARROW_7= RULE_ARROW ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )? ( (otherlv_10= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3973:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3974:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3974:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3975:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec8285); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowPathSpec8301); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowPathSpecAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowPathSpec8313); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowPathSpecAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4000:1: ( (lv_kind_3_0= ruleFlowPath ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4001:1: (lv_kind_3_0= ruleFlowPath )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4001:1: (lv_kind_3_0= ruleFlowPath )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4002:3: lv_kind_3_0= ruleFlowPath
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowPathSpecAccess().getKindFlowPathParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowPath_in_ruleFlowPathSpec8333);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4018:2: ( ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==RULE_ID) ) {
                int LA114_1 = input.LA(2);

                if ( (LA114_1==RULE_DOT) ) {
                    alt114=1;
                }
            }
            switch (alt114) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4018:3: ( (otherlv_4= RULE_ID ) ) this_DOT_5= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4018:3: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4019:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4019:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4020:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec8354); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getFlowPathSpecAccess().getInContextContextCrossReference_4_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_5=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleFlowPathSpec8365); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_5, grammarAccess.getFlowPathSpecAccess().getDOTTerminalRuleCall_4_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4035:3: ( (otherlv_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4036:1: (otherlv_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4036:1: (otherlv_6= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4037:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec8386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getFlowPathSpecAccess().getInFeatureFeatureCrossReference_5_0()); 
              	
            }

            }


            }

            this_ARROW_7=(Token)match(input,RULE_ARROW,FOLLOW_RULE_ARROW_in_ruleFlowPathSpec8397); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ARROW_7, grammarAccess.getFlowPathSpecAccess().getARROWTerminalRuleCall_6()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4052:1: ( ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==RULE_ID) ) {
                int LA115_1 = input.LA(2);

                if ( (LA115_1==RULE_DOT) ) {
                    alt115=1;
                }
            }
            switch (alt115) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4052:2: ( (otherlv_8= RULE_ID ) ) this_DOT_9= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4052:2: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4053:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4053:1: (otherlv_8= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4054:3: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
                      	        }
                              
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec8417); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_8, grammarAccess.getFlowPathSpecAccess().getOutContextContextCrossReference_7_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_9=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleFlowPathSpec8428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_9, grammarAccess.getFlowPathSpecAccess().getDOTTerminalRuleCall_7_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4069:3: ( (otherlv_10= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4070:1: (otherlv_10= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4070:1: (otherlv_10= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4071:3: otherlv_10= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathSpecRule());
              	        }
                      
            }
            otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpec8449); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_10, grammarAccess.getFlowPathSpecAccess().getOutFeatureFeatureCrossReference_8_0()); 
              	
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


    // $ANTLR start "entryRuleFlowSourceSpecRefinement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4090:1: entryRuleFlowSourceSpecRefinement returns [EObject current=null] : iv_ruleFlowSourceSpecRefinement= ruleFlowSourceSpecRefinement EOF ;
    public final EObject entryRuleFlowSourceSpecRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSourceSpecRefinement = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4091:2: (iv_ruleFlowSourceSpecRefinement= ruleFlowSourceSpecRefinement EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4092:2: iv_ruleFlowSourceSpecRefinement= ruleFlowSourceSpecRefinement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSourceSpecRefinementRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSourceSpecRefinement_in_entryRuleFlowSourceSpecRefinement8484);
            iv_ruleFlowSourceSpecRefinement=ruleFlowSourceSpecRefinement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSourceSpecRefinement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSourceSpecRefinement8494); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSourceSpecRefinement"


    // $ANTLR start "ruleFlowSourceSpecRefinement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4099:1: ruleFlowSourceSpecRefinement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSource ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ) ;
    public final EObject ruleFlowSourceSpecRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_LCURLY_6=null;
        Token this_RCURLY_8=null;
        AntlrDatatypeRuleToken lv_kind_5_0 = null;

        EObject lv_ownedPropertyAssociation_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4102:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSource ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4103:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSource ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4103:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSource ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4103:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSource ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4103:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4104:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4104:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4105:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSourceSpecRefinementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceSpecRefinement8539); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFlowSourceSpecRefinementAccess().getRefinedFlowSpecificationCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSourceSpecRefinement8550); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSourceSpecRefinementAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleFlowSourceSpecRefinement8562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSourceSpecRefinementAccess().getRefinedKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleFlowSourceSpecRefinement8574); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFlowSourceSpecRefinementAccess().getToKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowSourceSpecRefinement8586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFlowSourceSpecRefinementAccess().getFlowKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4135:1: ( (lv_kind_5_0= ruleFlowSource ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4136:1: (lv_kind_5_0= ruleFlowSource )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4136:1: (lv_kind_5_0= ruleFlowSource )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4137:3: lv_kind_5_0= ruleFlowSource
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSourceSpecRefinementAccess().getKindFlowSourceParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSource_in_ruleFlowSourceSpecRefinement8606);
            lv_kind_5_0=ruleFlowSource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSourceSpecRefinementRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_5_0, 
                      		"FlowSource");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4153:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            int alt117=2;
            alt117 = dfa117.predict(input);
            switch (alt117) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4153:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4153:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4153:4: ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY
                    {
                    this_LCURLY_6=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleFlowSourceSpecRefinement8623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_6, grammarAccess.getFlowSourceSpecRefinementAccess().getLCURLYTerminalRuleCall_6_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4157:2: ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+
                    int cnt116=0;
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==RULE_ID) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4158:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4158:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4159:3: lv_ownedPropertyAssociation_7_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFlowSourceSpecRefinementAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleFlowSourceSpecRefinement8644);
                    	    lv_ownedPropertyAssociation_7_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFlowSourceSpecRefinementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_7_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt116 >= 1 ) break loop116;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(116, input);
                                throw eee;
                        }
                        cnt116++;
                    } while (true);

                    this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleFlowSourceSpecRefinement8656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_8, grammarAccess.getFlowSourceSpecRefinementAccess().getRCURLYTerminalRuleCall_6_2()); 
                          
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
    // $ANTLR end "ruleFlowSourceSpecRefinement"


    // $ANTLR start "entryRuleFlowSinkSpecRefinement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4187:1: entryRuleFlowSinkSpecRefinement returns [EObject current=null] : iv_ruleFlowSinkSpecRefinement= ruleFlowSinkSpecRefinement EOF ;
    public final EObject entryRuleFlowSinkSpecRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSinkSpecRefinement = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4188:2: (iv_ruleFlowSinkSpecRefinement= ruleFlowSinkSpecRefinement EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4189:2: iv_ruleFlowSinkSpecRefinement= ruleFlowSinkSpecRefinement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSinkSpecRefinementRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSinkSpecRefinement_in_entryRuleFlowSinkSpecRefinement8692);
            iv_ruleFlowSinkSpecRefinement=ruleFlowSinkSpecRefinement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSinkSpecRefinement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSinkSpecRefinement8702); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSinkSpecRefinement"


    // $ANTLR start "ruleFlowSinkSpecRefinement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4196:1: ruleFlowSinkSpecRefinement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSink ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ) ;
    public final EObject ruleFlowSinkSpecRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_LCURLY_6=null;
        Token this_RCURLY_8=null;
        AntlrDatatypeRuleToken lv_kind_5_0 = null;

        EObject lv_ownedPropertyAssociation_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4199:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSink ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4200:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSink ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4200:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSink ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4200:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowSink ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4200:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4201:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4201:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4202:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSinkSpecRefinementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkSpecRefinement8747); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFlowSinkSpecRefinementAccess().getRefinedFlowSpecificationCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSinkSpecRefinement8758); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSinkSpecRefinementAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleFlowSinkSpecRefinement8770); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSinkSpecRefinementAccess().getRefinedKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleFlowSinkSpecRefinement8782); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFlowSinkSpecRefinementAccess().getToKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowSinkSpecRefinement8794); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFlowSinkSpecRefinementAccess().getFlowKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4232:1: ( (lv_kind_5_0= ruleFlowSink ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4233:1: (lv_kind_5_0= ruleFlowSink )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4233:1: (lv_kind_5_0= ruleFlowSink )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4234:3: lv_kind_5_0= ruleFlowSink
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSinkSpecRefinementAccess().getKindFlowSinkParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSink_in_ruleFlowSinkSpecRefinement8814);
            lv_kind_5_0=ruleFlowSink();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSinkSpecRefinementRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_5_0, 
                      		"FlowSink");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4250:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            int alt119=2;
            alt119 = dfa119.predict(input);
            switch (alt119) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4250:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4250:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4250:4: ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY
                    {
                    this_LCURLY_6=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleFlowSinkSpecRefinement8831); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_6, grammarAccess.getFlowSinkSpecRefinementAccess().getLCURLYTerminalRuleCall_6_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4254:2: ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+
                    int cnt118=0;
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( (LA118_0==RULE_ID) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4255:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4255:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4256:3: lv_ownedPropertyAssociation_7_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFlowSinkSpecRefinementAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleFlowSinkSpecRefinement8852);
                    	    lv_ownedPropertyAssociation_7_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFlowSinkSpecRefinementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_7_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt118 >= 1 ) break loop118;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(118, input);
                                throw eee;
                        }
                        cnt118++;
                    } while (true);

                    this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleFlowSinkSpecRefinement8864); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_8, grammarAccess.getFlowSinkSpecRefinementAccess().getRCURLYTerminalRuleCall_6_2()); 
                          
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
    // $ANTLR end "ruleFlowSinkSpecRefinement"


    // $ANTLR start "entryRuleFlowPathSpecRefinement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4284:1: entryRuleFlowPathSpecRefinement returns [EObject current=null] : iv_ruleFlowPathSpecRefinement= ruleFlowPathSpecRefinement EOF ;
    public final EObject entryRuleFlowPathSpecRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowPathSpecRefinement = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4285:2: (iv_ruleFlowPathSpecRefinement= ruleFlowPathSpecRefinement EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4286:2: iv_ruleFlowPathSpecRefinement= ruleFlowPathSpecRefinement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowPathSpecRefinementRule()); 
            }
            pushFollow(FOLLOW_ruleFlowPathSpecRefinement_in_entryRuleFlowPathSpecRefinement8900);
            iv_ruleFlowPathSpecRefinement=ruleFlowPathSpecRefinement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowPathSpecRefinement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowPathSpecRefinement8910); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowPathSpecRefinement"


    // $ANTLR start "ruleFlowPathSpecRefinement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4293:1: ruleFlowPathSpecRefinement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowPath ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ) ;
    public final EObject ruleFlowPathSpecRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_LCURLY_6=null;
        Token this_RCURLY_8=null;
        AntlrDatatypeRuleToken lv_kind_5_0 = null;

        EObject lv_ownedPropertyAssociation_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4296:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowPath ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4297:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowPath ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4297:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowPath ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4297:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_37 otherlv_3= KEYWORD_4 otherlv_4= KEYWORD_11 ( (lv_kind_5_0= ruleFlowPath ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4297:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4298:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4298:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4299:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathSpecRefinementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathSpecRefinement8955); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFlowPathSpecRefinementAccess().getRefinedFlowSpecificationCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowPathSpecRefinement8966); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowPathSpecRefinementAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleFlowPathSpecRefinement8978); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowPathSpecRefinementAccess().getRefinedKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleFlowPathSpecRefinement8990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFlowPathSpecRefinementAccess().getToKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowPathSpecRefinement9002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFlowPathSpecRefinementAccess().getFlowKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4329:1: ( (lv_kind_5_0= ruleFlowPath ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4330:1: (lv_kind_5_0= ruleFlowPath )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4330:1: (lv_kind_5_0= ruleFlowPath )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4331:3: lv_kind_5_0= ruleFlowPath
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowPathSpecRefinementAccess().getKindFlowPathParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowPath_in_ruleFlowPathSpecRefinement9022);
            lv_kind_5_0=ruleFlowPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowPathSpecRefinementRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_5_0, 
                      		"FlowPath");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4347:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?
            int alt121=2;
            alt121 = dfa121.predict(input);
            switch (alt121) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4347:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4347:3: ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4347:4: ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY
                    {
                    this_LCURLY_6=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleFlowPathSpecRefinement9039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_6, grammarAccess.getFlowPathSpecRefinementAccess().getLCURLYTerminalRuleCall_6_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4351:2: ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+
                    int cnt120=0;
                    loop120:
                    do {
                        int alt120=2;
                        int LA120_0 = input.LA(1);

                        if ( (LA120_0==RULE_ID) ) {
                            alt120=1;
                        }


                        switch (alt120) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4352:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4352:1: (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4353:3: lv_ownedPropertyAssociation_7_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFlowPathSpecRefinementAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleFlowPathSpecRefinement9060);
                    	    lv_ownedPropertyAssociation_7_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFlowPathSpecRefinementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_7_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt120 >= 1 ) break loop120;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(120, input);
                                throw eee;
                        }
                        cnt120++;
                    } while (true);

                    this_RCURLY_8=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleFlowPathSpecRefinement9072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_8, grammarAccess.getFlowPathSpecRefinementAccess().getRCURLYTerminalRuleCall_6_2()); 
                          
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
    // $ANTLR end "ruleFlowPathSpecRefinement"


    // $ANTLR start "entryRuleFlowSourceImpl"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4383:1: entryRuleFlowSourceImpl returns [EObject current=null] : iv_ruleFlowSourceImpl= ruleFlowSourceImpl EOF ;
    public final EObject entryRuleFlowSourceImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSourceImpl = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4384:2: (iv_ruleFlowSourceImpl= ruleFlowSourceImpl EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4385:2: iv_ruleFlowSourceImpl= ruleFlowSourceImpl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSourceImplRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSourceImpl_in_entryRuleFlowSourceImpl9110);
            iv_ruleFlowSourceImpl=ruleFlowSourceImpl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSourceImpl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSourceImpl9120); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSourceImpl"


    // $ANTLR start "ruleFlowSourceImpl"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4392:1: ruleFlowSourceImpl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ) ;
    public final EObject ruleFlowSourceImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4395:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4396:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4396:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4396:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSource ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4396:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4397:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4397:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4398:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSourceImplRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSourceImpl9165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFlowSourceImplAccess().getSpecificationFlowSpecificationCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSourceImpl9176); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSourceImplAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowSourceImpl9188); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSourceImplAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4418:1: ( (lv_kind_3_0= ruleFlowSource ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4419:1: (lv_kind_3_0= ruleFlowSource )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4419:1: (lv_kind_3_0= ruleFlowSource )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4420:3: lv_kind_3_0= ruleFlowSource
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSourceImplAccess().getKindFlowSourceParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSource_in_ruleFlowSourceImpl9208);
            lv_kind_3_0=ruleFlowSource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSourceImplRule());
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
    // $ANTLR end "ruleFlowSourceImpl"


    // $ANTLR start "entryRuleFlowSinkImpl"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4444:1: entryRuleFlowSinkImpl returns [EObject current=null] : iv_ruleFlowSinkImpl= ruleFlowSinkImpl EOF ;
    public final EObject entryRuleFlowSinkImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSinkImpl = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4445:2: (iv_ruleFlowSinkImpl= ruleFlowSinkImpl EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4446:2: iv_ruleFlowSinkImpl= ruleFlowSinkImpl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowSinkImplRule()); 
            }
            pushFollow(FOLLOW_ruleFlowSinkImpl_in_entryRuleFlowSinkImpl9243);
            iv_ruleFlowSinkImpl=ruleFlowSinkImpl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowSinkImpl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSinkImpl9253); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSinkImpl"


    // $ANTLR start "ruleFlowSinkImpl"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4453:1: ruleFlowSinkImpl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ) ;
    public final EObject ruleFlowSinkImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4456:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4457:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4457:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4457:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowSink ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4457:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4458:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4458:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4459:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowSinkImplRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSinkImpl9298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFlowSinkImplAccess().getSpecificationFlowSpecificationCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowSinkImpl9309); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowSinkImplAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowSinkImpl9321); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowSinkImplAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4479:1: ( (lv_kind_3_0= ruleFlowSink ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4480:1: (lv_kind_3_0= ruleFlowSink )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4480:1: (lv_kind_3_0= ruleFlowSink )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4481:3: lv_kind_3_0= ruleFlowSink
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowSinkImplAccess().getKindFlowSinkParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowSink_in_ruleFlowSinkImpl9341);
            lv_kind_3_0=ruleFlowSink();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowSinkImplRule());
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
    // $ANTLR end "ruleFlowSinkImpl"


    // $ANTLR start "entryRuleFlowPathImpl"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4505:1: entryRuleFlowPathImpl returns [EObject current=null] : iv_ruleFlowPathImpl= ruleFlowPathImpl EOF ;
    public final EObject entryRuleFlowPathImpl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowPathImpl = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4506:2: (iv_ruleFlowPathImpl= ruleFlowPathImpl EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4507:2: iv_ruleFlowPathImpl= ruleFlowPathImpl EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlowPathImplRule()); 
            }
            pushFollow(FOLLOW_ruleFlowPathImpl_in_entryRuleFlowPathImpl9376);
            iv_ruleFlowPathImpl=ruleFlowPathImpl();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlowPathImpl; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowPathImpl9386); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowPathImpl"


    // $ANTLR start "ruleFlowPathImpl"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4514:1: ruleFlowPathImpl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ) ;
    public final EObject ruleFlowPathImpl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_kind_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4517:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4518:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4518:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4518:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= KEYWORD_11 ( (lv_kind_3_0= ruleFlowPath ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4518:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4519:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4519:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4520:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFlowPathImplRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowPathImpl9431); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFlowPathImplAccess().getSpecificationFlowSpecificationCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleFlowPathImpl9442); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getFlowPathImplAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleFlowPathImpl9454); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFlowPathImplAccess().getFlowKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4540:1: ( (lv_kind_3_0= ruleFlowPath ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4541:1: (lv_kind_3_0= ruleFlowPath )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4541:1: (lv_kind_3_0= ruleFlowPath )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4542:3: lv_kind_3_0= ruleFlowPath
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFlowPathImplAccess().getKindFlowPathParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleFlowPath_in_ruleFlowPathImpl9474);
            lv_kind_3_0=ruleFlowPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFlowPathImplRule());
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
    // $ANTLR end "ruleFlowPathImpl"


    // $ANTLR start "entryRuleSubcomponentFlow"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4570:1: entryRuleSubcomponentFlow returns [EObject current=null] : iv_ruleSubcomponentFlow= ruleSubcomponentFlow EOF ;
    public final EObject entryRuleSubcomponentFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubcomponentFlow = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4571:2: (iv_ruleSubcomponentFlow= ruleSubcomponentFlow EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4572:2: iv_ruleSubcomponentFlow= ruleSubcomponentFlow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubcomponentFlowRule()); 
            }
            pushFollow(FOLLOW_ruleSubcomponentFlow_in_entryRuleSubcomponentFlow9513);
            iv_ruleSubcomponentFlow=ruleSubcomponentFlow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubcomponentFlow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubcomponentFlow9523); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubcomponentFlow"


    // $ANTLR start "ruleSubcomponentFlow"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4579:1: ruleSubcomponentFlow returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleSubcomponentFlow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_DOT_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4582:28: ( ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4583:1: ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4583:1: ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (otherlv_2= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4583:2: ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT ( (otherlv_2= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4583:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4584:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4584:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4585:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSubcomponentFlowRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubcomponentFlow9568); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getSubcomponentFlowAccess().getContextSubcomponentCrossReference_0_0()); 
              	
            }

            }


            }

            this_DOT_1=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleSubcomponentFlow9579); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_1, grammarAccess.getSubcomponentFlowAccess().getDOTTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4600:1: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4601:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4601:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4602:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSubcomponentFlowRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubcomponentFlow9598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getSubcomponentFlowAccess().getFlowSpecificationFlowSpecificationCrossReference_2_0()); 
              	
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
    // $ANTLR end "ruleSubcomponentFlow"


    // $ANTLR start "entryRuleMode"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4621:1: entryRuleMode returns [EObject current=null] : iv_ruleMode= ruleMode EOF ;
    public final EObject entryRuleMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMode = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4622:2: (iv_ruleMode= ruleMode EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4623:2: iv_ruleMode= ruleMode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeRule()); 
            }
            pushFollow(FOLLOW_ruleMode_in_entryRuleMode9633);
            iv_ruleMode=ruleMode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMode; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMode9643); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4630:1: ruleMode returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= KEYWORD_32 ) )? otherlv_3= KEYWORD_12 ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? this_SEMI_7= RULE_SEMI ) ;
    public final EObject ruleMode() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token lv_initial_2_0=null;
        Token otherlv_3=null;
        Token this_LCURLY_4=null;
        Token this_RCURLY_6=null;
        Token this_SEMI_7=null;
        EObject lv_ownedPropertyAssociation_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4633:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= KEYWORD_32 ) )? otherlv_3= KEYWORD_12 ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? this_SEMI_7= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4634:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= KEYWORD_32 ) )? otherlv_3= KEYWORD_12 ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? this_SEMI_7= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4634:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= KEYWORD_32 ) )? otherlv_3= KEYWORD_12 ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? this_SEMI_7= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4634:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_initial_2_0= KEYWORD_32 ) )? otherlv_3= KEYWORD_12 ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )? this_SEMI_7= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4634:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4635:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4635:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4636:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMode9685); if (state.failed) return current;
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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleMode9701); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getModeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4656:1: ( (lv_initial_2_0= KEYWORD_32 ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==KEYWORD_32) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4657:1: (lv_initial_2_0= KEYWORD_32 )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4657:1: (lv_initial_2_0= KEYWORD_32 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4658:3: lv_initial_2_0= KEYWORD_32
                    {
                    lv_initial_2_0=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_ruleMode9719); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleMode9744); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModeAccess().getModeKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4677:1: ( ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==RULE_LCURLY) && (synpred37_InternalAadl2Parser())) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4677:2: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+ this_RCURLY_6= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4677:2: ( ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4677:3: ( RULE_LCURLY )=>this_LCURLY_4= RULE_LCURLY
                    {
                    this_LCURLY_4=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleMode9760); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_4, grammarAccess.getModeAccess().getLCURLYTerminalRuleCall_4_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4681:2: ( (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation ) )+
                    int cnt123=0;
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==RULE_ID) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4682:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4682:1: (lv_ownedPropertyAssociation_5_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4683:3: lv_ownedPropertyAssociation_5_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModeAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_4_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleMode9781);
                    	    lv_ownedPropertyAssociation_5_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_5_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt123 >= 1 ) break loop123;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(123, input);
                                throw eee;
                        }
                        cnt123++;
                    } while (true);

                    this_RCURLY_6=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleMode9793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_6, grammarAccess.getModeAccess().getRCURLYTerminalRuleCall_4_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_7=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleMode9805); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_7, grammarAccess.getModeAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4715:1: entryRuleModeTransition returns [EObject current=null] : iv_ruleModeTransition= ruleModeTransition EOF ;
    public final EObject entryRuleModeTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransition = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4716:2: (iv_ruleModeTransition= ruleModeTransition EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4717:2: iv_ruleModeTransition= ruleModeTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeTransitionRule()); 
            }
            pushFollow(FOLLOW_ruleModeTransition_in_entryRuleModeTransition9839);
            iv_ruleModeTransition=ruleModeTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeTransition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransition9849); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4724:1: ruleModeTransition returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY )? this_SEMI_12= RULE_SEMI ) ;
    public final EObject ruleModeTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_LTRANS_3=null;
        Token this_COMMA_5=null;
        Token this_RTRANS_7=null;
        Token otherlv_8=null;
        Token this_LCURLY_9=null;
        Token this_RCURLY_11=null;
        Token this_SEMI_12=null;
        EObject lv_ownedTrigger_4_0 = null;

        EObject lv_ownedTrigger_6_0 = null;

        EObject lv_ownedPropertyAssociation_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4727:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY )? this_SEMI_12= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4728:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY )? this_SEMI_12= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4728:1: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY )? this_SEMI_12= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4728:2: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )? ( (otherlv_2= RULE_ID ) ) this_LTRANS_3= RULE_LTRANS ( (lv_ownedTrigger_4_0= ruleTriggerPort ) ) (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )* this_RTRANS_7= RULE_RTRANS ( (otherlv_8= RULE_ID ) ) ( ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY )? this_SEMI_12= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4728:2: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON )?
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==RULE_ID) ) {
                int LA125_1 = input.LA(2);

                if ( (LA125_1==RULE_COLON) ) {
                    alt125=1;
                }
            }
            switch (alt125) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4728:3: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4728:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4729:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4729:1: (lv_name_0_0= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4730:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition9892); if (state.failed) return current;
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

                    this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleModeTransition9908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COLON_1, grammarAccess.getModeTransitionAccess().getCOLONTerminalRuleCall_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4750:3: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4751:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4751:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4752:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeTransitionRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition9929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getModeTransitionAccess().getSourceModeCrossReference_1_0()); 
              	
            }

            }


            }

            this_LTRANS_3=(Token)match(input,RULE_LTRANS,FOLLOW_RULE_LTRANS_in_ruleModeTransition9940); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LTRANS_3, grammarAccess.getModeTransitionAccess().getLTRANSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4767:1: ( (lv_ownedTrigger_4_0= ruleTriggerPort ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4768:1: (lv_ownedTrigger_4_0= ruleTriggerPort )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4768:1: (lv_ownedTrigger_4_0= ruleTriggerPort )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4769:3: lv_ownedTrigger_4_0= ruleTriggerPort
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedTriggerTriggerPortParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerPort_in_ruleModeTransition9960);
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4785:2: (this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) ) )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==RULE_COMMA) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4785:3: this_COMMA_5= RULE_COMMA ( (lv_ownedTrigger_6_0= ruleTriggerPort ) )
            	    {
            	    this_COMMA_5=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleModeTransition9972); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_5, grammarAccess.getModeTransitionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4789:1: ( (lv_ownedTrigger_6_0= ruleTriggerPort ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4790:1: (lv_ownedTrigger_6_0= ruleTriggerPort )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4790:1: (lv_ownedTrigger_6_0= ruleTriggerPort )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4791:3: lv_ownedTrigger_6_0= ruleTriggerPort
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedTriggerTriggerPortParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTriggerPort_in_ruleModeTransition9992);
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
            	    break loop126;
                }
            } while (true);

            this_RTRANS_7=(Token)match(input,RULE_RTRANS,FOLLOW_RULE_RTRANS_in_ruleModeTransition10005); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RTRANS_7, grammarAccess.getModeTransitionAccess().getRTRANSTerminalRuleCall_5()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4811:1: ( (otherlv_8= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4812:1: (otherlv_8= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4812:1: (otherlv_8= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4813:3: otherlv_8= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeTransitionRule());
              	        }
                      
            }
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransition10024); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_8, grammarAccess.getModeTransitionAccess().getDestinationModeCrossReference_6_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4824:2: ( ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==RULE_LCURLY) && (synpred38_InternalAadl2Parser())) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4824:3: ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+ this_RCURLY_11= RULE_RCURLY
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4824:3: ( ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4824:4: ( RULE_LCURLY )=>this_LCURLY_9= RULE_LCURLY
                    {
                    this_LCURLY_9=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleModeTransition10041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_9, grammarAccess.getModeTransitionAccess().getLCURLYTerminalRuleCall_7_0()); 
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4828:2: ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation ) )+
                    int cnt127=0;
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==RULE_ID) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4829:1: (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4829:1: (lv_ownedPropertyAssociation_10_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4830:3: lv_ownedPropertyAssociation_10_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModeTransitionAccess().getOwnedPropertyAssociationPropertyAssociationParserRuleCall_7_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleModeTransition10062);
                    	    lv_ownedPropertyAssociation_10_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModeTransitionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedPropertyAssociation",
                    	              		lv_ownedPropertyAssociation_10_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt127 >= 1 ) break loop127;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(127, input);
                                throw eee;
                        }
                        cnt127++;
                    } while (true);

                    this_RCURLY_11=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleModeTransition10074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_11, grammarAccess.getModeTransitionAccess().getRCURLYTerminalRuleCall_7_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_12=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleModeTransition10086); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_12, grammarAccess.getModeTransitionAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4862:1: entryRuleTriggerPort returns [EObject current=null] : iv_ruleTriggerPort= ruleTriggerPort EOF ;
    public final EObject entryRuleTriggerPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerPort = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4863:2: (iv_ruleTriggerPort= ruleTriggerPort EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4864:2: iv_ruleTriggerPort= ruleTriggerPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggerPortRule()); 
            }
            pushFollow(FOLLOW_ruleTriggerPort_in_entryRuleTriggerPort10120);
            iv_ruleTriggerPort=ruleTriggerPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggerPort; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerPort10130); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4871:1: ruleTriggerPort returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTriggerPort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_DOT_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4874:28: ( ( ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4875:1: ( ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4875:1: ( ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4875:2: ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4875:2: ( ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==RULE_ID) ) {
                int LA129_1 = input.LA(2);

                if ( (LA129_1==RULE_DOT) ) {
                    alt129=1;
                }
            }
            switch (alt129) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4875:3: ( (otherlv_0= RULE_ID ) ) this_DOT_1= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4875:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4876:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4876:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4877:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTriggerPortRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggerPort10176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getTriggerPortAccess().getContextContextCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }

                    this_DOT_1=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleTriggerPort10187); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_1, grammarAccess.getTriggerPortAccess().getDOTTerminalRuleCall_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4892:3: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4893:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4893:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4894:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTriggerPortRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggerPort10208); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getTriggerPortAccess().getPortPortCrossReference_1_0()); 
              	
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
    // $ANTLR end "ruleTriggerPort"


    // $ANTLR start "entryRuleModeRef"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4913:1: entryRuleModeRef returns [EObject current=null] : iv_ruleModeRef= ruleModeRef EOF ;
    public final EObject entryRuleModeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeRef = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4914:2: (iv_ruleModeRef= ruleModeRef EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4915:2: iv_ruleModeRef= ruleModeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModeRefRule()); 
            }
            pushFollow(FOLLOW_ruleModeRef_in_entryRuleModeRef10243);
            iv_ruleModeRef=ruleModeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeRef10253); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4922:1: ruleModeRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) ) )? ) ;
    public final EObject ruleModeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ARROW_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4925:28: ( ( ( (otherlv_0= RULE_ID ) ) (this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) ) )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4926:1: ( ( (otherlv_0= RULE_ID ) ) (this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) ) )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4926:1: ( ( (otherlv_0= RULE_ID ) ) (this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) ) )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4926:2: ( (otherlv_0= RULE_ID ) ) (this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) ) )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4926:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4927:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4927:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4928:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModeRefRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeRef10298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getModeRefAccess().getParentModeModeCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4939:2: (this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) ) )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==RULE_ARROW) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4939:3: this_ARROW_1= RULE_ARROW ( (otherlv_2= RULE_ID ) )
                    {
                    this_ARROW_1=(Token)match(input,RULE_ARROW,FOLLOW_RULE_ARROW_in_ruleModeRef10310); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ARROW_1, grammarAccess.getModeRefAccess().getARROWTerminalRuleCall_1_0()); 
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4943:1: ( (otherlv_2= RULE_ID ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4944:1: (otherlv_2= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4944:1: (otherlv_2= RULE_ID )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4945:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModeRefRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeRef10329); if (state.failed) return current;
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


    // $ANTLR start "entryRuleDefaultAnnexLibrary"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4966:1: entryRuleDefaultAnnexLibrary returns [EObject current=null] : iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF ;
    public final EObject entryRuleDefaultAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultAnnexLibrary = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4967:2: (iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4968:2: iv_ruleDefaultAnnexLibrary= ruleDefaultAnnexLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultAnnexLibraryRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultAnnexLibrary_in_entryRuleDefaultAnnexLibrary10368);
            iv_ruleDefaultAnnexLibrary=ruleDefaultAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultAnnexLibrary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultAnnexLibrary10378); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4975:1: ruleDefaultAnnexLibrary returns [EObject current=null] : (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleDefaultAnnexLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sourceText_2_0=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4978:28: ( (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4979:1: (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4979:1: (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4980:2: otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,KEYWORD_17,FOLLOW_KEYWORD_17_in_ruleDefaultAnnexLibrary10416); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefaultAnnexLibraryAccess().getAnnexKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4984:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4985:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4985:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4986:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefaultAnnexLibrary10432); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5002:2: ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5003:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5003:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5004:3: lv_sourceText_2_0= RULE_ANNEXTEXT
            {
            lv_sourceText_2_0=(Token)match(input,RULE_ANNEXTEXT,FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexLibrary10454); if (state.failed) return current;
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

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDefaultAnnexLibrary10470); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5032:1: entryRuleAnnexSubclause returns [EObject current=null] : iv_ruleAnnexSubclause= ruleAnnexSubclause EOF ;
    public final EObject entryRuleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5033:2: (iv_ruleAnnexSubclause= ruleAnnexSubclause EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5034:2: iv_ruleAnnexSubclause= ruleAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause10504);
            iv_ruleAnnexSubclause=ruleAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnexSubclause10514); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5041:1: ruleAnnexSubclause returns [EObject current=null] : this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause ;
    public final EObject ruleAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject this_DefaultAnnexSubclause_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5044:28: (this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5046:5: this_DefaultAnnexSubclause_0= ruleDefaultAnnexSubclause
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAnnexSubclauseAccess().getDefaultAnnexSubclauseParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleDefaultAnnexSubclause_in_ruleAnnexSubclause10560);
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5062:1: entryRuleDefaultAnnexSubclause returns [EObject current=null] : iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF ;
    public final EObject entryRuleDefaultAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultAnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5063:2: (iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5064:2: iv_ruleDefaultAnnexSubclause= ruleDefaultAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultAnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleDefaultAnnexSubclause_in_entryRuleDefaultAnnexSubclause10593);
            iv_ruleDefaultAnnexSubclause=ruleDefaultAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultAnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefaultAnnexSubclause10603); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5071:1: ruleDefaultAnnexSubclause returns [EObject current=null] : (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleDefaultAnnexSubclause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sourceText_2_0=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5074:28: ( (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5075:1: (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5075:1: (otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5076:2: otherlv_0= KEYWORD_17 ( (lv_name_1_0= RULE_ID ) ) ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,KEYWORD_17,FOLLOW_KEYWORD_17_in_ruleDefaultAnnexSubclause10641); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDefaultAnnexSubclauseAccess().getAnnexKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5080:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5081:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5081:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5082:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefaultAnnexSubclause10657); if (state.failed) return current;
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

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5098:2: ( (lv_sourceText_2_0= RULE_ANNEXTEXT ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5099:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5099:1: (lv_sourceText_2_0= RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5100:3: lv_sourceText_2_0= RULE_ANNEXTEXT
            {
            lv_sourceText_2_0=(Token)match(input,RULE_ANNEXTEXT,FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexSubclause10679); if (state.failed) return current;
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

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDefaultAnnexSubclause10695); if (state.failed) return current;
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


    // $ANTLR start "entryRulePropertyAssociation"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5128:1: entryRulePropertyAssociation returns [EObject current=null] : iv_rulePropertyAssociation= rulePropertyAssociation EOF ;
    public final EObject entryRulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5129:2: (iv_rulePropertyAssociation= rulePropertyAssociation EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5130:2: iv_rulePropertyAssociation= rulePropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_rulePropertyAssociation_in_entryRulePropertyAssociation10729);
            iv_rulePropertyAssociation=rulePropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAssociation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAssociation10739); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssociation"


    // $ANTLR start "rulePropertyAssociation"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5137:1: rulePropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN this_SEMI_2= RULE_SEMI ) ;
    public final EObject rulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ASSIGN_1=null;
        Token this_SEMI_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5140:28: ( ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN this_SEMI_2= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5141:1: ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN this_SEMI_2= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5141:1: ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN this_SEMI_2= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5141:2: ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN this_SEMI_2= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5141:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5142:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5142:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5143:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociation10784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            this_ASSIGN_1=(Token)match(input,RULE_ASSIGN,FOLLOW_RULE_ASSIGN_in_rulePropertyAssociation10795); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ASSIGN_1, grammarAccess.getPropertyAssociationAccess().getASSIGNTerminalRuleCall_1()); 
                  
            }
            this_SEMI_2=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePropertyAssociation10805); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getPropertyAssociationAccess().getSEMITerminalRuleCall_2()); 
                  
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
    // $ANTLR end "rulePropertyAssociation"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5170:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5171:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5172:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation10839);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainedPropertyAssociation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainedPropertyAssociation10849); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainedPropertyAssociation"


    // $ANTLR start "ruleContainedPropertyAssociation"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5179:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) ) )? this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ASSIGN_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_5=null;
        EObject lv_appliesTo_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5182:28: ( ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) ) )? this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5183:1: ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) ) )? this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5183:1: ( ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) ) )? this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5183:2: ( (otherlv_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) ) )? this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5183:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5184:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5184:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5185:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainedPropertyAssociation10894); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            this_ASSIGN_1=(Token)match(input,RULE_ASSIGN,FOLLOW_RULE_ASSIGN_in_ruleContainedPropertyAssociation10905); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ASSIGN_1, grammarAccess.getContainedPropertyAssociationAccess().getASSIGNTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5200:1: ( ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) ) )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==KEYWORD_29) && (synpred39_InternalAadl2Parser())) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5200:2: ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 ) otherlv_3= KEYWORD_4 ( (lv_appliesTo_4_0= ruleContainmentPath ) )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5200:2: ( ( KEYWORD_29 )=>otherlv_2= KEYWORD_29 )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5200:3: ( KEYWORD_29 )=>otherlv_2= KEYWORD_29
                    {
                    otherlv_2=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_ruleContainedPropertyAssociation10925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_2_0());
                          
                    }

                    }

                    otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleContainedPropertyAssociation10938); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_2_1());
                          
                    }
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5212:1: ( (lv_appliesTo_4_0= ruleContainmentPath ) )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5213:1: (lv_appliesTo_4_0= ruleContainmentPath )
                    {
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5213:1: (lv_appliesTo_4_0= ruleContainmentPath )
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5214:3: lv_appliesTo_4_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_2_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation10958);
                    lv_appliesTo_4_0=ruleContainmentPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"appliesTo",
                              		lv_appliesTo_4_0, 
                              		"ContainmentPath");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleContainedPropertyAssociation10971); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getContainedPropertyAssociationAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5242:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5243:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5244:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathRule()); 
            }
            pushFollow(FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath11005);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPath; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPath11015); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPath"


    // $ANTLR start "ruleContainmentPath"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5251:1: ruleContainmentPath returns [EObject current=null] : ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        Token this_COMMA_2=null;
        EObject lv_containmentPathElement_1_0 = null;

        EObject lv_containmentPathElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5254:28: ( ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5255:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5255:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5255:2: () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5255:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5256:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getContainmentPathAccess().getContainedNamedElementAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5261:2: ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5262:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5262:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5263:3: lv_containmentPathElement_1_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath11070);
            lv_containmentPathElement_1_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainmentPathRule());
              	        }
                     		add(
                     			current, 
                     			"containmentPathElement",
                      		lv_containmentPathElement_1_0, 
                      		"ContainmentPathElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5279:2: (this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==RULE_COMMA) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5279:3: this_COMMA_2= RULE_COMMA ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    {
            	    this_COMMA_2=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleContainmentPath11082); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_2, grammarAccess.getContainmentPathAccess().getCOMMATerminalRuleCall_2_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5283:1: ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5284:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5284:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5285:3: lv_containmentPathElement_3_0= ruleContainmentPathElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath11102);
            	    lv_containmentPathElement_3_0=ruleContainmentPathElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getContainmentPathRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"containmentPathElement",
            	              		lv_containmentPathElement_3_0, 
            	              		"ContainmentPathElement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop132;
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
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleContainmentPathElement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5309:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5310:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5311:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement11139);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPathElement11149); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPathElement"


    // $ANTLR start "ruleContainmentPathElement"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5318:1: ruleContainmentPathElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) ) ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_arrayRange_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5321:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5322:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5322:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5322:2: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5322:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5323:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5323:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5324:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainmentPathElement11194); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5335:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5336:1: (lv_arrayRange_1_0= ruleArrayRange )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5336:1: (lv_arrayRange_1_0= ruleArrayRange )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5337:3: lv_arrayRange_1_0= ruleArrayRange
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleArrayRange_in_ruleContainmentPathElement11215);
            lv_arrayRange_1_0=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
              	        }
                     		add(
                     			current, 
                     			"arrayRange",
                      		lv_arrayRange_1_0, 
                      		"ArrayRange");
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
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRuleArrayRange"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5361:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5362:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5363:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FOLLOW_ruleArrayRange_in_entryRuleArrayRange11250);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayRange11260); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRange"


    // $ANTLR start "ruleArrayRange"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5370:1: ruleArrayRange returns [EObject current=null] : ( () this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token this_LBRACKET_1=null;
        Token this_RBRACKET_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5373:28: ( ( () this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5374:1: ( () this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5374:1: ( () this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5374:2: () this_LBRACKET_1= RULE_LBRACKET this_RBRACKET_2= RULE_RBRACKET
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5374:2: ()
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5375:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                          current);
                  
            }

            }

            this_LBRACKET_1=(Token)match(input,RULE_LBRACKET,FOLLOW_RULE_LBRACKET_in_ruleArrayRange11305); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LBRACKET_1, grammarAccess.getArrayRangeAccess().getLBRACKETTerminalRuleCall_1()); 
                  
            }
            this_RBRACKET_2=(Token)match(input,RULE_RBRACKET,FOLLOW_RULE_RBRACKET_in_ruleArrayRange11315); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RBRACKET_2, grammarAccess.getArrayRangeAccess().getRBRACKETTerminalRuleCall_2()); 
                  
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
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRulePNAME"
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5400:1: entryRulePNAME returns [String current=null] : iv_rulePNAME= rulePNAME EOF ;
    public final String entryRulePNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePNAME = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5401:1: (iv_rulePNAME= rulePNAME EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5402:2: iv_rulePNAME= rulePNAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPNAMERule()); 
            }
            pushFollow(FOLLOW_rulePNAME_in_entryRulePNAME11354);
            iv_rulePNAME=rulePNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePNAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePNAME11365); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5409:1: rulePNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= KEYWORD_1 this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken rulePNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5413:6: ( (this_ID_0= RULE_ID (kw= KEYWORD_1 this_ID_2= RULE_ID )* ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5414:1: (this_ID_0= RULE_ID (kw= KEYWORD_1 this_ID_2= RULE_ID )* )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5414:1: (this_ID_0= RULE_ID (kw= KEYWORD_1 this_ID_2= RULE_ID )* )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5414:6: this_ID_0= RULE_ID (kw= KEYWORD_1 this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePNAME11405); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getPNAMEAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5421:1: (kw= KEYWORD_1 this_ID_2= RULE_ID )*
            loop133:
            do {
                int alt133=2;
                int LA133_0 = input.LA(1);

                if ( (LA133_0==KEYWORD_1) ) {
                    alt133=1;
                }


                switch (alt133) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5422:2: kw= KEYWORD_1 this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_rulePNAME11424); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getPNAMEAccess().getColonColonKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePNAME11439); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getPNAMEAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop133;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5444:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5445:1: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5446:2: iv_ruleINAME= ruleINAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINAMERule()); 
            }
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME11488);
            iv_ruleINAME=ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME11499); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5453:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5457:6: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5458:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME11538); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5473:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5474:1: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5475:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF11582);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF11593); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5482:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= KEYWORD_1 )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_DOT_3=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5486:6: ( ( (this_ID_0= RULE_ID kw= KEYWORD_1 )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5487:1: ( (this_ID_0= RULE_ID kw= KEYWORD_1 )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5487:1: ( (this_ID_0= RULE_ID kw= KEYWORD_1 )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5487:2: (this_ID_0= RULE_ID kw= KEYWORD_1 )* this_ID_2= RULE_ID (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5487:2: (this_ID_0= RULE_ID kw= KEYWORD_1 )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==RULE_ID) ) {
                    int LA134_1 = input.LA(2);

                    if ( (LA134_1==KEYWORD_1) ) {
                        alt134=1;
                    }


                }


                switch (alt134) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5487:7: this_ID_0= RULE_ID kw= KEYWORD_1
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF11634); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleQCREF11652); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop134;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF11669); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5507:1: (this_DOT_3= RULE_DOT this_ID_4= RULE_ID )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==RULE_DOT) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5507:6: this_DOT_3= RULE_DOT this_ID_4= RULE_ID
                    {
                    this_DOT_3=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleQCREF11690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOT_3);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_3, grammarAccess.getQCREFAccess().getDOTTerminalRuleCall_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF11710); if (state.failed) return current;
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

    // $ANTLR start synpred1_InternalAadl2Parser
    public final void synpred1_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:153:5: ( KEYWORD_45 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:154:1: KEYWORD_45
        {
        match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred1_InternalAadl2Parser222); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalAadl2Parser

    // $ANTLR start synpred2_InternalAadl2Parser
    public final void synpred2_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:232:3: ( KEYWORD_16 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:233:1: KEYWORD_16
        {
        match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_synpred2_InternalAadl2Parser415); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalAadl2Parser

    // $ANTLR start synpred3_InternalAadl2Parser
    public final void synpred3_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:384:3: ( KEYWORD_16 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:385:1: KEYWORD_16
        {
        match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_synpred3_InternalAadl2Parser703); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalAadl2Parser

    // $ANTLR start synpred4_InternalAadl2Parser
    public final void synpred4_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:688:4: ( KEYWORD_46 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:689:1: KEYWORD_46
        {
        match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_synpred4_InternalAadl2Parser1385); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalAadl2Parser

    // $ANTLR start synpred5_InternalAadl2Parser
    public final void synpred5_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:732:8: ( KEYWORD_40 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:733:1: KEYWORD_40
        {
        match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred5_InternalAadl2Parser1460); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalAadl2Parser

    // $ANTLR start synpred6_InternalAadl2Parser
    public final void synpred6_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:814:9: ( KEYWORD_19 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:815:1: KEYWORD_19
        {
        match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_synpred6_InternalAadl2Parser1591); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalAadl2Parser

    // $ANTLR start synpred7_InternalAadl2Parser
    public final void synpred7_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:858:8: ( KEYWORD_21 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:859:1: KEYWORD_21
        {
        match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred7_InternalAadl2Parser1667); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalAadl2Parser

    // $ANTLR start synpred8_InternalAadl2Parser
    public final void synpred8_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:921:6: ( KEYWORD_45 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:922:1: KEYWORD_45
        {
        match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred8_InternalAadl2Parser1770); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalAadl2Parser

    // $ANTLR start synpred9_InternalAadl2Parser
    public final void synpred9_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1044:4: ( KEYWORD_40 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1045:1: KEYWORD_40
        {
        match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred9_InternalAadl2Parser2007); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalAadl2Parser

    // $ANTLR start synpred10_InternalAadl2Parser
    public final void synpred10_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1126:9: ( KEYWORD_19 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1127:1: KEYWORD_19
        {
        match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_synpred10_InternalAadl2Parser2138); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalAadl2Parser

    // $ANTLR start synpred11_InternalAadl2Parser
    public final void synpred11_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1170:8: ( KEYWORD_21 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1171:1: KEYWORD_21
        {
        match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred11_InternalAadl2Parser2214); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalAadl2Parser

    // $ANTLR start synpred12_InternalAadl2Parser
    public final void synpred12_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1233:6: ( KEYWORD_45 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1234:1: KEYWORD_45
        {
        match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred12_InternalAadl2Parser2317); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalAadl2Parser

    // $ANTLR start synpred13_InternalAadl2Parser
    public final void synpred13_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1352:4: ( KEYWORD_40 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1353:1: KEYWORD_40
        {
        match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred13_InternalAadl2Parser2550); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_InternalAadl2Parser

    // $ANTLR start synpred14_InternalAadl2Parser
    public final void synpred14_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1377:6: ( KEYWORD_19 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1378:1: KEYWORD_19
        {
        match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_synpred14_InternalAadl2Parser2595); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalAadl2Parser

    // $ANTLR start synpred15_InternalAadl2Parser
    public final void synpred15_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1421:8: ( KEYWORD_21 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1422:1: KEYWORD_21
        {
        match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred15_InternalAadl2Parser2671); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalAadl2Parser

    // $ANTLR start synpred16_InternalAadl2Parser
    public final void synpred16_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1484:6: ( KEYWORD_45 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1485:1: KEYWORD_45
        {
        match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred16_InternalAadl2Parser2774); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalAadl2Parser

    // $ANTLR start synpred17_InternalAadl2Parser
    public final void synpred17_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1596:3: ( KEYWORD_49 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1597:1: KEYWORD_49
        {
        match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_synpred17_InternalAadl2Parser3006); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalAadl2Parser

    // $ANTLR start synpred18_InternalAadl2Parser
    public final void synpred18_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1678:7: ( KEYWORD_48 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1679:1: KEYWORD_48
        {
        match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_synpred18_InternalAadl2Parser3137); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_InternalAadl2Parser

    // $ANTLR start synpred19_InternalAadl2Parser
    public final void synpred19_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1722:7: ( KEYWORD_19 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1723:1: KEYWORD_19
        {
        match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_synpred19_InternalAadl2Parser3212); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_InternalAadl2Parser

    // $ANTLR start synpred20_InternalAadl2Parser
    public final void synpred20_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1747:6: ( KEYWORD_21 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1748:1: KEYWORD_21
        {
        match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred20_InternalAadl2Parser3257); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalAadl2Parser

    // $ANTLR start synpred21_InternalAadl2Parser
    public final void synpred21_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1810:7: ( KEYWORD_45 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1811:1: KEYWORD_45
        {
        match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred21_InternalAadl2Parser3361); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalAadl2Parser

    // $ANTLR start synpred22_InternalAadl2Parser
    public final void synpred22_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1951:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:1951:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred22_InternalAadl2Parser3665); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalAadl2Parser

    // $ANTLR start synpred23_InternalAadl2Parser
    public final void synpred23_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2321:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2321:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred23_InternalAadl2Parser4436); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalAadl2Parser

    // $ANTLR start synpred24_InternalAadl2Parser
    public final void synpred24_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2347:5: ( KEYWORD_2 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2348:1: KEYWORD_2
        {
        match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_synpred24_InternalAadl2Parser4488); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalAadl2Parser

    // $ANTLR start synpred25_InternalAadl2Parser
    public final void synpred25_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2469:5: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2469:6: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred25_InternalAadl2Parser4750); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalAadl2Parser

    // $ANTLR start synpred26_InternalAadl2Parser
    public final void synpred26_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2495:5: ( KEYWORD_2 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2496:1: KEYWORD_2
        {
        match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_synpred26_InternalAadl2Parser4802); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalAadl2Parser

    // $ANTLR start synpred27_InternalAadl2Parser
    public final void synpred27_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2617:5: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2617:6: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred27_InternalAadl2Parser5064); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalAadl2Parser

    // $ANTLR start synpred28_InternalAadl2Parser
    public final void synpred28_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2643:5: ( KEYWORD_2 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2644:1: KEYWORD_2
        {
        match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_synpred28_InternalAadl2Parser5116); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalAadl2Parser

    // $ANTLR start synpred29_InternalAadl2Parser
    public final void synpred29_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2788:5: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2788:6: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred29_InternalAadl2Parser5411); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalAadl2Parser

    // $ANTLR start synpred30_InternalAadl2Parser
    public final void synpred30_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2909:5: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:2909:6: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred30_InternalAadl2Parser5655); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalAadl2Parser

    // $ANTLR start synpred31_InternalAadl2Parser
    public final void synpred31_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3010:3: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3010:4: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred31_InternalAadl2Parser5863); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_InternalAadl2Parser

    // $ANTLR start synpred32_InternalAadl2Parser
    public final void synpred32_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3697:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3697:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred32_InternalAadl2Parser7697); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalAadl2Parser

    // $ANTLR start synpred33_InternalAadl2Parser
    public final void synpred33_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3723:5: ( KEYWORD_2 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:3724:1: KEYWORD_2
        {
        match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_synpred33_InternalAadl2Parser7749); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalAadl2Parser

    // $ANTLR start synpred34_InternalAadl2Parser
    public final void synpred34_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4153:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4153:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred34_InternalAadl2Parser8618); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalAadl2Parser

    // $ANTLR start synpred35_InternalAadl2Parser
    public final void synpred35_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4250:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4250:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred35_InternalAadl2Parser8826); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalAadl2Parser

    // $ANTLR start synpred36_InternalAadl2Parser
    public final void synpred36_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4347:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4347:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred36_InternalAadl2Parser9034); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalAadl2Parser

    // $ANTLR start synpred37_InternalAadl2Parser
    public final void synpred37_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4677:3: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4677:4: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred37_InternalAadl2Parser9755); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalAadl2Parser

    // $ANTLR start synpred38_InternalAadl2Parser
    public final void synpred38_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4824:4: ( RULE_LCURLY )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:4824:5: RULE_LCURLY
        {
        match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_synpred38_InternalAadl2Parser10036); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalAadl2Parser

    // $ANTLR start synpred39_InternalAadl2Parser
    public final void synpred39_InternalAadl2Parser_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5200:3: ( KEYWORD_29 )
        // ../org.osate.xtext.aadl2/src-gen/org/osate/xtext/aadl2/parser/antlr/internal/InternalAadl2Parser.g:5201:1: KEYWORD_29
        {
        match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_synpred39_InternalAadl2Parser10917); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalAadl2Parser

    // Delegated rules

    public final boolean synpred35_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalAadl2Parser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalAadl2Parser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA107 dfa107 = new DFA107(this);
    protected DFA117 dfa117 = new DFA117(this);
    protected DFA119 dfa119 = new DFA119(this);
    protected DFA121 dfa121 = new DFA121(this);
    static final String DFA12_eotS =
        "\20\uffff";
    static final String DFA12_eofS =
        "\12\uffff\1\14\5\uffff";
    static final String DFA12_minS =
        "\1\11\11\uffff\1\44\1\13\4\uffff";
    static final String DFA12_maxS =
        "\1\57\11\uffff\1\111\1\57\4\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\2\uffff\1\13\1\12"+
        "\1\15\1\14";
    static final String DFA12_specialS =
        "\20\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\10\1\uffff\1\7\1\1\12\uffff\1\6\1\uffff\1\13\1\uffff\1\4"+
            "\1\5\2\uffff\1\11\1\12\5\uffff\1\3\10\uffff\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\23\uffff\1\14\12\uffff\1\14\1\uffff\1\14\3\uffff\1\14",
            "\1\16\43\uffff\1\17",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "530:1: (kw= KEYWORD_39 | kw= KEYWORD_7 | kw= KEYWORD_10 | kw= KEYWORD_23 | kw= KEYWORD_24 | kw= KEYWORD_36 | kw= KEYWORD_44 | (kw= KEYWORD_47 kw= KEYWORD_20 ) | kw= KEYWORD_27 | (kw= KEYWORD_28 kw= KEYWORD_20 ) | kw= KEYWORD_28 | (kw= KEYWORD_38 kw= KEYWORD_7 ) | (kw= KEYWORD_38 kw= KEYWORD_44 ) )";
        }
    }
    static final String DFA16_eotS =
        "\13\uffff";
    static final String DFA16_eofS =
        "\13\uffff";
    static final String DFA16_minS =
        "\1\7\1\uffff\1\76\1\61\2\42\1\46\1\42\3\uffff";
    static final String DFA16_maxS =
        "\1\111\1\uffff\1\76\1\63\1\61\1\46\1\52\1\46\3\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\4\6\uffff\1\1\1\3\1\2";
    static final String DFA16_specialS =
        "\13\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1\31\uffff\1\1\1\uffff\1\1\1\uffff\1\1\12\uffff\1\1\10\uffff"+
            "\1\1\17\uffff\1\2",
            "",
            "\1\3",
            "\1\5\1\uffff\1\4",
            "\1\6\3\uffff\1\10\12\uffff\1\7",
            "\1\6\3\uffff\1\10",
            "\1\11\3\uffff\1\12",
            "\1\6\3\uffff\1\10",
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
            return "()+ loopback of 758:6: ( ( (lv_ownedDataPort_7_0= ruleDataPort ) ) | ( (lv_ownedEventPort_8_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_9_0= ruleEventDataPort ) ) )+";
        }
    }
    static final String DFA28_eotS =
        "\13\uffff";
    static final String DFA28_eofS =
        "\13\uffff";
    static final String DFA28_minS =
        "\1\7\1\uffff\1\76\1\61\3\42\1\uffff\1\46\2\uffff";
    static final String DFA28_maxS =
        "\1\111\1\uffff\1\76\1\63\1\61\2\46\1\uffff\1\52\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\4\5\uffff\1\1\1\uffff\1\3\1\2";
    static final String DFA28_specialS =
        "\13\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1\31\uffff\1\1\1\uffff\1\1\1\uffff\1\1\12\uffff\1\1\10\uffff"+
            "\1\1\17\uffff\1\2",
            "",
            "\1\3",
            "\1\5\1\uffff\1\4",
            "\1\10\3\uffff\1\7\12\uffff\1\6",
            "\1\10\3\uffff\1\7",
            "\1\10\3\uffff\1\7",
            "",
            "\1\11\3\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1070:6: ( ( (lv_ownedDataPort_4_0= ruleDataPort ) ) | ( (lv_ownedEventPort_5_0= ruleEventPort ) ) | ( (lv_ownedEventDataPort_6_0= ruleEventDataPort ) ) )+";
        }
    }
    static final String DFA107_eotS =
        "\15\uffff";
    static final String DFA107_eofS =
        "\15\uffff";
    static final String DFA107_minS =
        "\1\111\1\76\1\30\1\36\1\65\3\uffff\1\47\1\36\3\uffff";
    static final String DFA107_maxS =
        "\1\111\1\76\1\47\1\53\1\65\3\uffff\1\47\1\53\3\uffff";
    static final String DFA107_acceptS =
        "\5\uffff\1\1\1\3\1\2\2\uffff\1\5\1\6\1\4";
    static final String DFA107_specialS =
        "\15\uffff}>";
    static final String[] DFA107_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\16\uffff\1\3",
            "\1\5\12\uffff\1\6\1\uffff\1\7",
            "\1\10",
            "",
            "",
            "",
            "\1\11",
            "\1\14\12\uffff\1\13\1\uffff\1\12",
            "",
            "",
            ""
    };

    static final short[] DFA107_eot = DFA.unpackEncodedString(DFA107_eotS);
    static final short[] DFA107_eof = DFA.unpackEncodedString(DFA107_eofS);
    static final char[] DFA107_min = DFA.unpackEncodedStringToUnsignedChars(DFA107_minS);
    static final char[] DFA107_max = DFA.unpackEncodedStringToUnsignedChars(DFA107_maxS);
    static final short[] DFA107_accept = DFA.unpackEncodedString(DFA107_acceptS);
    static final short[] DFA107_special = DFA.unpackEncodedString(DFA107_specialS);
    static final short[][] DFA107_transition;

    static {
        int numStates = DFA107_transitionS.length;
        DFA107_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA107_transition[i] = DFA.unpackEncodedString(DFA107_transitionS[i]);
        }
    }

    class DFA107 extends DFA {

        public DFA107(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 107;
            this.eot = DFA107_eot;
            this.eof = DFA107_eof;
            this.min = DFA107_min;
            this.max = DFA107_max;
            this.accept = DFA107_accept;
            this.special = DFA107_special;
            this.transition = DFA107_transition;
        }
        public String getDescription() {
            return "3638:2: (this_FlowSourceSpec_0= ruleFlowSourceSpec | this_FlowSinkSpec_1= ruleFlowSinkSpec | this_FlowPathSpec_2= ruleFlowPathSpec | this_FlowSourceSpecRefinement_3= ruleFlowSourceSpecRefinement | this_FlowSinkSpecRefinement_4= ruleFlowSinkSpecRefinement | this_FlowPathSpecRefinement_5= ruleFlowPathSpecRefinement )";
        }
    }
    static final String DFA117_eotS =
        "\10\uffff";
    static final String DFA117_eofS =
        "\1\2\7\uffff";
    static final String DFA117_minS =
        "\1\63\1\111\1\uffff\1\107\1\70\1\106\1\0\1\uffff";
    static final String DFA117_maxS =
        "\1\105\1\111\1\uffff\1\107\1\70\1\111\1\0\1\uffff";
    static final String DFA117_acceptS =
        "\2\uffff\1\2\4\uffff\1\1";
    static final String DFA117_specialS =
        "\6\uffff\1\0\1\uffff}>";
    static final String[] DFA117_transitionS = {
            "\1\2\4\uffff\1\2\14\uffff\1\1",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6\2\uffff\1\3",
            "\1\uffff",
            ""
    };

    static final short[] DFA117_eot = DFA.unpackEncodedString(DFA117_eotS);
    static final short[] DFA117_eof = DFA.unpackEncodedString(DFA117_eofS);
    static final char[] DFA117_min = DFA.unpackEncodedStringToUnsignedChars(DFA117_minS);
    static final char[] DFA117_max = DFA.unpackEncodedStringToUnsignedChars(DFA117_maxS);
    static final short[] DFA117_accept = DFA.unpackEncodedString(DFA117_acceptS);
    static final short[] DFA117_special = DFA.unpackEncodedString(DFA117_specialS);
    static final short[][] DFA117_transition;

    static {
        int numStates = DFA117_transitionS.length;
        DFA117_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA117_transition[i] = DFA.unpackEncodedString(DFA117_transitionS[i]);
        }
    }

    class DFA117 extends DFA {

        public DFA117(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 117;
            this.eot = DFA117_eot;
            this.eof = DFA117_eof;
            this.min = DFA117_min;
            this.max = DFA117_max;
            this.accept = DFA117_accept;
            this.special = DFA117_special;
            this.transition = DFA117_transition;
        }
        public String getDescription() {
            return "4153:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA117_6 = input.LA(1);

                         
                        int index117_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalAadl2Parser()) ) {s = 7;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index117_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 117, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA119_eotS =
        "\10\uffff";
    static final String DFA119_eofS =
        "\1\2\7\uffff";
    static final String DFA119_minS =
        "\1\63\1\111\1\uffff\1\107\1\70\1\106\1\0\1\uffff";
    static final String DFA119_maxS =
        "\1\105\1\111\1\uffff\1\107\1\70\1\111\1\0\1\uffff";
    static final String DFA119_acceptS =
        "\2\uffff\1\2\4\uffff\1\1";
    static final String DFA119_specialS =
        "\6\uffff\1\0\1\uffff}>";
    static final String[] DFA119_transitionS = {
            "\1\2\4\uffff\1\2\14\uffff\1\1",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6\2\uffff\1\3",
            "\1\uffff",
            ""
    };

    static final short[] DFA119_eot = DFA.unpackEncodedString(DFA119_eotS);
    static final short[] DFA119_eof = DFA.unpackEncodedString(DFA119_eofS);
    static final char[] DFA119_min = DFA.unpackEncodedStringToUnsignedChars(DFA119_minS);
    static final char[] DFA119_max = DFA.unpackEncodedStringToUnsignedChars(DFA119_maxS);
    static final short[] DFA119_accept = DFA.unpackEncodedString(DFA119_acceptS);
    static final short[] DFA119_special = DFA.unpackEncodedString(DFA119_specialS);
    static final short[][] DFA119_transition;

    static {
        int numStates = DFA119_transitionS.length;
        DFA119_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA119_transition[i] = DFA.unpackEncodedString(DFA119_transitionS[i]);
        }
    }

    class DFA119 extends DFA {

        public DFA119(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 119;
            this.eot = DFA119_eot;
            this.eof = DFA119_eof;
            this.min = DFA119_min;
            this.max = DFA119_max;
            this.accept = DFA119_accept;
            this.special = DFA119_special;
            this.transition = DFA119_transition;
        }
        public String getDescription() {
            return "4250:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA119_6 = input.LA(1);

                         
                        int index119_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalAadl2Parser()) ) {s = 7;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index119_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 119, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA121_eotS =
        "\10\uffff";
    static final String DFA121_eofS =
        "\1\2\7\uffff";
    static final String DFA121_minS =
        "\1\63\1\111\1\uffff\1\107\1\70\1\106\1\0\1\uffff";
    static final String DFA121_maxS =
        "\1\105\1\111\1\uffff\1\107\1\70\1\111\1\0\1\uffff";
    static final String DFA121_acceptS =
        "\2\uffff\1\2\4\uffff\1\1";
    static final String DFA121_specialS =
        "\6\uffff\1\0\1\uffff}>";
    static final String[] DFA121_transitionS = {
            "\1\2\4\uffff\1\2\14\uffff\1\1",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6\2\uffff\1\3",
            "\1\uffff",
            ""
    };

    static final short[] DFA121_eot = DFA.unpackEncodedString(DFA121_eotS);
    static final short[] DFA121_eof = DFA.unpackEncodedString(DFA121_eofS);
    static final char[] DFA121_min = DFA.unpackEncodedStringToUnsignedChars(DFA121_minS);
    static final char[] DFA121_max = DFA.unpackEncodedStringToUnsignedChars(DFA121_maxS);
    static final short[] DFA121_accept = DFA.unpackEncodedString(DFA121_acceptS);
    static final short[] DFA121_special = DFA.unpackEncodedString(DFA121_specialS);
    static final short[][] DFA121_transition;

    static {
        int numStates = DFA121_transitionS.length;
        DFA121_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA121_transition[i] = DFA.unpackEncodedString(DFA121_transitionS[i]);
        }
    }

    class DFA121 extends DFA {

        public DFA121(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 121;
            this.eot = DFA121_eot;
            this.eof = DFA121_eof;
            this.min = DFA121_min;
            this.max = DFA121_max;
            this.accept = DFA121_accept;
            this.special = DFA121_special;
            this.transition = DFA121_transition;
        }
        public String getDescription() {
            return "4347:2: ( ( ( RULE_LCURLY )=>this_LCURLY_6= RULE_LCURLY ) ( (lv_ownedPropertyAssociation_7_0= rulePropertyAssociation ) )+ this_RCURLY_8= RULE_RCURLY )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA121_6 = input.LA(1);

                         
                        int index121_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalAadl2Parser()) ) {s = 7;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index121_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 121, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleAadlPackage_in_entryRuleAadlPackage67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlPackage77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_ruleAadlPackage115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePNAME_in_ruleAadlPackage135 = new BitSet(new long[]{0x0000000020400000L});
    public static final BitSet FOLLOW_rulePublicPackageSection_in_ruleAadlPackage158 = new BitSet(new long[]{0x0001000020400080L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage179 = new BitSet(new long[]{0x0001000000000080L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_ruleAadlPackage208 = new BitSet(new long[]{0x0001000000000080L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleAadlPackage230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleAadlPackage251 = new BitSet(new long[]{0x0001000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleAadlPackage267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlPackage277 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleAadlPackage290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlPackage300 = new BitSet(new long[]{0x0104000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleAadlPackage312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePublicPackageSection_in_entryRulePublicPackageSection346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePublicPackageSection356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_25_in_rulePublicPackageSection403 = new BitSet(new long[]{0x0000104080000802L});
    public static final BitSet FOLLOW_KEYWORD_16_in_rulePublicPackageSection423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePublicPackageSection446 = new BitSet(new long[]{0x8100000000000000L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePublicPackageSection458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePublicPackageSection480 = new BitSet(new long[]{0x8100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePublicPackageSection493 = new BitSet(new long[]{0x0000104080000802L});
    public static final BitSet FOLLOW_ruleSystemType_in_rulePublicPackageSection516 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_rulePublicPackageSection543 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleProcessorType_in_rulePublicPackageSection570 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleDataType_in_rulePublicPackageSection597 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_rulePrivatePackageSection_in_entryRulePrivatePackageSection634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrivatePackageSection644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_rulePrivatePackageSection691 = new BitSet(new long[]{0x0000104080000802L});
    public static final BitSet FOLLOW_KEYWORD_16_in_rulePrivatePackageSection711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePrivatePackageSection734 = new BitSet(new long[]{0x8100000000000000L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePrivatePackageSection746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePNAME_in_rulePrivatePackageSection768 = new BitSet(new long[]{0x8100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePrivatePackageSection781 = new BitSet(new long[]{0x0000104080000802L});
    public static final BitSet FOLLOW_ruleSystemType_in_rulePrivatePackageSection804 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_rulePrivatePackageSection831 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleProcessorType_in_rulePrivatePackageSection858 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleDataType_in_rulePrivatePackageSection885 = new BitSet(new long[]{0x0000004080000802L});
    public static final BitSet FOLLOW_ruleComponentCategoryKW_in_entryRuleComponentCategoryKW927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategoryKW938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_ruleComponentCategoryKW976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleComponentCategoryKW995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleComponentCategoryKW1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleComponentCategoryKW1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_24_in_ruleComponentCategoryKW1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleComponentCategoryKW1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleComponentCategoryKW1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleComponentCategoryKW1110 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleComponentCategoryKW1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleComponentCategoryKW1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleComponentCategoryKW1163 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleComponentCategoryKW1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleComponentCategoryKW1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleComponentCategoryKW1216 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleComponentCategoryKW1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleComponentCategoryKW1250 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleComponentCategoryKW1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemType_in_entryRuleSystemType1303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemType1313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleSystemType1351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemType1367 = new BitSet(new long[]{0x0201002A00002180L});
    public static final BitSet FOLLOW_KEYWORD_46_in_ruleSystemType1393 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType1411 = new BitSet(new long[]{0x0201002A00002080L});
    public static final BitSet FOLLOW_rulePrototype_in_ruleSystemType1443 = new BitSet(new long[]{0x0201002A00002080L,0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleSystemType1468 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType1486 = new BitSet(new long[]{0x0201002A00000080L});
    public static final BitSet FOLLOW_ruleDataPort_in_ruleSystemType1519 = new BitSet(new long[]{0x0201002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleEventPort_in_ruleSystemType1546 = new BitSet(new long[]{0x0201002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_ruleSystemType1573 = new BitSet(new long[]{0x0201002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleSystemType1599 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleSystemType1621 = new BitSet(new long[]{0x0201002200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType1645 = new BitSet(new long[]{0x0201002200000080L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleSystemType1675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleMode_in_ruleSystemType1697 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleSystemType1724 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType1750 = new BitSet(new long[]{0x0001000200000080L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleSystemType1778 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleSystemType1800 = new BitSet(new long[]{0x0001000200000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemType1824 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleSystemType1853 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleSystemType1867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemType1877 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemType1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorType_in_entryRuleProcessorType1925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcessorType1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleProcessorType1973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorType1989 = new BitSet(new long[]{0x0201002A00002080L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleProcessorType2015 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2033 = new BitSet(new long[]{0x0201002A00000080L});
    public static final BitSet FOLLOW_ruleDataPort_in_ruleProcessorType2066 = new BitSet(new long[]{0x0201002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleEventPort_in_ruleProcessorType2093 = new BitSet(new long[]{0x0201002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_ruleProcessorType2120 = new BitSet(new long[]{0x0201002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleProcessorType2146 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleProcessorType2168 = new BitSet(new long[]{0x0201002200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2192 = new BitSet(new long[]{0x0201002200000080L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleProcessorType2222 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleMode_in_ruleProcessorType2244 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleProcessorType2271 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2297 = new BitSet(new long[]{0x0001000200000080L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleProcessorType2325 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleProcessorType2347 = new BitSet(new long[]{0x0001000200000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleProcessorType2371 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleProcessorType2400 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleProcessorType2414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorType2424 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleProcessorType2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataType_in_entryRuleDataType2468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataType2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleDataType2516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType2532 = new BitSet(new long[]{0x0201002A00002080L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleDataType2558 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType2575 = new BitSet(new long[]{0x0201002A00000080L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleDataType2603 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_ruleDataType2625 = new BitSet(new long[]{0x0201002200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType2649 = new BitSet(new long[]{0x0201002200000080L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleDataType2679 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleMode_in_ruleDataType2701 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleDataType2728 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType2754 = new BitSet(new long[]{0x0001000200000080L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleDataType2782 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleDataType2804 = new BitSet(new long[]{0x0001000200000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleDataType2828 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleDataType2857 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleDataType2871 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataType2881 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataType2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemImplementation_in_entryRuleSystemImplementation2925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemImplementation2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleSystemImplementation2982 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleSystemImplementation2994 = new BitSet(new long[]{0x0001002A000000E0L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleSystemImplementation3014 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_ruleSystemImplementation3037 = new BitSet(new long[]{0x0001002A000000C0L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_ruleSystemImplementation3064 = new BitSet(new long[]{0x0001002A000000C0L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_ruleSystemImplementation3091 = new BitSet(new long[]{0x0001002A000000C0L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3116 = new BitSet(new long[]{0x0001002A000000C0L});
    public static final BitSet FOLLOW_KEYWORD_48_in_ruleSystemImplementation3145 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePortConnection_in_ruleSystemImplementation3167 = new BitSet(new long[]{0x0001002A00000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3191 = new BitSet(new long[]{0x0001002A00000080L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleSystemImplementation3220 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3237 = new BitSet(new long[]{0x0001002200000080L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleSystemImplementation3265 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleMode_in_ruleSystemImplementation3288 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeTransition_in_ruleSystemImplementation3315 = new BitSet(new long[]{0x0001000200000080L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3340 = new BitSet(new long[]{0x0001000200000080L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleSystemImplementation3369 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleSystemImplementation3391 = new BitSet(new long[]{0x0001000200000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_NONE_in_ruleSystemImplementation3415 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_ruleSystemImplementation3444 = new BitSet(new long[]{0x0001000200000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleSystemImplementation3458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemImplementation3468 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSystemImplementation3478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleINAME_in_ruleSystemImplementation3493 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemImplementation3503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrototype_in_entryRulePrototype3541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrototype3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentPrototype_in_rulePrototype3599 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFeatureGroupPrototype_in_rulePrototype3626 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFeaturePrototype_in_rulePrototype3653 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_rulePrototype3670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_rulePrototype3691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_rulePrototype3703 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePrototype3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentPrototype_in_entryRuleComponentPrototype3749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentPrototype3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentPrototype3801 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleComponentPrototype3817 = new BitSet(new long[]{0x000080419B801A00L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleComponentPrototype3830 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleComponentPrototype3842 = new BitSet(new long[]{0x000080419B801A00L});
    public static final BitSet FOLLOW_ruleComponentCategoryKW_in_ruleComponentPrototype3864 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000208L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentPrototype3887 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_LBRACKET_in_ruleComponentPrototype3906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_RBRACKET_in_ruleComponentPrototype3922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroupPrototype_in_entryRuleFeatureGroupPrototype3958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureGroupPrototype3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureGroupPrototype4010 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFeatureGroupPrototype4026 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleFeatureGroupPrototype4039 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleFeatureGroupPrototype4051 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleFeatureGroupPrototype4065 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleFeatureGroupPrototype4077 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeatureGroupPrototype4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeaturePrototype_in_entryRuleFeaturePrototype4135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeaturePrototype4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeaturePrototype4187 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFeaturePrototype4203 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleFeaturePrototype4216 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleFeaturePrototype4228 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleFeaturePrototype4242 = new BitSet(new long[]{0x000A000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleInOutDirection_in_ruleFeaturePrototype4262 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleFeaturePrototype4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSubcomponent_in_entryRuleSystemSubcomponent4322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemSubcomponent4332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemSubcomponent4374 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleSystemSubcomponent4390 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleSystemSubcomponent4402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleSystemSubcomponent4424 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleSystemSubcomponent4441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleSystemSubcomponent4462 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleSystemSubcomponent4474 = new BitSet(new long[]{0x0108000000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleSystemSubcomponent4496 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleSystemSubcomponent4509 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleSystemSubcomponent4519 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleSystemSubcomponent4540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleSystemSubcomponent4566 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleSystemSubcomponent4589 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleSystemSubcomponent4601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProcessorSubcomponent_in_entryRuleProcessorSubcomponent4635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProcessorSubcomponent4645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProcessorSubcomponent4687 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleProcessorSubcomponent4703 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleProcessorSubcomponent4715 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleProcessorSubcomponent4737 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleProcessorSubcomponent4755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleProcessorSubcomponent4776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleProcessorSubcomponent4788 = new BitSet(new long[]{0x0108000000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleProcessorSubcomponent4810 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleProcessorSubcomponent4823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleProcessorSubcomponent4833 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleProcessorSubcomponent4854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleProcessorSubcomponent4880 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleProcessorSubcomponent4903 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleProcessorSubcomponent4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataSubcomponent_in_entryRuleDataSubcomponent4949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataSubcomponent4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataSubcomponent5001 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleDataSubcomponent5017 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleDataSubcomponent5029 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleDataSubcomponent5051 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleDataSubcomponent5069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleDataSubcomponent5090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleDataSubcomponent5102 = new BitSet(new long[]{0x0108000000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleDataSubcomponent5124 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleDataSubcomponent5137 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleDataSubcomponent5147 = new BitSet(new long[]{0x0000400000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleModeRef_in_ruleDataSubcomponent5168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleDataSubcomponent5194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleDataSubcomponent5217 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataSubcomponent5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataPort_in_entryRuleDataPort5263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataPort5273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDataPort5315 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleDataPort5331 = new BitSet(new long[]{0x000A000000000000L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleDataPort5351 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleDataPort5364 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleDataPort5376 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleDataPort5398 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleDataPort5416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleDataPort5437 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleDataPort5449 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDataPort5461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventDataPort_in_entryRuleEventDataPort5495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventDataPort5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventDataPort5547 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleEventDataPort5563 = new BitSet(new long[]{0x000A000000000000L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleEventDataPort5583 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_18_in_ruleEventDataPort5596 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleEventDataPort5608 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleEventDataPort5620 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleEventDataPort5642 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleEventDataPort5660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleEventDataPort5681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleEventDataPort5693 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEventDataPort5705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventPort_in_entryRuleEventPort5739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventPort5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEventPort5791 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleEventPort5807 = new BitSet(new long[]{0x000A000000000000L});
    public static final BitSet FOLLOW_rulePortDirection_in_ruleEventPort5827 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_18_in_ruleEventPort5840 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleEventPort5852 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleEventPort5868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_ruleEventPort5889 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleEventPort5901 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEventPort5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortDirection_in_entryRulePortDirection5962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortDirection5973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rulePortDirection6011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_rulePortDirection6030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_rulePortDirection6050 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYWORD_9_in_rulePortDirection6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInOutDirection_in_entryRuleInOutDirection6104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInOutDirection6115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleInOutDirection6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleInOutDirection6172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessDirection_in_entryRuleAccessDirection6212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessDirection6223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_42_in_ruleAccessDirection6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_ruleAccessDirection6280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortConnection_in_entryRulePortConnection6321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortConnection6331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6373 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_rulePortConnection6389 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rulePortConnectionKind_in_rulePortConnection6409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_rulePortConnection6441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6462 = new BitSet(new long[]{0x1000200000000000L});
    public static final BitSet FOLLOW_RULE_ARROW_in_rulePortConnection6474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_5_in_rulePortConnection6498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6531 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_rulePortConnection6542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortConnection6563 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePortConnection6574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortConnectionKind_in_entryRulePortConnectionKind6619 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortConnectionKind6630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_rulePortConnectionKind6667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessConnectionKind_in_entryRuleAccessConnectionKind6706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessConnectionKind6717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleAccessConnectionKind6754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureGroupConnectionKind_in_entryRuleFeatureGroupConnectionKind6793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureGroupConnectionKind6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleFeatureGroupConnectionKind6842 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleFeatureGroupConnectionKind6855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureConnectionKind_in_entryRuleFeatureConnectionKind6895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureConnectionKind6906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleFeatureConnectionKind6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterConnectionKind_in_entryRuleParameterConnectionKind6982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterConnectionKind6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleParameterConnectionKind7030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessCategory_in_entryRuleAccessCategory7069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessCategory7080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleAccessCategory7118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleAccessCategory7137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleAccessCategory7156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleAccessCategory7176 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleAccessCategory7189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSource_in_entryRuleFlowSource7232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSource7243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_ruleFlowSource7280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSink_in_entryRuleFlowSink7319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSink7330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_15_in_ruleFlowSink7367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPath_in_entryRuleFlowPath7406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowPath7417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleFlowPath7454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecification_in_entryRuleFlowSpecification7492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecification7502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSourceSpec_in_ruleFlowSpecification7550 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFlowSinkSpec_in_ruleFlowSpecification7577 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFlowPathSpec_in_ruleFlowSpecification7604 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFlowSourceSpecRefinement_in_ruleFlowSpecification7631 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFlowSinkSpecRefinement_in_ruleFlowSpecification7658 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleFlowPathSpecRefinement_in_ruleFlowSpecification7685 = new BitSet(new long[]{0x0108000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleFlowSpecification7702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleFlowSpecification7723 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleFlowSpecification7735 = new BitSet(new long[]{0x0108000000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleFlowSpecification7757 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleFlowSpecification7770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleFlowSpecification7780 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecification7799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleFlowSpecification7811 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFlowSpecification7823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSourceSpec_in_entryRuleFlowSourceSpec7857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSourceSpec7867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceSpec7909 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSourceSpec7925 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowSourceSpec7937 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleFlowSource_in_ruleFlowSourceSpec7957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceSpec7978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleFlowSourceSpec7989 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceSpec8010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSinkSpec_in_entryRuleFlowSinkSpec8045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSinkSpec8055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkSpec8097 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSinkSpec8113 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowSinkSpec8125 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFlowSink_in_ruleFlowSinkSpec8145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkSpec8166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleFlowSinkSpec8177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkSpec8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPathSpec_in_entryRuleFlowPathSpec8233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowPathSpec8243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec8285 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowPathSpec8301 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowPathSpec8313 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFlowPath_in_ruleFlowPathSpec8333 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec8354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleFlowPathSpec8365 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec8386 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RULE_ARROW_in_ruleFlowPathSpec8397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec8417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleFlowPathSpec8428 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpec8449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSourceSpecRefinement_in_entryRuleFlowSourceSpecRefinement8484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSourceSpecRefinement8494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceSpecRefinement8539 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSourceSpecRefinement8550 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleFlowSourceSpecRefinement8562 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleFlowSourceSpecRefinement8574 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowSourceSpecRefinement8586 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleFlowSource_in_ruleFlowSourceSpecRefinement8606 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleFlowSourceSpecRefinement8623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleFlowSourceSpecRefinement8644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleFlowSourceSpecRefinement8656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSinkSpecRefinement_in_entryRuleFlowSinkSpecRefinement8692 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSinkSpecRefinement8702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkSpecRefinement8747 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSinkSpecRefinement8758 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleFlowSinkSpecRefinement8770 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleFlowSinkSpecRefinement8782 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowSinkSpecRefinement8794 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFlowSink_in_ruleFlowSinkSpecRefinement8814 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleFlowSinkSpecRefinement8831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleFlowSinkSpecRefinement8852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleFlowSinkSpecRefinement8864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPathSpecRefinement_in_entryRuleFlowPathSpecRefinement8900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowPathSpecRefinement8910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathSpecRefinement8955 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowPathSpecRefinement8966 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleFlowPathSpecRefinement8978 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleFlowPathSpecRefinement8990 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowPathSpecRefinement9002 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFlowPath_in_ruleFlowPathSpecRefinement9022 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleFlowPathSpecRefinement9039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleFlowPathSpecRefinement9060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleFlowPathSpecRefinement9072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSourceImpl_in_entryRuleFlowSourceImpl9110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSourceImpl9120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSourceImpl9165 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSourceImpl9176 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowSourceImpl9188 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleFlowSource_in_ruleFlowSourceImpl9208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSinkImpl_in_entryRuleFlowSinkImpl9243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSinkImpl9253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSinkImpl9298 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowSinkImpl9309 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowSinkImpl9321 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFlowSink_in_ruleFlowSinkImpl9341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowPathImpl_in_entryRuleFlowPathImpl9376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowPathImpl9386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowPathImpl9431 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleFlowPathImpl9442 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleFlowPathImpl9454 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleFlowPath_in_ruleFlowPathImpl9474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubcomponentFlow_in_entryRuleSubcomponentFlow9513 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubcomponentFlow9523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubcomponentFlow9568 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleSubcomponentFlow9579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubcomponentFlow9598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMode_in_entryRuleMode9633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMode9643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMode9685 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleMode9701 = new BitSet(new long[]{0x0000010000080000L});
    public static final BitSet FOLLOW_KEYWORD_32_in_ruleMode9719 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleMode9744 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleMode9760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleMode9781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleMode9793 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleMode9805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransition_in_entryRuleModeTransition9839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransition9849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition9892 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleModeTransition9908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition9929 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_RULE_LTRANS_in_ruleModeTransition9940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_ruleModeTransition9960 = new BitSet(new long[]{0x8800000000000000L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleModeTransition9972 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_ruleModeTransition9992 = new BitSet(new long[]{0x8800000000000000L});
    public static final BitSet FOLLOW_RULE_RTRANS_in_ruleModeTransition10005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransition10024 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleModeTransition10041 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleModeTransition10062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleModeTransition10074 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleModeTransition10086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerPort_in_entryRuleTriggerPort10120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerPort10130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggerPort10176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleTriggerPort10187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggerPort10208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeRef_in_entryRuleModeRef10243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeRef10253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeRef10298 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_RULE_ARROW_in_ruleModeRef10310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeRef10329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexLibrary_in_entryRuleDefaultAnnexLibrary10368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultAnnexLibrary10378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_17_in_ruleDefaultAnnexLibrary10416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefaultAnnexLibrary10432 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexLibrary10454 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDefaultAnnexLibrary10470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnexSubclause_in_entryRuleAnnexSubclause10504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnexSubclause10514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexSubclause_in_ruleAnnexSubclause10560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefaultAnnexSubclause_in_entryRuleDefaultAnnexSubclause10593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefaultAnnexSubclause10603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_17_in_ruleDefaultAnnexSubclause10641 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefaultAnnexSubclause10657 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_ANNEXTEXT_in_ruleDefaultAnnexSubclause10679 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDefaultAnnexSubclause10695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_entryRulePropertyAssociation10729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociation10739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociation10784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASSIGN_in_rulePropertyAssociation10795 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePropertyAssociation10805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation10839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainedPropertyAssociation10849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainedPropertyAssociation10894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASSIGN_in_ruleContainedPropertyAssociation10905 = new BitSet(new long[]{0x0100000000010000L});
    public static final BitSet FOLLOW_KEYWORD_29_in_ruleContainedPropertyAssociation10925 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleContainedPropertyAssociation10938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation10958 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleContainedPropertyAssociation10971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath11005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPath11015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath11070 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleContainmentPath11082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath11102 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement11139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement11149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentPathElement11194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement11215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange11250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange11260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LBRACKET_in_ruleArrayRange11305 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_RBRACKET_in_ruleArrayRange11315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePNAME_in_entryRulePNAME11354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePNAME11365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePNAME11405 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_rulePNAME11424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePNAME11439 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME11488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME11499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME11538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF11582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF11593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF11634 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleQCREF11652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF11669 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleQCREF11690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF11710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred1_InternalAadl2Parser222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_16_in_synpred2_InternalAadl2Parser415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_16_in_synpred3_InternalAadl2Parser703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_synpred4_InternalAadl2Parser1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred5_InternalAadl2Parser1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_19_in_synpred6_InternalAadl2Parser1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred7_InternalAadl2Parser1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred8_InternalAadl2Parser1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred9_InternalAadl2Parser2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_19_in_synpred10_InternalAadl2Parser2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred11_InternalAadl2Parser2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred12_InternalAadl2Parser2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred13_InternalAadl2Parser2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_19_in_synpred14_InternalAadl2Parser2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred15_InternalAadl2Parser2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred16_InternalAadl2Parser2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_synpred17_InternalAadl2Parser3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_synpred18_InternalAadl2Parser3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_19_in_synpred19_InternalAadl2Parser3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred20_InternalAadl2Parser3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred21_InternalAadl2Parser3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred22_InternalAadl2Parser3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred23_InternalAadl2Parser4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_synpred24_InternalAadl2Parser4488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred25_InternalAadl2Parser4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_synpred26_InternalAadl2Parser4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred27_InternalAadl2Parser5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_synpred28_InternalAadl2Parser5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred29_InternalAadl2Parser5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred30_InternalAadl2Parser5655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred31_InternalAadl2Parser5863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred32_InternalAadl2Parser7697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_2_in_synpred33_InternalAadl2Parser7749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred34_InternalAadl2Parser8618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred35_InternalAadl2Parser8826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred36_InternalAadl2Parser9034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred37_InternalAadl2Parser9755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_synpred38_InternalAadl2Parser10036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_synpred39_InternalAadl2Parser10917 = new BitSet(new long[]{0x0000000000000002L});

}