package org.osate.reqspec.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReqSpecLexer extends Lexer {
    public static final int RULE_ID=39;
    public static final int RightParenthesis=31;
    public static final int RULE_ANY_OTHER=45;
    public static final int LeftParenthesis=30;
    public static final int Issues=20;
    public static final int RightSquareBracket=38;
    public static final int Mitigates=10;
    public static final int Requirement=5;
    public static final int Solidus=34;
    public static final int EOF=-1;
    public static final int Evolves=14;
    public static final int FullStop=33;
    public static final int Assertion=8;
    public static final int Decomposes=7;
    public static final int RULE_INT=40;
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
    public static final int Val=25;
    public static final int Comma=32;
    public static final int EqualsSign=36;
    public static final int Of=28;

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

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:19:13: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:19:15: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:21:13: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:21:15: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:23:13: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:23:15: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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

    // $ANTLR start "Decomposes"
    public final void mDecomposes() throws RecognitionException {
        try {
            int _type = Decomposes;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:25:12: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:25:14: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'S' | 's' )
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
    // $ANTLR end "Decomposes"

    // $ANTLR start "Assertion"
    public final void mAssertion() throws RecognitionException {
        try {
            int _type = Assertion;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:27:11: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:27:13: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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
    // $ANTLR end "Assertion"

    // $ANTLR start "Conflicts"
    public final void mConflicts() throws RecognitionException {
        try {
            int _type = Conflicts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:29:11: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:29:13: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' )
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

    // $ANTLR start "Mitigates"
    public final void mMitigates() throws RecognitionException {
        try {
            int _type = Mitigates;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:11: ( ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:31:13: ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'S' | 's' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:11: ( ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:33:13: ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'E' | 'e' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:10: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:35:12: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:10: ( ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:37:12: ( 'D' | 'd' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
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

    // $ANTLR start "Evolves"
    public final void mEvolves() throws RecognitionException {
        try {
            int _type = Evolves;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:9: ( ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:11: ( 'E' | 'e' ) ( 'V' | 'v' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'V' | 'v' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
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
    // $ANTLR end "Evolves"

    // $ANTLR start "Package"
    public final void mPackage() throws RecognitionException {
        try {
            int _type = Package;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:9: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:11: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'K' | 'k' ) ( 'A' | 'a' ) ( 'G' | 'g' ) ( 'E' | 'e' )
            {
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

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
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

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "Package"

    // $ANTLR start "Refines"
    public final void mRefines() throws RecognitionException {
        try {
            int _type = Refines;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:43:11: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'S' | 's' )
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

    // $ANTLR start "Folder"
    public final void mFolder() throws RecognitionException {
        try {
            int _type = Folder;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:8: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:10: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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

    // $ANTLR start "Hazard"
    public final void mHazard() throws RecognitionException {
        try {
            int _type = Hazard;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:8: ( ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'Z' | 'z' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'D' | 'd' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:10: ( 'H' | 'h' ) ( 'A' | 'a' ) ( 'Z' | 'z' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'D' | 'd' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
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

            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
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
    // $ANTLR end "Hazard"

    // $ANTLR start "Import"
    public final void mImport() throws RecognitionException {
        try {
            int _type = Import;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:8: ( ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:10: ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:8: ( ( 'I' | 'i' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:10: ( 'I' | 'i' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'U' | 'u' ) ( 'E' | 'e' ) ( 'S' | 's' )
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

    // $ANTLR start "Title"
    public final void mTitle() throws RecognitionException {
        try {
            int _type = Title;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:7: ( ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:9: ( 'T' | 't' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'L' | 'l' ) ( 'E' | 'e' )
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

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "Title"

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:6: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:8: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:5: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:7: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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

    // $ANTLR start "See"
    public final void mSee() throws RecognitionException {
        try {
            int _type = See;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:5: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:7: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' )
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

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:5: ( ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:7: ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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

    // $ANTLR start "FullStopAsterisk"
    public final void mFullStopAsterisk() throws RecognitionException {
        try {
            int _type = FullStopAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:18: ( '.' '*' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:20: '.' '*'
            {
            match('.'); 
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopAsterisk"

    // $ANTLR start "ColonColon"
    public final void mColonColon() throws RecognitionException {
        try {
            int _type = ColonColon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:12: ( ':' ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:14: ':' ':'
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

    // $ANTLR start "Of"
    public final void mOf() throws RecognitionException {
        try {
            int _type = Of;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:4: ( ( 'O' | 'o' ) ( 'F' | 'f' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:6: ( 'O' | 'o' ) ( 'F' | 'f' )
            {
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
    // $ANTLR end "Of"

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:12: ( '#' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:14: '#'
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

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:17: ( '(' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:19: '('
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:18: ( ')' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:20: ')'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:7: ( ',' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:9: ','
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

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:10: ( '.' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:12: '.'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:9: ( '/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:11: '/'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:7: ( ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:9: ':'
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

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:12: ( '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:14: '='
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

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:19: ( '[' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:21: '['
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:20: ( ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:22: ']'
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:11: '^'
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
            	    break loop2;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:10: ( ( '0' .. '9' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:12: ( '0' .. '9' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:28: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:95:61: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop5;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:41: '\\r'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
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
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:16: ( . )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:18: .
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
        // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:8: ( Description | Requirement | Stakeholder | Decomposes | Assertion | Conflicts | Mitigates | Rationale | Category | Document | Evolves | Package | Refines | Folder | Hazard | Import | Issues | Title | Goal | For | See | Val | FullStopAsterisk | ColonColon | Of | NumberSign | LeftParenthesis | RightParenthesis | Comma | FullStop | Solidus | Colon | EqualsSign | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=42;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:10: Description
                {
                mDescription(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:22: Requirement
                {
                mRequirement(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:34: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:46: Decomposes
                {
                mDecomposes(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:57: Assertion
                {
                mAssertion(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:67: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:77: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:87: Rationale
                {
                mRationale(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:97: Category
                {
                mCategory(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:106: Document
                {
                mDocument(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:115: Evolves
                {
                mEvolves(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:123: Package
                {
                mPackage(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:131: Refines
                {
                mRefines(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:139: Folder
                {
                mFolder(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:146: Hazard
                {
                mHazard(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:153: Import
                {
                mImport(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:160: Issues
                {
                mIssues(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:167: Title
                {
                mTitle(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:173: Goal
                {
                mGoal(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:178: For
                {
                mFor(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:182: See
                {
                mSee(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:186: Val
                {
                mVal(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:190: FullStopAsterisk
                {
                mFullStopAsterisk(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:207: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:218: Of
                {
                mOf(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:221: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:232: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:248: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:265: Comma
                {
                mComma(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:271: FullStop
                {
                mFullStop(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:280: Solidus
                {
                mSolidus(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:288: Colon
                {
                mColon(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:294: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:305: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:323: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:342: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:350: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:359: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:371: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:387: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:403: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:411: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\16\43\1\66\1\70\1\43\4\uffff\1\100\3\uffff\1\40\2\uffff"+
        "\2\40\2\uffff\2\43\1\uffff\21\43\4\uffff\1\135\15\uffff\7\43\1\145"+
        "\7\43\1\155\5\43\1\163\1\uffff\7\43\1\uffff\7\43\1\uffff\4\43\1"+
        "\u0086\1\uffff\21\43\1\u0098\1\uffff\15\43\1\u00a6\1\u00a7\1\u00a8"+
        "\1\u00a9\1\uffff\4\43\1\u00ae\6\43\1\u00b5\1\u00b6\4\uffff\2\43"+
        "\1\u00b9\1\43\1\uffff\4\43\1\u00bf\1\43\2\uffff\2\43\1\uffff\1\43"+
        "\1\u00c4\1\43\1\u00c6\1\u00c7\1\uffff\1\u00c8\1\43\1\u00ca\1\43"+
        "\1\uffff\1\43\3\uffff\1\u00cd\1\uffff\1\u00ce\1\u00cf\3\uffff";
    static final String DFA12_eofS =
        "\u00d0\uffff";
    static final String DFA12_minS =
        "\1\0\1\105\1\101\1\105\1\123\1\101\1\111\1\126\1\101\1\117\1\101"+
        "\1\115\1\111\1\117\1\101\1\52\1\72\1\106\4\uffff\1\52\3\uffff\1"+
        "\101\2\uffff\2\0\2\uffff\2\103\1\uffff\1\106\1\124\1\101\1\105\1"+
        "\123\1\116\2\124\1\117\1\103\1\114\1\132\1\120\1\123\1\124\1\101"+
        "\1\114\4\uffff\1\60\15\uffff\1\103\1\117\2\125\2\111\1\113\1\60"+
        "\1\105\1\106\1\105\1\111\1\114\1\113\1\104\1\60\1\101\1\117\1\125"+
        "\2\114\1\60\1\uffff\1\122\2\115\1\111\1\116\1\117\1\105\1\uffff"+
        "\1\122\1\114\2\107\1\126\1\101\1\105\1\uffff\2\122\2\105\1\60\1"+
        "\uffff\1\111\1\120\1\105\1\122\1\105\1\116\1\110\1\124\1\111\1\117"+
        "\1\101\1\105\1\107\1\122\1\104\1\124\1\123\1\60\1\uffff\1\120\1"+
        "\117\1\116\1\105\1\123\1\101\1\117\1\111\1\103\1\122\1\124\1\123"+
        "\1\105\4\60\1\uffff\1\124\1\123\1\124\1\115\1\60\2\114\1\117\1\124"+
        "\1\131\1\105\2\60\4\uffff\1\111\1\105\1\60\1\105\1\uffff\1\105\1"+
        "\104\1\116\1\123\1\60\1\123\2\uffff\1\117\1\123\1\uffff\1\116\1"+
        "\60\1\105\2\60\1\uffff\1\60\1\116\1\60\1\124\1\uffff\1\122\3\uffff"+
        "\1\60\1\uffff\2\60\3\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\157\1\145\1\164\1\163\1\157\1\151\1\166\1\141\1\157"+
        "\1\141\1\163\1\151\1\157\1\141\1\52\1\72\1\146\4\uffff\1\57\3\uffff"+
        "\1\172\2\uffff\2\uffff\2\uffff\1\163\1\143\1\uffff\1\161\1\164\1"+
        "\141\1\145\1\163\1\156\2\164\1\157\1\143\1\162\1\172\1\160\1\163"+
        "\1\164\1\141\1\154\4\uffff\1\172\15\uffff\1\143\1\157\2\165\2\151"+
        "\1\153\1\172\1\145\1\146\1\145\1\151\1\154\1\153\1\144\1\172\1\141"+
        "\1\157\1\165\2\154\1\172\1\uffff\1\162\2\155\1\151\1\156\1\157\1"+
        "\145\1\uffff\1\162\1\154\2\147\1\166\1\141\1\145\1\uffff\2\162\2"+
        "\145\1\172\1\uffff\1\151\1\160\1\145\1\162\1\145\1\156\1\150\1\164"+
        "\1\151\1\157\1\141\1\145\1\147\1\162\1\144\1\164\1\163\1\172\1\uffff"+
        "\1\160\1\157\1\156\1\145\1\163\1\141\1\157\1\151\1\143\1\162\1\164"+
        "\1\163\1\145\4\172\1\uffff\1\164\1\163\1\164\1\155\1\172\2\154\1"+
        "\157\1\164\1\171\1\145\2\172\4\uffff\1\151\1\145\1\172\1\145\1\uffff"+
        "\1\145\1\144\1\156\1\163\1\172\1\163\2\uffff\1\157\1\163\1\uffff"+
        "\1\156\1\172\1\145\2\172\1\uffff\1\172\1\156\1\172\1\164\1\uffff"+
        "\1\162\3\uffff\1\172\1\uffff\2\172\3\uffff";
    static final String DFA12_acceptS =
        "\22\uffff\1\32\1\33\1\34\1\35\1\uffff\1\41\1\42\1\43\1\uffff\1"+
        "\44\1\45\2\uffff\1\51\1\52\2\uffff\1\44\21\uffff\1\27\1\36\1\30"+
        "\1\40\1\uffff\1\32\1\33\1\34\1\35\1\47\1\50\1\37\1\41\1\42\1\43"+
        "\1\45\1\46\1\51\26\uffff\1\31\7\uffff\1\25\7\uffff\1\24\5\uffff"+
        "\1\26\22\uffff\1\23\21\uffff\1\22\15\uffff\1\16\1\17\1\20\1\21\4"+
        "\uffff\1\15\6\uffff\1\13\1\14\2\uffff\1\12\5\uffff\1\11\4\uffff"+
        "\1\10\1\uffff\1\5\1\6\1\7\1\uffff\1\4\2\uffff\1\1\1\2\1\3";
    static final String DFA12_specialS =
        "\1\1\34\uffff\1\0\1\2\u00b1\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\40\2\37\2\40\1\37\22\40\1\37\1\40\1\35\1\22\3\40\1\36\1"+
            "\23\1\24\2\40\1\25\1\40\1\17\1\26\12\34\1\20\2\40\1\27\3\40"+
            "\1\4\1\33\1\5\1\1\1\7\1\11\1\15\1\12\1\13\3\33\1\6\1\33\1\21"+
            "\1\10\1\33\1\2\1\3\1\14\1\33\1\16\4\33\1\30\1\40\1\31\1\32\1"+
            "\33\1\40\1\4\1\33\1\5\1\1\1\7\1\11\1\15\1\12\1\13\3\33\1\6\1"+
            "\33\1\21\1\10\1\33\1\2\1\3\1\14\1\33\1\16\4\33\uff85\40",
            "\1\41\11\uffff\1\42\25\uffff\1\41\11\uffff\1\42",
            "\1\45\3\uffff\1\44\33\uffff\1\45\3\uffff\1\44",
            "\1\47\16\uffff\1\46\20\uffff\1\47\16\uffff\1\46",
            "\1\50\37\uffff\1\50",
            "\1\52\15\uffff\1\51\21\uffff\1\52\15\uffff\1\51",
            "\1\53\37\uffff\1\53",
            "\1\54\37\uffff\1\54",
            "\1\55\37\uffff\1\55",
            "\1\56\37\uffff\1\56",
            "\1\57\37\uffff\1\57",
            "\1\60\5\uffff\1\61\31\uffff\1\60\5\uffff\1\61",
            "\1\62\37\uffff\1\62",
            "\1\63\37\uffff\1\63",
            "\1\64\37\uffff\1\64",
            "\1\65",
            "\1\67",
            "\1\71\37\uffff\1\71",
            "",
            "",
            "",
            "",
            "\1\76\4\uffff\1\77",
            "",
            "",
            "",
            "\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "\0\105",
            "\0\105",
            "",
            "",
            "\1\110\17\uffff\1\107\17\uffff\1\110\17\uffff\1\107",
            "\1\111\37\uffff\1\111",
            "",
            "\1\113\12\uffff\1\112\24\uffff\1\113\12\uffff\1\112",
            "\1\114\37\uffff\1\114",
            "\1\115\37\uffff\1\115",
            "\1\116\37\uffff\1\116",
            "\1\117\37\uffff\1\117",
            "\1\120\37\uffff\1\120",
            "\1\121\37\uffff\1\121",
            "\1\122\37\uffff\1\122",
            "\1\123\37\uffff\1\123",
            "\1\124\37\uffff\1\124",
            "\1\125\5\uffff\1\126\31\uffff\1\125\5\uffff\1\126",
            "\1\127\37\uffff\1\127",
            "\1\130\37\uffff\1\130",
            "\1\131\37\uffff\1\131",
            "\1\132\37\uffff\1\132",
            "\1\133\37\uffff\1\133",
            "\1\134\37\uffff\1\134",
            "",
            "",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
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
            "\1\136\37\uffff\1\136",
            "\1\137\37\uffff\1\137",
            "\1\140\37\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\37\uffff\1\144",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\150\37\uffff\1\150",
            "\1\151\37\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "\1\154\37\uffff\1\154",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\156\37\uffff\1\156",
            "\1\157\37\uffff\1\157",
            "\1\160\37\uffff\1\160",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\164\37\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\1\u0080\37\uffff\1\u0080",
            "\1\u0081\37\uffff\1\u0081",
            "",
            "\1\u0082\37\uffff\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\37\uffff\1\u0085",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u0087\37\uffff\1\u0087",
            "\1\u0088\37\uffff\1\u0088",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008a\37\uffff\1\u008a",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0094\37\uffff\1\u0094",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009c\37\uffff\1\u009c",
            "\1\u009d\37\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b2\37\uffff\1\u00b2",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            "",
            "\1\u00b7\37\uffff\1\u00b7",
            "\1\u00b8\37\uffff\1\u00b8",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00ba\37\uffff\1\u00ba",
            "",
            "\1\u00bb\37\uffff\1\u00bb",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00c0\37\uffff\1\u00c0",
            "",
            "",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "",
            "\1\u00c3\37\uffff\1\u00c3",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00c5\37\uffff\1\u00c5",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00c9\37\uffff\1\u00c9",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00cb\37\uffff\1\u00cb",
            "",
            "\1\u00cc\37\uffff\1\u00cc",
            "",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Description | Requirement | Stakeholder | Decomposes | Assertion | Conflicts | Mitigates | Rationale | Category | Document | Evolves | Package | Refines | Folder | Hazard | Import | Issues | Title | Goal | For | See | Val | FullStopAsterisk | ColonColon | Of | NumberSign | LeftParenthesis | RightParenthesis | Comma | FullStop | Solidus | Colon | EqualsSign | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_29 = input.LA(1);

                        s = -1;
                        if ( ((LA12_29>='\u0000' && LA12_29<='\uFFFF')) ) {s = 69;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='D'||LA12_0=='d') ) {s = 1;}

                        else if ( (LA12_0=='R'||LA12_0=='r') ) {s = 2;}

                        else if ( (LA12_0=='S'||LA12_0=='s') ) {s = 3;}

                        else if ( (LA12_0=='A'||LA12_0=='a') ) {s = 4;}

                        else if ( (LA12_0=='C'||LA12_0=='c') ) {s = 5;}

                        else if ( (LA12_0=='M'||LA12_0=='m') ) {s = 6;}

                        else if ( (LA12_0=='E'||LA12_0=='e') ) {s = 7;}

                        else if ( (LA12_0=='P'||LA12_0=='p') ) {s = 8;}

                        else if ( (LA12_0=='F'||LA12_0=='f') ) {s = 9;}

                        else if ( (LA12_0=='H'||LA12_0=='h') ) {s = 10;}

                        else if ( (LA12_0=='I'||LA12_0=='i') ) {s = 11;}

                        else if ( (LA12_0=='T'||LA12_0=='t') ) {s = 12;}

                        else if ( (LA12_0=='G'||LA12_0=='g') ) {s = 13;}

                        else if ( (LA12_0=='V'||LA12_0=='v') ) {s = 14;}

                        else if ( (LA12_0=='.') ) {s = 15;}

                        else if ( (LA12_0==':') ) {s = 16;}

                        else if ( (LA12_0=='O'||LA12_0=='o') ) {s = 17;}

                        else if ( (LA12_0=='#') ) {s = 18;}

                        else if ( (LA12_0=='(') ) {s = 19;}

                        else if ( (LA12_0==')') ) {s = 20;}

                        else if ( (LA12_0==',') ) {s = 21;}

                        else if ( (LA12_0=='/') ) {s = 22;}

                        else if ( (LA12_0=='=') ) {s = 23;}

                        else if ( (LA12_0=='[') ) {s = 24;}

                        else if ( (LA12_0==']') ) {s = 25;}

                        else if ( (LA12_0=='^') ) {s = 26;}

                        else if ( (LA12_0=='B'||(LA12_0>='J' && LA12_0<='L')||LA12_0=='N'||LA12_0=='Q'||LA12_0=='U'||(LA12_0>='W' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||(LA12_0>='j' && LA12_0<='l')||LA12_0=='n'||LA12_0=='q'||LA12_0=='u'||(LA12_0>='w' && LA12_0<='z')) ) {s = 27;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 28;}

                        else if ( (LA12_0=='\"') ) {s = 29;}

                        else if ( (LA12_0=='\'') ) {s = 30;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 31;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='$' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='-'||(LA12_0>=';' && LA12_0<='<')||(LA12_0>='>' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 32;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_30 = input.LA(1);

                        s = -1;
                        if ( ((LA12_30>='\u0000' && LA12_30<='\uFFFF')) ) {s = 69;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}