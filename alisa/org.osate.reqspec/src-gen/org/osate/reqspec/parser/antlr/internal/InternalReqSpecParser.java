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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:765:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket ) ;
    public final EObject ruleGoal() throws RecognitionException {
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:770:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= RightSquareBracket
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==For) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:793:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleGoal1448); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:797:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:798:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:798:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:799:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGoalRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleGoal1470);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1485); 

                	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:819:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:819:1: ( ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:820:2: ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_4());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:823:2: ( ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:824:3: ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:824:3: ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop30:
            do {
                int alt30=16;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:826:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:826:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:827:5: {...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:827:101: ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:828:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:831:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:831:7: {...}? => (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:831:16: (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:832:2: otherlv_6= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_6=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal1543); 

            	        	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getCategoryKeyword_4_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:836:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:837:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:837:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:838:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_4_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal1565);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:858:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:858:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:859:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:859:101: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:860:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:863:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:863:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:863:16: (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:864:2: otherlv_8= Title ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,Title,FOLLOW_Title_in_ruleGoal1634); 

            	        	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getTitleKeyword_4_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:868:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:869:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:869:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:870:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_4_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1654);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:893:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:893:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:894:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:894:101: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:898:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:898:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:898:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:899:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal1723); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getDescriptionKeyword_4_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:903:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:904:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:904:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:905:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_4_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1743);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:928:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:928:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:929:5: {...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:929:101: ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:930:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:933:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:933:7: {...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:933:16: (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:934:2: otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,Assertion,FOLLOW_Assertion_in_ruleGoal1812); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getAssertionKeyword_4_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:938:1: ( (lv_assert_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:939:1: (lv_assert_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:939:1: (lv_assert_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:940:3: lv_assert_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertValueStringParserRuleCall_4_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1832);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:963:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:963:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:964:5: {...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:964:101: ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:965:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:968:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:968:7: {...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:968:16: (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:969:2: otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal1901); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getRationaleKeyword_4_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:973:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:974:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:974:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:975:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_4_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1921);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:998:4: ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:998:4: ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:999:5: {...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:999:101: ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1000:6: ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:6: ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:7: {...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:16: (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1004:2: otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )*
            	    {
            	    otherlv_16=(Token)match(input,Issues,FOLLOW_Issues_in_ruleGoal1990); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getIssuesKeyword_4_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1008:1: ( (lv_issue_17_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1009:1: (lv_issue_17_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1009:1: (lv_issue_17_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1010:3: lv_issue_17_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_4_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2010);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1026:2: (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Comma) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1027:2: otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2024); 

            	    	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getCommaKeyword_4_5_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1031:1: ( (lv_issue_19_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: (lv_issue_19_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: (lv_issue_19_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1033:3: lv_issue_19_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_4_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2044);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:4: ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:4: ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1057:5: {...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1057:101: ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1058:6: ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1061:6: ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1061:7: {...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1061:16: (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1062:2: otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_20=(Token)match(input,Refined,FOLLOW_Refined_in_ruleGoal2115); 

            	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getRefinedKeyword_4_6_0());
            	        
            	    otherlv_21=(Token)match(input,To,FOLLOW_To_in_ruleGoal2127); 

            	        	newLeafNode(otherlv_21, grammarAccess.getGoalAccess().getToKeyword_4_6_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1071:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1072:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1072:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1073:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_4_6_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2149);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1086:2: (otherlv_23= Comma ( ( ruleQualifiedName ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Comma) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1087:2: otherlv_23= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2163); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getCommaKeyword_4_6_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1092:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1092:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1093:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_4_6_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2185);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:4: ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:4: ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1114:5: {...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1114:101: ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1115:6: ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:6: ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:7: {...}? => ( (lv_subgoal_25_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:16: ( (lv_subgoal_25_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1119:1: (lv_subgoal_25_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1119:1: (lv_subgoal_25_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1120:3: lv_subgoal_25_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_4_7_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal2263);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:4: ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:4: ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:5: {...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:101: ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1145:6: ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1148:6: ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1148:7: {...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1148:16: (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1149:2: otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_26=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleGoal2332); 

            	        	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getDecomposedKeyword_4_8_0());
            	        
            	    otherlv_27=(Token)match(input,To,FOLLOW_To_in_ruleGoal2344); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getToKeyword_4_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1158:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1159:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1159:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1160:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_4_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2366);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1173:2: (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Comma) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1174:2: otherlv_29= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2380); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getCommaKeyword_4_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1179:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1179:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1180:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_4_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2402);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:4: ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:4: ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1201:5: {...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1201:101: ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:6: ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1205:6: ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1205:7: {...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1205:16: (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1206:2: otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleGoal2473); 

            	        	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getEvolvesKeyword_4_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1210:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1211:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1211:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1212:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_4_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2495);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1225:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Comma) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1226:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2509); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getCommaKeyword_4_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1230:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1232:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_4_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2531);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1252:4: ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1252:4: ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1253:5: {...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1253:102: ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1254:6: ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1257:6: ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1257:7: {...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1257:16: (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1258:2: otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_35=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2602); 

            	        	newLeafNode(otherlv_35, grammarAccess.getGoalAccess().getConflictsKeyword_4_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1262:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1263:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1263:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1264:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_4_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2624);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1277:2: (otherlv_37= Comma ( ( ruleQualifiedName ) ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Comma) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1278:2: otherlv_37= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_37=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2638); 

            	    	        	newLeafNode(otherlv_37, grammarAccess.getGoalAccess().getCommaKeyword_4_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1282:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1283:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1283:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1284:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_4_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2660);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1304:4: ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1304:4: ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1305:5: {...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1305:102: ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1306:6: ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1309:6: ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1309:7: {...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1309:16: (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1310:2: otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_39=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2731); 

            	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getStakeholderKeyword_4_11_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1314:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1315:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1315:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1316:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_4_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2753);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1329:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Comma) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1330:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2767); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getCommaKeyword_4_11_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1334:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1335:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1335:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1336:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_4_11_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2789);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1356:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1356:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1357:5: {...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1357:102: ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1358:6: ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1361:6: ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1361:7: {...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1361:16: (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1362:2: otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,See,FOLLOW_See_in_ruleGoal2860); 

            	        	newLeafNode(otherlv_43, grammarAccess.getGoalAccess().getSeeKeyword_4_12_0());
            	        
            	    otherlv_44=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal2872); 

            	        	newLeafNode(otherlv_44, grammarAccess.getGoalAccess().getGoalKeyword_4_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1371:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1372:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1372:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1373:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_4_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2894);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1386:2: (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==Comma) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1387:2: otherlv_46= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_46=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2908); 

            	    	        	newLeafNode(otherlv_46, grammarAccess.getGoalAccess().getCommaKeyword_4_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1391:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1392:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1392:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1393:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_4_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2930);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1413:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1413:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1414:5: {...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1414:102: ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1415:6: ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1418:6: ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1418:7: {...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1418:16: (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1419:2: otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_48=(Token)match(input,See,FOLLOW_See_in_ruleGoal3001); 

            	        	newLeafNode(otherlv_48, grammarAccess.getGoalAccess().getSeeKeyword_4_13_0());
            	        
            	    otherlv_49=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal3013); 

            	        	newLeafNode(otherlv_49, grammarAccess.getGoalAccess().getRequirementKeyword_4_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1428:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1429:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1429:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1430:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_4_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3035);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1443:2: (otherlv_51= Comma ( ( ruleQualifiedName ) ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Comma) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1444:2: otherlv_51= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_51=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3049); 

            	    	        	newLeafNode(otherlv_51, grammarAccess.getGoalAccess().getCommaKeyword_4_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1448:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1449:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1449:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1450:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_4_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3071);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1470:4: ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1470:4: ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1471:5: {...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1471:102: ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1472:6: ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1475:6: ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1475:7: {...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1475:16: (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1476:2: otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_53=(Token)match(input,See,FOLLOW_See_in_ruleGoal3142); 

            	        	newLeafNode(otherlv_53, grammarAccess.getGoalAccess().getSeeKeyword_4_14_0());
            	        
            	    otherlv_54=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal3154); 

            	        	newLeafNode(otherlv_54, grammarAccess.getGoalAccess().getDocumentKeyword_4_14_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1485:1: ( (lv_docReference_55_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1486:1: (lv_docReference_55_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1486:1: (lv_docReference_55_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1487:3: lv_docReference_55_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_4_14_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3174);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1503:2: (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Comma) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1504:2: otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_56=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3188); 

            	    	        	newLeafNode(otherlv_56, grammarAccess.getGoalAccess().getCommaKeyword_4_14_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1508:1: ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1510:3: lv_docReference_57_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_4_14_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3208);
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

            otherlv_58=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal3264); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1553:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1554:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1555:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement3298);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement3308); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1562:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket ) ;
    public final EObject ruleRequirement() throws RecognitionException {
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1565:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1566:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1566:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1567:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3346); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1571:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1573:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3362); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3380); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1594:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1596:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1596:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1597:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1600:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1601:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1601:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop42:
            do {
                int alt42=18;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1603:4: ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1603:4: ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1604:5: {...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1604:108: ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1605:6: ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1608:6: ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1608:7: {...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1608:16: (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1609:2: otherlv_4= For ( ( ruleAadlClassifierReference ) )
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3438); 

            	        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1613:1: ( ( ruleAadlClassifierReference ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1614:1: ( ruleAadlClassifierReference )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1614:1: ( ruleAadlClassifierReference )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1615:3: ruleAadlClassifierReference
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3460);
            	    ruleAadlClassifierReference();

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
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1635:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1635:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1636:5: {...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1636:108: ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1637:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1640:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1640:7: {...}? => (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1640:16: (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1641:2: otherlv_6= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_6=(Token)match(input,Category,FOLLOW_Category_in_ruleRequirement3529); 

            	        	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1645:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1646:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1646:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1647:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3551);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1667:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1667:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:108: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1669:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1672:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1672:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1672:16: (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1673:2: otherlv_8= Title ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,Title,FOLLOW_Title_in_ruleRequirement3620); 

            	        	newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1677:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1678:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1678:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1679:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3640);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1702:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1702:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:108: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1704:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1707:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1707:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1707:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1708:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3709); 

            	        	newLeafNode(otherlv_10, grammarAccess.getRequirementAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1712:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1713:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1713:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1714:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3729);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1737:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1737:4: ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1738:5: {...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1738:108: ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1739:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1742:6: ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1742:7: {...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1742:16: (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1743:2: otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,Assertion,FOLLOW_Assertion_in_ruleRequirement3798); 

            	        	newLeafNode(otherlv_12, grammarAccess.getRequirementAccess().getAssertionKeyword_3_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1747:1: ( (lv_assert_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1748:1: (lv_assert_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1748:1: (lv_assert_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1749:3: lv_assert_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertValueStringParserRuleCall_3_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3818);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1772:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1772:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:5: {...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:108: ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1774:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1777:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1777:7: {...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1777:16: (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:2: otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3887); 

            	        	newLeafNode(otherlv_14, grammarAccess.getRequirementAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1782:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1784:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3907);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1807:4: ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1807:4: ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:5: {...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:108: ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1809:6: ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1812:6: ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1812:7: {...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1812:16: ( (lv_reqValue_16_0= ruleRSLVariable ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1813:1: (lv_reqValue_16_0= ruleRSLVariable )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1813:1: (lv_reqValue_16_0= ruleRSLVariable )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1814:3: lv_reqValue_16_0= ruleRSLVariable
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getReqValueRSLVariableParserRuleCall_3_6_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRSLVariable_in_ruleRequirement3983);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1837:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1837:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:5: {...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:108: ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1839:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1842:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1842:7: {...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1842:16: (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:2: otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,Issues,FOLLOW_Issues_in_ruleRequirement4052); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getIssuesKeyword_3_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1847:1: ( (lv_issue_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1848:1: (lv_issue_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1848:1: (lv_issue_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1849:3: lv_issue_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_3_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement4072);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1865:2: (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Comma) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1866:2: otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4086); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getCommaKeyword_3_7_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1870:1: ( (lv_issue_20_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1871:1: (lv_issue_20_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1871:1: (lv_issue_20_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1872:3: lv_issue_20_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_3_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement4106);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1895:4: ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1895:4: ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:5: {...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:108: ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1897:6: ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1900:6: ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1900:7: {...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1900:16: (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1901:2: otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4177); 

            	        	newLeafNode(otherlv_21, grammarAccess.getRequirementAccess().getSeeKeyword_3_8_0());
            	        
            	    otherlv_22=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4189); 

            	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getGoalKeyword_3_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1910:1: ( (otherlv_23= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1911:1: (otherlv_23= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1911:1: (otherlv_23= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1912:3: otherlv_23= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	    otherlv_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement4208); 

            	    		newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_3_8_2_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1923:2: (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Comma) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1924:2: otherlv_24= Comma ( (otherlv_25= RULE_ID ) )
            	    	    {
            	    	    otherlv_24=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4222); 

            	    	        	newLeafNode(otherlv_24, grammarAccess.getRequirementAccess().getCommaKeyword_3_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1928:1: ( (otherlv_25= RULE_ID ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1929:1: (otherlv_25= RULE_ID )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1929:1: (otherlv_25= RULE_ID )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:3: otherlv_25= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement4241); 

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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1948:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1948:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:5: {...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:108: ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1950:6: ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:6: ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:7: {...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:16: (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1954:2: otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )*
            	    {
            	    otherlv_26=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4312); 

            	        	newLeafNode(otherlv_26, grammarAccess.getRequirementAccess().getSeeKeyword_3_9_0());
            	        
            	    otherlv_27=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleRequirement4324); 

            	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getHazardKeyword_3_9_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1963:1: ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1964:1: (lv_hazardReference_28_0= ruleAadlClassifierReference )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1964:1: (lv_hazardReference_28_0= ruleAadlClassifierReference )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1965:3: lv_hazardReference_28_0= ruleAadlClassifierReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceAadlClassifierReferenceParserRuleCall_3_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4344);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1981:2: (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Comma) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1982:2: otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4358); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getCommaKeyword_3_9_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1986:1: ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1987:1: (lv_hazardReference_30_0= ruleAadlClassifierReference )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1987:1: (lv_hazardReference_30_0= ruleAadlClassifierReference )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1988:3: lv_hazardReference_30_0= ruleAadlClassifierReference
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceAadlClassifierReferenceParserRuleCall_3_9_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4378);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2011:4: ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2011:4: ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:5: {...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:109: ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:6: ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2016:6: ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2016:7: {...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2016:16: (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2017:2: otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,Refines,FOLLOW_Refines_in_ruleRequirement4449); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getRefinesKeyword_3_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2021:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2022:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2022:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2023:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_3_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4471);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2036:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==Comma) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2037:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4485); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getCommaKeyword_3_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2041:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2042:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2042:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2043:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_3_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4507);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2063:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2063:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2064:5: {...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2064:109: ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2065:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2068:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2068:7: {...}? => ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2068:16: ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2069:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2069:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:3: lv_subrequirement_35_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_3_11_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement4585);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2093:4: ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2093:4: ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2094:5: {...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2094:109: ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2095:6: ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2098:6: ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2098:7: {...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2098:16: (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2099:2: otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_36=(Token)match(input,Decomposes,FOLLOW_Decomposes_in_ruleRequirement4654); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDecomposesKeyword_3_12_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2103:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2104:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2104:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2105:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_3_12_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4676);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2118:2: (otherlv_38= Comma ( ( ruleQualifiedName ) ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Comma) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2119:2: otherlv_38= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_38=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4690); 

            	    	        	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getCommaKeyword_3_12_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2123:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2124:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2124:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2125:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_3_12_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4712);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2145:4: ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2145:4: ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2146:5: {...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2146:109: ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2147:6: ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2150:6: ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2150:7: {...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2150:16: (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2151:2: otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_40=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleRequirement4783); 

            	        	newLeafNode(otherlv_40, grammarAccess.getRequirementAccess().getEvolvesKeyword_3_13_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2155:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2156:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2156:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2157:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_3_13_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4805);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2170:2: (otherlv_42= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2171:2: otherlv_42= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_42=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4819); 

            	    	        	newLeafNode(otherlv_42, grammarAccess.getRequirementAccess().getCommaKeyword_3_13_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2175:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2176:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2176:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2177:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_3_13_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4841);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2197:4: ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2197:4: ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2198:5: {...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2198:109: ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2199:6: ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2202:6: ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2202:7: {...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2202:16: (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2203:2: otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_44=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4912); 

            	        	newLeafNode(otherlv_44, grammarAccess.getRequirementAccess().getSeeKeyword_3_14_0());
            	        
            	    otherlv_45=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4924); 

            	        	newLeafNode(otherlv_45, grammarAccess.getRequirementAccess().getGoalKeyword_3_14_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2212:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2213:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2213:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2214:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_3_14_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4946);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2227:2: (otherlv_47= Comma ( ( ruleQualifiedName ) ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Comma) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2228:2: otherlv_47= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_47=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4960); 

            	    	        	newLeafNode(otherlv_47, grammarAccess.getRequirementAccess().getCommaKeyword_3_14_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2232:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2233:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2233:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2234:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_3_14_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4982);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:4: ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:4: ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:5: {...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:109: ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2256:6: ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:6: ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:7: {...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:16: (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2260:2: otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_49=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5053); 

            	        	newLeafNode(otherlv_49, grammarAccess.getRequirementAccess().getSeeKeyword_3_15_0());
            	        
            	    otherlv_50=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement5065); 

            	        	newLeafNode(otherlv_50, grammarAccess.getRequirementAccess().getRequirementKeyword_3_15_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2269:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2270:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2270:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2271:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_3_15_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement5087);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2284:2: (otherlv_52= Comma ( ( ruleQualifiedName ) ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==Comma) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2285:2: otherlv_52= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_52=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5101); 

            	    	        	newLeafNode(otherlv_52, grammarAccess.getRequirementAccess().getCommaKeyword_3_15_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2289:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2290:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2290:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2291:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_3_15_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement5123);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2311:4: ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2311:4: ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:5: {...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:109: ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:6: ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2316:6: ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2316:7: {...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2316:16: (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2317:2: otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_54=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5194); 

            	        	newLeafNode(otherlv_54, grammarAccess.getRequirementAccess().getSeeKeyword_3_16_0());
            	        
            	    otherlv_55=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement5206); 

            	        	newLeafNode(otherlv_55, grammarAccess.getRequirementAccess().getDocumentKeyword_3_16_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2326:1: ( (lv_docReference_56_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2327:1: (lv_docReference_56_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2327:1: (lv_docReference_56_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2328:3: lv_docReference_56_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_3_16_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5226);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2344:2: (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==Comma) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2345:2: otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_57=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5240); 

            	    	        	newLeafNode(otherlv_57, grammarAccess.getRequirementAccess().getCommaKeyword_3_16_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2349:1: ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2350:1: (lv_docReference_58_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2350:1: (lv_docReference_58_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2351:3: lv_docReference_58_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_3_16_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5260);
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

            otherlv_59=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement5316); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2394:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2395:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2396:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard5350);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard5360); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2403:1: ruleHazard returns [EObject current=null] : (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket ) ;
    public final EObject ruleHazard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2406:28: ( (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2407:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2407:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2408:2: otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleHazard5398); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2412:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2413:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2413:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2414:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5414); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleHazard5432); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2435:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2437:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2437:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2438:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2441:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2442:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2442:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2444:4: ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2444:4: ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:5: {...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:103: ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2446:6: ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2449:6: ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2449:7: {...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2449:16: (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2450:2: otherlv_4= For ( ( ruleAadlClassifierReference ) )
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleHazard5490); 

            	        	newLeafNode(otherlv_4, grammarAccess.getHazardAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2454:1: ( ( ruleAadlClassifierReference ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2455:1: ( ruleAadlClassifierReference )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2455:1: ( ruleAadlClassifierReference )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2456:3: ruleAadlClassifierReference
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleHazard5512);
            	    ruleAadlClassifierReference();

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
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:4: ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2477:5: {...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2477:103: ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2478:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:6: ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:7: {...}? => (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:16: (otherlv_6= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:2: otherlv_6= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_6=(Token)match(input,Category,FOLLOW_Category_in_ruleHazard5581); 

            	        	newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2486:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2487:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2487:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2488:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleHazard5603);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:4: ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2509:5: {...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2509:103: ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2510:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:6: ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:7: {...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:16: (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2514:2: otherlv_8= Title ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,Title,FOLLOW_Title_in_ruleHazard5672); 

            	        	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2518:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2519:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2519:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2520:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5692);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:103: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:16: (otherlv_10= Description ( (lv_description_11_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:2: otherlv_10= Description ( (lv_description_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleHazard5761); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2553:1: ( (lv_description_11_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2554:1: (lv_description_11_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2554:1: (lv_description_11_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2555:3: lv_description_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionValueStringParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5781);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2578:4: ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2578:4: ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2579:5: {...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2579:103: ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2580:6: ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2583:6: ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2583:7: {...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2583:16: (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:2: otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_12=(Token)match(input,Mitigated,FOLLOW_Mitigated_in_ruleHazard5850); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getMitigatedKeyword_3_4_0());
            	        
            	    otherlv_13=(Token)match(input,By,FOLLOW_By_in_ruleHazard5862); 

            	        	newLeafNode(otherlv_13, grammarAccess.getHazardAccess().getByKeyword_3_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2593:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2594:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2594:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2595:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getMitigatedRequirementCrossReference_3_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5884);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2615:4: ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2615:4: ({...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2616:5: {...}? => ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2616:103: ( ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2617:6: ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:6: ({...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:7: {...}? => (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:16: (otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2621:2: otherlv_15= Rationale ( (lv_rationale_16_0= ruleValueString ) )
            	    {
            	    otherlv_15=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleHazard5953); 

            	        	newLeafNode(otherlv_15, grammarAccess.getHazardAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2625:1: ( (lv_rationale_16_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2626:1: (lv_rationale_16_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2626:1: (lv_rationale_16_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2627:3: lv_rationale_16_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5973);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2650:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2650:4: ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2651:5: {...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2651:103: ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2652:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2655:6: ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2655:7: {...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2655:16: (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2656:2: otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,Issues,FOLLOW_Issues_in_ruleHazard6042); 

            	        	newLeafNode(otherlv_17, grammarAccess.getHazardAccess().getIssuesKeyword_3_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2660:1: ( (lv_issue_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2661:1: (lv_issue_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2661:1: (lv_issue_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2662:3: lv_issue_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard6062);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2678:2: (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==Comma) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2679:2: otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard6076); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getHazardAccess().getCommaKeyword_3_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:1: ( (lv_issue_20_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2684:1: (lv_issue_20_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2684:1: (lv_issue_20_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2685:3: lv_issue_20_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_6_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard6096);
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

            otherlv_21=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleHazard6152); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2728:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2729:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2730:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6186);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument6196); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2737:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2740:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2741:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2741:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2741:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2741:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2742:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2742:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2743:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument6242);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2759:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NumberSign) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2760:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument6256); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2764:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2765:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2765:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2766:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6276);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2790:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2791:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2792:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6314);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH6325); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2803:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2804:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2804:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2804:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2804:2: (this_ID_0= RULE_ID kw= Solidus )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2804:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6366); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH6384); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6401); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH6419); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6434); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2845:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2846:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2847:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6479);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT6490); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2854:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2858:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2859:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2859:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2859:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6530); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2866:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==FullStop) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2867:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT6549); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6564); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2889:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2890:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2891:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription6612);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription6622); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2898:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2901:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2902:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2902:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2903:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2903:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2904:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription6667);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2928:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2929:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2930:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6702);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6712); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2937:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2940:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2941:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2941:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2941:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2941:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2942:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2942:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2943:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6754); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2960:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2960:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2961:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2961:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2962:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6785); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2982:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2983:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6820);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6830); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2990:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2993:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2994:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2994:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2994:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2994:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2995:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2995:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2996:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6875); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3007:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3008:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath6889); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3012:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3013:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3013:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3014:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6909);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3038:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3039:2: (iv_ruleImport= ruleImport EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3040:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport6945);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport6955); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3047:1: ruleImport returns [EObject current=null] : (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3050:28: ( (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3051:1: (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3051:1: (otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3052:2: otherlv_0= Import ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,Import,FOLLOW_Import_in_ruleImport6993); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3056:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3057:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3057:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3058:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport7013);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3082:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3083:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3084:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString7049);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString7060); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3091:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3095:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3096:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString7099); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3111:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3112:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3113:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7143);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7154); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3120:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3124:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3125:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3125:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3125:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7194); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3132:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==FullStop) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3133:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName7213); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7228); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3153:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3154:1: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3155:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard7275);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard7286); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3162:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3166:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3167:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3167:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3168:5: this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard7333);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3178:1: (kw= FullStopAsterisk )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FullStopAsterisk) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3179:2: kw= FullStopAsterisk
                    {
                    kw=(Token)match(input,FullStopAsterisk,FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildcard7352); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3192:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3193:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3194:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7394);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference7405); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3201:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3205:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3206:1: ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3206:1: ( (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3206:2: (this_ID_0= RULE_ID kw= ColonColon )+ this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3206:2: (this_ID_0= RULE_ID kw= ColonColon )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3206:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7446); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference7464); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7481); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3226:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FullStop) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3227:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference7500); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7515); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3247:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3248:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3249:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef7562);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef7573); 

            }

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3256:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3260:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3261:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef7612); 

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
        "\14\1\uffff\1\15\1\17\1\16";
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
            "\1\21\11\uffff\1\20\10\uffff\1\17",
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
            return "()* loopback of 824:3: ( ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Issues ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= Comma ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Refined otherlv_21= To ( ( ruleQualifiedName ) ) (otherlv_23= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= Decomposed otherlv_27= To ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Evolves ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= Conflicts ( ( ruleQualifiedName ) ) (otherlv_37= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Goal ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Requirement ( ( ruleQualifiedName ) ) (otherlv_51= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= See otherlv_54= Document ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= Comma ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
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
                        if ( LA30_14 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 12) ) {s = 15;}

                        else if ( LA30_14 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 14) ) {s = 16;}

                        else if ( LA30_14 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_4(), 13) ) {s = 17;}

                         
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
        "\1\15\1\16\1\uffff\1\21\1\20\1\12\1\uffff\1\11\1\17";
    static final String DFA42_specialS =
        "\1\3\11\uffff\1\0\4\uffff\1\1\3\uffff\1\2\2\uffff}>";
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
            "\1\21\11\uffff\1\20\4\uffff\1\22\3\uffff\1\17",
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
            return "()* loopback of 1601:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( ( ruleAadlClassifierReference ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Title ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assertion ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= Issues ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= Comma ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= See otherlv_22= Goal ( (otherlv_23= RULE_ID ) ) (otherlv_24= Comma ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Hazard ( (lv_hazardReference_28_0= ruleAadlClassifierReference ) ) (otherlv_29= Comma ( (lv_hazardReference_30_0= ruleAadlClassifierReference ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= Refines ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposes ( ( ruleQualifiedName ) ) (otherlv_38= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= Evolves ( ( ruleQualifiedName ) ) (otherlv_42= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= See otherlv_45= Goal ( ( ruleQualifiedName ) ) (otherlv_47= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= See otherlv_50= Requirement ( ( ruleQualifiedName ) ) (otherlv_52= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= See otherlv_55= Document ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= Comma ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
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

                        else if ( LA42_10 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) ) {s = 16;}

                        else if ( LA42_10 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) ) {s = 17;}

                        else if ( LA42_10 ==Hazard && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) ) {s = 18;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA42_15 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 19;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_19 = input.LA(1);

                         
                        int index42_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) ) {s = 20;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) {s = 21;}

                         
                        input.seek(index42_19);
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
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleGoal1470 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1485 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal1543 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal1565 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Title_in_ruleGoal1634 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1654 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal1723 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1743 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Assertion_in_ruleGoal1812 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1832 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal1901 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1921 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Issues_in_ruleGoal1990 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2010 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2024 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2044 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Refined_in_ruleGoal2115 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2127 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2149 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2163 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2185 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal2263 = new BitSet(new long[]{0x0000008005C566D0L});
    public static final BitSet FOLLOW_Decomposed_in_ruleGoal2332 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2344 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2366 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2380 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2402 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Evolves_in_ruleGoal2473 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2495 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2509 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2531 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2602 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2624 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2638 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2660 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2731 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2753 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2767 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2789 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2860 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal2872 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2894 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2908 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2930 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3001 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal3013 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3035 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3049 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3071 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3142 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal3154 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3174 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3188 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3208 = new BitSet(new long[]{0x0000008205C566D0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal3264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement3298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3346 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3362 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3380 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3438 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3460 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Category_in_ruleRequirement3529 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3551 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Title_in_ruleRequirement3620 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3640 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3709 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3729 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Assertion_in_ruleRequirement3798 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3818 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3887 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3907 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_ruleRequirement3983 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Issues_in_ruleRequirement4052 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement4072 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4086 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement4106 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4177 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4189 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement4208 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4222 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement4241 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4312 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Hazard_in_ruleRequirement4324 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4344 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4358 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement4378 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Refines_in_ruleRequirement4449 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4471 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4485 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4507 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement4585 = new BitSet(new long[]{0x000000800EC96330L});
    public static final BitSet FOLLOW_Decomposes_in_ruleRequirement4654 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4676 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4690 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4712 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Evolves_in_ruleRequirement4783 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4805 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4819 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4841 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4912 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4924 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4946 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4960 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4982 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5053 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement5065 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement5087 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5101 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement5123 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5194 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement5206 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5226 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5240 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5260 = new BitSet(new long[]{0x000000820EC96330L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement5316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard5350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard5360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hazard_in_ruleHazard5398 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5414 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleHazard5432 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_For_in_ruleHazard5490 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleHazard5512 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Category_in_ruleHazard5581 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazard5603 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Title_in_ruleHazard5672 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5692 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Description_in_ruleHazard5761 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5781 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Mitigated_in_ruleHazard5850 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_By_in_ruleHazard5862 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5884 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Rationale_in_ruleHazard5953 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5973 = new BitSet(new long[]{0x0000008002C07010L});
    public static final BitSet FOLLOW_Issues_in_ruleHazard6042 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard6062 = new BitSet(new long[]{0x0000008202C07010L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard6076 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard6096 = new BitSet(new long[]{0x0000008202C07010L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleHazard6152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument6196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument6242 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument6256 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH6325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6366 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH6384 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6401 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH6419 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6530 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT6549 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6564 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription6612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription6622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription6667 = new BitSet(new long[]{0x0000050000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6875 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath6889 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport6945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport6955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Import_in_ruleImport6993 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport7013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString7049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString7060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString7099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7194 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName7213 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7228 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard7275 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard7286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard7333 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildcard7352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference7405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7446 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference7464 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7481 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference7500 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef7562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef7573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef7612 = new BitSet(new long[]{0x0000000000000002L});

}
