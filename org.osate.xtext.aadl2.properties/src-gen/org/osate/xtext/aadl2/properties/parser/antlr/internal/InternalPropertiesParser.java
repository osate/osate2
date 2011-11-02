package org.osate.xtext.aadl2.properties.parser.antlr.internal; 

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
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalPropertiesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_31", "KEYWORD_30", "KEYWORD_29", "KEYWORD_27", "KEYWORD_28", "KEYWORD_23", "KEYWORD_24", "KEYWORD_25", "KEYWORD_26", "KEYWORD_22", "KEYWORD_19", "KEYWORD_20", "KEYWORD_21", "KEYWORD_13", "KEYWORD_14", "KEYWORD_15", "KEYWORD_16", "KEYWORD_17", "KEYWORD_18", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_12", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int RULE_ID=44;
    public static final int RULE_REAL_LIT=39;
    public static final int RULE_INTEGER_LIT=41;
    public static final int KEYWORD_19=14;
    public static final int KEYWORD_17=21;
    public static final int KEYWORD_18=22;
    public static final int KEYWORD_15=19;
    public static final int KEYWORD_16=20;
    public static final int KEYWORD_13=17;
    public static final int KEYWORD_14=18;
    public static final int KEYWORD_11=33;
    public static final int KEYWORD_12=34;
    public static final int EOF=-1;
    public static final int KEYWORD_10=32;
    public static final int KEYWORD_6=28;
    public static final int KEYWORD_7=29;
    public static final int KEYWORD_8=30;
    public static final int KEYWORD_9=31;
    public static final int KEYWORD_28=8;
    public static final int KEYWORD_29=6;
    public static final int KEYWORD_24=10;
    public static final int KEYWORD_25=11;
    public static final int KEYWORD_26=12;
    public static final int KEYWORD_27=7;
    public static final int KEYWORD_20=15;
    public static final int KEYWORD_21=16;
    public static final int KEYWORD_22=13;
    public static final int KEYWORD_23=9;
    public static final int RULE_EXTENDED_DIGIT=42;
    public static final int KEYWORD_30=5;
    public static final int KEYWORD_1=23;
    public static final int KEYWORD_5=27;
    public static final int KEYWORD_4=26;
    public static final int KEYWORD_3=25;
    public static final int KEYWORD_31=4;
    public static final int KEYWORD_2=24;
    public static final int RULE_BASED_INTEGER=40;
    public static final int RULE_SL_COMMENT=35;
    public static final int RULE_STRING=43;
    public static final int RULE_EXPONENT=37;
    public static final int RULE_INT_EXPONENT=38;
    public static final int RULE_WS=45;
    public static final int RULE_DIGIT=36;

    // delegates
    // delegators


        public InternalPropertiesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPropertiesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPropertiesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

    	private PropertiesGrammarAccess grammarAccess;
    	 	
    	public InternalPropertiesParser(TokenStream input, PropertiesGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "PModel";	
    	} 
    	   	   	
    	@Override
    	protected PropertiesGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRulePModel"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:68:1: entryRulePModel returns [EObject current=null] : iv_rulePModel= rulePModel EOF ;
    public final EObject entryRulePModel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePModel = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:69:2: (iv_rulePModel= rulePModel EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:70:2: iv_rulePModel= rulePModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePModel_in_entryRulePModel73);
            iv_rulePModel=rulePModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePModel83); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePModel"


    // $ANTLR start "rulePModel"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:77:1: rulePModel returns [EObject current=null] : (this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation | this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation | this_PropertyAssociation_2= rulePropertyAssociation ) ;
    public final EObject rulePModel() throws RecognitionException {
        EObject current = null;

        EObject this_ContainedPropertyAssociation_0 = null;

        EObject this_BasicPropertyAssociation_1 = null;

        EObject this_PropertyAssociation_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:80:28: ( (this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation | this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation | this_PropertyAssociation_2= rulePropertyAssociation ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:81:1: (this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation | this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation | this_PropertyAssociation_2= rulePropertyAssociation )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:81:1: (this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation | this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation | this_PropertyAssociation_2= rulePropertyAssociation )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1_InternalPropertiesParser()) ) {
                    alt1=1;
                }
                else if ( (synpred2_InternalPropertiesParser()) ) {
                    alt1=2;
                }
                else if ( (true) ) {
                    alt1=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:82:2: this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPModelAccess().getContainedPropertyAssociationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleContainedPropertyAssociation_in_rulePModel133);
                    this_ContainedPropertyAssociation_0=ruleContainedPropertyAssociation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ContainedPropertyAssociation_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:95:2: this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPModelAccess().getBasicPropertyAssociationParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBasicPropertyAssociation_in_rulePModel163);
                    this_BasicPropertyAssociation_1=ruleBasicPropertyAssociation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BasicPropertyAssociation_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:108:2: this_PropertyAssociation_2= rulePropertyAssociation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPModelAccess().getPropertyAssociationParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePropertyAssociation_in_rulePModel193);
                    this_PropertyAssociation_2=rulePropertyAssociation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_PropertyAssociation_2;
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
    // $ANTLR end "rulePModel"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:127:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:128:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:129:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation227);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainedPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainedPropertyAssociation237); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:136:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) (otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )* )? otherlv_15= KEYWORD_8 ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_ownedValue_5_0 = null;

        EObject lv_ownedValue_7_0 = null;

        EObject lv_ownedValue_9_0 = null;

        EObject lv_appliesTo_12_0 = null;

        EObject lv_appliesTo_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:139:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) (otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )* )? otherlv_15= KEYWORD_8 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:140:1: ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) (otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )* )? otherlv_15= KEYWORD_8 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:140:1: ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) (otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )* )? otherlv_15= KEYWORD_8 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:140:2: ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) (otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )* )? otherlv_15= KEYWORD_8
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:140:2: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:141:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:141:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:142:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation289);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:158:2: (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_15) ) {
                alt2=1;
            }
            else if ( (LA2_0==KEYWORD_19) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:159:2: otherlv_1= KEYWORD_15
                    {
                    otherlv_1=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_ruleContainedPropertyAssociation303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:164:6: ( (lv_append_2_0= KEYWORD_19 ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:164:6: ( (lv_append_2_0= KEYWORD_19 ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:165:1: (lv_append_2_0= KEYWORD_19 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:165:1: (lv_append_2_0= KEYWORD_19 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:166:3: lv_append_2_0= KEYWORD_19
                    {
                    lv_append_2_0=(Token)match(input,KEYWORD_19,FollowSets000.FOLLOW_KEYWORD_19_in_ruleContainedPropertyAssociation327); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "append", true, "+=>");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:180:3: ( (lv_constant_3_0= KEYWORD_29 ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==KEYWORD_29) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:181:1: (lv_constant_3_0= KEYWORD_29 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:181:1: (lv_constant_3_0= KEYWORD_29 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:182:3: lv_constant_3_0= KEYWORD_29
                    {
                    lv_constant_3_0=(Token)match(input,KEYWORD_29,FollowSets000.FOLLOW_KEYWORD_29_in_ruleContainedPropertyAssociation358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "constant", true, "constant");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:196:3: ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:196:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:196:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:197:2: otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2
                    {
                    otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleContainedPropertyAssociation385); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_3_0_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:201:1: ( (lv_ownedValue_5_0= ruleModalPropertyValue ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:202:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:202:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:203:3: lv_ownedValue_5_0= ruleModalPropertyValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_ruleContainedPropertyAssociation405);
                    lv_ownedValue_5_0=ruleModalPropertyValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedValue",
                              		lv_ownedValue_5_0, 
                              		"ModalPropertyValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:219:2: (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==KEYWORD_5) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:220:2: otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
                    	    {
                    	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation419); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_0_2_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:224:1: ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:225:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:225:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:226:3: lv_ownedValue_7_0= ruleModalPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_ruleContainedPropertyAssociation439);
                    	    lv_ownedValue_7_0=ruleModalPropertyValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedValue",
                    	              		lv_ownedValue_7_0, 
                    	              		"ModalPropertyValue");
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

                    otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleContainedPropertyAssociation454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_3_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:248:6: ( (lv_ownedValue_9_0= rulePropertyValue ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:248:6: ( (lv_ownedValue_9_0= rulePropertyValue ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:249:1: (lv_ownedValue_9_0= rulePropertyValue )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:249:1: (lv_ownedValue_9_0= rulePropertyValue )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:250:3: lv_ownedValue_9_0= rulePropertyValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValuePropertyValueParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePropertyValue_in_ruleContainedPropertyAssociation481);
                    lv_ownedValue_9_0=rulePropertyValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedValue",
                              		lv_ownedValue_9_0, 
                              		"PropertyValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:266:3: (otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_27) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:267:2: otherlv_10= KEYWORD_27 otherlv_11= KEYWORD_18 ( (lv_appliesTo_12_0= ruleContainmentPath ) ) (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_10=(Token)match(input,KEYWORD_27,FollowSets000.FOLLOW_KEYWORD_27_in_ruleContainedPropertyAssociation496); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
                          
                    }
                    otherlv_11=(Token)match(input,KEYWORD_18,FollowSets000.FOLLOW_KEYWORD_18_in_ruleContainedPropertyAssociation508); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:276:1: ( (lv_appliesTo_12_0= ruleContainmentPath ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:277:1: (lv_appliesTo_12_0= ruleContainmentPath )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:277:1: (lv_appliesTo_12_0= ruleContainmentPath )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:278:3: lv_appliesTo_12_0= ruleContainmentPath
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation528);
                    lv_appliesTo_12_0=ruleContainmentPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"appliesTo",
                              		lv_appliesTo_12_0, 
                              		"ContainmentPath");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:294:2: (otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==KEYWORD_5) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:295:2: otherlv_13= KEYWORD_5 ( (lv_appliesTo_14_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_13=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation542); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:299:1: ( (lv_appliesTo_14_0= ruleContainmentPath ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:300:1: (lv_appliesTo_14_0= ruleContainmentPath )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:300:1: (lv_appliesTo_14_0= ruleContainmentPath )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:301:3: lv_appliesTo_14_0= ruleContainmentPath
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation562);
                    	    lv_appliesTo_14_0=ruleContainmentPath();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"appliesTo",
                    	              		lv_appliesTo_14_0, 
                    	              		"ContainmentPath");
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
                    break;

            }

            otherlv_15=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleContainedPropertyAssociation579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_5());
                  
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


    // $ANTLR start "entryRulePropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:330:1: entryRulePropertyAssociation returns [EObject current=null] : iv_rulePropertyAssociation= rulePropertyAssociation EOF ;
    public final EObject entryRulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:331:2: (iv_rulePropertyAssociation= rulePropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:332:2: iv_rulePropertyAssociation= rulePropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyAssociation_in_entryRulePropertyAssociation613);
            iv_rulePropertyAssociation=rulePropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyAssociation623); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:339:1: rulePropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) otherlv_10= KEYWORD_8 ) ;
    public final EObject rulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_ownedValue_5_0 = null;

        EObject lv_ownedValue_7_0 = null;

        EObject lv_ownedValue_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:342:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) otherlv_10= KEYWORD_8 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:343:1: ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) otherlv_10= KEYWORD_8 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:343:1: ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) otherlv_10= KEYWORD_8 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:343:2: ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) ) ( (lv_constant_3_0= KEYWORD_29 ) )? ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) ) otherlv_10= KEYWORD_8
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:343:2: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:344:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:344:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:345:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_rulePropertyAssociation675);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:361:2: (otherlv_1= KEYWORD_15 | ( (lv_append_2_0= KEYWORD_19 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==KEYWORD_15) ) {
                alt8=1;
            }
            else if ( (LA8_0==KEYWORD_19) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:362:2: otherlv_1= KEYWORD_15
                    {
                    otherlv_1=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_rulePropertyAssociation689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:367:6: ( (lv_append_2_0= KEYWORD_19 ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:367:6: ( (lv_append_2_0= KEYWORD_19 ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:368:1: (lv_append_2_0= KEYWORD_19 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:368:1: (lv_append_2_0= KEYWORD_19 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:369:3: lv_append_2_0= KEYWORD_19
                    {
                    lv_append_2_0=(Token)match(input,KEYWORD_19,FollowSets000.FOLLOW_KEYWORD_19_in_rulePropertyAssociation713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_append_2_0, grammarAccess.getPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "append", true, "+=>");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:383:3: ( (lv_constant_3_0= KEYWORD_29 ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==KEYWORD_29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:384:1: (lv_constant_3_0= KEYWORD_29 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:384:1: (lv_constant_3_0= KEYWORD_29 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:385:3: lv_constant_3_0= KEYWORD_29
                    {
                    lv_constant_3_0=(Token)match(input,KEYWORD_29,FollowSets000.FOLLOW_KEYWORD_29_in_rulePropertyAssociation744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_constant_3_0, grammarAccess.getPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyAssociationRule());
                      	        }
                             		setWithLastConsumed(current, "constant", true, "constant");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:399:3: ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:399:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:399:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:400:2: otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2
                    {
                    otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_rulePropertyAssociation771); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getPropertyAssociationAccess().getLeftParenthesisKeyword_3_0_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:404:1: ( (lv_ownedValue_5_0= ruleModalPropertyValue ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:405:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:405:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:406:3: lv_ownedValue_5_0= ruleModalPropertyValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_rulePropertyAssociation791);
                    lv_ownedValue_5_0=ruleModalPropertyValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedValue",
                              		lv_ownedValue_5_0, 
                              		"ModalPropertyValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:422:2: (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==KEYWORD_5) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:423:2: otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
                    	    {
                    	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_rulePropertyAssociation805); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getPropertyAssociationAccess().getCommaKeyword_3_0_2_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:427:1: ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:428:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:428:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:429:3: lv_ownedValue_7_0= ruleModalPropertyValue
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_rulePropertyAssociation825);
                    	    lv_ownedValue_7_0=ruleModalPropertyValue();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedValue",
                    	              		lv_ownedValue_7_0, 
                    	              		"ModalPropertyValue");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_rulePropertyAssociation840); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPropertyAssociationAccess().getRightParenthesisKeyword_3_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:451:6: ( (lv_ownedValue_9_0= rulePropertyValue ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:451:6: ( (lv_ownedValue_9_0= rulePropertyValue ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:452:1: (lv_ownedValue_9_0= rulePropertyValue )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:452:1: (lv_ownedValue_9_0= rulePropertyValue )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:453:3: lv_ownedValue_9_0= rulePropertyValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValuePropertyValueParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePropertyValue_in_rulePropertyAssociation867);
                    lv_ownedValue_9_0=rulePropertyValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedValue",
                              		lv_ownedValue_9_0, 
                              		"PropertyValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_rulePropertyAssociation881); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getPropertyAssociationAccess().getSemicolonKeyword_4());
                  
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


    // $ANTLR start "entryRuleBasicPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:482:1: entryRuleBasicPropertyAssociation returns [EObject current=null] : iv_ruleBasicPropertyAssociation= ruleBasicPropertyAssociation EOF ;
    public final EObject entryRuleBasicPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:483:2: (iv_ruleBasicPropertyAssociation= ruleBasicPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:484:2: iv_ruleBasicPropertyAssociation= ruleBasicPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBasicPropertyAssociation_in_entryRuleBasicPropertyAssociation915);
            iv_ruleBasicPropertyAssociation=ruleBasicPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBasicPropertyAssociation925); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicPropertyAssociation"


    // $ANTLR start "ruleBasicPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:491:1: ruleBasicPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyValue ) ) otherlv_3= KEYWORD_8 ) ;
    public final EObject ruleBasicPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:494:28: ( ( ( ( ruleQPREF ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyValue ) ) otherlv_3= KEYWORD_8 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:495:1: ( ( ( ruleQPREF ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyValue ) ) otherlv_3= KEYWORD_8 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:495:1: ( ( ( ruleQPREF ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyValue ) ) otherlv_3= KEYWORD_8 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:495:2: ( ( ruleQPREF ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyValue ) ) otherlv_3= KEYWORD_8
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:495:2: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:496:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:496:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:497:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBasicPropertyAssociationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBasicPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleBasicPropertyAssociation977);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_ruleBasicPropertyAssociation990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBasicPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:518:1: ( (lv_ownedValue_2_0= rulePropertyValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:519:1: (lv_ownedValue_2_0= rulePropertyValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:519:1: (lv_ownedValue_2_0= rulePropertyValue )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:520:3: lv_ownedValue_2_0= rulePropertyValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValuePropertyValueParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyValue_in_ruleBasicPropertyAssociation1010);
            lv_ownedValue_2_0=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBasicPropertyAssociationRule());
              	        }
                     		add(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"PropertyValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleBasicPropertyAssociation1023); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBasicPropertyAssociationAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleBasicPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:549:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:550:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:551:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath1057);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPath; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentPath1067); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:558:1: ruleContainmentPath returns [EObject current=null] : ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_containmentPathElement_1_0 = null;

        EObject lv_containmentPathElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:561:28: ( ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:562:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:562:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:562:2: () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:562:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:563:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getContainmentPathAccess().getContainedNamedElementAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:571:2: ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:572:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:572:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:573:3: lv_containmentPathElement_1_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath1125);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:589:2: (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==KEYWORD_7) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:590:2: otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleContainmentPath1139); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathAccess().getFullStopKeyword_2_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:594:1: ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:595:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:595:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:596:3: lv_containmentPathElement_3_0= ruleContainmentPathElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath1159);
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
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleModalPropertyValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:620:1: entryRuleModalPropertyValue returns [EObject current=null] : iv_ruleModalPropertyValue= ruleModalPropertyValue EOF ;
    public final EObject entryRuleModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModalPropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:621:2: (iv_ruleModalPropertyValue= ruleModalPropertyValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:622:2: iv_ruleModalPropertyValue= ruleModalPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModalPropertyValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_entryRuleModalPropertyValue1196);
            iv_ruleModalPropertyValue=ruleModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModalPropertyValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModalPropertyValue1206); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModalPropertyValue"


    // $ANTLR start "ruleModalPropertyValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:629:1: ruleModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= KEYWORD_16 otherlv_2= KEYWORD_26 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 ) ;
    public final EObject ruleModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:632:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= KEYWORD_16 otherlv_2= KEYWORD_26 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:633:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= KEYWORD_16 otherlv_2= KEYWORD_26 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:633:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= KEYWORD_16 otherlv_2= KEYWORD_26 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:633:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= KEYWORD_16 otherlv_2= KEYWORD_26 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:633:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:634:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:634:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:635:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleModalPropertyValue1252);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModalPropertyValueRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_0_0, 
                      		"PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_16,FollowSets000.FOLLOW_KEYWORD_16_in_ruleModalPropertyValue1265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModalPropertyValueAccess().getInKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,KEYWORD_26,FollowSets000.FOLLOW_KEYWORD_26_in_ruleModalPropertyValue1277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModalPropertyValueAccess().getModesKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleModalPropertyValue1289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModalPropertyValueAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:666:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:667:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:667:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:668:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModalPropertyValueRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModalPropertyValue1312); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getModalPropertyValueAccess().getInModeModeCrossReference_4_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:682:2: (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==KEYWORD_5) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:683:2: otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleModalPropertyValue1326); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getModalPropertyValueAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:687:1: ( (otherlv_6= RULE_ID ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:688:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:688:1: (otherlv_6= RULE_ID )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:689:3: otherlv_6= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModalPropertyValueRule());
            	      	        }
            	              
            	    }
            	    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModalPropertyValue1349); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_6, grammarAccess.getModalPropertyValueAccess().getInModeModeCrossReference_5_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_7=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleModalPropertyValue1364); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getModalPropertyValueAccess().getRightParenthesisKeyword_6());
                  
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
    // $ANTLR end "ruleModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:716:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:717:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:718:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyValue_in_entryRulePropertyValue1398);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyValue1408); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValue"


    // $ANTLR start "rulePropertyValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:725:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:728:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:729:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:729:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:730:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:730:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:731:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_rulePropertyValue1453);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyValueRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_0_0, 
                      		"PropertyExpression");
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
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRulePropertyExpression"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:755:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:756:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:757:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression1487);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyExpression1497); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:764:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_ActualBooleanTerm_9= ruleActualBooleanTerm | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_ReferenceTerm_1 = null;

        EObject this_ComponentClassifierTerm_2 = null;

        EObject this_ComputedTerm_3 = null;

        EObject this_StringTerm_4 = null;

        EObject this_NumericRangeTerm_5 = null;

        EObject this_RealTerm_6 = null;

        EObject this_IntegerTerm_7 = null;

        EObject this_ListTerm_8 = null;

        EObject this_ActualBooleanTerm_9 = null;

        EObject this_LiteralorReferenceTerm_10 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:767:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_ActualBooleanTerm_9= ruleActualBooleanTerm | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:768:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_ActualBooleanTerm_9= ruleActualBooleanTerm | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:768:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_ActualBooleanTerm_9= ruleActualBooleanTerm | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )
            int alt14=11;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:769:2: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRecordTerm_in_rulePropertyExpression1547);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RecordTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:782:2: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceTerm_in_rulePropertyExpression1577);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ReferenceTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:795:2: this_ComponentClassifierTerm_2= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression1607);
                    this_ComponentClassifierTerm_2=ruleComponentClassifierTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ComponentClassifierTerm_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:808:2: this_ComputedTerm_3= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleComputedTerm_in_rulePropertyExpression1637);
                    this_ComputedTerm_3=ruleComputedTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ComputedTerm_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:821:2: this_StringTerm_4= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringTerm_in_rulePropertyExpression1667);
                    this_StringTerm_4=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_StringTerm_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:834:2: this_NumericRangeTerm_5= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression1697);
                    this_NumericRangeTerm_5=ruleNumericRangeTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NumericRangeTerm_5;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:847:2: this_RealTerm_6= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_rulePropertyExpression1727);
                    this_RealTerm_6=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealTerm_6;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:860:2: this_IntegerTerm_7= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_rulePropertyExpression1757);
                    this_IntegerTerm_7=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerTerm_7;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:873:2: this_ListTerm_8= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleListTerm_in_rulePropertyExpression1787);
                    this_ListTerm_8=ruleListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ListTerm_8;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:886:2: this_ActualBooleanTerm_9= ruleActualBooleanTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getActualBooleanTermParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleActualBooleanTerm_in_rulePropertyExpression1817);
                    this_ActualBooleanTerm_9=ruleActualBooleanTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ActualBooleanTerm_9;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:899:2: this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression1847);
                    this_LiteralorReferenceTerm_10=ruleLiteralorReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_LiteralorReferenceTerm_10;
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
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:918:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:919:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:920:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm1881);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralorReferenceTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm1891); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralorReferenceTerm"


    // $ANTLR start "ruleLiteralorReferenceTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:927:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:930:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:931:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:931:1: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:932:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:932:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:933:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm1942);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleActualBooleanTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:957:1: entryRuleActualBooleanTerm returns [EObject current=null] : iv_ruleActualBooleanTerm= ruleActualBooleanTerm EOF ;
    public final EObject entryRuleActualBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualBooleanTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:958:2: (iv_ruleActualBooleanTerm= ruleActualBooleanTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:959:2: iv_ruleActualBooleanTerm= ruleActualBooleanTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualBooleanTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleActualBooleanTerm_in_entryRuleActualBooleanTerm1976);
            iv_ruleActualBooleanTerm=ruleActualBooleanTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualBooleanTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleActualBooleanTerm1986); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActualBooleanTerm"


    // $ANTLR start "ruleActualBooleanTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:966:1: ruleActualBooleanTerm returns [EObject current=null] : (this_ActualOrTerm_0= ruleActualOrTerm | this_ActualAndTerm_1= ruleActualAndTerm | this_BooleanLiteral_2= ruleBooleanLiteral | this_NotTerm_3= ruleNotTerm | this_ConstantValue_4= ruleConstantValue ) ;
    public final EObject ruleActualBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject this_ActualOrTerm_0 = null;

        EObject this_ActualAndTerm_1 = null;

        EObject this_BooleanLiteral_2 = null;

        EObject this_NotTerm_3 = null;

        EObject this_ConstantValue_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:969:28: ( (this_ActualOrTerm_0= ruleActualOrTerm | this_ActualAndTerm_1= ruleActualAndTerm | this_BooleanLiteral_2= ruleBooleanLiteral | this_NotTerm_3= ruleNotTerm | this_ConstantValue_4= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:970:1: (this_ActualOrTerm_0= ruleActualOrTerm | this_ActualAndTerm_1= ruleActualAndTerm | this_BooleanLiteral_2= ruleBooleanLiteral | this_NotTerm_3= ruleNotTerm | this_ConstantValue_4= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:970:1: (this_ActualOrTerm_0= ruleActualOrTerm | this_ActualAndTerm_1= ruleActualAndTerm | this_BooleanLiteral_2= ruleBooleanLiteral | this_NotTerm_3= ruleNotTerm | this_ConstantValue_4= ruleConstantValue )
            int alt15=5;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:971:2: this_ActualOrTerm_0= ruleActualOrTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getActualBooleanTermAccess().getActualOrTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleActualOrTerm_in_ruleActualBooleanTerm2036);
                    this_ActualOrTerm_0=ruleActualOrTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ActualOrTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:984:2: this_ActualAndTerm_1= ruleActualAndTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getActualBooleanTermAccess().getActualAndTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleActualAndTerm_in_ruleActualBooleanTerm2066);
                    this_ActualAndTerm_1=ruleActualAndTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ActualAndTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:997:2: this_BooleanLiteral_2= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getActualBooleanTermAccess().getBooleanLiteralParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_ruleActualBooleanTerm2096);
                    this_BooleanLiteral_2=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanLiteral_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1010:2: this_NotTerm_3= ruleNotTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getActualBooleanTermAccess().getNotTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotTerm_in_ruleActualBooleanTerm2126);
                    this_NotTerm_3=ruleNotTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NotTerm_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1023:2: this_ConstantValue_4= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getActualBooleanTermAccess().getConstantValueParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleActualBooleanTerm2156);
                    this_ConstantValue_4=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ConstantValue_4;
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
    // $ANTLR end "ruleActualBooleanTerm"


    // $ANTLR start "entryRuleActualOrTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1042:1: entryRuleActualOrTerm returns [EObject current=null] : iv_ruleActualOrTerm= ruleActualOrTerm EOF ;
    public final EObject entryRuleActualOrTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualOrTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1043:2: (iv_ruleActualOrTerm= ruleActualOrTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1044:2: iv_ruleActualOrTerm= ruleActualOrTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualOrTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleActualOrTerm_in_entryRuleActualOrTerm2190);
            iv_ruleActualOrTerm=ruleActualOrTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualOrTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleActualOrTerm2200); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActualOrTerm"


    // $ANTLR start "ruleActualOrTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1051:1: ruleActualOrTerm returns [EObject current=null] : ( ( (lv_ownedPropertyExpression_0_0= ruleAndTerm ) ) ( (lv_op_1_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleAndTerm ) ) ( ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) ) )* ) ;
    public final EObject ruleActualOrTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedPropertyExpression_0_0 = null;

        AntlrDatatypeRuleToken lv_op_1_0 = null;

        EObject lv_ownedPropertyExpression_2_0 = null;

        AntlrDatatypeRuleToken lv_op_3_0 = null;

        EObject lv_ownedPropertyExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1054:28: ( ( ( (lv_ownedPropertyExpression_0_0= ruleAndTerm ) ) ( (lv_op_1_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleAndTerm ) ) ( ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1055:1: ( ( (lv_ownedPropertyExpression_0_0= ruleAndTerm ) ) ( (lv_op_1_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleAndTerm ) ) ( ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1055:1: ( ( (lv_ownedPropertyExpression_0_0= ruleAndTerm ) ) ( (lv_op_1_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleAndTerm ) ) ( ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1055:2: ( (lv_ownedPropertyExpression_0_0= ruleAndTerm ) ) ( (lv_op_1_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleAndTerm ) ) ( ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) ) )*
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1055:2: ( (lv_ownedPropertyExpression_0_0= ruleAndTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1056:1: (lv_ownedPropertyExpression_0_0= ruleAndTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1056:1: (lv_ownedPropertyExpression_0_0= ruleAndTerm )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1057:3: lv_ownedPropertyExpression_0_0= ruleAndTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualOrTermAccess().getOwnedPropertyExpressionAndTermParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndTerm_in_ruleActualOrTerm2246);
            lv_ownedPropertyExpression_0_0=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualOrTermRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_0_0, 
                      		"AndTerm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1073:2: ( (lv_op_1_0= ruleOrOp ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1074:1: (lv_op_1_0= ruleOrOp )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1074:1: (lv_op_1_0= ruleOrOp )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1075:3: lv_op_1_0= ruleOrOp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualOrTermAccess().getOpOrOpParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrOp_in_ruleActualOrTerm2267);
            lv_op_1_0=ruleOrOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualOrTermRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_1_0, 
                      		"OrOp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1091:2: ( (lv_ownedPropertyExpression_2_0= ruleAndTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1092:1: (lv_ownedPropertyExpression_2_0= ruleAndTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1092:1: (lv_ownedPropertyExpression_2_0= ruleAndTerm )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1093:3: lv_ownedPropertyExpression_2_0= ruleAndTerm
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualOrTermAccess().getOwnedPropertyExpressionAndTermParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndTerm_in_ruleActualOrTerm2288);
            lv_ownedPropertyExpression_2_0=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualOrTermRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_2_0, 
                      		"AndTerm");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1109:2: ( ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==KEYWORD_17) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1109:3: ( (lv_op_3_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1109:3: ( (lv_op_3_0= ruleOrOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1110:1: (lv_op_3_0= ruleOrOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1110:1: (lv_op_3_0= ruleOrOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1111:3: lv_op_3_0= ruleOrOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualOrTermAccess().getOpOrOpParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOrOp_in_ruleActualOrTerm2310);
            	    lv_op_3_0=ruleOrOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getActualOrTermRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_3_0, 
            	              		"OrOp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1127:2: ( (lv_ownedPropertyExpression_4_0= ruleAndTerm ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1128:1: (lv_ownedPropertyExpression_4_0= ruleAndTerm )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1128:1: (lv_ownedPropertyExpression_4_0= ruleAndTerm )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1129:3: lv_ownedPropertyExpression_4_0= ruleAndTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualOrTermAccess().getOwnedPropertyExpressionAndTermParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndTerm_in_ruleActualOrTerm2331);
            	    lv_ownedPropertyExpression_4_0=ruleAndTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getActualOrTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPropertyExpression",
            	              		lv_ownedPropertyExpression_4_0, 
            	              		"AndTerm");
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
    // $ANTLR end "ruleActualOrTerm"


    // $ANTLR start "entryRuleActualAndTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1153:1: entryRuleActualAndTerm returns [EObject current=null] : iv_ruleActualAndTerm= ruleActualAndTerm EOF ;
    public final EObject entryRuleActualAndTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActualAndTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1154:2: (iv_ruleActualAndTerm= ruleActualAndTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1155:2: iv_ruleActualAndTerm= ruleActualAndTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActualAndTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleActualAndTerm_in_entryRuleActualAndTerm2368);
            iv_ruleActualAndTerm=ruleActualAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActualAndTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleActualAndTerm2378); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActualAndTerm"


    // $ANTLR start "ruleActualAndTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1162:1: ruleActualAndTerm returns [EObject current=null] : ( ( (lv_ownedPropertyExpression_0_0= ruleBooleanAtom ) ) ( (lv_op_1_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleBooleanAtom ) ) ( ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) ) )* ) ;
    public final EObject ruleActualAndTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedPropertyExpression_0_0 = null;

        AntlrDatatypeRuleToken lv_op_1_0 = null;

        EObject lv_ownedPropertyExpression_2_0 = null;

        AntlrDatatypeRuleToken lv_op_3_0 = null;

        EObject lv_ownedPropertyExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1165:28: ( ( ( (lv_ownedPropertyExpression_0_0= ruleBooleanAtom ) ) ( (lv_op_1_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleBooleanAtom ) ) ( ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1166:1: ( ( (lv_ownedPropertyExpression_0_0= ruleBooleanAtom ) ) ( (lv_op_1_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleBooleanAtom ) ) ( ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1166:1: ( ( (lv_ownedPropertyExpression_0_0= ruleBooleanAtom ) ) ( (lv_op_1_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleBooleanAtom ) ) ( ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1166:2: ( (lv_ownedPropertyExpression_0_0= ruleBooleanAtom ) ) ( (lv_op_1_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_2_0= ruleBooleanAtom ) ) ( ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) ) )*
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1166:2: ( (lv_ownedPropertyExpression_0_0= ruleBooleanAtom ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1167:1: (lv_ownedPropertyExpression_0_0= ruleBooleanAtom )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1167:1: (lv_ownedPropertyExpression_0_0= ruleBooleanAtom )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1168:3: lv_ownedPropertyExpression_0_0= ruleBooleanAtom
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualAndTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_ruleActualAndTerm2424);
            lv_ownedPropertyExpression_0_0=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualAndTermRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_0_0, 
                      		"BooleanAtom");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1184:2: ( (lv_op_1_0= ruleAndOp ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1185:1: (lv_op_1_0= ruleAndOp )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1185:1: (lv_op_1_0= ruleAndOp )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1186:3: lv_op_1_0= ruleAndOp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualAndTermAccess().getOpAndOpParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndOp_in_ruleActualAndTerm2445);
            lv_op_1_0=ruleAndOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualAndTermRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_1_0, 
                      		"AndOp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1202:2: ( (lv_ownedPropertyExpression_2_0= ruleBooleanAtom ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1203:1: (lv_ownedPropertyExpression_2_0= ruleBooleanAtom )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1203:1: (lv_ownedPropertyExpression_2_0= ruleBooleanAtom )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1204:3: lv_ownedPropertyExpression_2_0= ruleBooleanAtom
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getActualAndTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_ruleActualAndTerm2466);
            lv_ownedPropertyExpression_2_0=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getActualAndTermRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_2_0, 
                      		"BooleanAtom");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1220:2: ( ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==KEYWORD_20) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1220:3: ( (lv_op_3_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1220:3: ( (lv_op_3_0= ruleAndOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1221:1: (lv_op_3_0= ruleAndOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1221:1: (lv_op_3_0= ruleAndOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1222:3: lv_op_3_0= ruleAndOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualAndTermAccess().getOpAndOpParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndOp_in_ruleActualAndTerm2488);
            	    lv_op_3_0=ruleAndOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getActualAndTermRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_3_0, 
            	              		"AndOp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1238:2: ( (lv_ownedPropertyExpression_4_0= ruleBooleanAtom ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1239:1: (lv_ownedPropertyExpression_4_0= ruleBooleanAtom )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1239:1: (lv_ownedPropertyExpression_4_0= ruleBooleanAtom )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1240:3: lv_ownedPropertyExpression_4_0= ruleBooleanAtom
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getActualAndTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_ruleActualAndTerm2509);
            	    lv_ownedPropertyExpression_4_0=ruleBooleanAtom();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getActualAndTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPropertyExpression",
            	              		lv_ownedPropertyExpression_4_0, 
            	              		"BooleanAtom");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "ruleActualAndTerm"


    // $ANTLR start "entryRuleBooleanTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1264:1: entryRuleBooleanTerm returns [EObject current=null] : iv_ruleBooleanTerm= ruleBooleanTerm EOF ;
    public final EObject entryRuleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1265:2: (iv_ruleBooleanTerm= ruleBooleanTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1266:2: iv_ruleBooleanTerm= ruleBooleanTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanTerm_in_entryRuleBooleanTerm2546);
            iv_ruleBooleanTerm=ruleBooleanTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanTerm2556); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanTerm"


    // $ANTLR start "ruleBooleanTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1273:1: ruleBooleanTerm returns [EObject current=null] : this_OrTerm_0= ruleOrTerm ;
    public final EObject ruleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject this_OrTerm_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1276:28: (this_OrTerm_0= ruleOrTerm )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1278:2: this_OrTerm_0= ruleOrTerm
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBooleanTermAccess().getOrTermParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrTerm_in_ruleBooleanTerm2605);
            this_OrTerm_0=ruleOrTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_OrTerm_0;
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
    // $ANTLR end "ruleBooleanTerm"


    // $ANTLR start "entryRuleOrTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1297:1: entryRuleOrTerm returns [EObject current=null] : iv_ruleOrTerm= ruleOrTerm EOF ;
    public final EObject entryRuleOrTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1298:2: (iv_ruleOrTerm= ruleOrTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1299:2: iv_ruleOrTerm= ruleOrTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrTerm_in_entryRuleOrTerm2638);
            iv_ruleOrTerm=ruleOrTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOrTerm2648); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrTerm"


    // $ANTLR start "ruleOrTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1306:1: ruleOrTerm returns [EObject current=null] : (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* ) ;
    public final EObject ruleOrTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AndTerm_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_ownedPropertyExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1309:28: ( (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1310:1: (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1310:1: (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1311:2: this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrTermAccess().getAndTermParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndTerm_in_ruleOrTerm2698);
            this_AndTerm_0=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_AndTerm_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1322:1: ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==KEYWORD_17) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1322:2: () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1322:2: ()
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1323:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndAdd(
            	                  grammarAccess.getOrTermAccess().getOperationOwnedPropertyExpressionAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1331:2: ( (lv_op_2_0= ruleOrOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1332:1: (lv_op_2_0= ruleOrOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1332:1: (lv_op_2_0= ruleOrOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1333:3: lv_op_2_0= ruleOrOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrTermAccess().getOpOrOpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOrOp_in_ruleOrTerm2731);
            	    lv_op_2_0=ruleOrOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrTermRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"OrOp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1349:2: ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1350:1: (lv_ownedPropertyExpression_3_0= ruleAndTerm )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1350:1: (lv_ownedPropertyExpression_3_0= ruleAndTerm )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1351:3: lv_ownedPropertyExpression_3_0= ruleAndTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrTermAccess().getOwnedPropertyExpressionAndTermParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndTerm_in_ruleOrTerm2752);
            	    lv_ownedPropertyExpression_3_0=ruleAndTerm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPropertyExpression",
            	              		lv_ownedPropertyExpression_3_0, 
            	              		"AndTerm");
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
    // $ANTLR end "ruleOrTerm"


    // $ANTLR start "entryRuleAndTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1375:1: entryRuleAndTerm returns [EObject current=null] : iv_ruleAndTerm= ruleAndTerm EOF ;
    public final EObject entryRuleAndTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1376:2: (iv_ruleAndTerm= ruleAndTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1377:2: iv_ruleAndTerm= ruleAndTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndTerm_in_entryRuleAndTerm2789);
            iv_ruleAndTerm=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndTerm2799); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndTerm"


    // $ANTLR start "ruleAndTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1384:1: ruleAndTerm returns [EObject current=null] : (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* ) ;
    public final EObject ruleAndTerm() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanAtom_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_ownedPropertyExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1387:28: ( (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1388:1: (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1388:1: (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1389:2: this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndTermAccess().getBooleanAtomParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_ruleAndTerm2849);
            this_BooleanAtom_0=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_BooleanAtom_0;
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1400:1: ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==KEYWORD_20) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1400:2: () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1400:2: ()
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1401:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndAdd(
            	                  grammarAccess.getAndTermAccess().getOperationOwnedPropertyExpressionAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1409:2: ( (lv_op_2_0= ruleAndOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1410:1: (lv_op_2_0= ruleAndOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1410:1: (lv_op_2_0= ruleAndOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1411:3: lv_op_2_0= ruleAndOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndTermAccess().getOpAndOpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAndOp_in_ruleAndTerm2882);
            	    lv_op_2_0=ruleAndOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndTermRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"op",
            	              		lv_op_2_0, 
            	              		"AndOp");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1427:2: ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1428:1: (lv_ownedPropertyExpression_3_0= ruleBooleanAtom )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1428:1: (lv_ownedPropertyExpression_3_0= ruleBooleanAtom )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1429:3: lv_ownedPropertyExpression_3_0= ruleBooleanAtom
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_ruleAndTerm2903);
            	    lv_ownedPropertyExpression_3_0=ruleBooleanAtom();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPropertyExpression",
            	              		lv_ownedPropertyExpression_3_0, 
            	              		"BooleanAtom");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // $ANTLR end "ruleAndTerm"


    // $ANTLR start "entryRuleNotTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1453:1: entryRuleNotTerm returns [EObject current=null] : iv_ruleNotTerm= ruleNotTerm EOF ;
    public final EObject entryRuleNotTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1454:2: (iv_ruleNotTerm= ruleNotTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1455:2: iv_ruleNotTerm= ruleNotTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotTerm_in_entryRuleNotTerm2940);
            iv_ruleNotTerm=ruleNotTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotTerm2950); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotTerm"


    // $ANTLR start "ruleNotTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1462:1: ruleNotTerm returns [EObject current=null] : ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) ) ;
    public final EObject ruleNotTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1465:28: ( ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1466:1: ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1466:1: ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1466:2: ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1466:2: ( (lv_op_0_0= ruleNotOp ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1467:1: (lv_op_0_0= ruleNotOp )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1467:1: (lv_op_0_0= ruleNotOp )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1468:3: lv_op_0_0= ruleNotOp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotTermAccess().getOpNotOpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotOp_in_ruleNotTerm2996);
            lv_op_0_0=ruleNotOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNotTermRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"NotOp");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1484:2: ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1485:1: (lv_ownedPropertyExpression_1_0= ruleBooleanAtom )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1485:1: (lv_ownedPropertyExpression_1_0= ruleBooleanAtom )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1486:3: lv_ownedPropertyExpression_1_0= ruleBooleanAtom
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_ruleNotTerm3017);
            lv_ownedPropertyExpression_1_0=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNotTermRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_1_0, 
                      		"BooleanAtom");
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
    // $ANTLR end "ruleNotTerm"


    // $ANTLR start "entryRuleBooleanAtom"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1510:1: entryRuleBooleanAtom returns [EObject current=null] : iv_ruleBooleanAtom= ruleBooleanAtom EOF ;
    public final EObject entryRuleBooleanAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAtom = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1511:2: (iv_ruleBooleanAtom= ruleBooleanAtom EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1512:2: iv_ruleBooleanAtom= ruleBooleanAtom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAtomRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanAtom_in_entryRuleBooleanAtom3052);
            iv_ruleBooleanAtom=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAtom; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanAtom3062); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanAtom"


    // $ANTLR start "ruleBooleanAtom"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1519:1: ruleBooleanAtom returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2 ) ) ;
    public final EObject ruleBooleanAtom() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_BooleanLiteral_0 = null;

        EObject this_NotTerm_1 = null;

        EObject this_ConstantValue_2 = null;

        EObject this_BooleanTerm_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1522:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2 ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1523:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2 ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1523:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2 ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case KEYWORD_25:
            case KEYWORD_22:
                {
                alt20=1;
                }
                break;
            case KEYWORD_21:
                {
                alt20=2;
                }
                break;
            case RULE_ID:
                {
                alt20=3;
                }
                break;
            case KEYWORD_1:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1524:2: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getBooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_ruleBooleanAtom3112);
                    this_BooleanLiteral_0=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanLiteral_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1537:2: this_NotTerm_1= ruleNotTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getNotTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNotTerm_in_ruleBooleanAtom3142);
                    this_NotTerm_1=ruleNotTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_NotTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1550:2: this_ConstantValue_2= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getConstantValueParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleBooleanAtom3172);
                    this_ConstantValue_2=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ConstantValue_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1562:6: (otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1562:6: (otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1563:2: otherlv_3= KEYWORD_1 this_BooleanTerm_4= ruleBooleanTerm otherlv_5= KEYWORD_2
                    {
                    otherlv_3=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleBooleanAtom3191); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getBooleanAtomAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getBooleanTermParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanTerm_in_ruleBooleanAtom3215);
                    this_BooleanTerm_4=ruleBooleanTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_BooleanTerm_4;
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_5=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleBooleanAtom3227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getBooleanAtomAccess().getRightParenthesisKeyword_3_2());
                          
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
    // $ANTLR end "ruleBooleanAtom"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1592:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1593:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1594:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3262);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteral3272); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1601:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= KEYWORD_22 ) ) | otherlv_2= KEYWORD_25 ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1604:28: ( ( () ( ( (lv_value_1_0= KEYWORD_22 ) ) | otherlv_2= KEYWORD_25 ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1605:1: ( () ( ( (lv_value_1_0= KEYWORD_22 ) ) | otherlv_2= KEYWORD_25 ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1605:1: ( () ( ( (lv_value_1_0= KEYWORD_22 ) ) | otherlv_2= KEYWORD_25 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1605:2: () ( ( (lv_value_1_0= KEYWORD_22 ) ) | otherlv_2= KEYWORD_25 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1605:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1606:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                          current);
                  
            }

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1614:2: ( ( (lv_value_1_0= KEYWORD_22 ) ) | otherlv_2= KEYWORD_25 )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==KEYWORD_22) ) {
                alt21=1;
            }
            else if ( (LA21_0==KEYWORD_25) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1614:3: ( (lv_value_1_0= KEYWORD_22 ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1614:3: ( (lv_value_1_0= KEYWORD_22 ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1615:1: (lv_value_1_0= KEYWORD_22 )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1615:1: (lv_value_1_0= KEYWORD_22 )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1616:3: lv_value_1_0= KEYWORD_22
                    {
                    lv_value_1_0=(Token)match(input,KEYWORD_22,FollowSets000.FOLLOW_KEYWORD_22_in_ruleBooleanLiteral3329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      	        }
                             		setWithLastConsumed(current, "value", true, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1632:2: otherlv_2= KEYWORD_25
                    {
                    otherlv_2=(Token)match(input,KEYWORD_25,FollowSets000.FOLLOW_KEYWORD_25_in_ruleBooleanLiteral3359); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                          
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
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1644:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1645:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1646:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_entryRuleConstantValue3394);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstantValue3404); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1653:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1656:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1657:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1657:1: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1658:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1658:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1659:3: ruleQPREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getConstantValueRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleConstantValue3455);
            ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleReferenceTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1683:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1684:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1685:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm3489);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceTerm3499); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceTerm"


    // $ANTLR start "ruleReferenceTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1692:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= KEYWORD_30 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_containmentPathElement_2_0 = null;

        EObject lv_containmentPathElement_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1695:28: ( (otherlv_0= KEYWORD_30 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1696:1: (otherlv_0= KEYWORD_30 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1696:1: (otherlv_0= KEYWORD_30 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1697:2: otherlv_0= KEYWORD_30 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_30,FollowSets000.FOLLOW_KEYWORD_30_in_ruleReferenceTerm3537); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleReferenceTerm3549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1706:1: ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1707:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1707:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1708:3: lv_containmentPathElement_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm3569);
            lv_containmentPathElement_2_0=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceTermRule());
              	        }
                     		add(
                     			current, 
                     			"containmentPathElement",
                      		lv_containmentPathElement_2_0, 
                      		"ContainmentPathElement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1724:2: (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==KEYWORD_7) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1725:2: otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleReferenceTerm3583); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getFullStopKeyword_3_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1729:1: ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1730:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1730:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1731:3: lv_containmentPathElement_4_0= ruleContainmentPathElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm3603);
            	    lv_containmentPathElement_4_0=ruleContainmentPathElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getReferenceTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"containmentPathElement",
            	              		lv_containmentPathElement_4_0, 
            	              		"ContainmentPathElement");
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

            otherlv_5=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleReferenceTerm3618); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1760:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1761:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1762:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm3652);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecordTerm3662); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordTerm"


    // $ANTLR start "ruleRecordTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1769:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1772:28: ( (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1773:1: (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1773:1: (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1774:2: otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleRecordTerm3700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1778:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
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
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1779:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1779:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1780:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm3720);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedFieldValue",
            	              		lv_ownedFieldValue_1_0, 
            	              		"FieldPropertyAssociation");
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

            otherlv_2=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleRecordTerm3734); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1809:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1810:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1811:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComputedTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm3768);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComputedTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComputedTerm3778); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputedTerm"


    // $ANTLR start "ruleComputedTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1818:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= KEYWORD_28 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1821:28: ( (otherlv_0= KEYWORD_28 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1822:1: (otherlv_0= KEYWORD_28 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1822:1: (otherlv_0= KEYWORD_28 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1823:2: otherlv_0= KEYWORD_28 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_28,FollowSets000.FOLLOW_KEYWORD_28_in_ruleComputedTerm3816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleComputedTerm3828); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1832:1: ( (lv_function_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1833:1: (lv_function_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1833:1: (lv_function_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1834:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComputedTerm3844); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getComputedTermRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"function",
                      		lv_function_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleComputedTerm3862); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1863:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1864:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1865:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm3896);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentClassifierTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComponentClassifierTerm3906); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentClassifierTerm"


    // $ANTLR start "ruleComponentClassifierTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1872:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1875:28: ( (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1876:1: (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1876:1: (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1877:2: otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_31,FollowSets000.FOLLOW_KEYWORD_31_in_ruleComponentClassifierTerm3944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleComponentClassifierTerm3956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1886:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1887:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1887:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1888:3: ruleQCREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm3982);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleComponentClassifierTerm3995); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1917:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1918:2: (iv_ruleListTerm= ruleListTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1919:2: iv_ruleListTerm= ruleListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListTerm_in_entryRuleListTerm4029);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListTerm4039); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTerm"


    // $ANTLR start "ruleListTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1926:1: ruleListTerm returns [EObject current=null] : (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedListElement_1_0 = null;

        EObject lv_ownedListElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1929:28: ( (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1930:1: (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1930:1: (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1931:2: otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleListTerm4077); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1935:1: ( (lv_ownedListElement_1_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1936:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1936:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1937:3: lv_ownedListElement_1_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleListTerm4097);
            lv_ownedListElement_1_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getListTermRule());
              	        }
                     		add(
                     			current, 
                     			"ownedListElement",
                      		lv_ownedListElement_1_0, 
                      		"PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1953:2: (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==KEYWORD_5) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1954:2: otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleListTerm4111); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getListTermAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1958:1: ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1959:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1959:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1960:3: lv_ownedListElement_3_0= rulePropertyExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleListTerm4131);
            	    lv_ownedListElement_3_0=rulePropertyExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getListTermRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedListElement",
            	              		lv_ownedListElement_3_0, 
            	              		"PropertyExpression");
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

            otherlv_4=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleListTerm4146); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1989:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1990:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1991:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation4180);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldPropertyAssociation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFieldPropertyAssociation4190); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldPropertyAssociation"


    // $ANTLR start "ruleFieldPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1998:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_8 ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2001:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_8 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2002:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_8 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2002:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_8 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2002:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_15 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_8
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2002:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2003:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2003:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2004:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation4239); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_ruleFieldPropertyAssociation4252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2023:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2024:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2024:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2025:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation4272);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleFieldPropertyAssociation4285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPathElement"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2054:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2055:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2056:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement4319);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentPathElement4329); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2063:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) ) ) ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2066:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2067:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2067:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==KEYWORD_23) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2067:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2067:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2067:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2067:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2068:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2068:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2069:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContainmentPathElement4379); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2083:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==KEYWORD_9) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2084:1: (lv_arrayRange_1_0= ruleArrayRange )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2084:1: (lv_arrayRange_1_0= ruleArrayRange )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2085:3: lv_arrayRange_1_0= ruleArrayRange
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleArrayRange_in_ruleContainmentPathElement4400);
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
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2102:6: (otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2102:6: (otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2103:2: otherlv_2= KEYWORD_23 ( ( ruleANNEXREF ) )
                    {
                    otherlv_2=(Token)match(input,KEYWORD_23,FollowSets000.FOLLOW_KEYWORD_23_in_ruleContainmentPathElement4422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getAnnexKeyword_1_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2107:1: ( ( ruleANNEXREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2108:1: ( ruleANNEXREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2108:1: ( ruleANNEXREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2109:3: ruleANNEXREF
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement4448);
                    ruleANNEXREF();

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
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRuleANNEXREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2133:1: entryRuleANNEXREF returns [String current=null] : iv_ruleANNEXREF= ruleANNEXREF EOF ;
    public final String entryRuleANNEXREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleANNEXREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2134:1: (iv_ruleANNEXREF= ruleANNEXREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2135:2: iv_ruleANNEXREF= ruleANNEXREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANNEXREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF4485);
            iv_ruleANNEXREF=ruleANNEXREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleANNEXREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleANNEXREF4496); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleANNEXREF"


    // $ANTLR start "ruleANNEXREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2142:1: ruleANNEXREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_11 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_12 ) ;
    public final AntlrDatatypeRuleToken ruleANNEXREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_3=null;
        AntlrDatatypeRuleToken this_STAR_1 = null;

        AntlrDatatypeRuleToken this_STAR_2 = null;

        AntlrDatatypeRuleToken this_STAR_4 = null;

        AntlrDatatypeRuleToken this_STAR_5 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2146:6: ( (kw= KEYWORD_11 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_12 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2147:1: (kw= KEYWORD_11 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_12 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2147:1: (kw= KEYWORD_11 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_12 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2148:2: kw= KEYWORD_11 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_12
            {
            kw=(Token)match(input,KEYWORD_11,FollowSets000.FOLLOW_KEYWORD_11_in_ruleANNEXREF4534); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getANNEXREFAccess().getLeftCurlyBracketKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_1()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF4556);
            this_STAR_1=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_2()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF4583);
            this_STAR_2=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleANNEXREF4603); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_3);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_3, grammarAccess.getANNEXREFAccess().getIDTerminalRuleCall_3()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_4()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF4630);
            this_STAR_4=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_4);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_5()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF4657);
            this_STAR_5=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_5);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            kw=(Token)match(input,KEYWORD_12,FollowSets000.FOLLOW_KEYWORD_12_in_ruleANNEXREF4675); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getANNEXREFAccess().getRightCurlyBracketKeyword_6()); 
                  
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
    // $ANTLR end "ruleANNEXREF"


    // $ANTLR start "entryRuleAndOp"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2218:1: entryRuleAndOp returns [String current=null] : iv_ruleAndOp= ruleAndOp EOF ;
    public final String entryRuleAndOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAndOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2219:1: (iv_ruleAndOp= ruleAndOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2220:2: iv_ruleAndOp= ruleAndOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndOpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAndOp_in_entryRuleAndOp4715);
            iv_ruleAndOp=ruleAndOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndOp.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAndOp4726); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndOp"


    // $ANTLR start "ruleAndOp"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2227:1: ruleAndOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_20 ;
    public final AntlrDatatypeRuleToken ruleAndOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2231:6: (kw= KEYWORD_20 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2233:2: kw= KEYWORD_20
            {
            kw=(Token)match(input,KEYWORD_20,FollowSets000.FOLLOW_KEYWORD_20_in_ruleAndOp4763); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAndOpAccess().getAndKeyword()); 
                  
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
    // $ANTLR end "ruleAndOp"


    // $ANTLR start "entryRuleOrOp"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2246:1: entryRuleOrOp returns [String current=null] : iv_ruleOrOp= ruleOrOp EOF ;
    public final String entryRuleOrOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOrOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2247:1: (iv_ruleOrOp= ruleOrOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2248:2: iv_ruleOrOp= ruleOrOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrOpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOrOp_in_entryRuleOrOp4802);
            iv_ruleOrOp=ruleOrOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrOp.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOrOp4813); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrOp"


    // $ANTLR start "ruleOrOp"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2255:1: ruleOrOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_17 ;
    public final AntlrDatatypeRuleToken ruleOrOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2259:6: (kw= KEYWORD_17 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2261:2: kw= KEYWORD_17
            {
            kw=(Token)match(input,KEYWORD_17,FollowSets000.FOLLOW_KEYWORD_17_in_ruleOrOp4850); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getOrOpAccess().getOrKeyword()); 
                  
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
    // $ANTLR end "ruleOrOp"


    // $ANTLR start "entryRuleNotOp"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2274:1: entryRuleNotOp returns [String current=null] : iv_ruleNotOp= ruleNotOp EOF ;
    public final String entryRuleNotOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNotOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2275:1: (iv_ruleNotOp= ruleNotOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2276:2: iv_ruleNotOp= ruleNotOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotOpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNotOp_in_entryRuleNotOp4889);
            iv_ruleNotOp=ruleNotOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotOp.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNotOp4900); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotOp"


    // $ANTLR start "ruleNotOp"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2283:1: ruleNotOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_21 ;
    public final AntlrDatatypeRuleToken ruleNotOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2287:6: (kw= KEYWORD_21 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2289:2: kw= KEYWORD_21
            {
            kw=(Token)match(input,KEYWORD_21,FollowSets000.FOLLOW_KEYWORD_21_in_ruleNotOp4937); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getNotOpAccess().getNotKeyword()); 
                  
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
    // $ANTLR end "ruleNotOp"


    // $ANTLR start "entryRulePlusMinus"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2302:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2303:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2304:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_entryRulePlusMinus4976);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePlusMinus4987); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2311:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_4 | kw= KEYWORD_6 ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2315:6: ( (kw= KEYWORD_4 | kw= KEYWORD_6 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2316:1: (kw= KEYWORD_4 | kw= KEYWORD_6 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2316:1: (kw= KEYWORD_4 | kw= KEYWORD_6 )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==KEYWORD_4) ) {
                alt27=1;
            }
            else if ( (LA27_0==KEYWORD_6) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2317:2: kw= KEYWORD_4
                    {
                    kw=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_rulePlusMinus5025); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2324:2: kw= KEYWORD_6
                    {
                    kw=(Token)match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_rulePlusMinus5044); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); 
                          
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
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2337:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2338:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2339:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringTerm_in_entryRuleStringTerm5083);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringTerm5093); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2346:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2349:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2350:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2350:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2351:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2351:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2352:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNoQuoteString_in_ruleStringTerm5138);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2376:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2377:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2378:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString5173);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNoQuoteString5184); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2385:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2389:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2390:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNoQuoteString5223); if (state.failed) return current;
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


    // $ANTLR start "entryRuleArrayRange"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2405:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2406:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2407:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleArrayRange_in_entryRuleArrayRange5266);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleArrayRange5276); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2414:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= KEYWORD_9 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_10 ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2417:28: ( ( () otherlv_1= KEYWORD_9 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_10 ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2418:1: ( () otherlv_1= KEYWORD_9 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_10 )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2418:1: ( () otherlv_1= KEYWORD_9 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_10 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2418:2: () otherlv_1= KEYWORD_9 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_10
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2418:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2419:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_ruleArrayRange5326); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2432:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2433:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2433:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2434:3: lv_lowerBound_2_0= ruleINTVALUE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleINTVALUE_in_ruleArrayRange5346);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
              	        }
                     		set(
                     			current, 
                     			"lowerBound",
                      		lv_lowerBound_2_0, 
                      		"INTVALUE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2450:2: (otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==KEYWORD_13) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2451:2: otherlv_3= KEYWORD_13 ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,KEYWORD_13,FollowSets000.FOLLOW_KEYWORD_13_in_ruleArrayRange5360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2455:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2456:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2456:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2457:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleINTVALUE_in_ruleArrayRange5380);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_4_0, 
                              		"INTVALUE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,KEYWORD_10,FollowSets000.FOLLOW_KEYWORD_10_in_ruleArrayRange5395); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
                  
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


    // $ANTLR start "entryRuleSignedConstant"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2486:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2487:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2488:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant5429);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedConstant; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignedConstant5439); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedConstant"


    // $ANTLR start "ruleSignedConstant"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2495:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2498:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2499:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2499:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2499:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2499:2: ( (lv_op_0_0= rulePlusMinus ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2500:1: (lv_op_0_0= rulePlusMinus )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2500:1: (lv_op_0_0= rulePlusMinus )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2501:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_ruleSignedConstant5485);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              	        }
                     		set(
                     			current, 
                     			"op",
                      		lv_op_0_0, 
                      		"PlusMinus");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2517:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2518:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2518:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2519:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleSignedConstant5506);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPropertyExpression",
                      		lv_ownedPropertyExpression_1_0, 
                      		"ConstantValue");
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
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleIntegerTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2543:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2544:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2545:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm5541);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerTerm5551); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2552:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2555:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2556:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2556:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2556:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2556:2: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2557:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2557:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2558:3: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSignedInt_in_ruleIntegerTerm5597);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIntegerTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"SignedInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2574:2: ( (otherlv_1= RULE_ID ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2575:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2575:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2576:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIntegerTerm5621); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
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
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleSignedInt"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2598:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2599:1: (iv_ruleSignedInt= ruleSignedInt EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2600:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedIntRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSignedInt_in_entryRuleSignedInt5658);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedInt.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignedInt5669); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInt"


    // $ANTLR start "ruleSignedInt"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2607:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2611:6: ( ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2612:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2612:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2612:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2612:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )?
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==KEYWORD_4) ) {
                alt30=1;
            }
            else if ( (LA30_0==KEYWORD_6) ) {
                alt30=2;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2613:2: kw= KEYWORD_4
                    {
                    kw=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleSignedInt5708); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2620:2: kw= KEYWORD_6
                    {
                    kw=(Token)match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_ruleSignedInt5727); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt5744); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); 
                  
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
    // $ANTLR end "ruleSignedInt"


    // $ANTLR start "entryRuleRealTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2640:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2641:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2642:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_entryRuleRealTerm5788);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealTerm5798); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2649:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2652:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2653:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2653:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2653:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2653:2: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2654:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2654:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2655:3: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleSignedReal_in_ruleRealTerm5844);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRealTermRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"SignedReal");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2671:2: ( (otherlv_1= RULE_ID ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2672:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2672:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2673:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRealTerm5868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                      	
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
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleSignedReal"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2695:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2696:1: (iv_ruleSignedReal= ruleSignedReal EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2697:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRealRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSignedReal_in_entryRuleSignedReal5905);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedReal.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignedReal5916); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedReal"


    // $ANTLR start "ruleSignedReal"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2704:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2708:6: ( ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2709:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2709:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2709:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2709:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )?
            int alt32=3;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==KEYWORD_4) ) {
                alt32=1;
            }
            else if ( (LA32_0==KEYWORD_6) ) {
                alt32=2;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2710:2: kw= KEYWORD_4
                    {
                    kw=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleSignedReal5955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2717:2: kw= KEYWORD_6
                    {
                    kw=(Token)match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_ruleSignedReal5974); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FollowSets000.FOLLOW_RULE_REAL_LIT_in_ruleSignedReal5991); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); 
                  
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
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2737:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2738:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2739:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm6035);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericRangeTerm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericRangeTerm6045); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericRangeTerm"


    // $ANTLR start "ruleNumericRangeTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2746:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_13 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2749:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_13 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2750:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_13 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2750:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_13 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2750:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_13 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2750:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2751:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2751:1: (lv_minimum_0_0= ruleNumAlt )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2752:3: lv_minimum_0_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm6091);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              	        }
                     		set(
                     			current, 
                     			"minimum",
                      		lv_minimum_0_0, 
                      		"NumAlt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_13,FollowSets000.FOLLOW_KEYWORD_13_in_ruleNumericRangeTerm6104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2773:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2774:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2774:1: (lv_maximum_2_0= ruleNumAlt )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2775:3: lv_maximum_2_0= ruleNumAlt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm6124);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
              	        }
                     		set(
                     			current, 
                     			"maximum",
                      		lv_maximum_2_0, 
                      		"NumAlt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2791:2: (otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==KEYWORD_24) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2792:2: otherlv_3= KEYWORD_24 ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,KEYWORD_24,FollowSets000.FOLLOW_KEYWORD_24_in_ruleNumericRangeTerm6138); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2796:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2797:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2797:1: (lv_delta_4_0= ruleNumAlt )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2798:3: lv_delta_4_0= ruleNumAlt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm6158);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"delta",
                              		lv_delta_4_0, 
                              		"NumAlt");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2822:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2823:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2824:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumAltRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_entryRuleNumAlt6195);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumAlt; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumAlt6205); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2831:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2834:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2835:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2835:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt34=4;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt34=3;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt34=2;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt34=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }

                }
                break;
            case KEYWORD_6:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt34=1;
                    }
                    break;
                case RULE_ID:
                    {
                    alt34=3;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt34=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt34=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt34=2;
                }
                break;
            case RULE_ID:
                {
                alt34=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2836:2: this_RealTerm_0= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_ruleNumAlt6255);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_RealTerm_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2849:2: this_IntegerTerm_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_ruleNumAlt6285);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntegerTerm_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2862:2: this_SignedConstant_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_ruleNumAlt6315);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SignedConstant_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2875:2: this_ConstantValue_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleNumAlt6345);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ConstantValue_3;
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
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleINTVALUE"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2894:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2895:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2896:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINTVALUERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE6380);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINTVALUE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINTVALUE6391); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2903:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2907:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2908:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE6430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INTEGER_LIT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
                  
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
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2923:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2924:1: (iv_ruleQPREF= ruleQPREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2925:2: iv_ruleQPREF= ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_entryRuleQPREF6474);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQPREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQPREF6485); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2932:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= KEYWORD_14 this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2936:6: ( (this_ID_0= RULE_ID (kw= KEYWORD_14 this_ID_2= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2937:1: (this_ID_0= RULE_ID (kw= KEYWORD_14 this_ID_2= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2937:1: (this_ID_0= RULE_ID (kw= KEYWORD_14 this_ID_2= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2937:6: this_ID_0= RULE_ID (kw= KEYWORD_14 this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQPREF6525); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2944:1: (kw= KEYWORD_14 this_ID_2= RULE_ID )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==KEYWORD_14) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2945:2: kw= KEYWORD_14 this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,KEYWORD_14,FollowSets000.FOLLOW_KEYWORD_14_in_ruleQPREF6544); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQPREF6559); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
                          
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
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2965:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2966:1: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2967:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQCREF_in_entryRuleQCREF6606);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQCREF6617); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2974:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= KEYWORD_14 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2978:6: ( ( (this_ID_0= RULE_ID kw= KEYWORD_14 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2979:1: ( (this_ID_0= RULE_ID kw= KEYWORD_14 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2979:1: ( (this_ID_0= RULE_ID kw= KEYWORD_14 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2979:2: (this_ID_0= RULE_ID kw= KEYWORD_14 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2979:2: (this_ID_0= RULE_ID kw= KEYWORD_14 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==KEYWORD_14) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2979:7: this_ID_0= RULE_ID kw= KEYWORD_14
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQCREF6658); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,KEYWORD_14,FollowSets000.FOLLOW_KEYWORD_14_in_ruleQCREF6676); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQCREF6693); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:2999:1: (kw= KEYWORD_7 this_ID_4= RULE_ID )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==KEYWORD_7) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3000:2: kw= KEYWORD_7 this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleQCREF6712); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQCREF6727); if (state.failed) return current;
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


    // $ANTLR start "entryRuleSTAR"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3020:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3021:1: (iv_ruleSTAR= ruleSTAR EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3022:2: iv_ruleSTAR= ruleSTAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTARRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_entryRuleSTAR6774);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTAR.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSTAR6785); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTAR"


    // $ANTLR start "ruleSTAR"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3029:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_3 ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3033:6: (kw= KEYWORD_3 )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:3035:2: kw= KEYWORD_3
            {
            kw=(Token)match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_ruleSTAR6822); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword()); 
                  
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
    // $ANTLR end "ruleSTAR"

    // $ANTLR start synpred1_InternalPropertiesParser
    public final void synpred1_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_ContainedPropertyAssociation_0 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:82:2: (this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:82:2: this_ContainedPropertyAssociation_0= ruleContainedPropertyAssociation
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleContainedPropertyAssociation_in_synpred1_InternalPropertiesParser133);
        this_ContainedPropertyAssociation_0=ruleContainedPropertyAssociation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalPropertiesParser

    // $ANTLR start synpred2_InternalPropertiesParser
    public final void synpred2_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_BasicPropertyAssociation_1 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:95:2: (this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:95:2: this_BasicPropertyAssociation_1= ruleBasicPropertyAssociation
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleBasicPropertyAssociation_in_synpred2_InternalPropertiesParser163);
        this_BasicPropertyAssociation_1=ruleBasicPropertyAssociation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalPropertiesParser

    // $ANTLR start synpred6_InternalPropertiesParser
    public final void synpred6_InternalPropertiesParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_ownedValue_5_0 = null;

        EObject lv_ownedValue_7_0 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:196:4: ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:196:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
        {
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:196:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:197:2: otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2
        {
        otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_synpred6_InternalPropertiesParser385); if (state.failed) return ;
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:201:1: ( (lv_ownedValue_5_0= ruleModalPropertyValue ) )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:202:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
        {
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:202:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:203:3: lv_ownedValue_5_0= ruleModalPropertyValue
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_synpred6_InternalPropertiesParser405);
        lv_ownedValue_5_0=ruleModalPropertyValue();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:219:2: (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )*
        loop38:
        do {
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==KEYWORD_5) ) {
                alt38=1;
            }


            switch (alt38) {
        	case 1 :
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:220:2: otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
        	    {
        	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_synpred6_InternalPropertiesParser419); if (state.failed) return ;
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:224:1: ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:225:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
        	    {
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:225:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:226:3: lv_ownedValue_7_0= ruleModalPropertyValue
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_synpred6_InternalPropertiesParser439);
        	    lv_ownedValue_7_0=ruleModalPropertyValue();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop38;
            }
        } while (true);

        otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_synpred6_InternalPropertiesParser454); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalPropertiesParser

    // $ANTLR start synpred12_InternalPropertiesParser
    public final void synpred12_InternalPropertiesParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_ownedValue_5_0 = null;

        EObject lv_ownedValue_7_0 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:399:4: ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:399:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
        {
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:399:4: (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:400:2: otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2
        {
        otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_synpred12_InternalPropertiesParser771); if (state.failed) return ;
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:404:1: ( (lv_ownedValue_5_0= ruleModalPropertyValue ) )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:405:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
        {
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:405:1: (lv_ownedValue_5_0= ruleModalPropertyValue )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:406:3: lv_ownedValue_5_0= ruleModalPropertyValue
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_synpred12_InternalPropertiesParser791);
        lv_ownedValue_5_0=ruleModalPropertyValue();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:422:2: (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )*
        loop40:
        do {
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==KEYWORD_5) ) {
                alt40=1;
            }


            switch (alt40) {
        	case 1 :
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:423:2: otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
        	    {
        	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_synpred12_InternalPropertiesParser805); if (state.failed) return ;
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:427:1: ( (lv_ownedValue_7_0= ruleModalPropertyValue ) )
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:428:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
        	    {
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:428:1: (lv_ownedValue_7_0= ruleModalPropertyValue )
        	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:429:3: lv_ownedValue_7_0= ruleModalPropertyValue
        	    {
        	    if ( state.backtracking==0 ) {
        	       
        	      	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getOwnedValueModalPropertyValueParserRuleCall_3_0_2_1_0()); 
        	      	    
        	    }
        	    pushFollow(FollowSets000.FOLLOW_ruleModalPropertyValue_in_synpred12_InternalPropertiesParser825);
        	    lv_ownedValue_7_0=ruleModalPropertyValue();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }


        	    }


        	    }
        	    break;

        	default :
        	    break loop40;
            }
        } while (true);

        otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_synpred12_InternalPropertiesParser840); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalPropertiesParser

    // $ANTLR start synpred15_InternalPropertiesParser
    public final void synpred15_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_RecordTerm_0 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:769:2: (this_RecordTerm_0= ruleRecordTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:769:2: this_RecordTerm_0= ruleRecordTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleRecordTerm_in_synpred15_InternalPropertiesParser1547);
        this_RecordTerm_0=ruleRecordTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalPropertiesParser

    // $ANTLR start synpred20_InternalPropertiesParser
    public final void synpred20_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_NumericRangeTerm_5 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:834:2: (this_NumericRangeTerm_5= ruleNumericRangeTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:834:2: this_NumericRangeTerm_5= ruleNumericRangeTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleNumericRangeTerm_in_synpred20_InternalPropertiesParser1697);
        this_NumericRangeTerm_5=ruleNumericRangeTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalPropertiesParser

    // $ANTLR start synpred21_InternalPropertiesParser
    public final void synpred21_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_RealTerm_6 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:847:2: (this_RealTerm_6= ruleRealTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:847:2: this_RealTerm_6= ruleRealTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_synpred21_InternalPropertiesParser1727);
        this_RealTerm_6=ruleRealTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalPropertiesParser

    // $ANTLR start synpred22_InternalPropertiesParser
    public final void synpred22_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_IntegerTerm_7 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:860:2: (this_IntegerTerm_7= ruleIntegerTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:860:2: this_IntegerTerm_7= ruleIntegerTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_synpred22_InternalPropertiesParser1757);
        this_IntegerTerm_7=ruleIntegerTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalPropertiesParser

    // $ANTLR start synpred23_InternalPropertiesParser
    public final void synpred23_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_ListTerm_8 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:873:2: (this_ListTerm_8= ruleListTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:873:2: this_ListTerm_8= ruleListTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleListTerm_in_synpred23_InternalPropertiesParser1787);
        this_ListTerm_8=ruleListTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalPropertiesParser

    // $ANTLR start synpred24_InternalPropertiesParser
    public final void synpred24_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_ActualBooleanTerm_9 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:886:2: (this_ActualBooleanTerm_9= ruleActualBooleanTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:886:2: this_ActualBooleanTerm_9= ruleActualBooleanTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleActualBooleanTerm_in_synpred24_InternalPropertiesParser1817);
        this_ActualBooleanTerm_9=ruleActualBooleanTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalPropertiesParser

    // $ANTLR start synpred25_InternalPropertiesParser
    public final void synpred25_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_ActualOrTerm_0 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:971:2: (this_ActualOrTerm_0= ruleActualOrTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:971:2: this_ActualOrTerm_0= ruleActualOrTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleActualOrTerm_in_synpred25_InternalPropertiesParser2036);
        this_ActualOrTerm_0=ruleActualOrTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalPropertiesParser

    // $ANTLR start synpred26_InternalPropertiesParser
    public final void synpred26_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_ActualAndTerm_1 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:984:2: (this_ActualAndTerm_1= ruleActualAndTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:984:2: this_ActualAndTerm_1= ruleActualAndTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleActualAndTerm_in_synpred26_InternalPropertiesParser2066);
        this_ActualAndTerm_1=ruleActualAndTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalPropertiesParser

    // $ANTLR start synpred27_InternalPropertiesParser
    public final void synpred27_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_BooleanLiteral_2 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:997:2: (this_BooleanLiteral_2= ruleBooleanLiteral )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:997:2: this_BooleanLiteral_2= ruleBooleanLiteral
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_synpred27_InternalPropertiesParser2096);
        this_BooleanLiteral_2=ruleBooleanLiteral();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalPropertiesParser

    // $ANTLR start synpred28_InternalPropertiesParser
    public final void synpred28_InternalPropertiesParser_fragment() throws RecognitionException {   
        EObject this_NotTerm_3 = null;


        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1010:2: (this_NotTerm_3= ruleNotTerm )
        // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalPropertiesParser.g:1010:2: this_NotTerm_3= ruleNotTerm
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleNotTerm_in_synpred28_InternalPropertiesParser2126);
        this_NotTerm_3=ruleNotTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalPropertiesParser

    // Delegated rules

    public final boolean synpred25_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalPropertiesParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalPropertiesParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA5_eotS =
        "\17\uffff";
    static final String DFA5_eofS =
        "\17\uffff";
    static final String DFA5_minS =
        "\1\4\1\0\15\uffff";
    static final String DFA5_maxS =
        "\1\54\1\0\15\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\13\uffff\1\1";
    static final String DFA5_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\2\2\uffff\1\2\2\uffff\1\2\1\uffff\1\2\2\uffff\1\2\6\uffff"+
            "\1\1\2\uffff\1\2\1\uffff\1\2\12\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\2\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "196:3: ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_1 = input.LA(1);

                         
                        int index5_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred6_InternalPropertiesParser()) ) {s = 14;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index5_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA11_eotS =
        "\17\uffff";
    static final String DFA11_eofS =
        "\17\uffff";
    static final String DFA11_minS =
        "\1\4\1\0\15\uffff";
    static final String DFA11_maxS =
        "\1\54\1\0\15\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\13\uffff\1\1";
    static final String DFA11_specialS =
        "\1\uffff\1\0\15\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\2\2\uffff\1\2\2\uffff\1\2\1\uffff\1\2\2\uffff\1\2\6\uffff"+
            "\1\1\2\uffff\1\2\1\uffff\1\2\12\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\2\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "399:3: ( (otherlv_4= KEYWORD_1 ( (lv_ownedValue_5_0= ruleModalPropertyValue ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedValue_7_0= ruleModalPropertyValue ) ) )* otherlv_8= KEYWORD_2 ) | ( (lv_ownedValue_9_0= rulePropertyValue ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalPropertiesParser()) ) {s = 14;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA14_eotS =
        "\24\uffff";
    static final String DFA14_eofS =
        "\24\uffff";
    static final String DFA14_minS =
        "\1\4\1\0\4\uffff\5\0\11\uffff";
    static final String DFA14_maxS =
        "\1\54\1\0\4\uffff\5\0\11\uffff";
    static final String DFA14_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\5\uffff\1\12\2\uffff\1\1\1\11\1\6\1\7"+
        "\1\10\1\13";
    static final String DFA14_specialS =
        "\1\uffff\1\0\4\uffff\1\1\1\2\1\3\1\4\1\5\11\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\3\1\2\2\uffff\1\4\2\uffff\1\13\1\uffff\1\13\2\uffff\1\13"+
            "\6\uffff\1\1\2\uffff\1\6\1\uffff\1\7\12\uffff\1\10\1\uffff\1"+
            "\11\1\uffff\1\5\1\12",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
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
            return "768:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_ComponentClassifierTerm_2= ruleComponentClassifierTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_NumericRangeTerm_5= ruleNumericRangeTerm | this_RealTerm_6= ruleRealTerm | this_IntegerTerm_7= ruleIntegerTerm | this_ListTerm_8= ruleListTerm | this_ActualBooleanTerm_9= ruleActualBooleanTerm | this_LiteralorReferenceTerm_10= ruleLiteralorReferenceTerm )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_1 = input.LA(1);

                         
                        int index14_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalPropertiesParser()) ) {s = 14;}

                        else if ( (synpred23_InternalPropertiesParser()) ) {s = 15;}

                        else if ( (synpred24_InternalPropertiesParser()) ) {s = 11;}

                         
                        input.seek(index14_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_6 = input.LA(1);

                         
                        int index14_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPropertiesParser()) ) {s = 16;}

                        else if ( (synpred21_InternalPropertiesParser()) ) {s = 17;}

                        else if ( (synpred22_InternalPropertiesParser()) ) {s = 18;}

                         
                        input.seek(index14_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_7 = input.LA(1);

                         
                        int index14_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPropertiesParser()) ) {s = 16;}

                        else if ( (synpred21_InternalPropertiesParser()) ) {s = 17;}

                        else if ( (synpred22_InternalPropertiesParser()) ) {s = 18;}

                         
                        input.seek(index14_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA14_8 = input.LA(1);

                         
                        int index14_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPropertiesParser()) ) {s = 16;}

                        else if ( (synpred21_InternalPropertiesParser()) ) {s = 17;}

                         
                        input.seek(index14_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA14_9 = input.LA(1);

                         
                        int index14_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPropertiesParser()) ) {s = 16;}

                        else if ( (synpred22_InternalPropertiesParser()) ) {s = 18;}

                         
                        input.seek(index14_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA14_10 = input.LA(1);

                         
                        int index14_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalPropertiesParser()) ) {s = 16;}

                        else if ( (synpred24_InternalPropertiesParser()) ) {s = 11;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index14_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA15_eotS =
        "\13\uffff";
    static final String DFA15_eofS =
        "\13\uffff";
    static final String DFA15_minS =
        "\1\13\5\0\5\uffff";
    static final String DFA15_maxS =
        "\1\54\5\0\5\uffff";
    static final String DFA15_acceptS =
        "\6\uffff\1\1\1\2\1\3\1\4\1\5";
    static final String DFA15_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\1\uffff\1\1\2\uffff\1\3\6\uffff\1\5\24\uffff\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "970:1: (this_ActualOrTerm_0= ruleActualOrTerm | this_ActualAndTerm_1= ruleActualAndTerm | this_BooleanLiteral_2= ruleBooleanLiteral | this_NotTerm_3= ruleNotTerm | this_ConstantValue_4= ruleConstantValue )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_1 = input.LA(1);

                         
                        int index15_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalPropertiesParser()) ) {s = 6;}

                        else if ( (synpred26_InternalPropertiesParser()) ) {s = 7;}

                        else if ( (synpred27_InternalPropertiesParser()) ) {s = 8;}

                         
                        input.seek(index15_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_2 = input.LA(1);

                         
                        int index15_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalPropertiesParser()) ) {s = 6;}

                        else if ( (synpred26_InternalPropertiesParser()) ) {s = 7;}

                        else if ( (synpred27_InternalPropertiesParser()) ) {s = 8;}

                         
                        input.seek(index15_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_3 = input.LA(1);

                         
                        int index15_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalPropertiesParser()) ) {s = 6;}

                        else if ( (synpred26_InternalPropertiesParser()) ) {s = 7;}

                        else if ( (synpred28_InternalPropertiesParser()) ) {s = 9;}

                         
                        input.seek(index15_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_4 = input.LA(1);

                         
                        int index15_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalPropertiesParser()) ) {s = 6;}

                        else if ( (synpred26_InternalPropertiesParser()) ) {s = 7;}

                        else if ( (true) ) {s = 10;}

                         
                        input.seek(index15_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_5 = input.LA(1);

                         
                        int index15_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalPropertiesParser()) ) {s = 6;}

                        else if ( (synpred26_InternalPropertiesParser()) ) {s = 7;}

                         
                        input.seek(index15_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_rulePModel_in_entryRulePModel73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePModel83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_rulePModel133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBasicPropertyAssociation_in_rulePModel163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyAssociation_in_rulePModel193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation227 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainedPropertyAssociation237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation289 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_KEYWORD_15_in_ruleContainedPropertyAssociation303 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_KEYWORD_19_in_ruleContainedPropertyAssociation327 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_KEYWORD_29_in_ruleContainedPropertyAssociation358 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleContainedPropertyAssociation385 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_ruleContainedPropertyAssociation405 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation419 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_ruleContainedPropertyAssociation439 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleContainedPropertyAssociation454 = new BitSet(new long[]{0x0000000040000080L});
        public static final BitSet FOLLOW_rulePropertyValue_in_ruleContainedPropertyAssociation481 = new BitSet(new long[]{0x0000000040000080L});
        public static final BitSet FOLLOW_KEYWORD_27_in_ruleContainedPropertyAssociation496 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_KEYWORD_18_in_ruleContainedPropertyAssociation508 = new BitSet(new long[]{0x0000100000000200L});
        public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation528 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation542 = new BitSet(new long[]{0x0000100000000200L});
        public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation562 = new BitSet(new long[]{0x0000000048000000L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleContainedPropertyAssociation579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyAssociation_in_entryRulePropertyAssociation613 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociation623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyAssociation675 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_KEYWORD_15_in_rulePropertyAssociation689 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_KEYWORD_19_in_rulePropertyAssociation713 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_KEYWORD_29_in_rulePropertyAssociation744 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_KEYWORD_1_in_rulePropertyAssociation771 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_rulePropertyAssociation791 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_rulePropertyAssociation805 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_rulePropertyAssociation825 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_rulePropertyAssociation840 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rulePropertyValue_in_rulePropertyAssociation867 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_KEYWORD_8_in_rulePropertyAssociation881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBasicPropertyAssociation_in_entryRuleBasicPropertyAssociation915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBasicPropertyAssociation925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleBasicPropertyAssociation977 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_KEYWORD_15_in_ruleBasicPropertyAssociation990 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_rulePropertyValue_in_ruleBasicPropertyAssociation1010 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleBasicPropertyAssociation1023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath1057 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPath1067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath1125 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleContainmentPath1139 = new BitSet(new long[]{0x0000100000000200L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath1159 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_entryRuleModalPropertyValue1196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModalPropertyValue1206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleModalPropertyValue1252 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_KEYWORD_16_in_ruleModalPropertyValue1265 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_KEYWORD_26_in_ruleModalPropertyValue1277 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleModalPropertyValue1289 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModalPropertyValue1312 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleModalPropertyValue1326 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModalPropertyValue1349 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleModalPropertyValue1364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyValue_in_entryRulePropertyValue1398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyValue1408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyValue1453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression1487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression1497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordTerm_in_rulePropertyExpression1547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceTerm_in_rulePropertyExpression1577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression1607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComputedTerm_in_rulePropertyExpression1637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringTerm_in_rulePropertyExpression1667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression1697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_rulePropertyExpression1727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_rulePropertyExpression1757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTerm_in_rulePropertyExpression1787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualBooleanTerm_in_rulePropertyExpression1817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression1847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm1881 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm1891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm1942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualBooleanTerm_in_entryRuleActualBooleanTerm1976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleActualBooleanTerm1986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualOrTerm_in_ruleActualBooleanTerm2036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualAndTerm_in_ruleActualBooleanTerm2066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleActualBooleanTerm2096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotTerm_in_ruleActualBooleanTerm2126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleActualBooleanTerm2156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualOrTerm_in_entryRuleActualOrTerm2190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleActualOrTerm2200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndTerm_in_ruleActualOrTerm2246 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_ruleOrOp_in_ruleActualOrTerm2267 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleAndTerm_in_ruleActualOrTerm2288 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleOrOp_in_ruleActualOrTerm2310 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleAndTerm_in_ruleActualOrTerm2331 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleActualAndTerm_in_entryRuleActualAndTerm2368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleActualAndTerm2378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleActualAndTerm2424 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_ruleAndOp_in_ruleActualAndTerm2445 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleActualAndTerm2466 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleAndOp_in_ruleActualAndTerm2488 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleActualAndTerm2509 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleBooleanTerm_in_entryRuleBooleanTerm2546 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTerm2556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrTerm_in_ruleBooleanTerm2605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrTerm_in_entryRuleOrTerm2638 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOrTerm2648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndTerm_in_ruleOrTerm2698 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleOrOp_in_ruleOrTerm2731 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleAndTerm_in_ruleOrTerm2752 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleAndTerm_in_entryRuleAndTerm2789 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndTerm2799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleAndTerm2849 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleAndOp_in_ruleAndTerm2882 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleAndTerm2903 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleNotTerm_in_entryRuleNotTerm2940 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotTerm2950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotOp_in_ruleNotTerm2996 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleNotTerm3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanAtom_in_entryRuleBooleanAtom3052 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAtom3062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleBooleanAtom3112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotTerm_in_ruleBooleanAtom3142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleBooleanAtom3172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleBooleanAtom3191 = new BitSet(new long[]{0x0000128014812800L});
        public static final BitSet FOLLOW_ruleBooleanTerm_in_ruleBooleanAtom3215 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleBooleanAtom3227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral3262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral3272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_22_in_ruleBooleanLiteral3329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_25_in_ruleBooleanLiteral3359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue3394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue3404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleConstantValue3455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm3489 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceTerm3499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_30_in_ruleReferenceTerm3537 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleReferenceTerm3549 = new BitSet(new long[]{0x0000100000000200L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm3569 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleReferenceTerm3583 = new BitSet(new long[]{0x0000100000000200L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm3603 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleReferenceTerm3618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm3652 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecordTerm3662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleRecordTerm3700 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm3720 = new BitSet(new long[]{0x0000100001000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleRecordTerm3734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm3768 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComputedTerm3778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_28_in_ruleComputedTerm3816 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleComputedTerm3828 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComputedTerm3844 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleComputedTerm3862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm3896 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComponentClassifierTerm3906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_31_in_ruleComponentClassifierTerm3944 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleComponentClassifierTerm3956 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm3982 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleComponentClassifierTerm3995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTerm_in_entryRuleListTerm4029 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListTerm4039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleListTerm4077 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm4097 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleListTerm4111 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm4131 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleListTerm4146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation4180 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFieldPropertyAssociation4190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation4239 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_KEYWORD_15_in_ruleFieldPropertyAssociation4252 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation4272 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleFieldPropertyAssociation4285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement4319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement4329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentPathElement4379 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement4400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_23_in_ruleContainmentPathElement4422 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement4448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF4485 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleANNEXREF4496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_11_in_ruleANNEXREF4534 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF4556 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF4583 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleANNEXREF4603 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF4630 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF4657 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_KEYWORD_12_in_ruleANNEXREF4675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAndOp_in_entryRuleAndOp4715 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAndOp4726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_20_in_ruleAndOp4763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrOp_in_entryRuleOrOp4802 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOrOp4813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_17_in_ruleOrOp4850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotOp_in_entryRuleNotOp4889 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNotOp4900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_21_in_ruleNotOp4937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus4976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus4987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_rulePlusMinus5025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_6_in_rulePlusMinus5044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm5083 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm5093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm5138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString5173 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString5184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString5223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange5266 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange5276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_9_in_ruleArrayRange5326 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange5346 = new BitSet(new long[]{0x0000000100020000L});
        public static final BitSet FOLLOW_KEYWORD_13_in_ruleArrayRange5360 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange5380 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_KEYWORD_10_in_ruleArrayRange5395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant5429 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignedConstant5439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePlusMinus_in_ruleSignedConstant5485 = new BitSet(new long[]{0x0000128014000000L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleSignedConstant5506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm5541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm5551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerTerm5597 = new BitSet(new long[]{0x0000100000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm5621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedInt_in_entryRuleSignedInt5658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignedInt5669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleSignedInt5708 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_KEYWORD_6_in_ruleSignedInt5727 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt5744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm5788 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm5798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealTerm5844 = new BitSet(new long[]{0x0000100000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm5868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedReal_in_entryRuleSignedReal5905 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignedReal5916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleSignedReal5955 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_KEYWORD_6_in_ruleSignedReal5974 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleSignedReal5991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm6035 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericRangeTerm6045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm6091 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_KEYWORD_13_in_ruleNumericRangeTerm6104 = new BitSet(new long[]{0x0000128014000000L});
        public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm6124 = new BitSet(new long[]{0x0000000000000402L});
        public static final BitSet FOLLOW_KEYWORD_24_in_ruleNumericRangeTerm6138 = new BitSet(new long[]{0x0000128014000000L});
        public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm6158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt6195 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt6205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumAlt6255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumAlt6285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumAlt6315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumAlt6345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE6380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE6391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE6430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_entryRuleQPREF6474 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQPREF6485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF6525 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_KEYWORD_14_in_ruleQPREF6544 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF6559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF6606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQCREF6617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF6658 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_KEYWORD_14_in_ruleQCREF6676 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF6693 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleQCREF6712 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF6727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTAR_in_entryRuleSTAR6774 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSTAR6785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_3_in_ruleSTAR6822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_synpred1_InternalPropertiesParser133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBasicPropertyAssociation_in_synpred2_InternalPropertiesParser163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_synpred6_InternalPropertiesParser385 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_synpred6_InternalPropertiesParser405 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_synpred6_InternalPropertiesParser419 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_synpred6_InternalPropertiesParser439 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_synpred6_InternalPropertiesParser454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_synpred12_InternalPropertiesParser771 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_synpred12_InternalPropertiesParser791 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_5_in_synpred12_InternalPropertiesParser805 = new BitSet(new long[]{0x00001A8014812970L});
        public static final BitSet FOLLOW_ruleModalPropertyValue_in_synpred12_InternalPropertiesParser825 = new BitSet(new long[]{0x0000000009000000L});
        public static final BitSet FOLLOW_KEYWORD_2_in_synpred12_InternalPropertiesParser840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordTerm_in_synpred15_InternalPropertiesParser1547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericRangeTerm_in_synpred20_InternalPropertiesParser1697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_synpred21_InternalPropertiesParser1727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_synpred22_InternalPropertiesParser1757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTerm_in_synpred23_InternalPropertiesParser1787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualBooleanTerm_in_synpred24_InternalPropertiesParser1817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualOrTerm_in_synpred25_InternalPropertiesParser2036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleActualAndTerm_in_synpred26_InternalPropertiesParser2066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_synpred27_InternalPropertiesParser2096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNotTerm_in_synpred28_InternalPropertiesParser2126 = new BitSet(new long[]{0x0000000000000002L});
    }


}