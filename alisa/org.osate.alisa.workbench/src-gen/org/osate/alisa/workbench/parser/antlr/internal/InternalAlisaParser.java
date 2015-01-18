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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'alisa'", "'case'", "'for'", "'['", "'title'", "'description'", "'constants'", "'plans'", "']'", "'.'", "'='", "'::'"
    };
    public static final int RULE_ID=4;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:76:1: ruleAlisaWorkArea returns [EObject current=null] : (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCasePlan ) )* ) ;
    public final EObject ruleAlisaWorkArea() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_cases_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:79:28: ( (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCasePlan ) )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCasePlan ) )* )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:1: (otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCasePlan ) )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:80:3: otherlv_0= 'alisa' ( (lv_name_1_0= RULE_ID ) ) ( (lv_cases_2_0= ruleAssuranceCasePlan ) )*
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

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:102:2: ( (lv_cases_2_0= ruleAssuranceCasePlan ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:103:1: (lv_cases_2_0= ruleAssuranceCasePlan )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:103:1: (lv_cases_2_0= ruleAssuranceCasePlan )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:104:3: lv_cases_2_0= ruleAssuranceCasePlan
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAlisaWorkAreaAccess().getCasesAssuranceCasePlanParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssuranceCasePlan_in_ruleAlisaWorkArea165);
            	    lv_cases_2_0=ruleAssuranceCasePlan();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAlisaWorkAreaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"cases",
            	            		lv_cases_2_0, 
            	            		"AssuranceCasePlan");
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


    // $ANTLR start "entryRuleAssuranceCasePlan"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:128:1: entryRuleAssuranceCasePlan returns [EObject current=null] : iv_ruleAssuranceCasePlan= ruleAssuranceCasePlan EOF ;
    public final EObject entryRuleAssuranceCasePlan() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssuranceCasePlan = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:129:2: (iv_ruleAssuranceCasePlan= ruleAssuranceCasePlan EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:130:2: iv_ruleAssuranceCasePlan= ruleAssuranceCasePlan EOF
            {
             newCompositeNode(grammarAccess.getAssuranceCasePlanRule()); 
            pushFollow(FOLLOW_ruleAssuranceCasePlan_in_entryRuleAssuranceCasePlan202);
            iv_ruleAssuranceCasePlan=ruleAssuranceCasePlan();

            state._fsp--;

             current =iv_ruleAssuranceCasePlan; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssuranceCasePlan212); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssuranceCasePlan"


    // $ANTLR start "ruleAssuranceCasePlan"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:137:1: ruleAssuranceCasePlan returns [EObject current=null] : (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_4= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) ) ) otherlv_14= ']' ) ;
    public final EObject ruleAssuranceCasePlan() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_title_7_0 = null;

        EObject lv_description_9_0 = null;

        EObject lv_constant_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:140:28: ( (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_4= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) ) ) otherlv_14= ']' ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:141:1: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_4= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) ) ) otherlv_14= ']' )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:141:1: (otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_4= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) ) ) otherlv_14= ']' )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:141:3: otherlv_0= 'case' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'for' ( ( ruleAadlClassifierReference ) ) otherlv_4= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) ) ) otherlv_14= ']'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleAssuranceCasePlan249); 

                	newLeafNode(otherlv_0, grammarAccess.getAssuranceCasePlanAccess().getCaseKeyword_0());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:145:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:146:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:147:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssuranceCasePlan266); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAssuranceCasePlanAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceCasePlanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleAssuranceCasePlan283); 

                	newLeafNode(otherlv_2, grammarAccess.getAssuranceCasePlanAccess().getForKeyword_2());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:167:1: ( ( ruleAadlClassifierReference ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: ( ruleAadlClassifierReference )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:168:1: ( ruleAadlClassifierReference )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:169:3: ruleAadlClassifierReference
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssuranceCasePlanRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getSystemComponentImplementationCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleAssuranceCasePlan306);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAssuranceCasePlan318); 

                	newLeafNode(otherlv_4, grammarAccess.getAssuranceCasePlanAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:186:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:188:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:188:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:189:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5());
            	
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:192:2: ( ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?)
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:193:3: ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+ {...}?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:193:3: ( ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=4;
                int LA5_0 = input.LA(1);

                if ( LA5_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 0) ) {
                    alt5=1;
                }
                else if ( LA5_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 1) ) {
                    alt5=2;
                }
                else if ( LA5_0 >=17 && LA5_0<=18 && getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 2) ) {
                    alt5=3;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:195:4: ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:195:4: ({...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:196:5: {...}? => ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:196:114: ( ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:197:6: ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:200:6: ({...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:200:7: {...}? => (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:200:16: (otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:200:18: otherlv_6= 'title' ( (lv_title_7_0= ruleValueString ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleAssuranceCasePlan376); 

            	        	newLeafNode(otherlv_6, grammarAccess.getAssuranceCasePlanAccess().getTitleKeyword_5_0_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:204:1: ( (lv_title_7_0= ruleValueString ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:205:1: (lv_title_7_0= ruleValueString )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:205:1: (lv_title_7_0= ruleValueString )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:206:3: lv_title_7_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getTitleValueStringParserRuleCall_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleAssuranceCasePlan397);
            	    lv_title_7_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssuranceCasePlanRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_7_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:229:4: ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:229:4: ({...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:230:5: {...}? => ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:230:114: ( ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:231:6: ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:234:6: ({...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:234:7: {...}? => (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:234:16: (otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:234:18: otherlv_8= 'description' ( (lv_description_9_0= ruleDescription ) )
            	    {
            	    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleAssuranceCasePlan465); 

            	        	newLeafNode(otherlv_8, grammarAccess.getAssuranceCasePlanAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:238:1: ( (lv_description_9_0= ruleDescription ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:239:1: (lv_description_9_0= ruleDescription )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:239:1: (lv_description_9_0= ruleDescription )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:240:3: lv_description_9_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleAssuranceCasePlan486);
            	    lv_description_9_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssuranceCasePlanRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_9_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:263:4: ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:263:4: ({...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:264:5: {...}? => ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "getUnorderedGroupHelper().canSelect(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:264:114: ( ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:265:6: ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:6: ({...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* ) )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:7: {...}? => ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "true");
            	    }
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:16: ( (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )* )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:17: (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )? otherlv_12= 'plans' ( ( ruleQualifiedName ) )*
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:17: (otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+ )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==17) ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:268:19: otherlv_10= 'constants' ( (lv_constant_11_0= ruleFinalValue ) )+
            	            {
            	            otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleAssuranceCasePlan555); 

            	                	newLeafNode(otherlv_10, grammarAccess.getAssuranceCasePlanAccess().getConstantsKeyword_5_2_0_0());
            	                
            	            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:272:1: ( (lv_constant_11_0= ruleFinalValue ) )+
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
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:273:1: (lv_constant_11_0= ruleFinalValue )
            	            	    {
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:273:1: (lv_constant_11_0= ruleFinalValue )
            	            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:274:3: lv_constant_11_0= ruleFinalValue
            	            	    {
            	            	     
            	            	    	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getConstantFinalValueParserRuleCall_5_2_0_1_0()); 
            	            	    	    
            	            	    pushFollow(FOLLOW_ruleFinalValue_in_ruleAssuranceCasePlan576);
            	            	    lv_constant_11_0=ruleFinalValue();

            	            	    state._fsp--;


            	            	    	        if (current==null) {
            	            	    	            current = createModelElementForParent(grammarAccess.getAssuranceCasePlanRule());
            	            	    	        }
            	            	           		add(
            	            	           			current, 
            	            	           			"constant",
            	            	            		lv_constant_11_0, 
            	            	            		"FinalValue");
            	            	    	        afterParserOrEnumRuleCall();
            	            	    	    

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


            	            }
            	            break;

            	    }

            	    otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleAssuranceCasePlan591); 

            	        	newLeafNode(otherlv_12, grammarAccess.getAssuranceCasePlanAccess().getPlansKeyword_5_2_1());
            	        
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:294:1: ( ( ruleQualifiedName ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==RULE_ID) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:295:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:295:1: ( ruleQualifiedName )
            	    	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:296:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getAssuranceCasePlanRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getAssuranceCasePlanAccess().getPlansVerificationPlanCrossReference_5_2_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleAssuranceCasePlan614);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5()) ) {
                throw new FailedPredicateException(input, "ruleAssuranceCasePlan", "getUnorderedGroupHelper().canLeave(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getAssuranceCasePlanAccess().getUnorderedGroup_5());
            	

            }

            otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleAssuranceCasePlan674); 

                	newLeafNode(otherlv_14, grammarAccess.getAssuranceCasePlanAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleAssuranceCasePlan"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:338:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:339:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:340:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription712);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription722); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:347:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:350:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:351:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:351:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_STRING)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:352:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:352:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:353:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription767);
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:377:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:378:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:379:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement803);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement813); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:386:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:389:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:390:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:391:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:392:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement855); 

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
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:409:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:409:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:410:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:410:1: (otherlv_1= RULE_ID )
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:411:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement886); 

                    		newLeafNode(otherlv_1, grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
                    	

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


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:430:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:431:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:432:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath922);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath932); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:439:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:442:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:443:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:443:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:443:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:443:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:444:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:444:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:445:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath977); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:456:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:456:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleReferencePath990); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:460:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:461:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:461:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:462:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1011);
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


    // $ANTLR start "entryRuleFinalValue"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:488:1: entryRuleFinalValue returns [EObject current=null] : iv_ruleFinalValue= ruleFinalValue EOF ;
    public final EObject entryRuleFinalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinalValue = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:489:2: (iv_ruleFinalValue= ruleFinalValue EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:490:2: iv_ruleFinalValue= ruleFinalValue EOF
            {
             newCompositeNode(grammarAccess.getFinalValueRule()); 
            pushFollow(FOLLOW_ruleFinalValue_in_entryRuleFinalValue1050);
            iv_ruleFinalValue=ruleFinalValue();

            state._fsp--;

             current =iv_ruleFinalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFinalValue1060); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinalValue"


    // $ANTLR start "ruleFinalValue"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:497:1: ruleFinalValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleFinalValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:500:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:501:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:502:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:503:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFinalValue1102); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFinalValueAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFinalValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleFinalValue1119); 

                	newLeafNode(otherlv_1, grammarAccess.getFinalValueAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:523:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:524:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:524:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:525:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getFinalValueAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleFinalValue1140);
            lv_value_2_0=ruleValueString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFinalValueRule());
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
    // $ANTLR end "ruleFinalValue"


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:549:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:550:2: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:551:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString1177);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString1188); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:558:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:561:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:562:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString1227); 

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:577:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:578:2: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:579:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1272);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference1283); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:586:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:589:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:2: (this_ID_0= RULE_ID kw= '::' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==22) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:590:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1324); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleAadlClassifierReference1342); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1359); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:610:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:611:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleAadlClassifierReference1378); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference1393); 

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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:633:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:634:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:635:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1443);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1454); 

            }

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
    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:642:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:645:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:646:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:646:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:646:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1494); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:653:1: (kw= '.' this_ID_2= RULE_ID )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.alisa.workbench/src-gen/org/osate/alisa/workbench/parser/antlr/internal/InternalAlisa.g:654:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,20,FOLLOW_20_in_ruleQualifiedName1513); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1528); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop10;
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
    public static final BitSet FOLLOW_ruleAssuranceCasePlan_in_ruleAlisaWorkArea165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleAssuranceCasePlan_in_entryRuleAssuranceCasePlan202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssuranceCasePlan212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleAssuranceCasePlan249 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssuranceCasePlan266 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAssuranceCasePlan283 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleAssuranceCasePlan306 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleAssuranceCasePlan318 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_15_in_ruleAssuranceCasePlan376 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleAssuranceCasePlan397 = new BitSet(new long[]{0x00000000000F8000L});
    public static final BitSet FOLLOW_16_in_ruleAssuranceCasePlan465 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleAssuranceCasePlan486 = new BitSet(new long[]{0x00000000000F8000L});
    public static final BitSet FOLLOW_17_in_ruleAssuranceCasePlan555 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleAssuranceCasePlan576 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleAssuranceCasePlan591 = new BitSet(new long[]{0x00000000000F8010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssuranceCasePlan614 = new BitSet(new long[]{0x00000000000F8010L});
    public static final BitSet FOLLOW_19_in_ruleAssuranceCasePlan674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription767 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath977 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleReferencePath990 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFinalValue_in_entryRuleFinalValue1050 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFinalValue1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFinalValue1102 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFinalValue1119 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleFinalValue1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString1177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference1272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1324 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleAadlClassifierReference1342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1359 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleAadlClassifierReference1378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1494 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleQualifiedName1513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1528 = new BitSet(new long[]{0x0000000000100002L});

}
