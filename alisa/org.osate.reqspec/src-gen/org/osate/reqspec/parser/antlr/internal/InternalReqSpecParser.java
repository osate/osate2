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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Description", "Requirement", "Stakeholder", "Decomposed", "Decomposes", "Assertion", "Conflicts", "Container", "Mitigated", "Rationale", "Category", "Document", "Evolves", "Package", "Refined", "Refines", "Hazard", "Import", "Issues", "Title", "Goal", "For", "See", "Val", "FullStopAsterisk", "ColonColon", "By", "To", "NumberSign", "Comma", "FullStop", "Solidus", "EqualsSign", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=40;
    public static final int Mitigated=12;
    public static final int RULE_ANY_OTHER=46;
    public static final int RightSquareBracket=39;
    public static final int Issues=22;
    public static final int Requirement=5;
    public static final int Solidus=35;
    public static final int EOF=-1;
    public static final int FullStop=34;
    public static final int Evolves=16;
    public static final int CommercialAt=37;
    public static final int To=31;
    public static final int Assertion=9;
    public static final int RULE_INT=41;
    public static final int Decomposes=8;
    public static final int LeftSquareBracket=38;
    public static final int Refines=19;
    public static final int Conflicts=10;
    public static final int Hazard=20;
    public static final int Stakeholder=6;
    public static final int Import=21;
    public static final int Decomposed=7;
    public static final int Refined=18;
    public static final int FullStopAsterisk=28;
    public static final int RULE_SL_COMMENT=44;
    public static final int Package=17;
    public static final int For=25;
    public static final int NumberSign=32;
    public static final int Rationale=13;
    public static final int RULE_ML_COMMENT=43;
    public static final int Container=11;
    public static final int Goal=24;
    public static final int By=30;
    public static final int ColonColon=29;
    public static final int Document=15;
    public static final int Description=4;
    public static final int RULE_STRING=42;
    public static final int See=26;
    public static final int Title=23;
    public static final int Category=14;
    public static final int RULE_WS=45;
    public static final int EqualsSign=36;
    public static final int Comma=33;
    public static final int Val=27;

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:70:1: ruleReqSpec returns [EObject current=null] : (this_ReqSpecModel_0= ruleReqSpecModel | this_ReqSpecDocument_1= ruleReqSpecDocument ) ;
    public final EObject ruleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject this_ReqSpecModel_0 = null;

        EObject this_ReqSpecDocument_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:73:28: ( (this_ReqSpecModel_0= ruleReqSpecModel | this_ReqSpecDocument_1= ruleReqSpecDocument ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: (this_ReqSpecModel_0= ruleReqSpecModel | this_ReqSpecDocument_1= ruleReqSpecDocument )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: (this_ReqSpecModel_0= ruleReqSpecModel | this_ReqSpecDocument_1= ruleReqSpecDocument )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Package) ) {
                alt1=1;
            }
            else if ( (LA1_0==Document) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:5: this_ReqSpecModel_0= ruleReqSpecModel
                    {
                     
                            newCompositeNode(grammarAccess.getReqSpecAccess().getReqSpecModelParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleReqSpecModel_in_ruleReqSpec124);
                    this_ReqSpecModel_0=ruleReqSpecModel();

                    state._fsp--;


                            current = this_ReqSpecModel_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:85:5: this_ReqSpecDocument_1= ruleReqSpecDocument
                    {
                     
                            newCompositeNode(grammarAccess.getReqSpecAccess().getReqSpecDocumentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReqSpecDocument_in_ruleReqSpec151);
                    this_ReqSpecDocument_1=ruleReqSpecDocument();

                    state._fsp--;


                            current = this_ReqSpecDocument_1;
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
    // $ANTLR end "ruleReqSpec"


    // $ANTLR start "entryRuleReqSpecModel"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:105:1: entryRuleReqSpecModel returns [EObject current=null] : iv_ruleReqSpecModel= ruleReqSpecModel EOF ;
    public final EObject entryRuleReqSpecModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecModel = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:106:2: (iv_ruleReqSpecModel= ruleReqSpecModel EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:107:2: iv_ruleReqSpecModel= ruleReqSpecModel EOF
            {
             newCompositeNode(grammarAccess.getReqSpecModelRule()); 
            pushFollow(FOLLOW_ruleReqSpecModel_in_entryRuleReqSpecModel189);
            iv_ruleReqSpecModel=ruleReqSpecModel();

            state._fsp--;

             current =iv_ruleReqSpecModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecModel199); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:114:1: ruleReqSpecModel returns [EObject current=null] : (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:117:28: ( (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:118:1: (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:118:1: (otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:119:2: otherlv_0= Package ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? ( (lv_import_4_0= ruleImport ) )* otherlv_5= LeftSquareBracket ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )* (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )? otherlv_13= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Package,FOLLOW_Package_in_ruleReqSpecModel237); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecModelAccess().getPackageKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:123:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:124:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:124:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:125:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecModel253); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:141:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==For) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:142:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecModel272); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecModelAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:146:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:147:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:147:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:148:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecModelRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecModel294);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:161:4: ( (lv_import_4_0= ruleImport ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Import) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:162:1: (lv_import_4_0= ruleImport )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:162:1: (lv_import_4_0= ruleImport )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:163:3: lv_import_4_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getImportImportParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleReqSpecModel317);
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
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecModel331); 

                	newLeafNode(otherlv_5, grammarAccess.getReqSpecModelAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:184:1: ( ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Requirement||LA5_0==Container||LA5_0==Goal) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:185:1: ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:185:1: ( (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:1: (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:1: (lv_content_6_1= ruleGoal | lv_content_6_2= ruleRequirement | lv_content_6_3= ruleReqSpecFolder )
            	    int alt4=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case Container:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:187:3: lv_content_6_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecModel353);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:202:8: lv_content_6_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecModel372);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:217:8: lv_content_6_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getContentReqSpecFolderParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecModel391);
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
            	    break loop5;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:235:3: (otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Issues) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:236:2: otherlv_7= Issues otherlv_8= LeftSquareBracket ( (lv_issue_9_0= ruleValueString ) ) (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )* otherlv_12= RightSquareBracket
                    {
                    otherlv_7=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecModel409); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecModelAccess().getIssuesKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecModel421); 

                        	newLeafNode(otherlv_8, grammarAccess.getReqSpecModelAccess().getLeftSquareBracketKeyword_6_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:245:1: ( (lv_issue_9_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:246:1: (lv_issue_9_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:246:1: (lv_issue_9_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:247:3: lv_issue_9_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getIssueValueStringParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecModel441);
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

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:263:2: (otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==Comma) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:264:2: otherlv_10= Comma ( (lv_issue_11_0= ruleValueString ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecModel455); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getReqSpecModelAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:268:1: ( (lv_issue_11_0= ruleValueString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:269:1: (lv_issue_11_0= ruleValueString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:269:1: (lv_issue_11_0= ruleValueString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:270:3: lv_issue_11_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecModelAccess().getIssueValueStringParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecModel475);
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
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecModel490); 

                        	newLeafNode(otherlv_12, grammarAccess.getReqSpecModelAccess().getRightSquareBracketKeyword_6_4());
                        

                    }
                    break;

            }

            otherlv_13=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecModel504); 

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


    // $ANTLR start "entryRuleReqSpecDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:304:1: entryRuleReqSpecDocument returns [EObject current=null] : iv_ruleReqSpecDocument= ruleReqSpecDocument EOF ;
    public final EObject entryRuleReqSpecDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:305:2: (iv_ruleReqSpecDocument= ruleReqSpecDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:306:2: iv_ruleReqSpecDocument= ruleReqSpecDocument EOF
            {
             newCompositeNode(grammarAccess.getReqSpecDocumentRule()); 
            pushFollow(FOLLOW_ruleReqSpecDocument_in_entryRuleReqSpecDocument538);
            iv_ruleReqSpecDocument=ruleReqSpecDocument();

            state._fsp--;

             current =iv_ruleReqSpecDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecDocument548); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReqSpecDocument"


    // $ANTLR start "ruleReqSpecDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:313:1: ruleReqSpecDocument returns [EObject current=null] : (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket ) ;
    public final EObject ruleReqSpecDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        EObject lv_docref_3_0 = null;

        EObject lv_content_7_1 = null;

        EObject lv_content_7_2 = null;

        EObject lv_content_7_3 = null;

        AntlrDatatypeRuleToken lv_issue_10_0 = null;

        AntlrDatatypeRuleToken lv_issue_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:316:28: ( (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:317:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:317:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:318:2: otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Document,FOLLOW_Document_in_ruleReqSpecDocument586); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecDocumentAccess().getDocumentKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:322:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:323:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:323:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:324:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecDocument602); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReqSpecDocumentAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecDocumentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:340:2: (otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==CommercialAt) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:341:2: otherlv_2= CommercialAt ( (lv_docref_3_0= ruleExternalDocument ) )
                    {
                    otherlv_2=(Token)match(input,CommercialAt,FOLLOW_CommercialAt_in_ruleReqSpecDocument621); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecDocumentAccess().getCommercialAtKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:345:1: ( (lv_docref_3_0= ruleExternalDocument ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:346:1: (lv_docref_3_0= ruleExternalDocument )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:346:1: (lv_docref_3_0= ruleExternalDocument )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:347:3: lv_docref_3_0= ruleExternalDocument
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getDocrefExternalDocumentParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExternalDocument_in_ruleReqSpecDocument641);
                    lv_docref_3_0=ruleExternalDocument();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecDocumentRule());
                    	        }
                           		set(
                           			current, 
                           			"docref",
                            		lv_docref_3_0, 
                            		"ExternalDocument");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:363:4: (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==For) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:364:2: otherlv_4= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecDocument657); 

                        	newLeafNode(otherlv_4, grammarAccess.getReqSpecDocumentAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:368:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:369:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:369:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:370:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecDocumentRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getTargetClassifierCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecDocument679);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecDocument694); 

                	newLeafNode(otherlv_6, grammarAccess.getReqSpecDocumentAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:388:1: ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Requirement||LA11_0==Container||LA11_0==Goal) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:389:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:389:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:390:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:390:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleReqSpecFolder )
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case Container:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:391:3: lv_content_7_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecDocument716);
            	            lv_content_7_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecDocumentRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:406:8: lv_content_7_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecDocument735);
            	            lv_content_7_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecDocumentRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:421:8: lv_content_7_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getContentReqSpecFolderParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecDocument754);
            	            lv_content_7_3=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecDocumentRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_3, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:439:3: (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Issues) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:440:2: otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleValueString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )* otherlv_13= RightSquareBracket
                    {
                    otherlv_8=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecDocument772); 

                        	newLeafNode(otherlv_8, grammarAccess.getReqSpecDocumentAccess().getIssuesKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecDocument784); 

                        	newLeafNode(otherlv_9, grammarAccess.getReqSpecDocumentAccess().getLeftSquareBracketKeyword_6_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:449:1: ( (lv_issue_10_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:450:1: (lv_issue_10_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:450:1: (lv_issue_10_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:451:3: lv_issue_10_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getIssueValueStringParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecDocument804);
                    lv_issue_10_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecDocumentRule());
                    	        }
                           		add(
                           			current, 
                           			"issue",
                            		lv_issue_10_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:467:2: (otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Comma) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:468:2: otherlv_11= Comma ( (lv_issue_12_0= ruleValueString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecDocument818); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getReqSpecDocumentAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:472:1: ( (lv_issue_12_0= ruleValueString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:473:1: (lv_issue_12_0= ruleValueString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:473:1: (lv_issue_12_0= ruleValueString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:474:3: lv_issue_12_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecDocumentAccess().getIssueValueStringParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecDocument838);
                    	    lv_issue_12_0=ruleValueString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecDocumentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_12_0, 
                    	            		"ValueString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecDocument853); 

                        	newLeafNode(otherlv_13, grammarAccess.getReqSpecDocumentAccess().getRightSquareBracketKeyword_6_4());
                        

                    }
                    break;

            }

            otherlv_14=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecDocument867); 

                	newLeafNode(otherlv_14, grammarAccess.getReqSpecDocumentAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleReqSpecDocument"


    // $ANTLR start "entryRuleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:508:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:509:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:510:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder901);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder911); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:517:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Container ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:520:28: ( (otherlv_0= Container ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:521:1: (otherlv_0= Container ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:521:1: (otherlv_0= Container ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:522:2: otherlv_0= Container ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Container,FOLLOW_Container_in_ruleReqSpecFolder949); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getContainerKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:526:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:527:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:527:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:528:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder965); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:544:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==For) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:545:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecFolder984); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:549:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:550:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:550:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:551:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecFolderRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder1006);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1021); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:569:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Requirement||LA16_0==Container||LA16_0==Goal) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:570:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:570:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:571:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:571:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    int alt15=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt15=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt15=2;
            	        }
            	        break;
            	    case Container:
            	        {
            	        alt15=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt15) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:572:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1043);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:587:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1062);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:602:8: lv_content_5_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1081);
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
            	    break loop16;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:620:3: (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Issues) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:621:2: otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecFolder1099); 

                        	newLeafNode(otherlv_6, grammarAccess.getReqSpecFolderAccess().getIssuesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1111); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_5_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:630:1: ( (lv_issue_8_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:631:1: (lv_issue_8_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:631:1: (lv_issue_8_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:632:3: lv_issue_8_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueValueStringParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder1131);
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

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:648:2: (otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==Comma) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:649:2: otherlv_9= Comma ( (lv_issue_10_0= ruleValueString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecFolder1145); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getReqSpecFolderAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:1: ( (lv_issue_10_0= ruleValueString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:1: (lv_issue_10_0= ruleValueString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:1: (lv_issue_10_0= ruleValueString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:655:3: lv_issue_10_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueValueStringParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder1165);
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
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1180); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1194); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:689:1: entryRuleRSLVariable returns [EObject current=null] : iv_ruleRSLVariable= ruleRSLVariable EOF ;
    public final EObject entryRuleRSLVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRSLVariable = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:690:2: (iv_ruleRSLVariable= ruleRSLVariable EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:691:2: iv_ruleRSLVariable= ruleRSLVariable EOF
            {
             newCompositeNode(grammarAccess.getRSLVariableRule()); 
            pushFollow(FOLLOW_ruleRSLVariable_in_entryRuleRSLVariable1228);
            iv_ruleRSLVariable=ruleRSLVariable();

            state._fsp--;

             current =iv_ruleRSLVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRSLVariable1238); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:698:1: ruleRSLVariable returns [EObject current=null] : (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) ) ;
    public final EObject ruleRSLVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:701:28: ( (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:702:1: (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:702:1: (otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:703:2: otherlv_0= Val ( (lv_name_1_0= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleValueString ) )
            {
            otherlv_0=(Token)match(input,Val,FOLLOW_Val_in_ruleRSLVariable1276); 

                	newLeafNode(otherlv_0, grammarAccess.getRSLVariableAccess().getValKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:707:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:708:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:708:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:709:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRSLVariable1292); 

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

            otherlv_2=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleRSLVariable1310); 

                	newLeafNode(otherlv_2, grammarAccess.getRSLVariableAccess().getEqualsSignKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:730:1: ( (lv_value_3_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:731:1: (lv_value_3_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:731:1: (lv_value_3_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:732:3: lv_value_3_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getRSLVariableAccess().getValueValueStringParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleRSLVariable1330);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:756:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:757:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:758:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1365);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1375); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:765:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( (otherlv_3= RULE_ID ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket ) ;
    public final EObject ruleGoal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_26=null;
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
        AntlrDatatypeRuleToken lv_title_9_0 = null;

        EObject lv_description_11_0 = null;

        AntlrDatatypeRuleToken lv_assert_13_0 = null;

        AntlrDatatypeRuleToken lv_rationale_15_0 = null;

        AntlrDatatypeRuleToken lv_issue_17_0 = null;

        AntlrDatatypeRuleToken lv_issue_19_0 = null;

        EObject lv_subgoal_25_0 = null;

        EObject lv_docReference_55_0 = null;

        EObject lv_docReference_57_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( (otherlv_3= RULE_ID ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( (otherlv_3= RULE_ID ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( (otherlv_3= RULE_ID ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:770:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( (otherlv_3= RULE_ID ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1413); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:774:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:775:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:775:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:776:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1429); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:2: (otherlv_2= For ( (otherlv_3= RULE_ID ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==For) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:793:2: otherlv_2= For ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleGoal1448); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:797:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:798:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:798:1: (otherlv_3= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:799:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGoalRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1467); 

                    		newLeafNode(otherlv_3, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1482); 

                	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:818:2: ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:821:2: ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:822:3: ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:822:3: ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop30:
            do {
                int alt30=16;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:824:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:824:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:825:5: {...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:825:101: ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:826:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:829:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:829:7: {...}? => (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:829:16: (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:830:2: otherlv_6= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_6=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal1540); 

            	        	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getCategoryKeyword_4_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:834:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:835:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:835:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:836:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_4_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal1562);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:856:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:856:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:857:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:857:101: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:858:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:861:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:861:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:861:16: (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:862:2: otherlv_8= Title ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,Title,FOLLOW_Title_in_ruleGoal1631); 

            	        	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getTitleKeyword_4_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:866:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:867:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:867:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:868:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_4_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1651);
            	    lv_title_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:891:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:891:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:892:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:892:101: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:893:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:897:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal1720); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getDescriptionKeyword_4_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:901:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:902:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:902:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:903:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_4_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1740);
            	    lv_description_11_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:926:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:926:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:927:5: {...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:927:101: ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:928:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:931:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:931:7: {...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:931:16: (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:932:2: otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,Assertion,FOLLOW_Assertion_in_ruleGoal1809); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getAssertionKeyword_4_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:936:1: ( (lv_assert_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:937:1: (lv_assert_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:937:1: (lv_assert_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:938:3: lv_assert_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertValueStringParserRuleCall_4_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1829);
            	    lv_assert_13_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_13_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:961:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:961:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:962:5: {...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:962:101: ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:963:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:966:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:966:7: {...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:966:16: (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:967:2: otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal1898); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getRationaleKeyword_4_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:971:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:972:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:972:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:973:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_4_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1918);
            	    lv_rationale_15_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:996:4: ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:996:4: ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:997:5: {...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:997:101: ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:998:6: ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1001:6: ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1001:7: {...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1001:16: (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1002:2: otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )*
            	    {
            	    otherlv_16=(Token)match(input,Issues,FOLLOW_Issues_in_ruleGoal1987); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getIssuesKeyword_4_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1006:1: ( (lv_issue_17_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1007:1: (lv_issue_17_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1007:1: (lv_issue_17_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1008:3: lv_issue_17_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_4_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2007);
            	    lv_issue_17_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_17_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1024:2: (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Comma) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1025:2: otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2021); 

            	    	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getCommaKeyword_4_5_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1029:1: ( (lv_issue_19_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1030:1: (lv_issue_19_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1030:1: (lv_issue_19_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1031:3: lv_issue_19_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_4_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2041);
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


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:4: ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:4: ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1055:5: {...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1055:101: ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:6: ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1059:6: ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1059:7: {...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1059:16: (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1060:2: otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_20=(Token)match(input,Refined,FOLLOW_Refined_in_ruleGoal2112); 

            	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getRefinedKeyword_4_6_0());
            	        
            	    otherlv_21=(Token)match(input,To,FOLLOW_To_in_ruleGoal2124); 

            	        	newLeafNode(otherlv_21, grammarAccess.getGoalAccess().getToKeyword_4_6_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1069:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1070:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1070:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1071:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_4_6_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2146);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1084:2: (otherlv_23= Comma ( ( ruleQualifiedName ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Comma) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:2: otherlv_23= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2160); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getCommaKeyword_4_6_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1089:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1090:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1090:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_4_6_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2182);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1111:4: ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1111:4: ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1112:5: {...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1112:101: ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:6: ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1116:6: ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Goal) ) {
            	            int LA22_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt22=1;
            	            }


            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1116:7: {...}? => ( (lv_subgoal_25_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1116:16: ( (lv_subgoal_25_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1117:1: (lv_subgoal_25_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1117:1: (lv_subgoal_25_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:3: lv_subgoal_25_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_4_7_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal2260);
            	    	    lv_subgoal_25_0=ruleGoal();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subgoal",
            	    	            		lv_subgoal_25_0, 
            	    	            		"Goal");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt22 >= 1 ) break loop22;
            	                EarlyExitException eee =
            	                    new EarlyExitException(22, input);
            	                throw eee;
            	        }
            	        cnt22++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1141:4: ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1141:4: ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:5: {...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:101: ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:6: ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1146:6: ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1146:7: {...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1146:16: (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1147:2: otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_26=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleGoal2329); 

            	        	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getDecomposedKeyword_4_8_0());
            	        
            	    otherlv_27=(Token)match(input,To,FOLLOW_To_in_ruleGoal2341); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getToKeyword_4_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1156:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1157:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1157:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1158:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_4_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2363);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1171:2: (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Comma) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:2: otherlv_29= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2377); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getCommaKeyword_4_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1176:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1177:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1177:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_4_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2399);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1198:4: ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1198:4: ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1199:5: {...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1199:101: ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:6: ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:6: ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:7: {...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:16: (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:2: otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleGoal2470); 

            	        	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getEvolvesKeyword_4_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1208:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1209:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1209:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1210:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_4_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2492);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1223:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Comma) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1224:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2506); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getCommaKeyword_4_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1228:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1230:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_4_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2528);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1250:4: ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1250:4: ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1251:5: {...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1251:102: ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1252:6: ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1255:6: ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1255:7: {...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1255:16: (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1256:2: otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_35=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2599); 

            	        	newLeafNode(otherlv_35, grammarAccess.getGoalAccess().getConflictsKeyword_4_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1260:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1261:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1261:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1262:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_4_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2621);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1275:2: (otherlv_37= Comma ( ( ruleQualifiedName ) ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Comma) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1276:2: otherlv_37= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_37=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2635); 

            	    	        	newLeafNode(otherlv_37, grammarAccess.getGoalAccess().getCommaKeyword_4_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1280:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1281:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1281:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1282:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_4_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2657);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1302:4: ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1302:4: ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1303:5: {...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1303:102: ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1304:6: ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1307:6: ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1307:7: {...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1307:16: (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1308:2: otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_39=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2728); 

            	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getStakeholderKeyword_4_11_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1312:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1313:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1313:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1314:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_4_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2750);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1327:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Comma) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1328:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2764); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getCommaKeyword_4_11_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1332:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1333:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1333:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1334:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_4_11_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2786);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1354:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1354:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1355:5: {...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1355:102: ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1356:6: ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1359:6: ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1359:7: {...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1359:16: (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1360:2: otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,See,FOLLOW_See_in_ruleGoal2857); 

            	        	newLeafNode(otherlv_43, grammarAccess.getGoalAccess().getSeeKeyword_4_12_0());
            	        
            	    otherlv_44=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal2869); 

            	        	newLeafNode(otherlv_44, grammarAccess.getGoalAccess().getGoalKeyword_4_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1369:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1370:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1370:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1371:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_4_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2891);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1384:2: (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==Comma) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1385:2: otherlv_46= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_46=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2905); 

            	    	        	newLeafNode(otherlv_46, grammarAccess.getGoalAccess().getCommaKeyword_4_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1389:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1390:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1390:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1391:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_4_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2927);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop27;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1411:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1411:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1412:5: {...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1412:102: ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1413:6: ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1416:6: ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1416:7: {...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1416:16: (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1417:2: otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_48=(Token)match(input,See,FOLLOW_See_in_ruleGoal2998); 

            	        	newLeafNode(otherlv_48, grammarAccess.getGoalAccess().getSeeKeyword_4_13_0());
            	        
            	    otherlv_49=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal3010); 

            	        	newLeafNode(otherlv_49, grammarAccess.getGoalAccess().getRequirementKeyword_4_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1427:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1427:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1428:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_4_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3032);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1441:2: (otherlv_51= Comma ( ( ruleQualifiedName ) ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Comma) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1442:2: otherlv_51= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_51=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3046); 

            	    	        	newLeafNode(otherlv_51, grammarAccess.getGoalAccess().getCommaKeyword_4_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1446:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1447:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1447:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1448:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_4_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3068);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop28;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1468:4: ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1468:4: ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:5: {...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:102: ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1470:6: ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1473:6: ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1473:7: {...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1473:16: (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1474:2: otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_53=(Token)match(input,See,FOLLOW_See_in_ruleGoal3139); 

            	        	newLeafNode(otherlv_53, grammarAccess.getGoalAccess().getSeeKeyword_4_14_0());
            	        
            	    otherlv_54=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal3151); 

            	        	newLeafNode(otherlv_54, grammarAccess.getGoalAccess().getDocumentKeyword_4_14_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:1: ( (lv_docReference_55_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1484:1: (lv_docReference_55_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1484:1: (lv_docReference_55_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1485:3: lv_docReference_55_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_4_14_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3171);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1501:2: (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Comma) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1502:2: otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_56=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3185); 

            	    	        	newLeafNode(otherlv_56, grammarAccess.getGoalAccess().getCommaKeyword_4_14_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:1: ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1507:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1507:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1508:3: lv_docReference_57_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_4_14_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3205);
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
            	    	    break loop29;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	

            }

            otherlv_58=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal3261); 

                	newLeafNode(otherlv_58, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_5());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1551:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1553:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement3295);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement3305); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1560:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket ) ;
    public final EObject ruleRequirement() throws RecognitionException {
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
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_55=null;
        Token otherlv_57=null;
        Token otherlv_59=null;
        AntlrDatatypeRuleToken lv_title_9_0 = null;

        EObject lv_description_11_0 = null;

        AntlrDatatypeRuleToken lv_assert_13_0 = null;

        AntlrDatatypeRuleToken lv_rationale_15_0 = null;

        EObject lv_reqValue_16_0 = null;

        AntlrDatatypeRuleToken lv_issue_18_0 = null;

        AntlrDatatypeRuleToken lv_issue_20_0 = null;

        AntlrDatatypeRuleToken lv_hazardReference_28_0 = null;

        AntlrDatatypeRuleToken lv_hazardReference_30_0 = null;

        EObject lv_subrequirement_35_0 = null;

        EObject lv_docReference_56_0 = null;

        EObject lv_docReference_58_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1563:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1564:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1564:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1565:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3343); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1569:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1570:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1570:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1571:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3359); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3377); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1592:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1594:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1594:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1595:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1598:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1599:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1599:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop42:
            do {
                int alt42=18;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1601:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1601:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1602:5: {...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1602:108: ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1603:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:7: {...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:16: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1607:2: otherlv_4= For ( (otherlv_5= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3435); 

            	        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:1: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1612:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1612:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1613:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3454); 

            	    		newLeafNode(otherlv_5, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1631:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1631:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1632:5: {...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1632:108: ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1633:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1636:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1636:7: {...}? => (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1636:16: (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1637:2: otherlv_6= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_6=(Token)match(input,Category,FOLLOW_Category_in_ruleRequirement3523); 

            	        	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1641:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1642:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1642:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1643:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3545);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1663:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1663:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1664:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1664:108: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1665:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:16: (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1669:2: otherlv_8= Title ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,Title,FOLLOW_Title_in_ruleRequirement3614); 

            	        	newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1673:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1674:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1674:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1675:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3634);
            	    lv_title_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1698:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1698:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1699:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1699:108: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1700:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1704:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3703); 

            	        	newLeafNode(otherlv_10, grammarAccess.getRequirementAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1708:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1709:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1709:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1710:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3723);
            	    lv_description_11_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1733:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1733:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:5: {...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:108: ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1735:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1738:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1738:7: {...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1738:16: (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1739:2: otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,Assertion,FOLLOW_Assertion_in_ruleRequirement3792); 

            	        	newLeafNode(otherlv_12, grammarAccess.getRequirementAccess().getAssertionKeyword_3_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1743:1: ( (lv_assert_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1744:1: (lv_assert_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1744:1: (lv_assert_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1745:3: lv_assert_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertValueStringParserRuleCall_3_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3812);
            	    lv_assert_13_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_13_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1768:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1768:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1769:5: {...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1769:108: ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1770:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:7: {...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:16: (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1774:2: otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3881); 

            	        	newLeafNode(otherlv_14, grammarAccess.getRequirementAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1779:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1779:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1780:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3901);
            	    lv_rationale_15_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1803:4: ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1803:4: ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1804:5: {...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1804:108: ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1805:6: ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:6: ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+
            	    int cnt31=0;
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Val) ) {
            	            int LA31_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt31=1;
            	            }


            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:7: {...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:16: ( (lv_reqValue_16_0= ruleRSLVariable ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1809:1: (lv_reqValue_16_0= ruleRSLVariable )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1809:1: (lv_reqValue_16_0= ruleRSLVariable )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1810:3: lv_reqValue_16_0= ruleRSLVariable
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getReqValueRSLVariableParserRuleCall_3_6_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRSLVariable_in_ruleRequirement3977);
            	    	    lv_reqValue_16_0=ruleRSLVariable();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"reqValue",
            	    	            		lv_reqValue_16_0, 
            	    	            		"RSLVariable");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt31 >= 1 ) break loop31;
            	                EarlyExitException eee =
            	                    new EarlyExitException(31, input);
            	                throw eee;
            	        }
            	        cnt31++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1834:5: {...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1834:108: ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1835:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:7: {...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:16: (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1839:2: otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,Issues,FOLLOW_Issues_in_ruleRequirement4046); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getIssuesKeyword_3_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:1: ( (lv_issue_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1844:1: (lv_issue_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1844:1: (lv_issue_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1845:3: lv_issue_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_3_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement4066);
            	    lv_issue_18_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_18_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1861:2: (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Comma) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1862:2: otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4080); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getCommaKeyword_3_7_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1866:1: ( (lv_issue_20_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1867:1: (lv_issue_20_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1867:1: (lv_issue_20_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:3: lv_issue_20_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_3_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement4100);
            	    	    lv_issue_20_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_20_0, 
            	    	            		"ValueString");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1891:4: ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1891:4: ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1892:5: {...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1892:108: ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1893:6: ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:6: ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:7: {...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:16: (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1897:2: otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4171); 

            	        	newLeafNode(otherlv_21, grammarAccess.getRequirementAccess().getSeeKeyword_3_8_0());
            	        
            	    otherlv_22=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4183); 

            	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getGoalKeyword_3_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:1: ( (otherlv_23= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:1: (otherlv_23= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:1: (otherlv_23= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1908:3: otherlv_23= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	    otherlv_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement4202); 

            	    		newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_3_8_2_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1919:2: (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Comma) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1920:2: otherlv_24= Comma ( (otherlv_25= RULE_ID ) )
            	    	    {
            	    	    otherlv_24=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4216); 

            	    	        	newLeafNode(otherlv_24, grammarAccess.getRequirementAccess().getCommaKeyword_3_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1924:1: ( (otherlv_25= RULE_ID ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1925:1: (otherlv_25= RULE_ID )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1925:1: (otherlv_25= RULE_ID )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:3: otherlv_25= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement4235); 

            	    	    		newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_3_8_3_1_0()); 
            	    	    	

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1944:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1944:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1945:5: {...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1945:108: ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1946:6: ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:6: ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:7: {...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:16: (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1950:2: otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )*
            	    {
            	    otherlv_26=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4306); 

            	        	newLeafNode(otherlv_26, grammarAccess.getRequirementAccess().getSeeKeyword_3_9_0());
            	        
            	    otherlv_27=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleRequirement4318); 

            	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getHazardKeyword_3_9_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1959:1: ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1960:1: (lv_hazardReference_28_0= ruleAadlClassifierReference )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1960:1: (lv_hazardReference_28_0= ruleAadlClassifierReference )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1961:3: lv_hazardReference_28_0= ruleAadlClassifierReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceAadlClassifierReferenceParserRuleCall_3_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4338);
            	    lv_hazardReference_28_0=ruleAadlClassifierReference();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"hazardReference",
            	            		lv_hazardReference_28_0, 
            	            		"AadlClassifierReference");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1977:2: (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Comma) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1978:2: otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4352); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getCommaKeyword_3_9_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1982:1: ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:1: (lv_hazardReference_30_0= ruleAadlClassifierReference )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:1: (lv_hazardReference_30_0= ruleAadlClassifierReference )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1984:3: lv_hazardReference_30_0= ruleAadlClassifierReference
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceAadlClassifierReferenceParserRuleCall_3_9_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4372);
            	    	    lv_hazardReference_30_0=ruleAadlClassifierReference();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"hazardReference",
            	    	            		lv_hazardReference_30_0, 
            	    	            		"AadlClassifierReference");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2007:4: ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2007:4: ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2008:5: {...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2008:109: ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2009:6: ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:6: ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:7: {...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:16: (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:2: otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,Refines,FOLLOW_Refines_in_ruleRequirement4443); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getRefinesKeyword_3_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2017:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2018:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2018:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2019:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_3_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4465);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2032:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==Comma) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2033:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4479); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getCommaKeyword_3_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2037:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2038:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2038:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2039:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_3_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4501);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop35;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2059:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2059:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2060:5: {...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2060:109: ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2061:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2064:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    int cnt36=0;
            	    loop36:
            	    do {
            	        int alt36=2;
            	        int LA36_0 = input.LA(1);

            	        if ( (LA36_0==Requirement) ) {
            	            int LA36_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt36=1;
            	            }


            	        }


            	        switch (alt36) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2064:7: {...}? => ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2064:16: ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2065:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2065:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2066:3: lv_subrequirement_35_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_3_11_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement4579);
            	    	    lv_subrequirement_35_0=ruleRequirement();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subrequirement",
            	    	            		lv_subrequirement_35_0, 
            	    	            		"Requirement");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt36 >= 1 ) break loop36;
            	                EarlyExitException eee =
            	                    new EarlyExitException(36, input);
            	                throw eee;
            	        }
            	        cnt36++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2089:4: ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2089:4: ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2090:5: {...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2090:109: ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2091:6: ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2094:6: ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2094:7: {...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2094:16: (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2095:2: otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_36=(Token)match(input,Decomposes,FOLLOW_Decomposes_in_ruleRequirement4648); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDecomposesKeyword_3_12_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2099:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2100:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2100:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2101:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_3_12_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4670);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2114:2: (otherlv_38= Comma ( ( ruleQualifiedName ) ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Comma) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2115:2: otherlv_38= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_38=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4684); 

            	    	        	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getCommaKeyword_3_12_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2119:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2120:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2120:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2121:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_3_12_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4706);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2141:4: ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2141:4: ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2142:5: {...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2142:109: ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2143:6: ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2146:6: ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2146:7: {...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2146:16: (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2147:2: otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_40=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleRequirement4777); 

            	        	newLeafNode(otherlv_40, grammarAccess.getRequirementAccess().getEvolvesKeyword_3_13_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2151:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2152:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2152:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2153:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_3_13_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4799);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2166:2: (otherlv_42= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2167:2: otherlv_42= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_42=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4813); 

            	    	        	newLeafNode(otherlv_42, grammarAccess.getRequirementAccess().getCommaKeyword_3_13_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2171:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2172:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2172:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2173:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_3_13_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4835);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2193:4: ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2193:4: ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2194:5: {...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2194:109: ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2195:6: ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2198:6: ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2198:7: {...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2198:16: (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2199:2: otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_44=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4906); 

            	        	newLeafNode(otherlv_44, grammarAccess.getRequirementAccess().getSeeKeyword_3_14_0());
            	        
            	    otherlv_45=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4918); 

            	        	newLeafNode(otherlv_45, grammarAccess.getRequirementAccess().getGoalKeyword_3_14_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2208:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_3_14_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4940);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2223:2: (otherlv_47= Comma ( ( ruleQualifiedName ) ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Comma) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2224:2: otherlv_47= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_47=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4954); 

            	    	        	newLeafNode(otherlv_47, grammarAccess.getRequirementAccess().getCommaKeyword_3_14_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2228:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2229:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2229:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2230:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_3_14_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4976);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2250:4: ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2250:4: ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2251:5: {...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2251:109: ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2252:6: ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:6: ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:7: {...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:16: (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2256:2: otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_49=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5047); 

            	        	newLeafNode(otherlv_49, grammarAccess.getRequirementAccess().getSeeKeyword_3_15_0());
            	        
            	    otherlv_50=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement5059); 

            	        	newLeafNode(otherlv_50, grammarAccess.getRequirementAccess().getRequirementKeyword_3_15_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2265:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2266:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2266:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2267:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_3_15_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement5081);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2280:2: (otherlv_52= Comma ( ( ruleQualifiedName ) ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==Comma) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2281:2: otherlv_52= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_52=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5095); 

            	    	        	newLeafNode(otherlv_52, grammarAccess.getRequirementAccess().getCommaKeyword_3_15_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2285:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2287:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_3_15_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement5117);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 17 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2307:4: ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2307:4: ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2308:5: {...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2308:109: ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2309:6: ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:6: ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:7: {...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:16: (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:2: otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_54=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5188); 

            	        	newLeafNode(otherlv_54, grammarAccess.getRequirementAccess().getSeeKeyword_3_16_0());
            	        
            	    otherlv_55=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement5200); 

            	        	newLeafNode(otherlv_55, grammarAccess.getRequirementAccess().getDocumentKeyword_3_16_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2322:1: ( (lv_docReference_56_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2323:1: (lv_docReference_56_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2323:1: (lv_docReference_56_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2324:3: lv_docReference_56_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_3_16_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5220);
            	    lv_docReference_56_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_56_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2340:2: (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==Comma) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2341:2: otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_57=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5234); 

            	    	        	newLeafNode(otherlv_57, grammarAccess.getRequirementAccess().getCommaKeyword_3_16_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2345:1: ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2346:1: (lv_docReference_58_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2346:1: (lv_docReference_58_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2347:3: lv_docReference_58_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_3_16_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5254);
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


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	

            }

            otherlv_59=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement5310); 

                	newLeafNode(otherlv_59, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_4());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2391:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2392:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard5344);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard5354); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2399:1: ruleHazard returns [EObject current=null] : (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket ) ;
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
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_title_9_0 = null;

        AntlrDatatypeRuleToken lv_description_11_0 = null;

        AntlrDatatypeRuleToken lv_rationale_16_0 = null;

        AntlrDatatypeRuleToken lv_issue_18_0 = null;

        AntlrDatatypeRuleToken lv_issue_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2402:28: ( (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2403:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2403:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2404:2: otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleHazard5392); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2408:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2409:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2409:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2410:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5408); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleHazard5426); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2431:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2433:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2433:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2434:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2437:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2438:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2438:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )*
            loop44:
            do {
                int alt44=8;
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
                else if ( LA44_0 ==Mitigated && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
                    alt44=5;
                }
                else if ( LA44_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
                    alt44=6;
                }
                else if ( LA44_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
                    alt44=7;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2440:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2440:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2441:5: {...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2441:103: ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2442:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:7: {...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:16: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2446:2: otherlv_4= For ( (otherlv_5= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleHazard5484); 

            	        	newLeafNode(otherlv_4, grammarAccess.getHazardAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2450:1: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2451:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2451:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2452:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5503); 

            	    		newLeafNode(otherlv_5, grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2470:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2470:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2471:5: {...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2471:103: ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2472:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2475:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2475:7: {...}? => (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2475:16: (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:2: otherlv_6= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_6=(Token)match(input,Category,FOLLOW_Category_in_ruleHazard5572); 

            	        	newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2480:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleHazard5594);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2502:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2502:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2503:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2503:103: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2504:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2507:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2507:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2507:16: (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:2: otherlv_8= Title ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,Title,FOLLOW_Title_in_ruleHazard5663); 

            	        	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2512:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2514:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5683);
            	    lv_title_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2537:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2537:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:103: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2539:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2542:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2542:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2542:16: (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:2: otherlv_10= Description ( (lv_description_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleHazard5752); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2547:1: ( (lv_description_11_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:1: (lv_description_11_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:1: (lv_description_11_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:3: lv_description_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionValueStringParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5772);
            	    lv_description_11_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2572:4: ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2572:4: ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:5: {...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:103: ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2574:6: ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2577:6: ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2577:7: {...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2577:16: (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2578:2: otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_12=(Token)match(input,Mitigated,FOLLOW_Mitigated_in_ruleHazard5841); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getMitigatedKeyword_3_4_0());
            	        
            	    otherlv_13=(Token)match(input,By,FOLLOW_By_in_ruleHazard5853); 

            	        	newLeafNode(otherlv_13, grammarAccess.getHazardAccess().getByKeyword_3_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2587:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2588:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2588:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2589:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getMitigatedRequirementCrossReference_3_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5875);
            	    ruleQualifiedName();

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
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2609:4: ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2609:4: ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2610:5: {...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2610:103: ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2611:6: ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2614:6: ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2614:7: {...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2614:16: (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2615:2: otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) )
            	    {
            	    otherlv_15=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleHazard5944); 

            	        	newLeafNode(otherlv_15, grammarAccess.getHazardAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2619:1: ( (lv_rationale_16_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:1: (lv_rationale_16_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:1: (lv_rationale_16_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2621:3: lv_rationale_16_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5964);
            	    lv_rationale_16_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_16_0, 
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
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2644:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2644:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2645:5: {...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2645:103: ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2646:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2649:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2649:7: {...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2649:16: (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2650:2: otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,Issues,FOLLOW_Issues_in_ruleHazard6033); 

            	        	newLeafNode(otherlv_17, grammarAccess.getHazardAccess().getIssuesKeyword_3_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2654:1: ( (lv_issue_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2655:1: (lv_issue_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2655:1: (lv_issue_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2656:3: lv_issue_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard6053);
            	    lv_issue_18_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_18_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2672:2: (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==Comma) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2673:2: otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard6067); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getHazardAccess().getCommaKeyword_3_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2677:1: ( (lv_issue_20_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2678:1: (lv_issue_20_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2678:1: (lv_issue_20_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2679:3: lv_issue_20_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_6_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard6087);
            	    	    lv_issue_20_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_20_0, 
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

            otherlv_21=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleHazard6143); 

                	newLeafNode(otherlv_21, grammarAccess.getHazardAccess().getRightSquareBracketKeyword_4());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2722:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2723:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2724:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6177);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument6187); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2731:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2734:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2735:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2736:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2736:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2737:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument6233);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2753:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NumberSign) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2754:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument6247); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2758:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2759:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2759:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2760:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6267);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2784:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2785:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2786:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6305);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH6316); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2793:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2797:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:2: (this_ID_0= RULE_ID kw= Solidus )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6357); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH6375); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6392); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH6410); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6425); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2839:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2840:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2841:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6470);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT6481); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2848:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2852:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2853:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2853:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2853:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6521); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2860:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==FullStop) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2861:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT6540); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6555); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2883:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2884:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2885:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription6603);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription6613); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2892:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2897:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2897:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2898:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription6658);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2922:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2923:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2924:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6693);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6703); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2931:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2934:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2936:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2936:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2937:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6745); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2954:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2954:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2955:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2955:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2956:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6776); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2975:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2976:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2977:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6811);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6821); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2984:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2987:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2988:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2988:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2988:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2988:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2989:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2989:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2990:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6866); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3001:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3002:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath6880); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3006:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3007:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3007:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3008:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6900);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3032:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3033:2: (iv_ruleImport= ruleImport EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3034:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport6936);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport6946); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3041:1: ruleImport returns [EObject current=null] : (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3044:28: ( (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3045:1: (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3045:1: (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3046:2: otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,Import,FOLLOW_Import_in_ruleImport6984); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3050:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3051:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3051:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3052:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport7004);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3076:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3077:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3078:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString7040);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString7051); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3085:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3089:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3090:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString7090); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3105:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3106:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3107:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7134);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7145); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3114:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3118:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3119:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3119:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3119:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7185); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3126:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==FullStop) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3127:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName7204); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7219); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3147:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3148:1: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3149:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard7266);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard7277); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3156:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3160:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3161:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3161:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3162:5: this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard7324);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3172:1: (kw= FullStopAsterisk )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FullStopAsterisk) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3173:2: kw= FullStopAsterisk
                    {
                    kw=(Token)match(input,FullStopAsterisk,FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildcard7343); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3186:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3187:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3188:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7385);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference7396); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3195:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3199:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3200:1: ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3200:1: ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3200:2: (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3200:2: (this_ID_0= RULE_ID kw= ColonColon )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3200:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7437); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference7455); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7472); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3220:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FullStop) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3221:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference7491); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7506); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3241:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3242:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3243:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef7553);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef7564); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3250:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3254:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3255:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef7603); 

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


    protected DFA30 dfa30 = new DFA30(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA30_eotS =
        "\22\uffff";
    static final String DFA30_eofS =
        "\22\uffff";
    static final String DFA30_minS =
        "\1\4\15\uffff\1\5\3\uffff";
    static final String DFA30_maxS =
        "\1\47\15\uffff\1\30\3\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\20\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\uffff\1\17\1\16\1\15";
    static final String DFA30_specialS =
        "\1\1\15\uffff\1\0\3\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\4\1\uffff\1\15\1\12\1\uffff\1\5\1\14\2\uffff\1\6\1\2\1\uffff"+
            "\1\13\1\uffff\1\10\3\uffff\1\7\1\3\1\11\1\uffff\1\16\14\uffff"+
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
            "",
            "\1\20\11\uffff\1\17\10\uffff\1\21",
            "",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()* loopback of 822:3: ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_14 = input.LA(1);

                         
                        int index30_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA30_14 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14) ) {s = 15;}

                        else if ( LA30_14 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13) ) {s = 16;}

                        else if ( LA30_14 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12) ) {s = 17;}

                         
                        input.seek(index30_14);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_0 = input.LA(1);

                         
                        int index30_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA30_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA30_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0) ) {s = 2;}

                        else if ( LA30_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1) ) {s = 3;}

                        else if ( LA30_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2) ) {s = 4;}

                        else if ( LA30_0 ==Assertion && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3) ) {s = 5;}

                        else if ( LA30_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4) ) {s = 6;}

                        else if ( LA30_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5) ) {s = 7;}

                        else if ( LA30_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6) ) {s = 8;}

                        else if ( LA30_0 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7) ) {s = 9;}

                        else if ( LA30_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8) ) {s = 10;}

                        else if ( LA30_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9) ) {s = 11;}

                        else if ( LA30_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10) ) {s = 12;}

                        else if ( LA30_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11) ) {s = 13;}

                        else if ( LA30_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12) ) ) {s = 14;}

                         
                        input.seek(index30_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\26\uffff";
    static final String DFA42_eofS =
        "\26\uffff";
    static final String DFA42_minS =
        "\1\4\11\uffff\1\5\4\uffff\1\50\3\uffff\1\0\2\uffff";
    static final String DFA42_maxS =
        "\1\47\11\uffff\1\30\4\uffff\1\50\3\uffff\1\0\2\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\22\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14"+
        "\1\15\1\16\1\uffff\1\12\1\21\1\20\1\uffff\1\11\1\17";
    static final String DFA42_specialS =
        "\1\3\11\uffff\1\0\4\uffff\1\2\3\uffff\1\1\2\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\5\1\14\2\uffff\1\15\1\6\3\uffff\1\7\1\3\1\uffff\1\16\2\uffff"+
            "\1\13\2\uffff\1\11\1\4\1\uffff\1\2\1\12\1\10\13\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22\11\uffff\1\21\4\uffff\1\20\3\uffff\1\17",
            "",
            "",
            "",
            "",
            "\1\23",
            "",
            "",
            "",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 1599:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_10 = input.LA(1);

                         
                        int index42_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA42_10 ==Goal && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 15;}

                        else if ( LA42_10 ==Hazard && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) ) {s = 16;}

                        else if ( LA42_10 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) ) {s = 17;}

                        else if ( LA42_10 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) ) {s = 18;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_19 = input.LA(1);

                         
                        int index42_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) ) {s = 20;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) {s = 21;}

                         
                        input.seek(index42_19);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA42_15 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 19;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_0 = input.LA(1);

                         
                        int index42_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA42_0 ==For && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA42_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA42_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA42_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA42_0 ==Assertion && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA42_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA42_0 ==Val && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA42_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA42_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 10;}

                        else if ( LA42_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10) ) {s = 11;}

                        else if ( LA42_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11) ) {s = 12;}

                        else if ( LA42_0 ==Decomposes && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12) ) {s = 13;}

                        else if ( LA42_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13) ) {s = 14;}

                         
                        input.seek(index42_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleReqSpec_in_entryRuleReqSpec67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpec77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecModel_in_ruleReqSpec124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecDocument_in_ruleReqSpec151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecModel_in_entryRuleReqSpecModel189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecModel199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Package_in_ruleReqSpecModel237 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecModel253 = new BitSet(new long[]{0x0000004002200000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecModel272 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecModel294 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleReqSpecModel317 = new BitSet(new long[]{0x0000004000200000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecModel331 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecModel353 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecModel372 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecModel391 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecModel409 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecModel421 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecModel441 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecModel455 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecModel475 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecModel490 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecModel504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecDocument_in_entryRuleReqSpecDocument538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecDocument548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqSpecDocument586 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecDocument602 = new BitSet(new long[]{0x0000006002000000L});
    public static final BitSet FOLLOW_CommercialAt_in_ruleReqSpecDocument621 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleReqSpecDocument641 = new BitSet(new long[]{0x0000004002000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecDocument657 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecDocument679 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecDocument694 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecDocument716 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecDocument735 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecDocument754 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecDocument772 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecDocument784 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecDocument804 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecDocument818 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecDocument838 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecDocument853 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecDocument867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Container_in_ruleReqSpecFolder949 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder965 = new BitSet(new long[]{0x0000004002000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecFolder984 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder1006 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1021 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1043 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1062 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1081 = new BitSet(new long[]{0x0000008001400820L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecFolder1099 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1111 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder1131 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecFolder1145 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder1165 = new BitSet(new long[]{0x0000008200000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1180 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_entryRuleRSLVariable1228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRSLVariable1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Val_in_ruleRSLVariable1276 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRSLVariable1292 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleRSLVariable1310 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRSLVariable1330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1413 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1429 = new BitSet(new long[]{0x0000004002000000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1448 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1467 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1482 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal1540 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal1562 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Title_in_ruleGoal1631 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1651 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal1720 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1740 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Assertion_in_ruleGoal1809 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1829 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal1898 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1918 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Issues_in_ruleGoal1987 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2007 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2021 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2041 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Refined_in_ruleGoal2112 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2124 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2146 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2160 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2182 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal2260 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Decomposed_in_ruleGoal2329 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2341 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2363 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2377 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2399 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Evolves_in_ruleGoal2470 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2492 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2506 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2528 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2599 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2621 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2635 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2657 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2728 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2750 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2764 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2786 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2857 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal2869 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2891 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2905 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2927 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2998 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal3010 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3032 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3046 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3068 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3139 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal3151 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3171 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3185 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3205 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement3295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3343 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3359 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3377 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3435 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3454 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Category_in_ruleRequirement3523 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3545 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Title_in_ruleRequirement3614 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3634 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3703 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3723 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Assertion_in_ruleRequirement3792 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3812 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3881 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3901 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_ruleRequirement3977 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Issues_in_ruleRequirement4046 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement4066 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4080 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement4100 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4171 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4183 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement4202 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4216 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement4235 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4306 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Hazard_in_ruleRequirement4318 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4338 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4352 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4372 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Refines_in_ruleRequirement4443 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4465 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4479 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4501 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement4579 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Decomposes_in_ruleRequirement4648 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4670 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4684 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4706 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Evolves_in_ruleRequirement4777 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4799 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4813 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4835 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4906 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4918 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4940 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4954 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4976 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5047 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement5059 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement5081 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5095 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement5117 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5188 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement5200 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5220 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5234 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5254 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard5344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard5354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hazard_in_ruleHazard5392 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5408 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleHazard5426 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_For_in_ruleHazard5484 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5503 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Category_in_ruleHazard5572 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazard5594 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Title_in_ruleHazard5663 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5683 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Description_in_ruleHazard5752 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5772 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Mitigated_in_ruleHazard5841 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_By_in_ruleHazard5853 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5875 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Rationale_in_ruleHazard5944 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5964 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Issues_in_ruleHazard6033 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard6053 = new BitSet(new long[]{0x0000008202C07010L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard6067 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard6087 = new BitSet(new long[]{0x0000008202C07010L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleHazard6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument6187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument6233 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument6247 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6357 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH6375 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6392 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH6410 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT6481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6521 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT6540 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6555 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription6603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription6613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription6658 = new BitSet(new long[]{0x0000050000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6693 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6866 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath6880 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport6936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport6946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Import_in_ruleImport6984 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport7004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString7040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString7051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString7090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7185 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName7204 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7219 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard7266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard7277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard7324 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildcard7343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference7396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7437 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference7455 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7472 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference7491 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef7553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef7564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef7603 = new BitSet(new long[]{0x0000000000000002L});

}
