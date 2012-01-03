package org.osate.xtext.aadl2.propertyset.parser.antlr.internal; 

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
import org.osate.xtext.aadl2.propertyset.services.PropertysetGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPropertysetParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_74", "KEYWORD_71", "KEYWORD_72", "KEYWORD_73", "KEYWORD_68", "KEYWORD_69", "KEYWORD_70", "KEYWORD_64", "KEYWORD_65", "KEYWORD_66", "KEYWORD_67", "KEYWORD_60", "KEYWORD_61", "KEYWORD_62", "KEYWORD_63", "KEYWORD_53", "KEYWORD_54", "KEYWORD_55", "KEYWORD_56", "KEYWORD_57", "KEYWORD_58", "KEYWORD_59", "KEYWORD_46", "KEYWORD_47", "KEYWORD_48", "KEYWORD_49", "KEYWORD_50", "KEYWORD_51", "KEYWORD_52", "KEYWORD_37", "KEYWORD_38", "KEYWORD_39", "KEYWORD_40", "KEYWORD_41", "KEYWORD_42", "KEYWORD_43", "KEYWORD_44", "KEYWORD_45", "KEYWORD_29", "KEYWORD_30", "KEYWORD_31", "KEYWORD_32", "KEYWORD_33", "KEYWORD_34", "KEYWORD_35", "KEYWORD_36", "KEYWORD_22", "KEYWORD_23", "KEYWORD_24", "KEYWORD_25", "KEYWORD_26", "KEYWORD_27", "KEYWORD_28", "KEYWORD_14", "KEYWORD_15", "KEYWORD_16", "KEYWORD_17", "KEYWORD_18", "KEYWORD_19", "KEYWORD_20", "KEYWORD_21", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_12", "KEYWORD_13", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_REAL_LIT", "RULE_BASED_INTEGER", "RULE_INTEGER_LIT", "RULE_EXTENDED_DIGIT", "RULE_STRING", "RULE_ID", "RULE_WS"
    };
    public static final int RULE_ID=87;
    public static final int RULE_INTEGER_LIT=84;
    public static final int RULE_REAL_LIT=82;
    public static final int KEYWORD_56=22;
    public static final int KEYWORD_19=62;
    public static final int KEYWORD_55=21;
    public static final int KEYWORD_54=20;
    public static final int KEYWORD_17=60;
    public static final int KEYWORD_53=19;
    public static final int KEYWORD_18=61;
    public static final int KEYWORD_52=32;
    public static final int KEYWORD_15=58;
    public static final int KEYWORD_51=31;
    public static final int KEYWORD_16=59;
    public static final int KEYWORD_50=30;
    public static final int KEYWORD_13=77;
    public static final int KEYWORD_14=57;
    public static final int KEYWORD_11=75;
    public static final int EOF=-1;
    public static final int KEYWORD_12=76;
    public static final int KEYWORD_10=74;
    public static final int KEYWORD_59=25;
    public static final int KEYWORD_58=24;
    public static final int KEYWORD_57=23;
    public static final int KEYWORD_6=70;
    public static final int KEYWORD_7=71;
    public static final int KEYWORD_8=72;
    public static final int KEYWORD_9=73;
    public static final int KEYWORD_28=56;
    public static final int KEYWORD_65=12;
    public static final int KEYWORD_64=11;
    public static final int KEYWORD_29=42;
    public static final int KEYWORD_67=14;
    public static final int KEYWORD_66=13;
    public static final int KEYWORD_24=52;
    public static final int KEYWORD_61=16;
    public static final int KEYWORD_25=53;
    public static final int KEYWORD_60=15;
    public static final int KEYWORD_26=54;
    public static final int KEYWORD_63=18;
    public static final int KEYWORD_62=17;
    public static final int KEYWORD_27=55;
    public static final int KEYWORD_20=63;
    public static final int KEYWORD_21=64;
    public static final int KEYWORD_22=50;
    public static final int KEYWORD_23=51;
    public static final int KEYWORD_69=9;
    public static final int KEYWORD_68=8;
    public static final int RULE_EXTENDED_DIGIT=85;
    public static final int KEYWORD_71=5;
    public static final int KEYWORD_72=6;
    public static final int KEYWORD_73=7;
    public static final int KEYWORD_74=4;
    public static final int KEYWORD_30=43;
    public static final int KEYWORD_1=65;
    public static final int KEYWORD_34=47;
    public static final int KEYWORD_5=69;
    public static final int KEYWORD_33=46;
    public static final int KEYWORD_4=68;
    public static final int KEYWORD_70=10;
    public static final int KEYWORD_32=45;
    public static final int KEYWORD_3=67;
    public static final int KEYWORD_31=44;
    public static final int KEYWORD_2=66;
    public static final int KEYWORD_38=34;
    public static final int RULE_BASED_INTEGER=83;
    public static final int KEYWORD_37=33;
    public static final int RULE_SL_COMMENT=78;
    public static final int KEYWORD_36=49;
    public static final int KEYWORD_35=48;
    public static final int KEYWORD_39=35;
    public static final int RULE_STRING=86;
    public static final int RULE_EXPONENT=80;
    public static final int RULE_INT_EXPONENT=81;
    public static final int KEYWORD_41=37;
    public static final int KEYWORD_40=36;
    public static final int KEYWORD_43=39;
    public static final int KEYWORD_42=38;
    public static final int KEYWORD_45=41;
    public static final int KEYWORD_44=40;
    public static final int KEYWORD_47=27;
    public static final int RULE_WS=88;
    public static final int KEYWORD_46=26;
    public static final int RULE_DIGIT=79;
    public static final int KEYWORD_49=29;
    public static final int KEYWORD_48=28;

    // delegates
    // delegators


        public InternalPropertysetParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPropertysetParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPropertysetParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g"; }




    	private PropertysetGrammarAccess grammarAccess;
    	 	
    	public InternalPropertysetParser(TokenStream input, PropertysetGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "PropertySet";	
    	} 
    	   	   	
    	@Override
    	protected PropertysetGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRulePropertySet"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:62:1: entryRulePropertySet returns [EObject current=null] : iv_rulePropertySet= rulePropertySet EOF ;
    public final EObject entryRulePropertySet() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertySet = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:63:2: (iv_rulePropertySet= rulePropertySet EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:64:2: iv_rulePropertySet= rulePropertySet EOF
            {
             newCompositeNode(grammarAccess.getPropertySetRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertySet_in_entryRulePropertySet67);
            iv_rulePropertySet=rulePropertySet();

            state._fsp--;

             current =iv_rulePropertySet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertySet77); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:71:1: rulePropertySet returns [EObject current=null] : (otherlv_0= KEYWORD_63 otherlv_1= KEYWORD_28 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_18 (otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9 )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= KEYWORD_26 this_ID_13= RULE_ID otherlv_14= KEYWORD_9 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:74:28: ( (otherlv_0= KEYWORD_63 otherlv_1= KEYWORD_28 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_18 (otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9 )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= KEYWORD_26 this_ID_13= RULE_ID otherlv_14= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:75:1: (otherlv_0= KEYWORD_63 otherlv_1= KEYWORD_28 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_18 (otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9 )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= KEYWORD_26 this_ID_13= RULE_ID otherlv_14= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:75:1: (otherlv_0= KEYWORD_63 otherlv_1= KEYWORD_28 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_18 (otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9 )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= KEYWORD_26 this_ID_13= RULE_ID otherlv_14= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:76:2: otherlv_0= KEYWORD_63 otherlv_1= KEYWORD_28 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_18 (otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9 )* ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )* otherlv_12= KEYWORD_26 this_ID_13= RULE_ID otherlv_14= KEYWORD_9
            {
            otherlv_0=(Token)match(input,KEYWORD_63,FollowSets000.FOLLOW_KEYWORD_63_in_rulePropertySet115); 

                	newLeafNode(otherlv_0, grammarAccess.getPropertySetAccess().getPropertyKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_28,FollowSets000.FOLLOW_KEYWORD_28_in_rulePropertySet127); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertySetAccess().getSetKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:85:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:86:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:86:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:87:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePropertySet143); 

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

            otherlv_3=(Token)match(input,KEYWORD_18,FollowSets000.FOLLOW_KEYWORD_18_in_rulePropertySet161); 

                	newLeafNode(otherlv_3, grammarAccess.getPropertySetAccess().getIsKeyword_3());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:108:1: (otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==KEYWORD_36) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:109:2: otherlv_4= KEYWORD_36 ( (otherlv_5= RULE_ID ) ) (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )* otherlv_8= KEYWORD_9
            	    {
            	    otherlv_4=(Token)match(input,KEYWORD_36,FollowSets000.FOLLOW_KEYWORD_36_in_rulePropertySet174); 

            	        	newLeafNode(otherlv_4, grammarAccess.getPropertySetAccess().getWithKeyword_4_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:113:1: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:114:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:114:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:115:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPropertySetRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePropertySet193); 

            	    		newLeafNode(otherlv_5, grammarAccess.getPropertySetAccess().getImportedUnitPropertySetCrossReference_4_1_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:126:2: (otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) ) )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==KEYWORD_5) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:127:2: otherlv_6= KEYWORD_5 ( (otherlv_7= RULE_ID ) )
            	    	    {
            	    	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_rulePropertySet207); 

            	    	        	newLeafNode(otherlv_6, grammarAccess.getPropertySetAccess().getCommaKeyword_4_2_0());
            	    	        
            	    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:131:1: ( (otherlv_7= RULE_ID ) )
            	    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:132:1: (otherlv_7= RULE_ID )
            	    	    {
            	    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:132:1: (otherlv_7= RULE_ID )
            	    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:133:3: otherlv_7= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getPropertySetRule());
            	    	    	        }
            	    	            
            	    	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePropertySet226); 

            	    	    		newLeafNode(otherlv_7, grammarAccess.getPropertySetAccess().getImportedUnitPropertySetCrossReference_4_2_1_0()); 
            	    	    	

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    otherlv_8=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_rulePropertySet241); 

            	        	newLeafNode(otherlv_8, grammarAccess.getPropertySetAccess().getSemicolonKeyword_4_3());
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:149:3: ( ( (lv_ownedPropertyType_9_0= rulePropertyType ) ) | ( (lv_ownedProperty_10_0= rulePropertyDefinition ) ) | ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) ) )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==KEYWORD_8) ) {
                        switch ( input.LA(3) ) {
                        case KEYWORD_35:
                            {
                            alt3=1;
                            }
                            break;
                        case KEYWORD_62:
                            {
                            alt3=3;
                            }
                            break;
                        case KEYWORD_71:
                        case KEYWORD_72:
                        case KEYWORD_73:
                        case KEYWORD_68:
                        case KEYWORD_69:
                        case KEYWORD_67:
                        case KEYWORD_60:
                        case KEYWORD_56:
                        case KEYWORD_50:
                        case KEYWORD_44:
                        case KEYWORD_45:
                        case KEYWORD_31:
                        case RULE_ID:
                            {
                            alt3=2;
                            }
                            break;

                        }

                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:149:4: ( (lv_ownedPropertyType_9_0= rulePropertyType ) )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:149:4: ( (lv_ownedPropertyType_9_0= rulePropertyType ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:150:1: (lv_ownedPropertyType_9_0= rulePropertyType )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:150:1: (lv_ownedPropertyType_9_0= rulePropertyType )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:151:3: lv_ownedPropertyType_9_0= rulePropertyType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyTypePropertyTypeParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePropertyType_in_rulePropertySet264);
            	    lv_ownedPropertyType_9_0=rulePropertyType();

            	    state._fsp--;


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
            	    break;
            	case 2 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:168:6: ( (lv_ownedProperty_10_0= rulePropertyDefinition ) )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:168:6: ( (lv_ownedProperty_10_0= rulePropertyDefinition ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:169:1: (lv_ownedProperty_10_0= rulePropertyDefinition )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:169:1: (lv_ownedProperty_10_0= rulePropertyDefinition )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:170:3: lv_ownedProperty_10_0= rulePropertyDefinition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyPropertyDefinitionParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePropertyDefinition_in_rulePropertySet291);
            	    lv_ownedProperty_10_0=rulePropertyDefinition();

            	    state._fsp--;


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
            	    break;
            	case 3 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:187:6: ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:187:6: ( (lv_ownedPropertyConstant_11_0= rulePropertyConstant ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:188:1: (lv_ownedPropertyConstant_11_0= rulePropertyConstant )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:188:1: (lv_ownedPropertyConstant_11_0= rulePropertyConstant )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:189:3: lv_ownedPropertyConstant_11_0= rulePropertyConstant
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertySetAccess().getOwnedPropertyConstantPropertyConstantParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePropertyConstant_in_rulePropertySet318);
            	    lv_ownedPropertyConstant_11_0=rulePropertyConstant();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_12=(Token)match(input,KEYWORD_26,FollowSets000.FOLLOW_KEYWORD_26_in_rulePropertySet333); 

                	newLeafNode(otherlv_12, grammarAccess.getPropertySetAccess().getEndKeyword_6());
                
            this_ID_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePropertySet343); 
             
                newLeafNode(this_ID_13, grammarAccess.getPropertySetAccess().getIDTerminalRuleCall_7()); 
                
            otherlv_14=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_rulePropertySet355); 

                	newLeafNode(otherlv_14, grammarAccess.getPropertySetAccess().getSemicolonKeyword_8());
                

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:227:1: entryRulePropertyType returns [EObject current=null] : iv_rulePropertyType= rulePropertyType EOF ;
    public final EObject entryRulePropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:228:2: (iv_rulePropertyType= rulePropertyType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:229:2: iv_rulePropertyType= rulePropertyType EOF
            {
             newCompositeNode(grammarAccess.getPropertyTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertyType_in_entryRulePropertyType389);
            iv_rulePropertyType=rulePropertyType();

            state._fsp--;

             current =iv_rulePropertyType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyType399); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:236:1: rulePropertyType returns [EObject current=null] : ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= KEYWORD_9 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:239:28: ( ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:240:1: ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:240:1: ( (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:240:2: (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType ) otherlv_10= KEYWORD_9
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:240:2: (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType )
            int alt4=10;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:241:5: this_BooleanType_0= ruleBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getBooleanTypeParserRuleCall_0_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_rulePropertyType447);
                    this_BooleanType_0=ruleBooleanType();

                    state._fsp--;


                            current = this_BooleanType_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:251:5: this_StringType_1= ruleStringType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getStringTypeParserRuleCall_0_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringType_in_rulePropertyType474);
                    this_StringType_1=ruleStringType();

                    state._fsp--;


                            current = this_StringType_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:261:5: this_EnumerationType_2= ruleEnumerationType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getEnumerationTypeParserRuleCall_0_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumerationType_in_rulePropertyType501);
                    this_EnumerationType_2=ruleEnumerationType();

                    state._fsp--;


                            current = this_EnumerationType_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:271:5: this_UnitsType_3= ruleUnitsType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getUnitsTypeParserRuleCall_0_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnitsType_in_rulePropertyType528);
                    this_UnitsType_3=ruleUnitsType();

                    state._fsp--;


                            current = this_UnitsType_3;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:281:5: this_RealType_4= ruleRealType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getRealTypeParserRuleCall_0_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRealType_in_rulePropertyType555);
                    this_RealType_4=ruleRealType();

                    state._fsp--;


                            current = this_RealType_4;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:291:5: this_IntegerType_5= ruleIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getIntegerTypeParserRuleCall_0_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_rulePropertyType582);
                    this_IntegerType_5=ruleIntegerType();

                    state._fsp--;


                            current = this_IntegerType_5;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:301:5: this_RangeType_6= ruleRangeType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getRangeTypeParserRuleCall_0_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRangeType_in_rulePropertyType609);
                    this_RangeType_6=ruleRangeType();

                    state._fsp--;


                            current = this_RangeType_6;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:311:5: this_ClassifierType_7= ruleClassifierType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getClassifierTypeParserRuleCall_0_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleClassifierType_in_rulePropertyType636);
                    this_ClassifierType_7=ruleClassifierType();

                    state._fsp--;


                            current = this_ClassifierType_7;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:321:5: this_ReferenceType_8= ruleReferenceType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getReferenceTypeParserRuleCall_0_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_rulePropertyType663);
                    this_ReferenceType_8=ruleReferenceType();

                    state._fsp--;


                            current = this_ReferenceType_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:331:5: this_RecordType_9= ruleRecordType
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyTypeAccess().getRecordTypeParserRuleCall_0_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecordType_in_rulePropertyType690);
                    this_RecordType_9=ruleRecordType();

                    state._fsp--;


                            current = this_RecordType_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            otherlv_10=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_rulePropertyType703); 

                	newLeafNode(otherlv_10, grammarAccess.getPropertyTypeAccess().getSemicolonKeyword_1());
                

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


    // $ANTLR start "entryRuleUnnamedPropertyType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:352:1: entryRuleUnnamedPropertyType returns [EObject current=null] : iv_ruleUnnamedPropertyType= ruleUnnamedPropertyType EOF ;
    public final EObject entryRuleUnnamedPropertyType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedPropertyType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:353:2: (iv_ruleUnnamedPropertyType= ruleUnnamedPropertyType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:354:2: iv_ruleUnnamedPropertyType= ruleUnnamedPropertyType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedPropertyTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedPropertyType_in_entryRuleUnnamedPropertyType737);
            iv_ruleUnnamedPropertyType=ruleUnnamedPropertyType();

            state._fsp--;

             current =iv_ruleUnnamedPropertyType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedPropertyType747); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:361:1: ruleUnnamedPropertyType returns [EObject current=null] : (this_ListType_0= ruleListType | this_UnnamedBooleanType_1= ruleUnnamedBooleanType | this_UnnamedStringType_2= ruleUnnamedStringType | this_UnnamedEnumerationType_3= ruleUnnamedEnumerationType | this_UnnamedUnitsType_4= ruleUnnamedUnitsType | this_UnnamedRealType_5= ruleUnnamedRealType | this_UnnamedIntegerType_6= ruleUnnamedIntegerType | this_UnnamedRangeType_7= ruleUnnamedRangeType | this_UnnamedClassifierType_8= ruleUnnamedClassifierType | this_UnnamedReferenceType_9= ruleUnnamedReferenceType | this_UnnamedRecordType_10= ruleUnnamedRecordType ) ;
    public final EObject ruleUnnamedPropertyType() throws RecognitionException {
        EObject current = null;

        EObject this_ListType_0 = null;

        EObject this_UnnamedBooleanType_1 = null;

        EObject this_UnnamedStringType_2 = null;

        EObject this_UnnamedEnumerationType_3 = null;

        EObject this_UnnamedUnitsType_4 = null;

        EObject this_UnnamedRealType_5 = null;

        EObject this_UnnamedIntegerType_6 = null;

        EObject this_UnnamedRangeType_7 = null;

        EObject this_UnnamedClassifierType_8 = null;

        EObject this_UnnamedReferenceType_9 = null;

        EObject this_UnnamedRecordType_10 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:364:28: ( (this_ListType_0= ruleListType | this_UnnamedBooleanType_1= ruleUnnamedBooleanType | this_UnnamedStringType_2= ruleUnnamedStringType | this_UnnamedEnumerationType_3= ruleUnnamedEnumerationType | this_UnnamedUnitsType_4= ruleUnnamedUnitsType | this_UnnamedRealType_5= ruleUnnamedRealType | this_UnnamedIntegerType_6= ruleUnnamedIntegerType | this_UnnamedRangeType_7= ruleUnnamedRangeType | this_UnnamedClassifierType_8= ruleUnnamedClassifierType | this_UnnamedReferenceType_9= ruleUnnamedReferenceType | this_UnnamedRecordType_10= ruleUnnamedRecordType ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:365:1: (this_ListType_0= ruleListType | this_UnnamedBooleanType_1= ruleUnnamedBooleanType | this_UnnamedStringType_2= ruleUnnamedStringType | this_UnnamedEnumerationType_3= ruleUnnamedEnumerationType | this_UnnamedUnitsType_4= ruleUnnamedUnitsType | this_UnnamedRealType_5= ruleUnnamedRealType | this_UnnamedIntegerType_6= ruleUnnamedIntegerType | this_UnnamedRangeType_7= ruleUnnamedRangeType | this_UnnamedClassifierType_8= ruleUnnamedClassifierType | this_UnnamedReferenceType_9= ruleUnnamedReferenceType | this_UnnamedRecordType_10= ruleUnnamedRecordType )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:365:1: (this_ListType_0= ruleListType | this_UnnamedBooleanType_1= ruleUnnamedBooleanType | this_UnnamedStringType_2= ruleUnnamedStringType | this_UnnamedEnumerationType_3= ruleUnnamedEnumerationType | this_UnnamedUnitsType_4= ruleUnnamedUnitsType | this_UnnamedRealType_5= ruleUnnamedRealType | this_UnnamedIntegerType_6= ruleUnnamedIntegerType | this_UnnamedRangeType_7= ruleUnnamedRangeType | this_UnnamedClassifierType_8= ruleUnnamedClassifierType | this_UnnamedReferenceType_9= ruleUnnamedReferenceType | this_UnnamedRecordType_10= ruleUnnamedRecordType )
            int alt5=11;
            switch ( input.LA(1) ) {
            case KEYWORD_31:
                {
                alt5=1;
                }
                break;
            case KEYWORD_71:
                {
                alt5=2;
                }
                break;
            case KEYWORD_68:
                {
                alt5=3;
                }
                break;
            case KEYWORD_73:
                {
                alt5=4;
                }
                break;
            case KEYWORD_45:
                {
                alt5=5;
                }
                break;
            case KEYWORD_60:
                {
                alt5=6;
                }
                break;
            case KEYWORD_72:
                {
                alt5=7;
                }
                break;
            case KEYWORD_44:
                {
                alt5=8;
                }
                break;
            case KEYWORD_69:
                {
                alt5=9;
                }
                break;
            case KEYWORD_67:
                {
                alt5=10;
                }
                break;
            case KEYWORD_50:
                {
                alt5=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:366:5: this_ListType_0= ruleListType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getListTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListType_in_ruleUnnamedPropertyType794);
                    this_ListType_0=ruleListType();

                    state._fsp--;


                            current = this_ListType_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:376:5: this_UnnamedBooleanType_1= ruleUnnamedBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedBooleanType_in_ruleUnnamedPropertyType821);
                    this_UnnamedBooleanType_1=ruleUnnamedBooleanType();

                    state._fsp--;


                            current = this_UnnamedBooleanType_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:386:5: this_UnnamedStringType_2= ruleUnnamedStringType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedStringType_in_ruleUnnamedPropertyType848);
                    this_UnnamedStringType_2=ruleUnnamedStringType();

                    state._fsp--;


                            current = this_UnnamedStringType_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:396:5: this_UnnamedEnumerationType_3= ruleUnnamedEnumerationType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedEnumerationTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedEnumerationType_in_ruleUnnamedPropertyType875);
                    this_UnnamedEnumerationType_3=ruleUnnamedEnumerationType();

                    state._fsp--;


                            current = this_UnnamedEnumerationType_3;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:406:5: this_UnnamedUnitsType_4= ruleUnnamedUnitsType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedUnitsTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedPropertyType902);
                    this_UnnamedUnitsType_4=ruleUnnamedUnitsType();

                    state._fsp--;


                            current = this_UnnamedUnitsType_4;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:416:5: this_UnnamedRealType_5= ruleUnnamedRealType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedRealTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedRealType_in_ruleUnnamedPropertyType929);
                    this_UnnamedRealType_5=ruleUnnamedRealType();

                    state._fsp--;


                            current = this_UnnamedRealType_5;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:426:5: this_UnnamedIntegerType_6= ruleUnnamedIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedIntegerTypeParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedPropertyType956);
                    this_UnnamedIntegerType_6=ruleUnnamedIntegerType();

                    state._fsp--;


                            current = this_UnnamedIntegerType_6;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:436:5: this_UnnamedRangeType_7= ruleUnnamedRangeType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedRangeTypeParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedRangeType_in_ruleUnnamedPropertyType983);
                    this_UnnamedRangeType_7=ruleUnnamedRangeType();

                    state._fsp--;


                            current = this_UnnamedRangeType_7;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:446:5: this_UnnamedClassifierType_8= ruleUnnamedClassifierType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedClassifierTypeParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedClassifierType_in_ruleUnnamedPropertyType1010);
                    this_UnnamedClassifierType_8=ruleUnnamedClassifierType();

                    state._fsp--;


                            current = this_UnnamedClassifierType_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:456:5: this_UnnamedReferenceType_9= ruleUnnamedReferenceType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedReferenceTypeParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedReferenceType_in_ruleUnnamedPropertyType1037);
                    this_UnnamedReferenceType_9=ruleUnnamedReferenceType();

                    state._fsp--;


                            current = this_UnnamedReferenceType_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:466:5: this_UnnamedRecordType_10= ruleUnnamedRecordType
                    {
                     
                            newCompositeNode(grammarAccess.getUnnamedPropertyTypeAccess().getUnnamedRecordTypeParserRuleCall_10()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedRecordType_in_ruleUnnamedPropertyType1064);
                    this_UnnamedRecordType_10=ruleUnnamedRecordType();

                    state._fsp--;


                            current = this_UnnamedRecordType_10;
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
    // $ANTLR end "ruleUnnamedPropertyType"


    // $ANTLR start "entryRuleBooleanType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:482:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:483:2: (iv_ruleBooleanType= ruleBooleanType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:484:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_entryRuleBooleanType1098);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanType1108); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:491:1: ruleBooleanType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_71 ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:494:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_71 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:495:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_71 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:495:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_71 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:495:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_71
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:495:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:496:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:496:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:497:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBooleanType1150); 

            			newLeafNode(lv_name_0_0, grammarAccess.getBooleanTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleBooleanType1168); 

                	newLeafNode(otherlv_1, grammarAccess.getBooleanTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleBooleanType1180); 

                	newLeafNode(otherlv_2, grammarAccess.getBooleanTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_71,FollowSets000.FOLLOW_KEYWORD_71_in_ruleBooleanType1192); 

                	newLeafNode(otherlv_3, grammarAccess.getBooleanTypeAccess().getAadlbooleanKeyword_3());
                

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
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleUnnamedBooleanType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:536:1: entryRuleUnnamedBooleanType returns [EObject current=null] : iv_ruleUnnamedBooleanType= ruleUnnamedBooleanType EOF ;
    public final EObject entryRuleUnnamedBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedBooleanType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:537:2: (iv_ruleUnnamedBooleanType= ruleUnnamedBooleanType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:538:2: iv_ruleUnnamedBooleanType= ruleUnnamedBooleanType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedBooleanType_in_entryRuleUnnamedBooleanType1226);
            iv_ruleUnnamedBooleanType=ruleUnnamedBooleanType();

            state._fsp--;

             current =iv_ruleUnnamedBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedBooleanType1236); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:545:1: ruleUnnamedBooleanType returns [EObject current=null] : ( () otherlv_1= KEYWORD_71 ) ;
    public final EObject ruleUnnamedBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:548:28: ( ( () otherlv_1= KEYWORD_71 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:549:1: ( () otherlv_1= KEYWORD_71 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:549:1: ( () otherlv_1= KEYWORD_71 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:549:2: () otherlv_1= KEYWORD_71
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:549:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:550:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedBooleanTypeAccess().getAadlBooleanAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_71,FollowSets000.FOLLOW_KEYWORD_71_in_ruleUnnamedBooleanType1283); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedBooleanTypeAccess().getAadlbooleanKeyword_1());
                

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
    // $ANTLR end "ruleUnnamedBooleanType"


    // $ANTLR start "entryRuleStringType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:568:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:569:2: (iv_ruleStringType= ruleStringType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:570:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringType_in_entryRuleStringType1317);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringType1327); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:577:1: ruleStringType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_68 ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:580:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_68 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:581:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_68 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:581:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_68 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:581:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_68
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:581:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:582:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:582:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:583:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStringType1369); 

            			newLeafNode(lv_name_0_0, grammarAccess.getStringTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleStringType1387); 

                	newLeafNode(otherlv_1, grammarAccess.getStringTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleStringType1399); 

                	newLeafNode(otherlv_2, grammarAccess.getStringTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_68,FollowSets000.FOLLOW_KEYWORD_68_in_ruleStringType1411); 

                	newLeafNode(otherlv_3, grammarAccess.getStringTypeAccess().getAadlstringKeyword_3());
                

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
    // $ANTLR end "ruleStringType"


    // $ANTLR start "entryRuleUnnamedStringType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:622:1: entryRuleUnnamedStringType returns [EObject current=null] : iv_ruleUnnamedStringType= ruleUnnamedStringType EOF ;
    public final EObject entryRuleUnnamedStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedStringType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:623:2: (iv_ruleUnnamedStringType= ruleUnnamedStringType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:624:2: iv_ruleUnnamedStringType= ruleUnnamedStringType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedStringType_in_entryRuleUnnamedStringType1445);
            iv_ruleUnnamedStringType=ruleUnnamedStringType();

            state._fsp--;

             current =iv_ruleUnnamedStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedStringType1455); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:631:1: ruleUnnamedStringType returns [EObject current=null] : ( () otherlv_1= KEYWORD_68 ) ;
    public final EObject ruleUnnamedStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:634:28: ( ( () otherlv_1= KEYWORD_68 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:635:1: ( () otherlv_1= KEYWORD_68 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:635:1: ( () otherlv_1= KEYWORD_68 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:635:2: () otherlv_1= KEYWORD_68
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:635:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:636:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedStringTypeAccess().getAadlStringAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_68,FollowSets000.FOLLOW_KEYWORD_68_in_ruleUnnamedStringType1502); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedStringTypeAccess().getAadlstringKeyword_1());
                

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
    // $ANTLR end "ruleUnnamedStringType"


    // $ANTLR start "entryRuleEnumerationType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:654:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:655:2: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:656:2: iv_ruleEnumerationType= ruleEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getEnumerationTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumerationType_in_entryRuleEnumerationType1536);
            iv_ruleEnumerationType=ruleEnumerationType();

            state._fsp--;

             current =iv_ruleEnumerationType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumerationType1546); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:663:1: ruleEnumerationType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_73 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= KEYWORD_2 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:666:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_73 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:667:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_73 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:667:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_73 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:667:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_73 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )* otherlv_8= KEYWORD_2
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:667:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:668:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:668:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:669:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumerationType1588); 

            			newLeafNode(lv_name_0_0, grammarAccess.getEnumerationTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleEnumerationType1606); 

                	newLeafNode(otherlv_1, grammarAccess.getEnumerationTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleEnumerationType1618); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_73,FollowSets000.FOLLOW_KEYWORD_73_in_ruleEnumerationType1630); 

                	newLeafNode(otherlv_3, grammarAccess.getEnumerationTypeAccess().getEnumerationKeyword_3());
                
            otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleEnumerationType1642); 

                	newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeAccess().getLeftParenthesisKeyword_4());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:705:1: ( (lv_ownedLiteral_5_0= ruleEnumerationLiteral ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:706:1: (lv_ownedLiteral_5_0= ruleEnumerationLiteral )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:706:1: (lv_ownedLiteral_5_0= ruleEnumerationLiteral )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:707:3: lv_ownedLiteral_5_0= ruleEnumerationLiteral
            {
             
            	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1662);
            lv_ownedLiteral_5_0=ruleEnumerationLiteral();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:723:2: (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==KEYWORD_5) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:724:2: otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) )
            	    {
            	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleEnumerationType1676); 

            	        	newLeafNode(otherlv_6, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:728:1: ( (lv_ownedLiteral_7_0= ruleEnumerationLiteral ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:729:1: (lv_ownedLiteral_7_0= ruleEnumerationLiteral )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:729:1: (lv_ownedLiteral_7_0= ruleEnumerationLiteral )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:730:3: lv_ownedLiteral_7_0= ruleEnumerationLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_6_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1696);
            	    lv_ownedLiteral_7_0=ruleEnumerationLiteral();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleEnumerationType1711); 

                	newLeafNode(otherlv_8, grammarAccess.getEnumerationTypeAccess().getRightParenthesisKeyword_7());
                

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
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleUnnamedEnumerationType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:759:1: entryRuleUnnamedEnumerationType returns [EObject current=null] : iv_ruleUnnamedEnumerationType= ruleUnnamedEnumerationType EOF ;
    public final EObject entryRuleUnnamedEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedEnumerationType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:760:2: (iv_ruleUnnamedEnumerationType= ruleUnnamedEnumerationType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:761:2: iv_ruleUnnamedEnumerationType= ruleUnnamedEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedEnumerationTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedEnumerationType_in_entryRuleUnnamedEnumerationType1745);
            iv_ruleUnnamedEnumerationType=ruleUnnamedEnumerationType();

            state._fsp--;

             current =iv_ruleUnnamedEnumerationType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedEnumerationType1755); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:768:1: ruleUnnamedEnumerationType returns [EObject current=null] : (otherlv_0= KEYWORD_73 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= KEYWORD_2 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:771:28: ( (otherlv_0= KEYWORD_73 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:772:1: (otherlv_0= KEYWORD_73 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:772:1: (otherlv_0= KEYWORD_73 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:773:2: otherlv_0= KEYWORD_73 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )* otherlv_5= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_73,FollowSets000.FOLLOW_KEYWORD_73_in_ruleUnnamedEnumerationType1793); 

                	newLeafNode(otherlv_0, grammarAccess.getUnnamedEnumerationTypeAccess().getEnumerationKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleUnnamedEnumerationType1805); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedEnumerationTypeAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:782:1: ( (lv_ownedLiteral_2_0= ruleEnumerationLiteral ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:783:1: (lv_ownedLiteral_2_0= ruleEnumerationLiteral )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:783:1: (lv_ownedLiteral_2_0= ruleEnumerationLiteral )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:784:3: lv_ownedLiteral_2_0= ruleEnumerationLiteral
            {
             
            	        newCompositeNode(grammarAccess.getUnnamedEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1825);
            lv_ownedLiteral_2_0=ruleEnumerationLiteral();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:800:2: (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==KEYWORD_5) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:801:2: otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleUnnamedEnumerationType1839); 

            	        	newLeafNode(otherlv_3, grammarAccess.getUnnamedEnumerationTypeAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:805:1: ( (lv_ownedLiteral_4_0= ruleEnumerationLiteral ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:806:1: (lv_ownedLiteral_4_0= ruleEnumerationLiteral )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:806:1: (lv_ownedLiteral_4_0= ruleEnumerationLiteral )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:807:3: lv_ownedLiteral_4_0= ruleEnumerationLiteral
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnnamedEnumerationTypeAccess().getOwnedLiteralEnumerationLiteralParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1859);
            	    lv_ownedLiteral_4_0=ruleEnumerationLiteral();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleUnnamedEnumerationType1874); 

                	newLeafNode(otherlv_5, grammarAccess.getUnnamedEnumerationTypeAccess().getRightParenthesisKeyword_4());
                

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
    // $ANTLR end "ruleUnnamedEnumerationType"


    // $ANTLR start "entryRuleEnumerationLiteral"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:836:1: entryRuleEnumerationLiteral returns [EObject current=null] : iv_ruleEnumerationLiteral= ruleEnumerationLiteral EOF ;
    public final EObject entryRuleEnumerationLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:837:2: (iv_ruleEnumerationLiteral= ruleEnumerationLiteral EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:838:2: iv_ruleEnumerationLiteral= ruleEnumerationLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumerationLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumerationLiteral_in_entryRuleEnumerationLiteral1908);
            iv_ruleEnumerationLiteral=ruleEnumerationLiteral();

            state._fsp--;

             current =iv_ruleEnumerationLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumerationLiteral1918); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:845:1: ruleEnumerationLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumerationLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:848:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:849:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:849:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:850:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:850:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:851:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumerationLiteral1959); 

            			newLeafNode(lv_name_0_0, grammarAccess.getEnumerationLiteralAccess().getNameIDTerminalRuleCall_0()); 
            		

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
    // $ANTLR end "ruleEnumerationLiteral"


    // $ANTLR start "entryRuleUnitsType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:875:1: entryRuleUnitsType returns [EObject current=null] : iv_ruleUnitsType= ruleUnitsType EOF ;
    public final EObject entryRuleUnitsType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitsType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:876:2: (iv_ruleUnitsType= ruleUnitsType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:877:2: iv_ruleUnitsType= ruleUnitsType EOF
            {
             newCompositeNode(grammarAccess.getUnitsTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnitsType_in_entryRuleUnitsType1998);
            iv_ruleUnitsType=ruleUnitsType();

            state._fsp--;

             current =iv_ruleUnitsType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnitsType2008); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:884:1: ruleUnitsType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_45 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= KEYWORD_2 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:887:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_45 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:888:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_45 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:888:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_45 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:888:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_45 otherlv_4= KEYWORD_1 ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) ) (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )* otherlv_8= KEYWORD_2
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:888:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:889:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:889:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:890:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnitsType2050); 

            			newLeafNode(lv_name_0_0, grammarAccess.getUnitsTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleUnitsType2068); 

                	newLeafNode(otherlv_1, grammarAccess.getUnitsTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleUnitsType2080); 

                	newLeafNode(otherlv_2, grammarAccess.getUnitsTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_45,FollowSets000.FOLLOW_KEYWORD_45_in_ruleUnitsType2092); 

                	newLeafNode(otherlv_3, grammarAccess.getUnitsTypeAccess().getUnitsKeyword_3());
                
            otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleUnitsType2104); 

                	newLeafNode(otherlv_4, grammarAccess.getUnitsTypeAccess().getLeftParenthesisKeyword_4());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:926:1: ( (lv_ownedLiteral_5_0= ruleUnitLiteral ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:927:1: (lv_ownedLiteral_5_0= ruleUnitLiteral )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:927:1: (lv_ownedLiteral_5_0= ruleUnitLiteral )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:928:3: lv_ownedLiteral_5_0= ruleUnitLiteral
            {
             
            	        newCompositeNode(grammarAccess.getUnitsTypeAccess().getOwnedLiteralUnitLiteralParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleUnitLiteral_in_ruleUnitsType2124);
            lv_ownedLiteral_5_0=ruleUnitLiteral();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:944:2: (otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==KEYWORD_5) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:945:2: otherlv_6= KEYWORD_5 ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) )
            	    {
            	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleUnitsType2138); 

            	        	newLeafNode(otherlv_6, grammarAccess.getUnitsTypeAccess().getCommaKeyword_6_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:949:1: ( (lv_ownedLiteral_7_0= ruleUnitLiteralConversion ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:950:1: (lv_ownedLiteral_7_0= ruleUnitLiteralConversion )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:950:1: (lv_ownedLiteral_7_0= ruleUnitLiteralConversion )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:951:3: lv_ownedLiteral_7_0= ruleUnitLiteralConversion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnitsTypeAccess().getOwnedLiteralUnitLiteralConversionParserRuleCall_6_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleUnitLiteralConversion_in_ruleUnitsType2158);
            	    lv_ownedLiteral_7_0=ruleUnitLiteralConversion();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleUnitsType2173); 

                	newLeafNode(otherlv_8, grammarAccess.getUnitsTypeAccess().getRightParenthesisKeyword_7());
                

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
    // $ANTLR end "ruleUnitsType"


    // $ANTLR start "entryRuleUnnamedUnitsType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:980:1: entryRuleUnnamedUnitsType returns [EObject current=null] : iv_ruleUnnamedUnitsType= ruleUnnamedUnitsType EOF ;
    public final EObject entryRuleUnnamedUnitsType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedUnitsType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:981:2: (iv_ruleUnnamedUnitsType= ruleUnnamedUnitsType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:982:2: iv_ruleUnnamedUnitsType= ruleUnnamedUnitsType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedUnitsTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedUnitsType_in_entryRuleUnnamedUnitsType2207);
            iv_ruleUnnamedUnitsType=ruleUnnamedUnitsType();

            state._fsp--;

             current =iv_ruleUnnamedUnitsType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedUnitsType2217); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:989:1: ruleUnnamedUnitsType returns [EObject current=null] : (otherlv_0= KEYWORD_45 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= KEYWORD_2 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:992:28: ( (otherlv_0= KEYWORD_45 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:993:1: (otherlv_0= KEYWORD_45 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:993:1: (otherlv_0= KEYWORD_45 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:994:2: otherlv_0= KEYWORD_45 otherlv_1= KEYWORD_1 ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) ) (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )* otherlv_5= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_45,FollowSets000.FOLLOW_KEYWORD_45_in_ruleUnnamedUnitsType2255); 

                	newLeafNode(otherlv_0, grammarAccess.getUnnamedUnitsTypeAccess().getUnitsKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleUnnamedUnitsType2267); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedUnitsTypeAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1003:1: ( (lv_ownedLiteral_2_0= ruleUnitLiteral ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1004:1: (lv_ownedLiteral_2_0= ruleUnitLiteral )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1004:1: (lv_ownedLiteral_2_0= ruleUnitLiteral )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1005:3: lv_ownedLiteral_2_0= ruleUnitLiteral
            {
             
            	        newCompositeNode(grammarAccess.getUnnamedUnitsTypeAccess().getOwnedLiteralUnitLiteralParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleUnitLiteral_in_ruleUnnamedUnitsType2287);
            lv_ownedLiteral_2_0=ruleUnitLiteral();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1021:2: (otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==KEYWORD_5) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1022:2: otherlv_3= KEYWORD_5 ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleUnnamedUnitsType2301); 

            	        	newLeafNode(otherlv_3, grammarAccess.getUnnamedUnitsTypeAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1026:1: ( (lv_ownedLiteral_4_0= ruleUnitLiteralConversion ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1027:1: (lv_ownedLiteral_4_0= ruleUnitLiteralConversion )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1027:1: (lv_ownedLiteral_4_0= ruleUnitLiteralConversion )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1028:3: lv_ownedLiteral_4_0= ruleUnitLiteralConversion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnnamedUnitsTypeAccess().getOwnedLiteralUnitLiteralConversionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleUnitLiteralConversion_in_ruleUnnamedUnitsType2321);
            	    lv_ownedLiteral_4_0=ruleUnitLiteralConversion();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleUnnamedUnitsType2336); 

                	newLeafNode(otherlv_5, grammarAccess.getUnnamedUnitsTypeAccess().getRightParenthesisKeyword_4());
                

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
    // $ANTLR end "ruleUnnamedUnitsType"


    // $ANTLR start "entryRuleUnitLiteral"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1057:1: entryRuleUnitLiteral returns [EObject current=null] : iv_ruleUnitLiteral= ruleUnitLiteral EOF ;
    public final EObject entryRuleUnitLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1058:2: (iv_ruleUnitLiteral= ruleUnitLiteral EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1059:2: iv_ruleUnitLiteral= ruleUnitLiteral EOF
            {
             newCompositeNode(grammarAccess.getUnitLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnitLiteral_in_entryRuleUnitLiteral2370);
            iv_ruleUnitLiteral=ruleUnitLiteral();

            state._fsp--;

             current =iv_ruleUnitLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnitLiteral2380); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1066:1: ruleUnitLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleUnitLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1069:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1070:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1070:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1071:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1071:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1072:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnitLiteral2421); 

            			newLeafNode(lv_name_0_0, grammarAccess.getUnitLiteralAccess().getNameIDTerminalRuleCall_0()); 
            		

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
    // $ANTLR end "ruleUnitLiteral"


    // $ANTLR start "entryRuleUnitLiteralConversion"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1096:1: entryRuleUnitLiteralConversion returns [EObject current=null] : iv_ruleUnitLiteralConversion= ruleUnitLiteralConversion EOF ;
    public final EObject entryRuleUnitLiteralConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitLiteralConversion = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1097:2: (iv_ruleUnitLiteralConversion= ruleUnitLiteralConversion EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1098:2: iv_ruleUnitLiteralConversion= ruleUnitLiteralConversion EOF
            {
             newCompositeNode(grammarAccess.getUnitLiteralConversionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnitLiteralConversion_in_entryRuleUnitLiteralConversion2460);
            iv_ruleUnitLiteralConversion=ruleUnitLiteralConversion();

            state._fsp--;

             current =iv_ruleUnitLiteralConversion; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnitLiteralConversion2470); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1105:1: ruleUnitLiteralConversion returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) ) ;
    public final EObject ruleUnitLiteralConversion() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_factor_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1108:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1109:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1109:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1109:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (otherlv_2= RULE_ID ) ) ruleSTAR ( (lv_factor_4_0= ruleNumberValue ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1109:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1110:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1110:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1111:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2512); 

            			newLeafNode(lv_name_0_0, grammarAccess.getUnitLiteralConversionAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_16,FollowSets000.FOLLOW_KEYWORD_16_in_ruleUnitLiteralConversion2530); 

                	newLeafNode(otherlv_1, grammarAccess.getUnitLiteralConversionAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1132:1: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1133:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1133:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1134:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getUnitLiteralConversionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2549); 

            		newLeafNode(otherlv_2, grammarAccess.getUnitLiteralConversionAccess().getBaseUnitUnitLiteralCrossReference_2_0()); 
            	

            }


            }

             
                    newCompositeNode(grammarAccess.getUnitLiteralConversionAccess().getSTARParserRuleCall_3()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleUnitLiteralConversion2565);
            ruleSTAR();

            state._fsp--;


                    afterParserOrEnumRuleCall();
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1153:1: ( (lv_factor_4_0= ruleNumberValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1154:1: (lv_factor_4_0= ruleNumberValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1154:1: (lv_factor_4_0= ruleNumberValue )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1155:3: lv_factor_4_0= ruleNumberValue
            {
             
            	        newCompositeNode(grammarAccess.getUnitLiteralConversionAccess().getFactorNumberValueParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumberValue_in_ruleUnitLiteralConversion2585);
            lv_factor_4_0=ruleNumberValue();

            state._fsp--;


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
    // $ANTLR end "ruleUnitLiteralConversion"


    // $ANTLR start "entryRuleRealType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1179:1: entryRuleRealType returns [EObject current=null] : iv_ruleRealType= ruleRealType EOF ;
    public final EObject entryRuleRealType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1180:2: (iv_ruleRealType= ruleRealType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1181:2: iv_ruleRealType= ruleRealType EOF
            {
             newCompositeNode(grammarAccess.getRealTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRealType_in_entryRuleRealType2620);
            iv_ruleRealType=ruleRealType();

            state._fsp--;

             current =iv_ruleRealType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealType2630); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1188:1: ruleRealType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_60 ( (lv_range_4_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) ;
    public final EObject ruleRealType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_range_4_0 = null;

        EObject lv_ownedUnitsType_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1191:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_60 ( (lv_range_4_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1192:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_60 ( (lv_range_4_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1192:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_60 ( (lv_range_4_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1192:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_60 ( (lv_range_4_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1192:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1193:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1193:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1194:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRealType2672); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRealTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleRealType2690); 

                	newLeafNode(otherlv_1, grammarAccess.getRealTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleRealType2702); 

                	newLeafNode(otherlv_2, grammarAccess.getRealTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_60,FollowSets000.FOLLOW_KEYWORD_60_in_ruleRealType2714); 

                	newLeafNode(otherlv_3, grammarAccess.getRealTypeAccess().getAadlrealKeyword_3());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1225:1: ( (lv_range_4_0= ruleRealRange ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==KEYWORD_4||LA10_0==KEYWORD_6||LA10_0==RULE_REAL_LIT||LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1226:1: (lv_range_4_0= ruleRealRange )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1226:1: (lv_range_4_0= ruleRealRange )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1227:3: lv_range_4_0= ruleRealRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealTypeAccess().getRangeRealRangeParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRealRange_in_ruleRealType2734);
                    lv_range_4_0=ruleRealRange();

                    state._fsp--;


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
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1243:3: ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==KEYWORD_45) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_ID) ) {
                    alt11=2;
                }
                else if ( (LA11_1==KEYWORD_1) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1243:4: ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1243:4: ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1244:1: (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1244:1: (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1245:3: lv_ownedUnitsType_5_0= ruleUnnamedUnitsType
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealTypeAccess().getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedUnitsType_in_ruleRealType2757);
                    lv_ownedUnitsType_5_0=ruleUnnamedUnitsType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRealTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedUnitsType",
                            		lv_ownedUnitsType_5_0, 
                            		"UnnamedUnitsType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1262:6: (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1262:6: (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1263:2: otherlv_6= KEYWORD_45 ( ( ruleQPREF ) )
                    {
                    otherlv_6=(Token)match(input,KEYWORD_45,FollowSets000.FOLLOW_KEYWORD_45_in_ruleRealType2777); 

                        	newLeafNode(otherlv_6, grammarAccess.getRealTypeAccess().getUnitsKeyword_5_1_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1267:1: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1268:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1268:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1269:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRealTypeAccess().getUnitsTypeUnitsTypeCrossReference_5_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleRealType2799);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleRealType"


    // $ANTLR start "entryRuleUnnamedRealType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1290:1: entryRuleUnnamedRealType returns [EObject current=null] : iv_ruleUnnamedRealType= ruleUnnamedRealType EOF ;
    public final EObject entryRuleUnnamedRealType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedRealType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1291:2: (iv_ruleUnnamedRealType= ruleUnnamedRealType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1292:2: iv_ruleUnnamedRealType= ruleUnnamedRealType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedRealTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedRealType_in_entryRuleUnnamedRealType2837);
            iv_ruleUnnamedRealType=ruleUnnamedRealType();

            state._fsp--;

             current =iv_ruleUnnamedRealType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedRealType2847); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1299:1: ruleUnnamedRealType returns [EObject current=null] : ( () otherlv_1= KEYWORD_60 ( (lv_range_2_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) ;
    public final EObject ruleUnnamedRealType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_range_2_0 = null;

        EObject lv_ownedUnitsType_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1302:28: ( ( () otherlv_1= KEYWORD_60 ( (lv_range_2_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1303:1: ( () otherlv_1= KEYWORD_60 ( (lv_range_2_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1303:1: ( () otherlv_1= KEYWORD_60 ( (lv_range_2_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1303:2: () otherlv_1= KEYWORD_60 ( (lv_range_2_0= ruleRealRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1303:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1304:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedRealTypeAccess().getAadlRealAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_60,FollowSets000.FOLLOW_KEYWORD_60_in_ruleUnnamedRealType2894); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedRealTypeAccess().getAadlrealKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1314:1: ( (lv_range_2_0= ruleRealRange ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==KEYWORD_4||LA12_0==KEYWORD_6||LA12_0==RULE_REAL_LIT||LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1315:1: (lv_range_2_0= ruleRealRange )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1315:1: (lv_range_2_0= ruleRealRange )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1316:3: lv_range_2_0= ruleRealRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnnamedRealTypeAccess().getRangeRealRangeParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRealRange_in_ruleUnnamedRealType2914);
                    lv_range_2_0=ruleRealRange();

                    state._fsp--;


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
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1332:3: ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==KEYWORD_45) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==KEYWORD_1) ) {
                    alt13=1;
                }
                else if ( (LA13_1==RULE_ID) ) {
                    alt13=2;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1332:4: ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1332:4: ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1333:1: (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1333:1: (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1334:3: lv_ownedUnitsType_3_0= ruleUnnamedUnitsType
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnnamedRealTypeAccess().getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedRealType2937);
                    lv_ownedUnitsType_3_0=ruleUnnamedUnitsType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnnamedRealTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedUnitsType",
                            		lv_ownedUnitsType_3_0, 
                            		"UnnamedUnitsType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1351:6: (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1351:6: (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1352:2: otherlv_4= KEYWORD_45 ( ( ruleQPREF ) )
                    {
                    otherlv_4=(Token)match(input,KEYWORD_45,FollowSets000.FOLLOW_KEYWORD_45_in_ruleUnnamedRealType2957); 

                        	newLeafNode(otherlv_4, grammarAccess.getUnnamedRealTypeAccess().getUnitsKeyword_3_1_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1356:1: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1357:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1357:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1358:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getUnnamedRealTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getUnnamedRealTypeAccess().getUnitsTypeUnitsTypeCrossReference_3_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleUnnamedRealType2979);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleUnnamedRealType"


    // $ANTLR start "entryRuleIntegerType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1379:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1380:2: (iv_ruleIntegerType= ruleIntegerType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1381:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_entryRuleIntegerType3017);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerType3027); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1388:1: ruleIntegerType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_72 ( (lv_range_4_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_range_4_0 = null;

        EObject lv_ownedUnitsType_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1391:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_72 ( (lv_range_4_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1392:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_72 ( (lv_range_4_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1392:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_72 ( (lv_range_4_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1392:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_72 ( (lv_range_4_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1392:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1393:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1393:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1394:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIntegerType3069); 

            			newLeafNode(lv_name_0_0, grammarAccess.getIntegerTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleIntegerType3087); 

                	newLeafNode(otherlv_1, grammarAccess.getIntegerTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleIntegerType3099); 

                	newLeafNode(otherlv_2, grammarAccess.getIntegerTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_72,FollowSets000.FOLLOW_KEYWORD_72_in_ruleIntegerType3111); 

                	newLeafNode(otherlv_3, grammarAccess.getIntegerTypeAccess().getAadlintegerKeyword_3());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1425:1: ( (lv_range_4_0= ruleIntegerRange ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==KEYWORD_4||LA14_0==KEYWORD_6||LA14_0==RULE_INTEGER_LIT||LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1426:1: (lv_range_4_0= ruleIntegerRange )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1426:1: (lv_range_4_0= ruleIntegerRange )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1427:3: lv_range_4_0= ruleIntegerRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerTypeAccess().getRangeIntegerRangeParserRuleCall_4_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerRange_in_ruleIntegerType3131);
                    lv_range_4_0=ruleIntegerRange();

                    state._fsp--;


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
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1443:3: ( ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) ) | (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==KEYWORD_45) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==RULE_ID) ) {
                    alt15=2;
                }
                else if ( (LA15_1==KEYWORD_1) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1443:4: ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1443:4: ( (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1444:1: (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1444:1: (lv_ownedUnitsType_5_0= ruleUnnamedUnitsType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1445:3: lv_ownedUnitsType_5_0= ruleUnnamedUnitsType
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerTypeAccess().getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedUnitsType_in_ruleIntegerType3154);
                    lv_ownedUnitsType_5_0=ruleUnnamedUnitsType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntegerTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedUnitsType",
                            		lv_ownedUnitsType_5_0, 
                            		"UnnamedUnitsType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1462:6: (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1462:6: (otherlv_6= KEYWORD_45 ( ( ruleQPREF ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1463:2: otherlv_6= KEYWORD_45 ( ( ruleQPREF ) )
                    {
                    otherlv_6=(Token)match(input,KEYWORD_45,FollowSets000.FOLLOW_KEYWORD_45_in_ruleIntegerType3174); 

                        	newLeafNode(otherlv_6, grammarAccess.getIntegerTypeAccess().getUnitsKeyword_5_1_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1467:1: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1468:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1468:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1469:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getIntegerTypeAccess().getUnitsTypeUnitsTypeCrossReference_5_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleIntegerType3196);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleUnnamedIntegerType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1490:1: entryRuleUnnamedIntegerType returns [EObject current=null] : iv_ruleUnnamedIntegerType= ruleUnnamedIntegerType EOF ;
    public final EObject entryRuleUnnamedIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedIntegerType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1491:2: (iv_ruleUnnamedIntegerType= ruleUnnamedIntegerType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1492:2: iv_ruleUnnamedIntegerType= ruleUnnamedIntegerType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedIntegerType_in_entryRuleUnnamedIntegerType3234);
            iv_ruleUnnamedIntegerType=ruleUnnamedIntegerType();

            state._fsp--;

             current =iv_ruleUnnamedIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedIntegerType3244); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1499:1: ruleUnnamedIntegerType returns [EObject current=null] : ( () otherlv_1= KEYWORD_72 ( (lv_range_2_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) ;
    public final EObject ruleUnnamedIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_range_2_0 = null;

        EObject lv_ownedUnitsType_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1502:28: ( ( () otherlv_1= KEYWORD_72 ( (lv_range_2_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1503:1: ( () otherlv_1= KEYWORD_72 ( (lv_range_2_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1503:1: ( () otherlv_1= KEYWORD_72 ( (lv_range_2_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1503:2: () otherlv_1= KEYWORD_72 ( (lv_range_2_0= ruleIntegerRange ) )? ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1503:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1504:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedIntegerTypeAccess().getAadlIntegerAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_72,FollowSets000.FOLLOW_KEYWORD_72_in_ruleUnnamedIntegerType3291); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedIntegerTypeAccess().getAadlintegerKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1514:1: ( (lv_range_2_0= ruleIntegerRange ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==KEYWORD_4||LA16_0==KEYWORD_6||LA16_0==RULE_INTEGER_LIT||LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1515:1: (lv_range_2_0= ruleIntegerRange )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1515:1: (lv_range_2_0= ruleIntegerRange )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1516:3: lv_range_2_0= ruleIntegerRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnnamedIntegerTypeAccess().getRangeIntegerRangeParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerRange_in_ruleUnnamedIntegerType3311);
                    lv_range_2_0=ruleIntegerRange();

                    state._fsp--;


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
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1532:3: ( ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) ) | (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) ) )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==KEYWORD_45) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==RULE_ID) ) {
                    alt17=2;
                }
                else if ( (LA17_1==KEYWORD_1) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1532:4: ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1532:4: ( (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1533:1: (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1533:1: (lv_ownedUnitsType_3_0= ruleUnnamedUnitsType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1534:3: lv_ownedUnitsType_3_0= ruleUnnamedUnitsType
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnnamedIntegerTypeAccess().getOwnedUnitsTypeUnnamedUnitsTypeParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedIntegerType3334);
                    lv_ownedUnitsType_3_0=ruleUnnamedUnitsType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnnamedIntegerTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedUnitsType",
                            		lv_ownedUnitsType_3_0, 
                            		"UnnamedUnitsType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1551:6: (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1551:6: (otherlv_4= KEYWORD_45 ( ( ruleQPREF ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1552:2: otherlv_4= KEYWORD_45 ( ( ruleQPREF ) )
                    {
                    otherlv_4=(Token)match(input,KEYWORD_45,FollowSets000.FOLLOW_KEYWORD_45_in_ruleUnnamedIntegerType3354); 

                        	newLeafNode(otherlv_4, grammarAccess.getUnnamedIntegerTypeAccess().getUnitsKeyword_3_1_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1556:1: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1557:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1557:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1558:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getUnnamedIntegerTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getUnnamedIntegerTypeAccess().getUnitsTypeUnitsTypeCrossReference_3_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleUnnamedIntegerType3376);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleUnnamedIntegerType"


    // $ANTLR start "entryRuleRangeType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1579:1: entryRuleRangeType returns [EObject current=null] : iv_ruleRangeType= ruleRangeType EOF ;
    public final EObject entryRuleRangeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1580:2: (iv_ruleRangeType= ruleRangeType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1581:2: iv_ruleRangeType= ruleRangeType EOF
            {
             newCompositeNode(grammarAccess.getRangeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRangeType_in_entryRuleRangeType3414);
            iv_ruleRangeType=ruleRangeType();

            state._fsp--;

             current =iv_ruleRangeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRangeType3424); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1588:1: ruleRangeType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_44 otherlv_4= KEYWORD_19 ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1591:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_44 otherlv_4= KEYWORD_19 ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1592:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_44 otherlv_4= KEYWORD_19 ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1592:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_44 otherlv_4= KEYWORD_19 ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1592:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_44 otherlv_4= KEYWORD_19 ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1592:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1593:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1593:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1594:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRangeType3466); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRangeTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleRangeType3484); 

                	newLeafNode(otherlv_1, grammarAccess.getRangeTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleRangeType3496); 

                	newLeafNode(otherlv_2, grammarAccess.getRangeTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_44,FollowSets000.FOLLOW_KEYWORD_44_in_ruleRangeType3508); 

                	newLeafNode(otherlv_3, grammarAccess.getRangeTypeAccess().getRangeKeyword_3());
                
            otherlv_4=(Token)match(input,KEYWORD_19,FollowSets000.FOLLOW_KEYWORD_19_in_ruleRangeType3520); 

                	newLeafNode(otherlv_4, grammarAccess.getRangeTypeAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1630:1: ( ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==KEYWORD_72||LA19_0==KEYWORD_60) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1630:2: ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1630:2: ( ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1631:1: ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1631:1: ( (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1632:1: (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1632:1: (lv_ownedNumberType_5_1= ruleUnnamedIntegerType | lv_ownedNumberType_5_2= ruleUnnamedRealType )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==KEYWORD_72) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==KEYWORD_60) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1633:3: lv_ownedNumberType_5_1= ruleUnnamedIntegerType
                            {
                             
                            	        newCompositeNode(grammarAccess.getRangeTypeAccess().getOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_5_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleUnnamedIntegerType_in_ruleRangeType3543);
                            lv_ownedNumberType_5_1=ruleUnnamedIntegerType();

                            state._fsp--;


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
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1648:8: lv_ownedNumberType_5_2= ruleUnnamedRealType
                            {
                             
                            	        newCompositeNode(grammarAccess.getRangeTypeAccess().getOwnedNumberTypeUnnamedRealTypeParserRuleCall_5_0_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleUnnamedRealType_in_ruleRangeType3562);
                            lv_ownedNumberType_5_2=ruleUnnamedRealType();

                            state._fsp--;


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
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1667:6: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1667:6: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1668:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1668:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1669:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRangeTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRangeTypeAccess().getNumberTypeNumberTypeCrossReference_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleRangeType3594);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleRangeType"


    // $ANTLR start "entryRuleUnnamedRangeType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1690:1: entryRuleUnnamedRangeType returns [EObject current=null] : iv_ruleUnnamedRangeType= ruleUnnamedRangeType EOF ;
    public final EObject entryRuleUnnamedRangeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedRangeType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1691:2: (iv_ruleUnnamedRangeType= ruleUnnamedRangeType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1692:2: iv_ruleUnnamedRangeType= ruleUnnamedRangeType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedRangeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedRangeType_in_entryRuleUnnamedRangeType3630);
            iv_ruleUnnamedRangeType=ruleUnnamedRangeType();

            state._fsp--;

             current =iv_ruleUnnamedRangeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedRangeType3640); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1699:1: ruleUnnamedRangeType returns [EObject current=null] : ( () otherlv_1= KEYWORD_44 otherlv_2= KEYWORD_19 ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) ;
    public final EObject ruleUnnamedRangeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedNumberType_3_1 = null;

        EObject lv_ownedNumberType_3_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1702:28: ( ( () otherlv_1= KEYWORD_44 otherlv_2= KEYWORD_19 ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1703:1: ( () otherlv_1= KEYWORD_44 otherlv_2= KEYWORD_19 ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1703:1: ( () otherlv_1= KEYWORD_44 otherlv_2= KEYWORD_19 ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1703:2: () otherlv_1= KEYWORD_44 otherlv_2= KEYWORD_19 ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1703:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1704:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedRangeTypeAccess().getRangeTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_44,FollowSets000.FOLLOW_KEYWORD_44_in_ruleUnnamedRangeType3687); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedRangeTypeAccess().getRangeKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_19,FollowSets000.FOLLOW_KEYWORD_19_in_ruleUnnamedRangeType3699); 

                	newLeafNode(otherlv_2, grammarAccess.getUnnamedRangeTypeAccess().getOfKeyword_2());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1719:1: ( ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) ) | ( ( ruleQPREF ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==KEYWORD_72||LA21_0==KEYWORD_60) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_ID) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1719:2: ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1719:2: ( ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1720:1: ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1720:1: ( (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1721:1: (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1721:1: (lv_ownedNumberType_3_1= ruleUnnamedIntegerType | lv_ownedNumberType_3_2= ruleUnnamedRealType )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==KEYWORD_72) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==KEYWORD_60) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1722:3: lv_ownedNumberType_3_1= ruleUnnamedIntegerType
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnnamedRangeTypeAccess().getOwnedNumberTypeUnnamedIntegerTypeParserRuleCall_3_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedRangeType3722);
                            lv_ownedNumberType_3_1=ruleUnnamedIntegerType();

                            state._fsp--;


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
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1737:8: lv_ownedNumberType_3_2= ruleUnnamedRealType
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnnamedRangeTypeAccess().getOwnedNumberTypeUnnamedRealTypeParserRuleCall_3_0_0_1()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleUnnamedRealType_in_ruleUnnamedRangeType3741);
                            lv_ownedNumberType_3_2=ruleUnnamedRealType();

                            state._fsp--;


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
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1756:6: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1756:6: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1757:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1757:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1758:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getUnnamedRangeTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getUnnamedRangeTypeAccess().getNumberTypeNumberTypeCrossReference_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleUnnamedRangeType3773);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleUnnamedRangeType"


    // $ANTLR start "entryRuleClassifierType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1779:1: entryRuleClassifierType returns [EObject current=null] : iv_ruleClassifierType= ruleClassifierType EOF ;
    public final EObject entryRuleClassifierType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1780:2: (iv_ruleClassifierType= ruleClassifierType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1781:2: iv_ruleClassifierType= ruleClassifierType EOF
            {
             newCompositeNode(grammarAccess.getClassifierTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleClassifierType_in_entryRuleClassifierType3809);
            iv_ruleClassifierType=ruleClassifierType();

            state._fsp--;

             current =iv_ruleClassifierType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleClassifierType3819); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1788:1: ruleClassifierType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_69 (otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? ) ;
    public final EObject ruleClassifierType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_classifierReference_5_0 = null;

        EObject lv_classifierReference_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1791:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_69 (otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1792:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_69 (otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1792:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_69 (otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1792:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_69 (otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1792:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1793:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1793:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1794:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClassifierType3861); 

            			newLeafNode(lv_name_0_0, grammarAccess.getClassifierTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleClassifierType3879); 

                	newLeafNode(otherlv_1, grammarAccess.getClassifierTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleClassifierType3891); 

                	newLeafNode(otherlv_2, grammarAccess.getClassifierTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_69,FollowSets000.FOLLOW_KEYWORD_69_in_ruleClassifierType3903); 

                	newLeafNode(otherlv_3, grammarAccess.getClassifierTypeAccess().getClassifierKeyword_3());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1825:1: (otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==KEYWORD_1) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1826:2: otherlv_4= KEYWORD_1 ( (lv_classifierReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2
                    {
                    otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleClassifierType3916); 

                        	newLeafNode(otherlv_4, grammarAccess.getClassifierTypeAccess().getLeftParenthesisKeyword_4_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1830:1: ( (lv_classifierReference_5_0= ruleQMReference ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1831:1: (lv_classifierReference_5_0= ruleQMReference )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1831:1: (lv_classifierReference_5_0= ruleQMReference )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1832:3: lv_classifierReference_5_0= ruleQMReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassifierTypeAccess().getClassifierReferenceQMReferenceParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleClassifierType3936);
                    lv_classifierReference_5_0=ruleQMReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassifierTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"classifierReference",
                            		lv_classifierReference_5_0, 
                            		"QMReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1848:2: (otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==KEYWORD_5) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1849:2: otherlv_6= KEYWORD_5 ( (lv_classifierReference_7_0= ruleQMReference ) )
                    	    {
                    	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleClassifierType3950); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getClassifierTypeAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1853:1: ( (lv_classifierReference_7_0= ruleQMReference ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1854:1: (lv_classifierReference_7_0= ruleQMReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1854:1: (lv_classifierReference_7_0= ruleQMReference )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1855:3: lv_classifierReference_7_0= ruleQMReference
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClassifierTypeAccess().getClassifierReferenceQMReferenceParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleClassifierType3970);
                    	    lv_classifierReference_7_0=ruleQMReference();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClassifierTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"classifierReference",
                    	            		lv_classifierReference_7_0, 
                    	            		"QMReference");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleClassifierType3985); 

                        	newLeafNode(otherlv_8, grammarAccess.getClassifierTypeAccess().getRightParenthesisKeyword_4_3());
                        

                    }
                    break;

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
    // $ANTLR end "ruleClassifierType"


    // $ANTLR start "entryRuleUnnamedClassifierType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1884:1: entryRuleUnnamedClassifierType returns [EObject current=null] : iv_ruleUnnamedClassifierType= ruleUnnamedClassifierType EOF ;
    public final EObject entryRuleUnnamedClassifierType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedClassifierType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1885:2: (iv_ruleUnnamedClassifierType= ruleUnnamedClassifierType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1886:2: iv_ruleUnnamedClassifierType= ruleUnnamedClassifierType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedClassifierTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedClassifierType_in_entryRuleUnnamedClassifierType4021);
            iv_ruleUnnamedClassifierType=ruleUnnamedClassifierType();

            state._fsp--;

             current =iv_ruleUnnamedClassifierType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedClassifierType4031); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1893:1: ruleUnnamedClassifierType returns [EObject current=null] : ( () otherlv_1= KEYWORD_69 (otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? ) ;
    public final EObject ruleUnnamedClassifierType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_classifierReference_3_0 = null;

        EObject lv_classifierReference_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1896:28: ( ( () otherlv_1= KEYWORD_69 (otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1897:1: ( () otherlv_1= KEYWORD_69 (otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1897:1: ( () otherlv_1= KEYWORD_69 (otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1897:2: () otherlv_1= KEYWORD_69 (otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1897:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1898:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedClassifierTypeAccess().getClassifierTypeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_69,FollowSets000.FOLLOW_KEYWORD_69_in_ruleUnnamedClassifierType4078); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedClassifierTypeAccess().getClassifierKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1908:1: (otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==KEYWORD_1) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1909:2: otherlv_2= KEYWORD_1 ( (lv_classifierReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2
                    {
                    otherlv_2=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleUnnamedClassifierType4091); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnnamedClassifierTypeAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1913:1: ( (lv_classifierReference_3_0= ruleQMReference ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1914:1: (lv_classifierReference_3_0= ruleQMReference )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1914:1: (lv_classifierReference_3_0= ruleQMReference )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1915:3: lv_classifierReference_3_0= ruleQMReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnnamedClassifierTypeAccess().getClassifierReferenceQMReferenceParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleUnnamedClassifierType4111);
                    lv_classifierReference_3_0=ruleQMReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnnamedClassifierTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"classifierReference",
                            		lv_classifierReference_3_0, 
                            		"QMReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1931:2: (otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==KEYWORD_5) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1932:2: otherlv_4= KEYWORD_5 ( (lv_classifierReference_5_0= ruleQMReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleUnnamedClassifierType4125); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getUnnamedClassifierTypeAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1936:1: ( (lv_classifierReference_5_0= ruleQMReference ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1937:1: (lv_classifierReference_5_0= ruleQMReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1937:1: (lv_classifierReference_5_0= ruleQMReference )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1938:3: lv_classifierReference_5_0= ruleQMReference
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getUnnamedClassifierTypeAccess().getClassifierReferenceQMReferenceParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleUnnamedClassifierType4145);
                    	    lv_classifierReference_5_0=ruleQMReference();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getUnnamedClassifierTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"classifierReference",
                    	            		lv_classifierReference_5_0, 
                    	            		"QMReference");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleUnnamedClassifierType4160); 

                        	newLeafNode(otherlv_6, grammarAccess.getUnnamedClassifierTypeAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

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
    // $ANTLR end "ruleUnnamedClassifierType"


    // $ANTLR start "entryRuleQMReference"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1967:1: entryRuleQMReference returns [EObject current=null] : iv_ruleQMReference= ruleQMReference EOF ;
    public final EObject entryRuleQMReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQMReference = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1968:2: (iv_ruleQMReference= ruleQMReference EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1969:2: iv_ruleQMReference= ruleQMReference EOF
            {
             newCompositeNode(grammarAccess.getQMReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_entryRuleQMReference4196);
            iv_ruleQMReference=ruleQMReference();

            state._fsp--;

             current =iv_ruleQMReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQMReference4206); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQMReference"


    // $ANTLR start "ruleQMReference"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1976:1: ruleQMReference returns [EObject current=null] : ( (otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR )? ( ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) ) )+ ) ;
    public final EObject ruleQMReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_annexName_1_0=null;
        Token otherlv_2=null;
        Token lv_metaclassName_5_2=null;
        AntlrDatatypeRuleToken lv_metaclassName_5_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1979:28: ( ( (otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR )? ( ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) ) )+ ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1980:1: ( (otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR )? ( ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) ) )+ )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1980:1: ( (otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR )? ( ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) ) )+ )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1980:2: (otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR )? ( ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) ) )+
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1980:2: (otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==KEYWORD_12) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1981:2: otherlv_0= KEYWORD_12 ( (lv_annexName_1_0= RULE_ID ) ) otherlv_2= KEYWORD_13 ruleSTAR ruleSTAR
                    {
                    otherlv_0=(Token)match(input,KEYWORD_12,FollowSets000.FOLLOW_KEYWORD_12_in_ruleQMReference4245); 

                        	newLeafNode(otherlv_0, grammarAccess.getQMReferenceAccess().getLeftCurlyBracketKeyword_0_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1985:1: ( (lv_annexName_1_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1986:1: (lv_annexName_1_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1986:1: (lv_annexName_1_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:1987:3: lv_annexName_1_0= RULE_ID
                    {
                    lv_annexName_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQMReference4261); 

                    			newLeafNode(lv_annexName_1_0, grammarAccess.getQMReferenceAccess().getAnnexNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQMReferenceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"annexName",
                            		lv_annexName_1_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,KEYWORD_13,FollowSets000.FOLLOW_KEYWORD_13_in_ruleQMReference4279); 

                        	newLeafNode(otherlv_2, grammarAccess.getQMReferenceAccess().getRightCurlyBracketKeyword_0_2());
                        
                     
                            newCompositeNode(grammarAccess.getQMReferenceAccess().getSTARParserRuleCall_0_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleQMReference4294);
                    ruleSTAR();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        
                     
                            newCompositeNode(grammarAccess.getQMReferenceAccess().getSTARParserRuleCall_0_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleQMReference4309);
                    ruleSTAR();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2024:3: ( ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==KEYWORD_74||(LA28_0>=KEYWORD_69 && LA28_0<=KEYWORD_66)||LA28_0==KEYWORD_61||LA28_0==KEYWORD_55||(LA28_0>=KEYWORD_57 && LA28_0<=KEYWORD_48)||(LA28_0>=KEYWORD_51 && LA28_0<=KEYWORD_52)||LA28_0==KEYWORD_38||LA28_0==KEYWORD_40||LA28_0==KEYWORD_42||(LA28_0>=KEYWORD_29 && LA28_0<=KEYWORD_30)||(LA28_0>=KEYWORD_32 && LA28_0<=KEYWORD_33)||LA28_0==KEYWORD_35||(LA28_0>=KEYWORD_25 && LA28_0<=KEYWORD_26)||LA28_0==KEYWORD_21||LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2025:1: ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2025:1: ( (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2026:1: (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2026:1: (lv_metaclassName_5_1= ruleCoreKeyWord | lv_metaclassName_5_2= RULE_ID )
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==KEYWORD_74||(LA27_0>=KEYWORD_69 && LA27_0<=KEYWORD_66)||LA27_0==KEYWORD_61||LA27_0==KEYWORD_55||(LA27_0>=KEYWORD_57 && LA27_0<=KEYWORD_48)||(LA27_0>=KEYWORD_51 && LA27_0<=KEYWORD_52)||LA27_0==KEYWORD_38||LA27_0==KEYWORD_40||LA27_0==KEYWORD_42||(LA27_0>=KEYWORD_29 && LA27_0<=KEYWORD_30)||(LA27_0>=KEYWORD_32 && LA27_0<=KEYWORD_33)||LA27_0==KEYWORD_35||(LA27_0>=KEYWORD_25 && LA27_0<=KEYWORD_26)||LA27_0==KEYWORD_21) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==RULE_ID) ) {
            	        alt27=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 27, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2027:3: lv_metaclassName_5_1= ruleCoreKeyWord
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getQMReferenceAccess().getMetaclassNameCoreKeyWordParserRuleCall_1_0_0()); 
            	            	    
            	            pushFollow(FollowSets000.FOLLOW_ruleCoreKeyWord_in_ruleQMReference4333);
            	            lv_metaclassName_5_1=ruleCoreKeyWord();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getQMReferenceRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"metaclassName",
            	                    		lv_metaclassName_5_1, 
            	                    		"CoreKeyWord");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2042:8: lv_metaclassName_5_2= RULE_ID
            	            {
            	            lv_metaclassName_5_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQMReference4348); 

            	            			newLeafNode(lv_metaclassName_5_2, grammarAccess.getQMReferenceAccess().getMetaclassNameIDTerminalRuleCall_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getQMReferenceRule());
            	            	        }
            	                   		addWithLastConsumed(
            	                   			current, 
            	                   			"metaclassName",
            	                    		lv_metaclassName_5_2, 
            	                    		"ID");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


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
    // $ANTLR end "ruleQMReference"


    // $ANTLR start "entryRuleQCReference"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2068:1: entryRuleQCReference returns [EObject current=null] : iv_ruleQCReference= ruleQCReference EOF ;
    public final EObject entryRuleQCReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQCReference = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2069:2: (iv_ruleQCReference= ruleQCReference EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2070:2: iv_ruleQCReference= ruleQCReference EOF
            {
             newCompositeNode(grammarAccess.getQCReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQCReference_in_entryRuleQCReference4392);
            iv_ruleQCReference=ruleQCReference();

            state._fsp--;

             current =iv_ruleQCReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQCReference4402); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2077:1: ruleQCReference returns [EObject current=null] : ( ( ruleFQCREF ) ) ;
    public final EObject ruleQCReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2080:28: ( ( ( ruleFQCREF ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2081:1: ( ( ruleFQCREF ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2081:1: ( ( ruleFQCREF ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2082:1: ( ruleFQCREF )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2082:1: ( ruleFQCREF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2083:3: ruleFQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQCReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getQCReferenceAccess().getClassifierComponentClassifierCrossReference_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQCREF_in_ruleQCReference4449);
            ruleFQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleQCReference"


    // $ANTLR start "entryRuleReferenceType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2104:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2105:2: (iv_ruleReferenceType= ruleReferenceType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2106:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
             newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceType_in_entryRuleReferenceType4483);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;

             current =iv_ruleReferenceType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceType4493); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2113:1: ruleReferenceType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_67 (otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_namedElementReference_5_0 = null;

        EObject lv_namedElementReference_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2116:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_67 (otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2117:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_67 (otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2117:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_67 (otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2117:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_67 (otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2117:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2118:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2118:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2119:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceType4535); 

            			newLeafNode(lv_name_0_0, grammarAccess.getReferenceTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleReferenceType4553); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleReferenceType4565); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_67,FollowSets000.FOLLOW_KEYWORD_67_in_ruleReferenceType4577); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceTypeAccess().getReferenceKeyword_3());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2150:1: (otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==KEYWORD_1) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2151:2: otherlv_4= KEYWORD_1 ( (lv_namedElementReference_5_0= ruleQMReference ) ) (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )* otherlv_8= KEYWORD_2
                    {
                    otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleReferenceType4590); 

                        	newLeafNode(otherlv_4, grammarAccess.getReferenceTypeAccess().getLeftParenthesisKeyword_4_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2155:1: ( (lv_namedElementReference_5_0= ruleQMReference ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2156:1: (lv_namedElementReference_5_0= ruleQMReference )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2156:1: (lv_namedElementReference_5_0= ruleQMReference )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2157:3: lv_namedElementReference_5_0= ruleQMReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceQMReferenceParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleReferenceType4610);
                    lv_namedElementReference_5_0=ruleQMReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"namedElementReference",
                            		lv_namedElementReference_5_0, 
                            		"QMReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2173:2: (otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==KEYWORD_5) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2174:2: otherlv_6= KEYWORD_5 ( (lv_namedElementReference_7_0= ruleQMReference ) )
                    	    {
                    	    otherlv_6=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleReferenceType4624); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getReferenceTypeAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2178:1: ( (lv_namedElementReference_7_0= ruleQMReference ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2179:1: (lv_namedElementReference_7_0= ruleQMReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2179:1: (lv_namedElementReference_7_0= ruleQMReference )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2180:3: lv_namedElementReference_7_0= ruleQMReference
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReferenceTypeAccess().getNamedElementReferenceQMReferenceParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleReferenceType4644);
                    	    lv_namedElementReference_7_0=ruleQMReference();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"namedElementReference",
                    	            		lv_namedElementReference_7_0, 
                    	            		"QMReference");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleReferenceType4659); 

                        	newLeafNode(otherlv_8, grammarAccess.getReferenceTypeAccess().getRightParenthesisKeyword_4_3());
                        

                    }
                    break;

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
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "entryRuleUnnamedReferenceType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2209:1: entryRuleUnnamedReferenceType returns [EObject current=null] : iv_ruleUnnamedReferenceType= ruleUnnamedReferenceType EOF ;
    public final EObject entryRuleUnnamedReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedReferenceType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2210:2: (iv_ruleUnnamedReferenceType= ruleUnnamedReferenceType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2211:2: iv_ruleUnnamedReferenceType= ruleUnnamedReferenceType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedReferenceTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedReferenceType_in_entryRuleUnnamedReferenceType4695);
            iv_ruleUnnamedReferenceType=ruleUnnamedReferenceType();

            state._fsp--;

             current =iv_ruleUnnamedReferenceType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedReferenceType4705); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2218:1: ruleUnnamedReferenceType returns [EObject current=null] : (otherlv_0= KEYWORD_67 () (otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? ) ;
    public final EObject ruleUnnamedReferenceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_namedElementReference_3_0 = null;

        EObject lv_namedElementReference_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2221:28: ( (otherlv_0= KEYWORD_67 () (otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2222:1: (otherlv_0= KEYWORD_67 () (otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2222:1: (otherlv_0= KEYWORD_67 () (otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2223:2: otherlv_0= KEYWORD_67 () (otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )?
            {
            otherlv_0=(Token)match(input,KEYWORD_67,FollowSets000.FOLLOW_KEYWORD_67_in_ruleUnnamedReferenceType4743); 

                	newLeafNode(otherlv_0, grammarAccess.getUnnamedReferenceTypeAccess().getReferenceKeyword_0());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2227:1: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2228:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnnamedReferenceTypeAccess().getReferenceTypeAction_1(),
                        current);
                

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2233:2: (otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==KEYWORD_1) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2234:2: otherlv_2= KEYWORD_1 ( (lv_namedElementReference_3_0= ruleQMReference ) ) (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )* otherlv_6= KEYWORD_2
                    {
                    otherlv_2=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleUnnamedReferenceType4765); 

                        	newLeafNode(otherlv_2, grammarAccess.getUnnamedReferenceTypeAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2238:1: ( (lv_namedElementReference_3_0= ruleQMReference ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2239:1: (lv_namedElementReference_3_0= ruleQMReference )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2239:1: (lv_namedElementReference_3_0= ruleQMReference )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2240:3: lv_namedElementReference_3_0= ruleQMReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnnamedReferenceTypeAccess().getNamedElementReferenceQMReferenceParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleUnnamedReferenceType4785);
                    lv_namedElementReference_3_0=ruleQMReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnnamedReferenceTypeRule());
                    	        }
                           		add(
                           			current, 
                           			"namedElementReference",
                            		lv_namedElementReference_3_0, 
                            		"QMReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2256:2: (otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==KEYWORD_5) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2257:2: otherlv_4= KEYWORD_5 ( (lv_namedElementReference_5_0= ruleQMReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleUnnamedReferenceType4799); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getUnnamedReferenceTypeAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2261:1: ( (lv_namedElementReference_5_0= ruleQMReference ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2262:1: (lv_namedElementReference_5_0= ruleQMReference )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2262:1: (lv_namedElementReference_5_0= ruleQMReference )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2263:3: lv_namedElementReference_5_0= ruleQMReference
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getUnnamedReferenceTypeAccess().getNamedElementReferenceQMReferenceParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_ruleUnnamedReferenceType4819);
                    	    lv_namedElementReference_5_0=ruleQMReference();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getUnnamedReferenceTypeRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"namedElementReference",
                    	            		lv_namedElementReference_5_0, 
                    	            		"QMReference");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleUnnamedReferenceType4834); 

                        	newLeafNode(otherlv_6, grammarAccess.getUnnamedReferenceTypeAccess().getRightParenthesisKeyword_2_3());
                        

                    }
                    break;

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
    // $ANTLR end "ruleUnnamedReferenceType"


    // $ANTLR start "entryRuleRecordType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2292:1: entryRuleRecordType returns [EObject current=null] : iv_ruleRecordType= ruleRecordType EOF ;
    public final EObject entryRuleRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2293:2: (iv_ruleRecordType= ruleRecordType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2294:2: iv_ruleRecordType= ruleRecordType EOF
            {
             newCompositeNode(grammarAccess.getRecordTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecordType_in_entryRuleRecordType4870);
            iv_ruleRecordType=ruleRecordType();

            state._fsp--;

             current =iv_ruleRecordType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecordType4880); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2301:1: ruleRecordType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_50 otherlv_4= KEYWORD_1 ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= KEYWORD_2 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2304:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_50 otherlv_4= KEYWORD_1 ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2305:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_50 otherlv_4= KEYWORD_1 ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2305:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_50 otherlv_4= KEYWORD_1 ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2305:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_35 otherlv_3= KEYWORD_50 otherlv_4= KEYWORD_1 ( (lv_ownedField_5_0= ruleRecordField ) )+ otherlv_6= KEYWORD_2
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2305:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2306:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2306:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2307:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecordType4922); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRecordTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleRecordType4940); 

                	newLeafNode(otherlv_1, grammarAccess.getRecordTypeAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleRecordType4952); 

                	newLeafNode(otherlv_2, grammarAccess.getRecordTypeAccess().getTypeKeyword_2());
                
            otherlv_3=(Token)match(input,KEYWORD_50,FollowSets000.FOLLOW_KEYWORD_50_in_ruleRecordType4964); 

                	newLeafNode(otherlv_3, grammarAccess.getRecordTypeAccess().getRecordKeyword_3());
                
            otherlv_4=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleRecordType4976); 

                	newLeafNode(otherlv_4, grammarAccess.getRecordTypeAccess().getLeftParenthesisKeyword_4());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2343:1: ( (lv_ownedField_5_0= ruleRecordField ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2344:1: (lv_ownedField_5_0= ruleRecordField )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2344:1: (lv_ownedField_5_0= ruleRecordField )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2345:3: lv_ownedField_5_0= ruleRecordField
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTypeAccess().getOwnedFieldRecordFieldParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecordField_in_ruleRecordType4996);
            	    lv_ownedField_5_0=ruleRecordField();

            	    state._fsp--;


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
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            otherlv_6=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleRecordType5010); 

                	newLeafNode(otherlv_6, grammarAccess.getRecordTypeAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleRecordType"


    // $ANTLR start "entryRuleUnnamedRecordType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2374:1: entryRuleUnnamedRecordType returns [EObject current=null] : iv_ruleUnnamedRecordType= ruleUnnamedRecordType EOF ;
    public final EObject entryRuleUnnamedRecordType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnnamedRecordType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2375:2: (iv_ruleUnnamedRecordType= ruleUnnamedRecordType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2376:2: iv_ruleUnnamedRecordType= ruleUnnamedRecordType EOF
            {
             newCompositeNode(grammarAccess.getUnnamedRecordTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnnamedRecordType_in_entryRuleUnnamedRecordType5044);
            iv_ruleUnnamedRecordType=ruleUnnamedRecordType();

            state._fsp--;

             current =iv_ruleUnnamedRecordType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnnamedRecordType5054); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2383:1: ruleUnnamedRecordType returns [EObject current=null] : (otherlv_0= KEYWORD_50 otherlv_1= KEYWORD_1 ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleUnnamedRecordType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedField_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2386:28: ( (otherlv_0= KEYWORD_50 otherlv_1= KEYWORD_1 ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2387:1: (otherlv_0= KEYWORD_50 otherlv_1= KEYWORD_1 ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2387:1: (otherlv_0= KEYWORD_50 otherlv_1= KEYWORD_1 ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2388:2: otherlv_0= KEYWORD_50 otherlv_1= KEYWORD_1 ( (lv_ownedField_2_0= ruleRecordField ) )+ otherlv_3= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_50,FollowSets000.FOLLOW_KEYWORD_50_in_ruleUnnamedRecordType5092); 

                	newLeafNode(otherlv_0, grammarAccess.getUnnamedRecordTypeAccess().getRecordKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleUnnamedRecordType5104); 

                	newLeafNode(otherlv_1, grammarAccess.getUnnamedRecordTypeAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2397:1: ( (lv_ownedField_2_0= ruleRecordField ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_ID) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2398:1: (lv_ownedField_2_0= ruleRecordField )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2398:1: (lv_ownedField_2_0= ruleRecordField )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2399:3: lv_ownedField_2_0= ruleRecordField
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUnnamedRecordTypeAccess().getOwnedFieldRecordFieldParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecordField_in_ruleUnnamedRecordType5124);
            	    lv_ownedField_2_0=ruleRecordField();

            	    state._fsp--;


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
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            otherlv_3=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleUnnamedRecordType5138); 

                	newLeafNode(otherlv_3, grammarAccess.getUnnamedRecordTypeAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleUnnamedRecordType"


    // $ANTLR start "entryRuleRecordField"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2428:1: entryRuleRecordField returns [EObject current=null] : iv_ruleRecordField= ruleRecordField EOF ;
    public final EObject entryRuleRecordField() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordField = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2429:2: (iv_ruleRecordField= ruleRecordField EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2430:2: iv_ruleRecordField= ruleRecordField EOF
            {
             newCompositeNode(grammarAccess.getRecordFieldRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecordField_in_entryRuleRecordField5172);
            iv_ruleRecordField=ruleRecordField();

            state._fsp--;

             current =iv_ruleRecordField; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecordField5182); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2437:1: ruleRecordField returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) ) ) otherlv_4= KEYWORD_9 ) ;
    public final EObject ruleRecordField() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_ownedPropertyType_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2440:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) ) ) otherlv_4= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2441:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) ) ) otherlv_4= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2441:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) ) ) otherlv_4= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2441:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) ) ) otherlv_4= KEYWORD_9
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2441:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2442:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2442:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2443:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRecordField5224); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRecordFieldAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_ruleRecordField5242); 

                	newLeafNode(otherlv_1, grammarAccess.getRecordFieldAccess().getColonKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2464:1: ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=KEYWORD_71 && LA35_0<=KEYWORD_69)||(LA35_0>=KEYWORD_67 && LA35_0<=KEYWORD_60)||LA35_0==KEYWORD_50||(LA35_0>=KEYWORD_44 && LA35_0<=KEYWORD_45)||LA35_0==KEYWORD_31) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2464:2: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2464:2: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2465:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2465:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2466:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRecordFieldRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRecordFieldAccess().getPropertyTypePropertyTypeCrossReference_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleRecordField5265);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2480:6: ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2480:6: ( (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2481:1: (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2481:1: (lv_ownedPropertyType_3_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2482:3: lv_ownedPropertyType_3_0= ruleUnnamedPropertyType
                    {
                     
                    	        newCompositeNode(grammarAccess.getRecordFieldAccess().getOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedPropertyType_in_ruleRecordField5292);
                    lv_ownedPropertyType_3_0=ruleUnnamedPropertyType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRecordFieldRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedPropertyType",
                            		lv_ownedPropertyType_3_0, 
                            		"UnnamedPropertyType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_ruleRecordField5306); 

                	newLeafNode(otherlv_4, grammarAccess.getRecordFieldAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleRecordField"


    // $ANTLR start "entryRulePropertyDefinition"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2511:1: entryRulePropertyDefinition returns [EObject current=null] : iv_rulePropertyDefinition= rulePropertyDefinition EOF ;
    public final EObject entryRulePropertyDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyDefinition = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2512:2: (iv_rulePropertyDefinition= rulePropertyDefinition EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2513:2: iv_rulePropertyDefinition= rulePropertyDefinition EOF
            {
             newCompositeNode(grammarAccess.getPropertyDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition5340);
            iv_rulePropertyDefinition=rulePropertyDefinition();

            state._fsp--;

             current =iv_rulePropertyDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyDefinition5350); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2520:1: rulePropertyDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( (lv_inherit_2_0= KEYWORD_56 ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 otherlv_9= KEYWORD_1 ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= KEYWORD_2 otherlv_15= KEYWORD_9 ) ;
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
        EObject lv_ownedPropertyType_4_0 = null;

        EObject lv_defaultValue_6_0 = null;

        EObject lv_appliesTo_10_0 = null;

        EObject lv_appliesTo_12_0 = null;

        EObject lv_appliesTo_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2523:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( (lv_inherit_2_0= KEYWORD_56 ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 otherlv_9= KEYWORD_1 ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= KEYWORD_2 otherlv_15= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2524:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( (lv_inherit_2_0= KEYWORD_56 ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 otherlv_9= KEYWORD_1 ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= KEYWORD_2 otherlv_15= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2524:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( (lv_inherit_2_0= KEYWORD_56 ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 otherlv_9= KEYWORD_1 ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= KEYWORD_2 otherlv_15= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2524:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 ( (lv_inherit_2_0= KEYWORD_56 ) )? ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) (otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )? otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 otherlv_9= KEYWORD_1 ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) ) otherlv_14= KEYWORD_2 otherlv_15= KEYWORD_9
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2524:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2525:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2525:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2526:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePropertyDefinition5392); 

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_rulePropertyDefinition5410); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyDefinitionAccess().getColonKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2547:1: ( (lv_inherit_2_0= KEYWORD_56 ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==KEYWORD_56) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2548:1: (lv_inherit_2_0= KEYWORD_56 )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2548:1: (lv_inherit_2_0= KEYWORD_56 )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2549:3: lv_inherit_2_0= KEYWORD_56
                    {
                    lv_inherit_2_0=(Token)match(input,KEYWORD_56,FollowSets000.FOLLOW_KEYWORD_56_in_rulePropertyDefinition5428); 

                            newLeafNode(lv_inherit_2_0, grammarAccess.getPropertyDefinitionAccess().getInheritInheritKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPropertyDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "inherit", true, "inherit");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2563:3: ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            else if ( ((LA37_0>=KEYWORD_71 && LA37_0<=KEYWORD_69)||(LA37_0>=KEYWORD_67 && LA37_0<=KEYWORD_60)||LA37_0==KEYWORD_50||(LA37_0>=KEYWORD_44 && LA37_0<=KEYWORD_45)||LA37_0==KEYWORD_31) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2563:4: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2563:4: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2564:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2564:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2565:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPropertyDefinitionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getPropertyTypePropertyTypeCrossReference_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_rulePropertyDefinition5464);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2579:6: ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2579:6: ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2580:1: (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2580:1: (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2581:3: lv_ownedPropertyType_4_0= ruleUnnamedPropertyType
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedPropertyType_in_rulePropertyDefinition5491);
                    lv_ownedPropertyType_4_0=ruleUnnamedPropertyType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedPropertyType",
                            		lv_ownedPropertyType_4_0, 
                            		"UnnamedPropertyType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2597:3: (otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==KEYWORD_16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2598:2: otherlv_5= KEYWORD_16 ( (lv_defaultValue_6_0= rulePropertyExpression ) )
                    {
                    otherlv_5=(Token)match(input,KEYWORD_16,FollowSets000.FOLLOW_KEYWORD_16_in_rulePropertyDefinition5506); 

                        	newLeafNode(otherlv_5, grammarAccess.getPropertyDefinitionAccess().getEqualsSignGreaterThanSignKeyword_4_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2602:1: ( (lv_defaultValue_6_0= rulePropertyExpression ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2603:1: (lv_defaultValue_6_0= rulePropertyExpression )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2603:1: (lv_defaultValue_6_0= rulePropertyExpression )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2604:3: lv_defaultValue_6_0= rulePropertyExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getDefaultValuePropertyExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_rulePropertyDefinition5526);
                    lv_defaultValue_6_0=rulePropertyExpression();

                    state._fsp--;


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
                    break;

            }

            otherlv_7=(Token)match(input,KEYWORD_53,FollowSets000.FOLLOW_KEYWORD_53_in_rulePropertyDefinition5541); 

                	newLeafNode(otherlv_7, grammarAccess.getPropertyDefinitionAccess().getAppliesKeyword_5());
                
            otherlv_8=(Token)match(input,KEYWORD_21,FollowSets000.FOLLOW_KEYWORD_21_in_rulePropertyDefinition5553); 

                	newLeafNode(otherlv_8, grammarAccess.getPropertyDefinitionAccess().getToKeyword_6());
                
            otherlv_9=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_rulePropertyDefinition5565); 

                	newLeafNode(otherlv_9, grammarAccess.getPropertyDefinitionAccess().getLeftParenthesisKeyword_7());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2635:1: ( ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* ) | ( (lv_appliesTo_13_0= ruleAllReference ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==KEYWORD_74||(LA40_0>=KEYWORD_69 && LA40_0<=KEYWORD_66)||LA40_0==KEYWORD_61||LA40_0==KEYWORD_55||(LA40_0>=KEYWORD_57 && LA40_0<=KEYWORD_48)||(LA40_0>=KEYWORD_51 && LA40_0<=KEYWORD_52)||LA40_0==KEYWORD_38||LA40_0==KEYWORD_40||LA40_0==KEYWORD_42||(LA40_0>=KEYWORD_29 && LA40_0<=KEYWORD_30)||(LA40_0>=KEYWORD_32 && LA40_0<=KEYWORD_33)||LA40_0==KEYWORD_35||(LA40_0>=KEYWORD_25 && LA40_0<=KEYWORD_26)||LA40_0==KEYWORD_21||LA40_0==KEYWORD_12||LA40_0==RULE_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==KEYWORD_23) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2635:2: ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2635:2: ( ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )* )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2635:3: ( (lv_appliesTo_10_0= rulePropertyOwner ) ) (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2635:3: ( (lv_appliesTo_10_0= rulePropertyOwner ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2636:1: (lv_appliesTo_10_0= rulePropertyOwner )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2636:1: (lv_appliesTo_10_0= rulePropertyOwner )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2637:3: lv_appliesTo_10_0= rulePropertyOwner
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAppliesToPropertyOwnerParserRuleCall_8_0_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5587);
                    lv_appliesTo_10_0=rulePropertyOwner();

                    state._fsp--;


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

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2653:2: (otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==KEYWORD_5) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2654:2: otherlv_11= KEYWORD_5 ( (lv_appliesTo_12_0= rulePropertyOwner ) )
                    	    {
                    	    otherlv_11=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_rulePropertyDefinition5601); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getPropertyDefinitionAccess().getCommaKeyword_8_0_1_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2658:1: ( (lv_appliesTo_12_0= rulePropertyOwner ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2659:1: (lv_appliesTo_12_0= rulePropertyOwner )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2659:1: (lv_appliesTo_12_0= rulePropertyOwner )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2660:3: lv_appliesTo_12_0= rulePropertyOwner
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAppliesToPropertyOwnerParserRuleCall_8_0_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5621);
                    	    lv_appliesTo_12_0=rulePropertyOwner();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2677:6: ( (lv_appliesTo_13_0= ruleAllReference ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2677:6: ( (lv_appliesTo_13_0= ruleAllReference ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2678:1: (lv_appliesTo_13_0= ruleAllReference )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2678:1: (lv_appliesTo_13_0= ruleAllReference )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2679:3: lv_appliesTo_13_0= ruleAllReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyDefinitionAccess().getAppliesToAllReferenceParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAllReference_in_rulePropertyDefinition5651);
                    lv_appliesTo_13_0=ruleAllReference();

                    state._fsp--;


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
                    break;

            }

            otherlv_14=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_rulePropertyDefinition5665); 

                	newLeafNode(otherlv_14, grammarAccess.getPropertyDefinitionAccess().getRightParenthesisKeyword_9());
                
            otherlv_15=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_rulePropertyDefinition5677); 

                	newLeafNode(otherlv_15, grammarAccess.getPropertyDefinitionAccess().getSemicolonKeyword_10());
                

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


    // $ANTLR start "entryRuleAllReference"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2713:1: entryRuleAllReference returns [EObject current=null] : iv_ruleAllReference= ruleAllReference EOF ;
    public final EObject entryRuleAllReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllReference = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2714:2: (iv_ruleAllReference= ruleAllReference EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2715:2: iv_ruleAllReference= ruleAllReference EOF
            {
             newCompositeNode(grammarAccess.getAllReferenceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAllReference_in_entryRuleAllReference5711);
            iv_ruleAllReference=ruleAllReference();

            state._fsp--;

             current =iv_ruleAllReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAllReference5721); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2722:1: ruleAllReference returns [EObject current=null] : ( (lv_metaclassName_0_0= KEYWORD_23 ) ) ;
    public final EObject ruleAllReference() throws RecognitionException {
        EObject current = null;

        Token lv_metaclassName_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2725:28: ( ( (lv_metaclassName_0_0= KEYWORD_23 ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2726:1: ( (lv_metaclassName_0_0= KEYWORD_23 ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2726:1: ( (lv_metaclassName_0_0= KEYWORD_23 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2727:1: (lv_metaclassName_0_0= KEYWORD_23 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2727:1: (lv_metaclassName_0_0= KEYWORD_23 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2728:3: lv_metaclassName_0_0= KEYWORD_23
            {
            lv_metaclassName_0_0=(Token)match(input,KEYWORD_23,FollowSets000.FOLLOW_KEYWORD_23_in_ruleAllReference5764); 

                    newLeafNode(lv_metaclassName_0_0, grammarAccess.getAllReferenceAccess().getMetaclassNameAllKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAllReferenceRule());
            	        }
                   		addWithLastConsumed(current, "metaclassName", lv_metaclassName_0_0, "all");
            	    

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
    // $ANTLR end "ruleAllReference"


    // $ANTLR start "entryRuleListType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2750:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2751:2: (iv_ruleListType= ruleListType EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2752:2: iv_ruleListType= ruleListType EOF
            {
             newCompositeNode(grammarAccess.getListTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListType_in_entryRuleListType5809);
            iv_ruleListType=ruleListType();

            state._fsp--;

             current =iv_ruleListType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListType5819); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2759:1: ruleListType returns [EObject current=null] : (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_19 ( ( ( ruleQPREF ) ) | ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) ) ) ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_ownedElementType_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2762:28: ( (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_19 ( ( ( ruleQPREF ) ) | ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2763:1: (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_19 ( ( ( ruleQPREF ) ) | ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2763:1: (otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_19 ( ( ( ruleQPREF ) ) | ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2764:2: otherlv_0= KEYWORD_31 otherlv_1= KEYWORD_19 ( ( ( ruleQPREF ) ) | ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_31,FollowSets000.FOLLOW_KEYWORD_31_in_ruleListType5857); 

                	newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_19,FollowSets000.FOLLOW_KEYWORD_19_in_ruleListType5869); 

                	newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getOfKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2773:1: ( ( ( ruleQPREF ) ) | ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            else if ( ((LA41_0>=KEYWORD_71 && LA41_0<=KEYWORD_69)||(LA41_0>=KEYWORD_67 && LA41_0<=KEYWORD_60)||LA41_0==KEYWORD_50||(LA41_0>=KEYWORD_44 && LA41_0<=KEYWORD_45)||LA41_0==KEYWORD_31) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2773:2: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2773:2: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2774:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2774:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2775:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getListTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getListTypeAccess().getElementTypePropertyTypeCrossReference_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleListType5892);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2789:6: ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2789:6: ( (lv_ownedElementType_3_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2790:1: (lv_ownedElementType_3_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2790:1: (lv_ownedElementType_3_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2791:3: lv_ownedElementType_3_0= ruleUnnamedPropertyType
                    {
                     
                    	        newCompositeNode(grammarAccess.getListTypeAccess().getOwnedElementTypeUnnamedPropertyTypeParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedPropertyType_in_ruleListType5919);
                    lv_ownedElementType_3_0=ruleUnnamedPropertyType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getListTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedElementType",
                            		lv_ownedElementType_3_0, 
                            		"UnnamedPropertyType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRulePropertyOwner"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2815:1: entryRulePropertyOwner returns [EObject current=null] : iv_rulePropertyOwner= rulePropertyOwner EOF ;
    public final EObject entryRulePropertyOwner() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyOwner = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2816:2: (iv_rulePropertyOwner= rulePropertyOwner EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2817:2: iv_rulePropertyOwner= rulePropertyOwner EOF
            {
             newCompositeNode(grammarAccess.getPropertyOwnerRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertyOwner_in_entryRulePropertyOwner5955);
            iv_rulePropertyOwner=rulePropertyOwner();

            state._fsp--;

             current =iv_rulePropertyOwner; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyOwner5965); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2824:1: rulePropertyOwner returns [EObject current=null] : (this_QMReference_0= ruleQMReference | this_QCReference_1= ruleQCReference ) ;
    public final EObject rulePropertyOwner() throws RecognitionException {
        EObject current = null;

        EObject this_QMReference_0 = null;

        EObject this_QCReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2827:28: ( (this_QMReference_0= ruleQMReference | this_QCReference_1= ruleQCReference ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2828:1: (this_QMReference_0= ruleQMReference | this_QCReference_1= ruleQCReference )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2828:1: (this_QMReference_0= ruleQMReference | this_QCReference_1= ruleQCReference )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==KEYWORD_74||(LA42_0>=KEYWORD_69 && LA42_0<=KEYWORD_66)||LA42_0==KEYWORD_61||LA42_0==KEYWORD_55||(LA42_0>=KEYWORD_57 && LA42_0<=KEYWORD_48)||(LA42_0>=KEYWORD_51 && LA42_0<=KEYWORD_52)||LA42_0==KEYWORD_38||LA42_0==KEYWORD_40||LA42_0==KEYWORD_42||(LA42_0>=KEYWORD_29 && LA42_0<=KEYWORD_30)||(LA42_0>=KEYWORD_32 && LA42_0<=KEYWORD_33)||LA42_0==KEYWORD_35||(LA42_0>=KEYWORD_25 && LA42_0<=KEYWORD_26)||LA42_0==KEYWORD_21||LA42_0==KEYWORD_12) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_ID) ) {
                int LA42_2 = input.LA(2);

                if ( (LA42_2==EOF||LA42_2==KEYWORD_74||(LA42_2>=KEYWORD_69 && LA42_2<=KEYWORD_66)||LA42_2==KEYWORD_61||LA42_2==KEYWORD_55||(LA42_2>=KEYWORD_57 && LA42_2<=KEYWORD_48)||(LA42_2>=KEYWORD_51 && LA42_2<=KEYWORD_52)||LA42_2==KEYWORD_38||LA42_2==KEYWORD_40||LA42_2==KEYWORD_42||(LA42_2>=KEYWORD_29 && LA42_2<=KEYWORD_30)||(LA42_2>=KEYWORD_32 && LA42_2<=KEYWORD_33)||LA42_2==KEYWORD_35||(LA42_2>=KEYWORD_25 && LA42_2<=KEYWORD_26)||LA42_2==KEYWORD_21||LA42_2==KEYWORD_2||LA42_2==KEYWORD_5||LA42_2==RULE_ID) ) {
                    alt42=1;
                }
                else if ( (LA42_2==KEYWORD_15) ) {
                    alt42=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2829:5: this_QMReference_0= ruleQMReference
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyOwnerAccess().getQMReferenceParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleQMReference_in_rulePropertyOwner6012);
                    this_QMReference_0=ruleQMReference();

                    state._fsp--;


                            current = this_QMReference_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2839:5: this_QCReference_1= ruleQCReference
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyOwnerAccess().getQCReferenceParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleQCReference_in_rulePropertyOwner6039);
                    this_QCReference_1=ruleQCReference();

                    state._fsp--;


                            current = this_QCReference_1;
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
    // $ANTLR end "rulePropertyOwner"


    // $ANTLR start "entryRulePropertyConstant"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2855:1: entryRulePropertyConstant returns [EObject current=null] : iv_rulePropertyConstant= rulePropertyConstant EOF ;
    public final EObject entryRulePropertyConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyConstant = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2856:2: (iv_rulePropertyConstant= rulePropertyConstant EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2857:2: iv_rulePropertyConstant= rulePropertyConstant EOF
            {
             newCompositeNode(grammarAccess.getPropertyConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertyConstant_in_entryRulePropertyConstant6073);
            iv_rulePropertyConstant=rulePropertyConstant();

            state._fsp--;

             current =iv_rulePropertyConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyConstant6083); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2864:1: rulePropertyConstant returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_62 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= KEYWORD_16 ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= KEYWORD_9 ) ;
    public final EObject rulePropertyConstant() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedPropertyType_4_0 = null;

        EObject lv_constantValue_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2867:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_62 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= KEYWORD_16 ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2868:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_62 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= KEYWORD_16 ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2868:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_62 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= KEYWORD_16 ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2868:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= KEYWORD_8 otherlv_2= KEYWORD_62 ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) ) otherlv_5= KEYWORD_16 ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) ) otherlv_7= KEYWORD_9
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2868:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2869:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2869:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2870:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePropertyConstant6125); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPropertyConstantAccess().getNameIDTerminalRuleCall_0_0()); 
            		

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

            otherlv_1=(Token)match(input,KEYWORD_8,FollowSets000.FOLLOW_KEYWORD_8_in_rulePropertyConstant6143); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyConstantAccess().getColonKeyword_1());
                
            otherlv_2=(Token)match(input,KEYWORD_62,FollowSets000.FOLLOW_KEYWORD_62_in_rulePropertyConstant6155); 

                	newLeafNode(otherlv_2, grammarAccess.getPropertyConstantAccess().getConstantKeyword_2());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2896:1: ( ( ( ruleQPREF ) ) | ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=KEYWORD_71 && LA43_0<=KEYWORD_69)||(LA43_0>=KEYWORD_67 && LA43_0<=KEYWORD_60)||LA43_0==KEYWORD_50||(LA43_0>=KEYWORD_44 && LA43_0<=KEYWORD_45)||LA43_0==KEYWORD_31) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2896:2: ( ( ruleQPREF ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2896:2: ( ( ruleQPREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2897:1: ( ruleQPREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2897:1: ( ruleQPREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2898:3: ruleQPREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getPropertyConstantRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getPropertyConstantAccess().getPropertyTypePropertyTypeCrossReference_3_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_rulePropertyConstant6178);
                    ruleQPREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2912:6: ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2912:6: ( (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2913:1: (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2913:1: (lv_ownedPropertyType_4_0= ruleUnnamedPropertyType )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2914:3: lv_ownedPropertyType_4_0= ruleUnnamedPropertyType
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyConstantAccess().getOwnedPropertyTypeUnnamedPropertyTypeParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleUnnamedPropertyType_in_rulePropertyConstant6205);
                    lv_ownedPropertyType_4_0=ruleUnnamedPropertyType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyConstantRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedPropertyType",
                            		lv_ownedPropertyType_4_0, 
                            		"UnnamedPropertyType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,KEYWORD_16,FollowSets000.FOLLOW_KEYWORD_16_in_rulePropertyConstant6219); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertyConstantAccess().getEqualsSignGreaterThanSignKeyword_4());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2935:1: ( (lv_constantValue_6_0= ruleConstantPropertyExpression ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2936:1: (lv_constantValue_6_0= ruleConstantPropertyExpression )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2936:1: (lv_constantValue_6_0= ruleConstantPropertyExpression )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2937:3: lv_constantValue_6_0= ruleConstantPropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getPropertyConstantAccess().getConstantValueConstantPropertyExpressionParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConstantPropertyExpression_in_rulePropertyConstant6239);
            lv_constantValue_6_0=ruleConstantPropertyExpression();

            state._fsp--;


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

            otherlv_7=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_rulePropertyConstant6252); 

                	newLeafNode(otherlv_7, grammarAccess.getPropertyConstantAccess().getSemicolonKeyword_6());
                

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
    // $ANTLR end "rulePropertyConstant"


    // $ANTLR start "entryRuleNumberValue"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2966:1: entryRuleNumberValue returns [EObject current=null] : iv_ruleNumberValue= ruleNumberValue EOF ;
    public final EObject entryRuleNumberValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberValue = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2967:2: (iv_ruleNumberValue= ruleNumberValue EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2968:2: iv_ruleNumberValue= ruleNumberValue EOF
            {
             newCompositeNode(grammarAccess.getNumberValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumberValue_in_entryRuleNumberValue6286);
            iv_ruleNumberValue=ruleNumberValue();

            state._fsp--;

             current =iv_ruleNumberValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberValue6296); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2975:1: ruleNumberValue returns [EObject current=null] : (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit ) ;
    public final EObject ruleNumberValue() throws RecognitionException {
        EObject current = null;

        EObject this_RealLit_0 = null;

        EObject this_IntegerLit_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2978:28: ( (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2979:1: (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2979:1: (this_RealLit_0= ruleRealLit | this_IntegerLit_1= ruleIntegerLit )
            int alt44=2;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==RULE_REAL_LIT) ) {
                    alt44=1;
                }
                else if ( (LA44_1==RULE_INTEGER_LIT) ) {
                    alt44=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
                }
                break;
            case KEYWORD_6:
                {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==RULE_INTEGER_LIT) ) {
                    alt44=2;
                }
                else if ( (LA44_2==RULE_REAL_LIT) ) {
                    alt44=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_LIT:
                {
                alt44=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt44=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2980:5: this_RealLit_0= ruleRealLit
                    {
                     
                            newCompositeNode(grammarAccess.getNumberValueAccess().getRealLitParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRealLit_in_ruleNumberValue6343);
                    this_RealLit_0=ruleRealLit();

                    state._fsp--;


                            current = this_RealLit_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:2990:5: this_IntegerLit_1= ruleIntegerLit
                    {
                     
                            newCompositeNode(grammarAccess.getNumberValueAccess().getIntegerLitParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerLit_in_ruleNumberValue6370);
                    this_IntegerLit_1=ruleIntegerLit();

                    state._fsp--;


                            current = this_IntegerLit_1;
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
    // $ANTLR end "ruleNumberValue"


    // $ANTLR start "entryRuleRealLit"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3006:1: entryRuleRealLit returns [EObject current=null] : iv_ruleRealLit= ruleRealLit EOF ;
    public final EObject entryRuleRealLit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLit = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3007:2: (iv_ruleRealLit= ruleRealLit EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3008:2: iv_ruleRealLit= ruleRealLit EOF
            {
             newCompositeNode(grammarAccess.getRealLitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRealLit_in_entryRuleRealLit6404);
            iv_ruleRealLit=ruleRealLit();

            state._fsp--;

             current =iv_ruleRealLit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealLit6414); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3015:1: ruleRealLit returns [EObject current=null] : ( (lv_value_0_0= ruleSignedReal ) ) ;
    public final EObject ruleRealLit() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3018:28: ( ( (lv_value_0_0= ruleSignedReal ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3019:1: ( (lv_value_0_0= ruleSignedReal ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3019:1: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3020:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3020:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3021:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealLitAccess().getValueSignedRealParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSignedReal_in_ruleRealLit6459);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealLitRule());
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
    // $ANTLR end "ruleRealLit"


    // $ANTLR start "entryRuleIntegerLit"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3045:1: entryRuleIntegerLit returns [EObject current=null] : iv_ruleIntegerLit= ruleIntegerLit EOF ;
    public final EObject entryRuleIntegerLit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLit = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3046:2: (iv_ruleIntegerLit= ruleIntegerLit EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3047:2: iv_ruleIntegerLit= ruleIntegerLit EOF
            {
             newCompositeNode(grammarAccess.getIntegerLitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerLit_in_entryRuleIntegerLit6493);
            iv_ruleIntegerLit=ruleIntegerLit();

            state._fsp--;

             current =iv_ruleIntegerLit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerLit6503); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3054:1: ruleIntegerLit returns [EObject current=null] : ( (lv_value_0_0= ruleSignedInt ) ) ;
    public final EObject ruleIntegerLit() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3057:28: ( ( (lv_value_0_0= ruleSignedInt ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3058:1: ( (lv_value_0_0= ruleSignedInt ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3058:1: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3059:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3059:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3060:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerLitAccess().getValueSignedIntParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSignedInt_in_ruleIntegerLit6548);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntegerLitRule());
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
    // $ANTLR end "ruleIntegerLit"


    // $ANTLR start "entryRuleConstantPropertyExpression"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3084:1: entryRuleConstantPropertyExpression returns [EObject current=null] : iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF ;
    public final EObject entryRuleConstantPropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantPropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3085:2: (iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3086:2: iv_ruleConstantPropertyExpression= ruleConstantPropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getConstantPropertyExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstantPropertyExpression_in_entryRuleConstantPropertyExpression6582);
            iv_ruleConstantPropertyExpression=ruleConstantPropertyExpression();

            state._fsp--;

             current =iv_ruleConstantPropertyExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstantPropertyExpression6592); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3093:1: ruleConstantPropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_ListTerm_7= ruleListTerm | this_LiteralorReferenceTerm_8= ruleLiteralorReferenceTerm | this_BooleanLiteral_9= ruleBooleanLiteral ) ;
    public final EObject ruleConstantPropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_NumericRangeTerm_1 = null;

        EObject this_ComputedTerm_2 = null;

        EObject this_StringTerm_3 = null;

        EObject this_RealTerm_4 = null;

        EObject this_IntegerTerm_5 = null;

        EObject this_ComponentClassifierTerm_6 = null;

        EObject this_ListTerm_7 = null;

        EObject this_LiteralorReferenceTerm_8 = null;

        EObject this_BooleanLiteral_9 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3096:28: ( (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_ListTerm_7= ruleListTerm | this_LiteralorReferenceTerm_8= ruleLiteralorReferenceTerm | this_BooleanLiteral_9= ruleBooleanLiteral ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3097:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_ListTerm_7= ruleListTerm | this_LiteralorReferenceTerm_8= ruleLiteralorReferenceTerm | this_BooleanLiteral_9= ruleBooleanLiteral )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3097:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_ListTerm_7= ruleListTerm | this_LiteralorReferenceTerm_8= ruleLiteralorReferenceTerm | this_BooleanLiteral_9= ruleBooleanLiteral )
            int alt45=10;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3098:5: this_RecordTerm_0= ruleRecordTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecordTerm_in_ruleConstantPropertyExpression6639);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;


                            current = this_RecordTerm_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3108:5: this_NumericRangeTerm_1= ruleNumericRangeTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getNumericRangeTermParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumericRangeTerm_in_ruleConstantPropertyExpression6666);
                    this_NumericRangeTerm_1=ruleNumericRangeTerm();

                    state._fsp--;


                            current = this_NumericRangeTerm_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3118:5: this_ComputedTerm_2= ruleComputedTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getComputedTermParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleComputedTerm_in_ruleConstantPropertyExpression6693);
                    this_ComputedTerm_2=ruleComputedTerm();

                    state._fsp--;


                            current = this_ComputedTerm_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3128:5: this_StringTerm_3= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getStringTermParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringTerm_in_ruleConstantPropertyExpression6720);
                    this_StringTerm_3=ruleStringTerm();

                    state._fsp--;


                            current = this_StringTerm_3;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3138:5: this_RealTerm_4= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getRealTermParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_ruleConstantPropertyExpression6747);
                    this_RealTerm_4=ruleRealTerm();

                    state._fsp--;


                            current = this_RealTerm_4;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3148:5: this_IntegerTerm_5= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getIntegerTermParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_ruleConstantPropertyExpression6774);
                    this_IntegerTerm_5=ruleIntegerTerm();

                    state._fsp--;


                            current = this_IntegerTerm_5;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3158:5: this_ComponentClassifierTerm_6= ruleComponentClassifierTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleComponentClassifierTerm_in_ruleConstantPropertyExpression6801);
                    this_ComponentClassifierTerm_6=ruleComponentClassifierTerm();

                    state._fsp--;


                            current = this_ComponentClassifierTerm_6;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3168:5: this_ListTerm_7= ruleListTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getListTermParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListTerm_in_ruleConstantPropertyExpression6828);
                    this_ListTerm_7=ruleListTerm();

                    state._fsp--;


                            current = this_ListTerm_7;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3178:5: this_LiteralorReferenceTerm_8= ruleLiteralorReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLiteralorReferenceTerm_in_ruleConstantPropertyExpression6855);
                    this_LiteralorReferenceTerm_8=ruleLiteralorReferenceTerm();

                    state._fsp--;


                            current = this_LiteralorReferenceTerm_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3188:5: this_BooleanLiteral_9= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getConstantPropertyExpressionAccess().getBooleanLiteralParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_ruleConstantPropertyExpression6882);
                    this_BooleanLiteral_9=ruleBooleanLiteral();

                    state._fsp--;


                            current = this_BooleanLiteral_9;
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
    // $ANTLR end "ruleConstantPropertyExpression"


    // $ANTLR start "entryRuleIntegerRange"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3204:1: entryRuleIntegerRange returns [EObject current=null] : iv_ruleIntegerRange= ruleIntegerRange EOF ;
    public final EObject entryRuleIntegerRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerRange = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3205:2: (iv_ruleIntegerRange= ruleIntegerRange EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3206:2: iv_ruleIntegerRange= ruleIntegerRange EOF
            {
             newCompositeNode(grammarAccess.getIntegerRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerRange_in_entryRuleIntegerRange6916);
            iv_ruleIntegerRange=ruleIntegerRange();

            state._fsp--;

             current =iv_ruleIntegerRange; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerRange6926); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3213:1: ruleIntegerRange returns [EObject current=null] : ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3216:28: ( ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3217:1: ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3217:1: ( ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3217:2: ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3217:2: ( ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3218:1: ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3218:1: ( (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3219:1: (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3219:1: (lv_lowerBound_0_1= ruleIntegerTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            int alt46=3;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==RULE_ID) ) {
                    alt46=2;
                }
                else if ( (LA46_1==RULE_INTEGER_LIT) ) {
                    alt46=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
                }
                break;
            case KEYWORD_6:
                {
                int LA46_2 = input.LA(2);

                if ( (LA46_2==RULE_INTEGER_LIT) ) {
                    alt46=1;
                }
                else if ( (LA46_2==RULE_ID) ) {
                    alt46=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt46=1;
                }
                break;
            case RULE_ID:
                {
                alt46=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3220:3: lv_lowerBound_0_1= ruleIntegerTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundIntegerTermParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_ruleIntegerRange6974);
                    lv_lowerBound_0_1=ruleIntegerTerm();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3235:8: lv_lowerBound_0_2= ruleSignedConstant
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundSignedConstantParserRuleCall_0_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_ruleIntegerRange6993);
                    lv_lowerBound_0_2=ruleSignedConstant();

                    state._fsp--;


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
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3250:8: lv_lowerBound_0_3= ruleConstantValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getLowerBoundConstantValueParserRuleCall_0_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleIntegerRange7012);
                    lv_lowerBound_0_3=ruleConstantValue();

                    state._fsp--;


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
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,KEYWORD_14,FollowSets000.FOLLOW_KEYWORD_14_in_ruleIntegerRange7028); 

                	newLeafNode(otherlv_1, grammarAccess.getIntegerRangeAccess().getFullStopFullStopKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3273:1: ( ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3274:1: ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3274:1: ( (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3275:1: (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3275:1: (lv_upperBound_2_1= ruleIntegerTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            int alt47=3;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==RULE_ID) ) {
                    alt47=2;
                }
                else if ( (LA47_1==RULE_INTEGER_LIT) ) {
                    alt47=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
                }
                break;
            case KEYWORD_6:
                {
                int LA47_2 = input.LA(2);

                if ( (LA47_2==RULE_INTEGER_LIT) ) {
                    alt47=1;
                }
                else if ( (LA47_2==RULE_ID) ) {
                    alt47=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt47=1;
                }
                break;
            case RULE_ID:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3276:3: lv_upperBound_2_1= ruleIntegerTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundIntegerTermParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_ruleIntegerRange7050);
                    lv_upperBound_2_1=ruleIntegerTerm();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3291:8: lv_upperBound_2_2= ruleSignedConstant
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundSignedConstantParserRuleCall_2_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_ruleIntegerRange7069);
                    lv_upperBound_2_2=ruleSignedConstant();

                    state._fsp--;


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
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3306:8: lv_upperBound_2_3= ruleConstantValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerRangeAccess().getUpperBoundConstantValueParserRuleCall_2_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleIntegerRange7088);
                    lv_upperBound_2_3=ruleConstantValue();

                    state._fsp--;


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
                    break;

            }


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
    // $ANTLR end "ruleIntegerRange"


    // $ANTLR start "entryRuleRealRange"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3332:1: entryRuleRealRange returns [EObject current=null] : iv_ruleRealRange= ruleRealRange EOF ;
    public final EObject entryRuleRealRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealRange = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3333:2: (iv_ruleRealRange= ruleRealRange EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3334:2: iv_ruleRealRange= ruleRealRange EOF
            {
             newCompositeNode(grammarAccess.getRealRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRealRange_in_entryRuleRealRange7126);
            iv_ruleRealRange=ruleRealRange();

            state._fsp--;

             current =iv_ruleRealRange; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealRange7136); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3341:1: ruleRealRange returns [EObject current=null] : ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3344:28: ( ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3345:1: ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3345:1: ( ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3345:2: ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) ) otherlv_1= KEYWORD_14 ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3345:2: ( ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3346:1: ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3346:1: ( (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3347:1: (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3347:1: (lv_lowerBound_0_1= ruleRealTerm | lv_lowerBound_0_2= ruleSignedConstant | lv_lowerBound_0_3= ruleConstantValue )
            int alt48=3;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==RULE_REAL_LIT) ) {
                    alt48=1;
                }
                else if ( (LA48_1==RULE_ID) ) {
                    alt48=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
                }
                break;
            case KEYWORD_6:
                {
                int LA48_2 = input.LA(2);

                if ( (LA48_2==RULE_REAL_LIT) ) {
                    alt48=1;
                }
                else if ( (LA48_2==RULE_ID) ) {
                    alt48=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_LIT:
                {
                alt48=1;
                }
                break;
            case RULE_ID:
                {
                alt48=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3348:3: lv_lowerBound_0_1= ruleRealTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundRealTermParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_ruleRealRange7184);
                    lv_lowerBound_0_1=ruleRealTerm();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3363:8: lv_lowerBound_0_2= ruleSignedConstant
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundSignedConstantParserRuleCall_0_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_ruleRealRange7203);
                    lv_lowerBound_0_2=ruleSignedConstant();

                    state._fsp--;


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
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3378:8: lv_lowerBound_0_3= ruleConstantValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealRangeAccess().getLowerBoundConstantValueParserRuleCall_0_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleRealRange7222);
                    lv_lowerBound_0_3=ruleConstantValue();

                    state._fsp--;


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
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,KEYWORD_14,FollowSets000.FOLLOW_KEYWORD_14_in_ruleRealRange7238); 

                	newLeafNode(otherlv_1, grammarAccess.getRealRangeAccess().getFullStopFullStopKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3401:1: ( ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3402:1: ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3402:1: ( (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3403:1: (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3403:1: (lv_upperBound_2_1= ruleRealTerm | lv_upperBound_2_2= ruleSignedConstant | lv_upperBound_2_3= ruleConstantValue )
            int alt49=3;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==RULE_ID) ) {
                    alt49=2;
                }
                else if ( (LA49_1==RULE_REAL_LIT) ) {
                    alt49=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
                }
                break;
            case KEYWORD_6:
                {
                int LA49_2 = input.LA(2);

                if ( (LA49_2==RULE_ID) ) {
                    alt49=2;
                }
                else if ( (LA49_2==RULE_REAL_LIT) ) {
                    alt49=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_REAL_LIT:
                {
                alt49=1;
                }
                break;
            case RULE_ID:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3404:3: lv_upperBound_2_1= ruleRealTerm
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundRealTermParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_ruleRealRange7260);
                    lv_upperBound_2_1=ruleRealTerm();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3419:8: lv_upperBound_2_2= ruleSignedConstant
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundSignedConstantParserRuleCall_2_0_1()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_ruleRealRange7279);
                    lv_upperBound_2_2=ruleSignedConstant();

                    state._fsp--;


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
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3434:8: lv_upperBound_2_3= ruleConstantValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealRangeAccess().getUpperBoundConstantValueParserRuleCall_2_0_2()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleRealRange7298);
                    lv_upperBound_2_3=ruleConstantValue();

                    state._fsp--;


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
                    break;

            }


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
    // $ANTLR end "ruleRealRange"


    // $ANTLR start "entryRuleCoreKeyWord"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3460:1: entryRuleCoreKeyWord returns [String current=null] : iv_ruleCoreKeyWord= ruleCoreKeyWord EOF ;
    public final String entryRuleCoreKeyWord() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCoreKeyWord = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3461:1: (iv_ruleCoreKeyWord= ruleCoreKeyWord EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3462:2: iv_ruleCoreKeyWord= ruleCoreKeyWord EOF
            {
             newCompositeNode(grammarAccess.getCoreKeyWordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCoreKeyWord_in_entryRuleCoreKeyWord7337);
            iv_ruleCoreKeyWord=ruleCoreKeyWord();

            state._fsp--;

             current =iv_ruleCoreKeyWord.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCoreKeyWord7348); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCoreKeyWord"


    // $ANTLR start "ruleCoreKeyWord"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3469:1: ruleCoreKeyWord returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_51 | kw= KEYWORD_52 | kw= KEYWORD_42 | kw= KEYWORD_58 | kw= KEYWORD_29 | kw= KEYWORD_65 | kw= KEYWORD_48 | kw= KEYWORD_47 | kw= KEYWORD_25 | kw= KEYWORD_59 | kw= KEYWORD_70 | kw= KEYWORD_55 | kw= KEYWORD_57 | kw= KEYWORD_64 | kw= KEYWORD_33 | kw= KEYWORD_38 | kw= KEYWORD_40 | kw= KEYWORD_30 | kw= KEYWORD_74 | kw= KEYWORD_35 | kw= KEYWORD_32 | kw= KEYWORD_66 | kw= KEYWORD_21 | kw= KEYWORD_26 | kw= KEYWORD_61 | kw= KEYWORD_46 | kw= KEYWORD_69 ) ;
    public final AntlrDatatypeRuleToken ruleCoreKeyWord() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3473:6: ( (kw= KEYWORD_51 | kw= KEYWORD_52 | kw= KEYWORD_42 | kw= KEYWORD_58 | kw= KEYWORD_29 | kw= KEYWORD_65 | kw= KEYWORD_48 | kw= KEYWORD_47 | kw= KEYWORD_25 | kw= KEYWORD_59 | kw= KEYWORD_70 | kw= KEYWORD_55 | kw= KEYWORD_57 | kw= KEYWORD_64 | kw= KEYWORD_33 | kw= KEYWORD_38 | kw= KEYWORD_40 | kw= KEYWORD_30 | kw= KEYWORD_74 | kw= KEYWORD_35 | kw= KEYWORD_32 | kw= KEYWORD_66 | kw= KEYWORD_21 | kw= KEYWORD_26 | kw= KEYWORD_61 | kw= KEYWORD_46 | kw= KEYWORD_69 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3474:1: (kw= KEYWORD_51 | kw= KEYWORD_52 | kw= KEYWORD_42 | kw= KEYWORD_58 | kw= KEYWORD_29 | kw= KEYWORD_65 | kw= KEYWORD_48 | kw= KEYWORD_47 | kw= KEYWORD_25 | kw= KEYWORD_59 | kw= KEYWORD_70 | kw= KEYWORD_55 | kw= KEYWORD_57 | kw= KEYWORD_64 | kw= KEYWORD_33 | kw= KEYWORD_38 | kw= KEYWORD_40 | kw= KEYWORD_30 | kw= KEYWORD_74 | kw= KEYWORD_35 | kw= KEYWORD_32 | kw= KEYWORD_66 | kw= KEYWORD_21 | kw= KEYWORD_26 | kw= KEYWORD_61 | kw= KEYWORD_46 | kw= KEYWORD_69 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3474:1: (kw= KEYWORD_51 | kw= KEYWORD_52 | kw= KEYWORD_42 | kw= KEYWORD_58 | kw= KEYWORD_29 | kw= KEYWORD_65 | kw= KEYWORD_48 | kw= KEYWORD_47 | kw= KEYWORD_25 | kw= KEYWORD_59 | kw= KEYWORD_70 | kw= KEYWORD_55 | kw= KEYWORD_57 | kw= KEYWORD_64 | kw= KEYWORD_33 | kw= KEYWORD_38 | kw= KEYWORD_40 | kw= KEYWORD_30 | kw= KEYWORD_74 | kw= KEYWORD_35 | kw= KEYWORD_32 | kw= KEYWORD_66 | kw= KEYWORD_21 | kw= KEYWORD_26 | kw= KEYWORD_61 | kw= KEYWORD_46 | kw= KEYWORD_69 )
            int alt50=27;
            switch ( input.LA(1) ) {
            case KEYWORD_51:
                {
                alt50=1;
                }
                break;
            case KEYWORD_52:
                {
                alt50=2;
                }
                break;
            case KEYWORD_42:
                {
                alt50=3;
                }
                break;
            case KEYWORD_58:
                {
                alt50=4;
                }
                break;
            case KEYWORD_29:
                {
                alt50=5;
                }
                break;
            case KEYWORD_65:
                {
                alt50=6;
                }
                break;
            case KEYWORD_48:
                {
                alt50=7;
                }
                break;
            case KEYWORD_47:
                {
                alt50=8;
                }
                break;
            case KEYWORD_25:
                {
                alt50=9;
                }
                break;
            case KEYWORD_59:
                {
                alt50=10;
                }
                break;
            case KEYWORD_70:
                {
                alt50=11;
                }
                break;
            case KEYWORD_55:
                {
                alt50=12;
                }
                break;
            case KEYWORD_57:
                {
                alt50=13;
                }
                break;
            case KEYWORD_64:
                {
                alt50=14;
                }
                break;
            case KEYWORD_33:
                {
                alt50=15;
                }
                break;
            case KEYWORD_38:
                {
                alt50=16;
                }
                break;
            case KEYWORD_40:
                {
                alt50=17;
                }
                break;
            case KEYWORD_30:
                {
                alt50=18;
                }
                break;
            case KEYWORD_74:
                {
                alt50=19;
                }
                break;
            case KEYWORD_35:
                {
                alt50=20;
                }
                break;
            case KEYWORD_32:
                {
                alt50=21;
                }
                break;
            case KEYWORD_66:
                {
                alt50=22;
                }
                break;
            case KEYWORD_21:
                {
                alt50=23;
                }
                break;
            case KEYWORD_26:
                {
                alt50=24;
                }
                break;
            case KEYWORD_61:
                {
                alt50=25;
                }
                break;
            case KEYWORD_46:
                {
                alt50=26;
                }
                break;
            case KEYWORD_69:
                {
                alt50=27;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3475:2: kw= KEYWORD_51
                    {
                    kw=(Token)match(input,KEYWORD_51,FollowSets000.FOLLOW_KEYWORD_51_in_ruleCoreKeyWord7386); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getSystemKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3482:2: kw= KEYWORD_52
                    {
                    kw=(Token)match(input,KEYWORD_52,FollowSets000.FOLLOW_KEYWORD_52_in_ruleCoreKeyWord7405); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getThreadKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3489:2: kw= KEYWORD_42
                    {
                    kw=(Token)match(input,KEYWORD_42,FollowSets000.FOLLOW_KEYWORD_42_in_ruleCoreKeyWord7424); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getGroupKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3496:2: kw= KEYWORD_58
                    {
                    kw=(Token)match(input,KEYWORD_58,FollowSets000.FOLLOW_KEYWORD_58_in_ruleCoreKeyWord7443); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getProcessKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3503:2: kw= KEYWORD_29
                    {
                    kw=(Token)match(input,KEYWORD_29,FollowSets000.FOLLOW_KEYWORD_29_in_ruleCoreKeyWord7462); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getDataKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3510:2: kw= KEYWORD_65
                    {
                    kw=(Token)match(input,KEYWORD_65,FollowSets000.FOLLOW_KEYWORD_65_in_ruleCoreKeyWord7481); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getProcessorKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3517:2: kw= KEYWORD_48
                    {
                    kw=(Token)match(input,KEYWORD_48,FollowSets000.FOLLOW_KEYWORD_48_in_ruleCoreKeyWord7500); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getMemoryKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3524:2: kw= KEYWORD_47
                    {
                    kw=(Token)match(input,KEYWORD_47,FollowSets000.FOLLOW_KEYWORD_47_in_ruleCoreKeyWord7519); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getDeviceKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3531:2: kw= KEYWORD_25
                    {
                    kw=(Token)match(input,KEYWORD_25,FollowSets000.FOLLOW_KEYWORD_25_in_ruleCoreKeyWord7538); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getBusKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3538:2: kw= KEYWORD_59
                    {
                    kw=(Token)match(input,KEYWORD_59,FollowSets000.FOLLOW_KEYWORD_59_in_ruleCoreKeyWord7557); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getVirtualKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3545:2: kw= KEYWORD_70
                    {
                    kw=(Token)match(input,KEYWORD_70,FollowSets000.FOLLOW_KEYWORD_70_in_ruleCoreKeyWord7576); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getSubprogramKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3552:2: kw= KEYWORD_55
                    {
                    kw=(Token)match(input,KEYWORD_55,FollowSets000.FOLLOW_KEYWORD_55_in_ruleCoreKeyWord7595); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getFeatureKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3559:2: kw= KEYWORD_57
                    {
                    kw=(Token)match(input,KEYWORD_57,FollowSets000.FOLLOW_KEYWORD_57_in_ruleCoreKeyWord7614); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getPackageKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3566:2: kw= KEYWORD_64
                    {
                    kw=(Token)match(input,KEYWORD_64,FollowSets000.FOLLOW_KEYWORD_64_in_ruleCoreKeyWord7633); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getParameterKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3573:2: kw= KEYWORD_33
                    {
                    kw=(Token)match(input,KEYWORD_33,FollowSets000.FOLLOW_KEYWORD_33_in_ruleCoreKeyWord7652); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getPortKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3580:2: kw= KEYWORD_38
                    {
                    kw=(Token)match(input,KEYWORD_38,FollowSets000.FOLLOW_KEYWORD_38_in_ruleCoreKeyWord7671); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getCallsKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3587:2: kw= KEYWORD_40
                    {
                    kw=(Token)match(input,KEYWORD_40,FollowSets000.FOLLOW_KEYWORD_40_in_ruleCoreKeyWord7690); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getEventKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3594:2: kw= KEYWORD_30
                    {
                    kw=(Token)match(input,KEYWORD_30,FollowSets000.FOLLOW_KEYWORD_30_in_ruleCoreKeyWord7709); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getFlowKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3601:2: kw= KEYWORD_74
                    {
                    kw=(Token)match(input,KEYWORD_74,FollowSets000.FOLLOW_KEYWORD_74_in_ruleCoreKeyWord7728); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getImplementationKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3608:2: kw= KEYWORD_35
                    {
                    kw=(Token)match(input,KEYWORD_35,FollowSets000.FOLLOW_KEYWORD_35_in_ruleCoreKeyWord7747); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getTypeKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3615:2: kw= KEYWORD_32
                    {
                    kw=(Token)match(input,KEYWORD_32,FollowSets000.FOLLOW_KEYWORD_32_in_ruleCoreKeyWord7766); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getModeKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3622:2: kw= KEYWORD_66
                    {
                    kw=(Token)match(input,KEYWORD_66,FollowSets000.FOLLOW_KEYWORD_66_in_ruleCoreKeyWord7785); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getPrototypeKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3629:2: kw= KEYWORD_21
                    {
                    kw=(Token)match(input,KEYWORD_21,FollowSets000.FOLLOW_KEYWORD_21_in_ruleCoreKeyWord7804); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getToKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3636:2: kw= KEYWORD_26
                    {
                    kw=(Token)match(input,KEYWORD_26,FollowSets000.FOLLOW_KEYWORD_26_in_ruleCoreKeyWord7823); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getEndKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3643:2: kw= KEYWORD_61
                    {
                    kw=(Token)match(input,KEYWORD_61,FollowSets000.FOLLOW_KEYWORD_61_in_ruleCoreKeyWord7842); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getAbstractKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3650:2: kw= KEYWORD_46
                    {
                    kw=(Token)match(input,KEYWORD_46,FollowSets000.FOLLOW_KEYWORD_46_in_ruleCoreKeyWord7861); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getAccessKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3657:2: kw= KEYWORD_69
                    {
                    kw=(Token)match(input,KEYWORD_69,FollowSets000.FOLLOW_KEYWORD_69_in_ruleCoreKeyWord7880); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCoreKeyWordAccess().getClassifierKeyword_26()); 
                        

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
    // $ANTLR end "ruleCoreKeyWord"


    // $ANTLR start "entryRuleFQCREF"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3670:1: entryRuleFQCREF returns [String current=null] : iv_ruleFQCREF= ruleFQCREF EOF ;
    public final String entryRuleFQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3671:1: (iv_ruleFQCREF= ruleFQCREF EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3672:2: iv_ruleFQCREF= ruleFQCREF EOF
            {
             newCompositeNode(grammarAccess.getFQCREFRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQCREF_in_entryRuleFQCREF7920);
            iv_ruleFQCREF=ruleFQCREF();

            state._fsp--;

             current =iv_ruleFQCREF.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQCREF7931); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQCREF"


    // $ANTLR start "ruleFQCREF"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3679:1: ruleFQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= KEYWORD_15 )+ this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleFQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3683:6: ( ( (this_ID_0= RULE_ID kw= KEYWORD_15 )+ this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3684:1: ( (this_ID_0= RULE_ID kw= KEYWORD_15 )+ this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3684:1: ( (this_ID_0= RULE_ID kw= KEYWORD_15 )+ this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3684:2: (this_ID_0= RULE_ID kw= KEYWORD_15 )+ this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3684:2: (this_ID_0= RULE_ID kw= KEYWORD_15 )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_1 = input.LA(2);

                    if ( (LA51_1==KEYWORD_15) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3684:7: this_ID_0= RULE_ID kw= KEYWORD_15
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQCREF7972); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_ruleFQCREF7990); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQCREF8007); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3704:1: (kw= KEYWORD_7 this_ID_4= RULE_ID )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==KEYWORD_7) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3705:2: kw= KEYWORD_7 this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleFQCREF8026); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQCREF8041); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

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
    // $ANTLR end "ruleFQCREF"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3727:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3728:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3729:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation8089);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;

             current =iv_ruleContainedPropertyAssociation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainedPropertyAssociation8099); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3736:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_16 | ( (lv_append_2_0= KEYWORD_22 ) ) ) ( (lv_constant_3_0= KEYWORD_62 ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? otherlv_12= KEYWORD_9 ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_9_0 = null;

        EObject lv_appliesTo_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3739:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_16 | ( (lv_append_2_0= KEYWORD_22 ) ) ) ( (lv_constant_3_0= KEYWORD_62 ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? otherlv_12= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3740:1: ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_16 | ( (lv_append_2_0= KEYWORD_22 ) ) ) ( (lv_constant_3_0= KEYWORD_62 ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? otherlv_12= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3740:1: ( ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_16 | ( (lv_append_2_0= KEYWORD_22 ) ) ) ( (lv_constant_3_0= KEYWORD_62 ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? otherlv_12= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3740:2: ( ( ruleQPREF ) ) (otherlv_1= KEYWORD_16 | ( (lv_append_2_0= KEYWORD_22 ) ) ) ( (lv_constant_3_0= KEYWORD_62 ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? otherlv_12= KEYWORD_9
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3740:2: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3741:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3741:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3742:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation8147);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3755:2: (otherlv_1= KEYWORD_16 | ( (lv_append_2_0= KEYWORD_22 ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==KEYWORD_16) ) {
                alt53=1;
            }
            else if ( (LA53_0==KEYWORD_22) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3756:2: otherlv_1= KEYWORD_16
                    {
                    otherlv_1=(Token)match(input,KEYWORD_16,FollowSets000.FOLLOW_KEYWORD_16_in_ruleContainedPropertyAssociation8161); 

                        	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3761:6: ( (lv_append_2_0= KEYWORD_22 ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3761:6: ( (lv_append_2_0= KEYWORD_22 ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3762:1: (lv_append_2_0= KEYWORD_22 )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3762:1: (lv_append_2_0= KEYWORD_22 )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3763:3: lv_append_2_0= KEYWORD_22
                    {
                    lv_append_2_0=(Token)match(input,KEYWORD_22,FollowSets000.FOLLOW_KEYWORD_22_in_ruleContainedPropertyAssociation8185); 

                            newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "append", true, "+=>");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3777:3: ( (lv_constant_3_0= KEYWORD_62 ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==KEYWORD_62) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3778:1: (lv_constant_3_0= KEYWORD_62 )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3778:1: (lv_constant_3_0= KEYWORD_62 )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3779:3: lv_constant_3_0= KEYWORD_62
                    {
                    lv_constant_3_0=(Token)match(input,KEYWORD_62,FollowSets000.FOLLOW_KEYWORD_62_in_ruleContainedPropertyAssociation8216); 

                            newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "constant", true, "constant");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3793:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3793:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3793:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3794:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3794:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3795:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation8250);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                   		add(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_4_0, 
                    		"OptionalModalPropertyValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3811:2: (otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==KEYWORD_5) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3812:2: otherlv_5= KEYWORD_5 ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation8264); 

            	        	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3816:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3817:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3817:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3818:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation8284);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedValue",
            	            		lv_ownedValue_6_0, 
            	            		"OptionalModalPropertyValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3834:5: (otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==KEYWORD_53) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3835:2: otherlv_7= KEYWORD_53 otherlv_8= KEYWORD_21 ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,KEYWORD_53,FollowSets000.FOLLOW_KEYWORD_53_in_ruleContainedPropertyAssociation8301); 

                        	newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
                        
                    otherlv_8=(Token)match(input,KEYWORD_21,FollowSets000.FOLLOW_KEYWORD_21_in_ruleContainedPropertyAssociation8313); 

                        	newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3844:1: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3845:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3845:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3846:3: lv_appliesTo_9_0= ruleContainmentPath
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation8333);
                    lv_appliesTo_9_0=ruleContainmentPath();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		add(
                           			current, 
                           			"appliesTo",
                            		lv_appliesTo_9_0, 
                            		"ContainmentPath");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3862:2: (otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==KEYWORD_5) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3863:2: otherlv_10= KEYWORD_5 ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_10=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation8347); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3867:1: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3868:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3868:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3869:3: lv_appliesTo_11_0= ruleContainmentPath
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation8367);
                    	    lv_appliesTo_11_0=ruleContainmentPath();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"appliesTo",
                    	            		lv_appliesTo_11_0, 
                    	            		"ContainmentPath");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_ruleContainedPropertyAssociation8384); 

                	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3902:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3903:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3904:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath8422);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;

             current =iv_ruleContainmentPath; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentPath8432); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3911:1: ruleContainmentPath returns [EObject current=null] : ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_containmentPathElement_1_0 = null;

        EObject lv_containmentPathElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3914:28: ( ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3915:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3915:1: ( () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )* )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3915:2: () ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) ) (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3915:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3916:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getContainmentPathAccess().getContainedNamedElementAction_0(),
                        current);
                

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3921:2: ( (lv_containmentPathElement_1_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3922:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3922:1: (lv_containmentPathElement_1_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3923:3: lv_containmentPathElement_1_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath8487);
            lv_containmentPathElement_1_0=ruleContainmentPathElement();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3939:2: (otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==KEYWORD_7) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3940:2: otherlv_2= KEYWORD_7 ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleContainmentPath8501); 

            	        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathAccess().getFullStopKeyword_2_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3944:1: ( (lv_containmentPathElement_3_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3945:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3945:1: (lv_containmentPathElement_3_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3946:3: lv_containmentPathElement_3_0= ruleContainmentPathElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getContainmentPathAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath8521);
            	    lv_containmentPathElement_3_0=ruleContainmentPathElement();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


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
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRuleOptionalModalPropertyValue"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3972:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3973:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3974:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOptionalModalPropertyValue_in_entryRuleOptionalModalPropertyValue8560);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;

             current =iv_ruleOptionalModalPropertyValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOptionalModalPropertyValue8570); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalModalPropertyValue"


    // $ANTLR start "ruleOptionalModalPropertyValue"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3981:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3984:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3985:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3985:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3985:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3985:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3986:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3986:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:3987:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleOptionalModalPropertyValue8616);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_0_0, 
                    		"PropertyExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4003:2: (otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==KEYWORD_17) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4004:2: otherlv_1= KEYWORD_17 otherlv_2= KEYWORD_43 otherlv_3= KEYWORD_1 ( (otherlv_4= RULE_ID ) ) (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )* otherlv_7= KEYWORD_2
                    {
                    otherlv_1=(Token)match(input,KEYWORD_17,FollowSets000.FOLLOW_KEYWORD_17_in_ruleOptionalModalPropertyValue8630); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,KEYWORD_43,FollowSets000.FOLLOW_KEYWORD_43_in_ruleOptionalModalPropertyValue8642); 

                        	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleOptionalModalPropertyValue8654); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4018:1: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4019:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4019:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4020:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalModalPropertyValue8673); 

                    		newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                    	

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4031:2: (otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) ) )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==KEYWORD_5) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4032:2: otherlv_5= KEYWORD_5 ( (otherlv_6= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleOptionalModalPropertyValue8687); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4036:1: ( (otherlv_6= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4037:1: (otherlv_6= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4037:1: (otherlv_6= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4038:3: otherlv_6= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	    	        }
                    	            
                    	    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOptionalModalPropertyValue8706); 

                    	    		newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleOptionalModalPropertyValue8721); 

                        	newLeafNode(otherlv_7, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5());
                        

                    }
                    break;

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
    // $ANTLR end "ruleOptionalModalPropertyValue"


    // $ANTLR start "entryRulePropertyValue"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4064:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4065:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4066:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertyValue_in_entryRulePropertyValue8759);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;

             current =iv_rulePropertyValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyValue8769); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4073:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4076:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4077:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4077:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4078:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4078:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4079:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_rulePropertyValue8814);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


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
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRulePropertyExpression"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4103:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4104:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4105:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression8848);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;

             current =iv_rulePropertyExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePropertyExpression8858); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4112:1: rulePropertyExpression returns [EObject current=null] : (this_OldRecordTerm_0= ruleOldRecordTerm | this_RecordTerm_1= ruleRecordTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OldRecordTerm_0 = null;

        EObject this_RecordTerm_1 = null;

        EObject this_ReferenceTerm_2 = null;

        EObject this_ComponentClassifierTerm_3 = null;

        EObject this_ComputedTerm_4 = null;

        EObject this_StringTerm_5 = null;

        EObject this_NumericRangeTerm_6 = null;

        EObject this_RealTerm_7 = null;

        EObject this_IntegerTerm_8 = null;

        EObject this_ListTerm_9 = null;

        EObject this_BooleanLiteral_10 = null;

        EObject this_LiteralorReferenceTerm_11 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4115:28: ( (this_OldRecordTerm_0= ruleOldRecordTerm | this_RecordTerm_1= ruleRecordTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4116:1: (this_OldRecordTerm_0= ruleOldRecordTerm | this_RecordTerm_1= ruleRecordTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4116:1: (this_OldRecordTerm_0= ruleOldRecordTerm | this_RecordTerm_1= ruleRecordTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            int alt61=12;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4117:5: this_OldRecordTerm_0= ruleOldRecordTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getOldRecordTermParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOldRecordTerm_in_rulePropertyExpression8905);
                    this_OldRecordTerm_0=ruleOldRecordTerm();

                    state._fsp--;


                            current = this_OldRecordTerm_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4127:5: this_RecordTerm_1= ruleRecordTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRecordTerm_in_rulePropertyExpression8932);
                    this_RecordTerm_1=ruleRecordTerm();

                    state._fsp--;


                            current = this_RecordTerm_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4137:5: this_ReferenceTerm_2= ruleReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceTerm_in_rulePropertyExpression8959);
                    this_ReferenceTerm_2=ruleReferenceTerm();

                    state._fsp--;


                            current = this_ReferenceTerm_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4147:5: this_ComponentClassifierTerm_3= ruleComponentClassifierTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression8986);
                    this_ComponentClassifierTerm_3=ruleComponentClassifierTerm();

                    state._fsp--;


                            current = this_ComponentClassifierTerm_3;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4157:5: this_ComputedTerm_4= ruleComputedTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleComputedTerm_in_rulePropertyExpression9013);
                    this_ComputedTerm_4=ruleComputedTerm();

                    state._fsp--;


                            current = this_ComputedTerm_4;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4167:5: this_StringTerm_5= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringTerm_in_rulePropertyExpression9040);
                    this_StringTerm_5=ruleStringTerm();

                    state._fsp--;


                            current = this_StringTerm_5;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4177:5: this_NumericRangeTerm_6= ruleNumericRangeTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression9067);
                    this_NumericRangeTerm_6=ruleNumericRangeTerm();

                    state._fsp--;


                            current = this_NumericRangeTerm_6;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4187:5: this_RealTerm_7= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_rulePropertyExpression9094);
                    this_RealTerm_7=ruleRealTerm();

                    state._fsp--;


                            current = this_RealTerm_7;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4197:5: this_IntegerTerm_8= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_rulePropertyExpression9121);
                    this_IntegerTerm_8=ruleIntegerTerm();

                    state._fsp--;


                            current = this_IntegerTerm_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4207:5: this_ListTerm_9= ruleListTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListTerm_in_rulePropertyExpression9148);
                    this_ListTerm_9=ruleListTerm();

                    state._fsp--;


                            current = this_ListTerm_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4217:5: this_BooleanLiteral_10= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_rulePropertyExpression9175);
                    this_BooleanLiteral_10=ruleBooleanLiteral();

                    state._fsp--;


                            current = this_BooleanLiteral_10;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4227:5: this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression9202);
                    this_LiteralorReferenceTerm_11=ruleLiteralorReferenceTerm();

                    state._fsp--;


                            current = this_LiteralorReferenceTerm_11;
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


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4243:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4244:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4245:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm9236);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;

             current =iv_ruleLiteralorReferenceTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm9246); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4252:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4255:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4256:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4256:1: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4257:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4257:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4258:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm9293);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4279:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4280:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4281:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral9327);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteral9337); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4288:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= KEYWORD_34 ) ) | otherlv_2= KEYWORD_41 ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4291:28: ( ( () ( ( (lv_value_1_0= KEYWORD_34 ) ) | otherlv_2= KEYWORD_41 ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4292:1: ( () ( ( (lv_value_1_0= KEYWORD_34 ) ) | otherlv_2= KEYWORD_41 ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4292:1: ( () ( ( (lv_value_1_0= KEYWORD_34 ) ) | otherlv_2= KEYWORD_41 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4292:2: () ( ( (lv_value_1_0= KEYWORD_34 ) ) | otherlv_2= KEYWORD_41 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4292:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4293:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4298:2: ( ( (lv_value_1_0= KEYWORD_34 ) ) | otherlv_2= KEYWORD_41 )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==KEYWORD_34) ) {
                alt62=1;
            }
            else if ( (LA62_0==KEYWORD_41) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4298:3: ( (lv_value_1_0= KEYWORD_34 ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4298:3: ( (lv_value_1_0= KEYWORD_34 ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4299:1: (lv_value_1_0= KEYWORD_34 )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4299:1: (lv_value_1_0= KEYWORD_34 )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4300:3: lv_value_1_0= KEYWORD_34
                    {
                    lv_value_1_0=(Token)match(input,KEYWORD_34,FollowSets000.FOLLOW_KEYWORD_34_in_ruleBooleanLiteral9391); 

                            newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "value", true, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4316:2: otherlv_2= KEYWORD_41
                    {
                    otherlv_2=(Token)match(input,KEYWORD_41,FollowSets000.FOLLOW_KEYWORD_41_in_ruleBooleanLiteral9421); 

                        	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                        

                    }
                    break;

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
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4328:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4329:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4330:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_entryRuleConstantValue9456);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstantValue9466); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4337:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4340:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4341:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4341:1: ( ( ruleQPREF ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4342:1: ( ruleQPREF )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4342:1: ( ruleQPREF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4343:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_ruleConstantValue9513);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleReferenceTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4364:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4365:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4366:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getReferenceTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm9547);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;

             current =iv_ruleReferenceTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceTerm9557); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4373:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= KEYWORD_67 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4376:28: ( (otherlv_0= KEYWORD_67 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4377:1: (otherlv_0= KEYWORD_67 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4377:1: (otherlv_0= KEYWORD_67 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4378:2: otherlv_0= KEYWORD_67 otherlv_1= KEYWORD_1 ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) ) (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )* otherlv_5= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_67,FollowSets000.FOLLOW_KEYWORD_67_in_ruleReferenceTerm9595); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleReferenceTerm9607); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4387:1: ( (lv_containmentPathElement_2_0= ruleContainmentPathElement ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4388:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4388:1: (lv_containmentPathElement_2_0= ruleContainmentPathElement )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4389:3: lv_containmentPathElement_2_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm9627);
            lv_containmentPathElement_2_0=ruleContainmentPathElement();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4405:2: (otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==KEYWORD_7) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4406:2: otherlv_3= KEYWORD_7 ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleReferenceTerm9641); 

            	        	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getFullStopKeyword_3_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4410:1: ( (lv_containmentPathElement_4_0= ruleContainmentPathElement ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4411:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4411:1: (lv_containmentPathElement_4_0= ruleContainmentPathElement )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4412:3: lv_containmentPathElement_4_0= ruleContainmentPathElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getReferenceTermAccess().getContainmentPathElementContainmentPathElementParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm9661);
            	    lv_containmentPathElement_4_0=ruleContainmentPathElement();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleReferenceTerm9676); 

                	newLeafNode(otherlv_5, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_4());
                

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
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4441:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4442:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4443:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
             newCompositeNode(grammarAccess.getRecordTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm9710);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;

             current =iv_ruleRecordTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecordTerm9720); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4450:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= KEYWORD_10 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_11 ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4453:28: ( (otherlv_0= KEYWORD_10 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_11 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4454:1: (otherlv_0= KEYWORD_10 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_11 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4454:1: (otherlv_0= KEYWORD_10 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_11 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4455:2: otherlv_0= KEYWORD_10 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_11
            {
            otherlv_0=(Token)match(input,KEYWORD_10,FollowSets000.FOLLOW_KEYWORD_10_in_ruleRecordTerm9758); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4459:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4460:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4460:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4461:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm9778);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;


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
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);

            otherlv_2=(Token)match(input,KEYWORD_11,FollowSets000.FOLLOW_KEYWORD_11_in_ruleRecordTerm9792); 

                	newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
                

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
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleOldRecordTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4490:1: entryRuleOldRecordTerm returns [EObject current=null] : iv_ruleOldRecordTerm= ruleOldRecordTerm EOF ;
    public final EObject entryRuleOldRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOldRecordTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4491:2: (iv_ruleOldRecordTerm= ruleOldRecordTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4492:2: iv_ruleOldRecordTerm= ruleOldRecordTerm EOF
            {
             newCompositeNode(grammarAccess.getOldRecordTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOldRecordTerm_in_entryRuleOldRecordTerm9826);
            iv_ruleOldRecordTerm=ruleOldRecordTerm();

            state._fsp--;

             current =iv_ruleOldRecordTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOldRecordTerm9836); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOldRecordTerm"


    // $ANTLR start "ruleOldRecordTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4499:1: ruleOldRecordTerm returns [EObject current=null] : (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 ) ;
    public final EObject ruleOldRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4502:28: ( (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4503:1: (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4503:1: (otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4504:2: otherlv_0= KEYWORD_1 ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleOldRecordTerm9874); 

                	newLeafNode(otherlv_0, grammarAccess.getOldRecordTermAccess().getLeftParenthesisKeyword_0());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4508:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
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
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4509:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4509:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4510:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOldRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFieldPropertyAssociation_in_ruleOldRecordTerm9894);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOldRecordTermRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedFieldValue",
            	            		lv_ownedFieldValue_1_0, 
            	            		"FieldPropertyAssociation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
            } while (true);

            otherlv_2=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleOldRecordTerm9908); 

                	newLeafNode(otherlv_2, grammarAccess.getOldRecordTermAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleOldRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4539:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4540:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4541:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
             newCompositeNode(grammarAccess.getComputedTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm9942);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;

             current =iv_ruleComputedTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComputedTerm9952); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4548:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= KEYWORD_54 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4551:28: ( (otherlv_0= KEYWORD_54 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4552:1: (otherlv_0= KEYWORD_54 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4552:1: (otherlv_0= KEYWORD_54 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4553:2: otherlv_0= KEYWORD_54 otherlv_1= KEYWORD_1 ( (lv_function_2_0= RULE_ID ) ) otherlv_3= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_54,FollowSets000.FOLLOW_KEYWORD_54_in_ruleComputedTerm9990); 

                	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleComputedTerm10002); 

                	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4562:1: ( (lv_function_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4563:1: (lv_function_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4563:1: (lv_function_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4564:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComputedTerm10018); 

            			newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); 
            		

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

            otherlv_3=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleComputedTerm10036); 

                	newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4593:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4594:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4595:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
             newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm10070);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;

             current =iv_ruleComponentClassifierTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComponentClassifierTerm10080); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4602:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= KEYWORD_69 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4605:28: ( (otherlv_0= KEYWORD_69 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4606:1: (otherlv_0= KEYWORD_69 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4606:1: (otherlv_0= KEYWORD_69 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4607:2: otherlv_0= KEYWORD_69 otherlv_1= KEYWORD_1 ( ( ruleQCREF ) ) otherlv_3= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_69,FollowSets000.FOLLOW_KEYWORD_69_in_ruleComponentClassifierTerm10118); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleComponentClassifierTerm10130); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4616:1: ( ( ruleQCREF ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4617:1: ( ruleQCREF )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4617:1: ( ruleQCREF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4618:3: ruleQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm10152);
            ruleQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleComponentClassifierTerm10165); 

                	newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4644:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4645:2: (iv_ruleListTerm= ruleListTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4646:2: iv_ruleListTerm= ruleListTerm EOF
            {
             newCompositeNode(grammarAccess.getListTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListTerm_in_entryRuleListTerm10199);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;

             current =iv_ruleListTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListTerm10209); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4653:1: ruleListTerm returns [EObject current=null] : (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedListElement_1_0 = null;

        EObject lv_ownedListElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4656:28: ( (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4657:1: (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4657:1: (otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4658:2: otherlv_0= KEYWORD_1 ( (lv_ownedListElement_1_0= rulePropertyExpression ) ) (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )* otherlv_4= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_1,FollowSets000.FOLLOW_KEYWORD_1_in_ruleListTerm10247); 

                	newLeafNode(otherlv_0, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_0());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4662:1: ( (lv_ownedListElement_1_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4663:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4663:1: (lv_ownedListElement_1_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4664:3: lv_ownedListElement_1_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleListTerm10267);
            lv_ownedListElement_1_0=rulePropertyExpression();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4680:2: (otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==KEYWORD_5) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4681:2: otherlv_2= KEYWORD_5 ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,KEYWORD_5,FollowSets000.FOLLOW_KEYWORD_5_in_ruleListTerm10281); 

            	        	newLeafNode(otherlv_2, grammarAccess.getListTermAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4685:1: ( (lv_ownedListElement_3_0= rulePropertyExpression ) )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4686:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4686:1: (lv_ownedListElement_3_0= rulePropertyExpression )
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4687:3: lv_ownedListElement_3_0= rulePropertyExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleListTerm10301);
            	    lv_ownedListElement_3_0=rulePropertyExpression();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            otherlv_4=(Token)match(input,KEYWORD_2,FollowSets000.FOLLOW_KEYWORD_2_in_ruleListTerm10316); 

                	newLeafNode(otherlv_4, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4716:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4717:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4718:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation10350);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;

             current =iv_ruleFieldPropertyAssociation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFieldPropertyAssociation10360); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4725:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_9 ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4728:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_9 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4729:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_9 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4729:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_9 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4729:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= KEYWORD_16 ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= KEYWORD_9
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4729:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4730:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4730:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4731:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation10405); 

            		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_16,FollowSets000.FOLLOW_KEYWORD_16_in_ruleFieldPropertyAssociation10418); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4747:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4748:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4748:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4749:3: lv_ownedValue_2_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation10438);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;


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

            otherlv_3=(Token)match(input,KEYWORD_9,FollowSets000.FOLLOW_KEYWORD_9_in_ruleFieldPropertyAssociation10451); 

                	newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPathElement"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4778:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4779:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4780:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement10485);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;

             current =iv_ruleContainmentPathElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContainmentPathElement10495); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4787:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) ) ) ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4790:28: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4791:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4791:1: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? ) | (otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                alt68=1;
            }
            else if ( (LA68_0==KEYWORD_37) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4791:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4791:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4791:3: ( (otherlv_0= RULE_ID ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4791:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4792:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4792:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4793:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleContainmentPathElement10541); 

                    		newLeafNode(otherlv_0, grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0_0()); 
                    	

                    }


                    }

                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4804:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==KEYWORD_10) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4805:1: (lv_arrayRange_1_0= ruleArrayRange )
                            {
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4805:1: (lv_arrayRange_1_0= ruleArrayRange )
                            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4806:3: lv_arrayRange_1_0= ruleArrayRange
                            {
                             
                            	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_0_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleArrayRange_in_ruleContainmentPathElement10562);
                            lv_arrayRange_1_0=ruleArrayRange();

                            state._fsp--;


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
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4823:6: (otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) ) )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4823:6: (otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4824:2: otherlv_2= KEYWORD_37 ( ( ruleANNEXREF ) )
                    {
                    otherlv_2=(Token)match(input,KEYWORD_37,FollowSets000.FOLLOW_KEYWORD_37_in_ruleContainmentPathElement10584); 

                        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getAnnexKeyword_1_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4828:1: ( ( ruleANNEXREF ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4829:1: ( ruleANNEXREF )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4829:1: ( ruleANNEXREF )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4830:3: ruleANNEXREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement10606);
                    ruleANNEXREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


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
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRuleANNEXREF"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4851:1: entryRuleANNEXREF returns [String current=null] : iv_ruleANNEXREF= ruleANNEXREF EOF ;
    public final String entryRuleANNEXREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleANNEXREF = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4852:1: (iv_ruleANNEXREF= ruleANNEXREF EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4853:2: iv_ruleANNEXREF= ruleANNEXREF EOF
            {
             newCompositeNode(grammarAccess.getANNEXREFRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF10643);
            iv_ruleANNEXREF=ruleANNEXREF();

            state._fsp--;

             current =iv_ruleANNEXREF.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleANNEXREF10654); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4860:1: ruleANNEXREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_12 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_13 ) ;
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
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4864:6: ( (kw= KEYWORD_12 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_13 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4865:1: (kw= KEYWORD_12 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_13 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4865:1: (kw= KEYWORD_12 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_13 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4866:2: kw= KEYWORD_12 this_STAR_1= ruleSTAR this_STAR_2= ruleSTAR this_ID_3= RULE_ID this_STAR_4= ruleSTAR this_STAR_5= ruleSTAR kw= KEYWORD_13
            {
            kw=(Token)match(input,KEYWORD_12,FollowSets000.FOLLOW_KEYWORD_12_in_ruleANNEXREF10692); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getANNEXREFAccess().getLeftCurlyBracketKeyword_0()); 
                
             
                    newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF10714);
            this_STAR_1=ruleSTAR();

            state._fsp--;


            		current.merge(this_STAR_1);
                
             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_2()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF10741);
            this_STAR_2=ruleSTAR();

            state._fsp--;


            		current.merge(this_STAR_2);
                
             
                    afterParserOrEnumRuleCall();
                
            this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleANNEXREF10761); 

            		current.merge(this_ID_3);
                
             
                newLeafNode(this_ID_3, grammarAccess.getANNEXREFAccess().getIDTerminalRuleCall_3()); 
                
             
                    newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_4()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF10788);
            this_STAR_4=ruleSTAR();

            state._fsp--;


            		current.merge(this_STAR_4);
                
             
                    afterParserOrEnumRuleCall();
                
             
                    newCompositeNode(grammarAccess.getANNEXREFAccess().getSTARParserRuleCall_5()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_ruleANNEXREF10815);
            this_STAR_5=ruleSTAR();

            state._fsp--;


            		current.merge(this_STAR_5);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,KEYWORD_13,FollowSets000.FOLLOW_KEYWORD_13_in_ruleANNEXREF10833); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getANNEXREFAccess().getRightCurlyBracketKeyword_6()); 
                

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
    // $ANTLR end "ruleANNEXREF"


    // $ANTLR start "entryRulePlusMinus"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4942:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4943:1: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4944:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusMinusRule()); 
            pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_entryRulePlusMinus10879);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;

             current =iv_rulePlusMinus.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePlusMinus10890); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4951:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_4 | kw= KEYWORD_6 ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4955:6: ( (kw= KEYWORD_4 | kw= KEYWORD_6 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4956:1: (kw= KEYWORD_4 | kw= KEYWORD_6 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4956:1: (kw= KEYWORD_4 | kw= KEYWORD_6 )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==KEYWORD_4) ) {
                alt69=1;
            }
            else if ( (LA69_0==KEYWORD_6) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4957:2: kw= KEYWORD_4
                    {
                    kw=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_rulePlusMinus10928); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4964:2: kw= KEYWORD_6
                    {
                    kw=(Token)match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_rulePlusMinus10947); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); 
                        

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
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4977:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4978:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4979:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringTerm_in_entryRuleStringTerm10986);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringTerm10996); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4986:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4989:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4990:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4990:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4991:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4991:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:4992:3: lv_value_0_0= ruleNoQuoteString
            {
             
            	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNoQuoteString_in_ruleStringTerm11041);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;


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
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5016:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5017:1: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5018:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
             newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString11076);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;

             current =iv_ruleNoQuoteString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNoQuoteString11087); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5025:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5029:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5030:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNoQuoteString11126); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleArrayRange"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5045:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5046:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5047:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
             newCompositeNode(grammarAccess.getArrayRangeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleArrayRange_in_entryRuleArrayRange11169);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;

             current =iv_ruleArrayRange; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleArrayRange11179); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5054:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= KEYWORD_10 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_11 ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5057:28: ( ( () otherlv_1= KEYWORD_10 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_11 ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5058:1: ( () otherlv_1= KEYWORD_10 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_11 )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5058:1: ( () otherlv_1= KEYWORD_10 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_11 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5058:2: () otherlv_1= KEYWORD_10 ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= KEYWORD_11
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5058:2: ()
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5059:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,KEYWORD_10,FollowSets000.FOLLOW_KEYWORD_10_in_ruleArrayRange11226); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5069:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5070:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5070:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5071:3: lv_lowerBound_2_0= ruleINTVALUE
            {
             
            	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleINTVALUE_in_ruleArrayRange11246);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5087:2: (otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==KEYWORD_14) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5088:2: otherlv_3= KEYWORD_14 ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,KEYWORD_14,FollowSets000.FOLLOW_KEYWORD_14_in_ruleArrayRange11260); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5092:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5093:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5093:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5094:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleINTVALUE_in_ruleArrayRange11280);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;


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
                    break;

            }

            otherlv_5=(Token)match(input,KEYWORD_11,FollowSets000.FOLLOW_KEYWORD_11_in_ruleArrayRange11295); 

                	newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRuleSignedConstant"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5123:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5124:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5125:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
             newCompositeNode(grammarAccess.getSignedConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant11329);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;

             current =iv_ruleSignedConstant; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignedConstant11339); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5132:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5135:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5136:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5136:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5136:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5136:2: ( (lv_op_0_0= rulePlusMinus ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5137:1: (lv_op_0_0= rulePlusMinus )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5137:1: (lv_op_0_0= rulePlusMinus )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5138:3: lv_op_0_0= rulePlusMinus
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_rulePlusMinus_in_ruleSignedConstant11385);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5154:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5155:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5155:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5156:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleSignedConstant11406);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;


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
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleIntegerTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5180:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5181:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5182:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm11441);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerTerm11451); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5189:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5192:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5193:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5193:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5193:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5193:2: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5194:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5194:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5195:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSignedInt_in_ruleIntegerTerm11497);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5211:2: ( (otherlv_1= RULE_ID ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5212:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5212:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5213:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIntegerTerm11517); 

                    		newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

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
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleSignedInt"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5232:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5233:1: (iv_ruleSignedInt= ruleSignedInt EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5234:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
             newCompositeNode(grammarAccess.getSignedIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSignedInt_in_entryRuleSignedInt11554);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;

             current =iv_ruleSignedInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignedInt11565); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5241:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5245:6: ( ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5246:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5246:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5246:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5246:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )?
            int alt72=3;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==KEYWORD_4) ) {
                alt72=1;
            }
            else if ( (LA72_0==KEYWORD_6) ) {
                alt72=2;
            }
            switch (alt72) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5247:2: kw= KEYWORD_4
                    {
                    kw=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleSignedInt11604); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5254:2: kw= KEYWORD_6
                    {
                    kw=(Token)match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_ruleSignedInt11623); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt11640); 

            		current.merge(this_INTEGER_LIT_2);
                
             
                newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); 
                

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
    // $ANTLR end "ruleSignedInt"


    // $ANTLR start "entryRuleRealTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5274:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5275:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5276:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_entryRuleRealTerm11684);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRealTerm11694); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5283:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5286:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5287:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5287:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5287:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5287:2: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5288:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5288:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5289:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSignedReal_in_ruleRealTerm11740);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5305:2: ( (otherlv_1= RULE_ID ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5306:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5306:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5307:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRealTerm11760); 

                    		newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

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
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleSignedReal"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5326:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5327:1: (iv_ruleSignedReal= ruleSignedReal EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5328:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
             newCompositeNode(grammarAccess.getSignedRealRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSignedReal_in_entryRuleSignedReal11797);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;

             current =iv_ruleSignedReal.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSignedReal11808); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5335:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5339:6: ( ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5340:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5340:1: ( (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5340:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5340:2: (kw= KEYWORD_4 | kw= KEYWORD_6 )?
            int alt74=3;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==KEYWORD_4) ) {
                alt74=1;
            }
            else if ( (LA74_0==KEYWORD_6) ) {
                alt74=2;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5341:2: kw= KEYWORD_4
                    {
                    kw=(Token)match(input,KEYWORD_4,FollowSets000.FOLLOW_KEYWORD_4_in_ruleSignedReal11847); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5348:2: kw= KEYWORD_6
                    {
                    kw=(Token)match(input,KEYWORD_6,FollowSets000.FOLLOW_KEYWORD_6_in_ruleSignedReal11866); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FollowSets000.FOLLOW_RULE_REAL_LIT_in_ruleSignedReal11883); 

            		current.merge(this_REAL_LIT_2);
                
             
                newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); 
                

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
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5368:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5369:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5370:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
             newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm11927);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;

             current =iv_ruleNumericRangeTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumericRangeTerm11937); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5377:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_14 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5380:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_14 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5381:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_14 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5381:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_14 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5381:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= KEYWORD_14 ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5381:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5382:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5382:1: (lv_minimum_0_0= ruleNumAlt )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5383:3: lv_minimum_0_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm11983);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;


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

            otherlv_1=(Token)match(input,KEYWORD_14,FollowSets000.FOLLOW_KEYWORD_14_in_ruleNumericRangeTerm11996); 

                	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5404:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5405:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5405:1: (lv_maximum_2_0= ruleNumAlt )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5406:3: lv_maximum_2_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm12016);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;


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

            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5422:2: (otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==KEYWORD_39) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5423:2: otherlv_3= KEYWORD_39 ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,KEYWORD_39,FollowSets000.FOLLOW_KEYWORD_39_in_ruleNumericRangeTerm12030); 

                        	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5427:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5428:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5428:1: (lv_delta_4_0= ruleNumAlt )
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5429:3: lv_delta_4_0= ruleNumAlt
                    {
                     
                    	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm12050);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;


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
                    break;

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
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5453:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5454:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5455:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
             newCompositeNode(grammarAccess.getNumAltRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumAlt_in_entryRuleNumAlt12087);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;

             current =iv_ruleNumAlt; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumAlt12097); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5462:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5465:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5466:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5466:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt76=4;
            switch ( input.LA(1) ) {
            case KEYWORD_4:
                {
                switch ( input.LA(2) ) {
                case RULE_INTEGER_LIT:
                    {
                    alt76=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt76=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt76=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;
                }

                }
                break;
            case KEYWORD_6:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt76=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt76=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt76=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt76=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt76=2;
                }
                break;
            case RULE_ID:
                {
                alt76=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5467:5: this_RealTerm_0= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRealTerm_in_ruleNumAlt12144);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;


                            current = this_RealTerm_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5477:5: this_IntegerTerm_1= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerTerm_in_ruleNumAlt12171);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;


                            current = this_IntegerTerm_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5487:5: this_SignedConstant_2= ruleSignedConstant
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSignedConstant_in_ruleNumAlt12198);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;


                            current = this_SignedConstant_2;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5497:5: this_ConstantValue_3= ruleConstantValue
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConstantValue_in_ruleNumAlt12225);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;


                            current = this_ConstantValue_3;
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
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleINTVALUE"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5513:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5514:1: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5515:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FollowSets000.FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE12260);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINTVALUE12271); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5522:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5526:6: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5527:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FollowSets000.FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE12310); 

            		current.merge(this_INTEGER_LIT_0);
                
             
                newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5542:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5543:1: (iv_ruleQPREF= ruleQPREF EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5544:2: iv_ruleQPREF= ruleQPREF EOF
            {
             newCompositeNode(grammarAccess.getQPREFRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQPREF_in_entryRuleQPREF12354);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;

             current =iv_ruleQPREF.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQPREF12365); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5551:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= KEYWORD_15 this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5555:6: ( (this_ID_0= RULE_ID (kw= KEYWORD_15 this_ID_2= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5556:1: (this_ID_0= RULE_ID (kw= KEYWORD_15 this_ID_2= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5556:1: (this_ID_0= RULE_ID (kw= KEYWORD_15 this_ID_2= RULE_ID )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5556:6: this_ID_0= RULE_ID (kw= KEYWORD_15 this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQPREF12405); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5563:1: (kw= KEYWORD_15 this_ID_2= RULE_ID )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==KEYWORD_15) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5564:2: kw= KEYWORD_15 this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_ruleQPREF12424); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQPREF12439); 

                    		current.merge(this_ID_2);
                        
                     
                        newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
                        

                    }
                    break;

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
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5584:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5585:1: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5586:2: iv_ruleQCREF= ruleQCREF EOF
            {
             newCompositeNode(grammarAccess.getQCREFRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleQCREF_in_entryRuleQCREF12486);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;

             current =iv_ruleQCREF.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQCREF12497); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5593:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= KEYWORD_15 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5597:6: ( ( (this_ID_0= RULE_ID kw= KEYWORD_15 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5598:1: ( (this_ID_0= RULE_ID kw= KEYWORD_15 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5598:1: ( (this_ID_0= RULE_ID kw= KEYWORD_15 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5598:2: (this_ID_0= RULE_ID kw= KEYWORD_15 )* this_ID_2= RULE_ID (kw= KEYWORD_7 this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5598:2: (this_ID_0= RULE_ID kw= KEYWORD_15 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID) ) {
                    int LA78_1 = input.LA(2);

                    if ( (LA78_1==KEYWORD_15) ) {
                        alt78=1;
                    }


                }


                switch (alt78) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5598:7: this_ID_0= RULE_ID kw= KEYWORD_15
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQCREF12538); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,KEYWORD_15,FollowSets000.FOLLOW_KEYWORD_15_in_ruleQCREF12556); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQCREF12573); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5618:1: (kw= KEYWORD_7 this_ID_4= RULE_ID )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==KEYWORD_7) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5619:2: kw= KEYWORD_7 this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,KEYWORD_7,FollowSets000.FOLLOW_KEYWORD_7_in_ruleQCREF12592); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQCREF12607); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

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
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "entryRuleSTAR"
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5639:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5640:1: (iv_ruleSTAR= ruleSTAR EOF )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5641:2: iv_ruleSTAR= ruleSTAR EOF
            {
             newCompositeNode(grammarAccess.getSTARRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSTAR_in_entryRuleSTAR12654);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;

             current =iv_ruleSTAR.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSTAR12665); 

            }

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
    // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5648:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_3 ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5652:6: (kw= KEYWORD_3 )
            // ../org.osate.xtext.aadl2.propertyset/src-gen/org/osate/xtext/aadl2/propertyset/parser/antlr/internal/InternalPropertysetParser.g:5654:2: kw= KEYWORD_3
            {
            kw=(Token)match(input,KEYWORD_3,FollowSets000.FOLLOW_KEYWORD_3_in_ruleSTAR12702); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword()); 
                

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
    // $ANTLR end "ruleSTAR"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA61 dfa61 = new DFA61(this);
    static final String DFA4_eotS =
        "\16\uffff";
    static final String DFA4_eofS =
        "\16\uffff";
    static final String DFA4_minS =
        "\1\127\1\110\1\60\1\5\12\uffff";
    static final String DFA4_maxS =
        "\1\127\1\110\1\60\1\51\12\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\12\1\2\1\10\1\1\1\11\1\4\1\5\1\6\1\7\1\3";
    static final String DFA4_specialS =
        "\16\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\7\1\13\1\15\1\5\1\6\4\uffff\1\10\1\12\16\uffff\1\4\11\uffff"+
            "\1\14\1\11",
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
            return "240:2: (this_BooleanType_0= ruleBooleanType | this_StringType_1= ruleStringType | this_EnumerationType_2= ruleEnumerationType | this_UnitsType_3= ruleUnitsType | this_RealType_4= ruleRealType | this_IntegerType_5= ruleIntegerType | this_RangeType_6= ruleRangeType | this_ClassifierType_7= ruleClassifierType | this_ReferenceType_8= ruleReferenceType | this_RecordType_9= ruleRecordType )";
        }
    }
    static final String DFA45_eotS =
        "\24\uffff";
    static final String DFA45_eofS =
        "\4\uffff\1\16\1\20\1\22\6\uffff\1\16\1\uffff\1\20\3\uffff\1\22";
    static final String DFA45_minS =
        "\1\11\1\uffff\2\122\3\71\6\uffff\1\71\1\uffff\1\71\1\uffff\1\127"+
        "\1\uffff\1\71";
    static final String DFA45_maxS =
        "\1\127\1\uffff\4\127\1\111\6\uffff\1\111\1\uffff\1\111\1\uffff"+
        "\1\127\1\uffff\1\111";
    static final String DFA45_acceptS =
        "\1\uffff\1\1\5\uffff\1\3\1\4\1\7\1\10\1\12\1\2\1\uffff\1\5\1\uffff"+
        "\1\6\1\uffff\1\11\1\uffff";
    static final String DFA45_specialS =
        "\24\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\11\12\uffff\1\7\20\uffff\1\13\11\uffff\1\13\21\uffff\1\12"+
            "\2\uffff\1\2\1\uffff\1\3\3\uffff\1\1\7\uffff\1\4\1\uffff\1\5"+
            "\1\uffff\1\10\1\6",
            "",
            "\1\4\1\uffff\1\5\2\uffff\1\14",
            "\1\4\1\uffff\1\5\2\uffff\1\14",
            "\1\14\17\uffff\1\16\15\uffff\1\15",
            "\1\14\17\uffff\1\20\15\uffff\1\17",
            "\1\14\1\21\16\uffff\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\17\uffff\1\16",
            "",
            "\1\14\17\uffff\1\20",
            "",
            "\1\23",
            "",
            "\1\14\17\uffff\1\22"
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "3097:1: (this_RecordTerm_0= ruleRecordTerm | this_NumericRangeTerm_1= ruleNumericRangeTerm | this_ComputedTerm_2= ruleComputedTerm | this_StringTerm_3= ruleStringTerm | this_RealTerm_4= ruleRealTerm | this_IntegerTerm_5= ruleIntegerTerm | this_ComponentClassifierTerm_6= ruleComponentClassifierTerm | this_ListTerm_7= ruleListTerm | this_LiteralorReferenceTerm_8= ruleLiteralorReferenceTerm | this_BooleanLiteral_9= ruleBooleanLiteral )";
        }
    }
    static final String DFA61_eotS =
        "\30\uffff";
    static final String DFA61_eofS =
        "\11\uffff\1\21\1\23\1\25\4\uffff\1\21\1\uffff\1\23\4\uffff\1\25";
    static final String DFA61_minS =
        "\2\11\5\uffff\2\122\3\23\1\uffff\1\71\2\uffff\1\23\1\uffff\1\23"+
        "\1\uffff\1\127\2\uffff\1\23";
    static final String DFA61_maxS =
        "\2\127\5\uffff\4\127\1\111\1\uffff\1\105\2\uffff\1\111\1\uffff"+
        "\1\111\1\uffff\1\127\2\uffff\1\111";
    static final String DFA61_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\5\uffff\1\13\1\uffff\1\12\1\7\1\uffff"+
        "\1\10\1\uffff\1\11\1\uffff\1\14\1\1\1\uffff";
    static final String DFA61_specialS =
        "\30\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\4\4\uffff\1\3\5\uffff\1\5\20\uffff\1\14\11\uffff\1\14\21"+
            "\uffff\1\1\2\uffff\1\7\1\uffff\1\10\3\uffff\1\2\7\uffff\1\11"+
            "\1\uffff\1\12\1\uffff\1\6\1\13",
            "\1\16\4\uffff\1\16\5\uffff\1\16\20\uffff\1\16\11\uffff\1\16"+
            "\21\uffff\1\16\2\uffff\1\16\1\uffff\1\16\3\uffff\1\16\7\uffff"+
            "\1\16\1\uffff\1\16\1\uffff\1\16\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\1\12\2\uffff\1\17",
            "\1\11\1\uffff\1\12\2\uffff\1\17",
            "\1\21\45\uffff\1\17\2\uffff\1\21\5\uffff\1\21\2\uffff\1\21"+
            "\3\uffff\1\21\15\uffff\1\20",
            "\1\23\45\uffff\1\17\2\uffff\1\23\5\uffff\1\23\2\uffff\1\23"+
            "\3\uffff\1\23\15\uffff\1\22",
            "\1\25\45\uffff\1\17\1\24\1\uffff\1\25\5\uffff\1\25\2\uffff"+
            "\1\25\3\uffff\1\25",
            "",
            "\2\16\1\26\6\uffff\1\16\2\uffff\1\16",
            "",
            "",
            "\1\21\45\uffff\1\17\2\uffff\1\21\5\uffff\1\21\2\uffff\1\21"+
            "\3\uffff\1\21",
            "",
            "\1\23\45\uffff\1\17\2\uffff\1\23\5\uffff\1\23\2\uffff\1\23"+
            "\3\uffff\1\23",
            "",
            "\1\27",
            "",
            "",
            "\1\25\45\uffff\1\17\2\uffff\1\25\5\uffff\1\25\2\uffff\1\25"+
            "\3\uffff\1\25"
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "4116:1: (this_OldRecordTerm_0= ruleOldRecordTerm | this_RecordTerm_1= ruleRecordTerm | this_ReferenceTerm_2= ruleReferenceTerm | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_rulePropertySet_in_entryRulePropertySet67 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertySet77 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_63_in_rulePropertySet115 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_KEYWORD_28_in_rulePropertySet127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet143 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_KEYWORD_18_in_rulePropertySet161 = new BitSet(new long[]{0x0042000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_KEYWORD_36_in_rulePropertySet174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
        public static final BitSet FOLLOW_KEYWORD_5_in_rulePropertySet207 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
        public static final BitSet FOLLOW_KEYWORD_9_in_rulePropertySet241 = new BitSet(new long[]{0x0042000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_rulePropertyType_in_rulePropertySet264 = new BitSet(new long[]{0x0040000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_rulePropertyDefinition_in_rulePropertySet291 = new BitSet(new long[]{0x0040000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_rulePropertyConstant_in_rulePropertySet318 = new BitSet(new long[]{0x0040000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_KEYWORD_26_in_rulePropertySet333 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePropertySet343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_9_in_rulePropertySet355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyType_in_entryRulePropertyType389 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyType399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_rulePropertyType447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleStringType_in_rulePropertyType474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleEnumerationType_in_rulePropertyType501 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleUnitsType_in_rulePropertyType528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleRealType_in_rulePropertyType555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleIntegerType_in_rulePropertyType582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleRangeType_in_rulePropertyType609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleClassifierType_in_rulePropertyType636 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleReferenceType_in_rulePropertyType663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleRecordType_in_rulePropertyType690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_9_in_rulePropertyType703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_entryRuleUnnamedPropertyType737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedPropertyType747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListType_in_ruleUnnamedPropertyType794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedBooleanType_in_ruleUnnamedPropertyType821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedStringType_in_ruleUnnamedPropertyType848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedEnumerationType_in_ruleUnnamedPropertyType875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedPropertyType902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRealType_in_ruleUnnamedPropertyType929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedPropertyType956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRangeType_in_ruleUnnamedPropertyType983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedClassifierType_in_ruleUnnamedPropertyType1010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedReferenceType_in_ruleUnnamedPropertyType1037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRecordType_in_ruleUnnamedPropertyType1064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_entryRuleBooleanType1098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanType1108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBooleanType1150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleBooleanType1168 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleBooleanType1180 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_KEYWORD_71_in_ruleBooleanType1192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedBooleanType_in_entryRuleUnnamedBooleanType1226 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedBooleanType1236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_71_in_ruleUnnamedBooleanType1283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_entryRuleStringType1317 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringType1327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStringType1369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleStringType1387 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleStringType1399 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_68_in_ruleStringType1411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedStringType_in_entryRuleUnnamedStringType1445 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedStringType1455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_68_in_ruleUnnamedStringType1502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumerationType_in_entryRuleEnumerationType1536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationType1546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationType1588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleEnumerationType1606 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleEnumerationType1618 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_KEYWORD_73_in_ruleEnumerationType1630 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleEnumerationType1642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleEnumerationType1676 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleEnumerationType1696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleEnumerationType1711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedEnumerationType_in_entryRuleUnnamedEnumerationType1745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedEnumerationType1755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_73_in_ruleUnnamedEnumerationType1793 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleUnnamedEnumerationType1805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1825 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleUnnamedEnumerationType1839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleEnumerationLiteral_in_ruleUnnamedEnumerationType1859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleUnnamedEnumerationType1874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumerationLiteral_in_entryRuleEnumerationLiteral1908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteral1918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationLiteral1959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnitsType_in_entryRuleUnitsType1998 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnitsType2008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnitsType2050 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleUnitsType2068 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleUnitsType2080 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_KEYWORD_45_in_ruleUnitsType2092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleUnitsType2104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleUnitLiteral_in_ruleUnitsType2124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleUnitsType2138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleUnitLiteralConversion_in_ruleUnitsType2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleUnitsType2173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_entryRuleUnnamedUnitsType2207 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedUnitsType2217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_45_in_ruleUnnamedUnitsType2255 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleUnnamedUnitsType2267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleUnitLiteral_in_ruleUnnamedUnitsType2287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleUnnamedUnitsType2301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleUnitLiteralConversion_in_ruleUnnamedUnitsType2321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleUnnamedUnitsType2336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnitLiteral_in_entryRuleUnitLiteral2370 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnitLiteral2380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnitLiteral2421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnitLiteralConversion_in_entryRuleUnitLiteralConversion2460 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnitLiteralConversion2470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2512 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_KEYWORD_16_in_ruleUnitLiteralConversion2530 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnitLiteralConversion2549 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleUnitLiteralConversion2565 = new BitSet(new long[]{0x0000000000000000L,0x0000000000140050L});
        public static final BitSet FOLLOW_ruleNumberValue_in_ruleUnitLiteralConversion2585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealType_in_entryRuleRealType2620 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealType2630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRealType2672 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleRealType2690 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleRealType2702 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_KEYWORD_60_in_ruleRealType2714 = new BitSet(new long[]{0x0000020000000002L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleRealRange_in_ruleRealType2734 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_ruleRealType2757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_45_in_ruleRealType2777 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleRealType2799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRealType_in_entryRuleUnnamedRealType2837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedRealType2847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_60_in_ruleUnnamedRealType2894 = new BitSet(new long[]{0x0000020000000002L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleRealRange_in_ruleUnnamedRealType2914 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedRealType2937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_45_in_ruleUnnamedRealType2957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleUnnamedRealType2979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_entryRuleIntegerType3017 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerType3027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerType3069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleIntegerType3087 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleIntegerType3099 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_KEYWORD_72_in_ruleIntegerType3111 = new BitSet(new long[]{0x0000020000000002L,0x0000000000940050L});
        public static final BitSet FOLLOW_ruleIntegerRange_in_ruleIntegerType3131 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_ruleIntegerType3154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_45_in_ruleIntegerType3174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleIntegerType3196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_entryRuleUnnamedIntegerType3234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedIntegerType3244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_72_in_ruleUnnamedIntegerType3291 = new BitSet(new long[]{0x0000020000000002L,0x0000000000940050L});
        public static final BitSet FOLLOW_ruleIntegerRange_in_ruleUnnamedIntegerType3311 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_ruleUnnamedUnitsType_in_ruleUnnamedIntegerType3334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_45_in_ruleUnnamedIntegerType3354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleUnnamedIntegerType3376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRangeType_in_entryRuleRangeType3414 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRangeType3424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRangeType3466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleRangeType3484 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleRangeType3496 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_KEYWORD_44_in_ruleRangeType3508 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_KEYWORD_19_in_ruleRangeType3520 = new BitSet(new long[]{0x0000000000008040L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_ruleRangeType3543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRealType_in_ruleRangeType3562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleRangeType3594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRangeType_in_entryRuleUnnamedRangeType3630 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedRangeType3640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_44_in_ruleUnnamedRangeType3687 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_KEYWORD_19_in_ruleUnnamedRangeType3699 = new BitSet(new long[]{0x0000000000008040L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleUnnamedIntegerType_in_ruleUnnamedRangeType3722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRealType_in_ruleUnnamedRangeType3741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleUnnamedRangeType3773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClassifierType_in_entryRuleClassifierType3809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleClassifierType3819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClassifierType3861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleClassifierType3879 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleClassifierType3891 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_69_in_ruleClassifierType3903 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleClassifierType3916 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleClassifierType3936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleClassifierType3950 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleClassifierType3970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleClassifierType3985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedClassifierType_in_entryRuleUnnamedClassifierType4021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedClassifierType4031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_69_in_ruleUnnamedClassifierType4078 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleUnnamedClassifierType4091 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleUnnamedClassifierType4111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleUnnamedClassifierType4125 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleUnnamedClassifierType4145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleUnnamedClassifierType4160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQMReference_in_entryRuleQMReference4196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQMReference4206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_12_in_ruleQMReference4245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQMReference4261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_KEYWORD_13_in_ruleQMReference4279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleQMReference4294 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleQMReference4309 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000800001L});
        public static final BitSet FOLLOW_ruleCoreKeyWord_in_ruleQMReference4333 = new BitSet(new long[]{0x00616C559FA13E12L,0x0000000000800001L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQMReference4348 = new BitSet(new long[]{0x00616C559FA13E12L,0x0000000000800001L});
        public static final BitSet FOLLOW_ruleQCReference_in_entryRuleQCReference4392 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQCReference4402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQCREF_in_ruleQCReference4449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceType_in_entryRuleReferenceType4483 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceType4493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceType4535 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleReferenceType4553 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleReferenceType4565 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_KEYWORD_67_in_ruleReferenceType4577 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleReferenceType4590 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleReferenceType4610 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleReferenceType4624 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleReferenceType4644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleReferenceType4659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedReferenceType_in_entryRuleUnnamedReferenceType4695 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedReferenceType4705 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_67_in_ruleUnnamedReferenceType4743 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleUnnamedReferenceType4765 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleUnnamedReferenceType4785 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleUnnamedReferenceType4799 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_ruleQMReference_in_ruleUnnamedReferenceType4819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleUnnamedReferenceType4834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordType_in_entryRuleRecordType4870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecordType4880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecordType4922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleRecordType4940 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleRecordType4952 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_KEYWORD_50_in_ruleRecordType4964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleRecordType4976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRecordField_in_ruleRecordType4996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800004L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleRecordType5010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedRecordType_in_entryRuleUnnamedRecordType5044 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnnamedRecordType5054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_50_in_ruleUnnamedRecordType5092 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleUnnamedRecordType5104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRecordField_in_ruleUnnamedRecordType5124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800004L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleUnnamedRecordType5138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordField_in_entryRuleRecordField5172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecordField5182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRecordField5224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_ruleRecordField5242 = new BitSet(new long[]{0x000013004000C3E0L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleRecordField5265 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_ruleRecordField5292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_9_in_ruleRecordField5306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyDefinition_in_entryRulePropertyDefinition5340 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyDefinition5350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePropertyDefinition5392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_rulePropertyDefinition5410 = new BitSet(new long[]{0x000013004040C3E0L,0x0000000000840050L});
        public static final BitSet FOLLOW_KEYWORD_56_in_rulePropertyDefinition5428 = new BitSet(new long[]{0x000013004000C3E0L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyDefinition5464 = new BitSet(new long[]{0x0800000000080000L});
        public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_rulePropertyDefinition5491 = new BitSet(new long[]{0x0800000000080000L});
        public static final BitSet FOLLOW_KEYWORD_16_in_rulePropertyDefinition5506 = new BitSet(new long[]{0x0000802000104200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyDefinition5526 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_KEYWORD_53_in_rulePropertyDefinition5541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_KEYWORD_21_in_rulePropertyDefinition5553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_rulePropertyDefinition5565 = new BitSet(new long[]{0x00696C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5587 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_rulePropertyDefinition5601 = new BitSet(new long[]{0x00616C559FA13E10L,0x0000000000801001L});
        public static final BitSet FOLLOW_rulePropertyOwner_in_rulePropertyDefinition5621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_ruleAllReference_in_rulePropertyDefinition5651 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_KEYWORD_2_in_rulePropertyDefinition5665 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_9_in_rulePropertyDefinition5677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAllReference_in_entryRuleAllReference5711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAllReference5721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_23_in_ruleAllReference5764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListType_in_entryRuleListType5809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListType5819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_31_in_ruleListType5857 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_KEYWORD_19_in_ruleListType5869 = new BitSet(new long[]{0x000013004000C3E0L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleListType5892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_ruleListType5919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyOwner_in_entryRulePropertyOwner5955 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyOwner5965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQMReference_in_rulePropertyOwner6012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQCReference_in_rulePropertyOwner6039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyConstant_in_entryRulePropertyConstant6073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyConstant6083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePropertyConstant6125 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_KEYWORD_8_in_rulePropertyConstant6143 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_KEYWORD_62_in_rulePropertyConstant6155 = new BitSet(new long[]{0x000013004000C3E0L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyConstant6178 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_ruleUnnamedPropertyType_in_rulePropertyConstant6205 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_KEYWORD_16_in_rulePropertyConstant6219 = new BitSet(new long[]{0x0000802000104200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_ruleConstantPropertyExpression_in_rulePropertyConstant6239 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_9_in_rulePropertyConstant6252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberValue_in_entryRuleNumberValue6286 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberValue6296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealLit_in_ruleNumberValue6343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerLit_in_ruleNumberValue6370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealLit_in_entryRuleRealLit6404 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealLit6414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealLit6459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerLit_in_entryRuleIntegerLit6493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLit6503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerLit6548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantPropertyExpression_in_entryRuleConstantPropertyExpression6582 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstantPropertyExpression6592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordTerm_in_ruleConstantPropertyExpression6639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericRangeTerm_in_ruleConstantPropertyExpression6666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComputedTerm_in_ruleConstantPropertyExpression6693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringTerm_in_ruleConstantPropertyExpression6720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_ruleConstantPropertyExpression6747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleConstantPropertyExpression6774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_ruleConstantPropertyExpression6801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTerm_in_ruleConstantPropertyExpression6828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_ruleConstantPropertyExpression6855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleConstantPropertyExpression6882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerRange_in_entryRuleIntegerRange6916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerRange6926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleIntegerRange6974 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_ruleIntegerRange6993 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleIntegerRange7012 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_KEYWORD_14_in_ruleIntegerRange7028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000940050L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleIntegerRange7050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_ruleIntegerRange7069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleIntegerRange7088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealRange_in_entryRuleRealRange7126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealRange7136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_ruleRealRange7184 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_ruleRealRange7203 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleRealRange7222 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_KEYWORD_14_in_ruleRealRange7238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleRealTerm_in_ruleRealRange7260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_ruleRealRange7279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleRealRange7298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCoreKeyWord_in_entryRuleCoreKeyWord7337 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCoreKeyWord7348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_51_in_ruleCoreKeyWord7386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_52_in_ruleCoreKeyWord7405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_42_in_ruleCoreKeyWord7424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_58_in_ruleCoreKeyWord7443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_29_in_ruleCoreKeyWord7462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_65_in_ruleCoreKeyWord7481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_48_in_ruleCoreKeyWord7500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_47_in_ruleCoreKeyWord7519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_25_in_ruleCoreKeyWord7538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_59_in_ruleCoreKeyWord7557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_70_in_ruleCoreKeyWord7576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_55_in_ruleCoreKeyWord7595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_57_in_ruleCoreKeyWord7614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_64_in_ruleCoreKeyWord7633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_33_in_ruleCoreKeyWord7652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_38_in_ruleCoreKeyWord7671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_40_in_ruleCoreKeyWord7690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_30_in_ruleCoreKeyWord7709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_74_in_ruleCoreKeyWord7728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_35_in_ruleCoreKeyWord7747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_32_in_ruleCoreKeyWord7766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_66_in_ruleCoreKeyWord7785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_21_in_ruleCoreKeyWord7804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_26_in_ruleCoreKeyWord7823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_61_in_ruleCoreKeyWord7842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_46_in_ruleCoreKeyWord7861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_69_in_ruleCoreKeyWord7880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQCREF_in_entryRuleFQCREF7920 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQCREF7931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF7972 = new BitSet(new long[]{0x0400000000000000L});
        public static final BitSet FOLLOW_KEYWORD_15_in_ruleFQCREF7990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF8007 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleFQCREF8026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF8041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation8089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainedPropertyAssociation8099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation8147 = new BitSet(new long[]{0x0804000000000000L});
        public static final BitSet FOLLOW_KEYWORD_16_in_ruleContainedPropertyAssociation8161 = new BitSet(new long[]{0x0000802000124200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_KEYWORD_22_in_ruleContainedPropertyAssociation8185 = new BitSet(new long[]{0x0000802000124200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_KEYWORD_62_in_ruleContainedPropertyAssociation8216 = new BitSet(new long[]{0x0000802000124200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation8250 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000220L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation8264 = new BitSet(new long[]{0x0000802000124200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation8284 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000220L});
        public static final BitSet FOLLOW_KEYWORD_53_in_ruleContainedPropertyAssociation8301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_KEYWORD_21_in_ruleContainedPropertyAssociation8313 = new BitSet(new long[]{0x0000000200000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation8333 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleContainedPropertyAssociation8347 = new BitSet(new long[]{0x0000000200000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation8367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
        public static final BitSet FOLLOW_KEYWORD_9_in_ruleContainedPropertyAssociation8384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath8422 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPath8432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath8487 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleContainmentPath8501 = new BitSet(new long[]{0x0000000200000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath8521 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_entryRuleOptionalModalPropertyValue8560 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOptionalModalPropertyValue8570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleOptionalModalPropertyValue8616 = new BitSet(new long[]{0x1000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_17_in_ruleOptionalModalPropertyValue8630 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_KEYWORD_43_in_ruleOptionalModalPropertyValue8642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleOptionalModalPropertyValue8654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalModalPropertyValue8673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleOptionalModalPropertyValue8687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOptionalModalPropertyValue8706 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleOptionalModalPropertyValue8721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyValue_in_entryRulePropertyValue8759 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyValue8769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyValue8814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression8848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression8858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOldRecordTerm_in_rulePropertyExpression8905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordTerm_in_rulePropertyExpression8932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceTerm_in_rulePropertyExpression8959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression8986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComputedTerm_in_rulePropertyExpression9013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringTerm_in_rulePropertyExpression9040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression9067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_rulePropertyExpression9094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_rulePropertyExpression9121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTerm_in_rulePropertyExpression9148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePropertyExpression9175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression9202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm9236 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm9246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm9293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral9327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral9337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_34_in_ruleBooleanLiteral9391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_41_in_ruleBooleanLiteral9421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue9456 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue9466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_ruleConstantValue9513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm9547 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceTerm9557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_67_in_ruleReferenceTerm9595 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleReferenceTerm9607 = new BitSet(new long[]{0x0000000200000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm9627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000084L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleReferenceTerm9641 = new BitSet(new long[]{0x0000000200000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm9661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000084L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleReferenceTerm9676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm9710 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecordTerm9720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_10_in_ruleRecordTerm9758 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm9778 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800800L});
        public static final BitSet FOLLOW_KEYWORD_11_in_ruleRecordTerm9792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOldRecordTerm_in_entryRuleOldRecordTerm9826 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOldRecordTerm9836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleOldRecordTerm9874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_ruleOldRecordTerm9894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800004L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleOldRecordTerm9908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm9942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComputedTerm9952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_54_in_ruleComputedTerm9990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleComputedTerm10002 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComputedTerm10018 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleComputedTerm10036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm10070 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComponentClassifierTerm10080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_69_in_ruleComponentClassifierTerm10118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleComponentClassifierTerm10130 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm10152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleComponentClassifierTerm10165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTerm_in_entryRuleListTerm10199 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListTerm10209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_1_in_ruleListTerm10247 = new BitSet(new long[]{0x0000802000104200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm10267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_5_in_ruleListTerm10281 = new BitSet(new long[]{0x0000802000104200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm10301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
        public static final BitSet FOLLOW_KEYWORD_2_in_ruleListTerm10316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation10350 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFieldPropertyAssociation10360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation10405 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_KEYWORD_16_in_ruleFieldPropertyAssociation10418 = new BitSet(new long[]{0x0000802000104200L,0x0000000000D40452L});
        public static final BitSet FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation10438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_KEYWORD_9_in_ruleFieldPropertyAssociation10451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement10485 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement10495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleContainmentPathElement10541 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement10562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_37_in_ruleContainmentPathElement10584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleANNEXREF_in_ruleContainmentPathElement10606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleANNEXREF_in_entryRuleANNEXREF10643 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleANNEXREF10654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_12_in_ruleANNEXREF10692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF10714 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF10741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleANNEXREF10761 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF10788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleSTAR_in_ruleANNEXREF10815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_KEYWORD_13_in_ruleANNEXREF10833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus10879 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus10890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_rulePlusMinus10928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_6_in_rulePlusMinus10947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm10986 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm10996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm11041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString11076 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString11087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString11126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange11169 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange11179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_10_in_ruleArrayRange11226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange11246 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_KEYWORD_14_in_ruleArrayRange11260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange11280 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_KEYWORD_11_in_ruleArrayRange11295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant11329 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignedConstant11339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePlusMinus_in_ruleSignedConstant11385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000840050L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleSignedConstant11406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm11441 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm11451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerTerm11497 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm11517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedInt_in_entryRuleSignedInt11554 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignedInt11565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleSignedInt11604 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_KEYWORD_6_in_ruleSignedInt11623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt11640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm11684 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm11694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealTerm11740 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm11760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedReal_in_entryRuleSignedReal11797 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSignedReal11808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_4_in_ruleSignedReal11847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_KEYWORD_6_in_ruleSignedReal11866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleSignedReal11883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm11927 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumericRangeTerm11937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm11983 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_KEYWORD_14_in_ruleNumericRangeTerm11996 = new BitSet(new long[]{0x0000000000000000L,0x0000000000940050L});
        public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm12016 = new BitSet(new long[]{0x0000000800000002L});
        public static final BitSet FOLLOW_KEYWORD_39_in_ruleNumericRangeTerm12030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000940050L});
        public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm12050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt12087 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt12097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumAlt12144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumAlt12171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumAlt12198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumAlt12225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE12260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE12271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE12310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQPREF_in_entryRuleQPREF12354 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQPREF12365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF12405 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_KEYWORD_15_in_ruleQPREF12424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF12439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF12486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQCREF12497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12538 = new BitSet(new long[]{0x0400000000000000L});
        public static final BitSet FOLLOW_KEYWORD_15_in_ruleQCREF12556 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12573 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_KEYWORD_7_in_ruleQCREF12592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF12607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSTAR_in_entryRuleSTAR12654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSTAR12665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_KEYWORD_3_in_ruleSTAR12702 = new BitSet(new long[]{0x0000000000000002L});
    }


}