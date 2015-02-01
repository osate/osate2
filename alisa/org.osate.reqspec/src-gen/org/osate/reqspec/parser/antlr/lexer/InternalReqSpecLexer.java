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
    public static final int RULE_ID=42;
    public static final int Specification=4;
    public static final int Constants=9;
    public static final int RULE_ANY_OTHER=48;
    public static final int Assert=18;
    public static final int RightSquareBracket=41;
    public static final int Mitigates=10;
    public static final int Library=15;
    public static final int Requirement=6;
    public static final int Solidus=35;
    public static final int EOF=-1;
    public static final int GreaterThanSign=39;
    public static final int FullStop=34;
    public static final int PercentSign=32;
    public static final int LessThanSign=37;
    public static final int RULE_INT=43;
    public static final int LeftSquareBracket=40;
    public static final int Refines=16;
    public static final int Conflicts=8;
    public static final int ExclamationMarkEqualsSign=26;
    public static final int Stakeholder=7;
    public static final int This=22;
    public static final int FullStopAsterisk=27;
    public static final int LessThanSignEqualsSign=29;
    public static final int Colon=36;
    public static final int RULE_SL_COMMENT=46;
    public static final int For=24;
    public static final int Include=14;
    public static final int NumberSign=31;
    public static final int Rationale=11;
    public static final int With=23;
    public static final int RULE_ML_COMMENT=45;
    public static final int Goal=21;
    public static final int Ampersand=33;
    public static final int Goals=20;
    public static final int ColonColon=28;
    public static final int Document=13;
    public static final int Description=5;
    public static final int RULE_STRING=44;
    public static final int Folder=19;
    public static final int See=25;
    public static final int Section=17;
    public static final int Category=12;
    public static final int GreaterThanSignEqualsSign=30;
    public static final int RULE_WS=47;
    public static final int EqualsSign=38;

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

    // $ANTLR start "Specification"
    public final void mSpecification() throws RecognitionException {
        try {
            int _type = Specification;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:19:15: ( ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:19:17: ( 'S' | 's' ) ( 'P' | 'p' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:21:13: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:21:15: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'P' | 'p' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:23:13: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:23:15: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:25:13: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:25:15: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'H' | 'h' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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

    // $ANTLR start "Conflicts"
    public final void mConflicts() throws RecognitionException {
        try {
            int _type = Conflicts;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:27:11: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:27:13: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'F' | 'f' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'S' | 's' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:29:11: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:29:13: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) ( 'S' | 's' )
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

    // $ANTLR start "Include"
    public final void mInclude() throws RecognitionException {
        try {
            int _type = Include;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:39:11: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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

    // $ANTLR start "Library"
    public final void mLibrary() throws RecognitionException {
        try {
            int _type = Library;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:9: ( ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'Y' | 'y' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:41:11: ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'B' | 'b' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'R' | 'r' ) ( 'Y' | 'y' )
            {
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

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
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
    // $ANTLR end "Library"

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

    // $ANTLR start "Section"
    public final void mSection() throws RecognitionException {
        try {
            int _type = Section;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:9: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:45:11: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:8: ( ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:47:10: ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:8: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:49:10: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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

    // $ANTLR start "Goals"
    public final void mGoals() throws RecognitionException {
        try {
            int _type = Goals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:7: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:51:9: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' )
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

    // $ANTLR start "Goal"
    public final void mGoal() throws RecognitionException {
        try {
            int _type = Goal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:6: ( ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:53:8: ( 'G' | 'g' ) ( 'O' | 'o' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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

    // $ANTLR start "This"
    public final void mThis() throws RecognitionException {
        try {
            int _type = This;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:6: ( ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:55:8: ( 'T' | 't' ) ( 'H' | 'h' ) ( 'I' | 'i' ) ( 'S' | 's' )
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

    // $ANTLR start "With"
    public final void mWith() throws RecognitionException {
        try {
            int _type = With;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:6: ( ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:57:8: ( 'W' | 'w' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'H' | 'h' )
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

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:5: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:59:7: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:5: ( ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:61:7: ( 'S' | 's' ) ( 'E' | 'e' ) ( 'E' | 'e' )
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

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:27: ( '!' '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:63:29: '!' '='
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

    // $ANTLR start "FullStopAsterisk"
    public final void mFullStopAsterisk() throws RecognitionException {
        try {
            int _type = FullStopAsterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:18: ( '.' '*' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:65:20: '.' '*'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:12: ( ':' ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:67:14: ':' ':'
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

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:24: ( '<' '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:69:26: '<' '='
            {
            match('<'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:27: ( '>' '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:71:29: '>' '='
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

    // $ANTLR start "NumberSign"
    public final void mNumberSign() throws RecognitionException {
        try {
            int _type = NumberSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:12: ( '#' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:73:14: '#'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:13: ( '%' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:75:15: '%'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:11: ( '&' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:77:13: '&'
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

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:10: ( '.' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:79:12: '.'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:9: ( '/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:81:11: '/'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:7: ( ':' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:83:9: ':'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:14: ( '<' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:85:16: '<'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:12: ( '=' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:87:14: '='
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:17: ( '>' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:89:19: '>'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:19: ( '[' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:91:21: '['
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:20: ( ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:93:22: ']'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:11: '^'
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:97:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:10: ( ( '0' .. '9' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:12: ( '0' .. '9' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:12: ( '0' .. '9' )+
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:99:13: '0' .. '9'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
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
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:28: ~ ( ( '\\\\' | '\"' ) )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
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
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:101:61: ~ ( ( '\\\\' | '\\'' ) )
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:24: ( options {greedy=false; } : . )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:103:52: .
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:24: ~ ( ( '\\n' | '\\r' ) )
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:105:41: '\\r'
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:107:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:16: ( . )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:109:18: .
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
        // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:8: ( Specification | Description | Requirement | Stakeholder | Conflicts | Constants | Mitigates | Rationale | Category | Document | Include | Library | Refines | Section | Assert | Folder | Goals | Goal | This | With | For | See | ExclamationMarkEqualsSign | FullStopAsterisk | ColonColon | LessThanSignEqualsSign | GreaterThanSignEqualsSign | NumberSign | PercentSign | Ampersand | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=45;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:10: Specification
                {
                mSpecification(); 

                }
                break;
            case 2 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:24: Description
                {
                mDescription(); 

                }
                break;
            case 3 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:36: Requirement
                {
                mRequirement(); 

                }
                break;
            case 4 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:48: Stakeholder
                {
                mStakeholder(); 

                }
                break;
            case 5 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:60: Conflicts
                {
                mConflicts(); 

                }
                break;
            case 6 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:70: Constants
                {
                mConstants(); 

                }
                break;
            case 7 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:80: Mitigates
                {
                mMitigates(); 

                }
                break;
            case 8 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:90: Rationale
                {
                mRationale(); 

                }
                break;
            case 9 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:100: Category
                {
                mCategory(); 

                }
                break;
            case 10 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:109: Document
                {
                mDocument(); 

                }
                break;
            case 11 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:118: Include
                {
                mInclude(); 

                }
                break;
            case 12 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:126: Library
                {
                mLibrary(); 

                }
                break;
            case 13 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:134: Refines
                {
                mRefines(); 

                }
                break;
            case 14 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:142: Section
                {
                mSection(); 

                }
                break;
            case 15 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:150: Assert
                {
                mAssert(); 

                }
                break;
            case 16 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:157: Folder
                {
                mFolder(); 

                }
                break;
            case 17 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:164: Goals
                {
                mGoals(); 

                }
                break;
            case 18 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:170: Goal
                {
                mGoal(); 

                }
                break;
            case 19 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:175: This
                {
                mThis(); 

                }
                break;
            case 20 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:180: With
                {
                mWith(); 

                }
                break;
            case 21 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:185: For
                {
                mFor(); 

                }
                break;
            case 22 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:189: See
                {
                mSee(); 

                }
                break;
            case 23 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:193: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 24 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:219: FullStopAsterisk
                {
                mFullStopAsterisk(); 

                }
                break;
            case 25 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:236: ColonColon
                {
                mColonColon(); 

                }
                break;
            case 26 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:247: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 27 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:270: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 28 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:296: NumberSign
                {
                mNumberSign(); 

                }
                break;
            case 29 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:307: PercentSign
                {
                mPercentSign(); 

                }
                break;
            case 30 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:319: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 31 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:329: FullStop
                {
                mFullStop(); 

                }
                break;
            case 32 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:338: Solidus
                {
                mSolidus(); 

                }
                break;
            case 33 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:346: Colon
                {
                mColon(); 

                }
                break;
            case 34 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:352: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 35 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:365: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 36 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:376: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 37 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:392: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 38 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:410: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 39 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:429: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 40 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:437: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 41 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:446: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 42 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:458: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 43 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:474: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 44 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:490: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 45 :
                // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/lexer/InternalReqSpecLexer.g:1:498: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\14\43\1\37\1\64\1\66\1\70\1\72\3\uffff\1\100\3\uffff\1"+
        "\37\2\uffff\2\37\2\uffff\3\43\1\uffff\16\43\25\uffff\3\43\1\136"+
        "\14\43\1\154\6\43\1\uffff\15\43\1\uffff\1\u0081\1\u0082\1\u0083"+
        "\20\43\1\u0094\3\uffff\16\43\1\u00a3\1\u00a4\1\uffff\2\43\1\u00a7"+
        "\3\43\1\u00ab\5\43\1\u00b1\1\u00b2\2\uffff\2\43\1\uffff\1\43\1\u00b6"+
        "\1\43\1\uffff\3\43\1\u00bb\1\43\2\uffff\3\43\1\uffff\1\43\1\u00c1"+
        "\1\u00c2\1\u00c3\1\uffff\1\u00c4\4\43\4\uffff\1\43\1\u00ca\1\u00cb"+
        "\1\u00cc\1\43\3\uffff\1\u00ce\1\uffff";
    static final String DFA12_eofS =
        "\u00cf\uffff";
    static final String DFA12_minS =
        "\1\0\2\105\2\101\1\111\1\116\1\111\1\123\2\117\1\110\1\111\1\75"+
        "\1\52\1\72\2\75\3\uffff\1\52\3\uffff\1\101\2\uffff\2\0\2\uffff\1"+
        "\105\1\101\1\103\1\uffff\1\123\1\103\1\106\1\124\1\116\2\124\1\103"+
        "\1\102\1\123\1\114\1\101\1\111\1\124\25\uffff\1\103\1\113\1\124"+
        "\1\60\1\103\2\125\2\111\1\106\1\105\1\111\1\114\1\122\1\105\1\104"+
        "\1\60\1\114\1\123\1\110\1\111\1\105\1\111\1\uffff\1\122\1\115\1"+
        "\111\1\116\1\117\1\114\1\124\2\107\1\125\1\101\1\122\1\105\1\uffff"+
        "\3\60\1\106\1\110\1\117\1\111\1\105\1\122\1\105\1\116\1\111\1\101"+
        "\1\117\1\101\1\104\1\122\1\124\1\122\1\60\3\uffff\1\111\1\117\1"+
        "\116\1\120\1\116\1\105\1\123\1\101\1\103\1\116\1\122\1\124\1\105"+
        "\1\131\2\60\1\uffff\1\103\1\114\1\60\2\124\1\115\1\60\1\114\2\124"+
        "\1\131\1\105\2\60\2\uffff\1\101\1\104\1\uffff\1\111\1\60\1\105\1"+
        "\uffff\1\105\2\123\1\60\1\123\2\uffff\1\124\1\105\1\117\1\uffff"+
        "\1\116\3\60\1\uffff\1\60\1\111\1\122\1\116\1\124\4\uffff\1\117\3"+
        "\60\1\116\3\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\164\1\157\1\145\1\157\1\151\1\156\1\151\1\163\2\157"+
        "\1\150\1\151\1\75\1\52\1\72\2\75\3\uffff\1\57\3\uffff\1\172\2\uffff"+
        "\2\uffff\2\uffff\1\145\1\141\1\145\1\uffff\1\163\1\143\1\161\1\164"+
        "\1\156\2\164\1\143\1\142\1\163\1\162\1\141\1\151\1\164\25\uffff"+
        "\1\143\1\153\1\164\1\172\1\143\2\165\2\151\1\163\1\145\1\151\1\154"+
        "\1\162\1\145\1\144\1\172\1\154\1\163\1\150\1\151\1\145\1\151\1\uffff"+
        "\1\162\1\155\1\151\1\156\1\157\1\154\1\164\2\147\1\165\1\141\1\162"+
        "\1\145\1\uffff\3\172\1\146\1\150\1\157\1\151\1\145\1\162\1\145\1"+
        "\156\1\151\1\141\1\157\1\141\1\144\1\162\1\164\1\162\1\172\3\uffff"+
        "\1\151\1\157\1\156\1\160\1\156\1\145\1\163\1\141\1\143\1\156\1\162"+
        "\1\164\1\145\1\171\2\172\1\uffff\1\143\1\154\1\172\2\164\1\155\1"+
        "\172\1\154\2\164\1\171\1\145\2\172\2\uffff\1\141\1\144\1\uffff\1"+
        "\151\1\172\1\145\1\uffff\1\145\2\163\1\172\1\163\2\uffff\1\164\1"+
        "\145\1\157\1\uffff\1\156\3\172\1\uffff\1\172\1\151\1\162\1\156\1"+
        "\164\4\uffff\1\157\3\172\1\156\3\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\22\uffff\1\34\1\35\1\36\1\uffff\1\43\1\45\1\46\1\uffff\1\47\1"+
        "\50\2\uffff\1\54\1\55\3\uffff\1\47\16\uffff\1\27\1\30\1\37\1\31"+
        "\1\41\1\32\1\42\1\33\1\44\1\34\1\35\1\36\1\52\1\53\1\40\1\43\1\45"+
        "\1\46\1\50\1\51\1\54\27\uffff\1\26\15\uffff\1\25\24\uffff\1\22\1"+
        "\23\1\24\20\uffff\1\21\16\uffff\1\17\1\20\2\uffff\1\16\3\uffff\1"+
        "\15\5\uffff\1\13\1\14\3\uffff\1\12\4\uffff\1\11\5\uffff\1\10\1\5"+
        "\1\6\1\7\5\uffff\1\4\1\2\1\3\1\uffff\1\1";
    static final String DFA12_specialS =
        "\1\2\33\uffff\1\1\1\0\u00b1\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\37\2\36\2\37\1\36\22\37\1\36\1\15\1\34\1\22\1\37\1\23\1"+
            "\24\1\35\6\37\1\16\1\25\12\33\1\17\1\37\1\20\1\26\1\21\2\37"+
            "\1\10\1\32\1\4\1\2\1\32\1\11\1\12\1\32\1\6\2\32\1\7\1\5\4\32"+
            "\1\3\1\1\1\13\2\32\1\14\3\32\1\27\1\37\1\30\1\31\1\32\1\37\1"+
            "\10\1\32\1\4\1\2\1\32\1\11\1\12\1\32\1\6\2\32\1\7\1\5\4\32\1"+
            "\3\1\1\1\13\2\32\1\14\3\32\uff85\37",
            "\1\42\12\uffff\1\40\3\uffff\1\41\20\uffff\1\42\12\uffff\1"+
            "\40\3\uffff\1\41",
            "\1\44\11\uffff\1\45\25\uffff\1\44\11\uffff\1\45",
            "\1\47\3\uffff\1\46\33\uffff\1\47\3\uffff\1\46",
            "\1\51\15\uffff\1\50\21\uffff\1\51\15\uffff\1\50",
            "\1\52\37\uffff\1\52",
            "\1\53\37\uffff\1\53",
            "\1\54\37\uffff\1\54",
            "\1\55\37\uffff\1\55",
            "\1\56\37\uffff\1\56",
            "\1\57\37\uffff\1\57",
            "\1\60\37\uffff\1\60",
            "\1\61\37\uffff\1\61",
            "\1\62",
            "\1\63",
            "\1\65",
            "\1\67",
            "\1\71",
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
            "\1\107\37\uffff\1\107",
            "\1\110\37\uffff\1\110",
            "\1\111\1\uffff\1\112\35\uffff\1\111\1\uffff\1\112",
            "",
            "\1\113\37\uffff\1\113",
            "\1\114\37\uffff\1\114",
            "\1\116\12\uffff\1\115\24\uffff\1\116\12\uffff\1\115",
            "\1\117\37\uffff\1\117",
            "\1\120\37\uffff\1\120",
            "\1\121\37\uffff\1\121",
            "\1\122\37\uffff\1\122",
            "\1\123\37\uffff\1\123",
            "\1\124\37\uffff\1\124",
            "\1\125\37\uffff\1\125",
            "\1\126\5\uffff\1\127\31\uffff\1\126\5\uffff\1\127",
            "\1\130\37\uffff\1\130",
            "\1\131\37\uffff\1\131",
            "\1\132\37\uffff\1\132",
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
            "\1\133\37\uffff\1\133",
            "\1\134\37\uffff\1\134",
            "\1\135\37\uffff\1\135",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\137\37\uffff\1\137",
            "\1\140\37\uffff\1\140",
            "\1\141\37\uffff\1\141",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\14\uffff\1\145\22\uffff\1\144\14\uffff\1\145",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\150\37\uffff\1\150",
            "\1\151\37\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\155\37\uffff\1\155",
            "\1\156\37\uffff\1\156",
            "\1\157\37\uffff\1\157",
            "\1\160\37\uffff\1\160",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "",
            "\1\163\37\uffff\1\163",
            "\1\164\37\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\1\173\37\uffff\1\173",
            "\1\174\37\uffff\1\174",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "",
            "\12\43\7\uffff\22\43\1\u0080\7\43\4\uffff\1\43\1\uffff\22"+
            "\43\1\u0080\7\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u0084\37\uffff\1\u0084",
            "\1\u0085\37\uffff\1\u0085",
            "\1\u0086\37\uffff\1\u0086",
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
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0098\37\uffff\1\u0098",
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
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b4\37\uffff\1\u00b4",
            "",
            "\1\u00b5\37\uffff\1\u00b5",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00b7\37\uffff\1\u00b7",
            "",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\u00b9\37\uffff\1\u00b9",
            "\1\u00ba\37\uffff\1\u00ba",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00bc\37\uffff\1\u00bc",
            "",
            "",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00bf",
            "",
            "\1\u00c0\37\uffff\1\u00c0",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "",
            "",
            "",
            "",
            "\1\u00c9\37\uffff\1\u00c9",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
            "\1\u00cd\37\uffff\1\u00cd",
            "",
            "",
            "",
            "\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
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
            return "1:1: Tokens : ( Specification | Description | Requirement | Stakeholder | Conflicts | Constants | Mitigates | Rationale | Category | Document | Include | Library | Refines | Section | Assert | Folder | Goals | Goal | This | With | For | See | ExclamationMarkEqualsSign | FullStopAsterisk | ColonColon | LessThanSignEqualsSign | GreaterThanSignEqualsSign | NumberSign | PercentSign | Ampersand | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftSquareBracket | RightSquareBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_29 = input.LA(1);

                        s = -1;
                        if ( ((LA12_29>='\u0000' && LA12_29<='\uFFFF')) ) {s = 69;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_28 = input.LA(1);

                        s = -1;
                        if ( ((LA12_28>='\u0000' && LA12_28<='\uFFFF')) ) {s = 69;}

                        else s = 31;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='S'||LA12_0=='s') ) {s = 1;}

                        else if ( (LA12_0=='D'||LA12_0=='d') ) {s = 2;}

                        else if ( (LA12_0=='R'||LA12_0=='r') ) {s = 3;}

                        else if ( (LA12_0=='C'||LA12_0=='c') ) {s = 4;}

                        else if ( (LA12_0=='M'||LA12_0=='m') ) {s = 5;}

                        else if ( (LA12_0=='I'||LA12_0=='i') ) {s = 6;}

                        else if ( (LA12_0=='L'||LA12_0=='l') ) {s = 7;}

                        else if ( (LA12_0=='A'||LA12_0=='a') ) {s = 8;}

                        else if ( (LA12_0=='F'||LA12_0=='f') ) {s = 9;}

                        else if ( (LA12_0=='G'||LA12_0=='g') ) {s = 10;}

                        else if ( (LA12_0=='T'||LA12_0=='t') ) {s = 11;}

                        else if ( (LA12_0=='W'||LA12_0=='w') ) {s = 12;}

                        else if ( (LA12_0=='!') ) {s = 13;}

                        else if ( (LA12_0=='.') ) {s = 14;}

                        else if ( (LA12_0==':') ) {s = 15;}

                        else if ( (LA12_0=='<') ) {s = 16;}

                        else if ( (LA12_0=='>') ) {s = 17;}

                        else if ( (LA12_0=='#') ) {s = 18;}

                        else if ( (LA12_0=='%') ) {s = 19;}

                        else if ( (LA12_0=='&') ) {s = 20;}

                        else if ( (LA12_0=='/') ) {s = 21;}

                        else if ( (LA12_0=='=') ) {s = 22;}

                        else if ( (LA12_0=='[') ) {s = 23;}

                        else if ( (LA12_0==']') ) {s = 24;}

                        else if ( (LA12_0=='^') ) {s = 25;}

                        else if ( (LA12_0=='B'||LA12_0=='E'||LA12_0=='H'||(LA12_0>='J' && LA12_0<='K')||(LA12_0>='N' && LA12_0<='Q')||(LA12_0>='U' && LA12_0<='V')||(LA12_0>='X' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='b'||LA12_0=='e'||LA12_0=='h'||(LA12_0>='j' && LA12_0<='k')||(LA12_0>='n' && LA12_0<='q')||(LA12_0>='u' && LA12_0<='v')||(LA12_0>='x' && LA12_0<='z')) ) {s = 26;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 27;}

                        else if ( (LA12_0=='\"') ) {s = 28;}

                        else if ( (LA12_0=='\'') ) {s = 29;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 30;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='$'||(LA12_0>='(' && LA12_0<='-')||LA12_0==';'||(LA12_0>='?' && LA12_0<='@')||LA12_0=='\\'||LA12_0=='`'||(LA12_0>='{' && LA12_0<='\uFFFF')) ) {s = 31;}

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