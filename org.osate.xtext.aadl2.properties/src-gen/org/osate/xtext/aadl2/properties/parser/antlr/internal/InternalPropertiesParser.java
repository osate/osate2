package org.osate.xtext.aadl2.properties.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.properties.services.PropertiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPropertiesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SEMI", "RULE_COLON", "RULE_INT", "RULE_DOT", "RULE_NONE", "RULE_LTRANS", "RULE_RTRANS", "RULE_SL_COMMENT", "RULE_COMMA", "RULE_LPARENS", "RULE_RPARENS", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_LCURLY", "RULE_RCURLY", "RULE_ASSIGN", "RULE_APPEND", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'property'", "'set'", "'is'", "'end'", "'type'"
    };
    public static final int RULE_RPARENS=15;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int RULE_APPEND=21;
    public static final int RULE_ANY_OTHER=25;
    public static final int RULE_LTRANS=10;
    public static final int RULE_COMMA=13;
    public static final int RULE_LBRACKET=16;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_NONE=9;
    public static final int RULE_ML_COMMENT=23;
    public static final int RULE_ASSIGN=20;
    public static final int T__30=30;
    public static final int RULE_COLON=6;
    public static final int RULE_STRING=22;
    public static final int RULE_DOT=8;
    public static final int RULE_LPARENS=14;
    public static final int RULE_INT=7;
    public static final int RULE_RTRANS=11;
    public static final int RULE_WS=24;
    public static final int RULE_RBRACKET=17;
    public static final int RULE_RCURLY=19;
    public static final int RULE_SEMI=5;
    public static final int RULE_LCURLY=18;

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:67:1: entryRulePropertySet returns [EObject current=null] : iv_rulePropertySet= rulePropertySet EOF ;
    public final EObject entryRulePropertySet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertySet = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:68:2: (iv_rulePropertySet= rulePropertySet EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:69:2: iv_rulePropertySet= rulePropertySet EOF
            {
             newCompositeNode(grammarAccess.getPropertySetRule()); 
            pushFollow(FOLLOW_rulePropertySet_in_entryRulePropertySet75);
            iv_rulePropertySet=rulePropertySet();

            state._fsp--;

             current =iv_rulePropertySet; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertySet85); 

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:76:1: rulePropertySet returns [EObject current=null] : (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) ) )+ otherlv_5= 'end' this_ID_6= RULE_ID this_SEMI_7= RULE_SEMI ) ;
    public final EObject rulePropertySet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token this_SEMI_7=null;
        EObject lv_owned_4_1 = null;

        EObject lv_owned_4_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:79:28: ( (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) ) )+ otherlv_5= 'end' this_ID_6= RULE_ID this_SEMI_7= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:80:1: (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) ) )+ otherlv_5= 'end' this_ID_6= RULE_ID this_SEMI_7= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:80:1: (otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) ) )+ otherlv_5= 'end' this_ID_6= RULE_ID this_SEMI_7= RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:80:3: otherlv_0= 'property' otherlv_1= 'set' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) ) )+ otherlv_5= 'end' this_ID_6= RULE_ID this_SEMI_7= RULE_SEMI
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_rulePropertySet122); 

                	newLeafNode(otherlv_0, grammarAccess.getPropertySetAccess().getPropertyKeyword_0());
                
            otherlv_1=(Token)match(input,27,FOLLOW_27_in_rulePropertySet134); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertySetAccess().getSetKeyword_1());
                
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:88:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:89:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:89:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:90:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertySet151); 

            			newLeafNode(lv_name_2_0, grammarAccess.getPropertySetAccess().getNameIDTerminalRuleCall_2_0()); 
            		

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

            otherlv_3=(Token)match(input,28,FOLLOW_28_in_rulePropertySet168); 

                	newLeafNode(otherlv_3, grammarAccess.getPropertySetAccess().getIsKeyword_3());
                
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:110:1: ( ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:111:1: ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:111:1: ( (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition ) )
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:112:1: (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition )
            	    {
            	    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:112:1: (lv_owned_4_1= rulePropertyType | lv_owned_4_2= rulePropertyDefinition )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_ID) ) {
            	        int LA1_1 = input.LA(2);

            	        if ( (LA1_1==RULE_COLON) ) {
            	            int LA1_2 = input.LA(3);

            	            if ( (LA1_2==30) ) {
            	                alt1=1;
            	            }
            	            else if ( (LA1_2==RULE_ID) ) {
            	                alt1=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 1, 2, input);

            	                throw nvae;
            	            }
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 1, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:113:3: lv_owned_4_1= rulePropertyType
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyTypeParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_rulePropertyType_in_rulePropertySet191);
            	            lv_owned_4_1=rulePropertyType();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getPropertySetRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"owned",
            	                    		lv_owned_4_1, 
            	                    		"PropertyType");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:128:8: lv_owned_4_2= rulePropertyDefinition
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyDefinitionParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_rulePropertyDefinition_in_rulePropertySet210);
            	            lv_owned_4_2=rulePropertyDefinition();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getPropertySetRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"owned",
            	                    		lv_owned_4_2, 
            	                    		"PropertyDefinition");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            otherlv_5=(Token)match(input,29,FOLLOW_29_in_rulePropertySet226); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertySetAccess().getEndKeyword_5());
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertySet237); 
             
                newLeafNode(this_ID_6, grammarAccess.getPropertySetAccess().getIDTerminalRuleCall_6()); 
                
            this_SEMI_7=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePropertySet247); 
             
                newLeafNode(this_SEMI_7, grammarAccess.getPropertySetAccess().getSEMITerminalRuleCall_7()); 
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:166:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:167:2: (iv_rulePropertyType= rulePropertyType EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:168:2: iv_rulePropertyType= rulePropertyType EOF
            {
             newCompositeNode(grammarAccess.getPropertyTypeRule()); 
            pushFollow(FOLLOW_rulePropertyType_in_entryRulePropertyType282);
            iv_rulePropertyType=rulePropertyType();

            state._fsp--;

             current =iv_rulePropertyType; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyType292); 

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:175:1: rulePropertyType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'type' this_SEMI_3= RULE_SEMI ) ;
    public final EObject rulePropertyType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:178:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'type' this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:179:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'type' this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:179:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'type' this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:179:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'type' this_SEMI_3= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:179:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:180:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:180:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:181:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyType334); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPropertyTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rulePropertyType350); 
             
                newLeafNode(this_COLON_1, grammarAccess.getPropertyTypeAccess().getCOLONTerminalRuleCall_1()); 
                
            otherlv_2=(Token)match(input,30,FOLLOW_30_in_rulePropertyType361); 

                	newLeafNode(otherlv_2, grammarAccess.getPropertyTypeAccess().getTypeKeyword_2());
                
            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePropertyType372); 
             
                newLeafNode(this_SEMI_3, grammarAccess.getPropertyTypeAccess().getSEMITerminalRuleCall_3()); 
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRulePropertyDefinition"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:217:1: entryRulePropertyDefinition returns [EObject current=null] : iv_rulePropertyDefinition= rulePropertyDefinition EOF ;
    public final EObject entryRulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefinition = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:218:2: (iv_rulePropertyDefinition= rulePropertyDefinition EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:219:2: iv_rulePropertyDefinition= rulePropertyDefinition EOF
            {
             newCompositeNode(grammarAccess.getPropertyDefinitionRule()); 
            pushFollow(FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition407);
            iv_rulePropertyDefinition=rulePropertyDefinition();

            state._fsp--;

             current =iv_rulePropertyDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyDefinition417); 

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:226:1: rulePropertyDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject rulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token this_SEMI_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:229:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:230:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:230:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:230:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) this_SEMI_3= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:230:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:231:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:231:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:232:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyDefinition459); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPropertyDefinitionAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_rulePropertyDefinition475); 
             
                newLeafNode(this_COLON_1, grammarAccess.getPropertyDefinitionAccess().getCOLONTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:252:1: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:253:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:253:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:254:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyDefinitionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyDefinition494); 

            		newLeafNode(otherlv_2, grammarAccess.getPropertyDefinitionAccess().getTypePropertyTypeCrossReference_2_0()); 
            	

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePropertyDefinition505); 
             
                newLeafNode(this_SEMI_3, grammarAccess.getPropertyDefinitionAccess().getSEMITerminalRuleCall_3()); 
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRulePropertyExpression"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:279:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:280:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:281:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression542);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;

             current =iv_rulePropertyExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression552); 

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:288:1: rulePropertyExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_ProbabilityValue_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:291:28: ( (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:292:1: (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:292:1: (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_INT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:293:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePropertyExpression599);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:303:5: this_ProbabilityValue_1= ruleProbabilityValue
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getProbabilityValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleProbabilityValue_in_rulePropertyExpression626);
                    this_ProbabilityValue_1=ruleProbabilityValue();

                    state._fsp--;

                     
                            current = this_ProbabilityValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:319:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:320:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:321:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral661);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral671); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:328:1: ruleLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:331:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:332:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:332:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:333:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:333:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:334:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteral712); 

            			newLeafNode(lv_name_0_0, grammarAccess.getLiteralAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleProbabilityValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:358:1: entryRuleProbabilityValue returns [EObject current=null] : iv_ruleProbabilityValue= ruleProbabilityValue EOF ;
    public final EObject entryRuleProbabilityValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProbabilityValue = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:359:2: (iv_ruleProbabilityValue= ruleProbabilityValue EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:360:2: iv_ruleProbabilityValue= ruleProbabilityValue EOF
            {
             newCompositeNode(grammarAccess.getProbabilityValueRule()); 
            pushFollow(FOLLOW_ruleProbabilityValue_in_entryRuleProbabilityValue752);
            iv_ruleProbabilityValue=ruleProbabilityValue();

            state._fsp--;

             current =iv_ruleProbabilityValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProbabilityValue762); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProbabilityValue"


    // $ANTLR start "ruleProbabilityValue"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:367:1: ruleProbabilityValue returns [EObject current=null] : ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProbabilityValue() throws RecognitionException {
        EObject current = null;

        Token lv_distribution_1_0=null;
        AntlrDatatypeRuleToken lv_number_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:370:28: ( ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:371:1: ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:371:1: ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:371:2: ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:371:2: ( (lv_number_0_0= ruleREAL ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:372:1: (lv_number_0_0= ruleREAL )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:372:1: (lv_number_0_0= ruleREAL )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:373:3: lv_number_0_0= ruleREAL
            {
             
            	        newCompositeNode(grammarAccess.getProbabilityValueAccess().getNumberREALParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleREAL_in_ruleProbabilityValue808);
            lv_number_0_0=ruleREAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProbabilityValueRule());
            	        }
                   		set(
                   			current, 
                   			"number",
                    		lv_number_0_0, 
                    		"REAL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:389:2: ( (lv_distribution_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:390:1: (lv_distribution_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:390:1: (lv_distribution_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:391:3: lv_distribution_1_0= RULE_ID
            {
            lv_distribution_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProbabilityValue825); 

            			newLeafNode(lv_distribution_1_0, grammarAccess.getProbabilityValueAccess().getDistributionIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProbabilityValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"distribution",
                    		lv_distribution_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProbabilityValue"


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:415:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:416:2: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:417:2: iv_ruleREAL= ruleREAL EOF
            {
             newCompositeNode(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL867);
            iv_ruleREAL=ruleREAL();

            state._fsp--;

             current =iv_ruleREAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL878); 

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:424:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DOT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:427:28: ( (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT ) )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:428:1: (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:428:1: (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:428:6: this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL918); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                
            this_DOT_1=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleREAL938); 

            		current.merge(this_DOT_1);
                
             
                newLeafNode(this_DOT_1, grammarAccess.getREALAccess().getDOTTerminalRuleCall_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL958); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleINAME"
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:461:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:462:2: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:463:2: iv_ruleINAME= ruleINAME EOF
            {
             newCompositeNode(grammarAccess.getINAMERule()); 
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME1008);
            iv_ruleINAME=ruleINAME();

            state._fsp--;

             current =iv_ruleINAME.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME1019); 

            }

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
    // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:470:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:473:28: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2.properties/src-gen/org/osate/xtext/aadl2/properties/parser/antlr/internal/InternalProperties.g:474:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME1058); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getINAMEAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule(); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePropertySet_in_entryRulePropertySet75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertySet85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePropertySet122 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePropertySet134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet151 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_rulePropertySet168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePropertyType_in_rulePropertySet191 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rulePropertyDefinition_in_rulePropertySet210 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_29_in_rulePropertySet226 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet237 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePropertySet247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyType_in_entryRulePropertyType282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyType292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyType334 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_COLON_in_rulePropertyType350 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_rulePropertyType361 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePropertyType372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyDefinition417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyDefinition459 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_COLON_in_rulePropertyDefinition475 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyDefinition494 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePropertyDefinition505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePropertyExpression599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProbabilityValue_in_rulePropertyExpression626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteral712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProbabilityValue_in_entryRuleProbabilityValue752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProbabilityValue762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleProbabilityValue808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProbabilityValue825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL918 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleREAL938 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME1008 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME1058 = new BitSet(new long[]{0x0000000000000002L});

}