package org.osate.reqspec.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReqSpecLexer extends Lexer {
    public static final int Switch=42;
    public static final int RULE_ID=121;
    public static final int RightParenthesis=99;
    public static final int Static=41;
    public static final int Specification=7;
    public static final int RULE_ANY_OTHER=126;
    public static final int ExclamationMark=94;
    public static final int LeftParenthesis=98;
    public static final int RightSquareBracket=114;
    public static final int Item=55;
    public static final int Extends=30;
    public static final int Solidus=105;
    public static final int Guarantee=20;
    public static final int EOF=-1;
    public static final int EqualsSignEqualsSign=85;
    public static final int FullStop=104;
    public static final int PercentSign=96;
    public static final int Finally=31;
    public static final int Volatility=17;
    public static final int Default=29;
    public static final int RULE_HEX=118;
    public static final int Costimpact=15;
    public static final int LessThanSign=108;
    public static final int Do=91;
    public static final int PlusSignPlusSign=76;
    public static final int RULE_DECIMAL=120;
    public static final int FullStopFullStop=81;
    public static final int Conflicts=18;
    public static final int Null=56;
    public static final int PercentSignEqualsSign=72;
    public static final int Stakeholder=12;
    public static final int Familiarity=10;
    public static final int This=57;
    public static final int LeftCurlyBracket=115;
    public static final int Colon=106;
    public static final int NumberSign=95;
    public static final int With=59;
    public static final int RULE_ML_COMMENT=123;
    public static final int Goals=46;
    public static final int Input=47;
    public static final int RULE_STRING=122;
    public static final int VerticalLine=116;
    public static final int HyphenMinusEqualsSign=79;
    public static final int ExclamationMarkEqualsSignEqualsSign=60;
    public static final int Img=65;
    public static final int Else=53;
    public static final int Val=69;
    public static final int Var=70;
    public static final int HyphenMinusGreaterThanSign=80;
    public static final int RightCurlyBracket=117;
    public static final int Assumption=14;
    public static final int Typeof=43;
    public static final int QuestionMarkFullStop=88;
    public static final int Try=68;
    public static final int VerticalLineVerticalLine=93;
    public static final int HyphenMinus=103;
    public static final int AmpersandAmpersand=73;
    public static final int Output=39;
    public static final int All=63;
    public static final int Assert=35;
    public static final int False=45;
    public static final int QuestionMarkColon=89;
    public static final int Extension=19;
    public static final int Issues=38;
    public static final int Mitigates=22;
    public static final int While=51;
    public static final int Requirement=11;
    public static final int LessThanSignGreaterThanSign=84;
    public static final int Case=52;
    public static final int GreaterThanSign=110;
    public static final int Riskindex=25;
    public static final int CommercialAt=112;
    public static final int Value=50;
    public static final int HyphenMinusHyphenMinus=78;
    public static final int EqualsSignGreaterThanSign=86;
    public static final int Uncertainty=13;
    public static final int RULE_INT=119;
    public static final int EqualsSignEqualsSignEqualsSign=62;
    public static final int AsteriskAsterisk=74;
    public static final int Invariant=21;
    public static final int Synchronized=8;
    public static final int LeftSquareBracket=113;
    public static final int Return=40;
    public static final int Refines=33;
    public static final int Predicate=23;
    public static final int True=58;
    public static final int If=92;
    public static final int ExclamationMarkEqualsSign=71;
    public static final int Asterisk=100;
    public static final int Import=37;
    public static final int As=90;
    public static final int Catch=44;
    public static final int Super=48;
    public static final int Throw=49;
    public static final int SolidusEqualsSign=82;
    public static final int Scheduleimpact=5;
    public static final int Semicolon=107;
    public static final int RULE_SL_COMMENT=124;
    public static final int For=64;
    public static final int Include=32;
    public static final int Rationale=24;
    public static final int Goal=54;
    public static final int Ampersand=97;
    public static final int ColonColon=83;
    public static final int Document=27;
    public static final int Description=9;
    public static final int Folder=36;
    public static final int PlusSign=101;
    public static final int Timecriticality=4;
    public static final int Maturityindex=6;
    public static final int New=66;
    public static final int AsteriskEqualsSign=75;
    public static final int See=67;
    public static final int Instanceof=16;
    public static final int FullStopFullStopLessThanSign=61;
    public static final int PlusSignEqualsSign=77;
    public static final int Section=34;
    public static final int Category=26;
    public static final int GreaterThanSignEqualsSign=87;
    public static final int QuestionMark=111;
    public static final int RULE_WS=125;
    public static final int EqualsSign=109;
    public static final int Comma=102;
    public static final int Compute=28;

    // delegates
    // delegators

    public InternalReqSpecLexer() {;} 
    public InternalReqSpecLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalReqSpecLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g"; }

    // $ANTLR start "Timecriticality"
    public final void mTimecriticality() throws RecognitionException {
        try {
            int _type = Timecriticality;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:19:17: ( ( 'T' | 't' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:19:19: ( 'T' | 't' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:21:16: ( ( 'S' | 's' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:21:18: ( 'S' | 's' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:23:15: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'X' | 'x' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:23:17: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Maturityindex"

    // $ANTLR start "Specification"
    public final void mSpecification() throws RecognitionException {
        try {
            int _type = Specification;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:25:15: ( ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:25:17: ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
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

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Specification"

    // $ANTLR start "Synchronized"
    public final void mSynchronized() throws RecognitionException {
        try {
            int _type = Synchronized;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:27:14: ( ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Z' | 'z' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:27:16: ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Z' | 'z' ) ( 'E' | 'e' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
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

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Synchronized"

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:29:13: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:29:15: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Description"

    // $ANTLR start "Familiarity"
    public final void mFamiliarity() throws RecognitionException {
        try {
            int _type = Familiarity;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:31:13: ( ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:31:15: ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:33:13: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:33:15: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
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

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:35:13: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:35:15: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:37:13: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:37:15: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uncertainty"

    // $ANTLR start "Assumption"
    public final void mAssumption() throws RecognitionException {
        try {
            int _type = Assumption;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:39:12: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:39:14: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Assumption"

    // $ANTLR start "Costimpact"
    public final void mCostimpact() throws RecognitionException {
        try {
            int _type = Costimpact;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:41:12: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:41:14: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Costimpact"

    // $ANTLR start "Instanceof"
    public final void mInstanceof() throws RecognitionException {
        try {
            int _type = Instanceof;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:43:12: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:43:14: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Instanceof"

    // $ANTLR start "Volatility"
    public final void mVolatility() throws RecognitionException {
        try {
            int _type = Volatility;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:45:12: ( ( 'V' | 'v' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:45:14: ( 'V' | 'v' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:47:11: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:47:13: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Conflicts"

    // $ANTLR start "Extension"
    public final void mExtension() throws RecognitionException {
        try {
            int _type = Extension;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:49:11: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:49:13: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Extension"

    // $ANTLR start "Guarantee"
    public final void mGuarantee() throws RecognitionException {
        try {
            int _type = Guarantee;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:51:11: ( ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:51:13: ( 'G' | 'g' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Guarantee"

    // $ANTLR start "Invariant"
    public final void mInvariant() throws RecognitionException {
        try {
            int _type = Invariant;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:53:11: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:53:13: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Invariant"

    // $ANTLR start "Mitigates"
    public final void mMitigates() throws RecognitionException {
        try {
            int _type = Mitigates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:55:11: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:55:13: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:57:11: ( ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:57:13: ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Predicate"

    // $ANTLR start "Rationale"
    public final void mRationale() throws RecognitionException {
        try {
            int _type = Rationale;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:59:11: ( ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:59:13: ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:61:11: ( ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'K' | 'k' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'X' | 'x' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:61:13: ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'S' | 's' ) ( 'K' | 'k' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'X' | 'x' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Riskindex"

    // $ANTLR start "Category"
    public final void mCategory() throws RecognitionException {
        try {
            int _type = Category;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:63:10: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:63:12: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:65:10: ( ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:65:12: ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Document"

    // $ANTLR start "Compute"
    public final void mCompute() throws RecognitionException {
        try {
            int _type = Compute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:67:9: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:67:11: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Compute"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:69:9: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:69:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "Extends"
    public final void mExtends() throws RecognitionException {
        try {
            int _type = Extends;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:71:9: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:71:11: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Extends"

    // $ANTLR start "Finally"
    public final void mFinally() throws RecognitionException {
        try {
            int _type = Finally;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:73:9: ( ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:73:11: ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Finally"

    // $ANTLR start "Include"
    public final void mInclude() throws RecognitionException {
        try {
            int _type = Include;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:75:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:75:11: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Include"

    // $ANTLR start "Refines"
    public final void mRefines() throws RecognitionException {
        try {
            int _type = Refines;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:77:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:77:11: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
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

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:79:9: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:79:11: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Section"

    // $ANTLR start "Assert"
    public final void mAssert() throws RecognitionException {
        try {
            int _type = Assert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:81:8: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:81:10: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Assert"

    // $ANTLR start "Folder"
    public final void mFolder() throws RecognitionException {
        try {
            int _type = Folder;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:83:8: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:83:10: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Folder"

    // $ANTLR start "Import"
    public final void mImport() throws RecognitionException {
        try {
            int _type = Import;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:85:8: ( ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:85:10: ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Import"

    // $ANTLR start "Issues"
    public final void mIssues() throws RecognitionException {
        try {
            int _type = Issues;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:87:8: ( ( 'I' | 'i' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:87:10: ( 'I' | 'i' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Issues"

    // $ANTLR start "Output"
    public final void mOutput() throws RecognitionException {
        try {
            int _type = Output;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:89:8: ( ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:89:10: ( 'O' | 'o' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Output"

    // $ANTLR start "Return"
    public final void mReturn() throws RecognitionException {
        try {
            int _type = Return;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:91:8: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:91:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'N' | 'n' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Return"

    // $ANTLR start "Static"
    public final void mStatic() throws RecognitionException {
        try {
            int _type = Static;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:93:8: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:93:10: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Static"

    // $ANTLR start "Switch"
    public final void mSwitch() throws RecognitionException {
        try {
            int _type = Switch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:95:8: ( ( 'S' | 's' ) ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:95:10: ( 'S' | 's' ) ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Switch"

    // $ANTLR start "Typeof"
    public final void mTypeof() throws RecognitionException {
        try {
            int _type = Typeof;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:97:8: ( ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:97:10: ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Typeof"

    // $ANTLR start "Catch"
    public final void mCatch() throws RecognitionException {
        try {
            int _type = Catch;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:99:7: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:99:9: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Catch"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:101:7: ( ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:101:9: ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:103:7: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:103:9: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goals"

    // $ANTLR start "Input"
    public final void mInput() throws RecognitionException {
        try {
            int _type = Input;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:105:7: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:105:9: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Input"

    // $ANTLR start "Super"
    public final void mSuper() throws RecognitionException {
        try {
            int _type = Super;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:107:7: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:107:9: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Super"

    // $ANTLR start "Throw"
    public final void mThrow() throws RecognitionException {
        try {
            int _type = Throw;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:109:7: ( ( 'T' | 't' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:109:9: ( 'T' | 't' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Throw"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:111:7: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:111:9: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value"

    // $ANTLR start "While"
    public final void mWhile() throws RecognitionException {
        try {
            int _type = While;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:113:7: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:113:9: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "While"

    // $ANTLR start "Case"
    public final void mCase() throws RecognitionException {
        try {
            int _type = Case;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:115:6: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:115:8: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Case"

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:117:6: ( ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:117:8: ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Else"

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:119:6: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:119:8: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Goal"

    // $ANTLR start "Item"
    public final void mItem() throws RecognitionException {
        try {
            int _type = Item;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:121:6: ( ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'M' | 'm' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:121:8: ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'M' | 'm' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Item"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:123:6: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:123:8: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:125:6: ( ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:125:8: ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:127:6: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:127:8: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:129:6: ( ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:129:8: ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "With"

    // $ANTLR start "ExclamationMarkEqualsSignEqualsSign"
    public final void mExclamationMarkEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:131:37: ( '!' '=' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:131:39: '!' '=' '='
            {
            match('!'); 
            match('='); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSignEqualsSign"

    // $ANTLR start "FullStopFullStopLessThanSign"
    public final void mFullStopFullStopLessThanSign() throws RecognitionException {
        try {
            int _type = FullStopFullStopLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:133:30: ( '.' '.' '<' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:133:32: '.' '.' '<'
            {
            match('.'); 
            match('.'); 
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStopLessThanSign"

    // $ANTLR start "EqualsSignEqualsSignEqualsSign"
    public final void mEqualsSignEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:135:32: ( '=' '=' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:135:34: '=' '=' '='
            {
            match('='); 
            match('='); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSignEqualsSign"

    // $ANTLR start "All"
    public final void mAll() throws RecognitionException {
        try {
            int _type = All;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:137:5: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:137:7: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "All"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:139:5: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:139:7: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:141:5: ( ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'G' | 'g' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:141:7: ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'G' | 'g' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Img"

    // $ANTLR start "New"
    public final void mNew() throws RecognitionException {
        try {
            int _type = New;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:143:5: ( ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:143:7: ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "New"

    // $ANTLR start "See"
    public final void mSee() throws RecognitionException {
        try {
            int _type = See;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:145:5: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:145:7: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "See"

    // $ANTLR start "Try"
    public final void mTry() throws RecognitionException {
        try {
            int _type = Try;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:147:5: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:147:7: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Try"

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:149:5: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:149:7: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Val"

    // $ANTLR start "Var"
    public final void mVar() throws RecognitionException {
        try {
            int _type = Var;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:151:5: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:151:7: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Var"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:153:27: ( '!' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:153:29: '!' '='
            {
            match('!'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "PercentSignEqualsSign"
    public final void mPercentSignEqualsSign() throws RecognitionException {
        try {
            int _type = PercentSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:155:23: ( '%' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:155:25: '%' '='
            {
            match('%'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PercentSignEqualsSign"

    // $ANTLR start "AmpersandAmpersand"
    public final void mAmpersandAmpersand() throws RecognitionException {
        try {
            int _type = AmpersandAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:157:20: ( '&' '&' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:157:22: '&' '&'
            {
            match('&'); 
            match('&'); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:159:18: ( '*' '*' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:159:20: '*' '*'
            {
            match('*'); 
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskAsterisk"

    // $ANTLR start "AsteriskEqualsSign"
    public final void mAsteriskEqualsSign() throws RecognitionException {
        try {
            int _type = AsteriskEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:161:20: ( '*' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:161:22: '*' '='
            {
            match('*'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AsteriskEqualsSign"

    // $ANTLR start "PlusSignPlusSign"
    public final void mPlusSignPlusSign() throws RecognitionException {
        try {
            int _type = PlusSignPlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:163:18: ( '+' '+' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:163:20: '+' '+'
            {
            match('+'); 
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignPlusSign"

    // $ANTLR start "PlusSignEqualsSign"
    public final void mPlusSignEqualsSign() throws RecognitionException {
        try {
            int _type = PlusSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:165:20: ( '+' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:165:22: '+' '='
            {
            match('+'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSignEqualsSign"

    // $ANTLR start "HyphenMinusHyphenMinus"
    public final void mHyphenMinusHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinusHyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:167:24: ( '-' '-' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:167:26: '-' '-'
            {
            match('-'); 
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusHyphenMinus"

    // $ANTLR start "HyphenMinusEqualsSign"
    public final void mHyphenMinusEqualsSign() throws RecognitionException {
        try {
            int _type = HyphenMinusEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:169:23: ( '-' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:169:25: '-' '='
            {
            match('-'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusEqualsSign"

    // $ANTLR start "HyphenMinusGreaterThanSign"
    public final void mHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:171:28: ( '-' '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:171:30: '-' '>'
            {
            match('-'); 
            match('>'); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:173:18: ( '.' '.' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:173:20: '.' '.'
            {
            match('.'); 
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStop"

    // $ANTLR start "SolidusEqualsSign"
    public final void mSolidusEqualsSign() throws RecognitionException {
        try {
            int _type = SolidusEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:175:19: ( '/' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:175:21: '/' '='
            {
            match('/'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SolidusEqualsSign"

    // $ANTLR start "ColonColon"
    public final void mColonColon() throws RecognitionException {
        try {
            int _type = ColonColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:177:12: ( ':' ':' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:177:14: ':' ':'
            {
            match(':'); 
            match(':'); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:179:29: ( '<' '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:179:31: '<' '>'
            {
            match('<'); 
            match('>'); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:181:22: ( '=' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:181:24: '=' '='
            {
            match('='); 
            match('='); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:183:27: ( '=' '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:183:29: '=' '>'
            {
            match('='); 
            match('>'); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:185:27: ( '>' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:185:29: '>' '='
            {
            match('>'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "QuestionMarkFullStop"
    public final void mQuestionMarkFullStop() throws RecognitionException {
        try {
            int _type = QuestionMarkFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:187:22: ( '?' '.' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:187:24: '?' '.'
            {
            match('?'); 
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMarkFullStop"

    // $ANTLR start "QuestionMarkColon"
    public final void mQuestionMarkColon() throws RecognitionException {
        try {
            int _type = QuestionMarkColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:189:19: ( '?' ':' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:189:21: '?' ':'
            {
            match('?'); 
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMarkColon"

    // $ANTLR start "As"
    public final void mAs() throws RecognitionException {
        try {
            int _type = As;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:191:4: ( ( 'A' | 'a' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:191:6: ( 'A' | 'a' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "As"

    // $ANTLR start "Do"
    public final void mDo() throws RecognitionException {
        try {
            int _type = Do;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:193:4: ( ( 'D' | 'd' ) ( 'O' | 'o' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:193:6: ( 'D' | 'd' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Do"

    // $ANTLR start "If"
    public final void mIf() throws RecognitionException {
        try {
            int _type = If;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:195:4: ( ( 'I' | 'i' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:195:6: ( 'I' | 'i' ) ( 'F' | 'f' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "If"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:197:26: ( '|' '|' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:197:28: '|' '|'
            {
            match('|'); 
            match('|'); 

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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:199:17: ( '!' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:199:19: '!'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:201:12: ( '#' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:201:14: '#'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:203:13: ( '%' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:203:15: '%'
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

    // $ANTLR start "Ampersand"
    public final void mAmpersand() throws RecognitionException {
        try {
            int _type = Ampersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:205:11: ( '&' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:205:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ampersand"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:207:17: ( '(' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:207:19: '('
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:209:18: ( ')' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:209:20: ')'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:211:10: ( '*' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:211:12: '*'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:10: ( '+' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:12: '+'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:215:7: ( ',' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:215:9: ','
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:13: ( '-' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:15: '-'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:10: ( '.' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:12: '.'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:9: ( '/' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:11: '/'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:223:7: ( ':' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:223:9: ':'
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

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:11: ( ';' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:227:14: ( '<' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:227:16: '<'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:229:12: ( '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:229:14: '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:231:17: ( '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:231:19: '>'
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

    // $ANTLR start "QuestionMark"
    public final void mQuestionMark() throws RecognitionException {
        try {
            int _type = QuestionMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:233:14: ( '?' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:233:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuestionMark"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:235:14: ( '@' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:235:16: '@'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:237:19: ( '[' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:237:21: '['
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:239:20: ( ']' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:239:22: ']'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:241:18: ( '{' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:241:20: '{'
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

    // $ANTLR start "VerticalLine"
    public final void mVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:243:14: ( '|' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:243:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLine"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:245:19: ( '}' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:245:21: '}'
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

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:12: ( '0x' | '0X' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='0') ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1=='x') ) {
                    alt1=1;
                }
                else if ( (LA1_1=='X') ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='#') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    {
                    match('#'); 
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='B'||LA3_0=='b') ) {
                        alt3=1;
                    }
                    else if ( (LA3_0=='L'||LA3_0=='l') ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:64: ( 'b' | 'B' ) ( 'i' | 'I' )
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
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:249:84: ( 'l' | 'L' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:251:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:251:12: '0' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('0','9'); 
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:251:21: ( '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||LA5_0=='_') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:
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
            	    break loop5;
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            {
            mRULE_INT(); 
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:36: ( '+' | '-' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='+'||LA6_0=='-') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:
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

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='B'||LA8_0=='b') ) {
                alt8=1;
            }
            else if ( (LA8_0=='D'||LA8_0=='F'||LA8_0=='L'||LA8_0=='d'||LA8_0=='f'||LA8_0=='l') ) {
                alt8=2;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
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
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:253:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:255:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:255:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:255:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:255:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:255:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='$'||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\"') ) {
                alt15=1;
            }
            else if ( (LA15_0=='\'') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )?
                    {
                    match('\"'); 
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop11;
                        }
                    } while (true);

                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:44: ( '\"' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\"') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:44: '\"'
                            {
                            match('\"'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:49: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )?
                    {
                    match('\''); 
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:54: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\\') ) {
                            alt13=1;
                        }
                        else if ( ((LA13_0>='\u0000' && LA13_0<='&')||(LA13_0>='(' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFF')) ) {
                            alt13=2;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:55: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:62: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop13;
                        }
                    } while (true);

                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:79: ( '\\'' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\'') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:257:79: '\\''
                            {
                            match('\''); 

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
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:259:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:259:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:259:24: ( options {greedy=false; } : . )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='*') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='/') ) {
                        alt16=2;
                    }
                    else if ( ((LA16_1>='\u0000' && LA16_1<='.')||(LA16_1>='0' && LA16_1<='\uFFFF')) ) {
                        alt16=1;
                    }


                }
                else if ( ((LA16_0>='\u0000' && LA16_0<=')')||(LA16_0>='+' && LA16_0<='\uFFFF')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:259:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop17;
                }
            } while (true);

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:261:41: '\\r'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:263:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:263:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:263:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='\t' && LA20_0<='\n')||LA20_0=='\r'||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:265:16: ( . )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:265:18: .
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
        // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:8: ( Timecriticality | Scheduleimpact | Maturityindex | Specification | Synchronized | Description | Familiarity | Requirement | Stakeholder | Uncertainty | Assumption | Costimpact | Instanceof | Volatility | Conflicts | Extension | Guarantee | Invariant | Mitigates | Predicate | Rationale | Riskindex | Category | Document | Compute | Default | Extends | Finally | Include | Refines | Section | Assert | Folder | Import | Issues | Output | Return | Static | Switch | Typeof | Catch | False | Goals | Input | Super | Throw | Value | While | Case | Else | Goal | Item | Null | This | True | With | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopLessThanSign | EqualsSignEqualsSignEqualsSign | All | For | Img | New | See | Try | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | HyphenMinusGreaterThanSign | FullStopFullStop | SolidusEqualsSign | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkFullStop | QuestionMarkColon | As | Do | If | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt21=123;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:10: Timecriticality
                {
                mTimecriticality(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:26: Scheduleimpact
                {
                mScheduleimpact(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:41: Maturityindex
                {
                mMaturityindex(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:55: Specification
                {
                mSpecification(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:69: Synchronized
                {
                mSynchronized(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:82: Description
                {
                mDescription(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:94: Familiarity
                {
                mFamiliarity(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:106: Requirement
                {
                mRequirement(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:118: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:130: Uncertainty
                {
                mUncertainty(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:142: Assumption
                {
                mAssumption(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:153: Costimpact
                {
                mCostimpact(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:164: Instanceof
                {
                mInstanceof(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:175: Volatility
                {
                mVolatility(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:186: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:196: Extension
                {
                mExtension(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:206: Guarantee
                {
                mGuarantee(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:216: Invariant
                {
                mInvariant(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:226: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:236: Predicate
                {
                mPredicate(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:246: Rationale
                {
                mRationale(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:256: Riskindex
                {
                mRiskindex(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:266: Category
                {
                mCategory(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:275: Document
                {
                mDocument(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:284: Compute
                {
                mCompute(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:292: Default
                {
                mDefault(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:300: Extends
                {
                mExtends(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:308: Finally
                {
                mFinally(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:316: Include
                {
                mInclude(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:324: Refines
                {
                mRefines(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:332: Section
                {
                mSection(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:340: Assert
                {
                mAssert(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:347: Folder
                {
                mFolder(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:354: Import
                {
                mImport(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:361: Issues
                {
                mIssues(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:368: Output
                {
                mOutput(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:375: Return
                {
                mReturn(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:382: Static
                {
                mStatic(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:389: Switch
                {
                mSwitch(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:396: Typeof
                {
                mTypeof(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:403: Catch
                {
                mCatch(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:409: False
                {
                mFalse(); 

                }
                break;
            case 43 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:415: Goals
                {
                mGoals(); 

                }
                break;
            case 44 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:421: Input
                {
                mInput(); 

                }
                break;
            case 45 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:427: Super
                {
                mSuper(); 

                }
                break;
            case 46 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:433: Throw
                {
                mThrow(); 

                }
                break;
            case 47 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:439: Value
                {
                mValue(); 

                }
                break;
            case 48 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:445: While
                {
                mWhile(); 

                }
                break;
            case 49 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:451: Case
                {
                mCase(); 

                }
                break;
            case 50 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:456: Else
                {
                mElse(); 

                }
                break;
            case 51 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:461: Goal
                {
                mGoal(); 

                }
                break;
            case 52 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:466: Item
                {
                mItem(); 

                }
                break;
            case 53 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:471: Null
                {
                mNull(); 

                }
                break;
            case 54 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:476: This
                {
                mThis(); 

                }
                break;
            case 55 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:481: True
                {
                mTrue(); 

                }
                break;
            case 56 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:486: With
                {
                mWith(); 

                }
                break;
            case 57 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:491: ExclamationMarkEqualsSignEqualsSign
                {
                mExclamationMarkEqualsSignEqualsSign(); 

                }
                break;
            case 58 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:527: FullStopFullStopLessThanSign
                {
                mFullStopFullStopLessThanSign(); 

                }
                break;
            case 59 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:556: EqualsSignEqualsSignEqualsSign
                {
                mEqualsSignEqualsSignEqualsSign(); 

                }
                break;
            case 60 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:587: All
                {
                mAll(); 

                }
                break;
            case 61 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:591: For
                {
                mFor(); 

                }
                break;
            case 62 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:595: Img
                {
                mImg(); 

                }
                break;
            case 63 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:599: New
                {
                mNew(); 

                }
                break;
            case 64 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:603: See
                {
                mSee(); 

                }
                break;
            case 65 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:607: Try
                {
                mTry(); 

                }
                break;
            case 66 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:611: Val
                {
                mVal(); 

                }
                break;
            case 67 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:615: Var
                {
                mVar(); 

                }
                break;
            case 68 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:619: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 69 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:645: PercentSignEqualsSign
                {
                mPercentSignEqualsSign(); 

                }
                break;
            case 70 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:667: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 71 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:686: AsteriskAsterisk
                {
                mAsteriskAsterisk(); 

                }
                break;
            case 72 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:703: AsteriskEqualsSign
                {
                mAsteriskEqualsSign(); 

                }
                break;
            case 73 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:722: PlusSignPlusSign
                {
                mPlusSignPlusSign(); 

                }
                break;
            case 74 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:739: PlusSignEqualsSign
                {
                mPlusSignEqualsSign(); 

                }
                break;
            case 75 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:758: HyphenMinusHyphenMinus
                {
                mHyphenMinusHyphenMinus(); 

                }
                break;
            case 76 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:781: HyphenMinusEqualsSign
                {
                mHyphenMinusEqualsSign(); 

                }
                break;
            case 77 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:803: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 78 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:830: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 79 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:847: SolidusEqualsSign
                {
                mSolidusEqualsSign(); 

                }
                break;
            case 80 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:865: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 81 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:876: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 82 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:904: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 83 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:925: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 84 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:951: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 85 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:977: QuestionMarkFullStop
                {
                mQuestionMarkFullStop(); 

                }
                break;
            case 86 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:998: QuestionMarkColon
                {
                mQuestionMarkColon(); 

                }
                break;
            case 87 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1016: As
                {
                mAs(); 

                }
                break;
            case 88 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1019: Do
                {
                mDo(); 

                }
                break;
            case 89 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1022: If
                {
                mIf(); 

                }
                break;
            case 90 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1025: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 91 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1050: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 92 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1066: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 93 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1077: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 94 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1089: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 95 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1099: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 96 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1115: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 97 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1132: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 98 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1141: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 99 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1150: Comma
                {
                mComma(); 

                }
                break;
            case 100 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1156: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 101 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1168: FullStop
                {
                mFullStop(); 

                }
                break;
            case 102 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1177: Solidus
                {
                mSolidus(); 

                }
                break;
            case 103 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1185: Colon
                {
                mColon(); 

                }
                break;
            case 104 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1191: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 105 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1201: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 106 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1214: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 107 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1225: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 108 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1241: QuestionMark
                {
                mQuestionMark(); 

                }
                break;
            case 109 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1254: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 110 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1267: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 111 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1285: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 112 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1304: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 113 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1321: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 114 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1334: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 115 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1352: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 116 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1361: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 117 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1370: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 118 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1383: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 119 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1391: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 120 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1403: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 121 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1419: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 122 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1435: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 123 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1443: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\1\uffff\21\66\1\137\1\141\1\144\1\146\1\150\1\153\1\156\1\162"+
        "\1\166\1\170\1\172\1\174\1\177\1\u0081\12\uffff\2\u008e\1\61\5\uffff"+
        "\4\66\1\uffff\12\66\1\u00a5\7\66\1\u00b2\7\66\1\u00c1\14\66\1\u00d0"+
        "\1\uffff\1\u00d2\1\uffff\1\u00d4\52\uffff\1\u008e\4\uffff\5\66\1"+
        "\u00da\5\66\1\u00e1\7\66\1\uffff\4\66\1\u00ed\7\66\1\uffff\1\u00f6"+
        "\12\66\1\u0102\2\66\1\uffff\1\66\1\u0107\1\u0108\11\66\1\u0112\6"+
        "\uffff\3\66\1\u0116\1\u0117\1\uffff\6\66\1\uffff\13\66\1\uffff\10"+
        "\66\1\uffff\5\66\1\u0136\5\66\1\uffff\1\66\1\u013d\2\66\2\uffff"+
        "\1\66\1\u0141\1\66\1\u0144\3\66\1\u0148\1\u0149\1\uffff\2\66\1\u014c"+
        "\2\uffff\7\66\1\u0154\6\66\1\u015b\16\66\1\u016a\1\uffff\3\66\1"+
        "\u016e\2\66\1\uffff\1\66\1\u0172\1\66\1\uffff\1\66\1\u0176\1\uffff"+
        "\2\66\1\u0179\2\uffff\1\66\1\u017b\1\uffff\4\66\1\u0180\1\66\1\u0182"+
        "\1\uffff\6\66\1\uffff\1\66\1\u018a\2\66\1\u018d\4\66\1\u0192\4\66"+
        "\1\uffff\3\66\1\uffff\1\u019a\1\u019b\1\66\1\uffff\3\66\1\uffff"+
        "\1\66\1\u01a1\1\uffff\1\66\1\uffff\4\66\1\uffff\1\u01a7\1\uffff"+
        "\3\66\1\u01ab\2\66\1\u01ae\1\uffff\1\66\1\u01b0\1\uffff\4\66\1\uffff"+
        "\2\66\1\u01b7\3\66\1\u01bb\2\uffff\2\66\1\u01be\2\66\1\uffff\5\66"+
        "\1\uffff\3\66\1\uffff\1\u01c9\1\66\1\uffff\1\66\1\uffff\6\66\1\uffff"+
        "\1\u01d2\2\66\1\uffff\2\66\1\uffff\10\66\1\u01df\1\66\1\uffff\2"+
        "\66\1\u01e3\1\u01e4\3\66\1\u01e8\1\uffff\1\66\1\u01ea\1\66\1\u01ec"+
        "\1\u01ed\1\u01ee\6\66\1\uffff\3\66\2\uffff\1\66\1\u01f9\1\u01fa"+
        "\1\uffff\1\u01fb\1\uffff\1\u01fc\3\uffff\4\66\1\u0201\1\66\1\u0203"+
        "\1\u0204\1\u0205\1\u0206\4\uffff\3\66\1\u020a\1\uffff\1\66\4\uffff"+
        "\2\66\1\u020e\1\uffff\1\u020f\1\66\1\u0211\2\uffff\1\u0212\2\uffff";
    static final String DFA21_eofS =
        "\u0213\uffff";
    static final String DFA21_minS =
        "\1\0\1\110\1\103\1\101\1\105\2\101\1\116\1\114\1\101\1\106\1\101"+
        "\1\114\1\117\1\122\1\125\1\110\1\105\1\75\1\56\2\75\1\46\1\52\1"+
        "\53\1\55\1\52\1\72\1\76\1\75\1\56\1\174\12\uffff\2\60\1\44\5\uffff"+
        "\1\115\1\120\1\111\1\125\1\uffff\1\110\1\105\1\116\1\101\1\103\1"+
        "\111\1\120\2\124\1\106\1\44\1\114\1\116\1\114\1\106\1\124\1\123"+
        "\1\103\1\44\1\114\1\115\1\123\1\103\1\107\1\123\1\105\1\44\2\114"+
        "\1\124\1\123\2\101\1\105\1\124\1\111\1\124\1\114\1\127\1\75\1\uffff"+
        "\1\74\1\uffff\1\75\52\uffff\1\60\4\uffff\2\105\1\117\1\123\1\105"+
        "\1\44\1\105\2\103\1\113\1\124\1\44\1\124\1\105\1\125\1\111\1\103"+
        "\1\101\1\125\1\uffff\1\111\1\123\1\101\1\104\1\44\1\125\1\111\1"+
        "\125\1\111\1\113\2\105\1\uffff\1\44\1\124\1\106\1\120\1\103\1\105"+
        "\1\124\1\101\1\114\1\125\1\117\1\44\1\125\1\115\1\uffff\1\101\2"+
        "\44\2\105\1\122\1\114\1\104\1\120\1\114\1\110\1\114\1\44\6\uffff"+
        "\1\103\1\117\1\127\2\44\1\uffff\1\104\1\111\1\110\1\105\2\111\1"+
        "\uffff\1\103\2\122\1\107\1\122\1\125\1\115\1\114\1\105\1\114\1\105"+
        "\1\uffff\1\111\1\116\1\122\1\117\1\111\1\122\1\115\1\122\1\uffff"+
        "\1\111\1\114\1\125\1\107\1\110\1\44\1\101\1\122\1\125\1\124\1\122"+
        "\1\uffff\1\105\1\44\1\124\1\105\2\uffff\1\116\1\44\1\101\1\44\1"+
        "\111\1\125\1\105\2\44\1\uffff\1\122\1\106\1\44\2\uffff\1\125\1\106"+
        "\1\122\1\110\1\103\1\117\1\110\1\44\1\111\1\101\1\111\1\114\1\105"+
        "\1\111\1\44\1\114\2\122\1\105\3\116\1\124\1\120\1\124\1\115\1\111"+
        "\1\124\1\117\1\44\1\uffff\1\116\1\111\1\104\1\44\1\124\1\123\1\uffff"+
        "\1\111\1\44\1\104\1\uffff\1\116\1\44\1\uffff\1\103\1\124\1\44\2"+
        "\uffff\1\111\1\44\1\uffff\1\114\1\111\2\117\1\44\1\116\1\44\1\uffff"+
        "\2\124\1\120\1\124\1\116\1\101\1\uffff\1\131\1\44\1\105\1\123\1"+
        "\44\1\101\1\104\1\101\1\124\1\44\1\120\1\103\1\105\1\122\1\uffff"+
        "\1\103\1\101\1\105\1\uffff\2\44\1\114\1\uffff\1\111\1\123\1\124"+
        "\1\uffff\1\101\1\44\1\uffff\1\124\1\uffff\1\105\1\103\1\116\1\114"+
        "\1\uffff\1\44\1\uffff\1\131\1\105\1\124\1\44\1\124\1\122\1\44\1"+
        "\uffff\1\115\1\44\1\uffff\1\114\1\105\2\111\1\uffff\1\101\1\124"+
        "\1\44\1\131\1\105\1\116\1\44\2\uffff\1\111\1\117\1\44\1\105\1\124"+
        "\1\uffff\2\111\1\101\1\111\1\104\1\uffff\1\111\1\123\1\111\1\uffff"+
        "\1\44\1\111\1\uffff\1\105\1\uffff\1\105\1\130\1\116\1\117\1\103"+
        "\1\123\1\uffff\1\44\1\117\1\124\1\uffff\1\124\1\116\1\uffff\2\105"+
        "\1\103\1\115\1\124\1\132\1\105\1\116\1\44\1\117\1\uffff\1\124\1"+
        "\116\2\44\1\124\1\116\1\124\1\44\1\uffff\1\106\1\44\1\131\3\44\1"+
        "\101\1\120\1\111\1\105\1\122\1\104\1\uffff\1\116\1\131\1\124\2\uffff"+
        "\1\131\2\44\1\uffff\1\44\1\uffff\1\44\3\uffff\1\114\1\101\1\117"+
        "\1\104\1\44\1\105\4\44\4\uffff\1\111\1\103\1\116\1\44\1\uffff\1"+
        "\130\4\uffff\2\124\1\44\1\uffff\1\44\1\131\1\44\2\uffff\1\44\2\uffff";
    static final String DFA21_maxS =
        "\1\uffff\2\171\1\151\2\157\1\151\1\156\1\163\1\157\1\164\1\157"+
        "\1\170\1\165\1\162\1\165\1\151\1\165\1\75\1\56\1\76\1\75\1\46\2"+
        "\75\1\76\1\75\1\72\1\76\1\75\1\72\1\174\12\uffff\1\170\1\154\1\172"+
        "\5\uffff\1\155\1\160\1\162\1\171\1\uffff\1\150\1\145\1\156\1\141"+
        "\1\145\1\151\1\160\2\164\1\163\1\172\1\155\1\156\1\162\2\164\1\163"+
        "\1\143\1\172\1\154\1\163\1\164\1\166\1\160\1\163\1\145\1\172\1\154"+
        "\1\162\1\164\1\163\2\141\1\145\1\164\1\151\1\164\1\154\1\167\1\75"+
        "\1\uffff\1\74\1\uffff\1\75\52\uffff\1\154\4\uffff\2\145\1\157\1"+
        "\163\1\145\1\172\1\145\2\143\2\164\1\172\1\164\1\145\1\165\1\151"+
        "\1\143\1\141\1\165\1\uffff\1\151\1\163\1\141\1\144\1\172\1\165\1"+
        "\151\1\165\1\151\1\153\1\145\1\165\1\uffff\1\172\1\164\1\146\1\160"+
        "\2\145\1\164\1\141\1\154\1\165\1\157\1\172\1\165\1\155\1\uffff\1"+
        "\141\2\172\2\145\1\162\1\154\1\144\1\160\1\154\1\150\1\154\1\172"+
        "\6\uffff\1\143\1\157\1\167\2\172\1\uffff\1\144\1\151\1\150\1\145"+
        "\2\151\1\uffff\1\143\2\162\1\147\1\162\1\165\1\155\1\154\1\145\1"+
        "\154\1\145\1\uffff\1\151\1\156\1\162\1\157\1\151\1\162\1\155\1\162"+
        "\1\uffff\1\151\1\154\1\165\1\147\1\150\1\172\1\141\1\162\1\165\1"+
        "\164\1\162\1\uffff\1\145\1\172\1\164\1\145\2\uffff\1\156\1\172\1"+
        "\141\1\172\1\151\1\165\1\145\2\172\1\uffff\1\162\1\146\1\172\2\uffff"+
        "\1\165\1\146\1\162\1\150\1\143\1\157\1\150\1\172\1\151\1\141\1\151"+
        "\1\154\1\145\1\151\1\172\1\154\2\162\1\145\3\156\1\164\1\160\1\164"+
        "\1\155\1\151\1\164\1\157\1\172\1\uffff\1\156\1\151\1\144\1\172\1"+
        "\164\1\163\1\uffff\1\151\1\172\1\163\1\uffff\1\156\1\172\1\uffff"+
        "\1\143\1\164\1\172\2\uffff\1\151\1\172\1\uffff\1\154\1\151\2\157"+
        "\1\172\1\156\1\172\1\uffff\2\164\1\160\1\164\1\156\1\141\1\uffff"+
        "\1\171\1\172\1\145\1\163\1\172\1\141\1\144\1\141\1\164\1\172\1\160"+
        "\1\143\1\145\1\162\1\uffff\1\143\1\141\1\145\1\uffff\2\172\1\154"+
        "\1\uffff\1\151\1\163\1\164\1\uffff\1\141\1\172\1\uffff\1\164\1\uffff"+
        "\1\145\1\143\1\156\1\154\1\uffff\1\172\1\uffff\1\171\1\145\1\164"+
        "\1\172\1\164\1\162\1\172\1\uffff\1\155\1\172\1\uffff\1\154\1\145"+
        "\2\151\1\uffff\1\141\1\164\1\172\1\171\1\145\1\156\1\172\2\uffff"+
        "\1\151\1\157\1\172\1\145\1\164\1\uffff\2\151\1\141\1\151\1\144\1"+
        "\uffff\1\151\1\163\1\151\1\uffff\1\172\1\151\1\uffff\1\145\1\uffff"+
        "\1\145\1\170\1\156\1\157\1\143\1\163\1\uffff\1\172\1\157\1\164\1"+
        "\uffff\1\164\1\156\1\uffff\2\145\1\143\1\155\1\164\1\172\1\145\1"+
        "\156\1\172\1\157\1\uffff\1\164\1\156\2\172\1\164\1\156\1\164\1\172"+
        "\1\uffff\1\146\1\172\1\171\3\172\1\141\1\160\1\151\1\145\1\162\1"+
        "\144\1\uffff\1\156\1\171\1\164\2\uffff\1\171\2\172\1\uffff\1\172"+
        "\1\uffff\1\172\3\uffff\1\154\1\141\1\157\1\144\1\172\1\145\4\172"+
        "\4\uffff\1\151\1\143\1\156\1\172\1\uffff\1\170\4\uffff\2\164\1\172"+
        "\1\uffff\1\172\1\171\1\172\2\uffff\1\172\2\uffff";
    static final String DFA21_acceptS =
        "\40\uffff\1\134\1\137\1\140\1\143\1\150\1\155\1\156\1\157\1\160"+
        "\1\162\3\uffff\1\166\2\167\1\172\1\173\4\uffff\1\166\50\uffff\1"+
        "\133\1\uffff\1\145\1\uffff\1\123\1\152\1\105\1\135\1\106\1\136\1"+
        "\107\1\110\1\141\1\111\1\112\1\142\1\113\1\114\1\115\1\144\1\117"+
        "\1\170\1\171\1\146\1\120\1\147\1\121\1\151\1\124\1\153\1\125\1\126"+
        "\1\154\1\132\1\161\1\134\1\137\1\140\1\143\1\150\1\155\1\156\1\157"+
        "\1\160\1\162\1\163\1\uffff\1\164\1\165\1\167\1\172\23\uffff\1\130"+
        "\14\uffff\1\127\16\uffff\1\131\15\uffff\1\71\1\104\1\72\1\116\1"+
        "\73\1\122\5\uffff\1\101\6\uffff\1\100\13\uffff\1\75\10\uffff\1\74"+
        "\13\uffff\1\76\4\uffff\1\102\1\103\11\uffff\1\77\3\uffff\1\66\1"+
        "\67\36\uffff\1\61\6\uffff\1\64\3\uffff\1\62\2\uffff\1\63\3\uffff"+
        "\1\70\1\65\2\uffff\1\56\7\uffff\1\55\6\uffff\1\52\16\uffff\1\51"+
        "\3\uffff\1\54\3\uffff\1\57\3\uffff\1\53\2\uffff\1\60\1\uffff\1\50"+
        "\4\uffff\1\46\1\uffff\1\47\7\uffff\1\41\2\uffff\1\45\4\uffff\1\40"+
        "\7\uffff\1\42\1\43\5\uffff\1\44\5\uffff\1\37\3\uffff\1\32\2\uffff"+
        "\1\34\1\uffff\1\36\6\uffff\1\31\3\uffff\1\35\2\uffff\1\33\12\uffff"+
        "\1\30\10\uffff\1\27\14\uffff\1\23\3\uffff\1\25\1\26\3\uffff\1\17"+
        "\1\uffff\1\22\1\uffff\1\20\1\21\1\24\12\uffff\1\13\1\14\1\15\1\16"+
        "\4\uffff\1\11\1\uffff\1\6\1\7\1\10\1\12\3\uffff\1\5\3\uffff\1\4"+
        "\1\3\1\uffff\1\2\1\1";
    static final String DFA21_specialS =
        "\1\0\u0212\uffff}>";
    static final String[] DFA21_transitionS = {
            "\11\61\2\60\2\61\1\60\22\61\1\60\1\22\1\56\1\40\1\55\1\25\1"+
            "\26\1\57\1\41\1\42\1\27\1\30\1\43\1\31\1\23\1\32\1\52\11\53"+
            "\1\33\1\44\1\34\1\24\1\35\1\36\1\45\1\10\1\55\1\11\1\4\1\14"+
            "\1\5\1\15\1\55\1\12\3\55\1\3\1\21\1\17\1\16\1\55\1\6\1\2\1\1"+
            "\1\7\1\13\1\20\3\55\1\46\1\61\1\47\1\54\1\55\1\61\1\10\1\55"+
            "\1\11\1\4\1\14\1\5\1\15\1\55\1\12\3\55\1\3\1\21\1\17\1\16\1"+
            "\55\1\6\1\2\1\1\1\7\1\13\1\20\3\55\1\50\1\37\1\51\uff82\61",
            "\1\64\1\62\10\uffff\1\65\6\uffff\1\63\16\uffff\1\64\1\62\10"+
            "\uffff\1\65\6\uffff\1\63",
            "\1\67\1\uffff\1\73\12\uffff\1\70\3\uffff\1\72\1\75\1\uffff"+
            "\1\74\1\uffff\1\71\11\uffff\1\67\1\uffff\1\73\12\uffff\1\70"+
            "\3\uffff\1\72\1\75\1\uffff\1\74\1\uffff\1\71",
            "\1\76\7\uffff\1\77\27\uffff\1\76\7\uffff\1\77",
            "\1\100\11\uffff\1\101\25\uffff\1\100\11\uffff\1\101",
            "\1\102\7\uffff\1\103\5\uffff\1\104\21\uffff\1\102\7\uffff"+
            "\1\103\5\uffff\1\104",
            "\1\106\3\uffff\1\105\3\uffff\1\107\27\uffff\1\106\3\uffff"+
            "\1\105\3\uffff\1\107",
            "\1\110\37\uffff\1\110",
            "\1\112\6\uffff\1\111\30\uffff\1\112\6\uffff\1\111",
            "\1\114\15\uffff\1\113\21\uffff\1\114\15\uffff\1\113",
            "\1\121\6\uffff\1\116\1\115\4\uffff\1\117\1\120\21\uffff\1"+
            "\121\6\uffff\1\116\1\115\4\uffff\1\117\1\120",
            "\1\123\15\uffff\1\122\21\uffff\1\123\15\uffff\1\122",
            "\1\125\13\uffff\1\124\23\uffff\1\125\13\uffff\1\124",
            "\1\127\5\uffff\1\126\31\uffff\1\127\5\uffff\1\126",
            "\1\130\37\uffff\1\130",
            "\1\131\37\uffff\1\131",
            "\1\132\1\133\36\uffff\1\132\1\133",
            "\1\135\17\uffff\1\134\17\uffff\1\135\17\uffff\1\134",
            "\1\136",
            "\1\140",
            "\1\142\1\143",
            "\1\145",
            "\1\147",
            "\1\151\22\uffff\1\152",
            "\1\154\21\uffff\1\155",
            "\1\157\17\uffff\1\160\1\161",
            "\1\164\4\uffff\1\165\15\uffff\1\163",
            "\1\167",
            "\1\171",
            "\1\173",
            "\1\175\13\uffff\1\176",
            "\1\u0080",
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
            "\12\u008d\10\uffff\1\u008f\1\uffff\3\u008f\5\uffff\1\u008f"+
            "\13\uffff\1\u008c\6\uffff\1\u008d\2\uffff\1\u008f\1\uffff\3"+
            "\u008f\5\uffff\1\u008f\13\uffff\1\u008c",
            "\12\u008d\10\uffff\1\u008f\1\uffff\3\u008f\5\uffff\1\u008f"+
            "\22\uffff\1\u008d\2\uffff\1\u008f\1\uffff\3\u008f\5\uffff\1"+
            "\u008f",
            "\1\66\34\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0095\10\uffff\1\u0094\26\uffff\1\u0095\10\uffff\1\u0094",
            "\1\u0096\3\uffff\1\u0097\33\uffff\1\u0096\3\uffff\1\u0097",
            "",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\1\uffff\1\u009d\35\uffff\1\u009c\1\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a3\14\uffff\1\u00a2\22\uffff\1\u00a3\14\uffff\1\u00a2",
            "\1\66\13\uffff\12\66\7\uffff\2\66\1\u00a4\27\66\4\uffff\1"+
            "\66\1\uffff\2\66\1\u00a4\27\66",
            "\1\u00a7\1\u00a6\36\uffff\1\u00a7\1\u00a6",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\5\uffff\1\u00aa\31\uffff\1\u00a9\5\uffff\1\u00aa",
            "\1\u00ac\12\uffff\1\u00ab\2\uffff\1\u00ad\21\uffff\1\u00ac"+
            "\12\uffff\1\u00ab\2\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\66\13\uffff\12\66\7\uffff\22\66\1\u00b1\7\66\4\uffff\1"+
            "\66\1\uffff\22\66\1\u00b1\7\66",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b6\1\u00b5\4\uffff\1\u00b4\31\uffff\1\u00b6\1\u00b5"+
            "\4\uffff\1\u00b4",
            "\1\u00b8\1\u00b7\36\uffff\1\u00b8\1\u00b7",
            "\1\u00bb\14\uffff\1\u00bc\2\uffff\1\u00b9\2\uffff\1\u00ba"+
            "\14\uffff\1\u00bb\14\uffff\1\u00bc\2\uffff\1\u00b9\2\uffff\1"+
            "\u00ba",
            "\1\u00be\10\uffff\1\u00bd\26\uffff\1\u00be\10\uffff\1\u00bd",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3\5\uffff\1\u00c4\31\uffff\1\u00c3\5\uffff\1\u00c4",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9\37\uffff\1\u00c9",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cc",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf",
            "",
            "\1\u00d1",
            "",
            "\1\u00d3",
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
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u008d\10\uffff\1\u008f\1\uffff\3\u008f\5\uffff\1\u008f"+
            "\22\uffff\1\u008d\2\uffff\1\u008f\1\uffff\3\u008f\5\uffff\1"+
            "\u008f",
            "",
            "",
            "",
            "",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u00db\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\10\uffff\1\u00df\26\uffff\1\u00de\10\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u00e2\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e3",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e8",
            "",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f0",
            "\1\u00f1\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f5\17\uffff\1\u00f4\17\uffff\1\u00f5\17\uffff\1\u00f4",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\u00fb\1\uffff\1\u00fa\35\uffff\1\u00fb\1\uffff\1\u00fa",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\u00fe\37\uffff\1\u00fe",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\u0100\37\uffff\1\u0100",
            "\1\u0101\37\uffff\1\u0101",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0103\37\uffff\1\u0103",
            "\1\u0104\37\uffff\1\u0104",
            "",
            "\1\u0105\37\uffff\1\u0105",
            "\1\66\13\uffff\12\66\7\uffff\24\66\1\u0106\5\66\4\uffff\1"+
            "\66\1\uffff\24\66\1\u0106\5\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "\1\u010b\37\uffff\1\u010b",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\1\u0110\37\uffff\1\u0110",
            "\1\u0111\37\uffff\1\u0111",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0113\37\uffff\1\u0113",
            "\1\u0114\37\uffff\1\u0114",
            "\1\u0115\37\uffff\1\u0115",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u0118\37\uffff\1\u0118",
            "\1\u0119\37\uffff\1\u0119",
            "\1\u011a\37\uffff\1\u011a",
            "\1\u011b\37\uffff\1\u011b",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "",
            "\1\u011e\37\uffff\1\u011e",
            "\1\u011f\37\uffff\1\u011f",
            "\1\u0120\37\uffff\1\u0120",
            "\1\u0121\37\uffff\1\u0121",
            "\1\u0122\37\uffff\1\u0122",
            "\1\u0123\37\uffff\1\u0123",
            "\1\u0124\37\uffff\1\u0124",
            "\1\u0125\37\uffff\1\u0125",
            "\1\u0126\37\uffff\1\u0126",
            "\1\u0127\37\uffff\1\u0127",
            "\1\u0128\37\uffff\1\u0128",
            "",
            "\1\u0129\37\uffff\1\u0129",
            "\1\u012a\37\uffff\1\u012a",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u012f",
            "\1\u0130\37\uffff\1\u0130",
            "",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "\1\u0133\37\uffff\1\u0133",
            "\1\u0134\37\uffff\1\u0134",
            "\1\u0135\37\uffff\1\u0135",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0137\37\uffff\1\u0137",
            "\1\u0138\37\uffff\1\u0138",
            "\1\u0139\37\uffff\1\u0139",
            "\1\u013a\37\uffff\1\u013a",
            "\1\u013b\37\uffff\1\u013b",
            "",
            "\1\u013c\37\uffff\1\u013c",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u013e\37\uffff\1\u013e",
            "\1\u013f\37\uffff\1\u013f",
            "",
            "",
            "\1\u0140\37\uffff\1\u0140",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0142\37\uffff\1\u0142",
            "\1\66\13\uffff\12\66\7\uffff\22\66\1\u0143\7\66\4\uffff\1"+
            "\66\1\uffff\22\66\1\u0143\7\66",
            "\1\u0145\37\uffff\1\u0145",
            "\1\u0146\37\uffff\1\u0146",
            "\1\u0147\37\uffff\1\u0147",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u014a\37\uffff\1\u014a",
            "\1\u014b\37\uffff\1\u014b",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "\1\u014d\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\1\u014f\37\uffff\1\u014f",
            "\1\u0150\37\uffff\1\u0150",
            "\1\u0151\37\uffff\1\u0151",
            "\1\u0152\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0153",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0155\37\uffff\1\u0155",
            "\1\u0156\37\uffff\1\u0156",
            "\1\u0157\37\uffff\1\u0157",
            "\1\u0158\37\uffff\1\u0158",
            "\1\u0159\37\uffff\1\u0159",
            "\1\u015a\37\uffff\1\u015a",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u015c\37\uffff\1\u015c",
            "\1\u015d\37\uffff\1\u015d",
            "\1\u015e\37\uffff\1\u015e",
            "\1\u015f\37\uffff\1\u015f",
            "\1\u0160\37\uffff\1\u0160",
            "\1\u0161\37\uffff\1\u0161",
            "\1\u0162\37\uffff\1\u0162",
            "\1\u0163\37\uffff\1\u0163",
            "\1\u0164\37\uffff\1\u0164",
            "\1\u0165\37\uffff\1\u0165",
            "\1\u0166\37\uffff\1\u0166",
            "\1\u0167\37\uffff\1\u0167",
            "\1\u0168\37\uffff\1\u0168",
            "\1\u0169\37\uffff\1\u0169",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u016b\37\uffff\1\u016b",
            "\1\u016c\37\uffff\1\u016c",
            "\1\u016d\37\uffff\1\u016d",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u016f\37\uffff\1\u016f",
            "\1\u0170\37\uffff\1\u0170",
            "",
            "\1\u0171\37\uffff\1\u0171",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0174\16\uffff\1\u0173\20\uffff\1\u0174\16\uffff\1\u0173",
            "",
            "\1\u0175\37\uffff\1\u0175",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u0177\37\uffff\1\u0177",
            "\1\u0178\37\uffff\1\u0178",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "\1\u017a\37\uffff\1\u017a",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u017c\37\uffff\1\u017c",
            "\1\u017d\37\uffff\1\u017d",
            "\1\u017e\37\uffff\1\u017e",
            "\1\u017f\37\uffff\1\u017f",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0181\37\uffff\1\u0181",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u0183\37\uffff\1\u0183",
            "\1\u0184\37\uffff\1\u0184",
            "\1\u0185\37\uffff\1\u0185",
            "\1\u0186\37\uffff\1\u0186",
            "\1\u0187\37\uffff\1\u0187",
            "\1\u0188\37\uffff\1\u0188",
            "",
            "\1\u0189\37\uffff\1\u0189",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u018b\37\uffff\1\u018b",
            "\1\u018c\37\uffff\1\u018c",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u018e\37\uffff\1\u018e",
            "\1\u018f\37\uffff\1\u018f",
            "\1\u0190\37\uffff\1\u0190",
            "\1\u0191\37\uffff\1\u0191",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0193\37\uffff\1\u0193",
            "\1\u0194\37\uffff\1\u0194",
            "\1\u0195\37\uffff\1\u0195",
            "\1\u0196\37\uffff\1\u0196",
            "",
            "\1\u0197\37\uffff\1\u0197",
            "\1\u0198\37\uffff\1\u0198",
            "\1\u0199\37\uffff\1\u0199",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u019c\37\uffff\1\u019c",
            "",
            "\1\u019d\37\uffff\1\u019d",
            "\1\u019e\37\uffff\1\u019e",
            "\1\u019f\37\uffff\1\u019f",
            "",
            "\1\u01a0\37\uffff\1\u01a0",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u01a2\37\uffff\1\u01a2",
            "",
            "\1\u01a3\37\uffff\1\u01a3",
            "\1\u01a4\37\uffff\1\u01a4",
            "\1\u01a5\37\uffff\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a6",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u01a8\37\uffff\1\u01a8",
            "\1\u01a9\37\uffff\1\u01a9",
            "\1\u01aa\37\uffff\1\u01aa",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01ac\37\uffff\1\u01ac",
            "\1\u01ad\37\uffff\1\u01ad",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u01af\37\uffff\1\u01af",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u01b1\37\uffff\1\u01b1",
            "\1\u01b2\37\uffff\1\u01b2",
            "\1\u01b3\37\uffff\1\u01b3",
            "\1\u01b4\37\uffff\1\u01b4",
            "",
            "\1\u01b5\37\uffff\1\u01b5",
            "\1\u01b6\37\uffff\1\u01b6",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01b8\37\uffff\1\u01b8",
            "\1\u01b9\37\uffff\1\u01b9",
            "\1\u01ba\37\uffff\1\u01ba",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "\1\u01bc\37\uffff\1\u01bc",
            "\1\u01bd\37\uffff\1\u01bd",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01bf\37\uffff\1\u01bf",
            "\1\u01c0\37\uffff\1\u01c0",
            "",
            "\1\u01c1\37\uffff\1\u01c1",
            "\1\u01c2\37\uffff\1\u01c2",
            "\1\u01c3\37\uffff\1\u01c3",
            "\1\u01c4\37\uffff\1\u01c4",
            "\1\u01c5\37\uffff\1\u01c5",
            "",
            "\1\u01c6\37\uffff\1\u01c6",
            "\1\u01c7\37\uffff\1\u01c7",
            "\1\u01c8\37\uffff\1\u01c8",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01ca\37\uffff\1\u01ca",
            "",
            "\1\u01cb\37\uffff\1\u01cb",
            "",
            "\1\u01cc\37\uffff\1\u01cc",
            "\1\u01cd\37\uffff\1\u01cd",
            "\1\u01ce\37\uffff\1\u01ce",
            "\1\u01cf\37\uffff\1\u01cf",
            "\1\u01d0\37\uffff\1\u01d0",
            "\1\u01d1\37\uffff\1\u01d1",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01d3\37\uffff\1\u01d3",
            "\1\u01d4\37\uffff\1\u01d4",
            "",
            "\1\u01d5\37\uffff\1\u01d5",
            "\1\u01d6\37\uffff\1\u01d6",
            "",
            "\1\u01d7\37\uffff\1\u01d7",
            "\1\u01d8\37\uffff\1\u01d8",
            "\1\u01d9\37\uffff\1\u01d9",
            "\1\u01da\37\uffff\1\u01da",
            "\1\u01db\37\uffff\1\u01db",
            "\1\u01dc\37\uffff\1\u01dc",
            "\1\u01dd\37\uffff\1\u01dd",
            "\1\u01de\37\uffff\1\u01de",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01e0\37\uffff\1\u01e0",
            "",
            "\1\u01e1\37\uffff\1\u01e1",
            "\1\u01e2\37\uffff\1\u01e2",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01e5\37\uffff\1\u01e5",
            "\1\u01e6\37\uffff\1\u01e6",
            "\1\u01e7\37\uffff\1\u01e7",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u01e9\37\uffff\1\u01e9",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01eb\37\uffff\1\u01eb",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u01ef\37\uffff\1\u01ef",
            "\1\u01f0\37\uffff\1\u01f0",
            "\1\u01f1\37\uffff\1\u01f1",
            "\1\u01f2\37\uffff\1\u01f2",
            "\1\u01f3\37\uffff\1\u01f3",
            "\1\u01f4\37\uffff\1\u01f4",
            "",
            "\1\u01f5\37\uffff\1\u01f5",
            "\1\u01f6\37\uffff\1\u01f6",
            "\1\u01f7\37\uffff\1\u01f7",
            "",
            "",
            "\1\u01f8\37\uffff\1\u01f8",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "",
            "\1\u01fd\37\uffff\1\u01fd",
            "\1\u01fe\37\uffff\1\u01fe",
            "\1\u01ff\37\uffff\1\u01ff",
            "\1\u0200\37\uffff\1\u0200",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0202\37\uffff\1\u0202",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "",
            "",
            "\1\u0207\37\uffff\1\u0207",
            "\1\u0208\37\uffff\1\u0208",
            "\1\u0209\37\uffff\1\u0209",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\u020b\37\uffff\1\u020b",
            "",
            "",
            "",
            "",
            "\1\u020c\37\uffff\1\u020c",
            "\1\u020d\37\uffff\1\u020d",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "\1\u0210\37\uffff\1\u0210",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            "",
            "\1\66\13\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32"+
            "\66",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    static class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Timecriticality | Scheduleimpact | Maturityindex | Specification | Synchronized | Description | Familiarity | Requirement | Stakeholder | Uncertainty | Assumption | Costimpact | Instanceof | Volatility | Conflicts | Extension | Guarantee | Invariant | Mitigates | Predicate | Rationale | Riskindex | Category | Document | Compute | Default | Extends | Finally | Include | Refines | Section | Assert | Folder | Import | Issues | Output | Return | Static | Switch | Typeof | Catch | False | Goals | Input | Super | Throw | Value | While | Case | Else | Goal | Item | Null | This | True | With | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopLessThanSign | EqualsSignEqualsSignEqualsSign | All | For | Img | New | See | Try | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | HyphenMinusGreaterThanSign | FullStopFullStop | SolidusEqualsSign | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkFullStop | QuestionMarkColon | As | Do | If | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='T'||LA21_0=='t') ) {s = 1;}

                        else if ( (LA21_0=='S'||LA21_0=='s') ) {s = 2;}

                        else if ( (LA21_0=='M'||LA21_0=='m') ) {s = 3;}

                        else if ( (LA21_0=='D'||LA21_0=='d') ) {s = 4;}

                        else if ( (LA21_0=='F'||LA21_0=='f') ) {s = 5;}

                        else if ( (LA21_0=='R'||LA21_0=='r') ) {s = 6;}

                        else if ( (LA21_0=='U'||LA21_0=='u') ) {s = 7;}

                        else if ( (LA21_0=='A'||LA21_0=='a') ) {s = 8;}

                        else if ( (LA21_0=='C'||LA21_0=='c') ) {s = 9;}

                        else if ( (LA21_0=='I'||LA21_0=='i') ) {s = 10;}

                        else if ( (LA21_0=='V'||LA21_0=='v') ) {s = 11;}

                        else if ( (LA21_0=='E'||LA21_0=='e') ) {s = 12;}

                        else if ( (LA21_0=='G'||LA21_0=='g') ) {s = 13;}

                        else if ( (LA21_0=='P'||LA21_0=='p') ) {s = 14;}

                        else if ( (LA21_0=='O'||LA21_0=='o') ) {s = 15;}

                        else if ( (LA21_0=='W'||LA21_0=='w') ) {s = 16;}

                        else if ( (LA21_0=='N'||LA21_0=='n') ) {s = 17;}

                        else if ( (LA21_0=='!') ) {s = 18;}

                        else if ( (LA21_0=='.') ) {s = 19;}

                        else if ( (LA21_0=='=') ) {s = 20;}

                        else if ( (LA21_0=='%') ) {s = 21;}

                        else if ( (LA21_0=='&') ) {s = 22;}

                        else if ( (LA21_0=='*') ) {s = 23;}

                        else if ( (LA21_0=='+') ) {s = 24;}

                        else if ( (LA21_0=='-') ) {s = 25;}

                        else if ( (LA21_0=='/') ) {s = 26;}

                        else if ( (LA21_0==':') ) {s = 27;}

                        else if ( (LA21_0=='<') ) {s = 28;}

                        else if ( (LA21_0=='>') ) {s = 29;}

                        else if ( (LA21_0=='?') ) {s = 30;}

                        else if ( (LA21_0=='|') ) {s = 31;}

                        else if ( (LA21_0=='#') ) {s = 32;}

                        else if ( (LA21_0=='(') ) {s = 33;}

                        else if ( (LA21_0==')') ) {s = 34;}

                        else if ( (LA21_0==',') ) {s = 35;}

                        else if ( (LA21_0==';') ) {s = 36;}

                        else if ( (LA21_0=='@') ) {s = 37;}

                        else if ( (LA21_0=='[') ) {s = 38;}

                        else if ( (LA21_0==']') ) {s = 39;}

                        else if ( (LA21_0=='{') ) {s = 40;}

                        else if ( (LA21_0=='}') ) {s = 41;}

                        else if ( (LA21_0=='0') ) {s = 42;}

                        else if ( ((LA21_0>='1' && LA21_0<='9')) ) {s = 43;}

                        else if ( (LA21_0=='^') ) {s = 44;}

                        else if ( (LA21_0=='$'||LA21_0=='B'||LA21_0=='H'||(LA21_0>='J' && LA21_0<='L')||LA21_0=='Q'||(LA21_0>='X' && LA21_0<='Z')||LA21_0=='_'||LA21_0=='b'||LA21_0=='h'||(LA21_0>='j' && LA21_0<='l')||LA21_0=='q'||(LA21_0>='x' && LA21_0<='z')) ) {s = 45;}

                        else if ( (LA21_0=='\"') ) {s = 46;}

                        else if ( (LA21_0=='\'') ) {s = 47;}

                        else if ( ((LA21_0>='\t' && LA21_0<='\n')||LA21_0=='\r'||LA21_0==' ') ) {s = 48;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='\\'||LA21_0=='`'||(LA21_0>='~' && LA21_0<='\uFFFF')) ) {s = 49;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}