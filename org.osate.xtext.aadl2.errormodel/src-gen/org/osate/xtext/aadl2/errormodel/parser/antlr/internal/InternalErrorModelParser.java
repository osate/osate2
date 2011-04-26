package org.osate.xtext.aadl2.errormodel.parser.antlr.internal; 

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
import org.osate.xtext.aadl2.errormodel.services.ErrorModelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalErrorModelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_EM", "RULE_SEMI", "RULE_ID", "RULE_COLON", "RULE_ASSIGN", "RULE_LPARENS", "RULE_COMMA", "RULE_RPARENS", "RULE_APPEND", "RULE_LBRACKET", "RULE_RBRACKET", "RULE_LCURLY", "RULE_RCURLY", "RULE_LTRANS", "RULE_RTRANS", "RULE_DOT", "RULE_INT", "RULE_NONE", "RULE_SL_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'annex'", "'{**'", "'**}'", "'errors'", "'end'", "'error'", "'type'", "'feature'", "'refined'", "'to'", "'propagations'", "'use'", "'flows'", "'not'", "'propagation'", "'applies'", "'processor'", "'memory'", "'bus'", "'device'", "'system'", "'bindings'", "'source'", "'sink'", "'path'", "'->'", "'self'", "'model'", "'extends'", "'events'", "'states'", "'transitions'", "'event'", "'repair'", "'initial'", "'state'", "'-('", "')->'", "'others'", "'behavior'", "'transition'", "'conditions'", "'detection'", "'.*'", "'mask'", "'when'", "'and'", "'or'", "'ormore'", "'orless'", "'working'", "'composite'", "'in'", "'out'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=6;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_ANY_OTHER=26;
    public static final int RULE_LBRACKET=13;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int RULE_ASSIGN=8;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int RULE_DOT=19;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int RULE_LPARENS=9;
    public static final int RULE_INT=20;
    public static final int T__50=50;
    public static final int RULE_RBRACKET=14;
    public static final int RULE_SEMI=5;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int RULE_RPARENS=11;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_APPEND=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_LTRANS=17;
    public static final int RULE_COMMA=10;
    public static final int RULE_SL_COMMENT=22;
    public static final int RULE_NONE=21;
    public static final int RULE_ML_COMMENT=24;
    public static final int T__30=30;
    public static final int RULE_COLON=7;
    public static final int T__31=31;
    public static final int RULE_STRING=23;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_EM=4;
    public static final int RULE_RTRANS=18;
    public static final int RULE_WS=25;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int RULE_RCURLY=16;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int RULE_LCURLY=15;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalErrorModelParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalErrorModelParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalErrorModelParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g"; }



     	private ErrorModelGrammarAccess grammarAccess;
     	
        public InternalErrorModelParser(TokenStream input, ErrorModelGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "EM2AnnexSubclause";	
       	}
       	
       	@Override
       	protected ErrorModelGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleEM2AnnexSubclause"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:68:1: entryRuleEM2AnnexSubclause returns [EObject current=null] : iv_ruleEM2AnnexSubclause= ruleEM2AnnexSubclause EOF ;
    public final EObject entryRuleEM2AnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEM2AnnexSubclause = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:69:2: (iv_ruleEM2AnnexSubclause= ruleEM2AnnexSubclause EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:70:2: iv_ruleEM2AnnexSubclause= ruleEM2AnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEM2AnnexSubclauseRule()); 
            }
            pushFollow(FOLLOW_ruleEM2AnnexSubclause_in_entryRuleEM2AnnexSubclause75);
            iv_ruleEM2AnnexSubclause=ruleEM2AnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEM2AnnexSubclause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEM2AnnexSubclause85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEM2AnnexSubclause"


    // $ANTLR start "ruleEM2AnnexSubclause"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:77:1: ruleEM2AnnexSubclause returns [EObject current=null] : (otherlv_0= 'annex' this_EM_1= RULE_EM otherlv_2= '{**' ( ( (lv_types_3_0= ruleErrorTypeSet ) ) | ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) ) | ( (lv_ep_5_0= ruleErrorPropagations ) ) | ( (lv_ceb_6_0= ruleComponentErrorBehavior ) ) | ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) ) )+ otherlv_8= '**}' this_SEMI_9= RULE_SEMI ) ;
    public final EObject ruleEM2AnnexSubclause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_EM_1=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        Token this_SEMI_9=null;
        EObject lv_types_3_0 = null;

        EObject lv_ebsm_4_0 = null;

        EObject lv_ep_5_0 = null;

        EObject lv_ceb_6_0 = null;

        EObject lv_compeb_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:80:28: ( (otherlv_0= 'annex' this_EM_1= RULE_EM otherlv_2= '{**' ( ( (lv_types_3_0= ruleErrorTypeSet ) ) | ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) ) | ( (lv_ep_5_0= ruleErrorPropagations ) ) | ( (lv_ceb_6_0= ruleComponentErrorBehavior ) ) | ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) ) )+ otherlv_8= '**}' this_SEMI_9= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:81:1: (otherlv_0= 'annex' this_EM_1= RULE_EM otherlv_2= '{**' ( ( (lv_types_3_0= ruleErrorTypeSet ) ) | ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) ) | ( (lv_ep_5_0= ruleErrorPropagations ) ) | ( (lv_ceb_6_0= ruleComponentErrorBehavior ) ) | ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) ) )+ otherlv_8= '**}' this_SEMI_9= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:81:1: (otherlv_0= 'annex' this_EM_1= RULE_EM otherlv_2= '{**' ( ( (lv_types_3_0= ruleErrorTypeSet ) ) | ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) ) | ( (lv_ep_5_0= ruleErrorPropagations ) ) | ( (lv_ceb_6_0= ruleComponentErrorBehavior ) ) | ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) ) )+ otherlv_8= '**}' this_SEMI_9= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:81:3: otherlv_0= 'annex' this_EM_1= RULE_EM otherlv_2= '{**' ( ( (lv_types_3_0= ruleErrorTypeSet ) ) | ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) ) | ( (lv_ep_5_0= ruleErrorPropagations ) ) | ( (lv_ceb_6_0= ruleComponentErrorBehavior ) ) | ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) ) )+ otherlv_8= '**}' this_SEMI_9= RULE_SEMI
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleEM2AnnexSubclause122); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEM2AnnexSubclauseAccess().getAnnexKeyword_0());
                  
            }
            this_EM_1=(Token)match(input,RULE_EM,FOLLOW_RULE_EM_in_ruleEM2AnnexSubclause133); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_EM_1, grammarAccess.getEM2AnnexSubclauseAccess().getEMTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleEM2AnnexSubclause144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEM2AnnexSubclauseAccess().getLeftCurlyBracketAsteriskAsteriskKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:93:1: ( ( (lv_types_3_0= ruleErrorTypeSet ) ) | ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) ) | ( (lv_ep_5_0= ruleErrorPropagations ) ) | ( (lv_ceb_6_0= ruleComponentErrorBehavior ) ) | ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=6;
                switch ( input.LA(1) ) {
                case 30:
                    {
                    alt1=1;
                    }
                    break;
                case 32:
                    {
                    switch ( input.LA(2) ) {
                    case 37:
                        {
                        alt1=3;
                        }
                        break;
                    case 66:
                        {
                        alt1=4;
                        }
                        break;
                    case 54:
                        {
                        alt1=2;
                        }
                        break;

                    }

                    }
                    break;
                case 78:
                    {
                    alt1=5;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:93:2: ( (lv_types_3_0= ruleErrorTypeSet ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:93:2: ( (lv_types_3_0= ruleErrorTypeSet ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:94:1: (lv_types_3_0= ruleErrorTypeSet )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:94:1: (lv_types_3_0= ruleErrorTypeSet )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:95:3: lv_types_3_0= ruleErrorTypeSet
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEM2AnnexSubclauseAccess().getTypesErrorTypeSetParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleErrorTypeSet_in_ruleEM2AnnexSubclause166);
            	    lv_types_3_0=ruleErrorTypeSet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEM2AnnexSubclauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"types",
            	              		lv_types_3_0, 
            	              		"ErrorTypeSet");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:112:6: ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:112:6: ( (lv_ebsm_4_0= ruleErrorBehaviorStateMachine ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:113:1: (lv_ebsm_4_0= ruleErrorBehaviorStateMachine )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:113:1: (lv_ebsm_4_0= ruleErrorBehaviorStateMachine )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:114:3: lv_ebsm_4_0= ruleErrorBehaviorStateMachine
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEM2AnnexSubclauseAccess().getEbsmErrorBehaviorStateMachineParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleErrorBehaviorStateMachine_in_ruleEM2AnnexSubclause193);
            	    lv_ebsm_4_0=ruleErrorBehaviorStateMachine();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEM2AnnexSubclauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ebsm",
            	              		lv_ebsm_4_0, 
            	              		"ErrorBehaviorStateMachine");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:131:6: ( (lv_ep_5_0= ruleErrorPropagations ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:131:6: ( (lv_ep_5_0= ruleErrorPropagations ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:132:1: (lv_ep_5_0= ruleErrorPropagations )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:132:1: (lv_ep_5_0= ruleErrorPropagations )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:133:3: lv_ep_5_0= ruleErrorPropagations
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEM2AnnexSubclauseAccess().getEpErrorPropagationsParserRuleCall_3_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleErrorPropagations_in_ruleEM2AnnexSubclause220);
            	    lv_ep_5_0=ruleErrorPropagations();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEM2AnnexSubclauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ep",
            	              		lv_ep_5_0, 
            	              		"ErrorPropagations");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:150:6: ( (lv_ceb_6_0= ruleComponentErrorBehavior ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:150:6: ( (lv_ceb_6_0= ruleComponentErrorBehavior ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:151:1: (lv_ceb_6_0= ruleComponentErrorBehavior )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:151:1: (lv_ceb_6_0= ruleComponentErrorBehavior )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:152:3: lv_ceb_6_0= ruleComponentErrorBehavior
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEM2AnnexSubclauseAccess().getCebComponentErrorBehaviorParserRuleCall_3_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleComponentErrorBehavior_in_ruleEM2AnnexSubclause247);
            	    lv_ceb_6_0=ruleComponentErrorBehavior();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEM2AnnexSubclauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ceb",
            	              		lv_ceb_6_0, 
            	              		"ComponentErrorBehavior");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:169:6: ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:169:6: ( (lv_compeb_7_0= ruleCompositeErrorBehavior ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:170:1: (lv_compeb_7_0= ruleCompositeErrorBehavior )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:170:1: (lv_compeb_7_0= ruleCompositeErrorBehavior )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:171:3: lv_compeb_7_0= ruleCompositeErrorBehavior
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEM2AnnexSubclauseAccess().getCompebCompositeErrorBehaviorParserRuleCall_3_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCompositeErrorBehavior_in_ruleEM2AnnexSubclause274);
            	    lv_compeb_7_0=ruleCompositeErrorBehavior();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEM2AnnexSubclauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"compeb",
            	              		lv_compeb_7_0, 
            	              		"CompositeErrorBehavior");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleEM2AnnexSubclause288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getEM2AnnexSubclauseAccess().getAsteriskAsteriskRightCurlyBracketKeyword_4());
                  
            }
            this_SEMI_9=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleEM2AnnexSubclause299); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_9, grammarAccess.getEM2AnnexSubclauseAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleEM2AnnexSubclause"


    // $ANTLR start "entryRuleErrorTypeSet"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:203:1: entryRuleErrorTypeSet returns [EObject current=null] : iv_ruleErrorTypeSet= ruleErrorTypeSet EOF ;
    public final EObject entryRuleErrorTypeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorTypeSet = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:204:2: (iv_ruleErrorTypeSet= ruleErrorTypeSet EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:205:2: iv_ruleErrorTypeSet= ruleErrorTypeSet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorTypeSetRule()); 
            }
            pushFollow(FOLLOW_ruleErrorTypeSet_in_entryRuleErrorTypeSet334);
            iv_ruleErrorTypeSet=ruleErrorTypeSet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorTypeSet; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorTypeSet344); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorTypeSet"


    // $ANTLR start "ruleErrorTypeSet"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:212:1: ruleErrorTypeSet returns [EObject current=null] : (otherlv_0= 'errors' ( (lv_name_1_0= RULE_ID ) ) ( (lv_types_2_0= ruleErrorType ) )+ ( (lv_features_3_0= ruleFeature ) )* otherlv_4= 'end' this_ID_5= RULE_ID this_SEMI_6= RULE_SEMI ) ;
    public final EObject ruleErrorTypeSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        Token this_ID_5=null;
        Token this_SEMI_6=null;
        EObject lv_types_2_0 = null;

        EObject lv_features_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:215:28: ( (otherlv_0= 'errors' ( (lv_name_1_0= RULE_ID ) ) ( (lv_types_2_0= ruleErrorType ) )+ ( (lv_features_3_0= ruleFeature ) )* otherlv_4= 'end' this_ID_5= RULE_ID this_SEMI_6= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:216:1: (otherlv_0= 'errors' ( (lv_name_1_0= RULE_ID ) ) ( (lv_types_2_0= ruleErrorType ) )+ ( (lv_features_3_0= ruleFeature ) )* otherlv_4= 'end' this_ID_5= RULE_ID this_SEMI_6= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:216:1: (otherlv_0= 'errors' ( (lv_name_1_0= RULE_ID ) ) ( (lv_types_2_0= ruleErrorType ) )+ ( (lv_features_3_0= ruleFeature ) )* otherlv_4= 'end' this_ID_5= RULE_ID this_SEMI_6= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:216:3: otherlv_0= 'errors' ( (lv_name_1_0= RULE_ID ) ) ( (lv_types_2_0= ruleErrorType ) )+ ( (lv_features_3_0= ruleFeature ) )* otherlv_4= 'end' this_ID_5= RULE_ID this_SEMI_6= RULE_SEMI
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleErrorTypeSet381); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorTypeSetAccess().getErrorsKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:220:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:221:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:221:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:222:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorTypeSet398); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getErrorTypeSetAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorTypeSetRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:238:2: ( (lv_types_2_0= ruleErrorType ) )+
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
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:239:1: (lv_types_2_0= ruleErrorType )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:239:1: (lv_types_2_0= ruleErrorType )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:240:3: lv_types_2_0= ruleErrorType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getErrorTypeSetAccess().getTypesErrorTypeParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleErrorType_in_ruleErrorTypeSet424);
            	    lv_types_2_0=ruleErrorType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getErrorTypeSetRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"types",
            	              		lv_types_2_0, 
            	              		"ErrorType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:256:3: ( (lv_features_3_0= ruleFeature ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==34) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:257:1: (lv_features_3_0= ruleFeature )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:257:1: (lv_features_3_0= ruleFeature )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:258:3: lv_features_3_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getErrorTypeSetAccess().getFeaturesFeatureParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleFeature_in_ruleErrorTypeSet446);
            	    lv_features_3_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getErrorTypeSetRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_3_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleErrorTypeSet459); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getErrorTypeSetAccess().getEndKeyword_4());
                  
            }
            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorTypeSet470); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_5, grammarAccess.getErrorTypeSetAccess().getIDTerminalRuleCall_5()); 
                  
            }
            this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorTypeSet480); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_6, grammarAccess.getErrorTypeSetAccess().getSEMITerminalRuleCall_6()); 
                  
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
    // $ANTLR end "ruleErrorTypeSet"


    // $ANTLR start "entryRuleErrorType"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:296:1: entryRuleErrorType returns [EObject current=null] : iv_ruleErrorType= ruleErrorType EOF ;
    public final EObject entryRuleErrorType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorType = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:297:2: (iv_ruleErrorType= ruleErrorType EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:298:2: iv_ruleErrorType= ruleErrorType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorTypeRule()); 
            }
            pushFollow(FOLLOW_ruleErrorType_in_entryRuleErrorType517);
            iv_ruleErrorType=ruleErrorType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorType527); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorType"


    // $ANTLR start "ruleErrorType"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:305:1: ruleErrorType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'type' (this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleErrorType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_ASSIGN_4=null;
        Token this_LPARENS_5=null;
        Token otherlv_6=null;
        Token this_COMMA_7=null;
        Token otherlv_8=null;
        Token this_RPARENS_9=null;
        Token this_SEMI_10=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:308:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'type' (this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:309:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'type' (this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:309:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'type' (this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:309:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'type' (this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:309:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:310:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:310:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:311:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorType569); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getErrorTypeAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorTypeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleErrorType585); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getErrorTypeAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleErrorType596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getErrorTypeAccess().getErrorKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleErrorType608); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getErrorTypeAccess().getTypeKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:339:1: (this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ASSIGN) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:339:2: this_ASSIGN_4= RULE_ASSIGN this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS
                    {
                    this_ASSIGN_4=(Token)match(input,RULE_ASSIGN,FOLLOW_RULE_ASSIGN_in_ruleErrorType620); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ASSIGN_4, grammarAccess.getErrorTypeAccess().getASSIGNTerminalRuleCall_4_0()); 
                          
                    }
                    this_LPARENS_5=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleErrorType630); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_5, grammarAccess.getErrorTypeAccess().getLPARENSTerminalRuleCall_4_1()); 
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:347:1: ( (otherlv_6= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:348:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:348:1: (otherlv_6= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:349:3: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorTypeRule());
                      	        }
                              
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorType649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_6, grammarAccess.getErrorTypeAccess().getSubtypesErrorTypeCrossReference_4_2_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:360:2: (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_COMMA) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:360:3: this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) )
                    	    {
                    	    this_COMMA_7=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleErrorType661); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COMMA_7, grammarAccess.getErrorTypeAccess().getCOMMATerminalRuleCall_4_3_0()); 
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:364:1: ( (otherlv_8= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:365:1: (otherlv_8= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:365:1: (otherlv_8= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:366:3: otherlv_8= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getErrorTypeRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorType680); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_8, grammarAccess.getErrorTypeAccess().getSubtypesErrorTypeCrossReference_4_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleErrorType693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getErrorTypeAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorType705); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getErrorTypeAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleErrorType"


    // $ANTLR start "entryRuleFeature"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:393:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:394:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:395:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_ruleFeature_in_entryRuleFeature740);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeature750); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:402:1: ruleFeature returns [EObject current=null] : (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) this_SEMI_2= RULE_SEMI ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token this_SEMI_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:405:28: ( (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) this_SEMI_2= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:406:1: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) this_SEMI_2= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:406:1: (otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) this_SEMI_2= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:406:3: otherlv_0= 'feature' ( (lv_name_1_0= RULE_ID ) ) this_SEMI_2= RULE_SEMI
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleFeature787); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFeatureAccess().getFeatureKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:410:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:411:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:411:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:412:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeature804); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            this_SEMI_2=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleFeature820); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_2, grammarAccess.getFeatureAccess().getSEMITerminalRuleCall_2()); 
                  
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleErrorTypeRefinement"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:440:1: entryRuleErrorTypeRefinement returns [EObject current=null] : iv_ruleErrorTypeRefinement= ruleErrorTypeRefinement EOF ;
    public final EObject entryRuleErrorTypeRefinement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorTypeRefinement = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:441:2: (iv_ruleErrorTypeRefinement= ruleErrorTypeRefinement EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:442:2: iv_ruleErrorTypeRefinement= ruleErrorTypeRefinement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorTypeRefinementRule()); 
            }
            pushFollow(FOLLOW_ruleErrorTypeRefinement_in_entryRuleErrorTypeRefinement855);
            iv_ruleErrorTypeRefinement=ruleErrorTypeRefinement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorTypeRefinement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorTypeRefinement865); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorTypeRefinement"


    // $ANTLR start "ruleErrorTypeRefinement"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:449:1: ruleErrorTypeRefinement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'refined' otherlv_3= 'to' (this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleErrorTypeRefinement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_APPEND_4=null;
        Token this_LPARENS_5=null;
        Token otherlv_6=null;
        Token this_COMMA_7=null;
        Token otherlv_8=null;
        Token this_RPARENS_9=null;
        Token this_SEMI_10=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:452:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'refined' otherlv_3= 'to' (this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:453:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'refined' otherlv_3= 'to' (this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:453:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'refined' otherlv_3= 'to' (this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:453:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'refined' otherlv_3= 'to' (this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )? this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:453:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:454:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:454:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:455:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorTypeRefinementRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorTypeRefinement910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getErrorTypeRefinementAccess().getNameErrorTypeCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleErrorTypeRefinement921); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getErrorTypeRefinementAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleErrorTypeRefinement932); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getErrorTypeRefinementAccess().getRefinedKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,36,FOLLOW_36_in_ruleErrorTypeRefinement944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getErrorTypeRefinementAccess().getToKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:478:1: (this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_APPEND) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:478:2: this_APPEND_4= RULE_APPEND this_LPARENS_5= RULE_LPARENS ( (otherlv_6= RULE_ID ) ) (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )* this_RPARENS_9= RULE_RPARENS
                    {
                    this_APPEND_4=(Token)match(input,RULE_APPEND,FOLLOW_RULE_APPEND_in_ruleErrorTypeRefinement956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_APPEND_4, grammarAccess.getErrorTypeRefinementAccess().getAPPENDTerminalRuleCall_4_0()); 
                          
                    }
                    this_LPARENS_5=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleErrorTypeRefinement966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_5, grammarAccess.getErrorTypeRefinementAccess().getLPARENSTerminalRuleCall_4_1()); 
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:486:1: ( (otherlv_6= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:487:1: (otherlv_6= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:487:1: (otherlv_6= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:488:3: otherlv_6= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorTypeRefinementRule());
                      	        }
                              
                    }
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorTypeRefinement985); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_6, grammarAccess.getErrorTypeRefinementAccess().getSubtypesErrorTypeCrossReference_4_2_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:499:2: (this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_COMMA) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:499:3: this_COMMA_7= RULE_COMMA ( (otherlv_8= RULE_ID ) )
                    	    {
                    	    this_COMMA_7=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleErrorTypeRefinement997); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COMMA_7, grammarAccess.getErrorTypeRefinementAccess().getCOMMATerminalRuleCall_4_3_0()); 
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:503:1: ( (otherlv_8= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:504:1: (otherlv_8= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:504:1: (otherlv_8= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:505:3: otherlv_8= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getErrorTypeRefinementRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorTypeRefinement1016); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_8, grammarAccess.getErrorTypeRefinementAccess().getSubtypesErrorTypeCrossReference_4_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    this_RPARENS_9=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleErrorTypeRefinement1029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_9, grammarAccess.getErrorTypeRefinementAccess().getRPARENSTerminalRuleCall_4_4()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorTypeRefinement1041); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getErrorTypeRefinementAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleErrorTypeRefinement"


    // $ANTLR start "entryRuleErrorPropagations"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:532:1: entryRuleErrorPropagations returns [EObject current=null] : iv_ruleErrorPropagations= ruleErrorPropagations EOF ;
    public final EObject entryRuleErrorPropagations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorPropagations = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:533:2: (iv_ruleErrorPropagations= ruleErrorPropagations EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:534:2: iv_ruleErrorPropagations= ruleErrorPropagations EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorPropagationsRule()); 
            }
            pushFollow(FOLLOW_ruleErrorPropagations_in_entryRuleErrorPropagations1076);
            iv_ruleErrorPropagations=ruleErrorPropagations();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorPropagations; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorPropagations1086); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorPropagations"


    // $ANTLR start "ruleErrorPropagations"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:541:1: ruleErrorPropagations returns [EObject current=null] : (otherlv_0= 'error' otherlv_1= 'propagations' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI ( ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+ )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+ )? otherlv_9= 'end' this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleErrorPropagations() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_SEMI_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token this_SEMI_10=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;

        EObject lv_propagations_6_0 = null;

        EObject lv_flows_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:544:28: ( (otherlv_0= 'error' otherlv_1= 'propagations' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI ( ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+ )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+ )? otherlv_9= 'end' this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:545:1: (otherlv_0= 'error' otherlv_1= 'propagations' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI ( ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+ )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+ )? otherlv_9= 'end' this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:545:1: (otherlv_0= 'error' otherlv_1= 'propagations' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI ( ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+ )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+ )? otherlv_9= 'end' this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:545:3: otherlv_0= 'error' otherlv_1= 'propagations' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI ( ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+ )? ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+ )? otherlv_9= 'end' this_SEMI_10= RULE_SEMI
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleErrorPropagations1123); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorPropagationsAccess().getErrorKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleErrorPropagations1135); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getErrorPropagationsAccess().getPropagationsKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleErrorPropagations1147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getErrorPropagationsAccess().getUseKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:557:1: ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:558:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:558:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:559:3: lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getErrorPropagationsAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleErrorPropagations1168);
            lv_importedNamespace_3_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getErrorPropagationsRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_3_0, 
                      		"QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorPropagations1179); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getErrorPropagationsAccess().getSEMITerminalRuleCall_4()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:579:1: ( ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==37) && (synpred1_InternalErrorModel())) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:579:2: ( ( 'propagations' )=>otherlv_5= 'propagations' ) ( (lv_propagations_6_0= ruleErrorPropagation ) )+
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:579:2: ( ( 'propagations' )=>otherlv_5= 'propagations' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:579:3: ( 'propagations' )=>otherlv_5= 'propagations'
                    {
                    otherlv_5=(Token)match(input,37,FOLLOW_37_in_ruleErrorPropagations1199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getErrorPropagationsAccess().getPropagationsKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:584:2: ( (lv_propagations_6_0= ruleErrorPropagation ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:585:1: (lv_propagations_6_0= ruleErrorPropagation )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:585:1: (lv_propagations_6_0= ruleErrorPropagation )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:586:3: lv_propagations_6_0= ruleErrorPropagation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getErrorPropagationsAccess().getPropagationsErrorPropagationParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleErrorPropagation_in_ruleErrorPropagations1221);
                    	    lv_propagations_6_0=ruleErrorPropagation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getErrorPropagationsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"propagations",
                    	              		lv_propagations_6_0, 
                    	              		"ErrorPropagation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:602:5: ( ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+ )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==39) && (synpred2_InternalErrorModel())) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:602:6: ( ( 'flows' )=>otherlv_7= 'flows' ) ( (lv_flows_8_0= ruleErrorFlow ) )+
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:602:6: ( ( 'flows' )=>otherlv_7= 'flows' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:602:7: ( 'flows' )=>otherlv_7= 'flows'
                    {
                    otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleErrorPropagations1245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getErrorPropagationsAccess().getFlowsKeyword_6_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:607:2: ( (lv_flows_8_0= ruleErrorFlow ) )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==32) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:608:1: (lv_flows_8_0= ruleErrorFlow )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:608:1: (lv_flows_8_0= ruleErrorFlow )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:609:3: lv_flows_8_0= ruleErrorFlow
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getErrorPropagationsAccess().getFlowsErrorFlowParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleErrorFlow_in_ruleErrorPropagations1267);
                    	    lv_flows_8_0=ruleErrorFlow();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getErrorPropagationsRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"flows",
                    	              		lv_flows_8_0, 
                    	              		"ErrorFlow");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,31,FOLLOW_31_in_ruleErrorPropagations1282); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getErrorPropagationsAccess().getEndKeyword_7());
                  
            }
            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorPropagations1293); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getErrorPropagationsAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // $ANTLR end "ruleErrorPropagations"


    // $ANTLR start "entryRuleErrorPropagation"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:641:1: entryRuleErrorPropagation returns [EObject current=null] : iv_ruleErrorPropagation= ruleErrorPropagation EOF ;
    public final EObject entryRuleErrorPropagation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorPropagation = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:642:2: (iv_ruleErrorPropagation= ruleErrorPropagation EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:643:2: iv_ruleErrorPropagation= ruleErrorPropagation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorPropagationRule()); 
            }
            pushFollow(FOLLOW_ruleErrorPropagation_in_entryRuleErrorPropagation1328);
            iv_ruleErrorPropagation=ruleErrorPropagation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorPropagation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorPropagation1338); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorPropagation"


    // $ANTLR start "ruleErrorPropagation"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:650:1: ruleErrorPropagation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_mask_2_0= 'not' ) )? ( (lv_direction_3_0= rulePropagationDirection ) )? otherlv_4= 'propagation' otherlv_5= 'applies' otherlv_6= 'to' ( ( (lv_binding_7_0= ruleBindingKind ) ) | ( (otherlv_8= RULE_ID ) ) ) (this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) ) )* this_SEMI_12= RULE_SEMI ) ;
    public final EObject ruleErrorPropagation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLON_1=null;
        Token lv_mask_2_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_COMMA_9=null;
        Token otherlv_11=null;
        Token this_SEMI_12=null;
        Enumerator lv_direction_3_0 = null;

        AntlrDatatypeRuleToken lv_binding_7_0 = null;

        AntlrDatatypeRuleToken lv_binding_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:653:28: ( ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_mask_2_0= 'not' ) )? ( (lv_direction_3_0= rulePropagationDirection ) )? otherlv_4= 'propagation' otherlv_5= 'applies' otherlv_6= 'to' ( ( (lv_binding_7_0= ruleBindingKind ) ) | ( (otherlv_8= RULE_ID ) ) ) (this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) ) )* this_SEMI_12= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:654:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_mask_2_0= 'not' ) )? ( (lv_direction_3_0= rulePropagationDirection ) )? otherlv_4= 'propagation' otherlv_5= 'applies' otherlv_6= 'to' ( ( (lv_binding_7_0= ruleBindingKind ) ) | ( (otherlv_8= RULE_ID ) ) ) (this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) ) )* this_SEMI_12= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:654:1: ( ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_mask_2_0= 'not' ) )? ( (lv_direction_3_0= rulePropagationDirection ) )? otherlv_4= 'propagation' otherlv_5= 'applies' otherlv_6= 'to' ( ( (lv_binding_7_0= ruleBindingKind ) ) | ( (otherlv_8= RULE_ID ) ) ) (this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) ) )* this_SEMI_12= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:654:2: ( (otherlv_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (lv_mask_2_0= 'not' ) )? ( (lv_direction_3_0= rulePropagationDirection ) )? otherlv_4= 'propagation' otherlv_5= 'applies' otherlv_6= 'to' ( ( (lv_binding_7_0= ruleBindingKind ) ) | ( (otherlv_8= RULE_ID ) ) ) (this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) ) )* this_SEMI_12= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:654:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:655:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:655:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:656:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorPropagationRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorPropagation1383); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getErrorPropagationAccess().getTypeErrorTypeCrossReference_0_0()); 
              	
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleErrorPropagation1394); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getErrorPropagationAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:671:1: ( (lv_mask_2_0= 'not' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==40) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:672:1: (lv_mask_2_0= 'not' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:672:1: (lv_mask_2_0= 'not' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:673:3: lv_mask_2_0= 'not'
                    {
                    lv_mask_2_0=(Token)match(input,40,FOLLOW_40_in_ruleErrorPropagation1411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_mask_2_0, grammarAccess.getErrorPropagationAccess().getMaskNotKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorPropagationRule());
                      	        }
                             		setWithLastConsumed(current, "mask", true, "not");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:686:3: ( (lv_direction_3_0= rulePropagationDirection ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=79 && LA13_0<=80)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:687:1: (lv_direction_3_0= rulePropagationDirection )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:687:1: (lv_direction_3_0= rulePropagationDirection )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:688:3: lv_direction_3_0= rulePropagationDirection
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getErrorPropagationAccess().getDirectionPropagationDirectionEnumRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePropagationDirection_in_ruleErrorPropagation1446);
                    lv_direction_3_0=rulePropagationDirection();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
                      	        }
                             		set(
                             			current, 
                             			"direction",
                              		lv_direction_3_0, 
                              		"PropagationDirection");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,41,FOLLOW_41_in_ruleErrorPropagation1459); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getErrorPropagationAccess().getPropagationKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,42,FOLLOW_42_in_ruleErrorPropagation1471); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getErrorPropagationAccess().getAppliesKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,36,FOLLOW_36_in_ruleErrorPropagation1483); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getErrorPropagationAccess().getToKeyword_6());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:716:1: ( ( (lv_binding_7_0= ruleBindingKind ) ) | ( (otherlv_8= RULE_ID ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=43 && LA14_0<=48)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_ID) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:716:2: ( (lv_binding_7_0= ruleBindingKind ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:716:2: ( (lv_binding_7_0= ruleBindingKind ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:717:1: (lv_binding_7_0= ruleBindingKind )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:717:1: (lv_binding_7_0= ruleBindingKind )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:718:3: lv_binding_7_0= ruleBindingKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getErrorPropagationAccess().getBindingBindingKindParserRuleCall_7_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBindingKind_in_ruleErrorPropagation1505);
                    lv_binding_7_0=ruleBindingKind();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
                      	        }
                             		add(
                             			current, 
                             			"binding",
                              		lv_binding_7_0, 
                              		"BindingKind");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:735:6: ( (otherlv_8= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:735:6: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:736:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:736:1: (otherlv_8= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:737:3: otherlv_8= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorPropagationRule());
                      	        }
                              
                    }
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorPropagation1531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_8, grammarAccess.getErrorPropagationAccess().getAppliestoFeatureCrossReference_7_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:748:3: (this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_COMMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:748:4: this_COMMA_9= RULE_COMMA ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) )
            	    {
            	    this_COMMA_9=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleErrorPropagation1544); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_9, grammarAccess.getErrorPropagationAccess().getCOMMATerminalRuleCall_8_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:752:1: ( ( (lv_binding_10_0= ruleBindingKind ) ) | ( (otherlv_11= RULE_ID ) ) )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( ((LA15_0>=43 && LA15_0<=48)) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==RULE_ID) ) {
            	        alt15=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:752:2: ( (lv_binding_10_0= ruleBindingKind ) )
            	            {
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:752:2: ( (lv_binding_10_0= ruleBindingKind ) )
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:753:1: (lv_binding_10_0= ruleBindingKind )
            	            {
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:753:1: (lv_binding_10_0= ruleBindingKind )
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:754:3: lv_binding_10_0= ruleBindingKind
            	            {
            	            if ( state.backtracking==0 ) {
            	               
            	              	        newCompositeNode(grammarAccess.getErrorPropagationAccess().getBindingBindingKindParserRuleCall_8_1_0_0()); 
            	              	    
            	            }
            	            pushFollow(FOLLOW_ruleBindingKind_in_ruleErrorPropagation1565);
            	            lv_binding_10_0=ruleBindingKind();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElementForParent(grammarAccess.getErrorPropagationRule());
            	              	        }
            	                     		add(
            	                     			current, 
            	                     			"binding",
            	                      		lv_binding_10_0, 
            	                      		"BindingKind");
            	              	        afterParserOrEnumRuleCall();
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:771:6: ( (otherlv_11= RULE_ID ) )
            	            {
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:771:6: ( (otherlv_11= RULE_ID ) )
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:772:1: (otherlv_11= RULE_ID )
            	            {
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:772:1: (otherlv_11= RULE_ID )
            	            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:773:3: otherlv_11= RULE_ID
            	            {
            	            if ( state.backtracking==0 ) {

            	              			if (current==null) {
            	              	            current = createModelElement(grammarAccess.getErrorPropagationRule());
            	              	        }
            	                      
            	            }
            	            otherlv_11=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorPropagation1591); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              		newLeafNode(otherlv_11, grammarAccess.getErrorPropagationAccess().getAppliestoFeatureCrossReference_8_1_1_0()); 
            	              	
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            this_SEMI_12=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorPropagation1605); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_12, grammarAccess.getErrorPropagationAccess().getSEMITerminalRuleCall_9()); 
                  
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
    // $ANTLR end "ruleErrorPropagation"


    // $ANTLR start "entryRuleBindingKind"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:796:1: entryRuleBindingKind returns [String current=null] : iv_ruleBindingKind= ruleBindingKind EOF ;
    public final String entryRuleBindingKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBindingKind = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:797:2: (iv_ruleBindingKind= ruleBindingKind EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:798:2: iv_ruleBindingKind= ruleBindingKind EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingKindRule()); 
            }
            pushFollow(FOLLOW_ruleBindingKind_in_entryRuleBindingKind1641);
            iv_ruleBindingKind=ruleBindingKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingKind.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBindingKind1652); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBindingKind"


    // $ANTLR start "ruleBindingKind"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:805:1: ruleBindingKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'processor' | kw= 'memory' | kw= 'bus' | kw= 'device' | kw= 'system' | kw= 'bindings' ) ;
    public final AntlrDatatypeRuleToken ruleBindingKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:808:28: ( (kw= 'processor' | kw= 'memory' | kw= 'bus' | kw= 'device' | kw= 'system' | kw= 'bindings' ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:809:1: (kw= 'processor' | kw= 'memory' | kw= 'bus' | kw= 'device' | kw= 'system' | kw= 'bindings' )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:809:1: (kw= 'processor' | kw= 'memory' | kw= 'bus' | kw= 'device' | kw= 'system' | kw= 'bindings' )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt17=1;
                }
                break;
            case 44:
                {
                alt17=2;
                }
                break;
            case 45:
                {
                alt17=3;
                }
                break;
            case 46:
                {
                alt17=4;
                }
                break;
            case 47:
                {
                alt17=5;
                }
                break;
            case 48:
                {
                alt17=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:810:2: kw= 'processor'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleBindingKind1690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBindingKindAccess().getProcessorKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:817:2: kw= 'memory'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleBindingKind1709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBindingKindAccess().getMemoryKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:824:2: kw= 'bus'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleBindingKind1728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBindingKindAccess().getBusKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:831:2: kw= 'device'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleBindingKind1747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBindingKindAccess().getDeviceKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:838:2: kw= 'system'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleBindingKind1766); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBindingKindAccess().getSystemKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:845:2: kw= 'bindings'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleBindingKind1785); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBindingKindAccess().getBindingsKeyword_5()); 
                          
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
    // $ANTLR end "ruleBindingKind"


    // $ANTLR start "entryRuleErrorFlow"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:858:1: entryRuleErrorFlow returns [EObject current=null] : iv_ruleErrorFlow= ruleErrorFlow EOF ;
    public final EObject entryRuleErrorFlow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorFlow = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:859:2: (iv_ruleErrorFlow= ruleErrorFlow EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:860:2: iv_ruleErrorFlow= ruleErrorFlow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorFlowRule()); 
            }
            pushFollow(FOLLOW_ruleErrorFlow_in_entryRuleErrorFlow1825);
            iv_ruleErrorFlow=ruleErrorFlow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorFlow; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorFlow1835); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorFlow"


    // $ANTLR start "ruleErrorFlow"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:867:1: ruleErrorFlow returns [EObject current=null] : (this_ErrorSource_0= ruleErrorSource | this_ErrorSink_1= ruleErrorSink | this_ErrorPath_2= ruleErrorPath ) ;
    public final EObject ruleErrorFlow() throws RecognitionException {
        EObject current = null;

        EObject this_ErrorSource_0 = null;

        EObject this_ErrorSink_1 = null;

        EObject this_ErrorPath_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:870:28: ( (this_ErrorSource_0= ruleErrorSource | this_ErrorSink_1= ruleErrorSink | this_ErrorPath_2= ruleErrorPath ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:871:1: (this_ErrorSource_0= ruleErrorSource | this_ErrorSink_1= ruleErrorSink | this_ErrorPath_2= ruleErrorPath )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:871:1: (this_ErrorSource_0= ruleErrorSource | this_ErrorSink_1= ruleErrorSink | this_ErrorPath_2= ruleErrorPath )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                switch ( input.LA(2) ) {
                case 51:
                    {
                    alt18=3;
                    }
                    break;
                case 50:
                    {
                    alt18=2;
                    }
                    break;
                case 49:
                    {
                    alt18=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:872:5: this_ErrorSource_0= ruleErrorSource
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorFlowAccess().getErrorSourceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleErrorSource_in_ruleErrorFlow1882);
                    this_ErrorSource_0=ruleErrorSource();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ErrorSource_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:882:5: this_ErrorSink_1= ruleErrorSink
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorFlowAccess().getErrorSinkParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleErrorSink_in_ruleErrorFlow1909);
                    this_ErrorSink_1=ruleErrorSink();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ErrorSink_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:892:5: this_ErrorPath_2= ruleErrorPath
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorFlowAccess().getErrorPathParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleErrorPath_in_ruleErrorFlow1936);
                    this_ErrorPath_2=ruleErrorPath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ErrorPath_2; 
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
    // $ANTLR end "ruleErrorFlow"


    // $ANTLR start "entryRuleErrorSource"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:908:1: entryRuleErrorSource returns [EObject current=null] : iv_ruleErrorSource= ruleErrorSource EOF ;
    public final EObject entryRuleErrorSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorSource = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:909:2: (iv_ruleErrorSource= ruleErrorSource EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:910:2: iv_ruleErrorSource= ruleErrorSource EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorSourceRule()); 
            }
            pushFollow(FOLLOW_ruleErrorSource_in_entryRuleErrorSource1971);
            iv_ruleErrorSource=ruleErrorSource();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorSource; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorSource1981); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorSource"


    // $ANTLR start "ruleErrorSource"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:917:1: ruleErrorSource returns [EObject current=null] : (otherlv_0= 'error' otherlv_1= 'source' ( (lv_outgoing_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleErrorSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_SEMI_3=null;
        EObject lv_outgoing_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:920:28: ( (otherlv_0= 'error' otherlv_1= 'source' ( (lv_outgoing_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:921:1: (otherlv_0= 'error' otherlv_1= 'source' ( (lv_outgoing_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:921:1: (otherlv_0= 'error' otherlv_1= 'source' ( (lv_outgoing_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:921:3: otherlv_0= 'error' otherlv_1= 'source' ( (lv_outgoing_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleErrorSource2018); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorSourceAccess().getErrorKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleErrorSource2030); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getErrorSourceAccess().getSourceKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:929:1: ( (lv_outgoing_2_0= ruleErrorPropagationReference ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:930:1: (lv_outgoing_2_0= ruleErrorPropagationReference )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:930:1: (lv_outgoing_2_0= ruleErrorPropagationReference )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:931:3: lv_outgoing_2_0= ruleErrorPropagationReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getErrorSourceAccess().getOutgoingErrorPropagationReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleErrorPropagationReference_in_ruleErrorSource2051);
            lv_outgoing_2_0=ruleErrorPropagationReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getErrorSourceRule());
              	        }
                     		set(
                     			current, 
                     			"outgoing",
                      		lv_outgoing_2_0, 
                      		"ErrorPropagationReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorSource2062); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_3, grammarAccess.getErrorSourceAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleErrorSource"


    // $ANTLR start "entryRuleErrorSink"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:959:1: entryRuleErrorSink returns [EObject current=null] : iv_ruleErrorSink= ruleErrorSink EOF ;
    public final EObject entryRuleErrorSink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorSink = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:960:2: (iv_ruleErrorSink= ruleErrorSink EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:961:2: iv_ruleErrorSink= ruleErrorSink EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorSinkRule()); 
            }
            pushFollow(FOLLOW_ruleErrorSink_in_entryRuleErrorSink2097);
            iv_ruleErrorSink=ruleErrorSink();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorSink; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorSink2107); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorSink"


    // $ANTLR start "ruleErrorSink"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:968:1: ruleErrorSink returns [EObject current=null] : (otherlv_0= 'error' otherlv_1= 'sink' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleErrorSink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_SEMI_3=null;
        EObject lv_incoming_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:971:28: ( (otherlv_0= 'error' otherlv_1= 'sink' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:972:1: (otherlv_0= 'error' otherlv_1= 'sink' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:972:1: (otherlv_0= 'error' otherlv_1= 'sink' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:972:3: otherlv_0= 'error' otherlv_1= 'sink' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) this_SEMI_3= RULE_SEMI
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleErrorSink2144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorSinkAccess().getErrorKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleErrorSink2156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getErrorSinkAccess().getSinkKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:980:1: ( (lv_incoming_2_0= ruleErrorPropagationReference ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:981:1: (lv_incoming_2_0= ruleErrorPropagationReference )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:981:1: (lv_incoming_2_0= ruleErrorPropagationReference )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:982:3: lv_incoming_2_0= ruleErrorPropagationReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getErrorSinkAccess().getIncomingErrorPropagationReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleErrorPropagationReference_in_ruleErrorSink2177);
            lv_incoming_2_0=ruleErrorPropagationReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getErrorSinkRule());
              	        }
                     		set(
                     			current, 
                     			"incoming",
                      		lv_incoming_2_0, 
                      		"ErrorPropagationReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorSink2188); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_3, grammarAccess.getErrorSinkAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleErrorSink"


    // $ANTLR start "entryRuleErrorPath"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1010:1: entryRuleErrorPath returns [EObject current=null] : iv_ruleErrorPath= ruleErrorPath EOF ;
    public final EObject entryRuleErrorPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorPath = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1011:2: (iv_ruleErrorPath= ruleErrorPath EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1012:2: iv_ruleErrorPath= ruleErrorPath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorPathRule()); 
            }
            pushFollow(FOLLOW_ruleErrorPath_in_entryRuleErrorPath2223);
            iv_ruleErrorPath=ruleErrorPath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorPath; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorPath2233); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorPath"


    // $ANTLR start "ruleErrorPath"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1019:1: ruleErrorPath returns [EObject current=null] : (otherlv_0= 'error' otherlv_1= 'path' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) otherlv_3= '->' ( (lv_outgoing_4_0= ruleErrorPropagationReference ) ) this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleErrorPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token this_SEMI_5=null;
        EObject lv_incoming_2_0 = null;

        EObject lv_outgoing_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1022:28: ( (otherlv_0= 'error' otherlv_1= 'path' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) otherlv_3= '->' ( (lv_outgoing_4_0= ruleErrorPropagationReference ) ) this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1023:1: (otherlv_0= 'error' otherlv_1= 'path' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) otherlv_3= '->' ( (lv_outgoing_4_0= ruleErrorPropagationReference ) ) this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1023:1: (otherlv_0= 'error' otherlv_1= 'path' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) otherlv_3= '->' ( (lv_outgoing_4_0= ruleErrorPropagationReference ) ) this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1023:3: otherlv_0= 'error' otherlv_1= 'path' ( (lv_incoming_2_0= ruleErrorPropagationReference ) ) otherlv_3= '->' ( (lv_outgoing_4_0= ruleErrorPropagationReference ) ) this_SEMI_5= RULE_SEMI
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleErrorPath2270); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorPathAccess().getErrorKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleErrorPath2282); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getErrorPathAccess().getPathKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1031:1: ( (lv_incoming_2_0= ruleErrorPropagationReference ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1032:1: (lv_incoming_2_0= ruleErrorPropagationReference )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1032:1: (lv_incoming_2_0= ruleErrorPropagationReference )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1033:3: lv_incoming_2_0= ruleErrorPropagationReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getErrorPathAccess().getIncomingErrorPropagationReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleErrorPropagationReference_in_ruleErrorPath2303);
            lv_incoming_2_0=ruleErrorPropagationReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getErrorPathRule());
              	        }
                     		set(
                     			current, 
                     			"incoming",
                      		lv_incoming_2_0, 
                      		"ErrorPropagationReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleErrorPath2315); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getErrorPathAccess().getHyphenMinusGreaterThanSignKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1053:1: ( (lv_outgoing_4_0= ruleErrorPropagationReference ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1054:1: (lv_outgoing_4_0= ruleErrorPropagationReference )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1054:1: (lv_outgoing_4_0= ruleErrorPropagationReference )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1055:3: lv_outgoing_4_0= ruleErrorPropagationReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getErrorPathAccess().getOutgoingErrorPropagationReferenceParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleErrorPropagationReference_in_ruleErrorPath2336);
            lv_outgoing_4_0=ruleErrorPropagationReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getErrorPathRule());
              	        }
                     		set(
                     			current, 
                     			"outgoing",
                      		lv_outgoing_4_0, 
                      		"ErrorPropagationReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorPath2347); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getErrorPathAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleErrorPath"


    // $ANTLR start "entryRuleErrorPropagationReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1083:1: entryRuleErrorPropagationReference returns [EObject current=null] : iv_ruleErrorPropagationReference= ruleErrorPropagationReference EOF ;
    public final EObject entryRuleErrorPropagationReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorPropagationReference = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1084:2: (iv_ruleErrorPropagationReference= ruleErrorPropagationReference EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1085:2: iv_ruleErrorPropagationReference= ruleErrorPropagationReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorPropagationReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleErrorPropagationReference_in_entryRuleErrorPropagationReference2382);
            iv_ruleErrorPropagationReference=ruleErrorPropagationReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorPropagationReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorPropagationReference2392); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorPropagationReference"


    // $ANTLR start "ruleErrorPropagationReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1092:1: ruleErrorPropagationReference returns [EObject current=null] : ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (otherlv_4= RULE_ID ) ) this_RBRACKET_5= RULE_RBRACKET ) ;
    public final EObject ruleErrorPropagationReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_self_2_0=null;
        Token this_LBRACKET_3=null;
        Token otherlv_4=null;
        Token this_RBRACKET_5=null;
        AntlrDatatypeRuleToken lv_binding_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1095:28: ( ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (otherlv_4= RULE_ID ) ) this_RBRACKET_5= RULE_RBRACKET ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1096:1: ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (otherlv_4= RULE_ID ) ) this_RBRACKET_5= RULE_RBRACKET )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1096:1: ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (otherlv_4= RULE_ID ) ) this_RBRACKET_5= RULE_RBRACKET )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1096:2: ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (otherlv_4= RULE_ID ) ) this_RBRACKET_5= RULE_RBRACKET
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1096:2: ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt19=1;
                }
                break;
            case RULE_ID:
                {
                alt19=2;
                }
                break;
            case 53:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1096:3: ( (lv_binding_0_0= ruleBindingKind ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1096:3: ( (lv_binding_0_0= ruleBindingKind ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1097:1: (lv_binding_0_0= ruleBindingKind )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1097:1: (lv_binding_0_0= ruleBindingKind )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1098:3: lv_binding_0_0= ruleBindingKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getErrorPropagationReferenceAccess().getBindingBindingKindParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBindingKind_in_ruleErrorPropagationReference2439);
                    lv_binding_0_0=ruleBindingKind();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getErrorPropagationReferenceRule());
                      	        }
                             		set(
                             			current, 
                             			"binding",
                              		lv_binding_0_0, 
                              		"BindingKind");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1115:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1115:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1116:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1116:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1117:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorPropagationReferenceRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorPropagationReference2465); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getErrorPropagationReferenceAccess().getFeatureFeatureCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1129:6: ( (lv_self_2_0= 'self' ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1129:6: ( (lv_self_2_0= 'self' ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1130:1: (lv_self_2_0= 'self' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1130:1: (lv_self_2_0= 'self' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1131:3: lv_self_2_0= 'self'
                    {
                    lv_self_2_0=(Token)match(input,53,FOLLOW_53_in_ruleErrorPropagationReference2489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_self_2_0, grammarAccess.getErrorPropagationReferenceAccess().getSelfSelfKeyword_0_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorPropagationReferenceRule());
                      	        }
                             		setWithLastConsumed(current, "self", true, "self");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            this_LBRACKET_3=(Token)match(input,RULE_LBRACKET,FOLLOW_RULE_LBRACKET_in_ruleErrorPropagationReference2514); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LBRACKET_3, grammarAccess.getErrorPropagationReferenceAccess().getLBRACKETTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1148:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1149:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1149:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1150:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorPropagationReferenceRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorPropagationReference2533); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getErrorPropagationReferenceAccess().getErrortypeErrorTypeCrossReference_2_0()); 
              	
            }

            }


            }

            this_RBRACKET_5=(Token)match(input,RULE_RBRACKET,FOLLOW_RULE_RBRACKET_in_ruleErrorPropagationReference2544); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RBRACKET_5, grammarAccess.getErrorPropagationReferenceAccess().getRBRACKETTerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleErrorPropagationReference"


    // $ANTLR start "entryRuleErrorBehaviorStateMachine"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1173:1: entryRuleErrorBehaviorStateMachine returns [EObject current=null] : iv_ruleErrorBehaviorStateMachine= ruleErrorBehaviorStateMachine EOF ;
    public final EObject entryRuleErrorBehaviorStateMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorBehaviorStateMachine = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1174:2: (iv_ruleErrorBehaviorStateMachine= ruleErrorBehaviorStateMachine EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1175:2: iv_ruleErrorBehaviorStateMachine= ruleErrorBehaviorStateMachine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorBehaviorStateMachineRule()); 
            }
            pushFollow(FOLLOW_ruleErrorBehaviorStateMachine_in_entryRuleErrorBehaviorStateMachine2579);
            iv_ruleErrorBehaviorStateMachine=ruleErrorBehaviorStateMachine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorBehaviorStateMachine; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorBehaviorStateMachine2589); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorBehaviorStateMachine"


    // $ANTLR start "ruleErrorBehaviorStateMachine"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1182:1: ruleErrorBehaviorStateMachine returns [EObject current=null] : (otherlv_0= 'error' otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) ) )? ( ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI )? ( ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+ )? ( ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+ )? ( ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+ )? otherlv_14= 'end' this_ID_15= RULE_ID this_SEMI_16= RULE_SEMI ) ;
    public final EObject ruleErrorBehaviorStateMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_SEMI_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token this_ID_15=null;
        Token this_SEMI_16=null;
        AntlrDatatypeRuleToken lv_importedNamespace_6_0 = null;

        EObject lv_events_9_0 = null;

        EObject lv_states_11_0 = null;

        EObject lv_transitions_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1185:28: ( (otherlv_0= 'error' otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) ) )? ( ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI )? ( ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+ )? ( ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+ )? ( ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+ )? otherlv_14= 'end' this_ID_15= RULE_ID this_SEMI_16= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1186:1: (otherlv_0= 'error' otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) ) )? ( ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI )? ( ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+ )? ( ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+ )? ( ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+ )? otherlv_14= 'end' this_ID_15= RULE_ID this_SEMI_16= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1186:1: (otherlv_0= 'error' otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) ) )? ( ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI )? ( ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+ )? ( ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+ )? ( ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+ )? otherlv_14= 'end' this_ID_15= RULE_ID this_SEMI_16= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1186:3: otherlv_0= 'error' otherlv_1= 'model' ( (lv_name_2_0= RULE_ID ) ) ( ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) ) )? ( ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI )? ( ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+ )? ( ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+ )? ( ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+ )? otherlv_14= 'end' this_ID_15= RULE_ID this_SEMI_16= RULE_SEMI
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleErrorBehaviorStateMachine2626); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorBehaviorStateMachineAccess().getErrorKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,54,FOLLOW_54_in_ruleErrorBehaviorStateMachine2638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getErrorBehaviorStateMachineAccess().getModelKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1194:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1195:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1195:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1196:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorBehaviorStateMachine2655); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getErrorBehaviorStateMachineAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorBehaviorStateMachineRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1212:2: ( ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==55) && (synpred3_InternalErrorModel())) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1212:3: ( ( 'extends' )=>otherlv_3= 'extends' ) ( (otherlv_4= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1212:3: ( ( 'extends' )=>otherlv_3= 'extends' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1212:4: ( 'extends' )=>otherlv_3= 'extends'
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_55_in_ruleErrorBehaviorStateMachine2681); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getErrorBehaviorStateMachineAccess().getExtendsKeyword_3_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1217:2: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1218:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1218:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1219:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorBehaviorStateMachineRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorBehaviorStateMachine2702); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getErrorBehaviorStateMachineAccess().getExtendsErrorBehaviorStateMachineCrossReference_3_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1230:4: ( ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) && (synpred4_InternalErrorModel())) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1230:5: ( ( 'use' )=>otherlv_5= 'use' ) ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_7= RULE_SEMI
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1230:5: ( ( 'use' )=>otherlv_5= 'use' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1230:6: ( 'use' )=>otherlv_5= 'use'
                    {
                    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleErrorBehaviorStateMachine2725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getErrorBehaviorStateMachineAccess().getUseKeyword_4_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1235:2: ( (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1236:1: (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1236:1: (lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1237:3: lv_importedNamespace_6_0= ruleQualifiedNameWithWildCard
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleErrorBehaviorStateMachine2747);
                    lv_importedNamespace_6_0=ruleQualifiedNameWithWildCard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
                      	        }
                             		set(
                             			current, 
                             			"importedNamespace",
                              		lv_importedNamespace_6_0, 
                              		"QualifiedNameWithWildCard");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_SEMI_7=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorBehaviorStateMachine2758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SEMI_7, grammarAccess.getErrorBehaviorStateMachineAccess().getSEMITerminalRuleCall_4_2()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1257:3: ( ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+ )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==56) && (synpred5_InternalErrorModel())) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1257:4: ( ( 'events' )=>otherlv_8= 'events' ) ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1257:4: ( ( 'events' )=>otherlv_8= 'events' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1257:5: ( 'events' )=>otherlv_8= 'events'
                    {
                    otherlv_8=(Token)match(input,56,FOLLOW_56_in_ruleErrorBehaviorStateMachine2780); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getErrorBehaviorStateMachineAccess().getEventsKeyword_5_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1262:2: ( (lv_events_9_0= ruleErrorBehaviorEvent ) )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1263:1: (lv_events_9_0= ruleErrorBehaviorEvent )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1263:1: (lv_events_9_0= ruleErrorBehaviorEvent )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1264:3: lv_events_9_0= ruleErrorBehaviorEvent
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getEventsErrorBehaviorEventParserRuleCall_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleErrorBehaviorEvent_in_ruleErrorBehaviorStateMachine2802);
                    	    lv_events_9_0=ruleErrorBehaviorEvent();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"events",
                    	              		lv_events_9_0, 
                    	              		"ErrorBehaviorEvent");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1280:5: ( ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+ )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==57) && (synpred6_InternalErrorModel())) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1280:6: ( ( 'states' )=>otherlv_10= 'states' ) ( (lv_states_11_0= ruleErrorBehaviorState ) )+
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1280:6: ( ( 'states' )=>otherlv_10= 'states' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1280:7: ( 'states' )=>otherlv_10= 'states'
                    {
                    otherlv_10=(Token)match(input,57,FOLLOW_57_in_ruleErrorBehaviorStateMachine2826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getErrorBehaviorStateMachineAccess().getStatesKeyword_6_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1285:2: ( (lv_states_11_0= ruleErrorBehaviorState ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1286:1: (lv_states_11_0= ruleErrorBehaviorState )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1286:1: (lv_states_11_0= ruleErrorBehaviorState )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1287:3: lv_states_11_0= ruleErrorBehaviorState
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getStatesErrorBehaviorStateParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleErrorBehaviorState_in_ruleErrorBehaviorStateMachine2848);
                    	    lv_states_11_0=ruleErrorBehaviorState();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"states",
                    	              		lv_states_11_0, 
                    	              		"ErrorBehaviorState");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1303:5: ( ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+ )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==58) && (synpred7_InternalErrorModel())) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1303:6: ( ( 'transitions' )=>otherlv_12= 'transitions' ) ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1303:6: ( ( 'transitions' )=>otherlv_12= 'transitions' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1303:7: ( 'transitions' )=>otherlv_12= 'transitions'
                    {
                    otherlv_12=(Token)match(input,58,FOLLOW_58_in_ruleErrorBehaviorStateMachine2872); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsKeyword_7_0());
                          
                    }

                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1308:2: ( (lv_transitions_13_0= ruleErrorBehaviorTransition ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1309:1: (lv_transitions_13_0= ruleErrorBehaviorTransition )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1309:1: (lv_transitions_13_0= ruleErrorBehaviorTransition )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1310:3: lv_transitions_13_0= ruleErrorBehaviorTransition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getErrorBehaviorStateMachineAccess().getTransitionsErrorBehaviorTransitionParserRuleCall_7_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleErrorBehaviorTransition_in_ruleErrorBehaviorStateMachine2894);
                    	    lv_transitions_13_0=ruleErrorBehaviorTransition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getErrorBehaviorStateMachineRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"transitions",
                    	              		lv_transitions_13_0, 
                    	              		"ErrorBehaviorTransition");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;

            }

            otherlv_14=(Token)match(input,31,FOLLOW_31_in_ruleErrorBehaviorStateMachine2909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getErrorBehaviorStateMachineAccess().getEndKeyword_8());
                  
            }
            this_ID_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorBehaviorStateMachine2920); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_15, grammarAccess.getErrorBehaviorStateMachineAccess().getIDTerminalRuleCall_9()); 
                  
            }
            this_SEMI_16=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorBehaviorStateMachine2930); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_16, grammarAccess.getErrorBehaviorStateMachineAccess().getSEMITerminalRuleCall_10()); 
                  
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
    // $ANTLR end "ruleErrorBehaviorStateMachine"


    // $ANTLR start "entryRuleErrorBehaviorEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1346:1: entryRuleErrorBehaviorEvent returns [EObject current=null] : iv_ruleErrorBehaviorEvent= ruleErrorBehaviorEvent EOF ;
    public final EObject entryRuleErrorBehaviorEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorBehaviorEvent = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1347:2: (iv_ruleErrorBehaviorEvent= ruleErrorBehaviorEvent EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1348:2: iv_ruleErrorBehaviorEvent= ruleErrorBehaviorEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorBehaviorEventRule()); 
            }
            pushFollow(FOLLOW_ruleErrorBehaviorEvent_in_entryRuleErrorBehaviorEvent2965);
            iv_ruleErrorBehaviorEvent=ruleErrorBehaviorEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorBehaviorEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorBehaviorEvent2975); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorBehaviorEvent"


    // $ANTLR start "ruleErrorBehaviorEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1355:1: ruleErrorBehaviorEvent returns [EObject current=null] : (this_ErrorEvent_0= ruleErrorEvent | this_RepairEvent_1= ruleRepairEvent ) ;
    public final EObject ruleErrorBehaviorEvent() throws RecognitionException {
        EObject current = null;

        EObject this_ErrorEvent_0 = null;

        EObject this_RepairEvent_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1358:28: ( (this_ErrorEvent_0= ruleErrorEvent | this_RepairEvent_1= ruleRepairEvent ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1359:1: (this_ErrorEvent_0= ruleErrorEvent | this_RepairEvent_1= ruleRepairEvent )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1359:1: (this_ErrorEvent_0= ruleErrorEvent | this_RepairEvent_1= ruleRepairEvent )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==RULE_COLON) ) {
                    int LA28_2 = input.LA(3);

                    if ( (LA28_2==32) ) {
                        alt28=1;
                    }
                    else if ( (LA28_2==60) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1360:5: this_ErrorEvent_0= ruleErrorEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorBehaviorEventAccess().getErrorEventParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleErrorEvent_in_ruleErrorBehaviorEvent3022);
                    this_ErrorEvent_0=ruleErrorEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ErrorEvent_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1370:5: this_RepairEvent_1= ruleRepairEvent
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorBehaviorEventAccess().getRepairEventParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRepairEvent_in_ruleErrorBehaviorEvent3049);
                    this_RepairEvent_1=ruleRepairEvent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RepairEvent_1; 
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
    // $ANTLR end "ruleErrorBehaviorEvent"


    // $ANTLR start "entryRuleErrorEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1386:1: entryRuleErrorEvent returns [EObject current=null] : iv_ruleErrorEvent= ruleErrorEvent EOF ;
    public final EObject entryRuleErrorEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorEvent = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1387:2: (iv_ruleErrorEvent= ruleErrorEvent EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1388:2: iv_ruleErrorEvent= ruleErrorEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorEventRule()); 
            }
            pushFollow(FOLLOW_ruleErrorEvent_in_entryRuleErrorEvent3084);
            iv_ruleErrorEvent=ruleErrorEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorEvent3094); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorEvent"


    // $ANTLR start "ruleErrorEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1395:1: ruleErrorEvent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'event' this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleErrorEvent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1398:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'event' this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1399:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'event' this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1399:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'event' this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1399:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'error' otherlv_3= 'event' this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1399:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1400:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1400:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1401:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorEvent3136); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getErrorEventAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorEventRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleErrorEvent3152); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getErrorEventAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleErrorEvent3163); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getErrorEventAccess().getErrorKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleErrorEvent3175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getErrorEventAccess().getEventKeyword_3());
                  
            }
            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorEvent3186); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getErrorEventAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleErrorEvent"


    // $ANTLR start "entryRuleRepairEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1441:1: entryRuleRepairEvent returns [EObject current=null] : iv_ruleRepairEvent= ruleRepairEvent EOF ;
    public final EObject entryRuleRepairEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepairEvent = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1442:2: (iv_ruleRepairEvent= ruleRepairEvent EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1443:2: iv_ruleRepairEvent= ruleRepairEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRepairEventRule()); 
            }
            pushFollow(FOLLOW_ruleRepairEvent_in_entryRuleRepairEvent3221);
            iv_ruleRepairEvent=ruleRepairEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRepairEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRepairEvent3231); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepairEvent"


    // $ANTLR start "ruleRepairEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1450:1: ruleRepairEvent returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'repair' otherlv_3= 'event' this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleRepairEvent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1453:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'repair' otherlv_3= 'event' this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1454:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'repair' otherlv_3= 'event' this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1454:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'repair' otherlv_3= 'event' this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1454:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON otherlv_2= 'repair' otherlv_3= 'event' this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1454:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1455:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1455:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1456:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRepairEvent3273); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getRepairEventAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRepairEventRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleRepairEvent3289); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getRepairEventAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,60,FOLLOW_60_in_ruleRepairEvent3300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRepairEventAccess().getRepairKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleRepairEvent3312); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRepairEventAccess().getEventKeyword_3());
                  
            }
            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleRepairEvent3323); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getRepairEventAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleRepairEvent"


    // $ANTLR start "entryRuleErrorBehaviorState"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1496:1: entryRuleErrorBehaviorState returns [EObject current=null] : iv_ruleErrorBehaviorState= ruleErrorBehaviorState EOF ;
    public final EObject entryRuleErrorBehaviorState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorBehaviorState = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1497:2: (iv_ruleErrorBehaviorState= ruleErrorBehaviorState EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1498:2: iv_ruleErrorBehaviorState= ruleErrorBehaviorState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorBehaviorStateRule()); 
            }
            pushFollow(FOLLOW_ruleErrorBehaviorState_in_entryRuleErrorBehaviorState3358);
            iv_ruleErrorBehaviorState=ruleErrorBehaviorState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorBehaviorState; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorBehaviorState3368); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorBehaviorState"


    // $ANTLR start "ruleErrorBehaviorState"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1505:1: ruleErrorBehaviorState returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_intial_1_0= 'initial' ) )? otherlv_2= 'state' (this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI ) ;
    public final EObject ruleErrorBehaviorState() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_intial_1_0=null;
        Token otherlv_2=null;
        Token this_LCURLY_3=null;
        Token this_RCURLY_5=null;
        Token this_SEMI_6=null;
        EObject lv_properties_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1508:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_intial_1_0= 'initial' ) )? otherlv_2= 'state' (this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1509:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_intial_1_0= 'initial' ) )? otherlv_2= 'state' (this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1509:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_intial_1_0= 'initial' ) )? otherlv_2= 'state' (this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1509:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_intial_1_0= 'initial' ) )? otherlv_2= 'state' (this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )? this_SEMI_6= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1509:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1510:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1510:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1511:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorBehaviorState3410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getErrorBehaviorStateAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorBehaviorStateRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1527:2: ( (lv_intial_1_0= 'initial' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==61) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1528:1: (lv_intial_1_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1528:1: (lv_intial_1_0= 'initial' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1529:3: lv_intial_1_0= 'initial'
                    {
                    lv_intial_1_0=(Token)match(input,61,FOLLOW_61_in_ruleErrorBehaviorState3433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_intial_1_0, grammarAccess.getErrorBehaviorStateAccess().getIntialInitialKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getErrorBehaviorStateRule());
                      	        }
                             		setWithLastConsumed(current, "intial", true, "initial");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,62,FOLLOW_62_in_ruleErrorBehaviorState3459); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getErrorBehaviorStateAccess().getStateKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1546:1: (this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_LCURLY) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1546:2: this_LCURLY_3= RULE_LCURLY ( (lv_properties_4_0= rulePropertyAssociation ) )+ this_RCURLY_5= RULE_RCURLY
                    {
                    this_LCURLY_3=(Token)match(input,RULE_LCURLY,FOLLOW_RULE_LCURLY_in_ruleErrorBehaviorState3471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LCURLY_3, grammarAccess.getErrorBehaviorStateAccess().getLCURLYTerminalRuleCall_3_0()); 
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1550:1: ( (lv_properties_4_0= rulePropertyAssociation ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1551:1: (lv_properties_4_0= rulePropertyAssociation )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1551:1: (lv_properties_4_0= rulePropertyAssociation )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1552:3: lv_properties_4_0= rulePropertyAssociation
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getErrorBehaviorStateAccess().getPropertiesPropertyAssociationParserRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropertyAssociation_in_ruleErrorBehaviorState3491);
                    	    lv_properties_4_0=rulePropertyAssociation();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getErrorBehaviorStateRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"properties",
                    	              		lv_properties_4_0, 
                    	              		"PropertyAssociation");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);

                    this_RCURLY_5=(Token)match(input,RULE_RCURLY,FOLLOW_RULE_RCURLY_in_ruleErrorBehaviorState3503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RCURLY_5, grammarAccess.getErrorBehaviorStateAccess().getRCURLYTerminalRuleCall_3_2()); 
                          
                    }

                    }
                    break;

            }

            this_SEMI_6=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleErrorBehaviorState3515); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_6, grammarAccess.getErrorBehaviorStateAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleErrorBehaviorState"


    // $ANTLR start "entryRuleErrorBehaviorTransition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1584:1: entryRuleErrorBehaviorTransition returns [EObject current=null] : iv_ruleErrorBehaviorTransition= ruleErrorBehaviorTransition EOF ;
    public final EObject entryRuleErrorBehaviorTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorBehaviorTransition = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1585:2: (iv_ruleErrorBehaviorTransition= ruleErrorBehaviorTransition EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1586:2: iv_ruleErrorBehaviorTransition= ruleErrorBehaviorTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorBehaviorTransitionRule()); 
            }
            pushFollow(FOLLOW_ruleErrorBehaviorTransition_in_entryRuleErrorBehaviorTransition3550);
            iv_ruleErrorBehaviorTransition=ruleErrorBehaviorTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorBehaviorTransition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorBehaviorTransition3560); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorBehaviorTransition"


    // $ANTLR start "ruleErrorBehaviorTransition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1593:1: ruleErrorBehaviorTransition returns [EObject current=null] : (this_TriggeredTransition_0= ruleTriggeredTransition | this_BranchTransition_1= ruleBranchTransition ) ;
    public final EObject ruleErrorBehaviorTransition() throws RecognitionException {
        EObject current = null;

        EObject this_TriggeredTransition_0 = null;

        EObject this_BranchTransition_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1596:28: ( (this_TriggeredTransition_0= ruleTriggeredTransition | this_BranchTransition_1= ruleBranchTransition ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1597:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_BranchTransition_1= ruleBranchTransition )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1597:1: (this_TriggeredTransition_0= ruleTriggeredTransition | this_BranchTransition_1= ruleBranchTransition )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==RULE_COLON) ) {
                    alt32=1;
                }
                else if ( (LA32_1==63) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1598:5: this_TriggeredTransition_0= ruleTriggeredTransition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getTriggeredTransitionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTriggeredTransition_in_ruleErrorBehaviorTransition3607);
                    this_TriggeredTransition_0=ruleTriggeredTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TriggeredTransition_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1608:5: this_BranchTransition_1= ruleBranchTransition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getErrorBehaviorTransitionAccess().getBranchTransitionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBranchTransition_in_ruleErrorBehaviorTransition3634);
                    this_BranchTransition_1=ruleBranchTransition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BranchTransition_1; 
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
    // $ANTLR end "ruleErrorBehaviorTransition"


    // $ANTLR start "entryRuleTriggeredTransition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1624:1: entryRuleTriggeredTransition returns [EObject current=null] : iv_ruleTriggeredTransition= ruleTriggeredTransition EOF ;
    public final EObject entryRuleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTransition = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1625:2: (iv_ruleTriggeredTransition= ruleTriggeredTransition EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1626:2: iv_ruleTriggeredTransition= ruleTriggeredTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggeredTransitionRule()); 
            }
            pushFollow(FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition3669);
            iv_ruleTriggeredTransition=ruleTriggeredTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggeredTransition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggeredTransition3679); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggeredTransition"


    // $ANTLR start "ruleTriggeredTransition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1633:1: ruleTriggeredTransition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' | (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS ) ) ( (otherlv_9= RULE_ID ) ) this_SEMI_10= RULE_SEMI ) ;
    public final EObject ruleTriggeredTransition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COLON_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_LTRANS_4=null;
        Token otherlv_5=null;
        Token this_COMMA_6=null;
        Token otherlv_7=null;
        Token this_RTRANS_8=null;
        Token otherlv_9=null;
        Token this_SEMI_10=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1636:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' | (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS ) ) ( (otherlv_9= RULE_ID ) ) this_SEMI_10= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1637:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' | (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS ) ) ( (otherlv_9= RULE_ID ) ) this_SEMI_10= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1637:1: ( ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' | (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS ) ) ( (otherlv_9= RULE_ID ) ) this_SEMI_10= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1637:2: ( (lv_name_0_0= RULE_ID ) ) this_COLON_1= RULE_COLON ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' | (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS ) ) ( (otherlv_9= RULE_ID ) ) this_SEMI_10= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1637:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1638:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1638:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1639:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3721); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getTriggeredTransitionAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_COLON_1=(Token)match(input,RULE_COLON,FOLLOW_RULE_COLON_in_ruleTriggeredTransition3737); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_COLON_1, grammarAccess.getTriggeredTransitionAccess().getCOLONTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1659:1: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1660:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1660:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1661:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3756); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getTriggeredTransitionAccess().getSourceErrorBehaviorStateCrossReference_2_0()); 
              	
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1672:2: (otherlv_3= '->' | (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==52) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_LTRANS) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1672:4: otherlv_3= '->'
                    {
                    otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleTriggeredTransition3769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTriggeredTransitionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1677:6: (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1677:6: (this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1677:7: this_LTRANS_4= RULE_LTRANS ( (otherlv_5= RULE_ID ) ) (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )* this_RTRANS_8= RULE_RTRANS
                    {
                    this_LTRANS_4=(Token)match(input,RULE_LTRANS,FOLLOW_RULE_LTRANS_in_ruleTriggeredTransition3787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LTRANS_4, grammarAccess.getTriggeredTransitionAccess().getLTRANSTerminalRuleCall_3_1_0()); 
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1681:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1682:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1682:1: (otherlv_5= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1683:3: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
                      	        }
                              
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3806); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_5, grammarAccess.getTriggeredTransitionAccess().getEventsErrorBehaviorEventCrossReference_3_1_1_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1694:2: (this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_COMMA) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1694:3: this_COMMA_6= RULE_COMMA ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleTriggeredTransition3818); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COMMA_6, grammarAccess.getTriggeredTransitionAccess().getCOMMATerminalRuleCall_3_1_2_0()); 
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1698:1: ( (otherlv_7= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1699:1: (otherlv_7= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1699:1: (otherlv_7= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1700:3: otherlv_7= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3837); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_7, grammarAccess.getTriggeredTransitionAccess().getEventsErrorBehaviorEventCrossReference_3_1_2_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    this_RTRANS_8=(Token)match(input,RULE_RTRANS,FOLLOW_RULE_RTRANS_in_ruleTriggeredTransition3850); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RTRANS_8, grammarAccess.getTriggeredTransitionAccess().getRTRANSTerminalRuleCall_3_1_3()); 
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1715:3: ( (otherlv_9= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1716:1: (otherlv_9= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1716:1: (otherlv_9= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1717:3: otherlv_9= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTriggeredTransitionRule());
              	        }
                      
            }
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTriggeredTransition3871); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_9, grammarAccess.getTriggeredTransitionAccess().getDestinationErrorBehaviorStateCrossReference_4_0()); 
              	
            }

            }


            }

            this_SEMI_10=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleTriggeredTransition3882); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_10, grammarAccess.getTriggeredTransitionAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleTriggeredTransition"


    // $ANTLR start "entryRuleBranchTransition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1740:1: entryRuleBranchTransition returns [EObject current=null] : iv_ruleBranchTransition= ruleBranchTransition EOF ;
    public final EObject entryRuleBranchTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBranchTransition = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1741:2: (iv_ruleBranchTransition= ruleBranchTransition EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1742:2: iv_ruleBranchTransition= ruleBranchTransition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBranchTransitionRule()); 
            }
            pushFollow(FOLLOW_ruleBranchTransition_in_entryRuleBranchTransition3917);
            iv_ruleBranchTransition=ruleBranchTransition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBranchTransition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBranchTransition3927); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBranchTransition"


    // $ANTLR start "ruleBranchTransition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1749:1: ruleBranchTransition returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-(' ( (lv_value_2_0= ruleBranchValue ) ) otherlv_3= ')->' ( (otherlv_4= RULE_ID ) ) this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleBranchTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token this_SEMI_5=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1752:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-(' ( (lv_value_2_0= ruleBranchValue ) ) otherlv_3= ')->' ( (otherlv_4= RULE_ID ) ) this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1753:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-(' ( (lv_value_2_0= ruleBranchValue ) ) otherlv_3= ')->' ( (otherlv_4= RULE_ID ) ) this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1753:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-(' ( (lv_value_2_0= ruleBranchValue ) ) otherlv_3= ')->' ( (otherlv_4= RULE_ID ) ) this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1753:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '-(' ( (lv_value_2_0= ruleBranchValue ) ) otherlv_3= ')->' ( (otherlv_4= RULE_ID ) ) this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1753:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1754:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1754:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1755:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBranchTransitionRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBranchTransition3972); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getBranchTransitionAccess().getSourceErrorBehaviorStateCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,63,FOLLOW_63_in_ruleBranchTransition3984); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBranchTransitionAccess().getHyphenMinusLeftParenthesisKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1770:1: ( (lv_value_2_0= ruleBranchValue ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1771:1: (lv_value_2_0= ruleBranchValue )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1771:1: (lv_value_2_0= ruleBranchValue )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1772:3: lv_value_2_0= ruleBranchValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBranchTransitionAccess().getValueBranchValueParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBranchValue_in_ruleBranchTransition4005);
            lv_value_2_0=ruleBranchValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBranchTransitionRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"BranchValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_64_in_ruleBranchTransition4017); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBranchTransitionAccess().getRightParenthesisHyphenMinusGreaterThanSignKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1792:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1793:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1793:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1794:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBranchTransitionRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBranchTransition4037); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getBranchTransitionAccess().getDestinationErrorBehaviorStateCrossReference_4_0()); 
              	
            }

            }


            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleBranchTransition4048); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getBranchTransitionAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleBranchTransition"


    // $ANTLR start "entryRuleBranchValue"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1817:1: entryRuleBranchValue returns [String current=null] : iv_ruleBranchValue= ruleBranchValue EOF ;
    public final String entryRuleBranchValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBranchValue = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1818:2: (iv_ruleBranchValue= ruleBranchValue EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1819:2: iv_ruleBranchValue= ruleBranchValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBranchValueRule()); 
            }
            pushFollow(FOLLOW_ruleBranchValue_in_entryRuleBranchValue4084);
            iv_ruleBranchValue=ruleBranchValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBranchValue.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBranchValue4095); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBranchValue"


    // $ANTLR start "ruleBranchValue"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1826:1: ruleBranchValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_REAL_0= ruleREAL | kw= 'others' ) ;
    public final AntlrDatatypeRuleToken ruleBranchValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_REAL_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1829:28: ( (this_REAL_0= ruleREAL | kw= 'others' ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1830:1: (this_REAL_0= ruleREAL | kw= 'others' )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1830:1: (this_REAL_0= ruleREAL | kw= 'others' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INT) ) {
                alt35=1;
            }
            else if ( (LA35_0==65) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1831:5: this_REAL_0= ruleREAL
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBranchValueAccess().getREALParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleREAL_in_ruleBranchValue4142);
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
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1843:2: kw= 'others'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleBranchValue4166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getBranchValueAccess().getOthersKeyword_1()); 
                          
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
    // $ANTLR end "ruleBranchValue"


    // $ANTLR start "entryRuleComponentErrorBehavior"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1856:1: entryRuleComponentErrorBehavior returns [EObject current=null] : iv_ruleComponentErrorBehavior= ruleComponentErrorBehavior EOF ;
    public final EObject entryRuleComponentErrorBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentErrorBehavior = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1857:2: (iv_ruleComponentErrorBehavior= ruleComponentErrorBehavior EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1858:2: iv_ruleComponentErrorBehavior= ruleComponentErrorBehavior EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentErrorBehaviorRule()); 
            }
            pushFollow(FOLLOW_ruleComponentErrorBehavior_in_entryRuleComponentErrorBehavior4206);
            iv_ruleComponentErrorBehavior=ruleComponentErrorBehavior();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponentErrorBehavior; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentErrorBehavior4216); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentErrorBehavior"


    // $ANTLR start "ruleComponentErrorBehavior"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1865:1: ruleComponentErrorBehavior returns [EObject current=null] : (otherlv_0= 'error' otherlv_1= 'behavior' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI (otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+ )? (otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+ )? (otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+ )? otherlv_14= 'end' this_SEMI_15= RULE_SEMI ) ;
    public final EObject ruleComponentErrorBehavior() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_SEMI_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token this_SEMI_15=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;

        EObject lv_transitionCondition_7_0 = null;

        EObject lv_propagationCondition_10_0 = null;

        EObject lv_detectionEvent_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1868:28: ( (otherlv_0= 'error' otherlv_1= 'behavior' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI (otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+ )? (otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+ )? (otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+ )? otherlv_14= 'end' this_SEMI_15= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1869:1: (otherlv_0= 'error' otherlv_1= 'behavior' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI (otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+ )? (otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+ )? (otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+ )? otherlv_14= 'end' this_SEMI_15= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1869:1: (otherlv_0= 'error' otherlv_1= 'behavior' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI (otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+ )? (otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+ )? (otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+ )? otherlv_14= 'end' this_SEMI_15= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1869:3: otherlv_0= 'error' otherlv_1= 'behavior' otherlv_2= 'use' ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_4= RULE_SEMI (otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+ )? (otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+ )? (otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+ )? otherlv_14= 'end' this_SEMI_15= RULE_SEMI
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleComponentErrorBehavior4253); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentErrorBehaviorAccess().getErrorKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,66,FOLLOW_66_in_ruleComponentErrorBehavior4265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getComponentErrorBehaviorAccess().getBehaviorKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleComponentErrorBehavior4277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getComponentErrorBehaviorAccess().getUseKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1881:1: ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1882:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1882:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1883:3: lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentErrorBehaviorAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleComponentErrorBehavior4298);
            lv_importedNamespace_3_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentErrorBehaviorRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_3_0, 
                      		"QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleComponentErrorBehavior4309); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getComponentErrorBehaviorAccess().getSEMITerminalRuleCall_4()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1903:1: (otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+ )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==67) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1903:3: otherlv_5= 'transition' otherlv_6= 'conditions' ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+
                    {
                    otherlv_5=(Token)match(input,67,FOLLOW_67_in_ruleComponentErrorBehavior4321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getComponentErrorBehaviorAccess().getTransitionKeyword_5_0());
                          
                    }
                    otherlv_6=(Token)match(input,68,FOLLOW_68_in_ruleComponentErrorBehavior4333); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getComponentErrorBehaviorAccess().getConditionsKeyword_5_1());
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1911:1: ( (lv_transitionCondition_7_0= ruleTransitionCondition ) )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==RULE_ID||LA36_0==71) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1912:1: (lv_transitionCondition_7_0= ruleTransitionCondition )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1912:1: (lv_transitionCondition_7_0= ruleTransitionCondition )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1913:3: lv_transitionCondition_7_0= ruleTransitionCondition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentErrorBehaviorAccess().getTransitionConditionTransitionConditionParserRuleCall_5_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTransitionCondition_in_ruleComponentErrorBehavior4354);
                    	    lv_transitionCondition_7_0=ruleTransitionCondition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentErrorBehaviorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"transitionCondition",
                    	              		lv_transitionCondition_7_0, 
                    	              		"TransitionCondition");
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


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1929:5: (otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+ )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==41) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1929:7: otherlv_8= 'propagation' otherlv_9= 'conditions' ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+
                    {
                    otherlv_8=(Token)match(input,41,FOLLOW_41_in_ruleComponentErrorBehavior4370); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getComponentErrorBehaviorAccess().getPropagationKeyword_6_0());
                          
                    }
                    otherlv_9=(Token)match(input,68,FOLLOW_68_in_ruleComponentErrorBehavior4382); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getComponentErrorBehaviorAccess().getConditionsKeyword_6_1());
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1937:1: ( (lv_propagationCondition_10_0= rulePropagationCondition ) )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID||LA38_0==71||LA38_0==77) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1938:1: (lv_propagationCondition_10_0= rulePropagationCondition )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1938:1: (lv_propagationCondition_10_0= rulePropagationCondition )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1939:3: lv_propagationCondition_10_0= rulePropagationCondition
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentErrorBehaviorAccess().getPropagationConditionPropagationConditionParserRuleCall_6_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_rulePropagationCondition_in_ruleComponentErrorBehavior4403);
                    	    lv_propagationCondition_10_0=rulePropagationCondition();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentErrorBehaviorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"propagationCondition",
                    	              		lv_propagationCondition_10_0, 
                    	              		"PropagationCondition");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1955:5: (otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==69) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1955:7: otherlv_11= 'detection' otherlv_12= 'events' ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+
                    {
                    otherlv_11=(Token)match(input,69,FOLLOW_69_in_ruleComponentErrorBehavior4419); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getComponentErrorBehaviorAccess().getDetectionKeyword_7_0());
                          
                    }
                    otherlv_12=(Token)match(input,56,FOLLOW_56_in_ruleComponentErrorBehavior4431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getComponentErrorBehaviorAccess().getEventsKeyword_7_1());
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1963:1: ( (lv_detectionEvent_13_0= ruleDetectionEvent ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID||LA40_0==53) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1964:1: (lv_detectionEvent_13_0= ruleDetectionEvent )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1964:1: (lv_detectionEvent_13_0= ruleDetectionEvent )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1965:3: lv_detectionEvent_13_0= ruleDetectionEvent
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentErrorBehaviorAccess().getDetectionEventDetectionEventParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleDetectionEvent_in_ruleComponentErrorBehavior4452);
                    	    lv_detectionEvent_13_0=ruleDetectionEvent();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentErrorBehaviorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"detectionEvent",
                    	              		lv_detectionEvent_13_0, 
                    	              		"DetectionEvent");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt40 >= 1 ) break loop40;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
                    } while (true);


                    }
                    break;

            }

            otherlv_14=(Token)match(input,31,FOLLOW_31_in_ruleComponentErrorBehavior4467); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getComponentErrorBehaviorAccess().getEndKeyword_8());
                  
            }
            this_SEMI_15=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleComponentErrorBehavior4478); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_15, grammarAccess.getComponentErrorBehaviorAccess().getSEMITerminalRuleCall_9()); 
                  
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
    // $ANTLR end "ruleComponentErrorBehavior"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1997:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1998:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1999:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4514);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName4525); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2006:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (this_DOT_1= RULE_DOT this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_DOT_1=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2009:28: ( (this_ID_0= RULE_ID (this_DOT_1= RULE_DOT this_ID_2= RULE_ID )* ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2010:1: (this_ID_0= RULE_ID (this_DOT_1= RULE_DOT this_ID_2= RULE_ID )* )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2010:1: (this_ID_0= RULE_ID (this_DOT_1= RULE_DOT this_ID_2= RULE_ID )* )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2010:6: this_ID_0= RULE_ID (this_DOT_1= RULE_DOT this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName4565); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2017:1: (this_DOT_1= RULE_DOT this_ID_2= RULE_ID )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_DOT) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2017:6: this_DOT_1= RULE_DOT this_ID_2= RULE_ID
            	    {
            	    this_DOT_1=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleQualifiedName4586); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_DOT_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_DOT_1, grammarAccess.getQualifiedNameAccess().getDOTTerminalRuleCall_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName4606); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2039:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2040:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2041:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard4654);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard4665); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2048:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2051:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2052:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2052:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2053:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard4712);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2063:1: (kw= '.*' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==70) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2064:2: kw= '.*'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleQualifiedNameWithWildCard4731); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                          
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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleTransitionCondition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2077:1: entryRuleTransitionCondition returns [EObject current=null] : iv_ruleTransitionCondition= ruleTransitionCondition EOF ;
    public final EObject entryRuleTransitionCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionCondition = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2078:2: (iv_ruleTransitionCondition= ruleTransitionCondition EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2079:2: iv_ruleTransitionCondition= ruleTransitionCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransitionConditionRule()); 
            }
            pushFollow(FOLLOW_ruleTransitionCondition_in_entryRuleTransitionCondition4773);
            iv_ruleTransitionCondition=ruleTransitionCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransitionCondition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionCondition4783); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionCondition"


    // $ANTLR start "ruleTransitionCondition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2086:1: ruleTransitionCondition returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) ) otherlv_2= 'when' ( (lv_condition_3_0= ruleTriggerConditionExpression ) ) this_SEMI_4= RULE_SEMI ) ;
    public final EObject ruleTransitionCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_mask_1_0=null;
        Token otherlv_2=null;
        Token this_SEMI_4=null;
        EObject lv_condition_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2089:28: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) ) otherlv_2= 'when' ( (lv_condition_3_0= ruleTriggerConditionExpression ) ) this_SEMI_4= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2090:1: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) ) otherlv_2= 'when' ( (lv_condition_3_0= ruleTriggerConditionExpression ) ) this_SEMI_4= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2090:1: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) ) otherlv_2= 'when' ( (lv_condition_3_0= ruleTriggerConditionExpression ) ) this_SEMI_4= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2090:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) ) otherlv_2= 'when' ( (lv_condition_3_0= ruleTriggerConditionExpression ) ) this_SEMI_4= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2090:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                alt44=1;
            }
            else if ( (LA44_0==71) ) {
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
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2090:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2090:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2091:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2091:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2092:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTransitionConditionRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransitionCondition4829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getTransitionConditionAccess().getErrorTransitionTriggeredTransitionCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2104:6: ( (lv_mask_1_0= 'mask' ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2104:6: ( (lv_mask_1_0= 'mask' ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2105:1: (lv_mask_1_0= 'mask' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2105:1: (lv_mask_1_0= 'mask' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2106:3: lv_mask_1_0= 'mask'
                    {
                    lv_mask_1_0=(Token)match(input,71,FOLLOW_71_in_ruleTransitionCondition4853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_mask_1_0, grammarAccess.getTransitionConditionAccess().getMaskMaskKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTransitionConditionRule());
                      	        }
                             		setWithLastConsumed(current, "mask", true, "mask");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,72,FOLLOW_72_in_ruleTransitionCondition4879); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTransitionConditionAccess().getWhenKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2123:1: ( (lv_condition_3_0= ruleTriggerConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2124:1: (lv_condition_3_0= ruleTriggerConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2124:1: (lv_condition_3_0= ruleTriggerConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2125:3: lv_condition_3_0= ruleTriggerConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransitionConditionAccess().getConditionTriggerConditionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerConditionExpression_in_ruleTransitionCondition4900);
            lv_condition_3_0=ruleTriggerConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransitionConditionRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_3_0, 
                      		"TriggerConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_4=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleTransitionCondition4911); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_4, grammarAccess.getTransitionConditionAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleTransitionCondition"


    // $ANTLR start "entryRuleTriggerConditionExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2153:1: entryRuleTriggerConditionExpression returns [EObject current=null] : iv_ruleTriggerConditionExpression= ruleTriggerConditionExpression EOF ;
    public final EObject entryRuleTriggerConditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggerConditionExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2154:2: (iv_ruleTriggerConditionExpression= ruleTriggerConditionExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2155:2: iv_ruleTriggerConditionExpression= ruleTriggerConditionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTriggerConditionExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleTriggerConditionExpression_in_entryRuleTriggerConditionExpression4946);
            iv_ruleTriggerConditionExpression=ruleTriggerConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTriggerConditionExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTriggerConditionExpression4956); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTriggerConditionExpression"


    // $ANTLR start "ruleTriggerConditionExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2162:1: ruleTriggerConditionExpression returns [EObject current=null] : (this_OrExpression_0= ruleOrExpression | this_OrmoreExpression_1= ruleOrmoreExpression | this_OrlessExpression_2= ruleOrlessExpression | this_OthersExpression_3= ruleOthersExpression ) ;
    public final EObject ruleTriggerConditionExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;

        EObject this_OrmoreExpression_1 = null;

        EObject this_OrlessExpression_2 = null;

        EObject this_OthersExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2165:28: ( (this_OrExpression_0= ruleOrExpression | this_OrmoreExpression_1= ruleOrmoreExpression | this_OrlessExpression_2= ruleOrlessExpression | this_OthersExpression_3= ruleOthersExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2166:1: (this_OrExpression_0= ruleOrExpression | this_OrmoreExpression_1= ruleOrmoreExpression | this_OrlessExpression_2= ruleOrlessExpression | this_OthersExpression_3= ruleOthersExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2166:1: (this_OrExpression_0= ruleOrExpression | this_OrmoreExpression_1= ruleOrmoreExpression | this_OrlessExpression_2= ruleOrlessExpression | this_OthersExpression_3= ruleOthersExpression )
            int alt45=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_LPARENS:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 53:
            case 59:
                {
                alt45=1;
                }
                break;
            case RULE_INT:
                {
                int LA45_2 = input.LA(2);

                if ( (LA45_2==75) ) {
                    alt45=2;
                }
                else if ( (LA45_2==76) ) {
                    alt45=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;
                }
                }
                break;
            case 65:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2167:5: this_OrExpression_0= ruleOrExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTriggerConditionExpressionAccess().getOrExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrExpression_in_ruleTriggerConditionExpression5003);
                    this_OrExpression_0=ruleOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2177:5: this_OrmoreExpression_1= ruleOrmoreExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTriggerConditionExpressionAccess().getOrmoreExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrmoreExpression_in_ruleTriggerConditionExpression5030);
                    this_OrmoreExpression_1=ruleOrmoreExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrmoreExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2187:5: this_OrlessExpression_2= ruleOrlessExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTriggerConditionExpressionAccess().getOrlessExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrlessExpression_in_ruleTriggerConditionExpression5057);
                    this_OrlessExpression_2=ruleOrlessExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrlessExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2197:5: this_OthersExpression_3= ruleOthersExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTriggerConditionExpressionAccess().getOthersExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOthersExpression_in_ruleTriggerConditionExpression5084);
                    this_OthersExpression_3=ruleOthersExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OthersExpression_3; 
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
    // $ANTLR end "ruleTriggerConditionExpression"


    // $ANTLR start "entryRuleAndExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2213:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2214:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2215:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression5119);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression5129); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2222:1: ruleAndExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_operands_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2225:28: ( (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) ) )* ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2226:1: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) ) )* )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2226:1: (this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) ) )* )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2227:5: this_Primary_0= rulePrimary ( () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getPrimaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_rulePrimary_in_ruleAndExpression5176);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Primary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2235:1: ( () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==73) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2235:2: () otherlv_2= 'and' ( (lv_operands_3_0= rulePrimary ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2235:2: ()
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2236:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndAdd(
            	                  grammarAccess.getAndExpressionAccess().getAndExpressionOperandsAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,73,FOLLOW_73_in_ruleAndExpression5197); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAndKeyword_1_1());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2245:1: ( (lv_operands_3_0= rulePrimary ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2246:1: (lv_operands_3_0= rulePrimary )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2246:1: (lv_operands_3_0= rulePrimary )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2247:3: lv_operands_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOperandsPrimaryParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimary_in_ruleAndExpression5218);
            	    lv_operands_3_0=rulePrimary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_3_0, 
            	              		"Primary");
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleOrExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2271:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2272:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2273:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression5256);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression5266); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2280:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2283:28: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2284:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2284:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2285:5: this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression5313);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2293:1: ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==74) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2293:2: () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2293:2: ()
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2294:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndAdd(
            	                  grammarAccess.getOrExpressionAccess().getOrExpressionOperandsAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,74,FOLLOW_74_in_ruleOrExpression5334); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getOrKeyword_1_1());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2303:1: ( (lv_operands_3_0= ruleAndExpression ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2304:1: (lv_operands_3_0= ruleAndExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2304:1: (lv_operands_3_0= ruleAndExpression )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2305:3: lv_operands_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrExpressionAccess().getOperandsAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleOrExpression5355);
            	    lv_operands_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_3_0, 
            	              		"AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleOrmoreExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2329:1: entryRuleOrmoreExpression returns [EObject current=null] : iv_ruleOrmoreExpression= ruleOrmoreExpression EOF ;
    public final EObject entryRuleOrmoreExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrmoreExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2330:2: (iv_ruleOrmoreExpression= ruleOrmoreExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2331:2: iv_ruleOrmoreExpression= ruleOrmoreExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrmoreExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOrmoreExpression_in_entryRuleOrmoreExpression5393);
            iv_ruleOrmoreExpression=ruleOrmoreExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrmoreExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrmoreExpression5403); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrmoreExpression"


    // $ANTLR start "ruleOrmoreExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2338:1: ruleOrmoreExpression returns [EObject current=null] : ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) ;
    public final EObject ruleOrmoreExpression() throws RecognitionException {
        EObject current = null;

        Token lv_count_0_0=null;
        Token otherlv_1=null;
        Token this_LPARENS_2=null;
        Token this_COMMA_4=null;
        Token this_RPARENS_6=null;
        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2341:28: ( ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2342:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2342:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2342:2: ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2342:2: ( (lv_count_0_0= RULE_INT ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2343:1: (lv_count_0_0= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2343:1: (lv_count_0_0= RULE_INT )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2344:3: lv_count_0_0= RULE_INT
            {
            lv_count_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrmoreExpression5445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_count_0_0, grammarAccess.getOrmoreExpressionAccess().getCountINTTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOrmoreExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"count",
                      		lv_count_0_0, 
                      		"INT");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,75,FOLLOW_75_in_ruleOrmoreExpression5462); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOrmoreExpressionAccess().getOrmoreKeyword_1());
                  
            }
            this_LPARENS_2=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleOrmoreExpression5473); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPARENS_2, grammarAccess.getOrmoreExpressionAccess().getLPARENSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2368:1: ( (lv_operands_3_0= ruleTriggerConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2369:1: (lv_operands_3_0= ruleTriggerConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2369:1: (lv_operands_3_0= ruleTriggerConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2370:3: lv_operands_3_0= ruleTriggerConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOrmoreExpressionAccess().getOperandsTriggerConditionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerConditionExpression_in_ruleOrmoreExpression5493);
            lv_operands_3_0=ruleTriggerConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOrmoreExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"operands",
                      		lv_operands_3_0, 
                      		"TriggerConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2386:2: (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_COMMA) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2386:3: this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) )
            	    {
            	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleOrmoreExpression5505); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_4, grammarAccess.getOrmoreExpressionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2390:1: ( (lv_operands_5_0= ruleTriggerConditionExpression ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2391:1: (lv_operands_5_0= ruleTriggerConditionExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2391:1: (lv_operands_5_0= ruleTriggerConditionExpression )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2392:3: lv_operands_5_0= ruleTriggerConditionExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrmoreExpressionAccess().getOperandsTriggerConditionExpressionParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTriggerConditionExpression_in_ruleOrmoreExpression5525);
            	    lv_operands_5_0=ruleTriggerConditionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrmoreExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_5_0, 
            	              		"TriggerConditionExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            this_RPARENS_6=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleOrmoreExpression5538); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPARENS_6, grammarAccess.getOrmoreExpressionAccess().getRPARENSTerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleOrmoreExpression"


    // $ANTLR start "entryRuleOrlessExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2420:1: entryRuleOrlessExpression returns [EObject current=null] : iv_ruleOrlessExpression= ruleOrlessExpression EOF ;
    public final EObject entryRuleOrlessExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrlessExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2421:2: (iv_ruleOrlessExpression= ruleOrlessExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2422:2: iv_ruleOrlessExpression= ruleOrlessExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrlessExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOrlessExpression_in_entryRuleOrlessExpression5573);
            iv_ruleOrlessExpression=ruleOrlessExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrlessExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrlessExpression5583); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrlessExpression"


    // $ANTLR start "ruleOrlessExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2429:1: ruleOrlessExpression returns [EObject current=null] : ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) ;
    public final EObject ruleOrlessExpression() throws RecognitionException {
        EObject current = null;

        Token lv_count_0_0=null;
        Token otherlv_1=null;
        Token this_LPARENS_2=null;
        Token this_COMMA_4=null;
        Token this_RPARENS_6=null;
        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2432:28: ( ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2433:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2433:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2433:2: ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleTriggerConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2433:2: ( (lv_count_0_0= RULE_INT ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2434:1: (lv_count_0_0= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2434:1: (lv_count_0_0= RULE_INT )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2435:3: lv_count_0_0= RULE_INT
            {
            lv_count_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrlessExpression5625); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_count_0_0, grammarAccess.getOrlessExpressionAccess().getCountINTTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOrlessExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"count",
                      		lv_count_0_0, 
                      		"INT");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleOrlessExpression5642); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOrlessExpressionAccess().getOrlessKeyword_1());
                  
            }
            this_LPARENS_2=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleOrlessExpression5653); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPARENS_2, grammarAccess.getOrlessExpressionAccess().getLPARENSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2459:1: ( (lv_operands_3_0= ruleTriggerConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2460:1: (lv_operands_3_0= ruleTriggerConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2460:1: (lv_operands_3_0= ruleTriggerConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2461:3: lv_operands_3_0= ruleTriggerConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOrlessExpressionAccess().getOperandsTriggerConditionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerConditionExpression_in_ruleOrlessExpression5673);
            lv_operands_3_0=ruleTriggerConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOrlessExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"operands",
                      		lv_operands_3_0, 
                      		"TriggerConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2477:2: (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_COMMA) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2477:3: this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleTriggerConditionExpression ) )
            	    {
            	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleOrlessExpression5685); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_4, grammarAccess.getOrlessExpressionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2481:1: ( (lv_operands_5_0= ruleTriggerConditionExpression ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2482:1: (lv_operands_5_0= ruleTriggerConditionExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2482:1: (lv_operands_5_0= ruleTriggerConditionExpression )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2483:3: lv_operands_5_0= ruleTriggerConditionExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrlessExpressionAccess().getOperandsTriggerConditionExpressionParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTriggerConditionExpression_in_ruleOrlessExpression5705);
            	    lv_operands_5_0=ruleTriggerConditionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrlessExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_5_0, 
            	              		"TriggerConditionExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            this_RPARENS_6=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleOrlessExpression5718); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPARENS_6, grammarAccess.getOrlessExpressionAccess().getRPARENSTerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleOrlessExpression"


    // $ANTLR start "entryRuleOthersExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2511:1: entryRuleOthersExpression returns [EObject current=null] : iv_ruleOthersExpression= ruleOthersExpression EOF ;
    public final EObject entryRuleOthersExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOthersExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2512:2: (iv_ruleOthersExpression= ruleOthersExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2513:2: iv_ruleOthersExpression= ruleOthersExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOthersExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOthersExpression_in_entryRuleOthersExpression5753);
            iv_ruleOthersExpression=ruleOthersExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOthersExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOthersExpression5763); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOthersExpression"


    // $ANTLR start "ruleOthersExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2520:1: ruleOthersExpression returns [EObject current=null] : ( () otherlv_1= 'others' ) ;
    public final EObject ruleOthersExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2523:28: ( ( () otherlv_1= 'others' ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2524:1: ( () otherlv_1= 'others' )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2524:1: ( () otherlv_1= 'others' )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2524:2: () otherlv_1= 'others'
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2524:2: ()
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2525:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getOthersExpressionAccess().getOthersExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleOthersExpression5809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOthersExpressionAccess().getOthersKeyword_1());
                  
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
    // $ANTLR end "ruleOthersExpression"


    // $ANTLR start "entryRulePrimary"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2542:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2543:2: (iv_rulePrimary= rulePrimary EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2544:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary5845);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary5855); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2551:1: rulePrimary returns [EObject current=null] : (this_ErrorEventReference_0= ruleErrorEventReference | this_ErrorPropagationReference_1= ruleErrorPropagationReference | this_WorkingReference_2= ruleWorkingReference | (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS ) ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token this_LPARENS_3=null;
        Token this_RPARENS_5=null;
        EObject this_ErrorEventReference_0 = null;

        EObject this_ErrorPropagationReference_1 = null;

        EObject this_WorkingReference_2 = null;

        EObject this_TriggerConditionExpression_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2554:28: ( (this_ErrorEventReference_0= ruleErrorEventReference | this_ErrorPropagationReference_1= ruleErrorPropagationReference | this_WorkingReference_2= ruleWorkingReference | (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2555:1: (this_ErrorEventReference_0= ruleErrorEventReference | this_ErrorPropagationReference_1= ruleErrorPropagationReference | this_WorkingReference_2= ruleWorkingReference | (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS ) )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2555:1: (this_ErrorEventReference_0= ruleErrorEventReference | this_ErrorPropagationReference_1= ruleErrorPropagationReference | this_WorkingReference_2= ruleWorkingReference | (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS ) )
            int alt50=4;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2556:5: this_ErrorEventReference_0= ruleErrorEventReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getErrorEventReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleErrorEventReference_in_rulePrimary5902);
                    this_ErrorEventReference_0=ruleErrorEventReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ErrorEventReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2566:5: this_ErrorPropagationReference_1= ruleErrorPropagationReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getErrorPropagationReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleErrorPropagationReference_in_rulePrimary5929);
                    this_ErrorPropagationReference_1=ruleErrorPropagationReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ErrorPropagationReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2576:5: this_WorkingReference_2= ruleWorkingReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getWorkingReferenceParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleWorkingReference_in_rulePrimary5956);
                    this_WorkingReference_2=ruleWorkingReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WorkingReference_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2585:6: (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2585:6: (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2585:7: this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS
                    {
                    this_LPARENS_3=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_rulePrimary5973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_LPARENS_3, grammarAccess.getPrimaryAccess().getLPARENSTerminalRuleCall_3_0()); 
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryAccess().getTriggerConditionExpressionParserRuleCall_3_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTriggerConditionExpression_in_rulePrimary5994);
                    this_TriggerConditionExpression_4=ruleTriggerConditionExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TriggerConditionExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    this_RPARENS_5=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_rulePrimary6004); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_RPARENS_5, grammarAccess.getPrimaryAccess().getRPARENSTerminalRuleCall_3_2()); 
                          
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
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleErrorEventReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2610:1: entryRuleErrorEventReference returns [EObject current=null] : iv_ruleErrorEventReference= ruleErrorEventReference EOF ;
    public final EObject entryRuleErrorEventReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorEventReference = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2611:2: (iv_ruleErrorEventReference= ruleErrorEventReference EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2612:2: iv_ruleErrorEventReference= ruleErrorEventReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorEventReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleErrorEventReference_in_entryRuleErrorEventReference6040);
            iv_ruleErrorEventReference=ruleErrorEventReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorEventReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleErrorEventReference6050); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorEventReference"


    // $ANTLR start "ruleErrorEventReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2619:1: ruleErrorEventReference returns [EObject current=null] : (otherlv_0= 'event' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleErrorEventReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2622:28: ( (otherlv_0= 'event' ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2623:1: (otherlv_0= 'event' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2623:1: (otherlv_0= 'event' ( (otherlv_1= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2623:3: otherlv_0= 'event' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleErrorEventReference6087); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getErrorEventReferenceAccess().getEventKeyword_0());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2627:1: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2628:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2628:1: (otherlv_1= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2629:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getErrorEventReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErrorEventReference6107); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getErrorEventReferenceAccess().getReferenceErrorBehaviorEventCrossReference_1_0()); 
              	
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
    // $ANTLR end "ruleErrorEventReference"


    // $ANTLR start "entryRuleWorkingReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2648:1: entryRuleWorkingReference returns [EObject current=null] : iv_ruleWorkingReference= ruleWorkingReference EOF ;
    public final EObject entryRuleWorkingReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkingReference = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2649:2: (iv_ruleWorkingReference= ruleWorkingReference EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2650:2: iv_ruleWorkingReference= ruleWorkingReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWorkingReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleWorkingReference_in_entryRuleWorkingReference6143);
            iv_ruleWorkingReference=ruleWorkingReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWorkingReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWorkingReference6153); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkingReference"


    // $ANTLR start "ruleWorkingReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2657:1: ruleWorkingReference returns [EObject current=null] : ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (lv_working_4_0= 'working' ) ) this_RBRACKET_5= RULE_RBRACKET ) ;
    public final EObject ruleWorkingReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_self_2_0=null;
        Token this_LBRACKET_3=null;
        Token lv_working_4_0=null;
        Token this_RBRACKET_5=null;
        AntlrDatatypeRuleToken lv_binding_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2660:28: ( ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (lv_working_4_0= 'working' ) ) this_RBRACKET_5= RULE_RBRACKET ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2661:1: ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (lv_working_4_0= 'working' ) ) this_RBRACKET_5= RULE_RBRACKET )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2661:1: ( ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (lv_working_4_0= 'working' ) ) this_RBRACKET_5= RULE_RBRACKET )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2661:2: ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) ) this_LBRACKET_3= RULE_LBRACKET ( (lv_working_4_0= 'working' ) ) this_RBRACKET_5= RULE_RBRACKET
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2661:2: ( ( (lv_binding_0_0= ruleBindingKind ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_self_2_0= 'self' ) ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt51=1;
                }
                break;
            case RULE_ID:
                {
                alt51=2;
                }
                break;
            case 53:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2661:3: ( (lv_binding_0_0= ruleBindingKind ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2661:3: ( (lv_binding_0_0= ruleBindingKind ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2662:1: (lv_binding_0_0= ruleBindingKind )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2662:1: (lv_binding_0_0= ruleBindingKind )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2663:3: lv_binding_0_0= ruleBindingKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWorkingReferenceAccess().getBindingBindingKindParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBindingKind_in_ruleWorkingReference6200);
                    lv_binding_0_0=ruleBindingKind();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWorkingReferenceRule());
                      	        }
                             		set(
                             			current, 
                             			"binding",
                              		lv_binding_0_0, 
                              		"BindingKind");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2680:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2680:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2681:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2681:1: (otherlv_1= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2682:3: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getWorkingReferenceRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWorkingReference6226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getWorkingReferenceAccess().getFeatureFeatureCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2694:6: ( (lv_self_2_0= 'self' ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2694:6: ( (lv_self_2_0= 'self' ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2695:1: (lv_self_2_0= 'self' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2695:1: (lv_self_2_0= 'self' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2696:3: lv_self_2_0= 'self'
                    {
                    lv_self_2_0=(Token)match(input,53,FOLLOW_53_in_ruleWorkingReference6250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_self_2_0, grammarAccess.getWorkingReferenceAccess().getSelfSelfKeyword_0_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getWorkingReferenceRule());
                      	        }
                             		setWithLastConsumed(current, "self", true, "self");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            this_LBRACKET_3=(Token)match(input,RULE_LBRACKET,FOLLOW_RULE_LBRACKET_in_ruleWorkingReference6275); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LBRACKET_3, grammarAccess.getWorkingReferenceAccess().getLBRACKETTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2713:1: ( (lv_working_4_0= 'working' ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2714:1: (lv_working_4_0= 'working' )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2714:1: (lv_working_4_0= 'working' )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2715:3: lv_working_4_0= 'working'
            {
            lv_working_4_0=(Token)match(input,77,FOLLOW_77_in_ruleWorkingReference6292); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_working_4_0, grammarAccess.getWorkingReferenceAccess().getWorkingWorkingKeyword_2_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getWorkingReferenceRule());
              	        }
                     		setWithLastConsumed(current, "working", true, "working");
              	    
            }

            }


            }

            this_RBRACKET_5=(Token)match(input,RULE_RBRACKET,FOLLOW_RULE_RBRACKET_in_ruleWorkingReference6316); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RBRACKET_5, grammarAccess.getWorkingReferenceAccess().getRBRACKETTerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleWorkingReference"


    // $ANTLR start "entryRulePropagationCondition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2740:1: entryRulePropagationCondition returns [EObject current=null] : iv_rulePropagationCondition= rulePropagationCondition EOF ;
    public final EObject entryRulePropagationCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropagationCondition = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2741:2: (iv_rulePropagationCondition= rulePropagationCondition EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2742:2: iv_rulePropagationCondition= rulePropagationCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropagationConditionRule()); 
            }
            pushFollow(FOLLOW_rulePropagationCondition_in_entryRulePropagationCondition6351);
            iv_rulePropagationCondition=rulePropagationCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropagationCondition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropagationCondition6361); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropagationCondition"


    // $ANTLR start "rulePropagationCondition"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2749:1: rulePropagationCondition returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) | ( (lv_working_2_0= 'working' ) ) ) otherlv_3= 'when' ( ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and' )? ( (lv_condition_6_0= ruleTriggerConditionExpression ) ) ( ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )* )? this_SEMI_12= RULE_SEMI ) ;
    public final EObject rulePropagationCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_mask_1_0=null;
        Token lv_working_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token this_COMMA_10=null;
        Token otherlv_11=null;
        Token this_SEMI_12=null;
        EObject lv_condition_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2752:28: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) | ( (lv_working_2_0= 'working' ) ) ) otherlv_3= 'when' ( ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and' )? ( (lv_condition_6_0= ruleTriggerConditionExpression ) ) ( ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )* )? this_SEMI_12= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2753:1: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) | ( (lv_working_2_0= 'working' ) ) ) otherlv_3= 'when' ( ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and' )? ( (lv_condition_6_0= ruleTriggerConditionExpression ) ) ( ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )* )? this_SEMI_12= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2753:1: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) | ( (lv_working_2_0= 'working' ) ) ) otherlv_3= 'when' ( ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and' )? ( (lv_condition_6_0= ruleTriggerConditionExpression ) ) ( ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )* )? this_SEMI_12= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2753:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) | ( (lv_working_2_0= 'working' ) ) ) otherlv_3= 'when' ( ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and' )? ( (lv_condition_6_0= ruleTriggerConditionExpression ) ) ( ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )* )? this_SEMI_12= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2753:2: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_mask_1_0= 'mask' ) ) | ( (lv_working_2_0= 'working' ) ) )
            int alt52=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt52=1;
                }
                break;
            case 71:
                {
                alt52=2;
                }
                break;
            case 77:
                {
                alt52=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2753:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2753:3: ( (otherlv_0= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2754:1: (otherlv_0= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2754:1: (otherlv_0= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2755:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropagationConditionRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropagationCondition6407); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getPropagationConditionAccess().getOutPropagationErrorPropagationCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2767:6: ( (lv_mask_1_0= 'mask' ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2767:6: ( (lv_mask_1_0= 'mask' ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2768:1: (lv_mask_1_0= 'mask' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2768:1: (lv_mask_1_0= 'mask' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2769:3: lv_mask_1_0= 'mask'
                    {
                    lv_mask_1_0=(Token)match(input,71,FOLLOW_71_in_rulePropagationCondition6431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_mask_1_0, grammarAccess.getPropagationConditionAccess().getMaskMaskKeyword_0_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropagationConditionRule());
                      	        }
                             		setWithLastConsumed(current, "mask", true, "mask");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2783:6: ( (lv_working_2_0= 'working' ) )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2783:6: ( (lv_working_2_0= 'working' ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2784:1: (lv_working_2_0= 'working' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2784:1: (lv_working_2_0= 'working' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2785:3: lv_working_2_0= 'working'
                    {
                    lv_working_2_0=(Token)match(input,77,FOLLOW_77_in_rulePropagationCondition6468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_working_2_0, grammarAccess.getPropagationConditionAccess().getWorkingWorkingKeyword_0_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropagationConditionRule());
                      	        }
                             		setWithLastConsumed(current, "working", true, "working");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,72,FOLLOW_72_in_rulePropagationCondition6494); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPropagationConditionAccess().getWhenKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2802:1: ( ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_ID) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==73) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2802:2: ( (otherlv_4= RULE_ID ) ) otherlv_5= 'and'
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2802:2: ( (otherlv_4= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2803:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2803:1: (otherlv_4= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2804:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropagationConditionRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropagationCondition6515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getPropagationConditionAccess().getStateErrorBehaviorStateCrossReference_2_0_0()); 
                      	
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,73,FOLLOW_73_in_rulePropagationCondition6527); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getPropagationConditionAccess().getAndKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2819:3: ( (lv_condition_6_0= ruleTriggerConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2820:1: (lv_condition_6_0= ruleTriggerConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2820:1: (lv_condition_6_0= ruleTriggerConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2821:3: lv_condition_6_0= ruleTriggerConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropagationConditionAccess().getConditionTriggerConditionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerConditionExpression_in_rulePropagationCondition6550);
            lv_condition_6_0=ruleTriggerConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropagationConditionRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_6_0, 
                      		"TriggerConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2837:2: ( ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==42) && (synpred8_InternalErrorModel())) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2837:3: ( ( 'applies' )=>otherlv_7= 'applies' ) otherlv_8= 'to' ( (otherlv_9= RULE_ID ) ) (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2837:3: ( ( 'applies' )=>otherlv_7= 'applies' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2837:4: ( 'applies' )=>otherlv_7= 'applies'
                    {
                    otherlv_7=(Token)match(input,42,FOLLOW_42_in_rulePropagationCondition6571); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getPropagationConditionAccess().getAppliesKeyword_4_0());
                          
                    }

                    }

                    otherlv_8=(Token)match(input,36,FOLLOW_36_in_rulePropagationCondition6584); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getPropagationConditionAccess().getToKeyword_4_1());
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2846:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2847:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2847:1: (otherlv_9= RULE_ID )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2848:3: otherlv_9= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getPropagationConditionRule());
                      	        }
                              
                    }
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropagationCondition6604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_9, grammarAccess.getPropagationConditionAccess().getFeatureFeatureCrossReference_4_2_0()); 
                      	
                    }

                    }


                    }

                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2859:2: (this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==RULE_COMMA) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2859:3: this_COMMA_10= RULE_COMMA ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    this_COMMA_10=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_rulePropagationCondition6616); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COMMA_10, grammarAccess.getPropagationConditionAccess().getCOMMATerminalRuleCall_4_3_0()); 
                    	          
                    	    }
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2863:1: ( (otherlv_11= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2864:1: (otherlv_11= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2864:1: (otherlv_11= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2865:3: otherlv_11= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getPropagationConditionRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropagationCondition6635); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_11, grammarAccess.getPropagationConditionAccess().getFeatureFeatureCrossReference_4_3_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            this_SEMI_12=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePropagationCondition6650); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_12, grammarAccess.getPropagationConditionAccess().getSEMITerminalRuleCall_5()); 
                  
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
    // $ANTLR end "rulePropagationCondition"


    // $ANTLR start "entryRuleDetectionEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2888:1: entryRuleDetectionEvent returns [EObject current=null] : iv_ruleDetectionEvent= ruleDetectionEvent EOF ;
    public final EObject entryRuleDetectionEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDetectionEvent = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2889:2: (iv_ruleDetectionEvent= ruleDetectionEvent EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2890:2: iv_ruleDetectionEvent= ruleDetectionEvent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDetectionEventRule()); 
            }
            pushFollow(FOLLOW_ruleDetectionEvent_in_entryRuleDetectionEvent6685);
            iv_ruleDetectionEvent=ruleDetectionEvent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDetectionEvent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDetectionEvent6695); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDetectionEvent"


    // $ANTLR start "ruleDetectionEvent"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2897:1: ruleDetectionEvent returns [EObject current=null] : ( ( ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) otherlv_3= 'when' ( (lv_condition_4_0= ruleTriggerConditionExpression ) ) this_SEMI_5= RULE_SEMI ) ;
    public final EObject ruleDetectionEvent() throws RecognitionException {
        EObject current = null;

        Token lv_self_0_0=null;
        Token this_DOT_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_5=null;
        EObject lv_condition_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2900:28: ( ( ( ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) otherlv_3= 'when' ( (lv_condition_4_0= ruleTriggerConditionExpression ) ) this_SEMI_5= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2901:1: ( ( ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) otherlv_3= 'when' ( (lv_condition_4_0= ruleTriggerConditionExpression ) ) this_SEMI_5= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2901:1: ( ( ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) otherlv_3= 'when' ( (lv_condition_4_0= ruleTriggerConditionExpression ) ) this_SEMI_5= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2901:2: ( ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT )? ( (otherlv_2= RULE_ID ) ) otherlv_3= 'when' ( (lv_condition_4_0= ruleTriggerConditionExpression ) ) this_SEMI_5= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2901:2: ( ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==53) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2901:3: ( (lv_self_0_0= 'self' ) ) this_DOT_1= RULE_DOT
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2901:3: ( (lv_self_0_0= 'self' ) )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2902:1: (lv_self_0_0= 'self' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2902:1: (lv_self_0_0= 'self' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2903:3: lv_self_0_0= 'self'
                    {
                    lv_self_0_0=(Token)match(input,53,FOLLOW_53_in_ruleDetectionEvent6739); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_self_0_0, grammarAccess.getDetectionEventAccess().getSelfSelfKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getDetectionEventRule());
                      	        }
                             		setWithLastConsumed(current, "self", true, "self");
                      	    
                    }

                    }


                    }

                    this_DOT_1=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleDetectionEvent6763); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOT_1, grammarAccess.getDetectionEventAccess().getDOTTerminalRuleCall_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2920:3: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2921:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2921:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2922:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDetectionEventRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDetectionEvent6784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getDetectionEventAccess().getEventPortFeatureCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_3=(Token)match(input,72,FOLLOW_72_in_ruleDetectionEvent6796); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDetectionEventAccess().getWhenKeyword_2());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2937:1: ( (lv_condition_4_0= ruleTriggerConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2938:1: (lv_condition_4_0= ruleTriggerConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2938:1: (lv_condition_4_0= ruleTriggerConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2939:3: lv_condition_4_0= ruleTriggerConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDetectionEventAccess().getConditionTriggerConditionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTriggerConditionExpression_in_ruleDetectionEvent6817);
            lv_condition_4_0=ruleTriggerConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDetectionEventRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_4_0, 
                      		"TriggerConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleDetectionEvent6828); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getDetectionEventAccess().getSEMITerminalRuleCall_4()); 
                  
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
    // $ANTLR end "ruleDetectionEvent"


    // $ANTLR start "entryRuleCompositeErrorBehavior"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2967:1: entryRuleCompositeErrorBehavior returns [EObject current=null] : iv_ruleCompositeErrorBehavior= ruleCompositeErrorBehavior EOF ;
    public final EObject entryRuleCompositeErrorBehavior() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeErrorBehavior = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2968:2: (iv_ruleCompositeErrorBehavior= ruleCompositeErrorBehavior EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2969:2: iv_ruleCompositeErrorBehavior= ruleCompositeErrorBehavior EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompositeErrorBehaviorRule()); 
            }
            pushFollow(FOLLOW_ruleCompositeErrorBehavior_in_entryRuleCompositeErrorBehavior6863);
            iv_ruleCompositeErrorBehavior=ruleCompositeErrorBehavior();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompositeErrorBehavior; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeErrorBehavior6873); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeErrorBehavior"


    // $ANTLR start "ruleCompositeErrorBehavior"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2976:1: ruleCompositeErrorBehavior returns [EObject current=null] : (otherlv_0= 'composite' otherlv_1= 'error' otherlv_2= 'behavior' otherlv_3= 'use' ( (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_5= RULE_SEMI (otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+ )? otherlv_8= 'end' this_SEMI_9= RULE_SEMI ) ;
    public final EObject ruleCompositeErrorBehavior() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_SEMI_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_SEMI_9=null;
        AntlrDatatypeRuleToken lv_importedNamespace_4_0 = null;

        EObject lv_state_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2979:28: ( (otherlv_0= 'composite' otherlv_1= 'error' otherlv_2= 'behavior' otherlv_3= 'use' ( (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_5= RULE_SEMI (otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+ )? otherlv_8= 'end' this_SEMI_9= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2980:1: (otherlv_0= 'composite' otherlv_1= 'error' otherlv_2= 'behavior' otherlv_3= 'use' ( (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_5= RULE_SEMI (otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+ )? otherlv_8= 'end' this_SEMI_9= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2980:1: (otherlv_0= 'composite' otherlv_1= 'error' otherlv_2= 'behavior' otherlv_3= 'use' ( (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_5= RULE_SEMI (otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+ )? otherlv_8= 'end' this_SEMI_9= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2980:3: otherlv_0= 'composite' otherlv_1= 'error' otherlv_2= 'behavior' otherlv_3= 'use' ( (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard ) ) this_SEMI_5= RULE_SEMI (otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+ )? otherlv_8= 'end' this_SEMI_9= RULE_SEMI
            {
            otherlv_0=(Token)match(input,78,FOLLOW_78_in_ruleCompositeErrorBehavior6910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCompositeErrorBehaviorAccess().getCompositeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleCompositeErrorBehavior6922); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCompositeErrorBehaviorAccess().getErrorKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,66,FOLLOW_66_in_ruleCompositeErrorBehavior6934); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCompositeErrorBehaviorAccess().getBehaviorKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleCompositeErrorBehavior6946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCompositeErrorBehaviorAccess().getUseKeyword_3());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2996:1: ( (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2997:1: (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2997:1: (lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2998:3: lv_importedNamespace_4_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCompositeErrorBehaviorAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleCompositeErrorBehavior6967);
            lv_importedNamespace_4_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCompositeErrorBehaviorRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_4_0, 
                      		"QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_5=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleCompositeErrorBehavior6978); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_5, grammarAccess.getCompositeErrorBehaviorAccess().getSEMITerminalRuleCall_5()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3018:1: (otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+ )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==57) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3018:3: otherlv_6= 'states' ( (lv_state_7_0= ruleCompositeState ) )+
                    {
                    otherlv_6=(Token)match(input,57,FOLLOW_57_in_ruleCompositeErrorBehavior6990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCompositeErrorBehaviorAccess().getStatesKeyword_6_0());
                          
                    }
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3022:1: ( (lv_state_7_0= ruleCompositeState ) )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==RULE_ID) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3023:1: (lv_state_7_0= ruleCompositeState )
                    	    {
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3023:1: (lv_state_7_0= ruleCompositeState )
                    	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3024:3: lv_state_7_0= ruleCompositeState
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCompositeErrorBehaviorAccess().getStateCompositeStateParserRuleCall_6_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleCompositeState_in_ruleCompositeErrorBehavior7011);
                    	    lv_state_7_0=ruleCompositeState();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCompositeErrorBehaviorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"state",
                    	              		lv_state_7_0, 
                    	              		"CompositeState");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt57 >= 1 ) break loop57;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleCompositeErrorBehavior7026); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getCompositeErrorBehaviorAccess().getEndKeyword_7());
                  
            }
            this_SEMI_9=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleCompositeErrorBehavior7037); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_9, grammarAccess.getCompositeErrorBehaviorAccess().getSEMITerminalRuleCall_8()); 
                  
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
    // $ANTLR end "ruleCompositeErrorBehavior"


    // $ANTLR start "entryRuleCompositeState"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3056:1: entryRuleCompositeState returns [EObject current=null] : iv_ruleCompositeState= ruleCompositeState EOF ;
    public final EObject entryRuleCompositeState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeState = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3057:2: (iv_ruleCompositeState= ruleCompositeState EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3058:2: iv_ruleCompositeState= ruleCompositeState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompositeStateRule()); 
            }
            pushFollow(FOLLOW_ruleCompositeState_in_entryRuleCompositeState7072);
            iv_ruleCompositeState=ruleCompositeState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompositeState; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeState7082); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeState"


    // $ANTLR start "ruleCompositeState"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3065:1: ruleCompositeState returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'when' ( (lv_condition_2_0= ruleStateConditionExpression ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject ruleCompositeState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_SEMI_3=null;
        EObject lv_condition_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3068:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'when' ( (lv_condition_2_0= ruleStateConditionExpression ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3069:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'when' ( (lv_condition_2_0= ruleStateConditionExpression ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3069:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= 'when' ( (lv_condition_2_0= ruleStateConditionExpression ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3069:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= 'when' ( (lv_condition_2_0= ruleStateConditionExpression ) ) this_SEMI_3= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3069:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3070:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3070:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3071:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getCompositeStateRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompositeState7127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getCompositeStateAccess().getStateErrorBehaviorStateCrossReference_0_0()); 
              	
            }

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleCompositeState7139); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCompositeStateAccess().getWhenKeyword_1());
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3086:1: ( (lv_condition_2_0= ruleStateConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3087:1: (lv_condition_2_0= ruleStateConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3087:1: (lv_condition_2_0= ruleStateConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3088:3: lv_condition_2_0= ruleStateConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCompositeStateAccess().getConditionStateConditionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateConditionExpression_in_ruleCompositeState7160);
            lv_condition_2_0=ruleStateConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCompositeStateRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_2_0, 
                      		"StateConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_ruleCompositeState7171); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_3, grammarAccess.getCompositeStateAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleCompositeState"


    // $ANTLR start "entryRuleStateConditionExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3116:1: entryRuleStateConditionExpression returns [EObject current=null] : iv_ruleStateConditionExpression= ruleStateConditionExpression EOF ;
    public final EObject entryRuleStateConditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateConditionExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3117:2: (iv_ruleStateConditionExpression= ruleStateConditionExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3118:2: iv_ruleStateConditionExpression= ruleStateConditionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateConditionExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleStateConditionExpression_in_entryRuleStateConditionExpression7206);
            iv_ruleStateConditionExpression=ruleStateConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateConditionExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateConditionExpression7216); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateConditionExpression"


    // $ANTLR start "ruleStateConditionExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3125:1: ruleStateConditionExpression returns [EObject current=null] : (this_OrSExpression_0= ruleOrSExpression | this_OrmoreSExpression_1= ruleOrmoreSExpression | this_OrlessSExpression_2= ruleOrlessSExpression | this_OthersExpression_3= ruleOthersExpression ) ;
    public final EObject ruleStateConditionExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrSExpression_0 = null;

        EObject this_OrmoreSExpression_1 = null;

        EObject this_OrlessSExpression_2 = null;

        EObject this_OthersExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3128:28: ( (this_OrSExpression_0= ruleOrSExpression | this_OrmoreSExpression_1= ruleOrmoreSExpression | this_OrlessSExpression_2= ruleOrlessSExpression | this_OthersExpression_3= ruleOthersExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3129:1: (this_OrSExpression_0= ruleOrSExpression | this_OrmoreSExpression_1= ruleOrmoreSExpression | this_OrlessSExpression_2= ruleOrlessSExpression | this_OthersExpression_3= ruleOthersExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3129:1: (this_OrSExpression_0= ruleOrSExpression | this_OrmoreSExpression_1= ruleOrmoreSExpression | this_OrlessSExpression_2= ruleOrlessSExpression | this_OthersExpression_3= ruleOthersExpression )
            int alt59=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_LPARENS:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 53:
            case 59:
                {
                alt59=1;
                }
                break;
            case RULE_INT:
                {
                int LA59_2 = input.LA(2);

                if ( (LA59_2==76) ) {
                    alt59=3;
                }
                else if ( (LA59_2==75) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;
                }
                }
                break;
            case 65:
                {
                alt59=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3130:5: this_OrSExpression_0= ruleOrSExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStateConditionExpressionAccess().getOrSExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrSExpression_in_ruleStateConditionExpression7263);
                    this_OrSExpression_0=ruleOrSExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrSExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3140:5: this_OrmoreSExpression_1= ruleOrmoreSExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStateConditionExpressionAccess().getOrmoreSExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrmoreSExpression_in_ruleStateConditionExpression7290);
                    this_OrmoreSExpression_1=ruleOrmoreSExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrmoreSExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3150:5: this_OrlessSExpression_2= ruleOrlessSExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStateConditionExpressionAccess().getOrlessSExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOrlessSExpression_in_ruleStateConditionExpression7317);
                    this_OrlessSExpression_2=ruleOrlessSExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OrlessSExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3160:5: this_OthersExpression_3= ruleOthersExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStateConditionExpressionAccess().getOthersExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleOthersExpression_in_ruleStateConditionExpression7344);
                    this_OthersExpression_3=ruleOthersExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_OthersExpression_3; 
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
    // $ANTLR end "ruleStateConditionExpression"


    // $ANTLR start "entryRuleOrSExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3178:1: entryRuleOrSExpression returns [EObject current=null] : iv_ruleOrSExpression= ruleOrSExpression EOF ;
    public final EObject entryRuleOrSExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrSExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3179:2: (iv_ruleOrSExpression= ruleOrSExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3180:2: iv_ruleOrSExpression= ruleOrSExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrSExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOrSExpression_in_entryRuleOrSExpression7381);
            iv_ruleOrSExpression=ruleOrSExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrSExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrSExpression7391); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrSExpression"


    // $ANTLR start "ruleOrSExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3187:1: ruleOrSExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrSExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3190:28: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3191:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3191:1: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )* )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3192:5: this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getOrSExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpression_in_ruleOrSExpression7438);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3200:1: ( () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==74) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3200:2: () otherlv_2= 'or' ( (lv_operands_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3200:2: ()
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3201:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndAdd(
            	                  grammarAccess.getOrSExpressionAccess().getOrExpressionOperandsAction_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_2=(Token)match(input,74,FOLLOW_74_in_ruleOrSExpression7459); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getOrSExpressionAccess().getOrKeyword_1_1());
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3210:1: ( (lv_operands_3_0= ruleAndExpression ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3211:1: (lv_operands_3_0= ruleAndExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3211:1: (lv_operands_3_0= ruleAndExpression )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3212:3: lv_operands_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrSExpressionAccess().getOperandsAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleOrSExpression7480);
            	    lv_operands_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrSExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_3_0, 
            	              		"AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
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
    // $ANTLR end "ruleOrSExpression"


    // $ANTLR start "entryRuleOrmoreSExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3236:1: entryRuleOrmoreSExpression returns [EObject current=null] : iv_ruleOrmoreSExpression= ruleOrmoreSExpression EOF ;
    public final EObject entryRuleOrmoreSExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrmoreSExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3237:2: (iv_ruleOrmoreSExpression= ruleOrmoreSExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3238:2: iv_ruleOrmoreSExpression= ruleOrmoreSExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrmoreSExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOrmoreSExpression_in_entryRuleOrmoreSExpression7518);
            iv_ruleOrmoreSExpression=ruleOrmoreSExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrmoreSExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrmoreSExpression7528); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrmoreSExpression"


    // $ANTLR start "ruleOrmoreSExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3245:1: ruleOrmoreSExpression returns [EObject current=null] : ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) ;
    public final EObject ruleOrmoreSExpression() throws RecognitionException {
        EObject current = null;

        Token lv_count_0_0=null;
        Token otherlv_1=null;
        Token this_LPARENS_2=null;
        Token this_COMMA_4=null;
        Token this_RPARENS_6=null;
        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3248:28: ( ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3249:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3249:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3249:2: ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'ormore' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3249:2: ( (lv_count_0_0= RULE_INT ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3250:1: (lv_count_0_0= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3250:1: (lv_count_0_0= RULE_INT )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3251:3: lv_count_0_0= RULE_INT
            {
            lv_count_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrmoreSExpression7570); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_count_0_0, grammarAccess.getOrmoreSExpressionAccess().getCountINTTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOrmoreSExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"count",
                      		lv_count_0_0, 
                      		"INT");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,75,FOLLOW_75_in_ruleOrmoreSExpression7587); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOrmoreSExpressionAccess().getOrmoreKeyword_1());
                  
            }
            this_LPARENS_2=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleOrmoreSExpression7598); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPARENS_2, grammarAccess.getOrmoreSExpressionAccess().getLPARENSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3275:1: ( (lv_operands_3_0= ruleStateConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3276:1: (lv_operands_3_0= ruleStateConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3276:1: (lv_operands_3_0= ruleStateConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3277:3: lv_operands_3_0= ruleStateConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOrmoreSExpressionAccess().getOperandsStateConditionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateConditionExpression_in_ruleOrmoreSExpression7618);
            lv_operands_3_0=ruleStateConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOrmoreSExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"operands",
                      		lv_operands_3_0, 
                      		"StateConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3293:2: (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_COMMA) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3293:3: this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) )
            	    {
            	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleOrmoreSExpression7630); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_4, grammarAccess.getOrmoreSExpressionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3297:1: ( (lv_operands_5_0= ruleStateConditionExpression ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3298:1: (lv_operands_5_0= ruleStateConditionExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3298:1: (lv_operands_5_0= ruleStateConditionExpression )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3299:3: lv_operands_5_0= ruleStateConditionExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrmoreSExpressionAccess().getOperandsStateConditionExpressionParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStateConditionExpression_in_ruleOrmoreSExpression7650);
            	    lv_operands_5_0=ruleStateConditionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrmoreSExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_5_0, 
            	              		"StateConditionExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            this_RPARENS_6=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleOrmoreSExpression7663); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPARENS_6, grammarAccess.getOrmoreSExpressionAccess().getRPARENSTerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleOrmoreSExpression"


    // $ANTLR start "entryRuleOrlessSExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3327:1: entryRuleOrlessSExpression returns [EObject current=null] : iv_ruleOrlessSExpression= ruleOrlessSExpression EOF ;
    public final EObject entryRuleOrlessSExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrlessSExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3328:2: (iv_ruleOrlessSExpression= ruleOrlessSExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3329:2: iv_ruleOrlessSExpression= ruleOrlessSExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrlessSExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleOrlessSExpression_in_entryRuleOrlessSExpression7698);
            iv_ruleOrlessSExpression=ruleOrlessSExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrlessSExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrlessSExpression7708); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrlessSExpression"


    // $ANTLR start "ruleOrlessSExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3336:1: ruleOrlessSExpression returns [EObject current=null] : ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) ;
    public final EObject ruleOrlessSExpression() throws RecognitionException {
        EObject current = null;

        Token lv_count_0_0=null;
        Token otherlv_1=null;
        Token this_LPARENS_2=null;
        Token this_COMMA_4=null;
        Token this_RPARENS_6=null;
        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3339:28: ( ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3340:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3340:1: ( ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3340:2: ( (lv_count_0_0= RULE_INT ) ) otherlv_1= 'orless' this_LPARENS_2= RULE_LPARENS ( (lv_operands_3_0= ruleStateConditionExpression ) ) (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )* this_RPARENS_6= RULE_RPARENS
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3340:2: ( (lv_count_0_0= RULE_INT ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3341:1: (lv_count_0_0= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3341:1: (lv_count_0_0= RULE_INT )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3342:3: lv_count_0_0= RULE_INT
            {
            lv_count_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOrlessSExpression7750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_count_0_0, grammarAccess.getOrlessSExpressionAccess().getCountINTTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getOrlessSExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"count",
                      		lv_count_0_0, 
                      		"INT");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,76,FOLLOW_76_in_ruleOrlessSExpression7767); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getOrlessSExpressionAccess().getOrlessKeyword_1());
                  
            }
            this_LPARENS_2=(Token)match(input,RULE_LPARENS,FOLLOW_RULE_LPARENS_in_ruleOrlessSExpression7778); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LPARENS_2, grammarAccess.getOrlessSExpressionAccess().getLPARENSTerminalRuleCall_2()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3366:1: ( (lv_operands_3_0= ruleStateConditionExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3367:1: (lv_operands_3_0= ruleStateConditionExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3367:1: (lv_operands_3_0= ruleStateConditionExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3368:3: lv_operands_3_0= ruleStateConditionExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOrlessSExpressionAccess().getOperandsStateConditionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleStateConditionExpression_in_ruleOrlessSExpression7798);
            lv_operands_3_0=ruleStateConditionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getOrlessSExpressionRule());
              	        }
                     		add(
                     			current, 
                     			"operands",
                      		lv_operands_3_0, 
                      		"StateConditionExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3384:2: (this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_COMMA) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3384:3: this_COMMA_4= RULE_COMMA ( (lv_operands_5_0= ruleStateConditionExpression ) )
            	    {
            	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleOrlessSExpression7810); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_4, grammarAccess.getOrlessSExpressionAccess().getCOMMATerminalRuleCall_4_0()); 
            	          
            	    }
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3388:1: ( (lv_operands_5_0= ruleStateConditionExpression ) )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3389:1: (lv_operands_5_0= ruleStateConditionExpression )
            	    {
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3389:1: (lv_operands_5_0= ruleStateConditionExpression )
            	    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3390:3: lv_operands_5_0= ruleStateConditionExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOrlessSExpressionAccess().getOperandsStateConditionExpressionParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStateConditionExpression_in_ruleOrlessSExpression7830);
            	    lv_operands_5_0=ruleStateConditionExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOrlessSExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operands",
            	              		lv_operands_5_0, 
            	              		"StateConditionExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            this_RPARENS_6=(Token)match(input,RULE_RPARENS,FOLLOW_RULE_RPARENS_in_ruleOrlessSExpression7843); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RPARENS_6, grammarAccess.getOrlessSExpressionAccess().getRPARENSTerminalRuleCall_5()); 
                  
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
    // $ANTLR end "ruleOrlessSExpression"


    // $ANTLR start "entryRuleSubcomponentStateReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3420:1: entryRuleSubcomponentStateReference returns [EObject current=null] : iv_ruleSubcomponentStateReference= ruleSubcomponentStateReference EOF ;
    public final EObject entryRuleSubcomponentStateReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubcomponentStateReference = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3421:2: (iv_ruleSubcomponentStateReference= ruleSubcomponentStateReference EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3422:2: iv_ruleSubcomponentStateReference= ruleSubcomponentStateReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubcomponentStateReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleSubcomponentStateReference_in_entryRuleSubcomponentStateReference7880);
            iv_ruleSubcomponentStateReference=ruleSubcomponentStateReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubcomponentStateReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubcomponentStateReference7890); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubcomponentStateReference"


    // $ANTLR start "ruleSubcomponentStateReference"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3429:1: ruleSubcomponentStateReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) this_LBRACKET_1= RULE_LBRACKET ( (otherlv_2= RULE_ID ) ) this_RBRACKET_3= RULE_RBRACKET ) ;
    public final EObject ruleSubcomponentStateReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_LBRACKET_1=null;
        Token otherlv_2=null;
        Token this_RBRACKET_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3432:28: ( ( ( (otherlv_0= RULE_ID ) ) this_LBRACKET_1= RULE_LBRACKET ( (otherlv_2= RULE_ID ) ) this_RBRACKET_3= RULE_RBRACKET ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3433:1: ( ( (otherlv_0= RULE_ID ) ) this_LBRACKET_1= RULE_LBRACKET ( (otherlv_2= RULE_ID ) ) this_RBRACKET_3= RULE_RBRACKET )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3433:1: ( ( (otherlv_0= RULE_ID ) ) this_LBRACKET_1= RULE_LBRACKET ( (otherlv_2= RULE_ID ) ) this_RBRACKET_3= RULE_RBRACKET )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3433:2: ( (otherlv_0= RULE_ID ) ) this_LBRACKET_1= RULE_LBRACKET ( (otherlv_2= RULE_ID ) ) this_RBRACKET_3= RULE_RBRACKET
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3433:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3434:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3434:1: (otherlv_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3435:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSubcomponentStateReferenceRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubcomponentStateReference7935); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getSubcomponentStateReferenceAccess().getSubcomponentFeatureCrossReference_0_0()); 
              	
            }

            }


            }

            this_LBRACKET_1=(Token)match(input,RULE_LBRACKET,FOLLOW_RULE_LBRACKET_in_ruleSubcomponentStateReference7946); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_LBRACKET_1, grammarAccess.getSubcomponentStateReferenceAccess().getLBRACKETTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3450:1: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3451:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3451:1: (otherlv_2= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3452:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSubcomponentStateReferenceRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSubcomponentStateReference7965); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getSubcomponentStateReferenceAccess().getErrortypeErrorBehaviorStateCrossReference_2_0()); 
              	
            }

            }


            }

            this_RBRACKET_3=(Token)match(input,RULE_RBRACKET,FOLLOW_RULE_RBRACKET_in_ruleSubcomponentStateReference7976); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RBRACKET_3, grammarAccess.getSubcomponentStateReferenceAccess().getRBRACKETTerminalRuleCall_3()); 
                  
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
    // $ANTLR end "ruleSubcomponentStateReference"


    // $ANTLR start "entryRulePropertyAssociation"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3475:1: entryRulePropertyAssociation returns [EObject current=null] : iv_rulePropertyAssociation= rulePropertyAssociation EOF ;
    public final EObject entryRulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociation = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3476:2: (iv_rulePropertyAssociation= rulePropertyAssociation EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3477:2: iv_rulePropertyAssociation= rulePropertyAssociation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAssociationRule()); 
            }
            pushFollow(FOLLOW_rulePropertyAssociation_in_entryRulePropertyAssociation8011);
            iv_rulePropertyAssociation=rulePropertyAssociation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAssociation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAssociation8021); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssociation"


    // $ANTLR start "rulePropertyAssociation"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3484:1: rulePropertyAssociation returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( (lv_value_2_0= rulePropertyExpression ) ) this_SEMI_3= RULE_SEMI ) ;
    public final EObject rulePropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_ASSIGN_1=null;
        Token this_SEMI_3=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3487:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( (lv_value_2_0= rulePropertyExpression ) ) this_SEMI_3= RULE_SEMI ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3488:1: ( ( (lv_name_0_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( (lv_value_2_0= rulePropertyExpression ) ) this_SEMI_3= RULE_SEMI )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3488:1: ( ( (lv_name_0_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( (lv_value_2_0= rulePropertyExpression ) ) this_SEMI_3= RULE_SEMI )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3488:2: ( (lv_name_0_0= RULE_ID ) ) this_ASSIGN_1= RULE_ASSIGN ( (lv_value_2_0= rulePropertyExpression ) ) this_SEMI_3= RULE_SEMI
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3488:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3489:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3489:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3490:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociation8063); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getPropertyAssociationAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyAssociationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }

            this_ASSIGN_1=(Token)match(input,RULE_ASSIGN,FOLLOW_RULE_ASSIGN_in_rulePropertyAssociation8079); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ASSIGN_1, grammarAccess.getPropertyAssociationAccess().getASSIGNTerminalRuleCall_1()); 
                  
            }
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3510:1: ( (lv_value_2_0= rulePropertyExpression ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3511:1: (lv_value_2_0= rulePropertyExpression )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3511:1: (lv_value_2_0= rulePropertyExpression )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3512:3: lv_value_2_0= rulePropertyExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAssociationAccess().getValuePropertyExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_rulePropertyAssociation8099);
            lv_value_2_0=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyAssociationRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"PropertyExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_SEMI_3=(Token)match(input,RULE_SEMI,FOLLOW_RULE_SEMI_in_rulePropertyAssociation8110); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SEMI_3, grammarAccess.getPropertyAssociationAccess().getSEMITerminalRuleCall_3()); 
                  
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
    // $ANTLR end "rulePropertyAssociation"


    // $ANTLR start "entryRulePropertyExpression"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3540:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3541:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3542:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression8145);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression8155); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3549:1: rulePropertyExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_ProbabilityValue_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3552:28: ( (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3553:1: (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3553:1: (this_Literal_0= ruleLiteral | this_ProbabilityValue_1= ruleProbabilityValue )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                alt63=1;
            }
            else if ( (LA63_0==RULE_INT) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3554:5: this_Literal_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_rulePropertyExpression8202);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Literal_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3564:5: this_ProbabilityValue_1= ruleProbabilityValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPropertyExpressionAccess().getProbabilityValueParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleProbabilityValue_in_rulePropertyExpression8229);
                    this_ProbabilityValue_1=ruleProbabilityValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProbabilityValue_1; 
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


    // $ANTLR start "entryRuleLiteral"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3580:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3581:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3582:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral8264);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral8274); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3589:1: ruleLiteral returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3592:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3593:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3593:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3594:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3594:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3595:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteral8315); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getLiteralAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleProbabilityValue"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3619:1: entryRuleProbabilityValue returns [EObject current=null] : iv_ruleProbabilityValue= ruleProbabilityValue EOF ;
    public final EObject entryRuleProbabilityValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProbabilityValue = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3620:2: (iv_ruleProbabilityValue= ruleProbabilityValue EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3621:2: iv_ruleProbabilityValue= ruleProbabilityValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProbabilityValueRule()); 
            }
            pushFollow(FOLLOW_ruleProbabilityValue_in_entryRuleProbabilityValue8355);
            iv_ruleProbabilityValue=ruleProbabilityValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProbabilityValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleProbabilityValue8365); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3628:1: ruleProbabilityValue returns [EObject current=null] : ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProbabilityValue() throws RecognitionException {
        EObject current = null;

        Token lv_distribution_1_0=null;
        AntlrDatatypeRuleToken lv_number_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3631:28: ( ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3632:1: ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3632:1: ( ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3632:2: ( (lv_number_0_0= ruleREAL ) ) ( (lv_distribution_1_0= RULE_ID ) )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3632:2: ( (lv_number_0_0= ruleREAL ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3633:1: (lv_number_0_0= ruleREAL )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3633:1: (lv_number_0_0= ruleREAL )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3634:3: lv_number_0_0= ruleREAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProbabilityValueAccess().getNumberREALParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleREAL_in_ruleProbabilityValue8411);
            lv_number_0_0=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3650:2: ( (lv_distribution_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3651:1: (lv_distribution_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3651:1: (lv_distribution_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3652:3: lv_distribution_1_0= RULE_ID
            {
            lv_distribution_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleProbabilityValue8428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_distribution_1_0, grammarAccess.getProbabilityValueAccess().getDistributionIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleProbabilityValue"


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3676:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3677:2: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3678:2: iv_ruleREAL= ruleREAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getREALRule()); 
            }
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL8470);
            iv_ruleREAL=ruleREAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREAL.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL8481); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3685:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_DOT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3688:28: ( (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3689:1: (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3689:1: (this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3689:6: this_INT_0= RULE_INT this_DOT_1= RULE_DOT this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL8521); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                  
            }
            this_DOT_1=(Token)match(input,RULE_DOT,FOLLOW_RULE_DOT_in_ruleREAL8541); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DOT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DOT_1, grammarAccess.getREALAccess().getDOTTerminalRuleCall_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL8561); if (state.failed) return current;
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


    // $ANTLR start "entryRuleINAME"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3722:1: entryRuleINAME returns [String current=null] : iv_ruleINAME= ruleINAME EOF ;
    public final String entryRuleINAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINAME = null;


        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3723:2: (iv_ruleINAME= ruleINAME EOF )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3724:2: iv_ruleINAME= ruleINAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getINAMERule()); 
            }
            pushFollow(FOLLOW_ruleINAME_in_entryRuleINAME8611);
            iv_ruleINAME=ruleINAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleINAME.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleINAME8622); if (state.failed) return current;

            }

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
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3731:1: ruleINAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleINAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3734:28: (this_ID_0= RULE_ID )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3735:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINAME8661); if (state.failed) return current;
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


    // $ANTLR start "rulePropagationDirection"
    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3752:1: rulePropagationDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) ) ;
    public final Enumerator rulePropagationDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3754:28: ( ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) ) )
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3755:1: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) )
            {
            // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3755:1: ( (enumLiteral_0= 'in' ) | (enumLiteral_1= 'out' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==79) ) {
                alt64=1;
            }
            else if ( (LA64_0==80) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3755:2: (enumLiteral_0= 'in' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3755:2: (enumLiteral_0= 'in' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3755:4: enumLiteral_0= 'in'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_79_in_rulePropagationDirection8721); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getPropagationDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getPropagationDirectionAccess().getINEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3761:6: (enumLiteral_1= 'out' )
                    {
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3761:6: (enumLiteral_1= 'out' )
                    // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:3761:8: enumLiteral_1= 'out'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_80_in_rulePropagationDirection8738); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getPropagationDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getPropagationDirectionAccess().getOUTEnumLiteralDeclaration_1()); 
                          
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
    // $ANTLR end "rulePropagationDirection"

    // $ANTLR start synpred1_InternalErrorModel
    public final void synpred1_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:579:3: ( 'propagations' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:579:5: 'propagations'
        {
        match(input,37,FOLLOW_37_in_synpred1_InternalErrorModel1191); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalErrorModel

    // $ANTLR start synpred2_InternalErrorModel
    public final void synpred2_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:602:7: ( 'flows' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:602:9: 'flows'
        {
        match(input,39,FOLLOW_39_in_synpred2_InternalErrorModel1237); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalErrorModel

    // $ANTLR start synpred3_InternalErrorModel
    public final void synpred3_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1212:4: ( 'extends' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1212:6: 'extends'
        {
        match(input,55,FOLLOW_55_in_synpred3_InternalErrorModel2673); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalErrorModel

    // $ANTLR start synpred4_InternalErrorModel
    public final void synpred4_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1230:6: ( 'use' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1230:8: 'use'
        {
        match(input,38,FOLLOW_38_in_synpred4_InternalErrorModel2717); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalErrorModel

    // $ANTLR start synpred5_InternalErrorModel
    public final void synpred5_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1257:5: ( 'events' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1257:7: 'events'
        {
        match(input,56,FOLLOW_56_in_synpred5_InternalErrorModel2772); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_InternalErrorModel

    // $ANTLR start synpred6_InternalErrorModel
    public final void synpred6_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1280:7: ( 'states' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1280:9: 'states'
        {
        match(input,57,FOLLOW_57_in_synpred6_InternalErrorModel2818); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_InternalErrorModel

    // $ANTLR start synpred7_InternalErrorModel
    public final void synpred7_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1303:7: ( 'transitions' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:1303:9: 'transitions'
        {
        match(input,58,FOLLOW_58_in_synpred7_InternalErrorModel2864); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_InternalErrorModel

    // $ANTLR start synpred8_InternalErrorModel
    public final void synpred8_InternalErrorModel_fragment() throws RecognitionException {   
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2837:4: ( 'applies' )
        // ../org.osate.xtext.aadl2.errormodel/src-gen/org/osate/xtext/aadl2/errormodel/parser/antlr/internal/InternalErrorModel.g:2837:6: 'applies'
        {
        match(input,42,FOLLOW_42_in_synpred8_InternalErrorModel6563); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_InternalErrorModel

    // Delegated rules

    public final boolean synpred8_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalErrorModel() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalErrorModel_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA50 dfa50 = new DFA50(this);
    static final String DFA50_eotS =
        "\16\uffff";
    static final String DFA50_eofS =
        "\16\uffff";
    static final String DFA50_minS =
        "\1\6\1\uffff\10\15\1\uffff\1\6\2\uffff";
    static final String DFA50_maxS =
        "\1\73\1\uffff\10\15\1\uffff\1\115\2\uffff";
    static final String DFA50_acceptS =
        "\1\uffff\1\1\10\uffff\1\4\1\uffff\1\2\1\3";
    static final String DFA50_specialS =
        "\16\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\10\2\uffff\1\12\41\uffff\1\2\1\3\1\4\1\5\1\6\1\7\4\uffff"+
            "\1\11\5\uffff\1\1",
            "",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "\1\13",
            "",
            "\1\14\106\uffff\1\15",
            "",
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
            return "2555:1: (this_ErrorEventReference_0= ruleErrorEventReference | this_ErrorPropagationReference_1= ruleErrorPropagationReference | this_WorkingReference_2= ruleWorkingReference | (this_LPARENS_3= RULE_LPARENS this_TriggerConditionExpression_4= ruleTriggerConditionExpression this_RPARENS_5= RULE_RPARENS ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleEM2AnnexSubclause_in_entryRuleEM2AnnexSubclause75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEM2AnnexSubclause85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleEM2AnnexSubclause122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_EM_in_ruleEM2AnnexSubclause133 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleEM2AnnexSubclause144 = new BitSet(new long[]{0x0000000140000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleErrorTypeSet_in_ruleEM2AnnexSubclause166 = new BitSet(new long[]{0x0000000160000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleErrorBehaviorStateMachine_in_ruleEM2AnnexSubclause193 = new BitSet(new long[]{0x0000000160000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleErrorPropagations_in_ruleEM2AnnexSubclause220 = new BitSet(new long[]{0x0000000160000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleComponentErrorBehavior_in_ruleEM2AnnexSubclause247 = new BitSet(new long[]{0x0000000160000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_ruleCompositeErrorBehavior_in_ruleEM2AnnexSubclause274 = new BitSet(new long[]{0x0000000160000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_29_in_ruleEM2AnnexSubclause288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleEM2AnnexSubclause299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorTypeSet_in_entryRuleErrorTypeSet334 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorTypeSet344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleErrorTypeSet381 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorTypeSet398 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleErrorType_in_ruleErrorTypeSet424 = new BitSet(new long[]{0x0000000480000040L});
    public static final BitSet FOLLOW_ruleFeature_in_ruleErrorTypeSet446 = new BitSet(new long[]{0x0000000480000000L});
    public static final BitSet FOLLOW_31_in_ruleErrorTypeSet459 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorTypeSet470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorTypeSet480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorType_in_entryRuleErrorType517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorType527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorType569 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleErrorType585 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleErrorType596 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleErrorType608 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_RULE_ASSIGN_in_ruleErrorType620 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleErrorType630 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorType649 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleErrorType661 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorType680 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleErrorType693 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorType705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeature750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFeature787 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeature804 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleFeature820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorTypeRefinement_in_entryRuleErrorTypeRefinement855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorTypeRefinement865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorTypeRefinement910 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleErrorTypeRefinement921 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleErrorTypeRefinement932 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleErrorTypeRefinement944 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_APPEND_in_ruleErrorTypeRefinement956 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleErrorTypeRefinement966 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorTypeRefinement985 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleErrorTypeRefinement997 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorTypeRefinement1016 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleErrorTypeRefinement1029 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorTypeRefinement1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorPropagations_in_entryRuleErrorPropagations1076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorPropagations1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleErrorPropagations1123 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleErrorPropagations1135 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleErrorPropagations1147 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleErrorPropagations1168 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorPropagations1179 = new BitSet(new long[]{0x000000A080000000L});
    public static final BitSet FOLLOW_37_in_ruleErrorPropagations1199 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleErrorPropagation_in_ruleErrorPropagations1221 = new BitSet(new long[]{0x0000008080000040L});
    public static final BitSet FOLLOW_39_in_ruleErrorPropagations1245 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ruleErrorFlow_in_ruleErrorPropagations1267 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_31_in_ruleErrorPropagations1282 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorPropagations1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorPropagation_in_entryRuleErrorPropagation1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorPropagation1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorPropagation1383 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleErrorPropagation1394 = new BitSet(new long[]{0x0000030000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_40_in_ruleErrorPropagation1411 = new BitSet(new long[]{0x0000020000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_rulePropagationDirection_in_ruleErrorPropagation1446 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleErrorPropagation1459 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleErrorPropagation1471 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleErrorPropagation1483 = new BitSet(new long[]{0x0001F80000000040L});
    public static final BitSet FOLLOW_ruleBindingKind_in_ruleErrorPropagation1505 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorPropagation1531 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleErrorPropagation1544 = new BitSet(new long[]{0x0001F80000000040L});
    public static final BitSet FOLLOW_ruleBindingKind_in_ruleErrorPropagation1565 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorPropagation1591 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorPropagation1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingKind_in_entryRuleBindingKind1641 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBindingKind1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleBindingKind1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleBindingKind1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleBindingKind1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleBindingKind1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleBindingKind1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleBindingKind1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorFlow_in_entryRuleErrorFlow1825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorFlow1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorSource_in_ruleErrorFlow1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorSink_in_ruleErrorFlow1909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorPath_in_ruleErrorFlow1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorSource_in_entryRuleErrorSource1971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorSource1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleErrorSource2018 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleErrorSource2030 = new BitSet(new long[]{0x0021F80000000040L});
    public static final BitSet FOLLOW_ruleErrorPropagationReference_in_ruleErrorSource2051 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorSource2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorSink_in_entryRuleErrorSink2097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorSink2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleErrorSink2144 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleErrorSink2156 = new BitSet(new long[]{0x0021F80000000040L});
    public static final BitSet FOLLOW_ruleErrorPropagationReference_in_ruleErrorSink2177 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorSink2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorPath_in_entryRuleErrorPath2223 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorPath2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleErrorPath2270 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleErrorPath2282 = new BitSet(new long[]{0x0021F80000000040L});
    public static final BitSet FOLLOW_ruleErrorPropagationReference_in_ruleErrorPath2303 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleErrorPath2315 = new BitSet(new long[]{0x0021F80000000040L});
    public static final BitSet FOLLOW_ruleErrorPropagationReference_in_ruleErrorPath2336 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorPath2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorPropagationReference_in_entryRuleErrorPropagationReference2382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorPropagationReference2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingKind_in_ruleErrorPropagationReference2439 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorPropagationReference2465 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_53_in_ruleErrorPropagationReference2489 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_LBRACKET_in_ruleErrorPropagationReference2514 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorPropagationReference2533 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_RBRACKET_in_ruleErrorPropagationReference2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorBehaviorStateMachine_in_entryRuleErrorBehaviorStateMachine2579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorBehaviorStateMachine2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleErrorBehaviorStateMachine2626 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleErrorBehaviorStateMachine2638 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorBehaviorStateMachine2655 = new BitSet(new long[]{0x0780004080000000L});
    public static final BitSet FOLLOW_55_in_ruleErrorBehaviorStateMachine2681 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorBehaviorStateMachine2702 = new BitSet(new long[]{0x0700004080000000L});
    public static final BitSet FOLLOW_38_in_ruleErrorBehaviorStateMachine2725 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleErrorBehaviorStateMachine2747 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorBehaviorStateMachine2758 = new BitSet(new long[]{0x0700000080000000L});
    public static final BitSet FOLLOW_56_in_ruleErrorBehaviorStateMachine2780 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleErrorBehaviorEvent_in_ruleErrorBehaviorStateMachine2802 = new BitSet(new long[]{0x0600000080000040L});
    public static final BitSet FOLLOW_57_in_ruleErrorBehaviorStateMachine2826 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleErrorBehaviorState_in_ruleErrorBehaviorStateMachine2848 = new BitSet(new long[]{0x0400000080000040L});
    public static final BitSet FOLLOW_58_in_ruleErrorBehaviorStateMachine2872 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleErrorBehaviorTransition_in_ruleErrorBehaviorStateMachine2894 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_31_in_ruleErrorBehaviorStateMachine2909 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorBehaviorStateMachine2920 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorBehaviorStateMachine2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorBehaviorEvent_in_entryRuleErrorBehaviorEvent2965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorBehaviorEvent2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorEvent_in_ruleErrorBehaviorEvent3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRepairEvent_in_ruleErrorBehaviorEvent3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorEvent_in_entryRuleErrorEvent3084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorEvent3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorEvent3136 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleErrorEvent3152 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleErrorEvent3163 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleErrorEvent3175 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorEvent3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRepairEvent_in_entryRuleRepairEvent3221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRepairEvent3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRepairEvent3273 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleRepairEvent3289 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleRepairEvent3300 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleRepairEvent3312 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleRepairEvent3323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorBehaviorState_in_entryRuleErrorBehaviorState3358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorBehaviorState3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorBehaviorState3410 = new BitSet(new long[]{0x6000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleErrorBehaviorState3433 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleErrorBehaviorState3459 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_LCURLY_in_ruleErrorBehaviorState3471 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_ruleErrorBehaviorState3491 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_RULE_RCURLY_in_ruleErrorBehaviorState3503 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleErrorBehaviorState3515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorBehaviorTransition_in_entryRuleErrorBehaviorTransition3550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorBehaviorTransition3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_ruleErrorBehaviorTransition3607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBranchTransition_in_ruleErrorBehaviorTransition3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggeredTransition_in_entryRuleTriggeredTransition3669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggeredTransition3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3721 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_COLON_in_ruleTriggeredTransition3737 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3756 = new BitSet(new long[]{0x0010000000020000L});
    public static final BitSet FOLLOW_52_in_ruleTriggeredTransition3769 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_LTRANS_in_ruleTriggeredTransition3787 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3806 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleTriggeredTransition3818 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3837 = new BitSet(new long[]{0x0000000000040400L});
    public static final BitSet FOLLOW_RULE_RTRANS_in_ruleTriggeredTransition3850 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTriggeredTransition3871 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleTriggeredTransition3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBranchTransition_in_entryRuleBranchTransition3917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBranchTransition3927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBranchTransition3972 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleBranchTransition3984 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBranchValue_in_ruleBranchTransition4005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleBranchTransition4017 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBranchTransition4037 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleBranchTransition4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBranchValue_in_entryRuleBranchValue4084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBranchValue4095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleBranchValue4142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleBranchValue4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentErrorBehavior_in_entryRuleComponentErrorBehavior4206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentErrorBehavior4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleComponentErrorBehavior4253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleComponentErrorBehavior4265 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleComponentErrorBehavior4277 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleComponentErrorBehavior4298 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleComponentErrorBehavior4309 = new BitSet(new long[]{0x0000020080000000L,0x0000000000000028L});
    public static final BitSet FOLLOW_67_in_ruleComponentErrorBehavior4321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleComponentErrorBehavior4333 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000080L});
    public static final BitSet FOLLOW_ruleTransitionCondition_in_ruleComponentErrorBehavior4354 = new BitSet(new long[]{0x0000020080000040L,0x00000000000000A0L});
    public static final BitSet FOLLOW_41_in_ruleComponentErrorBehavior4370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleComponentErrorBehavior4382 = new BitSet(new long[]{0x0000000000000040L,0x0000000000002080L});
    public static final BitSet FOLLOW_rulePropagationCondition_in_ruleComponentErrorBehavior4403 = new BitSet(new long[]{0x0000000080000040L,0x00000000000020A0L});
    public static final BitSet FOLLOW_69_in_ruleComponentErrorBehavior4419 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleComponentErrorBehavior4431 = new BitSet(new long[]{0x0020000000000040L});
    public static final BitSet FOLLOW_ruleDetectionEvent_in_ruleComponentErrorBehavior4452 = new BitSet(new long[]{0x0020000080000040L});
    public static final BitSet FOLLOW_31_in_ruleComponentErrorBehavior4467 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleComponentErrorBehavior4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName4525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4565 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleQualifiedName4586 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4606 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard4654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard4712 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleQualifiedNameWithWildCard4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionCondition_in_entryRuleTransitionCondition4773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionCondition4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransitionCondition4829 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_71_in_ruleTransitionCondition4853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleTransitionCondition4879 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_ruleTransitionCondition4900 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleTransitionCondition4911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_entryRuleTriggerConditionExpression4946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTriggerConditionExpression4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleTriggerConditionExpression5003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrmoreExpression_in_ruleTriggerConditionExpression5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrlessExpression_in_ruleTriggerConditionExpression5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOthersExpression_in_ruleTriggerConditionExpression5084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression5119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleAndExpression5176 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleAndExpression5197 = new BitSet(new long[]{0x0821F80000000240L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleAndExpression5218 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression5256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression5266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression5313 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleOrExpression5334 = new BitSet(new long[]{0x0821F80000000240L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrExpression5355 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleOrmoreExpression_in_entryRuleOrmoreExpression5393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrmoreExpression5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrmoreExpression5445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleOrmoreExpression5462 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleOrmoreExpression5473 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_ruleOrmoreExpression5493 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleOrmoreExpression5505 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_ruleOrmoreExpression5525 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleOrmoreExpression5538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrlessExpression_in_entryRuleOrlessExpression5573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrlessExpression5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrlessExpression5625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleOrlessExpression5642 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleOrlessExpression5653 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_ruleOrlessExpression5673 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleOrlessExpression5685 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_ruleOrlessExpression5705 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleOrlessExpression5718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOthersExpression_in_entryRuleOthersExpression5753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOthersExpression5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleOthersExpression5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary5845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary5855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorEventReference_in_rulePrimary5902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorPropagationReference_in_rulePrimary5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWorkingReference_in_rulePrimary5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_rulePrimary5973 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_rulePrimary5994 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_rulePrimary6004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErrorEventReference_in_entryRuleErrorEventReference6040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErrorEventReference6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleErrorEventReference6087 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErrorEventReference6107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWorkingReference_in_entryRuleWorkingReference6143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWorkingReference6153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBindingKind_in_ruleWorkingReference6200 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWorkingReference6226 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_53_in_ruleWorkingReference6250 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_LBRACKET_in_ruleWorkingReference6275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleWorkingReference6292 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_RBRACKET_in_ruleWorkingReference6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropagationCondition_in_entryRulePropagationCondition6351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropagationCondition6361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropagationCondition6407 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_71_in_rulePropagationCondition6431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_77_in_rulePropagationCondition6468 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_rulePropagationCondition6494 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropagationCondition6515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_rulePropagationCondition6527 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_rulePropagationCondition6550 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_42_in_rulePropagationCondition6571 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_rulePropagationCondition6584 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropagationCondition6604 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_RULE_COMMA_in_rulePropagationCondition6616 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropagationCondition6635 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePropagationCondition6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDetectionEvent_in_entryRuleDetectionEvent6685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDetectionEvent6695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleDetectionEvent6739 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleDetectionEvent6763 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDetectionEvent6784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleDetectionEvent6796 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTriggerConditionExpression_in_ruleDetectionEvent6817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleDetectionEvent6828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeErrorBehavior_in_entryRuleCompositeErrorBehavior6863 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeErrorBehavior6873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleCompositeErrorBehavior6910 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleCompositeErrorBehavior6922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleCompositeErrorBehavior6934 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleCompositeErrorBehavior6946 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleCompositeErrorBehavior6967 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleCompositeErrorBehavior6978 = new BitSet(new long[]{0x0200000080000000L});
    public static final BitSet FOLLOW_57_in_ruleCompositeErrorBehavior6990 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleCompositeState_in_ruleCompositeErrorBehavior7011 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_31_in_ruleCompositeErrorBehavior7026 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleCompositeErrorBehavior7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeState_in_entryRuleCompositeState7072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeState7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompositeState7127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleCompositeState7139 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateConditionExpression_in_ruleCompositeState7160 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_ruleCompositeState7171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateConditionExpression_in_entryRuleStateConditionExpression7206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateConditionExpression7216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrSExpression_in_ruleStateConditionExpression7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrmoreSExpression_in_ruleStateConditionExpression7290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrlessSExpression_in_ruleStateConditionExpression7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOthersExpression_in_ruleStateConditionExpression7344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrSExpression_in_entryRuleOrSExpression7381 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrSExpression7391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrSExpression7438 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleOrSExpression7459 = new BitSet(new long[]{0x0821F80000000240L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleOrSExpression7480 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleOrmoreSExpression_in_entryRuleOrmoreSExpression7518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrmoreSExpression7528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrmoreSExpression7570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleOrmoreSExpression7587 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleOrmoreSExpression7598 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateConditionExpression_in_ruleOrmoreSExpression7618 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleOrmoreSExpression7630 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateConditionExpression_in_ruleOrmoreSExpression7650 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleOrmoreSExpression7663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrlessSExpression_in_entryRuleOrlessSExpression7698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrlessSExpression7708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOrlessSExpression7750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleOrlessSExpression7767 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_LPARENS_in_ruleOrlessSExpression7778 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateConditionExpression_in_ruleOrlessSExpression7798 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleOrlessSExpression7810 = new BitSet(new long[]{0x0821F80000100240L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateConditionExpression_in_ruleOrlessSExpression7830 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RULE_RPARENS_in_ruleOrlessSExpression7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubcomponentStateReference_in_entryRuleSubcomponentStateReference7880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubcomponentStateReference7890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubcomponentStateReference7935 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_LBRACKET_in_ruleSubcomponentStateReference7946 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSubcomponentStateReference7965 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_RBRACKET_in_ruleSubcomponentStateReference7976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAssociation_in_entryRulePropertyAssociation8011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociation8021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociation8063 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ASSIGN_in_rulePropertyAssociation8079 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyAssociation8099 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_SEMI_in_rulePropertyAssociation8110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression8145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression8155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePropertyExpression8202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProbabilityValue_in_rulePropertyExpression8229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral8264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral8274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteral8315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProbabilityValue_in_entryRuleProbabilityValue8355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProbabilityValue8365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleProbabilityValue8411 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleProbabilityValue8428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL8470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL8481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL8521 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RULE_DOT_in_ruleREAL8541 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL8561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINAME_in_entryRuleINAME8611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINAME8622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINAME8661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_rulePropagationDirection8721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_rulePropagationDirection8738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred1_InternalErrorModel1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_synpred2_InternalErrorModel1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred3_InternalErrorModel2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_synpred4_InternalErrorModel2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred5_InternalErrorModel2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred6_InternalErrorModel2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred7_InternalErrorModel2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_synpred8_InternalErrorModel6563 = new BitSet(new long[]{0x0000000000000002L});

}