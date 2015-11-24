package org.osate.reqspec.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
@SuppressWarnings("all")
public class InternalReqSpecLexer extends Lexer {
    public static final int Val=65;
    public static final int LessThanSignGreaterThanSign=72;
    public static final int RULE_HEX=105;
    public static final int EqualsSignGreaterThanSign=74;
    public static final int Riskindex=25;
    public static final int Memory=42;
    public static final int KW_System=43;
    public static final int Decomposes=15;
    public static final int False=46;
    public static final int Document=28;
    public static final int LessThanSign=90;
    public static final int Goal=51;
    public static final int LeftParenthesis=81;
    public static final int Development=9;
    public static final int ExclamationMark=78;
    public static final int GreaterThanSign=92;
    public static final int RULE_ID=108;
    public static final int RULE_DIGIT=98;
    public static final int GreaterThanSignEqualsSign=75;
    public static final int ColonColon=71;
    public static final int Requirement=11;
    public static final int EqualsSignEqualsSign=73;
    public static final int See=63;
    public static final int PlusSign=84;
    public static final int RULE_INT=106;
    public static final int RULE_ML_COMMENT=110;
    public static final int LeftSquareBracket=94;
    public static final int Mitigates=21;
    public static final int Group=48;
    public static final int Description=8;
    public static final int Processor=23;
    public static final int Attribute=18;
    public static final int Maturityindex=6;
    public static final int Selection=26;
    public static final int VerticalLineVerticalLine=77;
    public static final int RULE_REAL_LIT=101;
    public static final int Comma=85;
    public static final int HyphenMinus=86;
    public static final int QuestionMarkColon=76;
    public static final int Solidus=88;
    public static final int RightCurlyBracket=97;
    public static final int Familiarity=10;
    public static final int Timecriticality=4;
    public static final int Refines=36;
    public static final int Bus=60;
    public static final int FullStop=87;
    public static final int Abstract=27;
    public static final int Use=64;
    public static final int Constants=20;
    public static final int Conflicts=19;
    public static final int Section=37;
    public static final int Thread=44;
    public static final int CommercialAt=93;
    public static final int Type=55;
    public static final int RULE_EXPONENT=99;
    public static final int Delta=45;
    public static final int RULE_EXTENDED_DIGIT=104;
    public static final int ExclamationMarkEqualsSign=66;
    public static final int HyphenMinusGreaterThanSign=69;
    public static final int All=59;
    public static final int Null=52;
    public static final int Include=33;
    public static final int True=54;
    public static final int Process=34;
    public static final int Requirements=7;
    public static final int Global=40;
    public static final int Predicate=22;
    public static final int RULE_INT_EXPONENT=100;
    public static final int PercentSign=80;
    public static final int Stakeholder=12;
    public static final int FullStopFullStop=70;
    public static final int This=53;
    public static final int Scheduleimpact=5;
    public static final int RULE_BASED_INTEGER=102;
    public static final int RightSquareBracket=95;
    public static final int Dropped=31;
    public static final int Img=62;
    public static final int Device=39;
    public static final int For=61;
    public static final int RightParenthesis=82;
    public static final int RULE_DECIMAL=107;
    public static final int NumberSign=79;
    public static final int Value=49;
    public static final int AsteriskAsterisk=68;
    public static final int Subprogram=16;
    public static final int Goals=47;
    public static final int RULE_INTEGER_LIT=103;
    public static final int Uncertainty=13;
    public static final int User=56;
    public static final int Volatility=17;
    public static final int Issues=41;
    public static final int RULE_STRING=109;
    public static final int Costimpact=14;
    public static final int Evolves=32;
    public static final int With=57;
    public static final int RULE_SL_COMMENT=111;
    public static final int EqualsSign=91;
    public static final int AmpersandAmpersand=67;
    public static final int Quality=35;
    public static final int Rationale=24;
    public static final int Colon=89;
    public static final int EOF=-1;
    public static final int Asterisk=83;
    public static final int RULE_WS=112;
    public static final int LeftCurlyBracket=96;
    public static final int Virtual=38;
    public static final int Data=50;
    public static final int RULE_ANY_OTHER=113;
    public static final int FullStopFullStopLessThanSign=58;
    public static final int Informal=29;
    public static final int Compute=30;

    // delegates
    // delegators

    public InternalReqSpecLexer() {;} 
    public InternalReqSpecLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalReqSpecLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g"; }

    // $ANTLR start "Timecriticality"
    public final void mTimecriticality() throws RecognitionException {
        try {
            int _type = Timecriticality;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:17: ( 'timecriticality' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:19: 'timecriticality'
            {
            match("timecriticality"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Timecriticality"

    // $ANTLR start "Scheduleimpact"
    public final void mScheduleimpact() throws RecognitionException {
        try {
            int _type = Scheduleimpact;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:16: ( 'scheduleimpact' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:18: 'scheduleimpact'
            {
            match("scheduleimpact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Scheduleimpact"

    // $ANTLR start "Maturityindex"
    public final void mMaturityindex() throws RecognitionException {
        try {
            int _type = Maturityindex;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:15: ( 'maturityindex' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:17: 'maturityindex'
            {
            match("maturityindex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Maturityindex"

    // $ANTLR start "Requirements"
    public final void mRequirements() throws RecognitionException {
        try {
            int _type = Requirements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:14: ( 'requirements' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:16: 'requirements'
            {
            match("requirements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Requirements"

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:13: ( 'description' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:15: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Description"

    // $ANTLR start "Development"
    public final void mDevelopment() throws RecognitionException {
        try {
            int _type = Development;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:13: ( 'development' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:15: 'development'
            {
            match("development"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Development"

    // $ANTLR start "Familiarity"
    public final void mFamiliarity() throws RecognitionException {
        try {
            int _type = Familiarity;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:13: ( 'familiarity' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:15: 'familiarity'
            {
            match("familiarity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Familiarity"

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:13: ( 'requirement' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:15: 'requirement'
            {
            match("requirement"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Requirement"

    // $ANTLR start "Stakeholder"
    public final void mStakeholder() throws RecognitionException {
        try {
            int _type = Stakeholder;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:13: ( 'stakeholder' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:15: 'stakeholder'
            {
            match("stakeholder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Stakeholder"

    // $ANTLR start "Uncertainty"
    public final void mUncertainty() throws RecognitionException {
        try {
            int _type = Uncertainty;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:13: ( 'uncertainty' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:15: 'uncertainty'
            {
            match("uncertainty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uncertainty"

    // $ANTLR start "Costimpact"
    public final void mCostimpact() throws RecognitionException {
        try {
            int _type = Costimpact;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:12: ( 'costimpact' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:14: 'costimpact'
            {
            match("costimpact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Costimpact"

    // $ANTLR start "Decomposes"
    public final void mDecomposes() throws RecognitionException {
        try {
            int _type = Decomposes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:12: ( 'decomposes' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:14: 'decomposes'
            {
            match("decomposes"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Decomposes"

    // $ANTLR start "Subprogram"
    public final void mSubprogram() throws RecognitionException {
        try {
            int _type = Subprogram;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:12: ( 'subprogram' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:14: 'subprogram'
            {
            match("subprogram"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Subprogram"

    // $ANTLR start "Volatility"
    public final void mVolatility() throws RecognitionException {
        try {
            int _type = Volatility;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:12: ( 'volatility' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:14: 'volatility'
            {
            match("volatility"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Volatility"

    // $ANTLR start "Attribute"
    public final void mAttribute() throws RecognitionException {
        try {
            int _type = Attribute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:11: ( 'attribute' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:13: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Attribute"

    // $ANTLR start "Conflicts"
    public final void mConflicts() throws RecognitionException {
        try {
            int _type = Conflicts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:11: ( 'conflicts' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:13: 'conflicts'
            {
            match("conflicts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Conflicts"

    // $ANTLR start "Constants"
    public final void mConstants() throws RecognitionException {
        try {
            int _type = Constants;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:11: ( 'constants' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:13: 'constants'
            {
            match("constants"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Constants"

    // $ANTLR start "Mitigates"
    public final void mMitigates() throws RecognitionException {
        try {
            int _type = Mitigates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:11: ( 'mitigates' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:13: 'mitigates'
            {
            match("mitigates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mitigates"

    // $ANTLR start "Predicate"
    public final void mPredicate() throws RecognitionException {
        try {
            int _type = Predicate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:11: ( 'predicate' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:13: 'predicate'
            {
            match("predicate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Predicate"

    // $ANTLR start "Processor"
    public final void mProcessor() throws RecognitionException {
        try {
            int _type = Processor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:11: ( 'processor' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:13: 'processor'
            {
            match("processor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Processor"

    // $ANTLR start "Rationale"
    public final void mRationale() throws RecognitionException {
        try {
            int _type = Rationale;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:11: ( 'rationale' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:13: 'rationale'
            {
            match("rationale"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rationale"

    // $ANTLR start "Riskindex"
    public final void mRiskindex() throws RecognitionException {
        try {
            int _type = Riskindex;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:11: ( 'riskindex' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:13: 'riskindex'
            {
            match("riskindex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Riskindex"

    // $ANTLR start "Selection"
    public final void mSelection() throws RecognitionException {
        try {
            int _type = Selection;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:11: ( 'selection' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:13: 'selection'
            {
            match("selection"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Selection"

    // $ANTLR start "Abstract"
    public final void mAbstract() throws RecognitionException {
        try {
            int _type = Abstract;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:10: ( 'abstract' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:12: 'abstract'
            {
            match("abstract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Abstract"

    // $ANTLR start "Document"
    public final void mDocument() throws RecognitionException {
        try {
            int _type = Document;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:10: ( 'document' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:12: 'document'
            {
            match("document"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Document"

    // $ANTLR start "Informal"
    public final void mInformal() throws RecognitionException {
        try {
            int _type = Informal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:10: ( 'informal' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:12: 'informal'
            {
            match("informal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Informal"

    // $ANTLR start "Compute"
    public final void mCompute() throws RecognitionException {
        try {
            int _type = Compute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:9: ( 'compute' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:11: 'compute'
            {
            match("compute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Compute"

    // $ANTLR start "Dropped"
    public final void mDropped() throws RecognitionException {
        try {
            int _type = Dropped;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:9: ( 'dropped' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:11: 'dropped'
            {
            match("dropped"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Dropped"

    // $ANTLR start "Evolves"
    public final void mEvolves() throws RecognitionException {
        try {
            int _type = Evolves;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:9: ( 'evolves' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:11: 'evolves'
            {
            match("evolves"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Evolves"

    // $ANTLR start "Include"
    public final void mInclude() throws RecognitionException {
        try {
            int _type = Include;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:9: ( 'include' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:11: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Include"

    // $ANTLR start "Process"
    public final void mProcess() throws RecognitionException {
        try {
            int _type = Process;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:9: ( 'process' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:11: 'process'
            {
            match("process"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Process"

    // $ANTLR start "Quality"
    public final void mQuality() throws RecognitionException {
        try {
            int _type = Quality;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:9: ( 'quality' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:11: 'quality'
            {
            match("quality"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Quality"

    // $ANTLR start "Refines"
    public final void mRefines() throws RecognitionException {
        try {
            int _type = Refines;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:9: ( 'refines' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:11: 'refines'
            {
            match("refines"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Refines"

    // $ANTLR start "Section"
    public final void mSection() throws RecognitionException {
        try {
            int _type = Section;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:9: ( 'section' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:11: 'section'
            {
            match("section"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Section"

    // $ANTLR start "Virtual"
    public final void mVirtual() throws RecognitionException {
        try {
            int _type = Virtual;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:9: ( 'virtual' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:11: 'virtual'
            {
            match("virtual"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Virtual"

    // $ANTLR start "Device"
    public final void mDevice() throws RecognitionException {
        try {
            int _type = Device;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:8: ( 'device' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:10: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Device"

    // $ANTLR start "Global"
    public final void mGlobal() throws RecognitionException {
        try {
            int _type = Global;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:8: ( 'global' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:10: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Global"

    // $ANTLR start "Issues"
    public final void mIssues() throws RecognitionException {
        try {
            int _type = Issues;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:8: ( 'issues' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:10: 'issues'
            {
            match("issues"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Issues"

    // $ANTLR start "Memory"
    public final void mMemory() throws RecognitionException {
        try {
            int _type = Memory;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:8: ( 'memory' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:10: 'memory'
            {
            match("memory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Memory"

    // $ANTLR start "KW_System"
    public final void mKW_System() throws RecognitionException {
        try {
            int _type = KW_System;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:11: ( 'system' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:13: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_System"

    // $ANTLR start "Thread"
    public final void mThread() throws RecognitionException {
        try {
            int _type = Thread;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:111:8: ( 'thread' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:111:10: 'thread'
            {
            match("thread"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Thread"

    // $ANTLR start "Delta"
    public final void mDelta() throws RecognitionException {
        try {
            int _type = Delta;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:113:7: ( 'delta' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:113:9: 'delta'
            {
            match("delta"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Delta"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:115:7: ( 'false' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:115:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "False"

    // $ANTLR start "Goals"
    public final void mGoals() throws RecognitionException {
        try {
            int _type = Goals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:117:7: ( 'goals' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:117:9: 'goals'
            {
            match("goals"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goals"

    // $ANTLR start "Group"
    public final void mGroup() throws RecognitionException {
        try {
            int _type = Group;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:119:7: ( 'group' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:119:9: 'group'
            {
            match("group"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Group"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:121:7: ( 'value' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:121:9: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value"

    // $ANTLR start "Data"
    public final void mData() throws RecognitionException {
        try {
            int _type = Data;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:123:6: ( 'data' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:123:8: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Data"

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:125:6: ( 'goal' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:125:8: 'goal'
            {
            match("goal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goal"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:127:6: ( 'null' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:127:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Null"

    // $ANTLR start "This"
    public final void mThis() throws RecognitionException {
        try {
            int _type = This;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:129:6: ( 'this' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:129:8: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "This"

    // $ANTLR start "True"
    public final void mTrue() throws RecognitionException {
        try {
            int _type = True;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:131:6: ( 'true' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:131:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "True"

    // $ANTLR start "Type"
    public final void mType() throws RecognitionException {
        try {
            int _type = Type;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:133:6: ( 'type' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:133:8: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Type"

    // $ANTLR start "User"
    public final void mUser() throws RecognitionException {
        try {
            int _type = User;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:135:6: ( 'user' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:135:8: 'user'
            {
            match("user"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "User"

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:137:6: ( 'with' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:137:8: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "With"

    // $ANTLR start "FullStopFullStopLessThanSign"
    public final void mFullStopFullStopLessThanSign() throws RecognitionException {
        try {
            int _type = FullStopFullStopLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:139:30: ( '..<' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:139:32: '..<'
            {
            match("..<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStopLessThanSign"

    // $ANTLR start "All"
    public final void mAll() throws RecognitionException {
        try {
            int _type = All;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:141:5: ( 'all' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:141:7: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "All"

    // $ANTLR start "Bus"
    public final void mBus() throws RecognitionException {
        try {
            int _type = Bus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:143:5: ( 'bus' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:143:7: 'bus'
            {
            match("bus"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bus"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:145:5: ( 'for' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:145:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "Img"
    public final void mImg() throws RecognitionException {
        try {
            int _type = Img;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:147:5: ( 'img' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:147:7: 'img'
            {
            match("img"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Img"

    // $ANTLR start "See"
    public final void mSee() throws RecognitionException {
        try {
            int _type = See;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:149:5: ( 'see' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:149:7: 'see'
            {
            match("see"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "See"

    // $ANTLR start "Use"
    public final void mUse() throws RecognitionException {
        try {
            int _type = Use;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:151:5: ( 'use' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:151:7: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Use"

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:153:5: ( 'val' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:153:7: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Val"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:155:27: ( '!=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:155:29: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "AmpersandAmpersand"
    public final void mAmpersandAmpersand() throws RecognitionException {
        try {
            int _type = AmpersandAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:157:20: ( '&&' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:157:22: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandAmpersand"

    // $ANTLR start "AsteriskAsterisk"
    public final void mAsteriskAsterisk() throws RecognitionException {
        try {
            int _type = AsteriskAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:159:18: ( '**' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:159:20: '**'
            {
            match("**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskAsterisk"

    // $ANTLR start "HyphenMinusGreaterThanSign"
    public final void mHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:161:28: ( '->' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:161:30: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusGreaterThanSign"

    // $ANTLR start "FullStopFullStop"
    public final void mFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:163:18: ( '..' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:163:20: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStop"

    // $ANTLR start "ColonColon"
    public final void mColonColon() throws RecognitionException {
        try {
            int _type = ColonColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:165:12: ( '::' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:165:14: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ColonColon"

    // $ANTLR start "LessThanSignGreaterThanSign"
    public final void mLessThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:167:29: ( '<>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:167:31: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignGreaterThanSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:169:22: ( '==' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:169:24: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "EqualsSignGreaterThanSign"
    public final void mEqualsSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = EqualsSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:171:27: ( '=>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:171:29: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignGreaterThanSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:173:27: ( '>=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:173:29: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "QuestionMarkColon"
    public final void mQuestionMarkColon() throws RecognitionException {
        try {
            int _type = QuestionMarkColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:175:19: ( '?:' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:175:21: '?:'
            {
            match("?:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMarkColon"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:177:26: ( '||' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:177:28: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLine"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:179:17: ( '!' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:179:19: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMark"

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:181:12: ( '#' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:181:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NumberSign"

    // $ANTLR start "PercentSign"
    public final void mPercentSign() throws RecognitionException {
        try {
            int _type = PercentSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:183:13: ( '%' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:183:15: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:185:17: ( '(' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:185:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:187:18: ( ')' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:187:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:189:10: ( '*' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:189:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:191:10: ( '+' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:191:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:193:7: ( ',' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:193:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:195:13: ( '-' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:195:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:197:10: ( '.' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:197:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:199:9: ( '/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:199:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:201:7: ( ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:201:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:203:14: ( '<' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:203:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:205:12: ( '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:205:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:207:17: ( '>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:207:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:209:14: ( '@' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:209:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:211:19: ( '[' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:211:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:213:20: ( ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:213:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:215:18: ( '{' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:215:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:217:19: ( '}' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:217:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:36: ( '+' | '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='+'||LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:47: ( RULE_DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:47: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

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

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_INT_EXPONENT"
    public final void mRULE_INT_EXPONENT() throws RecognitionException {
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:40: ( '+' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:45: ( RULE_DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:45: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

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

        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT_EXPONENT"

    // $ANTLR start "RULE_REAL_LIT"
    public final void mRULE_REAL_LIT() throws RecognitionException {
        try {
            int _type = RULE_REAL_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:17: ( RULE_DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:17: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:29: ( '_' ( RULE_DIGIT )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:34: ( RULE_DIGIT )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:34: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

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
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('.'); 
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:52: ( RULE_DIGIT )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:52: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:64: ( '_' ( RULE_DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:69: ( RULE_DIGIT )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( ((LA9_0>='0' && LA9_0<='9')) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:69: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

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
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:83: ( RULE_EXPONENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:83: RULE_EXPONENT
                    {
                    mRULE_EXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL_LIT"

    // $ANTLR start "RULE_INTEGER_LIT"
    public final void mRULE_INTEGER_LIT() throws RecognitionException {
        try {
            int _type = RULE_INTEGER_LIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:18: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:20: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:20: ( RULE_DIGIT )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:20: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:32: ( '_' ( RULE_DIGIT )+ )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='_') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:33: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:37: ( RULE_DIGIT )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:37: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt13 >= 1 ) break loop13;
            	                EarlyExitException eee =
            	                    new EarlyExitException(13, input);
            	                throw eee;
            	        }
            	        cnt13++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:51: ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='#') ) {
                alt17=1;
            }
            else {
                alt17=2;}
            switch (alt17) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:52: '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )?
                    {
                    match('#'); 
                    mRULE_BASED_INTEGER(); 
                    match('#'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:79: ( RULE_INT_EXPONENT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:79: RULE_INT_EXPONENT
                            {
                            mRULE_INT_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:98: ( RULE_INT_EXPONENT )?
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:98: ( RULE_INT_EXPONENT )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='E'||LA16_0=='e') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:98: RULE_INT_EXPONENT
                            {
                            mRULE_INT_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER_LIT"

    // $ANTLR start "RULE_DIGIT"
    public final void mRULE_DIGIT() throws RecognitionException {
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:229:21: ( '0' .. '9' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:229:23: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIGIT"

    // $ANTLR start "RULE_EXTENDED_DIGIT"
    public final void mRULE_EXTENDED_DIGIT() throws RecognitionException {
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:231:30: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:231:32: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXTENDED_DIGIT"

    // $ANTLR start "RULE_BASED_INTEGER"
    public final void mRULE_BASED_INTEGER() throws RecognitionException {
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:29: ( RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:31: RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )*
            {
            mRULE_EXTENDED_DIGIT(); 
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:51: ( ( '_' )? RULE_EXTENDED_DIGIT )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')||(LA19_0>='A' && LA19_0<='F')||LA19_0=='_'||(LA19_0>='a' && LA19_0<='f')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:52: ( '_' )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0=='_') ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:52: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    mRULE_EXTENDED_DIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BASED_INTEGER"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:12: ( '0x' | '0X' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='0') ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1=='x') ) {
                    alt20=1;
                }
                else if ( (LA20_1=='X') ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='0' && LA21_0<='9')||(LA21_0>='A' && LA21_0<='F')||LA21_0=='_'||(LA21_0>='a' && LA21_0<='f')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='#') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    {
                    match('#'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='B'||LA22_0=='b') ) {
                        alt22=1;
                    }
                    else if ( (LA22_0=='L'||LA22_0=='l') ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:64: ( 'b' | 'B' ) ( 'i' | 'I' )
                            {
                            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:84: ( 'l' | 'L' )
                            {
                            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:12: '0' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('0','9'); 
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:21: ( '0' .. '9' | '_' )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='0' && LA24_0<='9')||LA24_0=='_') ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='_' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_DECIMAL"
    public final void mRULE_DECIMAL() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            {
            mRULE_INT(); 
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='E'||LA26_0=='e') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:36: ( '+' | '-' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='+'||LA25_0=='-') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}


                            }
                            break;

                    }

                    mRULE_INT(); 

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='B'||LA27_0=='b') ) {
                alt27=1;
            }
            else if ( (LA27_0=='D'||LA27_0=='F'||LA27_0=='L'||LA27_0=='d'||LA27_0=='f'||LA27_0=='l') ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
                    {
                    if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    if ( input.LA(1)=='D'||input.LA(1)=='I'||input.LA(1)=='d'||input.LA(1)=='i' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='F'||input.LA(1)=='L'||input.LA(1)=='d'||input.LA(1)=='f'||input.LA(1)=='l' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMAL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:11: ( '^' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0=='^') ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='0' && LA29_0<='9')||(LA29_0>='A' && LA29_0<='Z')||LA29_0=='_'||(LA29_0>='a' && LA29_0<='z')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='\"') ) {
                alt32=1;
            }
            else if ( (LA32_0=='\'') ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop30:
                    do {
                        int alt30=3;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0=='\\') ) {
                            alt30=1;
                        }
                        else if ( ((LA30_0>='\u0000' && LA30_0<='!')||(LA30_0>='#' && LA30_0<='[')||(LA30_0>=']' && LA30_0<='\uFFFF')) ) {
                            alt30=2;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop31:
                    do {
                        int alt31=3;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0=='\\') ) {
                            alt31=1;
                        }
                        else if ( ((LA31_0>='\u0000' && LA31_0<='&')||(LA31_0>='(' && LA31_0<='[')||(LA31_0>=']' && LA31_0<='\uFFFF')) ) {
                            alt31=2;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:24: ( options {greedy=false; } : . )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0=='*') ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1=='/') ) {
                        alt33=2;
                    }
                    else if ( ((LA33_1>='\u0000' && LA33_1<='.')||(LA33_1>='0' && LA33_1<='\uFFFF')) ) {
                        alt33=1;
                    }


                }
                else if ( ((LA33_0>='\u0000' && LA33_0<=')')||(LA33_0>='+' && LA33_0<='\uFFFF')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='\u0000' && LA34_0<='\t')||(LA34_0>='\u000B' && LA34_0<='\f')||(LA34_0>='\u000E' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:40: ( ( '\\r' )? '\\n' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0=='\n'||LA36_0=='\r') ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:41: ( '\\r' )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0=='\r') ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>='\t' && LA37_0<='\n')||LA37_0=='\r'||LA37_0==' ') ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:251:16: ( . )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:251:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:8: ( Timecriticality | Scheduleimpact | Maturityindex | Requirements | Description | Development | Familiarity | Requirement | Stakeholder | Uncertainty | Costimpact | Decomposes | Subprogram | Volatility | Attribute | Conflicts | Constants | Mitigates | Predicate | Processor | Rationale | Riskindex | Selection | Abstract | Document | Informal | Compute | Dropped | Evolves | Include | Process | Quality | Refines | Section | Virtual | Device | Global | Issues | Memory | KW_System | Thread | Delta | False | Goals | Group | Value | Data | Goal | Null | This | True | Type | User | With | FullStopFullStopLessThanSign | All | Bus | For | Img | See | Use | Val | ExclamationMarkEqualsSign | AmpersandAmpersand | AsteriskAsterisk | HyphenMinusGreaterThanSign | FullStopFullStop | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkColon | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt38=105;
        alt38 = dfa38.predict(input);
        switch (alt38) {
            case 1 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:10: Timecriticality
                {
                mTimecriticality(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:26: Scheduleimpact
                {
                mScheduleimpact(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:41: Maturityindex
                {
                mMaturityindex(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:55: Requirements
                {
                mRequirements(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:68: Description
                {
                mDescription(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:80: Development
                {
                mDevelopment(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:92: Familiarity
                {
                mFamiliarity(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:104: Requirement
                {
                mRequirement(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:116: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:128: Uncertainty
                {
                mUncertainty(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:140: Costimpact
                {
                mCostimpact(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:151: Decomposes
                {
                mDecomposes(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:162: Subprogram
                {
                mSubprogram(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:173: Volatility
                {
                mVolatility(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:184: Attribute
                {
                mAttribute(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:194: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:204: Constants
                {
                mConstants(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:214: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:224: Predicate
                {
                mPredicate(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:234: Processor
                {
                mProcessor(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:244: Rationale
                {
                mRationale(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:254: Riskindex
                {
                mRiskindex(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:264: Selection
                {
                mSelection(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:274: Abstract
                {
                mAbstract(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:283: Document
                {
                mDocument(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:292: Informal
                {
                mInformal(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:301: Compute
                {
                mCompute(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:309: Dropped
                {
                mDropped(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:317: Evolves
                {
                mEvolves(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:325: Include
                {
                mInclude(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:333: Process
                {
                mProcess(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:341: Quality
                {
                mQuality(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:349: Refines
                {
                mRefines(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:357: Section
                {
                mSection(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:365: Virtual
                {
                mVirtual(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:373: Device
                {
                mDevice(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:380: Global
                {
                mGlobal(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:387: Issues
                {
                mIssues(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:394: Memory
                {
                mMemory(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:401: KW_System
                {
                mKW_System(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:411: Thread
                {
                mThread(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:418: Delta
                {
                mDelta(); 

                }
                break;
            case 43 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:424: False
                {
                mFalse(); 

                }
                break;
            case 44 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:430: Goals
                {
                mGoals(); 

                }
                break;
            case 45 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:436: Group
                {
                mGroup(); 

                }
                break;
            case 46 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:442: Value
                {
                mValue(); 

                }
                break;
            case 47 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:448: Data
                {
                mData(); 

                }
                break;
            case 48 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:453: Goal
                {
                mGoal(); 

                }
                break;
            case 49 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:458: Null
                {
                mNull(); 

                }
                break;
            case 50 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:463: This
                {
                mThis(); 

                }
                break;
            case 51 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:468: True
                {
                mTrue(); 

                }
                break;
            case 52 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:473: Type
                {
                mType(); 

                }
                break;
            case 53 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:478: User
                {
                mUser(); 

                }
                break;
            case 54 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:483: With
                {
                mWith(); 

                }
                break;
            case 55 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:488: FullStopFullStopLessThanSign
                {
                mFullStopFullStopLessThanSign(); 

                }
                break;
            case 56 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:517: All
                {
                mAll(); 

                }
                break;
            case 57 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:521: Bus
                {
                mBus(); 

                }
                break;
            case 58 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:525: For
                {
                mFor(); 

                }
                break;
            case 59 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:529: Img
                {
                mImg(); 

                }
                break;
            case 60 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:533: See
                {
                mSee(); 

                }
                break;
            case 61 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:537: Use
                {
                mUse(); 

                }
                break;
            case 62 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:541: Val
                {
                mVal(); 

                }
                break;
            case 63 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:545: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 64 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:571: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 65 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:590: AsteriskAsterisk
                {
                mAsteriskAsterisk(); 

                }
                break;
            case 66 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:607: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 67 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:634: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 68 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:651: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 69 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:662: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 70 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:690: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 71 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:711: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 72 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:737: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 73 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:763: QuestionMarkColon
                {
                mQuestionMarkColon(); 

                }
                break;
            case 74 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:781: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 75 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:806: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 76 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:822: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 77 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:833: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 78 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:845: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 79 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:861: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 80 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:878: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 81 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:887: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 82 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:896: Comma
                {
                mComma(); 

                }
                break;
            case 83 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:902: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 84 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:914: FullStop
                {
                mFullStop(); 

                }
                break;
            case 85 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:923: Solidus
                {
                mSolidus(); 

                }
                break;
            case 86 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:931: Colon
                {
                mColon(); 

                }
                break;
            case 87 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:937: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 88 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:950: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 89 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:961: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 90 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:977: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 91 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:990: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 92 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1008: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 93 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1027: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 94 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1044: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 95 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1062: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 96 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1076: RULE_INTEGER_LIT
                {
                mRULE_INTEGER_LIT(); 

                }
                break;
            case 97 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1093: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 98 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1102: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 99 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1111: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 100 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1124: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 101 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1132: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 102 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1144: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 103 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1160: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 104 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1176: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 105 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1184: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA38_eotS =
        "\1\uffff\21\66\1\135\1\66\1\140\1\61\1\143\1\145\1\147\1\151\1"+
        "\154\1\156\2\61\6\uffff\1\171\5\uffff\2\u0081\1\61\1\uffff\2\61"+
        "\2\uffff\4\66\1\uffff\45\66\1\u00be\1\uffff\1\66\41\uffff\1\u00c1"+
        "\3\uffff\1\u0081\3\uffff\12\66\1\u00cf\21\66\1\u00e2\1\66\1\u00e5"+
        "\5\66\1\u00ed\2\66\1\u00f0\5\66\1\u00f6\7\66\2\uffff\1\u00fe\1\u0081"+
        "\1\uffff\1\u00c1\1\uffff\1\u0081\2\66\1\u0102\1\u0103\1\u0104\5"+
        "\66\1\uffff\17\66\1\u0119\2\66\1\uffff\1\66\1\u011d\1\uffff\7\66"+
        "\1\uffff\2\66\1\uffff\5\66\1\uffff\3\66\1\u0130\1\66\1\u0132\1\u0133"+
        "\1\uffff\1\u0081\2\66\3\uffff\21\66\1\u0147\2\66\1\uffff\1\66\1"+
        "\u014b\1\66\1\uffff\6\66\1\u0153\12\66\1\u015e\1\uffff\1\u015f\2"+
        "\uffff\1\66\1\u0161\5\66\1\u0167\2\66\1\u016a\6\66\1\u0171\1\66"+
        "\1\uffff\3\66\1\uffff\7\66\1\uffff\6\66\1\u0183\2\66\1\u0186\2\uffff"+
        "\1\66\1\uffff\4\66\1\u018c\1\uffff\2\66\1\uffff\1\66\1\u0190\4\66"+
        "\1\uffff\2\66\1\u0197\5\66\1\u019d\1\66\1\u019f\3\66\1\u01a4\1\66"+
        "\1\u01a6\1\uffff\1\u01a7\1\u01a8\1\uffff\5\66\1\uffff\3\66\1\uffff"+
        "\5\66\1\u01b6\1\uffff\5\66\1\uffff\1\66\1\uffff\1\66\1\u01be\2\66"+
        "\1\uffff\1\u01c1\3\uffff\4\66\1\u01c6\1\66\1\u01c8\1\66\1\u01ca"+
        "\1\u01cb\3\66\1\uffff\3\66\1\u01d2\1\u01d3\1\66\1\u01d5\1\uffff"+
        "\1\u01d6\1\u01d7\1\uffff\3\66\1\u01db\1\uffff\1\66\1\uffff\1\66"+
        "\2\uffff\2\66\1\u01e0\2\66\1\u01e3\2\uffff\1\u01e4\3\uffff\2\66"+
        "\1\u01e7\1\uffff\1\66\1\u01ea\1\u01eb\1\u01ec\1\uffff\1\u01ed\1"+
        "\u01ee\2\uffff\2\66\1\uffff\1\66\1\u01f2\5\uffff\2\66\1\u01f5\1"+
        "\uffff\1\66\1\u01f7\1\uffff\1\u01f8\2\uffff";
    static final String DFA38_eofS =
        "\u01f9\uffff";
    static final String DFA38_minS =
        "\1\0\1\150\1\143\4\141\1\156\1\157\1\141\1\142\1\162\1\155\1\166"+
        "\1\165\1\154\1\165\1\151\1\56\1\165\1\75\1\46\1\52\1\76\1\72\1\76"+
        "\2\75\1\72\1\174\6\uffff\1\52\5\uffff\2\56\1\101\1\uffff\2\0\2\uffff"+
        "\1\155\1\151\1\165\1\160\1\uffff\1\150\1\141\1\142\1\143\1\163\2"+
        "\164\1\155\1\146\1\164\1\163\2\143\1\157\1\164\1\154\1\162\1\143"+
        "\1\145\1\155\1\154\1\162\1\154\1\164\1\163\1\154\1\145\1\143\1\163"+
        "\1\147\1\157\1\141\1\157\1\141\1\157\1\154\1\164\1\74\1\uffff\1"+
        "\163\41\uffff\1\60\1\uffff\1\53\1\uffff\1\56\3\uffff\2\145\1\163"+
        "\3\145\1\153\1\160\1\145\1\164\1\60\1\164\1\165\1\151\1\157\1\165"+
        "\2\151\1\153\1\143\1\145\1\157\1\164\1\165\1\160\1\141\1\151\1\163"+
        "\1\60\1\145\1\60\1\164\1\146\1\160\1\141\1\164\1\60\1\162\1\164"+
        "\1\60\1\144\1\143\1\157\1\154\1\165\1\60\2\154\1\142\1\154\1\165"+
        "\1\154\1\150\2\uffff\1\60\1\56\1\uffff\3\60\1\143\1\141\3\60\1\144"+
        "\1\145\1\162\1\143\1\151\1\uffff\1\145\1\162\1\147\1\162\1\151\1"+
        "\156\1\157\1\151\1\162\1\154\1\143\1\155\1\141\1\155\1\160\1\60"+
        "\1\154\1\145\1\uffff\1\162\1\60\1\uffff\1\151\1\154\1\164\1\165"+
        "\1\164\1\165\1\145\1\uffff\1\151\1\162\1\uffff\1\151\1\145\1\162"+
        "\1\165\1\145\1\uffff\1\166\1\151\1\141\1\60\1\160\2\60\1\uffff\1"+
        "\60\1\162\1\144\3\uffff\1\165\1\150\1\157\1\164\1\157\1\155\1\151"+
        "\1\141\1\171\1\162\1\145\2\156\1\151\1\157\1\145\1\160\1\60\2\145"+
        "\1\uffff\1\151\1\60\1\164\1\uffff\1\155\1\151\1\141\1\164\1\151"+
        "\1\141\1\60\1\142\1\141\1\143\1\163\1\155\1\144\1\163\1\145\1\164"+
        "\1\154\1\60\1\uffff\1\60\2\uffff\1\151\1\60\1\154\1\157\1\147\1"+
        "\151\1\156\1\60\2\164\1\60\1\145\1\163\1\141\1\144\2\160\1\60\1"+
        "\157\1\uffff\1\156\1\144\1\141\1\uffff\1\141\1\160\1\143\1\156\1"+
        "\145\2\154\1\uffff\1\165\1\143\1\141\1\163\1\141\1\145\1\60\1\163"+
        "\1\171\1\60\2\uffff\1\164\1\uffff\1\145\1\154\1\162\1\157\1\60\1"+
        "\uffff\1\171\1\145\1\uffff\1\155\1\60\1\154\1\145\1\164\1\155\1"+
        "\uffff\1\163\1\164\1\60\1\162\1\151\1\141\2\164\1\60\1\151\1\60"+
        "\3\164\1\60\1\154\1\60\1\uffff\2\60\1\uffff\2\151\1\144\1\141\1"+
        "\156\1\uffff\1\151\1\163\1\145\1\uffff\1\145\1\170\1\151\2\145\1"+
        "\60\1\uffff\1\151\1\156\1\143\2\163\1\uffff\1\164\1\uffff\1\145"+
        "\1\60\1\145\1\162\1\uffff\1\60\3\uffff\1\143\1\155\1\145\1\155\1"+
        "\60\1\156\1\60\1\156\2\60\1\157\1\156\1\163\1\uffff\3\164\2\60\1"+
        "\171\1\60\1\uffff\2\60\1\uffff\1\141\1\160\1\162\1\60\1\uffff\1"+
        "\144\1\uffff\1\164\2\uffff\1\156\1\164\1\60\2\171\1\60\2\uffff\1"+
        "\60\3\uffff\1\154\1\141\1\60\1\uffff\1\145\3\60\1\uffff\2\60\2\uffff"+
        "\1\151\1\143\1\uffff\1\170\1\60\5\uffff\2\164\1\60\1\uffff\1\171"+
        "\1\60\1\uffff\1\60\2\uffff";
    static final String DFA38_maxS =
        "\1\uffff\2\171\2\151\1\162\1\157\1\163\2\157\1\164\1\162\1\163"+
        "\1\166\1\165\1\162\1\165\1\151\1\56\1\165\1\75\1\46\1\52\1\76\1"+
        "\72\2\76\1\75\1\72\1\174\6\uffff\1\57\5\uffff\1\170\1\154\1\172"+
        "\1\uffff\2\uffff\2\uffff\1\155\1\162\1\165\1\160\1\uffff\1\150\1"+
        "\141\1\142\1\154\1\163\2\164\1\155\1\161\1\164\1\163\1\166\1\143"+
        "\1\157\1\164\1\155\1\162\1\143\1\145\1\163\1\154\1\162\1\154\1\164"+
        "\1\163\1\154\1\157\1\146\1\163\1\147\1\157\1\141\1\157\1\141\1\157"+
        "\1\154\1\164\1\74\1\uffff\1\163\41\uffff\1\154\1\uffff\1\71\1\uffff"+
        "\1\154\3\uffff\2\145\1\163\3\145\1\153\1\160\1\145\1\164\1\172\1"+
        "\164\1\165\1\151\1\157\1\165\2\151\1\153\1\143\1\151\1\157\1\164"+
        "\1\165\1\160\1\141\1\151\1\163\1\172\1\145\1\172\1\164\1\163\1\160"+
        "\1\141\1\164\1\172\1\162\1\164\1\172\1\144\1\143\1\157\1\154\1\165"+
        "\1\172\2\154\1\142\1\154\1\165\1\154\1\150\2\uffff\1\172\1\154\1"+
        "\uffff\1\154\1\71\1\154\1\143\1\141\3\172\1\144\1\145\1\162\1\143"+
        "\1\151\1\uffff\1\145\1\162\1\147\1\162\1\151\1\156\1\157\1\151\1"+
        "\162\1\154\1\143\1\155\1\141\1\155\1\160\1\172\1\154\1\145\1\uffff"+
        "\1\162\1\172\1\uffff\1\151\1\154\1\164\1\165\1\164\1\165\1\145\1"+
        "\uffff\1\151\1\162\1\uffff\1\151\1\145\1\162\1\165\1\145\1\uffff"+
        "\1\166\1\151\1\141\1\172\1\160\2\172\1\uffff\1\154\1\162\1\144\3"+
        "\uffff\1\165\1\150\1\157\1\164\1\157\1\155\1\151\1\141\1\171\1\162"+
        "\1\145\2\156\1\151\1\157\1\145\1\160\1\172\2\145\1\uffff\1\151\1"+
        "\172\1\164\1\uffff\1\155\1\151\1\141\1\164\1\151\1\141\1\172\1\142"+
        "\1\141\1\143\1\163\1\155\1\144\1\163\1\145\1\164\1\154\1\172\1\uffff"+
        "\1\172\2\uffff\1\151\1\172\1\154\1\157\1\147\1\151\1\156\1\172\2"+
        "\164\1\172\1\145\1\163\1\141\1\144\2\160\1\172\1\157\1\uffff\1\156"+
        "\1\144\1\141\1\uffff\1\141\1\160\1\143\1\156\1\145\2\154\1\uffff"+
        "\1\165\1\143\1\141\1\163\1\141\1\145\1\172\1\163\1\171\1\172\2\uffff"+
        "\1\164\1\uffff\1\145\1\154\1\162\1\157\1\172\1\uffff\1\171\1\145"+
        "\1\uffff\1\155\1\172\1\154\1\145\1\164\1\155\1\uffff\1\163\1\164"+
        "\1\172\1\162\1\151\1\141\2\164\1\172\1\151\1\172\3\164\1\172\1\154"+
        "\1\172\1\uffff\2\172\1\uffff\2\151\1\144\1\141\1\156\1\uffff\1\151"+
        "\1\163\1\145\1\uffff\1\145\1\170\1\151\2\145\1\172\1\uffff\1\151"+
        "\1\156\1\143\2\163\1\uffff\1\164\1\uffff\1\145\1\172\1\145\1\162"+
        "\1\uffff\1\172\3\uffff\1\143\1\155\1\145\1\155\1\172\1\156\1\172"+
        "\1\156\2\172\1\157\1\156\1\163\1\uffff\3\164\2\172\1\171\1\172\1"+
        "\uffff\2\172\1\uffff\1\141\1\160\1\162\1\172\1\uffff\1\144\1\uffff"+
        "\1\164\2\uffff\1\156\1\164\1\172\2\171\1\172\2\uffff\1\172\3\uffff"+
        "\1\154\1\141\1\172\1\uffff\1\145\3\172\1\uffff\2\172\2\uffff\1\151"+
        "\1\143\1\uffff\1\170\1\172\5\uffff\2\164\1\172\1\uffff\1\171\1\172"+
        "\1\uffff\1\172\2\uffff";
    static final String DFA38_acceptS =
        "\36\uffff\1\114\1\115\1\116\1\117\1\121\1\122\1\uffff\1\132\1\133"+
        "\1\134\1\135\1\136\3\uffff\1\144\2\uffff\1\150\1\151\4\uffff\1\144"+
        "\46\uffff\1\124\1\uffff\1\77\1\113\1\100\1\101\1\120\1\102\1\123"+
        "\1\104\1\126\1\105\1\127\1\106\1\107\1\130\1\110\1\131\1\111\1\112"+
        "\1\114\1\115\1\116\1\117\1\121\1\122\1\146\1\147\1\125\1\132\1\133"+
        "\1\134\1\135\1\136\1\141\1\uffff\1\140\1\uffff\1\143\1\uffff\1\137"+
        "\1\145\1\150\65\uffff\1\67\1\103\2\uffff\1\142\15\uffff\1\74\22"+
        "\uffff\1\72\2\uffff\1\75\7\uffff\1\76\2\uffff\1\70\5\uffff\1\73"+
        "\7\uffff\1\71\3\uffff\1\62\1\63\1\64\24\uffff\1\57\3\uffff\1\65"+
        "\22\uffff\1\60\1\uffff\1\61\1\66\23\uffff\1\52\3\uffff\1\53\7\uffff"+
        "\1\56\12\uffff\1\54\1\55\1\uffff\1\51\5\uffff\1\50\2\uffff\1\47"+
        "\6\uffff\1\44\21\uffff\1\46\2\uffff\1\45\5\uffff\1\42\3\uffff\1"+
        "\41\6\uffff\1\34\5\uffff\1\33\1\uffff\1\43\4\uffff\1\37\1\uffff"+
        "\1\36\1\35\1\40\15\uffff\1\31\7\uffff\1\30\2\uffff\1\32\4\uffff"+
        "\1\27\1\uffff\1\22\1\uffff\1\25\1\26\6\uffff\1\20\1\21\1\uffff\1"+
        "\17\1\23\1\24\3\uffff\1\15\4\uffff\1\14\2\uffff\1\13\1\16\2\uffff"+
        "\1\11\2\uffff\1\10\1\5\1\6\1\7\1\12\3\uffff\1\4\2\uffff\1\3\1\uffff"+
        "\1\2\1\1";
    static final String DFA38_specialS =
        "\1\2\55\uffff\1\0\1\1\u01c9\uffff}>";
    static final String[] DFA38_transitionS = {
            "\11\61\2\60\2\61\1\60\22\61\1\60\1\24\1\56\1\36\1\61\1\37\1"+
            "\25\1\57\1\40\1\41\1\26\1\42\1\43\1\27\1\22\1\44\1\52\11\53"+
            "\1\30\1\61\1\31\1\32\1\33\1\34\1\45\32\55\1\46\1\61\1\47\1\54"+
            "\1\55\1\61\1\12\1\23\1\10\1\5\1\15\1\6\1\17\1\55\1\14\3\55\1"+
            "\3\1\20\1\55\1\13\1\16\1\4\1\2\1\1\1\7\1\11\1\21\3\55\1\50\1"+
            "\35\1\51\uff82\61",
            "\1\63\1\62\10\uffff\1\64\6\uffff\1\65",
            "\1\67\1\uffff\1\72\16\uffff\1\70\1\71\3\uffff\1\73",
            "\1\74\3\uffff\1\76\3\uffff\1\75",
            "\1\100\3\uffff\1\77\3\uffff\1\101",
            "\1\105\3\uffff\1\102\11\uffff\1\103\2\uffff\1\104",
            "\1\106\15\uffff\1\107",
            "\1\110\4\uffff\1\111",
            "\1\112",
            "\1\115\7\uffff\1\114\5\uffff\1\113",
            "\1\117\11\uffff\1\120\7\uffff\1\116",
            "\1\121",
            "\1\124\1\122\4\uffff\1\123",
            "\1\125",
            "\1\126",
            "\1\127\2\uffff\1\130\2\uffff\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\136",
            "\1\137",
            "\1\141",
            "\1\142",
            "\1\144",
            "\1\146",
            "\1\150",
            "\1\152\1\153",
            "\1\155",
            "\1\157",
            "\1\160",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\167\4\uffff\1\170",
            "",
            "",
            "",
            "",
            "",
            "\1\u0085\1\uffff\12\u0084\10\uffff\1\u0083\1\uffff\1\u0083"+
            "\1\u0082\1\u0083\5\uffff\1\u0083\13\uffff\1\177\6\uffff\1\u0080"+
            "\2\uffff\1\u0083\1\uffff\1\u0083\1\u0082\1\u0083\5\uffff\1\u0083"+
            "\13\uffff\1\177",
            "\1\u0085\1\uffff\12\u0084\10\uffff\1\u0083\1\uffff\1\u0083"+
            "\1\u0082\1\u0083\5\uffff\1\u0083\22\uffff\1\u0080\2\uffff\1"+
            "\u0083\1\uffff\1\u0083\1\u0082\1\u0083\5\uffff\1\u0083",
            "\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\0\u0086",
            "\0\u0086",
            "",
            "",
            "\1\u0088",
            "\1\u008a\10\uffff\1\u0089",
            "\1\u008b",
            "\1\u008c",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0091\1\uffff\1\u0092\6\uffff\1\u0090",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0098\12\uffff\1\u0097",
            "\1\u0099",
            "\1\u009a",
            "\1\u009d\10\uffff\1\u009e\6\uffff\1\u009b\2\uffff\1\u009c",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a3\1\u00a2",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a9\1\u00a8\4\uffff\1\u00a7",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0\11\uffff\1\u00b1",
            "\1\u00b3\2\uffff\1\u00b2",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "",
            "\1\u00bf",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u00c0\10\uffff\1\u0083\1\uffff\3\u0083\5\uffff\1\u0083"+
            "\22\uffff\1\u00c2\2\uffff\1\u0083\1\uffff\3\u0083\5\uffff\1"+
            "\u0083",
            "",
            "\1\u00c3\1\uffff\1\u0083\2\uffff\12\u00c4",
            "",
            "\1\u0085\1\uffff\12\u0084\10\uffff\1\u0083\1\uffff\1\u0083"+
            "\1\u0082\1\u0083\5\uffff\1\u0083\22\uffff\1\u0080\2\uffff\1"+
            "\u0083\1\uffff\1\u0083\1\u0082\1\u0083\5\uffff\1\u0083",
            "",
            "",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9\3\uffff\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00e3",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u00e4\10"+
            "\66",
            "\1\u00e6",
            "\1\u00e7\14\uffff\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u00ec\5"+
            "\66",
            "\1\u00ee",
            "\1\u00ef",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0085\1\uffff\12\u00c0\10\uffff\1\u0083\1\uffff\1\u0083"+
            "\1\u0082\1\u0083\5\uffff\1\u0083\22\uffff\1\u0080\2\uffff\1"+
            "\u0083\1\uffff\1\u0083\1\u0082\1\u0083\5\uffff\1\u0083",
            "",
            "\12\u00c2\10\uffff\1\u0083\1\uffff\3\u0083\5\uffff\1\u0083"+
            "\22\uffff\1\u00c2\2\uffff\1\u0083\1\uffff\3\u0083\5\uffff\1"+
            "\u0083",
            "\12\u00c4",
            "\12\u00ff\10\uffff\1\u0083\1\uffff\1\u0083\1\uffff\1\u0083"+
            "\5\uffff\1\u0083\22\uffff\1\u0083\2\uffff\1\u0083\1\uffff\1"+
            "\u0083\1\uffff\1\u0083\5\uffff\1\u0083",
            "\1\u0100",
            "\1\u0101",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u011a",
            "\1\u011b",
            "",
            "\1\u011c",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "",
            "\1\u0125",
            "\1\u0126",
            "",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u012f\7"+
            "\66",
            "\1\u0131",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\u00ff\10\uffff\1\u0083\1\uffff\1\u0083\1\uffff\1\u0083"+
            "\5\uffff\1\u0083\22\uffff\1\u0083\2\uffff\1\u0083\1\uffff\1"+
            "\u0083\1\uffff\1\u0083\5\uffff\1\u0083",
            "\1\u0134",
            "\1\u0135",
            "",
            "",
            "",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0148",
            "\1\u0149",
            "",
            "\1\u014a",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u014c",
            "",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0160",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0168",
            "\1\u0169",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0172",
            "",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0184",
            "\1\u0185",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0187",
            "",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u018d",
            "\1\u018e",
            "",
            "\1\u018f",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "",
            "\1\u0195",
            "\1\u0196",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u019e",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u01a3\13"+
            "\66",
            "\1\u01a5",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\1\u01ba",
            "\1\u01bb",
            "",
            "\1\u01bc",
            "",
            "\1\u01bd",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01bf",
            "\1\u01c0",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "\1\u01c5",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01c7",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01c9",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01cc",
            "\1\u01cd",
            "\1\u01ce",
            "",
            "\1\u01cf",
            "\1\u01d0",
            "\1\u01d1",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01d4",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01dc",
            "",
            "\1\u01dd",
            "",
            "",
            "\1\u01de",
            "\1\u01df",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01e1",
            "\1\u01e2",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "\1\u01e5",
            "\1\u01e6",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01e8",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\22\66\1\u01e9\7"+
            "\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u01ef",
            "\1\u01f0",
            "",
            "\1\u01f1",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "",
            "\1\u01f3",
            "\1\u01f4",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01f6",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    static class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Timecriticality | Scheduleimpact | Maturityindex | Requirements | Description | Development | Familiarity | Requirement | Stakeholder | Uncertainty | Costimpact | Decomposes | Subprogram | Volatility | Attribute | Conflicts | Constants | Mitigates | Predicate | Processor | Rationale | Riskindex | Selection | Abstract | Document | Informal | Compute | Dropped | Evolves | Include | Process | Quality | Refines | Section | Virtual | Device | Global | Issues | Memory | KW_System | Thread | Delta | False | Goals | Group | Value | Data | Goal | Null | This | True | Type | User | With | FullStopFullStopLessThanSign | All | Bus | For | Img | See | Use | Val | ExclamationMarkEqualsSign | AmpersandAmpersand | AsteriskAsterisk | HyphenMinusGreaterThanSign | FullStopFullStop | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkColon | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_46 = input.LA(1);

                        s = -1;
                        if ( ((LA38_46>='\u0000' && LA38_46<='\uFFFF')) ) {s = 134;}

                        else s = 49;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_47 = input.LA(1);

                        s = -1;
                        if ( ((LA38_47>='\u0000' && LA38_47<='\uFFFF')) ) {s = 134;}

                        else s = 49;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_0 = input.LA(1);

                        s = -1;
                        if ( (LA38_0=='t') ) {s = 1;}

                        else if ( (LA38_0=='s') ) {s = 2;}

                        else if ( (LA38_0=='m') ) {s = 3;}

                        else if ( (LA38_0=='r') ) {s = 4;}

                        else if ( (LA38_0=='d') ) {s = 5;}

                        else if ( (LA38_0=='f') ) {s = 6;}

                        else if ( (LA38_0=='u') ) {s = 7;}

                        else if ( (LA38_0=='c') ) {s = 8;}

                        else if ( (LA38_0=='v') ) {s = 9;}

                        else if ( (LA38_0=='a') ) {s = 10;}

                        else if ( (LA38_0=='p') ) {s = 11;}

                        else if ( (LA38_0=='i') ) {s = 12;}

                        else if ( (LA38_0=='e') ) {s = 13;}

                        else if ( (LA38_0=='q') ) {s = 14;}

                        else if ( (LA38_0=='g') ) {s = 15;}

                        else if ( (LA38_0=='n') ) {s = 16;}

                        else if ( (LA38_0=='w') ) {s = 17;}

                        else if ( (LA38_0=='.') ) {s = 18;}

                        else if ( (LA38_0=='b') ) {s = 19;}

                        else if ( (LA38_0=='!') ) {s = 20;}

                        else if ( (LA38_0=='&') ) {s = 21;}

                        else if ( (LA38_0=='*') ) {s = 22;}

                        else if ( (LA38_0=='-') ) {s = 23;}

                        else if ( (LA38_0==':') ) {s = 24;}

                        else if ( (LA38_0=='<') ) {s = 25;}

                        else if ( (LA38_0=='=') ) {s = 26;}

                        else if ( (LA38_0=='>') ) {s = 27;}

                        else if ( (LA38_0=='?') ) {s = 28;}

                        else if ( (LA38_0=='|') ) {s = 29;}

                        else if ( (LA38_0=='#') ) {s = 30;}

                        else if ( (LA38_0=='%') ) {s = 31;}

                        else if ( (LA38_0=='(') ) {s = 32;}

                        else if ( (LA38_0==')') ) {s = 33;}

                        else if ( (LA38_0=='+') ) {s = 34;}

                        else if ( (LA38_0==',') ) {s = 35;}

                        else if ( (LA38_0=='/') ) {s = 36;}

                        else if ( (LA38_0=='@') ) {s = 37;}

                        else if ( (LA38_0=='[') ) {s = 38;}

                        else if ( (LA38_0==']') ) {s = 39;}

                        else if ( (LA38_0=='{') ) {s = 40;}

                        else if ( (LA38_0=='}') ) {s = 41;}

                        else if ( (LA38_0=='0') ) {s = 42;}

                        else if ( ((LA38_0>='1' && LA38_0<='9')) ) {s = 43;}

                        else if ( (LA38_0=='^') ) {s = 44;}

                        else if ( ((LA38_0>='A' && LA38_0<='Z')||LA38_0=='_'||LA38_0=='h'||(LA38_0>='j' && LA38_0<='l')||LA38_0=='o'||(LA38_0>='x' && LA38_0<='z')) ) {s = 45;}

                        else if ( (LA38_0=='\"') ) {s = 46;}

                        else if ( (LA38_0=='\'') ) {s = 47;}

                        else if ( ((LA38_0>='\t' && LA38_0<='\n')||LA38_0=='\r'||LA38_0==' ') ) {s = 48;}

                        else if ( ((LA38_0>='\u0000' && LA38_0<='\b')||(LA38_0>='\u000B' && LA38_0<='\f')||(LA38_0>='\u000E' && LA38_0<='\u001F')||LA38_0=='$'||LA38_0==';'||LA38_0=='\\'||LA38_0=='`'||(LA38_0>='~' && LA38_0<='\uFFFF')) ) {s = 49;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}