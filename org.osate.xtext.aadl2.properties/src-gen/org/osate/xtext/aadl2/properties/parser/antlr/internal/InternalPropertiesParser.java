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
                        case 40:
                            {
                            alt3=3;
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

                        if ( (LA14_1==18) ) {
                            alt14=1;
                        }
                        else if ( (LA14_1==EOF||LA14_1==RULE_ID||LA14_1==16||LA14_1==24||LA14_1==26||LA14_1==37) ) {
                            alt14=2;
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

                        if ( (LA20_1==EOF||LA20_1==RULE_ID||LA20_1==16||LA20_1==24||LA20_1==26||LA20_1==37) ) {
                            alt20=2;
                        }
                        else if ( (LA20_1==18) ) {
                            alt20=1;
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

                if ( (LA45_1==45) ) {
                    alt45=1;
                }
                else if ( (LA45_1==EOF||LA45_1==15||LA45_1==24) ) {
                    alt45=2;
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


    // $ANTLR start "entryRuleContainmentPath"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3005:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3006:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3007:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathRule()); 
            }
            pushFollow(FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath6485);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPath; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPath6495); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3014:1: ruleContainmentPath returns [EObject current=null] : ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_containmentPathElement_1_0 = null;

        EObject lv_containmentPathElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3017:28: ( ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3018:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3018:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3018:2: () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3018:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3019:2: 
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3027:2: ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3028:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3028:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3029:3: lv_containmentPathElement_1_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath6553);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3045:2: (otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==15) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3045:4: otherlv_2= ',' ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleContainmentPath6566); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3049:1: ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3050:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3050:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3051:3: lv_containmentPathElement_3_0= ruleContainmentPathElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath6587);
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
            	    break loop46;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3075:1: entryRuleModalPropertyValue returns [EObject current=null] : iv_ruleModalPropertyValue= ruleModalPropertyValue EOF ;
    public final EObject entryRuleModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModalPropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3076:2: (iv_ruleModalPropertyValue= ruleModalPropertyValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3077:2: iv_ruleModalPropertyValue= ruleModalPropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModalPropertyValueRule()); 
            }
            pushFollow(FOLLOW_ruleModalPropertyValue_in_entryRuleModalPropertyValue6625);
            iv_ruleModalPropertyValue=ruleModalPropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModalPropertyValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModalPropertyValue6635); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3084:1: ruleModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3087:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3088:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3088:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3088:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3088:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3089:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3089:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3090:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleModalPropertyValue6681);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3106:2: (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==41) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3106:4: otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleModalPropertyValue6694); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getModalPropertyValueAccess().getInKeyword_1_0());
                          
                    }
                    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleModalPropertyValue6706); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getModalPropertyValueAccess().getModesKeyword_1_1());
                          
                    }
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleModalPropertyValue6718); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3118:1: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3119:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3119:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3120:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModalPropertyValueRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModalPropertyValue6742); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3134:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==15) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3134:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleModalPropertyValue6755); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3138:1: ( (otherlv_6= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3139:1: (otherlv_6= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3139:1: (otherlv_6= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3140:3: otherlv_6= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModalPropertyValueRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModalPropertyValue6779); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_6, grammarAccess.getModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleModalPropertyValue6793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getModalPropertyValueAccess().getRightParenthesisKeyword_1_5());
                          
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
    // $ANTLR end "ruleModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3166:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3167:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3168:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyValueRule()); 
            }
            pushFollow(FOLLOW_rulePropertyValue_in_entryRulePropertyValue6831);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValue6841); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3175:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3178:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3179:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3179:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3180:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3180:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3181:3: lv_ownedValue_0_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_rulePropertyValue6886);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3205:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3206:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3207:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression6921);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression6931); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3214:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3217:28: ( (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3218:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3218:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm )
            int alt49=10;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3219:2: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRecordTerm_in_rulePropertyExpression6981);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3232:2: this_NumericRangeTerm_1= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression7011);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3245:2: this_ReferenceTerm_2= ruleReferenceTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReferenceTerm_in_rulePropertyExpression7041);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3258:2: this_ComputedTerm_3= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComputedTerm_in_rulePropertyExpression7071);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3271:2: this_StringTerm_4= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_rulePropertyExpression7101);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3284:2: this_RealTerm_5= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_rulePropertyExpression7131);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3297:2: this_IntegerTerm_6= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_rulePropertyExpression7161);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3310:2: this_ComponentClassifierTerm_7= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression7191);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3323:2: this_BooleanTerm_8= ruleBooleanTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanTerm_in_rulePropertyExpression7221);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3336:2: this_ListTerm_9= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleListTerm_in_rulePropertyExpression7251);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3355:1: entryRuleConstantPropertyExpression returns [EObject current=null] : iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF ;
    public final EObject entryRuleConstantPropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantPropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3356:2: (iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3357:2: iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantPropertyExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConstantPropertyExpression_in_entryRuleConstantPropertyExpression7286);
            iv_ruleConstantPropertyExpression=ruleConstantPropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantPropertyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantPropertyExpression7296); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3364:1: ruleConstantPropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3367:28: ( (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3368:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3368:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm )
            int alt50=9;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3369:2: this_RecordTerm_0= ruleRecordTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRecordTerm_in_ruleConstantPropertyExpression7346);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3382:2: this_NumericRangeTerm_1= ruleNumericRangeTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getNumericRangeTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericRangeTerm_in_ruleConstantPropertyExpression7376);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3395:2: this_ComputedTerm_2= ruleComputedTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getComputedTermParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComputedTerm_in_ruleConstantPropertyExpression7406);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3408:2: this_StringTerm_3= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getStringTermParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleConstantPropertyExpression7436);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3421:2: this_RealTerm_4= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getRealTermParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleConstantPropertyExpression7466);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3434:2: this_IntegerTerm_5= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getIntegerTermParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleConstantPropertyExpression7496);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3447:2: this_ComponentClassifierTerm_6= ruleComponentClassifierTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleComponentClassifierTerm_in_ruleConstantPropertyExpression7526);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3460:2: this_BooleanTerm_7= ruleBooleanTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getBooleanTermParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanTerm_in_ruleConstantPropertyExpression7556);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3473:2: this_ListTerm_8= ruleListTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getListTermParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleListTerm_in_ruleConstantPropertyExpression7586);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3492:1: entryRuleBooleanTerm returns [EObject current=null] : iv_ruleBooleanTerm= ruleBooleanTerm EOF ;
    public final EObject entryRuleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3493:2: (iv_ruleBooleanTerm= ruleBooleanTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3494:2: iv_ruleBooleanTerm= ruleBooleanTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanTermRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanTerm_in_entryRuleBooleanTerm7621);
            iv_ruleBooleanTerm=ruleBooleanTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTerm7631); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3501:1: ruleBooleanTerm returns [EObject current=null] : this_OrTerm_0= ruleOrTerm ;
    public final EObject ruleBooleanTerm() throws RecognitionException {
        EObject current = null;

        EObject this_OrTerm_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3504:28: (this_OrTerm_0= ruleOrTerm )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3506:2: this_OrTerm_0= ruleOrTerm
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBooleanTermAccess().getOrTermParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleOrTerm_in_ruleBooleanTerm7680);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3525:1: entryRuleOrTerm returns [EObject current=null] : iv_ruleOrTerm= ruleOrTerm EOF ;
    public final EObject entryRuleOrTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3526:2: (iv_ruleOrTerm= ruleOrTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3527:2: iv_ruleOrTerm= ruleOrTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrTermRule()); 
            }
            pushFollow(FOLLOW_ruleOrTerm_in_entryRuleOrTerm7714);
            iv_ruleOrTerm=ruleOrTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrTerm7724); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3534:1: ruleOrTerm returns [EObject current=null] : (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* ) ;
    public final EObject ruleOrTerm() throws RecognitionException {
        EObject current = null;

        EObject this_AndTerm_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_ownedPropertyExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3537:28: ( (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3538:1: (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3538:1: (this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3539:2: this_AndTerm_0= ruleAndTerm ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrTermAccess().getAndTermParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndTerm_in_ruleOrTerm7774);
            this_AndTerm_0=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndTerm_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3550:1: ( () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==51) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3550:2: () ( (lv_op_2_0= ruleOrOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3550:2: ()
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3551:2: 
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3559:2: ( (lv_op_2_0= ruleOrOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3560:1: (lv_op_2_0= ruleOrOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3560:1: (lv_op_2_0= ruleOrOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3561:3: lv_op_2_0= ruleOrOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrTermAccess().getOpOrOpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleOrOp_in_ruleOrTerm7807);
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3577:2: ( (lv_ownedPropertyExpression_3_0= ruleAndTerm ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3578:1: (lv_ownedPropertyExpression_3_0= ruleAndTerm )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3578:1: (lv_ownedPropertyExpression_3_0= ruleAndTerm )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3579:3: lv_ownedPropertyExpression_3_0= ruleAndTerm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrTermAccess().getOwnedPropertyExpressionAndTermParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndTerm_in_ruleOrTerm7828);
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
            	    break loop51;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3603:1: entryRuleAndTerm returns [EObject current=null] : iv_ruleAndTerm= ruleAndTerm EOF ;
    public final EObject entryRuleAndTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3604:2: (iv_ruleAndTerm= ruleAndTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3605:2: iv_ruleAndTerm= ruleAndTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndTermRule()); 
            }
            pushFollow(FOLLOW_ruleAndTerm_in_entryRuleAndTerm7866);
            iv_ruleAndTerm=ruleAndTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndTerm7876); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3612:1: ruleAndTerm returns [EObject current=null] : (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* ) ;
    public final EObject ruleAndTerm() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanAtom_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_ownedPropertyExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3615:28: ( (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3616:1: (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3616:1: (this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )* )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3617:2: this_BooleanAtom_0= ruleBooleanAtom ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndTermAccess().getBooleanAtomParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBooleanAtom_in_ruleAndTerm7926);
            this_BooleanAtom_0=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BooleanAtom_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3628:1: ( () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==50) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3628:2: () ( (lv_op_2_0= ruleAndOp ) ) ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3628:2: ()
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3629:2: 
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3637:2: ( (lv_op_2_0= ruleAndOp ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3638:1: (lv_op_2_0= ruleAndOp )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3638:1: (lv_op_2_0= ruleAndOp )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3639:3: lv_op_2_0= ruleAndOp
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndTermAccess().getOpAndOpParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndOp_in_ruleAndTerm7959);
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

            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3655:2: ( (lv_ownedPropertyExpression_3_0= ruleBooleanAtom ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3656:1: (lv_ownedPropertyExpression_3_0= ruleBooleanAtom )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3656:1: (lv_ownedPropertyExpression_3_0= ruleBooleanAtom )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3657:3: lv_ownedPropertyExpression_3_0= ruleBooleanAtom
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleBooleanAtom_in_ruleAndTerm7980);
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
            	    break loop52;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3681:1: entryRuleNotTerm returns [EObject current=null] : iv_ruleNotTerm= ruleNotTerm EOF ;
    public final EObject entryRuleNotTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3682:2: (iv_ruleNotTerm= ruleNotTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3683:2: iv_ruleNotTerm= ruleNotTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotTermRule()); 
            }
            pushFollow(FOLLOW_ruleNotTerm_in_entryRuleNotTerm8018);
            iv_ruleNotTerm=ruleNotTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotTerm8028); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3690:1: ruleNotTerm returns [EObject current=null] : ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) ) ;
    public final EObject ruleNotTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3693:28: ( ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3694:1: ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3694:1: ( ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3694:2: ( (lv_op_0_0= ruleNotOp ) ) ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3694:2: ( (lv_op_0_0= ruleNotOp ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3695:1: (lv_op_0_0= ruleNotOp )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3695:1: (lv_op_0_0= ruleNotOp )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3696:3: lv_op_0_0= ruleNotOp
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotTermAccess().getOpNotOpParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNotOp_in_ruleNotTerm8074);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3712:2: ( (lv_ownedPropertyExpression_1_0= ruleBooleanAtom ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3713:1: (lv_ownedPropertyExpression_1_0= ruleBooleanAtom )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3713:1: (lv_ownedPropertyExpression_1_0= ruleBooleanAtom )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3714:3: lv_ownedPropertyExpression_1_0= ruleBooleanAtom
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNotTermAccess().getOwnedPropertyExpressionBooleanAtomParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBooleanAtom_in_ruleNotTerm8095);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3738:1: entryRuleBooleanAtom returns [EObject current=null] : iv_ruleBooleanAtom= ruleBooleanAtom EOF ;
    public final EObject entryRuleBooleanAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanAtom = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3739:2: (iv_ruleBooleanAtom= ruleBooleanAtom EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3740:2: iv_ruleBooleanAtom= ruleBooleanAtom EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanAtomRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanAtom_in_entryRuleBooleanAtom8131);
            iv_ruleBooleanAtom=ruleBooleanAtom();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanAtom; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanAtom8141); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3747:1: ruleBooleanAtom returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3750:28: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3751:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3751:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotTerm_1= ruleNotTerm | this_ConstantValue_2= ruleConstantValue | (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case 43:
            case 44:
                {
                alt53=1;
                }
                break;
            case 52:
                {
                alt53=2;
                }
                break;
            case RULE_ID:
                {
                alt53=3;
                }
                break;
            case 23:
                {
                alt53=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3752:2: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getBooleanLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleBooleanAtom8191);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3765:2: this_NotTerm_1= ruleNotTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getNotTermParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNotTerm_in_ruleBooleanAtom8221);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3778:2: this_ConstantValue_2= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getConstantValueParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleBooleanAtom8251);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3790:6: (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3790:6: (otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')' )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3790:8: otherlv_3= '(' this_BooleanTerm_4= ruleBooleanTerm otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleBooleanAtom8269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getBooleanAtomAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBooleanAtomAccess().getBooleanTermParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanTerm_in_ruleBooleanAtom8294);
                    this_BooleanTerm_4=ruleBooleanTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanTerm_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleBooleanAtom8305); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3818:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3819:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3820:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8342);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8352); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3827:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3830:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3831:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3831:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3831:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3831:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3832:2: 
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3840:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==43) ) {
                alt54=1;
            }
            else if ( (LA54_0==44) ) {
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3840:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3840:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3841:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3841:1: (lv_value_1_0= 'true' )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3842:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,43,FOLLOW_43_in_ruleBooleanLiteral8408); if (state.failed) return current;
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3856:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleBooleanLiteral8439); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3868:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3869:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3870:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantValueRule()); 
            }
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue8476);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstantValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue8486); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3877:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3880:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3881:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3881:1: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3882:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3882:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3883:3: ruleQPREF
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
            pushFollow(FOLLOW_ruleQPREF_in_ruleConstantValue8537);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3907:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3908:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3909:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTermRule()); 
            }
            pushFollow(FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8572);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceTerm8582); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3916:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3919:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3920:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3920:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3920:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleReferenceTerm8619); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleReferenceTerm8631); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3928:1: ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3929:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3929:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3930:3: lv_containmentPathElement_2_0= ruleContainmentPathElement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8652);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3946:2: (otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==45) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3946:4: otherlv_3= '.' ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_3=(Token)match(input,45,FOLLOW_45_in_ruleReferenceTerm8665); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getFullStopKeyword_3_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3950:1: ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3951:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3951:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3952:3: lv_containmentPathElement_4_0= ruleContainmentPathElement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8686);
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
            	    break loop55;
                }
            } while (true);

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleReferenceTerm8700); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3980:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3981:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3982:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRecordTermRule()); 
            }
            pushFollow(FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8736);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRecordTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordTerm8746); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3989:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ')' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3992:28: ( (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3993:1: (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3993:1: (otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3993:3: otherlv_0= '(' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleRecordTerm8783); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3997:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ID) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3998:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3998:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:3999:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm8804);
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
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleRecordTerm8817); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4027:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4028:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4029:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComputedTermRule()); 
            }
            pushFollow(FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8853);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComputedTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComputedTerm8863); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4036:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4039:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4040:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4040:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4040:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleComputedTerm8900); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleComputedTerm8912); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4048:1: ( (lv_function_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4049:1: (lv_function_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4049:1: (lv_function_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4050:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComputedTerm8929); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComputedTerm8946); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4078:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4079:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4080:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            }
            pushFollow(FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8982);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentClassifierTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentClassifierTerm8992); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4087:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4090:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4091:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4091:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4091:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleComponentClassifierTerm9029); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleComponentClassifierTerm9041); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4099:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4100:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4100:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4101:3: ruleQCREF
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
            pushFollow(FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm9068);
            ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComponentClassifierTerm9080); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4129:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4130:2: (iv_ruleListTerm= ruleListTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4131:2: iv_ruleListTerm= ruleListTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTermRule()); 
            }
            pushFollow(FOLLOW_ruleListTerm_in_entryRuleListTerm9116);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleListTerm9126); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4138:1: ruleListTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedListElement_1_0 = null;

        EObject lv_ownedListElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4141:28: ( (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4142:1: (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4142:1: (otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4142:3: otherlv_0= '[' ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleListTerm9163); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getListTermAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4146:1: ( (lv_ownedListElement_1_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4147:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4147:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4148:3: lv_ownedListElement_1_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm9184);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4164:2: (otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==15) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4164:4: otherlv_2= ',' ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleListTerm9197); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getListTermAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4168:1: ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4169:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4169:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4170:3: lv_ownedListElement_3_0= rulePropertyExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm9218);
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
            	    break loop57;
                }
            } while (true);

            otherlv_4=(Token)match(input,48,FOLLOW_48_in_ruleListTerm9232); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4198:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4199:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4200:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation9268);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFieldPropertyAssociation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldPropertyAssociation9278); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4207:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4210:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4211:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4211:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4211:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4211:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4212:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4212:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4213:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation9327); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyRecordFieldCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleFieldPropertyAssociation9339); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4231:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4232:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4232:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4233:3: lv_ownedValue_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation9360);
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

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleFieldPropertyAssociation9372); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4261:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4262:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4263:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            }
            pushFollow(FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement9408);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainmentPathElement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPathElement9418); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4270:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4273:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==49) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4274:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4275:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4275:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4276:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainmentPathElement9468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4290:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==47) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4291:1: (lv_arrayRange_1_0= ruleArrayRange )
                            {
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4291:1: (lv_arrayRange_1_0= ruleArrayRange )
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4292:3: lv_arrayRange_1_0= ruleArrayRange
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleArrayRange_in_ruleContainmentPathElement9489);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4309:6: (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4309:6: (otherlv_2= 'annex' ( ( ruleANNEXREF ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4309:8: otherlv_2= 'annex' ( ( ruleANNEXREF ) )
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleContainmentPathElement9510); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getAnnexKeyword_1_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4313:1: ( ( ruleANNEXREF ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4314:1: ( ruleANNEXREF )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4314:1: ( ruleANNEXREF )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4315:3: ruleANNEXREF
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
                    pushFollow(FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement9537);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4339:1: entryRuleANNEXREF returns [String current=null] : iv_ruleANNEXREF= ruleANNEXREF EOF ;
    public final String entryRuleANNEXREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleANNEXREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4340:2: (iv_ruleANNEXREF= ruleANNEXREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4341:2: iv_ruleANNEXREF= ruleANNEXREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getANNEXREFRule()); 
            }
            pushFollow(FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF9575);
            iv_ruleANNEXREF=ruleANNEXREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleANNEXREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleANNEXREF9586); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4348:1: ruleANNEXREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4351:28: ( (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4352:1: (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4352:1: (kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4353:2: kw= '{' this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= '}'
            {
            kw=(Token)match(input,32,FOLLOW_32_in_ruleANNEXREF9624); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getANNEXREFAccess().getLeftCurlyBracketKeyword_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9646);
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
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9673);
            this_STAR_2=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleANNEXREF9693); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_3);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_3, grammarAccess.getANNEXREFAccess().getIDTerminalRuleCall_3()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_4()); 
                  
            }
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9720);
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
            pushFollow(FOLLOW_ruleSTAR_in_ruleANNEXREF9747);
            this_STAR_5=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STAR_5);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            kw=(Token)match(input,33,FOLLOW_33_in_ruleANNEXREF9765); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4423:1: entryRuleAndOp returns [String current=null] : iv_ruleAndOp= ruleAndOp EOF ;
    public final String entryRuleAndOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAndOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4424:2: (iv_ruleAndOp= ruleAndOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4425:2: iv_ruleAndOp= ruleAndOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndOpRule()); 
            }
            pushFollow(FOLLOW_ruleAndOp_in_entryRuleAndOp9806);
            iv_ruleAndOp=ruleAndOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOp9817); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4432:1: ruleAndOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleAndOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4435:28: (kw= 'and' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4437:2: kw= 'and'
            {
            kw=(Token)match(input,50,FOLLOW_50_in_ruleAndOp9854); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4450:1: entryRuleOrOp returns [String current=null] : iv_ruleOrOp= ruleOrOp EOF ;
    public final String entryRuleOrOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOrOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4451:2: (iv_ruleOrOp= ruleOrOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4452:2: iv_ruleOrOp= ruleOrOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrOpRule()); 
            }
            pushFollow(FOLLOW_ruleOrOp_in_entryRuleOrOp9894);
            iv_ruleOrOp=ruleOrOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrOp9905); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4459:1: ruleOrOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOrOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4462:28: (kw= 'or' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4464:2: kw= 'or'
            {
            kw=(Token)match(input,51,FOLLOW_51_in_ruleOrOp9942); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4477:1: entryRuleNotOp returns [String current=null] : iv_ruleNotOp= ruleNotOp EOF ;
    public final String entryRuleNotOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNotOp = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4478:2: (iv_ruleNotOp= ruleNotOp EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4479:2: iv_ruleNotOp= ruleNotOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotOpRule()); 
            }
            pushFollow(FOLLOW_ruleNotOp_in_entryRuleNotOp9982);
            iv_ruleNotOp=ruleNotOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOp9993); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4486:1: ruleNotOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'not' ;
    public final AntlrDatatypeRuleToken ruleNotOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4489:28: (kw= 'not' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4491:2: kw= 'not'
            {
            kw=(Token)match(input,52,FOLLOW_52_in_ruleNotOp10030); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4504:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4505:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4506:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusMinusRule()); 
            }
            pushFollow(FOLLOW_rulePlusMinus_in_entryRulePlusMinus10070);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusMinus.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusMinus10081); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4513:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4516:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4517:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4517:1: (kw= '+' | kw= '-' )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==53) ) {
                alt60=1;
            }
            else if ( (LA60_0==54) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4518:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_rulePlusMinus10119); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4525:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_rulePlusMinus10138); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4538:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4539:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4540:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm10178);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm10188); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4547:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4550:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4551:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4551:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4552:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4552:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4553:3: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm10233);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4577:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4578:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4579:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString10269);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString10280); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4586:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4589:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4590:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString10319); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4605:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4606:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4607:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayRangeRule()); 
            }
            pushFollow(FOLLOW_ruleArrayRange_in_entryRuleArrayRange10363);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayRange10373); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4614:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4617:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4618:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4618:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4618:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= rulegINT ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )? otherlv_5= ']'
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4618:2: ()
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4619:2: 
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

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleArrayRange10422); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4631:1: ( (lv_lowerBound_2_0= rulegINT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4632:1: (lv_lowerBound_2_0= rulegINT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4632:1: (lv_lowerBound_2_0= rulegINT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4633:3: lv_lowerBound_2_0= rulegINT
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundGINTParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulegINT_in_ruleArrayRange10443);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4649:2: (otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==55) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4649:4: otherlv_3= '..' ( (lv_upperBound_4_0= rulegINT ) )
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_55_in_ruleArrayRange10456); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4653:1: ( (lv_upperBound_4_0= rulegINT ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4654:1: (lv_upperBound_4_0= rulegINT )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4654:1: (lv_upperBound_4_0= rulegINT )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4655:3: lv_upperBound_4_0= rulegINT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundGINTParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulegINT_in_ruleArrayRange10477);
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

            otherlv_5=(Token)match(input,48,FOLLOW_48_in_ruleArrayRange10491); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4683:1: entryRuleIntegerRange returns [EObject current=null] : iv_ruleIntegerRange= ruleIntegerRange EOF ;
    public final EObject entryRuleIntegerRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4684:2: (iv_ruleIntegerRange= ruleIntegerRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4685:2: iv_ruleIntegerRange= ruleIntegerRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerRangeRule()); 
            }
            pushFollow(FOLLOW_ruleIntegerRange_in_entryRuleIntegerRange10527);
            iv_ruleIntegerRange=ruleIntegerRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerRange10537); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4692:1: ruleIntegerRange returns [EObject current=null] : ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4695:28: ( ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4696:1: ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4696:1: ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4696:2: ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4696:2: ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4697:1: ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4697:1: ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4698:1: (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4698:1: (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4699:3: lv_lowerBound_0_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundIntegerTermParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10585);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4714:8: lv_lowerBound_0_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundSignedConstantParserRuleCall_0_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleIntegerRange10604);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4729:8: lv_lowerBound_0_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundConstantValueParserRuleCall_0_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleIntegerRange10623);
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

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleIntegerRange10638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntegerRangeAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4751:1: ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4752:1: ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4752:1: ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4753:1: (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4753:1: (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4754:3: lv_upperBound_2_1= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundIntegerTermParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10661);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4769:8: lv_upperBound_2_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundSignedConstantParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleIntegerRange10680);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4784:8: lv_upperBound_2_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundConstantValueParserRuleCall_2_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleIntegerRange10699);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4810:1: entryRuleRealRange returns [EObject current=null] : iv_ruleRealRange= ruleRealRange EOF ;
    public final EObject entryRuleRealRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealRange = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4811:2: (iv_ruleRealRange= ruleRealRange EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4812:2: iv_ruleRealRange= ruleRealRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealRangeRule()); 
            }
            pushFollow(FOLLOW_ruleRealRange_in_entryRuleRealRange10738);
            iv_ruleRealRange=ruleRealRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealRange10748); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4819:1: ruleRealRange returns [EObject current=null] : ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4822:28: ( ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4823:1: ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4823:1: ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4823:2: ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4823:2: ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4824:1: ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4824:1: ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4825:1: (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4825:1: (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            int alt64=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_ID) ) {
                    alt64=2;
                }
                else if ( (LA64_1==RULE_INT) ) {
                    alt64=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA64_2 = input.LA(2);

                if ( (LA64_2==RULE_ID) ) {
                    alt64=2;
                }
                else if ( (LA64_2==RULE_INT) ) {
                    alt64=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt64=1;
                }
                break;
            case RULE_ID:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4826:3: lv_lowerBound_0_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundRealTermParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleRealRange10796);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4841:8: lv_lowerBound_0_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundSignedConstantParserRuleCall_0_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleRealRange10815);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4856:8: lv_lowerBound_0_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundConstantValueParserRuleCall_0_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleRealRange10834);
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

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleRealRange10849); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRealRangeAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4878:1: ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4879:1: ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4879:1: ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4880:1: (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4880:1: (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            int alt65=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==RULE_INT) ) {
                    alt65=1;
                }
                else if ( (LA65_1==RULE_ID) ) {
                    alt65=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA65_2 = input.LA(2);

                if ( (LA65_2==RULE_ID) ) {
                    alt65=2;
                }
                else if ( (LA65_2==RULE_INT) ) {
                    alt65=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt65=1;
                }
                break;
            case RULE_ID:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4881:3: lv_upperBound_2_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundRealTermParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleRealRange10872);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4896:8: lv_upperBound_2_2= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundSignedConstantParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleRealRange10891);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4911:8: lv_upperBound_2_3= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundConstantValueParserRuleCall_2_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleRealRange10910);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4937:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4938:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4939:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedConstantRule()); 
            }
            pushFollow(FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant10949);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedConstant; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedConstant10959); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4946:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4949:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4950:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4950:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4950:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4950:2: ( (lv_op_0_0= rulePlusMinus ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4951:1: (lv_op_0_0= rulePlusMinus )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4951:1: (lv_op_0_0= rulePlusMinus )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4952:3: lv_op_0_0= rulePlusMinus
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePlusMinus_in_ruleSignedConstant11005);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4968:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4969:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4969:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4970:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConstantValue_in_ruleSignedConstant11026);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4994:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4995:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:4996:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTermRule()); 
            }
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm11062);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm11072); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5003:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5006:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5007:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5007:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5007:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5007:2: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5008:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5008:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5009:3: lv_value_0_0= ruleSignedInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSignedInt_in_ruleIntegerTerm11118);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5025:2: ( (otherlv_1= RULE_ID ) )?
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5026:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5026:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5027:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getIntegerTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm11142); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5049:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5050:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5051:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedIntRule()); 
            }
            pushFollow(FOLLOW_ruleSignedInt_in_entryRuleSignedInt11180);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInt11191); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5058:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5061:28: ( ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5062:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5062:1: ( (kw= '+' | kw= '-' )? this_INT_2= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5062:2: (kw= '+' | kw= '-' )? this_INT_2= RULE_INT
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5062:2: (kw= '+' | kw= '-' )?
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5063:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleSignedInt11230); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5070:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleSignedInt11249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSignedInt11266); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5090:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5091:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5092:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealTermRule()); 
            }
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm11311);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm11321); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5099:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5102:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5103:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5103:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5103:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5103:2: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5104:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5104:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5105:3: lv_value_0_0= ruleSignedReal
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSignedReal_in_ruleRealTerm11367);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5121:2: ( (otherlv_1= RULE_ID ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==EOF||LA68_1==RULE_ID||(LA68_1>=15 && LA68_1<=16)||(LA68_1>=24 && LA68_1<=26)||LA68_1==37||LA68_1==41||LA68_1==48||(LA68_1>=55 && LA68_1<=56)) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5122:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5122:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5123:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getRealTermRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm11391); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5145:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5146:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5147:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSignedRealRule()); 
            }
            pushFollow(FOLLOW_ruleSignedReal_in_entryRuleSignedReal11429);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSignedReal.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedReal11440); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5154:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_REAL_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5157:28: ( ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5158:1: ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5158:1: ( (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5158:2: (kw= '+' | kw= '-' )? this_REAL_2= ruleREAL
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5158:2: (kw= '+' | kw= '-' )?
            int alt69=3;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==53) ) {
                alt69=1;
            }
            else if ( (LA69_0==54) ) {
                alt69=2;
            }
            switch (alt69) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5159:2: kw= '+'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleSignedReal11479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5166:2: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleSignedReal11498); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleREAL_in_ruleSignedReal11522);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5190:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5191:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5192:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            }
            pushFollow(FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm11567);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericRangeTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericRangeTerm11577); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5199:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? ) ;
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
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5202:28: ( ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5203:1: ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5203:1: ( ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5203:2: ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) ) otherlv_1= '..' ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) ) (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5203:2: ( ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5204:1: ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5204:1: ( (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5205:1: (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5205:1: (lv_minimum_0_1= ruleRealTerm | lv_minimum_0_2= ruleIntegerTerm | lv_minimum_0_3= ruleSignedConstant | lv_minimum_0_4= ruleConstantValue )
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

                    if ( (LA70_3==45) ) {
                        alt70=1;
                    }
                    else if ( (LA70_3==RULE_ID||LA70_3==55) ) {
                        alt70=2;
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

                if ( (LA70_2==RULE_ID) ) {
                    alt70=3;
                }
                else if ( (LA70_2==RULE_INT) ) {
                    int LA70_3 = input.LA(3);

                    if ( (LA70_3==45) ) {
                        alt70=1;
                    }
                    else if ( (LA70_3==RULE_ID||LA70_3==55) ) {
                        alt70=2;
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
                        new NoViableAltException("", 70, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA70_3 = input.LA(2);

                if ( (LA70_3==45) ) {
                    alt70=1;
                }
                else if ( (LA70_3==RULE_ID||LA70_3==55) ) {
                    alt70=2;
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5206:3: lv_minimum_0_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumRealTermParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11625);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5221:8: lv_minimum_0_2= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumIntegerTermParserRuleCall_0_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11644);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5236:8: lv_minimum_0_3= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumSignedConstantParserRuleCall_0_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11663);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5251:8: lv_minimum_0_4= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumConstantValueParserRuleCall_0_0_3()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11682);
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

            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleNumericRangeTerm11697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5273:1: ( ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5274:1: ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5274:1: ( (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5275:1: (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5275:1: (lv_maximum_2_1= ruleRealTerm | lv_maximum_2_2= ruleIntegerTerm | lv_maximum_2_3= ruleSignedConstant | lv_maximum_2_4= ruleConstantValue )
            int alt71=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==RULE_ID) ) {
                    alt71=3;
                }
                else if ( (LA71_1==RULE_INT) ) {
                    int LA71_3 = input.LA(3);

                    if ( (LA71_3==45) ) {
                        alt71=1;
                    }
                    else if ( (LA71_3==EOF||LA71_3==RULE_ID||(LA71_3>=15 && LA71_3<=16)||LA71_3==37||LA71_3==41||LA71_3==48||LA71_3==56) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                int LA71_2 = input.LA(2);

                if ( (LA71_2==RULE_INT) ) {
                    int LA71_3 = input.LA(3);

                    if ( (LA71_3==45) ) {
                        alt71=1;
                    }
                    else if ( (LA71_3==EOF||LA71_3==RULE_ID||(LA71_3>=15 && LA71_3<=16)||LA71_3==37||LA71_3==41||LA71_3==48||LA71_3==56) ) {
                        alt71=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA71_2==RULE_ID) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA71_3 = input.LA(2);

                if ( (LA71_3==45) ) {
                    alt71=1;
                }
                else if ( (LA71_3==EOF||LA71_3==RULE_ID||(LA71_3>=15 && LA71_3<=16)||LA71_3==37||LA71_3==41||LA71_3==48||LA71_3==56) ) {
                    alt71=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt71=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5276:3: lv_maximum_2_1= ruleRealTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumRealTermParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11720);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5291:8: lv_maximum_2_2= ruleIntegerTerm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumIntegerTermParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11739);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5306:8: lv_maximum_2_3= ruleSignedConstant
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumSignedConstantParserRuleCall_2_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11758);
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
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5321:8: lv_maximum_2_4= ruleConstantValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumConstantValueParserRuleCall_2_0_3()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11777);
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

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5339:2: (otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==56) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5339:4: otherlv_3= 'delta' ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) )
                    {
                    otherlv_3=(Token)match(input,56,FOLLOW_56_in_ruleNumericRangeTerm11793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5343:1: ( ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5344:1: ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5344:1: ( (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue ) )
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5345:1: (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue )
                    {
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5345:1: (lv_delta_4_1= ruleRealTerm | lv_delta_4_2= ruleIntegerTerm | lv_delta_4_3= ruleSignedConstant | lv_delta_4_4= ruleConstantValue )
                    int alt72=4;
                    switch ( input.LA(1) ) {
                    case 53:
                        {
                        int LA72_1 = input.LA(2);

                        if ( (LA72_1==RULE_ID) ) {
                            alt72=3;
                        }
                        else if ( (LA72_1==RULE_INT) ) {
                            int LA72_3 = input.LA(3);

                            if ( (LA72_3==EOF||LA72_3==RULE_ID||(LA72_3>=15 && LA72_3<=16)||LA72_3==37||LA72_3==41||LA72_3==48) ) {
                                alt72=2;
                            }
                            else if ( (LA72_3==45) ) {
                                alt72=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 72, 3, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 72, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 54:
                        {
                        int LA72_2 = input.LA(2);

                        if ( (LA72_2==RULE_INT) ) {
                            int LA72_3 = input.LA(3);

                            if ( (LA72_3==EOF||LA72_3==RULE_ID||(LA72_3>=15 && LA72_3<=16)||LA72_3==37||LA72_3==41||LA72_3==48) ) {
                                alt72=2;
                            }
                            else if ( (LA72_3==45) ) {
                                alt72=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 72, 3, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA72_2==RULE_ID) ) {
                            alt72=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 72, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_INT:
                        {
                        int LA72_3 = input.LA(2);

                        if ( (LA72_3==EOF||LA72_3==RULE_ID||(LA72_3>=15 && LA72_3<=16)||LA72_3==37||LA72_3==41||LA72_3==48) ) {
                            alt72=2;
                        }
                        else if ( (LA72_3==45) ) {
                            alt72=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 72, 3, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_ID:
                        {
                        alt72=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;
                    }

                    switch (alt72) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5346:3: lv_delta_4_1= ruleRealTerm
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaRealTermParserRuleCall_3_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11816);
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
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5361:8: lv_delta_4_2= ruleIntegerTerm
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaIntegerTermParserRuleCall_3_1_0_1()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11835);
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
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5376:8: lv_delta_4_3= ruleSignedConstant
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaSignedConstantParserRuleCall_3_1_0_2()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11854);
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
                            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5391:8: lv_delta_4_4= ruleConstantValue
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaConstantValueParserRuleCall_3_1_0_3()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11873);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5417:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5418:2: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5419:2: iv_ruleREAL= ruleREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getREALRule()); 
            }
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL11915);
            iv_ruleREAL=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL11926); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5426:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5429:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5430:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5430:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5430:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL11966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,45,FOLLOW_45_in_ruleREAL11984); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL11999); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5458:1: entryRulegINT returns [String current=null] : iv_rulegINT= rulegINT EOF ;
    public final String entryRulegINT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulegINT = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5459:2: (iv_rulegINT= rulegINT EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5460:2: iv_rulegINT= rulegINT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGINTRule()); 
            }
            pushFollow(FOLLOW_rulegINT_in_entryRulegINT12045);
            iv_rulegINT=rulegINT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegINT.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegINT12056); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5467:1: rulegINT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken rulegINT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5470:28: (this_INT_0= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5471:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_rulegINT12095); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5486:1: entryRulegREAL returns [String current=null] : iv_rulegREAL= rulegREAL EOF ;
    public final String entryRulegREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulegREAL = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5487:2: (iv_rulegREAL= rulegREAL EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5488:2: iv_rulegREAL= rulegREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGREALRule()); 
            }
            pushFollow(FOLLOW_rulegREAL_in_entryRulegREAL12140);
            iv_rulegREAL=rulegREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulegREAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulegREAL12151); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5495:1: rulegREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_0= ruleREAL ;
    public final AntlrDatatypeRuleToken rulegREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_REAL_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5498:28: (this_REAL_0= ruleREAL )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5500:5: this_REAL_0= ruleREAL
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGREALAccess().getREALParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleREAL_in_rulegREAL12197);
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5522:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5523:2: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5524:2: iv_ruleINAME= ruleINAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINAMERule()); 
            }
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME12246);
            iv_ruleINAME=ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME12257); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5531:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5534:28: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5535:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME12296); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5550:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5551:2: (iv_ruleQPREF= ruleQPREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5552:2: iv_ruleQPREF= ruleQPREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQPREFRule()); 
            }
            pushFollow(FOLLOW_ruleQPREF_in_entryRuleQPREF12341);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQPREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQPREF12352); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5559:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5562:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5563:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5563:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5563:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF12392); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5570:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==57) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5571:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleQPREF12411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                          
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF12426); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5591:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5592:2: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5593:2: iv_ruleQCREF= ruleQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF12474);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF12485); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5600:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5603:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5604:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5604:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5604:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5604:2: (this_ID_0= RULE_ID kw= '::' )*
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
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5604:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF12526); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleQCREF12544); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF12561); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5624:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==45) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5625:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleQCREF12580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF12595); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5645:1: entryRuleEQCREF returns [String current=null] : iv_ruleEQCREF= ruleEQCREF EOF ;
    public final String entryRuleEQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5646:2: (iv_ruleEQCREF= ruleEQCREF EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5647:2: iv_ruleEQCREF= ruleEQCREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEQCREFRule()); 
            }
            pushFollow(FOLLOW_ruleEQCREF_in_entryRuleEQCREF12643);
            iv_ruleEQCREF=ruleEQCREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEQCREF.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEQCREF12654); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5654:1: ruleEQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleEQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5657:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5658:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5658:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5658:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5658:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==RULE_ID) ) {
                    int LA77_1 = input.LA(2);

                    if ( (LA77_1==57) ) {
                        alt77=1;
                    }


                }


                switch (alt77) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5658:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEQCREF12695); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_0);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_0, grammarAccess.getEQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	          
            	    }
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleEQCREF12713); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getEQCREFAccess().getColonColonKeyword_0_1()); 
            	          
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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEQCREF12730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getEQCREFAccess().getIDTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5678:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==45) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5679:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleEQCREF12749); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEQCREFAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEQCREF12764); if (state.failed) return current;
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5699:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5700:2: (iv_ruleSTAR= ruleSTAR EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5701:2: iv_ruleSTAR= ruleSTAR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTARRule()); 
            }
            pushFollow(FOLLOW_ruleSTAR_in_entryRuleSTAR12812);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTAR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTAR12823); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5708:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5711:28: (kw= '*' )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:5713:2: kw= '*'
            {
            kw=(Token)match(input,58,FOLLOW_58_in_ruleSTAR12860); if (state.failed) return current;
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
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA50 dfa50 = new DFA50(this);
    static final String DFA4_eotS =
        "\16\uffff";
    static final String DFA4_eofS =
        "\16\uffff";
    static final String DFA4_minS =
        "\1\4\1\22\1\23\1\24\12\uffff";
    static final String DFA4_maxS =
        "\1\4\1\22\1\23\1\43\12\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\7\1\11\1\6\1\5\1\3\1\4\1\2\1\10\1\12\1\1";
    static final String DFA4_specialS =
        "\16\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\15\1\12\1\10\2\uffff\1\11\1\uffff\1\7\1\6\1\4\1\uffff\1"+
            "\13\2\uffff\1\5\1\14",
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
    static final String DFA49_eotS =
        "\27\uffff";
    static final String DFA49_eofS =
        "\4\uffff\1\20\1\12\11\uffff\1\20\3\uffff\1\26\1\12\1\26\1\uffff";
    static final String DFA49_minS =
        "\5\4\1\17\6\uffff\1\30\1\uffff\1\6\1\17\1\uffff\1\4\1\uffff\1\4"+
        "\2\17\1\uffff";
    static final String DFA49_maxS =
        "\1\66\1\64\2\6\1\67\1\71\6\uffff\1\71\1\uffff\1\6\1\67\1\uffff"+
        "\1\4\1\uffff\3\67\1\uffff";
    static final String DFA49_acceptS =
        "\6\uffff\1\3\1\4\1\5\1\10\1\11\1\12\1\uffff\1\2\2\uffff\1\7\1\uffff"+
        "\1\1\3\uffff\1\6";
    static final String DFA49_specialS =
        "\27\uffff}>";
    static final String[] DFA49_transitionS = {
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

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "3218:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComputedTerm_3= ruleComputedTerm | this_StringTerm_4= ruleStringTerm | this_RealTerm_5= ruleRealTerm | this_IntegerTerm_6= ruleIntegerTerm | this_ComponentClassifierTerm_7= ruleComponentClassifierTerm | this_BooleanTerm_8= ruleBooleanTerm | this_ListTerm_9= ruleListTerm )";
        }
    }
    static final String DFA50_eotS =
        "\26\uffff";
    static final String DFA50_eofS =
        "\4\uffff\1\16\1\11\7\uffff\1\16\4\uffff\1\25\1\11\1\25\1\uffff";
    static final String DFA50_minS =
        "\5\4\1\20\5\uffff\1\30\1\uffff\1\20\1\uffff\1\6\1\4\1\uffff\1\4"+
        "\2\20\1\uffff";
    static final String DFA50_maxS =
        "\1\66\1\64\2\6\1\67\1\71\5\uffff\1\71\1\uffff\1\67\1\uffff\1\6"+
        "\1\4\1\uffff\3\67\1\uffff";
    static final String DFA50_acceptS =
        "\6\uffff\1\3\1\4\1\7\1\10\1\11\1\uffff\1\2\1\uffff\1\6\2\uffff"+
        "\1\1\3\uffff\1\5";
    static final String DFA50_specialS =
        "\26\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\5\1\7\1\4\20\uffff\1\1\7\uffff\1\10\13\uffff\2\11\1\uffff"+
            "\1\6\1\12\4\uffff\1\11\1\2\1\3",
            "\1\13\22\uffff\1\11\23\uffff\2\11\7\uffff\1\11",
            "\1\14\1\uffff\1\4",
            "\1\14\1\uffff\1\4",
            "\1\15\13\uffff\1\16\34\uffff\1\17\11\uffff\1\14",
            "\1\11\41\uffff\2\11\3\uffff\1\14\1\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\1\21\27\uffff\2\11\5\uffff\1\11",
            "",
            "\1\16\46\uffff\1\14",
            "",
            "\1\22",
            "\1\23",
            "",
            "\1\24\13\uffff\1\25\46\uffff\1\14",
            "\1\11\41\uffff\2\11\3\uffff\1\14",
            "\1\25\46\uffff\1\14",
            ""
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "3368:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_BooleanTerm_7= ruleBooleanTerm | this_ListTerm_8= ruleListTerm )";
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
    public static final BitSet FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath6485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPath6495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath6553 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleContainmentPath6566 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath6587 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleModalPropertyValue_in_entryRuleModalPropertyValue6625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModalPropertyValue6635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleModalPropertyValue6681 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleModalPropertyValue6694 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleModalPropertyValue6706 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleModalPropertyValue6718 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModalPropertyValue6742 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_15_in_ruleModalPropertyValue6755 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModalPropertyValue6779 = new BitSet(new long[]{0x0000000001008000L});
    public static final BitSet FOLLOW_24_in_ruleModalPropertyValue6793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValue_in_entryRulePropertyValue6831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValue6841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyValue6886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression6921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression6931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_rulePropertyExpression6981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression7011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_rulePropertyExpression7041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_rulePropertyExpression7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_rulePropertyExpression7101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_rulePropertyExpression7131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_rulePropertyExpression7161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression7191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_rulePropertyExpression7221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_rulePropertyExpression7251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantPropertyExpression_in_entryRuleConstantPropertyExpression7286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantPropertyExpression7296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_ruleConstantPropertyExpression7346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_ruleConstantPropertyExpression7376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_ruleConstantPropertyExpression7406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleConstantPropertyExpression7436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleConstantPropertyExpression7466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleConstantPropertyExpression7496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_ruleConstantPropertyExpression7526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_ruleConstantPropertyExpression7556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_ruleConstantPropertyExpression7586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_entryRuleBooleanTerm7621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTerm7631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrTerm_in_ruleBooleanTerm7680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrTerm_in_entryRuleOrTerm7714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrTerm7724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndTerm_in_ruleOrTerm7774 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleOrOp_in_ruleOrTerm7807 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleAndTerm_in_ruleOrTerm7828 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleAndTerm_in_entryRuleAndTerm7866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndTerm7876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleAndTerm7926 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleAndOp_in_ruleAndTerm7959 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleAndTerm7980 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleNotTerm_in_entryRuleNotTerm8018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotTerm8028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOp_in_ruleNotTerm8074 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_ruleNotTerm8095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanAtom_in_entryRuleBooleanAtom8131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanAtom8141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleBooleanAtom8191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotTerm_in_ruleBooleanAtom8221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleBooleanAtom8251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBooleanAtom8269 = new BitSet(new long[]{0x0070180000800050L});
    public static final BitSet FOLLOW_ruleBooleanTerm_in_ruleBooleanAtom8294 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleBooleanAtom8305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBooleanLiteral8408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleBooleanLiteral8439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue8476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleConstantValue8537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceTerm8582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleReferenceTerm8619 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleReferenceTerm8631 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8652 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_45_in_ruleReferenceTerm8665 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8686 = new BitSet(new long[]{0x0000200001000000L});
    public static final BitSet FOLLOW_24_in_ruleReferenceTerm8700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordTerm8746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleRecordTerm8783 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm8804 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_ruleRecordTerm8817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComputedTerm8863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComputedTerm8900 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleComputedTerm8912 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComputedTerm8929 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComputedTerm8946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentClassifierTerm8992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleComponentClassifierTerm9029 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleComponentClassifierTerm9041 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm9068 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComponentClassifierTerm9080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_entryRuleListTerm9116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListTerm9126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleListTerm9163 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm9184 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_15_in_ruleListTerm9197 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm9218 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_48_in_ruleListTerm9232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation9268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldPropertyAssociation9278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation9327 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleFieldPropertyAssociation9339 = new BitSet(new long[]{0x0070D80480800070L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation9360 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFieldPropertyAssociation9372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement9408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement9418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentPathElement9468 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement9489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleContainmentPathElement9510 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement9537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF9575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANNEXREF9586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleANNEXREF9624 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9646 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9673 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleANNEXREF9693 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9720 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF9747 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleANNEXREF9765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOp_in_entryRuleAndOp9806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOp9817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleAndOp9854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOp_in_entryRuleOrOp9894 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrOp9905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleOrOp9942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOp_in_entryRuleNotOp9982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOp9993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleNotOp10030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus10070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus10081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rulePlusMinus10119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rulePlusMinus10138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm10178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm10188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm10233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString10269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString10280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString10319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange10363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange10373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleArrayRange10422 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rulegINT_in_ruleArrayRange10443 = new BitSet(new long[]{0x0081000000000000L});
    public static final BitSet FOLLOW_55_in_ruleArrayRange10456 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rulegINT_in_ruleArrayRange10477 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleArrayRange10491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerRange_in_entryRuleIntegerRange10527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerRange10537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10585 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleIntegerRange10604 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleIntegerRange10623 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleIntegerRange10638 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleIntegerRange10661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleIntegerRange10680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleIntegerRange10699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealRange_in_entryRuleRealRange10738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealRange10748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleRealRange10796 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleRealRange10815 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleRealRange10834 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleRealRange10849 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleRealRange10872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleRealRange10891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleRealRange10910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant10949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedConstant10959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_ruleSignedConstant11005 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleSignedConstant11026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm11062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm11072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerTerm11118 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm11142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_entryRuleSignedInt11180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInt11191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSignedInt11230 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_54_in_ruleSignedInt11249 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSignedInt11266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm11311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm11321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealTerm11367 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm11391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_entryRuleSignedReal11429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedReal11440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSignedReal11479 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_54_in_ruleSignedReal11498 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleSignedReal11522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm11567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericRangeTerm11577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11625 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11644 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11663 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11682 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleNumericRangeTerm11697 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11720 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11739 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11758 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11777 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_56_in_ruleNumericRangeTerm11793 = new BitSet(new long[]{0x0060000000000050L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumericRangeTerm11816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumericRangeTerm11835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumericRangeTerm11854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumericRangeTerm11873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL11915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL11926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL11966 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleREAL11984 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL11999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegINT_in_entryRulegINT12045 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegINT12056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rulegINT12095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulegREAL_in_entryRulegREAL12140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulegREAL12151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_rulegREAL12197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME12246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME12257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME12296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_entryRuleQPREF12341 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQPREF12352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF12392 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_ruleQPREF12411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF12426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF12474 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF12485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12526 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleQCREF12544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12561 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleQCREF12580 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEQCREF_in_entryRuleEQCREF12643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEQCREF12654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEQCREF12695 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleEQCREF12713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEQCREF12730 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleEQCREF12749 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEQCREF12764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTAR_in_entryRuleSTAR12812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTAR12823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSTAR12860 = new BitSet(new long[]{0x0000000000000002L});

}