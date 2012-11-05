package org.osate.xtext.aadl2.properties.ui.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPropertiesLexer extends Lexer {
    public static final int RULE_ID=43;
    public static final int RULE_REAL_LIT=39;
    public static final int RULE_INTEGER_LIT=41;
    public static final int KEYWORD_19=16;
    public static final int KEYWORD_17=22;
    public static final int KEYWORD_18=15;
    public static final int KEYWORD_15=20;
    public static final int KEYWORD_16=21;
    public static final int KEYWORD_13=18;
    public static final int KEYWORD_14=19;
    public static final int KEYWORD_11=33;
    public static final int EOF=-1;
    public static final int KEYWORD_12=34;
    public static final int KEYWORD_10=32;
    public static final int RULE_ANNEXTEXT=44;
    public static final int RULE_IDANNEXTEXT=45;
    public static final int KEYWORD_6=28;
    public static final int KEYWORD_7=29;
    public static final int KEYWORD_8=30;
    public static final int KEYWORD_9=31;
    public static final int KEYWORD_28=9;
    public static final int KEYWORD_29=6;
    public static final int KEYWORD_24=12;
    public static final int KEYWORD_25=13;
    public static final int KEYWORD_26=7;
    public static final int KEYWORD_27=8;
    public static final int KEYWORD_20=17;
    public static final int KEYWORD_21=14;
    public static final int KEYWORD_22=10;
    public static final int KEYWORD_23=11;
    public static final int RULE_EXTENDED_DIGIT=42;
    public static final int KEYWORD_30=5;
    public static final int KEYWORD_1=23;
    public static final int KEYWORD_5=27;
    public static final int KEYWORD_4=26;
    public static final int KEYWORD_3=25;
    public static final int KEYWORD_31=4;
    public static final int KEYWORD_2=24;
    public static final int RULE_BASED_INTEGER=40;
    public static final int RULE_SL_COMMENT=35;
    public static final int RULE_STRING=46;
    public static final int RULE_EXPONENT=37;
    public static final int RULE_INT_EXPONENT=38;
    public static final int RULE_WS=47;
    public static final int RULE_DIGIT=36;

    // delegates
    // delegators

    public InternalPropertiesLexer() {;} 
    public InternalPropertiesLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalPropertiesLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g"; }

    // $ANTLR start "KEYWORD_31"
    public final void mKEYWORD_31() throws RecognitionException {
        try {
            int _type = KEYWORD_31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:19:12: ( ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:19:14: ( 'C' | 'c' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'I' | 'i' ) ( 'F' | 'f' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
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
    // $ANTLR end "KEYWORD_31"

    // $ANTLR start "KEYWORD_30"
    public final void mKEYWORD_30() throws RecognitionException {
        try {
            int _type = KEYWORD_30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:21:12: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:21:14: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'C' | 'c' ) ( 'E' | 'e' )
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_30"

    // $ANTLR start "KEYWORD_29"
    public final void mKEYWORD_29() throws RecognitionException {
        try {
            int _type = KEYWORD_29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:23:12: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:23:14: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'T' | 't' )
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
    // $ANTLR end "KEYWORD_29"

    // $ANTLR start "KEYWORD_26"
    public final void mKEYWORD_26() throws RecognitionException {
        try {
            int _type = KEYWORD_26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:25:12: ( ( 'A' | 'a' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:25:14: ( 'A' | 'a' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
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
    // $ANTLR end "KEYWORD_26"

    // $ANTLR start "KEYWORD_27"
    public final void mKEYWORD_27() throws RecognitionException {
        try {
            int _type = KEYWORD_27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:27:12: ( ( 'B' | 'b' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'G' | 'g' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:27:14: ( 'B' | 'b' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'D' | 'd' ) ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'G' | 'g' )
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
    // $ANTLR end "KEYWORD_27"

    // $ANTLR start "KEYWORD_28"
    public final void mKEYWORD_28() throws RecognitionException {
        try {
            int _type = KEYWORD_28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:29:12: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:29:14: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'U' | 'u' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
    // $ANTLR end "KEYWORD_28"

    // $ANTLR start "KEYWORD_22"
    public final void mKEYWORD_22() throws RecognitionException {
        try {
            int _type = KEYWORD_22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:31:12: ( ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'X' | 'x' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:31:14: ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'N' | 'n' ) ( 'E' | 'e' ) ( 'X' | 'x' )
            {
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
    // $ANTLR end "KEYWORD_22"

    // $ANTLR start "KEYWORD_23"
    public final void mKEYWORD_23() throws RecognitionException {
        try {
            int _type = KEYWORD_23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:33:12: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'T' | 't' ) ( 'A' | 'a' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:33:14: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'T' | 't' ) ( 'A' | 'a' )
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

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
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
    // $ANTLR end "KEYWORD_23"

    // $ANTLR start "KEYWORD_24"
    public final void mKEYWORD_24() throws RecognitionException {
        try {
            int _type = KEYWORD_24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:35:12: ( ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:35:14: ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
    // $ANTLR end "KEYWORD_24"

    // $ANTLR start "KEYWORD_25"
    public final void mKEYWORD_25() throws RecognitionException {
        try {
            int _type = KEYWORD_25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:37:12: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:37:14: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_25"

    // $ANTLR start "KEYWORD_21"
    public final void mKEYWORD_21() throws RecognitionException {
        try {
            int _type = KEYWORD_21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:39:12: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:39:14: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
    // $ANTLR end "KEYWORD_21"

    // $ANTLR start "KEYWORD_18"
    public final void mKEYWORD_18() throws RecognitionException {
        try {
            int _type = KEYWORD_18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:41:12: ( '*' '*' '}' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:41:14: '*' '*' '}'
            {
            match('*'); 
            match('*'); 
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_18"

    // $ANTLR start "KEYWORD_19"
    public final void mKEYWORD_19() throws RecognitionException {
        try {
            int _type = KEYWORD_19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:43:12: ( '+' '=' '>' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:43:14: '+' '=' '>'
            {
            match('+'); 
            match('='); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_19"

    // $ANTLR start "KEYWORD_20"
    public final void mKEYWORD_20() throws RecognitionException {
        try {
            int _type = KEYWORD_20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:45:12: ( '{' '*' '*' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:45:14: '{' '*' '*'
            {
            match('{'); 
            match('*'); 
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_20"

    // $ANTLR start "KEYWORD_13"
    public final void mKEYWORD_13() throws RecognitionException {
        try {
            int _type = KEYWORD_13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:47:12: ( '.' '.' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:47:14: '.' '.'
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
    // $ANTLR end "KEYWORD_13"

    // $ANTLR start "KEYWORD_14"
    public final void mKEYWORD_14() throws RecognitionException {
        try {
            int _type = KEYWORD_14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:49:12: ( ':' ':' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:49:14: ':' ':'
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
    // $ANTLR end "KEYWORD_14"

    // $ANTLR start "KEYWORD_15"
    public final void mKEYWORD_15() throws RecognitionException {
        try {
            int _type = KEYWORD_15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:51:12: ( '=' '>' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:51:14: '=' '>'
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
    // $ANTLR end "KEYWORD_15"

    // $ANTLR start "KEYWORD_16"
    public final void mKEYWORD_16() throws RecognitionException {
        try {
            int _type = KEYWORD_16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:53:12: ( ( 'I' | 'i' ) ( 'N' | 'n' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:53:14: ( 'I' | 'i' ) ( 'N' | 'n' )
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_16"

    // $ANTLR start "KEYWORD_17"
    public final void mKEYWORD_17() throws RecognitionException {
        try {
            int _type = KEYWORD_17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:55:12: ( ( 'T' | 't' ) ( 'O' | 'o' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:55:14: ( 'T' | 't' ) ( 'O' | 'o' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "KEYWORD_17"

    // $ANTLR start "KEYWORD_1"
    public final void mKEYWORD_1() throws RecognitionException {
        try {
            int _type = KEYWORD_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:57:11: ( '(' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:57:13: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_1"

    // $ANTLR start "KEYWORD_2"
    public final void mKEYWORD_2() throws RecognitionException {
        try {
            int _type = KEYWORD_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:59:11: ( ')' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:59:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_2"

    // $ANTLR start "KEYWORD_3"
    public final void mKEYWORD_3() throws RecognitionException {
        try {
            int _type = KEYWORD_3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:61:11: ( '*' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:61:13: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_3"

    // $ANTLR start "KEYWORD_4"
    public final void mKEYWORD_4() throws RecognitionException {
        try {
            int _type = KEYWORD_4;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:63:11: ( '+' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:63:13: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_4"

    // $ANTLR start "KEYWORD_5"
    public final void mKEYWORD_5() throws RecognitionException {
        try {
            int _type = KEYWORD_5;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:65:11: ( ',' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:65:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_5"

    // $ANTLR start "KEYWORD_6"
    public final void mKEYWORD_6() throws RecognitionException {
        try {
            int _type = KEYWORD_6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:67:11: ( '-' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:67:13: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_6"

    // $ANTLR start "KEYWORD_7"
    public final void mKEYWORD_7() throws RecognitionException {
        try {
            int _type = KEYWORD_7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:69:11: ( '.' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:69:13: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_7"

    // $ANTLR start "KEYWORD_8"
    public final void mKEYWORD_8() throws RecognitionException {
        try {
            int _type = KEYWORD_8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:71:11: ( ';' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:71:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_8"

    // $ANTLR start "KEYWORD_9"
    public final void mKEYWORD_9() throws RecognitionException {
        try {
            int _type = KEYWORD_9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:73:11: ( '[' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:73:13: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_9"

    // $ANTLR start "KEYWORD_10"
    public final void mKEYWORD_10() throws RecognitionException {
        try {
            int _type = KEYWORD_10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:75:12: ( ']' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:75:14: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_10"

    // $ANTLR start "KEYWORD_11"
    public final void mKEYWORD_11() throws RecognitionException {
        try {
            int _type = KEYWORD_11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:77:12: ( '{' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:77:14: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_11"

    // $ANTLR start "KEYWORD_12"
    public final void mKEYWORD_12() throws RecognitionException {
        try {
            int _type = KEYWORD_12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:79:12: ( '}' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:79:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEYWORD_12"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:17: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:19: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:24: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop1;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:40: ( ( '\\r' )? '\\n' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:41: ( '\\r' )? '\\n'
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:41: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:83:41: '\\r'
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

    // $ANTLR start "RULE_EXPONENT"
    public final void mRULE_EXPONENT() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:85:24: ( ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+ )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:85:26: ( 'e' | 'E' ) ( '+' | '-' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:85:36: ( '+' | '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='+'||LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:
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

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:85:47: ( RULE_DIGIT )+
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
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:85:47: RULE_DIGIT
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


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXPONENT"

    // $ANTLR start "RULE_INT_EXPONENT"
    public final void mRULE_INT_EXPONENT() throws RecognitionException {
        try {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:87:28: ( ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+ )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:87:30: ( 'e' | 'E' ) ( '+' )? ( RULE_DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:87:40: ( '+' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='+') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:87:40: '+'
                    {
                    match('+'); 

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:87:45: ( RULE_DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:87:45: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:15: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )? )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:17: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* '.' ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( RULE_EXPONENT )?
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:17: ( RULE_DIGIT )+
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
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:17: RULE_DIGIT
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

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:29: ( '_' ( RULE_DIGIT )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='_') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:30: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:34: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:34: RULE_DIGIT
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

            match('.'); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:52: ( RULE_DIGIT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:52: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

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

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:64: ( '_' ( RULE_DIGIT )+ )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='_') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:65: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:69: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:69: RULE_DIGIT
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


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:83: ( RULE_EXPONENT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='E'||LA14_0=='e') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:89:83: RULE_EXPONENT
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:18: ( ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:20: ( RULE_DIGIT )+ ( '_' ( RULE_DIGIT )+ )* ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:20: ( RULE_DIGIT )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:20: RULE_DIGIT
            	    {
            	    mRULE_DIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:32: ( '_' ( RULE_DIGIT )+ )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='_') ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:33: '_' ( RULE_DIGIT )+
            	    {
            	    match('_'); 
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:37: ( RULE_DIGIT )+
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
            	    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:37: RULE_DIGIT
            	    	    {
            	    	    mRULE_DIGIT(); 

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
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:51: ( '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )? | ( RULE_INT_EXPONENT )? )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='#') ) {
                alt20=1;
            }
            else {
                alt20=2;}
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:52: '#' RULE_BASED_INTEGER '#' ( RULE_INT_EXPONENT )?
                    {
                    match('#'); 
                    mRULE_BASED_INTEGER(); 
                    match('#'); 
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:79: ( RULE_INT_EXPONENT )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='E'||LA18_0=='e') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:79: RULE_INT_EXPONENT
                            {
                            mRULE_INT_EXPONENT(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:98: ( RULE_INT_EXPONENT )?
                    {
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:98: ( RULE_INT_EXPONENT )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='E'||LA19_0=='e') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:91:98: RULE_INT_EXPONENT
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:93:21: ( '0' .. '9' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:93:23: '0' .. '9'
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:95:30: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:95:32: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:97:29: ( RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )* )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:97:31: RULE_EXTENDED_DIGIT ( ( '_' )? RULE_EXTENDED_DIGIT )*
            {
            mRULE_EXTENDED_DIGIT(); 
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:97:51: ( ( '_' )? RULE_EXTENDED_DIGIT )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>='0' && LA22_0<='9')||(LA22_0>='A' && LA22_0<='F')||LA22_0=='_'||(LA22_0>='a' && LA22_0<='f')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:97:52: ( '_' )? RULE_EXTENDED_DIGIT
            	    {
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:97:52: ( '_' )?
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0=='_') ) {
            	        alt21=1;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:97:52: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    mRULE_EXTENDED_DIGIT(); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BASED_INTEGER"

    // $ANTLR start "RULE_IDANNEXTEXT"
    public final void mRULE_IDANNEXTEXT() throws RecognitionException {
        try {
            int _type = RULE_IDANNEXTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:99:18: ( RULE_ID RULE_ANNEXTEXT )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:99:20: RULE_ID RULE_ANNEXTEXT
            {
            mRULE_ID(); 
            mRULE_ANNEXTEXT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IDANNEXTEXT"

    // $ANTLR start "RULE_ANNEXTEXT"
    public final void mRULE_ANNEXTEXT() throws RecognitionException {
        try {
            int _type = RULE_ANNEXTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:101:16: ( '{**' ( options {greedy=false; } : . )* '**}' )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:101:18: '{**' ( options {greedy=false; } : . )* '**}'
            {
            match("{**"); 

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:101:24: ( options {greedy=false; } : . )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='*') ) {
                    int LA23_1 = input.LA(2);

                    if ( (LA23_1=='*') ) {
                        int LA23_3 = input.LA(3);

                        if ( (LA23_3=='}') ) {
                            alt23=2;
                        }
                        else if ( ((LA23_3>='\u0000' && LA23_3<='|')||(LA23_3>='~' && LA23_3<='\uFFFF')) ) {
                            alt23=1;
                        }


                    }
                    else if ( ((LA23_1>='\u0000' && LA23_1<=')')||(LA23_1>='+' && LA23_1<='\uFFFF')) ) {
                        alt23=1;
                    }


                }
                else if ( ((LA23_0>='\u0000' && LA23_0<=')')||(LA23_0>='+' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:101:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match("**}"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANNEXTEXT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='\"') ) {
                alt26=1;
            }
            else if ( (LA26_0=='\'') ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop24:
                    do {
                        int alt24=3;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0=='\\') ) {
                            alt24=1;
                        }
                        else if ( ((LA24_0>='\u0000' && LA24_0<='!')||(LA24_0>='#' && LA24_0<='[')||(LA24_0>=']' && LA24_0<='\uFFFF')) ) {
                            alt24=2;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:66: ~ ( ( '\\\\' | '\"' ) )
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
                    	    break loop24;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop25:
                    do {
                        int alt25=3;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0=='\\') ) {
                            alt25=1;
                        }
                        else if ( ((LA25_0>='\u0000' && LA25_0<='&')||(LA25_0>='(' && LA25_0<='[')||(LA25_0>=']' && LA25_0<='\uFFFF')) ) {
                            alt25=2;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:103:137: ~ ( ( '\\\\' | '\\'' ) )
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
                    	    break loop25;
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

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:105:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:105:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:105:31: ( ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>='0' && LA28_0<='9')||(LA28_0>='A' && LA28_0<='Z')||LA28_0=='_'||(LA28_0>='a' && LA28_0<='z')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:105:32: ( '_' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:105:32: ( '_' )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0=='_') ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:105:32: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop28;
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

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:107:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:107:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:107:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='\t' && LA29_0<='\n')||LA29_0=='\r'||LA29_0==' ') ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:
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
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:8: ( KEYWORD_31 | KEYWORD_30 | KEYWORD_29 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_21 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | RULE_SL_COMMENT | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_IDANNEXTEXT | RULE_ANNEXTEXT | RULE_STRING | RULE_ID | RULE_WS )
        int alt30=39;
        alt30 = dfa30.predict(input);
        switch (alt30) {
            case 1 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:10: KEYWORD_31
                {
                mKEYWORD_31(); 

                }
                break;
            case 2 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:21: KEYWORD_30
                {
                mKEYWORD_30(); 

                }
                break;
            case 3 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:32: KEYWORD_29
                {
                mKEYWORD_29(); 

                }
                break;
            case 4 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:43: KEYWORD_26
                {
                mKEYWORD_26(); 

                }
                break;
            case 5 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:54: KEYWORD_27
                {
                mKEYWORD_27(); 

                }
                break;
            case 6 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:65: KEYWORD_28
                {
                mKEYWORD_28(); 

                }
                break;
            case 7 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:76: KEYWORD_22
                {
                mKEYWORD_22(); 

                }
                break;
            case 8 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:87: KEYWORD_23
                {
                mKEYWORD_23(); 

                }
                break;
            case 9 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:98: KEYWORD_24
                {
                mKEYWORD_24(); 

                }
                break;
            case 10 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:109: KEYWORD_25
                {
                mKEYWORD_25(); 

                }
                break;
            case 11 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:120: KEYWORD_21
                {
                mKEYWORD_21(); 

                }
                break;
            case 12 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:131: KEYWORD_18
                {
                mKEYWORD_18(); 

                }
                break;
            case 13 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:142: KEYWORD_19
                {
                mKEYWORD_19(); 

                }
                break;
            case 14 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:153: KEYWORD_20
                {
                mKEYWORD_20(); 

                }
                break;
            case 15 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:164: KEYWORD_13
                {
                mKEYWORD_13(); 

                }
                break;
            case 16 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:175: KEYWORD_14
                {
                mKEYWORD_14(); 

                }
                break;
            case 17 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:186: KEYWORD_15
                {
                mKEYWORD_15(); 

                }
                break;
            case 18 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:197: KEYWORD_16
                {
                mKEYWORD_16(); 

                }
                break;
            case 19 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:208: KEYWORD_17
                {
                mKEYWORD_17(); 

                }
                break;
            case 20 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:219: KEYWORD_1
                {
                mKEYWORD_1(); 

                }
                break;
            case 21 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:229: KEYWORD_2
                {
                mKEYWORD_2(); 

                }
                break;
            case 22 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:239: KEYWORD_3
                {
                mKEYWORD_3(); 

                }
                break;
            case 23 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:249: KEYWORD_4
                {
                mKEYWORD_4(); 

                }
                break;
            case 24 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:259: KEYWORD_5
                {
                mKEYWORD_5(); 

                }
                break;
            case 25 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:269: KEYWORD_6
                {
                mKEYWORD_6(); 

                }
                break;
            case 26 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:279: KEYWORD_7
                {
                mKEYWORD_7(); 

                }
                break;
            case 27 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:289: KEYWORD_8
                {
                mKEYWORD_8(); 

                }
                break;
            case 28 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:299: KEYWORD_9
                {
                mKEYWORD_9(); 

                }
                break;
            case 29 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:309: KEYWORD_10
                {
                mKEYWORD_10(); 

                }
                break;
            case 30 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:320: KEYWORD_11
                {
                mKEYWORD_11(); 

                }
                break;
            case 31 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:331: KEYWORD_12
                {
                mKEYWORD_12(); 

                }
                break;
            case 32 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:342: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 33 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:358: RULE_REAL_LIT
                {
                mRULE_REAL_LIT(); 

                }
                break;
            case 34 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:372: RULE_INTEGER_LIT
                {
                mRULE_INTEGER_LIT(); 

                }
                break;
            case 35 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:389: RULE_IDANNEXTEXT
                {
                mRULE_IDANNEXTEXT(); 

                }
                break;
            case 36 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:406: RULE_ANNEXTEXT
                {
                mRULE_ANNEXTEXT(); 

                }
                break;
            case 37 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:421: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 38 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:433: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 39 :
                // ../org.osate.xtext.aadl2.properties.ui/src-gen/org/osate/xtext/aadl2/properties/ui/contentassist/antlr/lexer/InternalPropertiesLexer.g:1:441: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA30_eotS =
        "\1\uffff\10\40\1\54\1\56\1\60\1\62\2\uffff\1\40\3\uffff\1\65\4"+
        "\uffff\1\66\1\40\2\uffff\2\40\1\uffff\1\40\2\uffff\10\40\1\104\10"+
        "\uffff\1\106\5\uffff\13\40\1\uffff\1\123\1\uffff\1\66\12\40\1\137"+
        "\2\uffff\5\40\1\145\1\40\1\147\1\150\1\151\1\uffff\5\40\1\uffff"+
        "\1\40\3\uffff\2\40\1\162\1\40\1\164\1\165\1\40\1\167\1\uffff\1\40"+
        "\2\uffff\1\40\1\uffff\1\172\1\173\2\uffff";
    static final String DFA30_eofS =
        "\174\uffff";
    static final String DFA30_minS =
        "\1\11\10\60\1\52\1\75\1\52\1\56\2\uffff\1\60\3\uffff\1\55\4\uffff"+
        "\1\56\1\60\2\uffff\4\60\2\uffff\11\60\4\uffff\1\52\3\uffff\1\60"+
        "\3\uffff\1\60\1\uffff\13\60\1\uffff\1\0\1\uffff\1\56\13\60\2\uffff"+
        "\12\60\1\uffff\5\60\1\uffff\1\60\3\uffff\10\60\1\uffff\1\60\2\uffff"+
        "\1\60\1\uffff\2\60\2\uffff";
    static final String DFA30_maxS =
        "\1\175\10\173\1\52\1\75\1\52\1\56\2\uffff\1\173\3\uffff\1\55\4"+
        "\uffff\1\137\1\173\2\uffff\2\173\1\172\1\173\2\uffff\11\173\4\uffff"+
        "\1\52\3\uffff\1\173\3\uffff\1\71\1\uffff\13\173\1\uffff\1\uffff"+
        "\1\uffff\1\137\13\173\2\uffff\12\173\1\uffff\5\173\1\uffff\1\173"+
        "\3\uffff\10\173\1\uffff\1\173\2\uffff\1\173\1\uffff\2\173\2\uffff";
    static final String DFA30_acceptS =
        "\15\uffff\1\20\1\21\1\uffff\1\24\1\25\1\30\1\uffff\1\33\1\34\1"+
        "\35\1\37\2\uffff\1\45\1\47\4\uffff\1\46\1\43\11\uffff\1\14\1\26"+
        "\1\15\1\27\1\uffff\1\36\1\17\1\32\1\uffff\1\40\1\31\1\42\1\uffff"+
        "\1\41\13\uffff\1\23\1\uffff\1\22\14\uffff\1\16\1\44\12\uffff\1\13"+
        "\5\uffff\1\7\1\uffff\1\10\1\11\1\12\10\uffff\1\6\1\uffff\1\4\1\5"+
        "\1\uffff\1\3\2\uffff\1\2\1\1";
    static final String DFA30_specialS =
        "\105\uffff\1\0\66\uffff}>";
    static final String[] DFA30_transitionS = {
            "\2\33\2\uffff\1\33\22\uffff\1\33\1\uffff\1\32\4\uffff\1\32"+
            "\1\20\1\21\1\11\1\12\1\22\1\23\1\14\1\uffff\12\30\1\15\1\24"+
            "\1\uffff\1\16\3\uffff\1\3\1\4\1\1\1\5\1\31\1\6\2\31\1\17\3\31"+
            "\1\7\4\31\1\2\1\31\1\10\6\31\1\25\1\uffff\1\26\3\uffff\1\3\1"+
            "\4\1\1\1\5\1\31\1\6\2\31\1\17\3\31\1\7\4\31\1\2\1\31\1\10\6"+
            "\31\1\13\1\uffff\1\27",
            "\12\37\7\uffff\13\37\1\34\2\37\1\35\13\37\4\uffff\1\36\1\uffff"+
            "\13\37\1\34\2\37\1\35\13\37\1\41",
            "\12\37\7\uffff\4\37\1\42\25\37\4\uffff\1\36\1\uffff\4\37\1"+
            "\42\25\37\1\41",
            "\12\37\7\uffff\15\37\1\44\1\37\1\43\12\37\4\uffff\1\36\1\uffff"+
            "\15\37\1\44\1\37\1\43\12\37\1\41",
            "\12\37\7\uffff\10\37\1\45\21\37\4\uffff\1\36\1\uffff\10\37"+
            "\1\45\21\37\1\41",
            "\12\37\7\uffff\4\37\1\46\25\37\4\uffff\1\36\1\uffff\4\37\1"+
            "\46\25\37\1\41",
            "\12\37\7\uffff\1\47\31\37\4\uffff\1\36\1\uffff\1\47\31\37"+
            "\1\41",
            "\12\37\7\uffff\16\37\1\50\13\37\4\uffff\1\36\1\uffff\16\37"+
            "\1\50\13\37\1\41",
            "\12\37\7\uffff\16\37\1\52\2\37\1\51\10\37\4\uffff\1\36\1\uffff"+
            "\16\37\1\52\2\37\1\51\10\37\1\41",
            "\1\53",
            "\1\55",
            "\1\57",
            "\1\61",
            "",
            "",
            "\12\37\7\uffff\15\37\1\63\14\37\4\uffff\1\36\1\uffff\15\37"+
            "\1\63\14\37\1\41",
            "",
            "",
            "",
            "\1\64",
            "",
            "",
            "",
            "",
            "\1\70\1\uffff\12\30\45\uffff\1\67",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "",
            "\12\37\7\uffff\1\71\31\37\4\uffff\1\36\1\uffff\1\71\31\37"+
            "\1\41",
            "\12\37\7\uffff\14\37\1\73\1\72\14\37\4\uffff\1\36\1\uffff"+
            "\14\37\1\73\1\72\14\37\1\41",
            "\12\37\7\uffff\32\37\6\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "",
            "\12\37\7\uffff\5\37\1\74\24\37\4\uffff\1\36\1\uffff\5\37\1"+
            "\74\24\37\1\41",
            "\12\37\7\uffff\17\37\1\75\12\37\4\uffff\1\36\1\uffff\17\37"+
            "\1\75\12\37\1\41",
            "\12\37\7\uffff\15\37\1\76\14\37\4\uffff\1\36\1\uffff\15\37"+
            "\1\76\14\37\1\41",
            "\12\37\7\uffff\15\37\1\77\14\37\4\uffff\1\36\1\uffff\15\37"+
            "\1\77\14\37\1\41",
            "\12\37\7\uffff\13\37\1\100\16\37\4\uffff\1\36\1\uffff\13\37"+
            "\1\100\16\37\1\41",
            "\12\37\7\uffff\13\37\1\101\16\37\4\uffff\1\36\1\uffff\13\37"+
            "\1\101\16\37\1\41",
            "\12\37\7\uffff\3\37\1\102\26\37\4\uffff\1\36\1\uffff\3\37"+
            "\1\102\26\37\1\41",
            "\12\37\7\uffff\24\37\1\103\5\37\4\uffff\1\36\1\uffff\24\37"+
            "\1\103\5\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "",
            "",
            "",
            "\1\105",
            "",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "",
            "",
            "\12\107",
            "",
            "\12\37\7\uffff\22\37\1\110\7\37\4\uffff\1\36\1\uffff\22\37"+
            "\1\110\7\37\1\41",
            "\12\37\7\uffff\22\37\1\111\7\37\4\uffff\1\36\1\uffff\22\37"+
            "\1\111\7\37\1\41",
            "\12\37\7\uffff\17\37\1\112\12\37\4\uffff\1\36\1\uffff\17\37"+
            "\1\112\12\37\1\41",
            "\12\37\7\uffff\4\37\1\113\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\113\25\37\1\41",
            "\12\37\7\uffff\13\37\1\114\16\37\4\uffff\1\36\1\uffff\13\37"+
            "\1\114\16\37\1\41",
            "\12\37\7\uffff\4\37\1\115\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\115\25\37\1\41",
            "\12\37\7\uffff\3\37\1\116\26\37\4\uffff\1\36\1\uffff\3\37"+
            "\1\116\26\37\1\41",
            "\12\37\7\uffff\23\37\1\117\6\37\4\uffff\1\36\1\uffff\23\37"+
            "\1\117\6\37\1\41",
            "\12\37\7\uffff\22\37\1\120\7\37\4\uffff\1\36\1\uffff\22\37"+
            "\1\120\7\37\1\41",
            "\12\37\7\uffff\4\37\1\121\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\121\25\37\1\41",
            "\12\37\7\uffff\4\37\1\122\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\122\25\37\1\41",
            "",
            "\0\124",
            "",
            "\1\70\1\uffff\12\107\45\uffff\1\67",
            "\12\37\7\uffff\22\37\1\125\7\37\4\uffff\1\36\1\uffff\22\37"+
            "\1\125\7\37\1\41",
            "\12\37\7\uffff\23\37\1\126\6\37\4\uffff\1\36\1\uffff\23\37"+
            "\1\126\6\37\1\41",
            "\12\37\7\uffff\24\37\1\127\5\37\4\uffff\1\36\1\uffff\24\37"+
            "\1\127\5\37\1\41",
            "\12\37\7\uffff\21\37\1\130\10\37\4\uffff\1\36\1\uffff\21\37"+
            "\1\130\10\37\1\41",
            "\12\37\7\uffff\10\37\1\131\21\37\4\uffff\1\36\1\uffff\10\37"+
            "\1\131\21\37\1\41",
            "\12\37\7\uffff\27\37\1\132\2\37\4\uffff\1\36\1\uffff\27\37"+
            "\1\132\2\37\1\41",
            "\12\37\7\uffff\10\37\1\133\21\37\4\uffff\1\36\1\uffff\10\37"+
            "\1\133\21\37\1\41",
            "\12\37\7\uffff\1\134\31\37\4\uffff\1\36\1\uffff\1\134\31\37"+
            "\1\41",
            "\12\37\7\uffff\4\37\1\135\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\135\25\37\1\41",
            "\12\37\7\uffff\22\37\1\136\7\37\4\uffff\1\36\1\uffff\22\37"+
            "\1\136\7\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "",
            "\12\37\7\uffff\10\37\1\140\21\37\4\uffff\1\36\1\uffff\10\37"+
            "\1\140\21\37\1\41",
            "\12\37\7\uffff\1\141\31\37\4\uffff\1\36\1\uffff\1\141\31\37"+
            "\1\41",
            "\12\37\7\uffff\23\37\1\142\6\37\4\uffff\1\36\1\uffff\23\37"+
            "\1\142\6\37\1\41",
            "\12\37\7\uffff\4\37\1\143\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\143\25\37\1\41",
            "\12\37\7\uffff\4\37\1\144\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\144\25\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\15\37\1\146\14\37\4\uffff\1\36\1\uffff\15\37"+
            "\1\146\14\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "\12\37\7\uffff\5\37\1\152\24\37\4\uffff\1\36\1\uffff\5\37"+
            "\1\152\24\37\1\41",
            "\12\37\7\uffff\15\37\1\153\14\37\4\uffff\1\36\1\uffff\15\37"+
            "\1\153\14\37\1\41",
            "\12\37\7\uffff\4\37\1\154\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\154\25\37\1\41",
            "\12\37\7\uffff\15\37\1\155\14\37\4\uffff\1\36\1\uffff\15\37"+
            "\1\155\14\37\1\41",
            "\12\37\7\uffff\22\37\1\156\7\37\4\uffff\1\36\1\uffff\22\37"+
            "\1\156\7\37\1\41",
            "",
            "\12\37\7\uffff\6\37\1\157\23\37\4\uffff\1\36\1\uffff\6\37"+
            "\1\157\23\37\1\41",
            "",
            "",
            "",
            "\12\37\7\uffff\10\37\1\160\21\37\4\uffff\1\36\1\uffff\10\37"+
            "\1\160\21\37\1\41",
            "\12\37\7\uffff\23\37\1\161\6\37\4\uffff\1\36\1\uffff\23\37"+
            "\1\161\6\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\2\37\1\163\27\37\4\uffff\1\36\1\uffff\2\37"+
            "\1\163\27\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\4\37\1\166\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\166\25\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "",
            "\12\37\7\uffff\4\37\1\170\25\37\4\uffff\1\36\1\uffff\4\37"+
            "\1\170\25\37\1\41",
            "",
            "",
            "\12\37\7\uffff\21\37\1\171\10\37\4\uffff\1\36\1\uffff\21\37"+
            "\1\171\10\37\1\41",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
            "\12\37\7\uffff\32\37\4\uffff\1\36\1\uffff\32\37\1\41",
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

    static class DFA30 extends DFA {

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
            return "1:1: Tokens : ( KEYWORD_31 | KEYWORD_30 | KEYWORD_29 | KEYWORD_26 | KEYWORD_27 | KEYWORD_28 | KEYWORD_22 | KEYWORD_23 | KEYWORD_24 | KEYWORD_25 | KEYWORD_21 | KEYWORD_18 | KEYWORD_19 | KEYWORD_20 | KEYWORD_13 | KEYWORD_14 | KEYWORD_15 | KEYWORD_16 | KEYWORD_17 | KEYWORD_1 | KEYWORD_2 | KEYWORD_3 | KEYWORD_4 | KEYWORD_5 | KEYWORD_6 | KEYWORD_7 | KEYWORD_8 | KEYWORD_9 | KEYWORD_10 | KEYWORD_11 | KEYWORD_12 | RULE_SL_COMMENT | RULE_REAL_LIT | RULE_INTEGER_LIT | RULE_IDANNEXTEXT | RULE_ANNEXTEXT | RULE_STRING | RULE_ID | RULE_WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_69 = input.LA(1);

                        s = -1;
                        if ( ((LA30_69>='\u0000' && LA30_69<='\uFFFF')) ) {s = 84;}

                        else s = 83;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}