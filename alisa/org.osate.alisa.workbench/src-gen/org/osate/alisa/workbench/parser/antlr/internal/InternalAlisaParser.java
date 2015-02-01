package org.osate.alisa.workbench.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAlisaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alisa'", "'case'", "':'", "'for'", "'['", "'description'", "'constants'", "'plans'", "'select'", "']'", "'&'", "'this'", "'%'", "'.'", "'='", "'::'"
    };
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalAlisaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAlisaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAlisaParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g"; }



     	private AlisaGrammarAccess grammarAccess;
     	
        public InternalAlisaParser(TokenStream input, AlisaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AlisaWorkArea";	
       	}
       	
       	@Override
       	protected AlisaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAlisaWorkArea"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:67:1: entryRuleAlisaWorkArea returns [EObject current=null] : iv_ruleAlisaWorkArea= ruleAlisaWorkArea EOF ;
    public final EObject entryRuleAlisaWorkArea() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlisaWorkArea = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:68:2: (iv_ruleAlisaWorkArea= ruleAlisaWorkArea EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:69:2: iv_ruleAlisaWorkArea= ruleAlisaWorkArea EOF
            {
             newCompositeNode(grammarAccess.getAlisaWorkAreaRule()); 
            pushFollow(FOLLOW_ruleAlisaWorkArea_in_entryRuleAlisaWorkArea75);
            iv_ruleAlisaWorkArea=ruleAlisaWorkArea();

            state._fsp--;

             current =iv_ruleAlisaWorkArea; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlisaWorkArea85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlisaWorkArea"


    // $ANTLR start "ruleAlisaWorkArea"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:76:1: ruleAlisaWorkArea returns [EObject current=null] : (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCaseConfiguration ) )* ) ;
    public final EObject ruleAlisaWorkArea() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_cases_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:79:28: ( (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCaseConfiguration ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCaseConfiguration ) )* )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCaseConfiguration ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:3: otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCaseConfiguration ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleAlisaWorkArea122); 

                	newLeafNode(otherlv_0, grammarAccess.getAlisaWorkAreaAccess().getAlisaKeyword_0());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAlisaWorkArea139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAlisaWorkAreaAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAlisaWorkAreaRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:102:2: ( (lv_cases_2_0= ruleAssuranceCaseConfiguration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:103:1: (lv_cases_2_0= ruleAssuranceCaseConfiguration )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:103:1: (lv_cases_2_0= ruleAssuranceCaseConfiguration )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:104:3: lv_cases_2_0= ruleAssuranceCaseConfiguration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssuranceCaseConfigurationParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssuranceCaseConfiguration_in_ruleAlisaWorkArea165);
            	    lv_cases_2_0=ruleAssuranceCaseConfiguration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"cases",
            	            		lv_cases_2_0, 
            	            		"AssuranceCaseConfiguration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleAlisaWorkArea"


    // $ANTLR start "entryRuleAssuranceCaseConfiguration"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:128:1: entryRuleAssuranceCaseConfiguration returns [EObject current=null] : iv_ruleAssuranceCaseConfiguration= ruleAssuranceCaseConfiguration EOF ;
    public final EObject entryRuleAssuranceCaseConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceCaseConfiguration = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:129:2: (iv_ruleAssuranceCaseConfiguration= ruleAssuranceCaseConfiguration EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:130:2: iv_ruleAssuranceCaseConfiguration= ruleAssuranceCaseConfiguration EOF
            {
             newCompositeNode(grammarAccess.getAssuranceCaseConfigurationRule()); 
            pushFollow(FOLLOW_ruleAssuranceCaseConfiguration_in_entryRuleAssuranceCaseConfiguration202);
            iv_ruleAssuranceCaseConfiguration=ruleAssuranceCaseConfiguration();

            state._fsp--;

             current =iv_ruleAssuranceCaseConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceCaseConfiguration212); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssuranceCaseConfiguration"


    // $ANTLR start "ruleAssuranceCaseConfiguration"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: ruleAssuranceCaseConfiguration returns [EObject current=null] : (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_6= '[' ( (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )? ) otherlv_15= ']' ) ;
    public final EObject ruleAssuranceCaseConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_8_0 = null;

        EObject lv_constant_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:140:28: ( (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_6= '[' ( (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )? ) otherlv_15= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:141:1: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_6= '[' ( (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )? ) otherlv_15= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:141:1: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_6= '[' ( (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )? ) otherlv_15= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:141:3: otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_6= '[' ( (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )? ) otherlv_15= ']'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleAssuranceCaseConfiguration249); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceCaseConfigurationAccess().getCaseKeyword_0());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:145:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:147:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceCaseConfiguration266); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAssuranceCaseConfigurationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceCaseConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:163:2: (otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:163:4: otherlv_2= ':' ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceCaseConfiguration284); 

                        	newLeafNode(otherlv_2, grammarAccess.getAssuranceCaseConfigurationAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:167:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:169:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssuranceCaseConfigurationAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleAssuranceCaseConfiguration305);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssuranceCaseConfigurationRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceCaseConfiguration319); 

                	newLeafNode(otherlv_4, grammarAccess.getAssuranceCaseConfigurationAccess().getForKeyword_3());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:189:1: ( ( ruleAadlClassifierReference ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:190:1: ( ruleAadlClassifierReference )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:190:1: ( ruleAadlClassifierReference )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:191:3: ruleAadlClassifierReference
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceCaseConfigurationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssuranceCaseConfigurationAccess().getSystemComponentImplementationCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssuranceCaseConfiguration342);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceCaseConfiguration354); 

                	newLeafNode(otherlv_6, grammarAccess.getAssuranceCaseConfigurationAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:1: ( (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:2: (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )? (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )? otherlv_11= 'plans' ( ( ruleQualifiedName ) )+ (otherlv_13= 'select' ( ( ruleCatRef ) )+ )?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:2: (otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:208:4: otherlv_7= 'description' ( (lv_description_8_0= ruleDescription ) )
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceCaseConfiguration368); 

                        	newLeafNode(otherlv_7, grammarAccess.getAssuranceCaseConfigurationAccess().getDescriptionKeyword_6_0_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:212:1: ( (lv_description_8_0= ruleDescription ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:213:1: (lv_description_8_0= ruleDescription )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:213:1: (lv_description_8_0= ruleDescription )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:214:3: lv_description_8_0= ruleDescription
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssuranceCaseConfigurationAccess().getDescriptionDescriptionParserRuleCall_6_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceCaseConfiguration389);
                    lv_description_8_0=ruleDescription();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssuranceCaseConfigurationRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_8_0, 
                            		"Description");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:230:4: (otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:230:6: otherlv_9= 'constants' ( (lv_constant_10_0= ruleConstantDecl ) )+
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleAssuranceCaseConfiguration404); 

                        	newLeafNode(otherlv_9, grammarAccess.getAssuranceCaseConfigurationAccess().getConstantsKeyword_6_1_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:234:1: ( (lv_constant_10_0= ruleConstantDecl ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:235:1: (lv_constant_10_0= ruleConstantDecl )
                    	    {
                    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:235:1: (lv_constant_10_0= ruleConstantDecl )
                    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:236:3: lv_constant_10_0= ruleConstantDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAssuranceCaseConfigurationAccess().getConstantConstantDeclParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstantDecl_in_ruleAssuranceCaseConfiguration425);
                    	    lv_constant_10_0=ruleConstantDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAssuranceCaseConfigurationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constant",
                    	            		lv_constant_10_0, 
                    	            		"ConstantDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleAssuranceCaseConfiguration440); 

                	newLeafNode(otherlv_11, grammarAccess.getAssuranceCaseConfigurationAccess().getPlansKeyword_6_2());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:256:1: ( ( ruleQualifiedName ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:257:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:257:1: ( ruleQualifiedName )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:258:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAssuranceCaseConfigurationRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceCaseConfigurationAccess().getPlansVerificationPlanCrossReference_6_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceCaseConfiguration463);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:271:3: (otherlv_13= 'select' ( ( ruleCatRef ) )+ )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:271:5: otherlv_13= 'select' ( ( ruleCatRef ) )+
                    {
                    otherlv_13=(Token)match(input,19,FOLLOW_19_in_ruleAssuranceCaseConfiguration477); 

                        	newLeafNode(otherlv_13, grammarAccess.getAssuranceCaseConfigurationAccess().getSelectKeyword_6_4_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:275:1: ( ( ruleCatRef ) )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:276:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:276:1: ( ruleCatRef )
                    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:277:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getAssuranceCaseConfigurationRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getAssuranceCaseConfigurationAccess().getSelectionFilterVerificationCategoryCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleAssuranceCaseConfiguration500);
                    	    ruleCatRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }


            }

            otherlv_15=(Token)match(input,20,FOLLOW_20_in_ruleAssuranceCaseConfiguration516); 

                	newLeafNode(otherlv_15, grammarAccess.getAssuranceCaseConfigurationAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleAssuranceCaseConfiguration"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:304:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:305:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:306:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription554);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription564); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:313:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:316:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:317:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:317:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)||(LA9_0>=21 && LA9_0<=22)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:318:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:318:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:319:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription609);
            	    lv_description_0_0=ruleDescriptionElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"description",
            	            		lv_description_0_0, 
            	            		"DescriptionElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:343:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:344:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:345:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement645);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement655); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:352:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_2_0=null;
        Token lv_thisTarget_3_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:355:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:356:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:356:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case RULE_ID:
                {
                alt10=2;
                }
                break;
            case 21:
                {
                alt10=3;
                }
                break;
            case 22:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:356:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:356:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:357:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:357:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:358:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement697); 

                    			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                    		

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
                    break;
                case 2 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:375:6: ( (lv_value_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:375:6: ( (lv_value_1_0= ruleShowValue ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:376:1: (lv_value_1_0= ruleShowValue )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:376:1: (lv_value_1_0= ruleShowValue )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:377:3: lv_value_1_0= ruleShowValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getValueShowValueParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement729);
                    lv_value_1_0=ruleShowValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"ShowValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:394:6: ( (lv_newline_2_0= '&' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:394:6: ( (lv_newline_2_0= '&' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:395:1: (lv_newline_2_0= '&' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:395:1: (lv_newline_2_0= '&' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:396:3: lv_newline_2_0= '&'
                    {
                    lv_newline_2_0=(Token)match(input,21,FOLLOW_21_in_ruleDescriptionElement753); 

                            newLeafNode(lv_newline_2_0, grammarAccess.getDescriptionElementAccess().getNewlineAmpersandKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(current, "newline", true, "&");
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:410:6: ( (lv_thisTarget_3_0= 'this' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:410:6: ( (lv_thisTarget_3_0= 'this' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:1: (lv_thisTarget_3_0= 'this' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:1: (lv_thisTarget_3_0= 'this' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:412:3: lv_thisTarget_3_0= 'this'
                    {
                    lv_thisTarget_3_0=(Token)match(input,22,FOLLOW_22_in_ruleDescriptionElement790); 

                            newLeafNode(lv_thisTarget_3_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(current, "thisTarget", true, "this");
                    	    

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
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleShowValue"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:433:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:434:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:435:2: iv_ruleShowValue= ruleShowValue EOF
            {
             newCompositeNode(grammarAccess.getShowValueRule()); 
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue839);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;

             current =iv_ruleShowValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue849); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:442:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_unit_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:445:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:446:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:446:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:446:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:446:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:447:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:447:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:448:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getShowValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue894); 

            		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:459:2: (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:459:4: otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleShowValue907); 

                        	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                        
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:463:1: ( (lv_unit_2_0= RULE_ID ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:464:1: (lv_unit_2_0= RULE_ID )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:464:1: (lv_unit_2_0= RULE_ID )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:465:3: lv_unit_2_0= RULE_ID
                    {
                    lv_unit_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue924); 

                    			newLeafNode(lv_unit_2_0, grammarAccess.getShowValueAccess().getUnitIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShowValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"unit",
                            		lv_unit_2_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:489:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:490:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:491:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath967);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath977); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencePath"


    // $ANTLR start "ruleReferencePath"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:498:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:504:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath1022); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:515:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleReferencePath1035); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:519:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:520:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:520:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:521:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1056);
            lv_subpath_2_0=ruleReferencePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferencePathRule());
            	        }
                   		set(
                   			current, 
                   			"subpath",
                    		lv_subpath_2_0, 
                    		"ReferencePath");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleReferencePath"


    // $ANTLR start "entryRuleConstantDecl"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:547:1: entryRuleConstantDecl returns [EObject current=null] : iv_ruleConstantDecl= ruleConstantDecl EOF ;
    public final EObject entryRuleConstantDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDecl = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:548:2: (iv_ruleConstantDecl= ruleConstantDecl EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:549:2: iv_ruleConstantDecl= ruleConstantDecl EOF
            {
             newCompositeNode(grammarAccess.getConstantDeclRule()); 
            pushFollow(FOLLOW_ruleConstantDecl_in_entryRuleConstantDecl1095);
            iv_ruleConstantDecl=ruleConstantDecl();

            state._fsp--;

             current =iv_ruleConstantDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDecl1105); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDecl"


    // $ANTLR start "ruleConstantDecl"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:556:1: ruleConstantDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleConstantDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:559:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:560:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:560:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:560:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:560:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:561:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:561:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstantDecl1147); 

            			newLeafNode(lv_name_0_0, grammarAccess.getConstantDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleConstantDecl1164); 

                	newLeafNode(otherlv_1, grammarAccess.getConstantDeclAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:582:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:583:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:583:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:584:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getConstantDeclAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleConstantDecl1185);
            lv_value_2_0=ruleValueString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDeclRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"ValueString");
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
    // $ANTLR end "ruleConstantDecl"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:610:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:611:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:612:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm1223);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm1233); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:619:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:622:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:623:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:623:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:624:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:624:1: (lv_value_0_0= RULE_STRING )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:625:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringTerm1274); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringTermAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringTermRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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


    // $ANTLR start "entryRuleRealTerm"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:649:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:650:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:651:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm1314);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm1324); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:658:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token lv_unit_1_0=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:661:28: ( ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:662:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:662:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:662:2: ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:662:2: ( (lv_value_0_0= ruleREAL ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:663:1: (lv_value_0_0= ruleREAL )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:663:1: (lv_value_0_0= ruleREAL )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:664:3: lv_value_0_0= ruleREAL
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueREALParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleREAL_in_ruleRealTerm1370);
            lv_value_0_0=ruleREAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"REAL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:680:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:681:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:681:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:682:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm1387); 

                    			newLeafNode(lv_unit_1_0, grammarAccess.getRealTermAccess().getUnitIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTermRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"unit",
                            		lv_unit_1_0, 
                            		"ID");
                    	    

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


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:706:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:707:2: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:708:2: iv_ruleREAL= ruleREAL EOF
            {
             newCompositeNode(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL1430);
            iv_ruleREAL=ruleREAL();

            state._fsp--;

             current =iv_ruleREAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL1441); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:715:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:718:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:719:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:719:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:719:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL1481); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,24,FOLLOW_24_in_ruleREAL1499); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL1514); 

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


    // $ANTLR start "entryRuleIntegerTerm"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:747:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:748:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:749:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm1559);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm1569); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:756:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_unit_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:759:28: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:760:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:761:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:761:1: (lv_value_0_0= RULE_INT )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:762:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntegerTerm1611); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerTermRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"INT");
            	    

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:778:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:779:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:779:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:780:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm1633); 

                    			newLeafNode(lv_unit_1_0, grammarAccess.getIntegerTermAccess().getUnitIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTermRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"unit",
                            		lv_unit_1_0, 
                            		"ID");
                    	    

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


    // $ANTLR start "entryRuleTextElement"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:806:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:807:2: (iv_ruleTextElement= ruleTextElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:808:2: iv_ruleTextElement= ruleTextElement EOF
            {
             newCompositeNode(grammarAccess.getTextElementRule()); 
            pushFollow(FOLLOW_ruleTextElement_in_entryRuleTextElement1677);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;

             current =iv_ruleTextElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextElement1687); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextElement"


    // $ANTLR start "ruleTextElement"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:815:1: ruleTextElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:818:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:819:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:819:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING) ) {
                alt14=1;
            }
            else if ( (LA14_0==21) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:819:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:819:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:820:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:820:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:821:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextElement1729); 

                    			newLeafNode(lv_text_0_0, grammarAccess.getTextElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"text",
                            		lv_text_0_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:838:6: ( (lv_newline_1_0= '&' ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:838:6: ( (lv_newline_1_0= '&' ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:839:1: (lv_newline_1_0= '&' )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:839:1: (lv_newline_1_0= '&' )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:840:3: lv_newline_1_0= '&'
                    {
                    lv_newline_1_0=(Token)match(input,21,FOLLOW_21_in_ruleTextElement1758); 

                            newLeafNode(lv_newline_1_0, grammarAccess.getTextElementAccess().getNewlineAmpersandKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextElementRule());
                    	        }
                           		setWithLastConsumed(current, "newline", true, "&");
                    	    

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
    // $ANTLR end "ruleTextElement"


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:861:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:862:2: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:863:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString1808);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString1819); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueString"


    // $ANTLR start "ruleValueString"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:870:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:873:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:874:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString1858); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleValueString"


    // $ANTLR start "entryRuleAadlClassifierReference"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:889:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:890:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:891:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1903);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1914); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAadlClassifierReference"


    // $ANTLR start "ruleAadlClassifierReference"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:898:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:901:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:902:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:902:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:902:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:902:2: (this_ID_0= RULE_ID kw= '::' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==26) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:902:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1955); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,26,FOLLOW_26_in_ruleAadlClassifierReference1973); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1990); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:922:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:923:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleAadlClassifierReference2009); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference2024); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); 
                        

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
    // $ANTLR end "ruleAadlClassifierReference"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:943:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:944:2: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:945:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef2072);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef2083); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatRef"


    // $ANTLR start "ruleCatRef"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:952:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:955:28: (this_ID_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:956:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef2122); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleCatRef"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:971:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:972:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:973:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2167);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2178); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:980:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:983:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:984:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:984:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:984:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2218); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:991:1: (kw= '.' this_ID_2= RULE_ID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:992:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,24,FOLLOW_24_in_ruleQualifiedName2237); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName2252); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleAlisaWorkArea_in_entryRuleAlisaWorkArea75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlisaWorkArea85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleAlisaWorkArea122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAlisaWorkArea139 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleAssuranceCaseConfiguration_in_ruleAlisaWorkArea165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleAssuranceCaseConfiguration_in_entryRuleAssuranceCaseConfiguration202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceCaseConfiguration212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleAssuranceCaseConfiguration249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceCaseConfiguration266 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceCaseConfiguration284 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleAssuranceCaseConfiguration305 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceCaseConfiguration319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssuranceCaseConfiguration342 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceCaseConfiguration354 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceCaseConfiguration368 = new BitSet(new long[]{0x0000000000600030L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceCaseConfiguration389 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleAssuranceCaseConfiguration404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_ruleAssuranceCaseConfiguration425 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleAssuranceCaseConfiguration440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceCaseConfiguration463 = new BitSet(new long[]{0x0000000000180010L});
    public static final BitSet FOLLOW_19_in_ruleAssuranceCaseConfiguration477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleAssuranceCaseConfiguration500 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_20_in_ruleAssuranceCaseConfiguration516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription609 = new BitSet(new long[]{0x0000000000600032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement645 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleDescriptionElement753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleDescriptionElement790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue894 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleShowValue907 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath1022 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleReferencePath1035 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_entryRuleConstantDecl1095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDecl1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstantDecl1147 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleConstantDecl1164 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleConstantDecl1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm1223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringTerm1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm1314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleRealTerm1370 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL1430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL1481 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleREAL1499 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm1559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntegerTerm1611 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement1677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextElement1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextElement1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTextElement1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString1808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString1858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1955 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAadlClassifierReference1973 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1990 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleAadlClassifierReference2009 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef2072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2218 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleQualifiedName2237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName2252 = new BitSet(new long[]{0x0000000001000002L});

}