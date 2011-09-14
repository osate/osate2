package org.osate.xtext.aadl2.sandbox.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.sandbox.services.SandboxGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSandboxParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_8", "KEYWORD_7", "KEYWORD_6", "KEYWORD_5", "KEYWORD_3", "KEYWORD_4", "KEYWORD_1", "KEYWORD_2", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=12;
    public static final int RULE_STRING=14;
    public static final int RULE_ANY_OTHER=18;
    public static final int KEYWORD_6=6;
    public static final int KEYWORD_7=5;
    public static final int KEYWORD_8=4;
    public static final int KEYWORD_1=10;
    public static final int RULE_INT=13;
    public static final int KEYWORD_5=7;
    public static final int KEYWORD_4=9;
    public static final int KEYWORD_3=8;
    public static final int KEYWORD_2=11;
    public static final int RULE_WS=17;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=15;

    // delegates
    // delegators


        public InternalSandboxParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSandboxParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSandboxParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g"; }




    	private SandboxGrammarAccess grammarAccess;
    	 	
    	public InternalSandboxParser(TokenStream input, SandboxGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Sandbox";	
    	} 
    	   	   	
    	@Override
    	protected SandboxGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleSandbox"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:61:1: entryRuleSandbox returns [EObject current=null] : iv_ruleSandbox= ruleSandbox EOF ;
    public final EObject entryRuleSandbox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSandbox = null;


        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:62:2: (iv_ruleSandbox= ruleSandbox EOF )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:63:2: iv_ruleSandbox= ruleSandbox EOF
            {
             newCompositeNode(grammarAccess.getSandboxRule()); 
            pushFollow(FOLLOW_ruleSandbox_in_entryRuleSandbox67);
            iv_ruleSandbox=ruleSandbox();

            state._fsp--;

             current =iv_ruleSandbox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSandbox77); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSandbox"


    // $ANTLR start "ruleSandbox"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:70:1: ruleSandbox returns [EObject current=null] : (otherlv_0= KEYWORD_7 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) ) ;
    public final EObject ruleSandbox() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_systemInstance_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:73:28: ( (otherlv_0= KEYWORD_7 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:74:1: (otherlv_0= KEYWORD_7 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:74:1: (otherlv_0= KEYWORD_7 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:75:2: otherlv_0= KEYWORD_7 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleSandbox115); 

                	newLeafNode(otherlv_0, grammarAccess.getSandboxAccess().getSandboxKeyword_0());
                
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:79:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:80:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:80:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:81:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSandbox131); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSandboxAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSandboxRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:97:2: ( (lv_systemInstance_2_0= ruleSystemConfiguration ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:98:1: (lv_systemInstance_2_0= ruleSystemConfiguration )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:98:1: (lv_systemInstance_2_0= ruleSystemConfiguration )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:99:3: lv_systemInstance_2_0= ruleSystemConfiguration
            {
             
            	        newCompositeNode(grammarAccess.getSandboxAccess().getSystemInstanceSystemConfigurationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSystemConfiguration_in_ruleSandbox157);
            lv_systemInstance_2_0=ruleSystemConfiguration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSandboxRule());
            	        }
                   		add(
                   			current, 
                   			"systemInstance",
                    		lv_systemInstance_2_0, 
                    		"SystemConfiguration");
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
    // $ANTLR end "ruleSandbox"


    // $ANTLR start "entryRuleSystemConfiguration"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:123:1: entryRuleSystemConfiguration returns [EObject current=null] : iv_ruleSystemConfiguration= ruleSystemConfiguration EOF ;
    public final EObject entryRuleSystemConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemConfiguration = null;


        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:124:2: (iv_ruleSystemConfiguration= ruleSystemConfiguration EOF )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:125:2: iv_ruleSystemConfiguration= ruleSystemConfiguration EOF
            {
             newCompositeNode(grammarAccess.getSystemConfigurationRule()); 
            pushFollow(FOLLOW_ruleSystemConfiguration_in_entryRuleSystemConfiguration192);
            iv_ruleSystemConfiguration=ruleSystemConfiguration();

            state._fsp--;

             current =iv_ruleSystemConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemConfiguration202); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemConfiguration"


    // $ANTLR start "ruleSystemConfiguration"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:132:1: ruleSystemConfiguration returns [EObject current=null] : (otherlv_0= KEYWORD_6 otherlv_1= KEYWORD_8 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_5 ( (otherlv_4= RULE_ID ) ) ( (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy ) )? otherlv_6= KEYWORD_2 ) ;
    public final EObject ruleSystemConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_systemInstanceProxy_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:135:28: ( (otherlv_0= KEYWORD_6 otherlv_1= KEYWORD_8 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_5 ( (otherlv_4= RULE_ID ) ) ( (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy ) )? otherlv_6= KEYWORD_2 ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:136:1: (otherlv_0= KEYWORD_6 otherlv_1= KEYWORD_8 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_5 ( (otherlv_4= RULE_ID ) ) ( (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy ) )? otherlv_6= KEYWORD_2 )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:136:1: (otherlv_0= KEYWORD_6 otherlv_1= KEYWORD_8 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_5 ( (otherlv_4= RULE_ID ) ) ( (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy ) )? otherlv_6= KEYWORD_2 )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:137:2: otherlv_0= KEYWORD_6 otherlv_1= KEYWORD_8 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_5 ( (otherlv_4= RULE_ID ) ) ( (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy ) )? otherlv_6= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleSystemConfiguration240); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleSystemConfiguration252); 

                	newLeafNode(otherlv_1, grammarAccess.getSystemConfigurationAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:146:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:147:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:147:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:148:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemConfiguration268); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSystemConfigurationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemConfigurationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleSystemConfiguration286); 

                	newLeafNode(otherlv_3, grammarAccess.getSystemConfigurationAccess().getFromKeyword_3());
                
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:169:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:170:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:170:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:171:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemConfigurationRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemConfiguration305); 

            		newLeafNode(otherlv_4, grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:182:2: ( (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==KEYWORD_4) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:183:1: (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy )
                    {
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:183:1: (lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy )
                    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:184:3: lv_systemInstanceProxy_5_0= ruleSystemInstanceProxy
                    {
                     
                    	        newCompositeNode(grammarAccess.getSystemConfigurationAccess().getSystemInstanceProxySystemInstanceProxyParserRuleCall_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSystemInstanceProxy_in_ruleSystemConfiguration326);
                    lv_systemInstanceProxy_5_0=ruleSystemInstanceProxy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSystemConfigurationRule());
                    	        }
                           		set(
                           			current, 
                           			"systemInstanceProxy",
                            		lv_systemInstanceProxy_5_0, 
                            		"SystemInstanceProxy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleSystemConfiguration340); 

                	newLeafNode(otherlv_6, grammarAccess.getSystemConfigurationAccess().getSemicolonKeyword_6());
                

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
    // $ANTLR end "ruleSystemConfiguration"


    // $ANTLR start "entryRuleSystemInstanceProxy"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:213:1: entryRuleSystemInstanceProxy returns [EObject current=null] : iv_ruleSystemInstanceProxy= ruleSystemInstanceProxy EOF ;
    public final EObject entryRuleSystemInstanceProxy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemInstanceProxy = null;


        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:214:2: (iv_ruleSystemInstanceProxy= ruleSystemInstanceProxy EOF )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:215:2: iv_ruleSystemInstanceProxy= ruleSystemInstanceProxy EOF
            {
             newCompositeNode(grammarAccess.getSystemInstanceProxyRule()); 
            pushFollow(FOLLOW_ruleSystemInstanceProxy_in_entryRuleSystemInstanceProxy374);
            iv_ruleSystemInstanceProxy=ruleSystemInstanceProxy();

            state._fsp--;

             current =iv_ruleSystemInstanceProxy; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemInstanceProxy384); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemInstanceProxy"


    // $ANTLR start "ruleSystemInstanceProxy"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:222:1: ruleSystemInstanceProxy returns [EObject current=null] : (otherlv_0= KEYWORD_4 ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleSystemInstanceProxy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:225:28: ( (otherlv_0= KEYWORD_4 ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:226:1: (otherlv_0= KEYWORD_4 ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:226:1: (otherlv_0= KEYWORD_4 ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:227:2: otherlv_0= KEYWORD_4 ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleSystemInstanceProxy422); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemInstanceProxyAccess().getToKeyword_0());
                
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:231:1: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:232:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:232:1: (otherlv_1= RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:233:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceProxyRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemInstanceProxy441); 

            		newLeafNode(otherlv_1, grammarAccess.getSystemInstanceProxyAccess().getInstanceRefEObjectCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleSystemInstanceProxy"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSandbox_in_entryRuleSandbox67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSandbox77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleSandbox115 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSandbox131 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_ruleSandbox157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_entryRuleSystemConfiguration192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemConfiguration202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleSystemConfiguration240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleSystemConfiguration252 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemConfiguration268 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleSystemConfiguration286 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemConfiguration305 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_ruleSystemInstanceProxy_in_ruleSystemConfiguration326 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleSystemConfiguration340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemInstanceProxy_in_entryRuleSystemInstanceProxy374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstanceProxy384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleSystemInstanceProxy422 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstanceProxy441 = new BitSet(new long[]{0x0000000000000002L});

}