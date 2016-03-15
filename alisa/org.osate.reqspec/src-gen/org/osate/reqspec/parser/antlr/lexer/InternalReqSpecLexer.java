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
    public static final int Connections=6;
    public static final int Val=78;
    public static final int Or=86;
    public static final int Memory=44;
    public static final int KW_System=46;
    public static final int Decomposes=12;
    public static final int String=45;
    public static final int False=51;
    public static final int Document=24;
    public static final int Success=36;
    public static final int LessThanSign=99;
    public static final int Goal=58;
    public static final int LeftParenthesis=90;
    public static final int Development=8;
    public static final int Boolean=27;
    public static final int Fail=57;
    public static final int ExclamationMark=87;
    public static final int GreaterThanSign=101;
    public static final int RULE_ID=112;
    public static final int RULE_DIGIT=106;
    public static final int GreaterThanSignEqualsSign=84;
    public static final int ColonColon=81;
    public static final int Requirement=9;
    public static final int EqualsSignEqualsSign=83;
    public static final int See=75;
    public static final int PlusSign=93;
    public static final int RULE_INT=113;
    public static final int RULE_ML_COMMENT=115;
    public static final int LeftSquareBracket=102;
    public static final int Mitigates=18;
    public static final int Group=53;
    public static final int Warning=38;
    public static final int Description=7;
    public static final int Processor=20;
    public static final int In=85;
    public static final int RULE_REAL_LIT=109;
    public static final int Self=63;
    public static final int Comma=94;
    public static final int Target=47;
    public static final int HyphenMinus=95;
    public static final int LessThanSignEqualsSign=82;
    public static final int Solidus=97;
    public static final int RightCurlyBracket=105;
    public static final int Upto=66;
    public static final int Refines=34;
    public static final int Bus=70;
    public static final int FullStop=96;
    public static final int Abstract=22;
    public static final int Use=77;
    public static final int Constants=16;
    public static final int Conflicts=15;
    public static final int Section=35;
    public static final int Thread=48;
    public static final int Div=71;
    public static final int RULE_EXPONENT=107;
    public static final int When=67;
    public static final int Delta=49;
    public static final int RULE_EXTENDED_DIGIT=110;
    public static final int ExclamationMarkEqualsSign=79;
    public static final int Null=61;
    public static final int Include=31;
    public static final int True=65;
    public static final int Process=33;
    public static final int Requirements=5;
    public static final int Global=41;
    public static final int Predicate=19;
    public static final int RULE_INT_EXPONENT=108;
    public static final int PercentSign=89;
    public static final int Stakeholder=10;
    public static final int FullStopFullStop=80;
    public static final int Tbd=76;
    public static final int Real=62;
    public static final int This=64;
    public static final int RULE_BASED_INTEGER=111;
    public static final int RightSquareBracket=103;
    public static final int Dropped=29;
    public static final int Impact=42;
    public static final int Img=73;
    public static final int Device=39;
    public static final int Inherits=26;
    public static final int For=72;
    public static final int RightParenthesis=91;
    public static final int State=54;
    public static final int And=69;
    public static final int NumberSign=88;
    public static final int Value=55;
    public static final int Subprogram=13;
    public static final int Goals=52;
    public static final int Uncertainty=11;
    public static final int Category=23;
    public static final int Volatility=14;
    public static final int Issues=43;
    public static final int RULE_STRING=114;
    public static final int Evolves=30;
    public static final int With=68;
    public static final int RULE_SL_COMMENT=116;
    public static final int EqualsSign=100;
    public static final int Rationale=21;
    public static final int Colon=98;
    public static final int EOF=-1;
    public static final int Asterisk=92;
    public static final int Downto=40;
    public static final int Mod=74;
    public static final int RULE_WS=117;
    public static final int Mode=60;
    public static final int LeftCurlyBracket=104;
    public static final int Error=50;
    public static final int Virtual=37;
    public static final int Data=56;
    public static final int RULE_ANY_OTHER=118;
    public static final int Info=59;
    public static final int Exception=17;
    public static final int Integer=32;
    public static final int Informal=25;
    public static final int Compute=28;
    public static final int DiagnosticId=4;

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

    // $ANTLR start "DiagnosticId"
    public final void mDiagnosticId() throws RecognitionException {
        try {
            int _type = DiagnosticId;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:14: ( 'diagnosticId' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:16: 'diagnosticId'
            {
            match("diagnosticId"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DiagnosticId"

    // $ANTLR start "Requirements"
    public final void mRequirements() throws RecognitionException {
        try {
            int _type = Requirements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:14: ( 'requirements' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:16: 'requirements'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:13: ( 'connections' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:15: 'connections'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:13: ( 'description' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:15: 'description'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:13: ( 'development' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:15: 'development'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:13: ( 'requirement' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:15: 'requirement'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:13: ( 'stakeholder' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:15: 'stakeholder'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:13: ( 'uncertainty' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:15: 'uncertainty'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:12: ( 'decomposes' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:14: 'decomposes'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:12: ( 'subprogram' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:14: 'subprogram'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:12: ( 'volatility' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:14: 'volatility'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:11: ( 'conflicts' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:13: 'conflicts'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:11: ( 'constants' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:13: 'constants'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:11: ( 'exception' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:13: 'exception'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:11: ( 'mitigates' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:13: 'mitigates'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:11: ( 'predicate' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:13: 'predicate'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:11: ( 'processor' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:13: 'processor'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:11: ( 'rationale' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:13: 'rationale'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:10: ( 'abstract' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:12: 'abstract'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:10: ( 'category' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:12: 'category'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:10: ( 'document' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:12: 'document'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:10: ( 'informal' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:12: 'informal'
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

    // $ANTLR start "Inherits"
    public final void mInherits() throws RecognitionException {
        try {
            int _type = Inherits;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:10: ( 'inherits' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:12: 'inherits'
            {
            match("inherits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Inherits"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:9: ( 'boolean' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Compute"
    public final void mCompute() throws RecognitionException {
        try {
            int _type = Compute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:9: ( 'compute' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:11: 'compute'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:9: ( 'dropped' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:11: 'dropped'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:9: ( 'evolves' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:11: 'evolves'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:9: ( 'include' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:11: 'include'
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

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:9: ( 'integer' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:11: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Process"
    public final void mProcess() throws RecognitionException {
        try {
            int _type = Process;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:9: ( 'process' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:11: 'process'
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

    // $ANTLR start "Refines"
    public final void mRefines() throws RecognitionException {
        try {
            int _type = Refines;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:9: ( 'refines' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:11: 'refines'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:9: ( 'section' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:11: 'section'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:9: ( 'success' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:11: 'success'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:9: ( 'virtual' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:11: 'virtual'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:9: ( 'warning' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:11: 'warning'
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

    // $ANTLR start "Downto"
    public final void mDownto() throws RecognitionException {
        try {
            int _type = Downto;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:8: ( 'downto' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:10: 'downto'
            {
            match("downto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Downto"

    // $ANTLR start "Global"
    public final void mGlobal() throws RecognitionException {
        try {
            int _type = Global;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:8: ( 'global' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:10: 'global'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:8: ( 'impact' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:10: 'impact'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:8: ( 'issues' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:10: 'issues'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:111:8: ( 'memory' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:111:10: 'memory'
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

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:113:8: ( 'string' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:113:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "KW_System"
    public final void mKW_System() throws RecognitionException {
        try {
            int _type = KW_System;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:115:11: ( 'system' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:115:13: 'system'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:117:8: ( 'target' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:117:10: 'target'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:119:8: ( 'thread' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:119:10: 'thread'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:121:7: ( 'delta' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:121:9: 'delta'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:123:7: ( 'error' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:123:9: 'error'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:125:7: ( 'false' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:125:9: 'false'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:127:7: ( 'goals' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:127:9: 'goals'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:129:7: ( 'group' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:129:9: 'group'
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

    // $ANTLR start "State"
    public final void mState() throws RecognitionException {
        try {
            int _type = State;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:131:7: ( 'state' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:131:9: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "State"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:133:7: ( 'value' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:133:9: 'value'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:135:6: ( 'data' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:135:8: 'data'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:137:6: ( 'fail' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:137:8: 'fail'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:139:6: ( 'goal' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:139:8: 'goal'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:141:6: ( 'info' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:141:8: 'info'
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

    // $ANTLR start "Mode"
    public final void mMode() throws RecognitionException {
        try {
            int _type = Mode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:143:6: ( 'mode' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:143:8: 'mode'
            {
            match("mode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mode"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:145:6: ( 'null' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:145:8: 'null'
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

    // $ANTLR start "Real"
    public final void mReal() throws RecognitionException {
        try {
            int _type = Real;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:147:6: ( 'real' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:147:8: 'real'
            {
            match("real"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Real"

    // $ANTLR start "Self"
    public final void mSelf() throws RecognitionException {
        try {
            int _type = Self;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:149:6: ( 'self' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:149:8: 'self'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:151:6: ( 'this' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:151:8: 'this'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:153:6: ( 'true' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:153:8: 'true'
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

    // $ANTLR start "Upto"
    public final void mUpto() throws RecognitionException {
        try {
            int _type = Upto;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:155:6: ( 'upto' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:155:8: 'upto'
            {
            match("upto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Upto"

    // $ANTLR start "When"
    public final void mWhen() throws RecognitionException {
        try {
            int _type = When;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:157:6: ( 'when' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:157:8: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "When"

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:159:6: ( 'with' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:159:8: 'with'
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

    // $ANTLR start "And"
    public final void mAnd() throws RecognitionException {
        try {
            int _type = And;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:161:5: ( 'and' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:161:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "And"

    // $ANTLR start "Bus"
    public final void mBus() throws RecognitionException {
        try {
            int _type = Bus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:163:5: ( 'bus' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:163:7: 'bus'
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

    // $ANTLR start "Div"
    public final void mDiv() throws RecognitionException {
        try {
            int _type = Div;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:165:5: ( 'div' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:165:7: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Div"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:167:5: ( 'for' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:167:7: 'for'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:169:5: ( 'img' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:169:7: 'img'
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

    // $ANTLR start "Mod"
    public final void mMod() throws RecognitionException {
        try {
            int _type = Mod;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:171:5: ( 'mod' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:171:7: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mod"

    // $ANTLR start "See"
    public final void mSee() throws RecognitionException {
        try {
            int _type = See;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:173:5: ( 'see' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:173:7: 'see'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:175:5: ( 'tbd' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:175:7: 'tbd'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:177:5: ( 'use' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:177:7: 'use'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:179:5: ( 'val' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:179:7: 'val'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:181:27: ( '!=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:181:29: '!='
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

    // $ANTLR start "FullStopFullStop"
    public final void mFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:183:18: ( '..' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:183:20: '..'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:185:12: ( '::' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:185:14: '::'
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

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:187:24: ( '<=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:187:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:189:22: ( '==' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:189:24: '=='
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

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:191:27: ( '>=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:191:29: '>='
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

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:193:4: ( 'in' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:193:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "Or"
    public final void mOr() throws RecognitionException {
        try {
            int _type = Or;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:195:4: ( 'or' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:195:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Or"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:197:17: ( '!' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:197:19: '!'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:199:12: ( '#' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:199:14: '#'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:201:13: ( '%' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:201:15: '%'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:203:17: ( '(' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:203:19: '('
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:205:18: ( ')' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:205:20: ')'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:207:10: ( '*' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:207:12: '*'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:209:10: ( '+' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:209:12: '+'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:211:7: ( ',' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:211:9: ','
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:213:13: ( '-' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:213:15: '-'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:215:10: ( '.' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:215:12: '.'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:217:9: ( '/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:217:11: '/'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:219:7: ( ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:219:9: ':'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:14: ( '<' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:221:16: '<'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:12: ( '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:223:14: '='
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:17: ( '>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:225:19: '>'
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

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:19: ( '[' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:227:21: '['
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:229:20: ( ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:229:22: ']'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:231:18: ( '{' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:231:20: '{'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:19: ( '}' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:233:21: '}'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:36: ( '+' | '-' )?
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:47: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:237:47: RULE_DIGIT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:40: ( '+' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='+') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:45: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:239:45: RULE_DIGIT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:17: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:17: RULE_DIGIT
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:29: ( '_' ( RULE_DIGIT )+ )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='_') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:34: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:34: RULE_DIGIT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:52: ( RULE_DIGIT )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:52: RULE_DIGIT
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:64: ( '_' ( RULE_DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:69: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:69: RULE_DIGIT
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:83: ( RULE_EXPONENT )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='E'||LA11_0=='e') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:241:83: RULE_EXPONENT
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:21: ( '0' .. '9' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:243:23: '0' .. '9'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:30: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:245:32: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:29: ( RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:31: RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )*
            {
            mRULE_EXTENDED_DIGIT(); 
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:51: ( ( '_' )? RULE_EXTENDED_DIGIT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='F')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='f')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:52: ( '_' )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0=='_') ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:247:52: '_'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:11: ( '^' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='^') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:11: '^'
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:249:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:251:10: ( ( '0' .. '9' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:251:12: ( '0' .. '9' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:251:12: ( '0' .. '9' )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:251:13: '0' .. '9'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:253:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:255:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:255:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:255:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:255:52: .
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>='\u0000' && LA21_0<='\t')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:40: ( ( '\\r' )? '\\n' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='\n'||LA23_0=='\r') ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:41: ( '\\r' )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0=='\r') ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:257:41: '\\r'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:259:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:259:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:259:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:261:16: ( . )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:261:18: .
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
        // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:8: ( DiagnosticId | Requirements | Connections | Description | Development | Requirement | Stakeholder | Uncertainty | Decomposes | Subprogram | Volatility | Conflicts | Constants | Exception | Mitigates | Predicate | Processor | Rationale | Abstract | Category | Document | Informal | Inherits | Boolean | Compute | Dropped | Evolves | Include | Integer | Process | Refines | Section | Success | Virtual | Warning | Device | Downto | Global | Impact | Issues | Memory | String | KW_System | Target | Thread | Delta | Error | False | Goals | Group | State | Value | Data | Fail | Goal | Info | Mode | Null | Real | Self | This | True | Upto | When | With | And | Bus | Div | For | Img | Mod | See | Tbd | Use | Val | ExclamationMarkEqualsSign | FullStopFullStop | ColonColon | LessThanSignEqualsSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | In | Or | ExclamationMark | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_REAL_LIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt25=110;
        alt25 = dfa25.predict(input);
        switch (alt25) {
            case 1 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:10: DiagnosticId
                {
                mDiagnosticId(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:23: Requirements
                {
                mRequirements(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:36: Connections
                {
                mConnections(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:48: Description
                {
                mDescription(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:60: Development
                {
                mDevelopment(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:72: Requirement
                {
                mRequirement(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:84: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:96: Uncertainty
                {
                mUncertainty(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:108: Decomposes
                {
                mDecomposes(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:119: Subprogram
                {
                mSubprogram(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:130: Volatility
                {
                mVolatility(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:141: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:151: Constants
                {
                mConstants(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:161: Exception
                {
                mException(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:171: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:181: Predicate
                {
                mPredicate(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:191: Processor
                {
                mProcessor(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:201: Rationale
                {
                mRationale(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:211: Abstract
                {
                mAbstract(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:220: Category
                {
                mCategory(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:229: Document
                {
                mDocument(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:238: Informal
                {
                mInformal(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:247: Inherits
                {
                mInherits(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:256: Boolean
                {
                mBoolean(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:264: Compute
                {
                mCompute(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:272: Dropped
                {
                mDropped(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:280: Evolves
                {
                mEvolves(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:288: Include
                {
                mInclude(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:296: Integer
                {
                mInteger(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:304: Process
                {
                mProcess(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:312: Refines
                {
                mRefines(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:320: Section
                {
                mSection(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:328: Success
                {
                mSuccess(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:336: Virtual
                {
                mVirtual(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:344: Warning
                {
                mWarning(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:352: Device
                {
                mDevice(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:359: Downto
                {
                mDownto(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:366: Global
                {
                mGlobal(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:373: Impact
                {
                mImpact(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:380: Issues
                {
                mIssues(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:387: Memory
                {
                mMemory(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:394: String
                {
                mString(); 

                }
                break;
            case 43 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:401: KW_System
                {
                mKW_System(); 

                }
                break;
            case 44 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:411: Target
                {
                mTarget(); 

                }
                break;
            case 45 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:418: Thread
                {
                mThread(); 

                }
                break;
            case 46 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:425: Delta
                {
                mDelta(); 

                }
                break;
            case 47 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:431: Error
                {
                mError(); 

                }
                break;
            case 48 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:437: False
                {
                mFalse(); 

                }
                break;
            case 49 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:443: Goals
                {
                mGoals(); 

                }
                break;
            case 50 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:449: Group
                {
                mGroup(); 

                }
                break;
            case 51 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:455: State
                {
                mState(); 

                }
                break;
            case 52 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:461: Value
                {
                mValue(); 

                }
                break;
            case 53 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:467: Data
                {
                mData(); 

                }
                break;
            case 54 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:472: Fail
                {
                mFail(); 

                }
                break;
            case 55 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:477: Goal
                {
                mGoal(); 

                }
                break;
            case 56 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:482: Info
                {
                mInfo(); 

                }
                break;
            case 57 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:487: Mode
                {
                mMode(); 

                }
                break;
            case 58 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:492: Null
                {
                mNull(); 

                }
                break;
            case 59 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:497: Real
                {
                mReal(); 

                }
                break;
            case 60 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:502: Self
                {
                mSelf(); 

                }
                break;
            case 61 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:507: This
                {
                mThis(); 

                }
                break;
            case 62 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:512: True
                {
                mTrue(); 

                }
                break;
            case 63 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:517: Upto
                {
                mUpto(); 

                }
                break;
            case 64 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:522: When
                {
                mWhen(); 

                }
                break;
            case 65 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:527: With
                {
                mWith(); 

                }
                break;
            case 66 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:532: And
                {
                mAnd(); 

                }
                break;
            case 67 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:536: Bus
                {
                mBus(); 

                }
                break;
            case 68 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:540: Div
                {
                mDiv(); 

                }
                break;
            case 69 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:544: For
                {
                mFor(); 

                }
                break;
            case 70 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:548: Img
                {
                mImg(); 

                }
                break;
            case 71 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:552: Mod
                {
                mMod(); 

                }
                break;
            case 72 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:556: See
                {
                mSee(); 

                }
                break;
            case 73 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:560: Tbd
                {
                mTbd(); 

                }
                break;
            case 74 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:564: Use
                {
                mUse(); 

                }
                break;
            case 75 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:568: Val
                {
                mVal(); 

                }
                break;
            case 76 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:572: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 77 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:598: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 78 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:615: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 79 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:626: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 80 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:649: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 81 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:670: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 82 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:696: In
                {
                mIn(); 

                }
                break;
            case 83 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:699: Or
                {
                mOr(); 

                }
                break;
            case 84 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:702: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 85 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:718: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 86 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:729: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 87 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:741: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 88 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:757: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 89 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:774: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 90 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:783: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 91 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:792: Comma
                {
                mComma(); 

                }
                break;
            case 92 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:798: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 93 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:810: FullStop
                {
                mFullStop(); 

                }
                break;
            case 94 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:819: Solidus
                {
                mSolidus(); 

                }
                break;
            case 95 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:827: Colon
                {
                mColon(); 

                }
                break;
            case 96 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:833: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 97 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:846: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 98 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:857: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 99 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:873: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 100 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:891: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 101 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:910: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 102 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:927: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 103 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:945: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 104 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:959: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 105 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:967: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 106 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:976: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 107 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:988: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 108 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1004: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 109 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1020: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 110 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:1028: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\1\uffff\21\62\1\135\1\137\1\141\1\143\1\145\1\147\1\62\10\uffff\1\163\4\uffff\1\170\1\54\1\uffff\2\54\2\uffff\5\62\1\uffff\27\62\1\u00aa\21\62\14\uffff\1\u00bf\21\uffff\1\170\2\uffff\1\62\1\u00c1\25\62\1\u00db\3\62\1\u00df\2\62\1\u00e3\5\62\1\u00ea\3\62\1\u00ee\4\62\1\uffff\1\62\1\u00f4\2\62\1\u00f7\12\62\1\u0102\2\62\1\u0105\1\62\1\uffff\1\62\1\uffff\10\62\1\u0110\2\62\1\u0113\14\62\1\u0120\1\uffff\2\62\1\u0123\1\uffff\3\62\1\uffff\5\62\1\u012c\1\uffff\3\62\1\uffff\1\u0131\4\62\1\uffff\2\62\1\uffff\1\62\1\u0139\1\u013a\1\62\1\u013d\3\62\1\u0141\1\u0142\1\uffff\1\62\1\u0144\1\uffff\1\u0145\5\62\1\u014b\3\62\1\uffff\2\62\1\uffff\7\62\1\u0158\4\62\1\uffff\2\62\1\uffff\2\62\1\u0161\2\62\1\u0164\2\62\1\uffff\4\62\1\uffff\7\62\2\uffff\1\62\1\u0173\1\uffff\1\u0174\2\62\2\uffff\1\u0177\2\uffff\3\62\1\u017b\1\62\1\uffff\1\62\1\u017e\12\62\1\uffff\1\u0189\3\62\1\u018d\3\62\1\uffff\2\62\1\uffff\1\62\1\u0194\7\62\1\u019c\1\u019d\2\62\1\u01a0\2\uffff\1\u01a1\1\u01a2\1\uffff\3\62\1\uffff\2\62\1\uffff\1\u01a8\1\62\1\u01aa\4\62\1\u01af\2\62\1\uffff\1\62\1\u01b3\1\u01b4\1\uffff\2\62\1\u01b7\1\62\1\u01b9\1\62\1\uffff\1\62\1\u01bd\3\62\1\u01c1\1\u01c2\2\uffff\1\u01c3\1\u01c4\3\uffff\4\62\1\u01c9\1\uffff\1\62\1\uffff\4\62\1\uffff\1\u01cf\2\62\2\uffff\2\62\1\uffff\1\62\1\uffff\3\62\1\uffff\1\u01d8\1\u01d9\1\u01da\4\uffff\4\62\1\uffff\1\62\1\u01e0\1\62\1\u01e2\1\u01e3\1\uffff\4\62\1\u01e8\1\u01e9\1\u01ea\1\u01eb\3\uffff\3\62\1\u01ef\1\62\1\uffff\1\62\2\uffff\1\62\1\u01f3\1\62\1\u01f5\4\uffff\1\62\1\u01f7\1\u01f8\1\uffff\1\u01fa\1\u01fb\1\u01fc\1\uffff\1\u01fd\1\uffff\1\u01fe\2\uffff\1\u01ff\6\uffff";
    static final String DFA25_eofS =
        "\u0200\uffff";
    static final String DFA25_minS =
        "\1\0\3\141\1\145\1\156\1\141\1\162\1\145\1\162\1\142\1\155\1\157\1\141\1\154\2\141\1\165\1\75\1\56\1\72\3\75\1\162\10\uffff\1\52\4\uffff\1\56\1\101\1\uffff\2\0\2\uffff\1\141\2\143\1\157\1\164\1\uffff\1\141\1\164\1\155\1\164\1\141\1\142\1\143\1\163\1\143\1\164\1\145\1\154\1\162\1\154\1\143\1\157\1\162\1\164\1\155\1\144\1\145\1\163\1\144\1\60\1\147\1\163\1\157\1\163\1\162\1\145\1\164\1\157\1\141\1\157\1\162\1\151\1\165\1\144\1\151\1\162\1\154\14\uffff\1\60\21\uffff\1\56\2\uffff\1\147\1\60\1\143\1\145\1\157\1\164\1\165\1\156\1\160\1\141\1\165\1\151\1\154\1\151\1\146\1\160\1\145\1\153\1\151\1\160\1\143\1\164\1\146\1\60\1\164\1\145\1\157\1\60\1\141\1\164\1\60\1\145\1\154\1\157\1\151\1\157\1\60\1\144\1\143\1\164\1\60\1\157\1\145\1\154\1\145\1\uffff\1\141\1\60\1\165\1\154\1\60\2\156\1\150\1\142\1\154\1\165\1\147\1\145\1\163\1\145\1\60\1\163\1\154\1\60\1\154\1\uffff\1\156\1\uffff\1\162\1\154\1\143\1\155\1\141\1\155\1\164\1\160\1\60\1\151\1\156\1\60\1\157\1\145\1\154\1\164\1\165\1\147\2\145\1\156\1\162\1\145\1\151\1\60\1\uffff\1\145\1\162\1\60\1\uffff\1\164\1\165\1\145\1\uffff\1\160\1\166\1\162\1\147\1\162\1\60\1\uffff\1\151\1\145\1\162\1\uffff\1\60\1\162\1\165\1\147\1\143\1\uffff\2\145\1\uffff\1\151\2\60\1\141\1\60\1\160\1\145\1\141\2\60\1\uffff\1\145\1\60\1\uffff\1\60\1\157\1\151\1\157\1\145\1\160\1\60\1\145\1\157\1\145\1\uffff\1\162\1\145\1\uffff\1\156\1\143\1\151\1\141\1\164\1\157\1\150\1\60\1\147\1\157\1\163\1\157\1\uffff\1\155\1\164\1\uffff\1\151\1\141\1\60\1\164\1\145\1\60\1\141\1\171\1\uffff\1\143\1\163\1\141\1\155\1\uffff\1\151\1\144\1\145\1\164\1\163\1\141\1\156\2\uffff\1\154\1\60\1\uffff\1\60\1\164\1\144\2\uffff\1\60\2\uffff\1\163\2\160\1\60\1\157\1\uffff\1\156\1\60\1\144\1\145\1\163\1\141\1\164\1\143\1\156\1\145\1\162\1\157\1\uffff\1\60\1\147\1\163\1\156\1\60\1\141\2\154\1\uffff\1\151\1\163\1\uffff\1\164\1\60\1\141\1\163\1\143\1\141\1\164\1\145\1\162\2\60\1\156\1\147\1\60\2\uffff\2\60\1\uffff\2\164\1\155\1\uffff\1\163\1\164\1\uffff\1\60\1\155\1\60\1\154\1\151\2\164\1\60\1\171\1\154\1\uffff\1\162\2\60\1\uffff\2\151\1\60\1\157\1\60\1\145\1\uffff\1\164\1\60\1\164\1\154\1\163\2\60\2\uffff\2\60\3\uffff\2\151\2\145\1\60\1\uffff\1\145\1\uffff\1\145\1\157\2\163\1\uffff\1\60\1\144\1\141\2\uffff\1\156\1\164\1\uffff\1\156\1\uffff\1\163\1\145\1\162\1\uffff\3\60\4\uffff\1\143\1\157\1\156\1\163\1\uffff\1\156\1\60\1\156\2\60\1\uffff\1\145\1\155\1\164\1\171\4\60\3\uffff\1\111\1\156\1\164\1\60\1\164\1\uffff\1\163\2\uffff\1\162\1\60\1\171\1\60\4\uffff\1\144\2\60\1\uffff\3\60\1\uffff\1\60\1\uffff\1\60\2\uffff\1\60\6\uffff";
    static final String DFA25_maxS =
        "\1\uffff\1\162\1\145\1\157\1\171\1\163\1\157\1\170\1\157\1\162\1\156\1\163\1\165\1\151\2\162\1\157\1\165\1\75\1\56\1\72\3\75\1\162\10\uffff\1\57\4\uffff\1\137\1\172\1\uffff\2\uffff\2\uffff\2\166\1\167\1\157\1\164\1\uffff\1\161\1\164\1\156\1\164\1\162\1\143\1\154\1\163\1\143\1\164\1\145\1\154\1\162\1\154\1\143\1\157\1\162\1\164\1\155\1\144\1\157\1\163\1\144\1\172\1\160\1\163\1\157\1\163\1\162\1\145\1\164\1\157\1\141\1\157\2\162\1\165\1\144\1\154\1\162\1\154\14\uffff\1\172\21\uffff\1\137\2\uffff\1\147\1\172\1\143\1\151\1\157\1\164\1\165\1\156\1\160\1\141\1\165\1\151\1\154\1\151\1\163\1\160\1\145\1\164\1\151\1\160\1\143\1\164\1\146\1\172\1\164\1\145\1\157\1\172\1\141\1\164\1\172\1\145\1\154\1\157\1\151\1\157\1\172\1\144\1\143\1\164\1\172\1\157\1\145\1\154\1\145\1\uffff\1\141\1\172\1\165\1\154\1\172\2\156\1\150\1\142\1\154\1\165\1\147\1\145\1\163\1\145\1\172\1\163\1\154\1\172\1\154\1\uffff\1\156\1\uffff\1\162\1\154\1\143\1\155\1\141\1\155\1\164\1\160\1\172\1\151\1\156\1\172\1\157\1\145\1\154\1\164\1\165\1\147\2\145\1\156\1\162\1\145\1\151\1\172\1\uffff\1\145\1\162\1\172\1\uffff\1\164\1\165\1\145\1\uffff\1\160\1\166\1\162\1\147\1\162\1\172\1\uffff\1\151\1\145\1\162\1\uffff\1\172\1\162\1\165\1\147\1\143\1\uffff\2\145\1\uffff\1\151\2\172\1\141\1\172\1\160\1\145\1\141\2\172\1\uffff\1\145\1\172\1\uffff\1\172\1\157\1\151\1\157\1\145\1\160\1\172\1\145\1\157\1\145\1\uffff\1\162\1\145\1\uffff\1\156\1\143\1\151\1\141\1\164\1\157\1\150\1\172\1\147\1\157\1\163\1\157\1\uffff\1\155\1\164\1\uffff\1\151\1\141\1\172\1\164\1\145\1\172\1\141\1\171\1\uffff\1\143\1\163\1\141\1\155\1\uffff\1\151\1\144\1\145\1\164\1\163\1\141\1\156\2\uffff\1\154\1\172\1\uffff\1\172\1\164\1\144\2\uffff\1\172\2\uffff\1\163\2\160\1\172\1\157\1\uffff\1\156\1\172\1\144\1\145\1\163\1\141\1\164\1\143\1\156\1\145\1\162\1\157\1\uffff\1\172\1\147\1\163\1\156\1\172\1\141\2\154\1\uffff\1\151\1\163\1\uffff\1\164\1\172\1\141\1\163\1\143\1\141\1\164\1\145\1\162\2\172\1\156\1\147\1\172\2\uffff\2\172\1\uffff\2\164\1\155\1\uffff\1\163\1\164\1\uffff\1\172\1\155\1\172\1\154\1\151\2\164\1\172\1\171\1\154\1\uffff\1\162\2\172\1\uffff\2\151\1\172\1\157\1\172\1\145\1\uffff\1\164\1\172\1\164\1\154\1\163\2\172\2\uffff\2\172\3\uffff\2\151\2\145\1\172\1\uffff\1\145\1\uffff\1\145\1\157\2\163\1\uffff\1\172\1\144\1\141\2\uffff\1\156\1\164\1\uffff\1\156\1\uffff\1\163\1\145\1\162\1\uffff\3\172\4\uffff\1\143\1\157\1\156\1\163\1\uffff\1\156\1\172\1\156\2\172\1\uffff\1\145\1\155\1\164\1\171\4\172\3\uffff\1\111\1\156\1\164\1\172\1\164\1\uffff\1\163\2\uffff\1\162\1\172\1\171\1\172\4\uffff\1\144\2\172\1\uffff\3\172\1\uffff\1\172\1\uffff\1\172\2\uffff\1\172\6\uffff";
    static final String DFA25_acceptS =
        "\31\uffff\1\125\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\uffff\1\143\1\144\1\145\1\146\2\uffff\1\150\2\uffff\1\155\1\156\5\uffff\1\150\51\uffff\1\114\1\124\1\115\1\135\1\116\1\137\1\117\1\140\1\120\1\141\1\121\1\142\1\uffff\1\125\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\153\1\154\1\136\1\143\1\144\1\145\1\146\1\151\1\147\1\uffff\1\152\1\155\55\uffff\1\122\24\uffff\1\123\1\uffff\1\104\31\uffff\1\110\3\uffff\1\112\3\uffff\1\113\6\uffff\1\107\3\uffff\1\102\5\uffff\1\106\2\uffff\1\103\12\uffff\1\111\2\uffff\1\105\12\uffff\1\65\2\uffff\1\73\14\uffff\1\74\2\uffff\1\77\10\uffff\1\71\4\uffff\1\70\7\uffff\1\100\1\101\2\uffff\1\67\3\uffff\1\75\1\76\1\uffff\1\66\1\72\5\uffff\1\56\14\uffff\1\63\10\uffff\1\64\2\uffff\1\57\16\uffff\1\61\1\62\2\uffff\1\60\3\uffff\1\44\2\uffff\1\45\12\uffff\1\52\3\uffff\1\53\6\uffff\1\51\7\uffff\1\47\1\50\2\uffff\1\46\1\54\1\55\5\uffff\1\32\1\uffff\1\37\4\uffff\1\31\3\uffff\1\41\1\40\2\uffff\1\42\1\uffff\1\33\3\uffff\1\36\3\uffff\1\34\1\35\1\30\1\43\4\uffff\1\25\5\uffff\1\24\10\uffff\1\23\1\26\1\27\5\uffff\1\22\1\uffff\1\14\1\15\4\uffff\1\16\1\17\1\20\1\21\3\uffff\1\11\3\uffff\1\12\1\uffff\1\13\1\uffff\1\4\1\5\1\uffff\1\6\1\3\1\7\1\10\1\1\1\2";
    static final String DFA25_specialS =
        "\1\0\50\uffff\1\1\1\2\u01d5\uffff}>";
    static final String[] DFA25_transitionS = {
            "\11\54\2\53\2\54\1\53\22\54\1\53\1\22\1\51\1\31\1\54\1\32\1\54\1\52\1\33\1\34\1\35\1\36\1\37\1\40\1\23\1\41\12\46\1\24\1\54\1\25\1\26\1\27\2\54\32\50\1\42\1\54\1\43\1\47\1\50\1\54\1\12\1\14\1\3\1\1\1\7\1\20\1\16\1\50\1\13\3\50\1\10\1\21\1\30\1\11\1\50\1\2\1\4\1\17\1\5\1\6\1\15\3\50\1\44\1\54\1\45\uff82\54",
            "\1\61\3\uffff\1\56\3\uffff\1\55\5\uffff\1\57\2\uffff\1\60",
            "\1\64\3\uffff\1\63",
            "\1\66\15\uffff\1\65",
            "\1\71\16\uffff\1\67\1\70\3\uffff\1\72",
            "\1\73\1\uffff\1\74\2\uffff\1\75",
            "\1\100\7\uffff\1\77\5\uffff\1\76",
            "\1\103\3\uffff\1\102\1\uffff\1\101",
            "\1\105\3\uffff\1\104\5\uffff\1\106",
            "\1\107",
            "\1\110\13\uffff\1\111",
            "\1\113\1\112\4\uffff\1\114",
            "\1\115\5\uffff\1\116",
            "\1\117\6\uffff\1\120\1\121",
            "\1\122\2\uffff\1\123\2\uffff\1\124",
            "\1\125\1\130\5\uffff\1\126\11\uffff\1\127",
            "\1\131\15\uffff\1\132",
            "\1\133",
            "\1\134",
            "\1\136",
            "\1\140",
            "\1\142",
            "\1\144",
            "\1\146",
            "\1\150",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\161\4\uffff\1\162",
            "",
            "",
            "",
            "",
            "\1\171\1\uffff\12\172\45\uffff\1\171",
            "\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\0\173",
            "\0\173",
            "",
            "",
            "\1\175\24\uffff\1\176",
            "\1\u0081\10\uffff\1\u0082\6\uffff\1\177\2\uffff\1\u0080",
            "\1\u0083\23\uffff\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "",
            "\1\u0089\4\uffff\1\u0088\12\uffff\1\u0087",
            "\1\u008a",
            "\1\u008c\1\u008b",
            "\1\u008d",
            "\1\u008e\20\uffff\1\u008f",
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
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2\11\uffff\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\2\62\1\u00a8\2\62\1\u00a6\1\62\1\u00a7\13\62\1\u00a9\6\62",
            "\1\u00ac\10\uffff\1\u00ab",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b8\10\uffff\1\u00b7",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bc\2\uffff\1\u00bb",
            "\1\u00bd",
            "\1\u00be",
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
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
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
            "\1\171\1\uffff\12\172\45\uffff\1\171",
            "",
            "",
            "\1\u00c0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
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
            "\1\u00d0\7\uffff\1\u00cf\4\uffff\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4\10\uffff\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00e0",
            "\1\u00e1",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\24\62\1\u00e2\5\62",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\4\62\1\u00e9\25\62",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "",
            "\1\u00f3",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u00f5",
            "\1\u00f6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
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
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0103",
            "\1\u0104",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0106",
            "",
            "\1\u0107",
            "",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0111",
            "\1\u0112",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0121",
            "\1\u0122",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\21\62\1\u0130\10\62",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "",
            "\1\u0136",
            "\1\u0137",
            "",
            "\1\u0138",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u013b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u013c\7\62",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u0143",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "",
            "\1\u014f",
            "\1\u0150",
            "",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "",
            "\1\u015d",
            "\1\u015e",
            "",
            "\1\u015f",
            "\1\u0160",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0162",
            "\1\u0163",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0165",
            "\1\u0166",
            "",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "\1\u0170",
            "\1\u0171",
            "",
            "",
            "\1\u0172",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0175",
            "\1\u0176",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u017c",
            "",
            "\1\u017d",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "",
            "\1\u0191",
            "\1\u0192",
            "",
            "\1\u0193",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u0195",
            "\1\u0196",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u019e",
            "\1\u019f",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "",
            "\1\u01a6",
            "\1\u01a7",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01a9",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01ab",
            "\1\u01ac",
            "\1\u01ad",
            "\1\u01ae",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01b0",
            "\1\u01b1",
            "",
            "\1\u01b2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u01b5",
            "\1\u01b6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01b8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01ba",
            "",
            "\1\u01bb",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\16\62\1\u01bc\13\62",
            "\1\u01be",
            "\1\u01bf",
            "\1\u01c0",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u01ca",
            "",
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "\1\u01ce",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01d0",
            "\1\u01d1",
            "",
            "",
            "\1\u01d2",
            "\1\u01d3",
            "",
            "\1\u01d4",
            "",
            "\1\u01d5",
            "\1\u01d6",
            "\1\u01d7",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "\1\u01db",
            "\1\u01dc",
            "\1\u01dd",
            "\1\u01de",
            "",
            "\1\u01df",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01e1",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\u01e4",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "\1\u01ec",
            "\1\u01ed",
            "\1\u01ee",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01f0",
            "",
            "\1\u01f1",
            "",
            "",
            "\1\u01f2",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\1\u01f4",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "\1\u01f6",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\22\62\1\u01f9\7\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "\12\62\7\uffff\32\62\4\uffff\1\62\1\uffff\32\62",
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
            return "1:1: Tokens : ( DiagnosticId | Requirements | Connections | Description | Development | Requirement | Stakeholder | Uncertainty | Decomposes | Subprogram | Volatility | Conflicts | Constants | Exception | Mitigates | Predicate | Processor | Rationale | Abstract | Category | Document | Informal | Inherits | Boolean | Compute | Dropped | Evolves | Include | Integer | Process | Refines | Section | Success | Virtual | Warning | Device | Downto | Global | Impact | Issues | Memory | String | KW_System | Target | Thread | Delta | Error | False | Goals | Group | State | Value | Data | Fail | Goal | Info | Mode | Null | Real | Self | This | True | Upto | When | With | And | Bus | Div | For | Img | Mod | See | Tbd | Use | Val | ExclamationMarkEqualsSign | FullStopFullStop | ColonColon | LessThanSignEqualsSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | In | Or | ExclamationMark | NumberSign | PercentSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | RightCurlyBracket | RULE_REAL_LIT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_0 = input.LA(1);

                        s = -1;
                        if ( (LA25_0=='d') ) {s = 1;}

                        else if ( (LA25_0=='r') ) {s = 2;}

                        else if ( (LA25_0=='c') ) {s = 3;}

                        else if ( (LA25_0=='s') ) {s = 4;}

                        else if ( (LA25_0=='u') ) {s = 5;}

                        else if ( (LA25_0=='v') ) {s = 6;}

                        else if ( (LA25_0=='e') ) {s = 7;}

                        else if ( (LA25_0=='m') ) {s = 8;}

                        else if ( (LA25_0=='p') ) {s = 9;}

                        else if ( (LA25_0=='a') ) {s = 10;}

                        else if ( (LA25_0=='i') ) {s = 11;}

                        else if ( (LA25_0=='b') ) {s = 12;}

                        else if ( (LA25_0=='w') ) {s = 13;}

                        else if ( (LA25_0=='g') ) {s = 14;}

                        else if ( (LA25_0=='t') ) {s = 15;}

                        else if ( (LA25_0=='f') ) {s = 16;}

                        else if ( (LA25_0=='n') ) {s = 17;}

                        else if ( (LA25_0=='!') ) {s = 18;}

                        else if ( (LA25_0=='.') ) {s = 19;}

                        else if ( (LA25_0==':') ) {s = 20;}

                        else if ( (LA25_0=='<') ) {s = 21;}

                        else if ( (LA25_0=='=') ) {s = 22;}

                        else if ( (LA25_0=='>') ) {s = 23;}

                        else if ( (LA25_0=='o') ) {s = 24;}

                        else if ( (LA25_0=='#') ) {s = 25;}

                        else if ( (LA25_0=='%') ) {s = 26;}

                        else if ( (LA25_0=='(') ) {s = 27;}

                        else if ( (LA25_0==')') ) {s = 28;}

                        else if ( (LA25_0=='*') ) {s = 29;}

                        else if ( (LA25_0=='+') ) {s = 30;}

                        else if ( (LA25_0==',') ) {s = 31;}

                        else if ( (LA25_0=='-') ) {s = 32;}

                        else if ( (LA25_0=='/') ) {s = 33;}

                        else if ( (LA25_0=='[') ) {s = 34;}

                        else if ( (LA25_0==']') ) {s = 35;}

                        else if ( (LA25_0=='{') ) {s = 36;}

                        else if ( (LA25_0=='}') ) {s = 37;}

                        else if ( ((LA25_0>='0' && LA25_0<='9')) ) {s = 38;}

                        else if ( (LA25_0=='^') ) {s = 39;}

                        else if ( ((LA25_0>='A' && LA25_0<='Z')||LA25_0=='_'||LA25_0=='h'||(LA25_0>='j' && LA25_0<='l')||LA25_0=='q'||(LA25_0>='x' && LA25_0<='z')) ) {s = 40;}

                        else if ( (LA25_0=='\"') ) {s = 41;}

                        else if ( (LA25_0=='\'') ) {s = 42;}

                        else if ( ((LA25_0>='\t' && LA25_0<='\n')||LA25_0=='\r'||LA25_0==' ') ) {s = 43;}

                        else if ( ((LA25_0>='\u0000' && LA25_0<='\b')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='\u001F')||LA25_0=='$'||LA25_0=='&'||LA25_0==';'||(LA25_0>='?' && LA25_0<='@')||LA25_0=='\\'||LA25_0=='`'||LA25_0=='|'||(LA25_0>='~' && LA25_0<='\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_41 = input.LA(1);

                        s = -1;
                        if ( ((LA25_41>='\u0000' && LA25_41<='\uFFFF')) ) {s = 123;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA25_42 = input.LA(1);

                        s = -1;
                        if ( ((LA25_42>='\u0000' && LA25_42<='\uFFFF')) ) {s = 123;}

                        else s = 44;

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