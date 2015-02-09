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
    public static final int Switch=29;
    public static final int RULE_ID=103;
    public static final int Inv=48;
    public static final int RightParenthesis=82;
    public static final int Static=28;
    public static final int Specification=4;
    public static final int Constants=11;
    public static final int RULE_ANY_OTHER=108;
    public static final int ExclamationMark=77;
    public static final int LeftParenthesis=81;
    public static final int RightSquareBracket=96;
    public static final int Extends=19;
    public static final int Solidus=88;
    public static final int EOF=-1;
    public static final int EqualsSignEqualsSign=68;
    public static final int FullStop=87;
    public static final int Finally=20;
    public static final int PercentSign=79;
    public static final int Default=18;
    public static final int RULE_HEX=100;
    public static final int LessThanSign=91;
    public static final int Do=74;
    public static final int PlusSignPlusSign=59;
    public static final int RULE_DECIMAL=102;
    public static final int FullStopFullStop=64;
    public static final int Conflicts=10;
    public static final int Null=40;
    public static final int PercentSignEqualsSign=55;
    public static final int Stakeholder=8;
    public static final int This=41;
    public static final int LeftCurlyBracket=97;
    public static final int Colon=89;
    public static final int NumberSign=78;
    public static final int With=43;
    public static final int RULE_ML_COMMENT=105;
    public static final int Goals=33;
    public static final int RULE_STRING=104;
    public static final int VerticalLine=98;
    public static final int HyphenMinusEqualsSign=62;
    public static final int ExclamationMarkEqualsSignEqualsSign=44;
    public static final int Else=38;
    public static final int Val=52;
    public static final int Var=53;
    public static final int HyphenMinusGreaterThanSign=63;
    public static final int RightCurlyBracket=99;
    public static final int Typeof=30;
    public static final int QuestionMarkFullStop=71;
    public static final int Try=51;
    public static final int VerticalLineVerticalLine=76;
    public static final int HyphenMinus=86;
    public static final int AmpersandAmpersand=56;
    public static final int Assert=24;
    public static final int False=32;
    public static final int QuestionMarkColon=72;
    public static final int Constant=16;
    public static final int Extension=12;
    public static final int While=36;
    public static final int Mitigates=13;
    public static final int Requirement=7;
    public static final int LessThanSignGreaterThanSign=67;
    public static final int Case=37;
    public static final int GreaterThanSign=93;
    public static final int HyphenMinusHyphenMinus=61;
    public static final int EqualsSignGreaterThanSign=69;
    public static final int RULE_INT=101;
    public static final int EqualsSignEqualsSignEqualsSign=46;
    public static final int AsteriskAsterisk=57;
    public static final int Synchronized=5;
    public static final int LeftSquareBracket=95;
    public static final int True=42;
    public static final int Return=27;
    public static final int Refines=22;
    public static final int If=75;
    public static final int ExclamationMarkEqualsSign=54;
    public static final int Asterisk=83;
    public static final int Import=26;
    public static final int As=73;
    public static final int Catch=31;
    public static final int Super=34;
    public static final int Throw=35;
    public static final int SolidusEqualsSign=65;
    public static final int Semicolon=90;
    public static final int RULE_SL_COMMENT=106;
    public static final int For=47;
    public static final int Include=21;
    public static final int Rationale=14;
    public static final int Goal=39;
    public static final int Ampersand=80;
    public static final int ColonColon=66;
    public static final int Description=6;
    public static final int Document=17;
    public static final int Folder=25;
    public static final int PlusSign=84;
    public static final int New=49;
    public static final int AsteriskEqualsSign=58;
    public static final int See=50;
    public static final int Instanceof=9;
    public static final int FullStopFullStopLessThanSign=45;
    public static final int PlusSignEqualsSign=60;
    public static final int Section=23;
    public static final int Category=15;
    public static final int GreaterThanSignEqualsSign=70;
    public static final int QuestionMark=94;
    public static final int RULE_WS=107;
    public static final int EqualsSign=92;
    public static final int Comma=85;

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

    // $ANTLR start "Specification"
    public final void mSpecification() throws RecognitionException {
        try {
            int _type = Specification;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:19:15: ( ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:19:17: ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:21:14: ( ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Z' | 'z' ) ( 'E' | 'e' ) ( 'D' | 'd' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:21:16: ( 'S' | 's' ) ( 'Y' | 'y' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Z' | 'z' ) ( 'E' | 'e' ) ( 'D' | 'd' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:23:13: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:23:15: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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

    // $ANTLR start "Requirement"
    public final void mRequirement() throws RecognitionException {
        try {
            int _type = Requirement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:25:13: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:25:15: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:27:13: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:27:15: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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

    // $ANTLR start "Instanceof"
    public final void mInstanceof() throws RecognitionException {
        try {
            int _type = Instanceof;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:29:12: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:29:14: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' )
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

    // $ANTLR start "Conflicts"
    public final void mConflicts() throws RecognitionException {
        try {
            int _type = Conflicts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:31:11: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:31:13: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' )
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

    // $ANTLR start "Constants"
    public final void mConstants() throws RecognitionException {
        try {
            int _type = Constants;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:33:11: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:33:13: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'S' | 's' )
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
    // $ANTLR end "Constants"

    // $ANTLR start "Extension"
    public final void mExtension() throws RecognitionException {
        try {
            int _type = Extension;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:35:11: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:35:13: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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

    // $ANTLR start "Mitigates"
    public final void mMitigates() throws RecognitionException {
        try {
            int _type = Mitigates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:37:11: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:37:13: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' )
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

    // $ANTLR start "Rationale"
    public final void mRationale() throws RecognitionException {
        try {
            int _type = Rationale;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:39:11: ( ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:39:13: ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' )
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

    // $ANTLR start "Category"
    public final void mCategory() throws RecognitionException {
        try {
            int _type = Category;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:41:10: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:41:12: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
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

    // $ANTLR start "Constant"
    public final void mConstant() throws RecognitionException {
        try {
            int _type = Constant;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:43:10: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:43:12: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' )
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
    // $ANTLR end "Constant"

    // $ANTLR start "Document"
    public final void mDocument() throws RecognitionException {
        try {
            int _type = Document;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:45:10: ( ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:45:12: ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
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

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:47:9: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:47:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:49:9: ( ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:49:11: ( 'E' | 'e' ) ( 'X' | 'x' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'S' | 's' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:51:9: ( ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:51:11: ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'Y' | 'y' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:53:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:53:11: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:55:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:55:11: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'S' | 's' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:57:9: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:57:11: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:59:8: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:59:10: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:61:8: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:61:10: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:63:8: ( ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:63:10: ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
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

    // $ANTLR start "Return"
    public final void mReturn() throws RecognitionException {
        try {
            int _type = Return;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:65:8: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:65:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'R' | 'r' ) ( 'N' | 'n' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:67:8: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:67:10: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'C' | 'c' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:69:8: ( ( 'S' | 's' ) ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:69:10: ( 'S' | 's' ) ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:71:8: ( ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:71:10: ( 'T' | 't' ) ( 'Y' | 'y' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'O' | 'o' ) ( 'F' | 'f' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:73:7: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:73:9: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:75:7: ( ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:75:9: ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:77:7: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:77:9: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' )
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

    // $ANTLR start "Super"
    public final void mSuper() throws RecognitionException {
        try {
            int _type = Super;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:79:7: ( ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:79:9: ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:81:7: ( ( 'T' | 't' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:81:9: ( 'T' | 't' ) ( 'H' | 'h' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'W' | 'w' )
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

    // $ANTLR start "While"
    public final void mWhile() throws RecognitionException {
        try {
            int _type = While;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:83:7: ( ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:83:9: ( 'W' | 'w' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'L' | 'l' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:85:6: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:85:8: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:87:6: ( ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:87:8: ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:89:6: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:89:8: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:91:6: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:91:8: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:93:6: ( ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:93:8: ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:95:6: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:95:8: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:97:6: ( ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:97:8: ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:99:37: ( '!' '=' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:99:39: '!' '=' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:101:30: ( '.' '.' '<' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:101:32: '.' '.' '<'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:103:32: ( '=' '=' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:103:34: '=' '=' '='
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

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:105:5: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:105:7: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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

    // $ANTLR start "Inv"
    public final void mInv() throws RecognitionException {
        try {
            int _type = Inv;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:107:5: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:107:7: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'V' | 'v' )
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Inv"

    // $ANTLR start "New"
    public final void mNew() throws RecognitionException {
        try {
            int _type = New;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:109:5: ( ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:109:7: ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'W' | 'w' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:111:5: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:111:7: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:113:5: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:113:7: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:115:5: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:115:7: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:117:5: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:117:7: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'R' | 'r' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:119:27: ( '!' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:119:29: '!' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:121:23: ( '%' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:121:25: '%' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:123:20: ( '&' '&' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:123:22: '&' '&'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:125:18: ( '*' '*' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:125:20: '*' '*'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:127:20: ( '*' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:127:22: '*' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:129:18: ( '+' '+' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:129:20: '+' '+'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:131:20: ( '+' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:131:22: '+' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:133:24: ( '-' '-' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:133:26: '-' '-'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:135:23: ( '-' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:135:25: '-' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:137:28: ( '-' '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:137:30: '-' '>'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:139:18: ( '.' '.' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:139:20: '.' '.'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:141:19: ( '/' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:141:21: '/' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:143:12: ( ':' ':' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:143:14: ':' ':'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:145:29: ( '<' '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:145:31: '<' '>'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:147:22: ( '=' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:147:24: '=' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:149:27: ( '=' '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:149:29: '=' '>'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:151:27: ( '>' '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:151:29: '>' '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:153:22: ( '?' '.' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:153:24: '?' '.'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:155:19: ( '?' ':' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:155:21: '?' ':'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:157:4: ( ( 'A' | 'a' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:157:6: ( 'A' | 'a' ) ( 'S' | 's' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:159:4: ( ( 'D' | 'd' ) ( 'O' | 'o' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:159:6: ( 'D' | 'd' ) ( 'O' | 'o' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:161:4: ( ( 'I' | 'i' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:161:6: ( 'I' | 'i' ) ( 'F' | 'f' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:163:26: ( '|' '|' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:163:28: '|' '|'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:165:17: ( '!' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:165:19: '!'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:167:12: ( '#' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:167:14: '#'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:169:13: ( '%' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:169:15: '%'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:171:11: ( '&' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:171:13: '&'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:173:17: ( '(' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:173:19: '('
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:175:18: ( ')' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:175:20: ')'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:177:10: ( '*' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:177:12: '*'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:179:10: ( '+' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:179:12: '+'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:181:7: ( ',' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:181:9: ','
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:183:13: ( '-' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:183:15: '-'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:185:10: ( '.' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:185:12: '.'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:187:9: ( '/' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:187:11: '/'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:189:7: ( ':' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:189:9: ':'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:191:11: ( ';' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:191:13: ';'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:193:14: ( '<' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:193:16: '<'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:195:12: ( '=' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:195:14: '='
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:197:17: ( '>' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:197:19: '>'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:199:14: ( '?' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:199:16: '?'
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

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:201:19: ( '[' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:201:21: '['
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:203:20: ( ']' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:203:22: ']'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:205:18: ( '{' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:205:20: '{'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:207:14: ( '|' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:207:16: '|'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:209:19: ( '}' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:209:21: '}'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:10: ( ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )? )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:12: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+ ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:12: ( '0x' | '0X' )
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
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:13: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:18: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:24: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' | '_' )+
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

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:58: ( '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='#') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:59: '#' ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
                    {
                    match('#'); 
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:63: ( ( 'b' | 'B' ) ( 'i' | 'I' ) | ( 'l' | 'L' ) )
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
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:64: ( 'b' | 'B' ) ( 'i' | 'I' )
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
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:213:84: ( 'l' | 'L' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:215:10: ( '0' .. '9' ( '0' .. '9' | '_' )* )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:215:12: '0' .. '9' ( '0' .. '9' | '_' )*
            {
            matchRange('0','9'); 
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:215:21: ( '0' .. '9' | '_' )*
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:14: ( RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )? )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:16: RULE_INT ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )? ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
            {
            mRULE_INT(); 
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:25: ( ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E'||LA7_0=='e') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:26: ( 'e' | 'E' ) ( '+' | '-' )? RULE_INT
                    {
                    if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:36: ( '+' | '-' )?
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

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:58: ( ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' ) | ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' ) )?
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
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:59: ( 'b' | 'B' ) ( 'i' | 'I' | 'd' | 'D' )
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
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:217:87: ( 'l' | 'L' | 'd' | 'D' | 'f' | 'F' )
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:11: ( '^' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='^') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:11: '^'
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

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:219:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? ) )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
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
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )?
                    {
                    match('\"'); 
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:28: ~ ( ( '\\\\' | '\"' ) )
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

                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:44: ( '\"' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\"') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:44: '\"'
                            {
                            match('\"'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:49: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )?
                    {
                    match('\''); 
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:54: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:55: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:62: ~ ( ( '\\\\' | '\\'' ) )
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

                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:79: ( '\\'' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\'') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:221:79: '\\''
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:223:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:223:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:223:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:223:52: .
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:40: ( ( '\\r' )? '\\n' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:41: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:225:41: '\\r'
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:227:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:227:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:227:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:229:16: ( . )
            // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:229:18: .
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
        // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:8: ( Specification | Synchronized | Description | Requirement | Stakeholder | Instanceof | Conflicts | Constants | Extension | Mitigates | Rationale | Category | Constant | Document | Default | Extends | Finally | Include | Refines | Section | Assert | Folder | Import | Return | Static | Switch | Typeof | Catch | False | Goals | Super | Throw | While | Case | Else | Goal | Null | This | True | With | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopLessThanSign | EqualsSignEqualsSignEqualsSign | For | Inv | New | See | Try | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | HyphenMinusGreaterThanSign | FullStopFullStop | SolidusEqualsSign | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkFullStop | QuestionMarkColon | As | Do | If | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt21=105;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:10: Specification
                {
                mSpecification(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:24: Synchronized
                {
                mSynchronized(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:37: Description
                {
                mDescription(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:49: Requirement
                {
                mRequirement(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:61: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:73: Instanceof
                {
                mInstanceof(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:84: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:94: Constants
                {
                mConstants(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:104: Extension
                {
                mExtension(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:114: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:124: Rationale
                {
                mRationale(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:134: Category
                {
                mCategory(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:143: Constant
                {
                mConstant(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:152: Document
                {
                mDocument(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:161: Default
                {
                mDefault(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:169: Extends
                {
                mExtends(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:177: Finally
                {
                mFinally(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:185: Include
                {
                mInclude(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:193: Refines
                {
                mRefines(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:201: Section
                {
                mSection(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:209: Assert
                {
                mAssert(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:216: Folder
                {
                mFolder(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:223: Import
                {
                mImport(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:230: Return
                {
                mReturn(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:237: Static
                {
                mStatic(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:244: Switch
                {
                mSwitch(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:251: Typeof
                {
                mTypeof(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:258: Catch
                {
                mCatch(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:264: False
                {
                mFalse(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:270: Goals
                {
                mGoals(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:276: Super
                {
                mSuper(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:282: Throw
                {
                mThrow(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:288: While
                {
                mWhile(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:294: Case
                {
                mCase(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:299: Else
                {
                mElse(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:304: Goal
                {
                mGoal(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:309: Null
                {
                mNull(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:314: This
                {
                mThis(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:319: True
                {
                mTrue(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:324: With
                {
                mWith(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:329: ExclamationMarkEqualsSignEqualsSign
                {
                mExclamationMarkEqualsSignEqualsSign(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:365: FullStopFullStopLessThanSign
                {
                mFullStopFullStopLessThanSign(); 

                }
                break;
            case 43 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:394: EqualsSignEqualsSignEqualsSign
                {
                mEqualsSignEqualsSignEqualsSign(); 

                }
                break;
            case 44 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:425: For
                {
                mFor(); 

                }
                break;
            case 45 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:429: Inv
                {
                mInv(); 

                }
                break;
            case 46 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:433: New
                {
                mNew(); 

                }
                break;
            case 47 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:437: See
                {
                mSee(); 

                }
                break;
            case 48 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:441: Try
                {
                mTry(); 

                }
                break;
            case 49 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:445: Val
                {
                mVal(); 

                }
                break;
            case 50 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:449: Var
                {
                mVar(); 

                }
                break;
            case 51 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:453: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 52 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:479: PercentSignEqualsSign
                {
                mPercentSignEqualsSign(); 

                }
                break;
            case 53 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:501: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 54 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:520: AsteriskAsterisk
                {
                mAsteriskAsterisk(); 

                }
                break;
            case 55 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:537: AsteriskEqualsSign
                {
                mAsteriskEqualsSign(); 

                }
                break;
            case 56 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:556: PlusSignPlusSign
                {
                mPlusSignPlusSign(); 

                }
                break;
            case 57 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:573: PlusSignEqualsSign
                {
                mPlusSignEqualsSign(); 

                }
                break;
            case 58 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:592: HyphenMinusHyphenMinus
                {
                mHyphenMinusHyphenMinus(); 

                }
                break;
            case 59 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:615: HyphenMinusEqualsSign
                {
                mHyphenMinusEqualsSign(); 

                }
                break;
            case 60 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:637: HyphenMinusGreaterThanSign
                {
                mHyphenMinusGreaterThanSign(); 

                }
                break;
            case 61 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:664: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 62 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:681: SolidusEqualsSign
                {
                mSolidusEqualsSign(); 

                }
                break;
            case 63 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:699: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 64 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:710: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 65 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:738: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 66 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:759: EqualsSignGreaterThanSign
                {
                mEqualsSignGreaterThanSign(); 

                }
                break;
            case 67 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:785: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 68 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:811: QuestionMarkFullStop
                {
                mQuestionMarkFullStop(); 

                }
                break;
            case 69 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:832: QuestionMarkColon
                {
                mQuestionMarkColon(); 

                }
                break;
            case 70 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:850: As
                {
                mAs(); 

                }
                break;
            case 71 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:853: Do
                {
                mDo(); 

                }
                break;
            case 72 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:856: If
                {
                mIf(); 

                }
                break;
            case 73 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:859: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 74 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:884: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 75 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:900: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 76 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:911: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 77 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:923: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 78 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:933: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 79 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:949: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 80 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:966: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 81 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:975: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 82 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:984: Comma
                {
                mComma(); 

                }
                break;
            case 83 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:990: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 84 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1002: FullStop
                {
                mFullStop(); 

                }
                break;
            case 85 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1011: Solidus
                {
                mSolidus(); 

                }
                break;
            case 86 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1019: Colon
                {
                mColon(); 

                }
                break;
            case 87 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1025: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 88 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1035: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 89 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1048: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 90 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1059: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 91 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1075: QuestionMark
                {
                mQuestionMark(); 

                }
                break;
            case 92 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1088: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 93 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1106: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 94 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1125: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 95 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1142: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 96 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1155: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 97 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1173: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 98 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1182: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 99 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1191: RULE_DECIMAL
                {
                mRULE_DECIMAL(); 

                }
                break;
            case 100 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1204: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 101 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1212: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 102 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1224: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 103 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1240: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 104 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1256: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 105 :
                // ../org.osate.reqspec.ui/src-gen/org/osate/reqspec/ui/contentassist/antlr/lexer/InternalReqSpecLexer.g:1:1264: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\1\uffff\15\64\1\116\1\120\1\123\1\64\1\126\1\130\1\133\1\136\1"+
        "\142\1\146\1\150\1\152\1\154\1\157\1\161\11\uffff\2\175\1\55\5\uffff"+
        "\6\64\1\uffff\1\64\1\u008b\4\64\1\u0094\10\64\1\u00a0\10\64\1\u00ac"+
        "\1\uffff\1\u00ae\1\uffff\1\u00b0\2\uffff\1\64\47\uffff\1\175\4\uffff"+
        "\4\64\1\u00b8\5\64\1\uffff\6\64\1\u00c4\1\64\1\uffff\10\64\1\u00d0"+
        "\2\64\1\uffff\4\64\1\u00d7\4\64\1\u00dc\6\uffff\1\u00dd\1\u00de"+
        "\5\64\1\uffff\13\64\1\uffff\5\64\1\u00f4\1\64\1\u00f6\3\64\1\uffff"+
        "\4\64\1\u00fe\1\u00ff\1\uffff\1\u0101\1\64\1\u0103\1\u0104\3\uffff"+
        "\6\64\1\u010b\15\64\1\u0119\1\uffff\1\64\1\uffff\3\64\1\u011f\2"+
        "\64\1\u0122\2\uffff\1\u0123\1\uffff\1\u0124\2\uffff\3\64\1\u0128"+
        "\1\64\1\u012a\1\uffff\5\64\1\u0130\3\64\1\u0134\3\64\1\uffff\4\64"+
        "\1\u013c\1\uffff\1\u013d\1\u013e\3\uffff\3\64\1\uffff\1\u0142\1"+
        "\uffff\1\64\1\u0144\2\64\1\u0147\1\uffff\2\64\1\u014a\1\uffff\4"+
        "\64\1\u014f\1\64\1\u0151\3\uffff\3\64\1\uffff\1\64\1\uffff\1\u0156"+
        "\1\64\1\uffff\2\64\1\uffff\1\64\1\u015c\1\u015d\1\64\1\uffff\1\64"+
        "\1\uffff\4\64\1\uffff\1\64\1\u0165\1\64\1\u0167\1\u0168\2\uffff"+
        "\1\u0169\1\u016a\5\64\1\uffff\1\u0170\4\uffff\2\64\1\u0173\1\u0174"+
        "\1\u0175\1\uffff\1\64\1\u0177\3\uffff\1\u0178\2\uffff";
    static final String DFA21_eofS =
        "\u0179\uffff";
    static final String DFA21_minS =
        "\1\0\2\105\1\101\1\106\1\101\1\114\1\111\1\101\1\123\1\110\1\117"+
        "\1\110\1\105\1\75\1\56\1\75\1\101\1\75\1\46\1\52\1\53\1\55\1\52"+
        "\1\72\1\76\1\75\1\56\1\174\11\uffff\2\60\1\44\5\uffff\1\105\1\116"+
        "\1\101\1\103\1\111\1\120\1\uffff\1\106\1\44\1\106\1\124\1\103\1"+
        "\120\1\44\1\116\1\123\1\124\1\123\1\124\1\116\2\114\1\44\1\120\1"+
        "\111\1\125\1\101\1\111\1\124\1\114\1\127\1\75\1\uffff\1\74\1\uffff"+
        "\1\75\2\uffff\1\114\47\uffff\1\60\4\uffff\2\103\1\113\1\124\1\44"+
        "\1\124\1\105\1\103\1\101\1\125\1\uffff\1\125\1\111\1\125\1\111\1"+
        "\124\1\114\1\44\1\117\1\uffff\1\106\1\103\3\105\1\111\1\101\1\104"+
        "\1\44\1\123\1\105\1\uffff\1\105\1\117\1\123\1\105\1\44\2\114\1\110"+
        "\1\114\1\44\6\uffff\2\44\1\111\1\110\1\105\2\111\1\uffff\1\103\2"+
        "\122\1\125\1\115\1\111\1\116\1\122\1\117\1\101\1\125\1\uffff\1\122"+
        "\1\114\1\124\1\107\1\110\1\44\1\116\1\44\1\107\1\114\1\105\1\uffff"+
        "\1\105\1\122\1\117\1\127\2\44\1\uffff\1\44\1\105\2\44\3\uffff\1"+
        "\106\1\122\1\110\1\103\1\117\1\110\1\44\1\111\1\114\1\105\1\122"+
        "\1\105\3\116\1\104\1\124\1\111\1\101\1\117\1\44\1\uffff\1\104\1"+
        "\uffff\1\101\1\114\1\122\1\44\1\124\1\106\1\44\2\uffff\1\44\1\uffff"+
        "\1\44\2\uffff\1\111\2\117\1\44\1\116\1\44\1\uffff\1\120\1\124\1"+
        "\116\1\105\1\123\1\44\1\101\1\103\1\105\1\44\1\103\1\116\1\122\1"+
        "\uffff\1\111\1\123\1\124\1\131\1\44\1\uffff\2\44\3\uffff\1\103\1"+
        "\116\1\114\1\uffff\1\44\1\uffff\1\124\1\44\1\124\1\115\1\44\1\uffff"+
        "\1\114\1\105\1\44\1\uffff\2\124\1\131\1\117\1\44\1\105\1\44\3\uffff"+
        "\1\101\1\111\1\104\1\uffff\1\111\1\uffff\1\44\1\105\1\uffff\1\105"+
        "\1\117\1\uffff\1\123\2\44\1\116\1\uffff\1\123\1\uffff\1\124\1\132"+
        "\1\105\1\117\1\uffff\1\116\1\44\1\106\2\44\2\uffff\2\44\1\111\1"+
        "\105\1\122\1\116\1\124\1\uffff\1\44\4\uffff\1\117\1\104\3\44\1\uffff"+
        "\1\116\1\44\3\uffff\1\44\2\uffff";
    static final String DFA21_maxS =
        "\1\uffff\1\171\1\157\1\145\1\156\1\157\1\170\1\151\1\157\1\163"+
        "\1\171\1\157\1\151\1\165\1\75\1\56\1\76\1\141\1\75\1\46\2\75\1\76"+
        "\1\75\1\72\1\76\1\75\1\72\1\174\11\uffff\1\170\1\154\1\172\5\uffff"+
        "\1\145\1\156\1\141\1\145\1\151\1\160\1\uffff\1\163\1\172\2\164\1"+
        "\166\1\160\1\172\1\156\2\164\1\163\1\164\1\156\1\162\1\154\1\172"+
        "\1\160\1\162\1\171\1\141\1\151\1\164\1\154\1\167\1\75\1\uffff\1"+
        "\74\1\uffff\1\75\2\uffff\1\162\47\uffff\1\154\4\uffff\2\143\2\164"+
        "\1\172\1\164\1\145\1\143\1\141\1\165\1\uffff\1\165\1\151\1\165\1"+
        "\151\1\164\1\154\1\172\1\157\1\uffff\1\163\4\145\1\151\1\141\1\144"+
        "\1\172\1\163\1\145\1\uffff\1\145\1\157\1\163\1\145\1\172\2\154\1"+
        "\150\1\154\1\172\6\uffff\2\172\1\151\1\150\1\145\2\151\1\uffff\1"+
        "\143\2\162\1\165\1\155\1\151\1\156\1\162\1\157\1\141\1\165\1\uffff"+
        "\1\162\1\154\1\164\1\147\1\150\1\172\1\156\1\172\1\147\1\154\1\145"+
        "\1\uffff\1\145\1\162\1\157\1\167\2\172\1\uffff\1\172\1\145\2\172"+
        "\3\uffff\1\146\1\162\1\150\1\143\1\157\1\150\1\172\1\151\1\154\1"+
        "\145\1\162\1\145\3\156\1\144\1\164\1\151\1\141\1\157\1\172\1\uffff"+
        "\1\163\1\uffff\1\141\1\154\1\162\1\172\1\164\1\146\1\172\2\uffff"+
        "\1\172\1\uffff\1\172\2\uffff\1\151\2\157\1\172\1\156\1\172\1\uffff"+
        "\1\160\1\164\1\156\1\145\1\163\1\172\1\141\1\143\1\145\1\172\1\143"+
        "\1\156\1\162\1\uffff\1\151\1\163\1\164\1\171\1\172\1\uffff\2\172"+
        "\3\uffff\1\143\1\156\1\154\1\uffff\1\172\1\uffff\1\164\1\172\1\164"+
        "\1\155\1\172\1\uffff\1\154\1\145\1\172\1\uffff\2\164\1\171\1\157"+
        "\1\172\1\145\1\172\3\uffff\1\141\1\151\1\144\1\uffff\1\151\1\uffff"+
        "\1\172\1\145\1\uffff\1\145\1\157\1\uffff\1\163\2\172\1\156\1\uffff"+
        "\1\163\1\uffff\1\164\1\172\1\145\1\157\1\uffff\1\156\1\172\1\146"+
        "\2\172\2\uffff\2\172\1\151\1\145\1\162\1\156\1\164\1\uffff\1\172"+
        "\4\uffff\1\157\1\144\3\172\1\uffff\1\156\1\172\3\uffff\1\172\2\uffff";
    static final String DFA21_acceptS =
        "\35\uffff\1\113\1\116\1\117\1\122\1\127\1\134\1\135\1\136\1\140"+
        "\3\uffff\1\144\2\145\1\150\1\151\6\uffff\1\144\31\uffff\1\112\1"+
        "\uffff\1\124\1\uffff\1\102\1\131\1\uffff\1\64\1\114\1\65\1\115\1"+
        "\66\1\67\1\120\1\70\1\71\1\121\1\72\1\73\1\74\1\123\1\76\1\146\1"+
        "\147\1\125\1\77\1\126\1\100\1\130\1\103\1\132\1\104\1\105\1\133"+
        "\1\111\1\137\1\113\1\116\1\117\1\122\1\127\1\134\1\135\1\136\1\140"+
        "\1\141\1\uffff\1\142\1\143\1\145\1\150\12\uffff\1\107\10\uffff\1"+
        "\110\13\uffff\1\106\12\uffff\1\51\1\63\1\52\1\75\1\53\1\101\7\uffff"+
        "\1\57\13\uffff\1\55\13\uffff\1\54\6\uffff\1\60\4\uffff\1\56\1\61"+
        "\1\62\25\uffff\1\42\1\uffff\1\43\7\uffff\1\46\1\47\1\uffff\1\44"+
        "\1\uffff\1\50\1\45\6\uffff\1\37\15\uffff\1\34\5\uffff\1\35\2\uffff"+
        "\1\40\1\36\1\41\3\uffff\1\31\1\uffff\1\32\5\uffff\1\30\3\uffff\1"+
        "\27\7\uffff\1\26\1\25\1\33\3\uffff\1\24\1\uffff\1\17\2\uffff\1\23"+
        "\2\uffff\1\22\4\uffff\1\20\1\uffff\1\21\4\uffff\1\16\5\uffff\1\15"+
        "\1\14\7\uffff\1\13\1\uffff\1\7\1\10\1\11\1\12\5\uffff\1\6\2\uffff"+
        "\1\5\1\3\1\4\1\uffff\1\2\1\1";
    static final String DFA21_specialS =
        "\1\0\u0178\uffff}>";
    static final String[] DFA21_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\16\1\52\1\35\1\51\1\22\1"+
            "\23\1\53\1\36\1\37\1\24\1\25\1\40\1\26\1\17\1\27\1\46\11\47"+
            "\1\30\1\41\1\31\1\20\1\32\1\33\1\55\1\11\1\51\1\5\1\2\1\6\1"+
            "\10\1\13\1\51\1\4\3\51\1\7\1\15\3\51\1\3\1\1\1\12\1\51\1\21"+
            "\1\14\3\51\1\42\1\55\1\43\1\50\1\51\1\55\1\11\1\51\1\5\1\2\1"+
            "\6\1\10\1\13\1\51\1\4\3\51\1\7\1\15\3\51\1\3\1\1\1\12\1\51\1"+
            "\21\1\14\3\51\1\44\1\34\1\45\uff82\55",
            "\1\61\12\uffff\1\56\3\uffff\1\60\1\63\1\uffff\1\62\1\uffff"+
            "\1\57\13\uffff\1\61\12\uffff\1\56\3\uffff\1\60\1\63\1\uffff"+
            "\1\62\1\uffff\1\57",
            "\1\65\11\uffff\1\66\25\uffff\1\65\11\uffff\1\66",
            "\1\70\3\uffff\1\67\33\uffff\1\70\3\uffff\1\67",
            "\1\73\6\uffff\1\72\1\71\27\uffff\1\73\6\uffff\1\72\1\71",
            "\1\75\15\uffff\1\74\21\uffff\1\75\15\uffff\1\74",
            "\1\77\13\uffff\1\76\23\uffff\1\77\13\uffff\1\76",
            "\1\100\37\uffff\1\100",
            "\1\103\7\uffff\1\101\5\uffff\1\102\21\uffff\1\103\7\uffff"+
            "\1\101\5\uffff\1\102",
            "\1\104\37\uffff\1\104",
            "\1\106\11\uffff\1\107\6\uffff\1\105\16\uffff\1\106\11\uffff"+
            "\1\107\6\uffff\1\105",
            "\1\110\37\uffff\1\110",
            "\1\111\1\112\36\uffff\1\111\1\112",
            "\1\114\17\uffff\1\113\17\uffff\1\114\17\uffff\1\113",
            "\1\115",
            "\1\117",
            "\1\121\1\122",
            "\1\124\37\uffff\1\124",
            "\1\125",
            "\1\127",
            "\1\131\22\uffff\1\132",
            "\1\134\21\uffff\1\135",
            "\1\137\17\uffff\1\140\1\141",
            "\1\144\4\uffff\1\145\15\uffff\1\143",
            "\1\147",
            "\1\151",
            "\1\153",
            "\1\155\13\uffff\1\156",
            "\1\160",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\174\10\uffff\1\176\1\uffff\3\176\5\uffff\1\176\13\uffff"+
            "\1\173\6\uffff\1\174\2\uffff\1\176\1\uffff\3\176\5\uffff\1\176"+
            "\13\uffff\1\173",
            "\12\174\10\uffff\1\176\1\uffff\3\176\5\uffff\1\176\22\uffff"+
            "\1\174\2\uffff\1\176\1\uffff\3\176\5\uffff\1\176",
            "\1\64\34\uffff\32\64\4\uffff\1\64\1\uffff\32\64",
            "",
            "",
            "",
            "",
            "",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082\37\uffff\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0084\1\uffff\1\u0085\35\uffff\1\u0084\1\uffff\1\u0085",
            "\1\u0086\37\uffff\1\u0086",
            "\1\u0087\37\uffff\1\u0087",
            "",
            "\1\u0089\14\uffff\1\u0088\22\uffff\1\u0089\14\uffff\1\u0088",
            "\1\64\13\uffff\12\64\7\uffff\2\64\1\u008a\27\64\4\uffff\1"+
            "\64\1\uffff\2\64\1\u008a\27\64",
            "\1\u008d\12\uffff\1\u008c\2\uffff\1\u008e\21\uffff\1\u008d"+
            "\12\uffff\1\u008c\2\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0091\17\uffff\1\u0090\2\uffff\1\u0092\14\uffff\1\u0091"+
            "\17\uffff\1\u0090\2\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0097\1\u0096\36\uffff\1\u0097\1\u0096",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\5\uffff\1\u009d\31\uffff\1\u009c\5\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\64\13\uffff\12\64\7\uffff\22\64\1\u009f\7\64\4\uffff\1"+
            "\64\1\uffff\22\64\1\u009f\7\64",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a3\10\uffff\1\u00a2\26\uffff\1\u00a3\10\uffff\1\u00a2",
            "\1\u00a4\3\uffff\1\u00a5\33\uffff\1\u00a4\3\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ad",
            "",
            "\1\u00af",
            "",
            "",
            "\1\u00b1\5\uffff\1\u00b2\31\uffff\1\u00b1\5\uffff\1\u00b2",
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
            "\12\174\10\uffff\1\176\1\uffff\3\176\5\uffff\1\176\22\uffff"+
            "\1\174\2\uffff\1\176\1\uffff\3\176\5\uffff\1\176",
            "",
            "",
            "",
            "",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\u00b5\10\uffff\1\u00b6\26\uffff\1\u00b5\10\uffff\1\u00b6",
            "\1\u00b7\37\uffff\1\u00b7",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00b9\37\uffff\1\u00b9",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\u00bb\37\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3\37\uffff\1\u00c3",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00c5\37\uffff\1\u00c5",
            "",
            "\1\u00c6\14\uffff\1\u00c7\22\uffff\1\u00c6\14\uffff\1\u00c7",
            "\1\u00c9\1\uffff\1\u00c8\35\uffff\1\u00c9\1\uffff\1\u00c8",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cc",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\u00d2\37\uffff\1\u00d2",
            "",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\u00d4\37\uffff\1\u00d4",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\u00da\37\uffff\1\u00da",
            "\1\u00db\37\uffff\1\u00db",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\u00e1\37\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e3",
            "",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e8",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\u00ed\37\uffff\1\u00ed",
            "\1\u00ee\37\uffff\1\u00ee",
            "",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f0",
            "\1\u00f1\37\uffff\1\u00f1",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00f5\37\uffff\1\u00f5",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\64\13\uffff\12\64\7\uffff\22\64\1\u0100\7\64\4\uffff\1"+
            "\64\1\uffff\22\64\1\u0100\7\64",
            "\1\u0102\37\uffff\1\u0102",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "\1\u0105\37\uffff\1\u0105",
            "\1\u0106\37\uffff\1\u0106",
            "\1\u0107\37\uffff\1\u0107",
            "\1\u0108\37\uffff\1\u0108",
            "\1\u0109\37\uffff\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d\37\uffff\1\u010d",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f\37\uffff\1\u010f",
            "\1\u0110\37\uffff\1\u0110",
            "\1\u0111\37\uffff\1\u0111",
            "\1\u0112\37\uffff\1\u0112",
            "\1\u0113\37\uffff\1\u0113",
            "\1\u0114\37\uffff\1\u0114",
            "\1\u0115\37\uffff\1\u0115",
            "\1\u0116\37\uffff\1\u0116",
            "\1\u0117\37\uffff\1\u0117",
            "\1\u0118\37\uffff\1\u0118",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u011b\16\uffff\1\u011a\20\uffff\1\u011b\16\uffff\1\u011a",
            "",
            "\1\u011c\37\uffff\1\u011c",
            "\1\u011d\37\uffff\1\u011d",
            "\1\u011e\37\uffff\1\u011e",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0120\37\uffff\1\u0120",
            "\1\u0121\37\uffff\1\u0121",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "\1\u0125\37\uffff\1\u0125",
            "\1\u0126\37\uffff\1\u0126",
            "\1\u0127\37\uffff\1\u0127",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0129\37\uffff\1\u0129",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u012b\37\uffff\1\u012b",
            "\1\u012c\37\uffff\1\u012c",
            "\1\u012d\37\uffff\1\u012d",
            "\1\u012e\37\uffff\1\u012e",
            "\1\u012f\37\uffff\1\u012f",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132\37\uffff\1\u0132",
            "\1\u0133\37\uffff\1\u0133",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0135\37\uffff\1\u0135",
            "\1\u0136\37\uffff\1\u0136",
            "\1\u0137\37\uffff\1\u0137",
            "",
            "\1\u0138\37\uffff\1\u0138",
            "\1\u0139\37\uffff\1\u0139",
            "\1\u013a\37\uffff\1\u013a",
            "\1\u013b\37\uffff\1\u013b",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "\1\u013f\37\uffff\1\u013f",
            "\1\u0140\37\uffff\1\u0140",
            "\1\u0141\37\uffff\1\u0141",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u0143\37\uffff\1\u0143",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0145\37\uffff\1\u0145",
            "\1\u0146\37\uffff\1\u0146",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u0148\37\uffff\1\u0148",
            "\1\u0149\37\uffff\1\u0149",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u014b\37\uffff\1\u014b",
            "\1\u014c\37\uffff\1\u014c",
            "\1\u014d\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0150\37\uffff\1\u0150",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "\1\u0152\37\uffff\1\u0152",
            "\1\u0153\37\uffff\1\u0153",
            "\1\u0154\37\uffff\1\u0154",
            "",
            "\1\u0155\37\uffff\1\u0155",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0157\37\uffff\1\u0157",
            "",
            "\1\u0158\37\uffff\1\u0158",
            "\1\u0159\37\uffff\1\u0159",
            "",
            "\1\u015a\37\uffff\1\u015a",
            "\1\64\13\uffff\12\64\7\uffff\22\64\1\u015b\7\64\4\uffff\1"+
            "\64\1\uffff\22\64\1\u015b\7\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u015e\37\uffff\1\u015e",
            "",
            "\1\u015f\37\uffff\1\u015f",
            "",
            "\1\u0160\37\uffff\1\u0160",
            "\1\u0161\37\uffff\1\u0161",
            "\1\u0162\37\uffff\1\u0162",
            "\1\u0163\37\uffff\1\u0163",
            "",
            "\1\u0164\37\uffff\1\u0164",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0166\37\uffff\1\u0166",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u016b\37\uffff\1\u016b",
            "\1\u016c\37\uffff\1\u016c",
            "\1\u016d\37\uffff\1\u016d",
            "\1\u016e\37\uffff\1\u016e",
            "\1\u016f\37\uffff\1\u016f",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "",
            "\1\u0171\37\uffff\1\u0171",
            "\1\u0172\37\uffff\1\u0172",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u0176\37\uffff\1\u0176",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
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
            return "1:1: Tokens : ( Specification | Synchronized | Description | Requirement | Stakeholder | Instanceof | Conflicts | Constants | Extension | Mitigates | Rationale | Category | Constant | Document | Default | Extends | Finally | Include | Refines | Section | Assert | Folder | Import | Return | Static | Switch | Typeof | Catch | False | Goals | Super | Throw | While | Case | Else | Goal | Null | This | True | With | ExclamationMarkEqualsSignEqualsSign | FullStopFullStopLessThanSign | EqualsSignEqualsSignEqualsSign | For | Inv | New | See | Try | Val | Var | ExclamationMarkEqualsSign | PercentSignEqualsSign | AmpersandAmpersand | AsteriskAsterisk | AsteriskEqualsSign | PlusSignPlusSign | PlusSignEqualsSign | HyphenMinusHyphenMinus | HyphenMinusEqualsSign | HyphenMinusGreaterThanSign | FullStopFullStop | SolidusEqualsSign | ColonColon | LessThanSignGreaterThanSign | EqualsSignEqualsSign | EqualsSignGreaterThanSign | GreaterThanSignEqualsSign | QuestionMarkFullStop | QuestionMarkColon | As | Do | If | VerticalLineVerticalLine | ExclamationMark | NumberSign | PercentSign | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | QuestionMark | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_0 = input.LA(1);

                        s = -1;
                        if ( (LA21_0=='S'||LA21_0=='s') ) {s = 1;}

                        else if ( (LA21_0=='D'||LA21_0=='d') ) {s = 2;}

                        else if ( (LA21_0=='R'||LA21_0=='r') ) {s = 3;}

                        else if ( (LA21_0=='I'||LA21_0=='i') ) {s = 4;}

                        else if ( (LA21_0=='C'||LA21_0=='c') ) {s = 5;}

                        else if ( (LA21_0=='E'||LA21_0=='e') ) {s = 6;}

                        else if ( (LA21_0=='M'||LA21_0=='m') ) {s = 7;}

                        else if ( (LA21_0=='F'||LA21_0=='f') ) {s = 8;}

                        else if ( (LA21_0=='A'||LA21_0=='a') ) {s = 9;}

                        else if ( (LA21_0=='T'||LA21_0=='t') ) {s = 10;}

                        else if ( (LA21_0=='G'||LA21_0=='g') ) {s = 11;}

                        else if ( (LA21_0=='W'||LA21_0=='w') ) {s = 12;}

                        else if ( (LA21_0=='N'||LA21_0=='n') ) {s = 13;}

                        else if ( (LA21_0=='!') ) {s = 14;}

                        else if ( (LA21_0=='.') ) {s = 15;}

                        else if ( (LA21_0=='=') ) {s = 16;}

                        else if ( (LA21_0=='V'||LA21_0=='v') ) {s = 17;}

                        else if ( (LA21_0=='%') ) {s = 18;}

                        else if ( (LA21_0=='&') ) {s = 19;}

                        else if ( (LA21_0=='*') ) {s = 20;}

                        else if ( (LA21_0=='+') ) {s = 21;}

                        else if ( (LA21_0=='-') ) {s = 22;}

                        else if ( (LA21_0=='/') ) {s = 23;}

                        else if ( (LA21_0==':') ) {s = 24;}

                        else if ( (LA21_0=='<') ) {s = 25;}

                        else if ( (LA21_0=='>') ) {s = 26;}

                        else if ( (LA21_0=='?') ) {s = 27;}

                        else if ( (LA21_0=='|') ) {s = 28;}

                        else if ( (LA21_0=='#') ) {s = 29;}

                        else if ( (LA21_0=='(') ) {s = 30;}

                        else if ( (LA21_0==')') ) {s = 31;}

                        else if ( (LA21_0==',') ) {s = 32;}

                        else if ( (LA21_0==';') ) {s = 33;}

                        else if ( (LA21_0=='[') ) {s = 34;}

                        else if ( (LA21_0==']') ) {s = 35;}

                        else if ( (LA21_0=='{') ) {s = 36;}

                        else if ( (LA21_0=='}') ) {s = 37;}

                        else if ( (LA21_0=='0') ) {s = 38;}

                        else if ( ((LA21_0>='1' && LA21_0<='9')) ) {s = 39;}

                        else if ( (LA21_0=='^') ) {s = 40;}

                        else if ( (LA21_0=='$'||LA21_0=='B'||LA21_0=='H'||(LA21_0>='J' && LA21_0<='L')||(LA21_0>='O' && LA21_0<='Q')||LA21_0=='U'||(LA21_0>='X' && LA21_0<='Z')||LA21_0=='_'||LA21_0=='b'||LA21_0=='h'||(LA21_0>='j' && LA21_0<='l')||(LA21_0>='o' && LA21_0<='q')||LA21_0=='u'||(LA21_0>='x' && LA21_0<='z')) ) {s = 41;}

                        else if ( (LA21_0=='\"') ) {s = 42;}

                        else if ( (LA21_0=='\'') ) {s = 43;}

                        else if ( ((LA21_0>='\t' && LA21_0<='\n')||LA21_0=='\r'||LA21_0==' ') ) {s = 44;}

                        else if ( ((LA21_0>='\u0000' && LA21_0<='\b')||(LA21_0>='\u000B' && LA21_0<='\f')||(LA21_0>='\u000E' && LA21_0<='\u001F')||LA21_0=='@'||LA21_0=='\\'||LA21_0=='`'||(LA21_0>='~' && LA21_0<='\uFFFF')) ) {s = 45;}

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