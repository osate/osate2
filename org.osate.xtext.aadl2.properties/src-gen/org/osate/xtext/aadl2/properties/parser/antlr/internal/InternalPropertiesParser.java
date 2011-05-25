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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_SL_COMMENT", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'property'", "'set'", "'is'", "'with'", "','", "';'", "'end'", "':'", "'type'", "'aadlboolean'", "'aadlstring'", "'enumeration'", "'('", "')'", "'units'", "'=>'", "'aadlreal'", "'aadlinteger'", "'range'", "'of'", "'classifier'", "'{'", "'}'", "'reference'", "'record'", "'inherit'", "'applies'", "'to'", "'all'", "'constant'", "'in'", "'modes'", "'true'", "'false'", "'.'", "'compute'", "'['", "']'", "'annex'", "'and'", "'or'", "'not'", "'+'", "'-'", "'..'", "'delta'", "'::'", "'*'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=7;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalPropertiesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPropertiesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPropertiesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g"; }



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
        	return "PropertySet";	
       	}
       	
       	@Override
       	protected PropertiesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRulePropertySet"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:74:1: entryRulePropertySet returns [EObject current=null] : iv_rulePropertySet= rulePropertySet EOF ;
    public final EObject entryRulePropertySet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertySet = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:75:2: (iv_rulePropertySet= rulePropertySet EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:76:2: iv_rulePropertySet= rulePropertySet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertySetRule()); 
            }
            pushFollow(FOLLOW_rulePropertySet_in_entryRulePropertySet81);
            iv_rulePropertySet=rulePropertySet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertySet; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertySet91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertySet"


    // $ANTLR start "rulePropertySet"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:83:1: rulePropertySet returns [EObject current=null] : (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';' )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= 'end' this_ID_13= RULE_ID otherlv_14= ';' ) ;
    public final EObject rulePropertySet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        Token this_ID_13=null;
        Token otherlv_14=null;
        EObject lv_ownedPropertyType_9_0 = null;

        EObject lv_ownedProperty_10_0 = null;

        EObject lv_ownedPropertyConstant_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:86:28: ( (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';' )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= 'end' this_ID_13= RULE_ID otherlv_14= ';' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:87:1: (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';' )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= 'end' this_ID_13= RULE_ID otherlv_14= ';' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:87:1: (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';' )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= 'end' this_ID_13= RULE_ID otherlv_14= ';' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:87:3: otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';' )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= 'end' this_ID_13= RULE_ID otherlv_14= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_rulePropertySet128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPropertySetAccess().getPropertyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_rulePropertySet140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertySetAccess().getSetKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:95:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:96:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:96:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:97:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertySet157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getPropertySetAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertySetRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_rulePropertySet174); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPropertySetAccess().getIsKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:117:1: ( ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:117:2: ( ( 'with' )=>otherlv_4= 'with' ) ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* otherlv_8= ';'
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:117:2: ( ( 'with' )=>otherlv_4= 'with' )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:117:3: ( 'with' )=>otherlv_4= 'with'
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_rulePropertySet195); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getPropertySetAccess().getWithKeyword_4_0());
            	          
            	    }

            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:122:2: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:123:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:123:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:124:3: otherlv_5= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPropertySetRule());
            	      	        }
            	              
            	    }
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertySet220); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_5, grammarAccess.getPropertySetAccess().getImportedPropertySetPropertySetCrossReference_4_1_0()); 
            	      	
            	    }

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:138:2: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==15) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:138:4: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
            	    	    {
            	    	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_rulePropertySet233); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	          	newLeafNode(otherlv_6, grammarAccess.getPropertySetAccess().getCommaKeyword_4_2_0());
            	    	          
            	    	    }
            	    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:142:1: ( (otherlv_7= RULE_ID ) )
            	    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:143:1: (otherlv_7= RULE_ID )
            	    	    {
            	    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:143:1: (otherlv_7= RULE_ID )
            	    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:144:3: otherlv_7= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getPropertySetRule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertySet257); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      		newLeafNode(otherlv_7, grammarAccess.getPropertySetAccess().getImportedPropertySetPropertySetCrossReference_4_2_1_0()); 
            	    	      	
            	    	    }

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    otherlv_8=(Token)match(input,16,FOLLOW_16_in_rulePropertySet271); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getPropertySetAccess().getSemicolonKeyword_4_3());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:162:3: ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==18) ) {
                        switch ( input.LA(3) ) {
                        case 19:
                            {
                            alt3=1;
                            }
                            break;
                        case 40:
                            {
                            alt3=3;
                            }
                            break;
                        case RULE_ID:
                        case 20:
                        case 21:
                        case 22:
                        case 25:
                        case 27:
                        case 28:
                        case 29:
                        case 31:
                        case 34:
                        case 35:
                        case 36:
                            {
                            alt3=2;
                            }
                            break;

                        }

                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:162:4: ( (lv_ownedPropertyType_9_0= rulePropertyType ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:162:4: ( (lv_ownedPropertyType_9_0= rulePropertyType ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:163:1: (lv_ownedPropertyType_9_0= rulePropertyType )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:163:1: (lv_ownedPropertyType_9_0= rulePropertyType )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:164:3: lv_ownedPropertyType_9_0= rulePropertyType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyTypePropertyTypeParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePropertyType_in_rulePropertySet295);
            	    lv_ownedPropertyType_9_0=rulePropertyType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPropertySetRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPropertyType",
            	              		lv_ownedPropertyType_9_0, 
            	              		"PropertyType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:181:6: ( (lv_ownedProperty_10_0= rulePropertyDefinition ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:181:6: ( (lv_ownedProperty_10_0= rulePropertyDefinition ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:182:1: (lv_ownedProperty_10_0= rulePropertyDefinition )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:182:1: (lv_ownedProperty_10_0= rulePropertyDefinition )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:183:3: lv_ownedProperty_10_0= rulePropertyDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyPropertyDefinitionParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePropertyDefinition_in_rulePropertySet322);
            	    lv_ownedProperty_10_0=rulePropertyDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPropertySetRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedProperty",
            	              		lv_ownedProperty_10_0, 
            	              		"PropertyDefinition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:200:6: ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:200:6: ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:201:1: (lv_ownedPropertyConstant_11_0= rulePropertyConstant )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:201:1: (lv_ownedPropertyConstant_11_0= rulePropertyConstant )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:202:3: lv_ownedPropertyConstant_11_0= rulePropertyConstant
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyConstantPropertyConstantParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePropertyConstant_in_rulePropertySet349);
            	    lv_ownedPropertyConstant_11_0=rulePropertyConstant();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPropertySetRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPropertyConstant",
            	              		lv_ownedPropertyConstant_11_0, 
            	              		"PropertyConstant");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_12=(Token)match(input,17,FOLLOW_17_in_rulePropertySet363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getPropertySetAccess().getEndKeyword_6());
                  
            }
            this_ID_13=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertySet374); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_13, grammarAccess.getPropertySetAccess().getIDTerminalRuleCall_7()); 
                  
            }
            otherlv_14=(Token)match(input,16,FOLLOW_16_in_rulePropertySet385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getPropertySetAccess().getSemicolonKeyword_8());
                  
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
    // $ANTLR end "rulePropertySet"


    // $ANTLR start "entryRulePropertyType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:238:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:239:2: (iv_rulePropertyType= rulePropertyType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:240:2: iv_rulePropertyType= rulePropertyType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyTypeRule()); 
            }
            pushFollow(FOLLOW_rulePropertyType_in_entryRulePropertyType421);
            iv_rulePropertyType=rulePropertyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyType431); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyType"


    // $ANTLR start "rulePropertyType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:247:1: rulePropertyType returns [EObject current=null] : ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= ';' ) ;
    public final EObject rulePropertyType() throws RecognitionException {
        EObject current = null;

        Token otherlv_10=null;
        EObject this_BooleanType_0 = null;

        EObject this_StringType_1 = null;

        EObject this_EnumerationType_2 = null;

        EObject this_UnitsType_3 = null;

        EObject this_RealType_4 = null;

        EObject this_IntegerType_5 = null;

        EObject this_RangeType_6 = null;

        EObject this_ClassifierType_7 = null;

        EObject this_ReferenceType_8 = null;

        EObject this_RecordType_9 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:250:28: ( ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= ';' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:251:1: ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= ';' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:251:1: ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= ';' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:251:2: (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= ';'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:251:2: (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType )
            int alt4=10;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:252:2: this_BooleanType_0= ruleBooleanType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getBooleanTypeParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanType_in_rulePropertyType482);
                    this_BooleanType_0=ruleBooleanType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanType_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:265:2: this_StringType_1= ruleStringType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getStringTypeParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringType_in_rulePropertyType512);
                    this_StringType_1=ruleStringType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringType_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:278:2: this_EnumerationType_2= ruleEnumerationType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getEnumerationTypeParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEnumerationType_in_rulePropertyType542);
                    this_EnumerationType_2=ruleEnumerationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EnumerationType_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:291:2: this_UnitsType_3= ruleUnitsType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getUnitsTypeParserRuleCall_0_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnitsType_in_rulePropertyType572);
                    this_UnitsType_3=ruleUnitsType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnitsType_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:304:2: this_RealType_4= ruleRealType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getRealTypeParserRuleCall_0_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealType_in_rulePropertyType602);
                    this_RealType_4=ruleRealType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealType_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:317:2: this_IntegerType_5= ruleIntegerType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getIntegerTypeParserRuleCall_0_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerType_in_rulePropertyType632);
                    this_IntegerType_5=ruleIntegerType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntegerType_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:330:2: this_RangeType_6= ruleRangeType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getRangeTypeParserRuleCall_0_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRangeType_in_rulePropertyType662);
                    this_RangeType_6=ruleRangeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RangeType_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:343:2: this_ClassifierType_7= ruleClassifierType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getClassifierTypeParserRuleCall_0_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClassifierType_in_rulePropertyType692);
                    this_ClassifierType_7=ruleClassifierType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClassifierType_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:356:2: this_ReferenceType_8= ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getReferenceTypeParserRuleCall_0_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReferenceType_in_rulePropertyType722);
                    this_ReferenceType_8=ruleReferenceType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReferenceType_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:369:2: this_RecordType_9= ruleRecordType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyTypeAccess().getRecordTypeParserRuleCall_0_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRecordType_in_rulePropertyType752);
                    this_RecordType_9=ruleRecordType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RecordType_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            otherlv_10=(Token)match(input,16,FOLLOW_16_in_rulePropertyType764); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1());
                  
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
    // $ANTLR end "rulePropertyType"


    // $ANTLR start "entryRuleUnnamedPropertyType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:392:1: entryRuleUnnamedPropertyType returns [EObject current=null] : iv_ruleUnnamedPropertyType= ruleUnnamedPropertyType EOF ;
    public final EObject entryRuleUnnamedPropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedPropertyType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:393:2: (iv_ruleUnnamedPropertyType= ruleUnnamedPropertyType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:394:2: iv_ruleUnnamedPropertyType= ruleUnnamedPropertyType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedPropertyTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedPropertyType_in_entryRuleUnnamedPropertyType800);
            iv_ruleUnnamedPropertyType=ruleUnnamedPropertyType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedPropertyType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedPropertyType810); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedPropertyType"


    // $ANTLR start "ruleUnnamedPropertyType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:401:1: ruleUnnamedPropertyType returns [EObject current=null] : (this_UnnamedBooleanType_0= ruleUnnamedBooleanType | this_UnnamedStringType_1= ruleUnnamedStringType | this_UnnamedEnumerationType_2= ruleUnnamedEnumerationType | this_UnnamedUnitsType_3= ruleUnnamedUnitsType | this_UnnamedRealType_4= ruleUnnamedRealType | this_UnnamedIntegerType_5= ruleUnnamedIntegerType | this_UnnamedRangeType_6= ruleUnnamedRangeType | this_UnnamedClassifierType_7= ruleUnnamedClassifierType | this_UnnamedReferenceType_8= ruleUnnamedReferenceType | this_UnnamedRecordType_9= ruleUnnamedRecordType ) ;
    public final EObject ruleUnnamedPropertyType() throws RecognitionException {
        EObject current = null;

        EObject this_UnnamedBooleanType_0 = null;

        EObject this_UnnamedStringType_1 = null;

        EObject this_UnnamedEnumerationType_2 = null;

        EObject this_UnnamedUnitsType_3 = null;

        EObject this_UnnamedRealType_4 = null;

        EObject this_UnnamedIntegerType_5 = null;

        EObject this_UnnamedRangeType_6 = null;

        EObject this_UnnamedClassifierType_7 = null;

        EObject this_UnnamedReferenceType_8 = null;

        EObject this_UnnamedRecordType_9 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:404:28: ( (this_UnnamedBooleanType_0= ruleUnnamedBooleanType | this_UnnamedStringType_1= ruleUnnamedStringType | this_UnnamedEnumerationType_2= ruleUnnamedEnumerationType | this_UnnamedUnitsType_3= ruleUnnamedUnitsType | this_UnnamedRealType_4= ruleUnnamedRealType | this_UnnamedIntegerType_5= ruleUnnamedIntegerType | this_UnnamedRangeType_6= ruleUnnamedRangeType | this_UnnamedClassifierType_7= ruleUnnamedClassifierType | this_UnnamedReferenceType_8= ruleUnnamedReferenceType | this_UnnamedRecordType_9= ruleUnnamedRecordType ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:405:1: (this_UnnamedBooleanType_0= ruleUnnamedBooleanType | this_UnnamedStringType_1= ruleUnnamedStringType | this_UnnamedEnumerationType_2= ruleUnnamedEnumerationType | this_UnnamedUnitsType_3= ruleUnnamedUnitsType | this_UnnamedRealType_4= ruleUnnamedRealType | this_UnnamedIntegerType_5= ruleUnnamedIntegerType | this_UnnamedRangeType_6= ruleUnnamedRangeType | this_UnnamedClassifierType_7= ruleUnnamedClassifierType | this_UnnamedReferenceType_8= ruleUnnamedReferenceType | this_UnnamedRecordType_9= ruleUnnamedRecordType )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:405:1: (this_UnnamedBooleanType_0= ruleUnnamedBooleanType | this_UnnamedStringType_1= ruleUnnamedStringType | this_UnnamedEnumerationType_2= ruleUnnamedEnumerationType | this_UnnamedUnitsType_3= ruleUnnamedUnitsType | this_UnnamedRealType_4= ruleUnnamedRealType | this_UnnamedIntegerType_5= ruleUnnamedIntegerType | this_UnnamedRangeType_6= ruleUnnamedRangeType | this_UnnamedClassifierType_7= ruleUnnamedClassifierType | this_UnnamedReferenceType_8= ruleUnnamedReferenceType | this_UnnamedRecordType_9= ruleUnnamedRecordType )
            int alt5=10;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt5=1;
                }
                break;
            case 21:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            case 25:
                {
                alt5=4;
                }
                break;
            case 27:
                {
                alt5=5;
                }
                break;
            case 28:
                {
                alt5=6;
                }
                break;
            case 29:
                {
                alt5=7;
                }
                break;
            case 31:
                {
                alt5=8;
                }
                break;
            case 34:
                {
                alt5=9;
                }
                break;
            case 35:
                {
                alt5=10;
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:406:2: this_UnnamedBooleanType_0= ruleUnnamedBooleanType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedBooleanTypeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedBooleanType_in_ruleUnnamedPropertyType860);
                    this_UnnamedBooleanType_0=ruleUnnamedBooleanType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedBooleanType_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:419:2: this_UnnamedStringType_1= ruleUnnamedStringType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedStringTypeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedStringType_in_ruleUnnamedPropertyType890);
                    this_UnnamedStringType_1=ruleUnnamedStringType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedStringType_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:432:2: this_UnnamedEnumerationType_2= ruleUnnamedEnumerationType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedEnumerationTypeParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedEnumerationType_in_ruleUnnamedPropertyType920);
                    this_UnnamedEnumerationType_2=ruleUnnamedEnumerationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedEnumerationType_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:445:2: this_UnnamedUnitsType_3= ruleUnnamedUnitsType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedUnitsTypeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedPropertyType950);
                    this_UnnamedUnitsType_3=ruleUnnamedUnitsType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedUnitsType_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:458:2: this_UnnamedRealType_4= ruleUnnamedRealType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedRealTypeParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedRealType_in_ruleUnnamedPropertyType980);
                    this_UnnamedRealType_4=ruleUnnamedRealType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedRealType_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:471:2: this_UnnamedIntegerType_5= ruleUnnamedIntegerType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedIntegerTypeParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedPropertyType1010);
                    this_UnnamedIntegerType_5=ruleUnnamedIntegerType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedIntegerType_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:484:2: this_UnnamedRangeType_6= ruleUnnamedRangeType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedRangeTypeParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedRangeType_in_ruleUnnamedPropertyType1040);
                    this_UnnamedRangeType_6=ruleUnnamedRangeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedRangeType_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:497:2: this_UnnamedClassifierType_7= ruleUnnamedClassifierType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedClassifierTypeParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedClassifierType_in_ruleUnnamedPropertyType1070);
                    this_UnnamedClassifierType_7=ruleUnnamedClassifierType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedClassifierType_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:510:2: this_UnnamedReferenceType_8= ruleUnnamedReferenceType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedReferenceTypeParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedReferenceType_in_ruleUnnamedPropertyType1100);
                    this_UnnamedReferenceType_8=ruleUnnamedReferenceType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedReferenceType_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:523:2: this_UnnamedRecordType_9= ruleUnnamedRecordType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedRecordTypeParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnnamedRecordType_in_ruleUnnamedPropertyType1130);
                    this_UnnamedRecordType_9=ruleUnnamedRecordType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnnamedRecordType_9; 
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
    // $ANTLR end "ruleUnnamedPropertyType"


    // $ANTLR start "entryRuleBooleanType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:542:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:543:2: (iv_ruleBooleanType= ruleBooleanType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:544:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanType_in_entryRuleBooleanType1165);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanType1175); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:551:1: ruleBooleanType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlboolean' ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:554:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlboolean' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:555:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlboolean' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:555:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlboolean' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:555:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlboolean'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:555:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:556:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:556:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:557:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBooleanType1217); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getBooleanTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBooleanTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBooleanType1234); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBooleanTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleBooleanType1246); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBooleanTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleBooleanType1258); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBooleanTypeAccess().getAadlbooleanKeyword_3());
                  
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
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleUnnamedBooleanType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:593:1: entryRuleUnnamedBooleanType returns [EObject current=null] : iv_ruleUnnamedBooleanType= ruleUnnamedBooleanType EOF ;
    public final EObject entryRuleUnnamedBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedBooleanType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:594:2: (iv_ruleUnnamedBooleanType= ruleUnnamedBooleanType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:595:2: iv_ruleUnnamedBooleanType= ruleUnnamedBooleanType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedBooleanTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedBooleanType_in_entryRuleUnnamedBooleanType1294);
            iv_ruleUnnamedBooleanType=ruleUnnamedBooleanType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedBooleanType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedBooleanType1304); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedBooleanType"


    // $ANTLR start "ruleUnnamedBooleanType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:602:1: ruleUnnamedBooleanType returns [EObject current=null] : ( () otherlv_1= 'aadlboolean' ) ;
    public final EObject ruleUnnamedBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:605:28: ( ( () otherlv_1= 'aadlboolean' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:606:1: ( () otherlv_1= 'aadlboolean' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:606:1: ( () otherlv_1= 'aadlboolean' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:606:2: () otherlv_1= 'aadlboolean'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:606:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:607:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedBooleanTypeAccess().getAadlBooleanAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleUnnamedBooleanType1353); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedBooleanTypeAccess().getAadlbooleanKeyword_1());
                  
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
    // $ANTLR end "ruleUnnamedBooleanType"


    // $ANTLR start "entryRuleStringType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:627:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:628:2: (iv_ruleStringType= ruleStringType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:629:2: iv_ruleStringType= ruleStringType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTypeRule()); 
            }
            pushFollow(FOLLOW_ruleStringType_in_entryRuleStringType1389);
            iv_ruleStringType=ruleStringType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringType1399); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:636:1: ruleStringType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlstring' ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:639:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlstring' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:640:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlstring' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:640:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlstring' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:640:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlstring'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:640:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:641:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:641:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:642:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringType1441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getStringTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleStringType1458); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStringTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleStringType1470); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getStringTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleStringType1482); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getStringTypeAccess().getAadlstringKeyword_3());
                  
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
    // $ANTLR end "ruleStringType"


    // $ANTLR start "entryRuleUnnamedStringType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:678:1: entryRuleUnnamedStringType returns [EObject current=null] : iv_ruleUnnamedStringType= ruleUnnamedStringType EOF ;
    public final EObject entryRuleUnnamedStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedStringType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:679:2: (iv_ruleUnnamedStringType= ruleUnnamedStringType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:680:2: iv_ruleUnnamedStringType= ruleUnnamedStringType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedStringTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedStringType_in_entryRuleUnnamedStringType1518);
            iv_ruleUnnamedStringType=ruleUnnamedStringType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedStringType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedStringType1528); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedStringType"


    // $ANTLR start "ruleUnnamedStringType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:687:1: ruleUnnamedStringType returns [EObject current=null] : ( () otherlv_1= 'aadlstring' ) ;
    public final EObject ruleUnnamedStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:690:28: ( ( () otherlv_1= 'aadlstring' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:691:1: ( () otherlv_1= 'aadlstring' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:691:1: ( () otherlv_1= 'aadlstring' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:691:2: () otherlv_1= 'aadlstring'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:691:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:692:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedStringTypeAccess().getAadlStringAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleUnnamedStringType1577); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedStringTypeAccess().getAadlstringKeyword_1());
                  
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
    // $ANTLR end "ruleUnnamedStringType"


    // $ANTLR start "entryRuleEnumerationType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:712:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:713:2: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:714:2: iv_ruleEnumerationType= ruleEnumerationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationTypeRule()); 
            }
            pushFollow(FOLLOW_ruleEnumerationType_in_entryRuleEnumerationType1613);
            iv_ruleEnumerationType=ruleEnumerationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerationType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationType1623); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationType"


    // $ANTLR start "ruleEnumerationType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:721:1: ruleEnumerationType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'enumeration' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= ')' ) ;
    public final EObject ruleEnumerationType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_ownedLiteral_5_0 = null;

        EObject lv_ownedLiteral_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:724:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'enumeration' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:725:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'enumeration' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:725:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'enumeration' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:725:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'enumeration' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= ')'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:725:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:726:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:726:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:727:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationType1665); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnumerationTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumerationTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleEnumerationType1682); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEnumerationTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleEnumerationType1694); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleEnumerationType1706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleEnumerationType1718); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:759:1: ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:760:1: (lv_ownedLiteral_5_0= ruleEnumerationLiteral )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:760:1: (lv_ownedLiteral_5_0= ruleEnumerationLiteral )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:761:3: lv_ownedLiteral_5_0= ruleEnumerationLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1739);
            lv_ownedLiteral_5_0=ruleEnumerationLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
              	        }
                     		add(
                     			current, 
                     			"ownedLiteral",
                      		lv_ownedLiteral_5_0, 
                      		"EnumerationLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:777:2: (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:777:4: otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleEnumerationType1752); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_6_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:781:1: ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:782:1: (lv_ownedLiteral_7_0= ruleEnumerationLiteral )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:782:1: (lv_ownedLiteral_7_0= ruleEnumerationLiteral )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:783:3: lv_ownedLiteral_7_0= ruleEnumerationLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_6_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1773);
            	    lv_ownedLiteral_7_0=ruleEnumerationLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedLiteral",
            	              		lv_ownedLiteral_7_0, 
            	              		"EnumerationLiteral");
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

            otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleEnumerationType1787); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getEnumerationTypeAccess().getRightParenthesisKeyword_7());
                  
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
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleUnnamedEnumerationType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:811:1: entryRuleUnnamedEnumerationType returns [EObject current=null] : iv_ruleUnnamedEnumerationType= ruleUnnamedEnumerationType EOF ;
    public final EObject entryRuleUnnamedEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedEnumerationType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:812:2: (iv_ruleUnnamedEnumerationType= ruleUnnamedEnumerationType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:813:2: iv_ruleUnnamedEnumerationType= ruleUnnamedEnumerationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedEnumerationTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedEnumerationType_in_entryRuleUnnamedEnumerationType1823);
            iv_ruleUnnamedEnumerationType=ruleUnnamedEnumerationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedEnumerationType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedEnumerationType1833); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedEnumerationType"


    // $ANTLR start "ruleUnnamedEnumerationType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:820:1: ruleUnnamedEnumerationType returns [EObject current=null] : (otherlv_0= 'enumeration' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleUnnamedEnumerationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedLiteral_2_0 = null;

        EObject lv_ownedLiteral_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:823:28: ( (otherlv_0= 'enumeration' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:824:1: (otherlv_0= 'enumeration' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:824:1: (otherlv_0= 'enumeration' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:824:3: otherlv_0= 'enumeration' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleUnnamedEnumerationType1870); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUnnamedEnumerationTypeAccess().getEnumerationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleUnnamedEnumerationType1882); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedEnumerationTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:832:1: ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:833:1: (lv_ownedLiteral_2_0= ruleEnumerationLiteral )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:833:1: (lv_ownedLiteral_2_0= ruleEnumerationLiteral )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:834:3: lv_ownedLiteral_2_0= ruleEnumerationLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1903);
            lv_ownedLiteral_2_0=ruleEnumerationLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnnamedEnumerationTypeRule());
              	        }
                     		add(
                     			current, 
                     			"ownedLiteral",
                      		lv_ownedLiteral_2_0, 
                      		"EnumerationLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:850:2: (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:850:4: otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleUnnamedEnumerationType1916); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getUnnamedEnumerationTypeAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:854:1: ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:855:1: (lv_ownedLiteral_4_0= ruleEnumerationLiteral )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:855:1: (lv_ownedLiteral_4_0= ruleEnumerationLiteral )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:856:3: lv_ownedLiteral_4_0= ruleEnumerationLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnnamedEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1937);
            	    lv_ownedLiteral_4_0=ruleEnumerationLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnnamedEnumerationTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedLiteral",
            	              		lv_ownedLiteral_4_0, 
            	              		"EnumerationLiteral");
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

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleUnnamedEnumerationType1951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getUnnamedEnumerationTypeAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleUnnamedEnumerationType"


    // $ANTLR start "entryRuleEnumerationLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:884:1: entryRuleEnumerationLiteral returns [EObject current=null] : iv_ruleEnumerationLiteral= ruleEnumerationLiteral EOF ;
    public final EObject entryRuleEnumerationLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:885:2: (iv_ruleEnumerationLiteral= ruleEnumerationLiteral EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:886:2: iv_ruleEnumerationLiteral= ruleEnumerationLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleEnumerationLiteral_in_entryRuleEnumerationLiteral1987);
            iv_ruleEnumerationLiteral=ruleEnumerationLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerationLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteral1997); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationLiteral"


    // $ANTLR start "ruleEnumerationLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:893:1: ruleEnumerationLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumerationLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:896:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:897:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:897:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:898:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:898:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:899:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationLiteral2038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getEnumerationLiteralAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEnumerationLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleEnumerationLiteral"


    // $ANTLR start "entryRuleUnitsType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:923:1: entryRuleUnitsType returns [EObject current=null] : iv_ruleUnitsType= ruleUnitsType EOF ;
    public final EObject entryRuleUnitsType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitsType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:924:2: (iv_ruleUnitsType= ruleUnitsType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:925:2: iv_ruleUnitsType= ruleUnitsType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitsTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnitsType_in_entryRuleUnitsType2078);
            iv_ruleUnitsType=ruleUnitsType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitsType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitsType2088); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitsType"


    // $ANTLR start "ruleUnitsType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:932:1: ruleUnitsType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'units' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= ')' ) ;
    public final EObject ruleUnitsType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_ownedLiteral_5_0 = null;

        EObject lv_ownedLiteral_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:935:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'units' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:936:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'units' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:936:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'units' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:936:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'units' otherlv_4= '(' ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= ')'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:936:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:937:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:937:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:938:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitsType2130); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getUnitsTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getUnitsTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleUnitsType2147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnitsTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleUnitsType2159); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getUnitsTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleUnitsType2171); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getUnitsTypeAccess().getUnitsKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleUnitsType2183); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getUnitsTypeAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:970:1: ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:971:1: (lv_ownedLiteral_5_0= ruleUnitLiteral )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:971:1: (lv_ownedLiteral_5_0= ruleUnitLiteral )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:972:3: lv_ownedLiteral_5_0= ruleUnitLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnitsTypeAccess().getOwnedLiteralUnitLiteralParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnitLiteral_in_ruleUnitsType2204);
            lv_ownedLiteral_5_0=ruleUnitLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnitsTypeRule());
              	        }
                     		add(
                     			current, 
                     			"ownedLiteral",
                      		lv_ownedLiteral_5_0, 
                      		"UnitLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:988:2: (otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:988:4: otherlv_6= ',' ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleUnitsType2217); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getUnitsTypeAccess().getCommaKeyword_6_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:992:1: ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:993:1: (lv_ownedLiteral_7_0= ruleUnitLiteralConversion )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:993:1: (lv_ownedLiteral_7_0= ruleUnitLiteralConversion )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:994:3: lv_ownedLiteral_7_0= ruleUnitLiteralConversion
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnitsTypeAccess().getOwnedLiteralUnitLiteralConversionParserRuleCall_6_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnitLiteralConversion_in_ruleUnitsType2238);
            	    lv_ownedLiteral_7_0=ruleUnitLiteralConversion();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnitsTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedLiteral",
            	              		lv_ownedLiteral_7_0, 
            	              		"UnitLiteralConversion");
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

            otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleUnitsType2252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getUnitsTypeAccess().getRightParenthesisKeyword_7());
                  
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
    // $ANTLR end "ruleUnitsType"


    // $ANTLR start "entryRuleUnnamedUnitsType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1022:1: entryRuleUnnamedUnitsType returns [EObject current=null] : iv_ruleUnnamedUnitsType= ruleUnnamedUnitsType EOF ;
    public final EObject entryRuleUnnamedUnitsType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedUnitsType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1023:2: (iv_ruleUnnamedUnitsType= ruleUnnamedUnitsType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1024:2: iv_ruleUnnamedUnitsType= ruleUnnamedUnitsType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedUnitsTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedUnitsType_in_entryRuleUnnamedUnitsType2288);
            iv_ruleUnnamedUnitsType=ruleUnnamedUnitsType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedUnitsType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedUnitsType2298); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedUnitsType"


    // $ANTLR start "ruleUnnamedUnitsType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1031:1: ruleUnnamedUnitsType returns [EObject current=null] : (otherlv_0= 'units' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleUnnamedUnitsType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedLiteral_2_0 = null;

        EObject lv_ownedLiteral_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1034:28: ( (otherlv_0= 'units' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1035:1: (otherlv_0= 'units' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1035:1: (otherlv_0= 'units' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1035:3: otherlv_0= 'units' otherlv_1= '(' ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleUnnamedUnitsType2335); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUnnamedUnitsTypeAccess().getUnitsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleUnnamedUnitsType2347); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedUnitsTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1043:1: ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1044:1: (lv_ownedLiteral_2_0= ruleUnitLiteral )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1044:1: (lv_ownedLiteral_2_0= ruleUnitLiteral )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1045:3: lv_ownedLiteral_2_0= ruleUnitLiteral
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnnamedUnitsTypeAccess().getOwnedLiteralUnitLiteralParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnitLiteral_in_ruleUnnamedUnitsType2368);
            lv_ownedLiteral_2_0=ruleUnitLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnnamedUnitsTypeRule());
              	        }
                     		add(
                     			current, 
                     			"ownedLiteral",
                      		lv_ownedLiteral_2_0, 
                      		"UnitLiteral");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1061:2: (otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1061:4: otherlv_3= ',' ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) )
            	    {
            	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleUnnamedUnitsType2381); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getUnnamedUnitsTypeAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1065:1: ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1066:1: (lv_ownedLiteral_4_0= ruleUnitLiteralConversion )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1066:1: (lv_ownedLiteral_4_0= ruleUnitLiteralConversion )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1067:3: lv_ownedLiteral_4_0= ruleUnitLiteralConversion
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnnamedUnitsTypeAccess().getOwnedLiteralUnitLiteralConversionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnitLiteralConversion_in_ruleUnnamedUnitsType2402);
            	    lv_ownedLiteral_4_0=ruleUnitLiteralConversion();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnnamedUnitsTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedLiteral",
            	              		lv_ownedLiteral_4_0, 
            	              		"UnitLiteralConversion");
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

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleUnnamedUnitsType2416); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getUnnamedUnitsTypeAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleUnnamedUnitsType"


    // $ANTLR start "entryRuleUnitLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1095:1: entryRuleUnitLiteral returns [EObject current=null] : iv_ruleUnitLiteral= ruleUnitLiteral EOF ;
    public final EObject entryRuleUnitLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1096:2: (iv_ruleUnitLiteral= ruleUnitLiteral EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1097:2: iv_ruleUnitLiteral= ruleUnitLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleUnitLiteral_in_entryRuleUnitLiteral2452);
            iv_ruleUnitLiteral=ruleUnitLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitLiteral2462); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitLiteral"


    // $ANTLR start "ruleUnitLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1104:1: ruleUnitLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleUnitLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1107:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1108:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1108:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1109:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1109:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1110:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitLiteral2503); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getUnitLiteralAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getUnitLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleUnitLiteral"


    // $ANTLR start "entryRuleUnitLiteralConversion"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1134:1: entryRuleUnitLiteralConversion returns [EObject current=null] : iv_ruleUnitLiteralConversion= ruleUnitLiteralConversion EOF ;
    public final EObject entryRuleUnitLiteralConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitLiteralConversion = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1135:2: (iv_ruleUnitLiteralConversion= ruleUnitLiteralConversion EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1136:2: iv_ruleUnitLiteralConversion= ruleUnitLiteralConversion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitLiteralConversionRule()); 
            }
            pushFollow(FOLLOW_ruleUnitLiteralConversion_in_entryRuleUnitLiteralConversion2543);
            iv_ruleUnitLiteralConversion=ruleUnitLiteralConversion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnitLiteralConversion; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitLiteralConversion2553); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnitLiteralConversion"


    // $ANTLR start "ruleUnitLiteralConversion"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1143:1: ruleUnitLiteralConversion returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) ) ;
    public final EObject ruleUnitLiteralConversion() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_factor_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1146:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1147:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1147:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1147:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1147:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1148:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1148:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1149:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2595); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getUnitLiteralConversionAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getUnitLiteralConversionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleUnitLiteralConversion2612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnitLiteralConversionAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1169:1: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1170:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1170:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1171:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUnitLiteralConversionRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2636); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getUnitLiteralConversionAccess().getBaseUnitUnitLiteralCrossReference_2_0()); 
              	
            }

            }


            }

            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnitLiteralConversionAccess().getSTARParserRuleCall_3()); 
                  
            }
            pushFollow(FOLLOW_ruleSTAR_in_ruleUnitLiteralConversion2655);
            ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1196:1: ( (lv_factor_4_0= ruleNumberValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1197:1: (lv_factor_4_0= ruleNumberValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1197:1: (lv_factor_4_0= ruleNumberValue )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1198:3: lv_factor_4_0= ruleNumberValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUnitLiteralConversionAccess().getFactorNumberValueParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNumberValue_in_ruleUnitLiteralConversion2675);
            lv_factor_4_0=ruleNumberValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUnitLiteralConversionRule());
              	        }
                     		set(
                     			current, 
                     			"factor",
                      		lv_factor_4_0, 
                      		"NumberValue");
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
    // $ANTLR end "ruleUnitLiteralConversion"


    // $ANTLR start "entryRuleRealType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1222:1: entryRuleRealType returns [EObject current=null] : iv_ruleRealType= ruleRealType EOF ;
    public final EObject entryRuleRealType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1223:2: (iv_ruleRealType= ruleRealType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1224:2: iv_ruleRealType= ruleRealType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTypeRule()); 
            }
            pushFollow(FOLLOW_ruleRealType_in_entryRuleRealType2711);
            iv_ruleRealType=ruleRealType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealType2721); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealType"


    // $ANTLR start "ruleRealType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1231:1: ruleRealType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlreal' ( (lv_range_4_0= ruleRealRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? ) ;
    public final EObject ruleRealType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_range_4_0 = null;

        EObject lv_ownedUnitsType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1234:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlreal' ( (lv_range_4_0= ruleRealRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1235:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlreal' ( (lv_range_4_0= ruleRealRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1235:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlreal' ( (lv_range_4_0= ruleRealRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1235:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlreal' ( (lv_range_4_0= ruleRealRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1235:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1236:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1236:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1237:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealType2763); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRealTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRealTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRealType2780); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRealTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleRealType2792); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRealTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleRealType2804); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRealTypeAccess().getAadlrealKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1265:1: ( (lv_range_4_0= ruleRealRange ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||LA10_0==RULE_INT||(LA10_0>=53 && LA10_0<=54)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1266:1: (lv_range_4_0= ruleRealRange )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1266:1: (lv_range_4_0= ruleRealRange )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1267:3: lv_range_4_0= ruleRealRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealTypeAccess().getRangeRealRangeParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealRange_in_ruleRealType2825);
                    lv_range_4_0=ruleRealRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_4_0, 
                              		"RealRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1283:3: (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1283:5: otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) )
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleRealType2839); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRealTypeAccess().getUnitsKeyword_5_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1287:1: ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_ID) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==EOF||LA11_1==16) ) {
                            alt11=2;
                        }
                        else if ( (LA11_1==18) ) {
                            alt11=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1287:2: ( (lv_ownedUnitsType_6_0= ruleUnitsType ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1287:2: ( (lv_ownedUnitsType_6_0= ruleUnitsType ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1288:1: (lv_ownedUnitsType_6_0= ruleUnitsType )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1288:1: (lv_ownedUnitsType_6_0= ruleUnitsType )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1289:3: lv_ownedUnitsType_6_0= ruleUnitsType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRealTypeAccess().getOwnedUnitsTypeUnitsTypeParserRuleCall_5_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnitsType_in_ruleRealType2861);
                            lv_ownedUnitsType_6_0=ruleUnitsType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRealTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedUnitsType",
                                      		lv_ownedUnitsType_6_0, 
                                      		"UnitsType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1306:6: ( (otherlv_7= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1306:6: ( (otherlv_7= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1307:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1307:1: (otherlv_7= RULE_ID )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1308:3: otherlv_7= RULE_ID
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getRealTypeRule());
                              	        }
                                      
                            }
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealType2891); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_7, grammarAccess.getRealTypeAccess().getUnitsTypeUnitsTypeCrossReference_5_1_1_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleRealType"


    // $ANTLR start "entryRuleUnnamedRealType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1330:1: entryRuleUnnamedRealType returns [EObject current=null] : iv_ruleUnnamedRealType= ruleUnnamedRealType EOF ;
    public final EObject entryRuleUnnamedRealType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedRealType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1331:2: (iv_ruleUnnamedRealType= ruleUnnamedRealType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1332:2: iv_ruleUnnamedRealType= ruleUnnamedRealType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedRealTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedRealType_in_entryRuleUnnamedRealType2930);
            iv_ruleUnnamedRealType=ruleUnnamedRealType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedRealType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedRealType2940); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedRealType"


    // $ANTLR start "ruleUnnamedRealType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1339:1: ruleUnnamedRealType returns [EObject current=null] : ( () otherlv_1= 'aadlreal' ( (lv_range_2_0= ruleRealRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? ) ;
    public final EObject ruleUnnamedRealType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_range_2_0 = null;

        EObject lv_ownedUnitsType_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1342:28: ( ( () otherlv_1= 'aadlreal' ( (lv_range_2_0= ruleRealRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1343:1: ( () otherlv_1= 'aadlreal' ( (lv_range_2_0= ruleRealRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1343:1: ( () otherlv_1= 'aadlreal' ( (lv_range_2_0= ruleRealRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1343:2: () otherlv_1= 'aadlreal' ( (lv_range_2_0= ruleRealRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1343:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1344:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedRealTypeAccess().getAadlRealAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleUnnamedRealType2989); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedRealTypeAccess().getAadlrealKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1356:1: ( (lv_range_2_0= ruleRealRange ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_INT||(LA13_0>=53 && LA13_0<=54)) ) {
                alt13=1;
            }
            else if ( (LA13_0==RULE_ID) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==55||LA13_2==57) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1357:1: (lv_range_2_0= ruleRealRange )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1357:1: (lv_range_2_0= ruleRealRange )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1358:3: lv_range_2_0= ruleRealRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedRealTypeAccess().getRangeRealRangeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealRange_in_ruleUnnamedRealType3010);
                    lv_range_2_0=ruleRealRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnnamedRealTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_2_0, 
                              		"RealRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1374:3: (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1374:5: otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleUnnamedRealType3024); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getUnnamedRealTypeAccess().getUnitsKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1378:1: ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_ID) ) {
                        int LA14_1 = input.LA(2);

                        if ( (LA14_1==EOF||LA14_1==RULE_ID||LA14_1==16||LA14_1==24||LA14_1==26||LA14_1==37) ) {
                            alt14=2;
                        }
                        else if ( (LA14_1==18) ) {
                            alt14=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1378:2: ( (lv_ownedUnitsType_4_0= ruleUnitsType ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1378:2: ( (lv_ownedUnitsType_4_0= ruleUnitsType ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1379:1: (lv_ownedUnitsType_4_0= ruleUnitsType )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1379:1: (lv_ownedUnitsType_4_0= ruleUnitsType )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1380:3: lv_ownedUnitsType_4_0= ruleUnitsType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getUnnamedRealTypeAccess().getOwnedUnitsTypeUnitsTypeParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnitsType_in_ruleUnnamedRealType3046);
                            lv_ownedUnitsType_4_0=ruleUnitsType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getUnnamedRealTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedUnitsType",
                                      		lv_ownedUnitsType_4_0, 
                                      		"UnitsType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1397:6: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1397:6: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1398:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1398:1: (otherlv_5= RULE_ID )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1399:3: otherlv_5= RULE_ID
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnnamedRealTypeRule());
                              	        }
                                      
                            }
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnnamedRealType3076); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_5, grammarAccess.getUnnamedRealTypeAccess().getUnitsTypeUnitsTypeCrossReference_3_1_1_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleUnnamedRealType"


    // $ANTLR start "entryRuleIntegerType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1421:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1422:2: (iv_ruleIntegerType= ruleIntegerType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1423:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            }
            pushFollow(FOLLOW_ruleIntegerType_in_entryRuleIntegerType3115);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerType3125); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1430:1: ruleIntegerType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlinteger' ( (lv_range_4_0= ruleIntegerRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_range_4_0 = null;

        EObject lv_ownedUnitsType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1433:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlinteger' ( (lv_range_4_0= ruleIntegerRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1434:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlinteger' ( (lv_range_4_0= ruleIntegerRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1434:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlinteger' ( (lv_range_4_0= ruleIntegerRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1434:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'aadlinteger' ( (lv_range_4_0= ruleIntegerRange ) )? (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1434:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1435:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1435:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1436:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerType3167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getIntegerTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIntegerTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleIntegerType3184); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntegerTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleIntegerType3196); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIntegerTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleIntegerType3208); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIntegerTypeAccess().getAadlintegerKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1464:1: ( (lv_range_4_0= ruleIntegerRange ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||LA16_0==RULE_INT||(LA16_0>=53 && LA16_0<=54)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1465:1: (lv_range_4_0= ruleIntegerRange )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1465:1: (lv_range_4_0= ruleIntegerRange )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1466:3: lv_range_4_0= ruleIntegerRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerTypeAccess().getRangeIntegerRangeParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerRange_in_ruleIntegerType3229);
                    lv_range_4_0=ruleIntegerRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_4_0, 
                              		"IntegerRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1482:3: (otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==25) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1482:5: otherlv_5= 'units' ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) )
                    {
                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleIntegerType3243); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getIntegerTypeAccess().getUnitsKeyword_5_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1486:1: ( ( (lv_ownedUnitsType_6_0= ruleUnitsType ) ) | ( (otherlv_7= RULE_ID ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_ID) ) {
                        int LA17_1 = input.LA(2);

                        if ( (LA17_1==18) ) {
                            alt17=1;
                        }
                        else if ( (LA17_1==EOF||LA17_1==16) ) {
                            alt17=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1486:2: ( (lv_ownedUnitsType_6_0= ruleUnitsType ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1486:2: ( (lv_ownedUnitsType_6_0= ruleUnitsType ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1487:1: (lv_ownedUnitsType_6_0= ruleUnitsType )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1487:1: (lv_ownedUnitsType_6_0= ruleUnitsType )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1488:3: lv_ownedUnitsType_6_0= ruleUnitsType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getIntegerTypeAccess().getOwnedUnitsTypeUnitsTypeParserRuleCall_5_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnitsType_in_ruleIntegerType3265);
                            lv_ownedUnitsType_6_0=ruleUnitsType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getIntegerTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedUnitsType",
                                      		lv_ownedUnitsType_6_0, 
                                      		"UnitsType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1505:6: ( (otherlv_7= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1505:6: ( (otherlv_7= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1506:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1506:1: (otherlv_7= RULE_ID )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1507:3: otherlv_7= RULE_ID
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getIntegerTypeRule());
                              	        }
                                      
                            }
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerType3295); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_7, grammarAccess.getIntegerTypeAccess().getUnitsTypeUnitsTypeCrossReference_5_1_1_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleUnnamedIntegerType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1529:1: entryRuleUnnamedIntegerType returns [EObject current=null] : iv_ruleUnnamedIntegerType= ruleUnnamedIntegerType EOF ;
    public final EObject entryRuleUnnamedIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedIntegerType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1530:2: (iv_ruleUnnamedIntegerType= ruleUnnamedIntegerType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1531:2: iv_ruleUnnamedIntegerType= ruleUnnamedIntegerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedIntegerTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedIntegerType_in_entryRuleUnnamedIntegerType3334);
            iv_ruleUnnamedIntegerType=ruleUnnamedIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedIntegerType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedIntegerType3344); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedIntegerType"


    // $ANTLR start "ruleUnnamedIntegerType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1538:1: ruleUnnamedIntegerType returns [EObject current=null] : ( () otherlv_1= 'aadlinteger' ( (lv_range_2_0= ruleIntegerRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? ) ;
    public final EObject ruleUnnamedIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_range_2_0 = null;

        EObject lv_ownedUnitsType_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1541:28: ( ( () otherlv_1= 'aadlinteger' ( (lv_range_2_0= ruleIntegerRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1542:1: ( () otherlv_1= 'aadlinteger' ( (lv_range_2_0= ruleIntegerRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1542:1: ( () otherlv_1= 'aadlinteger' ( (lv_range_2_0= ruleIntegerRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1542:2: () otherlv_1= 'aadlinteger' ( (lv_range_2_0= ruleIntegerRange ) )? (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1542:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1543:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedIntegerTypeAccess().getAadlIntegerAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleUnnamedIntegerType3393); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedIntegerTypeAccess().getAadlintegerKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1555:1: ( (lv_range_2_0= ruleIntegerRange ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT||(LA19_0>=53 && LA19_0<=54)) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==55||LA19_2==57) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1556:1: (lv_range_2_0= ruleIntegerRange )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1556:1: (lv_range_2_0= ruleIntegerRange )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1557:3: lv_range_2_0= ruleIntegerRange
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedIntegerTypeAccess().getRangeIntegerRangeParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerRange_in_ruleUnnamedIntegerType3414);
                    lv_range_2_0=ruleIntegerRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnnamedIntegerTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_2_0, 
                              		"IntegerRange");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1573:3: (otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==25) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1573:5: otherlv_3= 'units' ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) )
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleUnnamedIntegerType3428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getUnnamedIntegerTypeAccess().getUnitsKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1577:1: ( ( (lv_ownedUnitsType_4_0= ruleUnitsType ) ) | ( (otherlv_5= RULE_ID ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_ID) ) {
                        int LA20_1 = input.LA(2);

                        if ( (LA20_1==18) ) {
                            alt20=1;
                        }
                        else if ( (LA20_1==EOF||LA20_1==RULE_ID||LA20_1==16||LA20_1==24||LA20_1==26||LA20_1==37) ) {
                            alt20=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 20, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1577:2: ( (lv_ownedUnitsType_4_0= ruleUnitsType ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1577:2: ( (lv_ownedUnitsType_4_0= ruleUnitsType ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1578:1: (lv_ownedUnitsType_4_0= ruleUnitsType )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1578:1: (lv_ownedUnitsType_4_0= ruleUnitsType )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1579:3: lv_ownedUnitsType_4_0= ruleUnitsType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getUnnamedIntegerTypeAccess().getOwnedUnitsTypeUnitsTypeParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnitsType_in_ruleUnnamedIntegerType3450);
                            lv_ownedUnitsType_4_0=ruleUnitsType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getUnnamedIntegerTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedUnitsType",
                                      		lv_ownedUnitsType_4_0, 
                                      		"UnitsType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1596:6: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1596:6: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1597:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1597:1: (otherlv_5= RULE_ID )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1598:3: otherlv_5= RULE_ID
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnnamedIntegerTypeRule());
                              	        }
                                      
                            }
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnnamedIntegerType3480); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_5, grammarAccess.getUnnamedIntegerTypeAccess().getUnitsTypeUnitsTypeCrossReference_3_1_1_0()); 
                              	
                            }

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleUnnamedIntegerType"


    // $ANTLR start "entryRuleRangeType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1620:1: entryRuleRangeType returns [EObject current=null] : iv_ruleRangeType= ruleRangeType EOF ;
    public final EObject entryRuleRangeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1621:2: (iv_ruleRangeType= ruleRangeType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1622:2: iv_ruleRangeType= ruleRangeType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeTypeRule()); 
            }
            pushFollow(FOLLOW_ruleRangeType_in_entryRuleRangeType3519);
            iv_ruleRangeType=ruleRangeType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeType3529); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeType"


    // $ANTLR start "ruleRangeType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1629:1: ruleRangeType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'range' otherlv_4= 'of' ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) ;
    public final EObject ruleRangeType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_ownedNumberType_5_1 = null;

        EObject lv_ownedNumberType_5_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1632:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'range' otherlv_4= 'of' ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1633:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'range' otherlv_4= 'of' ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1633:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'range' otherlv_4= 'of' ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1633:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'range' otherlv_4= 'of' ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1633:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1634:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1634:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1635:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeType3571); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRangeTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRangeTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRangeType3588); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRangeTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleRangeType3600); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRangeTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleRangeType3612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRangeTypeAccess().getRangeKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleRangeType3624); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRangeTypeAccess().getOfKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1667:1: ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=27 && LA23_0<=28)) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_ID) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1667:2: ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1667:2: ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1668:1: ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1668:1: ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1669:1: (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1669:1: (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==28) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==27) ) {
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
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1670:3: lv_ownedNumberType_5_1= ruleUnnamedIntegerType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRangeTypeAccess().getOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_5_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnnamedIntegerType_in_ruleRangeType3648);
                            lv_ownedNumberType_5_1=ruleUnnamedIntegerType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRangeTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedNumberType",
                                      		lv_ownedNumberType_5_1, 
                                      		"UnnamedIntegerType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1685:8: lv_ownedNumberType_5_2= ruleUnnamedRealType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRangeTypeAccess().getOwnedNumberTypeUnnamedRealTypeParserRuleCall_5_0_0_1()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnnamedRealType_in_ruleRangeType3667);
                            lv_ownedNumberType_5_2=ruleUnnamedRealType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRangeTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedNumberType",
                                      		lv_ownedNumberType_5_2, 
                                      		"UnnamedRealType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1704:6: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1704:6: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1705:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1705:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1706:3: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRangeTypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRangeTypeAccess().getNumberTypeNumberTypeCrossReference_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQPREF_in_ruleRangeType3703);
                    ruleQPREF();

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeType"


    // $ANTLR start "entryRuleUnnamedRangeType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1730:1: entryRuleUnnamedRangeType returns [EObject current=null] : iv_ruleUnnamedRangeType= ruleUnnamedRangeType EOF ;
    public final EObject entryRuleUnnamedRangeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedRangeType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1731:2: (iv_ruleUnnamedRangeType= ruleUnnamedRangeType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1732:2: iv_ruleUnnamedRangeType= ruleUnnamedRangeType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedRangeTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedRangeType_in_entryRuleUnnamedRangeType3740);
            iv_ruleUnnamedRangeType=ruleUnnamedRangeType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedRangeType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedRangeType3750); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedRangeType"


    // $ANTLR start "ruleUnnamedRangeType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1739:1: ruleUnnamedRangeType returns [EObject current=null] : ( () otherlv_1= 'range' otherlv_2= 'of' ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) ;
    public final EObject ruleUnnamedRangeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedNumberType_3_1 = null;

        EObject lv_ownedNumberType_3_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1742:28: ( ( () otherlv_1= 'range' otherlv_2= 'of' ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1743:1: ( () otherlv_1= 'range' otherlv_2= 'of' ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1743:1: ( () otherlv_1= 'range' otherlv_2= 'of' ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1743:2: () otherlv_1= 'range' otherlv_2= 'of' ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1743:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1744:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedRangeTypeAccess().getRangeTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleUnnamedRangeType3799); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedRangeTypeAccess().getRangeKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleUnnamedRangeType3811); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getUnnamedRangeTypeAccess().getOfKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1760:1: ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=27 && LA25_0<=28)) ) {
                alt25=1;
            }
            else if ( (LA25_0==RULE_ID) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1760:2: ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1760:2: ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1761:1: ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1761:1: ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1762:1: (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1762:1: (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==28) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==27) ) {
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
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1763:3: lv_ownedNumberType_3_1= ruleUnnamedIntegerType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getUnnamedRangeTypeAccess().getOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_3_0_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedRangeType3835);
                            lv_ownedNumberType_3_1=ruleUnnamedIntegerType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getUnnamedRangeTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedNumberType",
                                      		lv_ownedNumberType_3_1, 
                                      		"UnnamedIntegerType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1778:8: lv_ownedNumberType_3_2= ruleUnnamedRealType
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getUnnamedRangeTypeAccess().getOwnedNumberTypeUnnamedRealTypeParserRuleCall_3_0_0_1()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnnamedRealType_in_ruleUnnamedRangeType3854);
                            lv_ownedNumberType_3_2=ruleUnnamedRealType();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getUnnamedRangeTypeRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedNumberType",
                                      		lv_ownedNumberType_3_2, 
                                      		"UnnamedRealType");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1797:6: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1797:6: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1798:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1798:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1799:3: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getUnnamedRangeTypeRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedRangeTypeAccess().getNumberTypeNumberTypeCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQPREF_in_ruleUnnamedRangeType3890);
                    ruleQPREF();

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

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnnamedRangeType"


    // $ANTLR start "entryRuleClassifierType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1823:1: entryRuleClassifierType returns [EObject current=null] : iv_ruleClassifierType= ruleClassifierType EOF ;
    public final EObject entryRuleClassifierType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1824:2: (iv_ruleClassifierType= ruleClassifierType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1825:2: iv_ruleClassifierType= ruleClassifierType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierTypeRule()); 
            }
            pushFollow(FOLLOW_ruleClassifierType_in_entryRuleClassifierType3927);
            iv_ruleClassifierType=ruleClassifierType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifierType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassifierType3937); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifierType"


    // $ANTLR start "ruleClassifierType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1832:1: ruleClassifierType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'classifier' ( ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )* )? ) ;
    public final EObject ruleClassifierType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_classifierReference_4_0 = null;

        EObject lv_classifierReference_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1835:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'classifier' ( ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )* )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1836:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'classifier' ( ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )* )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1836:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'classifier' ( ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )* )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1836:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'classifier' ( ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )* )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1836:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1837:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1837:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1838:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassifierType3979); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getClassifierTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClassifierTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleClassifierType3996); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getClassifierTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleClassifierType4008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClassifierTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,31,FOLLOW_31_in_ruleClassifierType4020); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getClassifierTypeAccess().getClassifierKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1866:1: ( ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID||LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1866:2: ( (lv_classifierReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1866:2: ( (lv_classifierReference_4_0= ruleQCReference ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1867:1: (lv_classifierReference_4_0= ruleQCReference )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1867:1: (lv_classifierReference_4_0= ruleQCReference )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1868:3: lv_classifierReference_4_0= ruleQCReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassifierTypeAccess().getClassifierReferenceQCReferenceParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCReference_in_ruleClassifierType4042);
                    lv_classifierReference_4_0=ruleQCReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassifierTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"classifierReference",
                              		lv_classifierReference_4_0, 
                              		"QCReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1884:2: (otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==15) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1884:4: otherlv_5= ',' ( (lv_classifierReference_6_0= ruleQCReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleClassifierType4055); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getClassifierTypeAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1888:1: ( (lv_classifierReference_6_0= ruleQCReference ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1889:1: (lv_classifierReference_6_0= ruleQCReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1889:1: (lv_classifierReference_6_0= ruleQCReference )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1890:3: lv_classifierReference_6_0= ruleQCReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClassifierTypeAccess().getClassifierReferenceQCReferenceParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleQCReference_in_ruleClassifierType4076);
                    	    lv_classifierReference_6_0=ruleQCReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getClassifierTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"classifierReference",
                    	              		lv_classifierReference_6_0, 
                    	              		"QCReference");
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
    // $ANTLR end "ruleClassifierType"


    // $ANTLR start "entryRuleUnnamedClassifierType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1914:1: entryRuleUnnamedClassifierType returns [EObject current=null] : iv_ruleUnnamedClassifierType= ruleUnnamedClassifierType EOF ;
    public final EObject entryRuleUnnamedClassifierType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedClassifierType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1915:2: (iv_ruleUnnamedClassifierType= ruleUnnamedClassifierType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1916:2: iv_ruleUnnamedClassifierType= ruleUnnamedClassifierType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedClassifierTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedClassifierType_in_entryRuleUnnamedClassifierType4116);
            iv_ruleUnnamedClassifierType=ruleUnnamedClassifierType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedClassifierType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedClassifierType4126); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedClassifierType"


    // $ANTLR start "ruleUnnamedClassifierType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1923:1: ruleUnnamedClassifierType returns [EObject current=null] : ( () otherlv_1= 'classifier' ( ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )* )? ) ;
    public final EObject ruleUnnamedClassifierType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_classifierReference_2_0 = null;

        EObject lv_classifierReference_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1926:28: ( ( () otherlv_1= 'classifier' ( ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )* )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1927:1: ( () otherlv_1= 'classifier' ( ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )* )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1927:1: ( () otherlv_1= 'classifier' ( ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )* )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1927:2: () otherlv_1= 'classifier' ( ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )* )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1927:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1928:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedClassifierTypeAccess().getClassifierTypeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleUnnamedClassifierType4175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedClassifierTypeAccess().getClassifierKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1940:1: ( ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_ID) ) {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==EOF||LA29_2==RULE_ID||LA29_2==15||LA29_2==24||LA29_2==26||LA29_2==37) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1940:2: ( (lv_classifierReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1940:2: ( (lv_classifierReference_2_0= ruleQCReference ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1941:1: (lv_classifierReference_2_0= ruleQCReference )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1941:1: (lv_classifierReference_2_0= ruleQCReference )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1942:3: lv_classifierReference_2_0= ruleQCReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedClassifierTypeAccess().getClassifierReferenceQCReferenceParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCReference_in_ruleUnnamedClassifierType4197);
                    lv_classifierReference_2_0=ruleQCReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnnamedClassifierTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"classifierReference",
                              		lv_classifierReference_2_0, 
                              		"QCReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1958:2: (otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==15) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1958:4: otherlv_3= ',' ( (lv_classifierReference_4_0= ruleQCReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleUnnamedClassifierType4210); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getUnnamedClassifierTypeAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1962:1: ( (lv_classifierReference_4_0= ruleQCReference ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1963:1: (lv_classifierReference_4_0= ruleQCReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1963:1: (lv_classifierReference_4_0= ruleQCReference )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1964:3: lv_classifierReference_4_0= ruleQCReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getUnnamedClassifierTypeAccess().getClassifierReferenceQCReferenceParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleQCReference_in_ruleUnnamedClassifierType4231);
                    	    lv_classifierReference_4_0=ruleQCReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getUnnamedClassifierTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"classifierReference",
                    	              		lv_classifierReference_4_0, 
                    	              		"QCReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


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
    // $ANTLR end "ruleUnnamedClassifierType"


    // $ANTLR start "entryRuleQCReference"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1988:1: entryRuleQCReference returns [EObject current=null] : iv_ruleQCReference= ruleQCReference EOF ;
    public final EObject entryRuleQCReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQCReference = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1989:2: (iv_ruleQCReference= ruleQCReference EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1990:2: iv_ruleQCReference= ruleQCReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleQCReference_in_entryRuleQCReference4271);
            iv_ruleQCReference=ruleQCReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCReference4281); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCReference"


    // $ANTLR start "ruleQCReference"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:1997:1: ruleQCReference returns [EObject current=null] : ( (otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR )? ( (lv_metaclassName_5_0= RULE_ID ) ) ) ;
    public final EObject ruleQCReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_annexName_1_0=null;
        Token otherlv_2=null;
        Token lv_metaclassName_5_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2000:28: ( ( (otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR )? ( (lv_metaclassName_5_0= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2001:1: ( (otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR )? ( (lv_metaclassName_5_0= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2001:1: ( (otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR )? ( (lv_metaclassName_5_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2001:2: (otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR )? ( (lv_metaclassName_5_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2001:2: (otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2001:4: otherlv_0= '{' ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= '}' ruleSTAR ruleSTAR
                    {
                    otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleQCReference4319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getQCReferenceAccess().getLeftCurlyBracketKeyword_0_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2005:1: ( (lv_annexName_1_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2006:1: (lv_annexName_1_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2006:1: (lv_annexName_1_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2007:3: lv_annexName_1_0= RULE_ID
                    {
                    lv_annexName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCReference4336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_annexName_1_0, grammarAccess.getQCReferenceAccess().getAnnexNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getQCReferenceRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"annexName",
                              		lv_annexName_1_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleQCReference4353); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getQCReferenceAccess().getRightCurlyBracketKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getQCReferenceAccess().getSTARParserRuleCall_0_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSTAR_in_ruleQCReference4372);
                    ruleSTAR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getQCReferenceAccess().getSTARParserRuleCall_0_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSTAR_in_ruleQCReference4390);
                    ruleSTAR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2049:3: ( (lv_metaclassName_5_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2050:1: (lv_metaclassName_5_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2050:1: (lv_metaclassName_5_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2051:3: lv_metaclassName_5_0= RULE_ID
            {
            lv_metaclassName_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCReference4408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_metaclassName_5_0, grammarAccess.getQCReferenceAccess().getMetaclassNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getQCReferenceRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"metaclassName",
                      		lv_metaclassName_5_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleQCReference"


    // $ANTLR start "entryRuleReferenceType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2075:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2076:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2077:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FOLLOW_ruleReferenceType_in_entryRuleReferenceType4449);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceType4459); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceType"


    // $ANTLR start "ruleReferenceType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2084:1: ruleReferenceType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'reference' ( ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )* )? ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_namedElementReference_4_0 = null;

        EObject lv_namedElementReference_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2087:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'reference' ( ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )* )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2088:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'reference' ( ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )* )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2088:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'reference' ( ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )* )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2088:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'reference' ( ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )* )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2088:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2089:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2089:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2090:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceType4501); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getReferenceTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReferenceTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleReferenceType4518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleReferenceType4530); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReferenceTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleReferenceType4542); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReferenceTypeAccess().getReferenceKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2118:1: ( ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||LA32_0==32) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2118:2: ( (lv_namedElementReference_4_0= ruleQCReference ) ) (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2118:2: ( (lv_namedElementReference_4_0= ruleQCReference ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2119:1: (lv_namedElementReference_4_0= ruleQCReference )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2119:1: (lv_namedElementReference_4_0= ruleQCReference )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2120:3: lv_namedElementReference_4_0= ruleQCReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceQCReferenceParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCReference_in_ruleReferenceType4564);
                    lv_namedElementReference_4_0=ruleQCReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"namedElementReference",
                              		lv_namedElementReference_4_0, 
                              		"QCReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2136:2: (otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==15) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2136:4: otherlv_5= ',' ( (lv_namedElementReference_6_0= ruleQCReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleReferenceType4577); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getReferenceTypeAccess().getCommaKeyword_4_1_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2140:1: ( (lv_namedElementReference_6_0= ruleQCReference ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2141:1: (lv_namedElementReference_6_0= ruleQCReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2141:1: (lv_namedElementReference_6_0= ruleQCReference )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2142:3: lv_namedElementReference_6_0= ruleQCReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceQCReferenceParserRuleCall_4_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleQCReference_in_ruleReferenceType4598);
                    	    lv_namedElementReference_6_0=ruleQCReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"namedElementReference",
                    	              		lv_namedElementReference_6_0, 
                    	              		"QCReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


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
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "entryRuleUnnamedReferenceType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2166:1: entryRuleUnnamedReferenceType returns [EObject current=null] : iv_ruleUnnamedReferenceType= ruleUnnamedReferenceType EOF ;
    public final EObject entryRuleUnnamedReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedReferenceType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2167:2: (iv_ruleUnnamedReferenceType= ruleUnnamedReferenceType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2168:2: iv_ruleUnnamedReferenceType= ruleUnnamedReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedReferenceTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedReferenceType_in_entryRuleUnnamedReferenceType4638);
            iv_ruleUnnamedReferenceType=ruleUnnamedReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedReferenceType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedReferenceType4648); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedReferenceType"


    // $ANTLR start "ruleUnnamedReferenceType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2175:1: ruleUnnamedReferenceType returns [EObject current=null] : (otherlv_0= 'reference' () ( ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )* )? ) ;
    public final EObject ruleUnnamedReferenceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_namedElementReference_2_0 = null;

        EObject lv_namedElementReference_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2178:28: ( (otherlv_0= 'reference' () ( ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )* )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2179:1: (otherlv_0= 'reference' () ( ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )* )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2179:1: (otherlv_0= 'reference' () ( ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )* )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2179:3: otherlv_0= 'reference' () ( ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )* )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleUnnamedReferenceType4685); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUnnamedReferenceTypeAccess().getReferenceKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2183:1: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2184:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnnamedReferenceTypeAccess().getReferenceTypeAction_1(),
                          current);
                  
            }

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2192:2: ( ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_ID) ) {
                int LA34_2 = input.LA(2);

                if ( (LA34_2==EOF||LA34_2==RULE_ID||LA34_2==15||LA34_2==24||LA34_2==26||LA34_2==37) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2192:3: ( (lv_namedElementReference_2_0= ruleQCReference ) ) (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2192:3: ( (lv_namedElementReference_2_0= ruleQCReference ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2193:1: (lv_namedElementReference_2_0= ruleQCReference )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2193:1: (lv_namedElementReference_2_0= ruleQCReference )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2194:3: lv_namedElementReference_2_0= ruleQCReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnnamedReferenceTypeAccess().getNamedElementReferenceQCReferenceParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQCReference_in_ruleUnnamedReferenceType4719);
                    lv_namedElementReference_2_0=ruleQCReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnnamedReferenceTypeRule());
                      	        }
                             		add(
                             			current, 
                             			"namedElementReference",
                              		lv_namedElementReference_2_0, 
                              		"QCReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2210:2: (otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==15) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2210:4: otherlv_3= ',' ( (lv_namedElementReference_4_0= ruleQCReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleUnnamedReferenceType4732); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getUnnamedReferenceTypeAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2214:1: ( (lv_namedElementReference_4_0= ruleQCReference ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2215:1: (lv_namedElementReference_4_0= ruleQCReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2215:1: (lv_namedElementReference_4_0= ruleQCReference )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2216:3: lv_namedElementReference_4_0= ruleQCReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getUnnamedReferenceTypeAccess().getNamedElementReferenceQCReferenceParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleQCReference_in_ruleUnnamedReferenceType4753);
                    	    lv_namedElementReference_4_0=ruleQCReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getUnnamedReferenceTypeRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"namedElementReference",
                    	              		lv_namedElementReference_4_0, 
                    	              		"QCReference");
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
    // $ANTLR end "ruleUnnamedReferenceType"


    // $ANTLR start "entryRuleRecordType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2240:1: entryRuleRecordType returns [EObject current=null] : iv_ruleRecordType= ruleRecordType EOF ;
    public final EObject entryRuleRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2241:2: (iv_ruleRecordType= ruleRecordType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2242:2: iv_ruleRecordType= ruleRecordType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTypeRule()); 
            }
            pushFollow(FOLLOW_ruleRecordType_in_entryRuleRecordType4793);
            iv_ruleRecordType=ruleRecordType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordType4803); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordType"


    // $ANTLR start "ruleRecordType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2249:1: ruleRecordType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'record' otherlv_4= '(' ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= ')' ) ;
    public final EObject ruleRecordType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedField_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2252:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'record' otherlv_4= '(' ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2253:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'record' otherlv_4= '(' ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2253:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'record' otherlv_4= '(' ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2253:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'type' otherlv_3= 'record' otherlv_4= '(' ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= ')'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2253:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2254:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2254:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2255:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordType4845); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRecordTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRecordTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRecordType4862); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRecordTypeAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleRecordType4874); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRecordTypeAccess().getTypeKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleRecordType4886); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRecordTypeAccess().getRecordKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleRecordType4898); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRecordTypeAccess().getLeftParenthesisKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2287:1: ( (lv_ownedField_5_0= ruleRecordField ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2288:1: (lv_ownedField_5_0= ruleRecordField )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2288:1: (lv_ownedField_5_0= ruleRecordField )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2289:3: lv_ownedField_5_0= ruleRecordField
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTypeAccess().getOwnedFieldRecordFieldParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRecordField_in_ruleRecordType4919);
            	    lv_ownedField_5_0=ruleRecordField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRecordTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedField",
            	              		lv_ownedField_5_0, 
            	              		"RecordField");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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

            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleRecordType4932); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRecordTypeAccess().getRightParenthesisKeyword_6());
                  
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
    // $ANTLR end "ruleRecordType"


    // $ANTLR start "entryRuleUnnamedRecordType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2317:1: entryRuleUnnamedRecordType returns [EObject current=null] : iv_ruleUnnamedRecordType= ruleUnnamedRecordType EOF ;
    public final EObject entryRuleUnnamedRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedRecordType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2318:2: (iv_ruleUnnamedRecordType= ruleUnnamedRecordType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2319:2: iv_ruleUnnamedRecordType= ruleUnnamedRecordType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnnamedRecordTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUnnamedRecordType_in_entryRuleUnnamedRecordType4968);
            iv_ruleUnnamedRecordType=ruleUnnamedRecordType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnnamedRecordType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnnamedRecordType4978); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnnamedRecordType"


    // $ANTLR start "ruleUnnamedRecordType"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2326:1: ruleUnnamedRecordType returns [EObject current=null] : (otherlv_0= 'record' otherlv_1= '(' ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= ')' ) ;
    public final EObject ruleUnnamedRecordType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedField_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2329:28: ( (otherlv_0= 'record' otherlv_1= '(' ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2330:1: (otherlv_0= 'record' otherlv_1= '(' ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2330:1: (otherlv_0= 'record' otherlv_1= '(' ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2330:3: otherlv_0= 'record' otherlv_1= '(' ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleUnnamedRecordType5015); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUnnamedRecordTypeAccess().getRecordKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleUnnamedRecordType5027); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnnamedRecordTypeAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2338:1: ( (lv_ownedField_2_0= ruleRecordField ) )+
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
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2339:1: (lv_ownedField_2_0= ruleRecordField )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2339:1: (lv_ownedField_2_0= ruleRecordField )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2340:3: lv_ownedField_2_0= ruleRecordField
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getUnnamedRecordTypeAccess().getOwnedFieldRecordFieldParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleRecordField_in_ruleUnnamedRecordType5048);
            	    lv_ownedField_2_0=ruleRecordField();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getUnnamedRecordTypeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedField",
            	              		lv_ownedField_2_0, 
            	              		"RecordField");
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleUnnamedRecordType5061); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getUnnamedRecordTypeAccess().getRightParenthesisKeyword_3());
                  
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
    // $ANTLR end "ruleUnnamedRecordType"


    // $ANTLR start "entryRuleRecordField"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2368:1: entryRuleRecordField returns [EObject current=null] : iv_ruleRecordField= ruleRecordField EOF ;
    public final EObject entryRuleRecordField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordField = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2369:2: (iv_ruleRecordField= ruleRecordField EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2370:2: iv_ruleRecordField= ruleRecordField EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordFieldRule()); 
            }
            pushFollow(FOLLOW_ruleRecordField_in_entryRuleRecordField5097);
            iv_ruleRecordField=ruleRecordField();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordField; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordField5107); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordField"


    // $ANTLR start "ruleRecordField"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2377:1: ruleRecordField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) ) ) ) ;
    public final EObject ruleRecordField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_ownedType_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2380:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2381:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2381:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2381:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2381:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2382:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2382:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2383:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordField5149); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRecordFieldAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRecordFieldRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleRecordField5166); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRecordFieldAccess().getColonKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2403:1: ( ( ( ruleQPREF ) ) | ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            else if ( ((LA37_0>=20 && LA37_0<=22)||LA37_0==25||(LA37_0>=27 && LA37_0<=29)||LA37_0==31||(LA37_0>=34 && LA37_0<=35)) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2403:2: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2403:2: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2404:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2404:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2405:3: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRecordFieldRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRecordFieldAccess().getTypePropertyTypeCrossReference_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQPREF_in_ruleRecordField5194);
                    ruleQPREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2422:6: ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2422:6: ( (lv_ownedType_3_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2423:1: (lv_ownedType_3_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2423:1: (lv_ownedType_3_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2424:3: lv_ownedType_3_0= ruleUnnamedPropertyType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRecordFieldAccess().getOwnedTypeUnnamedPropertyTypeParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnnamedPropertyType_in_ruleRecordField5221);
                    lv_ownedType_3_0=ruleUnnamedPropertyType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRecordFieldRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"UnnamedPropertyType");
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
    // $ANTLR end "ruleRecordField"


    // $ANTLR start "entryRulePropertyDefinition"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2448:1: entryRulePropertyDefinition returns [EObject current=null] : iv_rulePropertyDefinition= rulePropertyDefinition EOF ;
    public final EObject entryRulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefinition = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2449:2: (iv_rulePropertyDefinition= rulePropertyDefinition EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2450:2: iv_rulePropertyDefinition= rulePropertyDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyDefinitionRule()); 
            }
            pushFollow(FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition5258);
            iv_rulePropertyDefinition=rulePropertyDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyDefinition5268); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyDefinition"


    // $ANTLR start "rulePropertyDefinition"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2457:1: rulePropertyDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inherit_2_0= 'inherit' ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= 'applies' otherlv_8= 'to' otherlv_9= '(' ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= ')' otherlv_15= ';' ) ;
    public final EObject rulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_inherit_2_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedType_4_0 = null;

        EObject lv_defaultValue_6_0 = null;

        EObject lv_appliesTo_10_0 = null;

        EObject lv_appliesTo_12_0 = null;

        EObject lv_appliesTo_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2460:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inherit_2_0= 'inherit' ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= 'applies' otherlv_8= 'to' otherlv_9= '(' ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= ')' otherlv_15= ';' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2461:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inherit_2_0= 'inherit' ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= 'applies' otherlv_8= 'to' otherlv_9= '(' ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= ')' otherlv_15= ';' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2461:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inherit_2_0= 'inherit' ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= 'applies' otherlv_8= 'to' otherlv_9= '(' ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= ')' otherlv_15= ';' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2461:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_inherit_2_0= 'inherit' ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= 'applies' otherlv_8= 'to' otherlv_9= '(' ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= ')' otherlv_15= ';'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2461:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2462:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2462:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2463:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyDefinition5310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePropertyDefinition5327); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyDefinitionAccess().getColonKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2483:1: ( (lv_inherit_2_0= 'inherit' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==36) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2484:1: (lv_inherit_2_0= 'inherit' )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2484:1: (lv_inherit_2_0= 'inherit' )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2485:3: lv_inherit_2_0= 'inherit'
                    {
                    lv_inherit_2_0=(Token)match(input,36,FOLLOW_36_in_rulePropertyDefinition5345); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_inherit_2_0, grammarAccess.getPropertyDefinitionAccess().getInheritInheritKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyDefinitionRule());
                      	        }
                             		setWithLastConsumed(current, "inherit", true, "inherit");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2498:3: ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=20 && LA39_0<=22)||LA39_0==25||(LA39_0>=27 && LA39_0<=29)||LA39_0==31||(LA39_0>=34 && LA39_0<=35)) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2498:4: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2498:4: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2499:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2499:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2500:3: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyDefinitionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeCrossReference_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQPREF_in_rulePropertyDefinition5387);
                    ruleQPREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2517:6: ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2517:6: ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2518:1: (lv_ownedType_4_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2518:1: (lv_ownedType_4_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2519:3: lv_ownedType_4_0= ruleUnnamedPropertyType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getOwnedTypeUnnamedPropertyTypeParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnnamedPropertyType_in_rulePropertyDefinition5414);
                    lv_ownedType_4_0=ruleUnnamedPropertyType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_4_0, 
                              		"UnnamedPropertyType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2535:3: (otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==26) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2535:5: otherlv_5= '=>' ( (lv_defaultValue_6_0= rulePropertyExpression ) )
                    {
                    otherlv_5=(Token)match(input,26,FOLLOW_26_in_rulePropertyDefinition5428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPropertyDefinitionAccess().getEqualsSignGreaterThanSignKeyword_4_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2539:1: ( (lv_defaultValue_6_0= rulePropertyExpression ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2540:1: (lv_defaultValue_6_0= rulePropertyExpression )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2540:1: (lv_defaultValue_6_0= rulePropertyExpression )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2541:3: lv_defaultValue_6_0= rulePropertyExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultValuePropertyExpressionParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePropertyExpression_in_rulePropertyDefinition5449);
                    lv_defaultValue_6_0=rulePropertyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"defaultValue",
                              		lv_defaultValue_6_0, 
                              		"PropertyExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,37,FOLLOW_37_in_rulePropertyDefinition5463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getPropertyDefinitionAccess().getAppliesKeyword_5());
                  
            }
            otherlv_8=(Token)match(input,38,FOLLOW_38_in_rulePropertyDefinition5475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getPropertyDefinitionAccess().getToKeyword_6());
                  
            }
            otherlv_9=(Token)match(input,23,FOLLOW_23_in_rulePropertyDefinition5487); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getPropertyDefinitionAccess().getLeftParenthesisKeyword_7());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2569:1: ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID||LA42_0==32) ) {
                alt42=1;
            }
            else if ( (LA42_0==39) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2569:2: ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2569:2: ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2569:3: ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2569:3: ( (lv_appliesTo_10_0= rulePropertyOwner ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2570:1: (lv_appliesTo_10_0= rulePropertyOwner )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2570:1: (lv_appliesTo_10_0= rulePropertyOwner )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2571:3: lv_appliesTo_10_0= rulePropertyOwner
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAppliesToPropertyOwnerParserRuleCall_8_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5510);
                    lv_appliesTo_10_0=rulePropertyOwner();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      	        }
                             		add(
                             			current, 
                             			"appliesTo",
                              		lv_appliesTo_10_0, 
                              		"PropertyOwner");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2587:2: (otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==15) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2587:4: otherlv_11= ',' ( (lv_appliesTo_12_0= rulePropertyOwner ) )
                    	    {
                    	    otherlv_11=(Token)match(input,15,FOLLOW_15_in_rulePropertyDefinition5523); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getPropertyDefinitionAccess().getCommaKeyword_8_0_1_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2591:1: ( (lv_appliesTo_12_0= rulePropertyOwner ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2592:1: (lv_appliesTo_12_0= rulePropertyOwner )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2592:1: (lv_appliesTo_12_0= rulePropertyOwner )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2593:3: lv_appliesTo_12_0= rulePropertyOwner
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAppliesToPropertyOwnerParserRuleCall_8_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5544);
                    	    lv_appliesTo_12_0=rulePropertyOwner();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"appliesTo",
                    	              		lv_appliesTo_12_0, 
                    	              		"PropertyOwner");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2610:6: ( (lv_appliesTo_13_0= ruleAllReference ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2610:6: ( (lv_appliesTo_13_0= ruleAllReference ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2611:1: (lv_appliesTo_13_0= ruleAllReference )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2611:1: (lv_appliesTo_13_0= ruleAllReference )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2612:3: lv_appliesTo_13_0= ruleAllReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAppliesToAllReferenceParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAllReference_in_rulePropertyDefinition5574);
                    lv_appliesTo_13_0=ruleAllReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                      	        }
                             		add(
                             			current, 
                             			"appliesTo",
                              		lv_appliesTo_13_0, 
                              		"AllReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,24,FOLLOW_24_in_rulePropertyDefinition5587); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getPropertyDefinitionAccess().getRightParenthesisKeyword_9());
                  
            }
            otherlv_15=(Token)match(input,16,FOLLOW_16_in_rulePropertyDefinition5599); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_10());
                  
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
    // $ANTLR end "rulePropertyDefinition"


    // $ANTLR start "entryRuleAllReference"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2644:1: entryRuleAllReference returns [EObject current=null] : iv_ruleAllReference= ruleAllReference EOF ;
    public final EObject entryRuleAllReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllReference = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2645:2: (iv_ruleAllReference= ruleAllReference EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2646:2: iv_ruleAllReference= ruleAllReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAllReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleAllReference_in_entryRuleAllReference5635);
            iv_ruleAllReference=ruleAllReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAllReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAllReference5645); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAllReference"


    // $ANTLR start "ruleAllReference"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2653:1: ruleAllReference returns [EObject current=null] : ( (lv_metaclassName_0_0= 'all' ) ) ;
    public final EObject ruleAllReference() throws RecognitionException {
        EObject current = null;

        Token lv_metaclassName_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2656:28: ( ( (lv_metaclassName_0_0= 'all' ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2657:1: ( (lv_metaclassName_0_0= 'all' ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2657:1: ( (lv_metaclassName_0_0= 'all' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2658:1: (lv_metaclassName_0_0= 'all' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2658:1: (lv_metaclassName_0_0= 'all' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2659:3: lv_metaclassName_0_0= 'all'
            {
            lv_metaclassName_0_0=(Token)match(input,39,FOLLOW_39_in_ruleAllReference5687); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_metaclassName_0_0, grammarAccess.getAllReferenceAccess().getMetaclassNameAllKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAllReferenceRule());
              	        }
                     		addWithLastConsumed(current, "metaclassName", lv_metaclassName_0_0, "all");
              	    
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
    // $ANTLR end "ruleAllReference"


    // $ANTLR start "entryRulePropertyOwner"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2680:1: entryRulePropertyOwner returns [EObject current=null] : iv_rulePropertyOwner= rulePropertyOwner EOF ;
    public final EObject entryRulePropertyOwner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyOwner = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2681:2: (iv_rulePropertyOwner= rulePropertyOwner EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2682:2: iv_rulePropertyOwner= rulePropertyOwner EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyOwnerRule()); 
            }
            pushFollow(FOLLOW_rulePropertyOwner_in_entryRulePropertyOwner5735);
            iv_rulePropertyOwner=rulePropertyOwner();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyOwner; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyOwner5745); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyOwner"


    // $ANTLR start "rulePropertyOwner"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2689:1: rulePropertyOwner returns [EObject current=null] : (this_ClassifierValue_0= ruleClassifierValue | this_QCReference_1= ruleQCReference ) ;
    public final EObject rulePropertyOwner() throws RecognitionException {
        EObject current = null;

        EObject this_ClassifierValue_0 = null;

        EObject this_QCReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2692:28: ( (this_ClassifierValue_0= ruleClassifierValue | this_QCReference_1= ruleQCReference ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2693:1: (this_ClassifierValue_0= ruleClassifierValue | this_QCReference_1= ruleQCReference )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2693:1: (this_ClassifierValue_0= ruleClassifierValue | this_QCReference_1= ruleQCReference )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==57) ) {
                    alt43=1;
                }
                else if ( (LA43_1==EOF||LA43_1==15||LA43_1==24) ) {
                    alt43=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA43_0==32) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2694:2: this_ClassifierValue_0= ruleClassifierValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyOwnerAccess().getClassifierValueParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClassifierValue_in_rulePropertyOwner5795);
                    this_ClassifierValue_0=ruleClassifierValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClassifierValue_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2707:2: this_QCReference_1= ruleQCReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyOwnerAccess().getQCReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleQCReference_in_rulePropertyOwner5825);
                    this_QCReference_1=ruleQCReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_QCReference_1; 
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
    // $ANTLR end "rulePropertyOwner"


    // $ANTLR start "entryRuleClassifierValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2726:1: entryRuleClassifierValue returns [EObject current=null] : iv_ruleClassifierValue= ruleClassifierValue EOF ;
    public final EObject entryRuleClassifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2727:2: (iv_ruleClassifierValue= ruleClassifierValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2728:2: iv_ruleClassifierValue= ruleClassifierValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleClassifierValue_in_entryRuleClassifierValue5860);
            iv_ruleClassifierValue=ruleClassifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifierValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassifierValue5870); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifierValue"


    // $ANTLR start "ruleClassifierValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2735:1: ruleClassifierValue returns [EObject current=null] : ( ( ruleEQCREF ) ) ;
    public final EObject ruleClassifierValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2738:28: ( ( ( ruleEQCREF ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2739:1: ( ( ruleEQCREF ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2739:1: ( ( ruleEQCREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2740:1: ( ruleEQCREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2740:1: ( ruleEQCREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2741:3: ruleEQCREF
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getClassifierValueRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClassifierValueAccess().getClassifierComponentClassifierCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEQCREF_in_ruleClassifierValue5921);
            ruleEQCREF();

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
    // $ANTLR end "ruleClassifierValue"


    // $ANTLR start "entryRulePropertyConstant"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2765:1: entryRulePropertyConstant returns [EObject current=null] : iv_rulePropertyConstant= rulePropertyConstant EOF ;
    public final EObject entryRulePropertyConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyConstant = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2766:2: (iv_rulePropertyConstant= rulePropertyConstant EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2767:2: iv_rulePropertyConstant= rulePropertyConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyConstantRule()); 
            }
            pushFollow(FOLLOW_rulePropertyConstant_in_entryRulePropertyConstant5956);
            iv_rulePropertyConstant=rulePropertyConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyConstant5966); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyConstant"


    // $ANTLR start "rulePropertyConstant"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2774:1: rulePropertyConstant returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'constant' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= '=>' ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= ';' ) ;
    public final EObject rulePropertyConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedType_4_0 = null;

        EObject lv_constantValue_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2777:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'constant' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= '=>' ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= ';' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2778:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'constant' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= '=>' ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= ';' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2778:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'constant' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= '=>' ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= ';' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2778:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'constant' ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= '=>' ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= ';'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2778:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2779:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2779:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2780:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyConstant6008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPropertyConstantAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyConstantRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_rulePropertyConstant6025); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyConstantAccess().getColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,40,FOLLOW_40_in_rulePropertyConstant6037); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPropertyConstantAccess().getConstantKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2804:1: ( ( ( ruleQPREF ) ) | ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            else if ( ((LA44_0>=20 && LA44_0<=22)||LA44_0==25||(LA44_0>=27 && LA44_0<=29)||LA44_0==31||(LA44_0>=34 && LA44_0<=35)) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2804:2: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2804:2: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2805:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2805:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2806:3: ruleQPREF
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropertyConstantRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyConstantAccess().getTypePropertyTypeCrossReference_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQPREF_in_rulePropertyConstant6065);
                    ruleQPREF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2823:6: ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2823:6: ( (lv_ownedType_4_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2824:1: (lv_ownedType_4_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2824:1: (lv_ownedType_4_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2825:3: lv_ownedType_4_0= ruleUnnamedPropertyType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPropertyConstantAccess().getOwnedTypeUnnamedPropertyTypeParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnnamedPropertyType_in_rulePropertyConstant6092);
                    lv_ownedType_4_0=ruleUnnamedPropertyType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPropertyConstantRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_4_0, 
                              		"UnnamedPropertyType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,26,FOLLOW_26_in_rulePropertyConstant6105); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getPropertyConstantAccess().getEqualsSignGreaterThanSignKeyword_4());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2845:1: ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2846:1: (lv_constantValue_6_0= ruleConstantPropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2846:1: (lv_constantValue_6_0= ruleConstantPropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2847:3: lv_constantValue_6_0= ruleConstantPropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyConstantAccess().getConstantValueConstantPropertyExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConstantPropertyExpression_in_rulePropertyConstant6126);
            lv_constantValue_6_0=ruleConstantPropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyConstantRule());
              	        }
                     		set(
                     			current, 
                     			"constantValue",
                      		lv_constantValue_6_0, 
                      		"ConstantPropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_16_in_rulePropertyConstant6138); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getPropertyConstantAccess().getSemicolonKeyword_6());
                  
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
    // $ANTLR end "rulePropertyConstant"


    // $ANTLR start "entryRuleNumberValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2875:1: entryRuleNumberValue returns [EObject current=null] : iv_ruleNumberValue= ruleNumberValue EOF ;
    public final EObject entryRuleNumberValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2876:2: (iv_ruleNumberValue= ruleNumberValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2877:2: iv_ruleNumberValue= ruleNumberValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberValueRule()); 
            }
            pushFollow(FOLLOW_ruleNumberValue_in_entryRuleNumberValue6174);
            iv_ruleNumberValue=ruleNumberValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberValue6184); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberValue"


    // $ANTLR start "ruleNumberValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2884:1: ruleNumberValue returns [EObject current=null] : (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit ) ;
    public final EObject ruleNumberValue() throws RecognitionException {
        EObject current = null;

        EObject this_RealLit_0 = null;

        EObject this_IntegerLit_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2887:28: ( (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2888:1: (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2888:1: (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_INT) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==EOF||LA45_1==15||LA45_1==24) ) {
                    alt45=2;
                }
                else if ( (LA45_1==45) ) {
                    alt45=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2889:2: this_RealLit_0= ruleRealLit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumberValueAccess().getRealLitParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLit_in_ruleNumberValue6234);
                    this_RealLit_0=ruleRealLit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealLit_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2902:2: this_IntegerLit_1= ruleIntegerLit
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNumberValueAccess().getIntegerLitParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerLit_in_ruleNumberValue6264);
                    this_IntegerLit_1=ruleIntegerLit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntegerLit_1; 
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
    // $ANTLR end "ruleNumberValue"


    // $ANTLR start "entryRuleRealLit"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2921:1: entryRuleRealLit returns [EObject current=null] : iv_ruleRealLit= ruleRealLit EOF ;
    public final EObject entryRuleRealLit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLit = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2922:2: (iv_ruleRealLit= ruleRealLit EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2923:2: iv_ruleRealLit= ruleRealLit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLitRule()); 
            }
            pushFollow(FOLLOW_ruleRealLit_in_entryRuleRealLit6299);
            iv_ruleRealLit=ruleRealLit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLit6309); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLit"


    // $ANTLR start "ruleRealLit"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2930:1: ruleRealLit returns [EObject current=null] : ( (lv_value_0_0= rulegREAL ) ) ;
    public final EObject ruleRealLit() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2933:28: ( ( (lv_value_0_0= rulegREAL ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2934:1: ( (lv_value_0_0= rulegREAL ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2934:1: ( (lv_value_0_0= rulegREAL ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2935:1: (lv_value_0_0= rulegREAL )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2935:1: (lv_value_0_0= rulegREAL )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2936:3: lv_value_0_0= rulegREAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealLitAccess().getValueGREALParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulegREAL_in_ruleRealLit6354);
            lv_value_0_0=rulegREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRealLitRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"gREAL");
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
    // $ANTLR end "ruleRealLit"


    // $ANTLR start "entryRuleIntegerLit"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2960:1: entryRuleIntegerLit returns [EObject current=null] : iv_ruleIntegerLit= ruleIntegerLit EOF ;
    public final EObject entryRuleIntegerLit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLit = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2961:2: (iv_ruleIntegerLit= ruleIntegerLit EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2962:2: iv_ruleIntegerLit= ruleIntegerLit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerLitRule()); 
            }
            pushFollow(FOLLOW_ruleIntegerLit_in_entryRuleIntegerLit6389);
            iv_ruleIntegerLit=ruleIntegerLit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerLit; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLit6399); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLit"


    // $ANTLR start "ruleIntegerLit"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2969:1: ruleIntegerLit returns [EObject current=null] : ( (lv_value_0_0= rulegINT ) ) ;
    public final EObject ruleIntegerLit() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2972:28: ( ( (lv_value_0_0= rulegINT ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2973:1: ( (lv_value_0_0= rulegINT ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2973:1: ( (lv_value_0_0= rulegINT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2974:1: (lv_value_0_0= rulegINT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2974:1: (lv_value_0_0= rulegINT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:2975:3: lv_value_0_0= rulegINT
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerLitAccess().getValueGINTParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulegINT_in_ruleIntegerLit6444);
            lv_value_0_0=rulegINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIntegerLitRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"gINT");
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
    // $ANTLR end "ruleIntegerLit"


    // $ANTLR start "entryRuleModalPropertyValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3001:1: entryRuleModalPropertyValue returns [EObject current=null] : iv_ruleModalPropertyValue= ruleModalPropertyValue EOF ;
    public final EObject entryRuleModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModalPropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3002:2: (iv_ruleModalPropertyValue= ruleModalPropertyValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3003:2: iv_ruleModalPropertyValue= ruleModalPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModalPropertyValueRule()); 
            }
            pushFollow(FOLLOW_ruleModalPropertyValue_in_entryRuleModalPropertyValue6481);
            iv_ruleModalPropertyValue=ruleModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModalPropertyValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModalPropertyValue6491); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3010:1: ruleModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3013:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3014:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3014:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3014:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3014:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3015:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3015:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3016:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleModalPropertyValue6537);
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

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleModalPropertyValue6549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModalPropertyValueAccess().getInKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleModalPropertyValue6561); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModalPropertyValueAccess().getModesKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleModalPropertyValue6573); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModalPropertyValueAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3044:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3045:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3045:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3046:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModalPropertyValueRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModalPropertyValue6597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getModalPropertyValueAccess().getInModeModeCrossReference_4_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3060:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==15) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3060:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleModalPropertyValue6610); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getModalPropertyValueAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3064:1: ( (otherlv_6= RULE_ID ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3065:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3065:1: (otherlv_6= RULE_ID )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3066:3: otherlv_6= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModalPropertyValueRule());
            	      	        }
            	              
            	    }
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModalPropertyValue6634); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_6, grammarAccess.getModalPropertyValueAccess().getInModeModeCrossReference_5_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleModalPropertyValue6648); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3092:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3093:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3094:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyValueRule()); 
            }
            pushFollow(FOLLOW_rulePropertyValue_in_entryRulePropertyValue6684);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValue6694); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3101:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3104:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3105:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3105:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3106:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3106:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3107:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_rulePropertyValue6739);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3131:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3132:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3133:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression6774);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression6784); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3140:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_NumericRangeTerm_1 = null;

        EObject this_ReferenceTerm_2 = null;

        EObject this_ComputedTerm_3 = null;

        EObject this_StringTerm_4 = null;

        EObject this_RealTerm_5 = null;

        EObject this_IntegerTerm_6 = null;

        EObject this_ComponentClassifierTerm_7 = null;

        EObject this_BooleanTerm_8 = null;

        EObject this_ListTerm_9 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3143:28: ( (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3144:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3144:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm )
            int alt47=10;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3145:2: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRecordTerm_in_rulePropertyExpression6834);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3158:2: this_NumericRangeTerm_1= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression6864);
                    this_NumericRangeTerm_1=ruleNumericRangeTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumericRangeTerm_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3171:2: this_ReferenceTerm_2= ruleReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReferenceTerm_in_rulePropertyExpression6894);
                    this_ReferenceTerm_2=ruleReferenceTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReferenceTerm_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3184:2: this_ComputedTerm_3= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComputedTerm_in_rulePropertyExpression6924);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3197:2: this_StringTerm_4= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_rulePropertyExpression6954);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3210:2: this_RealTerm_5= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_rulePropertyExpression6984);
                    this_RealTerm_5=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealTerm_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3223:2: this_IntegerTerm_6= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_rulePropertyExpression7014);
                    this_IntegerTerm_6=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntegerTerm_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3236:2: this_ComponentClassifierTerm_7= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression7044);
                    this_ComponentClassifierTerm_7=ruleComponentClassifierTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ComponentClassifierTerm_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3249:2: this_BooleanTerm_8= ruleBooleanTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanTerm_in_rulePropertyExpression7074);
                    this_BooleanTerm_8=ruleBooleanTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanTerm_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3262:2: this_ListTerm_9= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleListTerm_in_rulePropertyExpression7104);
                    this_ListTerm_9=ruleListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ListTerm_9; 
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


    // $ANTLR start "entryRuleConstantPropertyExpression"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3281:1: entryRuleConstantPropertyExpression returns [EObject current=null] : iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF ;
    public final EObject entryRuleConstantPropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantPropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3282:2: (iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3283:2: iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantPropertyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConstantPropertyExpression_in_entryRuleConstantPropertyExpression7139);
            iv_ruleConstantPropertyExpression=ruleConstantPropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantPropertyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantPropertyExpression7149); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantPropertyExpression"


    // $ANTLR start "ruleConstantPropertyExpression"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3290:1: ruleConstantPropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm ) ;
    public final EObject ruleConstantPropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_NumericRangeTerm_1 = null;

        EObject this_ComputedTerm_2 = null;

        EObject this_StringTerm_3 = null;

        EObject this_RealTerm_4 = null;

        EObject this_IntegerTerm_5 = null;

        EObject this_ComponentClassifierTerm_6 = null;

        EObject this_BooleanTerm_7 = null;

        EObject this_ListTerm_8 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3293:28: ( (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3294:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3294:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm )
            int alt48=9;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3295:2: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRecordTerm_in_ruleConstantPropertyExpression7199);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3308:2: this_NumericRangeTerm_1= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getNumericRangeTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericRangeTerm_in_ruleConstantPropertyExpression7229);
                    this_NumericRangeTerm_1=ruleNumericRangeTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumericRangeTerm_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3321:2: this_ComputedTerm_2= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getComputedTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComputedTerm_in_ruleConstantPropertyExpression7259);
                    this_ComputedTerm_2=ruleComputedTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ComputedTerm_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3334:2: this_StringTerm_3= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getStringTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleConstantPropertyExpression7289);
                    this_StringTerm_3=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringTerm_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3347:2: this_RealTerm_4= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getRealTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleConstantPropertyExpression7319);
                    this_RealTerm_4=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealTerm_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3360:2: this_IntegerTerm_5= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getIntegerTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleConstantPropertyExpression7349);
                    this_IntegerTerm_5=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IntegerTerm_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3373:2: this_ComponentClassifierTerm_6= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentClassifierTerm_in_ruleConstantPropertyExpression7379);
                    this_ComponentClassifierTerm_6=ruleComponentClassifierTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ComponentClassifierTerm_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3386:2: this_BooleanTerm_7= ruleBooleanTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getBooleanTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanTerm_in_ruleConstantPropertyExpression7409);
                    this_BooleanTerm_7=ruleBooleanTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanTerm_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3399:2: this_ListTerm_8= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getListTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleListTerm_in_ruleConstantPropertyExpression7439);
                    this_ListTerm_8=ruleListTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ListTerm_8; 
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
    // $ANTLR end "ruleConstantPropertyExpression"


    // $ANTLR start "entryRuleBooleanTerm"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3418:1: entryRuleBooleanTerm returns [EObject current=null] : iv_ruleBooleanTerm= ruleBooleanTerm EOF ;
    public final EObject entryRuleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3419:2: (iv_ruleBooleanTerm= ruleBooleanTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3420:2: iv_ruleBooleanTerm= ruleBooleanTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanTermRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanTerm_in_entryRuleBooleanTerm7474);
            iv_ruleBooleanTerm=ruleBooleanTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTerm7484); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3427:1: ruleBooleanTerm returns [EObject current=null] : this_OrTerm_0= ruleOrTerm ;
    public final EObject ruleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject this_OrTerm_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3430:28: (this_OrTerm_0= ruleOrTerm )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3432:2: this_OrTerm_0= ruleOrTerm
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBooleanTermAccess().getOrTermParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleOrTerm_in_ruleBooleanTerm7533);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3451:1: entryRuleOrTerm returns [EObject current=null] : iv_ruleOrTerm= ruleOrTerm EOF ;
    public final EObject entryRuleOrTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3452:2: (iv_ruleOrTerm= ruleOrTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3453:2: iv_ruleOrTerm= ruleOrTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrTermRule()); 
            }
            pushFollow(FOLLOW_ruleOrTerm_in_entryRuleOrTerm7567);
            iv_ruleOrTerm=ruleOrTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrTerm7577); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3460:1: ruleOrTerm returns [EObject current=null] : (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* ) ;
    public final EObject ruleOrTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AndTerm_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_ownedPropertyExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3463:28: ( (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3464:1: (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3464:1: (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3465:2: this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrTermAccess().getAndTermParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndTerm_in_ruleOrTerm7627);
            this_AndTerm_0=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndTerm_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3476:1: ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==51) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3476:2: () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3476:2: ()
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3477:2: 
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3485:2: ( (lv_op_2_0= ruleOrOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3486:1: (lv_op_2_0= ruleOrOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3486:1: (lv_op_2_0= ruleOrOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3487:3: lv_op_2_0= ruleOrOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrTermAccess().getOpOrOpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOrOp_in_ruleOrTerm7660);
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3503:2: ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3504:1: (lv_ownedPropertyExpression_3_0= ruleAndTerm )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3504:1: (lv_ownedPropertyExpression_3_0= ruleAndTerm )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3505:3: lv_ownedPropertyExpression_3_0= ruleAndTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrTermAccess().getOwnedPropertyExpressionAndTermParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndTerm_in_ruleOrTerm7681);
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
            	    break loop49;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3529:1: entryRuleAndTerm returns [EObject current=null] : iv_ruleAndTerm= ruleAndTerm EOF ;
    public final EObject entryRuleAndTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3530:2: (iv_ruleAndTerm= ruleAndTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3531:2: iv_ruleAndTerm= ruleAndTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndTermRule()); 
            }
            pushFollow(FOLLOW_ruleAndTerm_in_entryRuleAndTerm7719);
            iv_ruleAndTerm=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndTerm7729); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3538:1: ruleAndTerm returns [EObject current=null] : (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* ) ;
    public final EObject ruleAndTerm() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanAtom_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_ownedPropertyExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3541:28: ( (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3542:1: (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3542:1: (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3543:2: this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndTermAccess().getBooleanAtomParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBooleanAtom_in_ruleAndTerm7779);
            this_BooleanAtom_0=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BooleanAtom_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3554:1: ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==50) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3554:2: () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3554:2: ()
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3555:2: 
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3563:2: ( (lv_op_2_0= ruleAndOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3564:1: (lv_op_2_0= ruleAndOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3564:1: (lv_op_2_0= ruleAndOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3565:3: lv_op_2_0= ruleAndOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndTermAccess().getOpAndOpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndOp_in_ruleAndTerm7812);
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3581:2: ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3582:1: (lv_ownedPropertyExpression_3_0= ruleBooleanAtom )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3582:1: (lv_ownedPropertyExpression_3_0= ruleBooleanAtom )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3583:3: lv_ownedPropertyExpression_3_0= ruleBooleanAtom
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBooleanAtom_in_ruleAndTerm7833);
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
            	    break loop50;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3607:1: entryRuleNotTerm returns [EObject current=null] : iv_ruleNotTerm= ruleNotTerm EOF ;
    public final EObject entryRuleNotTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3608:2: (iv_ruleNotTerm= ruleNotTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3609:2: iv_ruleNotTerm= ruleNotTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotTermRule()); 
            }
            pushFollow(FOLLOW_ruleNotTerm_in_entryRuleNotTerm7871);
            iv_ruleNotTerm=ruleNotTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotTerm7881); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3616:1: ruleNotTerm returns [EObject current=null] : ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) ) ;
    public final EObject ruleNotTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3619:28: ( ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3620:1: ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3620:1: ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3620:2: ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3620:2: ( (lv_op_0_0= ruleNotOp ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3621:1: (lv_op_0_0= ruleNotOp )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3621:1: (lv_op_0_0= ruleNotOp )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3622:3: lv_op_0_0= ruleNotOp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotTermAccess().getOpNotOpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNotOp_in_ruleNotTerm7927);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3638:2: ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3639:1: (lv_ownedPropertyExpression_1_0= ruleBooleanAtom )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3639:1: (lv_ownedPropertyExpression_1_0= ruleBooleanAtom )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3640:3: lv_ownedPropertyExpression_1_0= ruleBooleanAtom
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBooleanAtom_in_ruleNotTerm7948);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3664:1: entryRuleBooleanAtom returns [EObject current=null] : iv_ruleBooleanAtom= ruleBooleanAtom EOF ;
    public final EObject entryRuleBooleanAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAtom = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3665:2: (iv_ruleBooleanAtom= ruleBooleanAtom EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3666:2: iv_ruleBooleanAtom= ruleBooleanAtom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAtomRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanAtom_in_entryRuleBooleanAtom7984);
            iv_ruleBooleanAtom=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAtom; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAtom7994); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3673:1: ruleBooleanAtom returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3676:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3677:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3677:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 43:
            case 44:
                {
                alt51=1;
                }
                break;
            case 52:
                {
                alt51=2;
                }
                break;
            case RULE_ID:
                {
                alt51=3;
                }
                break;
            case 23:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3678:2: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getBooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleBooleanAtom8044);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3691:2: this_NotTerm_1= ruleNotTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getNotTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNotTerm_in_ruleBooleanAtom8074);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3704:2: this_ConstantValue_2= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getConstantValueParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleBooleanAtom8104);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3716:6: (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3716:6: (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3716:8: otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleBooleanAtom8122); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getBooleanAtomAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getBooleanTermParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanTerm_in_ruleBooleanAtom8147);
                    this_BooleanTerm_4=ruleBooleanTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanTerm_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleBooleanAtom8158); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3744:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3745:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3746:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8195);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8205); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3753:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3756:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3757:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3757:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3757:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3757:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3758:2: 
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3766:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==43) ) {
                alt52=1;
            }
            else if ( (LA52_0==44) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3766:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3766:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3767:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3767:1: (lv_value_1_0= 'true' )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3768:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,43,FOLLOW_43_in_ruleBooleanLiteral8261); if (state.failed) return current;
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3782:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleBooleanLiteral8292); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3794:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3795:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3796:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantValueRule()); 
            }
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue8329);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue8339); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3803:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3806:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3807:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3807:1: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3808:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3808:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3809:3: ruleQPREF
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
               
              	        newCompositeNode(grammarAccess.getConstantValueAccess().getConstantPropertyConstantCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQPREF_in_ruleConstantValue8390);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3833:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3834:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3835:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTermRule()); 
            }
            pushFollow(FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8425);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceTerm8435); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3842:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3845:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3846:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3846:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3846:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleReferenceTerm8472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleReferenceTerm8484); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3854:1: ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3855:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3855:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3856:3: lv_containmentPathElement_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8505);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3872:2: (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==45) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3872:4: otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_3=(Token)match(input,45,FOLLOW_45_in_ruleReferenceTerm8518); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getFullStopKeyword_3_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3876:1: ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3877:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3877:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3878:3: lv_containmentPathElement_4_0= ruleContainmentPathElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8539);
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
            	    break loop53;
                }
            } while (true);

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleReferenceTerm8553); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3906:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3907:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3908:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTermRule()); 
            }
            pushFollow(FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8589);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordTerm8599); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3915:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation ) )+ otherlv_2= ')' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3918:28: ( (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation ) )+ otherlv_2= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3919:1: (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation ) )+ otherlv_2= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3919:1: (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation ) )+ otherlv_2= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3919:3: otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation ) )+ otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleRecordTerm8636); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3923:1: ( (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation ) )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3924:1: (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3924:1: (lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3925:3: lv_ownedFieldValue_1_0= ruleBasicPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueBasicPropertyAssociationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBasicPropertyAssociation_in_ruleRecordTerm8657);
            	    lv_ownedFieldValue_1_0=ruleBasicPropertyAssociation();

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
            	              		"BasicPropertyAssociation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleRecordTerm8670); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3953:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3954:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3955:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComputedTermRule()); 
            }
            pushFollow(FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8706);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComputedTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComputedTerm8716); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3962:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3965:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3966:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3966:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3966:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleComputedTerm8753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleComputedTerm8765); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3974:1: ( (lv_function_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3975:1: (lv_function_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3975:1: (lv_function_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3976:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComputedTerm8782); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComputedTerm8799); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4004:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4005:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4006:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            }
            pushFollow(FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8835);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentClassifierTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentClassifierTerm8845); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4013:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4016:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4017:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4017:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4017:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleComponentClassifierTerm8882); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleComponentClassifierTerm8894); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4025:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4026:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4026:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4027:3: ruleQCREF
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
            pushFollow(FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm8921);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComponentClassifierTerm8933); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4055:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4056:2: (iv_ruleListTerm= ruleListTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4057:2: iv_ruleListTerm= ruleListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTermRule()); 
            }
            pushFollow(FOLLOW_ruleListTerm_in_entryRuleListTerm8969);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleListTerm8979); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4064:1: ruleListTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedListElement_1_0 = null;

        EObject lv_ownedListElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4067:28: ( (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4068:1: (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4068:1: (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4068:3: otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleListTerm9016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getListTermAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4072:1: ( (lv_ownedListElement_1_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4073:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4073:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4074:3: lv_ownedListElement_1_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm9037);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4090:2: (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==15) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4090:4: otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleListTerm9050); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getListTermAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4094:1: ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4095:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4095:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4096:3: lv_ownedListElement_3_0= rulePropertyExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm9071);
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
            	    break loop55;
                }
            } while (true);

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleListTerm9085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getListTermAccess().getRightSquareBracketKeyword_3());
                  
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


    // $ANTLR start "entryRuleBasicPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4124:1: entryRuleBasicPropertyAssociation returns [EObject current=null] : iv_ruleBasicPropertyAssociation= ruleBasicPropertyAssociation EOF ;
    public final EObject entryRuleBasicPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4125:2: (iv_ruleBasicPropertyAssociation= ruleBasicPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4126:2: iv_ruleBasicPropertyAssociation= ruleBasicPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_ruleBasicPropertyAssociation_in_entryRuleBasicPropertyAssociation9121);
            iv_ruleBasicPropertyAssociation=ruleBasicPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicPropertyAssociation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicPropertyAssociation9131); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4133:1: ruleBasicPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleBasicPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4136:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4137:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4137:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4137:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4137:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4138:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4138:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4139:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBasicPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBasicPropertyAssociation9180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getBasicPropertyAssociationAccess().getPropertyRecordFieldCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleBasicPropertyAssociation9192); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBasicPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4157:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4158:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4158:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4159:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBasicPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleBasicPropertyAssociation9213);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBasicPropertyAssociationRule());
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleBasicPropertyAssociation9225); if (state.failed) return current;
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


    // $ANTLR start "entryRuleContainmentPathElement"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4187:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4188:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4189:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement9261);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPathElement9271); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4196:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4199:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                alt57=1;
            }
            else if ( (LA57_0==49) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4201:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4201:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4202:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainmentPathElement9321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4216:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==47) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4217:1: (lv_arrayRange_1_0= ruleArrayRange )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4217:1: (lv_arrayRange_1_0= ruleArrayRange )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4218:3: lv_arrayRange_1_0= ruleArrayRange
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleArrayRange_in_ruleContainmentPathElement9342);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4235:6: (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4235:6: (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4235:8: otherlv_2= 'annex' ( ( ruleANNEXREF ) )
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleContainmentPathElement9363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getAnnexKeyword_1_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4239:1: ( ( ruleANNEXREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4240:1: ( ruleANNEXREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4240:1: ( ruleANNEXREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4241:3: ruleANNEXREF
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
                    pushFollow(FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement9390);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4265:1: entryRuleANNEXREF returns [String current=null] : iv_ruleANNEXREF= ruleANNEXREF EOF ;
    public final String entryRuleANNEXREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleANNEXREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4266:2: (iv_ruleANNEXREF= ruleANNEXREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4267:2: iv_ruleANNEXREF= ruleANNEXREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANNEXREFRule()); 
            }
            pushFollow(FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF9428);
            iv_ruleANNEXREF=ruleANNEXREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleANNEXREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleANNEXREF9439); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:1: ruleANNEXREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4277:28: ( (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4278:1: (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4278:1: (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4279:2: kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}'
            {
            kw=(Token)match(input,32,FOLLOW_32_in_ruleANNEXREF9477); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getANNEXREFAccess().getLeftCurlyBracketKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9499);
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
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9526);
            this_STAR_2=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleANNEXREF9546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_3);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_3, grammarAccess.getANNEXREFAccess().getIDTerminalRuleCall_3()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_4()); 
                  
            }
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9573);
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
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9600);
            this_STAR_5=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_5);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            kw=(Token)match(input,33,FOLLOW_33_in_ruleANNEXREF9618); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4349:1: entryRuleAndOp returns [String current=null] : iv_ruleAndOp= ruleAndOp EOF ;
    public final String entryRuleAndOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAndOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4350:2: (iv_ruleAndOp= ruleAndOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4351:2: iv_ruleAndOp= ruleAndOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndOpRule()); 
            }
            pushFollow(FOLLOW_ruleAndOp_in_entryRuleAndOp9659);
            iv_ruleAndOp=ruleAndOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOp9670); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4358:1: ruleAndOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleAndOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4361:28: (kw= 'and' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4363:2: kw= 'and'
            {
            kw=(Token)match(input,50,FOLLOW_50_in_ruleAndOp9707); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4376:1: entryRuleOrOp returns [String current=null] : iv_ruleOrOp= ruleOrOp EOF ;
    public final String entryRuleOrOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOrOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4377:2: (iv_ruleOrOp= ruleOrOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4378:2: iv_ruleOrOp= ruleOrOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrOpRule()); 
            }
            pushFollow(FOLLOW_ruleOrOp_in_entryRuleOrOp9747);
            iv_ruleOrOp=ruleOrOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrOp9758); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4385:1: ruleOrOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOrOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4388:28: (kw= 'or' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4390:2: kw= 'or'
            {
            kw=(Token)match(input,51,FOLLOW_51_in_ruleOrOp9795); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4403:1: entryRuleNotOp returns [String current=null] : iv_ruleNotOp= ruleNotOp EOF ;
    public final String entryRuleNotOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNotOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4404:2: (iv_ruleNotOp= ruleNotOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4405:2: iv_ruleNotOp= ruleNotOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotOpRule()); 
            }
            pushFollow(FOLLOW_ruleNotOp_in_entryRuleNotOp9835);
            iv_ruleNotOp=ruleNotOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOp9846); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4412:1: ruleNotOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'not' ;
    public final AntlrDatatypeRuleToken ruleNotOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4415:28: (kw= 'not' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4417:2: kw= 'not'
            {
            kw=(Token)match(input,52,FOLLOW_52_in_ruleNotOp9883); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4430:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4431:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4432:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FOLLOW_rulePlusMinus_in_entryRulePlusMinus9923);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusMinus9934); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4439:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4442:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4443:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4443:1: (kw= '+' | kw= '-' )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==53) ) {
                alt58=1;
            }
            else if ( (LA58_0==54) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4444:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_rulePlusMinus9972); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4451:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_rulePlusMinus9991); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4464:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4465:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4466:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm10031);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm10041); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4473:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4476:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4477:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4477:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4478:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4478:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4479:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm10086);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4503:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4504:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4505:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString10122);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString10133); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4512:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4515:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4516:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString10172); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4531:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4532:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4533:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FOLLOW_ruleArrayRange_in_entryRuleArrayRange10216);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayRange10226); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4540:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4543:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4544:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4544:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4544:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4544:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4545:2: 
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

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleArrayRange10275); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4557:1: ( (lv_lowerBound_2_0= rulegINT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4558:1: (lv_lowerBound_2_0= rulegINT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4558:1: (lv_lowerBound_2_0= rulegINT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4559:3: lv_lowerBound_2_0= rulegINT
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundGINTParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulegINT_in_ruleArrayRange10296);
            lv_lowerBound_2_0=rulegINT();

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
                      		"gINT");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4575:2: (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==55) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4575:4: otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) )
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_55_in_ruleArrayRange10309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4579:1: ( (lv_upperBound_4_0= rulegINT ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4580:1: (lv_upperBound_4_0= rulegINT )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4580:1: (lv_upperBound_4_0= rulegINT )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4581:3: lv_upperBound_4_0= rulegINT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundGINTParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulegINT_in_ruleArrayRange10330);
                    lv_upperBound_4_0=rulegINT();

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
                              		"gINT");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,48,FOLLOW_48_in_ruleArrayRange10344); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIntegerRange"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4609:1: entryRuleIntegerRange returns [EObject current=null] : iv_ruleIntegerRange= ruleIntegerRange EOF ;
    public final EObject entryRuleIntegerRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4610:2: (iv_ruleIntegerRange= ruleIntegerRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4611:2: iv_ruleIntegerRange= ruleIntegerRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerRangeRule()); 
            }
            pushFollow(FOLLOW_ruleIntegerRange_in_entryRuleIntegerRange10380);
            iv_ruleIntegerRange=ruleIntegerRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerRange10390); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerRange"


    // $ANTLR start "ruleIntegerRange"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4618:1: ruleIntegerRange returns [EObject current=null] : ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) ;
    public final EObject ruleIntegerRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lowerBound_0_1 = null;

        EObject lv_lowerBound_0_2 = null;

        EObject lv_lowerBound_0_3 = null;

        EObject lv_upperBound_2_1 = null;

        EObject lv_upperBound_2_2 = null;

        EObject lv_upperBound_2_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4621:28: ( ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4622:1: ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4622:1: ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4622:2: ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4622:2: ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4623:1: ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4623:1: ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4624:1: (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4624:1: (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==RULE_INT) ) {
                    alt60=1;
                }
                else if ( (LA60_1==RULE_ID) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA60_2 = input.LA(2);

                if ( (LA60_2==RULE_INT) ) {
                    alt60=1;
                }
                else if ( (LA60_2==RULE_ID) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt60=1;
                }
                break;
            case RULE_ID:
                {
                alt60=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4625:3: lv_lowerBound_0_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundIntegerTermParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10438);
                    lv_lowerBound_0_1=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"lowerBound",
                              		lv_lowerBound_0_1, 
                              		"IntegerTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4640:8: lv_lowerBound_0_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundSignedConstantParserRuleCall_0_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleIntegerRange10457);
                    lv_lowerBound_0_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"lowerBound",
                              		lv_lowerBound_0_2, 
                              		"SignedConstant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4655:8: lv_lowerBound_0_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundConstantValueParserRuleCall_0_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleIntegerRange10476);
                    lv_lowerBound_0_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"lowerBound",
                              		lv_lowerBound_0_3, 
                              		"ConstantValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleIntegerRange10491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntegerRangeAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4677:1: ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4678:1: ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4678:1: ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4679:1: (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4679:1: (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==RULE_INT) ) {
                    alt61=1;
                }
                else if ( (LA61_1==RULE_ID) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA61_2 = input.LA(2);

                if ( (LA61_2==RULE_INT) ) {
                    alt61=1;
                }
                else if ( (LA61_2==RULE_ID) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt61=1;
                }
                break;
            case RULE_ID:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4680:3: lv_upperBound_2_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundIntegerTermParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10514);
                    lv_upperBound_2_1=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_1, 
                              		"IntegerTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4695:8: lv_upperBound_2_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundSignedConstantParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleIntegerRange10533);
                    lv_upperBound_2_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_2, 
                              		"SignedConstant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4710:8: lv_upperBound_2_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundConstantValueParserRuleCall_2_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleIntegerRange10552);
                    lv_upperBound_2_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIntegerRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_3, 
                              		"ConstantValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

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
    // $ANTLR end "ruleIntegerRange"


    // $ANTLR start "entryRuleRealRange"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4736:1: entryRuleRealRange returns [EObject current=null] : iv_ruleRealRange= ruleRealRange EOF ;
    public final EObject entryRuleRealRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4737:2: (iv_ruleRealRange= ruleRealRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4738:2: iv_ruleRealRange= ruleRealRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealRangeRule()); 
            }
            pushFollow(FOLLOW_ruleRealRange_in_entryRuleRealRange10591);
            iv_ruleRealRange=ruleRealRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealRange10601); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealRange"


    // $ANTLR start "ruleRealRange"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4745:1: ruleRealRange returns [EObject current=null] : ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) ;
    public final EObject ruleRealRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_lowerBound_0_1 = null;

        EObject lv_lowerBound_0_2 = null;

        EObject lv_lowerBound_0_3 = null;

        EObject lv_upperBound_2_1 = null;

        EObject lv_upperBound_2_2 = null;

        EObject lv_upperBound_2_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4748:28: ( ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4749:1: ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4749:1: ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4749:2: ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4749:2: ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4750:1: ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4750:1: ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4751:1: (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4751:1: (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==RULE_ID) ) {
                    alt62=2;
                }
                else if ( (LA62_1==RULE_INT) ) {
                    alt62=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA62_2 = input.LA(2);

                if ( (LA62_2==RULE_INT) ) {
                    alt62=1;
                }
                else if ( (LA62_2==RULE_ID) ) {
                    alt62=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt62=1;
                }
                break;
            case RULE_ID:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4752:3: lv_lowerBound_0_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundRealTermParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleRealRange10649);
                    lv_lowerBound_0_1=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"lowerBound",
                              		lv_lowerBound_0_1, 
                              		"RealTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4767:8: lv_lowerBound_0_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundSignedConstantParserRuleCall_0_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleRealRange10668);
                    lv_lowerBound_0_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"lowerBound",
                              		lv_lowerBound_0_2, 
                              		"SignedConstant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4782:8: lv_lowerBound_0_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundConstantValueParserRuleCall_0_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleRealRange10687);
                    lv_lowerBound_0_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"lowerBound",
                              		lv_lowerBound_0_3, 
                              		"ConstantValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleRealRange10702); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRealRangeAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4804:1: ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4805:1: ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4805:1: ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4806:1: (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4806:1: (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==RULE_ID) ) {
                    alt63=2;
                }
                else if ( (LA63_1==RULE_INT) ) {
                    alt63=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA63_2 = input.LA(2);

                if ( (LA63_2==RULE_INT) ) {
                    alt63=1;
                }
                else if ( (LA63_2==RULE_ID) ) {
                    alt63=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt63=1;
                }
                break;
            case RULE_ID:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4807:3: lv_upperBound_2_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundRealTermParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleRealRange10725);
                    lv_upperBound_2_1=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_1, 
                              		"RealTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4822:8: lv_upperBound_2_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundSignedConstantParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleRealRange10744);
                    lv_upperBound_2_2=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_2, 
                              		"SignedConstant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4837:8: lv_upperBound_2_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundConstantValueParserRuleCall_2_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleRealRange10763);
                    lv_upperBound_2_3=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRealRangeRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_3, 
                              		"ConstantValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

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
    // $ANTLR end "ruleRealRange"


    // $ANTLR start "entryRuleSignedConstant"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4863:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4864:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4865:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedConstantRule()); 
            }
            pushFollow(FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant10802);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedConstant10812); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4872:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4875:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4876:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4876:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4876:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4876:2: ( (lv_op_0_0= rulePlusMinus ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4877:1: (lv_op_0_0= rulePlusMinus )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4877:1: (lv_op_0_0= rulePlusMinus )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4878:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePlusMinus_in_ruleSignedConstant10858);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4894:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4895:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4895:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4896:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConstantValue_in_ruleSignedConstant10879);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4920:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4921:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4922:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm10915);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm10925); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4929:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4932:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4933:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4933:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4933:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4933:2: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4934:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4934:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4935:3: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSignedInt_in_ruleIntegerTerm10971);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4951:2: ( (otherlv_1= RULE_ID ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==EOF||LA64_1==RULE_ID||(LA64_1>=15 && LA64_1<=16)||(LA64_1>=24 && LA64_1<=26)||LA64_1==37||LA64_1==41||LA64_1==48||(LA64_1>=55 && LA64_1<=56)) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4952:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4952:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4953:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm10995); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4975:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4976:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4977:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedIntRule()); 
            }
            pushFollow(FOLLOW_ruleSignedInt_in_entryRuleSignedInt11033);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInt11044); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4984:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4987:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4988:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4988:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4988:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4988:2: (kw= '+' | kw= '-' )?
            int alt65=3;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==53) ) {
                alt65=1;
            }
            else if ( (LA65_0==54) ) {
                alt65=2;
            }
            switch (alt65) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4989:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleSignedInt11083); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4996:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleSignedInt11102); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInt11119); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getSignedIntAccess().getINTTerminalRuleCall_1()); 
                  
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5016:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5017:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5018:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTermRule()); 
            }
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm11164);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm11174); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5025:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5028:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5029:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5029:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5029:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5029:2: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5030:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5030:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5031:3: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSignedReal_in_ruleRealTerm11220);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5047:2: ( (otherlv_1= RULE_ID ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==EOF||LA66_1==RULE_ID||(LA66_1>=15 && LA66_1<=16)||(LA66_1>=24 && LA66_1<=26)||LA66_1==37||LA66_1==41||LA66_1==48||(LA66_1>=55 && LA66_1<=56)) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5048:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5048:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5049:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm11244); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5071:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5072:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5073:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRealRule()); 
            }
            pushFollow(FOLLOW_ruleSignedReal_in_entryRuleSignedReal11282);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedReal11293); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5080:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_REAL_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5083:28: ( ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5084:1: ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5084:1: ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5084:2: (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5084:2: (kw= '+' | kw= '-' )?
            int alt67=3;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==53) ) {
                alt67=1;
            }
            else if ( (LA67_0==54) ) {
                alt67=2;
            }
            switch (alt67) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5085:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleSignedReal11332); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5092:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleSignedReal11351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSignedRealAccess().getREALParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleREAL_in_ruleSignedReal11375);
            this_REAL_2=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5116:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5117:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5118:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            }
            pushFollow(FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm11420);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericRangeTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericRangeTerm11430); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5125:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_1 = null;

        EObject lv_minimum_0_2 = null;

        EObject lv_minimum_0_3 = null;

        EObject lv_minimum_0_4 = null;

        EObject lv_maximum_2_1 = null;

        EObject lv_maximum_2_2 = null;

        EObject lv_maximum_2_3 = null;

        EObject lv_maximum_2_4 = null;

        EObject lv_delta_4_1 = null;

        EObject lv_delta_4_2 = null;

        EObject lv_delta_4_3 = null;

        EObject lv_delta_4_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5128:28: ( ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5129:1: ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5129:1: ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5129:2: ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5129:2: ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5130:1: ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5130:1: ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5131:1: (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5131:1: (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==RULE_INT) ) {
                    int LA68_3 = input.LA(3);

                    if ( (LA68_3==RULE_ID||LA68_3==55) ) {
                        alt68=2;
                    }
                    else if ( (LA68_3==45) ) {
                        alt68=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA68_1==RULE_ID) ) {
                    alt68=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA68_2 = input.LA(2);

                if ( (LA68_2==RULE_ID) ) {
                    alt68=3;
                }
                else if ( (LA68_2==RULE_INT) ) {
                    int LA68_3 = input.LA(3);

                    if ( (LA68_3==RULE_ID||LA68_3==55) ) {
                        alt68=2;
                    }
                    else if ( (LA68_3==45) ) {
                        alt68=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 68, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA68_3 = input.LA(2);

                if ( (LA68_3==RULE_ID||LA68_3==55) ) {
                    alt68=2;
                }
                else if ( (LA68_3==45) ) {
                    alt68=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt68=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5132:3: lv_minimum_0_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumRealTermParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11478);
                    lv_minimum_0_1=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"minimum",
                              		lv_minimum_0_1, 
                              		"RealTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5147:8: lv_minimum_0_2= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumIntegerTermParserRuleCall_0_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11497);
                    lv_minimum_0_2=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"minimum",
                              		lv_minimum_0_2, 
                              		"IntegerTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5162:8: lv_minimum_0_3= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumSignedConstantParserRuleCall_0_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11516);
                    lv_minimum_0_3=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"minimum",
                              		lv_minimum_0_3, 
                              		"SignedConstant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5177:8: lv_minimum_0_4= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumConstantValueParserRuleCall_0_0_3()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11535);
                    lv_minimum_0_4=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"minimum",
                              		lv_minimum_0_4, 
                              		"ConstantValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleNumericRangeTerm11550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5199:1: ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5200:1: ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5200:1: ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5201:1: (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5201:1: (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue )
            int alt69=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==RULE_INT) ) {
                    int LA69_3 = input.LA(3);

                    if ( (LA69_3==EOF||LA69_3==RULE_ID||(LA69_3>=15 && LA69_3<=16)||LA69_3==37||LA69_3==41||LA69_3==48||LA69_3==56) ) {
                        alt69=2;
                    }
                    else if ( (LA69_3==45) ) {
                        alt69=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA69_1==RULE_ID) ) {
                    alt69=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA69_2 = input.LA(2);

                if ( (LA69_2==RULE_INT) ) {
                    int LA69_3 = input.LA(3);

                    if ( (LA69_3==EOF||LA69_3==RULE_ID||(LA69_3>=15 && LA69_3<=16)||LA69_3==37||LA69_3==41||LA69_3==48||LA69_3==56) ) {
                        alt69=2;
                    }
                    else if ( (LA69_3==45) ) {
                        alt69=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA69_2==RULE_ID) ) {
                    alt69=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA69_3 = input.LA(2);

                if ( (LA69_3==EOF||LA69_3==RULE_ID||(LA69_3>=15 && LA69_3<=16)||LA69_3==37||LA69_3==41||LA69_3==48||LA69_3==56) ) {
                    alt69=2;
                }
                else if ( (LA69_3==45) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt69=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5202:3: lv_maximum_2_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumRealTermParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11573);
                    lv_maximum_2_1=ruleRealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"maximum",
                              		lv_maximum_2_1, 
                              		"RealTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5217:8: lv_maximum_2_2= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumIntegerTermParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11592);
                    lv_maximum_2_2=ruleIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"maximum",
                              		lv_maximum_2_2, 
                              		"IntegerTerm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5232:8: lv_maximum_2_3= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumSignedConstantParserRuleCall_2_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11611);
                    lv_maximum_2_3=ruleSignedConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"maximum",
                              		lv_maximum_2_3, 
                              		"SignedConstant");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5247:8: lv_maximum_2_4= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumConstantValueParserRuleCall_2_0_3()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11630);
                    lv_maximum_2_4=ruleConstantValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                      	        }
                             		set(
                             			current, 
                             			"maximum",
                              		lv_maximum_2_4, 
                              		"ConstantValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5265:2: (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==56) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5265:4: otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) )
                    {
                    otherlv_3=(Token)match(input,56,FOLLOW_56_in_ruleNumericRangeTerm11646); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5269:1: ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5270:1: ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5270:1: ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5271:1: (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5271:1: (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue )
                    int alt70=4;
                    switch ( input.LA(1) ) {
                    case 53:
                        {
                        int LA70_1 = input.LA(2);

                        if ( (LA70_1==RULE_ID) ) {
                            alt70=3;
                        }
                        else if ( (LA70_1==RULE_INT) ) {
                            int LA70_3 = input.LA(3);

                            if ( (LA70_3==EOF||LA70_3==RULE_ID||(LA70_3>=15 && LA70_3<=16)||LA70_3==37||LA70_3==41||LA70_3==48) ) {
                                alt70=2;
                            }
                            else if ( (LA70_3==45) ) {
                                alt70=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 70, 3, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 70, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 54:
                        {
                        int LA70_2 = input.LA(2);

                        if ( (LA70_2==RULE_INT) ) {
                            int LA70_3 = input.LA(3);

                            if ( (LA70_3==EOF||LA70_3==RULE_ID||(LA70_3>=15 && LA70_3<=16)||LA70_3==37||LA70_3==41||LA70_3==48) ) {
                                alt70=2;
                            }
                            else if ( (LA70_3==45) ) {
                                alt70=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 70, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA70_2==RULE_ID) ) {
                            alt70=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 70, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_INT:
                        {
                        int LA70_3 = input.LA(2);

                        if ( (LA70_3==EOF||LA70_3==RULE_ID||(LA70_3>=15 && LA70_3<=16)||LA70_3==37||LA70_3==41||LA70_3==48) ) {
                            alt70=2;
                        }
                        else if ( (LA70_3==45) ) {
                            alt70=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 70, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                        {
                        alt70=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        throw nvae;
                    }

                    switch (alt70) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5272:3: lv_delta_4_1= ruleRealTerm
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaRealTermParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11669);
                            lv_delta_4_1=ruleRealTerm();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"delta",
                                      		lv_delta_4_1, 
                                      		"RealTerm");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5287:8: lv_delta_4_2= ruleIntegerTerm
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaIntegerTermParserRuleCall_3_1_0_1()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11688);
                            lv_delta_4_2=ruleIntegerTerm();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"delta",
                                      		lv_delta_4_2, 
                                      		"IntegerTerm");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5302:8: lv_delta_4_3= ruleSignedConstant
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaSignedConstantParserRuleCall_3_1_0_2()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11707);
                            lv_delta_4_3=ruleSignedConstant();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"delta",
                                      		lv_delta_4_3, 
                                      		"SignedConstant");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5317:8: lv_delta_4_4= ruleConstantValue
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaConstantValueParserRuleCall_3_1_0_3()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11726);
                            lv_delta_4_4=ruleConstantValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"delta",
                                      		lv_delta_4_4, 
                                      		"ConstantValue");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;

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


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5343:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5344:2: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5345:2: iv_ruleREAL= ruleREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getREALRule()); 
            }
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL11768);
            iv_ruleREAL=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL11779); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5352:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5355:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5356:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5356:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5356:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL11819); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,45,FOLLOW_45_in_ruleREAL11837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL11852); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
                  
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
    // $ANTLR end "ruleREAL"


    // $ANTLR start "entryRulegINT"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5384:1: entryRulegINT returns [String current=null] : iv_rulegINT= rulegINT EOF ;
    public final String entryRulegINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulegINT = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5385:2: (iv_rulegINT= rulegINT EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5386:2: iv_rulegINT= rulegINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGINTRule()); 
            }
            pushFollow(FOLLOW_rulegINT_in_entryRulegINT11898);
            iv_rulegINT=rulegINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegINT11909); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulegINT"


    // $ANTLR start "rulegINT"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5393:1: rulegINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken rulegINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5396:28: (this_INT_0= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5397:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulegINT11948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getGINTAccess().getINTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulegINT"


    // $ANTLR start "entryRulegREAL"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5412:1: entryRulegREAL returns [String current=null] : iv_rulegREAL= rulegREAL EOF ;
    public final String entryRulegREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulegREAL = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5413:2: (iv_rulegREAL= rulegREAL EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5414:2: iv_rulegREAL= rulegREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGREALRule()); 
            }
            pushFollow(FOLLOW_rulegREAL_in_entryRulegREAL11993);
            iv_rulegREAL=rulegREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegREAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegREAL12004); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulegREAL"


    // $ANTLR start "rulegREAL"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5421:1: rulegREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_0= ruleREAL ;
    public final AntlrDatatypeRuleToken rulegREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_REAL_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5424:28: (this_REAL_0= ruleREAL )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5426:5: this_REAL_0= ruleREAL
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGREALAccess().getREALParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleREAL_in_rulegREAL12050);
            this_REAL_0=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_0);
                  
            }
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "rulegREAL"


    // $ANTLR start "entryRuleINAME"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5448:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5449:2: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5450:2: iv_ruleINAME= ruleINAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINAMERule()); 
            }
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME12099);
            iv_ruleINAME=ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME12110); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5457:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5460:28: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5461:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME12149); if (state.failed) return current;
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


    // $ANTLR start "entryRuleQPREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5476:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5477:2: (iv_ruleQPREF= ruleQPREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5478:2: iv_ruleQPREF= ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FOLLOW_ruleQPREF_in_entryRuleQPREF12194);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQPREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQPREF12205); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5485:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5488:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5489:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5489:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5489:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF12245); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5496:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==57) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5497:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleQPREF12264); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF12279); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5517:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5518:2: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5519:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF12327);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF12338); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5526:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5529:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5530:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5530:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5530:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5530:2: (this_ID_0= RULE_ID kw= '::' )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID) ) {
                    int LA73_1 = input.LA(2);

                    if ( (LA73_1==57) ) {
                        alt73=1;
                    }


                }


                switch (alt73) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5530:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF12379); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleQCREF12397); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF12414); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5550:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==45) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5551:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleQCREF12433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF12448); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEQCREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5571:1: entryRuleEQCREF returns [String current=null] : iv_ruleEQCREF= ruleEQCREF EOF ;
    public final String entryRuleEQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5572:2: (iv_ruleEQCREF= ruleEQCREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5573:2: iv_ruleEQCREF= ruleEQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleEQCREF_in_entryRuleEQCREF12496);
            iv_ruleEQCREF=ruleEQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEQCREF12507); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEQCREF"


    // $ANTLR start "ruleEQCREF"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5580:1: ruleEQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleEQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5583:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5584:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5584:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5584:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5584:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_ID) ) {
                    int LA75_1 = input.LA(2);

                    if ( (LA75_1==57) ) {
                        alt75=1;
                    }


                }


                switch (alt75) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5584:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEQCREF12548); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getEQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleEQCREF12566); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getEQCREFAccess().getColonColonKeyword_0_1()); 
            	          
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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEQCREF12583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getEQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5604:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==45) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5605:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleEQCREF12602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEQCREF12617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_4, grammarAccess.getEQCREFAccess().getIDTerminalRuleCall_2_1()); 
                          
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
    // $ANTLR end "ruleEQCREF"


    // $ANTLR start "entryRuleSTAR"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5625:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5626:2: (iv_ruleSTAR= ruleSTAR EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5627:2: iv_ruleSTAR= ruleSTAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTARRule()); 
            }
            pushFollow(FOLLOW_ruleSTAR_in_entryRuleSTAR12665);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTAR12676); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5634:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5637:28: (kw= '*' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5639:2: kw= '*'
            {
            kw=(Token)match(input,58,FOLLOW_58_in_ruleSTAR12713); if (state.failed) return current;
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

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA4_eotS =
        "\16\uffff";
    static final String DFA4_eofS =
        "\16\uffff";
    static final String DFA4_minS =
        "\1\4\1\22\1\23\1\24\12\uffff";
    static final String DFA4_maxS =
        "\1\4\1\22\1\23\1\43\12\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\6\1\7\1\5\1\1\1\11\1\12\1\4\1\10\1\3\1\2";
    static final String DFA4_specialS =
        "\16\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\7\1\15\1\14\2\uffff\1\12\1\uffff\1\6\1\4\1\5\1\uffff\1"+
            "\13\2\uffff\1\10\1\11",
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

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "251:2: (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType )";
        }
    }
    static final String DFA47_eotS =
        "\27\uffff";
    static final String DFA47_eofS =
        "\4\uffff\1\20\1\12\11\uffff\1\20\3\uffff\1\26\1\12\1\26\1\uffff";
    static final String DFA47_minS =
        "\5\4\1\17\6\uffff\1\30\1\uffff\1\6\1\17\1\uffff\1\4\1\uffff\1\4"+
        "\2\17\1\uffff";
    static final String DFA47_maxS =
        "\1\66\1\64\2\6\1\67\1\71\6\uffff\1\71\1\uffff\1\6\1\67\1\uffff"+
        "\1\4\1\uffff\3\67\1\uffff";
    static final String DFA47_acceptS =
        "\6\uffff\1\3\1\4\1\5\1\10\1\11\1\12\1\uffff\1\2\2\uffff\1\7\1\uffff"+
        "\1\1\3\uffff\1\6";
    static final String DFA47_specialS =
        "\27\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\5\1\10\1\4\20\uffff\1\1\7\uffff\1\11\2\uffff\1\6\10\uffff"+
            "\2\12\1\uffff\1\7\1\13\4\uffff\1\12\1\2\1\3",
            "\1\14\22\uffff\1\12\23\uffff\2\12\7\uffff\1\12",
            "\1\15\1\uffff\1\4",
            "\1\15\1\uffff\1\4",
            "\1\17\12\uffff\2\20\24\uffff\1\20\3\uffff\1\20\3\uffff\1\16"+
            "\2\uffff\1\20\6\uffff\1\15",
            "\2\12\24\uffff\1\12\3\uffff\1\12\6\uffff\1\12\1\uffff\2\12"+
            "\3\uffff\1\15\1\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\1\uffff\1\22\27\uffff\2\12\5\uffff\1\12",
            "",
            "\1\23",
            "\2\20\24\uffff\1\20\3\uffff\1\20\6\uffff\1\20\6\uffff\1\15",
            "",
            "\1\24",
            "",
            "\1\25\12\uffff\2\26\24\uffff\1\26\3\uffff\1\26\6\uffff\1\26"+
            "\6\uffff\1\15",
            "\2\12\24\uffff\1\12\3\uffff\1\12\6\uffff\1\12\1\uffff\2\12"+
            "\3\uffff\1\15",
            "\2\26\24\uffff\1\26\3\uffff\1\26\6\uffff\1\26\6\uffff\1\15",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "3144:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm )";
        }
    }
    static final String DFA48_eotS =
        "\26\uffff";
    static final String DFA48_eofS =
        "\4\uffff\1\17\1\11\10\uffff\1\17\3\uffff\1\25\1\11\1\25\1\uffff";
    static final String DFA48_minS =
        "\5\4\1\20\5\uffff\1\30\1\uffff\1\6\1\20\1\uffff\1\4\1\uffff\1\4"+
        "\2\20\1\uffff";
    static final String DFA48_maxS =
        "\1\66\1\64\2\6\1\67\1\71\5\uffff\1\71\1\uffff\1\6\1\67\1\uffff"+
        "\1\4\1\uffff\3\67\1\uffff";
    static final String DFA48_acceptS =
        "\6\uffff\1\3\1\4\1\7\1\10\1\11\1\uffff\1\2\2\uffff\1\6\1\uffff"+
        "\1\1\3\uffff\1\5";
    static final String DFA48_specialS =
        "\26\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\5\1\7\1\4\20\uffff\1\1\7\uffff\1\10\13\uffff\2\11\1\uffff"+
            "\1\6\1\12\4\uffff\1\11\1\2\1\3",
            "\1\13\22\uffff\1\11\23\uffff\2\11\7\uffff\1\11",
            "\1\14\1\uffff\1\4",
            "\1\14\1\uffff\1\4",
            "\1\16\13\uffff\1\17\34\uffff\1\15\11\uffff\1\14",
            "\1\11\41\uffff\2\11\3\uffff\1\14\1\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\1\21\27\uffff\2\11\5\uffff\1\11",
            "",
            "\1\22",
            "\1\17\46\uffff\1\14",
            "",
            "\1\23",
            "",
            "\1\24\13\uffff\1\25\46\uffff\1\14",
            "\1\11\41\uffff\2\11\3\uffff\1\14",
            "\1\25\46\uffff\1\14",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "3294:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm )";
        }
    }
 

    public static final BitSet FOLLOW_rulePropertySet_in_entryRulePropertySet81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertySet91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rulePropertySet128 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_rulePropertySet140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet157 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePropertySet174 = new BitSet(new long[]{0x0000000000024010L});
    public static final BitSet FOLLOW_14_in_rulePropertySet195 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet220 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_rulePropertySet233 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet257 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_rulePropertySet271 = new BitSet(new long[]{0x0000000000024010L});
    public static final BitSet FOLLOW_rulePropertyType_in_rulePropertySet295 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_rulePropertyDefinition_in_rulePropertySet322 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_rulePropertyConstant_in_rulePropertySet349 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_rulePropertySet363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet374 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePropertySet385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyType_in_entryRulePropertyType421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyType431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanType_in_rulePropertyType482 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleStringType_in_rulePropertyType512 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleEnumerationType_in_rulePropertyType542 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleUnitsType_in_rulePropertyType572 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleRealType_in_rulePropertyType602 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleIntegerType_in_rulePropertyType632 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleRangeType_in_rulePropertyType662 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleClassifierType_in_rulePropertyType692 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleReferenceType_in_rulePropertyType722 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleRecordType_in_rulePropertyType752 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePropertyType764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_entryRuleUnnamedPropertyType800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedPropertyType810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedBooleanType_in_ruleUnnamedPropertyType860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedStringType_in_ruleUnnamedPropertyType890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedEnumerationType_in_ruleUnnamedPropertyType920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedPropertyType950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRealType_in_ruleUnnamedPropertyType980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedPropertyType1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRangeType_in_ruleUnnamedPropertyType1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedClassifierType_in_ruleUnnamedPropertyType1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedReferenceType_in_ruleUnnamedPropertyType1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRecordType_in_ruleUnnamedPropertyType1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanType_in_entryRuleBooleanType1165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanType1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanType1217 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleBooleanType1234 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleBooleanType1246 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleBooleanType1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedBooleanType_in_entryRuleUnnamedBooleanType1294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedBooleanType1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleUnnamedBooleanType1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringType_in_entryRuleStringType1389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringType1399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringType1441 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStringType1458 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleStringType1470 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleStringType1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedStringType_in_entryRuleUnnamedStringType1518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedStringType1528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleUnnamedStringType1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationType_in_entryRuleEnumerationType1613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationType1623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationType1665 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEnumerationType1682 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleEnumerationType1694 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEnumerationType1706 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleEnumerationType1718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1739 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationType1752 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1773 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_24_in_ruleEnumerationType1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedEnumerationType_in_entryRuleUnnamedEnumerationType1823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedEnumerationType1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleUnnamedEnumerationType1870 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleUnnamedEnumerationType1882 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1903 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_ruleUnnamedEnumerationType1916 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1937 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_24_in_ruleUnnamedEnumerationType1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteral_in_entryRuleEnumerationLiteral1987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteral1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationLiteral2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitsType_in_entryRuleUnitsType2078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitsType2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitsType2130 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleUnitsType2147 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleUnitsType2159 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleUnitsType2171 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleUnitsType2183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitLiteral_in_ruleUnitsType2204 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_ruleUnitsType2217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitLiteralConversion_in_ruleUnitsType2238 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_24_in_ruleUnitsType2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_entryRuleUnnamedUnitsType2288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedUnitsType2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleUnnamedUnitsType2335 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleUnnamedUnitsType2347 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitLiteral_in_ruleUnnamedUnitsType2368 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_ruleUnnamedUnitsType2381 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitLiteralConversion_in_ruleUnnamedUnitsType2402 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_24_in_ruleUnnamedUnitsType2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitLiteral_in_entryRuleUnitLiteral2452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitLiteral2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitLiteral2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitLiteralConversion_in_entryRuleUnitLiteralConversion2543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitLiteralConversion2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2595 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUnitLiteralConversion2612 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2636 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleUnitLiteralConversion2655 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleNumberValue_in_ruleUnitLiteralConversion2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealType_in_entryRuleRealType2711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealType2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealType2763 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRealType2780 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRealType2792 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleRealType2804 = new BitSet(new long[]{0x0060000002000052L});
    public static final BitSet FOLLOW_ruleRealRange_in_ruleRealType2825 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleRealType2839 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitsType_in_ruleRealType2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealType2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRealType_in_entryRuleUnnamedRealType2930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedRealType2940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleUnnamedRealType2989 = new BitSet(new long[]{0x0060000002000052L});
    public static final BitSet FOLLOW_ruleRealRange_in_ruleUnnamedRealType3010 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleUnnamedRealType3024 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitsType_in_ruleUnnamedRealType3046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnnamedRealType3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerType_in_entryRuleIntegerType3115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerType3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerType3167 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIntegerType3184 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIntegerType3196 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleIntegerType3208 = new BitSet(new long[]{0x0060000002000052L});
    public static final BitSet FOLLOW_ruleIntegerRange_in_ruleIntegerType3229 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleIntegerType3243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitsType_in_ruleIntegerType3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerType3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_entryRuleUnnamedIntegerType3334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedIntegerType3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleUnnamedIntegerType3393 = new BitSet(new long[]{0x0060000002000052L});
    public static final BitSet FOLLOW_ruleIntegerRange_in_ruleUnnamedIntegerType3414 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleUnnamedIntegerType3428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnitsType_in_ruleUnnamedIntegerType3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnnamedIntegerType3480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeType_in_entryRuleRangeType3519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeType3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeType3571 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRangeType3588 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRangeType3600 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleRangeType3612 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleRangeType3624 = new BitSet(new long[]{0x0060000018000050L});
    public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_ruleRangeType3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRealType_in_ruleRangeType3667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleRangeType3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRangeType_in_entryRuleUnnamedRangeType3740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedRangeType3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleUnnamedRangeType3799 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleUnnamedRangeType3811 = new BitSet(new long[]{0x0060000018000050L});
    public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedRangeType3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRealType_in_ruleUnnamedRangeType3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleUnnamedRangeType3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifierType_in_entryRuleClassifierType3927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassifierType3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassifierType3979 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleClassifierType3996 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleClassifierType4008 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleClassifierType4020 = new BitSet(new long[]{0x0000000100000012L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleClassifierType4042 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleClassifierType4055 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleClassifierType4076 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleUnnamedClassifierType_in_entryRuleUnnamedClassifierType4116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedClassifierType4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnnamedClassifierType4175 = new BitSet(new long[]{0x0000000100000012L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleUnnamedClassifierType4197 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleUnnamedClassifierType4210 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleUnnamedClassifierType4231 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleQCReference_in_entryRuleQCReference4271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCReference4281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleQCReference4319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCReference4336 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleQCReference4353 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleQCReference4372 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleQCReference4390 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCReference4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType4449 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType4459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType4501 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReferenceType4518 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReferenceType4530 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleReferenceType4542 = new BitSet(new long[]{0x0000000100000012L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleReferenceType4564 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleReferenceType4577 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleReferenceType4598 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleUnnamedReferenceType_in_entryRuleUnnamedReferenceType4638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedReferenceType4648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleUnnamedReferenceType4685 = new BitSet(new long[]{0x0000000100000012L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleUnnamedReferenceType4719 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleUnnamedReferenceType4732 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_ruleQCReference_in_ruleUnnamedReferenceType4753 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleRecordType_in_entryRuleRecordType4793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordType4803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordType4845 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRecordType4862 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRecordType4874 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleRecordType4886 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleRecordType4898 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRecordField_in_ruleRecordType4919 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_ruleRecordType4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedRecordType_in_entryRuleUnnamedRecordType4968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedRecordType4978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnnamedRecordType5015 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleUnnamedRecordType5027 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRecordField_in_ruleUnnamedRecordType5048 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_ruleUnnamedRecordType5061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordField_in_entryRuleRecordField5097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordField5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordField5149 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRecordField5166 = new BitSet(new long[]{0x0060000CBA700050L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleRecordField5194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_ruleRecordField5221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition5258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyDefinition5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyDefinition5310 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePropertyDefinition5327 = new BitSet(new long[]{0x0060001CBA700050L});
    public static final BitSet FOLLOW_36_in_rulePropertyDefinition5345 = new BitSet(new long[]{0x0060000CBA700050L});
    public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyDefinition5387 = new BitSet(new long[]{0x0000002004000000L});
    public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_rulePropertyDefinition5414 = new BitSet(new long[]{0x0000002004000000L});
    public static final BitSet FOLLOW_26_in_rulePropertyDefinition5428 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyDefinition5449 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_rulePropertyDefinition5463 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_rulePropertyDefinition5475 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulePropertyDefinition5487 = new BitSet(new long[]{0x0000008100000010L});
    public static final BitSet FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5510 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_rulePropertyDefinition5523 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5544 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_ruleAllReference_in_rulePropertyDefinition5574 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_rulePropertyDefinition5587 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePropertyDefinition5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAllReference_in_entryRuleAllReference5635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAllReference5645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleAllReference5687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyOwner_in_entryRulePropertyOwner5735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyOwner5745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifierValue_in_rulePropertyOwner5795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCReference_in_rulePropertyOwner5825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifierValue_in_entryRuleClassifierValue5860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassifierValue5870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEQCREF_in_ruleClassifierValue5921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyConstant_in_entryRulePropertyConstant5956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyConstant5966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyConstant6008 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePropertyConstant6025 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_rulePropertyConstant6037 = new BitSet(new long[]{0x0060000CBA700050L});
    public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyConstant6065 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_rulePropertyConstant6092 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulePropertyConstant6105 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_ruleConstantPropertyExpression_in_rulePropertyConstant6126 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePropertyConstant6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberValue_in_entryRuleNumberValue6174 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberValue6184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLit_in_ruleNumberValue6234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLit_in_ruleNumberValue6264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLit_in_entryRuleRealLit6299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLit6309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegREAL_in_ruleRealLit6354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLit_in_entryRuleIntegerLit6389 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLit6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegINT_in_ruleIntegerLit6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModalPropertyValue_in_entryRuleModalPropertyValue6481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModalPropertyValue6491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleModalPropertyValue6537 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleModalPropertyValue6549 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleModalPropertyValue6561 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleModalPropertyValue6573 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModalPropertyValue6597 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_ruleModalPropertyValue6610 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModalPropertyValue6634 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_24_in_ruleModalPropertyValue6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValue_in_entryRulePropertyValue6684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValue6694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyValue6739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression6774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression6784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_rulePropertyExpression6834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression6864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_rulePropertyExpression6894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_rulePropertyExpression6924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_rulePropertyExpression6954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_rulePropertyExpression6984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_rulePropertyExpression7014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression7044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_rulePropertyExpression7074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_rulePropertyExpression7104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantPropertyExpression_in_entryRuleConstantPropertyExpression7139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantPropertyExpression7149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_ruleConstantPropertyExpression7199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_ruleConstantPropertyExpression7229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_ruleConstantPropertyExpression7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleConstantPropertyExpression7289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleConstantPropertyExpression7319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleConstantPropertyExpression7349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_ruleConstantPropertyExpression7379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_ruleConstantPropertyExpression7409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_ruleConstantPropertyExpression7439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_entryRuleBooleanTerm7474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTerm7484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrTerm_in_ruleBooleanTerm7533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrTerm_in_entryRuleOrTerm7567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrTerm7577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndTerm_in_ruleOrTerm7627 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleOrOp_in_ruleOrTerm7660 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleAndTerm_in_ruleOrTerm7681 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleAndTerm_in_entryRuleAndTerm7719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndTerm7729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleAndTerm7779 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleAndOp_in_ruleAndTerm7812 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleAndTerm7833 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleNotTerm_in_entryRuleNotTerm7871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotTerm7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOp_in_ruleNotTerm7927 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleNotTerm7948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_entryRuleBooleanAtom7984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAtom7994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleBooleanAtom8044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotTerm_in_ruleBooleanAtom8074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleBooleanAtom8104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBooleanAtom8122 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_ruleBooleanAtom8147 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBooleanAtom8158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBooleanLiteral8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleBooleanLiteral8292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue8329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue8339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleConstantValue8390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceTerm8435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleReferenceTerm8472 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleReferenceTerm8484 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8505 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_45_in_ruleReferenceTerm8518 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8539 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_24_in_ruleReferenceTerm8553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8589 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordTerm8599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleRecordTerm8636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleBasicPropertyAssociation_in_ruleRecordTerm8657 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_ruleRecordTerm8670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComputedTerm8716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComputedTerm8753 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleComputedTerm8765 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComputedTerm8782 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComputedTerm8799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentClassifierTerm8845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleComponentClassifierTerm8882 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleComponentClassifierTerm8894 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm8921 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComponentClassifierTerm8933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_entryRuleListTerm8969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListTerm8979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleListTerm9016 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm9037 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_15_in_ruleListTerm9050 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm9071 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_48_in_ruleListTerm9085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicPropertyAssociation_in_entryRuleBasicPropertyAssociation9121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicPropertyAssociation9131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBasicPropertyAssociation9180 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleBasicPropertyAssociation9192 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleBasicPropertyAssociation9213 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleBasicPropertyAssociation9225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement9261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement9271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentPathElement9321 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement9342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleContainmentPathElement9363 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement9390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF9428 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANNEXREF9439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleANNEXREF9477 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9499 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleANNEXREF9546 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9573 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9600 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleANNEXREF9618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOp_in_entryRuleAndOp9659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOp9670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAndOp9707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOp_in_entryRuleOrOp9747 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrOp9758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOrOp9795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOp_in_entryRuleNotOp9835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOp9846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleNotOp9883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus9923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus9934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rulePlusMinus9972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rulePlusMinus9991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm10031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm10041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm10086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString10122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString10133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString10172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange10216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange10226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleArrayRange10275 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rulegINT_in_ruleArrayRange10296 = new BitSet(new long[]{0x0081000000000000L});
    public static final BitSet FOLLOW_55_in_ruleArrayRange10309 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rulegINT_in_ruleArrayRange10330 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleArrayRange10344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerRange_in_entryRuleIntegerRange10380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerRange10390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10438 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleIntegerRange10457 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleIntegerRange10476 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleIntegerRange10491 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleIntegerRange10533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleIntegerRange10552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealRange_in_entryRuleRealRange10591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealRange10601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleRealRange10649 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleRealRange10668 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleRealRange10687 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleRealRange10702 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleRealRange10725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleRealRange10744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleRealRange10763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant10802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedConstant10812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_ruleSignedConstant10858 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleSignedConstant10879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm10915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm10925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerTerm10971 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm10995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_entryRuleSignedInt11033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInt11044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSignedInt11083 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_54_in_ruleSignedInt11102 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInt11119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm11164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealTerm11220 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm11244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_entryRuleSignedReal11282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedReal11293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSignedReal11332 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_54_in_ruleSignedReal11351 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleSignedReal11375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm11420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericRangeTerm11430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11478 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11497 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11516 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11535 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleNumericRangeTerm11550 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11573 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11592 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11611 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11630 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_56_in_ruleNumericRangeTerm11646 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL11768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL11779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL11819 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleREAL11837 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL11852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegINT_in_entryRulegINT11898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegINT11909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulegINT11948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegREAL_in_entryRulegREAL11993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegREAL12004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_rulegREAL12050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME12099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME12110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME12149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_entryRuleQPREF12194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQPREF12205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF12245 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQPREF12264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF12279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF12327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF12338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12379 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleQCREF12397 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12414 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleQCREF12433 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEQCREF_in_entryRuleEQCREF12496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEQCREF12507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEQCREF12548 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleEQCREF12566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEQCREF12583 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleEQCREF12602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEQCREF12617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTAR_in_entryRuleSTAR12665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTAR12676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSTAR12713 = new BitSet(new long[]{0x0000000000000002L});

}