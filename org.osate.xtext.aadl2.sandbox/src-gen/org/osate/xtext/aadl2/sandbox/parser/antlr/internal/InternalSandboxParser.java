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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_6", "KEYWORD_5", "KEYWORD_4", "KEYWORD_3", "KEYWORD_2", "KEYWORD_1", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=10;
    public static final int RULE_STRING=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int KEYWORD_6=4;
    public static final int KEYWORD_1=9;
    public static final int RULE_INT=11;
    public static final int KEYWORD_5=5;
    public static final int KEYWORD_4=6;
    public static final int KEYWORD_3=7;
    public static final int KEYWORD_2=8;
    public static final int RULE_WS=15;
    public static final int RULE_SL_COMMENT=14;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=13;

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
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:70:1: ruleSandbox returns [EObject current=null] : (otherlv_0= KEYWORD_5 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) ) ;
    public final EObject ruleSandbox() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_systemInstance_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:73:28: ( (otherlv_0= KEYWORD_5 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:74:1: (otherlv_0= KEYWORD_5 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:74:1: (otherlv_0= KEYWORD_5 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:75:2: otherlv_0= KEYWORD_5 ( (lv_name_1_0= RULE_ID ) ) ( (lv_systemInstance_2_0= ruleSystemConfiguration ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleSandbox115); 

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
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:132:1: ruleSystemConfiguration returns [EObject current=null] : (otherlv_0= KEYWORD_4 otherlv_1= KEYWORD_6 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_3 ( ( ruleQIREF ) ) ) ;
    public final EObject ruleSystemConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:135:28: ( (otherlv_0= KEYWORD_4 otherlv_1= KEYWORD_6 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_3 ( ( ruleQIREF ) ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:136:1: (otherlv_0= KEYWORD_4 otherlv_1= KEYWORD_6 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_3 ( ( ruleQIREF ) ) )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:136:1: (otherlv_0= KEYWORD_4 otherlv_1= KEYWORD_6 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_3 ( ( ruleQIREF ) ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:137:2: otherlv_0= KEYWORD_4 otherlv_1= KEYWORD_6 ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_3 ( ( ruleQIREF ) )
            {
            otherlv_0=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleSystemConfiguration240); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemConfigurationAccess().getSystemKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleSystemConfiguration252); 

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

            otherlv_3=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleSystemConfiguration286); 

                	newLeafNode(otherlv_3, grammarAccess.getSystemConfigurationAccess().getFromKeyword_3());
                
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:169:1: ( ( ruleQIREF ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:170:1: ( ruleQIREF )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:170:1: ( ruleQIREF )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:171:3: ruleQIREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemConfigurationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemConfigurationAccess().getSystemImplementationSystemImplementationCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleQIREF_in_ruleSystemConfiguration308);
            ruleQIREF();

            state._fsp--;

             
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
    // $ANTLR end "ruleSystemConfiguration"


    // $ANTLR start "entryRuleQIREF"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:192:1: entryRuleQIREF returns [String current=null] : iv_ruleQIREF= ruleQIREF EOF ;
    public final String entryRuleQIREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQIREF = null;


        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:193:1: (iv_ruleQIREF= ruleQIREF EOF )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:194:2: iv_ruleQIREF= ruleQIREF EOF
            {
             newCompositeNode(grammarAccess.getQIREFRule()); 
            pushFollow(FOLLOW_ruleQIREF_in_entryRuleQIREF344);
            iv_ruleQIREF=ruleQIREF();

            state._fsp--;

             current =iv_ruleQIREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQIREF355); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQIREF"


    // $ANTLR start "ruleQIREF"
    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:201:1: ruleQIREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= KEYWORD_2 )* this_ID_2= RULE_ID kw= KEYWORD_1 this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQIREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:205:6: ( ( (this_ID_0= RULE_ID kw= KEYWORD_2 )* this_ID_2= RULE_ID kw= KEYWORD_1 this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:206:1: ( (this_ID_0= RULE_ID kw= KEYWORD_2 )* this_ID_2= RULE_ID kw= KEYWORD_1 this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:206:1: ( (this_ID_0= RULE_ID kw= KEYWORD_2 )* this_ID_2= RULE_ID kw= KEYWORD_1 this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:206:2: (this_ID_0= RULE_ID kw= KEYWORD_2 )* this_ID_2= RULE_ID kw= KEYWORD_1 this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:206:2: (this_ID_0= RULE_ID kw= KEYWORD_2 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==KEYWORD_2) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.sandbox/src-gen/org/osate/xtext/aadl2/sandbox/parser/antlr/internal/InternalSandboxParser.g:206:7: this_ID_0= RULE_ID kw= KEYWORD_2
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQIREF396); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQIREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleQIREF414); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQIREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQIREF431); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQIREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleQIREF449); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQIREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQIREF464); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getQIREFAccess().getIDTerminalRuleCall_3()); 
                

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
    // $ANTLR end "ruleQIREF"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSandbox_in_entryRuleSandbox67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSandbox77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleSandbox115 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSandbox131 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_ruleSandbox157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemConfiguration_in_entryRuleSystemConfiguration192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemConfiguration202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleSystemConfiguration240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleSystemConfiguration252 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemConfiguration268 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleSystemConfiguration286 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ruleQIREF_in_ruleSystemConfiguration308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQIREF_in_entryRuleQIREF344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQIREF355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQIREF396 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleQIREF414 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQIREF431 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleQIREF449 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQIREF464 = new BitSet(new long[]{0x0000000000000002L});

}