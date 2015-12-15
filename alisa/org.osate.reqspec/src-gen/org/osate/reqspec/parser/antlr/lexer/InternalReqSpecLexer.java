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
    public static final int Connections=5;
    public static final int Val=66;
    public static final int LessThanSignGreaterThanSign=73;
    public static final int EqualsSignGreaterThanSign=75;
    public static final int Memory=40;
    public static final int KW_System=41;
    public static final int Decomposes=11;
    public static final int False=46;
    public static final int Document=23;
    public static final int Success=33;
    public static final int LessThanSign=91;
    public static final int Goal=52;
    public static final int LeftParenthesis=82;
    public static final int Development=7;
    public static final int Fail=51;
    public static final int ExclamationMark=79;
    public static final int GreaterThanSign=93;
    public static final int RULE_ID=105;
    public static final int RULE_DIGIT=99;
    public static final int GreaterThanSignEqualsSign=76;
    public static final int ColonColon=72;
    public static final int Requirement=8;
    public static final int EqualsSignEqualsSign=74;
    public static final int See=63;
    public static final int PlusSign=85;
    public static final int RULE_INT=106;
    public static final int RULE_ML_COMMENT=108;
    public static final int LeftSquareBracket=95;
    public static final int Mitigates=17;
    public static final int Group=48;
    public static final int Warning=35;
    public static final int Description=6;
    public static final int Processor=19;
    public static final int VerticalLineVerticalLine=78;
    public static final int RULE_REAL_LIT=102;
    public static final int Self=55;
    public static final int Comma=86;
    public static final int Target=42;
    public static final int HyphenMinus=87;
    public static final int QuestionMarkColon=77;
    public static final int Solidus=89;
    public static final int RightCurlyBracket=98;
    public static final int Refines=31;
    public static final int Bus=60;
    public static final int FullStop=88;
    public static final int Abstract=21;
    public static final int Use=65;
    public static final int Constants=15;
    public static final int Conflicts=14;
    public static final int Section=32;
    public static final int Thread=43;
    public static final int CommercialAt=94;
    public static final int RULE_EXPONENT=100;
    public static final int Delta=44;
    public static final int RULE_EXTENDED_DIGIT=103;
    public static final int ExclamationMarkEqualsSign=67;
    public static final int HyphenMinusGreaterThanSign=70;
    public static final int Null=54;
    public static final int Include=28;
    public static final int True=57;
    public static final int Process=29;
    public static final int Requirements=4;
    public static final int Global=37;
    public static final int Predicate=18;
    public static final int RULE_INT_EXPONENT=101;
    public static final int PercentSign=81;
    public static final int Stakeholder=9;
    public static final int FullStopFullStop=71;
    public static final int Tbd=64;
    public static final int This=56;
    public static final int RULE_BASED_INTEGER=104;
    public static final int RightSquareBracket=96;
    public static final int Dropped=26;
    public static final int Impact=38;
    public static final int Img=62;
    public static final int Device=36;
    public static final int For=61;
    public static final int RightParenthesis=83;
    public static final int NumberSign=80;
    public static final int Value=49;
    public static final int AsteriskAsterisk=69;
    public static final int Subprogram=12;
    public static final int Goals=47;
    public static final int Uncertainty=10;
    public static final int Category=22;
    public static final int Volatility=13;
    public static final int Issues=39;
    public static final int RULE_STRING=107;
    public static final int Evolves=27;
    public static final int With=58;
    public static final int RULE_SL_COMMENT=109;
    public static final int EqualsSign=92;
    public static final int AmpersandAmpersand=68;
    public static final int Quality=30;
    public static final int Rationale=20;
    public static final int Colon=90;
    public static final int EOF=-1;
    public static final int Asterisk=84;
    public static final int RULE_WS=110;
    public static final int LeftCurlyBracket=97;
    public static final int Error=45;
    public static final int Virtual=34;
    public static final int Data=50;
    public static final int RULE_ANY_OTHER=111;
    public static final int Info=53;
    public static final int Exception=16;
    public static final int FullStopFullStopLessThanSign=59;
    public static final int Informal=24;
    public static final int Compute=25;

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

    // $ANTLR start "Requirements"
    public final void mRequirements() throws RecognitionException {
        try {
            int _type = Requirements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:14: ( 'requirements' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:16: 'requirements'
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

    // $ANTLR start "Connections"
    public final void mConnections() throws RecognitionException {
        try {
            int _type = Connections;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:13: ( 'connections' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:15: 'connections'
            {
            match("connections"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Connections"

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:13: ( 'description' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:15: 'description'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:13: ( 'development' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:15: 'development'
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

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:13: ( 'requirement' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:15: 'requirement'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:13: ( 'stakeholder' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:15: 'stakeholder'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:13: ( 'uncertainty' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:15: 'uncertainty'
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

    // $ANTLR start "Decomposes"
    public final void mDecomposes() throws RecognitionException {
        try {
            int _type = Decomposes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:12: ( 'decomposes' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:14: 'decomposes'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:12: ( 'subprogram' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:14: 'subprogram'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:12: ( 'volatility' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:14: 'volatility'
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

    // $ANTLR start "Conflicts"
    public final void mConflicts() throws RecognitionException {
        try {
            int _type = Conflicts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:11: ( 'conflicts' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:13: 'conflicts'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:11: ( 'constants' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:13: 'constants'
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

    // $ANTLR start "Exception"
    public final void mException() throws RecognitionException {
        try {
            int _type = Exception;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:11: ( 'exception' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:13: 'exception'
            {
            match("exception"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Exception"

    // $ANTLR start "Mitigates"
    public final void mMitigates() throws RecognitionException {
        try {
            int _type = Mitigates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:11: ( 'mitigates' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:13: 'mitigates'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:11: ( 'predicate' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:13: 'predicate'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:11: ( 'processor' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:13: 'processor'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:11: ( 'rationale' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:13: 'rationale'
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

    // $ANTLR start "Abstract"
    public final void mAbstract() throws RecognitionException {
        try {
            int _type = Abstract;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:10: ( 'abstract' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:12: 'abstract'
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

    // $ANTLR start "Category"
    public final void mCategory() throws RecognitionException {
        try {
            int _type = Category;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:10: ( 'category' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:12: 'category'
            {
            match("category"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Category"

    // $ANTLR start "Document"
    public final void mDocument() throws RecognitionException {
        try {
            int _type = Document;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:10: ( 'document' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:12: 'document'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:10: ( 'informal' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:12: 'informal'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:9: ( 'compute' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:11: 'compute'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:9: ( 'dropped' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:11: 'dropped'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:9: ( 'evolves' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:11: 'evolves'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:9: ( 'include' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:11: 'include'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:9: ( 'process' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:11: 'process'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:9: ( 'quality' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:11: 'quality'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:9: ( 'refines' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:11: 'refines'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:9: ( 'section' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:11: 'section'
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

    // $ANTLR start "Success"
    public final void mSuccess() throws RecognitionException {
        try {
            int _type = Success;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:9: ( 'success' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:11: 'success'
            {
            match("success"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Success"

    // $ANTLR start "Virtual"
    public final void mVirtual() throws RecognitionException {
        try {
            int _type = Virtual;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:9: ( 'virtual' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:11: 'virtual'
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

    // $ANTLR start "Warning"
    public final void mWarning() throws RecognitionException {
        try {
            int _type = Warning;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:9: ( 'warning' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:11: 'warning'
            {
            match("warning"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Warning"

    // $ANTLR start "Device"
    public final void mDevice() throws RecognitionException {
        try {
            int _type = Device;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:8: ( 'device' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:10: 'device'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:8: ( 'global' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:10: 'global'
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

    // $ANTLR start "Impact"
    public final void mImpact() throws RecognitionException {
        try {
            int _type = Impact;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:8: ( 'impact' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:10: 'impact'
            {
            match("impact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Impact"

    // $ANTLR start "Issues"
    public final void mIssues() throws RecognitionException {
        try {
            int _type = Issues;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:8: ( 'issues' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:10: 'issues'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:8: ( 'memory' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:10: 'memory'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:11: ( 'system' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:13: 'system'
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

    // $ANTLR start "Target"
    public final void mTarget() throws RecognitionException {
        try {
            int _type = Target;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:8: ( 'target' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:10: 'target'
            {
            match("target"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Target"

    // $ANTLR start "Thread"
    public final void mThread() throws RecognitionException {
        try {
            int _type = Thread;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:8: ( 'thread' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:10: 'thread'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:111:7: ( 'delta' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:111:9: 'delta'
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

    // $ANTLR start "Error"
    public final void mError() throws RecognitionException {
        try {
            int _type = Error;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:113:7: ( 'error' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:113:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Error"

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

    // $ANTLR start "Fail"
    public final void mFail() throws RecognitionException {
        try {
            int _type = Fail;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:125:6: ( 'fail' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:125:8: 'fail'
            {
            match("fail"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Fail"

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:127:6: ( 'goal' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:127:8: 'goal'
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

    // $ANTLR start "Info"
    public final void mInfo() throws RecognitionException {
        try {
            int _type = Info;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:129:6: ( 'info' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:129:8: 'info'
            {
            match("info"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Info"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:131:6: ( 'null' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:131:8: 'null'
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

    // $ANTLR start "Self"
    public final void mSelf() throws RecognitionException {
        try {
            int _type = Self;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:133:6: ( 'self' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:133:8: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Self"

    // $ANTLR start "This"
    public final void mThis() throws RecognitionException {
        try {
            int _type = This;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:135:6: ( 'this' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:135:8: 'this'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:137:6: ( 'true' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:137:8: 'true'
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

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:139:6: ( 'with' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:139:8: 'with'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:141:30: ( '..<' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:141:32: '..<'
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

    // $ANTLR start "Tbd"
    public final void mTbd() throws RecognitionException {
        try {
            int _type = Tbd;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:151:5: ( 'tbd' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:151:7: 'tbd'
            {
            match("tbd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Tbd"

    // $ANTLR start "Use"
    public final void mUse() throws RecognitionException {
        try {
            int _type = Use;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:153:5: ( 'use' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:153:7: 'use'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:155:5: ( 'val' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:155:7: 'val'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:157:27: ( '!=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:157:29: '!='
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:159:20: ( '&&' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:159:22: '&&'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:161:18: ( '**' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:161:20: '**'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:163:28: ( '->' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:163:30: '->'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:165:18: ( '..' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:165:20: '..'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:167:12: ( '::' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:167:14: '::'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:169:29: ( '<>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:169:31: '<>'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:171:22: ( '==' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:171:24: '=='
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:173:27: ( '=>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:173:29: '=>'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:175:27: ( '>=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:175:29: '>='
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:177:19: ( '?:' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:177:21: '?:'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:179:26: ( '||' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:179:28: '||'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:181:17: ( '!' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:181:19: '!'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:183:12: ( '#' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:183:14: '#'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:185:13: ( '%' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:185:15: '%'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:187:17: ( '(' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:187:19: '('
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:189:18: ( ')' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:189:20: ')'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:191:10: ( '*' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:191:12: '*'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:193:10: ( '+' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:193:12: '+'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:195:7: ( ',' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:195:9: ','
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:197:13: ( '-' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:197:15: '-'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:199:10: ( '.' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:199:12: '.'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:201:9: ( '/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:201:11: '/'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:203:7: ( ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:203:9: ':'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:205:14: ( '<' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:205:16: '<'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:207:12: ( '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:207:14: '='
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:209:17: ( '>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:209:19: '>'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:211:14: ( '@' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:211:16: '@'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:213:19: ( '[' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:213:21: '['
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:215:20: ( ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:215:22: ']'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:217:18: ( '{' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:217:20: '{'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:219:19: ( '}' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:219:21: '}'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:36: ( '+' | '-' )?
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:47: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:47: RULE_DIGIT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:40: ( '+' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:45: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:45: RULE_DIGIT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:17: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:17: RULE_DIGIT
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:29: ( '_' ( RULE_DIGIT )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:34: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:34: RULE_DIGIT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:52: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:52: RULE_DIGIT
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:64: ( '_' ( RULE_DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:69: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:69: RULE_DIGIT
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:83: ( RULE_EXPONENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:83: RULE_EXPONENT
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
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='F')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='f')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:52: ( '_' )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0=='_') ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
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
            	    break loop13;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BASED_INTEGER"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:11: ( '^' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='^') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:11: '^'
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:235:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }


                switch (alt15) {
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
            	    break loop15;
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

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:10: ( ( '0' .. '9' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:12: ( '0' .. '9' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:12: ( '0' .. '9' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\"') ) {
                alt19=1;
            }
            else if ( (LA19_0=='\'') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop17:
                    do {
                        int alt17=3;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0=='\\') ) {
                            alt17=1;
                        }
                        else if ( ((LA17_0>='\u0000' && LA17_0<='!')||(LA17_0>='#' && LA17_0<='[')||(LA17_0>=']' && LA17_0<='\uFFFF')) ) {
                            alt17=2;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop17;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop18:
                    do {
                        int alt18=3;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0=='\\') ) {
                            alt18=1;
                        }
                        else if ( ((LA18_0>='\u0000' && LA18_0<='&')||(LA18_0>='(' && LA18_0<='[')||(LA18_0>=']' && LA18_0<='\uFFFF')) ) {
                            alt18=2;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop18;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:24: ( options {greedy=false; } : . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='*') ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1=='/') ) {
                        alt20=2;
                    }
                    else if ( ((LA20_1>='\u0000' && LA20_1<='.')||(LA20_1>='0' && LA20_1<='\uFFFF')) ) {
                        alt20=1;
                    }


                }
                else if ( ((LA20_0>='\u0000' && LA20_0<=')')||(LA20_0>='+' && LA20_0<='\uFFFF')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop20;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop21;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:40: ( ( '\\r' )? '\\n' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\n'||LA23_0=='\r') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:41: ( '\\r' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='\r') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:41: '\\r'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>='\t' && LA24_0<='\n')||LA24_0=='\r'||LA24_0==' ') ) {
                    alt24=1;
                }


                switch (alt24) {
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:16: ( . )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:18: .
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
        // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:8: ( Requirements | Connections | Description | Development | Requirement | Stakeholder | Uncertainty | Decomposes | Subprogram | Volatility | Conflicts | Constants | Exception | Mitigates | Predicate | Processor | Rationale | Abstract | Category | Document | Informal | Compute | Dropped | Evolves | Include | Process | Quality | Refines | Section | Success | Virtual | Warning | Device | Global | Impact | Issues | Memory | KW_System | Target | Thread | Delta | Error | False | Goals | Group | Value | Data | Fail | Goal | Info | Null | Self | This | True | With | FullStopFullStopLessThanSign | Bus | For | Img | See | Tbd | Use | Val | ExclamationMarkEqualsSign | AmpersandAmpersand | AsteriskAsterisk | HyphenMinusGreaterThanSign | FullStopFullStop | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkColon | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_REAL_LIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt25=103;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:10: Requirements
                {
                mRequirements(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:23: Connections
                {
                mConnections(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:35: Description
                {
                mDescription(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:47: Development
                {
                mDevelopment(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:59: Requirement
                {
                mRequirement(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:71: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:83: Uncertainty
                {
                mUncertainty(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:95: Decomposes
                {
                mDecomposes(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:106: Subprogram
                {
                mSubprogram(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:117: Volatility
                {
                mVolatility(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:128: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:138: Constants
                {
                mConstants(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:148: Exception
                {
                mException(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:158: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:168: Predicate
                {
                mPredicate(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:178: Processor
                {
                mProcessor(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:188: Rationale
                {
                mRationale(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:198: Abstract
                {
                mAbstract(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:207: Category
                {
                mCategory(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:216: Document
                {
                mDocument(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:225: Informal
                {
                mInformal(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:234: Compute
                {
                mCompute(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:242: Dropped
                {
                mDropped(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:250: Evolves
                {
                mEvolves(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:258: Include
                {
                mInclude(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:266: Process
                {
                mProcess(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:274: Quality
                {
                mQuality(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:282: Refines
                {
                mRefines(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:290: Section
                {
                mSection(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:298: Success
                {
                mSuccess(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:306: Virtual
                {
                mVirtual(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:314: Warning
                {
                mWarning(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:322: Device
                {
                mDevice(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:329: Global
                {
                mGlobal(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:336: Impact
                {
                mImpact(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:343: Issues
                {
                mIssues(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:350: Memory
                {
                mMemory(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:357: KW_System
                {
                mKW_System(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:367: Target
                {
                mTarget(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:374: Thread
                {
                mThread(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:381: Delta
                {
                mDelta(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:387: Error
                {
                mError(); 

                }
                break;
            case 43 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:393: False
                {
                mFalse(); 

                }
                break;
            case 44 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:399: Goals
                {
                mGoals(); 

                }
                break;
            case 45 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:405: Group
                {
                mGroup(); 

                }
                break;
            case 46 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:411: Value
                {
                mValue(); 

                }
                break;
            case 47 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:417: Data
                {
                mData(); 

                }
                break;
            case 48 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:422: Fail
                {
                mFail(); 

                }
                break;
            case 49 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:427: Goal
                {
                mGoal(); 

                }
                break;
            case 50 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:432: Info
                {
                mInfo(); 

                }
                break;
            case 51 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:437: Null
                {
                mNull(); 

                }
                break;
            case 52 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:442: Self
                {
                mSelf(); 

                }
                break;
            case 53 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:447: This
                {
                mThis(); 

                }
                break;
            case 54 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:452: True
                {
                mTrue(); 

                }
                break;
            case 55 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:457: With
                {
                mWith(); 

                }
                break;
            case 56 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:462: FullStopFullStopLessThanSign
                {
                mFullStopFullStopLessThanSign(); 

                }
                break;
            case 57 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:491: Bus
                {
                mBus(); 

                }
                break;
            case 58 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:495: For
                {
                mFor(); 

                }
                break;
            case 59 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:499: Img
                {
                mImg(); 

                }
                break;
            case 60 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:503: See
                {
                mSee(); 

                }
                break;
            case 61 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:507: Tbd
                {
                mTbd(); 

                }
                break;
            case 62 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:511: Use
                {
                mUse(); 

                }
                break;
            case 63 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:515: Val
                {
                mVal(); 

                }
                break;
            case 64 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:519: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 65 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:545: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 66 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:564: AsteriskAsterisk
                {
                mAsteriskAsterisk(); 

                }
                break;
            case 67 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:581: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 68 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:608: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 69 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:625: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 70 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:636: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 71 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:664: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 72 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:685: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 73 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:711: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 74 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:737: QuestionMarkColon
                {
                mQuestionMarkColon(); 

                }
                break;
            case 75 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:755: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 76 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:780: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 77 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:796: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 78 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:807: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 79 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:819: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 80 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:835: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 81 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:852: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 82 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:861: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 83 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:870: Comma
                {
                mComma(); 

                }
                break;
            case 84 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:876: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 85 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:888: FullStop
                {
                mFullStop(); 

                }
                break;
            case 86 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:897: Solidus
                {
                mSolidus(); 

                }
                break;
            case 87 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:905: Colon
                {
                mColon(); 

                }
                break;
            case 88 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:911: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 89 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:924: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 90 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:935: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 91 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:951: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 92 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:964: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 93 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:982: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 94 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1001: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 95 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1018: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 96 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1036: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 97 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1050: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 98 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1058: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 99 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1067: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 100 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1079: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 101 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1095: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 102 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1111: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 103 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1119: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\21\63\1\133\1\63\1\136\1\60\1\141\1\143\1\145\1\147\1"+
        "\152\1\154\2\60\6\uffff\1\167\5\uffff\1\175\1\60\1\uffff\2\60\2"+
        "\uffff\2\63\1\uffff\46\63\1\u00b8\1\uffff\1\63\42\uffff\1\175\2"+
        "\uffff\22\63\1\u00cf\2\63\1\u00d2\2\63\1\u00d6\13\63\1\u00e2\13"+
        "\63\1\u00ee\2\63\1\u00f1\1\63\2\uffff\1\u00f3\17\63\1\u0103\4\63"+
        "\1\u0108\1\uffff\2\63\1\uffff\3\63\1\uffff\10\63\1\u0117\2\63\1"+
        "\uffff\3\63\1\u011d\1\63\1\u0120\3\63\1\u0124\1\u0125\1\uffff\1"+
        "\63\1\u0127\1\uffff\1\u0128\1\uffff\14\63\1\u0135\2\63\1\uffff\4"+
        "\63\1\uffff\4\63\1\u0140\2\63\1\u0143\6\63\1\uffff\5\63\1\uffff"+
        "\1\63\1\u0150\1\uffff\1\u0151\2\63\2\uffff\1\u0154\2\uffff\12\63"+
        "\1\u015f\1\63\1\uffff\6\63\1\u0167\3\63\1\uffff\2\63\1\uffff\1\63"+
        "\1\u016e\5\63\1\u0174\1\u0175\2\63\1\u0178\2\uffff\1\u0179\1\u017a"+
        "\1\uffff\1\63\1\u017c\4\63\1\u0181\3\63\1\uffff\2\63\1\u0187\2\63"+
        "\1\u018a\1\u018b\1\uffff\2\63\1\u018e\1\63\1\u0190\1\63\1\uffff"+
        "\1\63\1\u0194\2\63\1\u0197\2\uffff\1\u0198\1\u0199\3\uffff\1\63"+
        "\1\uffff\4\63\1\uffff\1\u019f\3\63\1\u01a3\1\uffff\2\63\2\uffff"+
        "\2\63\1\uffff\1\63\1\uffff\3\63\1\uffff\1\u01ac\1\u01ad\3\uffff"+
        "\1\63\1\u01af\1\63\1\u01b1\1\u01b2\1\uffff\3\63\1\uffff\4\63\1\u01ba"+
        "\1\u01bb\1\u01bc\1\u01bd\2\uffff\1\63\1\uffff\1\63\2\uffff\2\63"+
        "\1\u01c2\1\63\1\u01c4\1\63\1\u01c6\4\uffff\1\u01c8\1\u01c9\1\u01ca"+
        "\1\u01cb\1\uffff\1\u01cc\1\uffff\1\u01cd\1\uffff\1\u01ce\7\uffff";
    static final String DFA25_eofS =
        "\u01cf\uffff";
    static final String DFA25_minS =
        "\1\0\3\141\1\145\1\156\1\141\1\162\1\145\1\162\1\142\1\155\1\165"+
        "\1\141\1\154\2\141\1\165\1\56\1\165\1\75\1\46\1\52\1\76\1\72\1\76"+
        "\2\75\1\72\1\174\6\uffff\1\52\5\uffff\1\56\1\101\1\uffff\2\0\2\uffff"+
        "\1\146\1\164\1\uffff\1\155\1\164\2\143\1\157\1\164\1\141\1\142\1"+
        "\143\1\163\1\143\1\145\1\154\1\162\1\154\1\143\1\157\1\162\1\164"+
        "\1\155\1\145\1\163\1\143\1\147\1\163\1\141\1\162\1\164\1\157\1\141"+
        "\1\157\1\162\1\151\1\165\1\144\1\151\1\162\1\154\1\74\1\uffff\1"+
        "\163\42\uffff\1\56\2\uffff\1\165\2\151\1\146\1\160\1\145\1\143\1"+
        "\145\1\157\1\164\1\165\1\160\1\141\1\153\1\160\1\143\1\164\1\146"+
        "\1\60\1\164\1\145\1\60\1\141\1\164\1\60\1\145\1\154\1\157\1\151"+
        "\1\157\1\144\1\143\1\164\1\157\1\154\1\141\1\60\1\165\1\154\1\156"+
        "\1\150\1\142\1\154\1\165\1\147\1\145\1\163\1\145\1\60\1\163\1\154"+
        "\1\60\1\154\2\uffff\1\60\1\151\1\156\1\157\1\145\1\154\1\164\1\165"+
        "\1\147\1\162\1\154\1\143\1\155\1\141\1\155\1\160\1\60\1\145\1\162"+
        "\1\145\1\151\1\60\1\uffff\1\145\1\162\1\uffff\1\164\1\165\1\145"+
        "\1\uffff\1\160\1\166\1\162\1\147\1\162\1\151\1\145\1\162\1\60\1"+
        "\165\1\143\1\uffff\1\145\2\151\1\60\1\141\1\60\1\160\1\145\1\141"+
        "\2\60\1\uffff\1\145\1\60\1\uffff\1\60\1\uffff\1\162\1\145\1\156"+
        "\1\143\1\151\1\141\1\164\1\157\1\151\1\157\1\145\1\160\1\60\2\145"+
        "\1\uffff\1\150\1\157\1\163\1\157\1\uffff\1\155\1\164\1\151\1\141"+
        "\1\60\1\164\1\145\1\60\1\141\1\171\1\143\1\163\1\141\1\155\1\uffff"+
        "\1\144\1\164\1\163\1\164\1\156\1\uffff\1\154\1\60\1\uffff\1\60\1"+
        "\164\1\144\2\uffff\1\60\2\uffff\1\145\1\163\1\141\1\164\1\143\1"+
        "\156\1\145\1\162\2\160\1\60\1\157\1\uffff\1\156\1\144\1\157\1\147"+
        "\1\163\1\156\1\60\1\141\2\154\1\uffff\1\151\1\163\1\uffff\1\164"+
        "\1\60\1\141\1\163\1\143\1\141\1\145\2\60\1\171\1\147\1\60\2\uffff"+
        "\2\60\1\uffff\1\155\1\60\1\154\1\151\2\164\1\60\1\171\1\164\1\155"+
        "\1\uffff\1\163\1\164\1\60\1\154\1\162\2\60\1\uffff\2\151\1\60\1"+
        "\157\1\60\1\145\1\uffff\1\164\1\60\1\164\1\154\1\60\2\uffff\2\60"+
        "\3\uffff\1\145\1\uffff\1\145\1\157\2\163\1\uffff\1\60\1\151\2\145"+
        "\1\60\1\uffff\1\144\1\141\2\uffff\1\156\1\164\1\uffff\1\156\1\uffff"+
        "\1\163\1\145\1\162\1\uffff\2\60\3\uffff\1\156\1\60\1\156\2\60\1"+
        "\uffff\1\157\1\156\1\163\1\uffff\1\145\1\155\1\164\1\171\4\60\2"+
        "\uffff\1\164\1\uffff\1\163\2\uffff\1\156\1\164\1\60\1\162\1\60\1"+
        "\171\1\60\4\uffff\4\60\1\uffff\1\60\1\uffff\1\60\1\uffff\1\60\7"+
        "\uffff";
    static final String DFA25_maxS =
        "\1\uffff\1\145\1\157\1\162\1\171\1\163\1\157\1\170\1\151\1\162"+
        "\1\142\1\163\1\165\1\151\2\162\1\157\1\165\1\56\1\165\1\75\1\46"+
        "\1\52\1\76\1\72\2\76\1\75\1\72\1\174\6\uffff\1\57\5\uffff\1\137"+
        "\1\172\1\uffff\2\uffff\2\uffff\1\161\1\164\1\uffff\1\156\1\164\1"+
        "\166\1\143\1\157\1\164\1\141\1\143\1\154\1\163\1\143\1\145\1\154"+
        "\1\162\1\154\1\143\1\157\1\162\1\164\1\155\1\157\1\163\1\146\1\160"+
        "\1\163\1\141\1\162\1\164\1\157\1\141\1\157\2\162\1\165\1\144\1\154"+
        "\1\162\1\154\1\74\1\uffff\1\163\42\uffff\1\137\2\uffff\1\165\2\151"+
        "\1\163\1\160\1\145\1\143\1\151\1\157\1\164\1\165\1\160\1\141\1\153"+
        "\1\160\1\143\1\164\1\146\1\172\1\164\1\145\1\172\1\141\1\164\1\172"+
        "\1\145\1\154\1\157\1\151\1\157\1\144\1\143\1\164\1\157\1\154\1\141"+
        "\1\172\1\165\1\154\1\156\1\150\1\142\1\154\1\165\1\147\1\145\1\163"+
        "\1\145\1\172\1\163\1\154\1\172\1\154\2\uffff\1\172\1\151\1\156\1"+
        "\157\1\145\1\154\1\164\1\165\1\147\1\162\1\154\1\143\1\155\1\141"+
        "\1\155\1\160\1\172\1\145\1\162\1\145\1\151\1\172\1\uffff\1\145\1"+
        "\162\1\uffff\1\164\1\165\1\145\1\uffff\1\160\1\166\1\162\1\147\1"+
        "\162\1\151\1\145\1\162\1\172\1\165\1\143\1\uffff\1\145\2\151\1\172"+
        "\1\141\1\172\1\160\1\145\1\141\2\172\1\uffff\1\145\1\172\1\uffff"+
        "\1\172\1\uffff\1\162\1\145\1\156\1\143\1\151\1\141\1\164\1\157\1"+
        "\151\1\157\1\145\1\160\1\172\2\145\1\uffff\1\150\1\157\1\163\1\157"+
        "\1\uffff\1\155\1\164\1\151\1\141\1\172\1\164\1\145\1\172\1\141\1"+
        "\171\1\143\1\163\1\141\1\155\1\uffff\1\144\1\164\1\163\1\164\1\156"+
        "\1\uffff\1\154\1\172\1\uffff\1\172\1\164\1\144\2\uffff\1\172\2\uffff"+
        "\1\145\1\163\1\141\1\164\1\143\1\156\1\145\1\162\2\160\1\172\1\157"+
        "\1\uffff\1\156\1\144\1\157\1\147\1\163\1\156\1\172\1\141\2\154\1"+
        "\uffff\1\151\1\163\1\uffff\1\164\1\172\1\141\1\163\1\143\1\141\1"+
        "\145\2\172\1\171\1\147\1\172\2\uffff\2\172\1\uffff\1\155\1\172\1"+
        "\154\1\151\2\164\1\172\1\171\1\164\1\155\1\uffff\1\163\1\164\1\172"+
        "\1\154\1\162\2\172\1\uffff\2\151\1\172\1\157\1\172\1\145\1\uffff"+
        "\1\164\1\172\1\164\1\154\1\172\2\uffff\2\172\3\uffff\1\145\1\uffff"+
        "\1\145\1\157\2\163\1\uffff\1\172\1\151\2\145\1\172\1\uffff\1\144"+
        "\1\141\2\uffff\1\156\1\164\1\uffff\1\156\1\uffff\1\163\1\145\1\162"+
        "\1\uffff\2\172\3\uffff\1\156\1\172\1\156\2\172\1\uffff\1\157\1\156"+
        "\1\163\1\uffff\1\145\1\155\1\164\1\171\4\172\2\uffff\1\164\1\uffff"+
        "\1\163\2\uffff\1\156\1\164\1\172\1\162\1\172\1\171\1\172\4\uffff"+
        "\4\172\1\uffff\1\172\1\uffff\1\172\1\uffff\1\172\7\uffff";
    static final String DFA25_acceptS =
        "\36\uffff\1\115\1\116\1\117\1\120\1\122\1\123\1\uffff\1\133\1\134"+
        "\1\135\1\136\1\137\2\uffff\1\141\2\uffff\1\146\1\147\2\uffff\1\141"+
        "\47\uffff\1\125\1\uffff\1\100\1\114\1\101\1\102\1\121\1\103\1\124"+
        "\1\105\1\127\1\106\1\130\1\107\1\110\1\131\1\111\1\132\1\112\1\113"+
        "\1\115\1\116\1\117\1\120\1\122\1\123\1\144\1\145\1\126\1\133\1\134"+
        "\1\135\1\136\1\137\1\142\1\140\1\uffff\1\143\1\146\65\uffff\1\70"+
        "\1\104\26\uffff\1\74\2\uffff\1\76\3\uffff\1\77\13\uffff\1\73\13"+
        "\uffff\1\75\2\uffff\1\72\1\uffff\1\71\17\uffff\1\57\4\uffff\1\64"+
        "\16\uffff\1\62\5\uffff\1\67\2\uffff\1\61\3\uffff\1\65\1\66\1\uffff"+
        "\1\60\1\63\14\uffff\1\51\12\uffff\1\56\2\uffff\1\52\14\uffff\1\54"+
        "\1\55\2\uffff\1\53\12\uffff\1\41\7\uffff\1\46\6\uffff\1\45\5\uffff"+
        "\1\43\1\44\2\uffff\1\42\1\47\1\50\1\uffff\1\34\4\uffff\1\26\5\uffff"+
        "\1\27\2\uffff\1\36\1\35\2\uffff\1\37\1\uffff\1\30\3\uffff\1\32\2"+
        "\uffff\1\31\1\33\1\40\5\uffff\1\23\3\uffff\1\24\10\uffff\1\22\1"+
        "\25\1\uffff\1\21\1\uffff\1\13\1\14\7\uffff\1\15\1\16\1\17\1\20\4"+
        "\uffff\1\10\1\uffff\1\11\1\uffff\1\12\1\uffff\1\5\1\2\1\3\1\4\1"+
        "\6\1\7\1\1";
    static final String DFA25_specialS =
        "\1\1\54\uffff\1\2\1\0\u01a0\uffff}>";
    static final String[] DFA25_transitionS = {
            "\11\60\2\57\2\60\1\57\22\60\1\57\1\24\1\55\1\36\1\60\1\37\1"+
            "\25\1\56\1\40\1\41\1\26\1\42\1\43\1\27\1\22\1\44\12\52\1\30"+
            "\1\60\1\31\1\32\1\33\1\34\1\45\32\54\1\46\1\60\1\47\1\53\1\54"+
            "\1\60\1\12\1\23\1\2\1\3\1\7\1\20\1\16\1\54\1\13\3\54\1\10\1"+
            "\21\1\54\1\11\1\14\1\1\1\4\1\17\1\5\1\6\1\15\3\54\1\50\1\35"+
            "\1\51\uff82\60",
            "\1\62\3\uffff\1\61",
            "\1\65\15\uffff\1\64",
            "\1\71\3\uffff\1\66\11\uffff\1\67\2\uffff\1\70",
            "\1\74\16\uffff\1\72\1\73\3\uffff\1\75",
            "\1\76\4\uffff\1\77",
            "\1\102\7\uffff\1\101\5\uffff\1\100",
            "\1\105\3\uffff\1\104\1\uffff\1\103",
            "\1\107\3\uffff\1\106",
            "\1\110",
            "\1\111",
            "\1\113\1\112\4\uffff\1\114",
            "\1\115",
            "\1\116\7\uffff\1\117",
            "\1\120\2\uffff\1\121\2\uffff\1\122",
            "\1\123\1\126\5\uffff\1\124\11\uffff\1\125",
            "\1\127\15\uffff\1\130",
            "\1\131",
            "\1\132",
            "\1\134",
            "\1\135",
            "\1\137",
            "\1\140",
            "\1\142",
            "\1\144",
            "\1\146",
            "\1\150\1\151",
            "\1\153",
            "\1\155",
            "\1\156",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\165\4\uffff\1\166",
            "",
            "",
            "",
            "",
            "",
            "\1\176\1\uffff\12\177\45\uffff\1\176",
            "\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\0\u0080",
            "\0\u0080",
            "",
            "",
            "\1\u0083\12\uffff\1\u0082",
            "\1\u0084",
            "",
            "\1\u0086\1\u0085",
            "\1\u0087",
            "\1\u008a\10\uffff\1\u008b\6\uffff\1\u0088\2\uffff\1\u0089",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090\1\u0091",
            "\1\u0092\1\uffff\1\u0094\6\uffff\1\u0093",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0\11\uffff\1\u00a1",
            "\1\u00a2",
            "\1\u00a4\2\uffff\1\u00a3",
            "\1\u00a6\10\uffff\1\u00a5",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00b0\10\uffff\1\u00af",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b4\2\uffff\1\u00b3",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "",
            "\1\u00b9",
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
            "",
            "\1\176\1\uffff\12\177\45\uffff\1\176",
            "",
            "",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00be\7\uffff\1\u00bd\4\uffff\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3\3\uffff\1\u00c4",
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
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d0",
            "\1\u00d1",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00d3",
            "\1\u00d4",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\24\63\1\u00d5\5"+
            "\63",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00ef",
            "\1\u00f0",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00f2",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0109",
            "\1\u010a",
            "",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\21\63\1\u0116\10"+
            "\63",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u011e",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\22\63\1\u011f\7"+
            "\63",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0126",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0136",
            "\1\u0137",
            "",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0141",
            "\1\u0142",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "",
            "\1\u014f",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0152",
            "\1\u0153",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0160",
            "",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "",
            "\1\u016b",
            "\1\u016c",
            "",
            "\1\u016d",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0176",
            "\1\u0177",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u017b",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "",
            "\1\u0185",
            "\1\u0186",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0188",
            "\1\u0189",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u018c",
            "\1\u018d",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u018f",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u0191",
            "",
            "\1\u0192",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\16\63\1\u0193\13"+
            "\63",
            "\1\u0195",
            "\1\u0196",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u019a",
            "",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u01a4",
            "\1\u01a5",
            "",
            "",
            "\1\u01a6",
            "\1\u01a7",
            "",
            "\1\u01a8",
            "",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "\1\u01ae",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u01b0",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "",
            "\1\u01b6",
            "\1\u01b7",
            "\1\u01b8",
            "\1\u01b9",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "\1\u01be",
            "",
            "\1\u01bf",
            "",
            "",
            "\1\u01c0",
            "\1\u01c1",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u01c3",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\1\u01c5",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\22\63\1\u01c7\7"+
            "\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\32\63",
            "",
            "",
            "",
            "",
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

    static class DFA25 extends DFA {

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
            return "1:1: Tokens : ( Requirements | Connections | Description | Development | Requirement | Stakeholder | Uncertainty | Decomposes | Subprogram | Volatility | Conflicts | Constants | Exception | Mitigates | Predicate | Processor | Rationale | Abstract | Category | Document | Informal | Compute | Dropped | Evolves | Include | Process | Quality | Refines | Section | Success | Virtual | Warning | Device | Global | Impact | Issues | Memory | KW_System | Target | Thread | Delta | Error | False | Goals | Group | Value | Data | Fail | Goal | Info | Null | Self | This | True | With | FullStopFullStopLessThanSign | Bus | For | Img | See | Tbd | Use | Val | ExclamationMarkEqualsSign | AmpersandAmpersand | AsteriskAsterisk | HyphenMinusGreaterThanSign | FullStopFullStop | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkColon | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_REAL_LIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_46 = input.LA(1);

                        s = -1;
                        if ( ((LA25_46>='\u0000' && LA25_46<='\uFFFF')) ) {s = 128;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_0 = input.LA(1);

                        s = -1;
                        if ( (LA25_0=='r') ) {s = 1;}

                        else if ( (LA25_0=='c') ) {s = 2;}

                        else if ( (LA25_0=='d') ) {s = 3;}

                        else if ( (LA25_0=='s') ) {s = 4;}

                        else if ( (LA25_0=='u') ) {s = 5;}

                        else if ( (LA25_0=='v') ) {s = 6;}

                        else if ( (LA25_0=='e') ) {s = 7;}

                        else if ( (LA25_0=='m') ) {s = 8;}

                        else if ( (LA25_0=='p') ) {s = 9;}

                        else if ( (LA25_0=='a') ) {s = 10;}

                        else if ( (LA25_0=='i') ) {s = 11;}

                        else if ( (LA25_0=='q') ) {s = 12;}

                        else if ( (LA25_0=='w') ) {s = 13;}

                        else if ( (LA25_0=='g') ) {s = 14;}

                        else if ( (LA25_0=='t') ) {s = 15;}

                        else if ( (LA25_0=='f') ) {s = 16;}

                        else if ( (LA25_0=='n') ) {s = 17;}

                        else if ( (LA25_0=='.') ) {s = 18;}

                        else if ( (LA25_0=='b') ) {s = 19;}

                        else if ( (LA25_0=='!') ) {s = 20;}

                        else if ( (LA25_0=='&') ) {s = 21;}

                        else if ( (LA25_0=='*') ) {s = 22;}

                        else if ( (LA25_0=='-') ) {s = 23;}

                        else if ( (LA25_0==':') ) {s = 24;}

                        else if ( (LA25_0=='<') ) {s = 25;}

                        else if ( (LA25_0=='=') ) {s = 26;}

                        else if ( (LA25_0=='>') ) {s = 27;}

                        else if ( (LA25_0=='?') ) {s = 28;}

                        else if ( (LA25_0=='|') ) {s = 29;}

                        else if ( (LA25_0=='#') ) {s = 30;}

                        else if ( (LA25_0=='%') ) {s = 31;}

                        else if ( (LA25_0=='(') ) {s = 32;}

                        else if ( (LA25_0==')') ) {s = 33;}

                        else if ( (LA25_0=='+') ) {s = 34;}

                        else if ( (LA25_0==',') ) {s = 35;}

                        else if ( (LA25_0=='/') ) {s = 36;}

                        else if ( (LA25_0=='@') ) {s = 37;}

                        else if ( (LA25_0=='[') ) {s = 38;}

                        else if ( (LA25_0==']') ) {s = 39;}

                        else if ( (LA25_0=='{') ) {s = 40;}

                        else if ( (LA25_0=='}') ) {s = 41;}

                        else if ( ((LA25_0>='0' && LA25_0<='9')) ) {s = 42;}

                        else if ( (LA25_0=='^') ) {s = 43;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||LA25_0=='h'||(LA25_0>='j' && LA25_0<='l')||LA25_0=='o'||(LA25_0>='x' && LA25_0<='z')) ) {s = 44;}

                        else if ( (LA25_0=='\"') ) {s = 45;}

                        else if ( (LA25_0=='\'') ) {s = 46;}

                        else if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {s = 47;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='$'||LA25_0==';'||LA25_0=='\\'||LA25_0=='`'||(LA25_0>='~' && LA25_0<='\uFFFF')) ) {s = 48;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_45 = input.LA(1);

                        s = -1;
                        if ( ((LA25_45>='\u0000' && LA25_45<='\uFFFF')) ) {s = 128;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}