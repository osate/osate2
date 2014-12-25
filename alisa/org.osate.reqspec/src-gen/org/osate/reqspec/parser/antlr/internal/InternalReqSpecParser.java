package org.osate.reqspec.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.reqspec.services.ReqSpecGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReqSpecParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Description", "Requirement", "Stakeholder", "Decomposes", "Assertion", "Conflicts", "Mitigates", "Rationale", "Category", "Document", "Evolves", "Package", "Refines", "Folder", "Hazard", "Import", "Issues", "Title", "Goal", "For", "See", "Val", "FullStopAsterisk", "ColonColon", "Of", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Solidus", "Colon", "EqualsSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=39;
    public static final int RightParenthesis=31;
    public static final int RULE_ANY_OTHER=45;
    public static final int LeftParenthesis=30;
    public static final int RightSquareBracket=38;
    public static final int Issues=20;
    public static final int Mitigates=10;
    public static final int Requirement=5;
    public static final int Solidus=34;
    public static final int EOF=-1;
    public static final int FullStop=33;
    public static final int Evolves=14;
    public static final int Assertion=8;
    public static final int RULE_INT=40;
    public static final int Decomposes=7;
    public static final int LeftSquareBracket=37;
    public static final int Refines=16;
    public static final int Conflicts=9;
    public static final int Hazard=18;
    public static final int Stakeholder=6;
    public static final int Import=19;
    public static final int FullStopAsterisk=26;
    public static final int Colon=35;
    public static final int RULE_SL_COMMENT=43;
    public static final int Package=15;
    public static final int For=23;
    public static final int NumberSign=29;
    public static final int Rationale=11;
    public static final int Goal=22;
    public static final int RULE_ML_COMMENT=42;
    public static final int ColonColon=27;
    public static final int Document=13;
    public static final int Description=4;
    public static final int Folder=17;
    public static final int RULE_STRING=41;
    public static final int See=24;
    public static final int Title=21;
    public static final int Category=12;
    public static final int RULE_WS=44;
    public static final int EqualsSign=36;
    public static final int Comma=32;
    public static final int Val=25;
    public static final int Of=28;

    // delegates
    // delegators


        public InternalReqSpecParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReqSpecParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReqSpecParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g"; }




    	private ReqSpecGrammarAccess grammarAccess;
    	 	
    	public InternalReqSpecParser(TokenStream input, ReqSpecGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "ReqSpec";	
    	} 
    	   	   	
    	@Override
    	protected ReqSpecGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleReqSpec"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:61:1: entryRuleReqSpec returns [EObject current=null] : iv_ruleReqSpec= ruleReqSpec EOF ;
    public final EObject entryRuleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpec = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:62:2: (iv_ruleReqSpec= ruleReqSpec EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:63:2: iv_ruleReqSpec= ruleReqSpec EOF
            {
             newCompositeNode(grammarAccess.getReqSpecRule()); 
            pushFollow(FOLLOW_ruleReqSpec_in_entryRuleReqSpec67);
            iv_ruleReqSpec=ruleReqSpec();

            state._fsp--;

             current =iv_ruleReqSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpec77); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReqSpec"


    // $ANTLR start "ruleReqSpec"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:70:1: ruleReqSpec returns [EObject current=null] : this_ReqSpecModel_0= ruleReqSpecModel ;
    public final EObject ruleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject this_ReqSpecModel_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:73:28: (this_ReqSpecModel_0= ruleReqSpecModel )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:5: this_ReqSpecModel_0= ruleReqSpecModel
            {
             
                    newCompositeNode(grammarAccess.getReqSpecAccess().getReqSpecModelParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleReqSpecModel_in_ruleReqSpec123);
            this_ReqSpecModel_0=ruleReqSpecModel();

            state._fsp--;


                    current = this_ReqSpecModel_0;
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleReqSpec"


    // $ANTLR start "entryRuleReqSpecModel"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:95:1: entryRuleReqSpecModel returns [EObject current=null] : iv_ruleReqSpecModel= ruleReqSpecModel EOF ;
    public final EObject entryRuleReqSpecModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecModel = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:96:2: (iv_ruleReqSpecModel= ruleReqSpecModel EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:97:2: iv_ruleReqSpecModel= ruleReqSpecModel EOF
            {
             newCompositeNode(grammarAccess.getReqSpecModelRule()); 
            pushFollow(FOLLOW_ruleReqSpecModel_in_entryRuleReqSpecModel160);
            iv_ruleReqSpecModel=ruleReqSpecModel();

            state._fsp--;

             current =iv_ruleReqSpecModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecModel170); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReqSpecModel"


    // $ANTLR start "ruleReqSpecModel"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:104:1: ruleReqSpecModel returns [EObject current=null] : (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket ) ;
    public final EObject ruleReqSpecModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_import_4_0 = null;

        EObject lv_content_6_1 = null;

        EObject lv_content_6_2 = null;

        EObject lv_content_6_3 = null;

        AntlrDatatypeRuleToken lv_issue_9_0 = null;

        AntlrDatatypeRuleToken lv_issue_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:107:28: ( (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:108:1: (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:108:1: (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:109:2: otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Package,FOLLOW_Package_in_ruleReqSpecModel208); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecModelAccess().getPackageKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:113:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:114:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:114:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:115:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecModel224); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReqSpecModelAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:131:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==For) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:132:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecModel243); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecModelAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:136:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:137:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:137:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:138:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecModelRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecModel265);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:151:4: ( (lv_import_4_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Import) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:152:1: (lv_import_4_0= ruleImport )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:152:1: (lv_import_4_0= ruleImport )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:153:3: lv_import_4_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getImportImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleReqSpecModel288);
            	    lv_import_4_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getReqSpecModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"import",
            	            		lv_import_4_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecModel302); 

                	newLeafNode(otherlv_5, grammarAccess.getReqSpecModelAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:174:1: ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Requirement||LA4_0==Folder||LA4_0==Goal) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:175:1: ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:175:1: ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:176:1: (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:176:1: (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder )
            	    int alt3=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt3=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt3=2;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt3=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt3) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:177:3: lv_content_6_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecModel324);
            	            lv_content_6_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_6_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:192:8: lv_content_6_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecModel343);
            	            lv_content_6_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_6_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:207:8: lv_content_6_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getContentReqSpecFolderParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecModel362);
            	            lv_content_6_3=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecModelRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_6_3, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:225:3: (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Issues) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:226:2: otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket
                    {
                    otherlv_7=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecModel380); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecModelAccess().getIssuesKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecModel392); 

                        	newLeafNode(otherlv_8, grammarAccess.getReqSpecModelAccess().getLeftSquareBracketKeyword_6_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:235:1: ( (lv_issue_9_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:236:1: (lv_issue_9_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:236:1: (lv_issue_9_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:237:3: lv_issue_9_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getIssueValueStringParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecModel412);
                    lv_issue_9_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecModelRule());
                    	        }
                           		add(
                           			current, 
                           			"issue",
                            		lv_issue_9_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:253:2: (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==Comma) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:254:2: otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecModel426); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getReqSpecModelAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:258:1: ( (lv_issue_11_0= ruleValueString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:259:1: (lv_issue_11_0= ruleValueString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:259:1: (lv_issue_11_0= ruleValueString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:260:3: lv_issue_11_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getIssueValueStringParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecModel446);
                    	    lv_issue_11_0=ruleValueString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecModelRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_11_0, 
                    	            		"ValueString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecModel461); 

                        	newLeafNode(otherlv_12, grammarAccess.getReqSpecModelAccess().getRightSquareBracketKeyword_6_4());
                        

                    }
                    break;

            }

            otherlv_13=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecModel475); 

                	newLeafNode(otherlv_13, grammarAccess.getReqSpecModelAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleReqSpecModel"


    // $ANTLR start "entryRuleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:294:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:295:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:296:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder509);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder519); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReqSpecFolder"


    // $ANTLR start "ruleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:303:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) ;
    public final EObject ruleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_label_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_content_5_1 = null;

        EObject lv_content_5_2 = null;

        EObject lv_content_5_3 = null;

        AntlrDatatypeRuleToken lv_issue_8_0 = null;

        AntlrDatatypeRuleToken lv_issue_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:306:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:307:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:307:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:308:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder557); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:312:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:313:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:313:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:314:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder573); 

            			newLeafNode(lv_label_1_0, grammarAccess.getReqSpecFolderAccess().getLabelIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecFolderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:330:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==For) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:331:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecFolder592); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:335:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:336:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:336:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:337:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecFolderRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder614);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder629); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:355:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Requirement||LA9_0==Folder||LA9_0==Goal) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:356:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:356:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:357:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:357:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    int alt8=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:358:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder651);
            	            lv_content_5_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:373:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder670);
            	            lv_content_5_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:388:8: lv_content_5_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder689);
            	            lv_content_5_3=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_3, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:406:3: (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Issues) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:407:2: otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecFolder707); 

                        	newLeafNode(otherlv_6, grammarAccess.getReqSpecFolderAccess().getIssuesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder719); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_5_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:416:1: ( (lv_issue_8_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:417:1: (lv_issue_8_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:417:1: (lv_issue_8_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:418:3: lv_issue_8_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueValueStringParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder739);
                    lv_issue_8_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
                    	        }
                           		add(
                           			current, 
                           			"issue",
                            		lv_issue_8_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:434:2: (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Comma) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:435:2: otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecFolder753); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getReqSpecFolderAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:439:1: ( (lv_issue_10_0= ruleValueString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:440:1: (lv_issue_10_0= ruleValueString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:440:1: (lv_issue_10_0= ruleValueString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:441:3: lv_issue_10_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueValueStringParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder773);
                    	    lv_issue_10_0=ruleValueString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_10_0, 
                    	            		"ValueString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder788); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder802); 

                	newLeafNode(otherlv_12, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleReqSpecFolder"


    // $ANTLR start "entryRuleRSLVariable"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:475:1: entryRuleRSLVariable returns [EObject current=null] : iv_ruleRSLVariable= ruleRSLVariable EOF ;
    public final EObject entryRuleRSLVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRSLVariable = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:476:2: (iv_ruleRSLVariable= ruleRSLVariable EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:477:2: iv_ruleRSLVariable= ruleRSLVariable EOF
            {
             newCompositeNode(grammarAccess.getRSLVariableRule()); 
            pushFollow(FOLLOW_ruleRSLVariable_in_entryRuleRSLVariable836);
            iv_ruleRSLVariable=ruleRSLVariable();

            state._fsp--;

             current =iv_ruleRSLVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRSLVariable846); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRSLVariable"


    // $ANTLR start "ruleRSLVariable"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:484:1: ruleRSLVariable returns [EObject current=null] : (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) ) ;
    public final EObject ruleRSLVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:487:28: ( (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:488:1: (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:488:1: (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:489:2: otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) )
            {
            otherlv_0=(Token)match(input,Val,FOLLOW_Val_in_ruleRSLVariable884); 

                	newLeafNode(otherlv_0, grammarAccess.getRSLVariableAccess().getValKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:493:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:494:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:494:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:495:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRSLVariable900); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRSLVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRSLVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleRSLVariable918); 

                	newLeafNode(otherlv_2, grammarAccess.getRSLVariableAccess().getEqualsSignKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:516:1: ( (lv_value_3_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:517:1: (lv_value_3_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:517:1: (lv_value_3_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:518:3: lv_value_3_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getRSLVariableAccess().getValueValueStringParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleRSLVariable938);
            lv_value_3_0=ruleValueString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRSLVariableRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
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
    // $ANTLR end "ruleRSLVariable"


    // $ANTLR start "entryRuleGoal"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:542:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:543:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:544:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal973);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal983); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoal"


    // $ANTLR start "ruleGoal"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:551:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket ) ;
    public final EObject ruleGoal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_13_0 = null;

        AntlrDatatypeRuleToken lv_assert_15_0 = null;

        AntlrDatatypeRuleToken lv_rationale_17_0 = null;

        AntlrDatatypeRuleToken lv_issue_19_0 = null;

        AntlrDatatypeRuleToken lv_issue_21_0 = null;

        EObject lv_subgoal_26_0 = null;

        EObject lv_docReference_55_0 = null;

        EObject lv_docReference_57_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:554:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:555:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:555:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:556:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1021); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:560:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:561:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:561:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:562:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1037); 

            			newLeafNode(lv_name_1_0, grammarAccess.getGoalAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGoalRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:578:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:579:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal1056); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:583:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:584:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:584:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:585:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1076);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGoalRule());
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:601:4: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==For) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:602:2: otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal1092); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:606:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:607:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:607:1: (otherlv_5= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:608:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGoalRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1111); 

                    		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:619:2: (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==Of) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:620:2: otherlv_6= Of ( ( ruleAadlClassifierReference ) )
                            {
                            otherlv_6=(Token)match(input,Of,FOLLOW_Of_in_ruleGoal1125); 

                                	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getOfKeyword_3_2_0());
                                
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:624:1: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:625:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:625:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:626:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGoalRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getGoalAccess().getTargetContextClassifierCrossReference_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleGoal1147);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1164); 

                	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:644:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:646:1: ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:646:1: ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:647:2: ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:650:2: ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:651:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:651:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop25:
            do {
                int alt25=15;
                alt25 = dfa25.predict(input);
                switch (alt25) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:4: ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:4: ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:5: {...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:101: ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:655:6: ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:658:6: ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:658:7: {...}? => (otherlv_10= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:658:16: (otherlv_10= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:659:2: otherlv_10= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_10=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal1222); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:663:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:664:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:664:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:665:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal1244);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:685:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:685:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:686:5: {...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:686:101: ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:687:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:690:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:690:7: {...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:690:16: (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:691:2: otherlv_12= Description ( (lv_description_13_0= ruleDescription ) )
            	    {
            	    otherlv_12=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal1313); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:695:1: ( (lv_description_13_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:696:1: (lv_description_13_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:696:1: (lv_description_13_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:697:3: lv_description_13_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1333);
            	    lv_description_13_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_13_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:720:4: ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:720:4: ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:721:5: {...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:721:101: ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:722:6: ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:725:6: ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:725:7: {...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:725:16: (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:726:2: otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,Assertion,FOLLOW_Assertion_in_ruleGoal1402); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getAssertionKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:730:1: ( (lv_assert_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:731:1: (lv_assert_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:731:1: (lv_assert_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:732:3: lv_assert_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertValueStringParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1422);
            	    lv_assert_15_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_15_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:755:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:755:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:756:5: {...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:756:101: ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:757:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:760:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:760:7: {...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:760:16: (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:761:2: otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) )
            	    {
            	    otherlv_16=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal1491); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getRationaleKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:765:1: ( (lv_rationale_17_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:766:1: (lv_rationale_17_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:766:1: (lv_rationale_17_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:767:3: lv_rationale_17_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1511);
            	    lv_rationale_17_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_17_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:790:4: ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:790:4: ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:5: {...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:101: ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:6: ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:795:6: ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:795:7: {...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:795:16: (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:796:2: otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )*
            	    {
            	    otherlv_18=(Token)match(input,Issues,FOLLOW_Issues_in_ruleGoal1580); 

            	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getIssuesKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:800:1: ( (lv_issue_19_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:801:1: (lv_issue_19_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:801:1: (lv_issue_19_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:802:3: lv_issue_19_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_5_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1600);
            	    lv_issue_19_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_19_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:818:2: (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==Comma) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:819:2: otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_20=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal1614); 

            	    	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getCommaKeyword_5_4_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:823:1: ( (lv_issue_21_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:824:1: (lv_issue_21_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:824:1: (lv_issue_21_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:825:3: lv_issue_21_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_5_4_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1634);
            	    	    lv_issue_21_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_21_0, 
            	    	            		"ValueString");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:848:4: ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:848:4: ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:5: {...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:101: ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:850:6: ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:853:6: ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:853:7: {...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:853:16: (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:854:2: otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_22=(Token)match(input,Refines,FOLLOW_Refines_in_ruleGoal1705); 

            	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getRefinesKeyword_5_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:858:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:859:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:859:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:860:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal1727);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:873:2: (otherlv_24= Comma ( ( ruleQualifiedName ) ) )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==Comma) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:874:2: otherlv_24= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_24=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal1741); 

            	    	        	newLeafNode(otherlv_24, grammarAccess.getGoalAccess().getCommaKeyword_5_5_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:878:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:879:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:879:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:880:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal1763);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:900:4: ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:900:4: ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:901:5: {...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:901:101: ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:902:6: ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:905:6: ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==Goal) ) {
            	            int LA17_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:905:7: {...}? => ( (lv_subgoal_26_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:905:16: ( (lv_subgoal_26_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:906:1: (lv_subgoal_26_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:906:1: (lv_subgoal_26_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:907:3: lv_subgoal_26_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_5_6_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal1841);
            	    	    lv_subgoal_26_0=ruleGoal();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subgoal",
            	    	            		lv_subgoal_26_0, 
            	    	            		"Goal");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:930:4: ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:930:4: ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:931:5: {...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:931:101: ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:932:6: ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:935:6: ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:935:7: {...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:935:16: (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:936:2: otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_27=(Token)match(input,Decomposes,FOLLOW_Decomposes_in_ruleGoal1910); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getDecomposesKeyword_5_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:940:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:941:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:941:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:942:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal1932);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:955:2: (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==Comma) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:956:2: otherlv_29= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal1946); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getCommaKeyword_5_7_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:960:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:961:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:961:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:962:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal1968);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:982:4: ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:982:4: ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:983:5: {...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:983:101: ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:984:6: ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:987:6: ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:987:7: {...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:987:16: (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:988:2: otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleGoal2039); 

            	        	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getEvolvesKeyword_5_8_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:992:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:993:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:993:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:994:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2061);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1007:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==Comma) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1008:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2075); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getCommaKeyword_5_8_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1012:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1013:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1013:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1014:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_8_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2097);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1034:4: ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1034:4: ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1035:5: {...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1035:101: ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1036:6: ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1039:6: ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1039:7: {...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1039:16: (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1040:2: otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_35=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2168); 

            	        	newLeafNode(otherlv_35, grammarAccess.getGoalAccess().getConflictsKeyword_5_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1044:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1045:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1045:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1046:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2190);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1059:2: (otherlv_37= Comma ( ( ruleQualifiedName ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Comma) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1060:2: otherlv_37= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_37=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2204); 

            	    	        	newLeafNode(otherlv_37, grammarAccess.getGoalAccess().getCommaKeyword_5_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1064:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1065:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1065:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1066:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2226);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1086:4: ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1086:4: ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1087:5: {...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1087:102: ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1088:6: ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:6: ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:7: {...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:16: (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1092:2: otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_39=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2297); 

            	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1096:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1097:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1097:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2319);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1111:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Comma) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1112:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2333); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getCommaKeyword_5_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1116:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1117:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1117:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2355);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1138:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1138:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1139:5: {...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1139:102: ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1140:6: ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:6: ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:7: {...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:16: (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:2: otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,See,FOLLOW_See_in_ruleGoal2426); 

            	        	newLeafNode(otherlv_43, grammarAccess.getGoalAccess().getSeeKeyword_5_11_0());
            	        
            	    otherlv_44=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal2438); 

            	        	newLeafNode(otherlv_44, grammarAccess.getGoalAccess().getGoalKeyword_5_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1153:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1154:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1154:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1155:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2460);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1168:2: (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Comma) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1169:2: otherlv_46= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_46=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2474); 

            	    	        	newLeafNode(otherlv_46, grammarAccess.getGoalAccess().getCommaKeyword_5_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1173:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1174:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1174:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1175:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2496);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1195:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1195:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1196:5: {...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1196:102: ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1197:6: ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:6: ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:7: {...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:16: (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1201:2: otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_48=(Token)match(input,See,FOLLOW_See_in_ruleGoal2567); 

            	        	newLeafNode(otherlv_48, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0());
            	        
            	    otherlv_49=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal2579); 

            	        	newLeafNode(otherlv_49, grammarAccess.getGoalAccess().getRequirementKeyword_5_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1210:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1211:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1211:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1212:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2601);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1225:2: (otherlv_51= Comma ( ( ruleQualifiedName ) ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Comma) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1226:2: otherlv_51= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_51=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2615); 

            	    	        	newLeafNode(otherlv_51, grammarAccess.getGoalAccess().getCommaKeyword_5_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1230:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1232:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2637);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1252:4: ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1252:4: ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1253:5: {...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1253:102: ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1254:6: ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1257:6: ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1257:7: {...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1257:16: (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1258:2: otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_53=(Token)match(input,See,FOLLOW_See_in_ruleGoal2708); 

            	        	newLeafNode(otherlv_53, grammarAccess.getGoalAccess().getSeeKeyword_5_13_0());
            	        
            	    otherlv_54=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2720); 

            	        	newLeafNode(otherlv_54, grammarAccess.getGoalAccess().getDocumentKeyword_5_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1267:1: ( (lv_docReference_55_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1268:1: (lv_docReference_55_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1268:1: (lv_docReference_55_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1269:3: lv_docReference_55_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2740);
            	    lv_docReference_55_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_55_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1285:2: (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Comma) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1286:2: otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_56=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2754); 

            	    	        	newLeafNode(otherlv_56, grammarAccess.getGoalAccess().getCommaKeyword_5_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1290:1: ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1291:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1291:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1292:3: lv_docReference_57_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2774);
            	    	    lv_docReference_57_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_57_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop24;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_58=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal2830); 

                	newLeafNode(otherlv_58, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleGoal"


    // $ANTLR start "entryRuleRequirement"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1335:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1336:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1337:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement2864);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement2874); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequirement"


    // $ANTLR start "ruleRequirement"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1344:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_61= RightSquareBracket ) ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_57=null;
        Token otherlv_59=null;
        Token otherlv_61=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_14_0 = null;

        AntlrDatatypeRuleToken lv_assert_16_0 = null;

        AntlrDatatypeRuleToken lv_rationale_18_0 = null;

        EObject lv_reqValue_19_0 = null;

        AntlrDatatypeRuleToken lv_issue_21_0 = null;

        AntlrDatatypeRuleToken lv_issue_23_0 = null;

        EObject lv_subrequirement_37_0 = null;

        EObject lv_docReference_58_0 = null;

        EObject lv_docReference_60_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1347:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_61= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1348:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_61= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1348:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_61= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1349:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_61= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement2912); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1353:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1354:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1354:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1355:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement2928); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRequirementAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1371:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Colon) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1372:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement2947); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1376:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1377:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1377:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1378:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement2967);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1394:4: (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LeftParenthesis) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1395:2: otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis
                    {
                    otherlv_4=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleRequirement2983); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1399:1: ( ( ruleCatRef ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1400:1: ( ruleCatRef )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1400:1: ( ruleCatRef )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1401:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3005);
                    ruleCatRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleRequirement3018); 

                        	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1419:3: (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==For) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1420:2: otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )?
                    {
                    otherlv_7=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3033); 

                        	newLeafNode(otherlv_7, grammarAccess.getRequirementAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1424:1: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:1: (otherlv_8= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3052); 

                    		newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1437:2: (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==Of) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1438:2: otherlv_9= Of ( ( ruleAadlClassifierReference ) )
                            {
                            otherlv_9=(Token)match(input,Of,FOLLOW_Of_in_ruleRequirement3066); 

                                	newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getOfKeyword_4_2_0());
                                
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1442:1: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1443:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1443:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1444:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRequirementRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetContextClassifierCrossReference_4_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3088);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3105); 

                	newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1462:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:1: ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:1: ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1465:2: ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1468:2: ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop41:
            do {
                int alt41=15;
                alt41 = dfa41.predict(input);
                switch (alt41) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1471:4: ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1471:4: ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1472:5: {...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1472:108: ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1473:6: ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1476:6: ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1476:7: {...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1476:16: (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1477:2: otherlv_13= Description ( (lv_description_14_0= ruleDescription ) )
            	    {
            	    otherlv_13=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3163); 

            	        	newLeafNode(otherlv_13, grammarAccess.getRequirementAccess().getDescriptionKeyword_6_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1481:1: ( (lv_description_14_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1482:1: (lv_description_14_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1482:1: (lv_description_14_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:3: lv_description_14_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_6_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3183);
            	    lv_description_14_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_14_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:4: ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:4: ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1507:5: {...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1507:108: ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1508:6: ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1511:6: ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1511:7: {...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1511:16: (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1512:2: otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) )
            	    {
            	    otherlv_15=(Token)match(input,Assertion,FOLLOW_Assertion_in_ruleRequirement3252); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRequirementAccess().getAssertionKeyword_6_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1516:1: ( (lv_assert_16_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1517:1: (lv_assert_16_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1517:1: (lv_assert_16_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1518:3: lv_assert_16_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertValueStringParserRuleCall_6_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3272);
            	    lv_assert_16_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_16_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1541:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1541:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1542:5: {...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1542:108: ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1543:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1546:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1546:7: {...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1546:16: (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1547:2: otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) )
            	    {
            	    otherlv_17=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3341); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getRationaleKeyword_6_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1551:1: ( (lv_rationale_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:1: (lv_rationale_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:1: (lv_rationale_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1553:3: lv_rationale_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRationaleValueStringParserRuleCall_6_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3361);
            	    lv_rationale_18_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_18_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1576:4: ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1576:4: ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1577:5: {...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1577:108: ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1578:6: ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1581:6: ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+
            	    int cnt30=0;
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Val) ) {
            	            int LA30_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt30=1;
            	            }


            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1581:7: {...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1581:16: ( (lv_reqValue_19_0= ruleRSLVariable ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1582:1: (lv_reqValue_19_0= ruleRSLVariable )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1582:1: (lv_reqValue_19_0= ruleRSLVariable )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1583:3: lv_reqValue_19_0= ruleRSLVariable
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getReqValueRSLVariableParserRuleCall_6_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRSLVariable_in_ruleRequirement3437);
            	    	    lv_reqValue_19_0=ruleRSLVariable();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"reqValue",
            	    	            		lv_reqValue_19_0, 
            	    	            		"RSLVariable");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt30 >= 1 ) break loop30;
            	                EarlyExitException eee =
            	                    new EarlyExitException(30, input);
            	                throw eee;
            	        }
            	        cnt30++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:4: ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:4: ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1607:5: {...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1607:108: ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1608:6: ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:6: ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:7: {...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:16: (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1612:2: otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )*
            	    {
            	    otherlv_20=(Token)match(input,Issues,FOLLOW_Issues_in_ruleRequirement3506); 

            	        	newLeafNode(otherlv_20, grammarAccess.getRequirementAccess().getIssuesKeyword_6_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1616:1: ( (lv_issue_21_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1617:1: (lv_issue_21_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1617:1: (lv_issue_21_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1618:3: lv_issue_21_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_6_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3526);
            	    lv_issue_21_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_21_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1634:2: (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Comma) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1635:2: otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_22=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3540); 

            	    	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getCommaKeyword_6_4_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1639:1: ( (lv_issue_23_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1640:1: (lv_issue_23_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1640:1: (lv_issue_23_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1641:3: lv_issue_23_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_6_4_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3560);
            	    	    lv_issue_23_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_23_0, 
            	    	            		"ValueString");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop31;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1664:4: ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1664:4: ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1665:5: {...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1665:108: ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1666:6: ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1669:6: ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1669:7: {...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1669:16: (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1670:2: otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_24=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3631); 

            	        	newLeafNode(otherlv_24, grammarAccess.getRequirementAccess().getSeeKeyword_6_5_0());
            	        
            	    otherlv_25=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement3643); 

            	        	newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getGoalKeyword_6_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1679:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1680:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1680:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1681:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_6_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3665);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1694:2: (otherlv_27= Comma ( ( ruleQualifiedName ) ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Comma) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1695:2: otherlv_27= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_27=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3679); 

            	    	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getCommaKeyword_6_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1699:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1700:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1700:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1701:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_6_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3701);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop32;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:4: ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:4: ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1722:5: {...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1722:108: ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1723:6: ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1726:6: ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1726:7: {...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1726:16: (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1727:2: otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )*
            	    {
            	    otherlv_29=(Token)match(input,Mitigates,FOLLOW_Mitigates_in_ruleRequirement3772); 

            	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getMitigatesKeyword_6_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1731:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1732:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1732:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1733:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceHazardCrossReference_6_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3794);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1746:2: (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Comma) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1747:2: otherlv_31= Comma ( (otherlv_32= RULE_ID ) )
            	    	    {
            	    	    otherlv_31=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3808); 

            	    	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getCommaKeyword_6_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1751:1: ( (otherlv_32= RULE_ID ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1752:1: (otherlv_32= RULE_ID )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1752:1: (otherlv_32= RULE_ID )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1753:3: otherlv_32= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	    otherlv_32=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3827); 

            	    	    		newLeafNode(otherlv_32, grammarAccess.getRequirementAccess().getHazardReferenceHazardCrossReference_6_6_2_1_0()); 
            	    	    	

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop33;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1771:4: ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1771:4: ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1772:5: {...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1772:108: ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:6: ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1776:6: ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1776:7: {...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1776:16: (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1777:2: otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_33=(Token)match(input,Refines,FOLLOW_Refines_in_ruleRequirement3898); 

            	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getRefinesKeyword_6_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1781:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1782:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1782:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_6_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3920);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1796:2: (otherlv_35= Comma ( ( ruleQualifiedName ) ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Comma) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1797:2: otherlv_35= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_35=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3934); 

            	    	        	newLeafNode(otherlv_35, grammarAccess.getRequirementAccess().getCommaKeyword_6_7_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1801:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1802:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1802:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1803:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_6_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3956);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop34;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1823:4: ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1823:4: ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1824:5: {...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1824:108: ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1825:6: ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1828:6: ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+
            	    int cnt35=0;
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==Requirement) ) {
            	            int LA35_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt35=1;
            	            }


            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1828:7: {...}? => ( (lv_subrequirement_37_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1828:16: ( (lv_subrequirement_37_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1829:1: (lv_subrequirement_37_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1829:1: (lv_subrequirement_37_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1830:3: lv_subrequirement_37_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_6_8_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement4034);
            	    	    lv_subrequirement_37_0=ruleRequirement();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subrequirement",
            	    	            		lv_subrequirement_37_0, 
            	    	            		"Requirement");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt35 >= 1 ) break loop35;
            	                EarlyExitException eee =
            	                    new EarlyExitException(35, input);
            	                throw eee;
            	        }
            	        cnt35++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1853:4: ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1853:4: ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1854:5: {...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1854:108: ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1855:6: ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1858:6: ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1858:7: {...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1858:16: (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1859:2: otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_38=(Token)match(input,Decomposes,FOLLOW_Decomposes_in_ruleRequirement4103); 

            	        	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getDecomposesKeyword_6_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1863:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1864:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1864:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1865:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_6_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4125);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1878:2: (otherlv_40= Comma ( ( ruleQualifiedName ) ) )*
            	    loop36:
            	    do {
            	        int alt36=2;
            	        int LA36_0 = input.LA(1);

            	        if ( (LA36_0==Comma) ) {
            	            alt36=1;
            	        }


            	        switch (alt36) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1879:2: otherlv_40= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_40=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4139); 

            	    	        	newLeafNode(otherlv_40, grammarAccess.getRequirementAccess().getCommaKeyword_6_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1883:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1884:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1884:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1885:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_6_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4161);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop36;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1905:4: ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1905:4: ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:5: {...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:109: ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:6: ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1910:6: ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1910:7: {...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1910:16: (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1911:2: otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_42=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleRequirement4232); 

            	        	newLeafNode(otherlv_42, grammarAccess.getRequirementAccess().getEvolvesKeyword_6_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1915:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1916:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1916:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1917:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_6_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4254);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:2: (otherlv_44= Comma ( ( ruleQualifiedName ) ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Comma) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1931:2: otherlv_44= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_44=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4268); 

            	    	        	newLeafNode(otherlv_44, grammarAccess.getRequirementAccess().getCommaKeyword_6_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1935:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1937:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_6_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4290);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop37;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1957:4: ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1957:4: ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1958:5: {...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1958:109: ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1959:6: ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:6: ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:7: {...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:16: (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1963:2: otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_46=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4361); 

            	        	newLeafNode(otherlv_46, grammarAccess.getRequirementAccess().getSeeKeyword_6_11_0());
            	        
            	    otherlv_47=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4373); 

            	        	newLeafNode(otherlv_47, grammarAccess.getRequirementAccess().getGoalKeyword_6_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1972:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1973:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1973:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1974:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_6_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4395);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1987:2: (otherlv_49= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1988:2: otherlv_49= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_49=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4409); 

            	    	        	newLeafNode(otherlv_49, grammarAccess.getRequirementAccess().getCommaKeyword_6_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1992:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1993:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1993:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1994:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_6_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4431);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop38;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2014:4: ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2014:4: ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2015:5: {...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2015:109: ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2016:6: ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2019:6: ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2019:7: {...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2019:16: (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2020:2: otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_51=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4502); 

            	        	newLeafNode(otherlv_51, grammarAccess.getRequirementAccess().getSeeKeyword_6_12_0());
            	        
            	    otherlv_52=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement4514); 

            	        	newLeafNode(otherlv_52, grammarAccess.getRequirementAccess().getRequirementKeyword_6_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2029:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2030:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2030:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2031:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_6_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4536);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2044:2: (otherlv_54= Comma ( ( ruleQualifiedName ) ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Comma) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:2: otherlv_54= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_54=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4550); 

            	    	        	newLeafNode(otherlv_54, grammarAccess.getRequirementAccess().getCommaKeyword_6_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2049:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2050:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2050:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2051:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_6_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4572);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2071:4: ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2071:4: ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2072:5: {...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2072:109: ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2073:6: ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2076:6: ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2076:7: {...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2076:16: (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2077:2: otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_56=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4643); 

            	        	newLeafNode(otherlv_56, grammarAccess.getRequirementAccess().getSeeKeyword_6_13_0());
            	        
            	    otherlv_57=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4655); 

            	        	newLeafNode(otherlv_57, grammarAccess.getRequirementAccess().getDocumentKeyword_6_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2086:1: ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2087:1: (lv_docReference_58_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2087:1: (lv_docReference_58_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2088:3: lv_docReference_58_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_6_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4675);
            	    lv_docReference_58_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_58_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2104:2: (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==Comma) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2105:2: otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_59=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4689); 

            	    	        	newLeafNode(otherlv_59, grammarAccess.getRequirementAccess().getCommaKeyword_6_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2109:1: ( (lv_docReference_60_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2110:1: (lv_docReference_60_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2110:1: (lv_docReference_60_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2111:3: lv_docReference_60_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_6_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4709);
            	    	    lv_docReference_60_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_60_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop40;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	

            }

            otherlv_61=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement4765); 

                	newLeafNode(otherlv_61, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleRequirement"


    // $ANTLR start "entryRuleHazard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2154:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2155:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2156:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard4799);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard4809); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHazard"


    // $ANTLR start "ruleHazard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2163:1: ruleHazard returns [EObject current=null] : (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_20= RightSquareBracket ) ;
    public final EObject ruleHazard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_title_11_0 = null;

        AntlrDatatypeRuleToken lv_description_13_0 = null;

        AntlrDatatypeRuleToken lv_rationale_15_0 = null;

        AntlrDatatypeRuleToken lv_issue_17_0 = null;

        AntlrDatatypeRuleToken lv_issue_19_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2166:28: ( (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_20= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2167:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_20= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2167:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_20= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2168:2: otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_20= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleHazard4847); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2172:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2173:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2173:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2174:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard4863); 

            			newLeafNode(lv_name_1_0, grammarAccess.getHazardAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHazardRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleHazard4881); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2195:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2197:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2197:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2198:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2201:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2202:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2202:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) )*
            loop44:
            do {
                int alt44=7;
                int LA44_0 = input.LA(1);

                if ( LA44_0 ==For && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
                    alt44=1;
                }
                else if ( LA44_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
                    alt44=2;
                }
                else if ( LA44_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
                    alt44=3;
                }
                else if ( LA44_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
                    alt44=4;
                }
                else if ( LA44_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
                    alt44=5;
                }
                else if ( LA44_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
                    alt44=6;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2204:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2204:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2205:5: {...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2205:103: ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2206:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:7: {...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:16: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:2: otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleHazard4939); 

            	        	newLeafNode(otherlv_4, grammarAccess.getHazardAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2214:1: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2215:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2215:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2216:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard4958); 

            	    		newLeafNode(otherlv_5, grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2227:2: (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==Of) ) {
            	        alt42=1;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2228:2: otherlv_6= Of ( ( ruleAadlClassifierReference ) )
            	            {
            	            otherlv_6=(Token)match(input,Of,FOLLOW_Of_in_ruleHazard4972); 

            	                	newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getOfKeyword_3_0_2_0());
            	                
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2232:1: ( ( ruleAadlClassifierReference ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2233:1: ( ruleAadlClassifierReference )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2233:1: ( ruleAadlClassifierReference )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2234:3: ruleAadlClassifierReference
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getHazardRule());
            	            	        }
            	                    
            	             
            	            	        newCompositeNode(grammarAccess.getHazardAccess().getTargetContextClassifierCrossReference_3_0_2_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleHazard4994);
            	            ruleAadlClassifierReference();

            	            state._fsp--;

            	             
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:5: {...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:103: ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2256:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:7: {...}? => (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:16: (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2260:2: otherlv_8= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_8=(Token)match(input,Category,FOLLOW_Category_in_ruleHazard5065); 

            	        	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2264:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2265:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2265:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2266:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleHazard5087);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:4: ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:4: ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2287:5: {...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2287:103: ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2288:6: ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2291:6: ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2291:7: {...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2291:16: (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2292:2: otherlv_10= Title ( (lv_title_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,Title,FOLLOW_Title_in_ruleHazard5156); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2296:1: ( (lv_title_11_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2297:1: (lv_title_11_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2297:1: (lv_title_11_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:3: lv_title_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5176);
            	    lv_title_11_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_11_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2321:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2321:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2322:5: {...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2322:103: ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2323:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2326:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2326:7: {...}? => (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2326:16: (otherlv_12= Description ( (lv_description_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2327:2: otherlv_12= Description ( (lv_description_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,Description,FOLLOW_Description_in_ruleHazard5245); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2331:1: ( (lv_description_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2332:1: (lv_description_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2332:1: (lv_description_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2333:3: lv_description_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionValueStringParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5265);
            	    lv_description_13_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_13_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2356:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2356:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2357:5: {...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2357:103: ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2358:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2361:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2361:7: {...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2361:16: (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2362:2: otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleHazard5334); 

            	        	newLeafNode(otherlv_14, grammarAccess.getHazardAccess().getRationaleKeyword_3_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2366:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2367:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2367:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getRationaleValueStringParserRuleCall_3_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5354);
            	    lv_rationale_15_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_15_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2391:4: ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2391:4: ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2392:5: {...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2392:103: ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2393:6: ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2396:6: ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2396:7: {...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2396:16: (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2397:2: otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )*
            	    {
            	    otherlv_16=(Token)match(input,Issues,FOLLOW_Issues_in_ruleHazard5423); 

            	        	newLeafNode(otherlv_16, grammarAccess.getHazardAccess().getIssuesKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2401:1: ( (lv_issue_17_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2402:1: (lv_issue_17_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2402:1: (lv_issue_17_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2403:3: lv_issue_17_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5443);
            	    lv_issue_17_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_17_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2419:2: (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==Comma) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2420:2: otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard5457); 

            	    	        	newLeafNode(otherlv_18, grammarAccess.getHazardAccess().getCommaKeyword_3_5_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2424:1: ( (lv_issue_19_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2425:1: (lv_issue_19_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2425:1: (lv_issue_19_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2426:3: lv_issue_19_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5477);
            	    	    lv_issue_19_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_19_0, 
            	    	            		"ValueString");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop43;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	

            }

            otherlv_20=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleHazard5533); 

                	newLeafNode(otherlv_20, grammarAccess.getHazardAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleHazard"


    // $ANTLR start "entryRuleExternalDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2469:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2470:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2471:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument5567);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument5577); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalDocument"


    // $ANTLR start "ruleExternalDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2478:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2484:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument5623);
            lv_docReference_0_0=ruleDOCPATH();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
            	        }
                   		set(
                   			current, 
                   			"docReference",
                    		lv_docReference_0_0, 
                    		"DOCPATH");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2500:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NumberSign) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2501:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument5637); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2505:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2506:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2506:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2507:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument5657);
                    lv_docFragment_2_0=ruleDOCFRAGMENT();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
                    	        }
                           		set(
                           			current, 
                           			"docFragment",
                            		lv_docFragment_2_0, 
                            		"DOCFRAGMENT");
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
    // $ANTLR end "ruleExternalDocument"


    // $ANTLR start "entryRuleDOCPATH"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2531:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2532:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2533:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH5695);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH5706); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOCPATH"


    // $ANTLR start "ruleDOCPATH"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2540:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:2: (this_ID_0= RULE_ID kw= Solidus )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    int LA46_1 = input.LA(2);

                    if ( (LA46_1==Solidus) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5747); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH5765); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5782); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH5800); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5815); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_3()); 
                

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
    // $ANTLR end "ruleDOCPATH"


    // $ANTLR start "entryRuleDOCFRAGMENT"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2586:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2587:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2588:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT5860);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT5871); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDOCFRAGMENT"


    // $ANTLR start "ruleDOCFRAGMENT"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2595:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2599:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2600:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2600:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2600:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5911); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2607:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==FullStop) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2608:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT5930); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5945); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleDOCFRAGMENT"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2630:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2631:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2632:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription5993);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription6003); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2639:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2642:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2643:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2643:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID||LA48_0==RULE_STRING) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2644:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2644:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2645:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription6048);
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
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2669:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2670:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2671:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6083);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6093); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2678:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2681:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2682:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2682:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_STRING) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2682:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2682:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2684:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6135); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2701:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2701:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2702:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2702:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2703:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6166); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2722:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2723:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2724:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6201);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6211); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2731:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2734:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2736:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2736:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2737:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6256); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2748:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2749:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath6270); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2753:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2754:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2754:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2755:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6290);
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


    // $ANTLR start "entryRuleImport"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2779:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2780:2: (iv_ruleImport= ruleImport EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2781:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport6326);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport6336); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2788:1: ruleImport returns [EObject current=null] : (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2791:28: ( (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2792:1: (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2792:1: (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2793:2: otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,Import,FOLLOW_Import_in_ruleImport6374); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2797:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport6394);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedNameWithWildcard");
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2823:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2824:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2825:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString6430);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString6441); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2832:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2836:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2837:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString6480); 

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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2852:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2853:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2854:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6524);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6535); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2861:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2865:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2866:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2866:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2866:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6575); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2873:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==FullStop) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2874:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName6594); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6609); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop50;
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


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2894:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:1: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard6656);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard6667); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2903:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2907:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2908:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2908:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2909:5: this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard6714);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2919:1: (kw= FullStopAsterisk )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FullStopAsterisk) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2920:2: kw= FullStopAsterisk
                    {
                    kw=(Token)match(input,FullStopAsterisk,FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildcard6733); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                        

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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleAadlClassifierReference"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2933:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2934:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6775);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference6786); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2942:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2946:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2947:1: ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2947:1: ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2947:2: (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2947:2: (this_ID_0= RULE_ID kw= ColonColon )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_1 = input.LA(2);

                    if ( (LA52_1==ColonColon) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2947:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6827); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference6845); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6862); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2967:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FullStop) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2968:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference6881); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6896); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2988:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2989:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2990:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef6943);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef6954); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2997:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3001:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3002:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef6993); 

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

    // Delegated rules


    protected DFA25 dfa25 = new DFA25(this);
    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA25_eotS =
        "\21\uffff";
    static final String DFA25_eofS =
        "\21\uffff";
    static final String DFA25_minS =
        "\1\4\14\uffff\1\5\3\uffff";
    static final String DFA25_maxS =
        "\1\46\14\uffff\1\26\3\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\17\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\uffff\1\14\1\15\1\16";
    static final String DFA25_specialS =
        "\1\1\14\uffff\1\0\3\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\3\1\uffff\1\14\1\11\1\4\1\13\1\uffff\1\5\1\2\1\uffff\1\12"+
            "\1\uffff\1\7\3\uffff\1\6\1\uffff\1\10\1\uffff\1\15\15\uffff"+
            "\1\1",
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
            "\1\17\7\uffff\1\20\10\uffff\1\16",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "()* loopback of 651:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assertion ( (lv_assert_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleValueString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refines ( ( ruleQualifiedName ) ) (otherlv_24= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_26_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_27= Decomposes ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA25_13 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {s = 14;}

                        else if ( LA25_13 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {s = 15;}

                        else if ( LA25_13 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) ) {s = 16;}

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_0 = input.LA(1);

                         
                        int index25_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA25_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA25_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA25_0 ==Assertion && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA25_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA25_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA25_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA25_0 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA25_0 ==Decomposes && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA25_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {s = 10;}

                        else if ( LA25_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {s = 11;}

                        else if ( LA25_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {s = 12;}

                        else if ( LA25_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) ) {s = 13;}

                         
                        input.seek(index25_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA41_eotS =
        "\23\uffff";
    static final String DFA41_eofS =
        "\23\uffff";
    static final String DFA41_minS =
        "\1\4\6\uffff\1\5\5\uffff\1\47\2\uffff\1\0\2\uffff";
    static final String DFA41_maxS =
        "\1\46\6\uffff\1\26\5\uffff\1\47\2\uffff\1\0\2\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\17\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1"+
        "\13\1\uffff\1\15\1\16\1\uffff\1\6\1\14";
    static final String DFA41_specialS =
        "\1\3\6\uffff\1\2\5\uffff\1\0\2\uffff\1\1\2\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\2\1\12\1\uffff\1\13\1\3\1\uffff\1\10\1\4\2\uffff\1\14\1"+
            "\uffff\1\11\3\uffff\1\6\3\uffff\1\7\1\5\14\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\7\uffff\1\17\10\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\20",
            "",
            "",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "()* loopback of 1469:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assertion ( (lv_assert_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_19_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_20= Issues ( (lv_issue_21_0= ruleValueString ) ) (otherlv_22= Comma ( (lv_issue_23_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= See otherlv_25= Goal ( ( ruleQualifiedName ) ) (otherlv_27= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Mitigates ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( (otherlv_32= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Refines ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_37_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_38= Decomposes ( ( ruleQualifiedName ) ) (otherlv_40= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_42= Evolves ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Goal ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Requirement ( ( ruleQualifiedName ) ) (otherlv_54= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_56= See otherlv_57= Document ( (lv_docReference_58_0= ruleExternalDocument ) ) (otherlv_59= Comma ( (lv_docReference_60_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_13 = input.LA(1);

                         
                        int index41_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA41_13 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) ) {s = 16;}

                         
                        input.seek(index41_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA41_16 = input.LA(1);

                         
                        int index41_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) {s = 17;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) {s = 18;}

                         
                        input.seek(index41_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA41_7 = input.LA(1);

                         
                        int index41_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA41_7 ==Goal && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) ) {s = 13;}

                        else if ( LA41_7 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) {s = 14;}

                        else if ( LA41_7 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 13) ) {s = 15;}

                         
                        input.seek(index41_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA41_0 = input.LA(1);

                         
                        int index41_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA41_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA41_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0) ) {s = 2;}

                        else if ( LA41_0 ==Assertion && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1) ) {s = 3;}

                        else if ( LA41_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2) ) {s = 4;}

                        else if ( LA41_0 ==Val && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3) ) {s = 5;}

                        else if ( LA41_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4) ) {s = 6;}

                        else if ( LA41_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 13) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) ) {s = 7;}

                        else if ( LA41_0 ==Mitigates && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6) ) {s = 8;}

                        else if ( LA41_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7) ) {s = 9;}

                        else if ( LA41_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8) ) {s = 10;}

                        else if ( LA41_0 ==Decomposes && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9) ) {s = 11;}

                        else if ( LA41_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) ) {s = 12;}

                         
                        input.seek(index41_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleReqSpec_in_entryRuleReqSpec67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpec77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecModel_in_ruleReqSpec123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecModel_in_entryRuleReqSpecModel160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecModel170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Package_in_ruleReqSpecModel208 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecModel224 = new BitSet(new long[]{0x0000002000880000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecModel243 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecModel265 = new BitSet(new long[]{0x0000002000080000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleReqSpecModel288 = new BitSet(new long[]{0x0000002000080000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecModel302 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecModel324 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecModel343 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecModel362 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecModel380 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecModel392 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecModel412 = new BitSet(new long[]{0x0000004100000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecModel426 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecModel446 = new BitSet(new long[]{0x0000004100000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecModel461 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecModel475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder557 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder573 = new BitSet(new long[]{0x0000002000800000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecFolder592 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder614 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder629 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder651 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder670 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder689 = new BitSet(new long[]{0x0000004000520020L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecFolder707 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder719 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder739 = new BitSet(new long[]{0x0000004100000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecFolder753 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder773 = new BitSet(new long[]{0x0000004100000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder788 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_entryRuleRSLVariable836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRSLVariable846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Val_in_ruleRSLVariable884 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRSLVariable900 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleRSLVariable918 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRSLVariable938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1021 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1037 = new BitSet(new long[]{0x0000002800800000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal1056 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1076 = new BitSet(new long[]{0x0000002000800000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1092 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1111 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_Of_in_ruleGoal1125 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleGoal1147 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1164 = new BitSet(new long[]{0x0000004001515BD0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal1222 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal1244 = new BitSet(new long[]{0x0000004001515BD0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal1313 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1333 = new BitSet(new long[]{0x0000004001515BD0L});
    public static final BitSet FOLLOW_Assertion_in_ruleGoal1402 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1422 = new BitSet(new long[]{0x0000004001515BD0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal1491 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1511 = new BitSet(new long[]{0x0000004001515BD0L});
    public static final BitSet FOLLOW_Issues_in_ruleGoal1580 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1600 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal1614 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1634 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Refines_in_ruleGoal1705 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal1727 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal1741 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal1763 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal1841 = new BitSet(new long[]{0x0000004001515BD0L});
    public static final BitSet FOLLOW_Decomposes_in_ruleGoal1910 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal1932 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal1946 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal1968 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Evolves_in_ruleGoal2039 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2061 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2075 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2097 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2168 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2190 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2204 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2226 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2297 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2319 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2333 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2355 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2426 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal2438 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2460 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2474 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2496 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2567 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal2579 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2601 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2615 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2637 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2708 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2720 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2740 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2754 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2774 = new BitSet(new long[]{0x0000004101515BD0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement2864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement2912 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement2928 = new BitSet(new long[]{0x0000002840800000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement2947 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement2967 = new BitSet(new long[]{0x0000002040800000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleRequirement2983 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3005 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleRequirement3018 = new BitSet(new long[]{0x0000002000800000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3033 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3052 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_Of_in_ruleRequirement3066 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3088 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3105 = new BitSet(new long[]{0x0000004003114DB0L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3163 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3183 = new BitSet(new long[]{0x0000004003114DB0L});
    public static final BitSet FOLLOW_Assertion_in_ruleRequirement3252 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3272 = new BitSet(new long[]{0x0000004003114DB0L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3341 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3361 = new BitSet(new long[]{0x0000004003114DB0L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_ruleRequirement3437 = new BitSet(new long[]{0x0000004003114DB0L});
    public static final BitSet FOLLOW_Issues_in_ruleRequirement3506 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3526 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3540 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3560 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3631 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement3643 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3665 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3679 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3701 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Mitigates_in_ruleRequirement3772 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3794 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3808 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3827 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Refines_in_ruleRequirement3898 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3920 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3934 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3956 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement4034 = new BitSet(new long[]{0x0000004003114DB0L});
    public static final BitSet FOLLOW_Decomposes_in_ruleRequirement4103 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4125 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4139 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4161 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Evolves_in_ruleRequirement4232 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4254 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4268 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4290 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4361 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4373 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4395 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4409 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4431 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4502 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement4514 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4536 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4550 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4572 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4643 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4655 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4675 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4689 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4709 = new BitSet(new long[]{0x0000004103114DB0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard4799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard4809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hazard_in_ruleHazard4847 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard4863 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleHazard4881 = new BitSet(new long[]{0x0000004000B01810L});
    public static final BitSet FOLLOW_For_in_ruleHazard4939 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard4958 = new BitSet(new long[]{0x0000004010B01810L});
    public static final BitSet FOLLOW_Of_in_ruleHazard4972 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleHazard4994 = new BitSet(new long[]{0x0000004000B01810L});
    public static final BitSet FOLLOW_Category_in_ruleHazard5065 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazard5087 = new BitSet(new long[]{0x0000004000B01810L});
    public static final BitSet FOLLOW_Title_in_ruleHazard5156 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5176 = new BitSet(new long[]{0x0000004000B01810L});
    public static final BitSet FOLLOW_Description_in_ruleHazard5245 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5265 = new BitSet(new long[]{0x0000004000B01810L});
    public static final BitSet FOLLOW_Rationale_in_ruleHazard5334 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5354 = new BitSet(new long[]{0x0000004000B01810L});
    public static final BitSet FOLLOW_Issues_in_ruleHazard5423 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5443 = new BitSet(new long[]{0x0000004100B01810L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard5457 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5477 = new BitSet(new long[]{0x0000004100B01810L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleHazard5533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument5567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument5577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument5623 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument5637 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument5657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH5695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH5706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5747 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH5765 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5782 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH5800 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT5860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT5871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5911 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT5930 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5945 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription5993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription6003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription6048 = new BitSet(new long[]{0x0000028000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6256 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath6270 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport6326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport6336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Import_in_ruleImport6374 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport6394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString6430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString6441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString6480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6524 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6575 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName6594 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6609 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard6656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard6667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard6714 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildcard6733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6775 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference6786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6827 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference6845 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6862 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference6881 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef6943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef6954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef6993 = new BitSet(new long[]{0x0000000000000002L});

}
